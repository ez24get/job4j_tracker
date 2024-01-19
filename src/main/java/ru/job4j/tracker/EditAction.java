package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public void execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Отредактированна заявка: " + item);
        } else {
            out.println("Ошибка замены заявки.");
        }
    }

    @Override
    public boolean exit() {
        return true;
    }
}