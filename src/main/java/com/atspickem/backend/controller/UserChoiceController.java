package com.atspickem.backend.controller;

import com.atspickem.backend.dao.UserChoiceDAO;
import com.atspickem.backend.models.SpreadChoiceRequest;
import com.atspickem.backend.services.UserChoiceService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserChoiceController {

    @Autowired
    private UserChoiceService userChoiceService;

    @PostMapping(value = "/submitChoice")
    public void updateUserChoices(@RequestBody List<SpreadChoiceRequest> request) {
        System.out.println("Made it here without failing >>> UserChoice Controller");
        userChoiceService.updateUserChoices(request);
    }

}
