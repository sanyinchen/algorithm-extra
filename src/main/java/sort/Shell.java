package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.CompareUtils;

/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

class Shell<T> implements CompareStrategy<T> {
    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int step = 1;
        while (step < a.length / 3) {
            step = 3 * step + 1;
        }
        while (step >= 1) {
            for (int j = step; j < a.length; j++) {
                for (int i = j; i >= step && a[i].compareTo(a[Math.max(i - step, 0)]) < 0; i -= step) {
                    CompareUtils.exch(a, i, Math.max(i - step, 0));
                }
            }
            step /= 3;
        }
        return a;
    }
}
