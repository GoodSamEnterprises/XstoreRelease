/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryCostItemYearEnd;
/*     */ import dtv.xst.dao.inv.IInventoryCostItemYearEndProperty;
/*     */ import dtv.xst.dao.inv.InventoryCostItemYearEndPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCostItemYearEndModel extends AbstractDataModelWithPropertyImpl<IInventoryCostItemYearEndProperty> implements IInventoryCostItemYearEnd {
/*     */   private static final long serialVersionUID = 1083488738L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IInventoryCostItemYearEndProperty> _properties; private transient HistoricalList<IInventoryCostItemYearEndProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new InventoryCostItemYearEndDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCostItemYearEndDAO getDAO_() {
/*  46 */     return (InventoryCostItemYearEndDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IInventoryCostItemYearEnd.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<InventoryCostItemYearEndPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((InventoryCostItemYearEndPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFiscalYear() {
/* 101 */     if (getDAO_().getFiscalYear() != null) {
/* 102 */       return getDAO_().getFiscalYear().intValue();
/*     */     }
/*     */     
/* 105 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFiscalYear(int argFiscalYear) {
/* 114 */     if (setFiscalYear_noev(argFiscalYear) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IInventoryCostItemYearEnd.SET_FISCALYEAR, Integer.valueOf(argFiscalYear));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFiscalYear_noev(int argFiscalYear) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getFiscalYear() == null && Integer.valueOf(argFiscalYear) != null) || (
/* 127 */       getDAO_().getFiscalYear() != null && !getDAO_().getFiscalYear().equals(Integer.valueOf(argFiscalYear)))) {
/* 128 */       getDAO_().setFiscalYear(Integer.valueOf(argFiscalYear));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<InventoryCostItemYearEndPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((InventoryCostItemYearEndPropertyModel)it.next()).setFiscalYear_noev(argFiscalYear);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 148 */     if (getDAO_().getRetailLocationId() != null) {
/* 149 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 161 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IInventoryCostItemYearEnd.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 174 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 175 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<InventoryCostItemYearEndPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((InventoryCostItemYearEndPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 195 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 203 */     if (setItemId_noev(argItemId) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IInventoryCostItemYearEnd.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 216 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 217 */       getDAO_().setItemId(argItemId);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<InventoryCostItemYearEndPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((InventoryCostItemYearEndPropertyModel)it.next()).setItemId_noev(argItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 237 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 245 */     if (setCreateDate_noev(argCreateDate) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IInventoryCostItemYearEnd.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 258 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 259 */       getDAO_().setCreateDate(argCreateDate);
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 271 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 279 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IInventoryCostItemYearEnd.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 292 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 293 */       getDAO_().setCreateUserId(argCreateUserId);
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 305 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 313 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IInventoryCostItemYearEnd.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 326 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 327 */       getDAO_().setUpdateDate(argUpdateDate);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 339 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 347 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IInventoryCostItemYearEnd.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 360 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 361 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getWacQuantityReceived() {
/* 373 */     return getDAO_().getWacQuantityReceived();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWacQuantityReceived(BigDecimal argWacQuantityReceived) {
/* 381 */     if (setWacQuantityReceived_noev(argWacQuantityReceived) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IInventoryCostItemYearEnd.SET_WACQUANTITYRECEIVED, argWacQuantityReceived);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWacQuantityReceived_noev(BigDecimal argWacQuantityReceived) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getWacQuantityReceived() == null && argWacQuantityReceived != null) || (
/* 394 */       getDAO_().getWacQuantityReceived() != null && !getDAO_().getWacQuantityReceived().equals(argWacQuantityReceived))) {
/* 395 */       getDAO_().setWacQuantityReceived(argWacQuantityReceived);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getWacValueReceived() {
/* 407 */     return getDAO_().getWacValueReceived();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWacValueReceived(BigDecimal argWacValueReceived) {
/* 415 */     if (setWacValueReceived_noev(argWacValueReceived) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IInventoryCostItemYearEnd.SET_WACVALUERECEIVED, argWacValueReceived);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWacValueReceived_noev(BigDecimal argWacValueReceived) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getWacValueReceived() == null && argWacValueReceived != null) || (
/* 428 */       getDAO_().getWacValueReceived() != null && !getDAO_().getWacValueReceived().equals(argWacValueReceived))) {
/* 429 */       getDAO_().setWacValueReceived(argWacValueReceived);
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPwacQuantityOnhandEndofyear() {
/* 441 */     return getDAO_().getPwacQuantityOnhandEndofyear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPwacQuantityOnhandEndofyear(BigDecimal argPwacQuantityOnhandEndofyear) {
/* 449 */     if (setPwacQuantityOnhandEndofyear_noev(argPwacQuantityOnhandEndofyear) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IInventoryCostItemYearEnd.SET_PWACQUANTITYONHANDENDOFYEAR, argPwacQuantityOnhandEndofyear);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPwacQuantityOnhandEndofyear_noev(BigDecimal argPwacQuantityOnhandEndofyear) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getPwacQuantityOnhandEndofyear() == null && argPwacQuantityOnhandEndofyear != null) || (
/* 462 */       getDAO_().getPwacQuantityOnhandEndofyear() != null && !getDAO_().getPwacQuantityOnhandEndofyear().equals(argPwacQuantityOnhandEndofyear))) {
/* 463 */       getDAO_().setPwacQuantityOnhandEndofyear(argPwacQuantityOnhandEndofyear);
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPwacValueOnhandEndofyear() {
/* 475 */     return getDAO_().getPwacValueOnhandEndofyear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPwacValueOnhandEndofyear(BigDecimal argPwacValueOnhandEndofyear) {
/* 483 */     if (setPwacValueOnhandEndofyear_noev(argPwacValueOnhandEndofyear) && 
/* 484 */       this._events != null && 
/* 485 */       postEventsForChanges()) {
/* 486 */       this._events.post(IInventoryCostItemYearEnd.SET_PWACVALUEONHANDENDOFYEAR, argPwacValueOnhandEndofyear);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPwacValueOnhandEndofyear_noev(BigDecimal argPwacValueOnhandEndofyear) {
/* 493 */     boolean ev_postable = false;
/*     */     
/* 495 */     if ((getDAO_().getPwacValueOnhandEndofyear() == null && argPwacValueOnhandEndofyear != null) || (
/* 496 */       getDAO_().getPwacValueOnhandEndofyear() != null && !getDAO_().getPwacValueOnhandEndofyear().equals(argPwacValueOnhandEndofyear))) {
/* 497 */       getDAO_().setPwacValueOnhandEndofyear(argPwacValueOnhandEndofyear);
/* 498 */       ev_postable = true;
/*     */     } 
/*     */     
/* 501 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCostItemYearEndProperty newProperty(String argPropertyName) {
/* 505 */     InventoryCostItemYearEndPropertyId id = new InventoryCostItemYearEndPropertyId();
/*     */     
/* 507 */     id.setFiscalYear(Integer.valueOf(getFiscalYear()));
/* 508 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 509 */     id.setItemId(getItemId());
/* 510 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 512 */     IInventoryCostItemYearEndProperty prop = (IInventoryCostItemYearEndProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCostItemYearEndProperty.class);
/* 513 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCostItemYearEndProperty> getProperties() {
/* 522 */     if (this._properties == null) {
/* 523 */       this._properties = new HistoricalList(null);
/*     */     }
/* 525 */     return (List<IInventoryCostItemYearEndProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCostItemYearEndProperty> argProperties) {
/* 529 */     if (this._properties == null) {
/* 530 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 532 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 535 */     for (IInventoryCostItemYearEndProperty child : this._properties) {
/* 536 */       InventoryCostItemYearEndPropertyModel model = (InventoryCostItemYearEndPropertyModel)child;
/* 537 */       model.setOrganizationId_noev(getOrganizationId());
/* 538 */       model.setFiscalYear_noev(getFiscalYear());
/* 539 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 540 */       model.setItemId_noev(getItemId());
/* 541 */       if (child instanceof IDataModelImpl) {
/* 542 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 543 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 544 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 545 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 548 */       if (postEventsForChanges()) {
/* 549 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCostItemYearEndProperty(IInventoryCostItemYearEndProperty argInventoryCostItemYearEndProperty) {
/* 555 */     if (this._properties == null) {
/* 556 */       this._properties = new HistoricalList(null);
/*     */     }
/* 558 */     argInventoryCostItemYearEndProperty.setOrganizationId(getOrganizationId());
/* 559 */     argInventoryCostItemYearEndProperty.setFiscalYear(getFiscalYear());
/* 560 */     argInventoryCostItemYearEndProperty.setRetailLocationId(getRetailLocationId());
/* 561 */     argInventoryCostItemYearEndProperty.setItemId(getItemId());
/* 562 */     if (argInventoryCostItemYearEndProperty instanceof IDataModelImpl) {
/* 563 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCostItemYearEndProperty).getDAO();
/* 564 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 565 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 566 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 571 */     if (postEventsForChanges()) {
/* 572 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCostItemYearEndProperty));
/*     */     }
/*     */     
/* 575 */     this._properties.add(argInventoryCostItemYearEndProperty);
/* 576 */     if (postEventsForChanges()) {
/* 577 */       this._events.post(IInventoryCostItemYearEnd.ADD_PROPERTIES, argInventoryCostItemYearEndProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCostItemYearEndProperty(IInventoryCostItemYearEndProperty argInventoryCostItemYearEndProperty) {
/* 582 */     if (this._properties != null) {
/*     */       
/* 584 */       if (postEventsForChanges()) {
/* 585 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCostItemYearEndProperty));
/*     */       }
/* 587 */       this._properties.remove(argInventoryCostItemYearEndProperty);
/* 588 */       if (postEventsForChanges()) {
/* 589 */         this._events.post(IInventoryCostItemYearEnd.REMOVE_PROPERTIES, argInventoryCostItemYearEndProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 596 */     if ("Properties".equals(argFieldId)) {
/* 597 */       return getProperties();
/*     */     }
/* 599 */     if ("InventoryCostItemYearEndExtension".equals(argFieldId)) {
/* 600 */       return this._myExtension;
/*     */     }
/*     */     
/* 603 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 609 */     if ("Properties".equals(argFieldId)) {
/* 610 */       setProperties(changeToList(argValue, IInventoryCostItemYearEndProperty.class));
/*     */     }
/* 612 */     else if ("InventoryCostItemYearEndExtension".equals(argFieldId)) {
/* 613 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 616 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 622 */     this._persistenceDefaults = argPD;
/* 623 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 624 */     this._eventManager = argEM;
/* 625 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 626 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 627 */     if (this._properties != null) {
/* 628 */       for (IInventoryCostItemYearEndProperty relationship : this._properties) {
/* 629 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCostItemYearEndExt() {
/* 635 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCostItemYearEndExt(IDataModel argExt) {
/* 639 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 644 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 648 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 651 */     super.startTransaction();
/*     */     
/* 653 */     this._propertiesSavepoint = this._properties;
/* 654 */     if (this._properties != null) {
/* 655 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 656 */       Iterator<IDataModel> it = this._properties.iterator();
/* 657 */       while (it.hasNext()) {
/* 658 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 663 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 668 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 671 */     super.rollbackChanges();
/*     */     
/* 673 */     this._properties = this._propertiesSavepoint;
/* 674 */     this._propertiesSavepoint = null;
/* 675 */     if (this._properties != null) {
/* 676 */       Iterator<IDataModel> it = this._properties.iterator();
/* 677 */       while (it.hasNext()) {
/* 678 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 686 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 689 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 692 */     super.commitTransaction();
/*     */     
/* 694 */     this._propertiesSavepoint = this._properties;
/* 695 */     if (this._properties != null) {
/* 696 */       Iterator<IDataModel> it = this._properties.iterator();
/* 697 */       while (it.hasNext()) {
/* 698 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 700 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 704 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 709 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCostItemYearEndModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */