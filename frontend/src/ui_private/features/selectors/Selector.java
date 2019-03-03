package ui_private.features.selectors;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import ui_private.features.Feature;

public abstract class Selector extends Feature {
    private static final int NUM_OPTIONS_SHOWN = 4;

    private ComboBox<String> myDropBox;

    public Selector() {
        super(true);
        myDropBox = new ComboBox<>();
        myDropBox.setEditable(false);
        myDropBox.setVisibleRowCount(NUM_OPTIONS_SHOWN);
        myDropBox.setItems(getItemList());
        myDropBox.getSelectionModel().selectFirst();
        String selectedItem = myDropBox.getSelectionModel().getSelectedItem();
        myDropBox.setOnAction(e -> handleItemSelected(selectedItem));
    }


    /**
     * @return List of selectable items
     */
    abstract protected ObservableList getItemList();

    /**
     * @param item
     */
    abstract protected void handleItemSelected(String item);


    @Override
    public Node getMainComponent() {
        return myDropBox;
    }
}
