package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.domain.Entrant;
import ua.vstup.entity.EntrantEntity;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.EntrantService;
import ua.vstup.service.utility.EntityMapper;
import ua.vstup.validator.EntrantValidator;

import java.util.Optional;

@Service
public class EntrantServiceImpl implements EntrantService {
    @Autowired
    private EntrantDao entrantDao;
    @Autowired
    private EntrantValidator entrantValidator;

    @Override
    public Entrant login(String email, String password) {
        Optional<EntrantEntity> entrantByEmail = entrantDao.findByEmail(email);
        if(entrantByEmail.isPresent() && entrantByEmail.get().getPassword().equals(password)){
            return EntityMapper.entrantEntityToEntrant(entrantByEmail.get());
        }
        return null;
    }

    @Override
    public void register(Entrant entrant) {
        //entrantValidator.validate(entrant);
        if(entrantDao.findByEmail(entrant.getEmail()).isPresent()){
            throw new IncorrectDataException("entrant.already.exists");
        }
        entrantDao.save(EntityMapper.entrantToEntrantEntity(entrant));
    }

    @Override
    public void edit(Entrant entrant) {

    }
}
