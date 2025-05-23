/*    */ package dtv.pos.framework.scope;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public final class ValueKey<T>
/*    */   implements Serializable, Comparable<ValueKey<?>>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final Class<T> _valueClass;
/*    */   private final String _name;
/*    */   
/*    */   public ValueKey(Class<T> argClass, String argName) {
/* 31 */     this._valueClass = argClass;
/* 32 */     this._name = argName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int compareTo(ValueKey<?> argO) {
/* 38 */     return getName().compareTo(argO.getName());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 44 */     if (argObj == null) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!(argObj instanceof ValueKey)) {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     ValueKey<?> other = (ValueKey)argObj;
/*    */     
/* 54 */     if (getName() == null) {
/* 55 */       return (other.getName() == null);
/*    */     }
/*    */     
/* 58 */     return getName().equals(other.getName());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 67 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<T> getValueClass() {
/* 76 */     return this._valueClass;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 82 */     return this._name.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 88 */     return "ValueKey [" + this._name + "]<" + this._valueClass + ">";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\ValueKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */