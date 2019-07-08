package net.lzzy.algorithm.algorlib;

import android.util.SparseArray;

import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap extends  SimpleMap{
    private SparseArray<String> vertexes;
    private  double minDistance;
    private int start,target;

    public BusMap(int v) {
        super(v);
        vertexes=new SparseArray<>();
        for (int i=0;i<v;i++){
            vertexes.append(i,String.valueOf(i));
        }
    }

    public int getStart() {
        return start;
    }

    public int getTarget() {
        return target;
    }

    public void rename(int i, String name){vertexes.setValueAt(i, name);}

    private void tryWay(int curVertex,double distance) {
        if (minDistance > 0 && distance > minDistance) {
            return;
        }
        if (curVertex == target) {
            if (minDistance == 0 || minDistance > distance) {
                minDistance = distance;
            }
            return;
        }
//        List<Edge> vEdges=getConnectedEdges(curVertex);
//        for (Edge edge:vEdges){
//            if (visited.contains(edge.getTarget())){
//                continue;
//            }

        }
    }


