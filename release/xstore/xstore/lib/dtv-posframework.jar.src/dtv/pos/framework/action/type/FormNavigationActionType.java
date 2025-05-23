/*     */ package dtv.pos.framework.action.type;
/*     */ 
/*     */ import dtv.pos.iframework.action.IXstActionType;
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
/*     */ public class FormNavigationActionType
/*     */   implements IXstActionType, Comparable<FormNavigationActionType>
/*     */ {
/*     */   private static Map<String, FormNavigationActionType> _values;
/*  30 */   public static final FormNavigationActionType STANDARD = valueOf("STANDARD");
/*     */ 
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
/*     */   
/*     */   public static FormNavigationActionType valueOf(String argName) {
/*  47 */     FormNavigationActionType match = null;
/*     */     
/*  49 */     if (!StringUtils.isEmpty(argName)) {
/*  50 */       if (_values != null) {
/*  51 */         match = _values.get(normalize(argName));
/*     */       }
/*  53 */       if (match == null) {
/*  54 */         match = new FormNavigationActionType(argName);
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
/*     */   private FormNavigationActionType(String argName) {
/*  74 */     this._name = normalize(argName);
/*  75 */     if (_values == null) {
/*  76 */       _values = new HashMap<>();
/*     */     }
/*  78 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(FormNavigationActionType argOther) {
/*  84 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  90 */     if (argObj == this) {
/*  91 */       return true;
/*     */     }
/*  93 */     if (!(argObj instanceof FormNavigationActionType)) {
/*  94 */       return false;
/*     */     }
/*  96 */     return (new EqualsBuilder()).append(this._name, ((FormNavigationActionType)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 102 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 108 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\FormNavigationActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */