package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public abstract class BaseSearch<T extends Comparable<? super T>> {

    T[] items;
    long duration;//时间间隔
    private int compareCount;//比较次数
    int movie;//移动次数
    private int swapMovie;//交换次数

    BaseSearch(T[] items) {
        this.items = items;
        compareCount = 0;
        swapMovie = 0;
        movie = 0;
        duration = 0;
    }

    BaseSearch() {

    }


    public abstract int search(T key);

    boolean bigger(T a, T b) {
        compareCount++;
        return a.compareTo(b) > 0;
    }


    boolean equal(T a, T b) {
        compareCount++;
        return a.compareTo(b) == 0;
    }

    int compare(T a, T b) {
        compareCount++;
        return a.compareTo(b);
    }


    public T[] Return() {
        return items;
    }

    public int getCompareCount() {
        return compareCount;
    }


    public long getDuration() {

        return duration;
    }

    public int getMovie() {
        return movie;
    }

    public int getSwapMovie() {
        return swapMovie;
    }
}
