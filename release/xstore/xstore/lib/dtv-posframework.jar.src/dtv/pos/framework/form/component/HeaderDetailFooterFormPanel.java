/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.form.component.IFormComponent;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.pos.ui.component.PosFormPanel;
/*    */ import java.awt.BorderLayout;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class HeaderDetailFooterFormPanel<T extends IFormModel>
/*    */   extends FormPanel<T>
/*    */ {
/*    */   private FormPanel headerViewFormPanel_;
/*    */   private FormPanel detailViewFormPanel_;
/*    */   private FormPanel footerViewFormPanel_;
/* 29 */   private static final Object HEADER_CONSTRAINT = "North";
/* 30 */   private static final Object DETAIL_CONSTRAINT = "Center";
/* 31 */   private static final Object FOOTER_CONSTRAINT = "South";
/*    */   
/*    */   private IFormComponent[] formComponents_;
/*    */   
/*    */   public HeaderDetailFooterFormPanel(boolean argIsTitled) {
/* 36 */     super(argIsTitled);
/* 37 */     PosFormPanel p = getFormPanel();
/* 38 */     p.setLayout(new BorderLayout());
/* 39 */     p.setFocusable(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void addFormComponent(IFormComponent comp, String argFieldKey) {
/* 44 */     throw new UnsupportedOperationException("not a configurable panel");
/*    */   }
/*    */ 
/*    */   
/*    */   public IFormComponent[] getFormComponents() {
/* 49 */     if (this.formComponents_ == null) {
/* 50 */       List<IFormComponent> l = new ArrayList<>();
/* 51 */       if (this.headerViewFormPanel_ != null) {
/* 52 */         l.add(this.headerViewFormPanel_);
/*    */       }
/* 54 */       if (this.detailViewFormPanel_ != null) {
/* 55 */         l.add(this.detailViewFormPanel_);
/*    */       }
/* 57 */       if (this.footerViewFormPanel_ != null) {
/* 58 */         l.add(this.footerViewFormPanel_);
/*    */       }
/* 60 */       this.formComponents_ = l.<IFormComponent>toArray(new IFormComponent[l.size()]);
/*    */     } 
/* 62 */     return this.formComponents_;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void init(IFormComponentConfig config) {
/* 67 */     throw new UnsupportedOperationException("not a configurable panel");
/*    */   }
/*    */   
/*    */   public void setDetailView(FormPanel argPanel) {
/* 71 */     PosFormPanel p = getFormPanel();
/* 72 */     if (this.detailViewFormPanel_ != null) {
/* 73 */       p.remove(this.detailViewFormPanel_.getDisplayComponent());
/*    */     }
/* 75 */     this.detailViewFormPanel_ = argPanel;
/* 76 */     p.add(argPanel.getDisplayComponent(), DETAIL_CONSTRAINT);
/* 77 */     this.formComponents_ = null;
/*    */   }
/*    */   
/*    */   public void setFooterView(FormPanel argPanel) {
/* 81 */     PosFormPanel p = getFormPanel();
/* 82 */     if (this.footerViewFormPanel_ != null) {
/* 83 */       p.remove(this.footerViewFormPanel_.getDisplayComponent());
/*    */     }
/* 85 */     this.footerViewFormPanel_ = argPanel;
/* 86 */     p.add(argPanel.getDisplayComponent(), FOOTER_CONSTRAINT);
/* 87 */     this.formComponents_ = null;
/*    */   }
/*    */   
/*    */   public void setHeaderView(FormPanel argPanel) {
/* 91 */     PosFormPanel p = getFormPanel();
/* 92 */     if (this.headerViewFormPanel_ != null) {
/* 93 */       p.remove(this.headerViewFormPanel_.getDisplayComponent());
/*    */     }
/* 95 */     this.headerViewFormPanel_ = argPanel;
/* 96 */     p.add(argPanel.getDisplayComponent(), HEADER_CONSTRAINT);
/* 97 */     this.formComponents_ = null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\HeaderDetailFooterFormPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */