package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.list.ListMarkedCommand;
import seedu.address.logic.commands.list.ListUnmarkedCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.TaskIsDonePredicate;

public class ListMarkedCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        TaskIsDonePredicate firstPredicate =
                new TaskIsDonePredicate(Collections.singletonList("false"));

        ListMarkedCommand ListMarkedCommand = new ListMarkedCommand(firstPredicate);

        // same object -> returns true
        assertTrue(ListMarkedCommand.equals(ListMarkedCommand));

        // same values -> returns true
        ListMarkedCommand findCommandCopy = new ListMarkedCommand(firstPredicate);
        assertTrue(ListMarkedCommand.equals(findCommandCopy));

        // different types -> returns false
        assertFalse(ListMarkedCommand.equals(1));

        // null -> returns false
        assertFalse(ListMarkedCommand.equals(null));

    }

    @Test
    public void execute_multipleMarked_multipleTasksFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 4);
        TaskIsDonePredicate predicate = preparePredicate("true");
        ListMarkedCommand command = new ListMarkedCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(List.of(BENSON, CARL, DANIEL, GEORGE), model.getFilteredPersonList());
    }

    /**
     * Parses {@code userInput} into a {@code TaskIsDonePredicate}.
     * @return
     */
    private TaskIsDonePredicate preparePredicate(String userInput) {
        return new TaskIsDonePredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
