/*     */ package dtv.pos.framework.form.design.model;
/*     */ 
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionRefConfig;
/*     */ import dtv.util.IParent;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeModel;
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
/*     */ public class FormViewConfigTreeModel
/*     */   extends DefaultTreeModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final IFormViewConfig config_;
/*     */   private final DefaultMutableTreeNode root_;
/*     */   
/*     */   public FormViewConfigTreeModel(IFormViewConfig argConfig) {
/*  35 */     super(new DefaultMutableTreeNode(argConfig));
/*     */     
/*  37 */     this.config_ = argConfig;
/*  38 */     this.root_ = (DefaultMutableTreeNode)getRoot();
/*     */     
/*  40 */     IFormViewPanelConfig[] ca = this.config_.getViewPanelConfigs();
/*  41 */     for (IFormViewPanelConfig element : ca) {
/*  42 */       DefaultMutableTreeNode panelRoot = new DefaultMutableTreeNode(element);
/*  43 */       this.root_.add(panelRoot);
/*  44 */       addChildren(panelRoot, (IParent)element);
/*     */     } 
/*     */     
/*  47 */     IFormViewSectionConfig[] sections = this.config_.getViewSectionConfigs();
/*  48 */     for (IFormViewSectionConfig element : sections) {
/*  49 */       DefaultMutableTreeNode panelRoot = new DefaultMutableTreeNode(element);
/*  50 */       this.root_.add(panelRoot);
/*  51 */       addChildren(panelRoot, (IParent)element);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultMutableTreeNode getFormCellNode(IFormViewCellConfig argConfig) {
/*  63 */     DefaultMutableTreeNode panelNode = (DefaultMutableTreeNode)this.root_.getFirstChild();
/*  64 */     while (panelNode != null) {
/*  65 */       DefaultMutableTreeNode node = getFormCellNode(panelNode, argConfig);
/*  66 */       if (node != null) {
/*  67 */         return node;
/*     */       }
/*  69 */       panelNode = panelNode.getNextSibling();
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultMutableTreeNode getFormPanelNode(IFormViewPanelConfig argConfig) {
/*  82 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.root_.getFirstChild();
/*     */     while (true) {
/*  84 */       if (node == null || node.getUserObject() == argConfig) {
/*  85 */         return node;
/*     */       }
/*  87 */       node = node.getNextSibling();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultMutableTreeNode getFormSectionNode(IFormViewSectionConfig argConfig) {
/*  99 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.root_.getFirstChild();
/*     */     while (true) {
/* 101 */       if (node == null || node.getUserObject() == argConfig) {
/* 102 */         return node;
/*     */       }
/* 104 */       node = node.getNextSibling();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultMutableTreeNode getFormSectionRefNode(IFormViewSectionRefConfig argConfig) {
/* 116 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.root_.getFirstChild();
/*     */     while (true) {
/* 118 */       if (node == null || node.getUserObject() == argConfig) {
/* 119 */         return node;
/*     */       }
/* 121 */       node = node.getNextSibling();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void addChildren(DefaultMutableTreeNode argParentNode, IParent argPanelConfig) {
/* 127 */     Collection<?> children = argPanelConfig.getChildren();
/* 128 */     for (Iterator<?> iter = children.iterator(); iter.hasNext(); ) {
/* 129 */       Object item = iter.next();
/* 130 */       DefaultMutableTreeNode node = new DefaultMutableTreeNode(item);
/* 131 */       argParentNode.add(node);
/* 132 */       if (item instanceof IParent)
/*     */       {
/* 134 */         addChildren(node, (IParent)item);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private DefaultMutableTreeNode getFormCellNode(DefaultMutableTreeNode parent, IFormViewCellConfig config) {
/* 140 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)parent.getFirstChild();
/*     */     
/*     */     while (true) {
/* 143 */       if (node == null || node.getUserObject() == config) {
/* 144 */         return node;
/*     */       }
/* 146 */       node = node.getNextSibling();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\FormViewConfigTreeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */