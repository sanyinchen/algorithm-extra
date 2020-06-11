package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.Util;

/**
 * Created by sanyinchen on 20-6-11.
 * <p>
 * 选择排序
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

class Selection<T> implements CompareStrategy<T> {

    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    Util.exch(a, i, j);
                }
            }
        }
        return a;
    }
}
