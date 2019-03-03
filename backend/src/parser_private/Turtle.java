package parser_private;

import java.awt.geom.Point2D;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * A backend turtle that employs bindings to relate properties to frontend turtle representation.
 * Ensures the turtle stays in display width and height.
 * X and Y properties reflect the coordinates of the turtle view's top left corner.
 * @author Hunter Gregory
 */
public class Turtle {

    private int myTurtleID;
    private double myPaneWidth;
    private double myPaneHeight;

    private ObjectProperty<Point2D> myPositionProperty;
    private SimpleDoubleProperty myHeadingProperty;
    private SimpleBooleanProperty myIsShowingProperty;
    private SimpleBooleanProperty myPenIsDownProperty;
    private SimpleBooleanProperty myShouldEraseLinesProperty;

    /**
     * Assumes all double inputs are positive, and list input is nonnull.
     */
    public Turtle(int turtID, double pwidth, double pheight) {
        myTurtleID = turtID;
        myPaneWidth = pwidth;
        myPaneHeight = pheight;
        instantiateProperties();
        setDefaultState();
    }

    private void instantiateProperties() {
        myPositionProperty = new SimpleObjectProperty<>();
        myHeadingProperty = new SimpleDoubleProperty();
        myIsShowingProperty = new SimpleBooleanProperty();
        myPenIsDownProperty = new SimpleBooleanProperty();
        myShouldEraseLinesProperty = new SimpleBooleanProperty();
    }

    private double getInBoundsNum(double num, double min, double max) {
        if (num < min)
            return min;
        if (num > max)
            return max;
        return num;
    }

    private void setDefaultState() {
        setPosition(0,0);
        setHeading(0);
        setShowing(true);
        setPenDown(true);
        myShouldEraseLinesProperty.set(false);
    }

    public void setPosition(double x, double y) {
        double newX = getInBoundsNum(x, - myPaneWidth / 2.0, myPaneWidth / 2.0);
        double newY = getInBoundsNum(y, - myPaneHeight / 2.0, myPaneHeight / 2.0);
        myPositionProperty.set(new Point2D.Double(newX, newY));
    }

    public void setHeading(double heading) {
        myHeadingProperty.set(heading);
    }

    public void setShowing(boolean bool) {
        myIsShowingProperty.set(bool);
    }

    public void setPenDown(boolean bool) {
        myPenIsDownProperty.set(bool);
    }

    public void eraseLines() {
        myShouldEraseLinesProperty.set(true);
        myShouldEraseLinesProperty.set(false); // Reset to false after listener deletes lines
    }

    public int getTurtleID() {
        return myTurtleID;
    }

    public ObjectProperty<Point2D> getPositionProperty() {
        return myPositionProperty;
    }

    public DoubleProperty getHeadingProperty() {
        return myHeadingProperty;
    }

    public BooleanProperty getDownProperty() {
        return myPenIsDownProperty;
    }

    public BooleanProperty getShowingProperty() {
        return myIsShowingProperty;
    }

    public BooleanProperty getEraseProperty() {
        return myShouldEraseLinesProperty;
    }
}
