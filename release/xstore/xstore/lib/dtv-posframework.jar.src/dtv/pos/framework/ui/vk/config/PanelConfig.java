/*     */ package dtv.pos.framework.ui.vk.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.IKeyboardButtonPanel;
/*     */ import dtv.pos.framework.ui.vk.IKeyboardDesign;
/*     */ import dtv.pos.framework.ui.vk.KeyboardButtonPanel;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
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
/*     */ public class PanelConfig<T extends KeyboardButtonPanel & IKeyboardButtonPanel>
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String ATT_PANEL_NAME = "name";
/*     */   private static final String ATT_ALIGNMENT = "alignment";
/*     */   private static final String ATT_MODIFIABLE = "modifiable";
/*     */   private static final String TAG_ROW = "row";
/*     */   private int id_;
/*     */   private String name_;
/*  33 */   private Alignment alignment_ = Alignment.LEFT;
/*  34 */   private List<RowConfig> rows_ = new ArrayList<>();
/*     */   private boolean modifiable_;
/*  36 */   private double maxRowLength_ = 0.0D;
/*  37 */   private double rowCount_ = 0.0D;
/*  38 */   private int rowNumber_ = 0;
/*     */ 
/*     */   
/*     */   private LayoutConfig parent_;
/*     */ 
/*     */   
/*     */   private KeyboardButtonPanel swingPanel_;
/*     */ 
/*     */ 
/*     */   
/*     */   public Alignment getAlignment() {
/*  49 */     return this.alignment_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId() {
/*  57 */     return this.id_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaxRowWidth() {
/*  65 */     return this.maxRowLength_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPanelName() {
/*  73 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LayoutConfig getParentLayout() {
/*  81 */     return this.parent_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<RowConfig> getRowConfigurations() {
/*  89 */     return this.rows_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRowCount() {
/*  97 */     return this.rowCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getSwingPanel(IKeyboardDesign argDesign) {
/* 106 */     if (this.swingPanel_ == null) {
/* 107 */       this.swingPanel_ = new BasicKeyboardButtonPanel(this, argDesign);
/* 108 */       this.swingPanel_.setBounds(argDesign.getPanelBounds().get(getId()));
/* 109 */       this.swingPanel_.loadButtons();
/*     */     } 
/*     */     
/* 112 */     return (T)this.swingPanel_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFirst() {
/* 120 */     if (getParentLayout().getPanelConfigurations().indexOf(this) == 0) {
/* 121 */       return true;
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLast() {
/* 131 */     if (getParentLayout().getPanelConfigurations().indexOf(this) == getParentLayout()
/* 132 */       .getPanelConfigurations().size() - 1) {
/* 133 */       return true;
/*     */     }
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isModifiable() {
/* 143 */     return this.modifiable_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 149 */     if (argKey.equalsIgnoreCase("name")) {
/* 150 */       this.name_ = OnScreenKeyboard.getTranslation(argValue.toString());
/*     */     }
/* 152 */     if (argKey.equalsIgnoreCase("alignment")) {
/* 153 */       this.alignment_ = Alignment.forName(argValue.toString());
/*     */     }
/* 155 */     if (argKey.equalsIgnoreCase("modifiable")) {
/* 156 */       this.modifiable_ = ConfigUtils.toBoolean(argValue.toString()).booleanValue();
/*     */     }
/* 158 */     if (argKey.equalsIgnoreCase("row") && argValue instanceof RowConfig) {
/* 159 */       RowConfig value = (RowConfig)argValue;
/* 160 */       value.setParentPanel(this);
/* 161 */       value.setRowOrder(this.rowNumber_);
/* 162 */       this.rows_.add(value);
/* 163 */       this.maxRowLength_ = (value.getRowWidth() > this.maxRowLength_) ? value.getRowWidth() : this.maxRowLength_;
/* 164 */       double tempRowCount = this.rowNumber_ + value.getRowHeight();
/* 165 */       this.rowCount_ = (tempRowCount > this.rowCount_) ? tempRowCount : this.rowCount_;
/* 166 */       this.rowNumber_++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(int argId) {
/* 175 */     this.id_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentLayout(LayoutConfig argParent) {
/* 183 */     this.parent_ = argParent;
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
/*     */   
/*     */   public enum Alignment
/*     */   {
/* 199 */     CENTERED,
/*     */ 
/*     */ 
/*     */     
/* 203 */     LEFT,
/*     */ 
/*     */ 
/*     */     
/* 207 */     RIGHT,
/*     */ 
/*     */ 
/*     */     
/* 211 */     DEFAULT;
/*     */     
/*     */     static Alignment forName(String argAlignment) {
/* 214 */       if (argAlignment.equalsIgnoreCase("center") || argAlignment.equalsIgnoreCase("centered") || argAlignment
/* 215 */         .equalsIgnoreCase("c")) {
/* 216 */         return CENTERED;
/*     */       }
/* 218 */       if (argAlignment.equalsIgnoreCase("left") || argAlignment.equalsIgnoreCase("l")) {
/* 219 */         return LEFT;
/*     */       }
/* 221 */       if (argAlignment.equalsIgnoreCase("right") || argAlignment.equalsIgnoreCase("r")) {
/* 222 */         return RIGHT;
/*     */       }
/*     */       
/* 225 */       return DEFAULT;
/*     */     }
/*     */   }
/*     */   
/*     */   class BasicKeyboardButtonPanel
/*     */     extends KeyboardButtonPanel
/*     */     implements IKeyboardButtonPanel
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public BasicKeyboardButtonPanel(PanelConfig<KeyboardButtonPanel> panelConfig, IKeyboardDesign argDesign) {
/* 236 */       super(panelConfig, argDesign);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\config\PanelConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */