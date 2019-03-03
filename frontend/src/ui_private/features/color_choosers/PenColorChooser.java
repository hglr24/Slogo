package ui_private.features.color_choosers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class PenColorChooser extends ColorChooser {
    private static final String LABEL_TEXT = "Pen Color";

    @Override
    void handleNewColor(Color newColor) {
        System.out.println("pen here");
        myTurtleDisplay.setPenColor(newColor);
    }

    @Override
    public String getLabelText() {
        return LABEL_TEXT;
    }
}