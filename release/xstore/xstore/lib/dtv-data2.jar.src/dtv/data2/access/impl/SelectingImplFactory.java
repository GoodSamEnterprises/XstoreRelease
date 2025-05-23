/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.util.StringUtils;
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
/*     */ public class SelectingImplFactory
/*     */ {
/*  19 */   private static final Logger logger_ = Logger.getLogger(SelectingImplFactory.class);
/*  20 */   private static String SYSTEM_PROPERTY = "dtv.data2.OverrideTypes";
/*  21 */   private static String DEFAULT_OVERRIDETYPES = "Customer,Country";
/*     */   
/*  23 */   private static String CONFIG_ELEMENT = "dtv.data2.access.impl.daogen.IHasConfigElementTables";
/*  24 */   private static String ORG_HIERARCHY = "dtv.data2.access.impl.daogen.IHasOrgHierarchyTables";
/*  25 */   private static String ADAPTER_MAP = "dtv.data2.access.impl.AdapterMap";
/*  26 */   private static String DATA_MODEL_FACTORY = "dtv.data2.access.DataModelFactory";
/*     */   
/*  28 */   private static String DEFAULT_CONFIG_ELEMENT = "dtv.xst.dao.ConfigElementTableList";
/*  29 */   private static String DEFAULT_ORG_HIERARCHY = "dtv.xst.dao.OrgHierarchyTableList";
/*  30 */   private static String DEFAULT_ADAPTERMAP_PREFIX = "dtv.data2.access.impl.jdbc.JDBCAdapterMap";
/*  31 */   private static String DEFAULT_DATAMODELFACTORY_PREFIX = "dtv.data2.access.impl.DataModelFactory";
/*  32 */   private static String DEFAULT_IMPL_SUFFIX = "Impl";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T getImplClass(Class<T> argClass) {
/*  42 */     String overrideTypes = System.getProperty(SYSTEM_PROPERTY);
/*  43 */     if (StringUtils.isEmpty(overrideTypes)) {
/*  44 */       overrideTypes = DEFAULT_OVERRIDETYPES;
/*     */     }
/*     */     
/*  47 */     String[] types = StringUtils.split(overrideTypes, ',');
/*     */     
/*  49 */     T impl = null;
/*  50 */     for (String type : types) {
/*  51 */       String className = getClassName(argClass, type);
/*     */       
/*     */       try {
/*  54 */         impl = (T)Class.forName(className).newInstance();
/*  55 */         if (impl != null) {
/*     */           break;
/*     */         }
/*     */       }
/*  59 */       catch (ClassNotFoundException ex) {
/*     */ 
/*     */         
/*  62 */         logger_.debug("Class not found! \"" + className + "\"", ex);
/*     */       }
/*  64 */       catch (Exception ex) {
/*  65 */         logger_.warn("There was a problem trying to instantiate \"" + className + "\"", ex);
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     if (impl == null) {
/*  70 */       String baseClassName = getClassName(argClass, null);
/*     */       
/*     */       try {
/*  73 */         impl = (T)Class.forName(baseClassName).newInstance();
/*     */       }
/*  75 */       catch (Exception ex) {
/*  76 */         throw new Error(ex);
/*     */       } 
/*     */     } 
/*     */     
/*  80 */     return impl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String buildClassName(String argPrefix, String argType) {
/*  91 */     return buildClassName(argPrefix, argType, null);
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
/*     */   private static String buildClassName(String argPrefix, String argType, String argSuffix) {
/* 103 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 105 */     sb.append((argPrefix != null) ? argPrefix : "");
/* 106 */     sb.append((argType != null) ? argType : "");
/* 107 */     sb.append((argSuffix != null) ? argSuffix : "");
/*     */     
/* 109 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getClassName(Class<?> argClass, String argType) {
/* 120 */     String className = "";
/* 121 */     if (CONFIG_ELEMENT.equalsIgnoreCase(argClass.getName())) {
/* 122 */       className = buildClassName(DEFAULT_CONFIG_ELEMENT, argType);
/*     */     }
/* 124 */     else if (ORG_HIERARCHY.equalsIgnoreCase(argClass.getName())) {
/* 125 */       className = buildClassName(DEFAULT_ORG_HIERARCHY, argType);
/*     */     }
/* 127 */     else if (ADAPTER_MAP.equalsIgnoreCase(argClass.getName())) {
/* 128 */       className = buildClassName(DEFAULT_ADAPTERMAP_PREFIX, argType, DEFAULT_IMPL_SUFFIX);
/*     */     }
/* 130 */     else if (DATA_MODEL_FACTORY.equalsIgnoreCase(argClass.getName())) {
/* 131 */       className = buildClassName(DEFAULT_DATAMODELFACTORY_PREFIX, argType, DEFAULT_IMPL_SUFFIX);
/*     */     } 
/*     */     
/* 134 */     return className;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\SelectingImplFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */