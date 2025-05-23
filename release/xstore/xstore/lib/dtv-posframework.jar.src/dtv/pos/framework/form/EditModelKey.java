/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.mapping.IEditModelKey;
/*    */ import dtv.util.StringUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EditModelKey
/*    */   implements IEditModelKey, Comparable<EditModelKey>
/*    */ {
/*    */   private static Map<String, IEditModelKey> _values;
/*    */   private final String _name;
/*    */   
/*    */   public static IEditModelKey valueOf(String argName) {
/* 41 */     IEditModelKey match = null;
/*    */     
/* 43 */     if (!StringUtils.isEmpty(argName)) {
/* 44 */       if (_values != null) {
/* 45 */         match = _values.get(normalize(argName));
/*    */       }
/* 47 */       if (match == null) {
/* 48 */         match = new EditModelKey(argName);
/*    */       }
/*    */     } 
/* 51 */     return match;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String normalize(String argName) {
/* 57 */     return argName.trim().toUpperCase();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private EditModelKey(String argName) {
/* 65 */     this._name = normalize(argName);
/* 66 */     if (_values == null) {
/* 67 */       _values = new HashMap<>();
/*    */     }
/* 69 */     _values.put(this._name, this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int compareTo(EditModelKey argOther) {
/* 75 */     return this._name.compareTo(argOther._name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 81 */     if (argObj == this) {
/* 82 */       return true;
/*    */     }
/* 84 */     if (!(argObj instanceof EditModelKey)) {
/* 85 */       return false;
/*    */     }
/* 87 */     return (new EqualsBuilder()).append(this._name, ((EditModelKey)argObj)._name).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 93 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 99 */     return this._name;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */