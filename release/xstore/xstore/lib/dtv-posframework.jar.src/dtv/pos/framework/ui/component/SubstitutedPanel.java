/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.SubstituteComponentConfig;
/*    */ import dtv.pos.framework.ui.config.SubstituteComponentConfigHelper;
/*    */ import dtv.pos.framework.ui.config.SubstituteComponentsConfig;
/*    */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*    */ import dtv.ui.ComponentID;
/*    */ import dtv.ui.swing.DtvPanel;
/*    */ import java.awt.LayoutManager;
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
/*    */ public class SubstitutedPanel<C extends IViewComponentConfig>
/*    */   extends DtvPanel
/*    */   implements ISubstitutedComponent<C>
/*    */ {
/*    */   private static final long serialVersionUID = 4215236372155850935L;
/*    */   private String id_;
/*    */   
/*    */   public SubstitutedPanel() {}
/*    */   
/*    */   public SubstitutedPanel(ComponentID id) {
/* 44 */     super(id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SubstitutedPanel(ComponentID id, LayoutManager layout) {
/* 55 */     super(id, layout);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IViewComponentConfig<C> getNewConfig() {
/* 62 */     String id = getComponentId();
/* 63 */     if (id == null) {
/* 64 */       throw new IllegalArgumentException("Component ID is null");
/*    */     }
/* 66 */     SubstituteComponentsConfig root = SubstituteComponentConfigHelper.getConfig();
/* 67 */     SubstituteComponentConfig config = root.getChild(id);
/* 68 */     if (config == null) {
/* 69 */       throw new IllegalStateException("Component with ID [" + id + "] could not be found");
/*    */     }
/* 71 */     return (IViewComponentConfig<C>)config.getComponentConfig();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setComponentId(String argId) {
/* 76 */     this.id_ = argId;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getComponentId() {
/* 81 */     return this.id_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\SubstitutedPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */