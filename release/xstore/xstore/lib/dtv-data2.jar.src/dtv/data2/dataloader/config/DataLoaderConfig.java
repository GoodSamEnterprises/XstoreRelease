/*     */ package dtv.data2.dataloader.config;
/*     */ 
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ 
/*     */ public class DataLoaderConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   public static final String PARAMETER_ORG_ID = "OrganizationId";
/*     */   public static final String PARAMETER_CHARACTER_ENCODING = "characterEncoding";
/*     */   public static final String ACTION_TRUNCATE = "TRUNCATE";
/*     */   public static final String ACTION_DELETE_BY_ORGANIZATION = "DELETE_BY_ORGANIZATION";
/*     */   public static final String ACTION_INSERT = "INSERT";
/*     */   public static final String ACTION_UPDATE = "UPDATE";
/*     */   public static final String ACTION_UPDATE_SELECT = "UPDATE_SELECT";
/*     */   public static final String ACTION_DELETE = "DELETE";
/*     */   public static final String ACTION_BEGIN_RUN_SQL = "BEGIN_RUN_SQL";
/*     */   public static final String ACTION_RUN_SQL = "RUN_SQL";
/*     */   public static final String ACTION_INSERT_ONLY = "INSERT_ONLY";
/*     */   public static final String SYS_PROP_FILE_LOCATION = "dtv.dataloader.DataFileLocation";
/*  43 */   public static final List<String> _actionTypes = Arrays.asList(new String[] { "TRUNCATE", "DELETE_BY_ORGANIZATION", "BEGIN_RUN_SQL", "DELETE", "INSERT", "UPDATE", "UPDATE_SELECT", "RUN_SQL", "INSERT_ONLY" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isRunSql(String argActionType) {
/*  63 */     return ("RUN_SQL".equalsIgnoreCase(argActionType) || "BEGIN_RUN_SQL"
/*  64 */       .equalsIgnoreCase(argActionType));
/*     */   }
/*     */   
/*  67 */   private final List<RecordTypeConfig> _recordTypeList = new ArrayList<>(32);
/*  68 */   private final Map<String, RecordTypeConfig> _recordTypeMap = new HashMap<>(32);
/*  69 */   private final Map<String, String> _parameters = new HashMap<>();
/*     */   
/*     */   public int getActionTypeSortOrder(String argActionType) {
/*  72 */     if ("BEGIN_RUN_SQL".equalsIgnoreCase(argActionType)) {
/*  73 */       return Integer.MIN_VALUE;
/*     */     }
/*  75 */     if ("RUN_SQL".equalsIgnoreCase(argActionType)) {
/*  76 */       return Integer.MAX_VALUE;
/*     */     }
/*  78 */     return _actionTypes.indexOf(argActionType);
/*     */   }
/*     */   
/*     */   public String getCharacterEncoding() {
/*  82 */     String value = this._parameters.get("characterEncoding");
/*  83 */     if (StringUtils.isEmpty(value)) {
/*  84 */       throw new DataLoaderException("Required parameter: characterEncoding was not found.  Check DataLoaderConfig.xml");
/*     */     }
/*     */     
/*  87 */     return value;
/*     */   }
/*     */   
/*     */   public Map<String, String> getParameters() {
/*  91 */     return this._parameters;
/*     */   }
/*     */   
/*     */   public RecordTypeConfig getRecordType(String argRecordType) {
/*  95 */     RecordTypeConfig recordType = this._recordTypeMap.get(argRecordType);
/*     */     
/*  97 */     if (recordType == null) {
/*  98 */       recordType = new RecordTypeConfig();
/*  99 */       recordType.setRecordTypeName(argRecordType);
/* 100 */       this._recordTypeMap.put(argRecordType, recordType);
/*     */     } 
/*     */     
/* 103 */     return recordType;
/*     */   }
/*     */   
/*     */   public List<RecordTypeConfig> getRecordTypes() {
/* 107 */     return this._recordTypeList;
/*     */   }
/*     */   
/*     */   public int getRecordTypeSortOrder(String argRecordType) {
/* 111 */     RecordTypeConfig config = getRecordType(argRecordType);
/* 112 */     if (config != null) {
/* 113 */       return this._recordTypeList.indexOf(config);
/*     */     }
/*     */     
/* 116 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValidActionType(String argActionType) {
/* 121 */     return _actionTypes.contains(argActionType);
/*     */   }
/*     */   
/*     */   public boolean isValidRecordType(String argRecordType) {
/* 125 */     return (this._recordTypeMap.containsKey(argRecordType) || 
/* 126 */       isRunSql(argRecordType) || "XML_PERSISTABLES"
/* 127 */       .equals(argRecordType));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 133 */     if ("RecordType".equalsIgnoreCase(argKey)) {
/* 134 */       this._recordTypeList.add((RecordTypeConfig)argValue);
/* 135 */       this._recordTypeMap.put(((RecordTypeConfig)argValue).getRecordTypeName(), (RecordTypeConfig)argValue);
/*     */     }
/* 137 */     else if ("Parameter".equalsIgnoreCase(argKey)) {
/* 138 */       this._parameters.put(((DataLoaderParameterConfig)argValue).getParameterName(), ((DataLoaderParameterConfig)argValue)
/* 139 */           .getParameterValue());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\DataLoaderConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */