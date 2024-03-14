package org.example.dz_obj_summary.sumOfList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Number> intNums = new ArrayList<>();
        intNums.addFirst(1);
        intNums.add(2);
        intNums.addLast(3);

        System.out.println(sumOfList(intNums));

        List<Number> doubleNums = new ArrayList<>();
        doubleNums.addFirst(1.4);
        doubleNums.add(2.5);
        doubleNums.addLast(3.9);

        System.out.println(sumOfList(doubleNums));
    }

    public static double sumOfList(List<? extends Number> nums) {
        double sum = 0.0;
        for (Number intNum : nums) {
            sum += intNum.doubleValue();
        }
        return sum;
    }
}

