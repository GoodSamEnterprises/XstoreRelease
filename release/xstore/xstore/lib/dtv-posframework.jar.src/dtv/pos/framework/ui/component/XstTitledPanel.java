/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.pos.ui.component.PosComponentFactory;
/*    */ import dtv.pos.ui.component.PosTitledPanel;
/*    */ import dtv.util.MutableString;
/*    */ import javax.swing.ImageIcon;
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
/*    */ public class XstTitledPanel
/*    */   implements IXstViewComponent
/*    */ {
/*    */   private final PosTitledPanel titledPanel_;
/*    */   
/*    */   public XstTitledPanel() {
/* 28 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public XstTitledPanel(JComponent content) {
/* 34 */     this.titledPanel_ = PosComponentFactory.getInstance().createTitledPanel();
/* 35 */     setContent(content);
/*    */   }
/*    */   
/*    */   public JComponent getContent() {
/* 39 */     return getTitledPanel().getContent();
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
/* 51 */     return (JComponent)getTitledPanel();
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 56 */     return (JComponent)getTitledPanel();
/*    */   }
/*    */   
/*    */   public void setContent(IXstViewComponent content) {
/* 60 */     setContent((content != null) ? content.getDisplayComponent() : null);
/*    */   }
/*    */   
/*    */   public void setContent(JComponent content) {
/* 64 */     getTitledPanel().setContent(content);
/*    */   }
/*    */   
/*    */   public void setIcon(ImageIcon icon) {
/* 68 */     getTitledPanel().setIcon(icon);
/*    */   }
/*    */   
/*    */   public void setTitle(IFormattable title) {
/* 72 */     setTitle(LocaleManager.getInstance().getRegisteredString(title));
/*    */   }
/*    */   
/*    */   public void setTitle(MutableString title) {
/* 76 */     getTitledPanel().setTitle(title);
/*    */   }
/*    */   
/*    */   private PosTitledPanel getTitledPanel() {
/* 80 */     return this.titledPanel_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstTitledPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */