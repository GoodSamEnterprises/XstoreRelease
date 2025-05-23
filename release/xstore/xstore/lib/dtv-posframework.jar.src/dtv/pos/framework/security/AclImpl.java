/*     */ package dtv.pos.framework.security;
/*     */ 
/*     */ import dtv.pos.iframework.security.AccessType;
/*     */ import dtv.pos.iframework.security.IAcl;
/*     */ import dtv.pos.iframework.security.IAclEntry;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.util.ByteUtils;
/*     */ import dtv.xst.dao.sec.IAccessControlList;
/*     */ import dtv.xst.dao.sec.IAclAccessType;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class AclImpl
/*     */   implements IAcl
/*     */ {
/*     */   private final IAccessControlList acl_;
/*     */   private ISecuredObjectID securedObjectId_;
/*     */   private Map<String, IAclAccessType> aclEntryMap_;
/*     */   
/*     */   public AclImpl(IAccessControlList argAcl) {
/*  35 */     this.acl_ = argAcl;
/*     */     
/*  37 */     List<IAclAccessType> entries = this.acl_.getAclEntries();
/*     */     
/*  39 */     if (entries == null || entries.isEmpty()) {
/*  40 */       this.aclEntryMap_ = Collections.emptyMap();
/*     */       return;
/*     */     } 
/*  43 */     this.aclEntryMap_ = new HashMap<>();
/*  44 */     for (IAclAccessType t : entries) {
/*  45 */       this.aclEntryMap_.put(t.getAccessTypeCode().toUpperCase().trim(), t);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAccessEntry(IAclEntry newAccessEntry) {
/*  52 */     throw new UnsupportedOperationException("Method addAccessEntry() not yet implemented.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean authorize(ISystemUser argAuthTicket, AccessType argAccessType) {
/*  59 */     IAclAccessType accessType = this.aclEntryMap_.get(argAccessType.toString().toUpperCase().trim());
/*     */     
/*  61 */     if (accessType == null) {
/*  62 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  66 */     return ByteUtils.compareBytes(argAuthTicket.getGroupMembership(), accessType.getGroupMembership());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAccessLevel getAccessLevel(AccessType argAccessType, ISystemUser argUser) {
/*  76 */     IAclAccessType accessType = this.aclEntryMap_.get(argAccessType.toString().toUpperCase().trim());
/*     */     
/*  78 */     if (accessType == null) {
/*  79 */       return (IAccessLevel)AccessLevel.DENIED;
/*     */     }
/*     */     
/*  82 */     if (ByteUtils.compareBytes(argUser.getGroupMembership(), accessType.getGroupMembership())) {
/*  83 */       return (IAccessLevel)AccessLevel.GRANTED_PRIVILEGED;
/*     */     }
/*     */     
/*  86 */     return (IAccessLevel)AccessLevel.DENIED_PRIVILEGED;
/*     */   }
/*     */ 
/*     */   
/*     */   public ISecuredObjectID getSecuredObjectID() {
/*  91 */     return this.securedObjectId_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAuthenticationRequired() {
/*  96 */     if (this.acl_ == null) {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     return this.acl_.getAuthenticationRequired();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\AclImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */