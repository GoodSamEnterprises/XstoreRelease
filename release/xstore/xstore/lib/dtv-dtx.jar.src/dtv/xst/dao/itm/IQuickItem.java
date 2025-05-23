/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IQuickItem extends IDataModel, IHasDataProperty<IQuickItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_PARENTID = new EventEnum("set parentId");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_IMAGEURL = new EventEnum("set imageUrl");
/* 20 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 21 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
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
/*    */   String getParentId();
/*    */   
/*    */   void setParentId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getImageUrl();
/*    */   
/*    */   void setImageUrl(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   IDataModel getQuickItemExt();
/*    */   
/*    */   void setQuickItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   List<IQuickItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IQuickItemProperty> paramList);
/*    */   
/*    */   void addQuickItemProperty(IQuickItemProperty paramIQuickItemProperty);
/*    */   
/*    */   void removeQuickItemProperty(IQuickItemProperty paramIQuickItemProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IQuickItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */