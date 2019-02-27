package parser_private.commands.boolean_commands;

import parser_private.Command;

import java.util.List;

abstract class TwoParamBoolCommand extends Command {

    Command myExpression1;
    Command myExpression2;

    TwoParamBoolCommand(List<Command> params) {
        super(params);
        this.myExpression1 = params.get(0);
        this.myExpression2 = params.get(1);
    }

    abstract public double runCommand();
}
