/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
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
/*     */ public class PromptKey
/*     */   implements Comparable<PromptKey>
/*     */ {
/*  24 */   private static ConcurrentMap<String, PromptKey> _values = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  27 */   public static final PromptKey DEFAULT = valueOf("DEFAULT");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String _name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PromptKey valueOf(String argName) {
/*  42 */     PromptKey match = null;
/*     */     
/*  44 */     if (!StringUtils.isEmpty(argName)) {
/*  45 */       String name = normalize(argName);
/*     */ 
/*     */       
/*  48 */       match = _values.get(name);
/*     */ 
/*     */       
/*  51 */       if (match == null) {
/*  52 */         PromptKey created = new PromptKey(name);
/*  53 */         PromptKey prior = _values.putIfAbsent(name, created);
/*  54 */         match = (prior != null) ? prior : created;
/*     */       } 
/*     */     } 
/*  57 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  63 */     return argName.trim().toUpperCase();
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
/*     */   private PromptKey(String argName) {
/*  76 */     this._name = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(PromptKey argOther) {
/*  82 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  88 */     if (argObj == this) {
/*  89 */       return true;
/*     */     }
/*  91 */     if (!(argObj instanceof PromptKey)) {
/*  92 */       return false;
/*     */     }
/*  94 */     return (new EqualsBuilder()).append(this._name, ((PromptKey)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 100 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 106 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\PromptKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */