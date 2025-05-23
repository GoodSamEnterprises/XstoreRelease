/*    */ package dtv.xst.dao.dsc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDiscount extends IDataModel, IDiscountModel, IHasDataProperty<IDiscountProperty> {
/*  9 */   public static final EventEnum SET_DISCOUNTCODE = new EventEnum("set discountCode");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_CLASSNAME = new EventEnum("set className");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 17 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 18 */   public static final EventEnum SET_APPLICATIONMETHODCODE = new EventEnum("set applicationMethodCode");
/* 19 */   public static final EventEnum SET_CALCULATIONMETHODCODE = new EventEnum("set calculationMethodCode");
/* 20 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 21 */   public static final EventEnum SET_EFFECTIVEDATETIME = new EventEnum("set effectiveDatetime");
/* 22 */   public static final EventEnum SET_EXCLUSIVEDISCOUNT = new EventEnum("set exclusiveDiscount");
/* 23 */   public static final EventEnum SET_EXPIRATIONDATETIME = new EventEnum("set expirationDatetime");
/* 24 */   public static final EventEnum SET_MAXIMUMTRANSACTIONCOUNT = new EventEnum("set maximumTransactionCount");
/* 25 */   public static final EventEnum SET_MINIMUMELIGIBLEPRICE = new EventEnum("set minimumEligiblePrice");
/* 26 */   public static final EventEnum SET_PERCENT = new EventEnum("set percent");
/* 27 */   public static final EventEnum SET_PROMPT = new EventEnum("set prompt");
/* 28 */   public static final EventEnum SET_SOUND = new EventEnum("set sound");
/* 29 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 30 */   public static final EventEnum SET_SERIALIZEDDISCOUNT = new EventEnum("set serializedDiscount");
/* 31 */   public static final EventEnum SET_PRIVILEGETYPE = new EventEnum("set privilegeType");
/* 32 */   public static final EventEnum SET_TAXABILITYCODE = new EventEnum("set taxabilityCode");
/* 33 */   public static final EventEnum SET_MAXDISCOUNT = new EventEnum("set maxDiscount");
/* 34 */   public static final EventEnum SET_MAXAMOUNT = new EventEnum("set maxAmount");
/* 35 */   public static final EventEnum SET_MAXPERCENTAGE = new EventEnum("set maxPercentage");
/* 36 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 37 */   public static final EventEnum SET_DISALLOWCHANGE = new EventEnum("set disallowChange");
/* 38 */   public static final EventEnum ADD_COMPATIBLEDISCOUNTS = new EventEnum("add CompatibleDiscounts");
/* 39 */   public static final EventEnum REMOVE_COMPATIBLEDISCOUNTS = new EventEnum("remove CompatibleDiscounts");
/* 40 */   public static final EventEnum SET_COMPATIBLEDISCOUNTS = new EventEnum("set CompatibleDiscounts");
/* 41 */   public static final EventEnum ADD_VALIDSALELINEITEMTYPECODES = new EventEnum("add ValidSaleLineItemTypeCodes");
/* 42 */   public static final EventEnum REMOVE_VALIDSALELINEITEMTYPECODES = new EventEnum("remove ValidSaleLineItemTypeCodes");
/* 43 */   public static final EventEnum SET_VALIDSALELINEITEMTYPECODES = new EventEnum("set ValidSaleLineItemTypeCodes");
/* 44 */   public static final EventEnum ADD_CUSTOMERGROUPS = new EventEnum("add CustomerGroups");
/* 45 */   public static final EventEnum REMOVE_CUSTOMERGROUPS = new EventEnum("remove CustomerGroups");
/* 46 */   public static final EventEnum SET_CUSTOMERGROUPS = new EventEnum("set CustomerGroups");
/* 47 */   public static final EventEnum SET_PRIVILEGE = new EventEnum("set Privilege");
/* 48 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 49 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 50 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 51 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 52 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 53 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getDiscountCode();
/*    */   
/*    */   void setDiscountCode(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getClassName();
/*    */   
/*    */   void setClassName(String paramString);
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getApplicationMethodCode();
/*    */   
/*    */   void setApplicationMethodCode(String paramString);
/*    */   
/*    */   String getCalculationMethodCode();
/*    */   
/*    */   void setCalculationMethodCode(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   Date getEffectiveDatetime();
/*    */   
/*    */   void setEffectiveDatetime(Date paramDate);
/*    */   
/*    */   boolean getExclusiveDiscount();
/*    */   
/*    */   void setExclusiveDiscount(boolean paramBoolean);
/*    */   
/*    */   Date getExpirationDatetime();
/*    */   
/*    */   void setExpirationDatetime(Date paramDate);
/*    */   
/*    */   long getMaximumTransactionCount();
/*    */   
/*    */   void setMaximumTransactionCount(long paramLong);
/*    */   
/*    */   BigDecimal getMinimumEligiblePrice();
/*    */   
/*    */   void setMinimumEligiblePrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPercent();
/*    */   
/*    */   void setPercent(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getPrompt();
/*    */   
/*    */   void setPrompt(String paramString);
/*    */   
/*    */   String getSound();
/*    */   
/*    */   void setSound(String paramString);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   boolean getSerializedDiscount();
/*    */   
/*    */   void setSerializedDiscount(boolean paramBoolean);
/*    */   
/*    */   String getPrivilegeType();
/*    */   
/*    */   void setPrivilegeType(String paramString);
/*    */   
/*    */   String getTaxabilityCode();
/*    */   
/*    */   void setTaxabilityCode(String paramString);
/*    */   
/*    */   BigDecimal getMaxDiscount();
/*    */   
/*    */   void setMaxDiscount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaxAmount();
/*    */   
/*    */   void setMaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaxPercentage();
/*    */   
/*    */   void setMaxPercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   boolean getDisallowChange();
/*    */   
/*    */   void setDisallowChange(boolean paramBoolean);
/*    */   
/*    */   IDataModel getDiscountExt();
/*    */   
/*    */   void setDiscountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDiscountCompatability> getCompatibleDiscounts();
/*    */   
/*    */   void setCompatibleDiscounts(List<IDiscountCompatability> paramList);
/*    */   
/*    */   void addDiscountCompatability(IDiscountCompatability paramIDiscountCompatability);
/*    */   
/*    */   void removeDiscountCompatability(IDiscountCompatability paramIDiscountCompatability);
/*    */   
/*    */   List<IDiscountTypeEligibility> getValidSaleLineItemTypeCodes();
/*    */   
/*    */   void setValidSaleLineItemTypeCodes(List<IDiscountTypeEligibility> paramList);
/*    */   
/*    */   void addDiscountTypeEligibility(IDiscountTypeEligibility paramIDiscountTypeEligibility);
/*    */   
/*    */   void removeDiscountTypeEligibility(IDiscountTypeEligibility paramIDiscountTypeEligibility);
/*    */   
/*    */   List<IDiscountGroupMapping> getCustomerGroups();
/*    */   
/*    */   void setCustomerGroups(List<IDiscountGroupMapping> paramList);
/*    */   
/*    */   void addDiscountGroupMapping(IDiscountGroupMapping paramIDiscountGroupMapping);
/*    */   
/*    */   void removeDiscountGroupMapping(IDiscountGroupMapping paramIDiscountGroupMapping);
/*    */   
/*    */   IPrivilege getPrivilege();
/*    */   
/*    */   void setPrivilege(IPrivilege paramIPrivilege);
/*    */   
/*    */   List<IDiscountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDiscountProperty> paramList);
/*    */   
/*    */   void addDiscountProperty(IDiscountProperty paramIDiscountProperty);
/*    */   
/*    */   void removeDiscountProperty(IDiscountProperty paramIDiscountProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\IDiscount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */