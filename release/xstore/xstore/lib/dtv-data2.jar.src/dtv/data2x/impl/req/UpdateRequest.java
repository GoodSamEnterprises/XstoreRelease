/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.data2.access.IQueryKey;
/*    */ import dtv.data2x.req.IUpdateRequest;
/*    */ import dtv.servicex.impl.req.ServiceRequest;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class UpdateRequest
/*    */   extends ServiceRequest
/*    */   implements IUpdateRequest
/*    */ {
/* 25 */   private static final Map<String, Object> _noQueryParams = Collections.emptyMap();
/*    */ 
/*    */ 
/*    */   
/*    */   private final IQueryKey<Object[]> _queryKey;
/*    */ 
/*    */ 
/*    */   
/*    */   private final Map<String, Object> _queryParams;
/*    */ 
/*    */ 
/*    */   
/*    */   public UpdateRequest(IQueryKey<Object[]> argQueryKey, Map<String, Object> argQueryParams) {
/* 38 */     this._queryKey = argQueryKey;
/* 39 */     this._queryParams = (argQueryParams == null) ? _noQueryParams : new HashMap<>(argQueryParams);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 45 */     if (argObj == this) {
/* 46 */       return true;
/*    */     }
/* 48 */     if (!(argObj instanceof UpdateRequest)) {
/* 49 */       return false;
/*    */     }
/* 51 */     UpdateRequest other = (UpdateRequest)argObj;
/* 52 */     return (new EqualsBuilder()).append(this._queryKey, other._queryKey).append(this._queryParams, other._queryParams)
/* 53 */       .appendSuper(super.equals(argObj)).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IQueryKey<Object[]> getQueryKey() {
/* 59 */     return this._queryKey;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Object> getQueryParams() {
/* 65 */     return this._queryParams;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 71 */     return (new HashCodeBuilder(17, 37)).append(this._queryKey).append(this._queryParams).appendSuper(super.hashCode())
/* 72 */       .toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     return (new ToStringBuilder(this)).append("queryKey", this._queryKey).append("queryParams", this._queryParams)
/* 79 */       .appendSuper(super.toString()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\UpdateRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */