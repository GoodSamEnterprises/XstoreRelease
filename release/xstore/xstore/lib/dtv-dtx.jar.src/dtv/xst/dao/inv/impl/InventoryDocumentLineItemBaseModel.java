/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectManager;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountDetail;
/*     */ import dtv.xst.dao.inv.IDocumentInventoryLocationModifier;
/*     */ import dtv.xst.dao.inv.IDocumentLineItemNote;
/*     */ import dtv.xst.dao.inv.IDocumentNote;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItemModel;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItemProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineSerial;
/*     */ import dtv.xst.dao.inv.IInventoryItemAccountModifier;
/*     */ import dtv.xst.dao.inv.InventoryItemAccountModifierId;
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.ItemId;
/*     */ import dtv.xst.dao.xom.IOrderModifier;
/*     */ import dtv.xst.daocommon.IInventoryAccountModifier;
/*     */ import dtv.xst.daocommon.IInventoryLocationModifier;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class InventoryDocumentLineItemBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IInventoryDocumentLineItemProperty>
/*     */   implements IInventoryDocumentLineItem, IInventoryDocumentLineItemModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient IItem item_;
/*     */   private transient ICustomerItemAccountDetail custItemAcctDetail_;
/*     */   private transient BigDecimal tempUnitCount_;
/*     */   private transient String tempStatusCode_;
/*     */   private transient BigDecimal tempPostedCount_;
/*     */   private transient BigDecimal quantityToAllocate_;
/*     */   private transient BigDecimal costToAllocate_;
/*     */   private transient BigDecimal tempUnitCost_;
/*     */   private transient BigDecimal tempPostedCost_;
/*     */   private transient boolean incomingInventoryProcessed_ = false;
/*     */   private transient boolean unmanageable_ = false;
/*     */   private transient BigDecimal onHandQuantity_;
/*  48 */   private transient String styleId_ = null;
/*  49 */   private transient String dimension1 = null;
/*  50 */   private transient String dimension2 = null;
/*  51 */   private transient String dimension3 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDocumentInventoryLocationModifier(IDocumentInventoryLocationModifier argModifier) {
/*  57 */     synchronized (this) {
/*  58 */       long currentMax = 0L;
/*     */       
/*  60 */       for (IDocumentInventoryLocationModifier mod : getDocumentInventoryLocationModifiers()) {
/*  61 */         if (currentMax < mod.getModifierSequence()) {
/*  62 */           currentMax = mod.getModifierSequence();
/*     */         }
/*     */       } 
/*     */       
/*  66 */       argModifier.setModifierSequence(currentMax + 1L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDocumentLineItemNote(IDocumentLineItemNote argDocumentLineItemNote) {
/*  73 */     synchronized (this) {
/*     */       
/*  75 */       if (!DaoUtils.contains(getNotes(), (IDataModel)argDocumentLineItemNote)) {
/*  76 */         argDocumentLineItemNote.setNoteId(getNextNoteId(getNotes()) + 1L);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInventoryDocumentLineSerial(IInventoryDocumentLineSerial argSerialNumber) {
/*  85 */     synchronized (this) {
/*  86 */       int currentMax = 0;
/*     */       
/*  88 */       for (IInventoryDocumentLineSerial serial : getSerialNumbers()) {
/*  89 */         if (currentMax < serial.getSerialLineNumber()) {
/*  90 */           currentMax = serial.getSerialLineNumber();
/*     */         }
/*     */       } 
/*     */       
/*  94 */       argSerialNumber.setSerialLineNumber(currentMax + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 103 */     if (argModifier instanceof IDocumentInventoryLocationModifier) {
/* 104 */       addDocumentInventoryLocationModifier((IDocumentInventoryLocationModifier)argModifier);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTemp() {
/* 111 */     if (this.tempUnitCount_ != null && !NumberUtils.equivalent(getUnitCount(), this.tempUnitCount_)) {
/* 112 */       setUnitCount(this.tempUnitCount_);
/*     */     }
/*     */     
/* 115 */     if (this.tempPostedCount_ != null && !NumberUtils.equivalent(getPostedCount(), this.tempPostedCount_)) {
/* 116 */       setPostedCount(this.tempPostedCount_);
/*     */     }
/*     */     
/* 119 */     if (this.tempStatusCode_ != null && !ObjectUtils.equivalent(getStatusCode(), this.tempStatusCode_)) {
/* 120 */       setStatusCode(this.tempStatusCode_);
/*     */     }
/*     */     
/* 123 */     if (this.tempUnitCost_ != null && !NumberUtils.equivalent(getUnitCost(), this.tempUnitCost_)) {
/* 124 */       setUnitCost(this.tempUnitCost_);
/*     */     }
/*     */     
/* 127 */     if (this.tempPostedCost_ != null && !NumberUtils.equivalent(getPostedCost(), this.tempPostedCost_)) {
/* 128 */       setPostedCost(this.tempPostedCost_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers() {
/* 137 */     return getDocumentInventoryLocationModifiers();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 143 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 145 */     if (getParentDocument().getNotes() != null && !getParentDocument().getNotes().isEmpty()) {
/* 146 */       for (IDocumentNote note : getParentDocument().getNotes()) {
/* 147 */         sb.append(note.getNote() + " ");
/*     */       }
/*     */     }
/*     */     
/* 151 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCostToAllocate() {
/* 160 */     return this.costToAllocate_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICustomerItemAccountDetail getCustItemAcctDetail() {
/* 166 */     return this.custItemAcctDetail_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension1() {
/* 175 */     return this.dimension1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension2() {
/* 184 */     return this.dimension2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension3() {
/* 193 */     return this.dimension3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IInventoryAccountModifier getInventoryAccountModifier() {
/* 199 */     return (IInventoryAccountModifier)getCustomerItemAccountMod();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IItem getInventoryItem() {
/* 205 */     if (this.item_ == null && getInventoryItemId() != null && !this.unmanageable_) {
/* 206 */       ItemId itemId = new ItemId();
/*     */       
/* 208 */       itemId.setItemId(getInventoryItemId());
/* 209 */       setItem((IItem)ObjectManager.getInstance().getManagedObject((IObjectId)itemId));
/*     */       
/* 211 */       if (this.item_ == null) {
/* 212 */         this.unmanageable_ = true;
/*     */       }
/*     */     } 
/*     */     
/* 216 */     return this.item_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IItem getItem() {
/* 222 */     return getInventoryItem();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemDescription() {
/* 228 */     return (getEnteredItemDescription() != null) ? getEnteredItemDescription() : 
/* 229 */       getInventoryItem().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemDimensionValue(int argIndex) {
/* 235 */     if (getInventoryItem() == null) {
/* 236 */       return null;
/*     */     }
/*     */     
/* 239 */     return getInventoryItem().getItemDimensionValue(argIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 245 */     return (getEnteredItemId() != null) ? getEnteredItemId() : getInventoryItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineItemSequence() {
/* 251 */     return getInventoryDocumentLineNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers() {
/* 258 */     HistoricalList<IDocumentInventoryLocationModifier> invModifiers = (HistoricalList<IDocumentInventoryLocationModifier>)getDocumentInventoryLocationModifiers();
/*     */     
/* 260 */     if (invModifiers == null || invModifiers.getAddedItems() == null) {
/* 261 */       return new ArrayList<>();
/*     */     }
/*     */     
/* 264 */     return invModifiers.getAddedItems();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOnHandQuantity() {
/* 274 */     return this.onHandQuantity_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOrderModifier getOrderModifier() {
/* 280 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityToAllocate() {
/* 286 */     return this.quantityToAllocate_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReturnReasonCode() {
/* 292 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumbersAsString() {
/* 301 */     StringBuffer buf = new StringBuffer();
/*     */     
/* 303 */     for (IInventoryDocumentLineSerial serial : getSerialNumbers()) {
/* 304 */       buf.append(serial.getSerialNumber());
/* 305 */       buf.append(", ");
/*     */     } 
/*     */     
/* 308 */     if (buf.length() > 0) {
/* 309 */       buf.delete(buf.length() - 2, buf.length() - 1);
/*     */     }
/*     */     
/* 312 */     return buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumbersString() {
/* 318 */     if (getSerialNumbers().isEmpty()) {
/* 319 */       return null;
/*     */     }
/*     */     
/* 322 */     StringBuilder buf = new StringBuilder();
/*     */     
/* 324 */     for (Iterator<IInventoryDocumentLineSerial> it = getSerialNumbers().iterator(); it.hasNext(); ) {
/* 325 */       IInventoryDocumentLineSerial serial = it.next();
/* 326 */       buf.append(serial.getSerialNumber());
/*     */       
/* 328 */       if (it.hasNext()) {
/* 329 */         buf.append(", ");
/*     */       }
/*     */     } 
/*     */     
/* 333 */     return buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStyleId() {
/* 342 */     return this.styleId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTempPostedCost() {
/* 348 */     return this.tempPostedCost_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTempPostedCount() {
/* 354 */     return this.tempPostedCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTempStatusCode() {
/* 360 */     return this.tempStatusCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTempUnitCost() {
/* 366 */     return this.tempUnitCost_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTempUnitCount() {
/* 372 */     return this.tempUnitCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncomingInventoryProcessed() {
/* 378 */     return this.incomingInventoryProcessed_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 385 */     if (argModifier instanceof IDocumentInventoryLocationModifier) {
/* 386 */       removeDocumentInventoryLocationModifier((IDocumentInventoryLocationModifier)argModifier);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCostToAllocate(BigDecimal argCost) {
/* 396 */     this.costToAllocate_ = argCost;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustItemAcctDetail(ICustomerItemAccountDetail argDetail) {
/* 402 */     if (argDetail != null && this.custItemAcctDetail_ == null) {
/* 403 */       this.custItemAcctDetail_ = argDetail;
/*     */       
/* 405 */       setLineItemBusinessDate(argDetail.getRetailLineItem().getBusinessDate());
/* 406 */       setLineItemRetailLocationId(
/* 407 */           Long.valueOf(argDetail.getRetailLineItem().getRetailLocationId()).intValue());
/* 408 */       setLineItemRetailTransactionLineItemSequence(argDetail
/* 409 */           .getRetailLineItem().getRetailTransactionLineItemSequence());
/* 410 */       setLineItemTransactionSequence(argDetail.getRetailLineItem().getTransactionSequence());
/* 411 */       setLineItemWorkstationId(argDetail.getRetailLineItem().getWorkstationId());
/* 412 */       setLineItemTypeCode(argDetail.getRetailLineItem().getLineItemTypeCode());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerItemAccountMod(IInventoryItemAccountModifier newValue) {
/* 419 */     InventoryItemAccountModifierId id = new InventoryItemAccountModifierId();
/*     */     
/* 421 */     id.setDocumentId(getDocumentId());
/* 422 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 423 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/* 424 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*     */     
/* 426 */     newValue.setObjectId((IObjectId)id);
/* 427 */     newValue.setParentLine(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension1(String argDim1) {
/* 433 */     this.dimension1 = argDim1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension2(String argDim2) {
/* 439 */     this.dimension2 = argDim2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension3(String argDim3) {
/* 445 */     this.dimension3 = argDim3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncomingInventoryProcessed(boolean argProcessed) {
/* 451 */     this.incomingInventoryProcessed_ = argProcessed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryItem(IItem argInventoryItem) {
/* 457 */     if (argInventoryItem == null) {
/*     */       return;
/*     */     }
/*     */     
/* 461 */     setInventoryItemId(argInventoryItem.getItemId());
/*     */     
/* 463 */     ObjectManager.getInstance().manageObject((IDataModel)argInventoryItem);
/* 464 */     this.item_ = argInventoryItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItem(IItem argItem) {
/* 470 */     this.item_ = argItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnHandQuantity(BigDecimal argOnHandQty) {
/* 476 */     this.onHandQuantity_ = argOnHandQty;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityToAllocate(BigDecimal argQuantity) {
/* 482 */     this.quantityToAllocate_ = argQuantity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyleId(String arg0) {
/* 488 */     this.styleId_ = arg0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempPostedCost(BigDecimal newValue) {
/* 494 */     this.tempPostedCost_ = newValue;
/* 495 */     this._events.post(IInventoryDocumentLineItem.SET_UNITCOST, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempPostedCount(BigDecimal newValue) {
/* 501 */     this.tempPostedCount_ = newValue;
/* 502 */     this._events.post(IInventoryDocumentLineItem.SET_POSTEDCOUNT, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempStatusCode(String newValue) {
/* 508 */     this.tempStatusCode_ = newValue;
/* 509 */     this._events.post(IInventoryDocumentLineItem.SET_STATUSCODE, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempUnitCost(BigDecimal newValue) {
/* 515 */     this.tempUnitCost_ = newValue;
/* 516 */     this._events.post(IInventoryDocumentLineItem.SET_UNITCOST, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempUnitCount(BigDecimal newValue) {
/* 522 */     this.tempUnitCount_ = newValue;
/* 523 */     this._events.post(IInventoryDocumentLineItem.SET_UNITCOUNT, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startTemp() {
/* 529 */     this.tempUnitCount_ = getUnitCount();
/* 530 */     this.tempPostedCount_ = getPostedCount();
/* 531 */     this.tempUnitCost_ = getUnitCost();
/* 532 */     this.tempPostedCost_ = getPostedCost();
/*     */     
/* 534 */     if (getStatusCode() != null) {
/* 535 */       this.tempStatusCode_ = getStatusCode();
/*     */     }
/*     */   }
/*     */   
/*     */   private long getNextNoteId(List<IDocumentLineItemNote> argNotes) {
/* 540 */     long index = 0L;
/* 541 */     for (IDocumentLineItemNote note : argNotes) {
/* 542 */       if (note.getNoteId() > index) {
/* 543 */         index = note.getNoteId();
/*     */       }
/*     */     } 
/*     */     
/* 547 */     return index;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */