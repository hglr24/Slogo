package frontend;

import control.backendapi.ParseCall;
import frontend.turtles.ImageTurtle;
import frontend.turtles.TriangleTurtle;
import frontend.turtles.Turtle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import parser.ParserException;

import java.util.ArrayList;

/**
 *
 * Coordinate system is positive in the right and downwards direction.
 * A heading of 0 points upwards.
 */
public class UIMain extends Application {

    private static UIMain instance;

    public static final String TITLE = "SLogo";
    private ArrayList<Turtle> myTurtles;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final Paint BACKGROUND = Color.WHITE;

    private Group root;
    private BorderPane myPane;
    private Pane myTurtlePane;
    private Scene myScene;
    private ControlPanel myControlPanel;

    public UIMain() {

    }

    public static UIMain getInstance() {
        return instance;
    }

    @Override
    public void start(Stage stage) {
        instance = this;
        myScene = setupGame(WIDTH, HEIGHT, BACKGROUND);
        initializeTurtles();
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
        new TurtleTester().testGoTo(); //TODO: Remove when done testing
    }

    private Scene setupGame (int width, int height, Paint background) {
        myPane = new BorderPane();
        setUpTurtlePane();
        var scene = new Scene(myPane, width, height, background);
        scene.getStylesheets().add("style.css");
        myControlPanel = new ControlPanel(WIDTH, HEIGHT);
        myPane.setLeft(myControlPanel.paneBox);
        myPane.setCenter(myTurtlePane);
        scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        return scene;
    }

    private void setUpTurtlePane() {
        myTurtlePane = new Pane();
        myTurtlePane.getStyleClass().add("pane"); //TODO: remove magic string
        myTurtlePane.setMaxSize(400, 400); //TODO: remove magic numbers
        myTurtlePane.setMinSize(400, 400); //TODO: remove magic numbers
    }

    //must be called after setupGame to prevent null pointer on myRoot
    private void initializeTurtles() {
        myTurtles = new ArrayList<>();
        var turtle = new ImageTurtle(400, 400, myTurtlePane.getChildren()); //TODO: FIX magic numbers
        myTurtles.add(turtle);
    }

    private void handleKeyInput (KeyCode code) {
        if (code == KeyCode.ENTER) {

        }
    }

    // Method for testing structure
    public void parseButtonPressed() {
        try {
            new ParseCall("fd 50").call();
        } catch (ParserException e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        // TODO: Handle exception with some display
    }


    /*************      Frontend internal api      *********************/
    // All assume there is at least one turtle in myTurtles

    public double getX() {
        return myTurtles.get(0).getX();
    }

    public double getY() {
        return myTurtles.get(0).getY();
    }

    public void setPosition(double x, double y) {
        myTurtles.get(0).setPosition(x,y);
    }

    public double getHeading() {
        return myTurtles.get(0).getHeading();
    }

    public void setHeading(double heading) {
        myTurtles.get(0).setHeading(heading);
    }

    public boolean getPenIsDown() {
        return myTurtles.get(0).getPenIsDown();
    }

    public void setPenIsDown(boolean down) {
        myTurtles.get(0).setPenIsDown(down);
    }

    public boolean getTurtleIsShowing() {
        return myTurtles.get(0).getIsShowing();
    }

    public void setTurtleIsShowing(boolean showing) {
        myTurtles.get(0).setIsShowing(showing);
    }

    public void eraseLines() {
        myTurtles.get(0).eraseLines();
    }
}
