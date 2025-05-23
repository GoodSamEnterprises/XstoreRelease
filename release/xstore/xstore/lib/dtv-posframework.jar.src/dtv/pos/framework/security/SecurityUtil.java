/*     */ package dtv.pos.framework.security;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pos.iframework.assistance.ITrainingModeHelper;
/*     */ import dtv.pos.iframework.security.IAcl;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.pos.iframework.security.SecuredAccessSettings;
/*     */ import dtv.pos.iframework.security.SecuredObjectID;
/*     */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.util.ByteUtils;
/*     */ import dtv.util.security.ISecured;
/*     */ import dtv.xst.dao.sec.IAccessControlList;
/*     */ import dtv.xst.dao.sec.IPrivilege;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class SecurityUtil
/*     */ {
/*  36 */   public static final IQueryKey<IPrivilege> SECURITY_PRIVILEGES = (IQueryKey<IPrivilege>)new QueryKey("SECURITY_PRIVILEGES", IPrivilege.class);
/*     */ 
/*     */   
/*  39 */   private static final Logger _logger = Logger.getLogger(SecurityUtil.class);
/*     */   
/*  41 */   private static final boolean _debugLogging = _logger.isDebugEnabled();
/*  42 */   private static final IQueryKey<IAccessControlList> _securityAcls = (IQueryKey<IAccessControlList>)new QueryKey("SECURITY_ACLS", IAccessControlList.class);
/*     */ 
/*     */   
/*     */   private Map<String, IPrivilege> privilegeMap_;
/*     */   
/*     */   private Map<String, IPrivilege> privilegeMapTrainingMode_;
/*     */   
/*     */   private Map<String, IAcl> aclMap_;
/*     */   
/*     */   private Map<String, IAcl> aclMapTrainingMode_;
/*     */   
/*     */   @Inject
/*     */   private ITrainingModeHelper _trainingModeHelper;
/*     */ 
/*     */   
/*     */   public IAccessLevel getAccessLevel(ISystemUser argUser, String argPrivilege) {
/*  58 */     return getAccessLevel(argPrivilege, argUser.getGroupMembership());
/*     */   }
/*     */ 
/*     */   
/*     */   public IAccessLevel getAccessLevel(String argPrivilege, byte[] argMembership) {
/*  63 */     IPrivilege privilege = getPrivilege(argPrivilege);
/*     */     
/*  65 */     if (privilege == null) {
/*  66 */       _logger.warn("No privilege foung for privilege type [" + argPrivilege + "]");
/*  67 */       return (IAccessLevel)AccessLevel.DENIED;
/*     */     } 
/*     */ 
/*     */     
/*  71 */     if (ByteUtils.compareBytes(privilege.getGroupMembership(), argMembership)) {
/*  72 */       return (IAccessLevel)AccessLevel.GRANTED_PRIVILEGED;
/*     */     }
/*     */     
/*  75 */     return AccessLevel.convertToLevel(privilege.getOverridable());
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
/*     */   public IAcl getAcl(ISecuredObjectID argSecuredObjectId) {
/*  88 */     IAcl retval = null;
/*  89 */     if (argSecuredObjectId != null) {
/*  90 */       retval = this.aclMap_.get(argSecuredObjectId.toString());
/*     */     }
/*     */     
/*  93 */     if (retval == null) {
/*  94 */       retval = this.aclMap_.get(SecuredObjectID.DEFAULT.toString());
/*     */     }
/*  96 */     return retval;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPrivilege getPrivilege(String argPrivilegeType) {
/* 101 */     return this.privilegeMap_.get(argPrivilegeType.toUpperCase());
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
/*     */   public SecuredAccessSettings getSecuredAccessSettings(ISystemUser argUser, ISecured argSecured) {
/* 114 */     return getSecuredAccessSettings(argUser, argSecured.getPrivilege());
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
/*     */   public SecuredAccessSettings getSecuredAccessSettings(ISystemUser argUser, String argType) {
/* 127 */     SecuredAccessSettings returnSettings = null;
/*     */ 
/*     */     
/* 130 */     IPrivilege privilege = getPrivilege(argType);
/*     */ 
/*     */     
/* 133 */     if (privilege != null) {
/*     */       
/* 135 */       IAccessLevel level = getAccessLevel(argUser, argType);
/* 136 */       returnSettings = new SecuredAccessSettings(level, argType);
/*     */     } else {
/*     */       
/* 139 */       _logger.warn("Privilege could not be determined for [" + argType + "]!", new Throwable("STACK TRACE"));
/*     */     } 
/* 141 */     return returnSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 148 */     if (this._trainingModeHelper.isTrainingMode()) {
/* 149 */       if (this.privilegeMapTrainingMode_ == null) {
/* 150 */         this.privilegeMapTrainingMode_ = loadPrivileges();
/*     */       }
/*     */       
/* 153 */       if (this.aclMapTrainingMode_ == null) {
/* 154 */         this.aclMapTrainingMode_ = loadAcls();
/*     */       }
/*     */       
/* 157 */       this.privilegeMap_ = this.privilegeMapTrainingMode_;
/* 158 */       this.aclMap_ = this.aclMapTrainingMode_;
/*     */     }
/*     */     else {
/*     */       
/* 162 */       this.privilegeMap_ = loadPrivileges();
/*     */ 
/*     */       
/* 165 */       this.aclMap_ = loadAcls();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, IAcl> loadAcls() {
/* 171 */     IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(_securityAcls, null);
/*     */     
/* 173 */     if (iQueryResultList.isEmpty()) {
/* 174 */       _logger.warn("No sec_acl rows were found.  This may be symptomatic of a much larger problem that will hopefully be reported as a PFC, so rather than fail fast here the issue will be ignored.");
/*     */     }
/*     */ 
/*     */     
/* 178 */     Map<String, IAcl> map = new HashMap<>();
/* 179 */     for (IAccessControlList acl : iQueryResultList) {
/* 180 */       IAcl aclImpl = new AclImpl(acl);
/* 181 */       map.put(acl.getSecuredObjectId().trim().toUpperCase(), aclImpl);
/*     */     } 
/* 183 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, IPrivilege> loadPrivileges() {
/* 189 */     IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(SECURITY_PRIVILEGES, null);
/*     */     
/* 191 */     if (iQueryResultList.isEmpty()) {
/* 192 */       _logger.warn("No sec_privilege rows were found.  This may be symptomatic of a much larger problem that will hopefully be reported as a PFC, so rather than fail fast here the issue will be ignored.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 197 */     Map<String, IPrivilege> map = new HashMap<>();
/* 198 */     for (IPrivilege privilege : iQueryResultList) {
/* 199 */       String privilegeType = privilege.getPrivilegeType();
/* 200 */       if (_debugLogging) {
/* 201 */         _logger.debug("Loading Privilege [" + privilegeType + "]");
/*     */       }
/* 203 */       map.put(privilegeType.toUpperCase().trim(), privilege);
/*     */     } 
/*     */     
/* 206 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\SecurityUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */