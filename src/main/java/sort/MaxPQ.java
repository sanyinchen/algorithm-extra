package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.CompareUtils;

import java.util.Arrays;

/**
 * heap sort
 *
 * @param <T>
 */
public class MaxPQ<T> implements CompareStrategy<T> {
    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        CompareAble<T>[] temp = new CompareAble[a.length + 1];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            temp[++index] = a[i];
            swim(temp, index);
        }
        int n = temp.length - 1;
        while (n > 1) {
            CompareUtils.exch(temp, 1, n--);
            sink(temp, 1, n);
        }

        return Arrays.copyOfRange(temp, 1, temp.length);
    }


    private void swim(CompareAble<T>[] a, int k) {
        while (k > 1 && a[k / 2].compareTo(a[k]) < 0) {
            CompareUtils.exch(a, k, k / 2);
            k /= 2;
        }
    }


    private void sink(CompareAble<T>[] a, int k, int len) {
        while (2 * k <= len) {
            int left = 2 * k;
            int right = left + 1;
            int maxIndex = left;
            if (left < len && a[left].compareTo(a[right]) < 0) {
                maxIndex = right;
            }
            if (a[k].compareTo(a[maxIndex]) > 0) {
                break;
            }
            CompareUtils.exch(a, k, maxIndex);
            k = maxIndex;
        }
    }

}
