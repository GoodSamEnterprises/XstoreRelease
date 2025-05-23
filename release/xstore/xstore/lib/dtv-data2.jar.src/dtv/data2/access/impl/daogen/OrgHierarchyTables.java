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
/*    */ public class OrgHierarchyTables
/*    */ {
/* 19 */   private static List<String> _orgHierarchyTableNames = null;
/*    */   
/*    */   public static synchronized List<String> getOrgHierarchyTables() {
/* 22 */     if (_orgHierarchyTableNames == null) {
/* 23 */       _orgHierarchyTableNames = new ArrayList<>();
/* 24 */       Collection<String> orgHierarchyTables = new HashSet<>();
/*    */       
/* 26 */       IHasOrgHierarchyTables tableClass = (IHasOrgHierarchyTables)SelectingImplFactory.getImplClass(IHasOrgHierarchyTables.class);
/* 27 */       if (tableClass != null) {
/* 28 */         orgHierarchyTables.addAll(tableClass.getOrgHierarchyTables());
/*    */       }
/*    */       
/* 31 */       _orgHierarchyTableNames.addAll(orgHierarchyTables);
/*    */     } 
/* 33 */     return _orgHierarchyTableNames;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\OrgHierarchyTables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */