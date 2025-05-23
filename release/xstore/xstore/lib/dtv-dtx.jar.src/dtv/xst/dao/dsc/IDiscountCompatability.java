/*    */ package dtv.xst.dao.dsc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDiscountCompatability extends IDataModel, IHasDataProperty<IDiscountCompatabilityProperty> {
/*  9 */   public static final EventEnum SET_COMPATIBLEDISCOUNTCODE = new EventEnum("set compatibleDiscountCode");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_PRIMARYDISCOUNTCODE = new EventEnum("set primaryDiscountCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 17 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 18 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 19 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 20 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 21 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getCompatibleDiscountCode();
/*    */   
/*    */   void setCompatibleDiscountCode(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getPrimaryDiscountCode();
/*    */   
/*    */   void setPrimaryDiscountCode(String paramString);
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
/*    */   IDataModel getDiscountCompatabilityExt();
/*    */   
/*    */   void setDiscountCompatabilityExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDiscountCompatabilityProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDiscountCompatabilityProperty> paramList);
/*    */   
/*    */   void addDiscountCompatabilityProperty(IDiscountCompatabilityProperty paramIDiscountCompatabilityProperty);
/*    */   
/*    */   void removeDiscountCompatabilityProperty(IDiscountCompatabilityProperty paramIDiscountCompatabilityProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\IDiscountCompatability.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */