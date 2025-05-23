/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.trl.IRetailTransactionDealLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RetailTransactionDealLineItemModel
/*     */   extends RetailTransactionLineItemModel
/*     */   implements IRetailTransactionDealLineItem
/*     */ {
/*     */   private static final long serialVersionUID = -1110874354L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new RetailTransactionDealLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RetailTransactionDealLineItemDAO getDAO_() {
/*  38 */     return (RetailTransactionDealLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  46 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  54 */     if (setCreateDate_noev(argCreateDate) && 
/*  55 */       this._events != null && 
/*  56 */       postEventsForChanges()) {
/*  57 */       this._events.post(IRetailTransactionDealLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  64 */     boolean ev_postable = false;
/*     */     
/*  66 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  67 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  68 */       getDAO_().setCreateDate(argCreateDate);
/*  69 */       ev_postable = true;
/*     */     } 
/*     */     
/*  72 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  89 */       this._events != null && 
/*  90 */       postEventsForChanges()) {
/*  91 */       this._events.post(IRetailTransactionDealLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  98 */     boolean ev_postable = false;
/*     */     
/* 100 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 101 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 102 */       getDAO_().setCreateUserId(argCreateUserId);
/* 103 */       ev_postable = true;
/*     */     } 
/*     */     
/* 106 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 123 */       this._events != null && 
/* 124 */       postEventsForChanges()) {
/* 125 */       this._events.post(IRetailTransactionDealLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 132 */     boolean ev_postable = false;
/*     */     
/* 134 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 135 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 136 */       getDAO_().setUpdateDate(argUpdateDate);
/* 137 */       ev_postable = true;
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 148 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IRetailTransactionDealLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 169 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 170 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getAmountImpl() {
/* 182 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setAmountImpl(BigDecimal argAmount) {
/* 190 */     if (setAmount_noev(argAmount) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(IRetailTransactionDealLineItem.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 203 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 204 */       getDAO_().setAmount(argAmount);
/* 205 */       ev_postable = true;
/*     */     } 
/*     */     
/* 208 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/* 216 */     return getDAO_().getDealId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 224 */     if (setDealId_noev(argDealId) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(IRetailTransactionDealLineItem.SET_DEALID, argDealId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDealId_noev(String argDealId) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/* 237 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/* 238 */       getDAO_().setDealId(argDealId);
/* 239 */       ev_postable = true;
/*     */     } 
/*     */     
/* 242 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonCode() {
/* 250 */     return getDAO_().getReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 258 */     if (setReasonCode_noev(argReasonCode) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(IRetailTransactionDealLineItem.SET_REASONCODE, argReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonCode_noev(String argReasonCode) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/* 271 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/* 272 */       getDAO_().setReasonCode(argReasonCode);
/* 273 */       ev_postable = true;
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 282 */     if ("RetailTransactionDealLineItemExtension".equals(argFieldId)) {
/* 283 */       return this._myExtension;
/*     */     }
/*     */     
/* 286 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 292 */     if ("RetailTransactionDealLineItemExtension".equals(argFieldId)) {
/* 293 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 296 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 302 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getRetailTransactionDealLineItemExt() {
/* 306 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionDealLineItemExt(IDataModel argExt) {
/* 310 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 315 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 319 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 322 */     super.startTransaction();
/*     */ 
/*     */     
/* 325 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 330 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 333 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 339 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 342 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 345 */     super.commitTransaction();
/*     */ 
/*     */     
/* 348 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 353 */     argStream.defaultReadObject();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 369 */     return getLocalizedAmount(getAmountImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 376 */     BigDecimal relativeAmount = getRelativeAmount(argAmount);
/* 377 */     setAmountImpl(relativeAmount);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionDealLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */