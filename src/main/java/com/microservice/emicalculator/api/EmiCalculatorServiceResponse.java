/*
 * EMI Calculator Service API
 * API specification of the EMI calculator microservice.
 *
 * OpenAPI spec version: 1.0
 * Contact: nitish.kashyap44@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.microservice.emicalculator.api;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * EmiCalculatorServiceResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-19T16:46:45.957+05:30[Asia/Calcutta]")
@XmlRootElement(name = "EmiCalculatorServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmiCalculatorServiceResponse {
  @XmlElement(name = "emiCalculatorResponse")
  public static final String SERIALIZED_NAME_EMI_CALCULATOR_RESPONSE = "emiCalculatorResponse";
  @SerializedName(SERIALIZED_NAME_EMI_CALCULATOR_RESPONSE)
  private EmiCalculatorResponse emiCalculatorResponse = null;

  public EmiCalculatorServiceResponse emiCalculatorResponse(EmiCalculatorResponse emiCalculatorResponse) {
    this.emiCalculatorResponse = emiCalculatorResponse;
    return this;
  }

   /**
   * Get emiCalculatorResponse
   * @return emiCalculatorResponse
  **/
  @NotNull
  @Valid
  @ApiModelProperty(required = true, value = "")
  public EmiCalculatorResponse getEmiCalculatorResponse() {
    return emiCalculatorResponse;
  }

  public void setEmiCalculatorResponse(EmiCalculatorResponse emiCalculatorResponse) {
    this.emiCalculatorResponse = emiCalculatorResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmiCalculatorServiceResponse emiCalculatorServiceResponse = (EmiCalculatorServiceResponse) o;
    return Objects.equals(this.emiCalculatorResponse, emiCalculatorServiceResponse.emiCalculatorResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emiCalculatorResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmiCalculatorServiceResponse {\n");
    
    sb.append("    emiCalculatorResponse: ").append(toIndentedString(emiCalculatorResponse)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

