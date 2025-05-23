/*     */ package dtv.pos.framework.form.design.model;
/*     */ 
/*     */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*     */ import dtv.pos.framework.form.config.FormViewConfig;
/*     */ import dtv.pos.framework.form.config.FormViewSectionConfig;
/*     */ import dtv.pos.framework.form.design.IFormComponentSelectionListener;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionRefConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.event.TableModelEvent;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.event.TreeSelectionEvent;
/*     */ import javax.swing.event.TreeSelectionListener;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeNode;
/*     */ import javax.swing.tree.TreePath;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormDesignerDetailModel
/*     */   implements TreeSelectionListener, PropertyEditTableModel
/*     */ {
/*  29 */   private static final Logger logger_ = Logger.getLogger(FormDesignerDetailModel.class);
/*     */   
/*  31 */   private final PropertyEditTableModel blankModel_ = new BlankDetailModel();
/*     */   
/*     */   private final IFormComponentSelectionListener callback_;
/*  34 */   private PropertyEditTableModel delegateModel_ = this.blankModel_;
/*     */   
/*  36 */   private final List<TableModelListener> tableModelListeners_ = new ArrayList<>();
/*     */   
/*     */   public FormDesignerDetailModel(IFormComponentSelectionListener callback) {
/*  39 */     this.callback_ = callback;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addTableModelListener(TableModelListener l) {
/*  44 */     this.tableModelListeners_.add(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class getCellClass(int rowIndex, int columnIndex) {
/*  49 */     return this.delegateModel_.getCellClass(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int columnIndex) {
/*  54 */     return this.delegateModel_.getColumnClass(columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/*  59 */     return this.delegateModel_.getColumnCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int columnIndex) {
/*  64 */     return this.delegateModel_.getColumnName(columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/*  69 */     return this.delegateModel_.getRowCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/*  74 */     return this.delegateModel_.getValueAt(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  79 */     return this.delegateModel_.isCellEditable(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeTableModelListener(TableModelListener l) {
/*  84 */     this.tableModelListeners_.remove(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/*  89 */     this.delegateModel_.setValueAt(aValue, rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public void valueChanged(TreeSelectionEvent e) {
/*     */     try {
/*  95 */       this.callback_.setSelectedFormComponent(null);
/*     */       
/*  97 */       TreePath p = e.getPath();
/*  98 */       Object[] nodes = p.getPath();
/*  99 */       TreeNode selected = (TreeNode)nodes[nodes.length - 1];
/*     */       
/* 101 */       if (selected instanceof DefaultMutableTreeNode) {
/* 102 */         Object userObject = ((DefaultMutableTreeNode)selected).getUserObject();
/* 103 */         if (userObject instanceof FormViewCellConfig) {
/* 104 */           this.delegateModel_ = new CellEditModel((FormViewCellConfig)userObject);
/* 105 */           IFormComponent activeFormComponent = ((FormViewCellConfig)userObject).getActiveFormComponent();
/* 106 */           if (activeFormComponent == null) {
/* 107 */             logger_.warn("active form component is null");
/*     */           } else {
/*     */             
/* 110 */             this.callback_.setSelectedFormComponent(activeFormComponent.getDisplayComponent());
/*     */           }
/*     */         
/* 113 */         } else if (userObject instanceof dtv.pos.framework.form.config.FormViewPanelConfig) {
/* 114 */           this.delegateModel_ = new PanelEditModel((IFormViewPanelConfig)userObject);
/*     */         }
/* 116 */         else if (userObject instanceof FormViewConfig) {
/* 117 */           this.delegateModel_ = new FormEditModel((FormViewConfig)userObject);
/*     */         }
/* 119 */         else if (userObject instanceof FormViewSectionConfig) {
/* 120 */           this.delegateModel_ = new SectionDetailModel((FormViewSectionConfig)userObject);
/*     */         }
/* 122 */         else if (userObject instanceof dtv.pos.framework.form.config.FormViewSectionRefConfig) {
/* 123 */           this.delegateModel_ = new SectionRefDetailModel((IFormViewSectionRefConfig)userObject);
/*     */         } else {
/*     */           
/* 126 */           this.delegateModel_ = this.blankModel_;
/*     */         } 
/* 128 */         fireChangedEvent();
/*     */       }
/*     */     
/* 131 */     } catch (Exception ex) {
/* 132 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void fireChangedEvent() {
/* 137 */     TableModelEvent event = new TableModelEvent(this);
/* 138 */     for (int i = 0; i < this.tableModelListeners_.size(); i++)
/* 139 */       ((TableModelListener)this.tableModelListeners_.get(i)).tableChanged(event); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\FormDesignerDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */