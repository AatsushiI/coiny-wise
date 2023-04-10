package com.agunus.coinywise.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.agunus.coinywise.infrastructure.entity.UserEntity;
import com.agunus.coinywise.model.User;
import com.agunus.coinywise.model.UserList;

@Component
public class UserConverter {

  public UserList convert(List<UserEntity> entities) {
    if (entities == null) {
      return null;
    }

    return new UserList()
    .result(convertList(entities));
  }

  public List<User> convertList(List<UserEntity> entities) {
    if (entities == null) {
      return null;
    }

    List<User> users = new ArrayList<>();
    for (UserEntity entity : entities) {
      users.add(convert(entity));
    }
    return users;
  }
   
  public User convert(UserEntity entity) {
    return new User()
    .id(entity.getId())
    .email(entity.getEmail())
    .name(entity.getName())
    .nickname(entity.getNickname());
  }
}
