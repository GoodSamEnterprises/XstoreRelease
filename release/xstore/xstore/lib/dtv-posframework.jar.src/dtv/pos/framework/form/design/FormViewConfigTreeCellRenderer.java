/*     */ package dtv.pos.framework.form.design;
/*     */ 
/*     */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*     */ import dtv.pos.framework.form.config.FormViewConfig;
/*     */ import dtv.pos.framework.form.config.FormViewPanelConfig;
/*     */ import dtv.pos.framework.form.config.FormViewSectionConfig;
/*     */ import dtv.pos.framework.form.config.FormViewSectionRefConfig;
/*     */ import dtv.pos.iframework.form.config.FormPanelType;
/*     */ import java.awt.Component;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeCellRenderer;
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
/*     */ public class FormViewConfigTreeCellRenderer
/*     */   extends DefaultTreeCellRenderer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final Logger logger_ = Logger.getLogger(FormViewConfigTreeCellRenderer.class);
/*     */   
/*  29 */   private final StringBuffer stringValue_ = new StringBuffer();
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getTreeCellRendererComponent(JTree argTree, Object argValue, boolean argSelected, boolean argExpanded, boolean argLeaf, int argRow, boolean argHasFocus) {
/*     */     Object object;
/*  35 */     super.getTreeCellRendererComponent(argTree, argValue, argSelected, argExpanded, argLeaf, argRow, argHasFocus);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     if (argValue instanceof DefaultMutableTreeNode) {
/*  41 */       object = ((DefaultMutableTreeNode)argValue).getUserObject();
/*     */     } else {
/*     */       
/*  44 */       object = null;
/*     */     } 
/*     */     
/*  47 */     if (object instanceof FormViewPanelConfig) {
/*  48 */       renderFormViewCell((FormViewPanelConfig)object);
/*  49 */       return this;
/*     */     } 
/*  51 */     if (object instanceof FormViewCellConfig) {
/*  52 */       renderFormViewCell((FormViewCellConfig)object);
/*  53 */       return this;
/*     */     } 
/*  55 */     if (object instanceof FormViewConfig) {
/*  56 */       renderFormViewCell((FormViewConfig)object);
/*  57 */       return this;
/*     */     } 
/*  59 */     if (object instanceof FormViewSectionConfig) {
/*  60 */       renderFormViewCell((FormViewSectionConfig)object);
/*  61 */       return this;
/*     */     } 
/*  63 */     if (object instanceof FormViewSectionRefConfig) {
/*  64 */       renderFormViewCell((FormViewSectionRefConfig)object);
/*  65 */       return this;
/*     */     } 
/*     */     
/*  68 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderFormViewCell(FormViewCellConfig argCell) {
/*     */     try {
/*  75 */       this.stringValue_.setLength(0);
/*  76 */       this.stringValue_.append(argCell.getType());
/*  77 */       if (argCell.getResource() != null) {
/*  78 */         this.stringValue_.append(" - ");
/*  79 */         this.stringValue_.append(argCell.getResource());
/*     */       }
/*  81 */       else if (argCell.getTextKey() != null) {
/*  82 */         this.stringValue_.append(" - ");
/*  83 */         this.stringValue_
/*  84 */           .append((argCell.getTextKey() == null) ? null : argCell.getTextKey().getUnformattedData());
/*     */       } 
/*     */       
/*  87 */       setText(this.stringValue_.toString());
/*     */     }
/*  89 */     catch (Exception ex) {
/*  90 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderFormViewCell(FormViewConfig argForm) {
/*  95 */     setText(argForm.getFormKey().toString());
/*     */   }
/*     */   
/*     */   private void renderFormViewCell(FormViewPanelConfig argCell) {
/*  99 */     this.stringValue_.setLength(0);
/* 100 */     this.stringValue_.append(argCell.getPanelType());
/* 101 */     if (FormPanelType.DETAIL.equals(argCell.getPanelType())) {
/* 102 */       this.stringValue_.append(" - ");
/* 103 */       this.stringValue_.append(argCell.getFormTabKey());
/*     */     } 
/* 105 */     setText(this.stringValue_.toString());
/*     */   }
/*     */   
/*     */   private void renderFormViewCell(FormViewSectionConfig argCell) {
/* 109 */     this.stringValue_.setLength(0);
/* 110 */     this.stringValue_.append(argCell.getName());
/* 111 */     setText(this.stringValue_.toString());
/*     */   }
/*     */   
/*     */   private void renderFormViewCell(FormViewSectionRefConfig argCell) {
/* 115 */     this.stringValue_.setLength(0);
/* 116 */     this.stringValue_.append(argCell.getName());
/* 117 */     setText(this.stringValue_.toString());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\FormViewConfigTreeCellRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */