package seedu.address.ui;

import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.visit.Visit;

/**
 * A UI class to show parameters of a {@code Visit} object on the patient's {@code ProfileWindow}.
 */
public class ProfileVisitCard extends UiPart<Region> {

    private static final String FXML = "ProfileVisitCard.fxml";

    public final Visit visit;
    public final String visitDate;
    private String diagnosis;
    private String prescription;
    private String comment;

    @FXML
    private HBox profileVisitCard;
    @FXML
    private Label profileDate;
    @FXML
    private Label profileDiagnosis;
    @FXML
    private Label profilePrescription;
    @FXML
    private Label profileComment;

    /**
     * Instantiates a ProfileVisitCard object.
     */
    public ProfileVisitCard(Visit visit) {
        super(FXML);
        this.visit = visit;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.visitDate = visit.getVisitDate().format(formatter);
        this.diagnosis = visit.getDiagnosis();
        this.prescription = visit.getPrescription();
        this.comment = visit.getComment();

        profileDate.setText("Visitation Report on [" + visitDate + "]");

        setParameter(diagnosis, profileDiagnosis);
        setParameter(prescription, profilePrescription);
        setParameter(comment, profileComment);
    }

    /**
     * Sets the specified parameter in {@code ProfileVisitCard}
     *
     * @param visitParameter Patient field to display
     * @param label {@code Label} object to represent specified patient field
     */
    private void setParameter(String visitParameter, Label label) {
        if (label == null) {
            return;
        }

        if (!(visitParameter.isBlank() || visitParameter == null)) {
            label.setText(visitParameter);
        } else {
            label.setText("-");
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ProfileVisitCard)) {
            return false;
        }

        // state check
        ProfileVisitCard card = (ProfileVisitCard) other;
        return this.visitDate.equals(card.visitDate) && visit.equals(card.visit);
    }
}

