/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.ui.config.IDataSelectionConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataSelectionConfig
/*     */   extends AbstractUIConfig
/*     */   implements IDataSelectionConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "DataSelection";
/*     */   private static final String MULTIPLE_SELECT_TAG = "MultipleSelect";
/*     */   private static final String SELECTION_TYPE_TAG = "SelectionMode";
/*  31 */   private static final Logger logger_ = Logger.getLogger(DataSelectionConfig.class);
/*     */   
/*     */   private IDataSelectionConfig.SelectionMode selectionMode_;
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  37 */     if (sourceConfig == null) {
/*     */       return;
/*     */     }
/*  40 */     if (!(sourceConfig instanceof DataSelectionConfig)) {
/*  41 */       logger_
/*  42 */         .error("Attempted to cascade from invalid configuration object [" + sourceConfig + "]::" + 
/*  43 */           getSourceDescription(sourceConfig) + "-->" + getSourceDescription(), new Throwable("STACK TRACE"));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  48 */     super.cascadeValues(sourceConfig);
/*  49 */     DataSelectionConfig config = (DataSelectionConfig)sourceConfig;
/*     */     
/*  51 */     if (this.selectionMode_ == null) {
/*  52 */       setSelectionMode(config.getSelectionMode());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataSelectionConfig.SelectionMode getSelectionMode() {
/*  60 */     return (this.selectionMode_ == null) ? IDataSelectionConfig.SelectionMode.SINGLE : this.selectionMode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean isMultipleSelect() {
/*  72 */     return (getSelectionMode() == IDataSelectionConfig.SelectionMode.MULTIPLE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  77 */     if (argKey.equalsIgnoreCase("MultipleSelect")) {
/*  78 */       setMultipleSelect(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/*  80 */     else if (argKey.equalsIgnoreCase("SelectionMode")) {
/*     */       try {
/*  82 */         setSelectionMode(IDataSelectionConfig.SelectionMode.valueOf(argValue.toString()));
/*     */       }
/*  84 */       catch (Exception ex) {
/*  85 */         logger_.error("invalid SelectionMode '" + argValue.toString() + "'");
/*     */       } 
/*     */     } else {
/*     */       
/*  89 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setMultipleSelect(Boolean multipleSelect) {
/*  96 */     if (multipleSelect == null) {
/*  97 */       this.selectionMode_ = null;
/*     */     } else {
/*     */       
/* 100 */       this.selectionMode_ = multipleSelect.booleanValue() ? IDataSelectionConfig.SelectionMode.MULTIPLE : IDataSelectionConfig.SelectionMode.SINGLE;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectionMode(IDataSelectionConfig.SelectionMode argSelectionMode) {
/* 107 */     this.selectionMode_ = argSelectionMode;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\DataSelectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */