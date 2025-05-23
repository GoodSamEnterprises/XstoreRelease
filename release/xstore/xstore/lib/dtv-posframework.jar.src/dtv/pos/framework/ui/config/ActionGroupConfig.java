/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
/*     */ import dtv.pos.iframework.ui.config.IActionGroupConfig;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ActionGroupConfig
/*     */   extends AbstractParentConfig
/*     */   implements IActionGroupConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "ActionGroup";
/*  29 */   private DataActionGroupKey groupKey_ = null;
/*  30 */   private String groupSubKey_ = null;
/*     */   
/*  32 */   private final List<IActionConfig> actionList_ = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public ActionGroupConfig() {}
/*     */ 
/*     */   
/*     */   public ActionGroupConfig(DataActionGroupKey key) {
/*  39 */     this(key, (String)null);
/*     */   }
/*     */   
/*     */   public ActionGroupConfig(DataActionGroupKey key, String subKey) {
/*  43 */     setGroupKey(key);
/*  44 */     setGroupSubKey(subKey);
/*  45 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addActionConfig(IActionConfig argValue) {
/*  50 */     this.actionList_.add(argValue);
/*  51 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public IActionConfig[] getActionConfigs() {
/*  56 */     return this.actionList_.<IActionConfig>toArray((IActionConfig[])new ActionConfig[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getActions() {
/*  61 */     Collection<IXstAction> actions = new ArrayList<>(this.actionList_.size());
/*     */     
/*  63 */     for (IActionConfig ac : this.actionList_) {
/*  64 */       IXstAction action = ac.getAction(this.groupKey_);
/*  65 */       if (action != null && action.isValid()) {
/*  66 */         actions.add(ac.getAction(this.groupKey_));
/*     */       }
/*     */     } 
/*  69 */     return actions;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataActionGroupKey getGroupKey() {
/*  74 */     return this.groupKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupSubKey() {
/*  79 */     return this.groupSubKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/*  84 */     if (super.isDirty()) {
/*  85 */       return true;
/*     */     }
/*  87 */     for (int i = 0; i < this.actionList_.size(); i++) {
/*  88 */       if (((IActionConfig)this.actionList_.get(i)).isDirty()) {
/*  89 */         return true;
/*     */       }
/*     */     } 
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEquivalent(Object o) {
/*  97 */     if (!(o instanceof ActionGroupConfig)) {
/*  98 */       return false;
/*     */     }
/* 100 */     return ((ActionGroupConfig)o).groupKey_.equals(this.groupKey_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeActionConfig(IActionConfig argConfig) {
/* 105 */     this.actionList_.remove(argConfig);
/* 106 */     setDirty();
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
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 118 */     if ("key".equalsIgnoreCase(argKey)) {
/* 119 */       setGroupKey(DataActionGroupKey.createForName(argValue.toString()));
/*     */     }
/* 121 */     else if ("subkey".equalsIgnoreCase(argKey)) {
/* 122 */       setGroupSubKey(argValue.toString());
/*     */     }
/* 124 */     else if (argValue instanceof IActionConfig && "Action".equalsIgnoreCase(argKey)) {
/* 125 */       addActionConfig((IActionConfig)argValue);
/*     */     } else {
/*     */       
/* 128 */       warnUnsupported(argKey, argValue);
/*     */     } 
/* 130 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGroupKey(DataActionGroupKey argGroupKey) {
/* 135 */     this.groupKey_ = argGroupKey;
/* 136 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setGroupSubKey(String argGroupSubKey) {
/* 140 */     this.groupSubKey_ = argGroupSubKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 147 */     if (this.groupSubKey_ == null) {
/* 148 */       argWriter.writeComment("**********************************");
/* 149 */       argWriter.writeComment("** " + this.groupKey_ + " action keys **");
/* 150 */       argWriter.writeComment("**********************************");
/*     */     } else {
/*     */       
/* 153 */       argWriter.writeComment(this.groupSubKey_);
/*     */     } 
/*     */     
/* 156 */     StringBuilder attr = new StringBuilder();
/* 157 */     if (this.groupKey_ != null) {
/* 158 */       attr.append(" key=\"").append(this.groupKey_.toString()).append("\"");
/*     */     }
/* 160 */     if (!StringUtils.isEmpty(this.groupSubKey_)) {
/* 161 */       attr.append(" subKey=\"").append(this.groupSubKey_).append("\"");
/*     */     }
/* 163 */     argWriter.writeHeader("ActionGroup", "ActionGroup", attr.toString().trim());
/* 164 */     argWriter.writeValue((ISavableConfig[])this.actionList_.toArray((Object[])new ActionConfig[0]));
/* 165 */     argWriter.writeFooter("ActionGroup");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ActionGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */