/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.ui.UIServices;
/*     */ import dtv.pos.ui.component.PosTextField;
/*     */ import dtv.pos.ui.plaf.PosBorders;
/*     */ import dtv.ui.model.IListSelectionModel;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.UIManager;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class XstFocusBarTextField
/*     */   extends XstTextField
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(XstFocusBarTextField.class);
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public XstFocusBarTextField() {
/*  38 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PosTextField createTextField() {
/*  43 */     return new DefaultFocusBarTextField();
/*     */   }
/*     */   
/*     */   protected class DefaultFocusBarTextField
/*     */     extends PosTextField
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public DefaultFocusBarTextField() {
/*  52 */       setFocusPainted(true);
/*  53 */       setBorder(PosBorders.getFocusBarTextFieldBorder());
/*  54 */       setFont(UIServices.getNonLookAndFeelFont(UIManager.getFont("PosFocusBar.fieldFont")));
/*  55 */       setHorizontalAlignment(4);
/*  56 */       setFocusTraversalKeysEnabled(false);
/*  57 */       setOpaque(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  63 */       addKeyListener(new KeyListener()
/*     */           {
/*     */             public void keyPressed(KeyEvent e)
/*     */             {
/*  67 */               if (e.getKeyCode() == 32) {
/*     */                 
/*  69 */                 IListSelectionModel selModel = ((IModeController)XstFocusBarTextField.this._modeProvider.get()).getStationModel().getCurrentListModel().getSelectionModel();
/*  70 */                 if (selModel.getSelectionMode() == 2 && 
/*  71 */                   !selModel.getValueIsAdjusting()) {
/*  72 */                   int anchor = selModel.getAnchorSelectionIndex();
/*  73 */                   int[] indices = selModel.getSelections();
/*  74 */                   boolean selected = false;
/*     */                   
/*  76 */                   for (int index : indices) {
/*  77 */                     if (index == anchor) {
/*  78 */                       selected = true;
/*     */                       
/*     */                       break;
/*     */                     } 
/*     */                   } 
/*  83 */                   if (selected) {
/*  84 */                     selModel.removeSelectionInterval(anchor, anchor);
/*     */                   } else {
/*     */                     
/*  87 */                     selModel.addSelectionInterval(anchor, anchor);
/*     */                   } 
/*     */                   
/*  90 */                   e.consume();
/*     */                 } 
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void keyReleased(KeyEvent e) {}
/*     */ 
/*     */             
/*     */             public void keyTyped(KeyEvent e) {}
/*     */           });
/* 102 */       if (XstFocusBarTextField.logger_.isDebugEnabled()) {
/* 103 */         addFocusListener(new FocusListener()
/*     */             {
/*     */               public void focusGained(FocusEvent event) {
/* 106 */                 XstFocusBarTextField.logger_.debug("FOCUS BAR FOCUS GAINED FROM " + event.getOppositeComponent());
/*     */               }
/*     */ 
/*     */               
/*     */               public void focusLost(FocusEvent event) {
/* 111 */                 XstFocusBarTextField.logger_.debug("FOCUS BAR FOCUS LOST TO " + event.getOppositeComponent());
/*     */               }
/*     */             });
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEnabled(boolean enabled) {
/* 121 */       setEditable(enabled);
/* 122 */       super.setEnabled(enabled);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstFocusBarTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */