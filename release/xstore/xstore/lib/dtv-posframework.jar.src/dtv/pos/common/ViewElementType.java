/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.pos.iframework.ui.IViewElementType;
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
/*     */ 
/*     */ public class ViewElementType
/*     */   implements IViewElementType, Comparable<ViewElementType>
/*     */ {
/*  26 */   private static ConcurrentMap<String, IViewElementType> _values = new ConcurrentHashMap<>();
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
/*     */   public static IViewElementType valueOf(String argName) {
/*  39 */     IViewElementType match = null;
/*     */     
/*  41 */     if (!StringUtils.isEmpty(argName)) {
/*  42 */       String name = normalize(argName);
/*     */ 
/*     */       
/*  45 */       match = _values.get(name);
/*     */ 
/*     */       
/*  48 */       if (match == null) {
/*  49 */         IViewElementType created = new ViewElementType(name);
/*  50 */         IViewElementType prior = _values.putIfAbsent(name, created);
/*  51 */         match = (prior != null) ? prior : created;
/*     */       } 
/*     */     } 
/*  54 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  60 */     return argName.trim().toUpperCase();
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
/*     */   private ViewElementType(String argName) {
/*  75 */     this._name = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ViewElementType argOther) {
/*  81 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  87 */     if (argObj == this) {
/*  88 */       return true;
/*     */     }
/*  90 */     if (!(argObj instanceof ViewElementType)) {
/*  91 */       return false;
/*     */     }
/*  93 */     return (new EqualsBuilder()).append(this._name, ((ViewElementType)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  99 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 105 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\ViewElementType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */