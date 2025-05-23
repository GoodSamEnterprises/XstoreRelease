/*    */ package dtv.pos.framework.form.design;
/*    */ 
/*    */ import dtv.pos.ui.UIServices;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Frame;
/*    */ import java.awt.event.WindowEvent;
/*    */ import java.io.IOException;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuBar;
/*    */ import javax.swing.JOptionPane;
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
/*    */ public class FormDesignerHost
/*    */   extends JFrame
/*    */   implements IFormDesignerHost
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 28 */   private static final Logger logger_ = Logger.getLogger(FormDesignerHost.class);
/*    */   
/*    */   private IFormDesigner formDesigner_;
/*    */ 
/*    */   
/*    */   public FormDesignerHost() {
/* 34 */     super("POS Form Designer");
/*    */   }
/*    */ 
/*    */   
/*    */   public void exit() {
/* 39 */     if (this.formDesigner_.isDirty()) {
/*    */       
/* 41 */       int answer = JOptionPane.showConfirmDialog(this, "Do you want to save before exiting?", "Save before close?", 1, 3);
/*    */       
/* 43 */       switch (answer) {
/*    */         case 0:
/*    */           try {
/* 46 */             this.formDesigner_.save();
/*    */           }
/* 48 */           catch (IOException ex) {
/* 49 */             logger_.error("CAUGHT EXCEPTION", ex);
/*    */           } 
/*    */           break;
/*    */ 
/*    */         
/*    */         case 2:
/*    */           return;
/*    */       } 
/*    */     
/*    */     } 
/* 59 */     System.exit(0);
/*    */   }
/*    */ 
/*    */   
/*    */   public Frame getFrame() {
/* 64 */     return this;
/*    */   }
/*    */   
/*    */   public void setFormDesigner(IFormDesigner newValue) {
/* 68 */     this.formDesigner_ = newValue;
/* 69 */     JMenuBar menuBar = new JMenuBar();
/* 70 */     JMenu[] menus = this.formDesigner_.getMenus();
/* 71 */     for (JMenu menu : menus) {
/* 72 */       menuBar.add(menu);
/*    */     }
/* 74 */     setJMenuBar(menuBar);
/* 75 */     setContentPane(this.formDesigner_.getDesignerPanel());
/*    */ 
/*    */     
/* 78 */     setDefaultCloseOperation(3);
/* 79 */     Dimension screenSize = UIServices.getFullScreenSize();
/* 80 */     setSize(screenSize);
/* 81 */     validate();
/* 82 */     setExtendedState(6);
/* 83 */     this.formDesigner_.setDividerLocation((int)screenSize.getHeight() >> 1);
/* 84 */     UIServices.moveWindowToDefaultScreen(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void processWindowEvent(WindowEvent e) {
/* 90 */     if (e.getID() == 201) {
/* 91 */       exit();
/*    */     } else {
/*    */       
/* 94 */       super.processWindowEvent(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\FormDesignerHost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */