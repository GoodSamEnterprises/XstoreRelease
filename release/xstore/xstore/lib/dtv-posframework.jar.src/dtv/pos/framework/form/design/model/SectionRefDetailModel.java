/*    */ package dtv.pos.framework.form.design.model;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.IFormViewSectionRefConfig;
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
/*    */ 
/*    */ public class SectionRefDetailModel
/*    */   extends AbstractDetailEditModel
/*    */ {
/* 21 */   private static final Logger logger = Logger.getLogger(SectionRefDetailModel.class);
/*    */ 
/*    */   
/*    */   private static final int NAME = 0;
/*    */ 
/*    */   
/*    */   private static final int MODEL_ROW_COUNT = 1;
/*    */   
/*    */   private final IFormViewSectionRefConfig config;
/*    */ 
/*    */   
/*    */   public SectionRefDetailModel(IFormViewSectionRefConfig argSection) {
/* 33 */     super(1, new String[] { "name" }, new Class[] { String.class });
/*    */     
/* 35 */     this.config = argSection;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValueAt(int argRowIndex, int argColumnIndex) {
/* 41 */     if (argColumnIndex == 0) {
/* 42 */       return super.getValueAt(argRowIndex, argColumnIndex);
/*    */     }
/* 44 */     switch (argRowIndex) {
/*    */       case 0:
/* 46 */         return this.config.getName();
/*    */     } 
/* 48 */     logger.warn("unexpected row " + argRowIndex);
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValueAt(Object argAValue, int argRowIndex, int argColumnIndex) {
/* 56 */     if (argColumnIndex == 1) {
/* 57 */       switch (argRowIndex) {
/*    */         case 0:
/* 59 */           this.config.setName(String.valueOf(argAValue));
/*    */           return;
/*    */       } 
/* 62 */       logger.warn("unexpected row " + argRowIndex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\SectionRefDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */