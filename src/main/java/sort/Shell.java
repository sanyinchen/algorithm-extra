package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.Util;

/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

class Shell implements CompareStrategy<Integer> {
    @Override
    public CompareAble<Integer>[] sort(CompareAble<Integer>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int step = 1;
        while (step < a.length / 3) {
            step = 3 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i > 0 && a[i].compareTo(a[i - step]) < 0; i -= step) {
                Util.exch(a, i, i - step);
            }
            step /= 3;
        }
        return a;
    }
}
