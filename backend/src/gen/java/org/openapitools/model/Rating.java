/*
 * HealthConnect+
 * HealthConnect+
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: abc@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.*;
import org.bson.Document;

/**
 * Rating
 */
@JsonPropertyOrder({
  Rating.JSON_PROPERTY_RATING_ID,
  Rating.JSON_PROPERTY_DOCTOR_EMAIL,
  Rating.JSON_PROPERTY_RATE,
  Rating.JSON_PROPERTY_USER_EMAIL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-29T22:36:39.223714+05:30[Asia/Kolkata]")
public class Rating   {
  public static final String JSON_PROPERTY_RATING_ID = "rating_id";
  @JsonProperty(JSON_PROPERTY_RATING_ID)
  private String ratingId;

  public static final String JSON_PROPERTY_DOCTOR_EMAIL = "doctor_email";
  @JsonProperty(JSON_PROPERTY_DOCTOR_EMAIL)
  private String doctorEmail;

  /**
   * Gets or Sets rate
   */
  public enum RateEnum {
    NUMBER_1(1),
    
    NUMBER_2(2),
    
    NUMBER_3(3),
    
    NUMBER_4(4),
    
    NUMBER_5(5);

    private Integer value;

    RateEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RateEnum fromValue(Integer value) {
      for (RateEnum b : RateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RATE = "rate";
  @JsonProperty(JSON_PROPERTY_RATE)
  private RateEnum rate;

  public static final String JSON_PROPERTY_USER_EMAIL = "user_email";
  @JsonProperty(JSON_PROPERTY_USER_EMAIL)
  private String userEmail;

  public Rating ratingId(String ratingId) {
    this.ratingId = ratingId;
    return this;
  }

  /**
   * Get ratingId
   * @return ratingId
   **/
  @JsonProperty(value = "rating_id")
  @ApiModelProperty(required = true, value = "")
  @NotNull 
  public String getRatingId() {
    return ratingId;
  }

  public void setRatingId(String ratingId) {
    this.ratingId = ratingId;
  }

  public Rating doctorEmail(String doctorEmail) {
    this.doctorEmail = doctorEmail;
    return this;
  }

  /**
   * Get doctorEmail
   * @return doctorEmail
   **/
  @JsonProperty(value = "doctor_email")
  @ApiModelProperty(required = true, value = "")
  @NotNull 
  public String getDoctorEmail() {
    return doctorEmail;
  }

  public void setDoctorEmail(String doctorEmail) {
    this.doctorEmail = doctorEmail;
  }

  public Rating rate(RateEnum rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
   **/
  @JsonProperty(value = "rate")
  @ApiModelProperty(required = true, value = "")
  @NotNull 
  public RateEnum getRate() {
    return rate;
  }

  public void setRate(RateEnum rate) {
    this.rate = rate;
  }

  public Rating userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * Get userEmail
   * @return userEmail
   **/
  @JsonProperty(value = "user_email")
  @ApiModelProperty(required = true, value = "")
  @NotNull 
  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rating rating = (Rating) o;
    return Objects.equals(ratingId, rating.ratingId) &&
        Objects.equals(doctorEmail, rating.doctorEmail) &&
        Objects.equals(rate, rating.rate) &&
        Objects.equals(userEmail, rating.userEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ratingId, doctorEmail, rate, userEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rating {\n");
    
    sb.append("    ratingId: ").append(toIndentedString(ratingId)).append("\n");
    sb.append("    doctorEmail: ").append(toIndentedString(doctorEmail)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
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

  public boolean isValid() {
    if (this.doctorEmail == null || this.rate == null || this.userEmail == null || this.ratingId == null) {
      return false;
    }
    return true;
  }

  public Document toDocument() {
    return new Document(JSON_PROPERTY_DOCTOR_EMAIL, this.getDoctorEmail().toString())
        .append(JSON_PROPERTY_RATE, this.getRate().toString())
        .append(JSON_PROPERTY_RATING_ID, this.getRatingId().toString())
        .append(JSON_PROPERTY_USER_EMAIL, this.getUserEmail().toString());
  }
}
