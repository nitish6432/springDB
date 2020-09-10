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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * EmiDetails
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-19T16:46:45.957+05:30[Asia/Calcutta]")
@XmlRootElement(name = "EmiDetails")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmiDetails {
  // Is a container wrapped=false
  // items.name=emi items.baseName=emi items.xmlName= items.xmlNamespace=
  // items.example= items.type=EMI
  @XmlElement(name = "emi")
  public static final String SERIALIZED_NAME_EMI = "emi";
  @SerializedName(SERIALIZED_NAME_EMI)
  private List<EMI> emi = null;

  public EmiDetails emi(List<EMI> emi) {
    this.emi = emi;
    return this;
  }

  public EmiDetails addEmiItem(EMI emiItem) {
    if (this.emi == null) {
      this.emi = new ArrayList<>();
    }
    this.emi.add(emiItem);
    return this;
  }

   /**
   * Get emi
   * @return emi
  **/
  @Valid
  @ApiModelProperty(value = "")
  public List<EMI> getEmi() {
    return emi;
  }

  public void setEmi(List<EMI> emi) {
    this.emi = emi;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmiDetails emiDetails = (EmiDetails) o;
    return Objects.equals(this.emi, emiDetails.emi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emi);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmiDetails {\n");
    
    sb.append("    emi: ").append(toIndentedString(emi)).append("\n");
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
