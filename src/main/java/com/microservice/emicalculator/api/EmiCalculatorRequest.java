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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * EmiCalculatorRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-19T16:46:45.957+05:30[Asia/Calcutta]")
@XmlRootElement(name = "EmiCalculatorRequest")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmiCalculatorRequest {
  @XmlElement(name = "loanAmount")
  public static final String SERIALIZED_NAME_LOAN_AMOUNT = "loanAmount";
  @SerializedName(SERIALIZED_NAME_LOAN_AMOUNT)
  private BigDecimal loanAmount;

  @XmlElement(name = "rateOfInterestInPercent")
  public static final String SERIALIZED_NAME_RATE_OF_INTEREST_IN_PERCENT = "rateOfInterestInPercent";
  @SerializedName(SERIALIZED_NAME_RATE_OF_INTEREST_IN_PERCENT)
  private BigDecimal rateOfInterestInPercent;

  @XmlElement(name = "duration")
  public static final String SERIALIZED_NAME_DURATION = "duration";
  @SerializedName(SERIALIZED_NAME_DURATION)
  private Duration duration = null;

  @XmlElement(name = "loanRequestedCurrency")
  public static final String SERIALIZED_NAME_LOAN_REQUESTED_CURRENCY = "loanRequestedCurrency";
  @SerializedName(SERIALIZED_NAME_LOAN_REQUESTED_CURRENCY)
  private String loanRequestedCurrency;

  // Is a container wrapped=false
  // items.name=loanPayableCurrency items.baseName=loanPayableCurrency items.xmlName= items.xmlNamespace=
  // items.example= items.type=String
  @XmlElement(name = "loanPayableCurrency")
  public static final String SERIALIZED_NAME_LOAN_PAYABLE_CURRENCY = "loanPayableCurrency";
  @SerializedName(SERIALIZED_NAME_LOAN_PAYABLE_CURRENCY)
  private List<String> loanPayableCurrency = null;

  @XmlElement(name = "specialCustomer")
  public static final String SERIALIZED_NAME_SPECIAL_CUSTOMER = "specialCustomer";
  @SerializedName(SERIALIZED_NAME_SPECIAL_CUSTOMER)
  private Boolean specialCustomer;

  public EmiCalculatorRequest loanAmount(BigDecimal loanAmount) {
    this.loanAmount = loanAmount;
    return this;
  }

   /**
   * Get loanAmount
   * minimum: 99
   * maximum: 99999999
   * @return loanAmount
  **/
  @NotNull
  @Valid
 @DecimalMin("99") @DecimalMax("99999999")  @ApiModelProperty(example = "50000", required = true, value = "")
  public BigDecimal getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(BigDecimal loanAmount) {
    this.loanAmount = loanAmount;
  }

  public EmiCalculatorRequest rateOfInterestInPercent(BigDecimal rateOfInterestInPercent) {
    this.rateOfInterestInPercent = rateOfInterestInPercent;
    return this;
  }

   /**
   * Get rateOfInterestInPercent
   * minimum: 0.1
   * maximum: 100
   * @return rateOfInterestInPercent
  **/
  @NotNull
  @Valid
 @DecimalMin("0.1") @DecimalMax("100")  @ApiModelProperty(example = "5", required = true, value = "")
  public BigDecimal getRateOfInterestInPercent() {
    return rateOfInterestInPercent;
  }

  public void setRateOfInterestInPercent(BigDecimal rateOfInterestInPercent) {
    this.rateOfInterestInPercent = rateOfInterestInPercent;
  }

  public EmiCalculatorRequest duration(Duration duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  @Valid
  @ApiModelProperty(value = "")
  public Duration getDuration() {
    return duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  public EmiCalculatorRequest loanRequestedCurrency(String loanRequestedCurrency) {
    this.loanRequestedCurrency = loanRequestedCurrency;
    return this;
  }

   /**
   * Get loanRequestedCurrency
   * @return loanRequestedCurrency
  **/
  @NotNull
  @ApiModelProperty(example = "INR", required = true, value = "")
  public String getLoanRequestedCurrency() {
    return loanRequestedCurrency;
  }

  public void setLoanRequestedCurrency(String loanRequestedCurrency) {
    this.loanRequestedCurrency = loanRequestedCurrency;
  }

  public EmiCalculatorRequest loanPayableCurrency(List<String> loanPayableCurrency) {
    this.loanPayableCurrency = loanPayableCurrency;
    return this;
  }

  public EmiCalculatorRequest addLoanPayableCurrencyItem(String loanPayableCurrencyItem) {
    if (this.loanPayableCurrency == null) {
      this.loanPayableCurrency = new ArrayList<>();
    }
    this.loanPayableCurrency.add(loanPayableCurrencyItem);
    return this;
  }

   /**
   * Get loanPayableCurrency
   * @return loanPayableCurrency
  **/
  @ApiModelProperty(example = "[\"EUR\",\"USD\"]", value = "")
  public List<String> getLoanPayableCurrency() {
    return loanPayableCurrency;
  }

  public void setLoanPayableCurrency(List<String> loanPayableCurrency) {
    this.loanPayableCurrency = loanPayableCurrency;
  }

  public EmiCalculatorRequest specialCustomer(Boolean specialCustomer) {
    this.specialCustomer = specialCustomer;
    return this;
  }

   /**
   * Get specialCustomer
   * @return specialCustomer
  **/
  @NotNull
  @ApiModelProperty(required = true, value = "")
  public Boolean getSpecialCustomer() {
    return specialCustomer;
  }

  public void setSpecialCustomer(Boolean specialCustomer) {
    this.specialCustomer = specialCustomer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmiCalculatorRequest emiCalculatorRequest = (EmiCalculatorRequest) o;
    return Objects.equals(this.loanAmount, emiCalculatorRequest.loanAmount) &&
        Objects.equals(this.rateOfInterestInPercent, emiCalculatorRequest.rateOfInterestInPercent) &&
        Objects.equals(this.duration, emiCalculatorRequest.duration) &&
        Objects.equals(this.loanRequestedCurrency, emiCalculatorRequest.loanRequestedCurrency) &&
        Objects.equals(this.loanPayableCurrency, emiCalculatorRequest.loanPayableCurrency) &&
        Objects.equals(this.specialCustomer, emiCalculatorRequest.specialCustomer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loanAmount, rateOfInterestInPercent, duration, loanRequestedCurrency, loanPayableCurrency, specialCustomer);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmiCalculatorRequest {\n");
    
    sb.append("    loanAmount: ").append(toIndentedString(loanAmount)).append("\n");
    sb.append("    rateOfInterestInPercent: ").append(toIndentedString(rateOfInterestInPercent)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    loanRequestedCurrency: ").append(toIndentedString(loanRequestedCurrency)).append("\n");
    sb.append("    loanPayableCurrency: ").append(toIndentedString(loanPayableCurrency)).append("\n");
    sb.append("    specialCustomer: ").append(toIndentedString(specialCustomer)).append("\n");
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
