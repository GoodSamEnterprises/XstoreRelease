/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*    */ import dtv.pos.iframework.form.component.IFormComponent;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.ui.ComponentID;
/*    */ import dtv.ui.swing.DtvTabbedPane;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import dtv.util.temp.InjectionHammer;
/*    */ import java.awt.Component;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JComponent;
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
/*    */ public class FormTabbedPane<T extends IFormModel>
/*    */   extends AbstractFormComponent<T>
/*    */ {
/*    */   private DtvTabbedPane tabPane_;
/*    */   private Object value_;
/* 33 */   private List<Object[]> tabs_ = null;
/*    */   
/*    */   public FormTabbedPane() {
/* 36 */     this(DtvTabbedPane.DEFAULT_ID);
/*    */   }
/*    */   
/*    */   public FormTabbedPane(ComponentID argID) {
/* 40 */     InjectionHammer.forceAtInjectProcessing(this);
/* 41 */     this.tabPane_ = new DtvTabbedPane(argID);
/* 42 */     setComponent((JComponent)this.tabPane_);
/*    */   }
/*    */   
/*    */   public void addFormComponent(IFormComponent comp, String argTitle, Icon argIcon) {
/* 46 */     this.tabPane_.addTab(argTitle, argIcon, comp.getDisplayComponent());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(IFormComponentConfig<?> argCfg) {
/* 52 */     super.init(argCfg);
/* 53 */     this.tabs_ = new ArrayList();
/*    */     
/* 55 */     for (ParameterConfig config : argCfg.getParameters()) {
/* 56 */       if (config.getName().equalsIgnoreCase("addTab")) {
/* 57 */         this.tabs_.add(config.getParamValues());
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(ResolvedFieldConfig argFieldDef) {
/* 65 */     super.init(argFieldDef);
/* 66 */     this.tabs_ = new ArrayList();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 73 */     return this.value_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setComponentValue(Object argValue) {
/* 79 */     this.value_ = argValue;
/* 80 */     this.tabPane_.removeAll();
/*    */     
/* 82 */     for (Object[] tab : this.tabs_) {
/* 83 */       String title = "No title set";
/* 84 */       Icon icon = null;
/* 85 */       Component c = null;
/*    */       
/* 87 */       for (Object value : tab) {
/* 88 */         if (value instanceof String) {
/* 89 */           title = (String)value;
/*    */         }
/* 91 */         else if (value instanceof Icon) {
/* 92 */           icon = (Icon)value;
/*    */         }
/* 94 */         else if (value instanceof Component) {
/* 95 */           c = (Component)value;
/*    */         } 
/*    */       } 
/*    */       
/* 99 */       this.tabPane_.addTab(title, icon, c);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormTabbedPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */