package pl.sdacademy.java.advance.exercises.day1.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {
    private static final List<String> UNSORTED = List.of("A", "Z", "B", "W", "C");
    private static final List<String> EXPECTED_RESULT = List.of("Z", "W", "C", "B", "A");

    @Test
    void shouldReverseListOfStrings_usingAnonymousClass() {
        // when
        List<String> result = Task1.sortUsingAnonymousClass(UNSORTED);
        //then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void shouldReverseListOfStrings_usingOwnComparator() {
        // when
        List<String> result = Task1.sortUsingOwnComparator(UNSORTED);
        //then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void shouldReverseListOfStrings_usingLambda() {
        // when
        List<String> result = Task1.sortUsingLambda(UNSORTED);
        //then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void shouldReverseListOfStrings_usingStream() {
        // when
        List<String> result = Task1.sortUsingStream(UNSORTED);
        //then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void shouldReverseListOfStrings_usingSortOnList() {
        // when
        List<String> result = Task1.sortOnList(UNSORTED);
        //then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

}