/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.AbstractPersistenceRule;
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class PruneCleanTreesRule
/*     */   extends AbstractPersistenceRule
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(PruneCleanTreesRule.class);
/*     */ 
/*     */   
/*     */   private static final String PARAM_OBJECT_ID = "ObjectId";
/*     */   
/*  35 */   private final Collection<String> _objectIdNames = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistable applyRule(PersistableMetaData argPersistableMetaData, Object argObject) {
/*  40 */     IDataModel rootModel = (IDataModel)argPersistableMetaData.getPersistable();
/*  41 */     IDataModel iDataModel1 = rootModel;
/*     */     
/*  43 */     if (this._objectIdNames.isEmpty()) {
/*     */ 
/*     */       
/*  46 */       if (!DaoUtils.isTreeDirty(rootModel))
/*     */       {
/*     */         
/*  49 */         _logger.debug("The entire tree rooted at [" + rootModel + "] is clean and will not be persisted.");
/*  50 */         DataFactory.makeTransient(rootModel);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  55 */       Collection<? extends DaoUtils.PersistableLink> hierarchy = DaoUtils.getAllPersistables(rootModel);
/*     */ 
/*     */ 
/*     */       
/*  59 */       for (String objectIdName : this._objectIdNames) {
/*  60 */         for (DaoUtils.PersistableLink persistableData : hierarchy) {
/*     */ 
/*     */           
/*  63 */           IDataModel model = (IDataModel)persistableData.getPersistable();
/*     */           
/*  65 */           if (objectIdName.equalsIgnoreCase(model.getObjectId().getClass().getName()) && 
/*  66 */             !DaoUtils.isTreeDirty(model)) {
/*     */ 
/*     */             
/*  69 */             _logger.debug("The entire subtree rooted at [" + model + "] is clean and will not be persisted.");
/*     */             
/*  71 */             DataFactory.makeTransient(model);
/*     */             
/*  73 */             if (persistableData.getParent() == null) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     return (IPersistable)iDataModel1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isApplicable(PersistableMetaData argPersistableMetaData, Object argObject) {
/*  90 */     return (argPersistableMetaData.getPersistable() instanceof IDataModel && "OBJECT_PERSISTED"
/*  91 */       .equals(argPersistableMetaData.getPersistableAction()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/*  97 */     if ("ObjectId".equalsIgnoreCase(argName)) {
/*  98 */       this._objectIdNames.add(argValue.toString());
/*     */     } else {
/*     */       
/* 101 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\PruneCleanTreesRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */