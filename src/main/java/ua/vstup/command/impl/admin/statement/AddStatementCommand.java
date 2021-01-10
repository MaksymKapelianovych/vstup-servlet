package ua.vstup.command.impl.admin.statement;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADMIN_STATEMENT_ADD_REDIRECT)
public class AddStatementCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        getStatementService(request).createStatement();
        return Constants.Urls.ADMIN_STATEMENT_FORWARD;
    }

}
