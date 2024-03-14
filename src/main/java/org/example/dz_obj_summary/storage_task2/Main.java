package org.example.dz_obj_summary.storage_task2;

public class Main {
    public static void main(String[] args) {

        Storage<Integer> intStore = new Storage<>(2);
        intStore.add(1);
        intStore.add(2);

        System.out.println(intStore);
        System.out.println(intStore.get(4));
        System.out.println(intStore.size());


        Storage<String> strStore = new Storage<>(2);
        strStore.add("puk");
        strStore.add("sren'k");
        System.out.println(strStore);


    }
}