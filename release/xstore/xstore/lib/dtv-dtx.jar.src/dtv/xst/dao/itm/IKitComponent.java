/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IKitComponent extends IDataModel, IHasDataProperty<IKitComponentProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_KITITEMID = new EventEnum("set kitItemId");
/* 11 */   public static final EventEnum SET_COMPONENTITEMID = new EventEnum("set componentItemId");
/* 12 */   public static final EventEnum SET_SEQUENCENUMBER = new EventEnum("set sequenceNumber");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 18 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 19 */   public static final EventEnum SET_DISPLAYORDER = new EventEnum("set displayOrder");
/* 20 */   public static final EventEnum SET_QUANTITYPERKIT = new EventEnum("set quantityPerKit");
/* 21 */   public static final EventEnum SET_BEGINDATETIME = new EventEnum("set beginDatetime");
/* 22 */   public static final EventEnum SET_ENDDATETIME = new EventEnum("set endDatetime");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getKitItemId();
/*    */   
/*    */   void setKitItemId(String paramString);
/*    */   
/*    */   String getComponentItemId();
/*    */   
/*    */   void setComponentItemId(String paramString);
/*    */   
/*    */   long getSequenceNumber();
/*    */   
/*    */   void setSequenceNumber(long paramLong);
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
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   int getDisplayOrder();
/*    */   
/*    */   void setDisplayOrder(int paramInt);
/*    */   
/*    */   int getQuantityPerKit();
/*    */   
/*    */   void setQuantityPerKit(int paramInt);
/*    */   
/*    */   Date getBeginDatetime();
/*    */   
/*    */   void setBeginDatetime(Date paramDate);
/*    */   
/*    */   Date getEndDatetime();
/*    */   
/*    */   void setEndDatetime(Date paramDate);
/*    */   
/*    */   IDataModel getKitComponentExt();
/*    */   
/*    */   void setKitComponentExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IKitComponentProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IKitComponentProperty> paramList);
/*    */   
/*    */   void addKitComponentProperty(IKitComponentProperty paramIKitComponentProperty);
/*    */   
/*    */   void removeKitComponentProperty(IKitComponentProperty paramIKitComponentProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IKitComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */