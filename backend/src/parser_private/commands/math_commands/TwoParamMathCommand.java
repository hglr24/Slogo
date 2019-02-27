package parser_private.commands.math_commands;

import parser_private.Command;
import parser_private.EvalCommand;
import java.util.List;

abstract class TwoParamMathCommand extends EvalCommand {

    Command myExpression1;
    Command myExpression2;

    TwoParamMathCommand(List<Command> params) {
        super(params);
        this.myExpression1 = params.get(0);
        this.myExpression2 = params.get(1);
    }
}