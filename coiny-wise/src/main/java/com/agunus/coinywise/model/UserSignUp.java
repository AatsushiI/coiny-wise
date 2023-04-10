package com.agunus.coinywise.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ユーザ登録のリクエスト
 */

@Schema(name = "UserSignUp", description = "ユーザ登録のリクエスト")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-09T07:04:38.204816Z[Etc/UTC]")
public class UserSignUp {

  @JsonProperty("email")
  private String email;

  @JsonProperty("name")
  private String name;

  @JsonProperty("nickname")
  private String nickname;

  @JsonProperty("password")
  private String password;

  public UserSignUp email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * @return email
  */
  
  @Schema(name = "email", example = "test@gmail.com", description = "メールアドレス", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserSignUp name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 会員名
   * @return name
  */
  
  @Schema(name = "name", example = "山田 太郎", description = "会員名", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserSignUp nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * ニックネーム
   * @return nickname
  */
  
  @Schema(name = "nickname", example = "あっくん", description = "ニックネーム", required = false)
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public UserSignUp password(String password) {
    this.password = password;
    return this;
  }

  /**
   * パスワード
   * @return password
  */
  
  @Schema(name = "password", example = "password", description = "パスワード", required = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserSignUp userSignUp = (UserSignUp) o;
    return Objects.equals(this.email, userSignUp.email) &&
        Objects.equals(this.name, userSignUp.name) &&
        Objects.equals(this.nickname, userSignUp.nickname) &&
        Objects.equals(this.password, userSignUp.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name, nickname, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserSignUp {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

