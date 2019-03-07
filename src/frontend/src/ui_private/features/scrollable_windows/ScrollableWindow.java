package ui_private.features.scrollable_windows;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import state_public.StateManager;
import ui_private.features.Feature;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public abstract class ScrollableWindow extends Feature {
    private static final boolean SORTS_ALPHABETICALLY = false;
    private static final int MAX_LINES_DISPLAYED = 50;

    private ScrollPane myScrollPane;
    private TextArea myTextArea;
    private LinkedList<String> myTextChain;

    public ScrollableWindow(StateManager manager) {
        super(manager);
        myTextChain = new LinkedList<>();
        myTextArea = new TextArea(getText());
        myScrollPane = new ScrollPane(myTextArea);
        myScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        myScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        myScrollPane.setDisable(true);
    }

    protected void addText(String newString) {
        myTextChain.addFirst(newString);
        if (SORTS_ALPHABETICALLY)
            Collections.sort(myTextChain, Comparator.reverseOrder());
        myTextArea.setText(getText());
    }

    private String getText() {
        StringBuilder builder = new StringBuilder();
        int maxLines = MAX_LINES_DISPLAYED;
        for (String line : myTextChain) {
            if (maxLines <= 0)
                break;
            builder.append(line + "\n");
            maxLines -= 1;
        }
        return builder.toString();
    }


    @Override
    protected Node getMainComponent() {
        return myScrollPane;
    }

    @Override
    protected boolean getHasHorizontalLayout() { return false; }
}
