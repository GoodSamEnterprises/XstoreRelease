/*      */ package dtv.xst.dao.inv.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.inv.IDocumentInventoryLocationModifier;
/*      */ import dtv.xst.dao.inv.IDocumentLineItemNote;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentCrossReference;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineItemProperty;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineSerial;
/*      */ import dtv.xst.dao.inv.IInventoryItemAccountModifier;
/*      */ import dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItem;
/*      */ import dtv.xst.dao.inv.InventoryDocumentLineItemPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class InventoryDocumentLineItemModel extends InventoryDocumentLineItemBaseModel implements IInventoryDocumentLineItem {
/*      */   private static final long serialVersionUID = 652670142L;
/*      */   private IInventoryDocument _parentDocument;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IInventoryItemAccountModifier _customerItemAccountMod;
/*      */   private transient IInventoryItemAccountModifier _customerItemAccountModSavepoint;
/*      */   private HistoricalList<IInventoryDocumentLineSerial> _serialNumbers;
/*      */   private transient HistoricalList<IInventoryDocumentLineSerial> _serialNumbersSavepoint;
/*      */   
/*      */   public String toString() {
/*   39 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<IDocumentInventoryLocationModifier> _documentInventoryLocationModifiers; private transient HistoricalList<IDocumentInventoryLocationModifier> _documentInventoryLocationModifiersSavepoint; private IInventoryReplenishmentDocumentLineItem _inventoryReplenishmentDocumentLineItem; private transient IInventoryReplenishmentDocumentLineItem _inventoryReplenishmentDocumentLineItemSavepoint; private HistoricalList<IDocumentLineItemNote> _notes; private transient HistoricalList<IDocumentLineItemNote> _notesSavepoint; private IInventoryDocumentCrossReference _inventoryLineCrossReference; private transient IInventoryDocumentCrossReference _inventoryLineCrossReferenceSavepoint; private HistoricalList<IInventoryDocumentLineItemProperty> _properties; private transient HistoricalList<IInventoryDocumentLineItemProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   44 */     setDAO((IDataAccessObject)new InventoryDocumentLineItemDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InventoryDocumentLineItemDAO getDAO_() {
/*   52 */     return (InventoryDocumentLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentId() {
/*   60 */     return getDAO_().getDocumentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentId(String argDocumentId) {
/*   68 */     if (setDocumentId_noev(argDocumentId) && 
/*   69 */       this._events != null && 
/*   70 */       postEventsForChanges()) {
/*   71 */       this._events.post(IInventoryDocumentLineItem.SET_DOCUMENTID, argDocumentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentId_noev(String argDocumentId) {
/*   78 */     boolean ev_postable = false;
/*      */     
/*   80 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*   81 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*   82 */       getDAO_().setDocumentId(argDocumentId);
/*   83 */       ev_postable = true;
/*   84 */       if (this._serialNumbers != null) {
/*      */         
/*   86 */         Iterator<InventoryDocumentLineSerialModel> it = this._serialNumbers.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((InventoryDocumentLineSerialModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*   92 */       if (this._documentInventoryLocationModifiers != null) {
/*      */         
/*   94 */         Iterator<DocumentInventoryLocationModifierModel> it = this._documentInventoryLocationModifiers.iterator();
/*   95 */         while (it.hasNext())
/*      */         {
/*   97 */           ((DocumentInventoryLocationModifierModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  100 */       if (this._notes != null) {
/*      */         
/*  102 */         Iterator<DocumentLineItemNoteModel> it = this._notes.iterator();
/*  103 */         while (it.hasNext())
/*      */         {
/*  105 */           ((DocumentLineItemNoteModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  108 */       if (this._properties != null) {
/*      */         
/*  110 */         Iterator<InventoryDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  111 */         while (it.hasNext())
/*      */         {
/*  113 */           ((InventoryDocumentLineItemPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*  116 */       if (this._customerItemAccountMod != null)
/*      */       {
/*      */         
/*  119 */         ((InventoryItemAccountModifierModel)this._customerItemAccountMod).setDocumentId_noev(argDocumentId);
/*      */       }
/*  121 */       if (this._inventoryReplenishmentDocumentLineItem != null)
/*      */       {
/*      */         
/*  124 */         ((InventoryReplenishmentDocumentLineItemModel)this._inventoryReplenishmentDocumentLineItem).setDocumentId_noev(argDocumentId);
/*      */       }
/*  126 */       if (this._inventoryLineCrossReference != null)
/*      */       {
/*      */         
/*  129 */         ((InventoryDocumentCrossReferenceModel)this._inventoryLineCrossReference).setDocumentId_noev(argDocumentId);
/*      */       }
/*      */     } 
/*      */     
/*  133 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentTypeCode() {
/*  141 */     return getDAO_().getDocumentTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  149 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/*  150 */       this._events != null && 
/*  151 */       postEventsForChanges()) {
/*  152 */       this._events.post(IInventoryDocumentLineItem.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/*  159 */     boolean ev_postable = false;
/*      */     
/*  161 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/*  162 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/*  163 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/*  164 */       ev_postable = true;
/*  165 */       if (this._serialNumbers != null) {
/*      */         
/*  167 */         Iterator<InventoryDocumentLineSerialModel> it = this._serialNumbers.iterator();
/*  168 */         while (it.hasNext())
/*      */         {
/*  170 */           ((InventoryDocumentLineSerialModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  173 */       if (this._documentInventoryLocationModifiers != null) {
/*      */         
/*  175 */         Iterator<DocumentInventoryLocationModifierModel> it = this._documentInventoryLocationModifiers.iterator();
/*  176 */         while (it.hasNext())
/*      */         {
/*  178 */           ((DocumentInventoryLocationModifierModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  181 */       if (this._notes != null) {
/*      */         
/*  183 */         Iterator<DocumentLineItemNoteModel> it = this._notes.iterator();
/*  184 */         while (it.hasNext())
/*      */         {
/*  186 */           ((DocumentLineItemNoteModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  189 */       if (this._properties != null) {
/*      */         
/*  191 */         Iterator<InventoryDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  192 */         while (it.hasNext())
/*      */         {
/*  194 */           ((InventoryDocumentLineItemPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*  197 */       if (this._customerItemAccountMod != null)
/*      */       {
/*      */         
/*  200 */         ((InventoryItemAccountModifierModel)this._customerItemAccountMod).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */       }
/*  202 */       if (this._inventoryReplenishmentDocumentLineItem != null)
/*      */       {
/*      */         
/*  205 */         ((InventoryReplenishmentDocumentLineItemModel)this._inventoryReplenishmentDocumentLineItem).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */       }
/*  207 */       if (this._inventoryLineCrossReference != null)
/*      */       {
/*      */         
/*  210 */         ((InventoryDocumentCrossReferenceModel)this._inventoryLineCrossReference).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */       }
/*      */     } 
/*      */     
/*  214 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInventoryDocumentLineNumber() {
/*  222 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/*  223 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*      */     }
/*      */     
/*  226 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/*  235 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/*  236 */       this._events != null && 
/*  237 */       postEventsForChanges()) {
/*  238 */       this._events.post(IInventoryDocumentLineItem.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/*  245 */     boolean ev_postable = false;
/*      */     
/*  247 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/*  248 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/*  249 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/*  250 */       ev_postable = true;
/*  251 */       if (this._serialNumbers != null) {
/*      */         
/*  253 */         Iterator<InventoryDocumentLineSerialModel> it = this._serialNumbers.iterator();
/*  254 */         while (it.hasNext())
/*      */         {
/*  256 */           ((InventoryDocumentLineSerialModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */         }
/*      */       } 
/*  259 */       if (this._documentInventoryLocationModifiers != null) {
/*      */         
/*  261 */         Iterator<DocumentInventoryLocationModifierModel> it = this._documentInventoryLocationModifiers.iterator();
/*  262 */         while (it.hasNext())
/*      */         {
/*  264 */           ((DocumentInventoryLocationModifierModel)it.next()).setDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */         }
/*      */       } 
/*  267 */       if (this._notes != null) {
/*      */         
/*  269 */         Iterator<DocumentLineItemNoteModel> it = this._notes.iterator();
/*  270 */         while (it.hasNext())
/*      */         {
/*  272 */           ((DocumentLineItemNoteModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */         }
/*      */       } 
/*  275 */       if (this._properties != null) {
/*      */         
/*  277 */         Iterator<InventoryDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  278 */         while (it.hasNext())
/*      */         {
/*  280 */           ((InventoryDocumentLineItemPropertyModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */         }
/*      */       } 
/*  283 */       if (this._customerItemAccountMod != null)
/*      */       {
/*      */         
/*  286 */         ((InventoryItemAccountModifierModel)this._customerItemAccountMod).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */       }
/*  288 */       if (this._inventoryReplenishmentDocumentLineItem != null)
/*      */       {
/*      */         
/*  291 */         ((InventoryReplenishmentDocumentLineItemModel)this._inventoryReplenishmentDocumentLineItem).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */       }
/*  293 */       if (this._inventoryLineCrossReference != null)
/*      */       {
/*      */         
/*  296 */         ((InventoryDocumentCrossReferenceModel)this._inventoryLineCrossReference).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*      */       }
/*      */     } 
/*      */     
/*  300 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  308 */     if (getDAO_().getOrganizationId() != null) {
/*  309 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  312 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  321 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  322 */       this._events != null && 
/*  323 */       postEventsForChanges()) {
/*  324 */       this._events.post(IInventoryDocumentLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  331 */     boolean ev_postable = false;
/*      */     
/*  333 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  334 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  335 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  336 */       ev_postable = true;
/*  337 */       if (this._serialNumbers != null) {
/*      */         
/*  339 */         Iterator<InventoryDocumentLineSerialModel> it = this._serialNumbers.iterator();
/*  340 */         while (it.hasNext())
/*      */         {
/*  342 */           ((InventoryDocumentLineSerialModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  345 */       if (this._documentInventoryLocationModifiers != null) {
/*      */         
/*  347 */         Iterator<DocumentInventoryLocationModifierModel> it = this._documentInventoryLocationModifiers.iterator();
/*  348 */         while (it.hasNext())
/*      */         {
/*  350 */           ((DocumentInventoryLocationModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  353 */       if (this._notes != null) {
/*      */         
/*  355 */         Iterator<DocumentLineItemNoteModel> it = this._notes.iterator();
/*  356 */         while (it.hasNext())
/*      */         {
/*  358 */           ((DocumentLineItemNoteModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  361 */       if (this._properties != null) {
/*      */         
/*  363 */         Iterator<InventoryDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  364 */         while (it.hasNext())
/*      */         {
/*  366 */           ((InventoryDocumentLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  369 */       if (this._customerItemAccountMod != null)
/*      */       {
/*      */         
/*  372 */         ((InventoryItemAccountModifierModel)this._customerItemAccountMod).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  374 */       if (this._inventoryReplenishmentDocumentLineItem != null)
/*      */       {
/*      */         
/*  377 */         ((InventoryReplenishmentDocumentLineItemModel)this._inventoryReplenishmentDocumentLineItem).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  379 */       if (this._inventoryLineCrossReference != null)
/*      */       {
/*      */         
/*  382 */         ((InventoryDocumentCrossReferenceModel)this._inventoryLineCrossReference).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */     
/*  386 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  394 */     if (getDAO_().getRetailLocationId() != null) {
/*  395 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  398 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  407 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  408 */       this._events != null && 
/*  409 */       postEventsForChanges()) {
/*  410 */       this._events.post(IInventoryDocumentLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  417 */     boolean ev_postable = false;
/*      */     
/*  419 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  420 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  421 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  422 */       ev_postable = true;
/*  423 */       if (this._serialNumbers != null) {
/*      */         
/*  425 */         Iterator<InventoryDocumentLineSerialModel> it = this._serialNumbers.iterator();
/*  426 */         while (it.hasNext())
/*      */         {
/*  428 */           ((InventoryDocumentLineSerialModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  431 */       if (this._documentInventoryLocationModifiers != null) {
/*      */         
/*  433 */         Iterator<DocumentInventoryLocationModifierModel> it = this._documentInventoryLocationModifiers.iterator();
/*  434 */         while (it.hasNext())
/*      */         {
/*  436 */           ((DocumentInventoryLocationModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  439 */       if (this._notes != null) {
/*      */         
/*  441 */         Iterator<DocumentLineItemNoteModel> it = this._notes.iterator();
/*  442 */         while (it.hasNext())
/*      */         {
/*  444 */           ((DocumentLineItemNoteModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  447 */       if (this._properties != null) {
/*      */         
/*  449 */         Iterator<InventoryDocumentLineItemPropertyModel> it = this._properties.iterator();
/*  450 */         while (it.hasNext())
/*      */         {
/*  452 */           ((InventoryDocumentLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  455 */       if (this._customerItemAccountMod != null)
/*      */       {
/*      */         
/*  458 */         ((InventoryItemAccountModifierModel)this._customerItemAccountMod).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*  460 */       if (this._inventoryReplenishmentDocumentLineItem != null)
/*      */       {
/*      */         
/*  463 */         ((InventoryReplenishmentDocumentLineItemModel)this._inventoryReplenishmentDocumentLineItem).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*  465 */       if (this._inventoryLineCrossReference != null)
/*      */       {
/*      */         
/*  468 */         ((InventoryDocumentCrossReferenceModel)this._inventoryLineCrossReference).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */     
/*  472 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  480 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  488 */     if (setCreateDate_noev(argCreateDate) && 
/*  489 */       this._events != null && 
/*  490 */       postEventsForChanges()) {
/*  491 */       this._events.post(IInventoryDocumentLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  498 */     boolean ev_postable = false;
/*      */     
/*  500 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  501 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  502 */       getDAO_().setCreateDate(argCreateDate);
/*  503 */       ev_postable = true;
/*      */     } 
/*      */     
/*  506 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  514 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  522 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  523 */       this._events != null && 
/*  524 */       postEventsForChanges()) {
/*  525 */       this._events.post(IInventoryDocumentLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  532 */     boolean ev_postable = false;
/*      */     
/*  534 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  535 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  536 */       getDAO_().setCreateUserId(argCreateUserId);
/*  537 */       ev_postable = true;
/*      */     } 
/*      */     
/*  540 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  548 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  556 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  557 */       this._events != null && 
/*  558 */       postEventsForChanges()) {
/*  559 */       this._events.post(IInventoryDocumentLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  566 */     boolean ev_postable = false;
/*      */     
/*  568 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  569 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  570 */       getDAO_().setUpdateDate(argUpdateDate);
/*  571 */       ev_postable = true;
/*      */     } 
/*      */     
/*  574 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  582 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  590 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  591 */       this._events != null && 
/*  592 */       postEventsForChanges()) {
/*  593 */       this._events.post(IInventoryDocumentLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  600 */     boolean ev_postable = false;
/*      */     
/*  602 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  603 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  604 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  605 */       ev_postable = true;
/*      */     } 
/*      */     
/*  608 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInventoryItemId() {
/*  616 */     return getDAO_().getInventoryItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryItemId(String argInventoryItemId) {
/*  624 */     if (setInventoryItemId_noev(argInventoryItemId) && 
/*  625 */       this._events != null && 
/*  626 */       postEventsForChanges()) {
/*  627 */       this._events.post(IInventoryDocumentLineItem.SET_INVENTORYITEMID, argInventoryItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryItemId_noev(String argInventoryItemId) {
/*  634 */     boolean ev_postable = false;
/*      */     
/*  636 */     if ((getDAO_().getInventoryItemId() == null && argInventoryItemId != null) || (
/*  637 */       getDAO_().getInventoryItemId() != null && !getDAO_().getInventoryItemId().equals(argInventoryItemId))) {
/*  638 */       getDAO_().setInventoryItemId(argInventoryItemId);
/*  639 */       ev_postable = true;
/*      */     } 
/*      */     
/*  642 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getLineItemBusinessDate() {
/*  650 */     return getDAO_().getLineItemBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemBusinessDate(Date argLineItemBusinessDate) {
/*  658 */     if (setLineItemBusinessDate_noev(argLineItemBusinessDate) && 
/*  659 */       this._events != null && 
/*  660 */       postEventsForChanges()) {
/*  661 */       this._events.post(IInventoryDocumentLineItem.SET_LINEITEMBUSINESSDATE, argLineItemBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemBusinessDate_noev(Date argLineItemBusinessDate) {
/*  668 */     boolean ev_postable = false;
/*      */     
/*  670 */     if ((getDAO_().getLineItemBusinessDate() == null && argLineItemBusinessDate != null) || (
/*  671 */       getDAO_().getLineItemBusinessDate() != null && !getDAO_().getLineItemBusinessDate().equals(argLineItemBusinessDate))) {
/*  672 */       getDAO_().setLineItemBusinessDate(argLineItemBusinessDate);
/*  673 */       ev_postable = true;
/*      */     } 
/*      */     
/*  676 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLineItemRetailLocationId() {
/*  684 */     if (getDAO_().getLineItemRetailLocationId() != null) {
/*  685 */       return getDAO_().getLineItemRetailLocationId().longValue();
/*      */     }
/*      */     
/*  688 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemRetailLocationId(long argLineItemRetailLocationId) {
/*  697 */     if (setLineItemRetailLocationId_noev(argLineItemRetailLocationId) && 
/*  698 */       this._events != null && 
/*  699 */       postEventsForChanges()) {
/*  700 */       this._events.post(IInventoryDocumentLineItem.SET_LINEITEMRETAILLOCATIONID, Long.valueOf(argLineItemRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemRetailLocationId_noev(long argLineItemRetailLocationId) {
/*  707 */     boolean ev_postable = false;
/*      */     
/*  709 */     if ((getDAO_().getLineItemRetailLocationId() == null && Long.valueOf(argLineItemRetailLocationId) != null) || (
/*  710 */       getDAO_().getLineItemRetailLocationId() != null && !getDAO_().getLineItemRetailLocationId().equals(Long.valueOf(argLineItemRetailLocationId)))) {
/*  711 */       getDAO_().setLineItemRetailLocationId(Long.valueOf(argLineItemRetailLocationId));
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
/*      */   public int getLineItemRetailTransactionLineItemSequence() {
/*  723 */     if (getDAO_().getLineItemRetailTransactionLineItemSequence() != null) {
/*  724 */       return getDAO_().getLineItemRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  727 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemRetailTransactionLineItemSequence(int argLineItemRetailTransactionLineItemSequence) {
/*  736 */     if (setLineItemRetailTransactionLineItemSequence_noev(argLineItemRetailTransactionLineItemSequence) && 
/*  737 */       this._events != null && 
/*  738 */       postEventsForChanges()) {
/*  739 */       this._events.post(IInventoryDocumentLineItem.SET_LINEITEMRETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argLineItemRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemRetailTransactionLineItemSequence_noev(int argLineItemRetailTransactionLineItemSequence) {
/*  746 */     boolean ev_postable = false;
/*      */     
/*  748 */     if ((getDAO_().getLineItemRetailTransactionLineItemSequence() == null && Integer.valueOf(argLineItemRetailTransactionLineItemSequence) != null) || (
/*  749 */       getDAO_().getLineItemRetailTransactionLineItemSequence() != null && !getDAO_().getLineItemRetailTransactionLineItemSequence().equals(Integer.valueOf(argLineItemRetailTransactionLineItemSequence)))) {
/*  750 */       getDAO_().setLineItemRetailTransactionLineItemSequence(Integer.valueOf(argLineItemRetailTransactionLineItemSequence));
/*  751 */       ev_postable = true;
/*      */     } 
/*      */     
/*  754 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLineItemTransactionSequence() {
/*  762 */     if (getDAO_().getLineItemTransactionSequence() != null) {
/*  763 */       return getDAO_().getLineItemTransactionSequence().longValue();
/*      */     }
/*      */     
/*  766 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemTransactionSequence(long argLineItemTransactionSequence) {
/*  775 */     if (setLineItemTransactionSequence_noev(argLineItemTransactionSequence) && 
/*  776 */       this._events != null && 
/*  777 */       postEventsForChanges()) {
/*  778 */       this._events.post(IInventoryDocumentLineItem.SET_LINEITEMTRANSACTIONSEQUENCE, Long.valueOf(argLineItemTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemTransactionSequence_noev(long argLineItemTransactionSequence) {
/*  785 */     boolean ev_postable = false;
/*      */     
/*  787 */     if ((getDAO_().getLineItemTransactionSequence() == null && Long.valueOf(argLineItemTransactionSequence) != null) || (
/*  788 */       getDAO_().getLineItemTransactionSequence() != null && !getDAO_().getLineItemTransactionSequence().equals(Long.valueOf(argLineItemTransactionSequence)))) {
/*  789 */       getDAO_().setLineItemTransactionSequence(Long.valueOf(argLineItemTransactionSequence));
/*  790 */       ev_postable = true;
/*      */     } 
/*      */     
/*  793 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLineItemTypeCode() {
/*  801 */     return getDAO_().getLineItemTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemTypeCode(String argLineItemTypeCode) {
/*  809 */     if (setLineItemTypeCode_noev(argLineItemTypeCode) && 
/*  810 */       this._events != null && 
/*  811 */       postEventsForChanges()) {
/*  812 */       this._events.post(IInventoryDocumentLineItem.SET_LINEITEMTYPECODE, argLineItemTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemTypeCode_noev(String argLineItemTypeCode) {
/*  819 */     boolean ev_postable = false;
/*      */     
/*  821 */     if ((getDAO_().getLineItemTypeCode() == null && argLineItemTypeCode != null) || (
/*  822 */       getDAO_().getLineItemTypeCode() != null && !getDAO_().getLineItemTypeCode().equals(argLineItemTypeCode))) {
/*  823 */       getDAO_().setLineItemTypeCode(argLineItemTypeCode);
/*  824 */       ev_postable = true;
/*      */     } 
/*      */     
/*  827 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLineItemWorkstationId() {
/*  835 */     if (getDAO_().getLineItemWorkstationId() != null) {
/*  836 */       return getDAO_().getLineItemWorkstationId().longValue();
/*      */     }
/*      */     
/*  839 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemWorkstationId(long argLineItemWorkstationId) {
/*  848 */     if (setLineItemWorkstationId_noev(argLineItemWorkstationId) && 
/*  849 */       this._events != null && 
/*  850 */       postEventsForChanges()) {
/*  851 */       this._events.post(IInventoryDocumentLineItem.SET_LINEITEMWORKSTATIONID, Long.valueOf(argLineItemWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemWorkstationId_noev(long argLineItemWorkstationId) {
/*  858 */     boolean ev_postable = false;
/*      */     
/*  860 */     if ((getDAO_().getLineItemWorkstationId() == null && Long.valueOf(argLineItemWorkstationId) != null) || (
/*  861 */       getDAO_().getLineItemWorkstationId() != null && !getDAO_().getLineItemWorkstationId().equals(Long.valueOf(argLineItemWorkstationId)))) {
/*  862 */       getDAO_().setLineItemWorkstationId(Long.valueOf(argLineItemWorkstationId));
/*  863 */       ev_postable = true;
/*      */     } 
/*      */     
/*  866 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  874 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  882 */     if (setStatusCode_noev(argStatusCode) && 
/*  883 */       this._events != null && 
/*  884 */       postEventsForChanges()) {
/*  885 */       this._events.post(IInventoryDocumentLineItem.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  892 */     boolean ev_postable = false;
/*      */     
/*  894 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  895 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  896 */       getDAO_().setStatusCode(argStatusCode);
/*  897 */       ev_postable = true;
/*      */     } 
/*      */     
/*  900 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  908 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  916 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  917 */       this._events != null && 
/*  918 */       postEventsForChanges()) {
/*  919 */       this._events.post(IInventoryDocumentLineItem.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  926 */     boolean ev_postable = false;
/*      */     
/*  928 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  929 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  930 */       getDAO_().setSerialNumber(argSerialNumber);
/*  931 */       ev_postable = true;
/*      */     } 
/*      */     
/*  934 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnitCount() {
/*  942 */     return getDAO_().getUnitCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitCount(BigDecimal argUnitCount) {
/*  950 */     if (setUnitCount_noev(argUnitCount) && 
/*  951 */       this._events != null && 
/*  952 */       postEventsForChanges()) {
/*  953 */       this._events.post(IInventoryDocumentLineItem.SET_UNITCOUNT, argUnitCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitCount_noev(BigDecimal argUnitCount) {
/*  960 */     boolean ev_postable = false;
/*      */     
/*  962 */     if ((getDAO_().getUnitCount() == null && argUnitCount != null) || (
/*  963 */       getDAO_().getUnitCount() != null && !getDAO_().getUnitCount().equals(argUnitCount))) {
/*  964 */       getDAO_().setUnitCount(argUnitCount);
/*  965 */       ev_postable = true;
/*      */     } 
/*      */     
/*  968 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnitCost() {
/*  976 */     return getDAO_().getUnitCost();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitCost(BigDecimal argUnitCost) {
/*  984 */     if (setUnitCost_noev(argUnitCost) && 
/*  985 */       this._events != null && 
/*  986 */       postEventsForChanges()) {
/*  987 */       this._events.post(IInventoryDocumentLineItem.SET_UNITCOST, argUnitCost);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitCost_noev(BigDecimal argUnitCost) {
/*  994 */     boolean ev_postable = false;
/*      */     
/*  996 */     if ((getDAO_().getUnitCost() == null && argUnitCost != null) || (
/*  997 */       getDAO_().getUnitCost() != null && !getDAO_().getUnitCost().equals(argUnitCost))) {
/*  998 */       getDAO_().setUnitCost(argUnitCost);
/*  999 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1002 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExpectedCount() {
/* 1010 */     return getDAO_().getExpectedCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpectedCount(BigDecimal argExpectedCount) {
/* 1018 */     if (setExpectedCount_noev(argExpectedCount) && 
/* 1019 */       this._events != null && 
/* 1020 */       postEventsForChanges()) {
/* 1021 */       this._events.post(IInventoryDocumentLineItem.SET_EXPECTEDCOUNT, argExpectedCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpectedCount_noev(BigDecimal argExpectedCount) {
/* 1028 */     boolean ev_postable = false;
/*      */     
/* 1030 */     if ((getDAO_().getExpectedCount() == null && argExpectedCount != null) || (
/* 1031 */       getDAO_().getExpectedCount() != null && !getDAO_().getExpectedCount().equals(argExpectedCount))) {
/* 1032 */       getDAO_().setExpectedCount(argExpectedCount);
/* 1033 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1036 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPostedCount() {
/* 1044 */     return getDAO_().getPostedCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostedCount(BigDecimal argPostedCount) {
/* 1052 */     if (setPostedCount_noev(argPostedCount) && 
/* 1053 */       this._events != null && 
/* 1054 */       postEventsForChanges()) {
/* 1055 */       this._events.post(IInventoryDocumentLineItem.SET_POSTEDCOUNT, argPostedCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostedCount_noev(BigDecimal argPostedCount) {
/* 1062 */     boolean ev_postable = false;
/*      */     
/* 1064 */     if ((getDAO_().getPostedCount() == null && argPostedCount != null) || (
/* 1065 */       getDAO_().getPostedCount() != null && !getDAO_().getPostedCount().equals(argPostedCount))) {
/* 1066 */       getDAO_().setPostedCount(argPostedCount);
/* 1067 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1070 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPostedCost() {
/* 1078 */     return getDAO_().getPostedCost();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostedCost(BigDecimal argPostedCost) {
/* 1086 */     if (setPostedCost_noev(argPostedCost) && 
/* 1087 */       this._events != null && 
/* 1088 */       postEventsForChanges()) {
/* 1089 */       this._events.post(IInventoryDocumentLineItem.SET_POSTEDCOST, argPostedCost);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostedCost_noev(BigDecimal argPostedCost) {
/* 1096 */     boolean ev_postable = false;
/*      */     
/* 1098 */     if ((getDAO_().getPostedCost() == null && argPostedCost != null) || (
/* 1099 */       getDAO_().getPostedCost() != null && !getDAO_().getPostedCost().equals(argPostedCost))) {
/* 1100 */       getDAO_().setPostedCost(argPostedCost);
/* 1101 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1104 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRecordCreationType() {
/* 1112 */     return getDAO_().getRecordCreationType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRecordCreationType(String argRecordCreationType) {
/* 1120 */     if (setRecordCreationType_noev(argRecordCreationType) && 
/* 1121 */       this._events != null && 
/* 1122 */       postEventsForChanges()) {
/* 1123 */       this._events.post(IInventoryDocumentLineItem.SET_RECORDCREATIONTYPE, argRecordCreationType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRecordCreationType_noev(String argRecordCreationType) {
/* 1130 */     boolean ev_postable = false;
/*      */     
/* 1132 */     if ((getDAO_().getRecordCreationType() == null && argRecordCreationType != null) || (
/* 1133 */       getDAO_().getRecordCreationType() != null && !getDAO_().getRecordCreationType().equals(argRecordCreationType))) {
/* 1134 */       getDAO_().setRecordCreationType(argRecordCreationType);
/* 1135 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1138 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEnteredItemDescription() {
/* 1146 */     return getDAO_().getEnteredItemDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnteredItemDescription(String argEnteredItemDescription) {
/* 1154 */     if (setEnteredItemDescription_noev(argEnteredItemDescription) && 
/* 1155 */       this._events != null && 
/* 1156 */       postEventsForChanges()) {
/* 1157 */       this._events.post(IInventoryDocumentLineItem.SET_ENTEREDITEMDESCRIPTION, argEnteredItemDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEnteredItemDescription_noev(String argEnteredItemDescription) {
/* 1164 */     boolean ev_postable = false;
/*      */     
/* 1166 */     if ((getDAO_().getEnteredItemDescription() == null && argEnteredItemDescription != null) || (
/* 1167 */       getDAO_().getEnteredItemDescription() != null && !getDAO_().getEnteredItemDescription().equals(argEnteredItemDescription))) {
/* 1168 */       getDAO_().setEnteredItemDescription(argEnteredItemDescription);
/* 1169 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1172 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEnteredItemId() {
/* 1180 */     return getDAO_().getEnteredItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnteredItemId(String argEnteredItemId) {
/* 1188 */     if (setEnteredItemId_noev(argEnteredItemId) && 
/* 1189 */       this._events != null && 
/* 1190 */       postEventsForChanges()) {
/* 1191 */       this._events.post(IInventoryDocumentLineItem.SET_ENTEREDITEMID, argEnteredItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEnteredItemId_noev(String argEnteredItemId) {
/* 1198 */     boolean ev_postable = false;
/*      */     
/* 1200 */     if ((getDAO_().getEnteredItemId() == null && argEnteredItemId != null) || (
/* 1201 */       getDAO_().getEnteredItemId() != null && !getDAO_().getEnteredItemId().equals(argEnteredItemId))) {
/* 1202 */       getDAO_().setEnteredItemId(argEnteredItemId);
/* 1203 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1206 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCartonId() {
/* 1214 */     return getDAO_().getCartonId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCartonId(String argCartonId) {
/* 1222 */     if (setCartonId_noev(argCartonId) && 
/* 1223 */       this._events != null && 
/* 1224 */       postEventsForChanges()) {
/* 1225 */       this._events.post(IInventoryDocumentLineItem.SET_CARTONID, argCartonId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCartonId_noev(String argCartonId) {
/* 1232 */     boolean ev_postable = false;
/*      */     
/* 1234 */     if ((getDAO_().getCartonId() == null && argCartonId != null) || (
/* 1235 */       getDAO_().getCartonId() != null && !getDAO_().getCartonId().equals(argCartonId))) {
/* 1236 */       getDAO_().setCartonId(argCartonId);
/* 1237 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1240 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getRetail() {
/* 1248 */     return getDAO_().getRetail();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetail(BigDecimal argRetail) {
/* 1256 */     if (setRetail_noev(argRetail) && 
/* 1257 */       this._events != null && 
/* 1258 */       postEventsForChanges()) {
/* 1259 */       this._events.post(IInventoryDocumentLineItem.SET_RETAIL, argRetail);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetail_noev(BigDecimal argRetail) {
/* 1266 */     boolean ev_postable = false;
/*      */     
/* 1268 */     if ((getDAO_().getRetail() == null && argRetail != null) || (
/* 1269 */       getDAO_().getRetail() != null && !getDAO_().getRetail().equals(argRetail))) {
/* 1270 */       getDAO_().setRetail(argRetail);
/* 1271 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1274 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getModelNumber() {
/* 1282 */     return getDAO_().getModelNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setModelNumber(String argModelNumber) {
/* 1290 */     if (setModelNumber_noev(argModelNumber) && 
/* 1291 */       this._events != null && 
/* 1292 */       postEventsForChanges()) {
/* 1293 */       this._events.post(IInventoryDocumentLineItem.SET_MODELNUMBER, argModelNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setModelNumber_noev(String argModelNumber) {
/* 1300 */     boolean ev_postable = false;
/*      */     
/* 1302 */     if ((getDAO_().getModelNumber() == null && argModelNumber != null) || (
/* 1303 */       getDAO_().getModelNumber() != null && !getDAO_().getModelNumber().equals(argModelNumber))) {
/* 1304 */       getDAO_().setModelNumber(argModelNumber);
/* 1305 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1308 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginalBucketId() {
/* 1316 */     return getDAO_().getOriginalBucketId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalBucketId(String argOriginalBucketId) {
/* 1324 */     if (setOriginalBucketId_noev(argOriginalBucketId) && 
/* 1325 */       this._events != null && 
/* 1326 */       postEventsForChanges()) {
/* 1327 */       this._events.post(IInventoryDocumentLineItem.SET_ORIGINALBUCKETID, argOriginalBucketId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalBucketId_noev(String argOriginalBucketId) {
/* 1334 */     boolean ev_postable = false;
/*      */     
/* 1336 */     if ((getDAO_().getOriginalBucketId() == null && argOriginalBucketId != null) || (
/* 1337 */       getDAO_().getOriginalBucketId() != null && !getDAO_().getOriginalBucketId().equals(argOriginalBucketId))) {
/* 1338 */       getDAO_().setOriginalBucketId(argOriginalBucketId);
/* 1339 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1342 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginalLocationId() {
/* 1350 */     return getDAO_().getOriginalLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalLocationId(String argOriginalLocationId) {
/* 1358 */     if (setOriginalLocationId_noev(argOriginalLocationId) && 
/* 1359 */       this._events != null && 
/* 1360 */       postEventsForChanges()) {
/* 1361 */       this._events.post(IInventoryDocumentLineItem.SET_ORIGINALLOCATIONID, argOriginalLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalLocationId_noev(String argOriginalLocationId) {
/* 1368 */     boolean ev_postable = false;
/*      */     
/* 1370 */     if ((getDAO_().getOriginalLocationId() == null && argOriginalLocationId != null) || (
/* 1371 */       getDAO_().getOriginalLocationId() != null && !getDAO_().getOriginalLocationId().equals(argOriginalLocationId))) {
/* 1372 */       getDAO_().setOriginalLocationId(argOriginalLocationId);
/* 1373 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1376 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getControlNumber() {
/* 1384 */     return getDAO_().getControlNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setControlNumber(String argControlNumber) {
/* 1392 */     if (setControlNumber_noev(argControlNumber) && 
/* 1393 */       this._events != null && 
/* 1394 */       postEventsForChanges()) {
/* 1395 */       this._events.post(IInventoryDocumentLineItem.SET_CONTROLNUMBER, argControlNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setControlNumber_noev(String argControlNumber) {
/* 1402 */     boolean ev_postable = false;
/*      */     
/* 1404 */     if ((getDAO_().getControlNumber() == null && argControlNumber != null) || (
/* 1405 */       getDAO_().getControlNumber() != null && !getDAO_().getControlNumber().equals(argControlNumber))) {
/* 1406 */       getDAO_().setControlNumber(argControlNumber);
/* 1407 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1410 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getShippingWeight() {
/* 1418 */     return getDAO_().getShippingWeight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingWeight(BigDecimal argShippingWeight) {
/* 1426 */     if (setShippingWeight_noev(argShippingWeight) && 
/* 1427 */       this._events != null && 
/* 1428 */       postEventsForChanges()) {
/* 1429 */       this._events.post(IInventoryDocumentLineItem.SET_SHIPPINGWEIGHT, argShippingWeight);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingWeight_noev(BigDecimal argShippingWeight) {
/* 1436 */     boolean ev_postable = false;
/*      */     
/* 1438 */     if ((getDAO_().getShippingWeight() == null && argShippingWeight != null) || (
/* 1439 */       getDAO_().getShippingWeight() != null && !getDAO_().getShippingWeight().equals(argShippingWeight))) {
/* 1440 */       getDAO_().setShippingWeight(argShippingWeight);
/* 1441 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1444 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IInventoryDocumentLineItemProperty newProperty(String argPropertyName) {
/* 1448 */     InventoryDocumentLineItemPropertyId id = new InventoryDocumentLineItemPropertyId();
/*      */     
/* 1450 */     id.setDocumentId(getDocumentId());
/* 1451 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 1452 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/* 1453 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 1454 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1456 */     IInventoryDocumentLineItemProperty prop = (IInventoryDocumentLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryDocumentLineItemProperty.class);
/* 1457 */     return prop;
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "CustomerItemAccountMod")
/*      */   public IInventoryItemAccountModifier getCustomerItemAccountMod() {
/* 1484 */     return this._customerItemAccountMod;
/*      */   }
/*      */   
/*      */   public void setCustomerItemAccountMod(IInventoryItemAccountModifier argCustomerItemAccountMod) {
/* 1488 */     super.setCustomerItemAccountMod(argCustomerItemAccountMod);
/*      */ 
/*      */     
/* 1491 */     if (argCustomerItemAccountMod == null) {
/*      */       
/* 1493 */       if (this._customerItemAccountMod != null) {
/* 1494 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1496 */       if (this._customerItemAccountMod != null) {
/*      */         
/* 1498 */         if (postEventsForChanges()) {
/* 1499 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._customerItemAccountMod));
/*      */         }
/* 1501 */         addDeletedObject((IDataModel)this._customerItemAccountMod);
/*      */       } 
/*      */     } else {
/*      */       
/* 1505 */       argCustomerItemAccountMod.setOrganizationId(getOrganizationId());
/* 1506 */       argCustomerItemAccountMod.setDocumentId(getDocumentId());
/* 1507 */       argCustomerItemAccountMod.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1508 */       argCustomerItemAccountMod.setDocumentTypeCode(getDocumentTypeCode());
/* 1509 */       argCustomerItemAccountMod.setRetailLocationId(getRetailLocationId());
/*      */ 
/*      */       
/* 1512 */       argCustomerItemAccountMod.setParentLine(this);
/*      */ 
/*      */       
/* 1515 */       if (postEventsForChanges()) {
/* 1516 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountMod));
/*      */       }
/*      */     } 
/*      */     
/* 1520 */     this._customerItemAccountMod = argCustomerItemAccountMod;
/* 1521 */     if (postEventsForChanges()) {
/* 1522 */       this._events.post(IInventoryDocumentLineItem.SET_CUSTOMERITEMACCOUNTMOD, argCustomerItemAccountMod);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "SerialNumbers")
/*      */   public List<IInventoryDocumentLineSerial> getSerialNumbers() {
/* 1528 */     if (this._serialNumbers == null) {
/* 1529 */       this._serialNumbers = new HistoricalList(null);
/*      */     }
/* 1531 */     return (List<IInventoryDocumentLineSerial>)this._serialNumbers;
/*      */   }
/*      */   
/*      */   public void setSerialNumbers(List<IInventoryDocumentLineSerial> argSerialNumbers) {
/* 1535 */     if (this._serialNumbers == null) {
/* 1536 */       this._serialNumbers = new HistoricalList(argSerialNumbers);
/*      */     } else {
/* 1538 */       this._serialNumbers.setCurrentList(argSerialNumbers);
/*      */     } 
/*      */     
/* 1541 */     for (IInventoryDocumentLineSerial child : this._serialNumbers) {
/* 1542 */       child.setParentLineItem(this);
/*      */     }
/*      */ 
/*      */     
/* 1546 */     for (IInventoryDocumentLineSerial child : this._serialNumbers) {
/* 1547 */       InventoryDocumentLineSerialModel model = (InventoryDocumentLineSerialModel)child;
/* 1548 */       model.setOrganizationId_noev(getOrganizationId());
/* 1549 */       model.setDocumentId_noev(getDocumentId());
/* 1550 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 1551 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1552 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1553 */       if (child instanceof IDataModelImpl) {
/* 1554 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1555 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1556 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1557 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1560 */       if (postEventsForChanges()) {
/* 1561 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryDocumentLineSerial(IInventoryDocumentLineSerial argInventoryDocumentLineSerial) {
/* 1567 */     super.addInventoryDocumentLineSerial(argInventoryDocumentLineSerial);
/*      */ 
/*      */     
/* 1570 */     argInventoryDocumentLineSerial.setParentLineItem(this);
/* 1571 */     if (this._serialNumbers == null) {
/* 1572 */       this._serialNumbers = new HistoricalList(null);
/*      */     }
/* 1574 */     argInventoryDocumentLineSerial.setOrganizationId(getOrganizationId());
/* 1575 */     argInventoryDocumentLineSerial.setDocumentId(getDocumentId());
/* 1576 */     argInventoryDocumentLineSerial.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1577 */     argInventoryDocumentLineSerial.setDocumentTypeCode(getDocumentTypeCode());
/* 1578 */     argInventoryDocumentLineSerial.setRetailLocationId(getRetailLocationId());
/* 1579 */     if (argInventoryDocumentLineSerial instanceof IDataModelImpl) {
/* 1580 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentLineSerial).getDAO();
/* 1581 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1582 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1583 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1588 */     if (postEventsForChanges()) {
/* 1589 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineSerial));
/*      */     }
/*      */     
/* 1592 */     this._serialNumbers.add(argInventoryDocumentLineSerial);
/* 1593 */     if (postEventsForChanges()) {
/* 1594 */       this._events.post(IInventoryDocumentLineItem.ADD_SERIALNUMBERS, argInventoryDocumentLineSerial);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryDocumentLineSerial(IInventoryDocumentLineSerial argInventoryDocumentLineSerial) {
/* 1599 */     if (this._serialNumbers != null) {
/*      */       
/* 1601 */       if (postEventsForChanges()) {
/* 1602 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineSerial));
/*      */       }
/* 1604 */       this._serialNumbers.remove(argInventoryDocumentLineSerial);
/*      */       
/* 1606 */       argInventoryDocumentLineSerial.setParentLineItem(null);
/* 1607 */       if (postEventsForChanges()) {
/* 1608 */         this._events.post(IInventoryDocumentLineItem.REMOVE_SERIALNUMBERS, argInventoryDocumentLineSerial);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "DocumentInventoryLocationModifiers")
/*      */   public List<IDocumentInventoryLocationModifier> getDocumentInventoryLocationModifiers() {
/* 1615 */     if (this._documentInventoryLocationModifiers == null) {
/* 1616 */       this._documentInventoryLocationModifiers = new HistoricalList(null);
/*      */     }
/* 1618 */     return (List<IDocumentInventoryLocationModifier>)this._documentInventoryLocationModifiers;
/*      */   }
/*      */   
/*      */   public void setDocumentInventoryLocationModifiers(List<IDocumentInventoryLocationModifier> argDocumentInventoryLocationModifiers) {
/* 1622 */     if (this._documentInventoryLocationModifiers == null) {
/* 1623 */       this._documentInventoryLocationModifiers = new HistoricalList(argDocumentInventoryLocationModifiers);
/*      */     } else {
/* 1625 */       this._documentInventoryLocationModifiers.setCurrentList(argDocumentInventoryLocationModifiers);
/*      */     } 
/*      */     
/* 1628 */     for (IDocumentInventoryLocationModifier child : this._documentInventoryLocationModifiers) {
/* 1629 */       child.setParentLineItem(this);
/*      */     }
/*      */ 
/*      */     
/* 1633 */     for (IDocumentInventoryLocationModifier child : this._documentInventoryLocationModifiers) {
/* 1634 */       DocumentInventoryLocationModifierModel model = (DocumentInventoryLocationModifierModel)child;
/* 1635 */       model.setOrganizationId_noev(getOrganizationId());
/* 1636 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1637 */       model.setDocumentId_noev(getDocumentId());
/* 1638 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1639 */       model.setDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 1640 */       if (child instanceof IDataModelImpl) {
/* 1641 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1642 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1643 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1644 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1647 */       if (postEventsForChanges()) {
/* 1648 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDocumentInventoryLocationModifier(IDocumentInventoryLocationModifier argDocumentInventoryLocationModifier) {
/* 1654 */     super.addDocumentInventoryLocationModifier(argDocumentInventoryLocationModifier);
/*      */ 
/*      */     
/* 1657 */     argDocumentInventoryLocationModifier.setParentLineItem(this);
/* 1658 */     if (this._documentInventoryLocationModifiers == null) {
/* 1659 */       this._documentInventoryLocationModifiers = new HistoricalList(null);
/*      */     }
/* 1661 */     argDocumentInventoryLocationModifier.setOrganizationId(getOrganizationId());
/* 1662 */     argDocumentInventoryLocationModifier.setRetailLocationId(getRetailLocationId());
/* 1663 */     argDocumentInventoryLocationModifier.setDocumentId(getDocumentId());
/* 1664 */     argDocumentInventoryLocationModifier.setDocumentTypeCode(getDocumentTypeCode());
/* 1665 */     argDocumentInventoryLocationModifier.setDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1666 */     if (argDocumentInventoryLocationModifier instanceof IDataModelImpl) {
/* 1667 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentInventoryLocationModifier).getDAO();
/* 1668 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1669 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1670 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1675 */     if (postEventsForChanges()) {
/* 1676 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentInventoryLocationModifier));
/*      */     }
/*      */     
/* 1679 */     this._documentInventoryLocationModifiers.add(argDocumentInventoryLocationModifier);
/* 1680 */     if (postEventsForChanges()) {
/* 1681 */       this._events.post(IInventoryDocumentLineItem.ADD_DOCUMENTINVENTORYLOCATIONMODIFIERS, argDocumentInventoryLocationModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDocumentInventoryLocationModifier(IDocumentInventoryLocationModifier argDocumentInventoryLocationModifier) {
/* 1686 */     if (this._documentInventoryLocationModifiers != null) {
/*      */       
/* 1688 */       if (postEventsForChanges()) {
/* 1689 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentInventoryLocationModifier));
/*      */       }
/* 1691 */       this._documentInventoryLocationModifiers.remove(argDocumentInventoryLocationModifier);
/*      */       
/* 1693 */       argDocumentInventoryLocationModifier.setParentLineItem(null);
/* 1694 */       if (postEventsForChanges()) {
/* 1695 */         this._events.post(IInventoryDocumentLineItem.REMOVE_DOCUMENTINVENTORYLOCATIONMODIFIERS, argDocumentInventoryLocationModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "InventoryReplenishmentDocumentLineItem")
/*      */   public IInventoryReplenishmentDocumentLineItem getInventoryReplenishmentDocumentLineItem() {
/* 1702 */     return this._inventoryReplenishmentDocumentLineItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInventoryReplenishmentDocumentLineItem(IInventoryReplenishmentDocumentLineItem argInventoryReplenishmentDocumentLineItem) {
/* 1707 */     if (argInventoryReplenishmentDocumentLineItem == null) {
/*      */       
/* 1709 */       if (this._inventoryReplenishmentDocumentLineItem != null) {
/* 1710 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1712 */       if (this._inventoryReplenishmentDocumentLineItem != null) {
/*      */         
/* 1714 */         if (postEventsForChanges()) {
/* 1715 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryReplenishmentDocumentLineItem));
/*      */         }
/* 1717 */         addDeletedObject((IDataModel)this._inventoryReplenishmentDocumentLineItem);
/*      */       } 
/*      */     } else {
/*      */       
/* 1721 */       argInventoryReplenishmentDocumentLineItem.setDocumentId(getDocumentId());
/* 1722 */       argInventoryReplenishmentDocumentLineItem.setDocumentTypeCode(getDocumentTypeCode());
/* 1723 */       argInventoryReplenishmentDocumentLineItem.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1724 */       argInventoryReplenishmentDocumentLineItem.setOrganizationId(getOrganizationId());
/* 1725 */       argInventoryReplenishmentDocumentLineItem.setRetailLocationId(getRetailLocationId());
/*      */ 
/*      */       
/* 1728 */       argInventoryReplenishmentDocumentLineItem.setParentLine(this);
/*      */ 
/*      */       
/* 1731 */       if (postEventsForChanges()) {
/* 1732 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryReplenishmentDocumentLineItem));
/*      */       }
/*      */     } 
/*      */     
/* 1736 */     this._inventoryReplenishmentDocumentLineItem = argInventoryReplenishmentDocumentLineItem;
/* 1737 */     if (postEventsForChanges()) {
/* 1738 */       this._events.post(IInventoryDocumentLineItem.SET_INVENTORYREPLENISHMENTDOCUMENTLINEITEM, argInventoryReplenishmentDocumentLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Notes")
/*      */   public List<IDocumentLineItemNote> getNotes() {
/* 1744 */     if (this._notes == null) {
/* 1745 */       this._notes = new HistoricalList(null);
/*      */     }
/* 1747 */     return (List<IDocumentLineItemNote>)this._notes;
/*      */   }
/*      */   
/*      */   public void setNotes(List<IDocumentLineItemNote> argNotes) {
/* 1751 */     if (this._notes == null) {
/* 1752 */       this._notes = new HistoricalList(argNotes);
/*      */     } else {
/* 1754 */       this._notes.setCurrentList(argNotes);
/*      */     } 
/*      */     
/* 1757 */     for (IDocumentLineItemNote child : this._notes) {
/* 1758 */       child.setParentDocument(this);
/*      */     }
/*      */ 
/*      */     
/* 1762 */     for (IDocumentLineItemNote child : this._notes) {
/* 1763 */       DocumentLineItemNoteModel model = (DocumentLineItemNoteModel)child;
/* 1764 */       model.setOrganizationId_noev(getOrganizationId());
/* 1765 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1766 */       model.setDocumentId_noev(getDocumentId());
/* 1767 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1768 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 1769 */       if (child instanceof IDataModelImpl) {
/* 1770 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1771 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1772 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1773 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1776 */       if (postEventsForChanges()) {
/* 1777 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDocumentLineItemNote(IDocumentLineItemNote argDocumentLineItemNote) {
/* 1783 */     super.addDocumentLineItemNote(argDocumentLineItemNote);
/*      */ 
/*      */     
/* 1786 */     argDocumentLineItemNote.setParentDocument(this);
/* 1787 */     if (this._notes == null) {
/* 1788 */       this._notes = new HistoricalList(null);
/*      */     }
/* 1790 */     argDocumentLineItemNote.setOrganizationId(getOrganizationId());
/* 1791 */     argDocumentLineItemNote.setRetailLocationId(getRetailLocationId());
/* 1792 */     argDocumentLineItemNote.setDocumentId(getDocumentId());
/* 1793 */     argDocumentLineItemNote.setDocumentTypeCode(getDocumentTypeCode());
/* 1794 */     argDocumentLineItemNote.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1795 */     if (argDocumentLineItemNote instanceof IDataModelImpl) {
/* 1796 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentLineItemNote).getDAO();
/* 1797 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1798 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1799 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1804 */     if (postEventsForChanges()) {
/* 1805 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentLineItemNote));
/*      */     }
/*      */     
/* 1808 */     this._notes.add(argDocumentLineItemNote);
/* 1809 */     if (postEventsForChanges()) {
/* 1810 */       this._events.post(IInventoryDocumentLineItem.ADD_NOTES, argDocumentLineItemNote);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDocumentLineItemNote(IDocumentLineItemNote argDocumentLineItemNote) {
/* 1815 */     if (this._notes != null) {
/*      */       
/* 1817 */       if (postEventsForChanges()) {
/* 1818 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentLineItemNote));
/*      */       }
/* 1820 */       this._notes.remove(argDocumentLineItemNote);
/*      */       
/* 1822 */       argDocumentLineItemNote.setParentDocument(null);
/* 1823 */       if (postEventsForChanges()) {
/* 1824 */         this._events.post(IInventoryDocumentLineItem.REMOVE_NOTES, argDocumentLineItemNote);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "InventoryLineCrossReference")
/*      */   public IInventoryDocumentCrossReference getInventoryLineCrossReference() {
/* 1831 */     return this._inventoryLineCrossReference;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInventoryLineCrossReference(IInventoryDocumentCrossReference argInventoryLineCrossReference) {
/* 1836 */     if (argInventoryLineCrossReference == null) {
/*      */       
/* 1838 */       if (this._inventoryLineCrossReference != null) {
/* 1839 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1841 */       if (this._inventoryLineCrossReference != null) {
/*      */         
/* 1843 */         if (postEventsForChanges()) {
/* 1844 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryLineCrossReference));
/*      */         }
/* 1846 */         addDeletedObject((IDataModel)this._inventoryLineCrossReference);
/*      */       } 
/*      */     } else {
/*      */       
/* 1850 */       argInventoryLineCrossReference.setOrganizationId(getOrganizationId());
/* 1851 */       argInventoryLineCrossReference.setDocumentId(getDocumentId());
/* 1852 */       argInventoryLineCrossReference.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1853 */       argInventoryLineCrossReference.setDocumentTypeCode(getDocumentTypeCode());
/* 1854 */       argInventoryLineCrossReference.setRetailLocationId(getRetailLocationId());
/*      */ 
/*      */       
/* 1857 */       argInventoryLineCrossReference.setParentLine(this);
/*      */ 
/*      */       
/* 1860 */       if (postEventsForChanges()) {
/* 1861 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLineCrossReference));
/*      */       }
/*      */     } 
/*      */     
/* 1865 */     this._inventoryLineCrossReference = argInventoryLineCrossReference;
/* 1866 */     if (postEventsForChanges()) {
/* 1867 */       this._events.post(IInventoryDocumentLineItem.SET_INVENTORYLINECROSSREFERENCE, argInventoryLineCrossReference);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IInventoryDocumentLineItemProperty> getProperties() {
/* 1873 */     if (this._properties == null) {
/* 1874 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1876 */     return (List<IInventoryDocumentLineItemProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IInventoryDocumentLineItemProperty> argProperties) {
/* 1880 */     if (this._properties == null) {
/* 1881 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1883 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1886 */     for (IInventoryDocumentLineItemProperty child : this._properties) {
/* 1887 */       InventoryDocumentLineItemPropertyModel model = (InventoryDocumentLineItemPropertyModel)child;
/* 1888 */       model.setDocumentId_noev(getDocumentId());
/* 1889 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 1890 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 1891 */       model.setOrganizationId_noev(getOrganizationId());
/* 1892 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1893 */       if (child instanceof IDataModelImpl) {
/* 1894 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1895 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1896 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1897 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1900 */       if (postEventsForChanges()) {
/* 1901 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryDocumentLineItemProperty(IInventoryDocumentLineItemProperty argInventoryDocumentLineItemProperty) {
/* 1907 */     if (this._properties == null) {
/* 1908 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1910 */     argInventoryDocumentLineItemProperty.setDocumentId(getDocumentId());
/* 1911 */     argInventoryDocumentLineItemProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 1912 */     argInventoryDocumentLineItemProperty.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 1913 */     argInventoryDocumentLineItemProperty.setOrganizationId(getOrganizationId());
/* 1914 */     argInventoryDocumentLineItemProperty.setRetailLocationId(getRetailLocationId());
/* 1915 */     if (argInventoryDocumentLineItemProperty instanceof IDataModelImpl) {
/* 1916 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentLineItemProperty).getDAO();
/* 1917 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1918 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1919 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1924 */     if (postEventsForChanges()) {
/* 1925 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItemProperty));
/*      */     }
/*      */     
/* 1928 */     this._properties.add(argInventoryDocumentLineItemProperty);
/* 1929 */     if (postEventsForChanges()) {
/* 1930 */       this._events.post(IInventoryDocumentLineItem.ADD_PROPERTIES, argInventoryDocumentLineItemProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryDocumentLineItemProperty(IInventoryDocumentLineItemProperty argInventoryDocumentLineItemProperty) {
/* 1935 */     if (this._properties != null) {
/*      */       
/* 1937 */       if (postEventsForChanges()) {
/* 1938 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItemProperty));
/*      */       }
/* 1940 */       this._properties.remove(argInventoryDocumentLineItemProperty);
/* 1941 */       if (postEventsForChanges()) {
/* 1942 */         this._events.post(IInventoryDocumentLineItem.REMOVE_PROPERTIES, argInventoryDocumentLineItemProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentDocument(IInventoryDocument argParentDocument) {
/* 1948 */     this._parentDocument = argParentDocument;
/*      */   }
/*      */   
/*      */   public IInventoryDocument getParentDocument() {
/* 1952 */     return this._parentDocument;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1957 */     if ("CustomerItemAccountMod".equals(argFieldId)) {
/* 1958 */       return getCustomerItemAccountMod();
/*      */     }
/* 1960 */     if ("SerialNumbers".equals(argFieldId)) {
/* 1961 */       return getSerialNumbers();
/*      */     }
/* 1963 */     if ("DocumentInventoryLocationModifiers".equals(argFieldId)) {
/* 1964 */       return getDocumentInventoryLocationModifiers();
/*      */     }
/* 1966 */     if ("InventoryReplenishmentDocumentLineItem".equals(argFieldId)) {
/* 1967 */       return getInventoryReplenishmentDocumentLineItem();
/*      */     }
/* 1969 */     if ("Notes".equals(argFieldId)) {
/* 1970 */       return getNotes();
/*      */     }
/* 1972 */     if ("InventoryLineCrossReference".equals(argFieldId)) {
/* 1973 */       return getInventoryLineCrossReference();
/*      */     }
/* 1975 */     if ("Properties".equals(argFieldId)) {
/* 1976 */       return getProperties();
/*      */     }
/* 1978 */     if ("InventoryDocumentLineItemExtension".equals(argFieldId)) {
/* 1979 */       return this._myExtension;
/*      */     }
/*      */     
/* 1982 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1988 */     if ("CustomerItemAccountMod".equals(argFieldId)) {
/* 1989 */       setCustomerItemAccountMod((IInventoryItemAccountModifier)argValue);
/*      */     }
/* 1991 */     else if ("SerialNumbers".equals(argFieldId)) {
/* 1992 */       setSerialNumbers(changeToList(argValue, IInventoryDocumentLineSerial.class));
/*      */     }
/* 1994 */     else if ("DocumentInventoryLocationModifiers".equals(argFieldId)) {
/* 1995 */       setDocumentInventoryLocationModifiers(changeToList(argValue, IDocumentInventoryLocationModifier.class));
/*      */     }
/* 1997 */     else if ("InventoryReplenishmentDocumentLineItem".equals(argFieldId)) {
/* 1998 */       setInventoryReplenishmentDocumentLineItem((IInventoryReplenishmentDocumentLineItem)argValue);
/*      */     }
/* 2000 */     else if ("Notes".equals(argFieldId)) {
/* 2001 */       setNotes(changeToList(argValue, IDocumentLineItemNote.class));
/*      */     }
/* 2003 */     else if ("InventoryLineCrossReference".equals(argFieldId)) {
/* 2004 */       setInventoryLineCrossReference((IInventoryDocumentCrossReference)argValue);
/*      */     }
/* 2006 */     else if ("Properties".equals(argFieldId)) {
/* 2007 */       setProperties(changeToList(argValue, IInventoryDocumentLineItemProperty.class));
/*      */     }
/* 2009 */     else if ("InventoryDocumentLineItemExtension".equals(argFieldId)) {
/* 2010 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 2013 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 2019 */     this._persistenceDefaults = argPD;
/* 2020 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 2021 */     this._eventManager = argEM;
/* 2022 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 2023 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 2024 */     if (this._customerItemAccountMod != null) {
/* 2025 */       ((IDataModelImpl)this._customerItemAccountMod).setDependencies(argPD, argEM);
/*      */     }
/* 2027 */     if (this._serialNumbers != null) {
/* 2028 */       for (IInventoryDocumentLineSerial relationship : this._serialNumbers) {
/* 2029 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2032 */     if (this._documentInventoryLocationModifiers != null) {
/* 2033 */       for (IDocumentInventoryLocationModifier relationship : this._documentInventoryLocationModifiers) {
/* 2034 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2037 */     if (this._inventoryReplenishmentDocumentLineItem != null) {
/* 2038 */       ((IDataModelImpl)this._inventoryReplenishmentDocumentLineItem).setDependencies(argPD, argEM);
/*      */     }
/* 2040 */     if (this._notes != null) {
/* 2041 */       for (IDocumentLineItemNote relationship : this._notes) {
/* 2042 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2045 */     if (this._inventoryLineCrossReference != null) {
/* 2046 */       ((IDataModelImpl)this._inventoryLineCrossReference).setDependencies(argPD, argEM);
/*      */     }
/* 2048 */     if (this._properties != null) {
/* 2049 */       for (IInventoryDocumentLineItemProperty relationship : this._properties) {
/* 2050 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getInventoryDocumentLineItemExt() {
/* 2056 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setInventoryDocumentLineItemExt(IDataModel argExt) {
/* 2060 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 2065 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 2069 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 2072 */     super.startTransaction();
/*      */     
/* 2074 */     this._customerItemAccountModSavepoint = this._customerItemAccountMod;
/* 2075 */     if (this._customerItemAccountMod != null) {
/* 2076 */       this._customerItemAccountMod.startTransaction();
/*      */     }
/*      */     
/* 2079 */     this._serialNumbersSavepoint = this._serialNumbers;
/* 2080 */     if (this._serialNumbers != null) {
/* 2081 */       this._serialNumbersSavepoint = new HistoricalList((List)this._serialNumbers);
/* 2082 */       Iterator<IDataModel> it = this._serialNumbers.iterator();
/* 2083 */       while (it.hasNext()) {
/* 2084 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2088 */     this._documentInventoryLocationModifiersSavepoint = this._documentInventoryLocationModifiers;
/* 2089 */     if (this._documentInventoryLocationModifiers != null) {
/* 2090 */       this._documentInventoryLocationModifiersSavepoint = new HistoricalList((List)this._documentInventoryLocationModifiers);
/* 2091 */       Iterator<IDataModel> it = this._documentInventoryLocationModifiers.iterator();
/* 2092 */       while (it.hasNext()) {
/* 2093 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2097 */     this._inventoryReplenishmentDocumentLineItemSavepoint = this._inventoryReplenishmentDocumentLineItem;
/* 2098 */     if (this._inventoryReplenishmentDocumentLineItem != null) {
/* 2099 */       this._inventoryReplenishmentDocumentLineItem.startTransaction();
/*      */     }
/*      */     
/* 2102 */     this._notesSavepoint = this._notes;
/* 2103 */     if (this._notes != null) {
/* 2104 */       this._notesSavepoint = new HistoricalList((List)this._notes);
/* 2105 */       Iterator<IDataModel> it = this._notes.iterator();
/* 2106 */       while (it.hasNext()) {
/* 2107 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2111 */     this._inventoryLineCrossReferenceSavepoint = this._inventoryLineCrossReference;
/* 2112 */     if (this._inventoryLineCrossReference != null) {
/* 2113 */       this._inventoryLineCrossReference.startTransaction();
/*      */     }
/*      */     
/* 2116 */     this._propertiesSavepoint = this._properties;
/* 2117 */     if (this._properties != null) {
/* 2118 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 2119 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2120 */       while (it.hasNext()) {
/* 2121 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2126 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 2131 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 2134 */     super.rollbackChanges();
/*      */     
/* 2136 */     this._customerItemAccountMod = this._customerItemAccountModSavepoint;
/* 2137 */     this._customerItemAccountModSavepoint = null;
/* 2138 */     if (this._customerItemAccountMod != null) {
/* 2139 */       this._customerItemAccountMod.rollbackChanges();
/*      */     }
/*      */     
/* 2142 */     this._serialNumbers = this._serialNumbersSavepoint;
/* 2143 */     this._serialNumbersSavepoint = null;
/* 2144 */     if (this._serialNumbers != null) {
/* 2145 */       Iterator<IDataModel> it = this._serialNumbers.iterator();
/* 2146 */       while (it.hasNext()) {
/* 2147 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2151 */     this._documentInventoryLocationModifiers = this._documentInventoryLocationModifiersSavepoint;
/* 2152 */     this._documentInventoryLocationModifiersSavepoint = null;
/* 2153 */     if (this._documentInventoryLocationModifiers != null) {
/* 2154 */       Iterator<IDataModel> it = this._documentInventoryLocationModifiers.iterator();
/* 2155 */       while (it.hasNext()) {
/* 2156 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2160 */     this._inventoryReplenishmentDocumentLineItem = this._inventoryReplenishmentDocumentLineItemSavepoint;
/* 2161 */     this._inventoryReplenishmentDocumentLineItemSavepoint = null;
/* 2162 */     if (this._inventoryReplenishmentDocumentLineItem != null) {
/* 2163 */       this._inventoryReplenishmentDocumentLineItem.rollbackChanges();
/*      */     }
/*      */     
/* 2166 */     this._notes = this._notesSavepoint;
/* 2167 */     this._notesSavepoint = null;
/* 2168 */     if (this._notes != null) {
/* 2169 */       Iterator<IDataModel> it = this._notes.iterator();
/* 2170 */       while (it.hasNext()) {
/* 2171 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2175 */     this._inventoryLineCrossReference = this._inventoryLineCrossReferenceSavepoint;
/* 2176 */     this._inventoryLineCrossReferenceSavepoint = null;
/* 2177 */     if (this._inventoryLineCrossReference != null) {
/* 2178 */       this._inventoryLineCrossReference.rollbackChanges();
/*      */     }
/*      */     
/* 2181 */     this._properties = this._propertiesSavepoint;
/* 2182 */     this._propertiesSavepoint = null;
/* 2183 */     if (this._properties != null) {
/* 2184 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2185 */       while (it.hasNext()) {
/* 2186 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 2194 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 2197 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 2200 */     super.commitTransaction();
/*      */     
/* 2202 */     this._customerItemAccountModSavepoint = this._customerItemAccountMod;
/* 2203 */     if (this._customerItemAccountMod != null) {
/* 2204 */       this._customerItemAccountMod.commitTransaction();
/*      */     }
/*      */     
/* 2207 */     this._serialNumbersSavepoint = this._serialNumbers;
/* 2208 */     if (this._serialNumbers != null) {
/* 2209 */       Iterator<IDataModel> it = this._serialNumbers.iterator();
/* 2210 */       while (it.hasNext()) {
/* 2211 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2213 */       this._serialNumbers = new HistoricalList((List)this._serialNumbers);
/*      */     } 
/*      */     
/* 2216 */     this._documentInventoryLocationModifiersSavepoint = this._documentInventoryLocationModifiers;
/* 2217 */     if (this._documentInventoryLocationModifiers != null) {
/* 2218 */       Iterator<IDataModel> it = this._documentInventoryLocationModifiers.iterator();
/* 2219 */       while (it.hasNext()) {
/* 2220 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2222 */       this._documentInventoryLocationModifiers = new HistoricalList((List)this._documentInventoryLocationModifiers);
/*      */     } 
/*      */     
/* 2225 */     this._inventoryReplenishmentDocumentLineItemSavepoint = this._inventoryReplenishmentDocumentLineItem;
/* 2226 */     if (this._inventoryReplenishmentDocumentLineItem != null) {
/* 2227 */       this._inventoryReplenishmentDocumentLineItem.commitTransaction();
/*      */     }
/*      */     
/* 2230 */     this._notesSavepoint = this._notes;
/* 2231 */     if (this._notes != null) {
/* 2232 */       Iterator<IDataModel> it = this._notes.iterator();
/* 2233 */       while (it.hasNext()) {
/* 2234 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2236 */       this._notes = new HistoricalList((List)this._notes);
/*      */     } 
/*      */     
/* 2239 */     this._inventoryLineCrossReferenceSavepoint = this._inventoryLineCrossReference;
/* 2240 */     if (this._inventoryLineCrossReference != null) {
/* 2241 */       this._inventoryLineCrossReference.commitTransaction();
/*      */     }
/*      */     
/* 2244 */     this._propertiesSavepoint = this._properties;
/* 2245 */     if (this._properties != null) {
/* 2246 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2247 */       while (it.hasNext()) {
/* 2248 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2250 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 2254 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */