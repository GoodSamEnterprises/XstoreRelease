/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ public class ListViewConfigHelper
/*     */   extends ConfigHelper
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(ListViewConfigHelper.class);
/*     */   
/*  28 */   private final ConcurrentHashMap<String, ListViewRuleConfig[]> ruleCache_ = (ConcurrentHashMap)new ConcurrentHashMap<>(10, 0.75F, 1);
/*     */ 
/*     */   
/*     */   public ListViewElementConfig getElementConfig(IViewElementType type) {
/*  32 */     return (ListViewElementConfig)getRoot().getElementMap().get(type);
/*     */   }
/*     */   
/*     */   public ListViewHeaderConfig getHeaderConfig(IViewElementType type) {
/*  36 */     return (ListViewHeaderConfig)getRoot().getHeaderMap().get(type);
/*     */   }
/*     */   
/*     */   public ListViewConfig getRoot() {
/*  40 */     return (ListViewConfig)getRootConfig();
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
/*     */   public ListViewRuleConfig[] getRules(String argRuleSetName) {
/*  52 */     String ruleSetName = StringUtils.isEmpty(argRuleSetName) ? "DEFAULT" : argRuleSetName;
/*     */     
/*  54 */     ListViewRuleConfig[] rules = this.ruleCache_.get(ruleSetName);
/*     */ 
/*     */     
/*  57 */     if (rules != null) {
/*  58 */       return rules;
/*     */     }
/*     */ 
/*     */     
/*  62 */     Map<String, ListViewRuleConfig> ruleMap = getRoot().getRuleMap();
/*  63 */     List<ListViewRuleConfig> ruleList = new ArrayList<>();
/*     */ 
/*     */     
/*  66 */     ListViewRuleSetConfig ruleSet = getListViewRuleSet(ruleSetName);
/*  67 */     if (ruleSet != null) {
/*  68 */       ruleList.addAll(getRules(ruleSet, ruleMap));
/*     */     }
/*     */ 
/*     */     
/*  72 */     if (!isDefaultRuleSet(ruleSetName)) {
/*  73 */       ruleList.addAll(getRules(getDefaultListViewRuleSet(), ruleMap));
/*     */     }
/*     */ 
/*     */     
/*  77 */     ListViewRuleConfig[] ruleArray = ruleList.<ListViewRuleConfig>toArray(new ListViewRuleConfig[ruleList.size()]);
/*  78 */     ListViewRuleConfig[] previuslyCachedListViewRuleConfigs = this.ruleCache_.putIfAbsent(ruleSetName, ruleArray);
/*     */ 
/*     */     
/*  81 */     return (previuslyCachedListViewRuleConfigs != null) ? previuslyCachedListViewRuleConfigs : ruleArray;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/*  86 */     return "ListViewConfig";
/*     */   }
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/*  91 */     if ("ListView".equalsIgnoreCase(dtype)) {
/*  92 */       return (IConfigObject)new ListViewConfig();
/*     */     }
/*  94 */     if ("ListViewElement".equalsIgnoreCase(dtype) || "Element".equalsIgnoreCase(dtype)) {
/*  95 */       return (IConfigObject)new ListViewElementConfig();
/*     */     }
/*  97 */     if ("ListViewHeader".equalsIgnoreCase(dtype) || "Header".equalsIgnoreCase(dtype)) {
/*  98 */       return (IConfigObject)new ListViewHeaderConfig();
/*     */     }
/* 100 */     if ("ListViewRule".equalsIgnoreCase(dtype) || "Rule".equalsIgnoreCase(dtype)) {
/* 101 */       return (IConfigObject)new ListViewRuleConfig();
/*     */     }
/* 103 */     if ("RuleSet".equalsIgnoreCase(dtype)) {
/* 104 */       return (IConfigObject)new ListViewRuleSetConfig();
/*     */     }
/* 106 */     if ("ListViewRow".equalsIgnoreCase(dtype) || "Row".equalsIgnoreCase(dtype)) {
/* 107 */       return (IConfigObject)new ListViewRowConfig();
/*     */     }
/* 109 */     if ("ListViewColumn".equalsIgnoreCase(dtype) || "Column".equalsIgnoreCase(dtype)) {
/* 110 */       return (IConfigObject)new ListViewColumnConfig();
/*     */     }
/*     */     
/* 113 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ListViewRuleSetConfig getDefaultListViewRuleSet() {
/* 119 */     return getListViewRuleSet("DEFAULT");
/*     */   }
/*     */ 
/*     */   
/*     */   private ListViewRuleSetConfig getListViewRuleSet(String argRuleSetName) {
/* 124 */     return (ListViewRuleSetConfig)getRoot().getRuleSetMap().get(argRuleSetName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ListViewRuleConfig> getRules(ListViewRuleSetConfig argRuleSet, Map<String, ListViewRuleConfig> argRuleMap) {
/* 131 */     List<String> ruleKeys = argRuleSet.getRuleKeys();
/* 132 */     List<ListViewRuleConfig> rules = new ArrayList<>();
/*     */     
/* 134 */     if (ruleKeys != null)
/*     */     {
/*     */       
/* 137 */       for (String ruleKey : ruleKeys) {
/* 138 */         ListViewRuleConfig rule = argRuleMap.get(ruleKey);
/*     */         
/* 140 */         if (rule != null) {
/* 141 */           rules.add(rule);
/*     */           continue;
/*     */         } 
/* 144 */         logger_.warn(ruleKey + " in set " + argRuleSet.getName() + " is undefined! @@ " + argRuleSet
/* 145 */             .getSourceDescription());
/*     */       } 
/*     */     }
/*     */     
/* 149 */     return rules;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isDefaultRuleSet(String argRuleSetName) {
/* 154 */     return "DEFAULT".equalsIgnoreCase(argRuleSetName);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */