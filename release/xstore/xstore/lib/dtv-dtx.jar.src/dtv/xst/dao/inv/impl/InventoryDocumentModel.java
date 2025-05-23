/*      */ package dtv.xst.dao.inv.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.com.IAddress;
/*      */ import dtv.xst.dao.inv.ICarton;
/*      */ import dtv.xst.dao.inv.IDocumentNote;
/*      */ import dtv.xst.dao.inv.IInventoryDocument;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentProperty;
/*      */ import dtv.xst.dao.inv.IShipment;
/*      */ import dtv.xst.dao.inv.InventoryDocumentPropertyId;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class InventoryDocumentModel extends InventoryDocumentBaseModel implements IInventoryDocument {
/*      */   private static final long serialVersionUID = 284848759L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IInventoryDocumentLineItem> _inventoryDocumentLineItems;
/*      */   private transient HistoricalList<IInventoryDocumentLineItem> _inventoryDocumentLineItemsSavepoint;
/*      */   private HistoricalList<IShipment> _shipments;
/*      */   private transient HistoricalList<IShipment> _shipmentsSavepoint;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<ICarton> _cartons; private transient HistoricalList<ICarton> _cartonsSavepoint; private HistoricalList<IDocumentNote> _notes; private transient HistoricalList<IDocumentNote> _notesSavepoint; private IAddress _originatorAddress; private transient IAddress _originatorAddressSavepoint; private HistoricalList<IInventoryDocumentProperty> _properties; private transient HistoricalList<IInventoryDocumentProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new InventoryDocumentDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InventoryDocumentDAO getDAO_() {
/*   48 */     return (InventoryDocumentDAO)this._daoImpl;
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
/*   67 */       this._events.post(IInventoryDocument.SET_DOCUMENTID, argDocumentId);
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
/*   80 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*   82 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((InventoryDocumentLineItemModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*   88 */       if (this._shipments != null) {
/*      */         
/*   90 */         Iterator<ShipmentModel> it = this._shipments.iterator();
/*   91 */         while (it.hasNext())
/*      */         {
/*   93 */           ((ShipmentModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*   96 */       if (this._cartons != null) {
/*      */         
/*   98 */         Iterator<CartonModel> it = this._cartons.iterator();
/*   99 */         while (it.hasNext())
/*      */         {
/*  101 */           ((CartonModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  104 */       if (this._notes != null) {
/*      */         
/*  106 */         Iterator<DocumentNoteModel> it = this._notes.iterator();
/*  107 */         while (it.hasNext())
/*      */         {
/*  109 */           ((DocumentNoteModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  112 */       if (this._properties != null) {
/*      */         
/*  114 */         Iterator<InventoryDocumentPropertyModel> it = this._properties.iterator();
/*  115 */         while (it.hasNext())
/*      */         {
/*  117 */           ((InventoryDocumentPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  122 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentTypeCode() {
/*  130 */     return getDAO_().getDocumentTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  138 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/*  139 */       this._events != null && 
/*  140 */       postEventsForChanges()) {
/*  141 */       this._events.post(IInventoryDocument.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/*  148 */     boolean ev_postable = false;
/*      */     
/*  150 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/*  151 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/*  152 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/*  153 */       ev_postable = true;
/*  154 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  156 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  157 */         while (it.hasNext())
/*      */         {
/*  159 */           ((InventoryDocumentLineItemModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  162 */       if (this._shipments != null) {
/*      */         
/*  164 */         Iterator<ShipmentModel> it = this._shipments.iterator();
/*  165 */         while (it.hasNext())
/*      */         {
/*  167 */           ((ShipmentModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  170 */       if (this._cartons != null) {
/*      */         
/*  172 */         Iterator<CartonModel> it = this._cartons.iterator();
/*  173 */         while (it.hasNext())
/*      */         {
/*  175 */           ((CartonModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  178 */       if (this._notes != null) {
/*      */         
/*  180 */         Iterator<DocumentNoteModel> it = this._notes.iterator();
/*  181 */         while (it.hasNext())
/*      */         {
/*  183 */           ((DocumentNoteModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  186 */       if (this._properties != null) {
/*      */         
/*  188 */         Iterator<InventoryDocumentPropertyModel> it = this._properties.iterator();
/*  189 */         while (it.hasNext())
/*      */         {
/*  191 */           ((InventoryDocumentPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  196 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  204 */     if (getDAO_().getOrganizationId() != null) {
/*  205 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  208 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  217 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  218 */       this._events != null && 
/*  219 */       postEventsForChanges()) {
/*  220 */       this._events.post(IInventoryDocument.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  227 */     boolean ev_postable = false;
/*      */     
/*  229 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  230 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  231 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  232 */       ev_postable = true;
/*  233 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  235 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  236 */         while (it.hasNext())
/*      */         {
/*  238 */           ((InventoryDocumentLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  241 */       if (this._shipments != null) {
/*      */         
/*  243 */         Iterator<ShipmentModel> it = this._shipments.iterator();
/*  244 */         while (it.hasNext())
/*      */         {
/*  246 */           ((ShipmentModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  249 */       if (this._cartons != null) {
/*      */         
/*  251 */         Iterator<CartonModel> it = this._cartons.iterator();
/*  252 */         while (it.hasNext())
/*      */         {
/*  254 */           ((CartonModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  257 */       if (this._notes != null) {
/*      */         
/*  259 */         Iterator<DocumentNoteModel> it = this._notes.iterator();
/*  260 */         while (it.hasNext())
/*      */         {
/*  262 */           ((DocumentNoteModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  265 */       if (this._properties != null) {
/*      */         
/*  267 */         Iterator<InventoryDocumentPropertyModel> it = this._properties.iterator();
/*  268 */         while (it.hasNext())
/*      */         {
/*  270 */           ((InventoryDocumentPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  275 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  283 */     if (getDAO_().getRetailLocationId() != null) {
/*  284 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  287 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  296 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  297 */       this._events != null && 
/*  298 */       postEventsForChanges()) {
/*  299 */       this._events.post(IInventoryDocument.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  306 */     boolean ev_postable = false;
/*      */     
/*  308 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  309 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  310 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  311 */       ev_postable = true;
/*  312 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  314 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  315 */         while (it.hasNext())
/*      */         {
/*  317 */           ((InventoryDocumentLineItemModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  320 */       if (this._shipments != null) {
/*      */         
/*  322 */         Iterator<ShipmentModel> it = this._shipments.iterator();
/*  323 */         while (it.hasNext())
/*      */         {
/*  325 */           ((ShipmentModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  328 */       if (this._cartons != null) {
/*      */         
/*  330 */         Iterator<CartonModel> it = this._cartons.iterator();
/*  331 */         while (it.hasNext())
/*      */         {
/*  333 */           ((CartonModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  336 */       if (this._notes != null) {
/*      */         
/*  338 */         Iterator<DocumentNoteModel> it = this._notes.iterator();
/*  339 */         while (it.hasNext())
/*      */         {
/*  341 */           ((DocumentNoteModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  344 */       if (this._properties != null) {
/*      */         
/*  346 */         Iterator<InventoryDocumentPropertyModel> it = this._properties.iterator();
/*  347 */         while (it.hasNext())
/*      */         {
/*  349 */           ((InventoryDocumentPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  354 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  362 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  370 */     if (setCreateDate_noev(argCreateDate) && 
/*  371 */       this._events != null && 
/*  372 */       postEventsForChanges()) {
/*  373 */       this._events.post(IInventoryDocument.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  380 */     boolean ev_postable = false;
/*      */     
/*  382 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  383 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  384 */       getDAO_().setCreateDate(argCreateDate);
/*  385 */       ev_postable = true;
/*      */     } 
/*      */     
/*  388 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  396 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  404 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  405 */       this._events != null && 
/*  406 */       postEventsForChanges()) {
/*  407 */       this._events.post(IInventoryDocument.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  414 */     boolean ev_postable = false;
/*      */     
/*  416 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  417 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  418 */       getDAO_().setCreateUserId(argCreateUserId);
/*  419 */       ev_postable = true;
/*      */     } 
/*      */     
/*  422 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  430 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  438 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  439 */       this._events != null && 
/*  440 */       postEventsForChanges()) {
/*  441 */       this._events.post(IInventoryDocument.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  448 */     boolean ev_postable = false;
/*      */     
/*  450 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  451 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  452 */       getDAO_().setUpdateDate(argUpdateDate);
/*  453 */       ev_postable = true;
/*      */     } 
/*      */     
/*  456 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  464 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  472 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  473 */       this._events != null && 
/*  474 */       postEventsForChanges()) {
/*  475 */       this._events.post(IInventoryDocument.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  482 */     boolean ev_postable = false;
/*      */     
/*  484 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  485 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  486 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  487 */       ev_postable = true;
/*      */     } 
/*      */     
/*  490 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCompleteDateTime() {
/*  498 */     return getDAO_().getCompleteDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompleteDateTime(Date argCompleteDateTime) {
/*  506 */     if (setCompleteDateTime_noev(argCompleteDateTime) && 
/*  507 */       this._events != null && 
/*  508 */       postEventsForChanges()) {
/*  509 */       this._events.post(IInventoryDocument.SET_COMPLETEDATETIME, argCompleteDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCompleteDateTime_noev(Date argCompleteDateTime) {
/*  516 */     boolean ev_postable = false;
/*      */     
/*  518 */     if ((getDAO_().getCompleteDateTime() == null && argCompleteDateTime != null) || (
/*  519 */       getDAO_().getCompleteDateTime() != null && !getDAO_().getCompleteDateTime().equals(argCompleteDateTime))) {
/*  520 */       getDAO_().setCompleteDateTime(argCompleteDateTime);
/*  521 */       ev_postable = true;
/*      */     } 
/*      */     
/*  524 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDateTime() {
/*  532 */     return getDAO_().getCreateDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDateTime(Date argCreateDateTime) {
/*  540 */     if (setCreateDateTime_noev(argCreateDateTime) && 
/*  541 */       this._events != null && 
/*  542 */       postEventsForChanges()) {
/*  543 */       this._events.post(IInventoryDocument.SET_CREATEDATETIME, argCreateDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDateTime_noev(Date argCreateDateTime) {
/*  550 */     boolean ev_postable = false;
/*      */     
/*  552 */     if ((getDAO_().getCreateDateTime() == null && argCreateDateTime != null) || (
/*  553 */       getDAO_().getCreateDateTime() != null && !getDAO_().getCreateDateTime().equals(argCreateDateTime))) {
/*  554 */       getDAO_().setCreateDateTime(argCreateDateTime);
/*  555 */       ev_postable = true;
/*      */     } 
/*      */     
/*  558 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginatorId() {
/*  566 */     return getDAO_().getOriginatorId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginatorId(String argOriginatorId) {
/*  574 */     if (setOriginatorId_noev(argOriginatorId) && 
/*  575 */       this._events != null && 
/*  576 */       postEventsForChanges()) {
/*  577 */       this._events.post(IInventoryDocument.SET_ORIGINATORID, argOriginatorId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginatorId_noev(String argOriginatorId) {
/*  584 */     boolean ev_postable = false;
/*      */     
/*  586 */     if ((getDAO_().getOriginatorId() == null && argOriginatorId != null) || (
/*  587 */       getDAO_().getOriginatorId() != null && !getDAO_().getOriginatorId().equals(argOriginatorId))) {
/*  588 */       getDAO_().setOriginatorId(argOriginatorId);
/*  589 */       ev_postable = true;
/*      */     } 
/*      */     
/*  592 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  600 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  608 */     if (setStatusCode_noev(argStatusCode) && 
/*  609 */       this._events != null && 
/*  610 */       postEventsForChanges()) {
/*  611 */       this._events.post(IInventoryDocument.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  618 */     boolean ev_postable = false;
/*      */     
/*  620 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  621 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  622 */       getDAO_().setStatusCode(argStatusCode);
/*  623 */       ev_postable = true;
/*      */     } 
/*      */     
/*  626 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentSubtypeCode() {
/*  634 */     return getDAO_().getDocumentSubtypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentSubtypeCode(String argDocumentSubtypeCode) {
/*  642 */     if (setDocumentSubtypeCode_noev(argDocumentSubtypeCode) && 
/*  643 */       this._events != null && 
/*  644 */       postEventsForChanges()) {
/*  645 */       this._events.post(IInventoryDocument.SET_DOCUMENTSUBTYPECODE, argDocumentSubtypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentSubtypeCode_noev(String argDocumentSubtypeCode) {
/*  652 */     boolean ev_postable = false;
/*      */     
/*  654 */     if ((getDAO_().getDocumentSubtypeCode() == null && argDocumentSubtypeCode != null) || (
/*  655 */       getDAO_().getDocumentSubtypeCode() != null && !getDAO_().getDocumentSubtypeCode().equals(argDocumentSubtypeCode))) {
/*  656 */       getDAO_().setDocumentSubtypeCode(argDocumentSubtypeCode);
/*  657 */       ev_postable = true;
/*      */     } 
/*      */     
/*  660 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginatorName() {
/*  668 */     return getDAO_().getOriginatorName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginatorName(String argOriginatorName) {
/*  676 */     if (setOriginatorName_noev(argOriginatorName) && 
/*  677 */       this._events != null && 
/*  678 */       postEventsForChanges()) {
/*  679 */       this._events.post(IInventoryDocument.SET_ORIGINATORNAME, argOriginatorName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginatorName_noev(String argOriginatorName) {
/*  686 */     boolean ev_postable = false;
/*      */     
/*  688 */     if ((getDAO_().getOriginatorName() == null && argOriginatorName != null) || (
/*  689 */       getDAO_().getOriginatorName() != null && !getDAO_().getOriginatorName().equals(argOriginatorName))) {
/*  690 */       getDAO_().setOriginatorName(argOriginatorName);
/*  691 */       ev_postable = true;
/*      */     } 
/*      */     
/*  694 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getLastActivityDate() {
/*  702 */     return getDAO_().getLastActivityDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastActivityDate(Date argLastActivityDate) {
/*  710 */     if (setLastActivityDate_noev(argLastActivityDate) && 
/*  711 */       this._events != null && 
/*  712 */       postEventsForChanges()) {
/*  713 */       this._events.post(IInventoryDocument.SET_LASTACTIVITYDATE, argLastActivityDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastActivityDate_noev(Date argLastActivityDate) {
/*  720 */     boolean ev_postable = false;
/*      */     
/*  722 */     if ((getDAO_().getLastActivityDate() == null && argLastActivityDate != null) || (
/*  723 */       getDAO_().getLastActivityDate() != null && !getDAO_().getLastActivityDate().equals(argLastActivityDate))) {
/*  724 */       getDAO_().setLastActivityDate(argLastActivityDate);
/*  725 */       ev_postable = true;
/*      */     } 
/*      */     
/*  728 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPoReferenceNumber() {
/*  736 */     return getDAO_().getPoReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPoReferenceNumber(String argPoReferenceNumber) {
/*  744 */     if (setPoReferenceNumber_noev(argPoReferenceNumber) && 
/*  745 */       this._events != null && 
/*  746 */       postEventsForChanges()) {
/*  747 */       this._events.post(IInventoryDocument.SET_POREFERENCENUMBER, argPoReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPoReferenceNumber_noev(String argPoReferenceNumber) {
/*  754 */     boolean ev_postable = false;
/*      */     
/*  756 */     if ((getDAO_().getPoReferenceNumber() == null && argPoReferenceNumber != null) || (
/*  757 */       getDAO_().getPoReferenceNumber() != null && !getDAO_().getPoReferenceNumber().equals(argPoReferenceNumber))) {
/*  758 */       getDAO_().setPoReferenceNumber(argPoReferenceNumber);
/*  759 */       ev_postable = true;
/*      */     } 
/*      */     
/*  762 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRecordCreationType() {
/*  770 */     return getDAO_().getRecordCreationType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRecordCreationType(String argRecordCreationType) {
/*  778 */     if (setRecordCreationType_noev(argRecordCreationType) && 
/*  779 */       this._events != null && 
/*  780 */       postEventsForChanges()) {
/*  781 */       this._events.post(IInventoryDocument.SET_RECORDCREATIONTYPE, argRecordCreationType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRecordCreationType_noev(String argRecordCreationType) {
/*  788 */     boolean ev_postable = false;
/*      */     
/*  790 */     if ((getDAO_().getRecordCreationType() == null && argRecordCreationType != null) || (
/*  791 */       getDAO_().getRecordCreationType() != null && !getDAO_().getRecordCreationType().equals(argRecordCreationType))) {
/*  792 */       getDAO_().setRecordCreationType(argRecordCreationType);
/*  793 */       ev_postable = true;
/*      */     } 
/*      */     
/*  796 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  804 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  812 */     if (setDescription_noev(argDescription) && 
/*  813 */       this._events != null && 
/*  814 */       postEventsForChanges()) {
/*  815 */       this._events.post(IInventoryDocument.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  822 */     boolean ev_postable = false;
/*      */     
/*  824 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  825 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  826 */       getDAO_().setDescription(argDescription);
/*  827 */       ev_postable = true;
/*      */     } 
/*      */     
/*  830 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getControlNumber() {
/*  838 */     return getDAO_().getControlNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setControlNumber(String argControlNumber) {
/*  846 */     if (setControlNumber_noev(argControlNumber) && 
/*  847 */       this._events != null && 
/*  848 */       postEventsForChanges()) {
/*  849 */       this._events.post(IInventoryDocument.SET_CONTROLNUMBER, argControlNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setControlNumber_noev(String argControlNumber) {
/*  856 */     boolean ev_postable = false;
/*      */     
/*  858 */     if ((getDAO_().getControlNumber() == null && argControlNumber != null) || (
/*  859 */       getDAO_().getControlNumber() != null && !getDAO_().getControlNumber().equals(argControlNumber))) {
/*  860 */       getDAO_().setControlNumber(argControlNumber);
/*  861 */       ev_postable = true;
/*      */     } 
/*      */     
/*  864 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginatorAddressId() {
/*  872 */     return getDAO_().getOriginatorAddressId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginatorAddressId(String argOriginatorAddressId) {
/*  880 */     if (setOriginatorAddressId_noev(argOriginatorAddressId) && 
/*  881 */       this._events != null && 
/*  882 */       postEventsForChanges()) {
/*  883 */       this._events.post(IInventoryDocument.SET_ORIGINATORADDRESSID, argOriginatorAddressId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginatorAddressId_noev(String argOriginatorAddressId) {
/*  890 */     boolean ev_postable = false;
/*      */     
/*  892 */     if ((getDAO_().getOriginatorAddressId() == null && argOriginatorAddressId != null) || (
/*  893 */       getDAO_().getOriginatorAddressId() != null && !getDAO_().getOriginatorAddressId().equals(argOriginatorAddressId))) {
/*  894 */       getDAO_().setOriginatorAddressId(argOriginatorAddressId);
/*  895 */       ev_postable = true;
/*      */     } 
/*      */     
/*  898 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getSubmitDate() {
/*  906 */     return getDAO_().getSubmitDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubmitDate(Date argSubmitDate) {
/*  914 */     if (setSubmitDate_noev(argSubmitDate) && 
/*  915 */       this._events != null && 
/*  916 */       postEventsForChanges()) {
/*  917 */       this._events.post(IInventoryDocument.SET_SUBMITDATE, argSubmitDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSubmitDate_noev(Date argSubmitDate) {
/*  924 */     boolean ev_postable = false;
/*      */     
/*  926 */     if ((getDAO_().getSubmitDate() == null && argSubmitDate != null) || (
/*  927 */       getDAO_().getSubmitDate() != null && !getDAO_().getSubmitDate().equals(argSubmitDate))) {
/*  928 */       getDAO_().setSubmitDate(argSubmitDate);
/*  929 */       ev_postable = true;
/*      */     } 
/*      */     
/*  932 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IInventoryDocumentProperty newProperty(String argPropertyName) {
/*  936 */     InventoryDocumentPropertyId id = new InventoryDocumentPropertyId();
/*      */     
/*  938 */     id.setDocumentId(getDocumentId());
/*  939 */     id.setDocumentTypeCode(getDocumentTypeCode());
/*  940 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  941 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  943 */     IInventoryDocumentProperty prop = (IInventoryDocumentProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryDocumentProperty.class);
/*  944 */     return prop;
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "InventoryDocumentLineItems")
/*      */   public List<IInventoryDocumentLineItem> getInventoryDocumentLineItems() {
/*  968 */     if (this._inventoryDocumentLineItems == null) {
/*  969 */       this._inventoryDocumentLineItems = new HistoricalList(null);
/*      */     }
/*  971 */     return (List<IInventoryDocumentLineItem>)this._inventoryDocumentLineItems;
/*      */   }
/*      */   
/*      */   public void setInventoryDocumentLineItems(List<IInventoryDocumentLineItem> argInventoryDocumentLineItems) {
/*  975 */     if (this._inventoryDocumentLineItems == null) {
/*  976 */       this._inventoryDocumentLineItems = new HistoricalList(argInventoryDocumentLineItems);
/*      */     } else {
/*  978 */       this._inventoryDocumentLineItems.setCurrentList(argInventoryDocumentLineItems);
/*      */     } 
/*      */     
/*  981 */     for (IInventoryDocumentLineItem child : this._inventoryDocumentLineItems) {
/*  982 */       child.setParentDocument(this);
/*      */     }
/*      */ 
/*      */     
/*  986 */     for (IInventoryDocumentLineItem child : this._inventoryDocumentLineItems) {
/*  987 */       InventoryDocumentLineItemModel model = (InventoryDocumentLineItemModel)child;
/*  988 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/*  989 */       model.setDocumentId_noev(getDocumentId());
/*  990 */       model.setOrganizationId_noev(getOrganizationId());
/*  991 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  992 */       if (child instanceof IDataModelImpl) {
/*  993 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  994 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  995 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  996 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  999 */       if (postEventsForChanges()) {
/* 1000 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryDocumentLineItem(IInventoryDocumentLineItem argInventoryDocumentLineItem) {
/* 1006 */     super.addInventoryDocumentLineItem(argInventoryDocumentLineItem);
/*      */ 
/*      */     
/* 1009 */     argInventoryDocumentLineItem.setParentDocument(this);
/* 1010 */     if (this._inventoryDocumentLineItems == null) {
/* 1011 */       this._inventoryDocumentLineItems = new HistoricalList(null);
/*      */     }
/* 1013 */     argInventoryDocumentLineItem.setDocumentTypeCode(getDocumentTypeCode());
/* 1014 */     argInventoryDocumentLineItem.setDocumentId(getDocumentId());
/* 1015 */     argInventoryDocumentLineItem.setOrganizationId(getOrganizationId());
/* 1016 */     argInventoryDocumentLineItem.setRetailLocationId(getRetailLocationId());
/* 1017 */     if (argInventoryDocumentLineItem instanceof IDataModelImpl) {
/* 1018 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentLineItem).getDAO();
/* 1019 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1020 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1021 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1026 */     if (postEventsForChanges()) {
/* 1027 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItem));
/*      */     }
/*      */     
/* 1030 */     this._inventoryDocumentLineItems.add(argInventoryDocumentLineItem);
/* 1031 */     if (postEventsForChanges()) {
/* 1032 */       this._events.post(IInventoryDocument.ADD_INVENTORYDOCUMENTLINEITEMS, argInventoryDocumentLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryDocumentLineItem(IInventoryDocumentLineItem argInventoryDocumentLineItem) {
/* 1037 */     if (this._inventoryDocumentLineItems != null) {
/*      */       
/* 1039 */       if (postEventsForChanges()) {
/* 1040 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItem));
/*      */       }
/* 1042 */       this._inventoryDocumentLineItems.remove(argInventoryDocumentLineItem);
/*      */       
/* 1044 */       argInventoryDocumentLineItem.setParentDocument(null);
/* 1045 */       if (postEventsForChanges()) {
/* 1046 */         this._events.post(IInventoryDocument.REMOVE_INVENTORYDOCUMENTLINEITEMS, argInventoryDocumentLineItem);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Shipments")
/*      */   public List<IShipment> getShipments() {
/* 1053 */     if (this._shipments == null) {
/* 1054 */       this._shipments = new HistoricalList(null);
/*      */     }
/* 1056 */     return (List<IShipment>)this._shipments;
/*      */   }
/*      */   
/*      */   public void setShipments(List<IShipment> argShipments) {
/* 1060 */     if (this._shipments == null) {
/* 1061 */       this._shipments = new HistoricalList(argShipments);
/*      */     } else {
/* 1063 */       this._shipments.setCurrentList(argShipments);
/*      */     } 
/*      */     
/* 1066 */     for (IShipment child : this._shipments) {
/* 1067 */       child.setParentDocument(this);
/*      */     }
/*      */ 
/*      */     
/* 1071 */     for (IShipment child : this._shipments) {
/* 1072 */       ShipmentModel model = (ShipmentModel)child;
/* 1073 */       model.setOrganizationId_noev(getOrganizationId());
/* 1074 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1075 */       model.setDocumentId_noev(getDocumentId());
/* 1076 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1077 */       if (child instanceof IDataModelImpl) {
/* 1078 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1079 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1080 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1081 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1084 */       if (postEventsForChanges()) {
/* 1085 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addShipment(IShipment argShipment) {
/* 1091 */     super.addShipment(argShipment);
/*      */ 
/*      */     
/* 1094 */     argShipment.setParentDocument(this);
/* 1095 */     if (this._shipments == null) {
/* 1096 */       this._shipments = new HistoricalList(null);
/*      */     }
/* 1098 */     argShipment.setOrganizationId(getOrganizationId());
/* 1099 */     argShipment.setRetailLocationId(getRetailLocationId());
/* 1100 */     argShipment.setDocumentId(getDocumentId());
/* 1101 */     argShipment.setDocumentTypeCode(getDocumentTypeCode());
/* 1102 */     if (argShipment instanceof IDataModelImpl) {
/* 1103 */       IDataAccessObject childDao = ((IDataModelImpl)argShipment).getDAO();
/* 1104 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1105 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1106 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1111 */     if (postEventsForChanges()) {
/* 1112 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipment));
/*      */     }
/*      */     
/* 1115 */     this._shipments.add(argShipment);
/* 1116 */     if (postEventsForChanges()) {
/* 1117 */       this._events.post(IInventoryDocument.ADD_SHIPMENTS, argShipment);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeShipment(IShipment argShipment) {
/* 1122 */     if (this._shipments != null) {
/*      */       
/* 1124 */       if (postEventsForChanges()) {
/* 1125 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipment));
/*      */       }
/* 1127 */       this._shipments.remove(argShipment);
/*      */       
/* 1129 */       argShipment.setParentDocument(null);
/* 1130 */       if (postEventsForChanges()) {
/* 1131 */         this._events.post(IInventoryDocument.REMOVE_SHIPMENTS, argShipment);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Cartons")
/*      */   public List<ICarton> getCartons() {
/* 1138 */     if (this._cartons == null) {
/* 1139 */       this._cartons = new HistoricalList(null);
/*      */     }
/* 1141 */     return (List<ICarton>)this._cartons;
/*      */   }
/*      */   
/*      */   public void setCartons(List<ICarton> argCartons) {
/* 1145 */     if (this._cartons == null) {
/* 1146 */       this._cartons = new HistoricalList(argCartons);
/*      */     } else {
/* 1148 */       this._cartons.setCurrentList(argCartons);
/*      */     } 
/*      */     
/* 1151 */     for (ICarton child : this._cartons) {
/* 1152 */       child.setParentDocument(this);
/*      */     }
/*      */ 
/*      */     
/* 1156 */     for (ICarton child : this._cartons) {
/* 1157 */       CartonModel model = (CartonModel)child;
/* 1158 */       model.setOrganizationId_noev(getOrganizationId());
/* 1159 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1160 */       model.setDocumentId_noev(getDocumentId());
/* 1161 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1162 */       if (child instanceof IDataModelImpl) {
/* 1163 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1164 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1165 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1166 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1169 */       if (postEventsForChanges()) {
/* 1170 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCarton(ICarton argCarton) {
/* 1176 */     super.addCarton(argCarton);
/*      */ 
/*      */     
/* 1179 */     argCarton.setParentDocument(this);
/* 1180 */     if (this._cartons == null) {
/* 1181 */       this._cartons = new HistoricalList(null);
/*      */     }
/* 1183 */     argCarton.setOrganizationId(getOrganizationId());
/* 1184 */     argCarton.setRetailLocationId(getRetailLocationId());
/* 1185 */     argCarton.setDocumentId(getDocumentId());
/* 1186 */     argCarton.setDocumentTypeCode(getDocumentTypeCode());
/* 1187 */     if (argCarton instanceof IDataModelImpl) {
/* 1188 */       IDataAccessObject childDao = ((IDataModelImpl)argCarton).getDAO();
/* 1189 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1190 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1191 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1196 */     if (postEventsForChanges()) {
/* 1197 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCarton));
/*      */     }
/*      */     
/* 1200 */     this._cartons.add(argCarton);
/* 1201 */     if (postEventsForChanges()) {
/* 1202 */       this._events.post(IInventoryDocument.ADD_CARTONS, argCarton);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCarton(ICarton argCarton) {
/* 1207 */     if (this._cartons != null) {
/*      */       
/* 1209 */       if (postEventsForChanges()) {
/* 1210 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCarton));
/*      */       }
/* 1212 */       this._cartons.remove(argCarton);
/*      */       
/* 1214 */       argCarton.setParentDocument(null);
/* 1215 */       if (postEventsForChanges()) {
/* 1216 */         this._events.post(IInventoryDocument.REMOVE_CARTONS, argCarton);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Notes")
/*      */   public List<IDocumentNote> getNotes() {
/* 1223 */     if (this._notes == null) {
/* 1224 */       this._notes = new HistoricalList(null);
/*      */     }
/* 1226 */     return (List<IDocumentNote>)this._notes;
/*      */   }
/*      */   
/*      */   public void setNotes(List<IDocumentNote> argNotes) {
/* 1230 */     if (this._notes == null) {
/* 1231 */       this._notes = new HistoricalList(argNotes);
/*      */     } else {
/* 1233 */       this._notes.setCurrentList(argNotes);
/*      */     } 
/*      */     
/* 1236 */     for (IDocumentNote child : this._notes) {
/* 1237 */       child.setParentDocument(this);
/*      */     }
/*      */ 
/*      */     
/* 1241 */     for (IDocumentNote child : this._notes) {
/* 1242 */       DocumentNoteModel model = (DocumentNoteModel)child;
/* 1243 */       model.setOrganizationId_noev(getOrganizationId());
/* 1244 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1245 */       model.setDocumentId_noev(getDocumentId());
/* 1246 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1247 */       if (child instanceof IDataModelImpl) {
/* 1248 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1249 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1250 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1251 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1254 */       if (postEventsForChanges()) {
/* 1255 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDocumentNote(IDocumentNote argDocumentNote) {
/* 1261 */     super.addDocumentNote(argDocumentNote);
/*      */ 
/*      */     
/* 1264 */     argDocumentNote.setParentDocument(this);
/* 1265 */     if (this._notes == null) {
/* 1266 */       this._notes = new HistoricalList(null);
/*      */     }
/* 1268 */     argDocumentNote.setOrganizationId(getOrganizationId());
/* 1269 */     argDocumentNote.setRetailLocationId(getRetailLocationId());
/* 1270 */     argDocumentNote.setDocumentId(getDocumentId());
/* 1271 */     argDocumentNote.setDocumentTypeCode(getDocumentTypeCode());
/* 1272 */     if (argDocumentNote instanceof IDataModelImpl) {
/* 1273 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentNote).getDAO();
/* 1274 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1275 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1276 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1281 */     if (postEventsForChanges()) {
/* 1282 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentNote));
/*      */     }
/*      */     
/* 1285 */     this._notes.add(argDocumentNote);
/* 1286 */     if (postEventsForChanges()) {
/* 1287 */       this._events.post(IInventoryDocument.ADD_NOTES, argDocumentNote);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDocumentNote(IDocumentNote argDocumentNote) {
/* 1292 */     if (this._notes != null) {
/*      */       
/* 1294 */       if (postEventsForChanges()) {
/* 1295 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentNote));
/*      */       }
/* 1297 */       this._notes.remove(argDocumentNote);
/*      */       
/* 1299 */       argDocumentNote.setParentDocument(null);
/* 1300 */       if (postEventsForChanges()) {
/* 1301 */         this._events.post(IInventoryDocument.REMOVE_NOTES, argDocumentNote);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "OriginatorAddress")
/*      */   public IAddress getOriginatorAddress() {
/* 1308 */     return this._originatorAddress;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOriginatorAddress(IAddress argOriginatorAddress) {
/* 1313 */     if (argOriginatorAddress == null) {
/*      */       
/* 1315 */       getDAO_().setOriginatorAddressId(null);
/* 1316 */       if (this._originatorAddress != null)
/*      */       {
/* 1318 */         if (postEventsForChanges()) {
/* 1319 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._originatorAddress));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1324 */       getDAO_().setOriginatorAddressId(argOriginatorAddress.getAddressId());
/*      */       
/* 1326 */       if (postEventsForChanges()) {
/* 1327 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOriginatorAddress));
/*      */       }
/*      */     } 
/*      */     
/* 1331 */     this._originatorAddress = argOriginatorAddress;
/* 1332 */     if (postEventsForChanges()) {
/* 1333 */       this._events.post(IInventoryDocument.SET_ORIGINATORADDRESS, argOriginatorAddress);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IInventoryDocumentProperty> getProperties() {
/* 1339 */     if (this._properties == null) {
/* 1340 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1342 */     return (List<IInventoryDocumentProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IInventoryDocumentProperty> argProperties) {
/* 1346 */     if (this._properties == null) {
/* 1347 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1349 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1352 */     for (IInventoryDocumentProperty child : this._properties) {
/* 1353 */       InventoryDocumentPropertyModel model = (InventoryDocumentPropertyModel)child;
/* 1354 */       model.setDocumentId_noev(getDocumentId());
/* 1355 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1356 */       model.setOrganizationId_noev(getOrganizationId());
/* 1357 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1358 */       if (child instanceof IDataModelImpl) {
/* 1359 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1360 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1361 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1362 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1365 */       if (postEventsForChanges()) {
/* 1366 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryDocumentProperty(IInventoryDocumentProperty argInventoryDocumentProperty) {
/* 1372 */     if (this._properties == null) {
/* 1373 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1375 */     argInventoryDocumentProperty.setDocumentId(getDocumentId());
/* 1376 */     argInventoryDocumentProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 1377 */     argInventoryDocumentProperty.setOrganizationId(getOrganizationId());
/* 1378 */     argInventoryDocumentProperty.setRetailLocationId(getRetailLocationId());
/* 1379 */     if (argInventoryDocumentProperty instanceof IDataModelImpl) {
/* 1380 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentProperty).getDAO();
/* 1381 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1382 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1383 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1388 */     if (postEventsForChanges()) {
/* 1389 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentProperty));
/*      */     }
/*      */     
/* 1392 */     this._properties.add(argInventoryDocumentProperty);
/* 1393 */     if (postEventsForChanges()) {
/* 1394 */       this._events.post(IInventoryDocument.ADD_PROPERTIES, argInventoryDocumentProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryDocumentProperty(IInventoryDocumentProperty argInventoryDocumentProperty) {
/* 1399 */     if (this._properties != null) {
/*      */       
/* 1401 */       if (postEventsForChanges()) {
/* 1402 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentProperty));
/*      */       }
/* 1404 */       this._properties.remove(argInventoryDocumentProperty);
/* 1405 */       if (postEventsForChanges()) {
/* 1406 */         this._events.post(IInventoryDocument.REMOVE_PROPERTIES, argInventoryDocumentProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1413 */     if ("InventoryDocumentLineItems".equals(argFieldId)) {
/* 1414 */       return getInventoryDocumentLineItems();
/*      */     }
/* 1416 */     if ("Shipments".equals(argFieldId)) {
/* 1417 */       return getShipments();
/*      */     }
/* 1419 */     if ("Cartons".equals(argFieldId)) {
/* 1420 */       return getCartons();
/*      */     }
/* 1422 */     if ("Notes".equals(argFieldId)) {
/* 1423 */       return getNotes();
/*      */     }
/* 1425 */     if ("OriginatorAddress".equals(argFieldId)) {
/* 1426 */       return getOriginatorAddress();
/*      */     }
/* 1428 */     if ("Properties".equals(argFieldId)) {
/* 1429 */       return getProperties();
/*      */     }
/* 1431 */     if ("InventoryDocumentExtension".equals(argFieldId)) {
/* 1432 */       return this._myExtension;
/*      */     }
/*      */     
/* 1435 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1441 */     if ("InventoryDocumentLineItems".equals(argFieldId)) {
/* 1442 */       setInventoryDocumentLineItems(changeToList(argValue, IInventoryDocumentLineItem.class));
/*      */     }
/* 1444 */     else if ("Shipments".equals(argFieldId)) {
/* 1445 */       setShipments(changeToList(argValue, IShipment.class));
/*      */     }
/* 1447 */     else if ("Cartons".equals(argFieldId)) {
/* 1448 */       setCartons(changeToList(argValue, ICarton.class));
/*      */     }
/* 1450 */     else if ("Notes".equals(argFieldId)) {
/* 1451 */       setNotes(changeToList(argValue, IDocumentNote.class));
/*      */     }
/* 1453 */     else if ("OriginatorAddress".equals(argFieldId)) {
/* 1454 */       setOriginatorAddress((IAddress)argValue);
/*      */     }
/* 1456 */     else if ("Properties".equals(argFieldId)) {
/* 1457 */       setProperties(changeToList(argValue, IInventoryDocumentProperty.class));
/*      */     }
/* 1459 */     else if ("InventoryDocumentExtension".equals(argFieldId)) {
/* 1460 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1463 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1469 */     this._persistenceDefaults = argPD;
/* 1470 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1471 */     this._eventManager = argEM;
/* 1472 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1473 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1474 */     if (this._inventoryDocumentLineItems != null) {
/* 1475 */       for (IInventoryDocumentLineItem relationship : this._inventoryDocumentLineItems) {
/* 1476 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1479 */     if (this._shipments != null) {
/* 1480 */       for (IShipment relationship : this._shipments) {
/* 1481 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1484 */     if (this._cartons != null) {
/* 1485 */       for (ICarton relationship : this._cartons) {
/* 1486 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1489 */     if (this._notes != null) {
/* 1490 */       for (IDocumentNote relationship : this._notes) {
/* 1491 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1494 */     if (this._originatorAddress != null) {
/* 1495 */       ((IDataModelImpl)this._originatorAddress).setDependencies(argPD, argEM);
/*      */     }
/* 1497 */     if (this._properties != null) {
/* 1498 */       for (IInventoryDocumentProperty relationship : this._properties) {
/* 1499 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getInventoryDocumentExt() {
/* 1505 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setInventoryDocumentExt(IDataModel argExt) {
/* 1509 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1514 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1518 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1521 */     super.startTransaction();
/*      */     
/* 1523 */     this._inventoryDocumentLineItemsSavepoint = this._inventoryDocumentLineItems;
/* 1524 */     if (this._inventoryDocumentLineItems != null) {
/* 1525 */       this._inventoryDocumentLineItemsSavepoint = new HistoricalList((List)this._inventoryDocumentLineItems);
/* 1526 */       Iterator<IDataModel> it = this._inventoryDocumentLineItems.iterator();
/* 1527 */       while (it.hasNext()) {
/* 1528 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1532 */     this._shipmentsSavepoint = this._shipments;
/* 1533 */     if (this._shipments != null) {
/* 1534 */       this._shipmentsSavepoint = new HistoricalList((List)this._shipments);
/* 1535 */       Iterator<IDataModel> it = this._shipments.iterator();
/* 1536 */       while (it.hasNext()) {
/* 1537 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1541 */     this._cartonsSavepoint = this._cartons;
/* 1542 */     if (this._cartons != null) {
/* 1543 */       this._cartonsSavepoint = new HistoricalList((List)this._cartons);
/* 1544 */       Iterator<IDataModel> it = this._cartons.iterator();
/* 1545 */       while (it.hasNext()) {
/* 1546 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1550 */     this._notesSavepoint = this._notes;
/* 1551 */     if (this._notes != null) {
/* 1552 */       this._notesSavepoint = new HistoricalList((List)this._notes);
/* 1553 */       Iterator<IDataModel> it = this._notes.iterator();
/* 1554 */       while (it.hasNext()) {
/* 1555 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1559 */     this._originatorAddressSavepoint = this._originatorAddress;
/* 1560 */     if (this._originatorAddress != null) {
/* 1561 */       this._originatorAddress.startTransaction();
/*      */     }
/*      */     
/* 1564 */     this._propertiesSavepoint = this._properties;
/* 1565 */     if (this._properties != null) {
/* 1566 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1567 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1568 */       while (it.hasNext()) {
/* 1569 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1574 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1579 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1582 */     super.rollbackChanges();
/*      */     
/* 1584 */     this._inventoryDocumentLineItems = this._inventoryDocumentLineItemsSavepoint;
/* 1585 */     this._inventoryDocumentLineItemsSavepoint = null;
/* 1586 */     if (this._inventoryDocumentLineItems != null) {
/* 1587 */       Iterator<IDataModel> it = this._inventoryDocumentLineItems.iterator();
/* 1588 */       while (it.hasNext()) {
/* 1589 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1593 */     this._shipments = this._shipmentsSavepoint;
/* 1594 */     this._shipmentsSavepoint = null;
/* 1595 */     if (this._shipments != null) {
/* 1596 */       Iterator<IDataModel> it = this._shipments.iterator();
/* 1597 */       while (it.hasNext()) {
/* 1598 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1602 */     this._cartons = this._cartonsSavepoint;
/* 1603 */     this._cartonsSavepoint = null;
/* 1604 */     if (this._cartons != null) {
/* 1605 */       Iterator<IDataModel> it = this._cartons.iterator();
/* 1606 */       while (it.hasNext()) {
/* 1607 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1611 */     this._notes = this._notesSavepoint;
/* 1612 */     this._notesSavepoint = null;
/* 1613 */     if (this._notes != null) {
/* 1614 */       Iterator<IDataModel> it = this._notes.iterator();
/* 1615 */       while (it.hasNext()) {
/* 1616 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1620 */     this._originatorAddress = this._originatorAddressSavepoint;
/* 1621 */     this._originatorAddressSavepoint = null;
/* 1622 */     if (this._originatorAddress != null) {
/* 1623 */       this._originatorAddress.rollbackChanges();
/*      */     }
/*      */     
/* 1626 */     this._properties = this._propertiesSavepoint;
/* 1627 */     this._propertiesSavepoint = null;
/* 1628 */     if (this._properties != null) {
/* 1629 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1630 */       while (it.hasNext()) {
/* 1631 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1639 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1642 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1645 */     super.commitTransaction();
/*      */     
/* 1647 */     this._inventoryDocumentLineItemsSavepoint = this._inventoryDocumentLineItems;
/* 1648 */     if (this._inventoryDocumentLineItems != null) {
/* 1649 */       Iterator<IDataModel> it = this._inventoryDocumentLineItems.iterator();
/* 1650 */       while (it.hasNext()) {
/* 1651 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1653 */       this._inventoryDocumentLineItems = new HistoricalList((List)this._inventoryDocumentLineItems);
/*      */     } 
/*      */     
/* 1656 */     this._shipmentsSavepoint = this._shipments;
/* 1657 */     if (this._shipments != null) {
/* 1658 */       Iterator<IDataModel> it = this._shipments.iterator();
/* 1659 */       while (it.hasNext()) {
/* 1660 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1662 */       this._shipments = new HistoricalList((List)this._shipments);
/*      */     } 
/*      */     
/* 1665 */     this._cartonsSavepoint = this._cartons;
/* 1666 */     if (this._cartons != null) {
/* 1667 */       Iterator<IDataModel> it = this._cartons.iterator();
/* 1668 */       while (it.hasNext()) {
/* 1669 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1671 */       this._cartons = new HistoricalList((List)this._cartons);
/*      */     } 
/*      */     
/* 1674 */     this._notesSavepoint = this._notes;
/* 1675 */     if (this._notes != null) {
/* 1676 */       Iterator<IDataModel> it = this._notes.iterator();
/* 1677 */       while (it.hasNext()) {
/* 1678 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1680 */       this._notes = new HistoricalList((List)this._notes);
/*      */     } 
/*      */     
/* 1683 */     this._originatorAddressSavepoint = this._originatorAddress;
/* 1684 */     if (this._originatorAddress != null) {
/* 1685 */       this._originatorAddress.commitTransaction();
/*      */     }
/*      */     
/* 1688 */     this._propertiesSavepoint = this._properties;
/* 1689 */     if (this._properties != null) {
/* 1690 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1691 */       while (it.hasNext()) {
/* 1692 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1694 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1698 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */