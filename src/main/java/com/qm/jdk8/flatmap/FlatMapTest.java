package com.qm.jdk8.flatmap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class FlatMapTest {

    @Test
    public void testFlatMap() {
        List<Integer> together =
                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                        .flatMap(numbers -> numbers.stream())
                        .collect(Collectors.toList());
        assertEquals(Arrays.asList(1,2,3,4),together);
    }

    @Test
    public void testFlatMap1() {
        Stream<Integer> together =
                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                        .flatMap(numbers -> numbers.stream());
    }
}
