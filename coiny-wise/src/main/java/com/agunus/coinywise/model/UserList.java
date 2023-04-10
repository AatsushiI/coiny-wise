package com.agunus.coinywise.model;

import java.net.URI;
import java.util.Objects;
import com.agunus.coinywise.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserList
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-09T07:04:38.204816Z[Etc/UTC]")
public class UserList {

  @JsonProperty("result")
  @Valid
  private List<User> result = null;

  public UserList result(List<User> result) {
    this.result = result;
    return this;
  }

  public UserList addResultItem(User resultItem) {
    if (this.result == null) {
      this.result = new ArrayList<>();
    }
    this.result.add(resultItem);
    return this;
  }

  /**
   * 会員データのリスト
   * @return result
  */
  @Valid 
  @Schema(name = "result", description = "会員データのリスト", required = false)
  public List<User> getResult() {
    return result;
  }

  public void setResult(List<User> result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserList userList = (UserList) o;
    return Objects.equals(this.result, userList.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserList {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

