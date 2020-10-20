package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EDIT_VISIT;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.patient.Patient;
/**
 * Edits record of patient by index.
 */
public class EditVisitCommand extends Command {

    public static final String COMMAND_WORD = "editvisit";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the visitation record of the person identified "
            + "by the index number used in the last person listing.\n "
            + COMMAND_WORD + " [PERSON INDEX] "
            + PREFIX_EDIT_VISIT + "[REPORT INDEX]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_EDIT_VISIT + "2";

    public static final String MESSAGE_EDIT_VISIT_PROMPT = "Please edit the form";
    public static final String MESSAGE_MISSING_INDEX_PROMPT = "Please specify index of report to be edited\n"
            + "Usage: " + COMMAND_WORD + " [PERSON INDEX] "
            + PREFIX_EDIT_VISIT + "[REPORT INDEX]\n";

    private static final int EMPTY_REPORT_INDICATOR = -1;

    private final Index index;
    private final int id;

    /**
     * @param index of the person in the filtered person list to edit the visitList
     * @param id of the report to be deleted
     */
    public EditVisitCommand(Index index, int id) {
        requireAllNonNull(index);

        this.index = index;
        this.id = id;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Patient> lastShownList = model.getFilteredPatientList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX);
        }

        Patient personToEdit = lastShownList.get(index.getZeroBased());
        Patient editedPerson = personToEdit;
        if (id != EMPTY_REPORT_INDICATOR) {
            try {
                return new CommandResult(String.format(MESSAGE_EDIT_VISIT_PROMPT, personToEdit),
                        editedPerson.getVisitHistory().getObservableVisits(), index.getOneBased(),
                        id, editedPerson.getVisitHistory().getVisitByIndex(id));
            } catch (IndexOutOfBoundsException e) {
                throw new CommandException(Messages.MESSAGE_INVALID_REPORT_INDEX);
            }
        } else {
            return new CommandResult(MESSAGE_MISSING_INDEX_PROMPT,
                    editedPerson.getVisitHistory().getObservableVisits());
        }

    }


    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditVisitCommand)) {
            return false;
        }

        // state check
        EditVisitCommand e = (EditVisitCommand) other;
        return index.equals(e.index)
                && id == e.id;
    }
}


