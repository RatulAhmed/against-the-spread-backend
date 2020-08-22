package com.atspickem.backend.util;

import com.atspickem.backend.dao.NflScheduleDAO;
import com.atspickem.backend.models.NflSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NflScheduleService {

    public NflScheduleService() {
    }

    @Autowired
    private NflScheduleDAO nflScheduleDAO;

    List<NflSchedule> findByCurrentWeek(Integer integer) {
        System.out.println(">>>>>>>/nflscheduleservice.findbyCurrentWeek");
       return nflScheduleDAO.findByWeek(integer);
    }

    List<NflSchedule> findAll() {
        return nflScheduleDAO.findAll();
    }
//
//    NflSchedule findById(Integer integer) {
//        return nflScheduleDAO.findById(integer);
//    }

    NflSchedule getOne(Integer integer) {
        return nflScheduleDAO.getOne(integer);
    }

}





