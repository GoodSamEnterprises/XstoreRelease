/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.config.query.QueryConfigHelper;
/*     */ import dtv.data2.access.config.query.QueryDescriptor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
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
/*     */ public class QueryFactory
/*     */ {
/*  25 */   private static final Logger logger_ = Logger.getLogger(QueryFactory.class);
/*     */   
/*     */   private Map<String, QueryDescriptor> descriptorIdx_;
/*     */   
/*     */   @Inject
/*     */   private ISqlQueryDecorator _queryDecorator;
/*     */   
/*     */   @Inject
/*     */   private IQueryHandlerFactory _queryHandlerFactory;
/*     */   
/*     */   protected QueryFactory() {
/*  36 */     QueryConfigHelper configHelper = new QueryConfigHelper();
/*  37 */     configHelper.initialize();
/*     */     
/*  39 */     this.descriptorIdx_ = configHelper.getQueryDescriptorMap();
/*     */   }
/*     */   
/*     */   public QueryDescriptor getQueryDescriptor(String argQueryKey) {
/*  43 */     QueryDescriptor queryDescriptor = this.descriptorIdx_.get(argQueryKey);
/*  44 */     if (queryDescriptor == null) {
/*  45 */       logger_.warn("No query found for '" + argQueryKey + "'");
/*     */     }
/*  47 */     else if (logger_.isInfoEnabled()) {
/*  48 */       logger_.info("Using query '" + argQueryKey + "' from " + queryDescriptor.getSourceDescription());
/*     */     } 
/*  50 */     return queryDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IQueryHandler getQueryHandler(String argKey) {
/*  57 */     if (StringUtils.isEmpty(argKey)) {
/*  58 */       throw new DtxException("Cannot load query definition because argQueryKey was NULL or empty");
/*     */     }
/*     */     
/*  61 */     QueryDescriptor descriptor = getQueryDescriptor(argKey);
/*     */     
/*  63 */     if (descriptor == null) {
/*  64 */       throw new DtxException("Could not find query definition for given query key: " + argKey + ". Check QueryConfig.xml or related");
/*     */     }
/*     */ 
/*     */     
/*  68 */     if (descriptor.getQueryHandler() == null) {
/*  69 */       throw new DtxException("There is no query handler class associated with key " + argKey + ". Check QueryConfig.xml or related");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     IQueryHandler handler = null;
/*     */     try {
/*  78 */       handler = this._queryHandlerFactory.getQueryHandler(descriptor.getQueryHandler().getName());
/*  79 */       handler.setQueryDecorator(this._queryDecorator);
/*     */     }
/*  81 */     catch (Exception ex) {
/*     */       
/*  83 */       String msg = "Exception occurred while loading query handler: " + descriptor.getQueryHandler().getName() + ". Associated query key: " + argKey;
/*     */       
/*  85 */       logger_.error(msg, ex);
/*  86 */       throw new DtxException(msg, ex);
/*     */     } 
/*     */     
/*  89 */     Properties props = descriptor.getProperties();
/*  90 */     props.setProperty("Name", argKey);
/*     */     
/*  92 */     handler.setProperties(props);
/*  93 */     handler.setSourceDescription(descriptor.getSourceDescription());
/*  94 */     return handler;
/*     */   }
/*     */   
/*     */   public void reinitialize() {
/*  98 */     QueryConfigHelper configHelper = new QueryConfigHelper();
/*  99 */     configHelper.initialize();
/*     */     
/* 101 */     this.descriptorIdx_ = configHelper.getQueryDescriptorMap();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */