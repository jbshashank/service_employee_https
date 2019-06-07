package com.ayushya.spring.bean;

public class BusinessClientContactDetails
{
  private String contactName;
  private String contactEmailAddress;
  private String contactLandline;
  private String contactMobile;
  private String contactDesignation;

  public BusinessClientContactDetails()
  {

  }

  public BusinessClientContactDetails(String contactName,
                                      String contactEmailAddress,
                                      String contactLandline,
                                      String contactMobile,
                                      String contactDesignation)
  {
    super();
    this.contactName = contactName;
    this.contactEmailAddress = contactEmailAddress;
    this.contactLandline = contactLandline;
    this.contactMobile = contactMobile;
    this.contactDesignation = contactDesignation;
  }

  public String getContactName()
  {
    return contactName;
  }

  public void setContactName(String contactName)
  {
    this.contactName = contactName;
  }

  public String getContactEmailAddress()
  {
    return contactEmailAddress;
  }

  public void setContactEmailAddress(String contactEmailAddress)
  {
    this.contactEmailAddress = contactEmailAddress;
  }

  public String getContactLandline()
  {
    return contactLandline;
  }

  public void setContactLandline(String contactLandline)
  {
    this.contactLandline = contactLandline;
  }

  public String getContactMobile()
  {
    return contactMobile;
  }

  public void setContactMobile(String contactMobile)
  {
    this.contactMobile = contactMobile;
  }

  public String getContactDesignation()
  {
    return contactDesignation;
  }

  public void setContactDesignation(String contactDesignation)
  {
    this.contactDesignation = contactDesignation;
  }

}
