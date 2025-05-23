/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemRestrictGS1 extends IDataModel, IHasDataProperty<IItemRestrictGS1Property> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_FIELDID = new EventEnum("set fieldId");
/* 12 */   public static final EventEnum SET_STARTVALUE = new EventEnum("set startValue");
/* 13 */   public static final EventEnum SET_AITYPE = new EventEnum("set aiType");
/* 14 */   public static final EventEnum SET_ENDVALUE = new EventEnum("set endValue");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 18 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 19 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 20 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 21 */   public static final EventEnum SET_RECORDSTATE = new EventEnum("set recordState");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getFieldId();
/*    */   
/*    */   void setFieldId(String paramString);
/*    */   
/*    */   String getStartValue();
/*    */   
/*    */   void setStartValue(String paramString);
/*    */   
/*    */   String getAiType();
/*    */   
/*    */   void setAiType(String paramString);
/*    */   
/*    */   String getEndValue();
/*    */   
/*    */   void setEndValue(String paramString);
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
/*    */   String getRecordState();
/*    */   
/*    */   void setRecordState(String paramString);
/*    */   
/*    */   IDataModel getItemRestrictGS1Ext();
/*    */   
/*    */   void setItemRestrictGS1Ext(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemRestrictGS1Property> getProperties();
/*    */   
/*    */   void setProperties(List<IItemRestrictGS1Property> paramList);
/*    */   
/*    */   void addItemRestrictGS1Property(IItemRestrictGS1Property paramIItemRestrictGS1Property);
/*    */   
/*    */   void removeItemRestrictGS1Property(IItemRestrictGS1Property paramIItemRestrictGS1Property);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemRestrictGS1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */