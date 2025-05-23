/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ILineItemAssociationTypeCode extends IDataModel, IHasDataProperty<ILineItemAssociationTypeCodeProperty> {
/*  9 */   public static final EventEnum SET_LINEITEMASSOCIATIONTYPECODE = new EventEnum("set lineItemAssociationTypeCode");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_CASCADEDELETE = new EventEnum("set cascadeDelete");
/* 16 */   public static final EventEnum SET_CASCADEQUANTITY = new EventEnum("set cascadeQuantity");
/* 17 */   public static final EventEnum SET_CHILDRESTRICTDELETE = new EventEnum("set childRestrictDelete");
/* 18 */   public static final EventEnum SET_CHILDRESTRICTPRICE = new EventEnum("set childRestrictPrice");
/* 19 */   public static final EventEnum SET_CHILDRESTRICTQUANTITY = new EventEnum("set childRestrictQuantity");
/* 20 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 21 */   public static final EventEnum SET_PARENTRESTRICTDELETE = new EventEnum("set parentRestrictDelete");
/* 22 */   public static final EventEnum SET_PARENTRESTRICTPRICE = new EventEnum("set parentRestrictPrice");
/* 23 */   public static final EventEnum SET_PARENTRESTRICTQUANTITY = new EventEnum("set parentRestrictQuantity");
/* 24 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getLineItemAssociationTypeCode();
/*    */   
/*    */   void setLineItemAssociationTypeCode(String paramString);
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
/*    */   boolean getCascadeDelete();
/*    */   
/*    */   void setCascadeDelete(boolean paramBoolean);
/*    */   
/*    */   boolean getCascadeQuantity();
/*    */   
/*    */   void setCascadeQuantity(boolean paramBoolean);
/*    */   
/*    */   boolean getChildRestrictDelete();
/*    */   
/*    */   void setChildRestrictDelete(boolean paramBoolean);
/*    */   
/*    */   boolean getChildRestrictPrice();
/*    */   
/*    */   void setChildRestrictPrice(boolean paramBoolean);
/*    */   
/*    */   boolean getChildRestrictQuantity();
/*    */   
/*    */   void setChildRestrictQuantity(boolean paramBoolean);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   boolean getParentRestrictDelete();
/*    */   
/*    */   void setParentRestrictDelete(boolean paramBoolean);
/*    */   
/*    */   boolean getParentRestrictPrice();
/*    */   
/*    */   void setParentRestrictPrice(boolean paramBoolean);
/*    */   
/*    */   boolean getParentRestrictQuantity();
/*    */   
/*    */   void setParentRestrictQuantity(boolean paramBoolean);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   IDataModel getLineItemAssociationTypeCodeExt();
/*    */   
/*    */   void setLineItemAssociationTypeCodeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ILineItemAssociationTypeCodeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ILineItemAssociationTypeCodeProperty> paramList);
/*    */   
/*    */   void addLineItemAssociationTypeCodeProperty(ILineItemAssociationTypeCodeProperty paramILineItemAssociationTypeCodeProperty);
/*    */   
/*    */   void removeLineItemAssociationTypeCodeProperty(ILineItemAssociationTypeCodeProperty paramILineItemAssociationTypeCodeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ILineItemAssociationTypeCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */