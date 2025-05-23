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
/*    */ public class XstLabelWrapping
/*    */   extends XstLabel
/*    */ {
/*    */   public XstLabelWrapping() {}
/*    */   
/*    */   public XstLabelWrapping(Icon icon) {
/* 25 */     super(icon);
/*    */   }
/*    */   
/*    */   public XstLabelWrapping(String text) {
/* 29 */     super(text);
/*    */   }
/*    */   
/*    */   public XstLabelWrapping(String text, Icon icon) {
/* 33 */     super(text, icon);
/*    */   }
/*    */ 
/*    */   
/*    */   protected PosLabel createLabel() {
/* 38 */     return (PosLabel)PosComponentFactory.getInstance().createWrappingLabel();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstLabelWrapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */