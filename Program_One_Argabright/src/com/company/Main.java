package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        singlyLinkedList<Integer> firstList = new singlyLinkedList<>();

        // add Integers to list
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        singlyLinkedList<Integer> secondList = new singlyLinkedList<>();

        // add Integer to list
        secondList.add(4);
        secondList.add(5);
        secondList.add(6);
        secondList.add(7);
        secondList.add(8);
        secondList.add(9);

        // 3. remove value at index of 5
        secondList.remove(5);

        // 6. concat two lists together
        singlyLinkedList<Integer> thirdList = firstList.concat(secondList);

        // 1. size of merged list
        System.out.println("Size of list: " + thirdList.getSize());

        // 2. index of 6 value
        System.out.println("Index of value 6: " + thirdList.indexOf(6));

        // 4. remove random value
        System.out.println( "Random removal: " + thirdList.randomRemove());

        // 5. toString of merged list
        System.out.println(thirdList.toString());


    }
}
