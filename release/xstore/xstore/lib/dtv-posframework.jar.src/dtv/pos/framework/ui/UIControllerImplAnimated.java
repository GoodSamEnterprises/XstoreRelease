/*     */ package dtv.pos.framework.ui;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.ui.component.PosAnimatedCardedPanel;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.ui.component.PosFormPanel;
/*     */ import dtv.pos.ui.plaf.component.TransactionViewHelper;
/*     */ import dtv.ui.ImageUtils;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.event.HierarchyEvent;
/*     */ import java.awt.event.HierarchyListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIControllerImplAnimated
/*     */   extends UIControllerImpl
/*     */ {
/*     */   private static boolean isAnimatedCustomerMaintenanceIn;
/*     */   private CustomerMaintenanceHierarchyListener hierarchyListener_;
/*     */   
/*     */   public JComponent showFormView(FormKey viewKey, FormLocationType location, boolean requestFocus) {
/*  42 */     String keyString = viewKey.toString();
/*  43 */     final String locationString = (location != null) ? location.toString() : "MULTI_PURPOSE_VIEW";
/*  44 */     this.currentFocusView_ = keyString;
/*     */     
/*  46 */     if (this.uiName_ != null && !this.uiName_.equalsIgnoreCase("BACK_OFFICE") && !isAnimatedCustomerMaintenanceIn && viewKey
/*  47 */       .toString().startsWith("CUSTOMER_MAINTENANCE")) {
/*  48 */       JComponent cardedPanel = (JComponent)getNamedComponent("GENERAL_VIEW");
/*  49 */       cardedPanel.putClientProperty("PAINT_TRANSACTION_IMAGE", Boolean.valueOf(true));
/*  50 */       cardedPanel.putClientProperty("TRANSACTION_IMAGE", ImageUtils.createScreenShot(cardedPanel));
/*     */     } 
/*     */ 
/*     */     
/*  54 */     JComponent result = getFormView(viewKey, location);
/*     */     
/*  56 */     if (this.uiName_ != null && !this.uiName_.equalsIgnoreCase("BACK_OFFICE") && viewKey
/*  57 */       .equals(FormKey.valueOf("CUSTOMER_MAINTENANCE"))) {
/*  58 */       JComponent cardedPanel = (JComponent)getNamedComponent("GENERAL_VIEW");
/*  59 */       if (result instanceof PosFormPanel && ((PosFormPanel)result).getActionGroupKey() == null) {
/*  60 */         cardedPanel.putClientProperty("ANIMATION_TYPE", PosAnimatedCardedPanel.AnimationType.ZOOM_IN);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  66 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  70 */             UIControllerImplAnimated.this.handleUITransition(locationString, true, true);
/*     */           }
/*     */         }true, true);
/*     */ 
/*     */ 
/*     */     
/*  76 */     UIServices.showComponentAndParents(result, true);
/*     */ 
/*     */     
/*  79 */     if (requestFocus) {
/*  80 */       handleFocusTransition(keyString);
/*     */     }
/*     */     
/*  83 */     if (this.uiName_ != null && !this.uiName_.equalsIgnoreCase("BACK_OFFICE") && !isAnimatedCustomerMaintenanceIn && viewKey
/*  84 */       .equals(FormKey.valueOf("CUSTOMER_MAINTENANCE"))) {
/*     */       
/*  86 */       JComponent customerMaintenance = getFormView(FormKey.valueOf("CUSTOMER_MAINTENANCE"), FormLocationType.MULTI_PURPOSE_VIEW);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  95 */       customerMaintenance
/*  96 */         .removeHierarchyListener(getCustomerMaintenanceHierarchyListener(customerMaintenance));
/*  97 */       customerMaintenance.addHierarchyListener(getCustomerMaintenanceHierarchyListener(customerMaintenance));
/*     */       
/*  99 */       if (customerMaintenance.getHeight() > 0 && customerMaintenance.getWidth() > 0) {
/* 100 */         JComponent cardedPanel = (JComponent)getNamedComponent("GENERAL_VIEW");
/* 101 */         cardedPanel.putClientProperty("CUSTOMER_MAINTENANCE_IMAGE", 
/* 102 */             ImageUtils.createScreenShot(customerMaintenance));
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     if (this.uiName_ != null && !this.uiName_.equalsIgnoreCase("BACK_OFFICE") && isAnimatedCustomerMaintenanceIn && 
/* 107 */       TransactionViewHelper.isTransactionForm(viewKey.toString())) {
/* 108 */       zoomOutCustomerMaintenance();
/*     */     }
/*     */     
/* 111 */     if (this.uiName_ != null && !this.uiName_.equalsIgnoreCase("BACK_OFFICE") && viewKey
/* 112 */       .equals(FormKey.valueOf("CUSTOMER_MAINTENANCE"))) {
/* 113 */       isAnimatedCustomerMaintenanceIn = true;
/*     */     }
/*     */     
/* 116 */     return result;
/*     */   }
/*     */   
/*     */   private HierarchyListener getCustomerMaintenanceHierarchyListener(JComponent customerMaintenance) {
/* 120 */     if (this.hierarchyListener_ == null) {
/* 121 */       this.hierarchyListener_ = new CustomerMaintenanceHierarchyListener(customerMaintenance);
/*     */     } else {
/*     */       
/* 124 */       this.hierarchyListener_.setCustomerMaintenance(customerMaintenance);
/*     */     } 
/*     */     
/* 127 */     return this.hierarchyListener_;
/*     */   }
/*     */   
/*     */   private void zoomOutCustomerMaintenance() {
/* 131 */     if (this.uiName_ != null && !this.uiName_.equalsIgnoreCase("BACK_OFFICE") && isAnimatedCustomerMaintenanceIn) {
/* 132 */       JComponent cardedPanel = (JComponent)getNamedComponent("GENERAL_VIEW");
/* 133 */       cardedPanel.putClientProperty("ANIMATION_TYPE", PosAnimatedCardedPanel.AnimationType.ZOOM_OUT);
/*     */       
/* 135 */       JComponent customerMaintenance = getFormView(FormKey.valueOf("CUSTOMER_MAINTENANCE"), FormLocationType.MULTI_PURPOSE_VIEW);
/* 136 */       cardedPanel.putClientProperty("CUSTOMER_MAINTENANCE_IMAGE", 
/* 137 */           ImageUtils.createScreenShot(customerMaintenance));
/* 138 */       cardedPanel.putClientProperty("PAINT_TRANSACTION_IMAGE", Boolean.valueOf(true));
/* 139 */       isAnimatedCustomerMaintenanceIn = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private class CustomerMaintenanceHierarchyListener
/*     */     implements HierarchyListener
/*     */   {
/*     */     private JComponent customerMaintenance_;
/*     */     
/*     */     public CustomerMaintenanceHierarchyListener(JComponent customerMaintenance) {
/* 149 */       this.customerMaintenance_ = customerMaintenance;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hierarchyChanged(HierarchyEvent e) {
/* 155 */       if ((0x4L & e.getChangeFlags()) != 0L && 
/* 156 */         !this.customerMaintenance_.isShowing())
/*     */       {
/*     */ 
/*     */         
/* 160 */         UIControllerImplAnimated.this.zoomOutCustomerMaintenance();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCustomerMaintenance(JComponent customerMaintenance) {
/* 166 */       this.customerMaintenance_ = customerMaintenance;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\UIControllerImplAnimated.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */