/*    */ package dtv.pos.framework.action.type;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstActionType;
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
/*    */ public class XstMenuActionType
/*    */   implements IXstActionType
/*    */ {
/*    */   private static Map<String, XstMenuActionType> _values;
/* 26 */   public static final XstMenuActionType MENU = new XstMenuActionType("MENU");
/*    */   
/*    */   private final String _name;
/*    */   
/*    */   private static final String normalize(String argName) {
/* 31 */     return argName.trim().toUpperCase();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private XstMenuActionType(String argName) {
/* 43 */     this._name = normalize(argName);
/*    */     
/* 45 */     if (_values == null) {
/* 46 */       _values = new HashMap<>();
/*    */     }
/*    */     
/* 49 */     _values.put(this._name, this);
/*    */   }
/*    */   
/*    */   public int compareTo(XstMenuActionType argOther) {
/* 53 */     return this._name.compareTo(argOther._name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 59 */     if (argObj == this) {
/* 60 */       return true;
/*    */     }
/*    */     
/* 63 */     if (!(argObj instanceof XstMenuActionType)) {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     return (new EqualsBuilder()).append(this._name, ((XstMenuActionType)argObj)._name).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 73 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 79 */     return this._name;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\XstMenuActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */