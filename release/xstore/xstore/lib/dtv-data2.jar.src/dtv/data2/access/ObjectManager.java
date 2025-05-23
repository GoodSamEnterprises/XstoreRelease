/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.pm.PersistenceManagerType;
/*     */ import dtv.data2.cache.CacheManager;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.data2.cache.NotCachedException;
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
/*     */ public class ObjectManager
/*     */ {
/*     */   protected ICache cache_;
/*     */   private static final String CACHE_NAME = "ObjectManager";
/*  25 */   private static final Logger logger_ = Logger.getLogger(ObjectManager.class);
/*  26 */   private static final IPersistenceMgrType PM_TYPE = (IPersistenceMgrType)PersistenceManagerType.forName("STORE_STANDARD");
/*     */   
/*     */   private static ObjectManager INSTANCE;
/*     */   
/*  30 */   public static final String SYSTEM_PROPERTY = ObjectManager.class.getName();
/*     */ 
/*     */   
/*     */   static {
/*  34 */     String className = System.getProperty(SYSTEM_PROPERTY);
/*     */     try {
/*  36 */       INSTANCE = (ObjectManager)Class.forName(className).newInstance();
/*     */     }
/*  38 */     catch (Exception ex) {
/*  39 */       logger_.warn("No accesible implementation defined in system properties. [" + className + "]");
/*  40 */       logger_.warn("Falling back on default implementation.");
/*  41 */       INSTANCE = new ObjectManager();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjectManager getInstance() {
/*  48 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjectManager() {
/*  53 */     this.cache_ = CacheManager.getInstance().getCache("ObjectManager");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getManagedObject(IObjectId argObjectId) {
/*  64 */     if (argObjectId == null) {
/*  65 */       throw new DtxException("getManagedObject() cannot have null argObjectId");
/*     */     }
/*     */     
/*     */     try {
/*  69 */       return this.cache_.get(argObjectId);
/*     */     }
/*  71 */     catch (NotCachedException notCachedException) {
/*     */ 
/*     */ 
/*     */       
/*  75 */       Object retVal = null;
/*     */       try {
/*  77 */         retVal = DataFactory.getObjectById(argObjectId, PM_TYPE);
/*  78 */         if (retVal != null) {
/*  79 */           this.cache_.put(argObjectId, retVal);
/*     */         }
/*     */       }
/*  82 */       catch (ObjectNotFoundException objectNotFoundException) {}
/*     */ 
/*     */       
/*  85 */       return retVal;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void manageObject(IDataModel argDataModel) {
/*  94 */     if (argDataModel == null) {
/*  95 */       throw new NullPointerException("manageObject() cannot manage null argDataModel");
/*     */     }
/*     */     
/*  98 */     this.cache_.put(((IDataModelImpl)argDataModel).getObjectId(), argDataModel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unmanageObject(Object argId) {
/* 107 */     this.cache_.remove(argId);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\ObjectManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */