/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import dtv.data2.access.impl.SelectingImplFactory;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
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
/*    */ public class ConfigElementTables
/*    */ {
/* 19 */   private static List<String> _configElementTableNames = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized List<String> getTableNames() {
/* 28 */     if (_configElementTableNames == null) {
/* 29 */       _configElementTableNames = new ArrayList<>();
/* 30 */       Collection<String> configElementTables = new HashSet<>();
/*    */       
/* 32 */       IHasConfigElementTables tableClass = (IHasConfigElementTables)SelectingImplFactory.getImplClass(IHasConfigElementTables.class);
/* 33 */       if (tableClass != null) {
/* 34 */         configElementTables.addAll(tableClass.getConfigElementTables());
/*    */       }
/*    */       
/* 37 */       _configElementTableNames.addAll(configElementTables);
/*    */     } 
/*    */     
/* 40 */     return _configElementTableNames;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\ConfigElementTables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */