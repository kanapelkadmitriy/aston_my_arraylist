package org.aston.konopelko.arraylist;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс CustomArrayListImpl представляет собой реализацию динамического массива.
 * CustomArrayListImpl позволяет добавлять, получать, удалять и сортировать элементы, как и в обычному массиву.
 */

public class CustomArrayListImpl<E> implements CustomArrayList<E> {

    /**
     * Изначальный размер списка.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Массив, содержащий элементы типа E.
     */
    private Object[] values;

    /**
     * Кол-во элементов, хранящихся в списке.
     */
    private int size;

    /**
     * Пустой CustomArrayListImpl с изначальным размером списка.
     */
    public CustomArrayListImpl() {
        this.size = 0;
        values = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Проверка CustomArrayListImpl.
     */
    public CustomArrayListImpl(int capacity) {
        this.size = 0;
        if (capacity < 0) {
            throw new RuntimeException(String.format("Capacity %s incorrect", capacity));
        }
        values = new Object[capacity];
    }

    /**
     * Добавляет нужный элемент по нужному индексу, со сдвигом всех последующих элементов в правую сторону.
     */
    @Override
    public boolean add(E e) {
        try {
            if (size < values.length) {
                values[size] = e;
                size++;
                return true;
            }
            Object[] previous = values;
            values = new Object[previous.length + previous.length / 2];
            System.arraycopy(previous, 0, values, 0, previous.length);
            values[size] = e;
            size++;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(int index, E e) {
        try {
            if (index > size || index < 0) {
                throw new RuntimeException(String.format("Incorrect index: %s", index));
            }
            Object[] previous = values;
            values = size == values.length
                    ? new Object[previous.length + previous.length / 2]
                    : new Object[previous.length];
            System.arraycopy(previous,0,values,0,previous.length);
            System.arraycopy(previous, index, values, index + 1, size - index);
            values[index] = e;
            size++;
            return true;
        } catch (ClassCastException exception){
            exception.printStackTrace();
        }
        return false;
    }

//    public void add(int index, E element) {
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException("Index out of range: " + index);
//        }
//        if (size == values.length) {
//            increaseCapacity();
//        }
//        System.arraycopy(values, index, values, index + 1, size - index);
//        values[index] = element;
//        size++;
//    }

    /**
     * Возвращает нужный элемент по нужному индексу.
     */
    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public void set(int index, E e) {
        values[index] = e;
    }

    /**
     * Удаляет нужный элемент по нужному индексу, со сдвигом всех элементов в левую сторону.
     */
    @Override
    public void delete(int index) {
        try {
            Object[] first = values;
            values = new Object[first.length - 1];
            System.arraycopy(first, 0, values, 0, index);
            int amountElementsAfterIndex = first.length - index - 1;
            System.arraycopy(first, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Удаляет все элементы.
     */
    @Override
    public void clean() {
        values = new Object[values.length];
    }

    /**
     * Сортирует все элементы из нашего списка.
     */
    @Override
    public void sort(Comparator<E> comparator) {
        Arrays.sort((E[]) values, 0, size, comparator);
    }

    /**
     * Возвращает кол-во элементов.
     */
    @Override
    public int length() {
        return size;
    }
}
