/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.pos.ui.component.PosComponentFactory;
/*    */ import dtv.pos.ui.component.PosLabel;
/*    */ import javax.swing.Icon;
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
/*    */ public class XstCenterLabelWrapping
/*    */   extends XstLabel
/*    */ {
/*    */   public XstCenterLabelWrapping() {}
/*    */   
/*    */   public XstCenterLabelWrapping(Icon icon) {
/* 26 */     super(icon);
/*    */   }
/*    */   
/*    */   public XstCenterLabelWrapping(String text) {
/* 30 */     super(text);
/*    */   }
/*    */   
/*    */   public XstCenterLabelWrapping(String text, Icon icon) {
/* 34 */     super(text, icon);
/*    */   }
/*    */ 
/*    */   
/*    */   protected PosLabel createLabel() {
/* 39 */     return (PosLabel)PosComponentFactory.getInstance().createCenterWrappingLabel();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstCenterLabelWrapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */