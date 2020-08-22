package com.atspickem.backend.dao;

import com.atspickem.backend.models.NflSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atspickem.backend.models.NflSchedule;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NflScheduleDAO extends JpaRepository<NflSchedule,Integer> {


    List<NflSchedule> findByWeek(Integer integer);

    @Override
    List<NflSchedule> findAll();
}
