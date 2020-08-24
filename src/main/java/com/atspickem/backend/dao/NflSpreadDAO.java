package com.atspickem.backend.dao;

import com.atspickem.backend.models.NflSpread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NflSpreadDAO extends JpaRepository<NflSpread, Integer> {

    @Override
    <S extends NflSpread> S save(S s);

    List<NflSpread> findAllByWeek(int iterable);
}
