/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.pos.framework.form.config.DaoMappingConfigHelper;
/*     */ import dtv.pos.iframework.form.IDaoEditModel;
/*     */ import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.pos.iframework.form.mapping.IEditModelKey;
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
/*     */ public class EditModelMapper
/*     */   implements IEditModelMapper
/*     */ {
/*  26 */   public static final String SYSTEM_PROPERTY = EditModelMapper.class.getName();
/*  27 */   private static final Logger logger_ = Logger.getLogger(EditModelMapper.class);
/*     */   private static final IEditModelMapper INSTANCE;
/*     */   
/*     */   static {
/*  31 */     IEditModelMapper temp = null;
/*  32 */     String className = System.getProperty(SYSTEM_PROPERTY);
/*     */     try {
/*  34 */       temp = (IEditModelMapper)Class.forName(className).newInstance();
/*     */     }
/*  36 */     catch (Exception ex) {
/*  37 */       temp = new EditModelMapper();
/*     */     } 
/*  39 */     INSTANCE = temp;
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<IEditModelKey, IDaoEditMappingConfig> configs_;
/*     */   private Map<String, IDataObjectDefinitionConfig> objectMap_;
/*     */   
/*     */   public static IEditModelMapper getInstance() {
/*  47 */     return INSTANCE;
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
/*     */   public IDataObjectDefinitionConfig getDataObjectDefinitionConfig(String argKey) {
/*  60 */     return this.objectMap_.get(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDaoEditModel mapDao(IEditModelKey argKey, IDataModel argDao, boolean argIsNew) {
/*  66 */     if (argDao == null) {
/*  67 */       throw new NullPointerException("cannot map a null data object");
/*     */     }
/*     */     
/*  70 */     init();
/*  71 */     return mapDao(argKey, new IDataModel[] { argDao }, argIsNew);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDaoEditModel mapDao(IEditModelKey argKey, IDataModel[] argDao) {
/*  77 */     return mapDao(argKey, argDao, (Boolean)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDaoEditModel mapDao(IEditModelKey argKey, IDataModel[] argDao, boolean argIsNew) {
/*  83 */     return mapDao(argKey, argDao, Boolean.valueOf(argIsNew));
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  88 */     if (this.configs_ == null) {
/*  89 */       DaoMappingConfigHelper configHelper = new DaoMappingConfigHelper();
/*  90 */       configHelper.initialize();
/*     */       
/*  92 */       this.configs_ = configHelper.getMappingMap();
/*  93 */       this.objectMap_ = configHelper.getObjectMap();
/*     */     } 
/*     */   }
/*     */   
/*     */   private IDaoEditModel mapDao(IEditModelKey argKey, IDataModel[] argDao, Boolean argIsNew) {
/*  98 */     if (argDao == null) {
/*  99 */       throw new NullPointerException("cannot map a null data object array");
/*     */     }
/* 101 */     if (argDao.length == 0) {
/* 102 */       throw new IllegalArgumentException("cannot map a zero length array of objects");
/*     */     }
/*     */     
/* 105 */     init();
/* 106 */     IDaoEditMappingConfig config = this.configs_.get(argKey);
/*     */     
/* 108 */     if (config == null) {
/* 109 */       logger_.warn("no mapping found for [" + argKey + "]");
/* 110 */       return null;
/*     */     } 
/* 112 */     return config.makeEditModel(argDao, argIsNew);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */