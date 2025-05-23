/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IWarrantyItemPrice;
/*     */ import dtv.xst.dao.itm.IWarrantyItemPriceProperty;
/*     */ import dtv.xst.dao.itm.WarrantyItemPricePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WarrantyItemPriceModel extends AbstractDataModelWithPropertyImpl<IWarrantyItemPriceProperty> implements IWarrantyItemPrice {
/*     */   private static final long serialVersionUID = 231273530L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IWarrantyItemPriceProperty> _properties; private transient HistoricalList<IWarrantyItemPriceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new WarrantyItemPriceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WarrantyItemPriceDAO getDAO_() {
/*  46 */     return (WarrantyItemPriceDAO)this._daoImpl;
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
/*  70 */       this._events.post(IWarrantyItemPrice.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<WarrantyItemPricePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((WarrantyItemPricePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 101 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 109 */     if (setItemId_noev(argItemId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IWarrantyItemPrice.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 122 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 123 */       getDAO_().setItemId(argItemId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<WarrantyItemPricePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((WarrantyItemPricePropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public long getWarrantyPriceSeq() {
/* 143 */     if (getDAO_().getWarrantyPriceSeq() != null) {
/* 144 */       return getDAO_().getWarrantyPriceSeq().longValue();
/*     */     }
/*     */     
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyPriceSeq(long argWarrantyPriceSeq) {
/* 156 */     if (setWarrantyPriceSeq_noev(argWarrantyPriceSeq) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IWarrantyItemPrice.SET_WARRANTYPRICESEQ, Long.valueOf(argWarrantyPriceSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyPriceSeq_noev(long argWarrantyPriceSeq) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getWarrantyPriceSeq() == null && Long.valueOf(argWarrantyPriceSeq) != null) || (
/* 169 */       getDAO_().getWarrantyPriceSeq() != null && !getDAO_().getWarrantyPriceSeq().equals(Long.valueOf(argWarrantyPriceSeq)))) {
/* 170 */       getDAO_().setWarrantyPriceSeq(Long.valueOf(argWarrantyPriceSeq));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<WarrantyItemPricePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((WarrantyItemPricePropertyModel)it.next()).setWarrantyPriceSeq_noev(argWarrantyPriceSeq);
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
/*     */   public String getOrgCode() {
/* 190 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 198 */     if (setOrgCode_noev(argOrgCode) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IWarrantyItemPrice.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 211 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 212 */       getDAO_().setOrgCode(argOrgCode);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 224 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 232 */     if (setOrgValue_noev(argOrgValue) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IWarrantyItemPrice.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 245 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 246 */       getDAO_().setOrgValue(argOrgValue);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 258 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 266 */     if (setCreateDate_noev(argCreateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IWarrantyItemPrice.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 279 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 280 */       getDAO_().setCreateDate(argCreateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 292 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 300 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IWarrantyItemPrice.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 313 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 314 */       getDAO_().setCreateUserId(argCreateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 326 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 334 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IWarrantyItemPrice.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 347 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 348 */       getDAO_().setUpdateDate(argUpdateDate);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 360 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 368 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IWarrantyItemPrice.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 381 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 382 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMinItemPriceAmt() {
/* 394 */     return getDAO_().getMinItemPriceAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinItemPriceAmt(BigDecimal argMinItemPriceAmt) {
/* 402 */     if (setMinItemPriceAmt_noev(argMinItemPriceAmt) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IWarrantyItemPrice.SET_MINITEMPRICEAMT, argMinItemPriceAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinItemPriceAmt_noev(BigDecimal argMinItemPriceAmt) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getMinItemPriceAmt() == null && argMinItemPriceAmt != null) || (
/* 415 */       getDAO_().getMinItemPriceAmt() != null && !getDAO_().getMinItemPriceAmt().equals(argMinItemPriceAmt))) {
/* 416 */       getDAO_().setMinItemPriceAmt(argMinItemPriceAmt);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaxItemPriceAmt() {
/* 428 */     return getDAO_().getMaxItemPriceAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxItemPriceAmt(BigDecimal argMaxItemPriceAmt) {
/* 436 */     if (setMaxItemPriceAmt_noev(argMaxItemPriceAmt) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IWarrantyItemPrice.SET_MAXITEMPRICEAMT, argMaxItemPriceAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxItemPriceAmt_noev(BigDecimal argMaxItemPriceAmt) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getMaxItemPriceAmt() == null && argMaxItemPriceAmt != null) || (
/* 449 */       getDAO_().getMaxItemPriceAmt() != null && !getDAO_().getMaxItemPriceAmt().equals(argMaxItemPriceAmt))) {
/* 450 */       getDAO_().setMaxItemPriceAmt(argMaxItemPriceAmt);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPriceAmt() {
/* 462 */     return getDAO_().getPriceAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriceAmt(BigDecimal argPriceAmt) {
/* 470 */     if (setPriceAmt_noev(argPriceAmt) && 
/* 471 */       this._events != null && 
/* 472 */       postEventsForChanges()) {
/* 473 */       this._events.post(IWarrantyItemPrice.SET_PRICEAMT, argPriceAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriceAmt_noev(BigDecimal argPriceAmt) {
/* 480 */     boolean ev_postable = false;
/*     */     
/* 482 */     if ((getDAO_().getPriceAmt() == null && argPriceAmt != null) || (
/* 483 */       getDAO_().getPriceAmt() != null && !getDAO_().getPriceAmt().equals(argPriceAmt))) {
/* 484 */       getDAO_().setPriceAmt(argPriceAmt);
/* 485 */       ev_postable = true;
/*     */     } 
/*     */     
/* 488 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPricePercentage() {
/* 496 */     return getDAO_().getPricePercentage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPricePercentage(BigDecimal argPricePercentage) {
/* 504 */     if (setPricePercentage_noev(argPricePercentage) && 
/* 505 */       this._events != null && 
/* 506 */       postEventsForChanges()) {
/* 507 */       this._events.post(IWarrantyItemPrice.SET_PRICEPERCENTAGE, argPricePercentage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPricePercentage_noev(BigDecimal argPricePercentage) {
/* 514 */     boolean ev_postable = false;
/*     */     
/* 516 */     if ((getDAO_().getPricePercentage() == null && argPricePercentage != null) || (
/* 517 */       getDAO_().getPricePercentage() != null && !getDAO_().getPricePercentage().equals(argPricePercentage))) {
/* 518 */       getDAO_().setPricePercentage(argPricePercentage);
/* 519 */       ev_postable = true;
/*     */     } 
/*     */     
/* 522 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMinPriceAmt() {
/* 530 */     return getDAO_().getMinPriceAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinPriceAmt(BigDecimal argMinPriceAmt) {
/* 538 */     if (setMinPriceAmt_noev(argMinPriceAmt) && 
/* 539 */       this._events != null && 
/* 540 */       postEventsForChanges()) {
/* 541 */       this._events.post(IWarrantyItemPrice.SET_MINPRICEAMT, argMinPriceAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinPriceAmt_noev(BigDecimal argMinPriceAmt) {
/* 548 */     boolean ev_postable = false;
/*     */     
/* 550 */     if ((getDAO_().getMinPriceAmt() == null && argMinPriceAmt != null) || (
/* 551 */       getDAO_().getMinPriceAmt() != null && !getDAO_().getMinPriceAmt().equals(argMinPriceAmt))) {
/* 552 */       getDAO_().setMinPriceAmt(argMinPriceAmt);
/* 553 */       ev_postable = true;
/*     */     } 
/*     */     
/* 556 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRefItemId() {
/* 564 */     return getDAO_().getRefItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRefItemId(String argRefItemId) {
/* 572 */     if (setRefItemId_noev(argRefItemId) && 
/* 573 */       this._events != null && 
/* 574 */       postEventsForChanges()) {
/* 575 */       this._events.post(IWarrantyItemPrice.SET_REFITEMID, argRefItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRefItemId_noev(String argRefItemId) {
/* 582 */     boolean ev_postable = false;
/*     */     
/* 584 */     if ((getDAO_().getRefItemId() == null && argRefItemId != null) || (
/* 585 */       getDAO_().getRefItemId() != null && !getDAO_().getRefItemId().equals(argRefItemId))) {
/* 586 */       getDAO_().setRefItemId(argRefItemId);
/* 587 */       ev_postable = true;
/*     */     } 
/*     */     
/* 590 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWarrantyItemPriceProperty newProperty(String argPropertyName) {
/* 594 */     WarrantyItemPricePropertyId id = new WarrantyItemPricePropertyId();
/*     */     
/* 596 */     id.setItemId(getItemId());
/* 597 */     id.setWarrantyPriceSeq(Long.valueOf(getWarrantyPriceSeq()));
/* 598 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 600 */     IWarrantyItemPriceProperty prop = (IWarrantyItemPriceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWarrantyItemPriceProperty.class);
/* 601 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWarrantyItemPriceProperty> getProperties() {
/* 610 */     if (this._properties == null) {
/* 611 */       this._properties = new HistoricalList(null);
/*     */     }
/* 613 */     return (List<IWarrantyItemPriceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWarrantyItemPriceProperty> argProperties) {
/* 617 */     if (this._properties == null) {
/* 618 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 620 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 623 */     for (IWarrantyItemPriceProperty child : this._properties) {
/* 624 */       WarrantyItemPricePropertyModel model = (WarrantyItemPricePropertyModel)child;
/* 625 */       model.setOrganizationId_noev(getOrganizationId());
/* 626 */       model.setItemId_noev(getItemId());
/* 627 */       model.setWarrantyPriceSeq_noev(getWarrantyPriceSeq());
/* 628 */       if (child instanceof IDataModelImpl) {
/* 629 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 630 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 631 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 632 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 635 */       if (postEventsForChanges()) {
/* 636 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWarrantyItemPriceProperty(IWarrantyItemPriceProperty argWarrantyItemPriceProperty) {
/* 642 */     if (this._properties == null) {
/* 643 */       this._properties = new HistoricalList(null);
/*     */     }
/* 645 */     argWarrantyItemPriceProperty.setOrganizationId(getOrganizationId());
/* 646 */     argWarrantyItemPriceProperty.setItemId(getItemId());
/* 647 */     argWarrantyItemPriceProperty.setWarrantyPriceSeq(getWarrantyPriceSeq());
/* 648 */     if (argWarrantyItemPriceProperty instanceof IDataModelImpl) {
/* 649 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyItemPriceProperty).getDAO();
/* 650 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 651 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 652 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 657 */     if (postEventsForChanges()) {
/* 658 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItemPriceProperty));
/*     */     }
/*     */     
/* 661 */     this._properties.add(argWarrantyItemPriceProperty);
/* 662 */     if (postEventsForChanges()) {
/* 663 */       this._events.post(IWarrantyItemPrice.ADD_PROPERTIES, argWarrantyItemPriceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWarrantyItemPriceProperty(IWarrantyItemPriceProperty argWarrantyItemPriceProperty) {
/* 668 */     if (this._properties != null) {
/*     */       
/* 670 */       if (postEventsForChanges()) {
/* 671 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItemPriceProperty));
/*     */       }
/* 673 */       this._properties.remove(argWarrantyItemPriceProperty);
/* 674 */       if (postEventsForChanges()) {
/* 675 */         this._events.post(IWarrantyItemPrice.REMOVE_PROPERTIES, argWarrantyItemPriceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 682 */     if ("Properties".equals(argFieldId)) {
/* 683 */       return getProperties();
/*     */     }
/* 685 */     if ("WarrantyItemPriceExtension".equals(argFieldId)) {
/* 686 */       return this._myExtension;
/*     */     }
/*     */     
/* 689 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 695 */     if ("Properties".equals(argFieldId)) {
/* 696 */       setProperties(changeToList(argValue, IWarrantyItemPriceProperty.class));
/*     */     }
/* 698 */     else if ("WarrantyItemPriceExtension".equals(argFieldId)) {
/* 699 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 702 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 708 */     this._persistenceDefaults = argPD;
/* 709 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 710 */     this._eventManager = argEM;
/* 711 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 712 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 713 */     if (this._properties != null) {
/* 714 */       for (IWarrantyItemPriceProperty relationship : this._properties) {
/* 715 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWarrantyItemPriceExt() {
/* 721 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemPriceExt(IDataModel argExt) {
/* 725 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 730 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 734 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 737 */     super.startTransaction();
/*     */     
/* 739 */     this._propertiesSavepoint = this._properties;
/* 740 */     if (this._properties != null) {
/* 741 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 742 */       Iterator<IDataModel> it = this._properties.iterator();
/* 743 */       while (it.hasNext()) {
/* 744 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 749 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 754 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 757 */     super.rollbackChanges();
/*     */     
/* 759 */     this._properties = this._propertiesSavepoint;
/* 760 */     this._propertiesSavepoint = null;
/* 761 */     if (this._properties != null) {
/* 762 */       Iterator<IDataModel> it = this._properties.iterator();
/* 763 */       while (it.hasNext()) {
/* 764 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 772 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 775 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 778 */     super.commitTransaction();
/*     */     
/* 780 */     this._propertiesSavepoint = this._properties;
/* 781 */     if (this._properties != null) {
/* 782 */       Iterator<IDataModel> it = this._properties.iterator();
/* 783 */       while (it.hasNext()) {
/* 784 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 786 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 790 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 795 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemPriceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */