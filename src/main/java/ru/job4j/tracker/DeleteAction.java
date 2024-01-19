package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public void execute(Input input, Store tracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter ID: ");
        if (tracker.findById(id) == null) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
    }

    @Override
    public boolean exit() {
        return true;
    }
}
