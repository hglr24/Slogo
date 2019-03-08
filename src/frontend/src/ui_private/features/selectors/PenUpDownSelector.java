package ui_private.features.selectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import state_public.StateManager;
import ui_private.displays.CommandTerminal;

public class PenUpDownSelector extends Selector {
    private static final String TITLE = "Pen Up/Down";
    private  ObservableList PENSTATES;
    private String myPenState;

    public PenUpDownSelector(StateManager manager) {
        super(manager);
    }

    @Override
    protected void setItemList(ObservableList list) {
        PENSTATES = FXCollections.observableArrayList("", "UP", "DOWN");
    }

    @Override
    protected void handleItemSelected(String item) {
        myPenState = item;
    }

    @Override
    public void setCommandTerminal(CommandTerminal terminal) {
        myCommandTerminal = terminal;
    }

    @Override
    protected String getLabelText() {
        return TITLE;
    }

    protected String getPenColor() {
        return myPenState;
    }
}