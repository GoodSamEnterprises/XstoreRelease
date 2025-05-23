/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IParty extends IDataModel, IPartyModel, IHasDataProperty<IPartyProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ALLEGIANCERETAILLOCATIONID = new EventEnum("set allegianceRetailLocationId");
/* 16 */   public static final EventEnum SET_BIRTHDATE = new EventEnum("set birthDate");
/* 17 */   public static final EventEnum SET_CUSTOMERID = new EventEnum("set customerId");
/* 18 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 19 */   public static final EventEnum SET_NATIONALTAXID = new EventEnum("set nationalTaxId");
/* 20 */   public static final EventEnum SET_FIRSTNAME = new EventEnum("set firstName");
/* 21 */   public static final EventEnum SET_FIRSTNAME2 = new EventEnum("set firstName2");
/* 22 */   public static final EventEnum SET_GENDER = new EventEnum("set gender");
/* 23 */   public static final EventEnum SET_LASTNAME = new EventEnum("set lastName");
/* 24 */   public static final EventEnum SET_LASTNAME2 = new EventEnum("set lastName2");
/* 25 */   public static final EventEnum SET_MIDDLENAME = new EventEnum("set middleName");
/* 26 */   public static final EventEnum SET_PREFERREDLOCALE = new EventEnum("set preferredLocale");
/* 27 */   public static final EventEnum SET_ORGANIZATIONNAME = new EventEnum("set organizationName");
/* 28 */   public static final EventEnum SET_ORGANIZATIONTYPECODE = new EventEnum("set organizationTypeCode");
/* 29 */   public static final EventEnum SET_PARTYTYPECODE = new EventEnum("set partyTypeCode");
/* 30 */   public static final EventEnum SET_PICTUREURI = new EventEnum("set pictureUri");
/* 31 */   public static final EventEnum SET_SALUTATION = new EventEnum("set salutation");
/* 32 */   public static final EventEnum SET_SIGNUPRETAILLOCATIONID = new EventEnum("set signUpRetailLocationId");
/* 33 */   public static final EventEnum SET_SOCIALSECURITYNBR = new EventEnum("set socialSecurityNbr");
/* 34 */   public static final EventEnum SET_PERSONALTAXID = new EventEnum("set personalTaxId");
/* 35 */   public static final EventEnum SET_SUFFIX = new EventEnum("set suffix");
/* 36 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 37 */   public static final EventEnum SET_ACTIVE = new EventEnum("set active");
/* 38 */   public static final EventEnum SET_EMAILRCPTS = new EventEnum("set emailRcpts");
/* 39 */   public static final EventEnum SET_ANNIVERSARYDATE = new EventEnum("set anniversaryDate");
/* 40 */   public static final EventEnum SET_PROSPECT = new EventEnum("set prospect");
/* 41 */   public static final EventEnum SET_RENT = new EventEnum("set rent");
/* 42 */   public static final EventEnum SET_PRIVACYCARD = new EventEnum("set privacyCard");
/* 43 */   public static final EventEnum SET_COMMERCIALCUSTOMER = new EventEnum("set commercialCustomer");
/* 44 */   public static final EventEnum SET_CONTACTPREF = new EventEnum("set contactPref");
/* 45 */   public static final EventEnum ADD_ALTERNATEPARTYIDS = new EventEnum("add AlternatePartyIds");
/* 46 */   public static final EventEnum REMOVE_ALTERNATEPARTYIDS = new EventEnum("remove AlternatePartyIds");
/* 47 */   public static final EventEnum SET_ALTERNATEPARTYIDS = new EventEnum("set AlternatePartyIds");
/* 48 */   public static final EventEnum ADD_CUSTOMERGROUPS = new EventEnum("add CustomerGroups");
/* 49 */   public static final EventEnum REMOVE_CUSTOMERGROUPS = new EventEnum("remove CustomerGroups");
/* 50 */   public static final EventEnum SET_CUSTOMERGROUPS = new EventEnum("set CustomerGroups");
/* 51 */   public static final EventEnum ADD_LOCALEINFORMATION = new EventEnum("add LocaleInformation");
/* 52 */   public static final EventEnum REMOVE_LOCALEINFORMATION = new EventEnum("remove LocaleInformation");
/* 53 */   public static final EventEnum SET_LOCALEINFORMATION = new EventEnum("set LocaleInformation");
/* 54 */   public static final EventEnum ADD_TELEPHONEINFORMATION = new EventEnum("add TelephoneInformation");
/* 55 */   public static final EventEnum REMOVE_TELEPHONEINFORMATION = new EventEnum("remove TelephoneInformation");
/* 56 */   public static final EventEnum SET_TELEPHONEINFORMATION = new EventEnum("set TelephoneInformation");
/* 57 */   public static final EventEnum ADD_EMAILINFORMATION = new EventEnum("add EmailInformation");
/* 58 */   public static final EventEnum REMOVE_EMAILINFORMATION = new EventEnum("remove EmailInformation");
/* 59 */   public static final EventEnum SET_EMAILINFORMATION = new EventEnum("set EmailInformation");
/* 60 */   public static final EventEnum ADD_LOYALTYCARDS = new EventEnum("add LoyaltyCards");
/* 61 */   public static final EventEnum REMOVE_LOYALTYCARDS = new EventEnum("remove LoyaltyCards");
/* 62 */   public static final EventEnum SET_LOYALTYCARDS = new EventEnum("set LoyaltyCards");
/* 63 */   public static final EventEnum ADD_CUSTOMERNOTES = new EventEnum("add CustomerNotes");
/* 64 */   public static final EventEnum REMOVE_CUSTOMERNOTES = new EventEnum("remove CustomerNotes");
/* 65 */   public static final EventEnum SET_CUSTOMERNOTES = new EventEnum("set CustomerNotes");
/* 66 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 67 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 68 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 69 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 70 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 71 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   long getAllegianceRetailLocationId();
/*    */   
/*    */   void setAllegianceRetailLocationId(long paramLong);
/*    */   
/*    */   Date getBirthDate();
/*    */   
/*    */   void setBirthDate(Date paramDate);
/*    */   
/*    */   String getCustomerId();
/*    */   
/*    */   void setCustomerId(String paramString);
/*    */   
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
/*    */   
/*    */   String getNationalTaxId();
/*    */   
/*    */   void setNationalTaxId(String paramString);
/*    */   
/*    */   String getFirstName();
/*    */   
/*    */   void setFirstName(String paramString);
/*    */   
/*    */   String getFirstName2();
/*    */   
/*    */   void setFirstName2(String paramString);
/*    */   
/*    */   String getGender();
/*    */   
/*    */   void setGender(String paramString);
/*    */   
/*    */   String getLastName();
/*    */   
/*    */   void setLastName(String paramString);
/*    */   
/*    */   String getLastName2();
/*    */   
/*    */   void setLastName2(String paramString);
/*    */   
/*    */   String getMiddleName();
/*    */   
/*    */   void setMiddleName(String paramString);
/*    */   
/*    */   String getPreferredLocale();
/*    */   
/*    */   void setPreferredLocale(String paramString);
/*    */   
/*    */   String getOrganizationName();
/*    */   
/*    */   void setOrganizationName(String paramString);
/*    */   
/*    */   String getOrganizationTypeCode();
/*    */   
/*    */   void setOrganizationTypeCode(String paramString);
/*    */   
/*    */   String getPartyTypeCode();
/*    */   
/*    */   void setPartyTypeCode(String paramString);
/*    */   
/*    */   String getPictureUri();
/*    */   
/*    */   void setPictureUri(String paramString);
/*    */   
/*    */   String getSalutation();
/*    */   
/*    */   void setSalutation(String paramString);
/*    */   
/*    */   long getSignUpRetailLocationId();
/*    */   
/*    */   void setSignUpRetailLocationId(long paramLong);
/*    */   
/*    */   String getSocialSecurityNbr();
/*    */   
/*    */   void setSocialSecurityNbr(String paramString);
/*    */   
/*    */   String getSocialSecurityNbrEncrypted();
/*    */   
/*    */   String getPersonalTaxId();
/*    */   
/*    */   void setPersonalTaxId(String paramString);
/*    */   
/*    */   String getSuffix();
/*    */   
/*    */   void setSuffix(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   boolean getActive();
/*    */   
/*    */   void setActive(boolean paramBoolean);
/*    */   
/*    */   boolean getEmailRcpts();
/*    */   
/*    */   void setEmailRcpts(boolean paramBoolean);
/*    */   
/*    */   Date getAnniversaryDate();
/*    */   
/*    */   void setAnniversaryDate(Date paramDate);
/*    */   
/*    */   boolean getProspect();
/*    */   
/*    */   void setProspect(boolean paramBoolean);
/*    */   
/*    */   boolean getRent();
/*    */   
/*    */   void setRent(boolean paramBoolean);
/*    */   
/*    */   boolean getPrivacyCard();
/*    */   
/*    */   void setPrivacyCard(boolean paramBoolean);
/*    */   
/*    */   boolean getCommercialCustomer();
/*    */   
/*    */   void setCommercialCustomer(boolean paramBoolean);
/*    */   
/*    */   String getContactPref();
/*    */   
/*    */   void setContactPref(String paramString);
/*    */   
/*    */   IDataModel getPartyExt();
/*    */   
/*    */   void setPartyExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPartyIdCrossReference> getAlternatePartyIds();
/*    */   
/*    */   void setAlternatePartyIds(List<IPartyIdCrossReference> paramList);
/*    */   
/*    */   void addPartyIdCrossReference(IPartyIdCrossReference paramIPartyIdCrossReference);
/*    */   
/*    */   void removePartyIdCrossReference(IPartyIdCrossReference paramIPartyIdCrossReference);
/*    */   
/*    */   List<ICustomerAffiliation> getCustomerGroups();
/*    */   
/*    */   void setCustomerGroups(List<ICustomerAffiliation> paramList);
/*    */   
/*    */   void addCustomerAffiliation(ICustomerAffiliation paramICustomerAffiliation);
/*    */   
/*    */   void removeCustomerAffiliation(ICustomerAffiliation paramICustomerAffiliation);
/*    */   
/*    */   List<IPartyLocaleInformation> getLocaleInformation();
/*    */   
/*    */   void setLocaleInformation(List<IPartyLocaleInformation> paramList);
/*    */   
/*    */   void addPartyLocaleInformation(IPartyLocaleInformation paramIPartyLocaleInformation);
/*    */   
/*    */   void removePartyLocaleInformation(IPartyLocaleInformation paramIPartyLocaleInformation);
/*    */   
/*    */   List<IPartyTelephone> getTelephoneInformation();
/*    */   
/*    */   void setTelephoneInformation(List<IPartyTelephone> paramList);
/*    */   
/*    */   void addPartyTelephone(IPartyTelephone paramIPartyTelephone);
/*    */   
/*    */   void removePartyTelephone(IPartyTelephone paramIPartyTelephone);
/*    */   
/*    */   List<IPartyEmail> getEmailInformation();
/*    */   
/*    */   void setEmailInformation(List<IPartyEmail> paramList);
/*    */   
/*    */   void addPartyEmail(IPartyEmail paramIPartyEmail);
/*    */   
/*    */   void removePartyEmail(IPartyEmail paramIPartyEmail);
/*    */   
/*    */   List<ICustomerLoyaltyCard> getLoyaltyCards();
/*    */   
/*    */   void setLoyaltyCards(List<ICustomerLoyaltyCard> paramList);
/*    */   
/*    */   void addCustomerLoyaltyCard(ICustomerLoyaltyCard paramICustomerLoyaltyCard);
/*    */   
/*    */   void removeCustomerLoyaltyCard(ICustomerLoyaltyCard paramICustomerLoyaltyCard);
/*    */   
/*    */   List<ICustomerNote> getCustomerNotes();
/*    */   
/*    */   void setCustomerNotes(List<ICustomerNote> paramList);
/*    */   
/*    */   void addCustomerNote(ICustomerNote paramICustomerNote);
/*    */   
/*    */   void removeCustomerNote(ICustomerNote paramICustomerNote);
/*    */   
/*    */   List<IPartyProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPartyProperty> paramList);
/*    */   
/*    */   void addPartyProperty(IPartyProperty paramIPartyProperty);
/*    */   
/*    */   void removePartyProperty(IPartyProperty paramIPartyProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IParty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */