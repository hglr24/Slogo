package ui_private.features.selectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import state_public.StateManager;

public class PenUpDownSelector extends Selector {
    private static final String TITLE = "Pen Up/Down";
    private static final ObservableList PENSTATES = FXCollections.observableArrayList("", "UP", "DOWN");
    private String myPenState;

    public PenUpDownSelector(StateManager manager) {
        super(manager);
    }

    @Override
    protected ObservableList getItemList() {
        return PENSTATES;
    }

    @Override
    protected void handleItemSelected(String item) {
        myPenState = item;
    }

    @Override
    protected String getLabelText() {
        return TITLE;
    }

    protected String getPenColor() {
        return myPenState;
    }
}