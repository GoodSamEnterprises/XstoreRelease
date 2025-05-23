/*    */ package dtv.pos.framework.form.design.model;
/*    */ 
/*    */ import dtv.pos.framework.form.config.FormViewConfig;
/*    */ import dtv.pos.iframework.form.FormLocationType;
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
/*    */ public class FormEditModel
/*    */   extends AbstractDetailEditModel
/*    */ {
/* 20 */   private static final Logger logger = Logger.getLogger(FormEditModel.class);
/*    */   
/*    */   private final FormViewConfig config;
/*    */   
/*    */   private static final int LOCATION = 0;
/*    */   
/*    */   private static final int TITLE_TEXT = 1;
/*    */   private static final int INSTRUCTIONS = 2;
/*    */   private static final int FIELD_COUNT = 3;
/*    */   
/*    */   public FormEditModel(FormViewConfig argFormConfig) {
/* 31 */     super(3, new String[] { "Location", "Title Text", "Instructions" }, new Class[] { FormLocationType.class, String.class, String.class });
/*    */ 
/*    */     
/* 34 */     this.config = argFormConfig;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getValueAt(int rowIndex, int columnIndex) {
/* 39 */     if (columnIndex == 0) {
/* 40 */       return super.getValueAt(rowIndex, columnIndex);
/*    */     }
/* 42 */     switch (rowIndex) {
/*    */       case 0:
/* 44 */         return this.config.getFormLocation();
/*    */       case 1:
/* 46 */         return (this.config.getTitleText() == null) ? null : this.config.getTitleText().getUnformattedData();
/*    */       case 2:
/* 48 */         return (this.config.getInstructions() == null) ? null : this.config.getInstructions().getUnformattedData();
/*    */     } 
/* 50 */     logger.warn("unexpected row " + rowIndex);
/* 51 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/* 57 */     if (columnIndex == 1) {
/* 58 */       switch (rowIndex) {
/*    */         case 0:
/* 60 */           this.config.setFormLocation((FormLocationType)aValue);
/*    */           return;
/*    */         case 1:
/* 63 */           this.config.setTitleText("" + aValue);
/*    */           return;
/*    */         case 2:
/* 66 */           this.config.setInstructions("" + aValue);
/*    */           return;
/*    */       } 
/* 69 */       logger.warn("unexpected row " + rowIndex);
/*    */     }
/*    */     else {
/*    */       
/* 73 */       logger.warn("unexpected column " + columnIndex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\FormEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */