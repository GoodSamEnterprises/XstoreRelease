/*     */ package dtv.pos.framework.form;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.pos.iframework.form.IObjectFilter;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*     */ import dtv.pos.iframework.form.config.IFormValueEnumListConfig;
/*     */ import dtv.util.ICodeInterface;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DaoEnumLoader implements IEnumLoader {
/*  29 */   private static final IValueWrapperFactory DEFAULT_WRAPPER_FACT = ValueWrapperFactory.makeWrapperFactory((Class)SimpleValueWrapper.class);
/*  30 */   private static final IQueryKey<IDataModel> EXTENT = (IQueryKey<IDataModel>)new QueryKey("EXTENT", IDataModel.class);
/*  31 */   private static final Logger logger_ = Logger.getLogger(DaoEnumLoader.class);
/*     */   
/*  33 */   protected IValueWrapperFactory valueWrapper_ = DEFAULT_WRAPPER_FACT;
/*     */   
/*  35 */   private String codeCategory_ = null;
/*     */   
/*     */   private Comparator<Object> comparator_;
/*     */   
/*     */   private ClassConfig<Comparator<Object>> comparatorClassConfig_;
/*     */   private IFormValueEnumConfig config_;
/*     */   private ClassConfig<?> diaClassConfig_;
/*     */   private ClassConfig<?> interfaceClassConfig_;
/*     */   private ClassConfig<?> objectFilter_;
/*     */   
/*     */   public List<? extends Object> getValues() {
/*     */     try {
/*  47 */       if (getDaiClassConfig() == null) {
/*  48 */         initialize();
/*     */       }
/*     */       
/*  51 */       List<Object> list = new ArrayList();
/*  52 */       if (this.config_.isNullAllowed()) {
/*  53 */         list.add(wrapValue(null));
/*     */       }
/*     */       
/*  56 */       Object[] results = loadCodes();
/*     */       
/*  58 */       for (Object element : results) {
/*  59 */         list.add(wrapValue(element));
/*     */       }
/*  61 */       return list;
/*     */     }
/*  63 */     catch (Exception ex) {
/*  64 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  65 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getWrapperFactory() {
/*  72 */     return this.valueWrapper_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IFormValueEnumConfig argConfig) {
/*  78 */     this.config_ = argConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getCodeCategoryKey() {
/*  86 */     return this.codeCategory_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Comparator<Object> getComparator() {
/*  94 */     return this.comparator_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassConfig<Comparator<Object>> getComparatorClassConfig() {
/* 102 */     return this.comparatorClassConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IFormValueEnumConfig getConfig() {
/* 110 */     return this.config_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassConfig<?> getDaiClassConfig() {
/* 118 */     return this.diaClassConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Comparator<ICodeInterface> getDefaultComparator() {
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassConfig<?> getInterfaceClassConfig() {
/* 134 */     return this.interfaceClassConfig_;
/*     */   }
/*     */   
/*     */   protected ClassConfig<?> getObjectFilterClassConfig() {
/* 138 */     return this.objectFilter_;
/*     */   }
/*     */   
/*     */   protected void initialize() {
/* 142 */     for (ParameterConfig param : getConfig().getLoaderParams().getParameters()) {
/* 143 */       processParam(param);
/*     */     }
/* 145 */     IFormValueEnumListConfig valuesConfig = getConfig().getConfiguredValues();
/* 146 */     if (valuesConfig != null) {
/* 147 */       List<? extends Object> configValues = valuesConfig.getValues();
/* 148 */       if (configValues != null && !configValues.isEmpty()) {
/* 149 */         logger_.warn("this enum loader does not accept configured values");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected Object[] loadCodes() {
/* 155 */     Object[] results = null;
/* 156 */     Map<String, Object> params = new HashMap<>();
/* 157 */     params.put("ClassName", getDaiClassConfig().getValue());
/*     */     
/* 159 */     if (this.codeCategory_ != null) {
/* 160 */       params.put("argCodeCategory", getCodeCategoryKey().toString());
/*     */     }
/*     */     
/* 163 */     List<IDataModel> col = null;
/*     */     try {
/* 165 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(EXTENT, params);
/*     */     }
/* 167 */     catch (ObjectNotFoundException ex) {
/* 168 */       logger_.warn("Query returned no results for query key [" + EXTENT + "] with parameters " + params);
/* 169 */       col = Collections.emptyList();
/*     */     } 
/*     */     
/* 172 */     ClassConfig<?> ofcc = getObjectFilterClassConfig();
/* 173 */     if (ofcc != null) {
/* 174 */       IObjectFilter filter = null;
/*     */       try {
/* 176 */         filter = ofcc.getValue().newInstance();
/*     */       }
/* 178 */       catch (Exception ex) {
/*     */ 
/*     */         
/* 181 */         throw (ex instanceof RuntimeException) ? (RuntimeException)ex : new RuntimeException(ex);
/*     */       } 
/* 183 */       Iterator<IDataModel> iter = col.iterator();
/* 184 */       while (iter.hasNext()) {
/* 185 */         if (!filter.accept(iter.next())) {
/* 186 */           iter.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     results = col.toArray();
/*     */ 
/*     */     
/* 194 */     return sort(results);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void processParam(ParameterConfig argParamConfig) {
/* 199 */     IConfigObject value = argParamConfig.getValue();
/* 200 */     String name = argParamConfig.getName();
/*     */     
/* 202 */     if ("dai".equalsIgnoreCase(name)) {
/* 203 */       setDiaClassConfig(ConfigUtils.toClassConfig(value));
/*     */     }
/* 205 */     else if ("interface".equalsIgnoreCase(name)) {
/* 206 */       setInterfaceClassConfig(ConfigUtils.toClassConfig(value));
/*     */     }
/* 208 */     else if ("wrapper".equalsIgnoreCase(name)) {
/*     */       
/* 210 */       ClassConfig<IEnumValueWrapper> config = ConfigUtils.toClassConfig(value);
/*     */       
/* 212 */       this.valueWrapper_ = ValueWrapperFactory.makeWrapperFactory(config.getValue());
/*     */     }
/* 214 */     else if ("comparator".equalsIgnoreCase(name)) {
/* 215 */       setComparatorClassConfig(ConfigUtils.toClassConfig(value));
/*     */     }
/* 217 */     else if ("filter".equalsIgnoreCase(name)) {
/* 218 */       setObjectFilterClassConfig(ConfigUtils.toClassConfig(value));
/*     */     }
/* 220 */     else if ("codeCategory".equalsIgnoreCase(name)) {
/* 221 */       if (value instanceof ClassConfig) {
/* 222 */         setCodeCategoryKey(((ClassConfig)value).getConfigValue());
/*     */       } else {
/*     */         
/* 225 */         setCodeCategoryKey(value.toString());
/*     */       } 
/*     */     } else {
/*     */       
/* 229 */       logger_.warn("unexpected parameter " + argParamConfig + "");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setCodeCategoryKey(String argCodeCategoryKey) {
/* 238 */     this.codeCategory_ = argCodeCategoryKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComparator(Comparator<Object> argComparator) {
/* 246 */     this.comparator_ = argComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComparatorClassConfig(ClassConfig<Comparator<Object>> argComparatorClassConfig) {
/* 254 */     this.comparatorClassConfig_ = argComparatorClassConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setDiaClassConfig(ClassConfig<?> argDiaClassConfig) {
/* 262 */     this.diaClassConfig_ = argDiaClassConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setInterfaceClassConfig(ClassConfig<?> argInterfaceClassConfig) {
/* 270 */     this.interfaceClassConfig_ = argInterfaceClassConfig;
/*     */   }
/*     */   
/*     */   protected void setObjectFilterClassConfig(ClassConfig<?> argObjectFilter) {
/* 274 */     this.objectFilter_ = argObjectFilter;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object[] sort(Object[] argValues) {
/* 279 */     if (getComparatorClassConfig() != null) {
/* 280 */       Class<Comparator<Object>> comparatorClass = getComparatorClassConfig().getValue();
/*     */       try {
/* 282 */         setComparator(comparatorClass.newInstance());
/*     */       }
/* 284 */       catch (Exception ex) {
/* 285 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/* 287 */       setComparatorClassConfig(null);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 292 */     if (this.comparator_ != null) {
/* 293 */       Arrays.sort(argValues, getComparator());
/*     */ 
/*     */     
/*     */     }
/* 297 */     else if (ObjectUtils.isImplementing(getDaiClassConfig().getValue(), ICodeInterface.class)) {
/* 298 */       Arrays.sort((ICodeInterface[])argValues, getDefaultComparator());
/*     */     }
/* 300 */     else if (getInterfaceClassConfig() != null && 
/* 301 */       ObjectUtils.isImplementing(getInterfaceClassConfig().getValue(), ICodeInterface.class)) {
/*     */       
/* 303 */       ICodeInterface[] sortArray = new ICodeInterface[argValues.length];
/* 304 */       for (int i = 0; i < argValues.length; i++) {
/* 305 */         sortArray[i] = (ICodeInterface)argValues[i];
/*     */       }
/* 307 */       Arrays.sort(sortArray, getDefaultComparator());
/*     */       
/* 309 */       return (Object[])sortArray;
/*     */     } 
/* 311 */     return argValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object wrapValue(Object actualValue) {
/* 321 */     if (getWrapperFactory() == null) {
/* 322 */       logger_.warn("null wrapper factory?!?!?!");
/* 323 */       return actualValue;
/*     */     } 
/*     */     
/* 326 */     return getWrapperFactory().wrapValue(actualValue);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DaoEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */