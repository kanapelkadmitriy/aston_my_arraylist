package org.aston.konopelko.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuickSortTest {

    @Test
    public void successfulQuickSort() {
        final CustomArrayList<Integer> actual = TestUtil.buildNumbersList();
        final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        QuickSort.sort(actual);
        for (int i = 0; i < actual.length(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }
    }
}