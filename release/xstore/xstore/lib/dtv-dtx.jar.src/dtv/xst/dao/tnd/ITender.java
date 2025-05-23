/*    */ package dtv.xst.dao.tnd;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITender extends IDataModel, ITenderModel, IHasDataProperty<ITenderProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_CURRENCYID = new EventEnum("set currencyId");
/* 16 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 17 */   public static final EventEnum SET_DISPLAYORDER = new EventEnum("set displayOrder");
/* 18 */   public static final EventEnum SET_FLASHSALESDISPLAYORDER = new EventEnum("set flashSalesDisplayOrder");
/* 19 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypecode");
/* 20 */   public static final EventEnum SET_DISABLED = new EventEnum("set disabled");
/* 21 */   public static final EventEnum ADD_TENDEROPTIONS = new EventEnum("add TenderOptions");
/* 22 */   public static final EventEnum REMOVE_TENDEROPTIONS = new EventEnum("remove TenderOptions");
/* 23 */   public static final EventEnum SET_TENDEROPTIONS = new EventEnum("set TenderOptions");
/* 24 */   public static final EventEnum ADD_TENDERAVAILABILITYCODES = new EventEnum("add TenderAvailabilityCodes");
/* 25 */   public static final EventEnum REMOVE_TENDERAVAILABILITYCODES = new EventEnum("remove TenderAvailabilityCodes");
/* 26 */   public static final EventEnum SET_TENDERAVAILABILITYCODES = new EventEnum("set TenderAvailabilityCodes");
/* 27 */   public static final EventEnum ADD_TENDERDENOMINATIONS = new EventEnum("add TenderDenominations");
/* 28 */   public static final EventEnum REMOVE_TENDERDENOMINATIONS = new EventEnum("remove TenderDenominations");
/* 29 */   public static final EventEnum SET_TENDERDENOMINATIONS = new EventEnum("set TenderDenominations");
/* 30 */   public static final EventEnum SET_TENDERTYPE = new EventEnum("set TenderType");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
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
/*    */   String getCurrencyId();
/*    */   
/*    */   void setCurrencyId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   int getDisplayOrder();
/*    */   
/*    */   void setDisplayOrder(int paramInt);
/*    */   
/*    */   int getFlashSalesDisplayOrder();
/*    */   
/*    */   void setFlashSalesDisplayOrder(int paramInt);
/*    */   
/*    */   String getTenderTypecode();
/*    */   
/*    */   void setTenderTypecode(String paramString);
/*    */   
/*    */   boolean getDisabled();
/*    */   
/*    */   void setDisabled(boolean paramBoolean);
/*    */   
/*    */   IDataModel getTenderExt();
/*    */   
/*    */   void setTenderExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderAvailability> getTenderAvailabilityCodes();
/*    */   
/*    */   void setTenderAvailabilityCodes(List<ITenderAvailability> paramList);
/*    */   
/*    */   void addTenderAvailability(ITenderAvailability paramITenderAvailability);
/*    */   
/*    */   void removeTenderAvailability(ITenderAvailability paramITenderAvailability);
/*    */   
/*    */   List<ITenderDenomination> getTenderDenominations();
/*    */   
/*    */   void setTenderDenominations(List<ITenderDenomination> paramList);
/*    */   
/*    */   void addTenderDenomination(ITenderDenomination paramITenderDenomination);
/*    */   
/*    */   void removeTenderDenomination(ITenderDenomination paramITenderDenomination);
/*    */   
/*    */   ITenderType getTenderType();
/*    */   
/*    */   void setTenderType(ITenderType paramITenderType);
/*    */   
/*    */   List<ITenderProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderProperty> paramList);
/*    */   
/*    */   void addTenderProperty(ITenderProperty paramITenderProperty);
/*    */   
/*    */   void removeTenderProperty(ITenderProperty paramITenderProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\ITender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */