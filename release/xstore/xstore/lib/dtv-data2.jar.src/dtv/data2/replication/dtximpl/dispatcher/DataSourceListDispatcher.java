/*     */ package dtv.data2.replication.dtximpl.dispatcher;
/*     */ 
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.impl.PersistenceStrategyFactory;
/*     */ import dtv.data2.replication.ReplicationException;
/*     */ import dtv.data2.replication.dtximpl.ReplicationTransaction;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataSourceListDispatcher
/*     */   extends DataSourceDispatcher
/*     */ {
/*     */   private final List<String> _myDataSourceList;
/*     */   
/*     */   public DataSourceListDispatcher(List<String> argDataSourceList, PersistenceStrategyFactory argPersistenceStrategyFactory) {
/*  34 */     super(argPersistenceStrategyFactory);
/*     */     
/*  36 */     if (argDataSourceList == null) {
/*  37 */       throw new ReplicationException("Cannot create DataSourceListDispatcher with null argDataSourceList.");
/*     */     }
/*     */ 
/*     */     
/*  41 */     this._myDataSourceList = argDataSourceList;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public IDtxReplicationDispatcher.DispatchResult dispatch(ReplicationTransaction argReplicationTransaction) {
/*  56 */     IDtxReplicationDispatcher.DispatchResult result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*  57 */     boolean atLeastOneSuccess = false;
/*     */     
/*  59 */     for (String dataSourceName : this._myDataSourceList) {
/*  60 */       result = dispatchImpl(dataSourceName, argReplicationTransaction);
/*     */       
/*  62 */       if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_SUCCESSFUL == result) {
/*  63 */         atLeastOneSuccess = true;
/*     */       }
/*     */     } 
/*     */     
/*  67 */     return atLeastOneSuccess ? IDtxReplicationDispatcher.DispatchResult.DISPATCH_SUCCESSFUL : result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDestination() {
/*  73 */     return this._myDataSourceList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/*  79 */     boolean enabled = false;
/*     */     
/*  81 */     for (String dataSource : this._myDataSourceList) {
/*  82 */       if (DataSourceFactory.isDataSourceEnabled(dataSource.toString())) {
/*  83 */         enabled = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  88 */     return enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTargeted(String argDataSourceName) {
/*  94 */     boolean isTargeted = false;
/*     */     
/*  96 */     for (String dataSourceName : this._myDataSourceList) {
/*  97 */       if (dataSourceName.equals(argDataSourceName)) {
/*  98 */         isTargeted = true;
/*     */       }
/*     */     } 
/*     */     
/* 102 */     return isTargeted;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\dispatcher\DataSourceListDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */