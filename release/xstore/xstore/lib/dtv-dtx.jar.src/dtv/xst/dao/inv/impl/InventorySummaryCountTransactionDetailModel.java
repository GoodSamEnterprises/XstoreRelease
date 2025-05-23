/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
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
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransaction;
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransactionDetail;
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransactionDetailProperty;
/*     */ import dtv.xst.dao.inv.InventorySummaryCountTransactionDetailPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventorySummaryCountTransactionDetailModel extends AbstractDataModelWithPropertyImpl<IInventorySummaryCountTransactionDetailProperty> implements IInventorySummaryCountTransactionDetail {
/*     */   private static final long serialVersionUID = -1159165206L;
/*     */   private IInventorySummaryCountTransaction _parentTransaction;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventorySummaryCountTransactionDetailProperty> _properties; private transient HistoricalList<IInventorySummaryCountTransactionDetailProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InventorySummaryCountTransactionDetailDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventorySummaryCountTransactionDetailDAO getDAO_() {
/*  48 */     return (InventorySummaryCountTransactionDetailDAO)this._daoImpl;
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
/*  69 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  78 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  79 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  80 */       ev_postable = true;
/*  81 */       if (this._properties != null) {
/*     */         
/*  83 */         Iterator<InventorySummaryCountTransactionDetailPropertyModel> it = this._properties.iterator();
/*  84 */         while (it.hasNext())
/*     */         {
/*  86 */           ((InventorySummaryCountTransactionDetailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  99 */     if (getDAO_().getRetailLocationId() != null) {
/* 100 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 103 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 112 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 118 */     boolean ev_postable = false;
/*     */     
/* 120 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 121 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 122 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 123 */       ev_postable = true;
/* 124 */       if (this._properties != null) {
/*     */         
/* 126 */         Iterator<InventorySummaryCountTransactionDetailPropertyModel> it = this._properties.iterator();
/* 127 */         while (it.hasNext())
/*     */         {
/* 129 */           ((InventorySummaryCountTransactionDetailPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 142 */     if (getDAO_().getWorkstationId() != null) {
/* 143 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 146 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 155 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 164 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 165 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<InventorySummaryCountTransactionDetailPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((InventorySummaryCountTransactionDetailPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 185 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 193 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 206 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 207 */       getDAO_().setBusinessDate(argBusinessDate);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<InventorySummaryCountTransactionDetailPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((InventorySummaryCountTransactionDetailPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 227 */     if (getDAO_().getTransactionSequence() != null) {
/* 228 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 231 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 240 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 253 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 254 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 255 */       ev_postable = true;
/* 256 */       if (this._properties != null) {
/*     */         
/* 258 */         Iterator<InventorySummaryCountTransactionDetailPropertyModel> it = this._properties.iterator();
/* 259 */         while (it.hasNext())
/*     */         {
/* 261 */           ((InventorySummaryCountTransactionDetailPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTransLineSequence() {
/* 274 */     if (getDAO_().getTransLineSequence() != null) {
/* 275 */       return getDAO_().getTransLineSequence().intValue();
/*     */     }
/*     */     
/* 278 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransLineSequence(int argTransLineSequence) {
/* 287 */     if (setTransLineSequence_noev(argTransLineSequence) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_TRANSLINESEQUENCE, Integer.valueOf(argTransLineSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransLineSequence_noev(int argTransLineSequence) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getTransLineSequence() == null && Integer.valueOf(argTransLineSequence) != null) || (
/* 300 */       getDAO_().getTransLineSequence() != null && !getDAO_().getTransLineSequence().equals(Integer.valueOf(argTransLineSequence)))) {
/* 301 */       getDAO_().setTransLineSequence(Integer.valueOf(argTransLineSequence));
/* 302 */       ev_postable = true;
/* 303 */       if (this._properties != null) {
/*     */         
/* 305 */         Iterator<InventorySummaryCountTransactionDetailPropertyModel> it = this._properties.iterator();
/* 306 */         while (it.hasNext())
/*     */         {
/* 308 */           ((InventorySummaryCountTransactionDetailPropertyModel)it.next()).setTransLineSequence_noev(argTransLineSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 321 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 329 */     if (setCreateDate_noev(argCreateDate) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 342 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 343 */       getDAO_().setCreateDate(argCreateDate);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 355 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 363 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 376 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 377 */       getDAO_().setCreateUserId(argCreateUserId);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 389 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 397 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 410 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 411 */       getDAO_().setUpdateDate(argUpdateDate);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 423 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 431 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 432 */       this._events != null && 
/* 433 */       postEventsForChanges()) {
/* 434 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 441 */     boolean ev_postable = false;
/*     */     
/* 443 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 444 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 445 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 446 */       ev_postable = true;
/*     */     } 
/*     */     
/* 449 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationId() {
/* 457 */     return getDAO_().getLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 465 */     if (setLocationId_noev(argLocationId) && 
/* 466 */       this._events != null && 
/* 467 */       postEventsForChanges()) {
/* 468 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_LOCATIONID, argLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationId_noev(String argLocationId) {
/* 475 */     boolean ev_postable = false;
/*     */     
/* 477 */     if ((getDAO_().getLocationId() == null && argLocationId != null) || (
/* 478 */       getDAO_().getLocationId() != null && !getDAO_().getLocationId().equals(argLocationId))) {
/* 479 */       getDAO_().setLocationId(argLocationId);
/* 480 */       ev_postable = true;
/*     */     } 
/*     */     
/* 483 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBucketId() {
/* 491 */     return getDAO_().getBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/* 499 */     if (setBucketId_noev(argBucketId) && 
/* 500 */       this._events != null && 
/* 501 */       postEventsForChanges()) {
/* 502 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_BUCKETID, argBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBucketId_noev(String argBucketId) {
/* 509 */     boolean ev_postable = false;
/*     */     
/* 511 */     if ((getDAO_().getBucketId() == null && argBucketId != null) || (
/* 512 */       getDAO_().getBucketId() != null && !getDAO_().getBucketId().equals(argBucketId))) {
/* 513 */       getDAO_().setBucketId(argBucketId);
/* 514 */       ev_postable = true;
/*     */     } 
/*     */     
/* 517 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getSystemCount() {
/* 525 */     return getDAO_().getSystemCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSystemCount(BigDecimal argSystemCount) {
/* 533 */     if (setSystemCount_noev(argSystemCount) && 
/* 534 */       this._events != null && 
/* 535 */       postEventsForChanges()) {
/* 536 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_SYSTEMCOUNT, argSystemCount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSystemCount_noev(BigDecimal argSystemCount) {
/* 543 */     boolean ev_postable = false;
/*     */     
/* 545 */     if ((getDAO_().getSystemCount() == null && argSystemCount != null) || (
/* 546 */       getDAO_().getSystemCount() != null && !getDAO_().getSystemCount().equals(argSystemCount))) {
/* 547 */       getDAO_().setSystemCount(argSystemCount);
/* 548 */       ev_postable = true;
/*     */     } 
/*     */     
/* 551 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDeclaredCount() {
/* 559 */     return getDAO_().getDeclaredCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDeclaredCount(BigDecimal argDeclaredCount) {
/* 567 */     if (setDeclaredCount_noev(argDeclaredCount) && 
/* 568 */       this._events != null && 
/* 569 */       postEventsForChanges()) {
/* 570 */       this._events.post(IInventorySummaryCountTransactionDetail.SET_DECLAREDCOUNT, argDeclaredCount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDeclaredCount_noev(BigDecimal argDeclaredCount) {
/* 577 */     boolean ev_postable = false;
/*     */     
/* 579 */     if ((getDAO_().getDeclaredCount() == null && argDeclaredCount != null) || (
/* 580 */       getDAO_().getDeclaredCount() != null && !getDAO_().getDeclaredCount().equals(argDeclaredCount))) {
/* 581 */       getDAO_().setDeclaredCount(argDeclaredCount);
/* 582 */       ev_postable = true;
/*     */     } 
/*     */     
/* 585 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventorySummaryCountTransactionDetailProperty newProperty(String argPropertyName) {
/* 589 */     InventorySummaryCountTransactionDetailPropertyId id = new InventorySummaryCountTransactionDetailPropertyId();
/*     */     
/* 591 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 592 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 593 */     id.setBusinessDate(getBusinessDate());
/* 594 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 595 */     id.setTransLineSequence(Integer.valueOf(getTransLineSequence()));
/* 596 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 598 */     IInventorySummaryCountTransactionDetailProperty prop = (IInventorySummaryCountTransactionDetailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventorySummaryCountTransactionDetailProperty.class);
/* 599 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventorySummaryCountTransactionDetailProperty> getProperties() {
/* 608 */     if (this._properties == null) {
/* 609 */       this._properties = new HistoricalList(null);
/*     */     }
/* 611 */     return (List<IInventorySummaryCountTransactionDetailProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventorySummaryCountTransactionDetailProperty> argProperties) {
/* 615 */     if (this._properties == null) {
/* 616 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 618 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 621 */     for (IInventorySummaryCountTransactionDetailProperty child : this._properties) {
/* 622 */       InventorySummaryCountTransactionDetailPropertyModel model = (InventorySummaryCountTransactionDetailPropertyModel)child;
/* 623 */       model.setOrganizationId_noev(getOrganizationId());
/* 624 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 625 */       model.setWorkstationId_noev(getWorkstationId());
/* 626 */       model.setBusinessDate_noev(getBusinessDate());
/* 627 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 628 */       model.setTransLineSequence_noev(getTransLineSequence());
/* 629 */       if (child instanceof IDataModelImpl) {
/* 630 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 631 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 632 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 633 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 636 */       if (postEventsForChanges()) {
/* 637 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventorySummaryCountTransactionDetailProperty(IInventorySummaryCountTransactionDetailProperty argInventorySummaryCountTransactionDetailProperty) {
/* 643 */     if (this._properties == null) {
/* 644 */       this._properties = new HistoricalList(null);
/*     */     }
/* 646 */     argInventorySummaryCountTransactionDetailProperty.setOrganizationId(getOrganizationId());
/* 647 */     argInventorySummaryCountTransactionDetailProperty.setRetailLocationId(getRetailLocationId());
/* 648 */     argInventorySummaryCountTransactionDetailProperty.setWorkstationId(getWorkstationId());
/* 649 */     argInventorySummaryCountTransactionDetailProperty.setBusinessDate(getBusinessDate());
/* 650 */     argInventorySummaryCountTransactionDetailProperty.setTransactionSequence(getTransactionSequence());
/* 651 */     argInventorySummaryCountTransactionDetailProperty.setTransLineSequence(getTransLineSequence());
/* 652 */     if (argInventorySummaryCountTransactionDetailProperty instanceof IDataModelImpl) {
/* 653 */       IDataAccessObject childDao = ((IDataModelImpl)argInventorySummaryCountTransactionDetailProperty).getDAO();
/* 654 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 655 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 656 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 661 */     if (postEventsForChanges()) {
/* 662 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventorySummaryCountTransactionDetailProperty));
/*     */     }
/*     */     
/* 665 */     this._properties.add(argInventorySummaryCountTransactionDetailProperty);
/* 666 */     if (postEventsForChanges()) {
/* 667 */       this._events.post(IInventorySummaryCountTransactionDetail.ADD_PROPERTIES, argInventorySummaryCountTransactionDetailProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventorySummaryCountTransactionDetailProperty(IInventorySummaryCountTransactionDetailProperty argInventorySummaryCountTransactionDetailProperty) {
/* 672 */     if (this._properties != null) {
/*     */       
/* 674 */       if (postEventsForChanges()) {
/* 675 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventorySummaryCountTransactionDetailProperty));
/*     */       }
/* 677 */       this._properties.remove(argInventorySummaryCountTransactionDetailProperty);
/* 678 */       if (postEventsForChanges()) {
/* 679 */         this._events.post(IInventorySummaryCountTransactionDetail.REMOVE_PROPERTIES, argInventorySummaryCountTransactionDetailProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTransaction(IInventorySummaryCountTransaction argParentTransaction) {
/* 685 */     this._parentTransaction = argParentTransaction;
/*     */   }
/*     */   
/*     */   public IInventorySummaryCountTransaction getParentTransaction() {
/* 689 */     return this._parentTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 694 */     if ("Properties".equals(argFieldId)) {
/* 695 */       return getProperties();
/*     */     }
/* 697 */     if ("InventorySummaryCountTransactionDetailExtension".equals(argFieldId)) {
/* 698 */       return this._myExtension;
/*     */     }
/*     */     
/* 701 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 707 */     if ("Properties".equals(argFieldId)) {
/* 708 */       setProperties(changeToList(argValue, IInventorySummaryCountTransactionDetailProperty.class));
/*     */     }
/* 710 */     else if ("InventorySummaryCountTransactionDetailExtension".equals(argFieldId)) {
/* 711 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 714 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 720 */     this._persistenceDefaults = argPD;
/* 721 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 722 */     this._eventManager = argEM;
/* 723 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 724 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 725 */     if (this._properties != null) {
/* 726 */       for (IInventorySummaryCountTransactionDetailProperty relationship : this._properties) {
/* 727 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventorySummaryCountTransactionDetailExt() {
/* 733 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventorySummaryCountTransactionDetailExt(IDataModel argExt) {
/* 737 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 742 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 746 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 749 */     super.startTransaction();
/*     */     
/* 751 */     this._propertiesSavepoint = this._properties;
/* 752 */     if (this._properties != null) {
/* 753 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 754 */       Iterator<IDataModel> it = this._properties.iterator();
/* 755 */       while (it.hasNext()) {
/* 756 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 761 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 766 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 769 */     super.rollbackChanges();
/*     */     
/* 771 */     this._properties = this._propertiesSavepoint;
/* 772 */     this._propertiesSavepoint = null;
/* 773 */     if (this._properties != null) {
/* 774 */       Iterator<IDataModel> it = this._properties.iterator();
/* 775 */       while (it.hasNext()) {
/* 776 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 784 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 787 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 790 */     super.commitTransaction();
/*     */     
/* 792 */     this._propertiesSavepoint = this._properties;
/* 793 */     if (this._properties != null) {
/* 794 */       Iterator<IDataModel> it = this._properties.iterator();
/* 795 */       while (it.hasNext()) {
/* 796 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 798 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 802 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 807 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventorySummaryCountTransactionDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */