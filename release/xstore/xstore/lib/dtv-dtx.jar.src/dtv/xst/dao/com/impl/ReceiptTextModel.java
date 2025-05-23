/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.IReceiptText;
/*     */ import dtv.xst.dao.com.IReceiptTextProperty;
/*     */ import dtv.xst.dao.com.ReceiptTextPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReceiptTextModel extends AbstractDataModelWithPropertyImpl<IReceiptTextProperty> implements IReceiptText {
/*     */   private static final long serialVersionUID = -593496219L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReceiptTextProperty> _properties; private transient HistoricalList<IReceiptTextProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReceiptTextDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReceiptTextDAO getDAO_() {
/*  46 */     return (ReceiptTextDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReceiptText.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReceiptTextPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReceiptTextPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getTextCode() {
/* 101 */     return getDAO_().getTextCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/* 109 */     if (setTextCode_noev(argTextCode) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IReceiptText.SET_TEXTCODE, argTextCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextCode_noev(String argTextCode) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getTextCode() == null && argTextCode != null) || (
/* 122 */       getDAO_().getTextCode() != null && !getDAO_().getTextCode().equals(argTextCode))) {
/* 123 */       getDAO_().setTextCode(argTextCode);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ReceiptTextPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ReceiptTextPropertyModel)it.next()).setTextCode_noev(argTextCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextSequence() {
/* 143 */     if (getDAO_().getTextSequence() != null) {
/* 144 */       return getDAO_().getTextSequence().intValue();
/*     */     }
/*     */     
/* 147 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextSequence(int argTextSequence) {
/* 156 */     if (setTextSequence_noev(argTextSequence) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IReceiptText.SET_TEXTSEQUENCE, Integer.valueOf(argTextSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextSequence_noev(int argTextSequence) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getTextSequence() == null && Integer.valueOf(argTextSequence) != null) || (
/* 169 */       getDAO_().getTextSequence() != null && !getDAO_().getTextSequence().equals(Integer.valueOf(argTextSequence)))) {
/* 170 */       getDAO_().setTextSequence(Integer.valueOf(argTextSequence));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<ReceiptTextPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((ReceiptTextPropertyModel)it.next()).setTextSequence_noev(argTextSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextSubcode() {
/* 190 */     return getDAO_().getTextSubcode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextSubcode(String argTextSubcode) {
/* 198 */     if (setTextSubcode_noev(argTextSubcode) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IReceiptText.SET_TEXTSUBCODE, argTextSubcode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextSubcode_noev(String argTextSubcode) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getTextSubcode() == null && argTextSubcode != null) || (
/* 211 */       getDAO_().getTextSubcode() != null && !getDAO_().getTextSubcode().equals(argTextSubcode))) {
/* 212 */       getDAO_().setTextSubcode(argTextSubcode);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<ReceiptTextPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((ReceiptTextPropertyModel)it.next()).setTextSubcode_noev(argTextSubcode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigElement() {
/* 232 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 240 */     if (setConfigElement_noev(argConfigElement) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IReceiptText.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 253 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 254 */       getDAO_().setConfigElement(argConfigElement);
/* 255 */       ev_postable = true;
/* 256 */       if (this._properties != null) {
/*     */         
/* 258 */         Iterator<ReceiptTextPropertyModel> it = this._properties.iterator();
/* 259 */         while (it.hasNext())
/*     */         {
/* 261 */           ((ReceiptTextPropertyModel)it.next()).setConfigElement_noev(argConfigElement);
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
/*     */   public Date getCreateDate() {
/* 274 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 282 */     if (setCreateDate_noev(argCreateDate) && 
/* 283 */       this._events != null && 
/* 284 */       postEventsForChanges()) {
/* 285 */       this._events.post(IReceiptText.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 292 */     boolean ev_postable = false;
/*     */     
/* 294 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 295 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 296 */       getDAO_().setCreateDate(argCreateDate);
/* 297 */       ev_postable = true;
/*     */     } 
/*     */     
/* 300 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 308 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 316 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 317 */       this._events != null && 
/* 318 */       postEventsForChanges()) {
/* 319 */       this._events.post(IReceiptText.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 326 */     boolean ev_postable = false;
/*     */     
/* 328 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 329 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 330 */       getDAO_().setCreateUserId(argCreateUserId);
/* 331 */       ev_postable = true;
/*     */     } 
/*     */     
/* 334 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 342 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 350 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 351 */       this._events != null && 
/* 352 */       postEventsForChanges()) {
/* 353 */       this._events.post(IReceiptText.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 360 */     boolean ev_postable = false;
/*     */     
/* 362 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 363 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 364 */       getDAO_().setUpdateDate(argUpdateDate);
/* 365 */       ev_postable = true;
/*     */     } 
/*     */     
/* 368 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 376 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 384 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 385 */       this._events != null && 
/* 386 */       postEventsForChanges()) {
/* 387 */       this._events.post(IReceiptText.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 394 */     boolean ev_postable = false;
/*     */     
/* 396 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 397 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 398 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 399 */       ev_postable = true;
/*     */     } 
/*     */     
/* 402 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReceiptText() {
/* 410 */     return getDAO_().getReceiptText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReceiptText(String argReceiptText) {
/* 418 */     if (setReceiptText_noev(argReceiptText) && 
/* 419 */       this._events != null && 
/* 420 */       postEventsForChanges()) {
/* 421 */       this._events.post(IReceiptText.SET_RECEIPTTEXT, argReceiptText);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReceiptText_noev(String argReceiptText) {
/* 428 */     boolean ev_postable = false;
/*     */     
/* 430 */     if ((getDAO_().getReceiptText() == null && argReceiptText != null) || (
/* 431 */       getDAO_().getReceiptText() != null && !getDAO_().getReceiptText().equals(argReceiptText))) {
/* 432 */       getDAO_().setReceiptText(argReceiptText);
/* 433 */       ev_postable = true;
/*     */     } 
/*     */     
/* 436 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 444 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 452 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 453 */       this._events != null && 
/* 454 */       postEventsForChanges()) {
/* 455 */       this._events.post(IReceiptText.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 462 */     boolean ev_postable = false;
/*     */     
/* 464 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 465 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 466 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 467 */       ev_postable = true;
/*     */     } 
/*     */     
/* 470 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 478 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 486 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 487 */       this._events != null && 
/* 488 */       postEventsForChanges()) {
/* 489 */       this._events.post(IReceiptText.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 496 */     boolean ev_postable = false;
/*     */     
/* 498 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 499 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 500 */       getDAO_().setExpirationDate(argExpirationDate);
/* 501 */       ev_postable = true;
/*     */     } 
/*     */     
/* 504 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineFormat() {
/* 512 */     return getDAO_().getLineFormat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineFormat(String argLineFormat) {
/* 520 */     if (setLineFormat_noev(argLineFormat) && 
/* 521 */       this._events != null && 
/* 522 */       postEventsForChanges()) {
/* 523 */       this._events.post(IReceiptText.SET_LINEFORMAT, argLineFormat);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineFormat_noev(String argLineFormat) {
/* 530 */     boolean ev_postable = false;
/*     */     
/* 532 */     if ((getDAO_().getLineFormat() == null && argLineFormat != null) || (
/* 533 */       getDAO_().getLineFormat() != null && !getDAO_().getLineFormat().equals(argLineFormat))) {
/* 534 */       getDAO_().setLineFormat(argLineFormat);
/* 535 */       ev_postable = true;
/*     */     } 
/*     */     
/* 538 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getReformat() {
/* 546 */     if (getDAO_().getReformat() != null) {
/* 547 */       return getDAO_().getReformat().booleanValue();
/*     */     }
/*     */     
/* 550 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReformat(boolean argReformat) {
/* 559 */     if (setReformat_noev(argReformat) && 
/* 560 */       this._events != null && 
/* 561 */       postEventsForChanges()) {
/* 562 */       this._events.post(IReceiptText.SET_REFORMAT, Boolean.valueOf(argReformat));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReformat_noev(boolean argReformat) {
/* 569 */     boolean ev_postable = false;
/*     */     
/* 571 */     if ((getDAO_().getReformat() == null && Boolean.valueOf(argReformat) != null) || (
/* 572 */       getDAO_().getReformat() != null && !getDAO_().getReformat().equals(Boolean.valueOf(argReformat)))) {
/* 573 */       getDAO_().setReformat(Boolean.valueOf(argReformat));
/* 574 */       ev_postable = true;
/*     */     } 
/*     */     
/* 577 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReceiptTextProperty newProperty(String argPropertyName) {
/* 581 */     ReceiptTextPropertyId id = new ReceiptTextPropertyId();
/*     */     
/* 583 */     id.setTextCode(getTextCode());
/* 584 */     id.setTextSequence(Integer.valueOf(getTextSequence()));
/* 585 */     id.setTextSubcode(getTextSubcode());
/* 586 */     id.setConfigElement(getConfigElement());
/* 587 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 589 */     IReceiptTextProperty prop = (IReceiptTextProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReceiptTextProperty.class);
/* 590 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReceiptTextProperty> getProperties() {
/* 599 */     if (this._properties == null) {
/* 600 */       this._properties = new HistoricalList(null);
/*     */     }
/* 602 */     return (List<IReceiptTextProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReceiptTextProperty> argProperties) {
/* 606 */     if (this._properties == null) {
/* 607 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 609 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 612 */     for (IReceiptTextProperty child : this._properties) {
/* 613 */       ReceiptTextPropertyModel model = (ReceiptTextPropertyModel)child;
/* 614 */       model.setOrganizationId_noev(getOrganizationId());
/* 615 */       model.setTextCode_noev(getTextCode());
/* 616 */       model.setTextSequence_noev(getTextSequence());
/* 617 */       model.setTextSubcode_noev(getTextSubcode());
/* 618 */       model.setConfigElement_noev(getConfigElement());
/* 619 */       if (child instanceof IDataModelImpl) {
/* 620 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 621 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 622 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 623 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 626 */       if (postEventsForChanges()) {
/* 627 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReceiptTextProperty(IReceiptTextProperty argReceiptTextProperty) {
/* 633 */     if (this._properties == null) {
/* 634 */       this._properties = new HistoricalList(null);
/*     */     }
/* 636 */     argReceiptTextProperty.setOrganizationId(getOrganizationId());
/* 637 */     argReceiptTextProperty.setTextCode(getTextCode());
/* 638 */     argReceiptTextProperty.setTextSequence(getTextSequence());
/* 639 */     argReceiptTextProperty.setTextSubcode(getTextSubcode());
/* 640 */     argReceiptTextProperty.setConfigElement(getConfigElement());
/* 641 */     if (argReceiptTextProperty instanceof IDataModelImpl) {
/* 642 */       IDataAccessObject childDao = ((IDataModelImpl)argReceiptTextProperty).getDAO();
/* 643 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 644 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 645 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 650 */     if (postEventsForChanges()) {
/* 651 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReceiptTextProperty));
/*     */     }
/*     */     
/* 654 */     this._properties.add(argReceiptTextProperty);
/* 655 */     if (postEventsForChanges()) {
/* 656 */       this._events.post(IReceiptText.ADD_PROPERTIES, argReceiptTextProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReceiptTextProperty(IReceiptTextProperty argReceiptTextProperty) {
/* 661 */     if (this._properties != null) {
/*     */       
/* 663 */       if (postEventsForChanges()) {
/* 664 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReceiptTextProperty));
/*     */       }
/* 666 */       this._properties.remove(argReceiptTextProperty);
/* 667 */       if (postEventsForChanges()) {
/* 668 */         this._events.post(IReceiptText.REMOVE_PROPERTIES, argReceiptTextProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 675 */     if ("Properties".equals(argFieldId)) {
/* 676 */       return getProperties();
/*     */     }
/* 678 */     if ("ReceiptTextExtension".equals(argFieldId)) {
/* 679 */       return this._myExtension;
/*     */     }
/*     */     
/* 682 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 688 */     if ("Properties".equals(argFieldId)) {
/* 689 */       setProperties(changeToList(argValue, IReceiptTextProperty.class));
/*     */     }
/* 691 */     else if ("ReceiptTextExtension".equals(argFieldId)) {
/* 692 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 695 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 701 */     this._persistenceDefaults = argPD;
/* 702 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 703 */     this._eventManager = argEM;
/* 704 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 705 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 706 */     if (this._properties != null) {
/* 707 */       for (IReceiptTextProperty relationship : this._properties) {
/* 708 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReceiptTextExt() {
/* 714 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReceiptTextExt(IDataModel argExt) {
/* 718 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 723 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 727 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 730 */     super.startTransaction();
/*     */     
/* 732 */     this._propertiesSavepoint = this._properties;
/* 733 */     if (this._properties != null) {
/* 734 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 735 */       Iterator<IDataModel> it = this._properties.iterator();
/* 736 */       while (it.hasNext()) {
/* 737 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 742 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 747 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 750 */     super.rollbackChanges();
/*     */     
/* 752 */     this._properties = this._propertiesSavepoint;
/* 753 */     this._propertiesSavepoint = null;
/* 754 */     if (this._properties != null) {
/* 755 */       Iterator<IDataModel> it = this._properties.iterator();
/* 756 */       while (it.hasNext()) {
/* 757 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 765 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 768 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 771 */     super.commitTransaction();
/*     */     
/* 773 */     this._propertiesSavepoint = this._properties;
/* 774 */     if (this._properties != null) {
/* 775 */       Iterator<IDataModel> it = this._properties.iterator();
/* 776 */       while (it.hasNext()) {
/* 777 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 779 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 783 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 788 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReceiptTextModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */