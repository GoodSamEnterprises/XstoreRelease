/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IReceiptText extends IDataModel, IHasConfigElement, IHasDataProperty<IReceiptTextProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TEXTCODE = new EventEnum("set textCode");
/* 11 */   public static final EventEnum SET_TEXTSEQUENCE = new EventEnum("set textSequence");
/* 12 */   public static final EventEnum SET_TEXTSUBCODE = new EventEnum("set textSubcode");
/* 13 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_RECEIPTTEXT = new EventEnum("set receiptText");
/* 19 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 20 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 21 */   public static final EventEnum SET_LINEFORMAT = new EventEnum("set lineFormat");
/* 22 */   public static final EventEnum SET_REFORMAT = new EventEnum("set reformat");
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
/*    */   String getTextCode();
/*    */   
/*    */   void setTextCode(String paramString);
/*    */   
/*    */   int getTextSequence();
/*    */   
/*    */   void setTextSequence(int paramInt);
/*    */   
/*    */   String getTextSubcode();
/*    */   
/*    */   void setTextSubcode(String paramString);
/*    */   
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
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
/*    */   String getReceiptText();
/*    */   
/*    */   void setReceiptText(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   String getLineFormat();
/*    */   
/*    */   void setLineFormat(String paramString);
/*    */   
/*    */   boolean getReformat();
/*    */   
/*    */   void setReformat(boolean paramBoolean);
/*    */   
/*    */   IDataModel getReceiptTextExt();
/*    */   
/*    */   void setReceiptTextExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IReceiptTextProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IReceiptTextProperty> paramList);
/*    */   
/*    */   void addReceiptTextProperty(IReceiptTextProperty paramIReceiptTextProperty);
/*    */   
/*    */   void removeReceiptTextProperty(IReceiptTextProperty paramIReceiptTextProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IReceiptText.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */