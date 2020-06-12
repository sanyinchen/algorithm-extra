package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.CompareUtils;

/**
 * Created by sanyinchen on 20-6-12.
 * 归并排序，自顶向下
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-12
 */

class Merge<T> implements CompareStrategy<T> {
    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        CompareAble<T>[] cache = new CompareAble[a.length];
        sortHelper(a, 0, a.length - 1, cache);

        return a;
    }

    private void sortHelper(CompareAble<T>[] a, int low, int high, CompareAble<T>[] cache) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >>> 1;
        sortHelper(a, low, mid, cache);
        sortHelper(a, mid + 1, high, cache);
        CompareUtils.merge(a, low, high, cache);
    }
}
