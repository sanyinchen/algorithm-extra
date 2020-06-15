package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.CompareUtils;

/**
 * Created by sanyinchen on 20-6-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-15
 */

class Quick<T> implements CompareStrategy<T> {
    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        sortHelper(a, 0, a.length - 1);
        return a;
    }

    /**
     * 切分
     *
     * @return
     */
    private int partition(CompareAble<T>[] a, int low, int high) {
        if (low > a.length || high > a.length) {
            return -1;
        }
        int i = low;
        int j = high + 1;
        while (true) {

            while (a[low].compareTo(a[++i]) >= 0) {
                if (i == high) {
                    break;
                }
            }
            while (a[low].compareTo(a[--j]) <= 0) {
                if (low == j) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            CompareUtils.exch(a, i, j);
        }
        CompareUtils.exch(a, low, j);
        return j;
    }

    private void sortHelper(CompareAble<T>[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int partIndex = partition(a, low, high);
        if (partIndex == -1) {
            return;
        }
        sortHelper(a, low, partIndex - 1);
        sortHelper(a, partIndex + 1, high);
    }
}
