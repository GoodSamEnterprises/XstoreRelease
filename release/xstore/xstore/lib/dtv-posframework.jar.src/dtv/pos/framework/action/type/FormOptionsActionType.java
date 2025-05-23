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
/*     */ public class FormOptionsActionType
/*     */   implements IXstActionType, Comparable<FormOptionsActionType>
/*     */ {
/*     */   private static Map<String, FormOptionsActionType> _values;
/*  29 */   public static final FormOptionsActionType STANDARD = valueOf("STANDARD");
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
/*     */   public static FormOptionsActionType valueOf(String argName) {
/*  44 */     FormOptionsActionType match = null;
/*     */     
/*  46 */     if (!StringUtils.isEmpty(argName)) {
/*  47 */       if (_values != null) {
/*  48 */         match = _values.get(normalize(argName));
/*     */       }
/*     */       
/*  51 */       if (match == null) {
/*  52 */         match = new FormOptionsActionType(argName);
/*     */       }
/*     */     } 
/*     */     
/*  56 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  62 */     return argName.trim().toUpperCase();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FormOptionsActionType(String argName) {
/*  73 */     this._name = normalize(argName);
/*     */     
/*  75 */     if (_values == null) {
/*  76 */       _values = new HashMap<>();
/*     */     }
/*     */     
/*  79 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(FormOptionsActionType argOther) {
/*  85 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  91 */     if (argObj == this) {
/*  92 */       return true;
/*     */     }
/*     */     
/*  95 */     if (!(argObj instanceof FormOptionsActionType)) {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     return (new EqualsBuilder()).append(this._name, ((FormOptionsActionType)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 111 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\FormOptionsActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */