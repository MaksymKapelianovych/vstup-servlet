package ua.vstup.command.impl.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Request;
import ua.vstup.domain.State;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADD_REQUEST_REDIRECT)
public class AddRequestCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Request entrantRequest = Request.builder()
                .withId(null)
                .withEntrantId(getEntrant(request).getId())
                .withFacultyId(Integer.valueOf(request.getParameter(Constants.Parameters.FACULTY_ID)))
                .withFirstSubjectId(Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_ID1)))
                .withSecondSubjectId(Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_ID2)))
                .withThirdSubjectId(Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_ID3)))
                .withPriority(1)  //TODO change setting priority
                .withState(State.ACTIVE)
                .build();

        getRequestService(request).add(entrantRequest);
        return Constants.Urls.REQUESTS_FORWARD;
    }
}
