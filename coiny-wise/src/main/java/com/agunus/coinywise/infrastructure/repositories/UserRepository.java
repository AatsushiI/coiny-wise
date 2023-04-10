package com.agunus.coinywise.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agunus.coinywise.infrastructure.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

  List<UserEntity> findAll();

  Optional<UserEntity> findById(String id);
}
