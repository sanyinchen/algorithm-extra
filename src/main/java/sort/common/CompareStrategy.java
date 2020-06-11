package sort.common;

/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

public interface CompareStrategy<T> {
    CompareAble<T>[] sort(CompareAble<T>[] a);
}
