package com.utkin.anton;

/*A certain computer has ten registers and 1000 words of RAM. Each register or RAM location holds 3-digit
integer between 0 - 999. Instructions are encoded as three-digit integers and stored in RAM.
The encodings are as follows:

100 - means halt
2dn - means set register d to n (between 0 and 9)
3dn - means add n to register d
4dn - means multiply register d by n
5ds - means set register d to the value of register s
6ds - means add the value of register s to register d
7ds - means multiply register d by the value of register s
8da - means set register d to the value in RAM whose address is in register a
9sa - means set the value in RAM whose address is in register a to that of register s
0ds - means goto the location in register d unless register s contains 0

All registers initially contain 0. The initial content of RAM is read from standard input. The first instruction
to be executed is at RAM address 0. All results are reduced by modulo 1000.

Class below provides interpreter for described operation codes.*/

public class Interpreter {
    private static final short MIN_VALUE = 0;
    private static final short MAX_VALUE = 999;
    private static final short MEMORY_SIZE = 1000; //1000 words, each word has 3 decimal digits
    private static final short RADIX = 10;

    //OPCODES
    private static final short GO = 0;
    private static final short HALT = 1;
    private static final short SETRV = 2;
    private static final short ADDRV = 3;
    private static final short MULRV = 4;
    private static final short SETRR = 5;
    private static final short ADDRR = 6;
    private static final short MULRR = 7;
    private static final short SETRM = 8;
    private static final short SETMR = 9;

    private class Register{
        private short mValue;

        public void setValue(short value){
            if(value < MIN_VALUE || value > MAX_VALUE) throw new RuntimeException("Invalid value");
            mValue = value;
        }

        public short getValue(){
            return mValue;
        }

        public void add(short value){
            if(value < MIN_VALUE || value > MAX_VALUE) throw new RuntimeException("Invalid value");
            mValue = (short)((mValue + value) % (MAX_VALUE + 1));
        }

        public void multiply(short value){
            if(value < MIN_VALUE || value > MAX_VALUE) throw new RuntimeException("Invalid value");
            mValue = (short)((mValue * value) % (MAX_VALUE + 1));
        }
    }

    private class RAM{
        private short mMemory[] = new short[MEMORY_SIZE];

        public void setValue(short address, short value){
            if(address < MIN_VALUE || address > MAX_VALUE) throw new RuntimeException("Invalid address");
            if(value < MIN_VALUE || value > MAX_VALUE) throw new RuntimeException("Invalid value");
            mMemory[address] = value;
        }

        public short getValue(short address){
            if(address < MIN_VALUE || address > MAX_VALUE) throw new RuntimeException("Invalid address");
            return mMemory[address];
        }
    }

    private interface Processor{
        enum Result{SUCCESS, STOP, JUMP};
        Result process(short firstDigit, short secondDigit);
    }

    private class HaltProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            if(firstDigit != 0 || secondDigit != 0) throw new RuntimeException("Invalid opcode");
            return Result.STOP;
        }
    }

    private class SetrvProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].setValue(secondDigit);
            return Result.SUCCESS;
        }
    }

    private class AddrvProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].add(secondDigit);
            return Result.SUCCESS;
        }
    }

    private class MulrvProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].multiply(secondDigit);
            return Result.SUCCESS;
        }
    }

    private class SetrrProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].setValue(mRegisters[secondDigit].getValue());
            return Result.SUCCESS;
        }
    }

    private class AddrrProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].add(mRegisters[secondDigit].getValue());
            return Result.SUCCESS;
        }
    }

    private class MulrrProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].multiply(mRegisters[secondDigit].getValue());
            return Result.SUCCESS;
        }
    }

    private class SetrmProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRegisters[firstDigit].setValue(mRam.getValue(mRegisters[secondDigit].getValue()));
            return Result.SUCCESS;
        }
    }

    private class SetmrProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            mRam.setValue(secondDigit, mRegisters[firstDigit].getValue());
            return Result.SUCCESS;
        }
    }

    private class GoProcessor implements Processor{
        @Override
        public Result process(short firstDigit, short secondDigit){
            if(mRegisters[secondDigit].getValue() == 0) {
                return Result.SUCCESS;
            }else {
                return Result.JUMP;
            }
        }
    }

    private Processor[] mHandlers = new Processor[10];
    private RAM mRam = new RAM();
    private Register[] mRegisters = new Register[10];
    private int mCounter = 0;

    {
        mHandlers[0] = new GoProcessor();
        mHandlers[1] = new HaltProcessor();
        mHandlers[2] = new SetrvProcessor();
        mHandlers[3] = new AddrvProcessor();
        mHandlers[4] = new MulrvProcessor();
        mHandlers[5] = new SetrrProcessor();
        mHandlers[6] = new AddrrProcessor();
        mHandlers[7] = new MulrrProcessor();
        mHandlers[8] = new SetrmProcessor();
        mHandlers[9] = new SetmrProcessor();

        for(int i = 0; i < 10; ++i){
            mRegisters[i] = new Register();
        }
    }

    public int execute(short[] program){
        mCounter = 0;
        if(program.length > MEMORY_SIZE) throw new RuntimeException("Invalid program size");
        for(int i = 0; i < program.length; ++i){
            if(program[i] > MAX_VALUE || program[i] < MIN_VALUE) throw new RuntimeException("Invalid opcode");
        }

        for(short i = 0; i < program.length; ++i) {
            mRam.setValue(i, program[i]);
        }
        jump((short)0);
        return mCounter;
    }

    private void jump(short entryPoint) {
        short digit0;
        short digit1;
        short digit2;

        if(entryPoint > MAX_VALUE || entryPoint < MIN_VALUE) throw new RuntimeException("Invalid address");

        for(short address = entryPoint; address < MEMORY_SIZE; ++address){
            short opCode = mRam.getValue(address);
            digit2 = (short)(opCode % RADIX);
            digit1 = (short)((opCode / RADIX) % RADIX);
            digit0 = (short)((opCode / (RADIX * RADIX)) % RADIX);
            Processor.Result result = mHandlers[digit0].process(digit1, digit2);
            mCounter++;
            if(result == Processor.Result.STOP) break;
            if(result == Processor.Result.JUMP) {
                jump(mRegisters[digit1].getValue());
                return;
            }
        }
    }
}