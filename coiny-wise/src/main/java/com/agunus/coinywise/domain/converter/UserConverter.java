package com.agunus.coinywise.domain.converter;

import org.springframework.stereotype.Component;

import com.agunus.coinywise.infrastructure.entity.UserEntity;
import com.agunus.coinywise.model.User;

@Component
public class UserConverter {
  
  public User convert(UserEntity entity) {
    return new User()
    .id(entity.getId())
    .email(entity.getEmail())
    .name(entity.getName())
    .nickname(entity.getNickname());
  }
}
