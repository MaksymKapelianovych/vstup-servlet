package ua.vstup.command.impl.admin.statement;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Statement;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADMIN_STATEMENT_FORWARD)
public class StatementPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Statement statement = getStatementService(request).getUnfinalizedStatement();
        request.setAttribute(Constants.Attributes.STATEMENT, statement);
        return "/WEB-INF/admin/statement/statement.jsp";
    }
}
