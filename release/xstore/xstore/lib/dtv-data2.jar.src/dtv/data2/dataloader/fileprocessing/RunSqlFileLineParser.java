/*    */ package dtv.data2.dataloader.fileprocessing;
/*    */ 
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2.access.query.SqlQueryRequest;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RunSqlFileLineParser
/*    */   implements IFileLineParser
/*    */ {
/*    */   public List<IPersistable> parse(FileLine argFileLine) {
/* 33 */     List<IPersistable> persistables = new ArrayList<>();
/* 34 */     persistables.add(getSqlFromLine(argFileLine));
/*    */     
/* 36 */     return persistables;
/*    */   }
/*    */   
/*    */   private IPersistable getSqlFromLine(FileLine argLine) {
/* 40 */     SqlQueryRequest query = new SqlQueryRequest();
/* 41 */     query.setSqlStatement(argLine.getFieldValue(1));
/* 42 */     return (IPersistable)query;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\RunSqlFileLineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */