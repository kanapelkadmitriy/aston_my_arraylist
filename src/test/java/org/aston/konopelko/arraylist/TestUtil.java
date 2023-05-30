package org.aston.konopelko.arraylist;

public class TestUtil {

    public static CustomArrayList<String> buildNamesList() {
        CustomArrayList<String> names = new CustomArrayListImpl<>();
        names.add("Dima");
        names.add("Maksim");
        names.add("Igor");
        names.add("Artem");
        names.add("Nasty");
        return names;
    }

    public static CustomArrayList<Integer> buildNumbersList() {
        CustomArrayList<Integer> numbers = new CustomArrayListImpl<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(9);
        numbers.add(6);
        numbers.add(5);
        numbers.add(8);
        numbers.add(7);
        return numbers;
    }
}
