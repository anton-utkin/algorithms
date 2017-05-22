package com.utkin.anton;


import java.util.*;

//Dijkstra algorithm implementation

public class WeightedGraphUtils {

    public static class EdgeData{
        int vertexIndex;
        int weight;

        public EdgeData(int vertexIndex, int weight) {
            this.vertexIndex = vertexIndex;
            this.weight = weight;
        }
    }

    public static class VertexData{
        int index;
        int distance;
        VertexData parent;
    }

    static private ArrayList<LinkedList<EdgeData>> mGraph = new ArrayList<LinkedList<EdgeData>>();
    static private ArrayList<VertexData> mGraphData = new ArrayList<VertexData>();
    static private ArrayList<VertexData> heap = new ArrayList<VertexData>();

    private static void clearGraphData(){
        heap.clear();
        mGraphData.clear();
        for(int i = 0; i < mGraph.size(); ++i) {
            mGraphData.add(new VertexData());
            mGraphData.get(i).parent =  null;
            mGraphData.get(i).distance =  0;
            mGraphData.get(i).index =  i;
        }
    }

    public static void setGraph(ArrayList<LinkedList<EdgeData>> graph) {
        mGraph = graph;
        clearGraphData();
    }
    public static ArrayList<LinkedList<EdgeData>> getGraph()
    {
        return mGraph;
    }
    public static ArrayList<VertexData> getGraphData()
    {
        return mGraphData;
    }

    private static VertexData extractMin(){
        int minDistancePos = 0;
        for(int i = 0; i < heap.size(); ++i){
            if(heap.get(i).distance < heap.get(minDistancePos).distance){
                minDistancePos = i;
            }
        }
        VertexData data = heap.get(minDistancePos);
        heap.remove(minDistancePos);
        return data;
    }

    public static void dijkstra(int vertex){
        clearGraphData();
        for(int i = 0; i < mGraph.size(); ++i){
            mGraphData.get(i).distance =  Integer.MAX_VALUE;
            heap.add(mGraphData.get(i));
        }
        mGraphData.get(vertex).distance = 0;

        while(!heap.isEmpty()){
            VertexData data = extractMin();
            LinkedList<EdgeData> adjList = mGraph.get(data.index);
            ListIterator<EdgeData> iter = adjList.listIterator();
            while(iter.hasNext()){
                EdgeData edgeData  = iter.next();
                if(data.distance + edgeData.weight < mGraphData.get(edgeData.vertexIndex).distance){
                    mGraphData.get(edgeData.vertexIndex).distance = data.distance + edgeData.weight;
                    mGraphData.get(edgeData.vertexIndex).parent = data;
                }
            }
        }
    }
}
