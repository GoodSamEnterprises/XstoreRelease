/*     */ package dtv.pos.framework.form.design.dialog;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListSelectorFrame<T>
/*     */   extends JFrame
/*     */   implements IOkCancelListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  29 */   private static final Logger logger_ = Logger.getLogger(ListSelectorFrame.class);
/*     */   
/*     */   private T selectedItem_;
/*     */   
/*     */   private final JScrollPane selectionScrollPane_;
/*     */   
/*     */   private final JList selectionList_;
/*     */   private final JPanel buttonPanel_;
/*     */   
/*     */   public static <S> S showDialog(Component argParent, String argTitle, S[] argOptions) {
/*  39 */     ListSelectorFrame<S> f = new ListSelectorFrame<>(argTitle, argOptions, false);
/*  40 */     if (argParent != null) {
/*  41 */       UIServices.centerComponent(f, argParent);
/*  42 */       Point location = f.getLocation();
/*  43 */       Point parentLocation = argParent.getLocation();
/*  44 */       if (location.x < parentLocation.x) {
/*  45 */         location.x = parentLocation.x;
/*     */       }
/*  47 */       if (location.y < parentLocation.y) {
/*  48 */         location.y = parentLocation.y;
/*     */       }
/*  50 */       f.setLocation(location);
/*     */     } 
/*  52 */     return f.getSelectedValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private final JButton cancelButton_;
/*     */   private final JButton newButton_;
/*     */   private final JButton okButton_;
/*     */   private final OkCancelDispatcher okCancelDispatcher_;
/*     */   
/*     */   public static FormKey showFormKeyDialog(Component argParent, String argTitle, FormKey[] argOptions) {
/*  62 */     ListSelectorFrame<FormKey> f = new ListSelectorFrame<>(argTitle, argOptions, true);
/*  63 */     if (argParent != null) {
/*  64 */       UIServices.centerComponent(f, argParent);
/*  65 */       if ((f.getLocation()).x != 0) {
/*  66 */         f.setLocation(0, (f.getLocation()).y);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     Rectangle bounds = f.getBounds();
/*  76 */     if (bounds.x < 0) {
/*  77 */       bounds.x = 0;
/*     */     }
/*  79 */     if (bounds.y < 0) {
/*  80 */       bounds.y = 0;
/*     */     }
/*  82 */     f.setBounds(bounds);
/*     */     
/*  84 */     return f.getSelectedValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ListSelectorFrame(String argTitle, T[] argOptions, boolean argIncludeNewButton) {
/* 106 */     super(argTitle); GridLayout buttonPanelLayout;
/*     */     this.selectedItem_ = null;
/* 108 */     getContentPane().setLayout(new BorderLayout());
/* 109 */     getContentPane().add(this.selectionScrollPane_ = new JScrollPane(), "Center");
/* 110 */     this.selectionScrollPane_.getViewport().add(this.selectionList_ = new JList());
/* 111 */     this.selectionList_.setSelectionMode(0);
/*     */ 
/*     */     
/* 114 */     if (argIncludeNewButton) {
/* 115 */       buttonPanelLayout = new GridLayout(1, 3);
/*     */     } else {
/*     */       
/* 118 */       buttonPanelLayout = new GridLayout(1, 2);
/*     */     } 
/*     */     
/* 121 */     getContentPane().add(this.buttonPanel_ = new JPanel(buttonPanelLayout), "South");
/* 122 */     this.buttonPanel_.add(this.okButton_ = new JButton("OK"));
/* 123 */     if (argIncludeNewButton) {
/* 124 */       this.buttonPanel_.add(this.newButton_ = new JButton("New"));
/* 125 */       this.newButton_.addActionListener(new ActionListener()
/*     */           {
/*     */             public void actionPerformed(ActionEvent e)
/*     */             {
/* 129 */               new NameNewFormFrame("Choose a name for the new form:", ListSelectorFrame.this);
/*     */             }
/*     */           });
/*     */     }
/*     */     else {
/*     */       
/* 135 */       this.newButton_ = null;
/*     */     } 
/* 137 */     this.buttonPanel_.add(this.cancelButton_ = new JButton("Cancel"));
/*     */     
/* 139 */     this.okCancelDispatcher_ = new OkCancelDispatcher(this.okButton_, this.cancelButton_);
/* 140 */     this.selectionList_.setListData(argOptions);
/*     */     
/* 142 */     pack();
/* 143 */     setSize(new Dimension(350, 450));
/* 144 */     UIServices.centerComponent(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelSelected() {
/* 153 */     this.selectedItem_ = null;
/* 154 */     setVisible(false);
/* 155 */     synchronized (this) {
/* 156 */       notifyAll();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getSelectedValue() {
/* 165 */     setVisible(true);
/*     */     
/*     */     try {
/* 168 */       synchronized (this) {
/* 169 */         wait();
/*     */       }
/*     */     
/* 172 */     } catch (InterruptedException ex) {
/* 173 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 174 */       return null;
/*     */     } 
/* 176 */     return this.selectedItem_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void okSelected() {
/* 184 */     if (this.selectedItem_ == null) {
/* 185 */       this.selectedItem_ = this.selectionList_.getSelectedValue();
/*     */     }
/* 187 */     setVisible(false);
/* 188 */     synchronized (this) {
/* 189 */       notifyAll();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectedValue(T argValue) {
/* 198 */     this.selectedItem_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean argVisible) {
/* 204 */     if (argVisible) {
/* 205 */       this.okCancelDispatcher_.addOkCancelListener(this);
/*     */     } else {
/*     */       
/* 208 */       this.okCancelDispatcher_.removeOkCancelListener(this);
/*     */     } 
/* 210 */     super.setVisible(argVisible);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void processWindowEvent(WindowEvent e) {
/* 217 */     super.processWindowEvent(e);
/* 218 */     if (e.getID() == 201)
/* 219 */       cancelSelected(); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\ListSelectorFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */