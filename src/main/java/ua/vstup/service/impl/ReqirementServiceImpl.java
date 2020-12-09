package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.RequirementDao;
import ua.vstup.domain.Requirement;
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
    public Integer add(Requirement requirement) {
        return requirementDao.save(EntityMapper.requirementToRequirementEntity(requirement));
    }
}
