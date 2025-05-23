/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.SelectingImplFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DataModelFactory
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(DataModelFactory.class);
/*  32 */   private static DataModelFactory factory_ = null;
/*     */ 
/*     */   
/*     */   static {
/*  36 */     factory_ = (DataModelFactory)SelectingImplFactory.getImplClass(DataModelFactory.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IDataAccessObject getDaoForDaoName(String argDaoName) {
/*     */     try {
/*  47 */       IDataAccessObject imp = factory_.getDaoForDaoNameImpl(argDaoName);
/*  48 */       if (imp != null) {
/*  49 */         return imp;
/*     */       }
/*     */     }
/*  52 */     catch (DtxException ex) {
/*  53 */       logger_.debug(ex);
/*     */     } 
/*  55 */     throw new DtxException("Could not find MODEL for DAO name: " + argDaoName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IObjectId getIdForDaoName(String argDaoName) {
/*     */     try {
/*  66 */       IObjectId oid = factory_.getIdForDaoNameImpl(argDaoName);
/*  67 */       if (oid != null) {
/*  68 */         return oid;
/*     */       }
/*     */     }
/*  71 */     catch (DtxException ex) {
/*  72 */       logger_.debug(ex);
/*     */     } 
/*  74 */     throw new DtxException("Could not find ID class for DTX type name: " + argDaoName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IDataModelImpl getModelForDAO(IDataAccessObject argDao) {
/*     */     try {
/*  85 */       IDataModelImpl imp = factory_.getModelForDAOImpl(argDao.getClass().getName());
/*  86 */       if (imp != null) {
/*  87 */         return imp;
/*     */       }
/*     */     }
/*  90 */     catch (DtxException ex) {
/*  91 */       logger_.debug(ex);
/*     */     } 
/*  93 */     throw new DtxException("Could not locate model for DAO: " + argDao.getClass().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends IDataModel> T getModelForInterface(Class<T> argInterfaceClass) {
/*     */     try {
/* 104 */       T imp = factory_.getModelForInterfaceImpl(argInterfaceClass);
/* 105 */       if (imp != null) {
/* 106 */         return imp;
/*     */       }
/*     */     }
/* 109 */     catch (DtxException ex) {
/* 110 */       logger_.debug(ex);
/*     */     } 
/* 112 */     throw new DtxException("Could not locate model for Interface: " + argInterfaceClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IDataModelRelationship[] getModelRelationships(IDataAccessObject argDao) {
/*     */     try {
/* 122 */       IDataModelRelationship[] rels = factory_.getRelationshipsImpl(argDao.getClass().getName());
/* 123 */       if (rels != null) {
/* 124 */         return rels;
/*     */       }
/*     */     }
/* 127 */     catch (DtxException ex) {
/* 128 */       logger_.debug(ex);
/*     */     } 
/* 130 */     logger_.debug("No model relationships found for " + argDao.getClass().getName());
/* 131 */     return null;
/*     */   }
/*     */   
/*     */   protected abstract IDataAccessObject getDaoForDaoNameImpl(String paramString);
/*     */   
/*     */   protected abstract IObjectId getIdForDaoNameImpl(String paramString);
/*     */   
/*     */   protected abstract IDataModelImpl getModelForDAOImpl(String paramString);
/*     */   
/*     */   protected abstract <T extends IDataModel> T getModelForInterfaceImpl(Class<T> paramClass);
/*     */   
/*     */   protected abstract IDataModelRelationship[] getRelationshipsImpl(String paramString);
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DataModelFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */