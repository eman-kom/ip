package seedu.commands;

import seedu.duke.DukeException;
import seedu.duke.Ui;
import seedu.storage.Storage;
import seedu.storage.TaskList;
import seedu.task.Task;

public class DeleteCommand extends Command {

    private int idx;

    @Override
    public void input(String inst) throws DukeException {
        idx = super.checkIdx(inst);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.remove(idx);
        ui.printDone(task, " deleted!");
    }
}
