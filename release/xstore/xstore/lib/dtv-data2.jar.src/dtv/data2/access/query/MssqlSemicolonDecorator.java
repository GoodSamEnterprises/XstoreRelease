/*    */ package dtv.data2.access.query;
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
/*    */ public class MssqlSemicolonDecorator
/*    */   extends AbstractMssqlDecorator
/*    */ {
/*    */   protected String decorate(String argSqlStatement) {
/* 24 */     return argSqlStatement.concat(";");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\MssqlSemicolonDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */