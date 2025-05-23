/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.CustomerAccountId;
/*     */ import dtv.xst.dao.cat.DeliveryModifierId;
/*     */ import dtv.xst.dao.trl.CustomerItemAccountModifierPropertyId;
/*     */ import dtv.xst.dao.trl.ICustomerItemAccountModifier;
/*     */ import dtv.xst.dao.trl.ICustomerItemAccountModifierProperty;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerItemAccountModifierModel extends AbstractDataModelWithPropertyImpl<ICustomerItemAccountModifierProperty> implements ICustomerItemAccountModifier {
/*     */   private static final long serialVersionUID = 1611431859L;
/*     */   private ISaleReturnLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICustomerItemAccountModifierProperty> _properties; private transient HistoricalList<ICustomerItemAccountModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new CustomerItemAccountModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerItemAccountModifierDAO getDAO_() {
/*  48 */     return (CustomerItemAccountModifierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  56 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  64 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(ICustomerItemAccountModifier.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  77 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  78 */       getDAO_().setBusinessDate(argBusinessDate);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<CustomerItemAccountModifierPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((CustomerItemAccountModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  98 */     if (getDAO_().getOrganizationId() != null) {
/*  99 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 102 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 111 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(ICustomerItemAccountModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<CustomerItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((CustomerItemAccountModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 145 */     if (getDAO_().getRetailLocationId() != null) {
/* 146 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 149 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 158 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(ICustomerItemAccountModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 171 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 172 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<CustomerItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((CustomerItemAccountModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 192 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 193 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 196 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 205 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(ICustomerItemAccountModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 218 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 219 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<CustomerItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((CustomerItemAccountModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 239 */     if (getDAO_().getTransactionSequence() != null) {
/* 240 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 243 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 252 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(ICustomerItemAccountModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 265 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 266 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 267 */       ev_postable = true;
/* 268 */       if (this._properties != null) {
/*     */         
/* 270 */         Iterator<CustomerItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((CustomerItemAccountModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 286 */     if (getDAO_().getWorkstationId() != null) {
/* 287 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 290 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 299 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(ICustomerItemAccountModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 312 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 313 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<CustomerItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((CustomerItemAccountModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 333 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 341 */     if (setCreateDate_noev(argCreateDate) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(ICustomerItemAccountModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 354 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 355 */       getDAO_().setCreateDate(argCreateDate);
/* 356 */       ev_postable = true;
/*     */     } 
/*     */     
/* 359 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 367 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 375 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 376 */       this._events != null && 
/* 377 */       postEventsForChanges()) {
/* 378 */       this._events.post(ICustomerItemAccountModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 385 */     boolean ev_postable = false;
/*     */     
/* 387 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 388 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 389 */       getDAO_().setCreateUserId(argCreateUserId);
/* 390 */       ev_postable = true;
/*     */     } 
/*     */     
/* 393 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 401 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 409 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 410 */       this._events != null && 
/* 411 */       postEventsForChanges()) {
/* 412 */       this._events.post(ICustomerItemAccountModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 419 */     boolean ev_postable = false;
/*     */     
/* 421 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 422 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 423 */       getDAO_().setUpdateDate(argUpdateDate);
/* 424 */       ev_postable = true;
/*     */     } 
/*     */     
/* 427 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 435 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 443 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 444 */       this._events != null && 
/* 445 */       postEventsForChanges()) {
/* 446 */       this._events.post(ICustomerItemAccountModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 453 */     boolean ev_postable = false;
/*     */     
/* 455 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 456 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 457 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 458 */       ev_postable = true;
/*     */     } 
/*     */     
/* 461 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 469 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 477 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(ICustomerItemAccountModifier.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 490 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 491 */       getDAO_().setCustAccountId(argCustAccountId);
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/* 503 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 511 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 512 */       this._events != null && 
/* 513 */       postEventsForChanges()) {
/* 514 */       this._events.post(ICustomerItemAccountModifier.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 521 */     boolean ev_postable = false;
/*     */     
/* 523 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 524 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 525 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 526 */       ev_postable = true;
/*     */     } 
/*     */     
/* 529 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getItemAccountExtendedPrice() {
/* 537 */     return getDAO_().getItemAccountExtendedPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemAccountExtendedPrice(BigDecimal argItemAccountExtendedPrice) {
/* 545 */     if (setItemAccountExtendedPrice_noev(argItemAccountExtendedPrice) && 
/* 546 */       this._events != null && 
/* 547 */       postEventsForChanges()) {
/* 548 */       this._events.post(ICustomerItemAccountModifier.SET_ITEMACCOUNTEXTENDEDPRICE, argItemAccountExtendedPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemAccountExtendedPrice_noev(BigDecimal argItemAccountExtendedPrice) {
/* 555 */     boolean ev_postable = false;
/*     */     
/* 557 */     if ((getDAO_().getItemAccountExtendedPrice() == null && argItemAccountExtendedPrice != null) || (
/* 558 */       getDAO_().getItemAccountExtendedPrice() != null && !getDAO_().getItemAccountExtendedPrice().equals(argItemAccountExtendedPrice))) {
/* 559 */       getDAO_().setItemAccountExtendedPrice(argItemAccountExtendedPrice);
/* 560 */       ev_postable = true;
/*     */     } 
/*     */     
/* 563 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerItemAccountModifierProperty newProperty(String argPropertyName) {
/* 567 */     CustomerItemAccountModifierPropertyId id = new CustomerItemAccountModifierPropertyId();
/*     */     
/* 569 */     id.setBusinessDate(getBusinessDate());
/* 570 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 571 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 572 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 573 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 574 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 576 */     ICustomerItemAccountModifierProperty prop = (ICustomerItemAccountModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerItemAccountModifierProperty.class);
/* 577 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerItemAccountModifierProperty> getProperties() {
/* 586 */     if (this._properties == null) {
/* 587 */       this._properties = new HistoricalList(null);
/*     */     }
/* 589 */     return (List<ICustomerItemAccountModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerItemAccountModifierProperty> argProperties) {
/* 593 */     if (this._properties == null) {
/* 594 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 596 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 599 */     for (ICustomerItemAccountModifierProperty child : this._properties) {
/* 600 */       CustomerItemAccountModifierPropertyModel model = (CustomerItemAccountModifierPropertyModel)child;
/* 601 */       model.setBusinessDate_noev(getBusinessDate());
/* 602 */       model.setOrganizationId_noev(getOrganizationId());
/* 603 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 604 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 605 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 606 */       model.setWorkstationId_noev(getWorkstationId());
/* 607 */       if (child instanceof IDataModelImpl) {
/* 608 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 609 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 610 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 611 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 614 */       if (postEventsForChanges()) {
/* 615 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerItemAccountModifierProperty(ICustomerItemAccountModifierProperty argCustomerItemAccountModifierProperty) {
/* 621 */     if (this._properties == null) {
/* 622 */       this._properties = new HistoricalList(null);
/*     */     }
/* 624 */     argCustomerItemAccountModifierProperty.setBusinessDate(getBusinessDate());
/* 625 */     argCustomerItemAccountModifierProperty.setOrganizationId(getOrganizationId());
/* 626 */     argCustomerItemAccountModifierProperty.setRetailLocationId(getRetailLocationId());
/* 627 */     argCustomerItemAccountModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 628 */     argCustomerItemAccountModifierProperty.setTransactionSequence(getTransactionSequence());
/* 629 */     argCustomerItemAccountModifierProperty.setWorkstationId(getWorkstationId());
/* 630 */     if (argCustomerItemAccountModifierProperty instanceof IDataModelImpl) {
/* 631 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerItemAccountModifierProperty).getDAO();
/* 632 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 633 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 634 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 639 */     if (postEventsForChanges()) {
/* 640 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountModifierProperty));
/*     */     }
/*     */     
/* 643 */     this._properties.add(argCustomerItemAccountModifierProperty);
/* 644 */     if (postEventsForChanges()) {
/* 645 */       this._events.post(ICustomerItemAccountModifier.ADD_PROPERTIES, argCustomerItemAccountModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerItemAccountModifierProperty(ICustomerItemAccountModifierProperty argCustomerItemAccountModifierProperty) {
/* 650 */     if (this._properties != null) {
/*     */       
/* 652 */       if (postEventsForChanges()) {
/* 653 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountModifierProperty));
/*     */       }
/* 655 */       this._properties.remove(argCustomerItemAccountModifierProperty);
/* 656 */       if (postEventsForChanges()) {
/* 657 */         this._events.post(ICustomerItemAccountModifier.REMOVE_PROPERTIES, argCustomerItemAccountModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/* 663 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public ISaleReturnLineItem getParentLine() {
/* 667 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 672 */     if ("Properties".equals(argFieldId)) {
/* 673 */       return getProperties();
/*     */     }
/* 675 */     if ("CustomerItemAccountModifierExtension".equals(argFieldId)) {
/* 676 */       return this._myExtension;
/*     */     }
/*     */     
/* 679 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 685 */     if ("Properties".equals(argFieldId)) {
/* 686 */       setProperties(changeToList(argValue, ICustomerItemAccountModifierProperty.class));
/*     */     }
/* 688 */     else if ("CustomerItemAccountModifierExtension".equals(argFieldId)) {
/* 689 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 692 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 698 */     this._persistenceDefaults = argPD;
/* 699 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 700 */     this._eventManager = argEM;
/* 701 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 702 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 703 */     if (this._properties != null) {
/* 704 */       for (ICustomerItemAccountModifierProperty relationship : this._properties) {
/* 705 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerItemAccountModifierExt() {
/* 711 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerItemAccountModifierExt(IDataModel argExt) {
/* 715 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 720 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 724 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 727 */     super.startTransaction();
/*     */     
/* 729 */     this._propertiesSavepoint = this._properties;
/* 730 */     if (this._properties != null) {
/* 731 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 732 */       Iterator<IDataModel> it = this._properties.iterator();
/* 733 */       while (it.hasNext()) {
/* 734 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 739 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 744 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 747 */     super.rollbackChanges();
/*     */     
/* 749 */     this._properties = this._propertiesSavepoint;
/* 750 */     this._propertiesSavepoint = null;
/* 751 */     if (this._properties != null) {
/* 752 */       Iterator<IDataModel> it = this._properties.iterator();
/* 753 */       while (it.hasNext()) {
/* 754 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 762 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 765 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 768 */     super.commitTransaction();
/*     */     
/* 770 */     this._propertiesSavepoint = this._properties;
/* 771 */     if (this._properties != null) {
/* 772 */       Iterator<IDataModel> it = this._properties.iterator();
/* 773 */       while (it.hasNext()) {
/* 774 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 776 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 780 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 785 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomerAccountId getCustomerAccountIdObject() {
/* 801 */     CustomerAccountId id = new CustomerAccountId();
/* 802 */     id.setCustAccountCode(getCustAccountCode());
/* 803 */     id.setCustAccountId(getCustAccountId());
/* 804 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DeliveryModifierId getDeliveryModifierIdObject() {
/* 811 */     DeliveryModifierId id = new DeliveryModifierId();
/* 812 */     id.setCustAccountCode(getCustAccountCode());
/* 813 */     id.setCustAccountId(getCustAccountId());
/* 814 */     return id;
/*     */   }
/*     */   
/*     */   public void setIdValuesByObject(RetailTransactionLineItemId lineItemId) {
/* 818 */     setBusinessDate(lineItemId.getBusinessDate());
/* 819 */     setRetailLocationId(lineItemId.getRetailLocationId().longValue());
/* 820 */     setWorkstationId(lineItemId.getWorkstationId().longValue());
/* 821 */     setTransactionSequence(lineItemId.getTransactionSequence().longValue());
/* 822 */     setRetailTransactionLineItemSequence(lineItemId.getRetailTransactionLineItemSequence().intValue());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CustomerItemAccountModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */