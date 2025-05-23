/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.config.query.QueryDescriptor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCAdapterMap;
/*     */ import dtv.data2.access.impl.jdbc.JDBCCall;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.access.query.SqlQueryBuilder;
/*     */ import dtv.data2.access.query.SqlQueryRequest;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.net.InetAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractJDBCPersistenceStrategy
/*     */   extends AbstractPersistenceStrategy
/*     */   implements IJDBCPersistenceStrategy
/*     */ {
/*  37 */   private static final Logger _logger = Logger.getLogger(AbstractJDBCPersistenceStrategy.class);
/*  38 */   private static final IDataSourceComparator _defaultDataSourceComparator = new DefaultDataSourceComparator();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equivalentDataSources(IPersistenceStrategy argOther) {
/*  64 */     boolean sameDataSources = false;
/*     */     
/*  66 */     if (argOther instanceof IJDBCPersistenceStrategy)
/*     */     {
/*  68 */       sameDataSources = getDataSourceComparator().equivalentDataSources(this, (IJDBCPersistenceStrategy)argOther);
/*     */     }
/*  70 */     return sameDataSources;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConnectionUrl() {
/*  76 */     return getProperties().getProperty("ConnectionURL");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<JDBCCall> getJDBCCallData(IPersistable argPersistable) {
/*  82 */     if (argPersistable == null) {
/*  83 */       throw new DtxException("getJDBCCallData cannot be called with a null argPersistable - Illegal call");
/*     */     }
/*     */ 
/*     */     
/*  87 */     if (argPersistable instanceof IDataAccessObject) {
/*  88 */       return getJDBCCallDataForDao((IDataAccessObject)argPersistable);
/*     */     }
/*  90 */     if (argPersistable instanceof QueryRequest) {
/*  91 */       return getJDBCCallDataForQueryRequest((QueryRequest)argPersistable);
/*     */     }
/*  93 */     if (argPersistable instanceof SqlQueryRequest) {
/*  94 */       return getJDBCCallDataForSqlQueryRequest((SqlQueryRequest)argPersistable);
/*     */     }
/*     */     
/*  97 */     throw new DtxException("Persistable type: " + argPersistable.getClass().getName() + " is not yet supported by JDBCHelper.  Please add support if needed.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IJDBCTableAdapter getTableAdapter(Class<?> argClass) {
/* 105 */     return getTableAdapter(argClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IJDBCTableAdapter getTableAdapter(IObjectId argId) {
/* 111 */     return getTableAdapter(argId.getClass().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IJDBCTableAdapter getTableAdapter(String argIdentifier) {
/* 117 */     return JDBCAdapterMap.getTableAdapter(argIdentifier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDataSourceComparator getDataSourceComparator() {
/* 127 */     return _defaultDataSourceComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<JDBCCall> getJDBCCallDataForDao(IDataAccessObject argDAO) {
/* 138 */     if (DaoState.isClean(argDAO)) {
/* 139 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 143 */     IJDBCTableAdapter adapter = getTableAdapter(argDAO.getClass());
/*     */     
/* 145 */     adapter.fill(argDAO);
/*     */     
/* 147 */     String[] sqlStrings = null;
/* 148 */     Object[][] params = (Object[][])null;
/* 149 */     int[][] types = (int[][])null;
/*     */     
/* 151 */     int objectState = argDAO.getObjectState();
/*     */ 
/*     */     
/* 154 */     if (DaoState.INSERT_OR_UPDATE.matches(argDAO)) {
/* 155 */       if (!argDAO.isObjectStateRulesApplied()) {
/* 156 */         objectState = DaoState.UPDATED.intVal();
/*     */       } else {
/*     */         
/* 159 */         objectState = DaoState.NEW.intVal();
/*     */       } 
/*     */     }
/*     */     
/* 163 */     if (objectState == DaoState.NEW.intVal() || objectState == DaoState.INSERT_ONLY.intVal()) {
/* 164 */       sqlStrings = adapter.getInsert();
/* 165 */       params = adapter.getInsertParameters();
/* 166 */       types = adapter.getInsertParameterTypes();
/*     */     }
/* 168 */     else if (objectState == DaoState.DELETED.intVal()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       String[] adapterDeleteStatements = adapter.getDelete();
/* 174 */       String[] deleteStatements = new String[adapterDeleteStatements.length];
/* 175 */       Object[][] deleteParams = new Object[deleteStatements.length][(adapter.getWhereParameters()).length];
/* 176 */       int[][] deleteTypes = new int[deleteStatements.length][(adapter.getWhereParameters()).length];
/* 177 */       Object[] whereParams = adapter.getWhereParameters();
/* 178 */       int[] whereParamTypes = adapter.getWhereParameterTypes();
/*     */       
/* 180 */       for (int i = 0; i < deleteStatements.length; i++) {
/* 181 */         deleteStatements[i] = adapterDeleteStatements[i] + adapter.getWhere();
/* 182 */         deleteParams[i] = whereParams;
/* 183 */         deleteTypes[i] = whereParamTypes;
/*     */       } 
/* 185 */       sqlStrings = deleteStatements;
/* 186 */       params = deleteParams;
/* 187 */       types = deleteTypes;
/*     */     }
/* 189 */     else if (objectState == DaoState.UPDATED.intVal()) {
/*     */ 
/*     */       
/* 192 */       if (argDAO instanceof IHasIncrementalValues && 
/* 193 */         !((IHasIncrementalValues)argDAO).getIncrementalActive())
/*     */       {
/* 195 */         ((IHasIncrementalValues)adapter).setIncrementalActive(false);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 201 */       String[] adapterUpdateStatements = adapter.getUpdate();
/* 202 */       String[] updateStatements = new String[adapterUpdateStatements.length];
/* 203 */       Object[][] adapterParams = adapter.getUpdateParameters();
/* 204 */       Object[][] updateParams = new Object[adapterParams.length][];
/* 205 */       int[][] adapterParamTypes = adapter.getUpdateParameterTypes();
/* 206 */       int[][] updateParamTypes = new int[adapterParamTypes.length][];
/* 207 */       Object[] whereParams = adapter.getWhereParameters();
/* 208 */       int[] whereParamTypes = adapter.getWhereParameterTypes();
/*     */       
/* 210 */       for (int i = 0; i < updateStatements.length; i++) {
/* 211 */         updateStatements[i] = adapterUpdateStatements[i] + adapter.getWhere();
/* 212 */         updateParams[i] = ArrayUtils.combine(adapterParams[i], whereParams);
/* 213 */         updateParamTypes[i] = ArrayUtils.combine(adapterParamTypes[i], whereParamTypes);
/*     */       } 
/* 215 */       sqlStrings = updateStatements;
/* 216 */       params = updateParams;
/* 217 */       types = updateParamTypes;
/*     */     } else {
/*     */       
/* 220 */       throw new DtxException("dao " + argDAO.getClass().getName() + " was passed in with state UNDEFINED.  This is invalid for makePersistent(). This condition usually results from a model that was explicitely instantiated rather than created with DataFactory.createObject() (as it should be)");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     List<JDBCCall> jdbcCalls = new ArrayList<>(4);
/*     */     
/* 230 */     for (int ii = 0; ii < sqlStrings.length; ii++) {
/* 231 */       JDBCCall call = new JDBCCall();
/* 232 */       call.setSqlString(sqlStrings[ii]);
/* 233 */       call.setParams(Arrays.asList(params[ii]));
/*     */       
/* 235 */       List<Integer> typesList = new ArrayList<>((types[ii]).length); int arrayOfInt[], i; byte b;
/* 236 */       for (arrayOfInt = types[ii], i = arrayOfInt.length, b = 0; b < i; ) { Integer type = Integer.valueOf(arrayOfInt[b]);
/* 237 */         typesList.add(type); b++; }
/*     */       
/* 239 */       call.setTypes(typesList);
/* 240 */       jdbcCalls.add(call);
/*     */     } 
/*     */     
/* 243 */     return jdbcCalls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<JDBCCall> getJDBCCallDataForQueryRequest(QueryRequest argQueryRequest) {
/* 254 */     QueryRequest query = argQueryRequest;
/* 255 */     JDBCCall jdbcCall = new JDBCCall();
/*     */     
/* 257 */     if (query.getQueryKey() != null) {
/* 258 */       QueryDescriptor queryDescriptor = DataFactory.getInstance().getQueryDescriptor(query.getQueryKey());
/* 259 */       String baseSqlStatement = queryDescriptor.getProperties().getProperty("SQL");
/*     */ 
/*     */       
/* 262 */       jdbcCall = SqlQueryBuilder.getJDBCCall(this, baseSqlStatement, queryDescriptor.getProperties(), query
/* 263 */           .getParams());
/*     */     } else {
/*     */       
/* 266 */       throw new DtxException("A QueryRequest was passed that doesn't define a query key. [" + query + "]");
/*     */     } 
/*     */ 
/*     */     
/* 270 */     List<JDBCCall> list = new ArrayList<>(1);
/* 271 */     list.add(jdbcCall);
/* 272 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<JDBCCall> getJDBCCallDataForSqlQueryRequest(SqlQueryRequest argQueryRequest) {
/* 282 */     SqlQueryRequest query = argQueryRequest;
/* 283 */     JDBCCall jdbcCall = new JDBCCall();
/*     */     
/* 285 */     jdbcCall.setSqlString(query.getSqlStatement());
/*     */     
/* 287 */     if (query.getParams() != null) {
/* 288 */       List<Object> params = query.getParams();
/*     */       
/* 290 */       jdbcCall.setParams(params);
/* 291 */       jdbcCall.setTypes(JDBCHelper.getJDBCTypesForList(params));
/*     */     } 
/* 293 */     List<JDBCCall> list = new ArrayList<>(1);
/* 294 */     list.add(jdbcCall);
/* 295 */     return list;
/*     */   }
/*     */   
/*     */   protected static interface IDataSourceComparator
/*     */   {
/*     */     boolean equivalentDataSources(IJDBCPersistenceStrategy param1IJDBCPersistenceStrategy1, IJDBCPersistenceStrategy param1IJDBCPersistenceStrategy2);
/*     */   }
/*     */   
/*     */   protected static class DefaultDataSourceComparator
/*     */     implements IDataSourceComparator {
/*     */     private static final String LOCAL_HOST = "localhost";
/* 306 */     private static Pattern _localHostIpPattern = null;
/* 307 */     private static Pattern _localHostNamePattern = null;
/*     */     
/*     */     static {
/*     */       try {
/* 311 */         InetAddress localHost = InetAddress.getLocalHost();
/* 312 */         _localHostIpPattern = Pattern.compile(localHost.getHostAddress(), 2);
/* 313 */         _localHostNamePattern = Pattern.compile(localHost.getHostName(), 2);
/*     */       }
/* 315 */       catch (Exception ex) {
/* 316 */         AbstractJDBCPersistenceStrategy._logger.warn("Could not determine IP address/name of local host!: " + ex);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equivalentDataSources(IJDBCPersistenceStrategy argPS1, IJDBCPersistenceStrategy argPS2) {
/* 324 */       String dbUrl = StringUtils.pack(StringUtils.nonNull(argPS1.getConnectionUrl()));
/* 325 */       String otherDbUrl = StringUtils.pack(StringUtils.nonNull(argPS2.getConnectionUrl()));
/*     */ 
/*     */       
/* 328 */       dbUrl = normalizeLocalHost(dbUrl);
/* 329 */       otherDbUrl = normalizeLocalHost(otherDbUrl);
/*     */ 
/*     */       
/* 332 */       boolean sameDataSources = dbUrl.equalsIgnoreCase(otherDbUrl);
/* 333 */       if (sameDataSources)
/*     */       {
/*     */ 
/*     */         
/* 337 */         if (argPS1 instanceof AbstractJDBCPersistenceStrategy && argPS2 instanceof AbstractJDBCPersistenceStrategy) {
/*     */ 
/*     */           
/* 340 */           String ps1User = ((AbstractJDBCPersistenceStrategy)argPS1).getProperties().getProperty("ConnectionUserName");
/* 341 */           String ps2User = ((AbstractJDBCPersistenceStrategy)argPS2).getProperties().getProperty("ConnectionUserName");
/*     */           
/* 343 */           sameDataSources = StringUtils.equalsIgnoreCase(ps1User, ps2User);
/*     */         } 
/*     */       }
/* 346 */       return sameDataSources;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String normalizeLocalHost(String argDbUrl) {
/* 358 */       String dbUrl = argDbUrl;
/*     */       
/* 360 */       if (_localHostIpPattern != null) {
/* 361 */         dbUrl = _localHostIpPattern.matcher(dbUrl).replaceAll("localhost");
/*     */       }
/* 363 */       if (_localHostNamePattern != null) {
/* 364 */         dbUrl = _localHostNamePattern.matcher(dbUrl).replaceAll("localhost");
/*     */       }
/* 366 */       return dbUrl;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractJDBCPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */