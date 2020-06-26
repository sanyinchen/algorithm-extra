package sort.common;

/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

public class CompareUtils {


    /**
     * exchange
     *
     * @param a
     * @param i
     * @param j
     */
    public static <T> void exch(CompareAble<T>[] a, int i, int j) {
        if (a.length <= i || a.length <= j) {
            return;
        }
        CompareAble<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T> void show(CompareAble<T>[] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i].toString() + " ");
        }
        System.out.println();
    }

    public static <T> boolean isSorted(CompareAble<T>[] a) {
        if (a == null) {
            return true;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> CompareAble<T>[] sort(CompareAble<T>[] a, CompareStrategy<T> strategy) {
        CompareAble<T>[] sorted = strategy.sort(a);
        if (!isSorted(sorted)) {
            show(sorted);
            throw new RuntimeException("not sorted!!");
        }
        return sorted;
    }

    public static <T> void merge(CompareAble<T>[] a, int start, int end, CompareAble<T>[] cache) {
        merge(a, start, (end + start) >>> 1, end, cache);
    }

    public static <T> void merge(CompareAble<T>[] a, int start, int mid, int end, CompareAble<T>[] cache) {
        if (cache == null || start >= cache.length || end >= cache.length) {
            return;
        }
        for (int i = start; i <= end; i++) {
            cache[i] = a[i];
        }
        for (int k = start, i = start, j = mid + 1; k <= end; k++) {
            // 左侧低位耗尽
            if (i > mid) {
                a[k] = cache[j++];
                continue;
            }
            // 右侧高位耗尽
            if (j > end) {
                a[k] = cache[i++];
                continue;
            }
            if (cache[j].compareTo(cache[i]) > 0) {
                a[k] = cache[i++];
                continue;
            }
            a[k] = cache[j++];

        }
    }
}
