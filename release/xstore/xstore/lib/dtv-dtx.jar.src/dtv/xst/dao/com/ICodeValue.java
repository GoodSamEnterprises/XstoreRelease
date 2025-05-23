/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICodeValue extends IDataModel, ICodeValueModel, IHasDataProperty<ICodeValueProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CATEGORY = new EventEnum("set category");
/* 11 */   public static final EventEnum SET_CODE = new EventEnum("set code");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 17 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 18 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 19 */   public static final EventEnum SET_HIDDEN = new EventEnum("set hidden");
/* 20 */   public static final EventEnum SET_RANK = new EventEnum("set rank");
/* 21 */   public static final EventEnum SET_IMAGEURL = new EventEnum("set imageUrl");
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
/*    */   String getCategory();
/*    */   
/*    */   void setCategory(String paramString);
/*    */   
/*    */   String getCode();
/*    */   
/*    */   void setCode(String paramString);
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
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   boolean getHidden();
/*    */   
/*    */   void setHidden(boolean paramBoolean);
/*    */   
/*    */   int getRank();
/*    */   
/*    */   void setRank(int paramInt);
/*    */   
/*    */   String getImageUrl();
/*    */   
/*    */   void setImageUrl(String paramString);
/*    */   
/*    */   IDataModel getCodeValueExt();
/*    */   
/*    */   void setCodeValueExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICodeValueProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICodeValueProperty> paramList);
/*    */   
/*    */   void addCodeValueProperty(ICodeValueProperty paramICodeValueProperty);
/*    */   
/*    */   void removeCodeValueProperty(ICodeValueProperty paramICodeValueProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ICodeValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */