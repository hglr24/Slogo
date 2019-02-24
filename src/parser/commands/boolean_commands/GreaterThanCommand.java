package parser.commands.boolean_commands;

import parser.Command;
import java.util.List;

public class GreaterThanCommand extends TwoParamBoolCommand {

    public GreaterThanCommand(List<Command> params) {
        super(params);
    }

    @Override
    public double runCommand() {
        return (myExpression1.execute() > myExpression2.execute()) ? 1 : 0;
    }
}
