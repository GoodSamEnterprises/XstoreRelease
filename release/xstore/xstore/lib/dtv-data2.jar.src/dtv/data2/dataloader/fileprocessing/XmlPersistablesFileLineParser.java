/*    */ package dtv.data2.dataloader.fileprocessing;
/*    */ 
/*    */ import dtv.data2.access.DaoUtils;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2.access.impl.DaoState;
/*    */ import dtv.data2.dataloader.DataLoaderException;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlPersistablesFileLineParser
/*    */   implements IFileLineParser
/*    */ {
/*    */   public List<IPersistable> parse(FileLine argFileLine) {
/* 32 */     String xml = argFileLine.getFieldValue(1);
/*    */     
/*    */     try {
/* 35 */       List<IPersistable> persistables = DaoUtils.getPersistablesForXml(xml);
/* 36 */       setDaosToInsertOrUpdate(argFileLine, persistables);
/* 37 */       return persistables;
/*    */     }
/* 39 */     catch (Exception ex) {
/* 40 */       throw new DataLoaderException("Cannot parse XML file line into persistables. xml: [" + xml + "]", ex);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void setDaosToInsertOrUpdate(FileLine argFileLine, List<IPersistable> argPersistables) {
/* 45 */     if (argPersistables == null || argPersistables.isEmpty()) {
/*    */       return;
/*    */     }
/*    */     
/* 49 */     if (!"INSERT".equals(argFileLine.getActionType())) {
/*    */       return;
/*    */     }
/*    */     
/* 53 */     for (IPersistable persistable : argPersistables) {
/* 54 */       if (persistable instanceof IDataAccessObject) {
/* 55 */         IDataAccessObject dao = (IDataAccessObject)persistable;
/*    */         
/* 57 */         if (DaoState.isNew(dao) || DaoState.isUpdated(dao))
/* 58 */           dao.setObjectState(DaoState.INSERT_OR_UPDATE.intVal()); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\XmlPersistablesFileLineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */