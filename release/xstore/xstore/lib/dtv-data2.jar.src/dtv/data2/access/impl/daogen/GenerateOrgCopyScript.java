/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import dtv.util.StringUtils;
/*    */ import java.io.File;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenerateOrgCopyScript
/*    */   implements Callable<Object>
/*    */ {
/* 22 */   private static final Logger logger_ = Logger.getLogger(GenerateOrgCopyScript.class);
/*    */   
/*    */   private final DaoGenHelper helper_;
/*    */   
/*    */   GenerateOrgCopyScript(DaoGenHelper argHelper) {
/* 27 */     this.helper_ = argHelper;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object call() throws Exception {
/* 35 */     logger_.info("Generating Org Copy Script");
/*    */     
/* 37 */     StringBuilder w = new StringBuilder(5120);
/*    */     
/* 39 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/* 40 */       if (!StringUtils.isEmpty(dtx.getTable())) {
/* 41 */         getOrgCopy(dtx, w);
/*    */       }
/*    */     } 
/*    */     
/* 45 */     File file = new File(this.helper_.getOutPath() + File.separator + "org_copy.sql");
/* 46 */     this.helper_.getWriter().write(file, w.toString());
/*    */     
/* 48 */     return null;
/*    */   }
/*    */   
/*    */   public void getOrgCopy(DtxDefinition dtx, StringBuilder buff) {
/* 52 */     buff.append("INSERT INTO ").append(dtx.getTable()).append("(");
/*    */ 
/*    */     
/* 55 */     for (DtxDefinition.DtxDaoField field : dtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 56 */       buff.append(field.getColumn()).append(", ");
/*    */     }
/*    */ 
/*    */     
/* 60 */     buff.setLength(buff.length() - 2);
/* 61 */     buff.append(") ");
/*    */ 
/*    */     
/* 64 */     buff.append("SELECT ");
/*    */     
/* 66 */     for (DtxDefinition.DtxDaoField field : dtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 67 */       if (field.getColumn().equals("organization_id")) {
/* 68 */         buff.append("NEW_ORG_ID, ");
/*    */       } else {
/*    */         
/* 71 */         buff.append(field.getColumn()).append(", ");
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 76 */     buff.setLength(buff.length() - 2);
/* 77 */     buff.append(" FROM ").append(dtx.getTable());
/* 78 */     buff.append(" WHERE organization_id = EXISTING_ORG_ID;\n");
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateOrgCopyScript.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */