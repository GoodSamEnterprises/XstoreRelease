/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemPromptProperty extends IDataModel, IHasDataProperty<IItemPromptPropertyProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_PROMPTPROPERTYCODE = new EventEnum("set promptPropertyCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_PROMPTMETHODCODE = new EventEnum("set promptMethodCode");
/* 19 */   public static final EventEnum SET_CODEGROUP = new EventEnum("set codeGroup");
/* 20 */   public static final EventEnum SET_PROMPTTITLEKEY = new EventEnum("set promptTitleKey");
/* 21 */   public static final EventEnum SET_PROMPTMESSAGEKEY = new EventEnum("set promptMessageKey");
/* 22 */   public static final EventEnum SET_REQUIRED = new EventEnum("set required");
/* 23 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getPromptPropertyCode();
/*    */   
/*    */   void setPromptPropertyCode(String paramString);
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
/*    */   String getPromptMethodCode();
/*    */   
/*    */   void setPromptMethodCode(String paramString);
/*    */   
/*    */   String getCodeGroup();
/*    */   
/*    */   void setCodeGroup(String paramString);
/*    */   
/*    */   String getPromptTitleKey();
/*    */   
/*    */   void setPromptTitleKey(String paramString);
/*    */   
/*    */   String getPromptMessageKey();
/*    */   
/*    */   void setPromptMessageKey(String paramString);
/*    */   
/*    */   boolean getRequired();
/*    */   
/*    */   void setRequired(boolean paramBoolean);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   IDataModel getItemPromptPropertyExt();
/*    */   
/*    */   void setItemPromptPropertyExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemPromptPropertyProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemPromptPropertyProperty> paramList);
/*    */   
/*    */   void addItemPromptPropertyProperty(IItemPromptPropertyProperty paramIItemPromptPropertyProperty);
/*    */   
/*    */   void removeItemPromptPropertyProperty(IItemPromptPropertyProperty paramIItemPromptPropertyProperty);
/*    */   
/*    */   void setParentItem(IItem paramIItem);
/*    */   
/*    */   IItem getParentItem();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemPromptProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */