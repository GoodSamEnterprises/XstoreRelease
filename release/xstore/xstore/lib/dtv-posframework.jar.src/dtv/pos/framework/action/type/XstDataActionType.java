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
/*     */ public class XstDataActionType
/*     */   implements IXstActionType, Comparable<XstDataActionType>
/*     */ {
/*     */   private static Map<String, XstDataActionType> _values;
/*  30 */   public static final XstDataActionType STANDARD = valueOf("STANDARD");
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
/*     */   public static XstDataActionType valueOf(String argName) {
/*  46 */     XstDataActionType match = null;
/*     */     
/*  48 */     if (!StringUtils.isEmpty(argName)) {
/*  49 */       if (_values != null) {
/*  50 */         match = _values.get(normalize(argName));
/*     */       }
/*  52 */       if (match == null) {
/*  53 */         match = new XstDataActionType(argName);
/*     */       }
/*     */     } 
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
/*     */   private XstDataActionType(String argName) {
/*  73 */     this._name = normalize(argName);
/*  74 */     if (_values == null) {
/*  75 */       _values = new HashMap<>();
/*     */     }
/*  77 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(XstDataActionType argOther) {
/*  83 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  89 */     if (argObj == this) {
/*  90 */       return true;
/*     */     }
/*  92 */     if (!(argObj instanceof XstDataActionType)) {
/*  93 */       return false;
/*     */     }
/*  95 */     return (new EqualsBuilder()).append(this._name, ((XstDataActionType)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 107 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\XstDataActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */