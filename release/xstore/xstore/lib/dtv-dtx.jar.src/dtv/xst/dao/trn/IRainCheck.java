/*    */ package dtv.xst.dao.trn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.itm.IItem;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IRainCheck extends IDataModel, IRainCheckModel, IHasDataProperty<IRainCheckProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RAINCHECKID = new EventEnum("set rainCheckId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 16 */   public static final EventEnum SET_SALEPRICE = new EventEnum("set salePrice");
/* 17 */   public static final EventEnum SET_EXPIRATIONBUSINESSDATE = new EventEnum("set expirationBusinessDate");
/* 18 */   public static final EventEnum SET_REDEEMEDFLAG = new EventEnum("set redeemedFlag");
/* 19 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 20 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
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
/*    */   String getRainCheckId();
/*    */   
/*    */   void setRainCheckId(String paramString);
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
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   BigDecimal getSalePrice();
/*    */   
/*    */   void setSalePrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getExpirationBusinessDate();
/*    */   
/*    */   void setExpirationBusinessDate(Date paramDate);
/*    */   
/*    */   boolean getRedeemedFlag();
/*    */   
/*    */   void setRedeemedFlag(boolean paramBoolean);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   IDataModel getRainCheckExt();
/*    */   
/*    */   void setRainCheckExt(IDataModel paramIDataModel);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   List<IRainCheckProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IRainCheckProperty> paramList);
/*    */   
/*    */   void addRainCheckProperty(IRainCheckProperty paramIRainCheckProperty);
/*    */   
/*    */   void removeRainCheckProperty(IRainCheckProperty paramIRainCheckProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IRainCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */