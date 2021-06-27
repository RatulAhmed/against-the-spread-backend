package com.atspickem.backend.controller;

import com.atspickem.backend.models.NflSpread;
import com.atspickem.backend.services.NflSpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SpreadController {

    @Autowired
    NflSpreadService nflSpreadService;

    @GetMapping(value = "/spreads")
    public List<NflSpread> getCurrentNflSpreads(@RequestParam("currentWeek") int currentWeek) {
        List<NflSpread> response;
        response = nflSpreadService.findAllByWeek(currentWeek);
        return response;
    }
}
