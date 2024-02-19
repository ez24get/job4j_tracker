package ru.job4j.tracker;

public class MemoryErrorAction implements UserAction {
    private final Output out;

    public MemoryErrorAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Annihilation";
    }

    @Override
    public void execute(Input input, Store tracker) {
        out.println("=== Okay let's go ===");
        int count = 1;
        while (true) {
            tracker.add(new Item("Заявка № " + count));
            out.println("Добавлено заявок: " + count);
        }
    }

    @Override
    public boolean exit() {
        return true;
    }
}