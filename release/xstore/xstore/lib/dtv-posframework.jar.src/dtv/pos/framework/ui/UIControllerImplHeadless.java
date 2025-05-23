/*     */ package dtv.pos.framework.ui;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.ui.ISwitchableView;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.util.config.ParameterListConfig;
/*     */ import java.awt.Component;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ public class UIControllerImplHeadless
/*     */   extends UIControllerImpl
/*     */ {
/*     */   public Component createUI(String uiName) {
/*  33 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDialogClose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hideDialog() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hideHelpView() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hidePopupView() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hideUI() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showDialog(IXstViewComponent argContent, String argTitle, Collection<IDtvAction> argActions, boolean argModal, boolean argDecorated) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showFocusBar() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent showFormView(FormKey viewKey, FormLocationType location, boolean requestFocus) {
/*  82 */     return getFormView(viewKey, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showHelpView(IXstEventListener listener) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showPopupIconMenu() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showPopupList(boolean argIsFullScreen) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showPopupLongText() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showPopupMenu() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showPopupNotify() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void showPopupView(boolean argIsFullScreen) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addNamedComponentToLocation(Component comp, ISwitchableView locationRoot) {
/* 130 */     registerNamedComponent(comp, comp.getName());
/*     */   }
/*     */   
/*     */   protected void handleUITransition(String argComponentName, boolean argEnabled) {}
/*     */   
/*     */   protected void handleUITransition(String argComponentName, boolean argVisible, boolean argEnabled, ParameterListConfig argParameters) {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\UIControllerImplHeadless.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */