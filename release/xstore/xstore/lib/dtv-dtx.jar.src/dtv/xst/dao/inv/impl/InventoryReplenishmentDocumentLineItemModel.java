/*      */ package dtv.xst.dao.inv.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*      */ import dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItem;
/*      */ import dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItemProperty;
/*      */ import dtv.xst.dao.inv.InventoryReplenishmentDocumentLineItemPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class InventoryReplenishmentDocumentLineItemModel extends AbstractDataModelWithPropertyImpl<IInventoryReplenishmentDocumentLineItemProperty> implements IInventoryReplenishmentDocumentLineItem {
/*      */   private static final long serialVersionUID = 1339662122L;
/*      */   private IInventoryDocumentLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryReplenishmentDocumentLineItemProperty> _properties; private transient HistoricalList<IInventoryReplenishmentDocumentLineItemProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new InventoryReplenishmentDocumentLineItemDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InventoryReplenishmentDocumentLineItemDAO getDAO_() {
/*   48 */     return (InventoryReplenishmentDocumentLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentId() {
/*   56 */     return getDAO_().getDocumentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentId(String argDocumentId) {
/*   64 */     if (setDocumentId_noev(argDocumentId) && 
/*   65 */       this._events != null && 
/*   66 */       postEventsForChanges()) {
/*   67 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_DOCUMENTID, argDocumentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentId_noev(String argDocumentId) {
/*   74 */     boolean ev_postable = false;
/*      */     
/*   76 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*   77 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*   78 */       getDAO_().setDocumentId(argDocumentId);
/*   79 */       ev_postable = true;
/*   80 */       if (this._properties != null) {
/*      */         
/*   82 */         Iterator<InventoryReplenishmentDocumentLineItemPropertyModel> it = this._properties.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((InventoryReplenishmentDocumentLineItemPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   90 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentTypeCode() {
/*   98 */     return getDAO_().getDocumentTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  106 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/*  107 */       this._events != null && 
/*  108 */       postEventsForChanges()) {
/*  109 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/*  116 */     boolean ev_postable = false;
/*      */     
/*  118 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/*  119 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/*  120 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/*  121 */       ev_postable = true;
/*  122 */       if (this._properties != null) {
/*      */         
/*  124 */         Iterator<InventoryReplenishmentDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  125 */         while (it.hasNext())
/*      */         {
/*  127 */           ((InventoryReplenishmentDocumentLineItemPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  132 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInventoryDocumentLineNumber() {
/*  140 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/*  141 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*      */     }
/*      */     
/*  144 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/*  153 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/*  154 */       this._events != null && 
/*  155 */       postEventsForChanges()) {
/*  156 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/*  163 */     boolean ev_postable = false;
/*      */     
/*  165 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/*  166 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/*  167 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/*  168 */       ev_postable = true;
/*  169 */       if (this._properties != null) {
/*      */         
/*  171 */         Iterator<InventoryReplenishmentDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  172 */         while (it.hasNext())
/*      */         {
/*  174 */           ((InventoryReplenishmentDocumentLineItemPropertyModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  179 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  187 */     if (getDAO_().getOrganizationId() != null) {
/*  188 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  191 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  200 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  201 */       this._events != null && 
/*  202 */       postEventsForChanges()) {
/*  203 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  210 */     boolean ev_postable = false;
/*      */     
/*  212 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  213 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  214 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  215 */       ev_postable = true;
/*  216 */       if (this._properties != null) {
/*      */         
/*  218 */         Iterator<InventoryReplenishmentDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  219 */         while (it.hasNext())
/*      */         {
/*  221 */           ((InventoryReplenishmentDocumentLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  226 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  234 */     if (getDAO_().getRetailLocationId() != null) {
/*  235 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  238 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  247 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  248 */       this._events != null && 
/*  249 */       postEventsForChanges()) {
/*  250 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  257 */     boolean ev_postable = false;
/*      */     
/*  259 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  260 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  261 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  262 */       ev_postable = true;
/*  263 */       if (this._properties != null) {
/*      */         
/*  265 */         Iterator<InventoryReplenishmentDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  266 */         while (it.hasNext())
/*      */         {
/*  268 */           ((InventoryReplenishmentDocumentLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  273 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getSuggestedOrderQuantity() {
/*  281 */     return getDAO_().getSuggestedOrderQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSuggestedOrderQuantity(BigDecimal argSuggestedOrderQuantity) {
/*  289 */     if (setSuggestedOrderQuantity_noev(argSuggestedOrderQuantity) && 
/*  290 */       this._events != null && 
/*  291 */       postEventsForChanges()) {
/*  292 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SUGGESTEDORDERQUANTITY, argSuggestedOrderQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSuggestedOrderQuantity_noev(BigDecimal argSuggestedOrderQuantity) {
/*  299 */     boolean ev_postable = false;
/*      */     
/*  301 */     if ((getDAO_().getSuggestedOrderQuantity() == null && argSuggestedOrderQuantity != null) || (
/*  302 */       getDAO_().getSuggestedOrderQuantity() != null && !getDAO_().getSuggestedOrderQuantity().equals(argSuggestedOrderQuantity))) {
/*  303 */       getDAO_().setSuggestedOrderQuantity(argSuggestedOrderQuantity);
/*  304 */       ev_postable = true;
/*      */     } 
/*      */     
/*  307 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOrderQuantity() {
/*  315 */     return getDAO_().getOrderQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderQuantity(BigDecimal argOrderQuantity) {
/*  323 */     if (setOrderQuantity_noev(argOrderQuantity) && 
/*  324 */       this._events != null && 
/*  325 */       postEventsForChanges()) {
/*  326 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_ORDERQUANTITY, argOrderQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderQuantity_noev(BigDecimal argOrderQuantity) {
/*  333 */     boolean ev_postable = false;
/*      */     
/*  335 */     if ((getDAO_().getOrderQuantity() == null && argOrderQuantity != null) || (
/*  336 */       getDAO_().getOrderQuantity() != null && !getDAO_().getOrderQuantity().equals(argOrderQuantity))) {
/*  337 */       getDAO_().setOrderQuantity(argOrderQuantity);
/*  338 */       ev_postable = true;
/*      */     } 
/*      */     
/*  341 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getConfirmedQuantity() {
/*  349 */     return getDAO_().getConfirmedQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConfirmedQuantity(BigDecimal argConfirmedQuantity) {
/*  357 */     if (setConfirmedQuantity_noev(argConfirmedQuantity) && 
/*  358 */       this._events != null && 
/*  359 */       postEventsForChanges()) {
/*  360 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_CONFIRMEDQUANTITY, argConfirmedQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setConfirmedQuantity_noev(BigDecimal argConfirmedQuantity) {
/*  367 */     boolean ev_postable = false;
/*      */     
/*  369 */     if ((getDAO_().getConfirmedQuantity() == null && argConfirmedQuantity != null) || (
/*  370 */       getDAO_().getConfirmedQuantity() != null && !getDAO_().getConfirmedQuantity().equals(argConfirmedQuantity))) {
/*  371 */       getDAO_().setConfirmedQuantity(argConfirmedQuantity);
/*  372 */       ev_postable = true;
/*      */     } 
/*      */     
/*  375 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getConfirmationDate() {
/*  383 */     return getDAO_().getConfirmationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConfirmationDate(Date argConfirmationDate) {
/*  391 */     if (setConfirmationDate_noev(argConfirmationDate) && 
/*  392 */       this._events != null && 
/*  393 */       postEventsForChanges()) {
/*  394 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_CONFIRMATIONDATE, argConfirmationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setConfirmationDate_noev(Date argConfirmationDate) {
/*  401 */     boolean ev_postable = false;
/*      */     
/*  403 */     if ((getDAO_().getConfirmationDate() == null && argConfirmationDate != null) || (
/*  404 */       getDAO_().getConfirmationDate() != null && !getDAO_().getConfirmationDate().equals(argConfirmationDate))) {
/*  405 */       getDAO_().setConfirmationDate(argConfirmationDate);
/*  406 */       ev_postable = true;
/*      */     } 
/*      */     
/*  409 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getConfirmationNumber() {
/*  417 */     return getDAO_().getConfirmationNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConfirmationNumber(String argConfirmationNumber) {
/*  425 */     if (setConfirmationNumber_noev(argConfirmationNumber) && 
/*  426 */       this._events != null && 
/*  427 */       postEventsForChanges()) {
/*  428 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_CONFIRMATIONNUMBER, argConfirmationNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setConfirmationNumber_noev(String argConfirmationNumber) {
/*  435 */     boolean ev_postable = false;
/*      */     
/*  437 */     if ((getDAO_().getConfirmationNumber() == null && argConfirmationNumber != null) || (
/*  438 */       getDAO_().getConfirmationNumber() != null && !getDAO_().getConfirmationNumber().equals(argConfirmationNumber))) {
/*  439 */       getDAO_().setConfirmationNumber(argConfirmationNumber);
/*  440 */       ev_postable = true;
/*      */     } 
/*      */     
/*  443 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShipVia() {
/*  451 */     return getDAO_().getShipVia();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipVia(String argShipVia) {
/*  459 */     if (setShipVia_noev(argShipVia) && 
/*  460 */       this._events != null && 
/*  461 */       postEventsForChanges()) {
/*  462 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SHIPVIA, argShipVia);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipVia_noev(String argShipVia) {
/*  469 */     boolean ev_postable = false;
/*      */     
/*  471 */     if ((getDAO_().getShipVia() == null && argShipVia != null) || (
/*  472 */       getDAO_().getShipVia() != null && !getDAO_().getShipVia().equals(argShipVia))) {
/*  473 */       getDAO_().setShipVia(argShipVia);
/*  474 */       ev_postable = true;
/*      */     } 
/*      */     
/*  477 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getShippedQuantity() {
/*  485 */     return getDAO_().getShippedQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippedQuantity(BigDecimal argShippedQuantity) {
/*  493 */     if (setShippedQuantity_noev(argShippedQuantity) && 
/*  494 */       this._events != null && 
/*  495 */       postEventsForChanges()) {
/*  496 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SHIPPEDQUANTITY, argShippedQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippedQuantity_noev(BigDecimal argShippedQuantity) {
/*  503 */     boolean ev_postable = false;
/*      */     
/*  505 */     if ((getDAO_().getShippedQuantity() == null && argShippedQuantity != null) || (
/*  506 */       getDAO_().getShippedQuantity() != null && !getDAO_().getShippedQuantity().equals(argShippedQuantity))) {
/*  507 */       getDAO_().setShippedQuantity(argShippedQuantity);
/*  508 */       ev_postable = true;
/*      */     } 
/*      */     
/*  511 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getShippedDate() {
/*  519 */     return getDAO_().getShippedDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippedDate(Date argShippedDate) {
/*  527 */     if (setShippedDate_noev(argShippedDate) && 
/*  528 */       this._events != null && 
/*  529 */       postEventsForChanges()) {
/*  530 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SHIPPEDDATE, argShippedDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippedDate_noev(Date argShippedDate) {
/*  537 */     boolean ev_postable = false;
/*      */     
/*  539 */     if ((getDAO_().getShippedDate() == null && argShippedDate != null) || (
/*  540 */       getDAO_().getShippedDate() != null && !getDAO_().getShippedDate().equals(argShippedDate))) {
/*  541 */       getDAO_().setShippedDate(argShippedDate);
/*  542 */       ev_postable = true;
/*      */     } 
/*      */     
/*  545 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getReceivedQuantity() {
/*  553 */     return getDAO_().getReceivedQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReceivedQuantity(BigDecimal argReceivedQuantity) {
/*  561 */     if (setReceivedQuantity_noev(argReceivedQuantity) && 
/*  562 */       this._events != null && 
/*  563 */       postEventsForChanges()) {
/*  564 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_RECEIVEDQUANTITY, argReceivedQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReceivedQuantity_noev(BigDecimal argReceivedQuantity) {
/*  571 */     boolean ev_postable = false;
/*      */     
/*  573 */     if ((getDAO_().getReceivedQuantity() == null && argReceivedQuantity != null) || (
/*  574 */       getDAO_().getReceivedQuantity() != null && !getDAO_().getReceivedQuantity().equals(argReceivedQuantity))) {
/*  575 */       getDAO_().setReceivedQuantity(argReceivedQuantity);
/*  576 */       ev_postable = true;
/*      */     } 
/*      */     
/*  579 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getReceivedDate() {
/*  587 */     return getDAO_().getReceivedDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReceivedDate(Date argReceivedDate) {
/*  595 */     if (setReceivedDate_noev(argReceivedDate) && 
/*  596 */       this._events != null && 
/*  597 */       postEventsForChanges()) {
/*  598 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_RECEIVEDDATE, argReceivedDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReceivedDate_noev(Date argReceivedDate) {
/*  605 */     boolean ev_postable = false;
/*      */     
/*  607 */     if ((getDAO_().getReceivedDate() == null && argReceivedDate != null) || (
/*  608 */       getDAO_().getReceivedDate() != null && !getDAO_().getReceivedDate().equals(argReceivedDate))) {
/*  609 */       getDAO_().setReceivedDate(argReceivedDate);
/*  610 */       ev_postable = true;
/*      */     } 
/*      */     
/*  613 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSourceType() {
/*  621 */     return getDAO_().getSourceType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSourceType(String argSourceType) {
/*  629 */     if (setSourceType_noev(argSourceType) && 
/*  630 */       this._events != null && 
/*  631 */       postEventsForChanges()) {
/*  632 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SOURCETYPE, argSourceType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSourceType_noev(String argSourceType) {
/*  639 */     boolean ev_postable = false;
/*      */     
/*  641 */     if ((getDAO_().getSourceType() == null && argSourceType != null) || (
/*  642 */       getDAO_().getSourceType() != null && !getDAO_().getSourceType().equals(argSourceType))) {
/*  643 */       getDAO_().setSourceType(argSourceType);
/*  644 */       ev_postable = true;
/*      */     } 
/*      */     
/*  647 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSourceId() {
/*  655 */     return getDAO_().getSourceId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSourceId(String argSourceId) {
/*  663 */     if (setSourceId_noev(argSourceId) && 
/*  664 */       this._events != null && 
/*  665 */       postEventsForChanges()) {
/*  666 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SOURCEID, argSourceId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSourceId_noev(String argSourceId) {
/*  673 */     boolean ev_postable = false;
/*      */     
/*  675 */     if ((getDAO_().getSourceId() == null && argSourceId != null) || (
/*  676 */       getDAO_().getSourceId() != null && !getDAO_().getSourceId().equals(argSourceId))) {
/*  677 */       getDAO_().setSourceId(argSourceId);
/*  678 */       ev_postable = true;
/*      */     } 
/*      */     
/*  681 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSourceName() {
/*  689 */     return getDAO_().getSourceName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSourceName(String argSourceName) {
/*  697 */     if (setSourceName_noev(argSourceName) && 
/*  698 */       this._events != null && 
/*  699 */       postEventsForChanges()) {
/*  700 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_SOURCENAME, argSourceName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSourceName_noev(String argSourceName) {
/*  707 */     boolean ev_postable = false;
/*      */     
/*  709 */     if ((getDAO_().getSourceName() == null && argSourceName != null) || (
/*  710 */       getDAO_().getSourceName() != null && !getDAO_().getSourceName().equals(argSourceName))) {
/*  711 */       getDAO_().setSourceName(argSourceName);
/*  712 */       ev_postable = true;
/*      */     } 
/*      */     
/*  715 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getParentDocumentId() {
/*  723 */     return getDAO_().getParentDocumentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setParentDocumentId(String argParentDocumentId) {
/*  731 */     if (setParentDocumentId_noev(argParentDocumentId) && 
/*  732 */       this._events != null && 
/*  733 */       postEventsForChanges()) {
/*  734 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_PARENTDOCUMENTID, argParentDocumentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setParentDocumentId_noev(String argParentDocumentId) {
/*  741 */     boolean ev_postable = false;
/*      */     
/*  743 */     if ((getDAO_().getParentDocumentId() == null && argParentDocumentId != null) || (
/*  744 */       getDAO_().getParentDocumentId() != null && !getDAO_().getParentDocumentId().equals(argParentDocumentId))) {
/*  745 */       getDAO_().setParentDocumentId(argParentDocumentId);
/*  746 */       ev_postable = true;
/*      */     } 
/*      */     
/*  749 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  757 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  765 */     if (setCreateDate_noev(argCreateDate) && 
/*  766 */       this._events != null && 
/*  767 */       postEventsForChanges()) {
/*  768 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  775 */     boolean ev_postable = false;
/*      */     
/*  777 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  778 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  779 */       getDAO_().setCreateDate(argCreateDate);
/*  780 */       ev_postable = true;
/*      */     } 
/*      */     
/*  783 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  791 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  799 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  800 */       this._events != null && 
/*  801 */       postEventsForChanges()) {
/*  802 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  809 */     boolean ev_postable = false;
/*      */     
/*  811 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  812 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  813 */       getDAO_().setCreateUserId(argCreateUserId);
/*  814 */       ev_postable = true;
/*      */     } 
/*      */     
/*  817 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  825 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  833 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  834 */       this._events != null && 
/*  835 */       postEventsForChanges()) {
/*  836 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  843 */     boolean ev_postable = false;
/*      */     
/*  845 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  846 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  847 */       getDAO_().setUpdateDate(argUpdateDate);
/*  848 */       ev_postable = true;
/*      */     } 
/*      */     
/*  851 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  859 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  867 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  868 */       this._events != null && 
/*  869 */       postEventsForChanges()) {
/*  870 */       this._events.post(IInventoryReplenishmentDocumentLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  877 */     boolean ev_postable = false;
/*      */     
/*  879 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  880 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  881 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  882 */       ev_postable = true;
/*      */     } 
/*      */     
/*  885 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IInventoryReplenishmentDocumentLineItemProperty newProperty(String argPropertyName) {
/*  889 */     InventoryReplenishmentDocumentLineItemPropertyId id = new InventoryReplenishmentDocumentLineItemPropertyId();
/*      */     
/*  891 */     id.setDocumentId(getDocumentId());
/*  892 */     id.setDocumentTypeCode(getDocumentTypeCode());
/*  893 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/*  894 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  895 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  897 */     IInventoryReplenishmentDocumentLineItemProperty prop = (IInventoryReplenishmentDocumentLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryReplenishmentDocumentLineItemProperty.class);
/*  898 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IInventoryReplenishmentDocumentLineItemProperty> getProperties() {
/*  907 */     if (this._properties == null) {
/*  908 */       this._properties = new HistoricalList(null);
/*      */     }
/*  910 */     return (List<IInventoryReplenishmentDocumentLineItemProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IInventoryReplenishmentDocumentLineItemProperty> argProperties) {
/*  914 */     if (this._properties == null) {
/*  915 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  917 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  920 */     for (IInventoryReplenishmentDocumentLineItemProperty child : this._properties) {
/*  921 */       InventoryReplenishmentDocumentLineItemPropertyModel model = (InventoryReplenishmentDocumentLineItemPropertyModel)child;
/*  922 */       model.setDocumentId_noev(getDocumentId());
/*  923 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/*  924 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/*  925 */       model.setOrganizationId_noev(getOrganizationId());
/*  926 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  927 */       if (child instanceof IDataModelImpl) {
/*  928 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  929 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  930 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  931 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  934 */       if (postEventsForChanges()) {
/*  935 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryReplenishmentDocumentLineItemProperty(IInventoryReplenishmentDocumentLineItemProperty argInventoryReplenishmentDocumentLineItemProperty) {
/*  941 */     if (this._properties == null) {
/*  942 */       this._properties = new HistoricalList(null);
/*      */     }
/*  944 */     argInventoryReplenishmentDocumentLineItemProperty.setDocumentId(getDocumentId());
/*  945 */     argInventoryReplenishmentDocumentLineItemProperty.setDocumentTypeCode(getDocumentTypeCode());
/*  946 */     argInventoryReplenishmentDocumentLineItemProperty.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/*  947 */     argInventoryReplenishmentDocumentLineItemProperty.setOrganizationId(getOrganizationId());
/*  948 */     argInventoryReplenishmentDocumentLineItemProperty.setRetailLocationId(getRetailLocationId());
/*  949 */     if (argInventoryReplenishmentDocumentLineItemProperty instanceof IDataModelImpl) {
/*  950 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryReplenishmentDocumentLineItemProperty).getDAO();
/*  951 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  952 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  953 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  958 */     if (postEventsForChanges()) {
/*  959 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryReplenishmentDocumentLineItemProperty));
/*      */     }
/*      */     
/*  962 */     this._properties.add(argInventoryReplenishmentDocumentLineItemProperty);
/*  963 */     if (postEventsForChanges()) {
/*  964 */       this._events.post(IInventoryReplenishmentDocumentLineItem.ADD_PROPERTIES, argInventoryReplenishmentDocumentLineItemProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryReplenishmentDocumentLineItemProperty(IInventoryReplenishmentDocumentLineItemProperty argInventoryReplenishmentDocumentLineItemProperty) {
/*  969 */     if (this._properties != null) {
/*      */       
/*  971 */       if (postEventsForChanges()) {
/*  972 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryReplenishmentDocumentLineItemProperty));
/*      */       }
/*  974 */       this._properties.remove(argInventoryReplenishmentDocumentLineItemProperty);
/*  975 */       if (postEventsForChanges()) {
/*  976 */         this._events.post(IInventoryReplenishmentDocumentLineItem.REMOVE_PROPERTIES, argInventoryReplenishmentDocumentLineItemProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(IInventoryDocumentLineItem argParentLine) {
/*  982 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public IInventoryDocumentLineItem getParentLine() {
/*  986 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  991 */     if ("Properties".equals(argFieldId)) {
/*  992 */       return getProperties();
/*      */     }
/*  994 */     if ("InventoryReplenishmentDocumentLineItemExtension".equals(argFieldId)) {
/*  995 */       return this._myExtension;
/*      */     }
/*      */     
/*  998 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1004 */     if ("Properties".equals(argFieldId)) {
/* 1005 */       setProperties(changeToList(argValue, IInventoryReplenishmentDocumentLineItemProperty.class));
/*      */     }
/* 1007 */     else if ("InventoryReplenishmentDocumentLineItemExtension".equals(argFieldId)) {
/* 1008 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1011 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1017 */     this._persistenceDefaults = argPD;
/* 1018 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1019 */     this._eventManager = argEM;
/* 1020 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1021 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1022 */     if (this._properties != null) {
/* 1023 */       for (IInventoryReplenishmentDocumentLineItemProperty relationship : this._properties) {
/* 1024 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getInventoryReplenishmentDocumentLineItemExt() {
/* 1030 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setInventoryReplenishmentDocumentLineItemExt(IDataModel argExt) {
/* 1034 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1039 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1043 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1046 */     super.startTransaction();
/*      */     
/* 1048 */     this._propertiesSavepoint = this._properties;
/* 1049 */     if (this._properties != null) {
/* 1050 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1051 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1052 */       while (it.hasNext()) {
/* 1053 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1058 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1063 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1066 */     super.rollbackChanges();
/*      */     
/* 1068 */     this._properties = this._propertiesSavepoint;
/* 1069 */     this._propertiesSavepoint = null;
/* 1070 */     if (this._properties != null) {
/* 1071 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1072 */       while (it.hasNext()) {
/* 1073 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1081 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1084 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1087 */     super.commitTransaction();
/*      */     
/* 1089 */     this._propertiesSavepoint = this._properties;
/* 1090 */     if (this._properties != null) {
/* 1091 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1092 */       while (it.hasNext()) {
/* 1093 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1095 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1099 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1104 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryReplenishmentDocumentLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */