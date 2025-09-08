import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        assertTrue(task.matches("родителям"));
        assertFalse(task.matches("сходить"));
    }

    @Test
    public void testEpicMatches() {
        Epic epic = new Epic(2, Arrays.asList("Молоко", "Яйца", "Хлеб").toArray(new String[0]));
        assertTrue(epic.matches("Яйца"));
        assertFalse(epic.matches("Мясо"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(2, "Обсуждение проекта", "Разработка", "15-09-2025");
        assertTrue(meeting.matches("Разработка"));
        assertFalse(meeting.matches("Мясо"));
    }

}
