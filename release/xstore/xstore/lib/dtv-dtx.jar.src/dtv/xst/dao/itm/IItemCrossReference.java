/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemCrossReference extends IDataModel, IHasDataProperty<IItemCrossReferenceProperty> {
/*  9 */   public static final EventEnum SET_MANUFACTURERUPC = new EventEnum("set manufacturerUpc");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_MANUFACTURER = new EventEnum("set manufacturer");
/* 18 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 19 */   public static final EventEnum SET_PRIMARYFLAG = new EventEnum("set primaryFlag");
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
/*    */   String getManufacturerUpc();
/*    */   
/*    */   void setManufacturerUpc(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   String getManufacturer();
/*    */   
/*    */   void setManufacturer(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   boolean getPrimaryFlag();
/*    */   
/*    */   void setPrimaryFlag(boolean paramBoolean);
/*    */   
/*    */   IDataModel getItemCrossReferenceExt();
/*    */   
/*    */   void setItemCrossReferenceExt(IDataModel paramIDataModel);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   List<IItemCrossReferenceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemCrossReferenceProperty> paramList);
/*    */   
/*    */   void addItemCrossReferenceProperty(IItemCrossReferenceProperty paramIItemCrossReferenceProperty);
/*    */   
/*    */   void removeItemCrossReferenceProperty(IItemCrossReferenceProperty paramIItemCrossReferenceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemCrossReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */