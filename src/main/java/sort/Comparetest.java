package sort;


import java.util.Arrays;

import sort.common.CompareAble;
import sort.common.CompareUtils;

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

//            if (this.value - c.getValue().value == 0) {
//                return this.index - c.getValue().index;
//            }

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
        TestCompareBean[] testInputs = new TestCompareBean[len + 2];
        for (int i = 0; i < len; i++) {
            testInputs[i] = new TestCompareBean(i, (int) (Math.random() * 1000));
        }
        testInputs[len] = new TestCompareBean(len, 0);
        testInputs[len + 1] = new TestCompareBean(len + 1, 0);


        long local = System.currentTimeMillis();
        CompareUtils.show(CompareUtils.sort(Arrays.copyOf(testInputs, testInputs.length), new Selection<>()));
        System.out.println("Selection:" + (System.currentTimeMillis() - local) + "ms");

        local = System.currentTimeMillis();
        CompareUtils.show(CompareUtils.sort(Arrays.copyOf(testInputs, testInputs.length), new Insertion<>()));
        System.out.println("Insertion:" + (System.currentTimeMillis() - local) + "ms");

        local = System.currentTimeMillis();
        CompareUtils.show(CompareUtils.sort(Arrays.copyOf(testInputs, testInputs.length), new Shell<>()));
        System.out.println("Shell:" + (System.currentTimeMillis() - local) + "ms");

        local = System.currentTimeMillis();
        CompareUtils.show(CompareUtils.sort(Arrays.copyOf(testInputs, testInputs.length), new Merge<>()));
        System.out.println("Merge:" + (System.currentTimeMillis() - local) + "ms");

        local = System.currentTimeMillis();
        CompareUtils.show(CompareUtils.sort(Arrays.copyOf(testInputs, testInputs.length), new MergeBU<>()));
        System.out.println("MergeBU:" + (System.currentTimeMillis() - local) + "ms");

    }
}
