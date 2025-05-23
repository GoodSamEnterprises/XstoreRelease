/*     */ package dtv.pos.framework.ui.vk.config;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class RowConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String TAG_BUTTON = "button";
/*     */   private static final String ATT_ALIGNMENT = "alignment";
/*     */   private static final String ATT_MODIFIABLE = "modifiable";
/*     */   private PanelConfig<?> parent_;
/*  29 */   private List<ButtonConfig> buttons_ = new ArrayList<>();
/*     */   private PanelConfig.Alignment alignment_;
/*  31 */   private double rowLength_ = 0.0D;
/*  32 */   private double rowHeight_ = 0.0D;
/*     */ 
/*     */   
/*     */   private int rowOrder_;
/*     */   
/*     */   private Boolean modifiable_;
/*     */ 
/*     */   
/*     */   public PanelConfig.Alignment getAlignment() {
/*  41 */     if (this.alignment_ == null) {
/*  42 */       return this.parent_.getAlignment();
/*     */     }
/*     */     
/*  45 */     return this.alignment_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ButtonConfig> getButtonConfigurations() {
/*  53 */     return this.buttons_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PanelConfig<?> getParentPanel() {
/*  61 */     return this.parent_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRowHeight() {
/*  69 */     return this.rowHeight_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowOrder() {
/*  77 */     return this.rowOrder_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRowWidth() {
/*  85 */     return this.rowLength_;
/*     */   }
/*     */   
/*     */   public boolean isModifiable() {
/*  89 */     if (this.modifiable_ == null) {
/*  90 */       return getParentPanel().isModifiable();
/*     */     }
/*     */     
/*  93 */     return this.modifiable_.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  99 */     if (argKey.equalsIgnoreCase("button") && argValue instanceof ButtonConfig) {
/* 100 */       ButtonConfig value = (ButtonConfig)argValue;
/* 101 */       value.setParentRow(this);
/* 102 */       this.buttons_.add(value);
/* 103 */       this.rowLength_ += value.getWidth();
/* 104 */       this.rowHeight_ = (value.getHeight() > this.rowHeight_) ? value.getHeight() : this.rowHeight_;
/*     */     } 
/* 106 */     if (argKey.equalsIgnoreCase("modifiable")) {
/* 107 */       this.modifiable_ = ConfigUtils.toBoolean(argValue.toString());
/*     */     }
/* 109 */     if (argKey.equalsIgnoreCase("alignment")) {
/* 110 */       this.alignment_ = PanelConfig.Alignment.forName(argValue.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentPanel(PanelConfig<?> parent) {
/* 119 */     this.parent_ = parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowOrder(int order) {
/* 127 */     this.rowOrder_ = order;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\config\RowConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */