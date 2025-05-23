/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.ui.ComponentPropertySet;
/*    */ import dtv.ui.StringObjectPair;
/*    */ import dtv.ui.renderer.ScaledImageRenderer;
/*    */ import dtv.ui.swing.DtvPanel;
/*    */ import java.awt.Color;
/*    */ import java.awt.Image;
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
/*    */ public class StartupScreenView
/*    */   implements IXstViewComponent
/*    */ {
/*    */   private final DtvPanel panel_;
/*    */   
/*    */   public StartupScreenView() {
/* 31 */     this.panel_ = new MyDtvPanel();
/* 32 */     this.panel_.setFocusable(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getDisplayComponent() {
/* 37 */     return (JComponent)this.panel_;
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 42 */     return (JComponent)this.panel_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   class MyDtvPanel
/*    */     extends DtvPanel
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */     
/* 53 */     ComponentPropertySet set_ = new ComponentPropertySet(); public MyDtvPanel() {
/* 54 */       Image backgroundImage = IXstViewComponent.UIRM.getImage("_imageStartupFillerNormal");
/* 55 */       Image backgroundDisabledImage = IXstViewComponent.UIRM.getImage("_imageStartupFillerDisabled");
/*    */       
/* 57 */       this.set_.put(new StringObjectPair("background", new ScaledImageRenderer.UIResource(backgroundImage)));
/*    */       
/* 59 */       this.set_.put(new StringObjectPair("backgroundDisabled", new ScaledImageRenderer.UIResource(backgroundDisabledImage)));
/*    */       
/* 61 */       setBorder(BorderFactory.createLineBorder(Color.WHITE));
/*    */     }
/*    */ 
/*    */     
/*    */     public ComponentPropertySet getPropertySet() {
/* 66 */       return this.set_;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\StartupScreenView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */