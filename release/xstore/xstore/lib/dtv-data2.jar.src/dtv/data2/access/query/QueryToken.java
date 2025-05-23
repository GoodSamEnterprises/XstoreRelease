/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.transaction.DataSourceTransactionException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ThreadLocalRandom;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryToken
/*     */ {
/*     */   private static final String NODE_SEPARATOR = ":";
/*     */   private static final String GET_BY_ID_PREFIX = "getById:";
/*     */   private static final String GET_BY_QUERY_PREFIX = "getByQuery:";
/*     */   private final String _uniqueId;
/*  30 */   private final Set<IQueryResource> _queryResources = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QueryToken(IObjectId argId, IPersistenceMgrType argType) {
/*  39 */     StringBuilder buf = new StringBuilder(128);
/*  40 */     buf.append("getById:");
/*  41 */     buf.append(argId.toString()).append(":");
/*  42 */     buf.append(argId.hashCode()).append(":");
/*  43 */     buf.append(argType.getName()).append(":");
/*  44 */     buf.append(argType.hashCode()).append(":");
/*  45 */     buf.append(System.currentTimeMillis()).append(":");
/*  46 */     buf.append(Thread.currentThread().getId()).append(":");
/*  47 */     buf.append(ThreadLocalRandom.current().nextFloat());
/*  48 */     this._uniqueId = buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QueryToken(QueryRequest argQueryRequest) {
/*  57 */     StringBuilder buf = new StringBuilder(128);
/*  58 */     buf.append("getByQuery:");
/*  59 */     buf.append(argQueryRequest.toString()).append(":");
/*  60 */     buf.append(argQueryRequest.hashCode()).append(":");
/*  61 */     buf.append(System.currentTimeMillis()).append(":");
/*  62 */     buf.append(Thread.currentThread().getId()).append(":");
/*  63 */     buf.append(ThreadLocalRandom.current().nextFloat());
/*  64 */     this._uniqueId = buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<IQueryResource> drainQueryResources() {
/*  72 */     synchronized (this._queryResources) {
/*  73 */       Set<IQueryResource> datasources = new HashSet<>(this._queryResources);
/*  74 */       this._queryResources.clear();
/*  75 */       return datasources;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  82 */     if (this == obj) {
/*  83 */       return true;
/*     */     }
/*  85 */     if (obj == null) {
/*  86 */       return false;
/*     */     }
/*  88 */     if (getClass() != obj.getClass()) {
/*  89 */       return false;
/*     */     }
/*  91 */     QueryToken other = (QueryToken)obj;
/*  92 */     if (this._uniqueId == null) {
/*  93 */       if (other._uniqueId != null) {
/*  94 */         return false;
/*     */       }
/*     */     }
/*  97 */     else if (!this._uniqueId.equals(other._uniqueId)) {
/*  98 */       return false;
/*     */     } 
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IQueryResource> T getQueryResource(String argDataSource, Class<T> argType) {
/* 112 */     if (argDataSource == null) {
/* 113 */       throw new DtxException("getQueryResource was called without a datasource name.  This is not supported.");
/*     */     }
/* 115 */     if (argType == null) {
/* 116 */       throw new DtxException("getQueryResource was called without a type parameter.  This is not supported.");
/*     */     }
/*     */     
/* 119 */     synchronized (this._queryResources) {
/* 120 */       for (IQueryResource resource : this._queryResources) {
/* 121 */         if (argDataSource.equals(resource.getDataSourceName()) && argType.isInstance(resource)) {
/* 122 */           return (T)resource;
/*     */         }
/*     */       } 
/*     */     } 
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 132 */     int prime = 31;
/* 133 */     int result = 1;
/* 134 */     result = 31 * result + ((this._uniqueId == null) ? 0 : this._uniqueId.hashCode());
/* 135 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerQueryResource(IQueryResource argCloseableResource) {
/* 143 */     if (argCloseableResource == null) {
/* 144 */       throw new DataSourceTransactionException("Cannot register a null query resource to QueryToken " + this);
/*     */     }
/*     */     
/* 147 */     synchronized (this._queryResources) {
/*     */       
/* 149 */       this._queryResources.add(argCloseableResource);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     synchronized (this._queryResources) {
/* 157 */       return "QueryToken [_uniqueId=" + this._uniqueId + ", queryResources=" + this._queryResources + "]";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryToken.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */