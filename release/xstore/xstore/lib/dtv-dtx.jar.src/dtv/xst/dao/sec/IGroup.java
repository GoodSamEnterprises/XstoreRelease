/*    */ package dtv.xst.dao.sec;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IGroup extends IDataModel, IHasDataProperty<IGroupProperty> {
/*  9 */   public static final EventEnum SET_GROUPID = new EventEnum("set groupId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 16 */   public static final EventEnum SET_BITMAPPOSITION = new EventEnum("set bitmapPosition");
/* 17 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 18 */   public static final EventEnum SET_GROUPRANK = new EventEnum("set groupRank");
/* 19 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 20 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 21 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getGroupId();
/*    */   
/*    */   void setGroupId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
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
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
/*    */   
/*    */   int getBitmapPosition();
/*    */   
/*    */   void setBitmapPosition(int paramInt);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   int getGroupRank();
/*    */   
/*    */   void setGroupRank(int paramInt);
/*    */   
/*    */   IDataModel getGroupExt();
/*    */   
/*    */   void setGroupExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IGroupProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IGroupProperty> paramList);
/*    */   
/*    */   void addGroupProperty(IGroupProperty paramIGroupProperty);
/*    */   
/*    */   void removeGroupProperty(IGroupProperty paramIGroupProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */