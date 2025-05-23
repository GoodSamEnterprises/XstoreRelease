/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.iframework.ui.config.IDataSelectionConfig;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.model.IListPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptModel;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.model.IListSelectionModel;
/*     */ import java.util.Arrays;
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
/*     */ public class DefaultListPromptModel
/*     */   extends DefaultListInputModel
/*     */   implements IListPromptModel<Object>
/*     */ {
/*     */   private IPromptConfig config_;
/*     */   private IFormattable[] promptArgs_;
/*     */   
/*     */   public IFormattable[] getPromptArgs() {
/*  52 */     return this.promptArgs_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPromptConfig getPromptConfig() {
/*  63 */     return this.config_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPromptArgs(IFormattable[] promptArgs) {
/*  68 */     this.promptArgs_ = promptArgs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(IPromptConfig config) {
/*  73 */     setPromptConfig(config);
/*     */   }
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
/*     */   public void setValues(final IPromptConfig config, final Object[] listItems, final int[] selectedIndices) {
/*  87 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  91 */             DefaultListPromptModel.this.setPromptConfig(config);
/*  92 */             DefaultListPromptModel.this.getModel().setElements(Arrays.asList(listItems));
/*     */             
/*  94 */             int mode = 0;
/*  95 */             if (config != null) {
/*  96 */               IDataSelectionConfig selectionConfig = config.getDataSelectionConfig();
/*     */               
/*  98 */               if (selectionConfig != null && selectionConfig.isMultipleSelect()) {
/*  99 */                 mode = 2;
/*     */               }
/*     */             } 
/* 102 */             int selectionMode = mode;
/* 103 */             IListSelectionModel lsm = DefaultListPromptModel.this.getSelectionModel();
/*     */             
/* 105 */             lsm.setSelectionMode(selectionMode);
/* 106 */             lsm.clearSelection();
/*     */             
/* 108 */             if (selectedIndices == null || selectedIndices.length == 0 || selectedIndices[0] < 0) {
/* 109 */               lsm.addSelectionInterval(0, 0);
/* 110 */               if (selectionMode != 0) {
/* 111 */                 lsm.removeIndexInterval(0, 0);
/*     */               }
/*     */             } else {
/*     */               
/* 115 */               lsm.setSelections(selectedIndices);
/*     */             } 
/* 117 */             DefaultListPromptModel.this.events_.post(IPromptModel.SET_VALUES, listItems);
/*     */           }
/*     */         }true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearModelImpl() {
/* 125 */     if (getPromptConfig() != null) {
/* 126 */       getPromptConfig().clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setPromptConfig(IPromptConfig config) {
/* 137 */     this.config_ = (config == null) ? (IPromptConfig)new PromptConfig() : config;
/*     */ 
/*     */     
/* 140 */     this.events_.post(IListPromptModel.VIEW_TYPE_CHANGED_CONSTRAINT);
/* 141 */     this.events_.post(SET_VALUES);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultListPromptModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */