package ui_public;

import parser_public.CommandParser;
import state_public.ParserException;
import state_public.StateManager;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 *
 * Coordinate system is positive in the right and downwards direction.
 * A heading of 0 points upwards.
 */
public class UIMain {
    private static final double WIDTH = 1000;
    private static final double HEIGHT = 750;
    private static final Paint BACKGROUND = Color.WHITE;
    private static final String TITLE = "SLogo";

    private Stage myStage;
    private Scene myScene;
    private BorderPane myPane;
    private UIBuilder myFactory;
    private StateManager myStateManager;
    private CommandParser myBackend;
    private int myWorkspaceID;

    public UIMain(int workspaceID, CommandParser backend, StateManager stateManager, double width, double height) {
        myWorkspaceID = workspaceID;
        //myStage = stage;
        myBackend = backend;
        myStateManager = stateManager;
        init(myStage);
    }

    private void init(Stage stage) {
        myScene = setupGame(WIDTH, HEIGHT, BACKGROUND);
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
    }

    private Scene setupGame (double width, double height, Paint background) {
        myPane = new BorderPane();
        var scene = new Scene(myPane, width, height, background);
        scene.getStylesheets().add("style.css");
        //myFactory = new UIBuilder(myBackend, myStateManager, WIDTH, HEIGHT);
        /*myPane.setLeft(myFactory.getLeft());
        myPane.setRight(myFactory.getRight());
        myPane.setCenter(myFactory.getCenter());
        myPane.setBottom(myFactory.getBottom());*/

        addFeatures();

        return scene;
    }

    private void addFeatures() {
//        addPenColorChooser();
//        //myFactory.addLeftFeature(FeatureType.PEN_COLOR_CHOOSER);
//        addBackgroundColorChooser();
//        //myFactory.addLeftFeature(FeatureType.BACKGROUND_COLOR_CHOOSER);
//        addLanguageSelector();
//        //myFactory.addLeftFeature(FeatureType.LANGUAGE_SELECTOR);
//        addTurtleImageSelector();
//        //myFactory.addLeftFeature(FeatureType.TURTLE_IMAGE_SELECTOR);
//        //myFactory.addLeftFeature(FeatureType.PAST_COMMANDS_WINDOW);
//        addPastCommandsSelector();
//        //myFactory.addLeftFeature(FeatureType.PAST_COMMANDS_SELECTOR);
//        //myFactory.addRightFeature(FeatureType.USER_COMMANDS_WINDOW);
//        addUserCommandsSelector();
//        //myFactory.addLeftFeature(FeatureType.USER_COMMANDS_SELECTOR);
//        addMoveTurtleSelector();
//        //myFactory.addLeftFeature(FeatureType.MOVE_TURTLE_SELECTOR);
//        myFactory.addRightFeature(FeatureType.VARIABLES_WINDOW);
//        myFactory.addRightFeature(FeatureType.TURTLESTATE_WINDOW);
//        //myFactory.addRightFeature(FeatureType.FD_BUTTON);
//        myFactory.addRightFeature(FeatureType.PEN_THICKNESS_SLIDER);
//        myFactory.addRightFeature(FeatureType.PEN_UPDOWN_SELECTOR);
    }

    private void addPenColorChooser() {
        myFactory.addLeftFeature(FeatureType.PEN_COLOR_CHOOSER);
    }

    private void addBackgroundColorChooser() {
        myFactory.addLeftFeature(FeatureType.BACKGROUND_COLOR_CHOOSER);
    }

    private void addLanguageSelector() {
        myFactory.addLeftFeature(FeatureType.LANGUAGE_SELECTOR);
    }

    private void addTurtleImageSelector() {
        myFactory.addLeftFeature(FeatureType.TURTLE_IMAGE_SELECTOR);
    }

    private void addPastCommandsSelector() {
        myFactory.addLeftFeature(FeatureType.PAST_COMMANDS_SELECTOR);
    }

    private void addUserCommandsSelector() {
        myFactory.addLeftFeature(FeatureType.USER_COMMANDS_SELECTOR);
    }

    private void addMoveTurtleSelector() {
        myFactory.addLeftFeature(FeatureType.MOVE_TURTLE_SELECTOR);
    }

    private void addVariablesWindow() {
        myFactory.addRightFeature(FeatureType.VARIABLES_WINDOW);
    }

    private void addTurtleStateWindow() {
        myFactory.addRightFeature(FeatureType.TURTLESTATE_WINDOW);
    }

    private void addPenThicknessSlider() {
        myFactory.addRightFeature(FeatureType.PEN_THICKNESS_SLIDER);
    }

    private void addPenUpDownSelector() {
        myFactory.addRightFeature(FeatureType.PEN_UPDOWN_SELECTOR);
    }

    //TODO: put this in CommandTerminal
    private void handleException(ParserException e) {
        // TODO: Handle exception with some display
    }
}
