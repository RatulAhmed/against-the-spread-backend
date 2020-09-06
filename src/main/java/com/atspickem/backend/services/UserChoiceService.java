package com.atspickem.backend.services;

import com.atspickem.backend.dao.UserChoiceDAO;
import com.atspickem.backend.models.SpreadChoiceRequest;
import com.atspickem.backend.models.UserChoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserChoiceService {

    @Autowired
    UserChoiceDAO userChoiceDAO;

    @Autowired
    EntityManager entityManager;
    public void updateUserChoices(List<SpreadChoiceRequest> spreadChoiceRequestList) {

        for(SpreadChoiceRequest s : spreadChoiceRequestList) {
            entityManager.clear();
            userChoiceDAO.save(new UserChoice(s.getUserId(), s.getSpreadId(), s.getChoice()));
        }
    }


}
