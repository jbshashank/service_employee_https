package com.ayushya.spring.bean;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document(collection = "businessClient_details")
public class BusinessClient extends BaseEntity
{
  private String clientCode;
  private String clientName;
  private String clientAddress;
  private String clientCountry;
  private String clientState;
  private String clientCity;
  private String clientPinCode;

  private List<BusinessClientContactDetails> businessClientContactDetails;

  public BusinessClient()
  {

  }

  public BusinessClient(String clientCode,
                        String clientName,
                        String clientAddress,
                        String clientCountry,
                        String clientState,
                        String clientCity,
                        String clientPinCode,
                        List<BusinessClientContactDetails> businessClientContactDetails)
  {

    this.clientCode = clientCode;
    this.clientName = clientName;
    this.clientAddress = clientAddress;
    this.clientCountry = clientCountry;
    this.clientState = clientState;
    this.clientCity = clientCity;
    this.clientPinCode = clientPinCode;
    this.businessClientContactDetails = businessClientContactDetails;

  }

  public String getClientCode()
  {
    return clientCode;
  }

  public void setClientCode(String clientCode)
  {
    this.clientCode = clientCode;
  }

  public String getClientName()
  {
    return clientName;
  }

  public void setClientName(String clientName)
  {
    this.clientName = clientName;
  }

  public String getClientAddress()
  {
    return clientAddress;
  }

  public void setClientAddress(String clientAddress)
  {
    this.clientAddress = clientAddress;
  }

  public String getClientCountry()
  {
    return clientCountry;
  }

  public void setClientCountry(String clientCountry)
  {
    this.clientCountry = clientCountry;
  }

  public String getClientState()
  {
    return clientState;
  }

  public void setClientState(String clientState)
  {
    this.clientState = clientState;
  }

  public String getClientCity()
  {
    return clientCity;
  }

  public void setClientCity(String clientCity)
  {
    this.clientCity = clientCity;
  }

  public String getClientPinCode()
  {
    return clientPinCode;
  }

  public void setClientPinCode(String clientPinCode)
  {
    this.clientPinCode = clientPinCode;
  }

  public List<BusinessClientContactDetails> getBusinessClientContactDetails()
  {
    return businessClientContactDetails;
  }

  public void setBusinessClientContactDetails(List<BusinessClientContactDetails> businessClientContactDetails)
  {
    this.businessClientContactDetails = businessClientContactDetails;
  }

}
