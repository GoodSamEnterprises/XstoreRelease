/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import dtv.util.StringUtils;
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.Callable;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenerateTableList
/*    */   implements Callable<Object>
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(GenerateTableList.class);
/*    */   
/*    */   private final DaoGenHelper helper_;
/*    */   
/*    */   GenerateTableList(DaoGenHelper argHelper) {
/* 28 */     this.helper_ = argHelper;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object call() throws Exception {
/* 36 */     logger_.info("Generating Table List");
/*    */     
/* 38 */     StringBuilder w = new StringBuilder(5120);
/*    */     
/* 40 */     List<DtxDefinition> dtxDefs = new ArrayList<>(this.helper_.getDtxDefinitions());
/* 41 */     Collections.sort(dtxDefs, new DtxComparator());
/*    */     
/* 43 */     for (DtxDefinition dtx : dtxDefs) {
/* 44 */       if (!StringUtils.isEmpty(dtx.getTable())) {
/* 45 */         w.append(dtx.getTable() + "\n");
/*    */       }
/*    */     } 
/*    */     
/* 49 */     File file = new File(this.helper_.getOutPath() + File.separator + "table_list.txt");
/* 50 */     this.helper_.getWriter().write(file, w.toString());
/*    */     
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   class DtxComparator
/*    */     implements Comparator<DtxDefinition>
/*    */   {
/*    */     public int compare(DtxDefinition o1, DtxDefinition o2) {
/* 61 */       String table1 = o1.getTable();
/* 62 */       String table2 = o2.getTable();
/*    */       
/* 64 */       if (table1 == null) {
/* 65 */         table1 = "";
/*    */       }
/* 67 */       if (table2 == null) {
/* 68 */         table2 = "";
/*    */       }
/*    */       
/* 71 */       return table1.compareTo(table2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateTableList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */