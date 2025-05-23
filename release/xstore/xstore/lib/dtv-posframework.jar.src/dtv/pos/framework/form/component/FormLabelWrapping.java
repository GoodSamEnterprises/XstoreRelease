/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*    */ import dtv.pos.framework.ui.component.XstLabel;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.pos.ui.component.PosLabel;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JComponent;
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
/*    */ public class FormLabelWrapping<T extends IFormModel>
/*    */   extends FormLabel<T>
/*    */ {
/*    */   private boolean _useOldConf = false;
/*    */   
/*    */   public void init(IFormComponentConfig<?> argCfg) {
/* 33 */     JComponent displayComp = this.label_.getDisplayComponent();
/* 34 */     if (!(displayComp instanceof PosLabel)) {
/*    */       return;
/*    */     }
/* 37 */     PosLabel l = (PosLabel)displayComp;
/*    */     
/* 39 */     int width = 32767;
/* 40 */     int height = 32767;
/* 41 */     l.setPreferredSize(new Dimension(width, height));
/*    */     
/* 43 */     super.init(argCfg);
/* 44 */     this._useOldConf = true;
/*    */     
/* 46 */     FormViewCellConfig config = (FormViewCellConfig)argCfg;
/* 47 */     String layoutLocation = config.getLayoutLocation();
/* 48 */     String[] layoutParams = layoutLocation.split(", ");
/* 49 */     if (layoutParams.length >= 4)
/* 50 */       switch (layoutParams[4].charAt(0)) {
/*    */         case 'C':
/* 52 */           l.setHorizontalAlignment(0);
/*    */           break;
/*    */         case 'R':
/* 55 */           l.setHorizontalAlignment(4);
/*    */           break;
/*    */       }  
/* 58 */     if (layoutParams.length >= 5) {
/* 59 */       switch (layoutParams[5].charAt(0)) {
/*    */         case 'C':
/* 61 */           l.setVerticalAlignment(0);
/*    */           break;
/*    */         case 'R':
/* 64 */           l.setVerticalAlignment(4);
/*    */           break;
/*    */         case 'T':
/* 67 */           l.setVerticalAlignment(1);
/*    */           break;
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(ResolvedFieldConfig argFieldDef) {
/* 77 */     super.init(argFieldDef);
/*    */     
/* 79 */     JComponent displayComp = this.label_.getDisplayComponent();
/* 80 */     if (!(displayComp instanceof PosLabel)) {
/*    */       return;
/*    */     }
/* 83 */     PosLabel l = (PosLabel)displayComp;
/* 84 */     l.setHorizontalTextPosition(argFieldDef.getHorizontalAlignment());
/* 85 */     l.setHorizontalAlignment(argFieldDef.getHorizontalAlignment());
/* 86 */     l.setVerticalAlignment(argFieldDef.getVerticalAlignment());
/* 87 */     l.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
/*    */   }
/*    */ 
/*    */   
/*    */   protected XstLabel createLabel() {
/* 92 */     XstLabel label = XstViewComponentFactory.getInstance().createWrappingLabel();
/*    */     
/* 94 */     if (this._useOldConf) {
/* 95 */       label.getFocusComponent().setPreferredSize(new Dimension(2147483647, 2147483647));
/*    */     }
/*    */     
/* 98 */     return label;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormLabelWrapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */