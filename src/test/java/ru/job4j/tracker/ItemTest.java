package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenAscByName() {
        List<Item> items = Arrays.asList(
                new Item("one"),
                new Item("two"),
                new Item("four"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("four"),
                new Item("one"),
                new Item("two"));
        assertThat(items).isEqualTo(expected);
    }
}