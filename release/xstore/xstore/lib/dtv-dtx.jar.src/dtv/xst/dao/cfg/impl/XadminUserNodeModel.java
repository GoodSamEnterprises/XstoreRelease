/*     */ package dtv.xst.dao.cfg.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelImpl;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.xst.dao.cfg.IXadminUserNode;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XadminUserNodeModel
/*     */   extends AbstractDataModelImpl
/*     */   implements IXadminUserNode
/*     */ {
/*     */   private static final long serialVersionUID = 1176774532L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  31 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initDAO() {
/*  36 */     setDAO((IDataAccessObject)new XadminUserNodeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XadminUserNodeDAO getDAO_() {
/*  44 */     return (XadminUserNodeDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUserName() {
/*  52 */     return getDAO_().getUserName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserName(String argUserName) {
/*  60 */     if (setUserName_noev(argUserName) && 
/*  61 */       this._events != null && 
/*  62 */       postEventsForChanges()) {
/*  63 */       this._events.post(IXadminUserNode.SET_USERNAME, argUserName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUserName_noev(String argUserName) {
/*  70 */     boolean ev_postable = false;
/*     */     
/*  72 */     if ((getDAO_().getUserName() == null && argUserName != null) || (
/*  73 */       getDAO_().getUserName() != null && !getDAO_().getUserName().equals(argUserName))) {
/*  74 */       getDAO_().setUserName(argUserName);
/*  75 */       ev_postable = true;
/*     */     } 
/*     */     
/*  78 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgScope() {
/*  86 */     return getDAO_().getOrgScope();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgScope(String argOrgScope) {
/*  94 */     if (setOrgScope_noev(argOrgScope) && 
/*  95 */       this._events != null && 
/*  96 */       postEventsForChanges()) {
/*  97 */       this._events.post(IXadminUserNode.SET_ORGSCOPE, argOrgScope);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgScope_noev(String argOrgScope) {
/* 104 */     boolean ev_postable = false;
/*     */     
/* 106 */     if ((getDAO_().getOrgScope() == null && argOrgScope != null) || (
/* 107 */       getDAO_().getOrgScope() != null && !getDAO_().getOrgScope().equals(argOrgScope))) {
/* 108 */       getDAO_().setOrgScope(argOrgScope);
/* 109 */       ev_postable = true;
/*     */     } 
/*     */     
/* 112 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 120 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 128 */     if (setCreateDate_noev(argCreateDate) && 
/* 129 */       this._events != null && 
/* 130 */       postEventsForChanges()) {
/* 131 */       this._events.post(IXadminUserNode.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 138 */     boolean ev_postable = false;
/*     */     
/* 140 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 141 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 142 */       getDAO_().setCreateDate(argCreateDate);
/* 143 */       ev_postable = true;
/*     */     } 
/*     */     
/* 146 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 154 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 162 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 163 */       this._events != null && 
/* 164 */       postEventsForChanges()) {
/* 165 */       this._events.post(IXadminUserNode.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 172 */     boolean ev_postable = false;
/*     */     
/* 174 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 175 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 176 */       getDAO_().setCreateUserId(argCreateUserId);
/* 177 */       ev_postable = true;
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 188 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 196 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 197 */       this._events != null && 
/* 198 */       postEventsForChanges()) {
/* 199 */       this._events.post(IXadminUserNode.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 206 */     boolean ev_postable = false;
/*     */     
/* 208 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 209 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 210 */       getDAO_().setUpdateDate(argUpdateDate);
/* 211 */       ev_postable = true;
/*     */     } 
/*     */     
/* 214 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 222 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 230 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 231 */       this._events != null && 
/* 232 */       postEventsForChanges()) {
/* 233 */       this._events.post(IXadminUserNode.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 240 */     boolean ev_postable = false;
/*     */     
/* 242 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 243 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 244 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 245 */       ev_postable = true;
/*     */     } 
/*     */     
/* 248 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 256 */     if (getDAO_().getOrganizationId() != null) {
/* 257 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 260 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 269 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IXadminUserNode.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 282 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 283 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 293 */     if ("XadminUserNodeExtension".equals(argFieldId)) {
/* 294 */       return this._myExtension;
/*     */     }
/*     */     
/* 297 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 303 */     if ("XadminUserNodeExtension".equals(argFieldId)) {
/* 304 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 307 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 313 */     this._persistenceDefaults = argPD;
/* 314 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 315 */     this._eventManager = argEM;
/* 316 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 317 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */   
/*     */   public IDataModel getXadminUserNodeExt() {
/* 321 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setXadminUserNodeExt(IDataModel argExt) {
/* 325 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 330 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 334 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 337 */     super.startTransaction();
/*     */ 
/*     */     
/* 340 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 345 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 348 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 354 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 357 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 360 */     super.commitTransaction();
/*     */ 
/*     */     
/* 363 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 368 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\impl\XadminUserNodeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */