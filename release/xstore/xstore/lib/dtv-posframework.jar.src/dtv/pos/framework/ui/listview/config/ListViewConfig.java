/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class ListViewConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "ListView";
/*  25 */   private List<ListViewHeaderConfig> headerList_ = new ArrayList<>();
/*  26 */   private List<ListViewElementConfig> elementList_ = new ArrayList<>();
/*  27 */   private List<ListViewRuleConfig> ruleList_ = new ArrayList<>();
/*  28 */   private List<ListViewRuleSetConfig> ruleSetList_ = new ArrayList<>();
/*     */   
/*     */   private Map<IViewElementType, ListViewHeaderConfig> headerMap_;
/*     */   
/*     */   private Map<IViewElementType, ListViewElementConfig> elementMap_;
/*     */   private Map<String, ListViewRuleSetConfig> ruleSetMap_;
/*     */   private Map<String, ListViewRuleConfig> ruleMap_;
/*     */   
/*     */   public synchronized Map getElementMap() {
/*  37 */     if (this.elementMap_ == null) {
/*  38 */       Map<IViewElementType, ListViewElementConfig> newHeaderMap = new HashMap<>();
/*     */       
/*  40 */       for (ListViewElementConfig element : this.elementList_) {
/*  41 */         newHeaderMap.put(element.getType(), element);
/*     */       }
/*  43 */       this.elementMap_ = newHeaderMap;
/*  44 */       this.elementList_ = null;
/*     */     } 
/*  46 */     return this.elementMap_;
/*     */   }
/*     */   
/*     */   public synchronized Map getHeaderMap() {
/*  50 */     if (this.headerMap_ == null) {
/*  51 */       Map<IViewElementType, ListViewHeaderConfig> newHeaderMap = new HashMap<>();
/*     */       
/*  53 */       for (ListViewHeaderConfig header : this.headerList_) {
/*  54 */         newHeaderMap.put(header.getType(), header);
/*     */       }
/*  56 */       this.headerMap_ = newHeaderMap;
/*  57 */       this.headerList_ = null;
/*     */     } 
/*  59 */     return this.headerMap_;
/*     */   }
/*     */   
/*     */   public synchronized Map<String, ListViewRuleConfig> getRuleMap() {
/*  63 */     if (this.ruleMap_ == null) {
/*  64 */       Map<String, ListViewRuleConfig> newRuleMap = new HashMap<>();
/*     */       
/*  66 */       for (ListViewRuleConfig rule : this.ruleList_) {
/*  67 */         newRuleMap.put(rule.getRuleKey(), rule);
/*     */       }
/*  69 */       this.ruleMap_ = newRuleMap;
/*  70 */       this.ruleList_ = null;
/*     */     } 
/*  72 */     return this.ruleMap_;
/*     */   }
/*     */   
/*     */   public synchronized Map getRuleSetMap() {
/*  76 */     if (this.ruleSetMap_ == null) {
/*  77 */       Map<String, ListViewRuleSetConfig> newRuleSetMap = new HashMap<>();
/*     */       
/*  79 */       for (ListViewRuleSetConfig ruleSet : this.ruleSetList_) {
/*  80 */         newRuleSetMap.put(ruleSet.getName(), ruleSet);
/*     */       }
/*  82 */       this.ruleSetMap_ = newRuleSetMap;
/*  83 */       this.ruleSetList_ = null;
/*     */     } 
/*  85 */     return this.ruleSetMap_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  90 */     if (argKey.equalsIgnoreCase("Header") && argValue instanceof ListViewHeaderConfig) {
/*  91 */       this.headerList_.add((ListViewHeaderConfig)argValue);
/*     */     }
/*  93 */     else if (argKey.equalsIgnoreCase("Element") && argValue instanceof ListViewElementConfig) {
/*     */       
/*  95 */       this.elementList_.add((ListViewElementConfig)argValue);
/*     */     }
/*  97 */     else if (argKey.equalsIgnoreCase("Rule") && argValue instanceof ListViewRuleConfig) {
/*  98 */       this.ruleList_.add((ListViewRuleConfig)argValue);
/*     */     }
/* 100 */     else if ("RuleSet".equalsIgnoreCase(argKey) && argValue instanceof ListViewRuleSetConfig) {
/*     */ 
/*     */       
/* 103 */       this.ruleSetList_.add((ListViewRuleSetConfig)argValue);
/*     */     } else {
/*     */       
/* 106 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */