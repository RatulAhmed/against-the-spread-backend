package com.atspickem.backend.util;

import com.atspickem.backend.dao.NflScheduleDAO;
import com.atspickem.backend.models.NflSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NflScheduleService {

    public NflScheduleService() {
    }

    @Autowired
    private NflScheduleDAO nflScheduleDAO;

    List<NflSchedule> findByCurrentWeek(Integer integer) {
       return nflScheduleDAO.findByCurrentWeek(integer);
    }

    List<NflSchedule> findAll() {
        return nflScheduleDAO.findAll();
    }



}





