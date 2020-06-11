package sort.common;

/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

public class Util {


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
            throw new RuntimeException("not sorted!!");
        }
        return sorted;
    }
}
