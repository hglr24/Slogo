package parser_private.commands.display_commands;

import parser_private.commands.turtle_commands.TurtleCommand;
import state.ICommand;

import java.util.List;

/**
 * @author David Miron
 * @author Harry Ross
 */
public class SetShapeCommand extends TurtleCommand {

    private ICommand myIndex;

    public SetShapeCommand(List<ICommand> params) {
        super(params);
        myIndex = params.get(0);
    }

    /**
     * Set the current shape to a given index
     * @return The index
     */
    @Override
    public double execute() {
        int index = (int) myIndex.execute();
        myStateManager.getTurtleManager().setImageIndex(index);
        return index;
    }
}
