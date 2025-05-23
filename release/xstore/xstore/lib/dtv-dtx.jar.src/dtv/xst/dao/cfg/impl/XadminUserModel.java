/*     */ package dtv.xst.dao.cfg.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelImpl;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cfg.IXadminUser;
/*     */ import dtv.xst.dao.cfg.IXadminUserNode;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class XadminUserModel extends AbstractDataModelImpl implements IXadminUser {
/*     */   private static final long serialVersionUID = -91421086L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IXadminUserNode> _orgScopes; private transient HistoricalList<IXadminUserNode> _orgScopesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new XadminUserDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XadminUserDAO getDAO_() {
/*  46 */     return (XadminUserDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUserName() {
/*  54 */     return getDAO_().getUserName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserName(String argUserName) {
/*  62 */     if (setUserName_noev(argUserName) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IXadminUser.SET_USERNAME, argUserName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUserName_noev(String argUserName) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getUserName() == null && argUserName != null) || (
/*  75 */       getDAO_().getUserName() != null && !getDAO_().getUserName().equals(argUserName))) {
/*  76 */       getDAO_().setUserName(argUserName);
/*  77 */       ev_postable = true;
/*  78 */       if (this._orgScopes != null) {
/*     */         
/*  80 */         Iterator<XadminUserNodeModel> it = this._orgScopes.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((XadminUserNodeModel)it.next()).setUserName_noev(argUserName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/*  96 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 104 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 105 */       this._events != null && 
/* 106 */       postEventsForChanges()) {
/* 107 */       this._events.post(IXadminUser.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 114 */     boolean ev_postable = false;
/*     */     
/* 116 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 117 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 118 */       getDAO_().setUpdateDate(argUpdateDate);
/* 119 */       ev_postable = true;
/*     */     } 
/*     */     
/* 122 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 130 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 138 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 139 */       this._events != null && 
/* 140 */       postEventsForChanges()) {
/* 141 */       this._events.post(IXadminUser.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 148 */     boolean ev_postable = false;
/*     */     
/* 150 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 151 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 152 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 153 */       ev_postable = true;
/*     */     } 
/*     */     
/* 156 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 164 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 172 */     if (setCreateDate_noev(argCreateDate) && 
/* 173 */       this._events != null && 
/* 174 */       postEventsForChanges()) {
/* 175 */       this._events.post(IXadminUser.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 182 */     boolean ev_postable = false;
/*     */     
/* 184 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 185 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 186 */       getDAO_().setCreateDate(argCreateDate);
/* 187 */       ev_postable = true;
/*     */     } 
/*     */     
/* 190 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 198 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 206 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(IXadminUser.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 219 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 220 */       getDAO_().setCreateUserId(argCreateUserId);
/* 221 */       ev_postable = true;
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstName() {
/* 232 */     return getDAO_().getFirstName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 240 */     if (setFirstName_noev(argFirstName) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IXadminUser.SET_FIRSTNAME, argFirstName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFirstName_noev(String argFirstName) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getFirstName() == null && argFirstName != null) || (
/* 253 */       getDAO_().getFirstName() != null && !getDAO_().getFirstName().equals(argFirstName))) {
/* 254 */       getDAO_().setFirstName(argFirstName);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastName() {
/* 266 */     return getDAO_().getLastName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 274 */     if (setLastName_noev(argLastName) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(IXadminUser.SET_LASTNAME, argLastName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastName_noev(String argLastName) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getLastName() == null && argLastName != null) || (
/* 287 */       getDAO_().getLastName() != null && !getDAO_().getLastName().equals(argLastName))) {
/* 288 */       getDAO_().setLastName(argLastName);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRoleId() {
/* 300 */     return getDAO_().getRoleId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoleId(String argRoleId) {
/* 308 */     if (setRoleId_noev(argRoleId) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(IXadminUser.SET_ROLEID, argRoleId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRoleId_noev(String argRoleId) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getRoleId() == null && argRoleId != null) || (
/* 321 */       getDAO_().getRoleId() != null && !getDAO_().getRoleId().equals(argRoleId))) {
/* 322 */       getDAO_().setRoleId(argRoleId);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocale() {
/* 334 */     return getDAO_().getLocale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocale(String argLocale) {
/* 342 */     if (setLocale_noev(argLocale) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(IXadminUser.SET_LOCALE, argLocale);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocale_noev(String argLocale) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getLocale() == null && argLocale != null) || (
/* 355 */       getDAO_().getLocale() != null && !getDAO_().getLocale().equals(argLocale))) {
/* 356 */       getDAO_().setLocale(argLocale);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 368 */     if (getDAO_().getOrganizationId() != null) {
/* 369 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 372 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 381 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IXadminUser.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 394 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 395 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
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
/*     */   public String getEmailAddress() {
/* 407 */     return getDAO_().getEmailAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 415 */     if (setEmailAddress_noev(argEmailAddress) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IXadminUser.SET_EMAILADDRESS, argEmailAddress);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailAddress_noev(String argEmailAddress) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getEmailAddress() == null && argEmailAddress != null) || (
/* 428 */       getDAO_().getEmailAddress() != null && !getDAO_().getEmailAddress().equals(argEmailAddress))) {
/* 429 */       getDAO_().setEmailAddress(argEmailAddress);
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
/*     */   public String getDirectoryType() {
/* 441 */     return getDAO_().getDirectoryType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDirectoryType(String argDirectoryType) {
/* 449 */     if (setDirectoryType_noev(argDirectoryType) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IXadminUser.SET_DIRECTORYTYPE, argDirectoryType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDirectoryType_noev(String argDirectoryType) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getDirectoryType() == null && argDirectoryType != null) || (
/* 462 */       getDAO_().getDirectoryType() != null && !getDAO_().getDirectoryType().equals(argDirectoryType))) {
/* 463 */       getDAO_().setDirectoryType(argDirectoryType);
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
/*     */   @Relationship(name = "OrgScopes")
/*     */   public List<IXadminUserNode> getOrgScopes() {
/* 476 */     if (this._orgScopes == null) {
/* 477 */       this._orgScopes = new HistoricalList(null);
/*     */     }
/* 479 */     return (List<IXadminUserNode>)this._orgScopes;
/*     */   }
/*     */   
/*     */   public void setOrgScopes(List<IXadminUserNode> argOrgScopes) {
/* 483 */     if (this._orgScopes == null) {
/* 484 */       this._orgScopes = new HistoricalList(argOrgScopes);
/*     */     } else {
/* 486 */       this._orgScopes.setCurrentList(argOrgScopes);
/*     */     } 
/*     */     
/* 489 */     for (IXadminUserNode child : this._orgScopes) {
/* 490 */       XadminUserNodeModel model = (XadminUserNodeModel)child;
/* 491 */       model.setUserName_noev(getUserName());
/* 492 */       if (child instanceof IDataModelImpl) {
/* 493 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 494 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 495 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 496 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 499 */       if (postEventsForChanges()) {
/* 500 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addXadminUserNode(IXadminUserNode argXadminUserNode) {
/* 506 */     if (this._orgScopes == null) {
/* 507 */       this._orgScopes = new HistoricalList(null);
/*     */     }
/* 509 */     argXadminUserNode.setUserName(getUserName());
/* 510 */     if (argXadminUserNode instanceof IDataModelImpl) {
/* 511 */       IDataAccessObject childDao = ((IDataModelImpl)argXadminUserNode).getDAO();
/* 512 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 513 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 514 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 519 */     if (postEventsForChanges()) {
/* 520 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXadminUserNode));
/*     */     }
/*     */     
/* 523 */     this._orgScopes.add(argXadminUserNode);
/* 524 */     if (postEventsForChanges()) {
/* 525 */       this._events.post(IXadminUser.ADD_ORGSCOPES, argXadminUserNode);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeXadminUserNode(IXadminUserNode argXadminUserNode) {
/* 530 */     if (this._orgScopes != null) {
/*     */       
/* 532 */       if (postEventsForChanges()) {
/* 533 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXadminUserNode));
/*     */       }
/* 535 */       this._orgScopes.remove(argXadminUserNode);
/* 536 */       if (postEventsForChanges()) {
/* 537 */         this._events.post(IXadminUser.REMOVE_ORGSCOPES, argXadminUserNode);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 544 */     if ("OrgScopes".equals(argFieldId)) {
/* 545 */       return getOrgScopes();
/*     */     }
/* 547 */     if ("XadminUserExtension".equals(argFieldId)) {
/* 548 */       return this._myExtension;
/*     */     }
/*     */     
/* 551 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 557 */     if ("OrgScopes".equals(argFieldId)) {
/* 558 */       setOrgScopes(changeToList(argValue, IXadminUserNode.class));
/*     */     }
/* 560 */     else if ("XadminUserExtension".equals(argFieldId)) {
/* 561 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 564 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 570 */     this._persistenceDefaults = argPD;
/* 571 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 572 */     this._eventManager = argEM;
/* 573 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 574 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 575 */     if (this._orgScopes != null) {
/* 576 */       for (IXadminUserNode relationship : this._orgScopes) {
/* 577 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getXadminUserExt() {
/* 583 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setXadminUserExt(IDataModel argExt) {
/* 587 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 592 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 596 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 599 */     super.startTransaction();
/*     */     
/* 601 */     this._orgScopesSavepoint = this._orgScopes;
/* 602 */     if (this._orgScopes != null) {
/* 603 */       this._orgScopesSavepoint = new HistoricalList((List)this._orgScopes);
/* 604 */       Iterator<IDataModel> it = this._orgScopes.iterator();
/* 605 */       while (it.hasNext()) {
/* 606 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 611 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 616 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 619 */     super.rollbackChanges();
/*     */     
/* 621 */     this._orgScopes = this._orgScopesSavepoint;
/* 622 */     this._orgScopesSavepoint = null;
/* 623 */     if (this._orgScopes != null) {
/* 624 */       Iterator<IDataModel> it = this._orgScopes.iterator();
/* 625 */       while (it.hasNext()) {
/* 626 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 634 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 637 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 640 */     super.commitTransaction();
/*     */     
/* 642 */     this._orgScopesSavepoint = this._orgScopes;
/* 643 */     if (this._orgScopes != null) {
/* 644 */       Iterator<IDataModel> it = this._orgScopes.iterator();
/* 645 */       while (it.hasNext()) {
/* 646 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 648 */       this._orgScopes = new HistoricalList((List)this._orgScopes);
/*     */     } 
/*     */ 
/*     */     
/* 652 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 657 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\impl\XadminUserModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */