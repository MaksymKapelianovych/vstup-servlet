package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.RequestDao;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.Request;
import ua.vstup.service.RequestService;
import ua.vstup.service.utility.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDao requestDao;
    @Override
    public List<Request> getAll(Entrant entrant) {
        return requestDao.findAllByEntrantId(entrant.getId()).stream()
                .map(EntityMapper::requestEntityToRequest)
                .collect(Collectors.toList());
    }
}
