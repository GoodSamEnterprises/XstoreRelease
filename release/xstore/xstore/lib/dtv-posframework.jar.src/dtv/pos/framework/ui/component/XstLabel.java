/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.pos.ui.component.PosComponentFactory;
/*    */ import dtv.pos.ui.component.PosLabel;
/*    */ import javax.swing.Icon;
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
/*    */ public class XstLabel
/*    */   implements IXstViewComponent
/*    */ {
/*    */   private final PosLabel label_;
/*    */   
/*    */   public XstLabel() {
/* 27 */     this(null, null);
/*    */   }
/*    */   
/*    */   public XstLabel(Icon icon) {
/* 31 */     this(null, icon);
/*    */   }
/*    */   
/*    */   public XstLabel(String text) {
/* 35 */     this(text, null);
/*    */   }
/*    */   
/*    */   public XstLabel(String text, Icon icon) {
/* 39 */     this.label_ = createLabel();
/*    */     
/* 41 */     setText(text);
/* 42 */     setIcon(icon);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getDisplayComponent() {
/* 54 */     return (JComponent)getLabel();
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 59 */     return (JComponent)getLabel();
/*    */   }
/*    */   
/*    */   public Icon getIcon() {
/* 63 */     return getLabel().getIcon();
/*    */   }
/*    */   
/*    */   public String getText() {
/* 67 */     return getLabel().getText();
/*    */   }
/*    */   
/*    */   public void setIcon(Icon icon) {
/* 71 */     getLabel().setIcon(icon);
/*    */   }
/*    */   
/*    */   public void setText(IFormattable text) {
/* 75 */     getLabel().setText(LocaleManager.getInstance().getRegisteredString(text));
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 79 */     getLabel().setText(text);
/*    */   }
/*    */   
/*    */   protected PosLabel createLabel() {
/* 83 */     return (PosLabel)PosComponentFactory.getInstance().createPrettyLabel();
/*    */   }
/*    */   
/*    */   private PosLabel getLabel() {
/* 87 */     return this.label_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */