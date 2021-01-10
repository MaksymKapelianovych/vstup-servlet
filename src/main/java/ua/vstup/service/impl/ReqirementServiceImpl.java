package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.RequirementDao;
import ua.vstup.domain.Requirement;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.RequirementService;
import ua.vstup.service.utility.EntityMapper;
import ua.vstup.validator.RequirementValidator;

@Service
public class ReqirementServiceImpl implements RequirementService {
    @Autowired
    private RequirementDao requirementDao;
    @Autowired
    private RequirementValidator requirementValidator;

    @Override
    public void add(Requirement requirement) {
        if(requirementDao.save(EntityMapper.requirementToRequirementEntity(requirement)) == 0){
            throw new IncorrectDataException("Incorrect data");
        }
    }
}
