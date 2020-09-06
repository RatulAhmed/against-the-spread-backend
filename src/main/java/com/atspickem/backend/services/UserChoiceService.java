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
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserChoiceService {

    //TODO Figure out why without this id = 0 and doesn't get autofixed by DB like in users
    private int tempId = 1;

    @Autowired
    UserChoiceDAO userChoiceDAO;

    @Autowired
    EntityManager entityManager;

    public void updateUserChoices(List<SpreadChoiceRequest> spreadChoiceRequestList) {
        List<UserChoice> userChoiceList = new ArrayList<>();

        for(SpreadChoiceRequest s : spreadChoiceRequestList) {
            tempId++;
            userChoiceList.add(new UserChoice(tempId, s.getUserId(),s.getSpreadId(),s.getChoice()));
        }

        userChoiceDAO.saveAll(userChoiceList);
    }


}
