package com.agunus.coinywise.domain.services;

import java.util.List;
import java.util.Objects;

import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Service;

import com.agunus.coinywise.domain.converter.UserConverter;
import com.agunus.coinywise.infrastructure.entity.UserEntity;
import com.agunus.coinywise.infrastructure.repositories.UserRepository;
import com.agunus.coinywise.model.User;
import com.agunus.coinywise.model.UserList;
import com.agunus.coinywise.model.UserSignUp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  private final UserConverter userConverter;

  public UserList getUsers() {
    List<UserEntity> entities  = userRepository.findAll();
    
    return userConverter.convert(entities);
  }

  public User getUser(String Id) {
    UserEntity entity = userRepository.findById(Id).orElse(null);
    if (entity == null) {
      return null;
    }
    return userConverter.convert(entity);
  }
  
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

  public User update(String id, User user) {
    UserEntity entity = userRepository.findById(id).orElse(null);
    if (entity == null) {
      return null;
    }
    
    if (!Objects.isNull(user.getName())) {
      entity.setName(user.getName());
    }
    if (!Objects.isNull(user.getEmail())) {
      entity.setName(user.getEmail());
    }
    if (!Objects.isNull(user.getNickname())) {
      entity.setName(user.getNickname());
    }

    UserEntity savedEntity = userRepository.saveAndFlush(entity);
    return userConverter.convert(savedEntity);
  }

  public void userDelete(String id) {
    UserEntity entity = userRepository.findById(id).orElse(null);
    if (entity != null) {
      userRepository.delete(entity);
    }
  }
  
}
