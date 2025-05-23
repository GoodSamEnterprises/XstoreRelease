/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.data2.access.DaoUtils;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*    */ import dtv.xst.dao.loc.IRetailLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RetailLocationEnumValueWrapper
/*    */   implements IEnumValueWrapper
/*    */ {
/* 19 */   private String toString_ = null;
/* 20 */   private IRetailLocation value_ = null;
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 24 */     if (argOther == this) {
/* 25 */       return true;
/*    */     }
/* 27 */     if (argOther == null) {
/* 28 */       return (this.value_ == null);
/*    */     }
/* 30 */     if (argOther instanceof IRetailLocation) {
/* 31 */       IRetailLocation iRetailLocation = (IRetailLocation)argOther;
/* 32 */       return DaoUtils.equivalent((IDataModel)iRetailLocation, (IDataModel)this.value_);
/*    */     } 
/*    */     
/* 35 */     if (!(argOther instanceof RetailLocationEnumValueWrapper)) {
/* 36 */       return false;
/*    */     }
/* 38 */     RetailLocationEnumValueWrapper other = (RetailLocationEnumValueWrapper)argOther;
/* 39 */     return DaoUtils.equivalent((IDataModel)other.value_, (IDataModel)this.value_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getActualValue() {
/* 44 */     return this.value_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 49 */     if (this.value_ == null) {
/* 50 */       return 0;
/*    */     }
/*    */     
/* 53 */     return this.value_.getObjectId().hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setActualValue(Object newValue) {
/* 59 */     this.value_ = (IRetailLocation)newValue;
/* 60 */     if (this.value_ == null) {
/* 61 */       this.toString_ = "";
/*    */     } else {
/*    */       
/* 64 */       StringBuffer sb = new StringBuffer();
/* 65 */       sb.append(this.value_.getStoreNbr());
/* 66 */       if (this.value_.getDescription() != null) {
/* 67 */         sb.append(" - ");
/* 68 */         sb.append(this.value_.getDescription());
/*    */       } 
/* 70 */       this.toString_ = sb.toString();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 76 */     return this.toString_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\RetailLocationEnumValueWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */