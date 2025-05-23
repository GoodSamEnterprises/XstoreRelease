/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.inject.Inject;
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
/*     */ public class LoadBalancePersistenceStrategy
/*     */   extends AbstractPersistenceStrategy
/*     */ {
/*  37 */   private static Map<String, LoadBalanceHistory> _preLoadedSettings = new HashMap<>(4);
/*     */ 
/*     */   
/*     */   private IPersistenceStrategy _impersonatedStrategy;
/*     */   
/*     */   private String _myDataSourceName;
/*     */   
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */ 
/*     */   
/*     */   public boolean checkExistence(IObjectId argId, QueryToken argQueryToken) {
/*  49 */     ensureOnline();
/*  50 */     return this._impersonatedStrategy.checkExistence(argId, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceName() {
/*  56 */     if (this._impersonatedStrategy == null) {
/*  57 */       return this._myDataSourceName;
/*     */     }
/*     */     
/*  60 */     return this._impersonatedStrategy.getDataSourceName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHost() {
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getObjectById(IObjectId argId, QueryToken argQueryToken) {
/*  71 */     ensureOnline();
/*  72 */     return this._impersonatedStrategy.getObjectById(argId, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByQuery(String argKey, Map<String, Object> argParams, QueryToken argQueryToken) {
/*  78 */     ensureOnline();
/*  79 */     return this._impersonatedStrategy.getObjectByQuery(argKey, argParams, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByRelationship(IDataModelRelationship argRel, QueryToken argQueryToken) {
/*  85 */     ensureOnline();
/*  86 */     return this._impersonatedStrategy.getObjectByRelationship(argRel, argQueryToken);
/*     */   }
/*     */   
/*     */   public int getPort() {
/*  90 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphPersisted() {
/*  96 */     ensureOnline();
/*  97 */     return this._impersonatedStrategy.isFullGraphPersisted();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphProvided() {
/* 103 */     ensureOnline();
/* 104 */     return this._impersonatedStrategy.isFullGraphProvided();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ping() {
/*     */     try {
/* 114 */       ensureOnline();
/* 115 */       return true;
/*     */     }
/* 117 */     catch (FailoverException ee) {
/* 118 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSourceName(String argName) {
/* 125 */     this._myDataSourceName = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProps) {
/* 131 */     if (!_preLoadedSettings.containsKey(this._myDataSourceName)) {
/* 132 */       initLoadBalanceHistory(argProps);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     LoadBalanceHistory history = _preLoadedSettings.get(this._myDataSourceName);
/*     */     
/* 143 */     DataSourceDescriptor theChosenOne = null;
/* 144 */     int counter = 0;
/*     */     
/* 146 */     while (theChosenOne == null && counter++ < history.getValidDataSources().size()) {
/* 147 */       theChosenOne = history.getNextDataSource();
/*     */       
/* 149 */       boolean online = StatusMgr.getInstance().isOnline(theChosenOne.getName());
/*     */       
/* 151 */       if (online) {
/* 152 */         this
/* 153 */           ._impersonatedStrategy = this._persistenceStrategyFactory.createStrategy(theChosenOne, isOnlineStrategyType());
/*     */         
/*     */         break;
/*     */       } 
/* 157 */       theChosenOne = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void ensureOnline() {
/* 166 */     if (this._impersonatedStrategy == null) {
/* 167 */       throw FailoverException.getNewException("LoadBalancePersistenceStrategy is failing over because none of the strategies he is balancing are online.", this._myDataSourceName);
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
/*     */   protected void initLoadBalanceHistory(Properties argProps) {
/* 179 */     if (argProps == null || argProps.isEmpty()) {
/* 180 */       throw new DtxException("No properties were found for datasource: " + this._myDataSourceName + " Check DataSourceConfig.xml");
/*     */     }
/*     */ 
/*     */     
/* 184 */     Collection<Object> datasourceNames = argProps.values();
/* 185 */     List<String> enabledDatasources = new ArrayList<>(5);
/*     */     
/* 187 */     for (Object dataSourceName : datasourceNames) {
/*     */       
/* 189 */       DataSourceDescriptor desc = DataSourceFactory.getInstance().getDataSourceDescriptor(dataSourceName.toString());
/*     */       
/* 191 */       if (desc.isEnabled()) {
/* 192 */         enabledDatasources.add(desc.getName());
/*     */       }
/*     */     } 
/*     */     
/* 196 */     LoadBalanceHistory history = new LoadBalanceHistory();
/* 197 */     history.setValidDataSources(enabledDatasources);
/* 198 */     _preLoadedSettings.put(this._myDataSourceName, history);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void makePersistentImpl(TransactionToken argTransToken, IPersistable argPersistable) {
/* 204 */     ensureOnline();
/* 205 */     this._impersonatedStrategy.makePersistent(argTransToken, argPersistable);
/*     */   }
/*     */   
/*     */   private static class LoadBalanceHistory {
/* 209 */     private final List<DataSourceDescriptor> validDataSources_ = new ArrayList<>(5);
/* 210 */     private int count_ = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DataSourceDescriptor getNextDataSource() {
/* 218 */       DataSourceDescriptor datasource = this.validDataSources_.get(this.count_ % this.validDataSources_.size());
/* 219 */       this.count_++;
/* 220 */       if (this.count_ < 0) {
/* 221 */         this.count_ = 0;
/*     */       }
/* 223 */       return datasource;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<DataSourceDescriptor> getValidDataSources() {
/* 230 */       return this.validDataSources_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setValidDataSources(List<String> argValidDataSources) {
/* 237 */       for (String dataSourceName : argValidDataSources) {
/*     */         
/* 239 */         DataSourceDescriptor descriptor = DataSourceFactory.getInstance().getDataSourceDescriptor(dataSourceName);
/*     */         
/* 241 */         if (!this.validDataSources_.contains(descriptor))
/* 242 */           this.validDataSources_.add(descriptor); 
/*     */       } 
/*     */     }
/*     */     
/*     */     private LoadBalanceHistory() {}
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\LoadBalancePersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */