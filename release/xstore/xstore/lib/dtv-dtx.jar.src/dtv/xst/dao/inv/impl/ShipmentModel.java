/*      */ package dtv.xst.dao.inv.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.inv.IInventoryDocument;
/*      */ import dtv.xst.dao.inv.IShipment;
/*      */ import dtv.xst.dao.inv.IShipmentAddress;
/*      */ import dtv.xst.dao.inv.IShipmentLineItem;
/*      */ import dtv.xst.dao.inv.IShipmentProperty;
/*      */ import dtv.xst.dao.inv.ShipmentPropertyId;
/*      */ import dtv.xst.dao.loc.IRetailLocation;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ShipmentModel extends ShipmentBaseModel implements IShipment {
/*      */   private static final long serialVersionUID = -451684934L;
/*      */   private IInventoryDocument _parentDocument;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IParty _destinationParty;
/*      */   private transient IParty _destinationPartySavepoint;
/*      */   
/*      */   public String toString() {
/*   39 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IRetailLocation _destinationRetailLocation; private transient IRetailLocation _destinationRetailLocationSavepoint; private IShipmentAddress _address; private transient IShipmentAddress _addressSavepoint; private HistoricalList<IShipmentLineItem> _shipmentLineItems; private transient HistoricalList<IShipmentLineItem> _shipmentLineItemsSavepoint; private HistoricalList<IShipmentProperty> _properties; private transient HistoricalList<IShipmentProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   44 */     setDAO((IDataAccessObject)new ShipmentDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ShipmentDAO getDAO_() {
/*   52 */     return (ShipmentDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   60 */     if (getDAO_().getOrganizationId() != null) {
/*   61 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   64 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   73 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   74 */       this._events != null && 
/*   75 */       postEventsForChanges()) {
/*   76 */       this._events.post(IShipment.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   83 */     boolean ev_postable = false;
/*      */     
/*   85 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   86 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   87 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   88 */       ev_postable = true;
/*   89 */       if (this._shipmentLineItems != null) {
/*      */         
/*   91 */         Iterator<ShipmentLineItemModel> it = this._shipmentLineItems.iterator();
/*   92 */         while (it.hasNext())
/*      */         {
/*   94 */           ((ShipmentLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   97 */       if (this._properties != null) {
/*      */         
/*   99 */         Iterator<ShipmentPropertyModel> it = this._properties.iterator();
/*  100 */         while (it.hasNext())
/*      */         {
/*  102 */           ((ShipmentPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  105 */       if (this._address != null)
/*      */       {
/*      */         
/*  108 */         ((ShipmentAddressModel)this._address).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */     
/*  112 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  120 */     if (getDAO_().getRetailLocationId() != null) {
/*  121 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  124 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  133 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  134 */       this._events != null && 
/*  135 */       postEventsForChanges()) {
/*  136 */       this._events.post(IShipment.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  143 */     boolean ev_postable = false;
/*      */     
/*  145 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  146 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  147 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  148 */       ev_postable = true;
/*  149 */       if (this._shipmentLineItems != null) {
/*      */         
/*  151 */         Iterator<ShipmentLineItemModel> it = this._shipmentLineItems.iterator();
/*  152 */         while (it.hasNext())
/*      */         {
/*  154 */           ((ShipmentLineItemModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  157 */       if (this._properties != null) {
/*      */         
/*  159 */         Iterator<ShipmentPropertyModel> it = this._properties.iterator();
/*  160 */         while (it.hasNext())
/*      */         {
/*  162 */           ((ShipmentPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  165 */       if (this._address != null)
/*      */       {
/*      */         
/*  168 */         ((ShipmentAddressModel)this._address).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */     
/*  172 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentId() {
/*  180 */     return getDAO_().getDocumentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentId(String argDocumentId) {
/*  188 */     if (setDocumentId_noev(argDocumentId) && 
/*  189 */       this._events != null && 
/*  190 */       postEventsForChanges()) {
/*  191 */       this._events.post(IShipment.SET_DOCUMENTID, argDocumentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentId_noev(String argDocumentId) {
/*  198 */     boolean ev_postable = false;
/*      */     
/*  200 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*  201 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*  202 */       getDAO_().setDocumentId(argDocumentId);
/*  203 */       ev_postable = true;
/*  204 */       if (this._shipmentLineItems != null) {
/*      */         
/*  206 */         Iterator<ShipmentLineItemModel> it = this._shipmentLineItems.iterator();
/*  207 */         while (it.hasNext())
/*      */         {
/*  209 */           ((ShipmentLineItemModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  212 */       if (this._properties != null) {
/*      */         
/*  214 */         Iterator<ShipmentPropertyModel> it = this._properties.iterator();
/*  215 */         while (it.hasNext())
/*      */         {
/*  217 */           ((ShipmentPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  220 */       if (this._address != null)
/*      */       {
/*      */         
/*  223 */         ((ShipmentAddressModel)this._address).setDocumentId_noev(argDocumentId);
/*      */       }
/*      */     } 
/*      */     
/*  227 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentTypeCode() {
/*  235 */     return getDAO_().getDocumentTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  243 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/*  244 */       this._events != null && 
/*  245 */       postEventsForChanges()) {
/*  246 */       this._events.post(IShipment.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/*  253 */     boolean ev_postable = false;
/*      */     
/*  255 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/*  256 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/*  257 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/*  258 */       ev_postable = true;
/*  259 */       if (this._shipmentLineItems != null) {
/*      */         
/*  261 */         Iterator<ShipmentLineItemModel> it = this._shipmentLineItems.iterator();
/*  262 */         while (it.hasNext())
/*      */         {
/*  264 */           ((ShipmentLineItemModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  267 */       if (this._properties != null) {
/*      */         
/*  269 */         Iterator<ShipmentPropertyModel> it = this._properties.iterator();
/*  270 */         while (it.hasNext())
/*      */         {
/*  272 */           ((ShipmentPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  275 */       if (this._address != null)
/*      */       {
/*      */         
/*  278 */         ((ShipmentAddressModel)this._address).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */       }
/*      */     } 
/*      */     
/*  282 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getShipmentSequence() {
/*  290 */     if (getDAO_().getShipmentSequence() != null) {
/*  291 */       return getDAO_().getShipmentSequence().intValue();
/*      */     }
/*      */     
/*  294 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipmentSequence(int argShipmentSequence) {
/*  303 */     if (setShipmentSequence_noev(argShipmentSequence) && 
/*  304 */       this._events != null && 
/*  305 */       postEventsForChanges()) {
/*  306 */       this._events.post(IShipment.SET_SHIPMENTSEQUENCE, Integer.valueOf(argShipmentSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipmentSequence_noev(int argShipmentSequence) {
/*  313 */     boolean ev_postable = false;
/*      */     
/*  315 */     if ((getDAO_().getShipmentSequence() == null && Integer.valueOf(argShipmentSequence) != null) || (
/*  316 */       getDAO_().getShipmentSequence() != null && !getDAO_().getShipmentSequence().equals(Integer.valueOf(argShipmentSequence)))) {
/*  317 */       getDAO_().setShipmentSequence(Integer.valueOf(argShipmentSequence));
/*  318 */       ev_postable = true;
/*  319 */       if (this._shipmentLineItems != null) {
/*      */         
/*  321 */         Iterator<ShipmentLineItemModel> it = this._shipmentLineItems.iterator();
/*  322 */         while (it.hasNext())
/*      */         {
/*  324 */           ((ShipmentLineItemModel)it.next()).setShipmentSequence_noev(argShipmentSequence);
/*      */         }
/*      */       } 
/*  327 */       if (this._properties != null) {
/*      */         
/*  329 */         Iterator<ShipmentPropertyModel> it = this._properties.iterator();
/*  330 */         while (it.hasNext())
/*      */         {
/*  332 */           ((ShipmentPropertyModel)it.next()).setShipmentSequence_noev(argShipmentSequence);
/*      */         }
/*      */       } 
/*  335 */       if (this._address != null)
/*      */       {
/*      */         
/*  338 */         ((ShipmentAddressModel)this._address).setShipmentSequence_noev(argShipmentSequence);
/*      */       }
/*      */     } 
/*      */     
/*  342 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  350 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  358 */     if (setCreateDate_noev(argCreateDate) && 
/*  359 */       this._events != null && 
/*  360 */       postEventsForChanges()) {
/*  361 */       this._events.post(IShipment.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  368 */     boolean ev_postable = false;
/*      */     
/*  370 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  371 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  372 */       getDAO_().setCreateDate(argCreateDate);
/*  373 */       ev_postable = true;
/*      */     } 
/*      */     
/*  376 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  384 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  392 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  393 */       this._events != null && 
/*  394 */       postEventsForChanges()) {
/*  395 */       this._events.post(IShipment.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  402 */     boolean ev_postable = false;
/*      */     
/*  404 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  405 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  406 */       getDAO_().setCreateUserId(argCreateUserId);
/*  407 */       ev_postable = true;
/*      */     } 
/*      */     
/*  410 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  418 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  426 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  427 */       this._events != null && 
/*  428 */       postEventsForChanges()) {
/*  429 */       this._events.post(IShipment.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  436 */     boolean ev_postable = false;
/*      */     
/*  438 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  439 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  440 */       getDAO_().setUpdateDate(argUpdateDate);
/*  441 */       ev_postable = true;
/*      */     } 
/*      */     
/*  444 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  452 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  460 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  461 */       this._events != null && 
/*  462 */       postEventsForChanges()) {
/*  463 */       this._events.post(IShipment.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  470 */     boolean ev_postable = false;
/*      */     
/*  472 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  473 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  474 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  475 */       ev_postable = true;
/*      */     } 
/*      */     
/*  478 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpectedDeliveryDate() {
/*  486 */     return getDAO_().getExpectedDeliveryDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpectedDeliveryDate(Date argExpectedDeliveryDate) {
/*  494 */     if (setExpectedDeliveryDate_noev(argExpectedDeliveryDate) && 
/*  495 */       this._events != null && 
/*  496 */       postEventsForChanges()) {
/*  497 */       this._events.post(IShipment.SET_EXPECTEDDELIVERYDATE, argExpectedDeliveryDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpectedDeliveryDate_noev(Date argExpectedDeliveryDate) {
/*  504 */     boolean ev_postable = false;
/*      */     
/*  506 */     if ((getDAO_().getExpectedDeliveryDate() == null && argExpectedDeliveryDate != null) || (
/*  507 */       getDAO_().getExpectedDeliveryDate() != null && !getDAO_().getExpectedDeliveryDate().equals(argExpectedDeliveryDate))) {
/*  508 */       getDAO_().setExpectedDeliveryDate(argExpectedDeliveryDate);
/*  509 */       ev_postable = true;
/*      */     } 
/*      */     
/*  512 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getActualDeliveryDate() {
/*  520 */     return getDAO_().getActualDeliveryDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActualDeliveryDate(Date argActualDeliveryDate) {
/*  528 */     if (setActualDeliveryDate_noev(argActualDeliveryDate) && 
/*  529 */       this._events != null && 
/*  530 */       postEventsForChanges()) {
/*  531 */       this._events.post(IShipment.SET_ACTUALDELIVERYDATE, argActualDeliveryDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActualDeliveryDate_noev(Date argActualDeliveryDate) {
/*  538 */     boolean ev_postable = false;
/*      */     
/*  540 */     if ((getDAO_().getActualDeliveryDate() == null && argActualDeliveryDate != null) || (
/*  541 */       getDAO_().getActualDeliveryDate() != null && !getDAO_().getActualDeliveryDate().equals(argActualDeliveryDate))) {
/*  542 */       getDAO_().setActualDeliveryDate(argActualDeliveryDate);
/*  543 */       ev_postable = true;
/*      */     } 
/*      */     
/*  546 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpectedShipDate() {
/*  554 */     return getDAO_().getExpectedShipDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpectedShipDate(Date argExpectedShipDate) {
/*  562 */     if (setExpectedShipDate_noev(argExpectedShipDate) && 
/*  563 */       this._events != null && 
/*  564 */       postEventsForChanges()) {
/*  565 */       this._events.post(IShipment.SET_EXPECTEDSHIPDATE, argExpectedShipDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpectedShipDate_noev(Date argExpectedShipDate) {
/*  572 */     boolean ev_postable = false;
/*      */     
/*  574 */     if ((getDAO_().getExpectedShipDate() == null && argExpectedShipDate != null) || (
/*  575 */       getDAO_().getExpectedShipDate() != null && !getDAO_().getExpectedShipDate().equals(argExpectedShipDate))) {
/*  576 */       getDAO_().setExpectedShipDate(argExpectedShipDate);
/*  577 */       ev_postable = true;
/*      */     } 
/*      */     
/*  580 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getActualShipDate() {
/*  588 */     return getDAO_().getActualShipDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActualShipDate(Date argActualShipDate) {
/*  596 */     if (setActualShipDate_noev(argActualShipDate) && 
/*  597 */       this._events != null && 
/*  598 */       postEventsForChanges()) {
/*  599 */       this._events.post(IShipment.SET_ACTUALSHIPDATE, argActualShipDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActualShipDate_noev(Date argActualShipDate) {
/*  606 */     boolean ev_postable = false;
/*      */     
/*  608 */     if ((getDAO_().getActualShipDate() == null && argActualShipDate != null) || (
/*  609 */       getDAO_().getActualShipDate() != null && !getDAO_().getActualShipDate().equals(argActualShipDate))) {
/*  610 */       getDAO_().setActualShipDate(argActualShipDate);
/*  611 */       ev_postable = true;
/*      */     } 
/*      */     
/*  614 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationName() {
/*  622 */     return getDAO_().getDestinationName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationName(String argDestinationName) {
/*  630 */     if (setDestinationName_noev(argDestinationName) && 
/*  631 */       this._events != null && 
/*  632 */       postEventsForChanges()) {
/*  633 */       this._events.post(IShipment.SET_DESTINATIONNAME, argDestinationName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationName_noev(String argDestinationName) {
/*  640 */     boolean ev_postable = false;
/*      */     
/*  642 */     if ((getDAO_().getDestinationName() == null && argDestinationName != null) || (
/*  643 */       getDAO_().getDestinationName() != null && !getDAO_().getDestinationName().equals(argDestinationName))) {
/*  644 */       getDAO_().setDestinationName(argDestinationName);
/*  645 */       ev_postable = true;
/*      */     } 
/*      */     
/*  648 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShippingCarrier() {
/*  656 */     return getDAO_().getShippingCarrier();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingCarrier(String argShippingCarrier) {
/*  664 */     if (setShippingCarrier_noev(argShippingCarrier) && 
/*  665 */       this._events != null && 
/*  666 */       postEventsForChanges()) {
/*  667 */       this._events.post(IShipment.SET_SHIPPINGCARRIER, argShippingCarrier);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingCarrier_noev(String argShippingCarrier) {
/*  674 */     boolean ev_postable = false;
/*      */     
/*  676 */     if ((getDAO_().getShippingCarrier() == null && argShippingCarrier != null) || (
/*  677 */       getDAO_().getShippingCarrier() != null && !getDAO_().getShippingCarrier().equals(argShippingCarrier))) {
/*  678 */       getDAO_().setShippingCarrier(argShippingCarrier);
/*  679 */       ev_postable = true;
/*      */     } 
/*      */     
/*  682 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTrackingNumber() {
/*  690 */     return getDAO_().getTrackingNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTrackingNumber(String argTrackingNumber) {
/*  698 */     if (setTrackingNumber_noev(argTrackingNumber) && 
/*  699 */       this._events != null && 
/*  700 */       postEventsForChanges()) {
/*  701 */       this._events.post(IShipment.SET_TRACKINGNUMBER, argTrackingNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTrackingNumber_noev(String argTrackingNumber) {
/*  708 */     boolean ev_postable = false;
/*      */     
/*  710 */     if ((getDAO_().getTrackingNumber() == null && argTrackingNumber != null) || (
/*  711 */       getDAO_().getTrackingNumber() != null && !getDAO_().getTrackingNumber().equals(argTrackingNumber))) {
/*  712 */       getDAO_().setTrackingNumber(argTrackingNumber);
/*  713 */       ev_postable = true;
/*      */     } 
/*      */     
/*  716 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShipmentStatusCode() {
/*  724 */     return getDAO_().getShipmentStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipmentStatusCode(String argShipmentStatusCode) {
/*  732 */     if (setShipmentStatusCode_noev(argShipmentStatusCode) && 
/*  733 */       this._events != null && 
/*  734 */       postEventsForChanges()) {
/*  735 */       this._events.post(IShipment.SET_SHIPMENTSTATUSCODE, argShipmentStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipmentStatusCode_noev(String argShipmentStatusCode) {
/*  742 */     boolean ev_postable = false;
/*      */     
/*  744 */     if ((getDAO_().getShipmentStatusCode() == null && argShipmentStatusCode != null) || (
/*  745 */       getDAO_().getShipmentStatusCode() != null && !getDAO_().getShipmentStatusCode().equals(argShipmentStatusCode))) {
/*  746 */       getDAO_().setShipmentStatusCode(argShipmentStatusCode);
/*  747 */       ev_postable = true;
/*      */     } 
/*      */     
/*  750 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getDestinationPartyId() {
/*  758 */     if (getDAO_().getDestinationPartyId() != null) {
/*  759 */       return getDAO_().getDestinationPartyId().longValue();
/*      */     }
/*      */     
/*  762 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationPartyId(long argDestinationPartyId) {
/*  771 */     if (setDestinationPartyId_noev(argDestinationPartyId) && 
/*  772 */       this._events != null && 
/*  773 */       postEventsForChanges()) {
/*  774 */       this._events.post(IShipment.SET_DESTINATIONPARTYID, Long.valueOf(argDestinationPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationPartyId_noev(long argDestinationPartyId) {
/*  781 */     boolean ev_postable = false;
/*      */     
/*  783 */     if ((getDAO_().getDestinationPartyId() == null && Long.valueOf(argDestinationPartyId) != null) || (
/*  784 */       getDAO_().getDestinationPartyId() != null && !getDAO_().getDestinationPartyId().equals(Long.valueOf(argDestinationPartyId)))) {
/*  785 */       getDAO_().setDestinationPartyId(Long.valueOf(argDestinationPartyId));
/*  786 */       ev_postable = true;
/*      */     } 
/*      */     
/*  789 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getDestinationRetailLocationId() {
/*  797 */     if (getDAO_().getDestinationRetailLocationId() != null) {
/*  798 */       return getDAO_().getDestinationRetailLocationId().longValue();
/*      */     }
/*      */     
/*  801 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationRetailLocationId(long argDestinationRetailLocationId) {
/*  810 */     if (setDestinationRetailLocationId_noev(argDestinationRetailLocationId) && 
/*  811 */       this._events != null && 
/*  812 */       postEventsForChanges()) {
/*  813 */       this._events.post(IShipment.SET_DESTINATIONRETAILLOCATIONID, Long.valueOf(argDestinationRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationRetailLocationId_noev(long argDestinationRetailLocationId) {
/*  820 */     boolean ev_postable = false;
/*      */     
/*  822 */     if ((getDAO_().getDestinationRetailLocationId() == null && Long.valueOf(argDestinationRetailLocationId) != null) || (
/*  823 */       getDAO_().getDestinationRetailLocationId() != null && !getDAO_().getDestinationRetailLocationId().equals(Long.valueOf(argDestinationRetailLocationId)))) {
/*  824 */       getDAO_().setDestinationRetailLocationId(Long.valueOf(argDestinationRetailLocationId));
/*  825 */       ev_postable = true;
/*      */     } 
/*      */     
/*  828 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRecordCreationType() {
/*  836 */     return getDAO_().getRecordCreationType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRecordCreationType(String argRecordCreationType) {
/*  844 */     if (setRecordCreationType_noev(argRecordCreationType) && 
/*  845 */       this._events != null && 
/*  846 */       postEventsForChanges()) {
/*  847 */       this._events.post(IShipment.SET_RECORDCREATIONTYPE, argRecordCreationType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRecordCreationType_noev(String argRecordCreationType) {
/*  854 */     boolean ev_postable = false;
/*      */     
/*  856 */     if ((getDAO_().getRecordCreationType() == null && argRecordCreationType != null) || (
/*  857 */       getDAO_().getRecordCreationType() != null && !getDAO_().getRecordCreationType().equals(argRecordCreationType))) {
/*  858 */       getDAO_().setRecordCreationType(argRecordCreationType);
/*  859 */       ev_postable = true;
/*      */     } 
/*      */     
/*  862 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShippingMethod() {
/*  870 */     return getDAO_().getShippingMethod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingMethod(String argShippingMethod) {
/*  878 */     if (setShippingMethod_noev(argShippingMethod) && 
/*  879 */       this._events != null && 
/*  880 */       postEventsForChanges()) {
/*  881 */       this._events.post(IShipment.SET_SHIPPINGMETHOD, argShippingMethod);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingMethod_noev(String argShippingMethod) {
/*  888 */     boolean ev_postable = false;
/*      */     
/*  890 */     if ((getDAO_().getShippingMethod() == null && argShippingMethod != null) || (
/*  891 */       getDAO_().getShippingMethod() != null && !getDAO_().getShippingMethod().equals(argShippingMethod))) {
/*  892 */       getDAO_().setShippingMethod(argShippingMethod);
/*  893 */       ev_postable = true;
/*      */     } 
/*      */     
/*  896 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShippingLabel() {
/*  904 */     return getDAO_().getShippingLabel();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingLabel(String argShippingLabel) {
/*  912 */     if (setShippingLabel_noev(argShippingLabel) && 
/*  913 */       this._events != null && 
/*  914 */       postEventsForChanges()) {
/*  915 */       this._events.post(IShipment.SET_SHIPPINGLABEL, argShippingLabel);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingLabel_noev(String argShippingLabel) {
/*  922 */     boolean ev_postable = false;
/*      */     
/*  924 */     if ((getDAO_().getShippingLabel() == null && argShippingLabel != null) || (
/*  925 */       getDAO_().getShippingLabel() != null && !getDAO_().getShippingLabel().equals(argShippingLabel))) {
/*  926 */       getDAO_().setShippingLabel(argShippingLabel);
/*  927 */       ev_postable = true;
/*      */     } 
/*      */     
/*  930 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationType() {
/*  938 */     return getDAO_().getDestinationType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationType(String argDestinationType) {
/*  946 */     if (setDestinationType_noev(argDestinationType) && 
/*  947 */       this._events != null && 
/*  948 */       postEventsForChanges()) {
/*  949 */       this._events.post(IShipment.SET_DESTINATIONTYPE, argDestinationType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationType_noev(String argDestinationType) {
/*  956 */     boolean ev_postable = false;
/*      */     
/*  958 */     if ((getDAO_().getDestinationType() == null && argDestinationType != null) || (
/*  959 */       getDAO_().getDestinationType() != null && !getDAO_().getDestinationType().equals(argDestinationType))) {
/*  960 */       getDAO_().setDestinationType(argDestinationType);
/*  961 */       ev_postable = true;
/*      */     } 
/*      */     
/*  964 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationServiceLocationId() {
/*  972 */     return getDAO_().getDestinationServiceLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationServiceLocationId(String argDestinationServiceLocationId) {
/*  980 */     if (setDestinationServiceLocationId_noev(argDestinationServiceLocationId) && 
/*  981 */       this._events != null && 
/*  982 */       postEventsForChanges()) {
/*  983 */       this._events.post(IShipment.SET_DESTINATIONSERVICELOCATIONID, argDestinationServiceLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationServiceLocationId_noev(String argDestinationServiceLocationId) {
/*  990 */     boolean ev_postable = false;
/*      */     
/*  992 */     if ((getDAO_().getDestinationServiceLocationId() == null && argDestinationServiceLocationId != null) || (
/*  993 */       getDAO_().getDestinationServiceLocationId() != null && !getDAO_().getDestinationServiceLocationId().equals(argDestinationServiceLocationId))) {
/*  994 */       getDAO_().setDestinationServiceLocationId(argDestinationServiceLocationId);
/*  995 */       ev_postable = true;
/*      */     } 
/*      */     
/*  998 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IShipmentProperty newProperty(String argPropertyName) {
/* 1002 */     ShipmentPropertyId id = new ShipmentPropertyId();
/*      */     
/* 1004 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 1005 */     id.setDocumentId(getDocumentId());
/* 1006 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 1007 */     id.setShipmentSequence(Integer.valueOf(getShipmentSequence()));
/* 1008 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1010 */     IShipmentProperty prop = (IShipmentProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShipmentProperty.class);
/* 1011 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "DestinationParty")
/*      */   public IParty getDestinationParty() {
/* 1032 */     return this._destinationParty;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDestinationParty(IParty argDestinationParty) {
/* 1037 */     if (argDestinationParty == null) {
/*      */       
/* 1039 */       getDAO_().setDestinationPartyId(null);
/* 1040 */       if (this._destinationParty != null)
/*      */       {
/* 1042 */         if (postEventsForChanges()) {
/* 1043 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._destinationParty));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1048 */       getDAO_().setDestinationPartyId(Long.valueOf(argDestinationParty.getPartyId()));
/*      */       
/* 1050 */       if (postEventsForChanges()) {
/* 1051 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDestinationParty));
/*      */       }
/*      */     } 
/*      */     
/* 1055 */     this._destinationParty = argDestinationParty;
/* 1056 */     if (postEventsForChanges()) {
/* 1057 */       this._events.post(IShipment.SET_DESTINATIONPARTY, argDestinationParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "DestinationRetailLocation")
/*      */   public IRetailLocation getDestinationRetailLocation() {
/* 1063 */     return this._destinationRetailLocation;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDestinationRetailLocation(IRetailLocation argDestinationRetailLocation) {
/* 1068 */     if (argDestinationRetailLocation == null) {
/*      */       
/* 1070 */       getDAO_().setDestinationRetailLocationId(null);
/* 1071 */       if (this._destinationRetailLocation != null)
/*      */       {
/* 1073 */         if (postEventsForChanges()) {
/* 1074 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._destinationRetailLocation));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1079 */       getDAO_().setDestinationRetailLocationId(Long.valueOf(argDestinationRetailLocation.getRetailLocationId()));
/*      */       
/* 1081 */       if (postEventsForChanges()) {
/* 1082 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDestinationRetailLocation));
/*      */       }
/*      */     } 
/*      */     
/* 1086 */     this._destinationRetailLocation = argDestinationRetailLocation;
/* 1087 */     if (postEventsForChanges()) {
/* 1088 */       this._events.post(IShipment.SET_DESTINATIONRETAILLOCATION, argDestinationRetailLocation);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Address")
/*      */   public IShipmentAddress getAddress() {
/* 1094 */     return this._address;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAddress(IShipmentAddress argAddress) {
/* 1099 */     if (argAddress == null) {
/*      */       
/* 1101 */       if (this._address != null) {
/* 1102 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1104 */       if (this._address != null) {
/*      */         
/* 1106 */         if (postEventsForChanges()) {
/* 1107 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*      */         }
/* 1109 */         addDeletedObject((IDataModel)this._address);
/*      */       } 
/*      */     } else {
/*      */       
/* 1113 */       argAddress.setOrganizationId(getOrganizationId());
/* 1114 */       argAddress.setRetailLocationId(getRetailLocationId());
/* 1115 */       argAddress.setDocumentId(getDocumentId());
/* 1116 */       argAddress.setDocumentTypeCode(getDocumentTypeCode());
/* 1117 */       argAddress.setShipmentSequence(getShipmentSequence());
/*      */ 
/*      */       
/* 1120 */       if (postEventsForChanges()) {
/* 1121 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*      */       }
/*      */     } 
/*      */     
/* 1125 */     this._address = argAddress;
/* 1126 */     if (postEventsForChanges()) {
/* 1127 */       this._events.post(IShipment.SET_ADDRESS, argAddress);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "ShipmentLineItems")
/*      */   public List<IShipmentLineItem> getShipmentLineItems() {
/* 1133 */     if (this._shipmentLineItems == null) {
/* 1134 */       this._shipmentLineItems = new HistoricalList(null);
/*      */     }
/* 1136 */     return (List<IShipmentLineItem>)this._shipmentLineItems;
/*      */   }
/*      */   
/*      */   public void setShipmentLineItems(List<IShipmentLineItem> argShipmentLineItems) {
/* 1140 */     if (this._shipmentLineItems == null) {
/* 1141 */       this._shipmentLineItems = new HistoricalList(argShipmentLineItems);
/*      */     } else {
/* 1143 */       this._shipmentLineItems.setCurrentList(argShipmentLineItems);
/*      */     } 
/*      */     
/* 1146 */     for (IShipmentLineItem child : this._shipmentLineItems) {
/* 1147 */       child.setParentShipment(this);
/*      */     }
/*      */ 
/*      */     
/* 1151 */     for (IShipmentLineItem child : this._shipmentLineItems) {
/* 1152 */       ShipmentLineItemModel model = (ShipmentLineItemModel)child;
/* 1153 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1154 */       model.setDocumentId_noev(getDocumentId());
/* 1155 */       model.setOrganizationId_noev(getOrganizationId());
/* 1156 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1157 */       model.setShipmentSequence_noev(getShipmentSequence());
/* 1158 */       if (child instanceof IDataModelImpl) {
/* 1159 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1160 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1161 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1162 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1165 */       if (postEventsForChanges()) {
/* 1166 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addLineItems(IShipmentLineItem argLineItems) {
/* 1172 */     super.addLineItems(argLineItems);
/*      */ 
/*      */     
/* 1175 */     argLineItems.setParentShipment(this);
/* 1176 */     if (this._shipmentLineItems == null) {
/* 1177 */       this._shipmentLineItems = new HistoricalList(null);
/*      */     }
/* 1179 */     argLineItems.setDocumentTypeCode(getDocumentTypeCode());
/* 1180 */     argLineItems.setDocumentId(getDocumentId());
/* 1181 */     argLineItems.setOrganizationId(getOrganizationId());
/* 1182 */     argLineItems.setRetailLocationId(getRetailLocationId());
/* 1183 */     argLineItems.setShipmentSequence(getShipmentSequence());
/* 1184 */     if (argLineItems instanceof IDataModelImpl) {
/* 1185 */       IDataAccessObject childDao = ((IDataModelImpl)argLineItems).getDAO();
/* 1186 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1187 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1188 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1193 */     if (postEventsForChanges()) {
/* 1194 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItems));
/*      */     }
/*      */     
/* 1197 */     this._shipmentLineItems.add(argLineItems);
/* 1198 */     if (postEventsForChanges()) {
/* 1199 */       this._events.post(IShipment.ADD_SHIPMENTLINEITEMS, argLineItems);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeLineItems(IShipmentLineItem argLineItems) {
/* 1204 */     if (this._shipmentLineItems != null) {
/*      */       
/* 1206 */       if (postEventsForChanges()) {
/* 1207 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItems));
/*      */       }
/* 1209 */       this._shipmentLineItems.remove(argLineItems);
/*      */       
/* 1211 */       argLineItems.setParentShipment(null);
/* 1212 */       if (postEventsForChanges()) {
/* 1213 */         this._events.post(IShipment.REMOVE_SHIPMENTLINEITEMS, argLineItems);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IShipmentProperty> getProperties() {
/* 1220 */     if (this._properties == null) {
/* 1221 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1223 */     return (List<IShipmentProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IShipmentProperty> argProperties) {
/* 1227 */     if (this._properties == null) {
/* 1228 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1230 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1233 */     for (IShipmentProperty child : this._properties) {
/* 1234 */       ShipmentPropertyModel model = (ShipmentPropertyModel)child;
/* 1235 */       model.setOrganizationId_noev(getOrganizationId());
/* 1236 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1237 */       model.setDocumentId_noev(getDocumentId());
/* 1238 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1239 */       model.setShipmentSequence_noev(getShipmentSequence());
/* 1240 */       if (child instanceof IDataModelImpl) {
/* 1241 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1242 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1243 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1244 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1247 */       if (postEventsForChanges()) {
/* 1248 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addShipmentProperty(IShipmentProperty argShipmentProperty) {
/* 1254 */     if (this._properties == null) {
/* 1255 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1257 */     argShipmentProperty.setOrganizationId(getOrganizationId());
/* 1258 */     argShipmentProperty.setRetailLocationId(getRetailLocationId());
/* 1259 */     argShipmentProperty.setDocumentId(getDocumentId());
/* 1260 */     argShipmentProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 1261 */     argShipmentProperty.setShipmentSequence(getShipmentSequence());
/* 1262 */     if (argShipmentProperty instanceof IDataModelImpl) {
/* 1263 */       IDataAccessObject childDao = ((IDataModelImpl)argShipmentProperty).getDAO();
/* 1264 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1265 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1266 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1271 */     if (postEventsForChanges()) {
/* 1272 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipmentProperty));
/*      */     }
/*      */     
/* 1275 */     this._properties.add(argShipmentProperty);
/* 1276 */     if (postEventsForChanges()) {
/* 1277 */       this._events.post(IShipment.ADD_PROPERTIES, argShipmentProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeShipmentProperty(IShipmentProperty argShipmentProperty) {
/* 1282 */     if (this._properties != null) {
/*      */       
/* 1284 */       if (postEventsForChanges()) {
/* 1285 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipmentProperty));
/*      */       }
/* 1287 */       this._properties.remove(argShipmentProperty);
/* 1288 */       if (postEventsForChanges()) {
/* 1289 */         this._events.post(IShipment.REMOVE_PROPERTIES, argShipmentProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentDocument(IInventoryDocument argParentDocument) {
/* 1295 */     this._parentDocument = argParentDocument;
/*      */   }
/*      */   
/*      */   public IInventoryDocument getParentDocument() {
/* 1299 */     return this._parentDocument;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1304 */     if ("DestinationParty".equals(argFieldId)) {
/* 1305 */       return getDestinationParty();
/*      */     }
/* 1307 */     if ("DestinationRetailLocation".equals(argFieldId)) {
/* 1308 */       return getDestinationRetailLocation();
/*      */     }
/* 1310 */     if ("Address".equals(argFieldId)) {
/* 1311 */       return getAddress();
/*      */     }
/* 1313 */     if ("ShipmentLineItems".equals(argFieldId)) {
/* 1314 */       return getShipmentLineItems();
/*      */     }
/* 1316 */     if ("Properties".equals(argFieldId)) {
/* 1317 */       return getProperties();
/*      */     }
/* 1319 */     if ("ShipmentExtension".equals(argFieldId)) {
/* 1320 */       return this._myExtension;
/*      */     }
/*      */     
/* 1323 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1329 */     if ("DestinationParty".equals(argFieldId)) {
/* 1330 */       setDestinationParty((IParty)argValue);
/*      */     }
/* 1332 */     else if ("DestinationRetailLocation".equals(argFieldId)) {
/* 1333 */       setDestinationRetailLocation((IRetailLocation)argValue);
/*      */     }
/* 1335 */     else if ("Address".equals(argFieldId)) {
/* 1336 */       setAddress((IShipmentAddress)argValue);
/*      */     }
/* 1338 */     else if ("ShipmentLineItems".equals(argFieldId)) {
/* 1339 */       setShipmentLineItems(changeToList(argValue, IShipmentLineItem.class));
/*      */     }
/* 1341 */     else if ("Properties".equals(argFieldId)) {
/* 1342 */       setProperties(changeToList(argValue, IShipmentProperty.class));
/*      */     }
/* 1344 */     else if ("ShipmentExtension".equals(argFieldId)) {
/* 1345 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1348 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1354 */     this._persistenceDefaults = argPD;
/* 1355 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1356 */     this._eventManager = argEM;
/* 1357 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1358 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1359 */     if (this._destinationParty != null) {
/* 1360 */       ((IDataModelImpl)this._destinationParty).setDependencies(argPD, argEM);
/*      */     }
/* 1362 */     if (this._destinationRetailLocation != null) {
/* 1363 */       ((IDataModelImpl)this._destinationRetailLocation).setDependencies(argPD, argEM);
/*      */     }
/* 1365 */     if (this._address != null) {
/* 1366 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*      */     }
/* 1368 */     if (this._shipmentLineItems != null) {
/* 1369 */       for (IShipmentLineItem relationship : this._shipmentLineItems) {
/* 1370 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1373 */     if (this._properties != null) {
/* 1374 */       for (IShipmentProperty relationship : this._properties) {
/* 1375 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getShipmentExt() {
/* 1381 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setShipmentExt(IDataModel argExt) {
/* 1385 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1390 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1394 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1397 */     super.startTransaction();
/*      */     
/* 1399 */     this._destinationPartySavepoint = this._destinationParty;
/* 1400 */     if (this._destinationParty != null) {
/* 1401 */       this._destinationParty.startTransaction();
/*      */     }
/*      */     
/* 1404 */     this._destinationRetailLocationSavepoint = this._destinationRetailLocation;
/* 1405 */     if (this._destinationRetailLocation != null) {
/* 1406 */       this._destinationRetailLocation.startTransaction();
/*      */     }
/*      */     
/* 1409 */     this._addressSavepoint = this._address;
/* 1410 */     if (this._address != null) {
/* 1411 */       this._address.startTransaction();
/*      */     }
/*      */     
/* 1414 */     this._shipmentLineItemsSavepoint = this._shipmentLineItems;
/* 1415 */     if (this._shipmentLineItems != null) {
/* 1416 */       this._shipmentLineItemsSavepoint = new HistoricalList((List)this._shipmentLineItems);
/* 1417 */       Iterator<IDataModel> it = this._shipmentLineItems.iterator();
/* 1418 */       while (it.hasNext()) {
/* 1419 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1423 */     this._propertiesSavepoint = this._properties;
/* 1424 */     if (this._properties != null) {
/* 1425 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1426 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1427 */       while (it.hasNext()) {
/* 1428 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1433 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1438 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1441 */     super.rollbackChanges();
/*      */     
/* 1443 */     this._destinationParty = this._destinationPartySavepoint;
/* 1444 */     this._destinationPartySavepoint = null;
/* 1445 */     if (this._destinationParty != null) {
/* 1446 */       this._destinationParty.rollbackChanges();
/*      */     }
/*      */     
/* 1449 */     this._destinationRetailLocation = this._destinationRetailLocationSavepoint;
/* 1450 */     this._destinationRetailLocationSavepoint = null;
/* 1451 */     if (this._destinationRetailLocation != null) {
/* 1452 */       this._destinationRetailLocation.rollbackChanges();
/*      */     }
/*      */     
/* 1455 */     this._address = this._addressSavepoint;
/* 1456 */     this._addressSavepoint = null;
/* 1457 */     if (this._address != null) {
/* 1458 */       this._address.rollbackChanges();
/*      */     }
/*      */     
/* 1461 */     this._shipmentLineItems = this._shipmentLineItemsSavepoint;
/* 1462 */     this._shipmentLineItemsSavepoint = null;
/* 1463 */     if (this._shipmentLineItems != null) {
/* 1464 */       Iterator<IDataModel> it = this._shipmentLineItems.iterator();
/* 1465 */       while (it.hasNext()) {
/* 1466 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1470 */     this._properties = this._propertiesSavepoint;
/* 1471 */     this._propertiesSavepoint = null;
/* 1472 */     if (this._properties != null) {
/* 1473 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1474 */       while (it.hasNext()) {
/* 1475 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1483 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1486 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1489 */     super.commitTransaction();
/*      */     
/* 1491 */     this._destinationPartySavepoint = this._destinationParty;
/* 1492 */     if (this._destinationParty != null) {
/* 1493 */       this._destinationParty.commitTransaction();
/*      */     }
/*      */     
/* 1496 */     this._destinationRetailLocationSavepoint = this._destinationRetailLocation;
/* 1497 */     if (this._destinationRetailLocation != null) {
/* 1498 */       this._destinationRetailLocation.commitTransaction();
/*      */     }
/*      */     
/* 1501 */     this._addressSavepoint = this._address;
/* 1502 */     if (this._address != null) {
/* 1503 */       this._address.commitTransaction();
/*      */     }
/*      */     
/* 1506 */     this._shipmentLineItemsSavepoint = this._shipmentLineItems;
/* 1507 */     if (this._shipmentLineItems != null) {
/* 1508 */       Iterator<IDataModel> it = this._shipmentLineItems.iterator();
/* 1509 */       while (it.hasNext()) {
/* 1510 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1512 */       this._shipmentLineItems = new HistoricalList((List)this._shipmentLineItems);
/*      */     } 
/*      */     
/* 1515 */     this._propertiesSavepoint = this._properties;
/* 1516 */     if (this._properties != null) {
/* 1517 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1518 */       while (it.hasNext()) {
/* 1519 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1521 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1525 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */