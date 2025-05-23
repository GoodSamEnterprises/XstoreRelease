/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITaxBracket extends IDataModel, IHasDataProperty<ITaxBracketProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TAXBRACKETID = new EventEnum("set taxBracketId");
/* 11 */   public static final EventEnum SET_TAXBRACKETSEQUENCE = new EventEnum("set taxBracketSequence");
/* 12 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 13 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_TAXBREAKPOINT = new EventEnum("set taxBreakpoint");
/* 19 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTaxBracketId();
/*    */   
/*    */   void setTaxBracketId(String paramString);
/*    */   
/*    */   int getTaxBracketSequence();
/*    */   
/*    */   void setTaxBracketSequence(int paramInt);
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
/*    */   BigDecimal getTaxBreakpoint();
/*    */   
/*    */   void setTaxBreakpoint(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxAmount();
/*    */   
/*    */   void setTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getTaxBracketExt();
/*    */   
/*    */   void setTaxBracketExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITaxBracketProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITaxBracketProperty> paramList);
/*    */   
/*    */   void addTaxBracketProperty(ITaxBracketProperty paramITaxBracketProperty);
/*    */   
/*    */   void removeTaxBracketProperty(ITaxBracketProperty paramITaxBracketProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxBracket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */