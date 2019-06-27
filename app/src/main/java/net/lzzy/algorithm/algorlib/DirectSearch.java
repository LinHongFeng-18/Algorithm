package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DirectSearch<T extends Comparable<? super T>> extends BaseSearch {

    public DirectSearch(T[] items) {
        super(items);
    }


    @Override
    public int search(Comparable key) {
        int a = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < items.length; i++) {
            if (compare(key, items[i]) == 0) {
                return a;
            }
            a++;
        }


        duration = System.currentTimeMillis() - startTime;
        return -1;
    }
}
