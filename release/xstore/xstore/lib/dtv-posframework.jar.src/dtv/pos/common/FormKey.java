/*     */ package dtv.pos.common;
/*     */ 
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
/*     */ public class FormKey
/*     */   implements Comparable<FormKey>
/*     */ {
/*     */   private static Map<String, FormKey> _values;
/*     */   private final String _name;
/*     */   
/*     */   public static FormKey valueOf(String argName) {
/*  39 */     FormKey match = null;
/*     */     
/*  41 */     if (!StringUtils.isEmpty(argName)) {
/*  42 */       if (_values != null) {
/*  43 */         match = _values.get(normalize(argName));
/*     */       }
/*  45 */       if (match == null) {
/*  46 */         match = new FormKey(argName);
/*     */       }
/*     */     } 
/*  49 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  55 */     return argName.trim().toUpperCase();
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
/*     */   protected FormKey(String argName) {
/*  69 */     this._name = normalize(argName);
/*  70 */     if (_values == null) {
/*  71 */       _values = new HashMap<>();
/*     */     }
/*  73 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(FormKey argOther) {
/*  79 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  85 */     if (argObj == this) {
/*  86 */       return true;
/*     */     }
/*  88 */     if (!(argObj instanceof FormKey)) {
/*  89 */       return false;
/*     */     }
/*  91 */     return (new EqualsBuilder()).append(this._name, ((FormKey)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  97 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 103 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\FormKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */