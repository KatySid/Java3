package Lesson1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        String[] arrString = {"qwe","asd", "zxc", "poi"};
        swapElement(arr1, 1, 3);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i].intValue());
        }
        swapElement(arrString, 1, 2);
        for (int i = 0; i < arrString.length; i++) {
            System.out.println(arrString[i]);
        }
        ArrayList<Integer> arrInteger = setArrayList(arr1);
        ArrayList <String> arrayString = setArrayList(arrString);
        for (int i = 0; i < arrInteger.size(); i++) {
            System.out.println(arrInteger.get(i));
        }
        for (int i = 0; i < arrayString.size(); i++) {
            System.out.println(arrayString.get(i) );
        }

        Box <Orange> box1 = new Box<>();
        for (int i = 0; i < 10; i++) {
            Orange or= new Orange(1.5f);
            box1.addToBoxElement(or);
        }
        Box<Apple> box2 = new Box<>();
        for (int i = 0; i < 10; i++) {
            Apple ap= new Apple(1.0f);
            box2.addToBoxElement(ap);
        }
        Box<Apple> box3 = new Box<>();
        for (int i = 0; i < 10; i++) {
            Apple ap= new Apple(2.0f);
            box3.addToBoxElement(ap);
        }
        Box <Orange> box4 = new Box<>();
        for (int i = 0; i < 10; i++) {
            Orange or = new Orange(2.0f);
            box4.addToBoxElement(or);
        }

        System.out.println("Weight in box1 "+box1.getWeight());
        System.out.println("Weight in box2 "+box2.getWeight());
        System.out.println(box1.compare(box2));
        System.out.println(box3.compare(box4));

        box2.putInBox(box3);

        System.out.println("In box2 "+box2.getWeight());
        System.out.println("In box3 "+box3.getWeight());

    }



    public static <T> T[] swapElement (T[] arr, int i, int j){
        if (i> arr.length || j > arr.length){
            throw new IndexOutOfBoundsException(" index not found");
        }
        T o= arr[i];
        arr[i]= arr[j];
        arr[j]= o;
        return arr;
    }

    public static <T> ArrayList<T> setArrayList(T[] arr){
        ArrayList<T> arr1 = new ArrayList<>(Arrays.asList(arr));
        return arr1;

    }

}
