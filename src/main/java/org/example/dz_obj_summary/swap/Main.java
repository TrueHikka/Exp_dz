package org.example.dz_obj_summary.swap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int
        Integer a = 2;
        Integer b = 4;

        TwoValues<Integer> twoNums = swap(a, b);
        System.out.println("twoNums" + twoNums);

        a = twoNums.value1;
        b = twoNums.value2;

        System.out.println("item a = " + a + ", item b = " + b);

        //str
        String str1 = "Hello";
        String str2 = "World";

        TwoValues<String> twoStr = swap(str1, str2);

        str1 = twoStr.value1;
        str2 = twoStr.value2;

        System.out.println("item srt1 = " + str1 + ", item str2 = " + str2);

        //arr elem
        Integer[] arr = {1, 5};
        System.out.println(Arrays.toString(arr));
        TwoValues<Integer> intArr = swap(arr[0], arr[1]);

        arr[0] = intArr.value1;
        arr[1] = intArr.value2;

        System.out.println("item arr[0] = " + arr[0] + ", item arr[1] = " + arr[1]);
        System.out.println(Arrays.toString(arr));
    }

    public static <T> TwoValues <T> swap(T item_1, T item_2) {
        TwoValues<T> result = new TwoValues<>();
        result.value1 = item_1;
        result.value2 = item_2;

        T swapper = result.value1;
        result.value1 = result.value2;
        result.value2 = swapper;

        return result;
    }

    public static class TwoValues <T> {
        public T value1;
        public T value2;

        @Override
        public String toString() {
            return "TwoValues{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    '}';
        }
    }
}

