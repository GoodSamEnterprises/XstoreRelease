/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ import dtv.xst.dao.ttr.IVoucher;
/*     */ import dtv.xst.dao.ttr.IVoucherProperty;
/*     */ import dtv.xst.dao.ttr.VoucherPropertyId;
/*     */ import dtv.xst.daocommon.ExchangeRateHelper;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class VoucherModel extends AbstractDataModelWithPropertyImpl<IVoucherProperty> implements IVoucher {
/*     */   private static final long serialVersionUID = -1990121842L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IVoucherProperty> _properties; private transient HistoricalList<IVoucherProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new VoucherDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private VoucherDAO getDAO_() {
/*  46 */     return (VoucherDAO)this._daoImpl;
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
/*  70 */       this._events.post(IVoucher.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<VoucherPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((VoucherPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getSerialNumber() {
/* 101 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 109 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IVoucher.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 122 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 123 */       getDAO_().setSerialNumber(argSerialNumber);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<VoucherPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((VoucherPropertyModel)it.next()).setSerialNumber_noev(argSerialNumber);
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
/*     */   public String getVoucherTypeCode() {
/* 143 */     return getDAO_().getVoucherTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/* 151 */     if (setVoucherTypeCode_noev(argVoucherTypeCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IVoucher.SET_VOUCHERTYPECODE, argVoucherTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoucherTypeCode_noev(String argVoucherTypeCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getVoucherTypeCode() == null && argVoucherTypeCode != null) || (
/* 164 */       getDAO_().getVoucherTypeCode() != null && !getDAO_().getVoucherTypeCode().equals(argVoucherTypeCode))) {
/* 165 */       getDAO_().setVoucherTypeCode(argVoucherTypeCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<VoucherPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((VoucherPropertyModel)it.next()).setVoucherTypeCode_noev(argVoucherTypeCode);
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
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IVoucher.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IVoucher.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IVoucher.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IVoucher.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 321 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 329 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IVoucher.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 342 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 343 */       getDAO_().setEffectiveDate(argEffectiveDate);
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
/*     */   public Date getExpirationDate() {
/* 355 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 363 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IVoucher.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 376 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 377 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*     */   protected BigDecimal getFaceValueAmountImpl() {
/* 389 */     return getDAO_().getFaceValueAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setFaceValueAmountImpl(BigDecimal argFaceValueAmount) {
/* 397 */     if (setFaceValueAmount_noev(argFaceValueAmount) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IVoucher.SET_FACEVALUEAMOUNT, argFaceValueAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFaceValueAmount_noev(BigDecimal argFaceValueAmount) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getFaceValueAmount() == null && argFaceValueAmount != null) || (
/* 410 */       getDAO_().getFaceValueAmount() != null && !getDAO_().getFaceValueAmount().equals(argFaceValueAmount))) {
/* 411 */       getDAO_().setFaceValueAmount(argFaceValueAmount);
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
/*     */   public Date getIssueDatetimestamp() {
/* 423 */     return getDAO_().getIssueDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 431 */     if (setIssueDatetimestamp_noev(argIssueDatetimestamp) && 
/* 432 */       this._events != null && 
/* 433 */       postEventsForChanges()) {
/* 434 */       this._events.post(IVoucher.SET_ISSUEDATETIMESTAMP, argIssueDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIssueDatetimestamp_noev(Date argIssueDatetimestamp) {
/* 441 */     boolean ev_postable = false;
/*     */     
/* 443 */     if ((getDAO_().getIssueDatetimestamp() == null && argIssueDatetimestamp != null) || (
/* 444 */       getDAO_().getIssueDatetimestamp() != null && !getDAO_().getIssueDatetimestamp().equals(argIssueDatetimestamp))) {
/* 445 */       getDAO_().setIssueDatetimestamp(argIssueDatetimestamp);
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
/*     */   public String getIssueTypeCode() {
/* 457 */     return getDAO_().getIssueTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 465 */     if (setIssueTypeCode_noev(argIssueTypeCode) && 
/* 466 */       this._events != null && 
/* 467 */       postEventsForChanges()) {
/* 468 */       this._events.post(IVoucher.SET_ISSUETYPECODE, argIssueTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIssueTypeCode_noev(String argIssueTypeCode) {
/* 475 */     boolean ev_postable = false;
/*     */     
/* 477 */     if ((getDAO_().getIssueTypeCode() == null && argIssueTypeCode != null) || (
/* 478 */       getDAO_().getIssueTypeCode() != null && !getDAO_().getIssueTypeCode().equals(argIssueTypeCode))) {
/* 479 */       getDAO_().setIssueTypeCode(argIssueTypeCode);
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
/*     */   protected BigDecimal getUnspentBalanceAmountImpl() {
/* 491 */     return getDAO_().getUnspentBalanceAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setUnspentBalanceAmountImpl(BigDecimal argUnspentBalanceAmount) {
/* 499 */     if (setUnspentBalanceAmount_noev(argUnspentBalanceAmount) && 
/* 500 */       this._events != null && 
/* 501 */       postEventsForChanges()) {
/* 502 */       this._events.post(IVoucher.SET_UNSPENTBALANCEAMOUNT, argUnspentBalanceAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUnspentBalanceAmount_noev(BigDecimal argUnspentBalanceAmount) {
/* 509 */     boolean ev_postable = false;
/*     */     
/* 511 */     if ((getDAO_().getUnspentBalanceAmount() == null && argUnspentBalanceAmount != null) || (
/* 512 */       getDAO_().getUnspentBalanceAmount() != null && !getDAO_().getUnspentBalanceAmount().equals(argUnspentBalanceAmount))) {
/* 513 */       getDAO_().setUnspentBalanceAmount(argUnspentBalanceAmount);
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
/*     */   public String getVoucherStatusCode() {
/* 525 */     return getDAO_().getVoucherStatusCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 533 */     if (setVoucherStatusCode_noev(argVoucherStatusCode) && 
/* 534 */       this._events != null && 
/* 535 */       postEventsForChanges()) {
/* 536 */       this._events.post(IVoucher.SET_VOUCHERSTATUSCODE, argVoucherStatusCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoucherStatusCode_noev(String argVoucherStatusCode) {
/* 543 */     boolean ev_postable = false;
/*     */     
/* 545 */     if ((getDAO_().getVoucherStatusCode() == null && argVoucherStatusCode != null) || (
/* 546 */       getDAO_().getVoucherStatusCode() != null && !getDAO_().getVoucherStatusCode().equals(argVoucherStatusCode))) {
/* 547 */       getDAO_().setVoucherStatusCode(argVoucherStatusCode);
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
/*     */   protected String getCurrencyIdImpl() {
/* 559 */     return getDAO_().getCurrencyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 567 */     if (setCurrencyId_noev(argCurrencyId) && 
/* 568 */       this._events != null && 
/* 569 */       postEventsForChanges()) {
/* 570 */       this._events.post(IVoucher.SET_CURRENCYID, argCurrencyId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCurrencyId_noev(String argCurrencyId) {
/* 577 */     boolean ev_postable = false;
/*     */     
/* 579 */     if ((getDAO_().getCurrencyId() == null && argCurrencyId != null) || (
/* 580 */       getDAO_().getCurrencyId() != null && !getDAO_().getCurrencyId().equals(argCurrencyId))) {
/* 581 */       getDAO_().setCurrencyId(argCurrencyId);
/* 582 */       ev_postable = true;
/*     */     } 
/*     */     
/* 585 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IVoucherProperty newProperty(String argPropertyName) {
/* 589 */     VoucherPropertyId id = new VoucherPropertyId();
/*     */     
/* 591 */     id.setSerialNumber(getSerialNumber());
/* 592 */     id.setVoucherTypeCode(getVoucherTypeCode());
/* 593 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 595 */     IVoucherProperty prop = (IVoucherProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IVoucherProperty.class);
/* 596 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IVoucherProperty> getProperties() {
/* 605 */     if (this._properties == null) {
/* 606 */       this._properties = new HistoricalList(null);
/*     */     }
/* 608 */     return (List<IVoucherProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IVoucherProperty> argProperties) {
/* 612 */     if (this._properties == null) {
/* 613 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 615 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 618 */     for (IVoucherProperty child : this._properties) {
/* 619 */       VoucherPropertyModel model = (VoucherPropertyModel)child;
/* 620 */       model.setOrganizationId_noev(getOrganizationId());
/* 621 */       model.setSerialNumber_noev(getSerialNumber());
/* 622 */       model.setVoucherTypeCode_noev(getVoucherTypeCode());
/* 623 */       if (child instanceof IDataModelImpl) {
/* 624 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 625 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 626 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 627 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 630 */       if (postEventsForChanges()) {
/* 631 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addVoucherProperty(IVoucherProperty argVoucherProperty) {
/* 637 */     if (this._properties == null) {
/* 638 */       this._properties = new HistoricalList(null);
/*     */     }
/* 640 */     argVoucherProperty.setOrganizationId(getOrganizationId());
/* 641 */     argVoucherProperty.setSerialNumber(getSerialNumber());
/* 642 */     argVoucherProperty.setVoucherTypeCode(getVoucherTypeCode());
/* 643 */     if (argVoucherProperty instanceof IDataModelImpl) {
/* 644 */       IDataAccessObject childDao = ((IDataModelImpl)argVoucherProperty).getDAO();
/* 645 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 646 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 647 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 652 */     if (postEventsForChanges()) {
/* 653 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoucherProperty));
/*     */     }
/*     */     
/* 656 */     this._properties.add(argVoucherProperty);
/* 657 */     if (postEventsForChanges()) {
/* 658 */       this._events.post(IVoucher.ADD_PROPERTIES, argVoucherProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeVoucherProperty(IVoucherProperty argVoucherProperty) {
/* 663 */     if (this._properties != null) {
/*     */       
/* 665 */       if (postEventsForChanges()) {
/* 666 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoucherProperty));
/*     */       }
/* 668 */       this._properties.remove(argVoucherProperty);
/* 669 */       if (postEventsForChanges()) {
/* 670 */         this._events.post(IVoucher.REMOVE_PROPERTIES, argVoucherProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 677 */     if ("Properties".equals(argFieldId)) {
/* 678 */       return getProperties();
/*     */     }
/* 680 */     if ("VoucherExtension".equals(argFieldId)) {
/* 681 */       return this._myExtension;
/*     */     }
/*     */     
/* 684 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 690 */     if ("Properties".equals(argFieldId)) {
/* 691 */       setProperties(changeToList(argValue, IVoucherProperty.class));
/*     */     }
/* 693 */     else if ("VoucherExtension".equals(argFieldId)) {
/* 694 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 697 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 703 */     this._persistenceDefaults = argPD;
/* 704 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 705 */     this._eventManager = argEM;
/* 706 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 707 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 708 */     if (this._properties != null) {
/* 709 */       for (IVoucherProperty relationship : this._properties) {
/* 710 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getVoucherExt() {
/* 716 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setVoucherExt(IDataModel argExt) {
/* 720 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 725 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 729 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 732 */     super.startTransaction();
/*     */     
/* 734 */     this._propertiesSavepoint = this._properties;
/* 735 */     if (this._properties != null) {
/* 736 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 737 */       Iterator<IDataModel> it = this._properties.iterator();
/* 738 */       while (it.hasNext()) {
/* 739 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 744 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 749 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 752 */     super.rollbackChanges();
/*     */     
/* 754 */     this._properties = this._propertiesSavepoint;
/* 755 */     this._propertiesSavepoint = null;
/* 756 */     if (this._properties != null) {
/* 757 */       Iterator<IDataModel> it = this._properties.iterator();
/* 758 */       while (it.hasNext()) {
/* 759 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 767 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 770 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 773 */     super.commitTransaction();
/*     */     
/* 775 */     this._propertiesSavepoint = this._properties;
/* 776 */     if (this._properties != null) {
/* 777 */       Iterator<IDataModel> it = this._properties.iterator();
/* 778 */       while (it.hasNext()) {
/* 779 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 781 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */     
/* 784 */     getDAO_().setInitUnspentBalanceAmount(getUnspentBalanceAmount());
/*     */     
/* 786 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 791 */     argStream.defaultReadObject();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrencyId() {
/* 811 */     if (getDAO_().getCurrencyId() == null) {
/* 812 */       getDAO_().setCurrencyId(getPersistenceDefaults().getCurrencyId());
/*     */     }
/*     */     
/* 815 */     return getDAO_().getCurrencyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getFaceValueAmount() {
/* 822 */     return ExchangeRateHelper.getLocalizedAmount(getFaceValueAmountImpl(), getCurrencyId(), getPersistenceDefaults().getCurrencyId(), this._persistenceDefaults.getRetailLocationId().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFaceValueAmount(BigDecimal argAmount) {
/* 829 */     BigDecimal relativeAmount = ExchangeRateHelper.getRelativeAmount(argAmount, getCurrencyId(), getPersistenceDefaults().getCurrencyId(), this._persistenceDefaults.getRetailLocationId().intValue());
/* 830 */     setFaceValueAmountImpl(relativeAmount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getUnspentBalanceAmount() {
/* 837 */     return ExchangeRateHelper.getLocalizedAmount(getUnspentBalanceAmountImpl(), getCurrencyId(), getPersistenceDefaults().getCurrencyId(), this._persistenceDefaults.getRetailLocationId().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnspentBalanceAmount(BigDecimal argAmount) {
/* 844 */     BigDecimal relativeAmount = ExchangeRateHelper.getRelativeAmount(argAmount, getCurrencyId(), getPersistenceDefaults().getCurrencyId(), this._persistenceDefaults.getRetailLocationId().intValue());
/* 845 */     setUnspentBalanceAmountImpl(relativeAmount);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */