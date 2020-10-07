package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Undoes the previous user command.
 */
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_SUCCESS = "Undo-ed the previous command";

    public static final String MESSAGE_NO_MORE_COMMANDS = "No more commands to undo";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (!model.canUndoCliniCal()) {
            throw new CommandException(MESSAGE_NO_MORE_COMMANDS);
        }
        model.undoCliniCal();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}