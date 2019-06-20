package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort<T extends Comparable<? super T>>extends BaseSort{


    InsertSort(T[] items) {
        super(items);
    }

    public void sort(){
        long start=System.currentTimeMillis();
        for(int i=1;i<items.length;i++){
            int j=i-1;
            if (items[j].compareTo(items[i])<0) {
                continue;
            }
            T num= (T) items[i];
            while (j>=0&&items[j].compareTo(num)>0){
                items[j+1]=items[j];
                j--;
                movie++;
            }items[j+1]=num;
        }
        duration=System.currentTimeMillis()-start;
    }
}
