package org.aston.konopelko.arraylist;

import java.util.Comparator;

/**
 * Интерфейс CustomArrayList с описанием методов которые реализованы в классе CustomArrayListImpl.
 */
public interface CustomArrayList<E> {

    boolean add(E e);

    boolean add(int index, E e);

    E get(int index);

    void set(int index, E e);

    void delete(int index);

    void clean();

    void sort(Comparator<E> comparator);

    int length();
}
