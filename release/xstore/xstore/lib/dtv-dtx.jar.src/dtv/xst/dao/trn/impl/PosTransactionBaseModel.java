/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import com.google.common.collect.LinkedListMultimap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Multimaps;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.pricing2.IResult;
/*     */ import dtv.pricing2.PricingDeal;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.IDateProvider;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.xst.dao.loc.RetailLocationId;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import dtv.xst.dao.trn.IPosTransactionModel;
/*     */ import dtv.xst.dao.trn.IPosTransactionProperty;
/*     */ import dtv.xst.dao.trn.ITransactionNotes;
/*     */ import dtv.xst.daocommon.ILineItemFilter;
/*     */ import dtv.xst.daocommon.IRetailTransactionManager;
/*     */ import dtv.xst.pricing.EventedPricingTransaction;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PosTransactionBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IPosTransactionProperty>
/*     */   implements IPosTransactionModel, IPosTransaction
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  41 */   protected transient ListMultimap<String, IRetailTransactionLineItem> lineItemIndexByType_ = null;
/*     */ 
/*     */   
/*     */   protected transient IRetailTransactionManager _transMgr;
/*     */ 
/*     */   
/*     */   protected transient EventedPricingTransaction _pricingShadow;
/*     */   
/*  49 */   private transient Date _custBirthDate = null;
/*  50 */   private transient BigDecimal _amountTendered = BigDecimal.ZERO;
/*  51 */   private transient BigDecimal _foodStampsAmountDue = BigDecimal.ZERO;
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRetailTransactionLineItem(IRetailTransactionLineItem newItem) {
/*  56 */     synchronized (this) {
/*  57 */       newItem.setRetailTransactionLineItemSequence(getRetailTransactionLineItems().size() + 1);
/*  58 */       getLineItemIndexByType().put(newItem.getLineItemTypeCode(), newItem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTransactionNotes(ITransactionNotes argNote) {
/*  65 */     argNote.setNoteSequence(getTransactionNotes().size() + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmountDue() {
/*  71 */     return NumberUtils.nonNull(getTotal()).subtract(getAmountTendered());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmountTendered() {
/*  77 */     return NumberUtils.nonNull(this._amountTendered);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final Date getBeginDatetimestamp() {
/*  85 */     return getBeginDateTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PricingDeal> getCurrentPossibleDeals() {
/*  91 */     return getPricing().getActiveDeals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCustBirthDate() {
/*  97 */     return this._custBirthDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IResult getDealResults() {
/* 103 */     return getPricing().calculateItemDeals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailTransactionLineItem> getDiscountLineItems() {
/* 109 */     return getLineItemsByTypeCode("DISCOUNT");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final Date getEndDatetimestamp() {
/* 117 */     return getEndDateTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getFoodStampsAmountDue() {
/* 128 */     return this._foodStampsAmountDue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IRetailTransactionLineItem> List<T> getLineItems(Class<T> argInterface) {
/* 134 */     List<IRetailTransactionLineItem> items = getRetailTransactionLineItems();
/* 135 */     List<T> results = new ArrayList<>(items.size());
/*     */     
/* 137 */     for (IRetailTransactionLineItem line : items) {
/* 138 */       if (argInterface.isAssignableFrom(line.getClass())) {
/* 139 */         results.add(argInterface.cast(line));
/*     */       }
/*     */     } 
/*     */     
/* 143 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailTransactionLineItem> getLineItemsByTypeCode(String argLineItemTypeCode) {
/* 149 */     ListMultimap<String, IRetailTransactionLineItem> itemsByType = getLineItemIndexByType();
/*     */     
/* 151 */     if (itemsByType.isEmpty()) {
/* 152 */       for (IRetailTransactionLineItem line : getRetailTransactionLineItems()) {
/* 153 */         itemsByType.put(line.getLineItemTypeCode(), line);
/*     */       }
/*     */     }
/*     */     
/* 157 */     if (!itemsByType.containsKey(argLineItemTypeCode)) {
/* 158 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 161 */     return itemsByType.get(argLineItemTypeCode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IRetailTransactionLineItem> List<T> getLineItemsByTypeCode(String argLineItemTypeCode, Class<T> argInterface) {
/* 168 */     ListMultimap<String, IRetailTransactionLineItem> itemsByType = getLineItemIndexByType();
/*     */     
/* 170 */     if (itemsByType.isEmpty()) {
/* 171 */       for (IRetailTransactionLineItem line : getRetailTransactionLineItems()) {
/* 172 */         itemsByType.put(line.getLineItemTypeCode(), line);
/*     */       }
/*     */     }
/*     */     
/* 176 */     if (!itemsByType.containsKey(argLineItemTypeCode)) {
/* 177 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 180 */     List<IRetailTransactionLineItem> found = itemsByType.get(argLineItemTypeCode);
/* 181 */     List<T> results = Collections.checkedList(new ArrayList<>(found.size()), argInterface);
/*     */     
/* 183 */     for (IRetailTransactionLineItem line : found) {
/*     */       try {
/* 185 */         results.add(argInterface.cast(line));
/*     */       }
/* 187 */       catch (Exception exception) {}
/*     */     } 
/*     */     
/* 190 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IDataModel> getLineItemsByTypeCodeFiltered(String argLineItemTypeCode, String filterClassName) {
/* 203 */     ILineItemFilter lineItemFilter = null;
/*     */     
/*     */     try {
/* 206 */       lineItemFilter = (ILineItemFilter)Class.forName(filterClassName).newInstance();
/*     */     }
/* 208 */     catch (Exception ex) {
/* 209 */       Logger.getLogger(getClass()).error("CAUGHT EXCEPTION getLineItemsByTypeCodeFiltered", ex);
/* 210 */       return (List)getLineItemsByTypeCode(argLineItemTypeCode);
/*     */     } 
/*     */     
/* 213 */     return lineItemFilter.filter(getLineItemsByTypeCode(argLineItemTypeCode));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IRetailTransactionLineItem> getPosLogRetailLineItems() {
/* 219 */     List<IRetailTransactionLineItem> posLogLines = new ArrayList<>();
/*     */     
/* 221 */     for (IRetailTransactionLineItem line : getRetailTransactionLineItems()) {
/* 222 */       if (line.getTLogSequence() != Integer.MIN_VALUE) {
/* 223 */         posLogLines.add(line);
/*     */       }
/*     */     } 
/*     */     
/* 227 */     return posLogLines;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EventedPricingTransaction getPricing() {
/* 233 */     return this._pricingShadow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RetailLocationId getRetailLocationIdObject() {
/* 242 */     RetailLocationId id = new RetailLocationId();
/* 243 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 244 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getRoundedAmount() {
/* 250 */     return NumberUtils.nonNull(getDAO_().getRoundedAmount());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailTransactionLineItem> getSaleLineItems() {
/* 256 */     return getLineItemsByTypeCode("ITEM");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailTransactionLineItem> getTaxLineItems() {
/* 262 */     return getLineItemsByTypeCode("TAX");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailTransactionLineItem> getTenderLineItems() {
/* 268 */     return getLineItemsByTypeCode("TENDER");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IResult getThresholdDealResults() {
/* 274 */     return getPricing().calculateTransactionDeals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmountTendered(BigDecimal argAmountTendered) {
/* 280 */     this._amountTendered = argAmountTendered;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDateTimestamp(Date newValue) {
/* 286 */     setBeginTimeInt((newValue == null) ? -1 : DateUtils.date2TimeInt(newValue));
/* 287 */     setTransactionDate(DateUtils.clearTime(newValue));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDateTimestamp(Date argValue, IDateProvider argDateProvider) {
/* 293 */     setBeginDateTimestamp(argValue);
/* 294 */     setBeginTimeInt((argValue == null) ? -1 : DateUtils.date2TimeInt(argValue));
/* 295 */     setTransactionDate(argDateProvider.getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustBirthDate(Date custBirthDate) {
/* 301 */     this._custBirthDate = custBirthDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFoodStampsAmountDue(BigDecimal argAmount) {
/* 311 */     this._foodStampsAmountDue = argAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPricing(EventedPricingTransaction argPricingShadow) {
/* 317 */     this._pricingShadow = argPricingShadow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItems(List<IRetailTransactionLineItem> argRetailTransactionLineItems) {
/* 323 */     this.lineItemIndexByType_ = Multimaps.synchronizedListMultimap(
/* 324 */         (ListMultimap)LinkedListMultimap.create(10));
/*     */     
/* 326 */     for (IRetailTransactionLineItem lineItem : argRetailTransactionLineItems) {
/* 327 */       getLineItemIndexByType().put(lineItem.getLineItemTypeCode(), lineItem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PosTransactionDAO getDAO_() {
/* 336 */     return (PosTransactionDAO)this._daoImpl;
/*     */   }
/*     */   
/*     */   private ListMultimap<String, IRetailTransactionLineItem> getLineItemIndexByType() {
/* 340 */     if (this.lineItemIndexByType_ == null) {
/* 341 */       this.lineItemIndexByType_ = Multimaps.synchronizedListMultimap(
/* 342 */           (ListMultimap)LinkedListMultimap.create(10));
/*     */     }
/*     */     
/* 345 */     return this.lineItemIndexByType_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */