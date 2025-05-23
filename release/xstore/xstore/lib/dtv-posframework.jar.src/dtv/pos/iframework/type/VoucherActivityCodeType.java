/*     */ package dtv.pos.iframework.type;
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
/*     */ public class VoucherActivityCodeType
/*     */ {
/*     */   private static Map<String, VoucherActivityCodeType> _values;
/*  24 */   public static final VoucherActivityCodeType ISSUED = valueOf("ISSUED");
/*  25 */   public static final VoucherActivityCodeType REDEEMED = valueOf("REDEEMED");
/*  26 */   public static final VoucherActivityCodeType RELOAD = valueOf("RELOAD");
/*  27 */   public static final VoucherActivityCodeType LOOKUP = valueOf("LOOKUP");
/*  28 */   public static final VoucherActivityCodeType CASHOUT = valueOf("CASHOUT");
/*  29 */   public static final VoucherActivityCodeType INQUIRE_BALANCE = valueOf("INQUIRE_BALANCE");
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
/*     */   public static VoucherActivityCodeType valueOf(String argName) {
/*  44 */     VoucherActivityCodeType match = null;
/*     */     
/*  46 */     if (!StringUtils.isEmpty(argName)) {
/*  47 */       if (_values != null) {
/*  48 */         match = _values.get(normalize(argName));
/*     */       }
/*  50 */       if (match == null) {
/*  51 */         match = new VoucherActivityCodeType(argName);
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
/*     */   protected VoucherActivityCodeType(String argName) {
/*  75 */     this._name = normalize(argName);
/*  76 */     if (_values == null) {
/*  77 */       _values = new HashMap<>();
/*     */     }
/*  79 */     _values.put(this._name, this);
/*     */   }
/*     */   
/*     */   public int compareTo(VoucherActivityCodeType argOther) {
/*  83 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  89 */     if (argObj == this) {
/*  90 */       return true;
/*     */     }
/*  92 */     if (!(argObj instanceof VoucherActivityCodeType)) {
/*  93 */       return false;
/*     */     }
/*  95 */     return (new EqualsBuilder()).append(this._name, ((VoucherActivityCodeType)argObj)._name).isEquals();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String argName) {
/* 112 */     return this._name.equalsIgnoreCase(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 118 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\VoucherActivityCodeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */