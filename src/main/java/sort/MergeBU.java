package sort;

import sort.common.CompareAble;
import sort.common.CompareStrategy;
import sort.common.CompareUtils;

/**
 * Created by sanyinchen on 20-6-12.
 * 归并排序，自底向上
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-12
 */

class MergeBU<T> implements CompareStrategy<T> {
    @Override
    public CompareAble<T>[] sort(CompareAble<T>[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        CompareAble<T>[] cache = new CompareAble[a.length];
        for (int i = 1; i < a.length; i += i) {
            for (int j = 0; j < a.length - i; j += i * 2) {
                CompareUtils.merge(a, j, j + i - 1, Math.min(j + i * 2 - 1, a.length - 1), cache);
            }
        }
        return a;
    }


}
