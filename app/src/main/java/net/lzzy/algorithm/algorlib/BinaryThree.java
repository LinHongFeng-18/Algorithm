package net.lzzy.algorithm.algorlib;

import android.util.Pair;

import org.w3c.dom.Node;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class BinaryThree<T extends Comparable<? super T>> extends BaseSearch {
    private Pair<Integer, T> root;
    private BinaryThree left, right;

    BinaryThree(T[] items) {
        super(items);
        root = new Pair<>(0, items[0]);
        for (int i = 1; i < items.length; i++) {
            annNoda(new Pair<>(i, items[i]));
        }
    }


    private BinaryThree(Pair<Integer, T> node) {
        root = node;
    }

    private void annNoda(Pair<Integer, T> node) {
        int comp = compare(node.second, root.second);
        if (comp > 0) {
            if (right == null) {
                right = new BinaryThree<>(node);
            } else {
                right.annNoda(node);
            }
        }
        if (comp < 0) {
            if (left == null) {
                left = new BinaryThree<>(node);
            } else {
                left.annNoda(node);
            }
        }
    }

    long start = -1;

    @Override
    public int search(Comparable key) {
        if (start < 0) {
            start = System.currentTimeMillis();
        }
        int comp = compare(key, root.second);
        if (comp == 0) {
            duration = System.currentTimeMillis() - start;
            return root.first;
        } else if (comp > 0) {
            if (right == null) {
                duration = System.currentTimeMillis() - start;
                return -1;
            } else {
                return right.search(key);
            }
        } else {
            if (left == null) {
                duration = System.currentTimeMillis() - start;
                return -1;
            } else {
                return left.search(key);
            }
        }
    }
}
