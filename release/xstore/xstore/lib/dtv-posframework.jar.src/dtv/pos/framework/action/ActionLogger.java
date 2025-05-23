/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.test.ITestHarness;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
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
/*     */ public class ActionLogger
/*     */ {
/*  33 */   private static final Logger _logger = Logger.getLogger(ActionLogger.class);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ITestHarness _testHarness;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public void logAllActions() {
/*  45 */     logAllActions(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logAllActions(String argFormKey) {
/*  54 */     if (shouldLog()) {
/*  55 */       StringBuilder sb = new StringBuilder("\n******PROMPT ACTIONS******");
/*  56 */       appendActions(sb, "PROMPT", ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel().getActions());
/*  57 */       appendFormActions(sb, argFormKey);
/*  58 */       appendActions(sb, "MENU", 
/*  59 */           getActions(((IModeController)this._modeProvider.get()).getStationModel().getMenuModel().getCurrentMenu()));
/*  60 */       appendListFields(sb);
/*  61 */       _logger.info(sb);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void logFormActions(String argFormKey) {
/*  66 */     if (shouldLog()) {
/*  67 */       StringBuilder sb = new StringBuilder("\n******FORM ACTIONS******");
/*  68 */       appendFormActions(sb, argFormKey);
/*  69 */       _logger.info(sb);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendActions(StringBuilder sb, String argTitle, Collection<IXstAction> argActions) {
/*  74 */     if (argActions != null) {
/*  75 */       sb.append("\n");
/*  76 */       sb.append(argTitle);
/*  77 */       sb.append(":");
/*  78 */       for (IXstAction action : argActions) {
/*  79 */         sb.append("\n\t");
/*  80 */         sb.append(action.getActionKey());
/*  81 */         sb.append(" (");
/*  82 */         sb.append(action.getActionName().toString(OutputContextType.VIEW));
/*  83 */         sb.append(")");
/*  84 */         if (!action.isEnabled()) {
/*  85 */           sb.append("        ***DISABLED***");
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendFieldKeys(StringBuilder sb, String argTitle, IEditModel argEditModel) {
/*  92 */     Collection<String> fieldKeys = argEditModel.getFieldKeys();
/*  93 */     if (fieldKeys != null && !fieldKeys.isEmpty()) {
/*  94 */       sb.append("\n");
/*  95 */       sb.append(argTitle);
/*  96 */       sb.append(":");
/*  97 */       for (String key : fieldKeys) {
/*  98 */         sb.append("\n\t");
/*  99 */         sb.append(key);
/* 100 */         sb.append(" (");
/* 101 */         sb.append(argEditModel.getDataType(key));
/* 102 */         sb.append(")");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendFormActions(StringBuilder sb, String argFormKey) {
/* 108 */     if (argFormKey != null) {
/* 109 */       FormKey formKey = FormKey.valueOf(argFormKey);
/* 110 */       appendActions(sb, "FORM (" + argFormKey + ")", ((IModeController)this._modeProvider
/* 111 */           .get()).getStationModel().getFormActions(formKey));
/* 112 */       IEditModel editModel = ((IModeController)this._modeProvider.get()).getStationModel().getEditModel(formKey);
/* 113 */       if (editModel != null) {
/* 114 */         appendFieldKeys(sb, "FORM FIELD KEYS", editModel);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendListFields(StringBuilder sb) {
/* 120 */     ICombinedListModel<?> listModel = ((IModeController)this._modeProvider.get()).getStationModel().getListModel(null);
/*     */     
/* 122 */     if (listModel != null) {
/* 123 */       List<?> elements = listModel.getModel().getElements();
/*     */       
/* 125 */       if (!elements.isEmpty()) {
/* 126 */         sb.append("\n\n******LIST FIELDS******");
/*     */         
/* 128 */         Object sampleObj = elements.get(0);
/* 129 */         Class<?> type = sampleObj.getClass();
/* 130 */         sb.append("\nOBJECT TYPE: " + type);
/*     */         
/* 132 */         sb.append("\nAVAILABLE METHODS:");
/* 133 */         for (String methodName : getQualifyingMethods(type)) {
/* 134 */           sb.append("\n\t" + methodName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Collection<IXstAction> getActions(IMenuItem argMenuItem) {
/* 141 */     Collection<IXstAction> events = null;
/*     */     
/* 143 */     if (argMenuItem != null) {
/* 144 */       events = new LinkedList<>();
/* 145 */       List<IMenuItem> children = argMenuItem.getChildren();
/*     */ 
/*     */       
/* 148 */       if (children != null && !children.isEmpty()) {
/* 149 */         for (IMenuItem child : children)
/*     */         {
/* 151 */           events.addAll(getActions(child));
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 156 */         events.add(argMenuItem.getAction());
/*     */       } 
/*     */     } 
/*     */     
/* 160 */     return events;
/*     */   }
/*     */   
/*     */   private List<String> getQualifyingMethods(Class<?> argClass) {
/* 164 */     List<String> methods = new ArrayList<>();
/*     */     
/* 166 */     for (Method m : argClass.getMethods()) {
/* 167 */       String methodName = m.getName();
/*     */       
/* 169 */       if (methodName.startsWith("get") && !"getClass".equalsIgnoreCase(methodName) && (m
/* 170 */         .getParameterTypes()).length == 0) {
/* 171 */         methods.add(methodName);
/*     */       }
/*     */     } 
/*     */     
/* 175 */     Collections.sort(methods);
/* 176 */     return methods;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean shouldLog() {
/* 181 */     return (_logger.isInfoEnabled() && !this._testHarness.isProcessing());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\ActionLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */