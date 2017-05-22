package com.utkin.anton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class GraphUtils {
    enum Color{White, Gray, Black};

    public static class VertexData {
        Integer index;
        Color color;
        VertexData parent;
    };

    static private ArrayList<LinkedList<Integer>> mGraph = new ArrayList<LinkedList<Integer>>();
    static private ArrayList<VertexData> mGraphData = new ArrayList<VertexData>();

    private static void clearGraphData(){
        mGraphData.clear();
        for(int i = 0; i < mGraph.size(); ++i) {
            mGraphData.add(new VertexData());
            mGraphData.get(i).color =  Color.White;
            mGraphData.get(i).parent =  null;
            mGraphData.get(i).index =  i;
        }
    }

    public static void setGraph(ArrayList<LinkedList<Integer>> graph) {
        mGraph = graph;
        clearGraphData();
    }

    public static ArrayList<LinkedList<Integer>> getGraph()
    {
        return mGraph;
    }

    public static ArrayList<VertexData> getGraphData()
    {
        return mGraphData;
    }

    public static void BFS (int vertex) {
        clearGraphData();
        java.util.Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(vertex);
        mGraphData.get(vertex).color = Color.Gray;

        while(!queue.isEmpty()) {
            Integer node = queue.poll();

            LinkedList<Integer> list = mGraph.get(node);
            ListIterator<Integer> iter = list.listIterator();
            while(iter.hasNext()) {
                Integer adjNode = iter.next();
                if(mGraphData.get(adjNode).color == Color.White) {
                    mGraphData.get(adjNode).color = Color.Gray;
                    mGraphData.get(adjNode).parent = mGraphData.get(node);
                    queue.offer(adjNode);
                }
            }

            mGraphData.get(node).color = Color.Black;
            //System.out.println(node);
        }
    }

    public static void DFS() {
        clearGraphData();
        for(int i = 0; i < mGraphData.size(); ++i) {
            if(mGraphData.get(i).color == Color.White) {
                DFSVisit(i);
            }
        }
    }

    private static void DFSVisit (int vertex) {
        mGraphData.get(vertex).color = Color.Gray;
        //System.out.println(vertex);
        LinkedList<Integer> list = mGraph.get(vertex);
        ListIterator<Integer> iter = list.listIterator();
        while(iter.hasNext()) {
            Integer adjNode = iter.next();
            if(mGraphData.get(adjNode).color == Color.White) {
                mGraphData.get(adjNode).parent = mGraphData.get(vertex);
                DFSVisit(adjNode);
            }
        }
        mGraphData.get(vertex).color = Color.Black;
    }



    public static boolean hasRoute (int src, int dest) {
        BFS(src);
        VertexData data = mGraphData.get(dest);
        while(data.parent != null){
            if (data.parent.index == src) return true;
            data = data.parent;
        }
        return false;
    }
}
