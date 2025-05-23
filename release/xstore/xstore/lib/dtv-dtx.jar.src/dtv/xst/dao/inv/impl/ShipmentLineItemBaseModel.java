/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectManager;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import dtv.xst.dao.inv.IShipment;
/*     */ import dtv.xst.dao.inv.IShipmentLineItem;
/*     */ import dtv.xst.dao.inv.IShipmentLineItemModel;
/*     */ import dtv.xst.dao.inv.IShipmentLineItemProperty;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineItemId;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ShipmentLineItemBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IShipmentLineItemProperty>
/*     */   implements IShipmentLineItem, IShipmentLineItemModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient BigDecimal tempShipQuantity_;
/*     */   private transient String tempStatusCode_;
/*     */   private transient IInventoryDocumentLineItem _docLineItem;
/*     */   private transient boolean _unmanageableDocLine = false;
/*     */   
/*     */   public void commitTemp() {
/*  35 */     if (!ObjectUtils.equivalent(getShipQuantity(), this.tempShipQuantity_)) {
/*  36 */       setShipQuantity(this.tempShipQuantity_);
/*     */     }
/*     */     
/*  39 */     if (!ObjectUtils.equivalent(getStatusCode(), this.tempStatusCode_)) {
/*  40 */       setStatusCode(this.tempStatusCode_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IInventoryDocumentLineItem getInventoryLineItem() {
/*  47 */     IShipment parentShipment = getParentShipment();
/*  48 */     IInventoryDocument parentDocument = null;
/*     */     
/*  50 */     if (this._docLineItem == null) {
/*  51 */       if (parentShipment != null) {
/*  52 */         parentDocument = parentShipment.getParentDocument();
/*     */       }
/*     */       
/*  55 */       if (parentDocument != null) {
/*  56 */         for (IInventoryDocumentLineItem lineItem : parentDocument.getInventoryDocumentLineItems()) {
/*  57 */           if (lineItem.getInventoryDocumentLineNumber() == getInventoryDocumentLineNumber()) {
/*  58 */             this._docLineItem = lineItem;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*  63 */       } else if (!this._unmanageableDocLine) {
/*  64 */         InventoryDocumentLineItemId id = new InventoryDocumentLineItemId();
/*  65 */         id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  66 */         id.setDocumentId(getDocumentId());
/*  67 */         id.setDocumentTypeCode(getDocumentTypeCode());
/*  68 */         id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/*     */         
/*  70 */         IInventoryDocumentLineItem docLine = (IInventoryDocumentLineItem)ObjectManager.getInstance().getManagedObject((IObjectId)id);
/*     */         
/*  72 */         if (docLine == null) {
/*  73 */           this._unmanageableDocLine = true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  80 */         ObjectManager.getInstance().unmanageObject(docLine);
/*  81 */         this._docLineItem = docLine;
/*     */       } 
/*     */     } 
/*     */     
/*  85 */     return this._docLineItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTempShipQuantity() {
/*  91 */     return this.tempShipQuantity_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTempStatusCode() {
/*  97 */     return this.tempStatusCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempShipQuantity(BigDecimal newValue) {
/* 103 */     this.tempShipQuantity_ = newValue;
/* 104 */     this._events.post(IShipmentLineItem.SET_SHIPQUANTITY, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempStatusCode(String newValue) {
/* 110 */     this.tempStatusCode_ = newValue;
/* 111 */     this._events.post(IShipmentLineItem.SET_STATUSCODE, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startTemp() {
/* 117 */     if (getShipQuantity() != null) {
/* 118 */       this.tempShipQuantity_ = getShipQuantity();
/*     */     }
/*     */     
/* 121 */     if (getStatusCode() != null)
/* 122 */       this.tempStatusCode_ = getStatusCode(); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentLineItemBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */