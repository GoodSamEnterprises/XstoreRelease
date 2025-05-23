/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentCrossReference;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentCrossReferenceProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import dtv.xst.dao.inv.InventoryDocumentCrossReferencePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryDocumentCrossReferenceModel extends AbstractDataModelWithPropertyImpl<IInventoryDocumentCrossReferenceProperty> implements IInventoryDocumentCrossReference {
/*     */   private static final long serialVersionUID = -683921086L;
/*     */   private IInventoryDocumentLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryDocumentCrossReferenceProperty> _properties; private transient HistoricalList<IInventoryDocumentCrossReferenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InventoryDocumentCrossReferenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryDocumentCrossReferenceDAO getDAO_() {
/*  48 */     return (InventoryDocumentCrossReferenceDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(IInventoryDocumentCrossReference.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<InventoryDocumentCrossReferencePropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((InventoryDocumentCrossReferencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/* 103 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 111 */     if (setDocumentId_noev(argDocumentId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IInventoryDocumentCrossReference.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 124 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 125 */       getDAO_().setDocumentId(argDocumentId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<InventoryDocumentCrossReferencePropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((InventoryDocumentCrossReferencePropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryDocumentLineNumber() {
/* 145 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/* 146 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*     */     }
/*     */     
/* 149 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/* 158 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IInventoryDocumentCrossReference.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/* 171 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/* 172 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<InventoryDocumentCrossReferencePropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((InventoryDocumentCrossReferencePropertyModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 192 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 200 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IInventoryDocumentCrossReference.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 213 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 214 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<InventoryDocumentCrossReferencePropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((InventoryDocumentCrossReferencePropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 234 */     if (getDAO_().getRetailLocationId() != null) {
/* 235 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 238 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 247 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IInventoryDocumentCrossReference.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 260 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 261 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 262 */       ev_postable = true;
/* 263 */       if (this._properties != null) {
/*     */         
/* 265 */         Iterator<InventoryDocumentCrossReferencePropertyModel> it = this._properties.iterator();
/* 266 */         while (it.hasNext())
/*     */         {
/* 268 */           ((InventoryDocumentCrossReferencePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 281 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 289 */     if (setCreateDate_noev(argCreateDate) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IInventoryDocumentCrossReference.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 302 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 303 */       getDAO_().setCreateDate(argCreateDate);
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 315 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 323 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(IInventoryDocumentCrossReference.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 336 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 337 */       getDAO_().setCreateUserId(argCreateUserId);
/* 338 */       ev_postable = true;
/*     */     } 
/*     */     
/* 341 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 349 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 357 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IInventoryDocumentCrossReference.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 370 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 371 */       getDAO_().setUpdateDate(argUpdateDate);
/* 372 */       ev_postable = true;
/*     */     } 
/*     */     
/* 375 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 383 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 391 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 392 */       this._events != null && 
/* 393 */       postEventsForChanges()) {
/* 394 */       this._events.post(IInventoryDocumentCrossReference.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 401 */     boolean ev_postable = false;
/*     */     
/* 403 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 404 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 405 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 406 */       ev_postable = true;
/*     */     } 
/*     */     
/* 409 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCrossRefOrganizationId() {
/* 417 */     if (getDAO_().getCrossRefOrganizationId() != null) {
/* 418 */       return getDAO_().getCrossRefOrganizationId().longValue();
/*     */     }
/*     */     
/* 421 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossRefOrganizationId(long argCrossRefOrganizationId) {
/* 430 */     if (setCrossRefOrganizationId_noev(argCrossRefOrganizationId) && 
/* 431 */       this._events != null && 
/* 432 */       postEventsForChanges()) {
/* 433 */       this._events.post(IInventoryDocumentCrossReference.SET_CROSSREFORGANIZATIONID, Long.valueOf(argCrossRefOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCrossRefOrganizationId_noev(long argCrossRefOrganizationId) {
/* 440 */     boolean ev_postable = false;
/*     */     
/* 442 */     if ((getDAO_().getCrossRefOrganizationId() == null && Long.valueOf(argCrossRefOrganizationId) != null) || (
/* 443 */       getDAO_().getCrossRefOrganizationId() != null && !getDAO_().getCrossRefOrganizationId().equals(Long.valueOf(argCrossRefOrganizationId)))) {
/* 444 */       getDAO_().setCrossRefOrganizationId(Long.valueOf(argCrossRefOrganizationId));
/* 445 */       ev_postable = true;
/*     */     } 
/*     */     
/* 448 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCrossRefDocumentId() {
/* 456 */     return getDAO_().getCrossRefDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossRefDocumentId(String argCrossRefDocumentId) {
/* 464 */     if (setCrossRefDocumentId_noev(argCrossRefDocumentId) && 
/* 465 */       this._events != null && 
/* 466 */       postEventsForChanges()) {
/* 467 */       this._events.post(IInventoryDocumentCrossReference.SET_CROSSREFDOCUMENTID, argCrossRefDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCrossRefDocumentId_noev(String argCrossRefDocumentId) {
/* 474 */     boolean ev_postable = false;
/*     */     
/* 476 */     if ((getDAO_().getCrossRefDocumentId() == null && argCrossRefDocumentId != null) || (
/* 477 */       getDAO_().getCrossRefDocumentId() != null && !getDAO_().getCrossRefDocumentId().equals(argCrossRefDocumentId))) {
/* 478 */       getDAO_().setCrossRefDocumentId(argCrossRefDocumentId);
/* 479 */       ev_postable = true;
/*     */     } 
/*     */     
/* 482 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCrossRefLineNumber() {
/* 490 */     if (getDAO_().getCrossRefLineNumber() != null) {
/* 491 */       return getDAO_().getCrossRefLineNumber().intValue();
/*     */     }
/*     */     
/* 494 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossRefLineNumber(int argCrossRefLineNumber) {
/* 503 */     if (setCrossRefLineNumber_noev(argCrossRefLineNumber) && 
/* 504 */       this._events != null && 
/* 505 */       postEventsForChanges()) {
/* 506 */       this._events.post(IInventoryDocumentCrossReference.SET_CROSSREFLINENUMBER, Integer.valueOf(argCrossRefLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCrossRefLineNumber_noev(int argCrossRefLineNumber) {
/* 513 */     boolean ev_postable = false;
/*     */     
/* 515 */     if ((getDAO_().getCrossRefLineNumber() == null && Integer.valueOf(argCrossRefLineNumber) != null) || (
/* 516 */       getDAO_().getCrossRefLineNumber() != null && !getDAO_().getCrossRefLineNumber().equals(Integer.valueOf(argCrossRefLineNumber)))) {
/* 517 */       getDAO_().setCrossRefLineNumber(Integer.valueOf(argCrossRefLineNumber));
/* 518 */       ev_postable = true;
/*     */     } 
/*     */     
/* 521 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCrossRefDocumentTypeCode() {
/* 529 */     return getDAO_().getCrossRefDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossRefDocumentTypeCode(String argCrossRefDocumentTypeCode) {
/* 537 */     if (setCrossRefDocumentTypeCode_noev(argCrossRefDocumentTypeCode) && 
/* 538 */       this._events != null && 
/* 539 */       postEventsForChanges()) {
/* 540 */       this._events.post(IInventoryDocumentCrossReference.SET_CROSSREFDOCUMENTTYPECODE, argCrossRefDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCrossRefDocumentTypeCode_noev(String argCrossRefDocumentTypeCode) {
/* 547 */     boolean ev_postable = false;
/*     */     
/* 549 */     if ((getDAO_().getCrossRefDocumentTypeCode() == null && argCrossRefDocumentTypeCode != null) || (
/* 550 */       getDAO_().getCrossRefDocumentTypeCode() != null && !getDAO_().getCrossRefDocumentTypeCode().equals(argCrossRefDocumentTypeCode))) {
/* 551 */       getDAO_().setCrossRefDocumentTypeCode(argCrossRefDocumentTypeCode);
/* 552 */       ev_postable = true;
/*     */     } 
/*     */     
/* 555 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCrossRefRetailLocationId() {
/* 563 */     if (getDAO_().getCrossRefRetailLocationId() != null) {
/* 564 */       return getDAO_().getCrossRefRetailLocationId().longValue();
/*     */     }
/*     */     
/* 567 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossRefRetailLocationId(long argCrossRefRetailLocationId) {
/* 576 */     if (setCrossRefRetailLocationId_noev(argCrossRefRetailLocationId) && 
/* 577 */       this._events != null && 
/* 578 */       postEventsForChanges()) {
/* 579 */       this._events.post(IInventoryDocumentCrossReference.SET_CROSSREFRETAILLOCATIONID, Long.valueOf(argCrossRefRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCrossRefRetailLocationId_noev(long argCrossRefRetailLocationId) {
/* 586 */     boolean ev_postable = false;
/*     */     
/* 588 */     if ((getDAO_().getCrossRefRetailLocationId() == null && Long.valueOf(argCrossRefRetailLocationId) != null) || (
/* 589 */       getDAO_().getCrossRefRetailLocationId() != null && !getDAO_().getCrossRefRetailLocationId().equals(Long.valueOf(argCrossRefRetailLocationId)))) {
/* 590 */       getDAO_().setCrossRefRetailLocationId(Long.valueOf(argCrossRefRetailLocationId));
/* 591 */       ev_postable = true;
/*     */     } 
/*     */     
/* 594 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryDocumentCrossReferenceProperty newProperty(String argPropertyName) {
/* 598 */     InventoryDocumentCrossReferencePropertyId id = new InventoryDocumentCrossReferencePropertyId();
/*     */     
/* 600 */     id.setDocumentId(getDocumentId());
/* 601 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/* 602 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 603 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 604 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 606 */     IInventoryDocumentCrossReferenceProperty prop = (IInventoryDocumentCrossReferenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryDocumentCrossReferenceProperty.class);
/* 607 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryDocumentCrossReferenceProperty> getProperties() {
/* 616 */     if (this._properties == null) {
/* 617 */       this._properties = new HistoricalList(null);
/*     */     }
/* 619 */     return (List<IInventoryDocumentCrossReferenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryDocumentCrossReferenceProperty> argProperties) {
/* 623 */     if (this._properties == null) {
/* 624 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 626 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 629 */     for (IInventoryDocumentCrossReferenceProperty child : this._properties) {
/* 630 */       InventoryDocumentCrossReferencePropertyModel model = (InventoryDocumentCrossReferencePropertyModel)child;
/* 631 */       model.setOrganizationId_noev(getOrganizationId());
/* 632 */       model.setDocumentId_noev(getDocumentId());
/* 633 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 634 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 635 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 636 */       if (child instanceof IDataModelImpl) {
/* 637 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 638 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 639 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 640 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 643 */       if (postEventsForChanges()) {
/* 644 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryDocumentCrossReferenceProperty(IInventoryDocumentCrossReferenceProperty argInventoryDocumentCrossReferenceProperty) {
/* 650 */     if (this._properties == null) {
/* 651 */       this._properties = new HistoricalList(null);
/*     */     }
/* 653 */     argInventoryDocumentCrossReferenceProperty.setOrganizationId(getOrganizationId());
/* 654 */     argInventoryDocumentCrossReferenceProperty.setDocumentId(getDocumentId());
/* 655 */     argInventoryDocumentCrossReferenceProperty.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 656 */     argInventoryDocumentCrossReferenceProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 657 */     argInventoryDocumentCrossReferenceProperty.setRetailLocationId(getRetailLocationId());
/* 658 */     if (argInventoryDocumentCrossReferenceProperty instanceof IDataModelImpl) {
/* 659 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentCrossReferenceProperty).getDAO();
/* 660 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 661 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 662 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 667 */     if (postEventsForChanges()) {
/* 668 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentCrossReferenceProperty));
/*     */     }
/*     */     
/* 671 */     this._properties.add(argInventoryDocumentCrossReferenceProperty);
/* 672 */     if (postEventsForChanges()) {
/* 673 */       this._events.post(IInventoryDocumentCrossReference.ADD_PROPERTIES, argInventoryDocumentCrossReferenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryDocumentCrossReferenceProperty(IInventoryDocumentCrossReferenceProperty argInventoryDocumentCrossReferenceProperty) {
/* 678 */     if (this._properties != null) {
/*     */       
/* 680 */       if (postEventsForChanges()) {
/* 681 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentCrossReferenceProperty));
/*     */       }
/* 683 */       this._properties.remove(argInventoryDocumentCrossReferenceProperty);
/* 684 */       if (postEventsForChanges()) {
/* 685 */         this._events.post(IInventoryDocumentCrossReference.REMOVE_PROPERTIES, argInventoryDocumentCrossReferenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(IInventoryDocumentLineItem argParentLine) {
/* 691 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public IInventoryDocumentLineItem getParentLine() {
/* 695 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 700 */     if ("Properties".equals(argFieldId)) {
/* 701 */       return getProperties();
/*     */     }
/* 703 */     if ("InventoryDocumentCrossReferenceExtension".equals(argFieldId)) {
/* 704 */       return this._myExtension;
/*     */     }
/*     */     
/* 707 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 713 */     if ("Properties".equals(argFieldId)) {
/* 714 */       setProperties(changeToList(argValue, IInventoryDocumentCrossReferenceProperty.class));
/*     */     }
/* 716 */     else if ("InventoryDocumentCrossReferenceExtension".equals(argFieldId)) {
/* 717 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 720 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 726 */     this._persistenceDefaults = argPD;
/* 727 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 728 */     this._eventManager = argEM;
/* 729 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 730 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 731 */     if (this._properties != null) {
/* 732 */       for (IInventoryDocumentCrossReferenceProperty relationship : this._properties) {
/* 733 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryDocumentCrossReferenceExt() {
/* 739 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentCrossReferenceExt(IDataModel argExt) {
/* 743 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 748 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 752 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 755 */     super.startTransaction();
/*     */     
/* 757 */     this._propertiesSavepoint = this._properties;
/* 758 */     if (this._properties != null) {
/* 759 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 760 */       Iterator<IDataModel> it = this._properties.iterator();
/* 761 */       while (it.hasNext()) {
/* 762 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 767 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 772 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 775 */     super.rollbackChanges();
/*     */     
/* 777 */     this._properties = this._propertiesSavepoint;
/* 778 */     this._propertiesSavepoint = null;
/* 779 */     if (this._properties != null) {
/* 780 */       Iterator<IDataModel> it = this._properties.iterator();
/* 781 */       while (it.hasNext()) {
/* 782 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 790 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 793 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 796 */     super.commitTransaction();
/*     */     
/* 798 */     this._propertiesSavepoint = this._properties;
/* 799 */     if (this._properties != null) {
/* 800 */       Iterator<IDataModel> it = this._properties.iterator();
/* 801 */       while (it.hasNext()) {
/* 802 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 804 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 808 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 813 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentCrossReferenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */