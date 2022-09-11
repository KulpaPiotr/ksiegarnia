package pl.sdacademy.java.advance.exercises.day1.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StorageTest {
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
        storage.addToStorage("0", "value0_1");
        storage.addToStorage("1", "value1_1");
        storage.addToStorage("2", "value2_1");
        storage.addToStorage("2", "value2_2");
        storage.addToStorage("3", "value3_2");
    }

    @Test
    void shouldAddNewPosition() {
        // when
        storage.addToStorage("4", "value4_1");
        // then
        // sprawdz czy pod kluczem "1" znajduje się "value1_1"
        assertThat(storage.getValues("4")).containsExactly("value4_1");
    }

    @Test
    void shouldAddNewValueUnderExistingKey() {
        // when
        storage.addToStorage("2", "value2_3");
        // then
        assertThat(storage.getValues("2"))
                .containsExactly("value2_1", "value2_2", "value2_3");
    }

    @Test
    void shouldReturnAllKeysForSpecificValue() {
        // given
        storage.addToStorage("4", "value3_2");
        // when
        List<String> result = storage.findValues("value3_2");
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactly("3", "4");
    }

}