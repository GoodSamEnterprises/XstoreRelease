/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWarrantyItemPrice extends IDataModel, IHasDataProperty<IWarrantyItemPriceProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_WARRANTYPRICESEQ = new EventEnum("set warrantyPriceSeq");
/* 12 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 13 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_MINITEMPRICEAMT = new EventEnum("set minItemPriceAmt");
/* 19 */   public static final EventEnum SET_MAXITEMPRICEAMT = new EventEnum("set maxItemPriceAmt");
/* 20 */   public static final EventEnum SET_PRICEAMT = new EventEnum("set priceAmt");
/* 21 */   public static final EventEnum SET_PRICEPERCENTAGE = new EventEnum("set pricePercentage");
/* 22 */   public static final EventEnum SET_MINPRICEAMT = new EventEnum("set minPriceAmt");
/* 23 */   public static final EventEnum SET_REFITEMID = new EventEnum("set refItemId");
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
/*    */   long getWarrantyPriceSeq();
/*    */   
/*    */   void setWarrantyPriceSeq(long paramLong);
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
/*    */   BigDecimal getMinItemPriceAmt();
/*    */   
/*    */   void setMinItemPriceAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaxItemPriceAmt();
/*    */   
/*    */   void setMaxItemPriceAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPriceAmt();
/*    */   
/*    */   void setPriceAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPricePercentage();
/*    */   
/*    */   void setPricePercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMinPriceAmt();
/*    */   
/*    */   void setMinPriceAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getRefItemId();
/*    */   
/*    */   void setRefItemId(String paramString);
/*    */   
/*    */   IDataModel getWarrantyItemPriceExt();
/*    */   
/*    */   void setWarrantyItemPriceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWarrantyItemPriceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IWarrantyItemPriceProperty> paramList);
/*    */   
/*    */   void addWarrantyItemPriceProperty(IWarrantyItemPriceProperty paramIWarrantyItemPriceProperty);
/*    */   
/*    */   void removeWarrantyItemPriceProperty(IWarrantyItemPriceProperty paramIWarrantyItemPriceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IWarrantyItemPrice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */