package control.frontendapi.move_to_position_calls;

import control.frontendapi.FrontendAPICall;

public abstract class MoveToPositionCall extends FrontendAPICall {
    private double myNewX;
    private double myNewY;
    private boolean myEraseLines;

    public MoveToPositionCall(double newX, double newY, boolean eraseLines) {
        myNewX = newX;
        myNewY = newY;
        myEraseLines = eraseLines;
    }

    @Override
    public double call() {
        ui.setXY((int)myNewX, (int)myNewY);
        if (myEraseLines)
            ui.eraseLines();
        return getCartesianDistance();
    }

    private double getCartesianDistance() {
        double oldX = ui.getX();
        double oldY = ui.getY();
        var deltaXSquared = Math.pow(myNewX - oldX, 2);
        var deltaYSquared = Math.pow(myNewY - oldY, 2);
        return Math.sqrt(deltaXSquared + deltaYSquared);
    }
}