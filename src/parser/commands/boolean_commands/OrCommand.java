package parser.commands.boolean_commands;

import parser.Command;
import java.util.List;

public class OrCommand extends TwoParamBoolCommand {

    public OrCommand(List<Command> params) {
        super(params);
    }

    @Override
    public double runCommand() {
        return (myExpression1.execute() != 0 || myExpression2.execute() != 0) ? 1 : 0;
    }
}
