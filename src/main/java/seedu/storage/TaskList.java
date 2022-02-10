package seedu.storage;

import java.util.ArrayList;

import seedu.duke.DukeException;
import seedu.task.Task;

/**
 * The task list to temporarily store the data
 */
public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.tasks = new ArrayList<>(taskList);
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Removes task from list specified by index.
     *
     * @param idx Index of task to be deleted.
     * @return Task to be deleted.
     * @throws DukeException Index not in range of 0 to task list size.
     */
    public Task remove(int idx) throws DukeException {
        Task t = get(idx);
        tasks.remove(idx);
        return t;
    }

    /**
     * Gets task from list specified by index.
     *
     * @param idx Index of task to be retrieved.
     * @return Task to be retrieved.
     * @throws DukeException Index not in range of 0 to task list size.
     */
    public Task get(int idx) throws DukeException {
        try {
            return tasks.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Task does not exist.");
        }
    }

    /**
     * Find all tasks with the given string in the task list
     *
     * @param search The string to be searched
     * @return A list in string representation of all the tasks with the substring found
     */
    public String find(String search) {
        StringBuilder s = new StringBuilder("Found:\n");

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(search)) {
                s.append("\t\t");
                s.append(i + 1);
                s.append(". ");
                s.append(tasks.get(i).toString());
                s.append("\n");
            }
        }

        return s.toString();
    }

    /**
     * Gives the appropriate response based on the size of the list
     *
     * @return The contents of the list in string form
     */
    @Override
    public String toString() {

        if (tasks.isEmpty()) {
            return "Empty list";
        }

        StringBuilder out = new StringBuilder("This List:\n");

        for (int i = 0; i < tasks.size(); i++) {
            out.append("\t\t");
            out.append(i + 1 + ". ");
            out.append(tasks.get(i).toString());
            out.append("\n");
        }

        return out.toString().trim();
    }
}
