package org.aston.konopelko.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CustomArrayListTest {

    @Test
    public void successfulCreationTest() {
        Assertions.assertDoesNotThrow(() -> new CustomArrayListImpl<>( 12));
    }

    @Test
    public void wrongCreationTest() {
        Assertions.assertThrows(RuntimeException.class, () -> new CustomArrayListImpl<>( -10));
    }

    @Test
    public void successfulAddition() {
        String newName = "Oleg";
        final CustomArrayList<String> names = TestUtil.buildNamesList();
        Assertions.assertTrue(names.add("Victoria"));
        names.add("Oleg");
        Assertions.assertEquals(newName, names.get(names.length() - 1));
    }
    @Test
    public void successfulAdditionWithIndex(){
        String newName = "Oleg";
        final CustomArrayList<String> names = TestUtil.buildNamesList();
        Assertions.assertEquals(5,names.length());
        Assertions.assertEquals("Igor",names.get(2));
        names.add(2,newName);
        Assertions.assertEquals(6,names.length());
        Assertions.assertEquals("Igor",names.get(3));
        Assertions.assertEquals(newName,names.get(2));
    }

    @ParameterizedTest
    @MethodSource(value = "provideSuccessGetData")
    public void successfulGet(int idx, String value) {
        final CustomArrayList<String> names = TestUtil.buildNamesList();
        for (int i = 0; i < names.length(); i++) {
            Assertions.assertEquals(value, names.get(idx));
        }
    }

    @Test
    public void successfulGetLength() {
        final CustomArrayList<String> names = TestUtil.buildNamesList();
        Assertions.assertEquals(5, names.length());
    }

    @Test
    public void successfulSort() {
        final CustomArrayList<Integer> actual = TestUtil.buildNumbersList();
        final List<Integer> expected = List.of(1,2,3,4,5,6,7,8,9);
        actual.sort(Comparator.naturalOrder());
        for (int i = 0; i < actual.length(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }
    }

    public static Stream<Arguments> provideSuccessGetData() {
        return Stream.of(
                Arguments.of(0, "Dima"),
                Arguments.of(1, "Maksim"),
                Arguments.of(2, "Igor"),
                Arguments.of(3, "Artem"),
                Arguments.of(4, "Nasty")
        );
    }
}
