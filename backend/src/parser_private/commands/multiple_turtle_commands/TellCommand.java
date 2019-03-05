package parser_private.commands.multiple_turtle_commands;

import parser_private.Command;
import parser_private.commands.control_commands.ListCommand;
import state_public.CommandInter;

import java.util.ArrayList;
import java.util.List;

public class TellCommand extends MultipleTurtlesCommand {

    private ListCommand turtlesToTell;

    public TellCommand(List<CommandInter> params) {
        super(params);
        turtlesToTell = (ListCommand)params.get(0);
    }

    @Override
    public double execute() {
        return tell(turtlesToTell);
    }


}
