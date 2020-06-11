package sort.common;


/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

public interface CompareAble<T> {

    int compareTo(CompareAble<T> c);

    T getValue();

    String toString();


}
