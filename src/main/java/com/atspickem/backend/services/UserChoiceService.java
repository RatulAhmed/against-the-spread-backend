package com.atspickem.backend.services;

import com.atspickem.backend.dao.UserChoiceDAO;
import com.atspickem.backend.models.SpreadChoiceRequest;
import com.atspickem.backend.models.UserChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserChoiceService {

    //TODO Figure out why without this id = 0 it doesn't get autoincremented by DB like in users table
    private int tempId = 1;

    @Autowired
    UserChoiceDAO userChoiceDAO;

    public void updateUserChoices(List<SpreadChoiceRequest> spreadChoiceRequestList) {
        for(SpreadChoiceRequest s : spreadChoiceRequestList) {
            if(userChoiceDAO.existsByUserId(s.getUserId())) {
                Optional<UserChoice> userChoice = userChoiceDAO.findByUserIdAndSpreadId(s.getUserId(), s.getSpreadId());
                userChoice.get().setChoice(s.getChoice());
            }
        }
    }


}
