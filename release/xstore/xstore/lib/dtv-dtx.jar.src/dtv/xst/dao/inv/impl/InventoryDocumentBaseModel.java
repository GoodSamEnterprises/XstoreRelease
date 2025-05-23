/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.inv.ICarton;
/*     */ import dtv.xst.dao.inv.IDocumentNote;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentModel;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentProperty;
/*     */ import dtv.xst.dao.inv.IShipment;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class InventoryDocumentBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IInventoryDocumentProperty>
/*     */   implements IInventoryDocument, IInventoryDocumentModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient String tempStatusCode_;
/*     */   private transient boolean expectedDeliveryDateSet = false;
/*     */   private transient boolean actualDeliveryDateSet = false;
/*     */   private transient Date expectedDeliveryDate;
/*     */   private transient Date actualDeliveryDate;
/*     */   
/*     */   public void addCarton(ICarton carton) {
/*  36 */     synchronized (this) {
/*     */       
/*  38 */       if (!"CLOSED".equals(carton.getTempCartonStatusCode()) && 
/*  39 */         getTempStatusCode() != null) {
/*  40 */         carton.setTempCartonStatusCode(getTempStatusCode());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDocumentNote(IDocumentNote documentNote) {
/*  49 */     synchronized (this) {
/*  50 */       documentNote.setNoteId((getNotes().size() + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInventoryDocumentLineItem(IInventoryDocumentLineItem lineItem) {
/*  57 */     lineItem.setParentDocument(this);
/*     */     
/*  59 */     synchronized (this) {
/*     */       
/*  61 */       if (getDocumentTypeCode().equalsIgnoreCase("INVENTORY_COUNT") || 
/*  62 */         !listContains(getInventoryDocumentLineItems(), lineItem)) {
/*  63 */         lineItem.setInventoryDocumentLineNumber(getInventoryDocumentLineItems().size() + 1);
/*     */ 
/*     */         
/*  66 */         if (!isInactiveStatus(lineItem.getTempStatusCode())) {
/*  67 */           lineItem.setTempStatusCode(getTempStatusCode());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addShipment(IShipment shipment) {
/*  77 */     synchronized (this) {
/*     */       
/*  79 */       shipment.setShipmentSequence(getShipments().size() + 1);
/*     */ 
/*     */       
/*  82 */       if (!isInactiveStatus(shipment.getTempShipmentStatusCode())) {
/*  83 */         shipment.setTempShipmentStatusCode(getTempStatusCode());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTemp() {
/*  91 */     if (this.tempStatusCode_ != null && !ObjectUtils.equivalent(getStatusCode(), this.tempStatusCode_)) {
/*  92 */       setStatusCode(this.tempStatusCode_);
/*     */     }
/*     */     
/*  95 */     for (IInventoryDocumentLineItem item : getInventoryDocumentLineItems()) {
/*  96 */       item.commitTemp();
/*     */     }
/*     */     
/*  99 */     for (IShipment shipment : getShipments()) {
/* 100 */       shipment.commitTemp();
/*     */     }
/*     */     
/* 103 */     for (ICarton carton : getCartons()) {
/* 104 */       carton.commitTemp();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getActualDeliveryDate() {
/* 114 */     if (!this.actualDeliveryDateSet) {
/* 115 */       for (IShipment shipment : getShipments()) {
/* 116 */         Date d = shipment.getActualDeliveryDate();
/*     */         
/* 118 */         if (d != null && (
/* 119 */           this.actualDeliveryDate == null || d.before(this.actualDeliveryDate))) {
/* 120 */           this.actualDeliveryDate = d;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 125 */       this.actualDeliveryDateSet = true;
/*     */     } 
/*     */     
/* 128 */     return this.actualDeliveryDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpectedDeliveryDate() {
/* 134 */     if (!this.expectedDeliveryDateSet) {
/* 135 */       for (IShipment shipment : getShipments()) {
/* 136 */         Date d = shipment.getExpectedDeliveryDate();
/*     */         
/* 138 */         if (d != null && (
/* 139 */           this.expectedDeliveryDate == null || d.before(this.expectedDeliveryDate))) {
/* 140 */           this.expectedDeliveryDate = d;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 145 */       this.expectedDeliveryDateSet = true;
/*     */     } 
/*     */     
/* 148 */     return this.expectedDeliveryDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNotesContent() {
/* 154 */     if (getNotes() != null && !getNotes().isEmpty()) {
/* 155 */       StringBuffer sb = new StringBuffer();
/*     */       
/* 157 */       for (Object element : getNotes()) {
/* 158 */         IDocumentNote note = (IDocumentNote)element;
/* 159 */         sb.append(note.getNote());
/* 160 */         sb.append(" ");
/*     */       } 
/*     */       
/* 163 */       return sb.toString();
/*     */     } 
/*     */     
/* 166 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTempStatusCode() {
/* 172 */     return this.tempStatusCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActualDeliveryDate(Date documentDate) {
/* 181 */     this.actualDeliveryDate = documentDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpectedDeliveryDate(Date documentDate) {
/* 187 */     this.expectedDeliveryDate = documentDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempStatusCode(String newValue) {
/* 193 */     this.tempStatusCode_ = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startTemp() {
/* 199 */     if (getStatusCode() != null) {
/* 200 */       this.tempStatusCode_ = getStatusCode();
/*     */     }
/*     */     
/* 203 */     for (IInventoryDocumentLineItem item : getInventoryDocumentLineItems()) {
/* 204 */       item.startTemp();
/*     */     }
/*     */     
/* 207 */     for (IShipment shipment : getShipments()) {
/* 208 */       shipment.startTemp();
/*     */     }
/*     */     
/* 211 */     for (ICarton carton : getCartons()) {
/* 212 */       carton.startTemp();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInactiveStatus(String argStatus) {
/* 223 */     return ("CLOSED".equalsIgnoreCase(argStatus) || "VOID"
/* 224 */       .equalsIgnoreCase(argStatus));
/*     */   }
/*     */   
/*     */   private <T extends IDataModel> boolean listContains(List<T> list, T searchTarget) {
/* 228 */     boolean results = false;
/* 229 */     Object targetObjectId = searchTarget.getObjectId();
/*     */     
/* 231 */     for (Iterator<T> iter = list.iterator(); iter.hasNext(); ) {
/* 232 */       IDataModel item = (IDataModel)iter.next();
/*     */       
/* 234 */       if (item.getObjectId().equals(targetObjectId)) {
/* 235 */         results = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 240 */     return results;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */