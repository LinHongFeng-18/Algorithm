package net.lzzy.algorithm.algorlib;

import android.util.Log;
import android.widget.Toast;

import net.lzzy.algorithm.MainActivity;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public class SortFactory {
    public static <T extends Comparable<? super T>> BaseSort<T> getInstance(int key,T[] item){
        BaseSort<T> sort;
        switch (key) {
            case 0:
                sort = new DirectSort<>(item);

                break;
            case 1:
                sort = new InsertSort<>(item);


                break;
            case 2:
                sort = new ShellSort<>(item);

                break;
            default:
                return null;
        }
        return sort;
        }



        public static String[] getSortName(){
        return new String[]{"插入排序","选择排序","希尔排序"};
    }

    }

