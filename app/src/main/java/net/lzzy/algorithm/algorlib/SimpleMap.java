package net.lzzy.algorithm.algorlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class SimpleMap {
    int vertexcount;
    List<Edge> edges=new ArrayList<>();
    List<Integer>vidited;

    public SimpleMap(int v){
        vertexcount=v;
    }
    public void addEdge(int source,int target,double distance){
        edges.add(new Edge(source,target,distance));
    }
    public void addTwoWayEdge(int v1,int v2,double d1){
        addEdge(v1,v2,d1);
        addEdge(v2,v1,d1);
    }
    List<Edge>getConnectedEdge(int source){
        List<Edge>result=new ArrayList<>();
        for (Edge e:edges){
            if (e.getSource()==source){
                result.add(e);
            }
        }
        return result;
    }

    private void iterateDepth(int v){
        if (!vidited.contains(v)){
            vidited.add(v);
        }
        if (vidited.size()==vertexcount){
            return;
        }
        List<Edge>vEdges=getConnectedEdge(v);
        for (Edge edge:vEdges){
            if (vidited.contains(edge.getTarget())){
                continue;
            }
            iterateDepth(edge.getTarget());
        }
    }
    public String iterateDEpthFirst(){
        vidited=new ArrayList<>();
        iterateDepth(0);
        StringBuilder result=new StringBuilder();
        for (int v:vidited){
            result.append(v).append(",");
        }
        return result.toString();
    }
    public String iterateRangeFirst(){
        return "012354";
    }

}




class Edge {
    private int target;
    private int source;
    private double distance;

    Edge(int source, int target, double distance) {
        this.distance = distance;
        this.source = source;
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public int getSource() {
        return source;
    }

    public double getDistance() {
        return distance;
    }
}