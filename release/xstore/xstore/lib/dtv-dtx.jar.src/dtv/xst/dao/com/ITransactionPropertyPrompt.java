/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITransactionPropertyPrompt extends IDataModel, IHasDataProperty<ITransactionPropertyPromptProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PROMPTPROPERTYCODE = new EventEnum("set promptPropertyCode");
/* 11 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 19 */   public static final EventEnum SET_PROMPTMETHODCODE = new EventEnum("set promptMethodCode");
/* 20 */   public static final EventEnum SET_CODECATEGORY = new EventEnum("set codeCategory");
/* 21 */   public static final EventEnum SET_PROMPTTITLEKEY = new EventEnum("set promptTitleKey");
/* 22 */   public static final EventEnum SET_PROMPTMESSAGEKEY = new EventEnum("set promptMessageKey");
/* 23 */   public static final EventEnum SET_REQUIRED = new EventEnum("set required");
/* 24 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 25 */   public static final EventEnum SET_PROMPTEDITPATTERN = new EventEnum("set promptEditPattern");
/* 26 */   public static final EventEnum SET_VALIDATIONRULEKEY = new EventEnum("set validationRuleKey");
/* 27 */   public static final EventEnum SET_PROMPTKEY = new EventEnum("set promptKey");
/* 28 */   public static final EventEnum SET_CHAINKEY = new EventEnum("set chainKey");
/* 29 */   public static final EventEnum SET_TRANSACTIONSTATE = new EventEnum("set transactionState");
/* 30 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 31 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 32 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 33 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 34 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 35 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getPromptPropertyCode();
/*    */   
/*    */   void setPromptPropertyCode(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
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
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   String getPromptMethodCode();
/*    */   
/*    */   void setPromptMethodCode(String paramString);
/*    */   
/*    */   String getCodeCategory();
/*    */   
/*    */   void setCodeCategory(String paramString);
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
/*    */   String getPromptEditPattern();
/*    */   
/*    */   void setPromptEditPattern(String paramString);
/*    */   
/*    */   String getValidationRuleKey();
/*    */   
/*    */   void setValidationRuleKey(String paramString);
/*    */   
/*    */   String getPromptKey();
/*    */   
/*    */   void setPromptKey(String paramString);
/*    */   
/*    */   String getChainKey();
/*    */   
/*    */   void setChainKey(String paramString);
/*    */   
/*    */   String getTransactionState();
/*    */   
/*    */   void setTransactionState(String paramString);
/*    */   
/*    */   IDataModel getTransactionPropertyPromptExt();
/*    */   
/*    */   void setTransactionPropertyPromptExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITransactionPropertyPromptProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITransactionPropertyPromptProperty> paramList);
/*    */   
/*    */   void addTransactionPropertyPromptProperty(ITransactionPropertyPromptProperty paramITransactionPropertyPromptProperty);
/*    */   
/*    */   void removeTransactionPropertyPromptProperty(ITransactionPropertyPromptProperty paramITransactionPropertyPromptProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ITransactionPropertyPrompt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */