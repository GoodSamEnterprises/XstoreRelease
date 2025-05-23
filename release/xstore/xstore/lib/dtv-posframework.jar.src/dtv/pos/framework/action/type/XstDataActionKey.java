/*     */ package dtv.pos.framework.action.type;
/*     */ 
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstDataActionKey;
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
/*     */ 
/*     */ 
/*     */ public class XstDataActionKey
/*     */   implements IXstDataActionKey, Comparable<XstDataActionKey>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static Map<String, IXstDataActionKey> _values;
/*  42 */   public static final IXstDataActionKey CANCEL = valueOf("CANCEL");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static final IXstDataActionKey ACCEPT = valueOf("ACCEPT");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final IXstDataActionKey YES = valueOf("YES");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final IXstDataActionKey NO = valueOf("NO");
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
/*     */   public static IXstDataActionKey valueOf(String argName) {
/*  74 */     IXstDataActionKey match = null;
/*     */     
/*  76 */     if (!StringUtils.isEmpty(argName)) {
/*  77 */       if (_values != null) {
/*  78 */         match = _values.get(normalize(argName));
/*     */       }
/*  80 */       if (match == null) {
/*  81 */         match = new XstDataActionKey(argName);
/*     */       }
/*     */     } 
/*  84 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String normalize(String argName) {
/*  90 */     return argName.trim().toUpperCase();
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
/*     */   protected XstDataActionKey(String argName) {
/* 105 */     this._name = normalize(argName);
/* 106 */     if (_values == null) {
/* 107 */       _values = new HashMap<>();
/*     */     }
/* 109 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(XstDataActionKey argOther) {
/* 115 */     return this._name.compareTo(argOther._name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/* 121 */     if (argObj == this) {
/* 122 */       return true;
/*     */     }
/* 124 */     if (!(argObj instanceof XstDataActionKey)) {
/* 125 */       return false;
/*     */     }
/* 127 */     return (new EqualsBuilder()).append(this._name, ((XstDataActionKey)argObj)._name).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey get(String argKey) {
/* 133 */     return (IXstActionKey)valueOf(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 139 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 145 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\XstDataActionKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */