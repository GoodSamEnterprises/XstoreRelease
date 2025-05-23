/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.util.ICodeInterface;
/*     */ import dtv.util.StringUtils;
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
/*     */ public class CodeLocatorImpl
/*     */   implements ICodeLocator
/*     */ {
/*  22 */   private static final IQueryKey<? extends ICodeInterface> _defaultCodeQuery = (IQueryKey<? extends ICodeInterface>)new QueryKey("CODE_LOOKUP", ICodeInterface.class);
/*     */   
/*  24 */   private static final IQueryKey<? extends ICodeValue> _defaultCodeValueQuery = (IQueryKey<? extends ICodeValue>)new QueryKey("CODE_VALUE_LOOKUP", ICodeValue.class);
/*     */   
/*  26 */   private static final IQueryKey<? extends IReasonCode> _defaultReasonCodeQuery = (IQueryKey<? extends IReasonCode>)new QueryKey("REASON_CODE_LOOKUP", IReasonCode.class);
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
/*     */   protected static boolean putParamIf(Map<String, Object> argParams, String argKey, Object argValue) {
/*  41 */     boolean rejected = (argValue == null || (argValue instanceof String && StringUtils.isEmpty((String)argValue)));
/*     */     
/*  43 */     if (!rejected) {
/*  44 */       argParams.put(argKey, argValue);
/*     */     }
/*  46 */     return !rejected;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICodeInterface getCode(IObjectId argObjectId) {
/*  52 */     return (ICodeInterface)DataFactory.getObjectById(argObjectId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends ICodeInterface> getCodes(Class<? extends IObjectId> argClass) {
/*  58 */     Map<String, Object> queryParams = new HashMap<>();
/*  59 */     putParamIf(queryParams, "ClassName", argClass.getName());
/*     */     
/*  61 */     return (List<? extends ICodeInterface>)DataFactory.getObjectByQuery(getCodeQueryKey(), queryParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICodeValue getCodeValue(long argOrgId, String argCategory, String argCode) {
/*  67 */     CodeValueId id = new CodeValueId();
/*  68 */     id.setOrganizationId(Long.valueOf(argOrgId));
/*  69 */     id.setCategory(argCategory);
/*  70 */     id.setCode(argCode);
/*     */     
/*  72 */     return (ICodeValue)DataFactory.getObjectById((IObjectId)id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends ICodeValue> getCodeValues(long argOrgId, String argCategory) {
/*  78 */     Map<String, Object> queryParams = new HashMap<>();
/*  79 */     putParamIf(queryParams, "argOrganizationId", Long.valueOf(argOrgId));
/*  80 */     putParamIf(queryParams, "argCategory", argCategory);
/*     */     
/*  82 */     return (List<? extends ICodeValue>)DataFactory.getObjectByQuery(getCodeValueQueryKey(), queryParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IReasonCode getReasonCode(long argOrgId, String argCategory, String argCode) {
/*  88 */     ReasonCodeId id = new ReasonCodeId();
/*  89 */     id.setOrganizationId(Long.valueOf(argOrgId));
/*  90 */     id.setReasonTypeCode(argCategory);
/*  91 */     id.setReasonCode(argCode);
/*     */     
/*  93 */     return (IReasonCode)DataFactory.getObjectById((IObjectId)id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IReasonCode> getReasonCodes(long argOrgId, String argCategory, String argParentCode) {
/*  99 */     Map<String, Object> queryParams = new HashMap<>();
/* 100 */     String categoryParam = StringUtils.isEmpty(argParentCode) ? "argCategory" : "argParentCategory";
/*     */     
/* 102 */     putParamIf(queryParams, categoryParam, argCategory);
/* 103 */     putParamIf(queryParams, "argParentCode", argParentCode);
/* 104 */     putParamIf(queryParams, "argOrganizationId", Long.valueOf(argOrgId));
/*     */     
/* 106 */     return (List<? extends IReasonCode>)DataFactory.getObjectByQuery(getReasonCodeQueryKey(), queryParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IQueryKey<? extends ICodeInterface> getCodeQueryKey() {
/* 116 */     return _defaultCodeQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IQueryKey<? extends ICodeValue> getCodeValueQueryKey() {
/* 124 */     return _defaultCodeValueQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IQueryKey<? extends IReasonCode> getReasonCodeQueryKey() {
/* 132 */     return _defaultReasonCodeQuery;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\CodeLocatorImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */