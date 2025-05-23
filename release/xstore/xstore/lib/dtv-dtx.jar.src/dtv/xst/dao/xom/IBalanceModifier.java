/*    */ package dtv.xst.dao.xom;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IBalanceModifier extends IDataModel, IHasDataProperty<IBalanceModifierProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ORDERID = new EventEnum("set orderId");
/* 11 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 12 */   public static final EventEnum SET_MODSEQUENCE = new EventEnum("set modSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 18 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 19 */   public static final EventEnum SET_VOID = new EventEnum("set void");
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
/*    */   String getOrderId();
/*    */   
/*    */   void setOrderId(String paramString);
/*    */   
/*    */   int getSequence();
/*    */   
/*    */   void setSequence(int paramInt);
/*    */   
/*    */   int getModSequence();
/*    */   
/*    */   void setModSequence(int paramInt);
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
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   IDataModel getBalanceModifierExt();
/*    */   
/*    */   void setBalanceModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IBalanceModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IBalanceModifierProperty> paramList);
/*    */   
/*    */   void addBalanceModifierProperty(IBalanceModifierProperty paramIBalanceModifierProperty);
/*    */   
/*    */   void removeBalanceModifierProperty(IBalanceModifierProperty paramIBalanceModifierProperty);
/*    */   
/*    */   void setParentOrderLine(IOrderLine paramIOrderLine);
/*    */   
/*    */   IOrderLine getParentOrderLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IBalanceModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */