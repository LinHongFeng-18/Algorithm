package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class BinarySearch<T extends Comparable<? super T>> extends BaseSearch {
    BinarySearch(T[] items) {
        super(items);
    }

    @Override
    public int search(Comparable key) {
        long start = System.currentTimeMillis();
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comp = compare(key, items[mid]);
            if (comp == 0) {
                duration = System.currentTimeMillis() - start;
                return mid;
            } else if (comp > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        duration = System.currentTimeMillis() - start;
        return -1;


    }


}
