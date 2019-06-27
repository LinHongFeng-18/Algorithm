package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class BubbleSort <T extends Comparable<? super T>>extends BaseSort{
    BubbleSort(T[] items) {
        super(items);
    }

    @Override
    void sort() {
        for (int i=0;i<items.length;i++){
            for(int j=items.length-1;j>=i;j--){
                if (bigger(items[j],items[j-1])){
                }else{
                    swap(j,j-1);
                }
            }
        }
    }
}
