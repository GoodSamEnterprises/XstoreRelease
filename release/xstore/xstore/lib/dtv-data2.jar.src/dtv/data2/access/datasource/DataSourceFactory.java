/*     */ package dtv.data2.access.datasource;
/*     */ 
/*     */ import dtv.data2.access.datasource.config.DataSourceConfigHelper;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
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
/*     */ public class DataSourceFactory
/*     */   implements IDataSourceFactory
/*     */ {
/*  24 */   private static final String IMPL_PROPERTY = IDataSourceFactory.class.getName();
/*  25 */   private static final Logger _logger = Logger.getLogger(DataSourceFactory.class);
/*     */   
/*  27 */   private static IDataSourceFactory _instance = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataSourceDescriptor getDataSourceDescriptor(String argDataSourceName, Throwable argEx) {
/*  36 */     if (argDataSourceName == null) {
/*  37 */       throw new DtxException("getDataSourceDescriptor cannot accept null argDataSourceName.", argEx);
/*     */     }
/*  39 */     DataSourceDescriptor datasource = getInstance().getDataSourceDescriptor(argDataSourceName);
/*     */     
/*  41 */     if (datasource == null) {
/*  42 */       throw new DtxException("No data source definition was found for data source name: '" + argDataSourceName + "'. Available datasources: " + 
/*  43 */           getInstance().getDataSourceDescriptors(), argEx);
/*     */     }
/*     */     
/*  46 */     return datasource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IDataSourceFactory getInstance() {
/*  54 */     if (_instance == null) {
/*  55 */       String className = System.getProperty(IMPL_PROPERTY);
/*     */       try {
/*  57 */         _instance = (IDataSourceFactory)Class.forName(className).newInstance();
/*     */       }
/*  59 */       catch (Exception ex) {
/*  60 */         _logger
/*  61 */           .debug(className + " is not a valid data source factory mapping for property " + IMPL_PROPERTY);
/*  62 */         _instance = new DataSourceFactory();
/*     */       } 
/*     */     } 
/*  65 */     return _instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isDataSourceEnabled(String argDataSourceName) {
/*  76 */     DataSourceDescriptor datasource = getInstance().getDataSourceDescriptor(argDataSourceName);
/*     */     
/*  78 */     if (datasource == null) {
/*  79 */       throw new DtxException("No data source definition was found for data source name: '" + argDataSourceName + "'. Available datasources: " + 
/*  80 */           getInstance().getDataSourceDescriptors());
/*     */     }
/*     */     
/*  83 */     return getInstance().isDataSourceEnabled(datasource);
/*     */   }
/*     */   
/*  86 */   private Map<String, DataSourceDescriptor> _datasources = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DataSourceFactory() {
/*  93 */     initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataSourceDescriptor getDataSourceDescriptor(String argDataSourceName) {
/*  99 */     return this._datasources.get(argDataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<DataSourceDescriptor> getDataSourceDescriptors() {
/* 105 */     return this._datasources.values();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reinitialize() {
/* 111 */     initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDataSourceEnabled(DataSourceDescriptor argDescriptor) {
/* 117 */     return argDescriptor.isEnabled();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initialize() {
/* 122 */     DataSourceConfigHelper configHelper = new DataSourceConfigHelper();
/* 123 */     configHelper.initialize();
/* 124 */     this._datasources = configHelper.getDataSourceDescriptors();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\DataSourceFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */