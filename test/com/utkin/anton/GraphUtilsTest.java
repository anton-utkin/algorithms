package com.utkin.anton;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class GraphUtilsTest {

    //   * 0
    @Test
    public void testA(){
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
        graph.add(new LinkedList<Integer>());
        GraphUtils.setGraph(graph);

        GraphUtils.BFS(0);
        testACheck(GraphUtils.getGraphData());

        GraphUtils.DFS();
        testACheck(GraphUtils.getGraphData());

    }

    private void testACheck(ArrayList<GraphUtils.VertexData> data){
        assertEquals(data.size(), 1);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));
    }

    // 0 * ----- * 1
    @Test
    public void testB(){
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
        while(graph.size() < 2) graph.add(null);
        LinkedList<Integer> adjV0 = new LinkedList<Integer>();
        adjV0.add(1);
        graph.set(0, adjV0);
        LinkedList<Integer> adjV1 = new LinkedList<Integer>();
        adjV1.add(0);
        graph.set(1, adjV1);
        GraphUtils.setGraph(graph);

        GraphUtils.BFS(0);
        testBCheck(GraphUtils.getGraphData());
        GraphUtils.DFS();
        testBCheck(GraphUtils.getGraphData());

        assertEquals(GraphUtils.hasRoute(0, 1), true);
        assertEquals(GraphUtils.hasRoute(1, 0), true);
    }

    private void testBCheck(ArrayList<GraphUtils.VertexData> data){
        assertEquals(data.size(), 2);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));

        assertEquals(data.get(1).color, GraphUtils.Color.Black);
        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, new Integer(1));
    }

    // 0 * ----- * 1 ----- *2
    @Test
    public void testC() {
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
        while(graph.size() < 3) graph.add(null);
        LinkedList<Integer> adjV0 = new LinkedList<Integer>();
        adjV0.add(1);
        graph.set(0, adjV0);
        LinkedList<Integer> adjV1 = new LinkedList<Integer>();
        adjV1.add(0);
        adjV1.add(2);
        graph.set(1, adjV1);
        LinkedList<Integer> adjV2 = new LinkedList<Integer>();
        adjV2.add(1);
        graph.set(2, adjV2);
        GraphUtils.setGraph(graph);

        GraphUtils.BFS(0);
        testCCheck(GraphUtils.getGraphData());

        GraphUtils.DFS();
        testCCheck(GraphUtils.getGraphData());

        assertEquals(GraphUtils.hasRoute(0, 2), true);
        assertEquals(GraphUtils.hasRoute(2, 0), true);
    }

    private void testCCheck(ArrayList<GraphUtils.VertexData> data){
        assertEquals(data.size(), 3);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));

        assertEquals(data.get(1).color, GraphUtils.Color.Black);
        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, new Integer(1));

        assertEquals(data.get(2).color, GraphUtils.Color.Black);
        assertEquals(data.get(2).parent, data.get(1));
        assertEquals(data.get(2).index, new Integer(2));
    }

    // *1 -----\
    // |        \
    // |         \
    // 0 * ----- * 2 ----- *3
    @Test
    public void testD() {
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
        while(graph.size() < 4) graph.add(null);
        LinkedList<Integer> adjV0 = new LinkedList<Integer>();
        adjV0.add(1);
        adjV0.add(2);
        graph.set(0, adjV0);
        LinkedList<Integer> adjV1 = new LinkedList<Integer>();
        adjV1.add(0);
        adjV1.add(2);
        graph.set(1, adjV1);
        LinkedList<Integer> adjV2 = new LinkedList<Integer>();
        adjV2.add(0);
        adjV2.add(1);
        adjV2.add(3);
        graph.set(2, adjV2);

        LinkedList<Integer> adjV3 = new LinkedList<Integer>();
        adjV3.add(2);
        graph.set(3, adjV3);
        GraphUtils.setGraph(graph);
        GraphUtils.BFS(0);

        ArrayList<GraphUtils.VertexData> data = GraphUtils.getGraphData();

        assertEquals(data.size(), 4);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));

        assertEquals(data.get(1).color, GraphUtils.Color.Black);
        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, new Integer(1));

        assertEquals(data.get(2).color, GraphUtils.Color.Black);
        assertEquals(data.get(2).parent, data.get(0));
        assertEquals(data.get(2).index, new Integer(2));

        assertEquals(data.get(3).color, GraphUtils.Color.Black);
        assertEquals(data.get(3).parent, data.get(2));
        assertEquals(data.get(3).index, new Integer(3));

        GraphUtils.DFS();
        data = GraphUtils.getGraphData();

        assertEquals(data.size(), 4);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));

        assertEquals(data.get(1).color, GraphUtils.Color.Black);
        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, new Integer(1));

        assertEquals(data.get(2).color, GraphUtils.Color.Black);
        assertEquals(data.get(2).parent, data.get(1));
        assertEquals(data.get(2).index, new Integer(2));

        assertEquals(data.get(3).color, GraphUtils.Color.Black);
        assertEquals(data.get(3).parent, data.get(2));
        assertEquals(data.get(3).index, new Integer(3));

        assertEquals(GraphUtils.hasRoute(0, 3), true);
        assertEquals(GraphUtils.hasRoute(3, 0), true);
    }

    //
    //    *1---*0    /*4------*6
    //     |    |  /   |    /  |
    //     |    |/     | /     |
    //    *2   *3-----*5------*7
    //
    @Test
    public void testE(){
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
        while(graph.size() < 8) graph.add(null);
        LinkedList<Integer> adjV0 = new LinkedList<Integer>();
        adjV0.add(1);
        adjV0.add(3);
        graph.set(0, adjV0);
        LinkedList<Integer> adjV1 = new LinkedList<Integer>();
        adjV1.add(0);
        adjV1.add(2);
        graph.set(1, adjV1);
        LinkedList<Integer> adjV2 = new LinkedList<Integer>();
        adjV2.add(1);
        graph.set(2, adjV2);
        LinkedList<Integer> adjV3 = new LinkedList<Integer>();
        adjV3.add(0);
        adjV3.add(4);
        adjV3.add(5);
        graph.set(3, adjV3);
        LinkedList<Integer> adjV4 = new LinkedList<Integer>();
        adjV4.add(3);
        adjV4.add(5);
        adjV4.add(6);
        graph.set(4, adjV4);
        LinkedList<Integer> adjV5 = new LinkedList<Integer>();
        adjV5.add(3);
        adjV5.add(4);
        adjV5.add(6);
        adjV5.add(7);
        graph.set(5, adjV5);
        LinkedList<Integer> adjV6 = new LinkedList<Integer>();
        adjV6.add(4);
        adjV6.add(5);
        adjV6.add(7);
        graph.set(6, adjV6);
        LinkedList<Integer> adjV7 = new LinkedList<Integer>();
        adjV7.add(5);
        adjV7.add(6);
        graph.set(7, adjV7);
        GraphUtils.setGraph(graph);

        GraphUtils.BFS(0);
        ArrayList<GraphUtils.VertexData> data = GraphUtils.getGraphData();

        assertEquals(data.size(), 8);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));

        assertEquals(data.get(1).color, GraphUtils.Color.Black);
        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, new Integer(1));

        assertEquals(data.get(2).color, GraphUtils.Color.Black);
        assertEquals(data.get(2).parent, data.get(1));
        assertEquals(data.get(2).index, new Integer(2));

        assertEquals(data.get(3).color, GraphUtils.Color.Black);
        assertEquals(data.get(3).parent, data.get(0));
        assertEquals(data.get(3).index, new Integer(3));

        assertEquals(data.get(4).color, GraphUtils.Color.Black);
        assertEquals(data.get(4).parent, data.get(3));
        assertEquals(data.get(4).index, new Integer(4));

        assertEquals(data.get(5).color, GraphUtils.Color.Black);
        assertEquals(data.get(5).parent, data.get(3));
        assertEquals(data.get(5).index, new Integer(5));

        assertEquals(data.get(6).color, GraphUtils.Color.Black);
        assertEquals(data.get(6).parent, data.get(4));
        assertEquals(data.get(6).index, new Integer(6));

        assertEquals(data.get(7).color, GraphUtils.Color.Black);
        assertEquals(data.get(7).parent, data.get(5));
        assertEquals(data.get(7).index, new Integer(7));

        GraphUtils.DFS();
        data = GraphUtils.getGraphData();

        assertEquals(data.size(), 8);
        assertEquals(data.get(0).color, GraphUtils.Color.Black);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).index, new Integer(0));

        assertEquals(data.get(1).color, GraphUtils.Color.Black);
        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, new Integer(1));

        assertEquals(data.get(2).color, GraphUtils.Color.Black);
        assertEquals(data.get(2).parent, data.get(1));
        assertEquals(data.get(2).index, new Integer(2));

        assertEquals(data.get(3).color, GraphUtils.Color.Black);
        assertEquals(data.get(3).parent, data.get(0));
        assertEquals(data.get(3).index, new Integer(3));

        assertEquals(data.get(4).color, GraphUtils.Color.Black);
        assertEquals(data.get(4).parent, data.get(3));
        assertEquals(data.get(4).index, new Integer(4));

        assertEquals(data.get(5).color, GraphUtils.Color.Black);
        assertEquals(data.get(5).parent, data.get(4));
        assertEquals(data.get(5).index, new Integer(5));

        assertEquals(data.get(6).color, GraphUtils.Color.Black);
        assertEquals(data.get(6).parent, data.get(5));
        assertEquals(data.get(6).index, new Integer(6));

        assertEquals(data.get(7).color, GraphUtils.Color.Black);
        assertEquals(data.get(7).parent, data.get(6));
        assertEquals(data.get(7).index, new Integer(7));

        assertEquals(GraphUtils.hasRoute(2, 7), true);
        assertEquals(GraphUtils.hasRoute(7, 2), true);
    }

    // *1 ----\
    // |       \  250
    // | 250    \
    // |         \
    // 0 * ----- * 2 ----- *3
    //     1000        250
    @Test
    public void testF() {
        ArrayList<LinkedList<WeightedGraphUtils.EdgeData>> graph = new ArrayList<LinkedList<WeightedGraphUtils.EdgeData>>();
        while(graph.size() < 4) graph.add(null);
        LinkedList<WeightedGraphUtils.EdgeData> adjV0 = new LinkedList<WeightedGraphUtils.EdgeData>();
        adjV0.add(new WeightedGraphUtils.EdgeData(1, 250));
        adjV0.add(new WeightedGraphUtils.EdgeData(2, 1000));
        graph.set(0, adjV0);
        LinkedList<WeightedGraphUtils.EdgeData> adjV1 = new LinkedList<WeightedGraphUtils.EdgeData>();
        adjV1.add(new WeightedGraphUtils.EdgeData(0, 250));
        adjV1.add(new WeightedGraphUtils.EdgeData(2, 250));
        graph.set(1, adjV1);
        LinkedList<WeightedGraphUtils.EdgeData> adjV2 = new LinkedList<WeightedGraphUtils.EdgeData>();
        adjV2.add(new WeightedGraphUtils.EdgeData(1, 250));
        adjV2.add(new WeightedGraphUtils.EdgeData(0, 1000));
        adjV2.add(new WeightedGraphUtils.EdgeData(3, 250));
        graph.set(2, adjV2);

        LinkedList<WeightedGraphUtils.EdgeData> adjV3 = new LinkedList<WeightedGraphUtils.EdgeData>();
        adjV3.add(new WeightedGraphUtils.EdgeData(2, 250));
        graph.set(3, adjV3);
        WeightedGraphUtils.setGraph(graph);
        WeightedGraphUtils.dijkstra(0);

        ArrayList<WeightedGraphUtils.VertexData> data = WeightedGraphUtils.getGraphData();

        assertEquals(data.size(), 4);
        assertEquals(data.get(0).parent, null);
        assertEquals(data.get(0).distance, 0);
        assertEquals(data.get(0).index, 0);

        assertEquals(data.get(1).parent, data.get(0));
        assertEquals(data.get(1).index, 1);
        assertEquals(data.get(1).distance, 250);

        assertEquals(data.get(2).parent, data.get(1));
        assertEquals(data.get(2).index, 2);
        assertEquals(data.get(2).distance, 500);

        assertEquals(data.get(3).parent, data.get(2));
        assertEquals(data.get(3).index, 3);
        assertEquals(data.get(3).distance, 750);
    }
}
