/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ public abstract class AbstractPersistenceStrategy
/*     */   implements IPersistenceStrategy
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(AbstractPersistenceStrategy.class);
/*  29 */   private static final boolean debugLogging_ = logger_.isDebugEnabled();
/*     */   
/*     */   private String datasourceName_;
/*     */   private IPersistenceMgrType currentPmType_;
/*  33 */   private Properties properties_ = new Properties();
/*     */ 
/*     */   
/*     */   private boolean isOnlineStategyType_;
/*     */ 
/*     */   
/*     */   public boolean equivalentDataSources(IPersistenceStrategy argOther) {
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getChildObjectIdForRelationship(IDataModelRelationship argRel) {
/*  46 */     if (!IDataModelRelationship.RelationshipType.ONE_TO_ONE.equals(argRel.getType())) {
/*  47 */       throw new DtxException("getChildObjectIdForRelationship can only operate on ONE-ONE relationships. Relationship name given: " + argRel
/*  48 */           .getIdentifier() + " Type: " + argRel
/*  49 */           .getType());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     IDataModelImpl parent = (IDataModelImpl)argRel.getParent();
/*     */ 
/*     */ 
/*     */     
/*  61 */     IRelationshipAdapter adapter = AdapterMap.getRelationshipAdapter(parent.getDAO().getClass(), argRel.getIdentifier());
/*     */     
/*  63 */     if (adapter == null) {
/*  64 */       throw new DtxException("Could not load relationship: " + argRel.getIdentifier() + " for DAO: " + parent
/*  65 */           .getDAO().getClass() + " check associated .dtx's.");
/*     */     }
/*  67 */     adapter.setParent(parent.getDAO());
/*     */     
/*  69 */     return adapter.getChildObjectId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getCurrentPmType() {
/*  76 */     return this.currentPmType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceName() {
/*  82 */     return this.datasourceName_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getProperties() {
/*  88 */     return this.properties_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOnlineStrategyType() {
/*  94 */     return this.isOnlineStategyType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void makePersistent(TransactionToken argTransToken, IPersistable argPersistable) {
/* 102 */     if (isPersistenceNecessary(argTransToken, argPersistable)) {
/* 103 */       makePersistentImpl(argTransToken, argPersistable);
/*     */     
/*     */     }
/* 106 */     else if (debugLogging_) {
/* 107 */       logger_.debug("Persistable [" + argPersistable + "] will not be persisted to [" + getDataSourceName() + "].  The write would be entirely redundant.");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentPmType(IPersistenceMgrType argCurrentPmType) {
/* 117 */     this.currentPmType_ = argCurrentPmType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSourceName(String argName) {
/* 123 */     this.datasourceName_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnlineStrategyType(boolean argIsOnlineStrategyType) {
/* 129 */     this.isOnlineStategyType_ = argIsOnlineStrategyType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProps) {
/* 135 */     this.properties_ = (argProps == null) ? new Properties() : argProps;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return (new ToStringBuilder(this)).append(this.datasourceName_).toString();
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
/*     */   protected boolean isPersistenceNecessary(TransactionToken argTransToken, IPersistable argPersistable) {
/* 153 */     boolean persistNeeded = true;
/*     */ 
/*     */ 
/*     */     
/* 157 */     if (DaoUtils.isClean(argPersistable)) {
/* 158 */       persistNeeded = false;
/*     */     }
/* 160 */     else if (argPersistable instanceof IDataAccessObject) {
/* 161 */       IDataAccessObject dao = (IDataAccessObject)argPersistable;
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
/* 182 */       if (DaoState.INSERT_OR_UPDATE.intVal() == dao.getObjectState() && 
/* 183 */         !isFullGraphPersisted() && 
/* 184 */         StringUtils.equalsIgnoreCase(getDataSourceName(), dao.getOriginDataSource()))
/*     */       {
/* 186 */         persistNeeded = false;
/*     */       }
/*     */     } 
/* 189 */     return persistNeeded;
/*     */   }
/*     */   
/*     */   protected abstract void makePersistentImpl(TransactionToken paramTransactionToken, IPersistable paramIPersistable);
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */