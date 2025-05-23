/*     */ package dtv.data2.access.transaction;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransactionToken
/*     */ {
/*     */   public static final String TIMESTAMP_PROPERTY = "TIMESTAMP_PROPERTY";
/*     */   public static final String WORKSTATION_ID_PROPERTY = "WORKSTATION_ID_PROPERTY";
/*  22 */   private static transient long _counter = (new Random()).nextLong();
/*     */ 
/*     */ 
/*     */   
/*  26 */   private static final transient Object sync_ = new Object();
/*     */   private final String _uniqueId;
/*  28 */   private final Set<ITransactionalDataSource> _datasources = new LinkedHashSet<>();
/*  29 */   private final Map<String, String> _properties = new HashMap<>();
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
/*     */   public TransactionToken(int argIdHash) {
/*  41 */     StringBuilder buf = new StringBuilder(64);
/*  42 */     buf.append(argIdHash);
/*  43 */     buf.append(System.currentTimeMillis());
/*     */     
/*  45 */     synchronized (sync_) {
/*  46 */       buf.append(++_counter);
/*     */     } 
/*     */     
/*  49 */     this._uniqueId = buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<ITransactionalDataSource> drainDataSources() {
/*  58 */     synchronized (this._datasources) {
/*  59 */       Set<ITransactionalDataSource> datasources = new LinkedHashSet<>(this._datasources);
/*  60 */       this._datasources.clear();
/*  61 */       return datasources;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObject) {
/*  73 */     if (argObject instanceof TransactionToken) {
/*  74 */       return this._uniqueId.equals(((TransactionToken)argObject)._uniqueId);
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITransactionalDataSource getDataSource(String argDataSource) {
/*  86 */     return getDataSource(argDataSource, ITransactionalDataSource.class);
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
/*     */   public <T extends ITransactionalDataSource> T getDataSource(String argDataSource, Class<T> argType) {
/*  98 */     if (argDataSource == null) {
/*  99 */       throw new DtxException("getDataSource was called without a datasource name.  This is not supported.");
/*     */     }
/* 101 */     if (argType == null) {
/* 102 */       throw new DtxException("getDataSource was called without a type parameter.  This is not supported.");
/*     */     }
/*     */     
/* 105 */     synchronized (this._datasources) {
/* 106 */       for (ITransactionalDataSource datasource : this._datasources) {
/* 107 */         if (argDataSource.equals(datasource.getDataSourceName()) && argType.isInstance(datasource)) {
/* 108 */           return (T)datasource;
/*     */         }
/*     */       } 
/*     */     } 
/* 112 */     return null;
/*     */   }
/*     */   
/*     */   public Map<String, String> getProperties() {
/* 116 */     return this._properties;
/*     */   }
/*     */   
/*     */   public String getProperty(String argPropertyName) {
/* 120 */     return this._properties.get(argPropertyName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/* 129 */     return this._uniqueId;
/*     */   }
/*     */   
/*     */   public boolean hasDatasources() {
/* 133 */     synchronized (this._datasources) {
/* 134 */       return (this._datasources.size() > 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return this._uniqueId.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerDataSource(ITransactionalDataSource argDataSource) {
/* 153 */     if (argDataSource == null) {
/* 154 */       throw new DataSourceTransactionException("datasource is null - a value must be provided. Cannot register null data source for token" + this);
/*     */     }
/*     */ 
/*     */     
/* 158 */     synchronized (this._datasources) {
/*     */       
/* 160 */       this._datasources.add(argDataSource);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITransactionalDataSource removeDatasource(String argDatasourceName) {
/* 171 */     return removeDatasource(argDatasourceName, ITransactionalDataSource.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends ITransactionalDataSource> T removeDatasource(String argDatasourceName, Class<T> argType) {
/* 182 */     synchronized (this._datasources) {
/* 183 */       Iterator<ITransactionalDataSource> iter = this._datasources.iterator();
/* 184 */       while (iter.hasNext()) {
/* 185 */         ITransactionalDataSource datasource = iter.next();
/* 186 */         if (datasource.getDataSourceName().equals(argDatasourceName) && argType.isInstance(datasource)) {
/* 187 */           iter.remove();
/* 188 */           return (T)datasource;
/*     */         } 
/*     */       } 
/*     */     } 
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public void setProperty(String argPropertyName, String argPropertyValue) {
/* 196 */     this._properties.put(argPropertyName, argPropertyValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 206 */     synchronized (this._datasources) {
/* 207 */       return "TransactionToken [_uniqueId=" + this._uniqueId + ", _datasources=" + this._datasources + "]";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\transaction\TransactionToken.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */