/*    */ package dtv.xst.dao.tnd;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderType extends IDataModel, ITenderTypeModel, IHasDataProperty<ITenderTypeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypecode");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 16 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 17 */   public static final EventEnum SET_UNITCOUNTCODE = new EventEnum("set unitCountCode");
/* 18 */   public static final EventEnum SET_CLOSECOUNTDISCREPANCYTHRESHOLD = new EventEnum("set closeCountDiscrepancyThreshold");
/* 19 */   public static final EventEnum SET_HIDDEN = new EventEnum("set hidden");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTenderTypecode();
/*    */   
/*    */   void setTenderTypecode(String paramString);
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
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getUnitCountCode();
/*    */   
/*    */   void setUnitCountCode(String paramString);
/*    */   
/*    */   BigDecimal getCloseCountDiscrepancyThreshold();
/*    */   
/*    */   void setCloseCountDiscrepancyThreshold(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getHidden();
/*    */   
/*    */   void setHidden(boolean paramBoolean);
/*    */   
/*    */   IDataModel getTenderTypeExt();
/*    */   
/*    */   void setTenderTypeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderTypeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderTypeProperty> paramList);
/*    */   
/*    */   void addTenderTypeProperty(ITenderTypeProperty paramITenderTypeProperty);
/*    */   
/*    */   void removeTenderTypeProperty(ITenderTypeProperty paramITenderTypeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\ITenderType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */