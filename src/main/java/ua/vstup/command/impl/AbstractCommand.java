package ua.vstup.command.impl;

import ua.vstup.domain.Entrant;
import ua.vstup.service.EntrantService;
import ua.vstup.service.RequirementService;
import ua.vstup.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class AbstractCommand {
    protected EntrantService getEntrantService(HttpServletRequest request){
        return (EntrantService) request.getServletContext().getAttribute("ua.vstup.service.EntrantService");
    }

    protected SubjectService getSubjectService(HttpServletRequest request){
        return (SubjectService) request.getServletContext().getAttribute("ua.vstup.service.SubjectService");
    }

    protected RequirementService getRequirementService(HttpServletRequest request){
        return (RequirementService) request.getServletContext().getAttribute("ua.vstup.service.RequirementService");
    }
}
