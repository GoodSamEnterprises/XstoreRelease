package dtv.pos.framework.tax;

import dtv.util.IDateProvider;
import dtv.util.IDateTimeProvider;
import dtv.util.config.ConfigException;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.tax.IPostalCodeMapping;
import dtv.xst.dao.tax.ITaxAuthority;
import dtv.xst.dao.tax.ITaxBracket;
import dtv.xst.dao.tax.ITaxExemption;
import dtv.xst.dao.tax.ITaxGroupRule;
import dtv.xst.dao.tax.ITaxLocation;
import dtv.xst.dao.tax.ITaxRule;
import dtv.xst.dao.tax.TaxGroupRuleId;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.ISaleTaxModifier;
import dtv.xst.dao.trl.ITaxLineItem;
import dtv.xst.dao.trl.RetailTransactionLineItemId;
import dtv.xst.dao.trn.IPosTransaction;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITaxHelper {
  BigDecimal addTaxesToNetAmt(BigDecimal paramBigDecimal, Map<TaxGroupRuleId, TaxInfo> paramMap);
  
  boolean calcLineItemAsExempt(ISaleReturnLineItem paramISaleReturnLineItem);
  
  boolean calcLineItemAsOverriden(ISaleReturnLineItem paramISaleReturnLineItem);
  
  void copyTaxLineItem(ITaxLineItem paramITaxLineItem1, ITaxLineItem paramITaxLineItem2);
  
  void copyTaxModifiersExactPercent(ISaleReturnLineItem paramISaleReturnLineItem1, ISaleReturnLineItem paramISaleReturnLineItem2);
  
  ISaleTaxModifier createEmptySaleTaxModifier(ISaleReturnLineItem paramISaleReturnLineItem) throws ConfigException;
  
  void createSaleTaxModifiers(ISaleReturnLineItem paramISaleReturnLineItem, List<ITaxGroupRule> paramList);
  
  ITaxExemption createTaxExemption(IParty paramIParty);
  
  ITaxLineItem createTaxLineItem(IPosTransaction paramIPosTransaction, ITaxGroupRule paramITaxGroupRule);
  
  ITaxLineItem createTaxLineItem(RetailTransactionLineItemId paramRetailTransactionLineItemId, IPosTransaction paramIPosTransaction, ITaxGroupRule paramITaxGroupRule);
  
  List<ITaxBracket> getBrackets(String paramString);
  
  String getCurrentSaleItemTaxGroup(IItem paramIItem, IParty paramIParty, long paramLong);
  
  String getCustomerNumber(ISaleReturnLineItem paramISaleReturnLineItem);
  
  BigDecimal getExtendedAmount(ISaleReturnLineItem paramISaleReturnLineItem, Currency paramCurrency);
  
  List<ITaxGroupRule> getGroupRules(ITaxLocation paramITaxLocation);
  
  List<ITaxGroupRule> getGroupRules(String paramString, ITaxLocation paramITaxLocation);
  
  ISaleTaxModifier getModForRemainderTax(List<ISaleTaxModifier> paramList);
  
  ITaxSystemLocation getNewTaxSystemLocation();
  
  ITaxGroupRule getParentGroupRule(ITaxRule paramITaxRule, long paramLong);
  
  List<ITaxRule> getRateRules(ITaxGroupRule paramITaxGroupRule, BigDecimal paramBigDecimal, IDateTimeProvider paramIDateTimeProvider);
  
  ISaleTaxModifier getSaleTaxModifier(ISaleReturnLineItem paramISaleReturnLineItem, String paramString1, String paramString2);
  
  BigDecimal getTax(ISaleReturnLineItem paramISaleReturnLineItem);
  
  List<ITaxExemption> getTaxExemptions(IParty paramIParty);
  
  List<ITaxExemption> getTaxExemptions(IParty paramIParty, Date paramDate);
  
  List<ITaxExemption> getTaxExemptions(IParty paramIParty, Date paramDate, String paramString);
  
  List<ITaxExemption> getTaxExemptions(long paramLong);
  
  List<ITaxExemption> getTaxExemptions(long paramLong, Date paramDate, String paramString);
  
  String getTaxGroupId(ISaleReturnLineItem paramISaleReturnLineItem);
  
  ITaxLineItem getTaxLineItem(ITaxGroupRule paramITaxGroupRule, IRetailTransaction paramIRetailTransaction);
  
  List<IPostalCodeMapping> getTaxLocationById(String paramString);
  
  List<IPostalCodeMapping> getTaxLocationByPostalCode(String paramString);
  
  ITaxLocation getTaxLocationByRetailLocation(long paramLong);
  
  Map<TaxGroupRuleId, TaxInfo> getTaxSummary(List<ICustomerItemAccountDetail> paramList, boolean paramBoolean);
  
  TaxSystemType getTaxSystemType();
  
  BigDecimal getTotalTax(List<ISaleReturnLineItem> paramList);
  
  BigDecimal getTotalTaxPercentForTaxModifier(ISaleTaxModifier paramISaleTaxModifier);
  
  boolean hasCurrentTaxExemptions(IDateProvider paramIDateProvider, IParty paramIParty);
  
  boolean isEditableTax(ISaleTaxModifier paramISaleTaxModifier);
  
  boolean isLineItemTaxExempt(ISaleReturnLineItem paramISaleReturnLineItem);
  
  boolean isLineItemTaxOverriden(ISaleReturnLineItem paramISaleReturnLineItem);
  
  boolean isOverrideCalcApplicable(ISaleTaxModifier paramISaleTaxModifier);
  
  boolean isSaleTaxModifierTaxExempt(ISaleTaxModifier paramISaleTaxModifier);
  
  boolean isTaxApplicable(ISaleReturnLineItem paramISaleReturnLineItem);
  
  boolean isThisTaxable(List<? extends ISaleTaxModifier> paramList);
  
  boolean isTransactionTaxExempt(IRetailTransaction paramIRetailTransaction);
  
  void preload();
  
  List<ITaxLineItem> removeNonEditableTaxLines(List<ITaxLineItem> paramList);
  
  List<ITaxLineItem> removeVoidedTaxLines(List<ITaxLineItem> paramList);
  
  BigDecimal roundTaxAmount(ISaleTaxModifier paramISaleTaxModifier, BigDecimal paramBigDecimal);
  
  BigDecimal roundTaxAmount(ITaxAuthority paramITaxAuthority, BigDecimal paramBigDecimal);
  
  void setGroupRuleForTaxLine(ITaxLineItem paramITaxLineItem);
  
  void updateGroupRulesForSaleLine(ISaleReturnLineItem paramISaleReturnLineItem);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\tax\ITaxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */