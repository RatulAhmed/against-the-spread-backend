package com.atspickem.backend.dao;

import com.atspickem.backend.models.SpreadChoiceRequest;
import com.atspickem.backend.models.UserChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChoiceDAO extends JpaRepository<UserChoice, Integer> {
    <S extends UserChoice> S save(SpreadChoiceRequest s);

    @Override
    UserChoice getOne(Integer integer);

    @Override
    <S extends UserChoice> S save(S s);
}
