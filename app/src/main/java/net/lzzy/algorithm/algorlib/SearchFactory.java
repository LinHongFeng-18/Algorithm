package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class SearchFactory {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInSearch(int key, T[] item) {
        BaseSearch<T> search = null;
        switch (key) {
            case 0:
                search = new DirectSearch<>(item);
                break;
            case 1:
                search = new BinarySearch<>(item);
                break;
            case 2:
                search = new BinaryThree<>(item);
                break;
            case 3:
                //search=new BubbleSort<>(item);
                break;
            default:
                return null;
        }
        return search;
    }


    public static String[] getSearchName() {
        return new String[]{"顺序查找", "二分查找", "二叉排序树"};
    }

}

