/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.pos.ui.component.PosComponentFactory;
/*    */ import dtv.pos.ui.component.PosTitledInstructionPanel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XstSecondaryTitledInstructionPanel
/*    */   extends XstTitledInstructionPanel
/*    */ {
/*    */   public XstSecondaryTitledInstructionPanel() {}
/*    */   
/*    */   public XstSecondaryTitledInstructionPanel(JComponent argContent) {
/* 30 */     super(argContent);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected PosTitledInstructionPanel createContents() {
/* 36 */     return PosComponentFactory.getInstance().createSecondaryTitledInstructionPanel();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstSecondaryTitledInstructionPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */