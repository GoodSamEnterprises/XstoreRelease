/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2x.req.IRetrieveResponse;
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
/*    */ public class RetrieveResponse<M extends IDataModel>
/*    */   extends ServiceResponse
/*    */   implements IRetrieveResponse<M>
/*    */ {
/*    */   private final M _retrieveResult;
/*    */   
/*    */   public RetrieveResponse() {
/* 30 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RetrieveResponse(M argRetrieveResult) {
/* 39 */     this._retrieveResult = argRetrieveResult;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 45 */     if (argObj == this) {
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     if (!(argObj instanceof RetrieveResponse)) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     RetrieveResponse<?> other = (RetrieveResponse)argObj;
/* 54 */     return (new EqualsBuilder())
/* 55 */       .append(this._retrieveResult, other._retrieveResult)
/* 56 */       .appendSuper(super.equals(argObj)).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public M getResult() {
/* 62 */     return this._retrieveResult;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 68 */     return (new HashCodeBuilder(17, 37))
/* 69 */       .append(this._retrieveResult)
/* 70 */       .appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 76 */     return (new ToStringBuilder(this))
/* 77 */       .append("retrieveResult", this._retrieveResult)
/* 78 */       .appendSuper(super.toString()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\RetrieveResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */