package com.atspickem.backend.dao;

import com.atspickem.backend.models.NflSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface NflScheduleDAO extends JpaRepository<NflSchedule,Integer> {


    List<NflSchedule> findByWeek(Integer integer);

    @Override
    List<NflSchedule> findAll();

}
