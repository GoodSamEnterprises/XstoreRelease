/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
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
/*    */ public class FormLabelDiminished<T extends IFormModel>
/*    */   extends FormLabel<T>
/*    */ {
/*    */   protected Font getDefaultFont() {
/* 27 */     return getDisplayComponent().getFont().deriveFont(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Color getDefaultForeground() {
/* 36 */     return Color.DARK_GRAY;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormLabelDiminished.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */