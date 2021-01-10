package ua.vstup.command.impl.admin.statement;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADMIN_STATEMENT_FINALIZE_REDIRECT)
public class FinalizeStatementCommand extends AbstractCommand implements Command {
    //TODO implement
    @Override
    public String execute(HttpServletRequest request) {
        getStatementService(request).finalizeStatement();
        return Constants.Urls.ADMIN_STATEMENT_FORWARD;
    }
}
