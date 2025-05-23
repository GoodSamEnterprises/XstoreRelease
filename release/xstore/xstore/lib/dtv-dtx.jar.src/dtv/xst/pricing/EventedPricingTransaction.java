/*     */ package dtv.xst.pricing;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventList;
/*     */ import dtv.event.IEventFinder;
/*     */ import dtv.pricing2.IResult;
/*     */ import dtv.pricing2.PricingDeal;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.doc.IDocumentLineItem;
/*     */ import dtv.xst.dao.trl.ICouponLineItem;
/*     */ import dtv.xst.dao.trl.IRetailTransaction;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EventedPricingTransaction
/*     */   extends EventHandler
/*     */ {
/*     */   protected final IPosTransaction _nativeTransaction;
/*     */   
/*     */   public EventedPricingTransaction(IPosTransaction argTransaction) {
/*  36 */     this._nativeTransaction = argTransaction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTransactionSaleCompleteTrigger() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract IResult calculateItemDeals();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract IResult calculateTransactionDeals();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PricingDeal> getActiveDeals() {
/*  64 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTransactionSaleCompleteTrigger() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void addCoupon(ICouponLineItem paramICouponLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void addCustomer(IParty paramIParty);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void addDocument(IDocumentLineItem paramIDocumentLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addItem(ISaleReturnLineItem argItem) {
/*  99 */     registerHandler((IRetailTransactionLineItem)argItem);
/* 100 */     addItemImpl(argItem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void addItemImpl(ISaleReturnLineItem paramISaleReturnLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addLineItem(IRetailTransactionLineItem argItem) {
/* 116 */     registerHandler(argItem);
/* 117 */     addLineItemImpl(argItem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void addLineItemImpl(IRetailTransactionLineItem paramIRetailTransactionLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterHandler(IRetailTransactionLineItem argItem) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IPosTransaction getTransaction() {
/* 140 */     return this._nativeTransaction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handle(Event argEvent) {
/* 146 */     handle(argEvent, new HashSet<>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handle(Event argEvent, Set<IRetailTransactionLineItem> argRefreshed) {
/* 156 */     Object payload = argEvent.getPayload();
/* 157 */     if (payload instanceof EventList) {
/* 158 */       EventList events = (EventList)payload;
/* 159 */       List<IEventFinder> elements = events.getElements();
/* 160 */       for (IEventFinder finder : elements) {
/* 161 */         handle(finder.getBaseEvent(), argRefreshed);
/*     */       }
/*     */     } else {
/*     */       
/* 165 */       Object eventName = argEvent.getName();
/* 166 */       if (eventName == IPosTransaction.ADD_RETAILTRANSACTIONLINEITEMS) {
/* 167 */         handleAddLineItem(argEvent);
/*     */       }
/* 169 */       else if (eventName == IPosTransaction.REMOVE_RETAILTRANSACTIONLINEITEMS) {
/* 170 */         handleRemoveLineItem(argEvent);
/*     */       }
/* 172 */       else if (eventName == IRetailTransaction.SET_CUSTOMERPARTY) {
/* 173 */         handleSetCustomer(argEvent);
/*     */       }
/* 175 */       else if (eventName == IRetailTransactionLineItem.SET_VOID) {
/* 176 */         handleSetVoid(argEvent);
/*     */       }
/* 178 */       else if (eventName == ISaleReturnLineItem.SET_QUANTITY) {
/* 179 */         ISaleReturnLineItem source = (ISaleReturnLineItem)argEvent.getSource(ISaleReturnLineItem.class);
/*     */         
/* 181 */         setQuantity(source, Integer.valueOf(((BigDecimal)payload).intValue()));
/*     */       } 
/* 183 */       if (eventName == ISaleReturnLineItem.SET_UNITPRICE) {
/* 184 */         ISaleReturnLineItem source = (ISaleReturnLineItem)argEvent.getSource(ISaleReturnLineItem.class);
/* 185 */         setUnitPrice(source, (BigDecimal)payload);
/*     */       } 
/* 187 */       if (eventName == ISaleReturnLineItem.SET_EXTENDEDAMOUNT) {
/* 188 */         ISaleReturnLineItem source = (ISaleReturnLineItem)argEvent.getSource(ISaleReturnLineItem.class);
/* 189 */         setExtendedAmount(source, (BigDecimal)payload);
/*     */       } else {
/*     */         
/* 192 */         Object source = argEvent.getSource();
/* 193 */         if (source != null && !argRefreshed.contains(source)) {
/* 194 */           if (source instanceof ISaleReturnLineItem) {
/* 195 */             ISaleReturnLineItem saleItem = (ISaleReturnLineItem)source;
/* 196 */             updateItem(saleItem);
/* 197 */             argRefreshed.add(saleItem);
/*     */           }
/* 199 */           else if (source instanceof IRetailTransactionLineItem) {
/* 200 */             IRetailTransactionLineItem lineItem = (IRetailTransactionLineItem)source;
/* 201 */             updateLineItem(lineItem);
/* 202 */             argRefreshed.add(lineItem);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleAddLineItem(Event argEvent) {
/* 215 */     Object payload = argEvent.getPayload();
/* 216 */     if (payload instanceof IRetailTransactionLineItem) {
/* 217 */       if (payload instanceof ICouponLineItem) {
/* 218 */         addCoupon((ICouponLineItem)payload);
/*     */       }
/* 220 */       else if (payload instanceof IDocumentLineItem) {
/* 221 */         addDocument((IDocumentLineItem)payload);
/*     */       }
/* 223 */       else if (payload instanceof ISaleReturnLineItem) {
/*     */         
/* 225 */         addItem((ISaleReturnLineItem)payload);
/*     */       } else {
/*     */         
/* 228 */         addLineItem((IRetailTransactionLineItem)payload);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleRemoveLineItem(Event argEvent) {
/* 239 */     Object payload = argEvent.getPayload();
/* 240 */     if (payload instanceof IRetailTransactionLineItem) {
/* 241 */       if (payload instanceof ICouponLineItem) {
/* 242 */         removeCoupon((ICouponLineItem)payload);
/*     */       }
/* 244 */       else if (payload instanceof IDocumentLineItem) {
/* 245 */         removeDocument((IDocumentLineItem)payload);
/*     */       }
/* 247 */       else if (payload instanceof ISaleReturnLineItem) {
/* 248 */         removeItem((ISaleReturnLineItem)payload);
/*     */       } else {
/*     */         
/* 251 */         removeLineItem((IRetailTransactionLineItem)payload);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleSetCustomer(Event argEvent) {
/* 263 */     IParty newCustomer = (IParty)argEvent.getPayload();
/* 264 */     if (newCustomer == null) {
/* 265 */       removeCustomer();
/*     */     } else {
/*     */       
/* 268 */       addCustomer(newCustomer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleSetVoid(Event argEvent) {
/* 278 */     Object source = argEvent.getSource();
/*     */     
/* 280 */     Object payload = argEvent.getPayload();
/* 281 */     boolean flag = (payload != null && ((Boolean)payload).booleanValue());
/*     */     
/* 283 */     if (source instanceof ISaleReturnLineItem) {
/* 284 */       ISaleReturnLineItem item = (ISaleReturnLineItem)source;
/* 285 */       if (flag) {
/* 286 */         removeItem(item);
/*     */       } else {
/*     */         
/* 289 */         addItem(item);
/*     */       } 
/*     */     } else {
/*     */       
/* 293 */       IRetailTransactionLineItem item = (IRetailTransactionLineItem)source;
/* 294 */       if (flag) {
/* 295 */         removeLineItem(item);
/*     */       } else {
/*     */         
/* 298 */         addLineItem(item);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerHandler(IRetailTransactionLineItem argItem) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void removeCoupon(ICouponLineItem paramICouponLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void removeCustomer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void removeDocument(IDocumentLineItem paramIDocumentLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeItem(ISaleReturnLineItem argItem) {
/* 335 */     deregisterHandler((IRetailTransactionLineItem)argItem);
/* 336 */     removeItemImpl(argItem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void removeItemImpl(ISaleReturnLineItem paramISaleReturnLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void removeLineItemImpl(IRetailTransactionLineItem paramIRetailTransactionLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setExtendedAmount(ISaleReturnLineItem paramISaleReturnLineItem, BigDecimal paramBigDecimal);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setQuantity(ISaleReturnLineItem paramISaleReturnLineItem, Integer paramInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setUnitPrice(ISaleReturnLineItem paramISaleReturnLineItem, BigDecimal paramBigDecimal);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void updateItem(ISaleReturnLineItem paramISaleReturnLineItem);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateLineItem(IRetailTransactionLineItem argLineItem) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void removeLineItem(IRetailTransactionLineItem argItem) {
/* 397 */     deregisterHandler(argItem);
/* 398 */     removeLineItemImpl(argItem);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\EventedPricingTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */