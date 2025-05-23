/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.xst.dao.itm.IItem;
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
/*     */ public class InventoryItemTransferResult
/*     */   extends AbstractQueryResult
/*     */   implements IEventSource
/*     */ {
/*  27 */   public static final EventEnum SET_TRANSFER_QUANTITY = new EventEnum("set transferQuantity");
/*     */   
/*     */   private static final long serialVersionUID = 8675309L;
/*  30 */   private transient Eventor events_ = (Eventor)new DefaultEventor(this);
/*     */   private String itemId_;
/*     */   private String itemDescription_;
/*     */   private BigDecimal currentQuantity_;
/*     */   private BigDecimal transferQuantity_;
/*     */   private Boolean serializedItem_;
/*     */   private String serialNumber_;
/*  37 */   private Date updateDate_ = new Date();
/*     */ 
/*     */ 
/*     */   
/*     */   private IItem item_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCurrentQuantity() {
/*  47 */     return this.currentQuantity_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IItem getItem() {
/*  56 */     return this.item_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemDescription() {
/*  65 */     return this.itemDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  74 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  83 */     return this.serialNumber_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTransferQuantity() {
/*  92 */     return NumberUtils.nonNull(this.transferQuantity_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 101 */     return this.updateDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSerializedItem() {
/* 110 */     return this.serializedItem_.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentQuantity(BigDecimal argCurrentQuantity) {
/* 119 */     this.currentQuantity_ = argCurrentQuantity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItem(IItem argItem) {
/* 128 */     this.item_ = argItem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemDescription(String argItemDescription) {
/* 137 */     this.itemDescription_ = argItemDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 146 */     this.itemId_ = argItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerializedItem(Boolean argSerializedItem) {
/* 155 */     this.serializedItem_ = argSerializedItem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 164 */     this.serialNumber_ = argSerialNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransferQuantity(BigDecimal argTransferQuantity) {
/* 173 */     this.updateDate_ = new Date();
/*     */ 
/*     */ 
/*     */     
/* 177 */     if ((this.transferQuantity_ == null && argTransferQuantity != null) || (this.transferQuantity_ != null && 
/* 178 */       !this.transferQuantity_.equals(argTransferQuantity))) {
/* 179 */       this.transferQuantity_ = argTransferQuantity;
/* 180 */       this.events_.post(SET_TRANSFER_QUANTITY, argTransferQuantity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 191 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 197 */     this.events_ = (Eventor)new DefaultEventor(this);
/*     */     
/* 199 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\InventoryItemTransferResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */