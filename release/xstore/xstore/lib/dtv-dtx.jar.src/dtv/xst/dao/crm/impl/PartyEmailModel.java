/*     */ package dtv.xst.dao.crm.impl;
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
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.crm.IPartyEmail;
/*     */ import dtv.xst.dao.crm.IPartyEmailProperty;
/*     */ import dtv.xst.dao.crm.PartyEmailPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PartyEmailModel extends AbstractDataModelWithPropertyImpl<IPartyEmailProperty> implements IPartyEmail {
/*     */   private static final long serialVersionUID = -1846281098L;
/*     */   private IParty _parentParty;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IPartyEmailProperty> _properties; private transient HistoricalList<IPartyEmailProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new PartyEmailDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PartyEmailDAO getDAO_() {
/*  48 */     return (PartyEmailDAO)this._daoImpl;
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
/*  72 */       this._events.post(IPartyEmail.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<PartyEmailPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((PartyEmailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getPartyId() {
/* 103 */     if (getDAO_().getPartyId() != null) {
/* 104 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 116 */     if (setPartyId_noev(argPartyId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(IPartyEmail.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 129 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 130 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<PartyEmailPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((PartyEmailPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSequence() {
/* 150 */     if (getDAO_().getSequence() != null) {
/* 151 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 154 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 163 */     if (setSequence_noev(argSequence) && 
/* 164 */       this._events != null && 
/* 165 */       postEventsForChanges()) {
/* 166 */       this._events.post(IPartyEmail.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 173 */     boolean ev_postable = false;
/*     */     
/* 175 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 176 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 177 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 178 */       ev_postable = true;
/* 179 */       if (this._properties != null) {
/*     */         
/* 181 */         Iterator<PartyEmailPropertyModel> it = this._properties.iterator();
/* 182 */         while (it.hasNext())
/*     */         {
/* 184 */           ((PartyEmailPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 197 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 205 */     if (setCreateDate_noev(argCreateDate) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IPartyEmail.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 218 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 219 */       getDAO_().setCreateDate(argCreateDate);
/* 220 */       ev_postable = true;
/*     */     } 
/*     */     
/* 223 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 231 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 239 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 240 */       this._events != null && 
/* 241 */       postEventsForChanges()) {
/* 242 */       this._events.post(IPartyEmail.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 249 */     boolean ev_postable = false;
/*     */     
/* 251 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 252 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 253 */       getDAO_().setCreateUserId(argCreateUserId);
/* 254 */       ev_postable = true;
/*     */     } 
/*     */     
/* 257 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 265 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 273 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 274 */       this._events != null && 
/* 275 */       postEventsForChanges()) {
/* 276 */       this._events.post(IPartyEmail.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 283 */     boolean ev_postable = false;
/*     */     
/* 285 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 286 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 287 */       getDAO_().setUpdateDate(argUpdateDate);
/* 288 */       ev_postable = true;
/*     */     } 
/*     */     
/* 291 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 299 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 307 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 308 */       this._events != null && 
/* 309 */       postEventsForChanges()) {
/* 310 */       this._events.post(IPartyEmail.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 317 */     boolean ev_postable = false;
/*     */     
/* 319 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 320 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 321 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 322 */       ev_postable = true;
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmailAddress() {
/* 333 */     return getDAO_().getEmailAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 341 */     if (setEmailAddress_noev(argEmailAddress) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(IPartyEmail.SET_EMAILADDRESS, argEmailAddress);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailAddress_noev(String argEmailAddress) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getEmailAddress() == null && argEmailAddress != null) || (
/* 354 */       getDAO_().getEmailAddress() != null && !getDAO_().getEmailAddress().equals(argEmailAddress))) {
/* 355 */       getDAO_().setEmailAddress(argEmailAddress);
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
/*     */   public String getEmailType() {
/* 367 */     return getDAO_().getEmailType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailType(String argEmailType) {
/* 375 */     if (setEmailType_noev(argEmailType) && 
/* 376 */       this._events != null && 
/* 377 */       postEventsForChanges()) {
/* 378 */       this._events.post(IPartyEmail.SET_EMAILTYPE, argEmailType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailType_noev(String argEmailType) {
/* 385 */     boolean ev_postable = false;
/*     */     
/* 387 */     if ((getDAO_().getEmailType() == null && argEmailType != null) || (
/* 388 */       getDAO_().getEmailType() != null && !getDAO_().getEmailType().equals(argEmailType))) {
/* 389 */       getDAO_().setEmailType(argEmailType);
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
/*     */   public String getEmailFormat() {
/* 401 */     return getDAO_().getEmailFormat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailFormat(String argEmailFormat) {
/* 409 */     if (setEmailFormat_noev(argEmailFormat) && 
/* 410 */       this._events != null && 
/* 411 */       postEventsForChanges()) {
/* 412 */       this._events.post(IPartyEmail.SET_EMAILFORMAT, argEmailFormat);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailFormat_noev(String argEmailFormat) {
/* 419 */     boolean ev_postable = false;
/*     */     
/* 421 */     if ((getDAO_().getEmailFormat() == null && argEmailFormat != null) || (
/* 422 */       getDAO_().getEmailFormat() != null && !getDAO_().getEmailFormat().equals(argEmailFormat))) {
/* 423 */       getDAO_().setEmailFormat(argEmailFormat);
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
/*     */   public boolean getContact() {
/* 435 */     if (getDAO_().getContact() != null) {
/* 436 */       return getDAO_().getContact().booleanValue();
/*     */     }
/*     */     
/* 439 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContact(boolean argContact) {
/* 448 */     if (setContact_noev(argContact) && 
/* 449 */       this._events != null && 
/* 450 */       postEventsForChanges()) {
/* 451 */       this._events.post(IPartyEmail.SET_CONTACT, Boolean.valueOf(argContact));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContact_noev(boolean argContact) {
/* 458 */     boolean ev_postable = false;
/*     */     
/* 460 */     if ((getDAO_().getContact() == null && Boolean.valueOf(argContact) != null) || (
/* 461 */       getDAO_().getContact() != null && !getDAO_().getContact().equals(Boolean.valueOf(argContact)))) {
/* 462 */       getDAO_().setContact(Boolean.valueOf(argContact));
/* 463 */       ev_postable = true;
/*     */     } 
/*     */     
/* 466 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPrimary() {
/* 474 */     if (getDAO_().getPrimary() != null) {
/* 475 */       return getDAO_().getPrimary().booleanValue();
/*     */     }
/*     */     
/* 478 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimary(boolean argPrimary) {
/* 487 */     if (setPrimary_noev(argPrimary) && 
/* 488 */       this._events != null && 
/* 489 */       postEventsForChanges()) {
/* 490 */       this._events.post(IPartyEmail.SET_PRIMARY, Boolean.valueOf(argPrimary));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrimary_noev(boolean argPrimary) {
/* 497 */     boolean ev_postable = false;
/*     */     
/* 499 */     if ((getDAO_().getPrimary() == null && Boolean.valueOf(argPrimary) != null) || (
/* 500 */       getDAO_().getPrimary() != null && !getDAO_().getPrimary().equals(Boolean.valueOf(argPrimary)))) {
/* 501 */       getDAO_().setPrimary(Boolean.valueOf(argPrimary));
/* 502 */       ev_postable = true;
/*     */     } 
/*     */     
/* 505 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPartyEmailProperty newProperty(String argPropertyName) {
/* 509 */     PartyEmailPropertyId id = new PartyEmailPropertyId();
/*     */     
/* 511 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 512 */     id.setSequence(Integer.valueOf(getSequence()));
/* 513 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 515 */     IPartyEmailProperty prop = (IPartyEmailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyEmailProperty.class);
/* 516 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPartyEmailProperty> getProperties() {
/* 525 */     if (this._properties == null) {
/* 526 */       this._properties = new HistoricalList(null);
/*     */     }
/* 528 */     return (List<IPartyEmailProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPartyEmailProperty> argProperties) {
/* 532 */     if (this._properties == null) {
/* 533 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 535 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 538 */     for (IPartyEmailProperty child : this._properties) {
/* 539 */       PartyEmailPropertyModel model = (PartyEmailPropertyModel)child;
/* 540 */       model.setOrganizationId_noev(getOrganizationId());
/* 541 */       model.setPartyId_noev(getPartyId());
/* 542 */       model.setSequence_noev(getSequence());
/* 543 */       if (child instanceof IDataModelImpl) {
/* 544 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 545 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 546 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 547 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 550 */       if (postEventsForChanges()) {
/* 551 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPartyEmailProperty(IPartyEmailProperty argPartyEmailProperty) {
/* 557 */     if (this._properties == null) {
/* 558 */       this._properties = new HistoricalList(null);
/*     */     }
/* 560 */     argPartyEmailProperty.setOrganizationId(getOrganizationId());
/* 561 */     argPartyEmailProperty.setPartyId(getPartyId());
/* 562 */     argPartyEmailProperty.setSequence(getSequence());
/* 563 */     if (argPartyEmailProperty instanceof IDataModelImpl) {
/* 564 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyEmailProperty).getDAO();
/* 565 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 566 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 567 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 572 */     if (postEventsForChanges()) {
/* 573 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyEmailProperty));
/*     */     }
/*     */     
/* 576 */     this._properties.add(argPartyEmailProperty);
/* 577 */     if (postEventsForChanges()) {
/* 578 */       this._events.post(IPartyEmail.ADD_PROPERTIES, argPartyEmailProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePartyEmailProperty(IPartyEmailProperty argPartyEmailProperty) {
/* 583 */     if (this._properties != null) {
/*     */       
/* 585 */       if (postEventsForChanges()) {
/* 586 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyEmailProperty));
/*     */       }
/* 588 */       this._properties.remove(argPartyEmailProperty);
/* 589 */       if (postEventsForChanges()) {
/* 590 */         this._events.post(IPartyEmail.REMOVE_PROPERTIES, argPartyEmailProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentParty(IParty argParentParty) {
/* 596 */     this._parentParty = argParentParty;
/*     */   }
/*     */   
/*     */   public IParty getParentParty() {
/* 600 */     return this._parentParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 605 */     if ("Properties".equals(argFieldId)) {
/* 606 */       return getProperties();
/*     */     }
/* 608 */     if ("PartyEmailExtension".equals(argFieldId)) {
/* 609 */       return this._myExtension;
/*     */     }
/*     */     
/* 612 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 618 */     if ("Properties".equals(argFieldId)) {
/* 619 */       setProperties(changeToList(argValue, IPartyEmailProperty.class));
/*     */     }
/* 621 */     else if ("PartyEmailExtension".equals(argFieldId)) {
/* 622 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 625 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 631 */     this._persistenceDefaults = argPD;
/* 632 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 633 */     this._eventManager = argEM;
/* 634 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 635 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 636 */     if (this._properties != null) {
/* 637 */       for (IPartyEmailProperty relationship : this._properties) {
/* 638 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPartyEmailExt() {
/* 644 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPartyEmailExt(IDataModel argExt) {
/* 648 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 653 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 657 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 660 */     super.startTransaction();
/*     */     
/* 662 */     this._propertiesSavepoint = this._properties;
/* 663 */     if (this._properties != null) {
/* 664 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 665 */       Iterator<IDataModel> it = this._properties.iterator();
/* 666 */       while (it.hasNext()) {
/* 667 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 672 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 677 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 680 */     super.rollbackChanges();
/*     */     
/* 682 */     this._properties = this._propertiesSavepoint;
/* 683 */     this._propertiesSavepoint = null;
/* 684 */     if (this._properties != null) {
/* 685 */       Iterator<IDataModel> it = this._properties.iterator();
/* 686 */       while (it.hasNext()) {
/* 687 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 695 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 698 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 701 */     super.commitTransaction();
/*     */     
/* 703 */     this._propertiesSavepoint = this._properties;
/* 704 */     if (this._properties != null) {
/* 705 */       Iterator<IDataModel> it = this._properties.iterator();
/* 706 */       while (it.hasNext()) {
/* 707 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 709 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 713 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 718 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyEmailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */