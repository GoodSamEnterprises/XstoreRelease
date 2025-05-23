/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.security.ISecured;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrivilegeType
/*     */   implements ISecured, Comparable<PrivilegeType>
/*     */ {
/*     */   private static Map<String, PrivilegeType> _values;
/*     */   private final String _name;
/*     */   
/*     */   public static PrivilegeType valueOf(String argName) {
/*  41 */     PrivilegeType match = null;
/*     */     
/*  43 */     if (!StringUtils.isEmpty(argName)) {
/*  44 */       if (_values != null) {
/*  45 */         match = _values.get(normalize(argName));
/*     */       }
/*  47 */       if (match == null) {
/*  48 */         match = new PrivilegeType(argName);
/*     */       }
/*     */     } 
/*  51 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  57 */     return argName.trim().toUpperCase();
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
/*     */   protected PrivilegeType(String argName) {
/*  72 */     this._name = normalize(argName);
/*  73 */     if (_values == null) {
/*  74 */       _values = new HashMap<>();
/*     */     }
/*  76 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(PrivilegeType argOther) {
/*  82 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  88 */     if (argObj == this) {
/*  89 */       return true;
/*     */     }
/*  91 */     if (!(argObj instanceof PrivilegeType)) {
/*  92 */       return false;
/*     */     }
/*  94 */     return (new EqualsBuilder()).append(this._name, ((PrivilegeType)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilege() {
/* 100 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 106 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 112 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\PrivilegeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */