/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IItemPromptProperty;
/*     */ import dtv.xst.dao.itm.IItemPromptPropertyProperty;
/*     */ import dtv.xst.dao.itm.ItemPromptPropertyPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemPromptPropertyModel extends AbstractDataModelWithPropertyImpl<IItemPromptPropertyProperty> implements IItemPromptProperty {
/*     */   private static final long serialVersionUID = 979737964L;
/*     */   private IItem _parentItem;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IItemPromptPropertyProperty> _properties; private transient HistoricalList<IItemPromptPropertyProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new ItemPromptPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemPromptPropertyDAO getDAO_() {
/*  48 */     return (ItemPromptPropertyDAO)this._daoImpl;
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
/*  72 */       this._events.post(IItemPromptProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<ItemPromptPropertyPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((ItemPromptPropertyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 103 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 111 */     if (setItemId_noev(argItemId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IItemPromptProperty.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 124 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 125 */       getDAO_().setItemId(argItemId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<ItemPromptPropertyPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((ItemPromptPropertyPropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getPromptPropertyCode() {
/* 145 */     return getDAO_().getPromptPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptPropertyCode(String argPromptPropertyCode) {
/* 153 */     if (setPromptPropertyCode_noev(argPromptPropertyCode) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IItemPromptProperty.SET_PROMPTPROPERTYCODE, argPromptPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptPropertyCode_noev(String argPromptPropertyCode) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getPromptPropertyCode() == null && argPromptPropertyCode != null) || (
/* 166 */       getDAO_().getPromptPropertyCode() != null && !getDAO_().getPromptPropertyCode().equals(argPromptPropertyCode))) {
/* 167 */       getDAO_().setPromptPropertyCode(argPromptPropertyCode);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<ItemPromptPropertyPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((ItemPromptPropertyPropertyModel)it.next()).setPromptPropertyCode_noev(argPromptPropertyCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 187 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 195 */     if (setCreateDate_noev(argCreateDate) && 
/* 196 */       this._events != null && 
/* 197 */       postEventsForChanges()) {
/* 198 */       this._events.post(IItemPromptProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 205 */     boolean ev_postable = false;
/*     */     
/* 207 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 208 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 209 */       getDAO_().setCreateDate(argCreateDate);
/* 210 */       ev_postable = true;
/*     */     } 
/*     */     
/* 213 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 221 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 229 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 230 */       this._events != null && 
/* 231 */       postEventsForChanges()) {
/* 232 */       this._events.post(IItemPromptProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 239 */     boolean ev_postable = false;
/*     */     
/* 241 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 242 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 243 */       getDAO_().setCreateUserId(argCreateUserId);
/* 244 */       ev_postable = true;
/*     */     } 
/*     */     
/* 247 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 255 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 263 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(IItemPromptProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 276 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 277 */       getDAO_().setUpdateDate(argUpdateDate);
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 289 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 297 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IItemPromptProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 310 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 311 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 312 */       ev_postable = true;
/*     */     } 
/*     */     
/* 315 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 323 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 331 */     if (setOrgCode_noev(argOrgCode) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(IItemPromptProperty.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 344 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 345 */       getDAO_().setOrgCode(argOrgCode);
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 357 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 365 */     if (setOrgValue_noev(argOrgValue) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(IItemPromptProperty.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 378 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 379 */       getDAO_().setOrgValue(argOrgValue);
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptMethodCode() {
/* 391 */     return getDAO_().getPromptMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptMethodCode(String argPromptMethodCode) {
/* 399 */     if (setPromptMethodCode_noev(argPromptMethodCode) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IItemPromptProperty.SET_PROMPTMETHODCODE, argPromptMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptMethodCode_noev(String argPromptMethodCode) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getPromptMethodCode() == null && argPromptMethodCode != null) || (
/* 412 */       getDAO_().getPromptMethodCode() != null && !getDAO_().getPromptMethodCode().equals(argPromptMethodCode))) {
/* 413 */       getDAO_().setPromptMethodCode(argPromptMethodCode);
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCodeGroup() {
/* 425 */     return getDAO_().getCodeGroup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCodeGroup(String argCodeGroup) {
/* 433 */     if (setCodeGroup_noev(argCodeGroup) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IItemPromptProperty.SET_CODEGROUP, argCodeGroup);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCodeGroup_noev(String argCodeGroup) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getCodeGroup() == null && argCodeGroup != null) || (
/* 446 */       getDAO_().getCodeGroup() != null && !getDAO_().getCodeGroup().equals(argCodeGroup))) {
/* 447 */       getDAO_().setCodeGroup(argCodeGroup);
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptTitleKey() {
/* 459 */     return getDAO_().getPromptTitleKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptTitleKey(String argPromptTitleKey) {
/* 467 */     if (setPromptTitleKey_noev(argPromptTitleKey) && 
/* 468 */       this._events != null && 
/* 469 */       postEventsForChanges()) {
/* 470 */       this._events.post(IItemPromptProperty.SET_PROMPTTITLEKEY, argPromptTitleKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptTitleKey_noev(String argPromptTitleKey) {
/* 477 */     boolean ev_postable = false;
/*     */     
/* 479 */     if ((getDAO_().getPromptTitleKey() == null && argPromptTitleKey != null) || (
/* 480 */       getDAO_().getPromptTitleKey() != null && !getDAO_().getPromptTitleKey().equals(argPromptTitleKey))) {
/* 481 */       getDAO_().setPromptTitleKey(argPromptTitleKey);
/* 482 */       ev_postable = true;
/*     */     } 
/*     */     
/* 485 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptMessageKey() {
/* 493 */     return getDAO_().getPromptMessageKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptMessageKey(String argPromptMessageKey) {
/* 501 */     if (setPromptMessageKey_noev(argPromptMessageKey) && 
/* 502 */       this._events != null && 
/* 503 */       postEventsForChanges()) {
/* 504 */       this._events.post(IItemPromptProperty.SET_PROMPTMESSAGEKEY, argPromptMessageKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptMessageKey_noev(String argPromptMessageKey) {
/* 511 */     boolean ev_postable = false;
/*     */     
/* 513 */     if ((getDAO_().getPromptMessageKey() == null && argPromptMessageKey != null) || (
/* 514 */       getDAO_().getPromptMessageKey() != null && !getDAO_().getPromptMessageKey().equals(argPromptMessageKey))) {
/* 515 */       getDAO_().setPromptMessageKey(argPromptMessageKey);
/* 516 */       ev_postable = true;
/*     */     } 
/*     */     
/* 519 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getRequired() {
/* 527 */     if (getDAO_().getRequired() != null) {
/* 528 */       return getDAO_().getRequired().booleanValue();
/*     */     }
/*     */     
/* 531 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean argRequired) {
/* 540 */     if (setRequired_noev(argRequired) && 
/* 541 */       this._events != null && 
/* 542 */       postEventsForChanges()) {
/* 543 */       this._events.post(IItemPromptProperty.SET_REQUIRED, Boolean.valueOf(argRequired));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRequired_noev(boolean argRequired) {
/* 550 */     boolean ev_postable = false;
/*     */     
/* 552 */     if ((getDAO_().getRequired() == null && Boolean.valueOf(argRequired) != null) || (
/* 553 */       getDAO_().getRequired() != null && !getDAO_().getRequired().equals(Boolean.valueOf(argRequired)))) {
/* 554 */       getDAO_().setRequired(Boolean.valueOf(argRequired));
/* 555 */       ev_postable = true;
/*     */     } 
/*     */     
/* 558 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 566 */     if (getDAO_().getSortOrder() != null) {
/* 567 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 570 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 579 */     if (setSortOrder_noev(argSortOrder) && 
/* 580 */       this._events != null && 
/* 581 */       postEventsForChanges()) {
/* 582 */       this._events.post(IItemPromptProperty.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 589 */     boolean ev_postable = false;
/*     */     
/* 591 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 592 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 593 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 594 */       ev_postable = true;
/*     */     } 
/*     */     
/* 597 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemPromptPropertyProperty newProperty(String argPropertyName) {
/* 601 */     ItemPromptPropertyPropertyId id = new ItemPromptPropertyPropertyId();
/*     */     
/* 603 */     id.setItemId(getItemId());
/* 604 */     id.setPromptPropertyCode(getPromptPropertyCode());
/* 605 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 607 */     IItemPromptPropertyProperty prop = (IItemPromptPropertyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemPromptPropertyProperty.class);
/* 608 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemPromptPropertyProperty> getProperties() {
/* 617 */     if (this._properties == null) {
/* 618 */       this._properties = new HistoricalList(null);
/*     */     }
/* 620 */     return (List<IItemPromptPropertyProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemPromptPropertyProperty> argProperties) {
/* 624 */     if (this._properties == null) {
/* 625 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 627 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 630 */     for (IItemPromptPropertyProperty child : this._properties) {
/* 631 */       ItemPromptPropertyPropertyModel model = (ItemPromptPropertyPropertyModel)child;
/* 632 */       model.setOrganizationId_noev(getOrganizationId());
/* 633 */       model.setItemId_noev(getItemId());
/* 634 */       model.setPromptPropertyCode_noev(getPromptPropertyCode());
/* 635 */       if (child instanceof IDataModelImpl) {
/* 636 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 637 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 638 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 639 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 642 */       if (postEventsForChanges()) {
/* 643 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemPromptPropertyProperty(IItemPromptPropertyProperty argItemPromptPropertyProperty) {
/* 649 */     if (this._properties == null) {
/* 650 */       this._properties = new HistoricalList(null);
/*     */     }
/* 652 */     argItemPromptPropertyProperty.setOrganizationId(getOrganizationId());
/* 653 */     argItemPromptPropertyProperty.setItemId(getItemId());
/* 654 */     argItemPromptPropertyProperty.setPromptPropertyCode(getPromptPropertyCode());
/* 655 */     if (argItemPromptPropertyProperty instanceof IDataModelImpl) {
/* 656 */       IDataAccessObject childDao = ((IDataModelImpl)argItemPromptPropertyProperty).getDAO();
/* 657 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 658 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 659 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 664 */     if (postEventsForChanges()) {
/* 665 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemPromptPropertyProperty));
/*     */     }
/*     */     
/* 668 */     this._properties.add(argItemPromptPropertyProperty);
/* 669 */     if (postEventsForChanges()) {
/* 670 */       this._events.post(IItemPromptProperty.ADD_PROPERTIES, argItemPromptPropertyProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemPromptPropertyProperty(IItemPromptPropertyProperty argItemPromptPropertyProperty) {
/* 675 */     if (this._properties != null) {
/*     */       
/* 677 */       if (postEventsForChanges()) {
/* 678 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemPromptPropertyProperty));
/*     */       }
/* 680 */       this._properties.remove(argItemPromptPropertyProperty);
/* 681 */       if (postEventsForChanges()) {
/* 682 */         this._events.post(IItemPromptProperty.REMOVE_PROPERTIES, argItemPromptPropertyProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentItem(IItem argParentItem) {
/* 688 */     this._parentItem = argParentItem;
/*     */   }
/*     */   
/*     */   public IItem getParentItem() {
/* 692 */     return this._parentItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 697 */     if ("Properties".equals(argFieldId)) {
/* 698 */       return getProperties();
/*     */     }
/* 700 */     if ("ItemPromptPropertyExtension".equals(argFieldId)) {
/* 701 */       return this._myExtension;
/*     */     }
/*     */     
/* 704 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 710 */     if ("Properties".equals(argFieldId)) {
/* 711 */       setProperties(changeToList(argValue, IItemPromptPropertyProperty.class));
/*     */     }
/* 713 */     else if ("ItemPromptPropertyExtension".equals(argFieldId)) {
/* 714 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 717 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 723 */     this._persistenceDefaults = argPD;
/* 724 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 725 */     this._eventManager = argEM;
/* 726 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 727 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 728 */     if (this._properties != null) {
/* 729 */       for (IItemPromptPropertyProperty relationship : this._properties) {
/* 730 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemPromptPropertyExt() {
/* 736 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemPromptPropertyExt(IDataModel argExt) {
/* 740 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 745 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 749 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 752 */     super.startTransaction();
/*     */     
/* 754 */     this._propertiesSavepoint = this._properties;
/* 755 */     if (this._properties != null) {
/* 756 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 757 */       Iterator<IDataModel> it = this._properties.iterator();
/* 758 */       while (it.hasNext()) {
/* 759 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 764 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 769 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 772 */     super.rollbackChanges();
/*     */     
/* 774 */     this._properties = this._propertiesSavepoint;
/* 775 */     this._propertiesSavepoint = null;
/* 776 */     if (this._properties != null) {
/* 777 */       Iterator<IDataModel> it = this._properties.iterator();
/* 778 */       while (it.hasNext()) {
/* 779 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 787 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 790 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 793 */     super.commitTransaction();
/*     */     
/* 795 */     this._propertiesSavepoint = this._properties;
/* 796 */     if (this._properties != null) {
/* 797 */       Iterator<IDataModel> it = this._properties.iterator();
/* 798 */       while (it.hasNext()) {
/* 799 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 801 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 805 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 810 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPromptPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */