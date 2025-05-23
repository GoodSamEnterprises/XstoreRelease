/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
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
/*     */ public class SelectingPersistenceStrategy
/*     */   extends AbstractPersistenceStrategy
/*     */ {
/*     */   private Collection<IPersistenceStrategySelector> _strategySelectors;
/*  29 */   private IPersistenceStrategy _selectedStrategy = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectingPersistenceStrategy(IPersistenceStrategySelector... argStrategy) {
/*  37 */     this._strategySelectors = Arrays.asList(argStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectingPersistenceStrategy(List<IPersistenceStrategySelector> argSelectors) {
/*  46 */     this._strategySelectors = argSelectors;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkExistence(IObjectId argId, QueryToken argQueryToken) {
/*  52 */     return (this._selectedStrategy == null) ? false : this._selectedStrategy.checkExistence(argId, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getObjectById(IObjectId argId, QueryToken argQueryToken) {
/*  58 */     if (this._selectedStrategy == null) {
/*  59 */       for (IPersistenceStrategySelector selector : this._strategySelectors) {
/*  60 */         if (selector.acceptGetObjectById(argId)) {
/*  61 */           this._selectedStrategy = selector.getPersistenceStrategy();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  66 */     checkSelectedStrategy();
/*  67 */     return this._selectedStrategy.getObjectById(argId, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByQuery(String argKey, Map<String, Object> argParams, QueryToken argQueryToken) {
/*  73 */     if (this._selectedStrategy == null) {
/*  74 */       for (IPersistenceStrategySelector selector : this._strategySelectors) {
/*  75 */         if (selector.acceptGetObjectByQuery(argKey, argParams)) {
/*  76 */           this._selectedStrategy = selector.getPersistenceStrategy();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  81 */     checkSelectedStrategy();
/*  82 */     return this._selectedStrategy.getObjectByQuery(argKey, argParams, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByRelationship(IDataModelRelationship argRel, QueryToken argQueryToken) {
/*  88 */     return (this._selectedStrategy == null) ? null : this._selectedStrategy
/*  89 */       .getObjectByRelationship(argRel, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphPersisted() {
/*  95 */     return (this._selectedStrategy == null) ? true : this._selectedStrategy.isFullGraphPersisted();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphProvided() {
/* 101 */     return (this._selectedStrategy == null) ? false : this._selectedStrategy.isFullGraphProvided();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProps) {
/* 111 */     if (this._selectedStrategy != null) {
/* 112 */       this._selectedStrategy.setProperties(argProps);
/*     */     } else {
/*     */       
/* 115 */       for (IPersistenceStrategySelector selector : this._strategySelectors) {
/* 116 */         selector.setProperties(argProps);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void makePersistentImpl(TransactionToken argTransToken, IPersistable argPersistable) {
/* 124 */     if (this._selectedStrategy == null) {
/* 125 */       for (IPersistenceStrategySelector selector : this._strategySelectors) {
/* 126 */         if (selector.acceptMakePersistent(argTransToken, argPersistable)) {
/* 127 */           this._selectedStrategy = selector.getPersistenceStrategy();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 132 */     checkSelectedStrategy();
/* 133 */     this._selectedStrategy.makePersistent(argTransToken, argPersistable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkSelectedStrategy() {
/* 141 */     if (this._selectedStrategy == null)
/* 142 */       throw new IllegalStateException("No persistence strategy selected."); 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\SelectingPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */