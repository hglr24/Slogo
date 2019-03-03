package parser_private.commands.control_commands;

import parser_private.Command;
import state_public.CommandInter;

import java.util.List;

public class DoTimesCommand extends Command {

    private ListCommand myParams;
    private CommandInter myBody;

    public DoTimesCommand(List<CommandInter> params) {
        super(params);
        myParams = (ListCommand) params.get(0); // dotimes >>>[]<<< []
        myBody = params.get(1); // dotimes [] >>>[]<<<
    }

    @Override
    public double runCommand() {
        int limit = (int) myParams.getParam(1).execute();
        String countVarName = ((VariableCommand) myParams.getParam(0)).getVariableName();
        double retval = 0;

        for (int i = 1; i <= limit; i++) { //TODO remove duplication across dotimes, for, repeat
            // --- UNCOMMENT TO ENABLE LOCAL VARIABLE SCOPE ---
            /*myVariables.setVariable(countVarName, i);
              myBody.addVariables(myVariables);*/ //propagates var changes through body parser_private.commands
            myStateManager.getVariables().setVariable(countVarName, i); // --- COMMENT THIS TO ENABLE LOCAL ---
            retval = myBody.execute();
        }
        return retval;
    }
}
