/*    */ package dtv.pos.framework.form.design.model;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.ActionGroupConfig;
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
/*    */ public class ActionGroupEditModel
/*    */   extends AbstractDetailEditModel
/*    */ {
/*    */   private static final int SUBKEY = 0;
/*    */   private static final int ROW_COUNT = 1;
/*    */   private final ActionGroupConfig config;
/*    */   
/*    */   public ActionGroupEditModel(ActionGroupConfig argActionGroupConfig) {
/* 23 */     super(1, new String[] { "subkey" }, new Class[] { String.class });
/* 24 */     this.config = argActionGroupConfig;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getValueAt(int rowIndex, int columnIndex) {
/* 29 */     if (columnIndex == 0) {
/* 30 */       return super.getValueAt(rowIndex, columnIndex);
/*    */     }
/* 32 */     switch (rowIndex) {
/*    */       case 0:
/* 34 */         return this.config.getGroupSubKey();
/*    */     } 
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/* 41 */     if (columnIndex == 1)
/* 42 */       switch (rowIndex) {
/*    */         case 0:
/* 44 */           this.config.setGroupSubKey((aValue == null) ? null : String.valueOf(aValue));
/*    */           break;
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\ActionGroupEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */