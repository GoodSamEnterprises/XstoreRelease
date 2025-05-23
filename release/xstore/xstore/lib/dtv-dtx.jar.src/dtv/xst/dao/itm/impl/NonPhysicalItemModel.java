/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.itm.INonPhysicalItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NonPhysicalItemModel
/*     */   extends ItemModel
/*     */   implements INonPhysicalItem
/*     */ {
/*     */   private static final long serialVersionUID = 2117171159L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new NonPhysicalItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private NonPhysicalItemDAO getDAO_() {
/*  38 */     return (NonPhysicalItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  46 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  54 */     if (setCreateDate_noev(argCreateDate) && 
/*  55 */       this._events != null && 
/*  56 */       postEventsForChanges()) {
/*  57 */       this._events.post(INonPhysicalItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  64 */     boolean ev_postable = false;
/*     */     
/*  66 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  67 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  68 */       getDAO_().setCreateDate(argCreateDate);
/*  69 */       ev_postable = true;
/*     */     } 
/*     */     
/*  72 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  89 */       this._events != null && 
/*  90 */       postEventsForChanges()) {
/*  91 */       this._events.post(INonPhysicalItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  98 */     boolean ev_postable = false;
/*     */     
/* 100 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 101 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 102 */       getDAO_().setCreateUserId(argCreateUserId);
/* 103 */       ev_postable = true;
/*     */     } 
/*     */     
/* 106 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 123 */       this._events != null && 
/* 124 */       postEventsForChanges()) {
/* 125 */       this._events.post(INonPhysicalItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 132 */     boolean ev_postable = false;
/*     */     
/* 134 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 135 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 136 */       getDAO_().setUpdateDate(argUpdateDate);
/* 137 */       ev_postable = true;
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 148 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(INonPhysicalItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 169 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 170 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayOrder() {
/* 182 */     if (getDAO_().getDisplayOrder() != null) {
/* 183 */       return getDAO_().getDisplayOrder().intValue();
/*     */     }
/*     */     
/* 186 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayOrder(int argDisplayOrder) {
/* 195 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/* 196 */       this._events != null && 
/* 197 */       postEventsForChanges()) {
/* 198 */       this._events.post(INonPhysicalItem.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/* 205 */     boolean ev_postable = false;
/*     */     
/* 207 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/* 208 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/* 209 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
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
/*     */   public String getNonPhysicalItemTypeCode() {
/* 221 */     return getDAO_().getNonPhysicalItemTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNonPhysicalItemTypeCode(String argNonPhysicalItemTypeCode) {
/* 229 */     if (setNonPhysicalItemTypeCode_noev(argNonPhysicalItemTypeCode) && 
/* 230 */       this._events != null && 
/* 231 */       postEventsForChanges()) {
/* 232 */       this._events.post(INonPhysicalItem.SET_NONPHYSICALITEMTYPECODE, argNonPhysicalItemTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNonPhysicalItemTypeCode_noev(String argNonPhysicalItemTypeCode) {
/* 239 */     boolean ev_postable = false;
/*     */     
/* 241 */     if ((getDAO_().getNonPhysicalItemTypeCode() == null && argNonPhysicalItemTypeCode != null) || (
/* 242 */       getDAO_().getNonPhysicalItemTypeCode() != null && !getDAO_().getNonPhysicalItemTypeCode().equals(argNonPhysicalItemTypeCode))) {
/* 243 */       getDAO_().setNonPhysicalItemTypeCode(argNonPhysicalItemTypeCode);
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
/*     */   public String getNonPhysicalItemSubtype() {
/* 255 */     return getDAO_().getNonPhysicalItemSubtype();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNonPhysicalItemSubtype(String argNonPhysicalItemSubtype) {
/* 263 */     if (setNonPhysicalItemSubtype_noev(argNonPhysicalItemSubtype) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(INonPhysicalItem.SET_NONPHYSICALITEMSUBTYPE, argNonPhysicalItemSubtype);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNonPhysicalItemSubtype_noev(String argNonPhysicalItemSubtype) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getNonPhysicalItemSubtype() == null && argNonPhysicalItemSubtype != null) || (
/* 276 */       getDAO_().getNonPhysicalItemSubtype() != null && !getDAO_().getNonPhysicalItemSubtype().equals(argNonPhysicalItemSubtype))) {
/* 277 */       getDAO_().setNonPhysicalItemSubtype(argNonPhysicalItemSubtype);
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 287 */     if ("NonPhysicalItemExtension".equals(argFieldId)) {
/* 288 */       return this._myExtension;
/*     */     }
/*     */     
/* 291 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 297 */     if ("NonPhysicalItemExtension".equals(argFieldId)) {
/* 298 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 301 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 307 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getNonPhysicalItemExt() {
/* 311 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setNonPhysicalItemExt(IDataModel argExt) {
/* 315 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 320 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 324 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 327 */     super.startTransaction();
/*     */ 
/*     */     
/* 330 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 335 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 338 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 344 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 347 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 350 */     super.commitTransaction();
/*     */ 
/*     */     
/* 353 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 358 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\NonPhysicalItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */