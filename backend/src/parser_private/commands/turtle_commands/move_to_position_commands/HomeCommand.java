package parser_private.commands.turtle_commands.move_to_position_commands;

import parser_private.commands.math_commands.ConstantCommand;
import state_public.ICommand;

import java.util.List;

public class HomeCommand extends MoveToPositionCommand {

    public HomeCommand(List<ICommand> params) {
        super(params);
        this.myNewX = new ConstantCommand(0.0);
        this.myNewY = new ConstantCommand(0.0);
    }
}
