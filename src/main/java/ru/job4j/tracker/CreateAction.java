package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create";
    }

    @Override
    public void execute(Input input, Store tracker) {
        out.println("=== Create one new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
    }

    @Override
    public boolean exit() {
        return true;
    }
}