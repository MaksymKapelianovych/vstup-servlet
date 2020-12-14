package ua.vstup.command.impl;

import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;
import ua.vstup.service.*;

import javax.servlet.http.HttpServletRequest;

public class AbstractCommand {
    protected Entrant getEntrant(HttpServletRequest request) {
        return (Entrant) request.getSession().getAttribute(Constants.Attributes.ENTRANT);
    }

    protected EntrantService getEntrantService(HttpServletRequest request){
        return (EntrantService) request.getServletContext().getAttribute("ua.vstup.service.EntrantService");
    }

    protected SubjectService getSubjectService(HttpServletRequest request){
        return (SubjectService) request.getServletContext().getAttribute("ua.vstup.service.SubjectService");
    }

    protected RequirementService getRequirementService(HttpServletRequest request){
        return (RequirementService) request.getServletContext().getAttribute("ua.vstup.service.RequirementService");
    }
    protected SchoolService getSchoolService(HttpServletRequest request){
        return (SchoolService) request.getServletContext().getAttribute("ua.vstup.service.SchoolService");
    }
    protected RequestService getRequestService(HttpServletRequest request){
        return (RequestService) request.getServletContext().getAttribute("ua.vstup.service.RequestService");
    }
    protected FacultyService getFacultyService(HttpServletRequest request){
        return (FacultyService) request.getServletContext().getAttribute("ua.vstup.service.FacultyService");
    }
}
