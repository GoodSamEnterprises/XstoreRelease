/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2x.req.IRetrieveRequest;
/*    */ import dtv.servicex.impl.req.ServiceRequest;
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
/*    */ 
/*    */ public class RetrieveRequest<I extends IObjectId>
/*    */   extends ServiceRequest
/*    */   implements IRetrieveRequest<I>
/*    */ {
/*    */   private final I _dataModelId;
/*    */   
/*    */   public RetrieveRequest(I argDataModelId) {
/* 32 */     this._dataModelId = argDataModelId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 38 */     if (argObj == this) {
/* 39 */       return true;
/*    */     }
/* 41 */     if (!(argObj instanceof RetrieveRequest)) {
/* 42 */       return false;
/*    */     }
/* 44 */     RetrieveRequest<?> other = (RetrieveRequest)argObj;
/* 45 */     return (new EqualsBuilder())
/* 46 */       .append(this._dataModelId, other._dataModelId)
/* 47 */       .appendSuper(super.equals(argObj)).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public I getModelId() {
/* 53 */     return this._dataModelId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 59 */     return (new HashCodeBuilder(17, 37))
/* 60 */       .append(this._dataModelId)
/* 61 */       .appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 67 */     return (new ToStringBuilder(this))
/* 68 */       .append("dataModelId", this._dataModelId)
/* 69 */       .appendSuper(super.toString()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\RetrieveRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */