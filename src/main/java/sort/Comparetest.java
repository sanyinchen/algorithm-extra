package sort;


import sort.common.CompareAble;
import sort.common.Util;

/**
 * Created by sanyinchen on 20-6-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-11
 */

class Comparetest {

    static class TestCompareBean implements CompareAble<TestCompareBean> {

        public int index;
        public int value;

        public TestCompareBean(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(CompareAble<TestCompareBean> c) {

            if (this.value - c.getValue().value == 0) {
                return this.index - c.getValue().index;
            }

            return this.value - c.getValue().value;
        }

        @Override
        public TestCompareBean getValue() {
            return this;
        }

        @Override
        public String toString() {
            return value + "-" + index;
        }
    }


    public static void main(String[] args) {
        int len = 10000;
        TestCompareBean[] testInputs = new TestCompareBean[len];
        for (int i = 0; i < len; i++) {
            testInputs[i] = new TestCompareBean(i, (int) (Math.random() * 10000));
        }
        long local = System.currentTimeMillis();
        Util.show(Util.sort(testInputs, new Selection<>()));
        System.out.println("Selection:" + (System.currentTimeMillis() - local) + "ms");

        local = System.currentTimeMillis();
        Util.show(Util.sort(testInputs, new Insertion<>()));
        System.out.println("Insertion:" + (System.currentTimeMillis() - local) + "ms");

        local = System.currentTimeMillis();
        Util.show(Util.sort(testInputs, new Shell<>()));
        System.out.println("Shell:" + (System.currentTimeMillis() - local) + "ms");

    }
}
