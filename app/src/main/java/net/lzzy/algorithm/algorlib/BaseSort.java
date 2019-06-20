package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class BaseSort <T extends Comparable<? super T>>{
     T[] items;
     long duration;//时间间隔
    private int compareCount;//比较次数
     int movie;//移动次数
    private int swapMovie;//交换次数

     BaseSort(T[] items) {
        this.items=items;
        compareCount=0;
        swapMovie=0;
        movie=0;
        duration=0;
    }

    boolean bigger (T a, T b){
        compareCount++;
        return a.compareTo(b)>0;
    }

    public void swap(int a ,int b){
        swapMovie++;
        T num=items[a];
        items[a]=items[b];
        items[b]=num;

    }


//    public void sort() {
//        long a=System.currentTimeMillis();
//        //todo:直接选择排序的具体实现
//        for(int i = 0; i<items.length-1; i++){
//            int num=i;
//            for (int j=i+1;j<items.length;j++){
//                if (bigger(items[num] , items[j])) {
//                    num=j;
//                }
//            }
//            swap(num,i);
//        }
//        duration=System.currentTimeMillis()-a;
//    }

    public String getResult(){
         String display="";
         for (T i:items){
             display=display.concat(i+",");
         }
         return display.substring(0,display.length()-1);
    }




    abstract void sort();

    public T[] Return(){
        return items;
    }

    public int getCompareCount() {
        return compareCount;
    }


    public long getDuration() {
        long startTime=System.currentTimeMillis();
        sort();
        duration=System.currentTimeMillis()-startTime;
        return duration;
    }

    public int getMovie() {
        return movie;
    }

    public int getSwapMovie() {
        return swapMovie;
    }

}
