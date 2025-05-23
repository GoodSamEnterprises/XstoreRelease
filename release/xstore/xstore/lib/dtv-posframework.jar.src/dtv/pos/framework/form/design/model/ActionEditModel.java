/*     */ package dtv.pos.framework.form.design.model;
/*     */ 
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.action.type.ActionType;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.ui.config.ActionConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstKeyStroke;
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
/*     */ public class ActionEditModel
/*     */   extends AbstractDetailEditModel
/*     */ {
/*  29 */   private static final Logger logger = Logger.getLogger(ActionEditModel.class);
/*     */   
/*     */   private static final int TYPE = 0;
/*     */   private static final int KEY = 1;
/*     */   private static final int KEYSTROKE = 2;
/*     */   private static final int TEXT = 3;
/*     */   private static final int ROW_COUNT = 4;
/*     */   private final ActionConfig actionConfig;
/*     */   private final ActionType type;
/*     */   private final Class keyClass;
/*     */   
/*     */   public ActionEditModel(ActionConfig argActionConfig) {
/*  41 */     super(4, new String[] { "type", "key", "keystroke", "text key" }, new Class[] { String.class, Integer.class, XstKeyStroke.class, String.class });
/*     */ 
/*     */ 
/*     */     
/*  45 */     this.actionConfig = argActionConfig;
/*     */     
/*  47 */     IXstActionKey actionKey = this.actionConfig.getKey();
/*     */     
/*  49 */     ActionType t = ActionType.forActionKey(actionKey);
/*  50 */     if (t == null) {
/*  51 */       logger.warn("type is null from " + actionKey);
/*  52 */       FormTabKey formTabKey = FormTabKey.DEFAULT;
/*  53 */       this.actionConfig.setKey((IXstActionKey)formTabKey);
/*  54 */       this.type = ActionType.forActionKey((IXstActionKey)formTabKey);
/*     */     } else {
/*     */       
/*  57 */       this.type = t;
/*     */     } 
/*  59 */     this.keyClass = this.type.getActionClass();
/*  60 */     if (this.keyClass == null) {
/*  61 */       logger.warn("null key class for " + this.type);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Class getCellClass(int rowIndex, int columnIndex) {
/*  67 */     if (columnIndex == 1 && rowIndex == 1) {
/*  68 */       return this.keyClass;
/*     */     }
/*  70 */     return super.getCellClass(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/*  75 */     if (columnIndex == 0) {
/*  76 */       return super.getValueAt(rowIndex, columnIndex);
/*     */     }
/*  78 */     switch (rowIndex) {
/*     */       case 0:
/*  80 */         return this.type;
/*     */       case 1:
/*  82 */         return this.actionConfig.getKey();
/*     */       case 2:
/*  84 */         return this.actionConfig.getKeyStroke();
/*     */       case 3:
/*  86 */         if (this.actionConfig.getTextKey() == null) {
/*  87 */           return null;
/*     */         }
/*     */         
/*  90 */         return this.actionConfig.getTextKey().getUnformattedData();
/*     */     } 
/*     */     
/*  93 */     logger.warn("unexpected row " + rowIndex);
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 100 */     if (rowIndex == 0) {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     return super.isCellEditable(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/* 110 */     if (columnIndex == 1) {
/* 111 */       String value; IFormattableConfig cfg; switch (rowIndex) {
/*     */         case 1:
/* 113 */           this.actionConfig.setKey("" + aValue);
/*     */           return;
/*     */         case 2:
/* 116 */           if (aValue instanceof XstKeyStroke) {
/* 117 */             this.actionConfig.setKeyStroke((IXstKeyStroke)aValue);
/*     */           } else {
/*     */             
/* 120 */             this.actionConfig.setKeyStroke((IXstKeyStroke)XstKeyStroke.forName("" + aValue));
/*     */           } 
/*     */           return;
/*     */         case 3:
/* 124 */           value = "" + aValue;
/*     */           
/* 126 */           cfg = (TranslationHelper.getInstance().isTranslationKey(value) || TranslationHelper.getInstance().isDatabaseTranslationKey(value)) ? (IFormattableConfig)new TranslatableConfig(value) : (IFormattableConfig)new LiteralConfig(value);
/*     */ 
/*     */ 
/*     */           
/* 130 */           this.actionConfig.setTextKey(cfg);
/*     */           return;
/*     */       } 
/* 133 */       logger.warn("unexpected row " + rowIndex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\ActionEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */