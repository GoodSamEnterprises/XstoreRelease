/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import java.awt.event.ItemListener;
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
/*    */ public class FormYesNo<T extends IFormModel>
/*    */   extends FormComboBox<T>
/*    */   implements ItemListener
/*    */ {
/*    */   public FormYesNo() {
/* 23 */     YesNoValue yes = new YesNoValue(Boolean.TRUE);
/* 24 */     YesNoValue no = new YesNoValue(Boolean.FALSE);
/* 25 */     this.comboBox_.addItem(yes);
/* 26 */     this.comboBox_.addItem(no);
/* 27 */     this.comboBox_.setSelectedItem(no);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 33 */     YesNoValue o = (YesNoValue)super.getComponentValue();
/*    */     
/* 35 */     if (o == null) {
/* 36 */       return Boolean.FALSE;
/*    */     }
/*    */     
/* 39 */     return o.getValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setComponentValue(Object value) {
/* 45 */     Object obj = null;
/*    */     
/* 47 */     if (value instanceof Boolean) {
/* 48 */       obj = new YesNoValue((Boolean)value);
/*    */     }
/*    */     
/* 51 */     super.setComponentValue(obj);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormYesNo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */