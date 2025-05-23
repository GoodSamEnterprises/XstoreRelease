/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataModelMetaData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataModelMetaData
/*    */   implements IDataModelMetaData
/*    */ {
/*    */   private final IDataModelImpl _dataModel;
/* 21 */   private final Set<IDataModelImpl> _relatedDataModels = new HashSet<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataModelMetaData(IDataModelImpl argDataModel) {
/* 29 */     this._dataModel = argDataModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addRelatedDataModels(Collection<?> argRelatedDataModels) {
/* 35 */     if (argRelatedDataModels == null) {
/*    */       return;
/*    */     }
/*    */     
/* 39 */     for (Object element : argRelatedDataModels) {
/* 40 */       if (element instanceof IDataModelImpl) {
/* 41 */         this._relatedDataModels.add((IDataModelImpl)element);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IDataModelImpl getDataModel() {
/* 49 */     return this._dataModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IDataModelImpl> getRelatedDataModels() {
/* 55 */     return new ArrayList<>(this._relatedDataModels);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\DataModelMetaData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */