package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public void execute(Input input, Store tracker) {
        out.println("=== Exit Program ===");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
