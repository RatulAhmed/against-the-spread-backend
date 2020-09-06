package com.atspickem.backend.dao;

import com.atspickem.backend.models.SpreadChoiceRequest;
import com.atspickem.backend.models.UserChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserChoiceDAO extends JpaRepository<UserChoice, Integer> {
    <S extends UserChoice> S save(SpreadChoiceRequest s);

    @Override
    UserChoice getOne(Integer integer);

    @Override
    <S extends UserChoice> S save(S s);

    boolean existsByUserId(Integer integer);

    @Override
    Optional<UserChoice> findById(Integer integer);

    Optional<UserChoice> findByUserIdAndSpreadId(Integer userId, Integer spreadId);



}
