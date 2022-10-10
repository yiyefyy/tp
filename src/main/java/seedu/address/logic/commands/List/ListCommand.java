package seedu.address.logic.commands.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "ls";

    public static String MESSAGE_SUCCESS = "Listed all tasks";
    public static final String MESSAGE_USAGE = "To list all tasks in list: ls -a\n"
            + "To list all task under <module>: \n"
            + "EXAMPLE: ls --module cs2103t (case-insensitive for module name)\n"
            + "To list all unmarked (uncompleted tasks): ls -u\n";

    public ListCommand() {};

    public ListCommand(String MESSAGE_SUCCESS) {
        this.MESSAGE_SUCCESS =MESSAGE_SUCCESS;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
