/*     */ package dtv.pos.framework.version;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pos.Version;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.xst.dao.ctl.IVersion;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ public class VersionHelperImpl
/*     */   implements IVersionHelper
/*     */ {
/*  29 */   private static final Logger _logger = Logger.getLogger(VersionHelperImpl.class);
/*  30 */   private static final IQueryKey<IVersion> SCHEMA_VERSION = (IQueryKey<IVersion>)new QueryKey("SCHEMA_VERSION", IVersion.class);
/*     */   
/*  32 */   private final Map<SchemaVersionScope, IVersion> _schemaVersionMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionInfo getAppVersionInfo() {
/*  43 */     return new VersionInfo(
/*  44 */         Version.getShortTitle(), 
/*  45 */         getBaseAppVersion(), 
/*  46 */         getCustomerAppVersion().appendVersion(getCustomerPatchVersion()), 
/*  47 */         Version.getBuildDate(), 
/*  48 */         Version.getCustomerBuildDate());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion getBaseAppVersion() {
/*  54 */     return UniversalVersion.make(Version.getBaseVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion getBaseSchemaVersion(SchemaVersionScope argScope) {
/*  60 */     IVersion schemaVersion = getSchemaVersionObject(argScope);
/*  61 */     return (schemaVersion == null) ? UniversalVersion.makeUnknown() : UniversalVersion.make(schemaVersion.getBaseSchemaVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion getCustomerAppVersion() {
/*  67 */     return UniversalVersion.make(Version.getCustomerVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion getCustomerPatchVersion() {
/*  73 */     return UniversalVersion.make(Version.getPatchVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion getCustomerSchemaVersion(SchemaVersionScope argScope) {
/*  79 */     IVersion schemaVersion = getSchemaVersionObject(argScope);
/*  80 */     return (schemaVersion == null) ? UniversalVersion.makeUnknown() : UniversalVersion.make(schemaVersion.getCustomerSchemaVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionInfo getSchemaVersionInfo(SchemaVersionScope argScope) {
/*  86 */     IVersion schemaVersion = getSchemaVersionObject(argScope);
/*  87 */     String versionName = "Database [" + argScope.name() + "]";
/*     */     
/*  89 */     return (schemaVersion == null) ? new VersionInfo(versionName) : new VersionInfo(versionName, schemaVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> hashCodes() {
/* 100 */     return Version.getHashCodes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IVersion getSchemaVersionObject(SchemaVersionScope argScope) {
/* 111 */     IVersion schemaVersion = this._schemaVersionMap.get(argScope);
/*     */     
/* 113 */     if (schemaVersion == null) {
/* 114 */       Map<String, Object> params = new HashMap<>();
/* 115 */       params.put("argOrganizationId", Long.valueOf(ConfigurationMgr.getOrganizationId()));
/* 116 */       List<IVersion> versions = null;
/*     */       
/*     */       try {
/* 119 */         IQueryResultList<IVersion> iQueryResultList = DataFactory.getObjectByQuery(SCHEMA_VERSION, params, argScope.getPmType());
/* 120 */         schemaVersion = iQueryResultList.get(0);
/* 121 */         this._schemaVersionMap.put(argScope, schemaVersion);
/*     */       }
/* 123 */       catch (Throwable ex) {
/* 124 */         _logger.warn("No database schema version could be determined! [" + ex + "]");
/*     */       } 
/*     */     } 
/* 127 */     return schemaVersion;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionHelperImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */