package com.agunus.coinywise.domain.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.agunus.coinywise.domain.converter.UserConverter;
import com.agunus.coinywise.infrastructure.entity.UserEntity;
import com.agunus.coinywise.infrastructure.repositories.UserRepository;
import com.agunus.coinywise.model.User;
import com.agunus.coinywise.model.UserSignUp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  private final UserConverter userConverter;
  
  public User create(UserSignUp userSignUp) {
    System.out.println("------------------------------");
    System.out.println("request come");
    System.out.println("------------------------------");
    UserEntity entity = new UserEntity();
    entity.setEmail(userSignUp.getEmail());
    entity.setName(userSignUp.getName());
    
    if (!Objects.isNull(userSignUp.getNickname())) {
      entity.setNickname(userSignUp.getNickname());
    }

    UserEntity savedEntity = userRepository.saveAndFlush(entity);
    
    return userConverter.convert(savedEntity);
  }
  
}
