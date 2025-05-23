/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPartyCrossReference extends IDataModel, IHasDataProperty<IPartyCrossReferenceProperty> {
/*  9 */   public static final EventEnum SET_CHILDPARTYID = new EventEnum("set childPartyId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_PARENTPARTYID = new EventEnum("set parentPartyId");
/* 12 */   public static final EventEnum SET_PARTYRELATIONSHIPTYPECODE = new EventEnum("set partyRelationshipTypeCode");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 18 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 19 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getChildPartyId();
/*    */   
/*    */   void setChildPartyId(long paramLong);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getParentPartyId();
/*    */   
/*    */   void setParentPartyId(long paramLong);
/*    */   
/*    */   String getPartyRelationshipTypeCode();
/*    */   
/*    */   void setPartyRelationshipTypeCode(String paramString);
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
/*    */   IDataModel getPartyCrossReferenceExt();
/*    */   
/*    */   void setPartyCrossReferenceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPartyCrossReferenceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPartyCrossReferenceProperty> paramList);
/*    */   
/*    */   void addPartyCrossReferenceProperty(IPartyCrossReferenceProperty paramIPartyCrossReferenceProperty);
/*    */   
/*    */   void removePartyCrossReferenceProperty(IPartyCrossReferenceProperty paramIPartyCrossReferenceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IPartyCrossReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */