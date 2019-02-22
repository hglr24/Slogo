package parser.commands;

import parser.Command;
import java.util.List;

public class EqualCommand extends TwoParamEvalCommand {

    public EqualCommand(List<Command> params) {
        super(params);
    }

    @Override
    public double execute() {
        return (myExpression1.execute() == myExpression2.execute()) ? 1 : 0;
    }
}
