/*
 * HealthConnect+ HealthConnect+
 *
 * The version of the OpenAPI document: 1.0.0 Contact: abc@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech Do not edit the class manually.
 */


package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.*;
import org.bson.Document;

/**
 * AppointmentDetails
 */
@JsonPropertyOrder({AppointmentDetails.JSON_PROPERTY_APPOINTMENT_ID,
    AppointmentDetails.JSON_PROPERTY_DOCTOR_EMAIL, AppointmentDetails.JSON_PROPERTY_USER_EMAIL,
    AppointmentDetails.JSON_PROPERTY_DATE, AppointmentDetails.JSON_PROPERTY_TIME})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
    date = "2023-08-31T14:23:42.183723+05:30[Asia/Kolkata]")
public class AppointmentDetails {
  public static final String JSON_PROPERTY_APPOINTMENT_ID = "appointment_id";
  @JsonProperty(JSON_PROPERTY_APPOINTMENT_ID)
  private String appointmentId;

  public static final String JSON_PROPERTY_DOCTOR_EMAIL = "doctor_email";
  @JsonProperty(JSON_PROPERTY_DOCTOR_EMAIL)
  private String doctorEmail;

  public static final String JSON_PROPERTY_USER_EMAIL = "user_email";
  @JsonProperty(JSON_PROPERTY_USER_EMAIL)
  private String userEmail;

  public static final String JSON_PROPERTY_DATE = "date";
  @JsonProperty(JSON_PROPERTY_DATE)
  private String date;

  public static final String JSON_PROPERTY_TIME = "time";
  @JsonProperty(JSON_PROPERTY_TIME)
  private String time;

  public AppointmentDetails appointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
    return this;
  }

  /**
   * Get appointmentId
   * 
   * @return appointmentId
   **/
  @JsonProperty(value = "appointment_id")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
  }

  public AppointmentDetails doctorEmail(String doctorEmail) {
    this.doctorEmail = doctorEmail;
    return this;
  }

  /**
   * Get doctorEmail
   * 
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

  public AppointmentDetails userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * Get userEmail
   * 
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

  public AppointmentDetails date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * 
   * @return date
   **/
  @JsonProperty(value = "date")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public AppointmentDetails time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * 
   * @return time
   **/
  @JsonProperty(value = "time")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppointmentDetails appointmentDetails = (AppointmentDetails) o;
    return Objects.equals(appointmentId, appointmentDetails.appointmentId)
        && Objects.equals(doctorEmail, appointmentDetails.doctorEmail)
        && Objects.equals(userEmail, appointmentDetails.userEmail)
        && Objects.equals(date, appointmentDetails.date)
        && Objects.equals(time, appointmentDetails.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appointmentId, doctorEmail, userEmail, date, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppointmentDetails {\n");

    sb.append("    appointmentId: ").append(toIndentedString(appointmentId)).append("\n");
    sb.append("    doctorEmail: ").append(toIndentedString(doctorEmail)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public boolean isValid() {
    if (this.date == null || this.doctorEmail == null || this.time == null || this.userEmail == null
        || this.getAppointmentId() == null) {
      return false;
    }
    return true;
  }

  public Document toDocument() {
    return new Document(JSON_PROPERTY_DOCTOR_EMAIL, this.getDoctorEmail().toString())
        .append(JSON_PROPERTY_USER_EMAIL, this.getUserEmail().toString())
        .append(JSON_PROPERTY_DATE, this.getDate().toString())
        .append(JSON_PROPERTY_TIME, this.getTime().toString())
        .append(JSON_PROPERTY_APPOINTMENT_ID, this.getAppointmentId().toString());
  }
}
