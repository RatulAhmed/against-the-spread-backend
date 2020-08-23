package com.atspickem.backend.services;

import com.atspickem.backend.dao.NflSpreadDAO;
import com.atspickem.backend.models.NflSpread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NflSpreadService {

    @Autowired
    NflSpreadDAO nflSpreadDAO;

    public void createSpread(NflSpread nflSpread) {
        nflSpreadDAO.save(nflSpread);
    }
}
