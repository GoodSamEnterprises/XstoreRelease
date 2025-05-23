/*     */ package dtv.data2.dataloader.fileprocessing;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.DataModelFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.data2.access.query.SqlQueryRequest;
/*     */ import dtv.data2.dataloader.ConfigParameters;
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.applicability.IApplicabilityCondition;
/*     */ import dtv.data2.dataloader.config.DaoConfig;
/*     */ import dtv.data2.dataloader.config.DataLoaderConfigHelper;
/*     */ import dtv.data2.dataloader.config.DataModifierConfig;
/*     */ import dtv.data2.dataloader.config.DataModifierParameterConfig;
/*     */ import dtv.data2.dataloader.config.FieldConfig;
/*     */ import dtv.data2.dataloader.config.PersistableConfig;
/*     */ import dtv.data2.dataloader.config.RecordTypeConfig;
/*     */ import dtv.data2.dataloader.config.SqlStatementConfig;
/*     */ import dtv.data2.dataloader.valuetranslator.IValueTranslator;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DelimitedValueFileLineParser implements IFileLineParser {
/*  41 */   private static final Logger logger_ = Logger.getLogger(DelimitedValueFileLineParser.class);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */   
/*  47 */   private Map<String, Method> _configParamToMethod = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> parse(FileLine argFileLine) {
/*  53 */     RecordTypeConfig recordConfig = DataLoaderConfigHelper.getDataLoaderConfig().getRecordType(argFileLine.getRecordType());
/*     */     
/*  55 */     List<PersistableConfig> persistableConfigs = recordConfig.getPersistables();
/*  56 */     List<IPersistable> persistables = new ArrayList<>(persistableConfigs.size());
/*     */     
/*  58 */     for (PersistableConfig persistableConfig : persistableConfigs) {
/*     */       IPersistable persistable;
/*     */ 
/*     */       
/*  62 */       if (persistableConfig.getActionType() != null) {
/*  63 */         if (persistableConfig.getActionType().equals("INSERT_ONLY")) {
/*     */           
/*  65 */           if (argFileLine.getActionType().equals("DELETE"))
/*     */           {
/*     */             continue;
/*     */           }
/*     */         }
/*  70 */         else if (!persistableConfig.getActionType().equals(argFileLine.getActionType())) {
/*     */           continue;
/*     */         } 
/*     */       }
/*     */       
/*  75 */       if (persistableConfig.getApplicabilityConditions() != null && 
/*  76 */         !processApplicabilityConditions(persistableConfig, argFileLine)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  87 */       if (persistableConfig instanceof DaoConfig) {
/*  88 */         persistable = getDao((DaoConfig)persistableConfig, argFileLine);
/*     */       }
/*  90 */       else if (persistableConfig instanceof SqlStatementConfig) {
/*  91 */         persistable = getSql((SqlStatementConfig)persistableConfig, argFileLine);
/*     */       } else {
/*     */         
/*  94 */         throw new DataLoaderException("Unknown config type: " + persistableConfig);
/*     */       } 
/*     */       
/*  97 */       if (persistable != null) {
/*  98 */         persistables.add(persistable);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     if (argFileLine.getActionType().equals("DELETE")) {
/* 108 */       Collections.reverse(persistables);
/*     */     }
/*     */     
/* 111 */     return persistables;
/*     */   }
/*     */   
/*     */   public void setDaoState(IDataAccessObject argDao, String argActionType, DaoConfig argConfig) {
/* 115 */     DaoState state = null;
/*     */     
/* 117 */     if ("INSERT_ONLY".equals(argConfig.getActionType())) {
/* 118 */       state = DaoState.INSERT_ONLY;
/* 119 */       argDao.setObjectState(state.intVal());
/* 120 */       DataLoaderUtils.stampDaoAuditFields(argDao, state);
/*     */       
/*     */       return;
/*     */     } 
/* 124 */     if ("INSERT".equals(argActionType)) {
/* 125 */       state = DaoState.INSERT_OR_UPDATE;
/*     */     }
/* 127 */     else if ("INSERT_ONLY".equals(argActionType)) {
/* 128 */       state = DaoState.INSERT_ONLY;
/*     */     }
/* 130 */     else if ("UPDATE".equals(argActionType) || "UPDATE_SELECT".equals(argActionType)) {
/* 131 */       state = DaoState.UPDATED;
/*     */     }
/* 133 */     else if ("DELETE".equals(argActionType) || "TRUNCATE"
/* 134 */       .equals(argActionType) || "DELETE_BY_ORGANIZATION"
/* 135 */       .equals(argActionType)) {
/*     */       
/* 137 */       state = DaoState.DELETED;
/*     */     } else {
/*     */       
/* 140 */       throw new DataLoaderException("Unknown action type encountered: " + argActionType);
/*     */     } 
/*     */     
/* 143 */     argDao.setObjectState(state.intVal());
/* 144 */     DataLoaderUtils.stampDaoAuditFields(argDao, state);
/*     */   }
/*     */   
/*     */   protected String getValue(FieldConfig argConfig, FileLine argLine) {
/* 148 */     FieldConfig fieldConfig = argConfig;
/*     */     
/* 150 */     String value = null;
/*     */     
/* 152 */     if (FieldConfig.FieldValueSource.LITERAL == fieldConfig.getFieldValueSource()) {
/* 153 */       value = fieldConfig.getValueSpecifier();
/*     */     }
/* 155 */     else if (FieldConfig.FieldValueSource.VARIABLE == fieldConfig.getFieldValueSource()) {
/* 156 */       if ("$currentDate".equals(fieldConfig.getValueSpecifier())) {
/*     */         
/* 158 */         value = String.valueOf((new DtvDate(DateUtils.clearTime((new Date()).getTime()))).getTimeSerializable());
/*     */ 
/*     */       
/*     */       }
/* 162 */       else if ("$currentDateTimestamp".equals(fieldConfig.getValueSpecifier())) {
/* 163 */         value = String.valueOf((new DtvDate()).getTimeSerializable());
/*     */       } else {
/*     */         
/* 166 */         throw new DataLoaderException("Unknown variable name specified: " + fieldConfig.getValueSpecifier());
/*     */       }
/*     */     
/* 169 */     } else if (FieldConfig.FieldValueSource.SYSTEM_PROPERTY == fieldConfig.getFieldValueSource()) {
/* 170 */       value = System.getProperty(fieldConfig.getValueSpecifier());
/* 171 */       if (value == null) {
/* 172 */         logger_.warn("System propery " + fieldConfig.getValueSpecifier() + " value was null.  Config source: " + fieldConfig
/* 173 */             .getSourceDescription());
/*     */       }
/*     */     }
/* 176 */     else if (FieldConfig.FieldValueSource.CONFIG_PARAMETER == fieldConfig.getFieldValueSource()) {
/* 177 */       Method configParamMethod = this._configParamToMethod.get(fieldConfig.getValueSpecifier());
/*     */       
/*     */       try {
/* 180 */         if (configParamMethod == null) {
/* 181 */           configParamMethod = this._configParameters.getClass().getDeclaredMethod(fieldConfig.getValueSpecifier(), new Class[0]);
/* 182 */           this._configParamToMethod.put(fieldConfig.getValueSpecifier(), configParamMethod);
/*     */         } 
/*     */         
/* 185 */         Object result = configParamMethod.invoke(this._configParameters, new Object[0]);
/* 186 */         value = result.toString();
/*     */       }
/* 188 */       catch (ReflectiveOperationException ex) {
/* 189 */         logger_.error("Unable to access config parameter named " + fieldConfig.getValueSpecifier(), ex);
/*     */       }
/*     */     
/* 192 */     } else if (FieldConfig.FieldValueSource.FILE_POSITION == fieldConfig.getFieldValueSource()) {
/* 193 */       int filePosition = fieldConfig.getFilePosition();
/*     */       
/* 195 */       if (filePosition <= argLine.getFieldValueCount()) {
/* 196 */         String fileValue = argLine.getFieldValue(filePosition);
/* 197 */         if (!StringUtils.isEmpty(fileValue)) {
/* 198 */           value = fileValue.trim();
/*     */         }
/*     */         else {
/*     */           
/* 202 */           value = fieldConfig.getFieldDefault();
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 208 */       if (null == value && filePosition > argLine.getFieldValueCount()) {
/* 209 */         value = fieldConfig.getFieldDefault();
/*     */       }
/*     */     }
/* 212 */     else if (FieldConfig.FieldValueSource.FILE_INTERVAL == fieldConfig.getFieldValueSource()) {
/* 213 */       value = argLine.getFieldValue(fieldConfig.getFileIntervalStart(), fieldConfig.getFileIntervalEnd());
/*     */     }
/* 215 */     else if (fieldConfig.getFieldValueSource() == null) {
/* 216 */       if (fieldConfig.getValueTranslators() == null) {
/* 217 */         throw new DataLoaderException("A Field is misconfigured in dataloader config.  This field does not define a field value source (e.g. \"filePosition\", \"sysProp\") and also does not define any translators. A field must define value source or at least 1 translator to provide a value. COnfig Source: " + argConfig
/*     */ 
/*     */ 
/*     */             
/* 221 */             .getSourceDescription());
/*     */       }
/*     */     } else {
/*     */       
/* 225 */       throw new DataLoaderException("Unknown field value source specified: " + argConfig
/* 226 */           .getFieldValueSource());
/*     */     } 
/*     */     
/* 229 */     value = translateValue(value, argConfig, argLine);
/*     */     
/* 231 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean processApplicabilityConditions(PersistableConfig argPersistable, FileLine argCurrentLine) {
/* 236 */     boolean applicable = true;
/*     */     
/* 238 */     for (DataModifierConfig config : argPersistable.getApplicabilityConditions()) {
/* 239 */       IApplicabilityCondition condition = null;
/*     */       try {
/* 241 */         condition = (IApplicabilityCondition)Class.forName(config.getClassName()).newInstance();
/*     */       }
/* 243 */       catch (Exception ee) {
/* 244 */         throw new DataLoaderException("Could not instantiate class for applicability condition. Class name: [" + config
/* 245 */             .getClassName() + "]", ee);
/*     */       } 
/*     */       
/* 248 */       if (condition == null) {
/* 249 */         throw new DataLoaderException("condition should not be null at this point.");
/*     */       }
/*     */       
/* 252 */       List<DataModifierParameterConfig> params = config.getParameters();
/*     */       
/* 254 */       for (DataModifierParameterConfig param : params) {
/* 255 */         condition.setParameter(param.getParameterKey(), param.getParameterValue());
/*     */       }
/*     */       
/* 258 */       applicable = condition.isApplicable(argCurrentLine);
/*     */       
/* 260 */       if (!applicable) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 265 */     return applicable;
/*     */   }
/*     */   
/*     */   private IPersistable getDao(DaoConfig argConfig, FileLine argLine) {
/* 269 */     List<FieldConfig> fieldConfigs = argConfig.getFields();
/*     */     
/* 271 */     Map<String, String> values = new HashMap<>(fieldConfigs.size());
/*     */     
/* 273 */     for (FieldConfig fieldConfig : fieldConfigs) {
/* 274 */       values.put(fieldConfig.getDaoFieldName(), getValue(fieldConfig, argLine));
/*     */     }
/*     */     
/* 277 */     IDataAccessObject dao = null;
/*     */     
/* 279 */     if (argLine.getActionType().equals("UPDATE_SELECT")) {
/* 280 */       IObjectId id = DataModelFactory.getIdForDaoName(argConfig.getDaoName());
/* 281 */       DaoUtils.loadIDFromValueMap(id, values);
/* 282 */       IDataModelImpl model = (IDataModelImpl)DataFactory.getObjectById(id);
/*     */       
/* 284 */       if (model != null) {
/* 285 */         dao = model.getDAO();
/*     */       }
/*     */       
/* 288 */       values = replaceNullsWithValuesFromDAO(values, (IPersistable)dao);
/*     */     } else {
/*     */       
/* 291 */       dao = DataModelFactory.getDaoForDaoName(argConfig.getDaoName());
/*     */     } 
/*     */     
/* 294 */     setDaoState(dao, argLine.getActionType(), argConfig);
/*     */     
/* 296 */     if (dao != null) {
/* 297 */       dao.setValues(values);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 302 */     if (dao instanceof IHasIncrementalValues) {
/* 303 */       ((IHasIncrementalValues)dao).setIncrementalActive(false);
/*     */     }
/*     */     
/* 306 */     return (IPersistable)dao;
/*     */   }
/*     */   
/*     */   private IPersistable getSql(SqlStatementConfig argConfig, FileLine argLine) {
/* 310 */     SqlQueryRequest query = new SqlQueryRequest();
/* 311 */     query.setSqlStatement(argConfig.getSqlString());
/* 312 */     List<FieldConfig> fieldConfigs = argConfig.getFields();
/*     */     
/* 314 */     List<Object> params = new ArrayList(fieldConfigs.size());
/*     */     
/* 316 */     for (FieldConfig fieldConfig : fieldConfigs) {
/* 317 */       String rawValue = getValue(fieldConfig, argLine);
/*     */ 
/*     */       
/* 320 */       Object objectValue = DaoUtils.getFieldValueForXmlString(
/* 321 */           JDBCHelper.getJDBCTypeForTypeName(fieldConfig.getFieldDataType()), rawValue);
/*     */       
/* 323 */       params.add(objectValue);
/*     */     } 
/*     */     
/* 326 */     query.setParams(params);
/* 327 */     return (IPersistable)query;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getterFromKey(String argKey) {
/* 337 */     if (argKey == null || argKey.length() == 0) {
/* 338 */       return null;
/*     */     }
/*     */     
/* 341 */     return "get" + Character.toUpperCase(argKey.charAt(0)) + argKey
/* 342 */       .substring(1);
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
/*     */   private String getValueFromDAO(String argKey, IPersistable argDao) {
/* 354 */     Class<? extends IPersistable> daoType = (Class)argDao.getClass();
/* 355 */     String currentValue = null;
/*     */ 
/*     */     
/* 358 */     try { Method getter = daoType.getMethod(getterFromKey(argKey), new Class[0]);
/*     */       
/* 360 */       if (getter != null) {
/* 361 */         Object currentValObj = getter.invoke(argDao, new Object[0]);
/*     */         
/* 363 */         if (currentValObj != null) {
/* 364 */           currentValue = currentValObj.toString();
/*     */         }
/*     */       }
/*     */        }
/*     */     
/* 369 */     catch (ReflectiveOperationException reflectiveOperationException) {  }
/* 370 */     catch (IllegalArgumentException illegalArgumentException) {}
/*     */     
/* 372 */     return currentValue;
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
/*     */   private Map<String, String> replaceNullsWithValuesFromDAO(Map<String, String> argValues, IPersistable argDao) {
/* 385 */     Map<String, String> meldedValues = new HashMap<>();
/*     */     
/* 387 */     for (String key : argValues.keySet()) {
/* 388 */       if (argValues.get(key) == null) {
/* 389 */         meldedValues.put(key, getValueFromDAO(key, argDao));
/*     */         continue;
/*     */       } 
/* 392 */       meldedValues.put(key, argValues.get(key));
/*     */     } 
/*     */ 
/*     */     
/* 396 */     return meldedValues;
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
/*     */   private String translateValue(String argRawValue, FieldConfig argConfig, FileLine argFileLine) {
/* 408 */     if (argConfig.getValueTranslators() == null) {
/* 409 */       return argRawValue;
/*     */     }
/*     */     
/* 412 */     String translatedValue = argRawValue;
/*     */     
/* 414 */     for (DataModifierConfig translatorConfig : argConfig.getValueTranslators()) {
/*     */ 
/*     */ 
/*     */       
/* 418 */       IValueTranslator translator = null;
/*     */       
/*     */       try {
/* 421 */         translator = (IValueTranslator)Class.forName(translatorConfig.getClassName()).newInstance();
/*     */       }
/* 423 */       catch (Exception ee) {
/* 424 */         if (StringUtils.isEmpty(translatorConfig.getClassName())) {
/* 425 */           throw new DataLoaderException("Could not load value translator - No Class name attribute was supplied for ValueTransltor field. Source: " + argConfig
/*     */               
/* 427 */               .getSourceDescription());
/*     */         }
/*     */         
/* 430 */         throw new DataLoaderException("Could not load value translator.", ee);
/*     */       } 
/*     */ 
/*     */       
/* 434 */       if (translator == null) {
/* 435 */         throw new DataLoaderException("translator should not be null at this point.  Source config: " + argConfig
/* 436 */             .getSourceDescription());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 442 */       for (DataModifierParameterConfig paramConfig : translatorConfig.getParameters()) {
/* 443 */         translator.setParameter(paramConfig.getParameterKey(), paramConfig.getParameterValue());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 449 */       translatedValue = translator.translate(translatedValue, argFileLine);
/*     */     } 
/*     */     
/* 452 */     return translatedValue;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\DelimitedValueFileLineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */