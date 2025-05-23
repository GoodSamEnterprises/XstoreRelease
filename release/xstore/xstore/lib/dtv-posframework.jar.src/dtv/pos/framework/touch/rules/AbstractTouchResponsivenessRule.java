/*     */ package dtv.pos.framework.touch.rules;
/*     */ 
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*     */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*     */ import dtv.pos.iframework.validation.ValidationDataType;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountDetail;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractTouchResponsivenessRule
/*     */   implements ITouchResponsivenessRule
/*     */ {
/*  33 */   private static final Logger _logger = Logger.getLogger(AbstractTouchResponsivenessRule.class);
/*     */   
/*     */   private ITouchConfig _parentConfig;
/*     */   
/*     */   private boolean _invert = false;
/*     */   
/*     */   @Inject
/*     */   protected Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public AbstractTouchResponsivenessRule() {
/*  44 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITouchConfig getParentConfigObject() {
/*  50 */     return this._parentConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isResponsive(MouseEvent argE) {
/*  56 */     boolean result = isResponsiveImpl(argE);
/*  57 */     return this._invert ? (!result) : result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/*  63 */     if ("inverted".equalsIgnoreCase(argName) || "invert".equalsIgnoreCase(argName)) {
/*  64 */       this._invert = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/*  67 */       _logger.warn("Unexpected parameter for [" + getClass().getName() + "]: [" + argName + "]=[" + argValue
/*  68 */           .toString() + "] @@ " + argValue.getSourceDescription());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentConfigObject(ITouchConfig argParentConfig) {
/*  75 */     this._parentConfig = argParentConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getListSelection() {
/*     */     Object resultData;
/*  84 */     List<Object> listElements = ((IModeController)this._modeProvider.get()).getStationModel().getCurrentListModel().getSelectedElements();
/*     */     
/*  86 */     if (listElements == null || listElements.isEmpty()) {
/*  87 */       resultData = null;
/*     */     } else {
/*     */       
/*  90 */       resultData = listElements.get(0);
/*     */     } 
/*     */     
/*  93 */     return resultData;
/*     */   }
/*     */   
/*     */   protected ISaleReturnLineItem getSelectedSaleLineItem() {
/*  97 */     Object selection = getListSelection();
/*     */     
/*  99 */     ISaleReturnLineItem result = null;
/* 100 */     if (selection instanceof ISaleReturnLineItem) {
/* 101 */       result = (ISaleReturnLineItem)selection;
/*     */     }
/* 103 */     if (selection instanceof ICustomerItemAccountDetail) {
/* 104 */       ICustomerItemAccountDetail detail = (ICustomerItemAccountDetail)selection;
/* 105 */       if (detail.getRetailLineItem() instanceof ISaleReturnLineItem) {
/* 106 */         result = (ISaleReturnLineItem)detail.getRetailLineItem();
/*     */       }
/*     */     } 
/*     */     
/* 110 */     return result;
/*     */   }
/*     */   
/*     */   protected Object getValidationData() {
/* 114 */     return null;
/*     */   }
/*     */   
/*     */   protected ValidationDataType getValidationDataType() {
/* 118 */     return ValidationDataType.OBJECT;
/*     */   }
/*     */   
/*     */   protected boolean isResponsiveImpl(MouseEvent argE) {
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\AbstractTouchResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */