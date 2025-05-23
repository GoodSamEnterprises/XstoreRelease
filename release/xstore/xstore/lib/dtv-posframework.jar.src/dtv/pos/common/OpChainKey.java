/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.util.StringUtils;
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
/*     */ public class OpChainKey
/*     */   implements IXstActionKey, Comparable<OpChainKey>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static Map<String, OpChainKey> _values;
/*     */   private final String _name;
/*     */   
/*     */   public static OpChainKey valueOf(String argName) {
/*  42 */     OpChainKey match = null;
/*     */     
/*  44 */     if (!StringUtils.isEmpty(argName)) {
/*  45 */       if (_values != null) {
/*  46 */         match = _values.get(normalize(argName));
/*     */       }
/*  48 */       if (match == null) {
/*  49 */         match = new OpChainKey(argName);
/*     */       }
/*     */     } 
/*  52 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  58 */     return argName.trim().toUpperCase();
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
/*     */   protected OpChainKey(String argName) {
/*  73 */     this._name = normalize(argName);
/*  74 */     if (_values == null) {
/*  75 */       _values = new HashMap<>();
/*     */     }
/*  77 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(OpChainKey argOther) {
/*  83 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  89 */     if (argObj == this) {
/*  90 */       return true;
/*     */     }
/*  92 */     if (!(argObj instanceof OpChainKey)) {
/*  93 */       return false;
/*     */     }
/*  95 */     return (new EqualsBuilder()).append(this._name, ((OpChainKey)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey get(String argKey) {
/* 101 */     return valueOf(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 107 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 113 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\OpChainKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */