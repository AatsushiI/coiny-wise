package com.agunus.coinywise.infrastructure.entity;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(generator = "ulid-generator")
  @GenericGenerator(name = "ulid-generator", strategy = "com.agunus.coinywise.infrastructure.generator.ULIDGenerator")
  @Column(name="id")
  private String id;

  @Column(name = "email")
  @NotNull
  @Size(max = 255)
  private String email;
  
  @Column(name = "name")
  @NotNull
  @Size(max = 50)
  private String name;
  
  @Column(name = "nickname")
  @Size(max = 50)
  private String nickname;

  @Column(name = "created_at", insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date created_at;

  @Column(name = "updated_at", insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date updated_at;

  @Column(name = "deleted_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deleted_at;

}
