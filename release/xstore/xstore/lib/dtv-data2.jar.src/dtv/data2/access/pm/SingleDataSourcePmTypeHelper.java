/*     */ package dtv.data2.access.pm;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.PersistenceStrategyFactory;
/*     */ import dtv.data2.access.impl.config.PmTypeMappingConfigHelper;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.dataloader.ConfigParameters;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class SingleDataSourcePmTypeHelper
/*     */   extends PmTypeHelper
/*     */ {
/*  37 */   private static final Logger logger_ = Logger.getLogger(SingleDataSourcePmTypeHelper.class);
/*     */ 
/*     */   
/*     */   private static DataSourceDescriptor myDataSourceTemplate_;
/*     */ 
/*     */   
/*     */   private static IPersistenceMgrType defaultPmType_;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private PersistenceStrategyFactory _persistenceStrategyFactory;
/*     */   
/*     */   @Inject
/*     */   private PersistenceMgrTypeFactory _persistenceMgrTypeFactory;
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */ 
/*     */   
/*     */   protected SingleDataSourcePmTypeHelper(PmTypeMappingConfigHelper argCfg) {
/*  57 */     super(argCfg);
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
/*     */   public List<PmStrategyInfo> getPersistenceStrategies(IPersistable argPersistable) {
/*  69 */     return getPrioritizedStratgies(null, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getPMTypeByQueryKey(String argQueryKey, Map<?, ?> argParams) {
/*  75 */     return defaultPmType_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getPMTypeForPersistable(IPersistable argPersistable) {
/*  80 */     return defaultPmType_;
/*     */   }
/*     */   
/*     */   public void init() {
/*  84 */     String DATA_SOURCE_NAME = this._configParameters.getDataSource();
/*     */     
/*  86 */     if (StringUtils.isEmpty(DATA_SOURCE_NAME)) {
/*  87 */       String msg = "SingleDataSourcePmTypeHelper could not locate a datasource name from configuration. It is null or empty.";
/*     */ 
/*     */       
/*  90 */       logger_.fatal(msg);
/*  91 */       throw new DtxException(msg);
/*     */     } 
/*     */     
/*  94 */     myDataSourceTemplate_ = DataSourceFactory.getInstance().getDataSourceDescriptor(DATA_SOURCE_NAME);
/*     */     
/*  96 */     if (myDataSourceTemplate_ == null) {
/*  97 */       String msg = "SingleDataSourcePmTypeHelper is pointed towards a datasource [" + DATA_SOURCE_NAME + "] that does not exist. This datasource must be configured to function.";
/*     */ 
/*     */       
/* 100 */       logger_.fatal(msg);
/* 101 */       throw new DtxException(msg);
/*     */     } 
/*     */     
/* 104 */     if (!myDataSourceTemplate_.isEnabled()) {
/*     */ 
/*     */       
/* 107 */       String msg = "SingleDataSourcePmTypeHelper is pointed towards a datasource [" + DATA_SOURCE_NAME + "] that is NOT enabled. This datasource must be enabled to function. See: " + myDataSourceTemplate_.getSourceDescription();
/*     */       
/* 109 */       logger_.fatal(msg);
/* 110 */       throw new DtxException(msg);
/*     */     } 
/*     */     
/* 113 */     String DEFAULT_PM_TYPE_NAME = "REGISTER_CORE";
/*     */     
/*     */     try {
/* 116 */       defaultPmType_ = PersistenceManagerType.forName("REGISTER_CORE");
/*     */ 
/*     */       
/* 119 */       this._persistenceMgrTypeFactory.getPersistenceMgrTypeDescriptor(defaultPmType_);
/*     */     }
/* 121 */     catch (Exception ee) {
/* 122 */       if (PersistenceManagerType.getInstances() != null && (
/* 123 */         PersistenceManagerType.getInstances()).length > 0) {
/* 124 */         defaultPmType_ = PersistenceManagerType.getInstances()[0];
/* 125 */         logger_.warn("An exception occurred while loading default pm type [REGISTER_CORE]. Failing over to pm type: [" + defaultPmType_
/* 126 */             .getName() + "]", ee);
/*     */       } else {
/*     */         
/* 129 */         logger_.error("SingleDataSourcePmTypeHelper cannot load a default pm type (did PersistenceManagerConfig load?)");
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<PmStrategyInfo> getPrioritizedStratgies(IPersistenceMgrType argPmType, boolean argLookup, boolean argOnline) {
/* 148 */     List<PmStrategyInfo> singleDataSource = new ArrayList<>(1);
/* 149 */     IPersistenceStrategy strategy = this._persistenceStrategyFactory.createStrategy(myDataSourceTemplate_, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     singleDataSource
/* 157 */       .add(new PmStrategyInfo(strategy, StatusMgr.getInstance().isOnline(strategy.getDataSourceName())));
/*     */     
/* 159 */     return singleDataSource;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\SingleDataSourcePmTypeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */