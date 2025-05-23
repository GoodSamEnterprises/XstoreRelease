/*    */ package dtv.pos.framework.form.design.model;
/*    */ 
/*    */ import dtv.pos.framework.form.config.FormViewSectionConfig;
/*    */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
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
/*    */ public class SectionDetailModel
/*    */   extends AbstractDetailEditModel
/*    */ {
/* 22 */   private static final Logger logger = Logger.getLogger(SectionDetailModel.class);
/*    */ 
/*    */   
/*    */   private static final int NAME = 0;
/*    */   
/*    */   private static final int VISIBLE = 1;
/*    */   
/*    */   private static final int MODEL_ROW_COUNT = 2;
/*    */   
/*    */   private final IFormViewSectionConfig config;
/*    */ 
/*    */   
/*    */   public SectionDetailModel(FormViewSectionConfig argSection) {
/* 35 */     super(2, new String[] { "name", "visible" }, new Class[] { String.class, Boolean.class });
/*    */     
/* 37 */     this.config = (IFormViewSectionConfig)argSection;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValueAt(int argRowIndex, int argColumnIndex) {
/* 43 */     if (argColumnIndex == 0) {
/* 44 */       return super.getValueAt(argRowIndex, argColumnIndex);
/*    */     }
/* 46 */     switch (argRowIndex) {
/*    */       case 0:
/* 48 */         return this.config.getName();
/*    */       case 1:
/* 50 */         return Boolean.valueOf(this.config.getVisible());
/*    */     } 
/* 52 */     logger.warn("unexpected row " + argRowIndex);
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValueAt(Object argAValue, int argRowIndex, int argColumnIndex) {
/* 60 */     if (argColumnIndex == 1) {
/* 61 */       switch (argRowIndex) {
/*    */         case 0:
/* 63 */           this.config.setName(String.valueOf(argAValue));
/*    */           return;
/*    */         case 1:
/*    */           try {
/* 67 */             this.config.setVisible(Boolean.valueOf("" + argAValue));
/*    */           }
/* 69 */           catch (Exception ex) {
/*    */             
/* 71 */             logger.debug("CAUGHT EXCEPTION", ex);
/*    */           } 
/*    */           return;
/*    */       } 
/* 75 */       logger.warn("unexpected row " + argRowIndex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\SectionDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */