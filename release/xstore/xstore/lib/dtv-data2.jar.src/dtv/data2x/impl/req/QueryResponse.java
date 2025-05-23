/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.data2.access.IQueryResult;
/*    */ import dtv.data2x.req.IQueryResponse;
/*    */ import dtv.servicex.impl.req.ServiceResponse;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
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
/*    */ public class QueryResponse<R extends IQueryResult>
/*    */   extends ServiceResponse
/*    */   implements IQueryResponse<R>
/*    */ {
/*    */   private final List<R> _queryResults;
/*    */   
/*    */   public QueryResponse() {
/* 32 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public QueryResponse(List<? extends R> argQueryResults) {
/* 41 */     List<R> noQueryResults = Collections.emptyList();
/* 42 */     this._queryResults = (argQueryResults == null) ? noQueryResults : new ArrayList<>(argQueryResults);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 48 */     if (argObj == this) {
/* 49 */       return true;
/*    */     }
/* 51 */     if (!(argObj instanceof QueryResponse)) {
/* 52 */       return false;
/*    */     }
/* 54 */     QueryResponse<?> other = (QueryResponse)argObj;
/* 55 */     return (new EqualsBuilder())
/* 56 */       .append(this._queryResults, other._queryResults)
/* 57 */       .appendSuper(super.equals(argObj)).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<? extends R> getResults() {
/* 63 */     return this._queryResults;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 69 */     return (new HashCodeBuilder(17, 37))
/* 70 */       .append(this._queryResults)
/* 71 */       .appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     return (new ToStringBuilder(this))
/* 78 */       .append("queryResults", this._queryResults)
/* 79 */       .appendSuper(super.toString()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\QueryResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */