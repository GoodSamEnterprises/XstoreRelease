/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.ui.component.PosFormPanel;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class TransactionFormPanel<T extends IFormModel>
/*     */   extends FormPanel<T>
/*     */ {
/*     */   private FormPanel topInfoFormPanel_;
/*     */   private FormPanel topInfoFooterFormPanel_;
/*     */   private FormPanel bottomInfoFormPanel_;
/*     */   private FormPanel listFormPanel_;
/*     */   private FormPanel listFooterFormPanel_;
/*     */   private static final String TOP_INFO_CONSTRAINT = "North";
/*     */   private static final String LIST_CONSTRAINT = "Center";
/*     */   private static final String BOTTOM_INFO_CONSTRAINT = "South";
/*     */   private IFormComponent[] formComponents_;
/*     */   private PosFormPanel header_;
/*     */   private PosFormPanel footer_;
/*     */   
/*     */   public TransactionFormPanel(boolean argIsTitled) {
/*  42 */     super(argIsTitled);
/*  43 */     PosFormPanel p = getFormPanel();
/*  44 */     p.setLayout(new BorderLayout());
/*  45 */     p.setFocusable(false);
/*  46 */     this.header_ = new PosFormPanel();
/*  47 */     this.header_.setLayout(new BorderLayout());
/*  48 */     this.header_.setFocusable(false);
/*  49 */     this.footer_ = new PosFormPanel();
/*  50 */     this.footer_.setLayout(new BorderLayout());
/*  51 */     this.footer_.setFocusable(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addFormComponent(IFormComponent comp, String argFieldKey) {
/*  56 */     throw new UnsupportedOperationException("not a configurable panel");
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormComponent[] getFormComponents() {
/*  61 */     if (this.formComponents_ == null) {
/*  62 */       List<IFormComponent> l = new ArrayList<>();
/*  63 */       if (this.topInfoFormPanel_ != null) {
/*  64 */         l.add(this.topInfoFormPanel_);
/*     */       }
/*  66 */       if (this.topInfoFooterFormPanel_ != null) {
/*  67 */         l.add(this.topInfoFooterFormPanel_);
/*     */       }
/*  69 */       if (this.listFormPanel_ != null) {
/*  70 */         l.add(this.listFormPanel_);
/*     */       }
/*  72 */       if (this.listFooterFormPanel_ != null) {
/*  73 */         l.add(this.listFooterFormPanel_);
/*     */       }
/*  75 */       if (this.bottomInfoFormPanel_ != null) {
/*  76 */         l.add(this.bottomInfoFormPanel_);
/*     */       }
/*  78 */       this.formComponents_ = l.<IFormComponent>toArray(new IFormComponent[l.size()]);
/*     */     } 
/*  80 */     return this.formComponents_;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void init(IFormComponentConfig config) {
/*  85 */     throw new UnsupportedOperationException("not a configurable panel");
/*     */   }
/*     */   
/*     */   public void setBottomInfoView(FormPanel argPanel) {
/*  89 */     PosFormPanel p = getFormPanel();
/*  90 */     if (this.bottomInfoFormPanel_ != null) {
/*  91 */       this.footer_.remove(this.bottomInfoFormPanel_.getDisplayComponent());
/*  92 */       p.remove((Component)this.footer_);
/*     */     } 
/*  94 */     this.bottomInfoFormPanel_ = argPanel;
/*  95 */     this.footer_.add(argPanel.getDisplayComponent(), "South");
/*  96 */     p.add((Component)this.footer_, "South");
/*  97 */     this.formComponents_ = null;
/*     */   }
/*     */   
/*     */   public void setListView(FormPanel argPanel) {
/* 101 */     PosFormPanel p = getFormPanel();
/* 102 */     if (this.listFormPanel_ != null) {
/* 103 */       p.remove(this.listFormPanel_.getDisplayComponent());
/*     */     }
/* 105 */     this.listFormPanel_ = argPanel;
/* 106 */     p.add(argPanel.getDisplayComponent(), "Center");
/* 107 */     this.formComponents_ = null;
/*     */   }
/*     */   
/*     */   public void setTopInfoFooterView(FormPanel argPanel) {
/* 111 */     PosFormPanel p = getFormPanel();
/* 112 */     if (this.topInfoFooterFormPanel_ != null) {
/* 113 */       this.header_.remove(this.topInfoFooterFormPanel_.getDisplayComponent());
/* 114 */       p.remove((Component)this.header_);
/*     */     } 
/* 116 */     this.topInfoFooterFormPanel_ = argPanel;
/* 117 */     this.header_.add(argPanel.getDisplayComponent(), "South");
/* 118 */     p.add((Component)this.header_, "North");
/* 119 */     this.formComponents_ = null;
/*     */   }
/*     */   
/*     */   public void setTopInfoView(FormPanel argPanel) {
/* 123 */     PosFormPanel p = getFormPanel();
/* 124 */     if (this.topInfoFormPanel_ != null) {
/* 125 */       this.header_.remove(this.topInfoFormPanel_.getDisplayComponent());
/* 126 */       p.remove((Component)this.header_);
/*     */     } 
/* 128 */     this.topInfoFormPanel_ = argPanel;
/* 129 */     this.header_.add(argPanel.getDisplayComponent(), "North");
/* 130 */     p.add((Component)this.header_, "North");
/* 131 */     this.formComponents_ = null;
/*     */   }
/*     */   
/*     */   public void setTransactionListFooterView(FormPanel argPanel) {
/* 135 */     PosFormPanel p = getFormPanel();
/* 136 */     if (this.listFooterFormPanel_ != null) {
/* 137 */       this.footer_.remove(this.listFooterFormPanel_.getDisplayComponent());
/* 138 */       p.remove((Component)this.footer_);
/*     */     } 
/* 140 */     this.listFooterFormPanel_ = argPanel;
/* 141 */     this.footer_.add(argPanel.getDisplayComponent(), "North");
/* 142 */     p.add((Component)this.footer_, "South");
/* 143 */     this.formComponents_ = null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\TransactionFormPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */