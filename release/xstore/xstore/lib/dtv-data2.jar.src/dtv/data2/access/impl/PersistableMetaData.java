/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PersistableMetaData
/*     */ {
/*     */   public static final String OBJECT_PERSISTED = "OBJECT_PERSISTED";
/*     */   public static final String OBJECT_RETRIEVED = "OBJECT_RETRIEVED";
/*     */   public static final String OBJECT_QUERIED = "OBJECT_QUERIED";
/*  36 */   private final List<String> _dataSourcesVisited = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private String _successfulDataSource;
/*     */ 
/*     */   
/*     */   private IPersistable _persistable;
/*     */ 
/*     */   
/*     */   private final String _persistableAction;
/*     */ 
/*     */ 
/*     */   
/*     */   public PersistableMetaData(String argPersistableAction) {
/*  51 */     this._persistableAction = argPersistableAction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDataSourceVisited(String argDataSourceName) {
/*  60 */     this._dataSourcesVisited.add(argDataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getDataSourcesVisited() {
/*  70 */     return this._dataSourcesVisited;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistable getPersistable() {
/*  78 */     return this._persistable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPersistableAction() {
/*  88 */     return this._persistableAction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuccessfulDataSource() {
/*  96 */     return this._successfulDataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPersistable(IPersistable argPersistable) {
/* 104 */     this._persistable = argPersistable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuccessfulDataSource(String argDataSourceName) {
/* 112 */     this._successfulDataSource = argDataSourceName;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\PersistableMetaData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */