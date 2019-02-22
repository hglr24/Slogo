package parser.commands;

import parser.Command;
import java.util.List;

public class OrCommand extends TwoParamEvalCommand {

    public OrCommand(List<Command> params) {
        super(params);
    }

    @Override
    public double execute() {
        return (myExpression1.execute() == myExpression2.execute()) ? 1 : 0;
    }
}
