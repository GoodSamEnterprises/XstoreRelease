/*     */ package dtv.data2.purge.config;
/*     */ 
/*     */ import dtv.data2.purge.PurgeMetaData;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractParentConfig<C extends IPurgeConfig>
/*     */   extends AbstractConfig
/*     */   implements IPurgeParentConfig<C>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Class<? extends C> _childClass;
/*     */   private final Map<String, C> _childMap;
/*     */   
/*     */   public AbstractParentConfig(Class<? extends C> argChildClass) {
/*  35 */     this._childClass = argChildClass;
/*  36 */     this._childMap = new HashMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public C getChild(String argChildName) {
/*  42 */     return this._childMap.get(normalize(argChildName));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<? extends C> getPrioritizedChildren() {
/*  48 */     List<? extends C> sortedChildren = new ArrayList<>(this._childMap.values());
/*  49 */     Collections.sort(sortedChildren);
/*     */     
/*  51 */     return sortedChildren;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  57 */     if (this._childClass.isAssignableFrom(argValue.getClass())) {
/*  58 */       IPurgeConfig iPurgeConfig = (IPurgeConfig)this._childClass.cast(argValue);
/*  59 */       this._childMap.put(normalize(iPurgeConfig.getName()), (C)iPurgeConfig);
/*     */     } else {
/*     */       
/*  62 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PurgeMetaData callImpl() throws Exception {
/*  71 */     PurgeMetaData purgeData = new PurgeMetaData();
/*     */ 
/*     */ 
/*     */     
/*  75 */     for (IPurgeConfig iPurgeConfig : getPrioritizedChildren()) {
/*     */       
/*  77 */       cascadeParameters((C)iPurgeConfig);
/*  78 */       purgeData.add(iPurgeConfig.call());
/*     */     } 
/*  80 */     return purgeData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cascadeParameters(C argChild) {
/*  91 */     for (Map.Entry<? extends String, ? extends IConfigObject> param : getParameters().entrySet()) {
/*  92 */       ParameterConfig paramConfig = new ParameterConfig(param.getKey(), param.getValue());
/*     */       
/*  94 */       if (checkCascade(paramConfig, argChild)) {
/*  95 */         argChild.setParameter(paramConfig);
/*     */       }
/*     */     } 
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
/*     */   protected boolean checkCascade(ParameterConfig argParam, C argChild) {
/* 110 */     return (argChild.getParameterValue(argParam.getName()) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDisabledLogMessage(PurgeMetaData argPurgeData) {
/* 116 */     return "--- [" + getDescription() + "] DISABLED ---";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getStartLogMessage() {
/* 122 */     return "--- [" + getDescription() + "] STARTED ---";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSuccessLogMessage(PurgeMetaData argPurgeData) {
/* 128 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 130 */     sb.append("--- [" + getDescription() + "] TOTALS: ---\n");
/* 131 */     sb.append("\trecords = [" + argPurgeData.getRecordsPurged() + "]\n");
/* 132 */     sb.append("\ttables = [" + argPurgeData.getTablesPurged() + " / " + argPurgeData.getTablesTargeted() + "]\n");
/*     */     
/* 134 */     sb.append("\ttime = [" + argPurgeData.getPurgeTime() + "]\n");
/*     */     
/* 136 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\AbstractParentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */