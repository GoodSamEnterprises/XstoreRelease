/*     */ package dtv.data2x.impl.req;
/*     */ 
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResult;
/*     */ import dtv.data2x.req.IQueryRequest;
/*     */ import dtv.servicex.impl.req.ServiceRequest;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryRequest<R extends IQueryResult>
/*     */   extends ServiceRequest
/*     */   implements IQueryRequest<R>
/*     */ {
/*  27 */   private static final Map<String, Object> _noQueryParams = Collections.emptyMap();
/*     */ 
/*     */   
/*     */   private final IQueryKey<? extends R> _queryKey;
/*     */ 
/*     */   
/*     */   private final Map<String, Object> _queryParams;
/*     */ 
/*     */   
/*     */   public QueryRequest(IQueryKey<? extends R> argQueryKey) {
/*  37 */     this(argQueryKey, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QueryRequest(IQueryKey<? extends R> argQueryKey, Map<String, Object> argQueryParams) {
/*  48 */     this._queryParams = (argQueryParams == null) ? _noQueryParams : new HashMap<>(argQueryParams);
/*  49 */     this._queryKey = argQueryKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QueryRequest(Map<String, Object> argQueryParams) {
/*  57 */     this(null, argQueryParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  63 */     if (argObj == this) {
/*  64 */       return true;
/*     */     }
/*  66 */     if (!(argObj instanceof QueryRequest)) {
/*  67 */       return false;
/*     */     }
/*  69 */     QueryRequest<?> other = (QueryRequest)argObj;
/*  70 */     return (new EqualsBuilder())
/*  71 */       .append(this._queryParams, other._queryParams)
/*  72 */       .append(this._queryKey, other._queryKey)
/*  73 */       .appendSuper(super.equals(argObj)).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IQueryKey<? extends R> getQueryKey() {
/*  79 */     return this._queryKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> getQueryParams() {
/*  85 */     return this._queryParams;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return (new HashCodeBuilder(17, 37))
/*  92 */       .append(this._queryParams)
/*  93 */       .append(this._queryKey)
/*  94 */       .appendSuper(super.hashCode()).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     return (new ToStringBuilder(this))
/* 101 */       .append("queryParams", this._queryParams)
/* 102 */       .append("queryKey", this._queryKey)
/* 103 */       .appendSuper(super.toString()).toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\QueryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */