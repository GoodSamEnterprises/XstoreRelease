/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.data2.access.DaoUtils;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*    */ import dtv.util.ObjectUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleValueWrapper
/*    */   implements IEnumValueWrapper
/*    */ {
/*    */   private Object value_;
/*    */   private int hashCode_;
/*    */   
/*    */   private static boolean equivalent(Object o1, Object o2) {
/* 21 */     if (o1 instanceof IDataModel) {
/* 22 */       if (o2 instanceof IDataModel)
/*    */       {
/* 24 */         return DaoUtils.equivalent((IDataModel)o1, (IDataModel)o2);
/*    */       }
/*    */ 
/*    */       
/* 28 */       return false;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 33 */     return ObjectUtils.equivalent(o1, o2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 42 */     if (argOther == this) {
/* 43 */       return true;
/*    */     }
/* 45 */     if (argOther == null) {
/* 46 */       return (this.value_ == null);
/*    */     }
/* 48 */     if (!(argOther instanceof SimpleValueWrapper)) {
/* 49 */       return equivalent(this.value_, argOther);
/*    */     }
/* 51 */     SimpleValueWrapper other = (SimpleValueWrapper)argOther;
/* 52 */     return equivalent(this.value_, other.value_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getActualValue() {
/* 57 */     return this.value_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 62 */     return this.hashCode_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setActualValue(Object newValue) {
/* 67 */     this.value_ = newValue;
/* 68 */     if (this.value_ == null) {
/* 69 */       this.hashCode_ = 0;
/*    */     }
/* 71 */     else if (this.value_ instanceof IDataModel) {
/* 72 */       this.hashCode_ = ((IDataModel)this.value_).getObjectId().hashCode();
/*    */     } else {
/*    */       
/* 75 */       this.hashCode_ = this.value_.hashCode();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 81 */     if (this.value_ == null) {
/* 82 */       return "";
/*    */     }
/*    */     
/* 85 */     return this.value_.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\SimpleValueWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */