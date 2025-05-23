/*     */ package dtv.pos.framework.version;
/*     */ 
/*     */ import dtv.xst.dao.ctl.IVersion;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VersionInfo
/*     */   implements Comparable<VersionInfo>
/*     */ {
/*  24 */   private static final IVersionFormatter _versionFormatter = VersionFormatter.createStandardFormatter();
/*     */   
/*     */   private final String _name;
/*     */   
/*     */   private final String _baseVersion;
/*     */   private final String _customerVersion;
/*     */   private final String _combinedVersion;
/*     */   private final Date _baseDate;
/*     */   private final Date _customerDate;
/*  33 */   private String toString_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionInfo(String argName) {
/*  40 */     this(argName, UniversalVersion.makeUnknown(), UniversalVersion.makeUnknown(), null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionInfo(String argName, IVersion argVersionData) {
/*  50 */     this(argName, 
/*  51 */         UniversalVersion.make(argVersionData.getBaseSchemaVersion()), 
/*  52 */         UniversalVersion.make(argVersionData.getCustomerSchemaVersion()), argVersionData
/*  53 */         .getBaseSchemaDate(), argVersionData
/*  54 */         .getCustomerSchemaDate());
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
/*     */   
/*     */   public VersionInfo(String argName, UniversalVersion argBaseVersion, UniversalVersion argCustomerVersion, Date argBaseDate, Date argCustomerDate) {
/*  70 */     this._name = argName;
/*  71 */     this._baseVersion = _versionFormatter.format(argBaseVersion);
/*  72 */     this._baseDate = argBaseDate;
/*  73 */     this._customerVersion = _versionFormatter.format(argCustomerVersion);
/*  74 */     this._customerDate = argCustomerDate;
/*     */     
/*  76 */     this._combinedVersion = _versionFormatter.format(argBaseVersion.appendVersion(argCustomerVersion));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(VersionInfo argObj) {
/*  82 */     return this._name.compareTo(argObj.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  88 */     if (argOther == this) {
/*  89 */       return true;
/*     */     }
/*  91 */     if (!(argOther instanceof VersionInfo)) {
/*  92 */       return false;
/*     */     }
/*  94 */     VersionInfo other = (VersionInfo)argOther;
/*     */     
/*  96 */     return other.getName().equals(this._name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBaseDate() {
/* 104 */     return this._baseDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseVersion() {
/* 112 */     return this._baseVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCustomerDate() {
/* 120 */     return this._customerDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerVersion() {
/* 128 */     return this._customerVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 136 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 142 */     int result = 17;
/* 143 */     result = 37 * result + this._name.hashCode();
/* 144 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     if (this.toString_ == null) {
/* 151 */       StringBuilder sb = new StringBuilder();
/* 152 */       sb.append(this._name);
/* 153 */       sb.append(" version ");
/* 154 */       sb.append(this._combinedVersion);
/* 155 */       sb.append(" (");
/* 156 */       sb.append(this._customerDate);
/* 157 */       sb.append(")");
/*     */       
/* 159 */       this.toString_ = sb.toString();
/*     */     } 
/*     */     
/* 162 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */