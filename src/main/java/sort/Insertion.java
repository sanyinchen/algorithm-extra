package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.CompareUtils;

/**
 * Created by sanyinchen on 20-6-11.
 * <p>
 * 插入排序
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

class Insertion<T> implements CompareStrategy<T> {
    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) <= 0; j--) {
                CompareUtils.exch(a, j - 1, j);
            }
        }

        return a;
    }
}
