/*     */ package dtv.xst.dao.prc.impl;
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
/*     */ import dtv.xst.dao.prc.DealFieldTestPropertyId;
/*     */ import dtv.xst.dao.prc.IDealFieldTest;
/*     */ import dtv.xst.dao.prc.IDealFieldTestProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DealFieldTestModel extends AbstractDataModelWithPropertyImpl<IDealFieldTestProperty> implements IDealFieldTest {
/*     */   private static final long serialVersionUID = -1604134528L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDealFieldTestProperty> _properties; private transient HistoricalList<IDealFieldTestProperty> _propertiesSavepoint; private static final String ITEM_FIELD_SEPARATOR = ":";
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DealFieldTestDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DealFieldTestDAO getDAO_() {
/*  46 */     return (DealFieldTestDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDealFieldTest.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DealFieldTestPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DealFieldTestPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getDealId() {
/* 101 */     return getDAO_().getDealId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 109 */     if (setDealId_noev(argDealId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDealFieldTest.SET_DEALID, argDealId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDealId_noev(String argDealId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/* 122 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/* 123 */       getDAO_().setDealId(argDealId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DealFieldTestPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DealFieldTestPropertyModel)it.next()).setDealId_noev(argDealId);
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
/*     */   public int getOrdinal() {
/* 143 */     if (getDAO_().getOrdinal() != null) {
/* 144 */       return getDAO_().getOrdinal().intValue();
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
/*     */   public void setOrdinal(int argOrdinal) {
/* 156 */     if (setOrdinal_noev(argOrdinal) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IDealFieldTest.SET_ORDINAL, Integer.valueOf(argOrdinal));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrdinal_noev(int argOrdinal) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getOrdinal() == null && Integer.valueOf(argOrdinal) != null) || (
/* 169 */       getDAO_().getOrdinal() != null && !getDAO_().getOrdinal().equals(Integer.valueOf(argOrdinal)))) {
/* 170 */       getDAO_().setOrdinal(Integer.valueOf(argOrdinal));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<DealFieldTestPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((DealFieldTestPropertyModel)it.next()).setOrdinal_noev(argOrdinal);
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
/*     */   public int getItemConditionGroup() {
/* 190 */     if (getDAO_().getItemConditionGroup() != null) {
/* 191 */       return getDAO_().getItemConditionGroup().intValue();
/*     */     }
/*     */     
/* 194 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemConditionGroup(int argItemConditionGroup) {
/* 203 */     if (setItemConditionGroup_noev(argItemConditionGroup) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IDealFieldTest.SET_ITEMCONDITIONGROUP, Integer.valueOf(argItemConditionGroup));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemConditionGroup_noev(int argItemConditionGroup) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getItemConditionGroup() == null && Integer.valueOf(argItemConditionGroup) != null) || (
/* 216 */       getDAO_().getItemConditionGroup() != null && !getDAO_().getItemConditionGroup().equals(Integer.valueOf(argItemConditionGroup)))) {
/* 217 */       getDAO_().setItemConditionGroup(Integer.valueOf(argItemConditionGroup));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<DealFieldTestPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((DealFieldTestPropertyModel)it.next()).setItemConditionGroup_noev(argItemConditionGroup);
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
/*     */   public int getItemConditionSeq() {
/* 237 */     if (getDAO_().getItemConditionSeq() != null) {
/* 238 */       return getDAO_().getItemConditionSeq().intValue();
/*     */     }
/*     */     
/* 241 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemConditionSeq(int argItemConditionSeq) {
/* 250 */     if (setItemConditionSeq_noev(argItemConditionSeq) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IDealFieldTest.SET_ITEMCONDITIONSEQ, Integer.valueOf(argItemConditionSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemConditionSeq_noev(int argItemConditionSeq) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getItemConditionSeq() == null && Integer.valueOf(argItemConditionSeq) != null) || (
/* 263 */       getDAO_().getItemConditionSeq() != null && !getDAO_().getItemConditionSeq().equals(Integer.valueOf(argItemConditionSeq)))) {
/* 264 */       getDAO_().setItemConditionSeq(Integer.valueOf(argItemConditionSeq));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<DealFieldTestPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((DealFieldTestPropertyModel)it.next()).setItemConditionSeq_noev(argItemConditionSeq);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 284 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 292 */     if (setOrgCode_noev(argOrgCode) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IDealFieldTest.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 305 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 306 */       getDAO_().setOrgCode(argOrgCode);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 318 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 326 */     if (setOrgValue_noev(argOrgValue) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IDealFieldTest.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 339 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 340 */       getDAO_().setOrgValue(argOrgValue);
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 352 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 360 */     if (setCreateDate_noev(argCreateDate) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IDealFieldTest.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 373 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 374 */       getDAO_().setCreateDate(argCreateDate);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 386 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 394 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(IDealFieldTest.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 407 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 408 */       getDAO_().setCreateUserId(argCreateUserId);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 420 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 428 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(IDealFieldTest.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 441 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 442 */       getDAO_().setUpdateDate(argUpdateDate);
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 454 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 462 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(IDealFieldTest.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 475 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 476 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getField() {
/* 488 */     return getDAO_().getField();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(String argField) {
/* 496 */     if (setField_noev(argField) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(IDealFieldTest.SET_FIELD, argField);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setField_noev(String argField) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getField() == null && argField != null) || (
/* 509 */       getDAO_().getField() != null && !getDAO_().getField().equals(argField))) {
/* 510 */       getDAO_().setField(argField);
/* 511 */       ev_postable = true;
/*     */     } 
/*     */     
/* 514 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMatchRule() {
/* 522 */     return getDAO_().getMatchRule();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMatchRule(String argMatchRule) {
/* 530 */     if (setMatchRule_noev(argMatchRule) && 
/* 531 */       this._events != null && 
/* 532 */       postEventsForChanges()) {
/* 533 */       this._events.post(IDealFieldTest.SET_MATCHRULE, argMatchRule);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMatchRule_noev(String argMatchRule) {
/* 540 */     boolean ev_postable = false;
/*     */     
/* 542 */     if ((getDAO_().getMatchRule() == null && argMatchRule != null) || (
/* 543 */       getDAO_().getMatchRule() != null && !getDAO_().getMatchRule().equals(argMatchRule))) {
/* 544 */       getDAO_().setMatchRule(argMatchRule);
/* 545 */       ev_postable = true;
/*     */     } 
/*     */     
/* 548 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue1() {
/* 556 */     return getDAO_().getValue1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue1(String argValue1) {
/* 564 */     if (setValue1_noev(argValue1) && 
/* 565 */       this._events != null && 
/* 566 */       postEventsForChanges()) {
/* 567 */       this._events.post(IDealFieldTest.SET_VALUE1, argValue1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValue1_noev(String argValue1) {
/* 574 */     boolean ev_postable = false;
/*     */     
/* 576 */     if ((getDAO_().getValue1() == null && argValue1 != null) || (
/* 577 */       getDAO_().getValue1() != null && !getDAO_().getValue1().equals(argValue1))) {
/* 578 */       getDAO_().setValue1(argValue1);
/* 579 */       ev_postable = true;
/*     */     } 
/*     */     
/* 582 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue2() {
/* 590 */     return getDAO_().getValue2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue2(String argValue2) {
/* 598 */     if (setValue2_noev(argValue2) && 
/* 599 */       this._events != null && 
/* 600 */       postEventsForChanges()) {
/* 601 */       this._events.post(IDealFieldTest.SET_VALUE2, argValue2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValue2_noev(String argValue2) {
/* 608 */     boolean ev_postable = false;
/*     */     
/* 610 */     if ((getDAO_().getValue2() == null && argValue2 != null) || (
/* 611 */       getDAO_().getValue2() != null && !getDAO_().getValue2().equals(argValue2))) {
/* 612 */       getDAO_().setValue2(argValue2);
/* 613 */       ev_postable = true;
/*     */     } 
/*     */     
/* 616 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDealFieldTestProperty newProperty(String argPropertyName) {
/* 620 */     DealFieldTestPropertyId id = new DealFieldTestPropertyId();
/*     */     
/* 622 */     id.setDealId(getDealId());
/* 623 */     id.setOrdinal(Integer.valueOf(getOrdinal()));
/* 624 */     id.setItemConditionGroup(Integer.valueOf(getItemConditionGroup()));
/* 625 */     id.setItemConditionSeq(Integer.valueOf(getItemConditionSeq()));
/* 626 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 628 */     IDealFieldTestProperty prop = (IDealFieldTestProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDealFieldTestProperty.class);
/* 629 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDealFieldTestProperty> getProperties() {
/* 638 */     if (this._properties == null) {
/* 639 */       this._properties = new HistoricalList(null);
/*     */     }
/* 641 */     return (List<IDealFieldTestProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDealFieldTestProperty> argProperties) {
/* 645 */     if (this._properties == null) {
/* 646 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 648 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 651 */     for (IDealFieldTestProperty child : this._properties) {
/* 652 */       DealFieldTestPropertyModel model = (DealFieldTestPropertyModel)child;
/* 653 */       model.setOrganizationId_noev(getOrganizationId());
/* 654 */       model.setDealId_noev(getDealId());
/* 655 */       model.setOrdinal_noev(getOrdinal());
/* 656 */       model.setItemConditionGroup_noev(getItemConditionGroup());
/* 657 */       model.setItemConditionSeq_noev(getItemConditionSeq());
/* 658 */       if (child instanceof IDataModelImpl) {
/* 659 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 660 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 661 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 662 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 665 */       if (postEventsForChanges()) {
/* 666 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDealFieldTestProperty(IDealFieldTestProperty argDealFieldTestProperty) {
/* 672 */     if (this._properties == null) {
/* 673 */       this._properties = new HistoricalList(null);
/*     */     }
/* 675 */     argDealFieldTestProperty.setOrganizationId(getOrganizationId());
/* 676 */     argDealFieldTestProperty.setDealId(getDealId());
/* 677 */     argDealFieldTestProperty.setOrdinal(getOrdinal());
/* 678 */     argDealFieldTestProperty.setItemConditionGroup(getItemConditionGroup());
/* 679 */     argDealFieldTestProperty.setItemConditionSeq(getItemConditionSeq());
/* 680 */     if (argDealFieldTestProperty instanceof IDataModelImpl) {
/* 681 */       IDataAccessObject childDao = ((IDataModelImpl)argDealFieldTestProperty).getDAO();
/* 682 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 683 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 684 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 689 */     if (postEventsForChanges()) {
/* 690 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealFieldTestProperty));
/*     */     }
/*     */     
/* 693 */     this._properties.add(argDealFieldTestProperty);
/* 694 */     if (postEventsForChanges()) {
/* 695 */       this._events.post(IDealFieldTest.ADD_PROPERTIES, argDealFieldTestProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDealFieldTestProperty(IDealFieldTestProperty argDealFieldTestProperty) {
/* 700 */     if (this._properties != null) {
/*     */       
/* 702 */       if (postEventsForChanges()) {
/* 703 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealFieldTestProperty));
/*     */       }
/* 705 */       this._properties.remove(argDealFieldTestProperty);
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._events.post(IDealFieldTest.REMOVE_PROPERTIES, argDealFieldTestProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 714 */     if ("Properties".equals(argFieldId)) {
/* 715 */       return getProperties();
/*     */     }
/* 717 */     if ("DealFieldTestExtension".equals(argFieldId)) {
/* 718 */       return this._myExtension;
/*     */     }
/*     */     
/* 721 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 727 */     if ("Properties".equals(argFieldId)) {
/* 728 */       setProperties(changeToList(argValue, IDealFieldTestProperty.class));
/*     */     }
/* 730 */     else if ("DealFieldTestExtension".equals(argFieldId)) {
/* 731 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 734 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 740 */     this._persistenceDefaults = argPD;
/* 741 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 742 */     this._eventManager = argEM;
/* 743 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 744 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 745 */     if (this._properties != null) {
/* 746 */       for (IDealFieldTestProperty relationship : this._properties) {
/* 747 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDealFieldTestExt() {
/* 753 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDealFieldTestExt(IDataModel argExt) {
/* 757 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 762 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 766 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 769 */     super.startTransaction();
/*     */     
/* 771 */     this._propertiesSavepoint = this._properties;
/* 772 */     if (this._properties != null) {
/* 773 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 774 */       Iterator<IDataModel> it = this._properties.iterator();
/* 775 */       while (it.hasNext()) {
/* 776 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 781 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 786 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 789 */     super.rollbackChanges();
/*     */     
/* 791 */     this._properties = this._propertiesSavepoint;
/* 792 */     this._propertiesSavepoint = null;
/* 793 */     if (this._properties != null) {
/* 794 */       Iterator<IDataModel> it = this._properties.iterator();
/* 795 */       while (it.hasNext()) {
/* 796 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 804 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 807 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 810 */     super.commitTransaction();
/*     */     
/* 812 */     this._propertiesSavepoint = this._properties;
/* 813 */     if (this._properties != null) {
/* 814 */       Iterator<IDataModel> it = this._properties.iterator();
/* 815 */       while (it.hasNext()) {
/* 816 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 818 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 822 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 827 */     argStream.defaultReadObject();
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
/*     */   public String getItemFieldName() {
/* 842 */     String fieldName = getField();
/* 843 */     if (fieldName == null) {
/* 844 */       return null;
/*     */     }
/*     */     
/* 847 */     return fieldName.split(":", 2)[0];
/*     */   }
/*     */   
/*     */   public String getItemFieldParameter() {
/* 851 */     String fieldName = getField();
/* 852 */     if (fieldName == null) {
/* 853 */       return null;
/*     */     }
/*     */     
/* 856 */     String[] fieldParameterPair = fieldName.split(":", 2);
/* 857 */     return (fieldParameterPair.length > 1) ? fieldParameterPair[1] : null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealFieldTestModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */