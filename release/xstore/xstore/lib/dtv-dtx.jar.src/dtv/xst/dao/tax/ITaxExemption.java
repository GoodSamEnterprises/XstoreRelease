/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.com.IAddress;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITaxExemption extends IDataModel, ITaxExemptionModel, IHasDataProperty<ITaxExemptionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TAXEXEMPTIONID = new EventEnum("set taxExemptionId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_CERTIFICATEHOLDERNAME = new EventEnum("set certificateHolderName");
/* 16 */   public static final EventEnum SET_CERTIFICATENBR = new EventEnum("set certificateNbr");
/* 17 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 18 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
/* 19 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 20 */   public static final EventEnum SET_CERTIFICATECOUNTRY = new EventEnum("set certificateCountry");
/* 21 */   public static final EventEnum SET_CERTIFICATESTATE = new EventEnum("set certificateState");
/* 22 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 23 */   public static final EventEnum SET_PHONENUMBER = new EventEnum("set phoneNumber");
/* 24 */   public static final EventEnum SET_REGION = new EventEnum("set region");
/* 25 */   public static final EventEnum SET_DIPLOMATICTITLE = new EventEnum("set diplomaticTitle");
/* 26 */   public static final EventEnum SET_CERTHOLDERFIRSTNAME = new EventEnum("set certHolderFirstName");
/* 27 */   public static final EventEnum SET_CERTHOLDERLASTNAME = new EventEnum("set certHolderLastName");
/* 28 */   public static final EventEnum SET_ADDRESSID = new EventEnum("set addressId");
/* 29 */   public static final EventEnum SET_ADDRESS = new EventEnum("set Address");
/* 30 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 31 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 32 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 33 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 34 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 35 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTaxExemptionId();
/*    */   
/*    */   void setTaxExemptionId(String paramString);
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
/*    */   String getCertificateHolderName();
/*    */   
/*    */   void setCertificateHolderName(String paramString);
/*    */   
/*    */   String getCertificateNbr();
/*    */   
/*    */   void setCertificateNbr(String paramString);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   String getCertificateCountry();
/*    */   
/*    */   void setCertificateCountry(String paramString);
/*    */   
/*    */   String getCertificateState();
/*    */   
/*    */   void setCertificateState(String paramString);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   String getPhoneNumber();
/*    */   
/*    */   void setPhoneNumber(String paramString);
/*    */   
/*    */   String getRegion();
/*    */   
/*    */   void setRegion(String paramString);
/*    */   
/*    */   String getDiplomaticTitle();
/*    */   
/*    */   void setDiplomaticTitle(String paramString);
/*    */   
/*    */   String getCertHolderFirstName();
/*    */   
/*    */   void setCertHolderFirstName(String paramString);
/*    */   
/*    */   String getCertHolderLastName();
/*    */   
/*    */   void setCertHolderLastName(String paramString);
/*    */   
/*    */   String getAddressId();
/*    */   
/*    */   void setAddressId(String paramString);
/*    */   
/*    */   IDataModel getTaxExemptionExt();
/*    */   
/*    */   void setTaxExemptionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IAddress getAddress();
/*    */   
/*    */   void setAddress(IAddress paramIAddress);
/*    */   
/*    */   List<ITaxExemptionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITaxExemptionProperty> paramList);
/*    */   
/*    */   void addTaxExemptionProperty(ITaxExemptionProperty paramITaxExemptionProperty);
/*    */   
/*    */   void removeTaxExemptionProperty(ITaxExemptionProperty paramITaxExemptionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxExemption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */