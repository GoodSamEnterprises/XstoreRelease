/*    */ package dtv.pos.framework.form.design.dialog;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Frame;
/*    */ import java.awt.HeadlessException;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JLabel;
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
/*    */ public class BlockingMessageDialog
/*    */   extends JDialog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   protected static final Logger logger_ = Logger.getLogger(BlockingMessageDialog.class);
/*    */   
/*    */   protected final Runnable target_;
/*    */   private final Thread thread_;
/* 27 */   private static int threadIndex_ = 0;
/* 28 */   private final JLabel label_ = new JLabel();
/*    */   
/*    */   public BlockingMessageDialog(Frame owner, String title, String message, Runnable target) {
/* 31 */     super(owner, title, true);
/* 32 */     this.label_.setText(message);
/* 33 */     getContentPane().add(this.label_);
/* 34 */     pack();
/* 35 */     centerDialog();
/* 36 */     this.target_ = target;
/* 37 */     this.thread_ = new Thread("BlockingMessageDialogWorkerThread-" + threadIndex_++)
/*    */       {
/*    */         public void run()
/*    */         {
/*    */           try {
/* 42 */             BlockingMessageDialog.this.target_.run();
/*    */           }
/* 44 */           catch (Exception ex) {
/* 45 */             BlockingMessageDialog.logger_.error("CAUGHT EXCEPTION", ex);
/*    */           } finally {
/*    */             
/* 48 */             BlockingMessageDialog.this.setVisible(false);
/*    */           } 
/*    */         }
/*    */       };
/* 52 */     setDefaultCloseOperation(0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVisible(boolean argVisible) {
/* 58 */     if (argVisible) {
/* 59 */       this.thread_.start();
/*    */     }
/* 61 */     super.setVisible(argVisible);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void centerDialog() throws HeadlessException {
/* 68 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 69 */     Dimension dialogSize = getSize();
/* 70 */     if (dialogSize.height > screenSize.height) {
/* 71 */       dialogSize.height = screenSize.height;
/*    */     }
/* 73 */     if (dialogSize.width > screenSize.width) {
/* 74 */       dialogSize.width = screenSize.width;
/*    */     }
/* 76 */     setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\BlockingMessageDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */