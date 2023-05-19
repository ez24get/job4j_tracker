package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void whenDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "one"),
                new Item(2, "two"),
                new Item(3, "four"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "two"),
                new Item(1, "one"),
                new Item(3, "four"));
        assertThat(items).isEqualTo(expected);
    }
}