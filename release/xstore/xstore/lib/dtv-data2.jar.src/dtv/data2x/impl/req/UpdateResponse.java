/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.data2x.req.IUpdateResponse;
/*    */ import dtv.servicex.impl.req.ServiceResponse;
/*    */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*    */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*    */ public class UpdateResponse
/*    */   extends ServiceResponse
/*    */   implements IUpdateResponse
/*    */ {
/*    */   private final int _updatedCount;
/*    */   
/*    */   public UpdateResponse() {
/* 30 */     this(-2147483648);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UpdateResponse(int argUpdatedCount) {
/* 39 */     this._updatedCount = (argUpdatedCount < 0) ? Integer.MIN_VALUE : argUpdatedCount;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 45 */     if (argObj == this) {
/* 46 */       return true;
/*    */     }
/* 48 */     if (!(argObj instanceof UpdateResponse)) {
/* 49 */       return false;
/*    */     }
/* 51 */     UpdateResponse other = (UpdateResponse)argObj;
/* 52 */     return (new EqualsBuilder()).append(this._updatedCount, other._updatedCount).appendSuper(super.equals(argObj))
/* 53 */       .isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUpdatedCount() {
/* 59 */     return this._updatedCount;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     return (new HashCodeBuilder(17, 37)).append(this._updatedCount).appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     return (new ToStringBuilder(this)).append("updatedCount", this._updatedCount).appendSuper(super.toString())
/* 72 */       .toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\UpdateResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */