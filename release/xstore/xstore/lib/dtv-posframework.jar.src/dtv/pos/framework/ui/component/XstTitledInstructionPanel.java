/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosTitledInstructionPanel;
/*     */ import dtv.pos.ui.plaf.component.PosTitledInstructionPanelUI;
/*     */ import dtv.util.MutableString;
/*     */ import java.util.Collection;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
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
/*     */ public class XstTitledInstructionPanel
/*     */   implements IXstViewComponent
/*     */ {
/*     */   private final PosTitledInstructionPanel _titledInstructionPanel;
/*     */   
/*     */   public XstTitledInstructionPanel() {
/*  34 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstTitledInstructionPanel(JComponent argContent) {
/*  45 */     this._titledInstructionPanel = createContents();
/*     */     
/*  47 */     setContent(argContent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getContent() {
/*  56 */     return getTitledInstructionPanel().getContent();
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
/*     */   public JComponent getDisplayComponent() {
/*  68 */     return (JComponent)getTitledInstructionPanel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  76 */     return (JComponent)getTitledInstructionPanel();
/*     */   }
/*     */   
/*     */   public void setBreadCrumbs(Collection<PosTitledInstructionPanelUI.BreadCrumb> breadCrumbs) {
/*  80 */     getTitledInstructionPanel().setBreadCrumbs(breadCrumbs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContent(IXstViewComponent argContent) {
/*  89 */     setContent((argContent != null) ? argContent.getDisplayComponent() : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContent(JComponent argContent) {
/*  98 */     getTitledInstructionPanel().setContent(argContent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIcon(ImageIcon argIcon) {
/* 107 */     getTitledInstructionPanel().setIcon(argIcon);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstruction(IFormattable argInstruction) {
/* 116 */     setInstruction(LocaleManager.getInstance().getRegisteredString(argInstruction));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstruction(MutableString argInstruction) {
/* 125 */     getTitledInstructionPanel().setInstruction(argInstruction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondaryInstruction(IFormattable argInstruction) {
/* 134 */     setSecondaryInstruction(LocaleManager.getInstance().getRegisteredString(argInstruction));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondaryInstruction(MutableString argInstruction) {
/* 143 */     getTitledInstructionPanel().setSecondaryInstruction(argInstruction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(IFormattable argTitle) {
/* 152 */     setTitle(LocaleManager.getInstance().getRegisteredString(argTitle));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(MutableString argTitle) {
/* 161 */     getTitledInstructionPanel().setTitle(argTitle);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PosTitledInstructionPanel createContents() {
/* 166 */     return PosComponentFactory.getInstance().createTitledInstructionPanel();
/*     */   }
/*     */   
/*     */   protected PosTitledInstructionPanel getTitledInstructionPanel() {
/* 170 */     return this._titledInstructionPanel;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstTitledInstructionPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */