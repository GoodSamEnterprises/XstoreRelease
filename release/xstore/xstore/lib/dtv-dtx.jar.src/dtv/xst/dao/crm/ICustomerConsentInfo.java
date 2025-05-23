/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerConsentInfo extends IDataModel, IHasDataProperty<ICustomerConsentInfoProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_TERMSANDCONDITIONS = new EventEnum("set termsAndConditions");
/* 16 */   public static final EventEnum SET_CONSENT1TEXT = new EventEnum("set consent1Text");
/* 17 */   public static final EventEnum SET_CONSENT2TEXT = new EventEnum("set consent2Text");
/* 18 */   public static final EventEnum SET_CONSENT3TEXT = new EventEnum("set consent3Text");
/* 19 */   public static final EventEnum SET_CONSENT4TEXT = new EventEnum("set consent4Text");
/* 20 */   public static final EventEnum SET_CONSENT5TEXT = new EventEnum("set consent5Text");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
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
/*    */   String getTermsAndConditions();
/*    */   
/*    */   void setTermsAndConditions(String paramString);
/*    */   
/*    */   String getConsent1Text();
/*    */   
/*    */   void setConsent1Text(String paramString);
/*    */   
/*    */   String getConsent2Text();
/*    */   
/*    */   void setConsent2Text(String paramString);
/*    */   
/*    */   String getConsent3Text();
/*    */   
/*    */   void setConsent3Text(String paramString);
/*    */   
/*    */   String getConsent4Text();
/*    */   
/*    */   void setConsent4Text(String paramString);
/*    */   
/*    */   String getConsent5Text();
/*    */   
/*    */   void setConsent5Text(String paramString);
/*    */   
/*    */   IDataModel getCustomerConsentInfoExt();
/*    */   
/*    */   void setCustomerConsentInfoExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerConsentInfoProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerConsentInfoProperty> paramList);
/*    */   
/*    */   void addCustomerConsentInfoProperty(ICustomerConsentInfoProperty paramICustomerConsentInfoProperty);
/*    */   
/*    */   void removeCustomerConsentInfoProperty(ICustomerConsentInfoProperty paramICustomerConsentInfoProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\ICustomerConsentInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */