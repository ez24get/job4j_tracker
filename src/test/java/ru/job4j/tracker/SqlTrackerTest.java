package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items;")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("replaced");
        tracker.add(item);
        int id = item.getId();
        tracker.replace(id, item2);
        assertThat(tracker.findById(id).getName()).isEqualTo(item2.getName());
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        List<String> items = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Item one = new Item("one");
        Item two = new Item("two");
        items.add(one.getName());
        items.add(two.getName());
        tracker.add(one);
        tracker.add(two);
        result.add(tracker.findById(one.getId()).getName());
        result.add(tracker.findById(two.getId()).getName());
        assertThat(result.equals(items)).isTrue();
    }

    @Test
    public void whenByName() {
        SqlTracker tracker = new SqlTracker(connection);
        List<String> items = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Item one = new Item("one");
        Item two = new Item("one");
        items.add(one.getName());
        items.add(two.getName());
        tracker.add(one);
        tracker.add(two);
        List<Item> found = new ArrayList<>(tracker.findByName("one"));
        for (Item i : found) {
            result.add(i.getName());
        }
        assertThat(result.equals(items)).isTrue();
    }
}