/*    */ package dtv.pos.iframework.type;
/*    */ 
/*    */ import dtv.pos.iframework.form.IListEditModel;
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
/*    */ public class ModelKey<M extends IListEditModel<Object>>
/*    */   implements Comparable<ModelKey<?>>
/*    */ {
/*    */   private final String _name;
/*    */   
/*    */   private static final String normalize(String argName) {
/* 24 */     return argName.trim().toUpperCase();
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
/*    */   public ModelKey(String argName) {
/* 36 */     this._name = normalize(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int compareTo(ModelKey<?> argOther) {
/* 46 */     return this._name.compareTo(argOther._name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 52 */     if (argObj == this) {
/* 53 */       return true;
/*    */     }
/* 55 */     if (!(argObj instanceof ModelKey)) {
/* 56 */       return false;
/*    */     }
/* 58 */     return (new EqualsBuilder()).append(this._name, ((ModelKey)argObj)._name).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 64 */     return (new HashCodeBuilder(17, 37)).append(this._name).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 70 */     return this._name;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\ModelKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */