/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.IQueryResultWrapper;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.jdbc.DBConnection;
/*     */ import dtv.data2.access.impl.jdbc.JDBCDataSourceMgr;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.sql.Blob;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Clob;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SqlQueryExecutor
/*     */ {
/*  32 */   private static final Logger logger_ = Logger.getLogger(SqlQueryExecutor.class);
/*  33 */   private static final boolean _debugLogging = logger_.isDebugEnabled();
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
/*     */   public static Object execute(String argSqlStatement, List<?> argFinalizedParameters, List<String> argParamNames, Properties argProperties, String[] argResultFields, String argSourceDescription, Class<?> argResultClass, IPersistenceStrategy argStrategy, QueryToken argQueryToken) throws SQLException {
/*  57 */     if (argSqlStatement == null) {
/*  58 */       throw new DtxException("SqlQueryExecutor execute was called with a null argSqlStatement.  This is invalid.");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  63 */       String queryType = argProperties.getProperty("QueryType", "");
/*  64 */       if (queryType.equalsIgnoreCase("Procedure")) {
/*  65 */         return executeProcedure(argSqlStatement, argFinalizedParameters, argParamNames, argProperties, argResultFields, argSourceDescription, argStrategy, argQueryToken);
/*     */       }
/*     */ 
/*     */       
/*  69 */       return executeStatement(argSqlStatement, argFinalizedParameters, argParamNames, argProperties, argResultFields, argSourceDescription, argResultClass, argStrategy, argQueryToken);
/*     */ 
/*     */     
/*     */     }
/*  73 */     catch (SQLException|RuntimeException ee) {
/*  74 */       if (!FailoverException.isFailover(ee)) {
/*  75 */         logger_.error("Exception occurred while executing sql: [" + argSqlStatement + "] with parameters: " + argFinalizedParameters + " Will re-throw.", ee);
/*     */       }
/*     */       
/*  78 */       throw ee;
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
/*     */   public static int getMaxRecordValue(Properties argProperties) {
/*  91 */     int maxRows = 0;
/*  92 */     Object maxRowsObj = argProperties.get("MaxRows");
/*  93 */     if (maxRowsObj != null && maxRowsObj instanceof String) {
/*  94 */       String maxRowsString = (String)maxRowsObj;
/*  95 */       if (!StringUtils.isEmpty(maxRowsString)) {
/*     */         try {
/*  97 */           maxRows = Integer.parseInt(maxRowsString);
/*     */         }
/*  99 */         catch (NumberFormatException ex) {
/* 100 */           logger_.warn("A bad value was detected for a 'MaxRows' property for a query.  Bad Value: " + maxRowsString, ex);
/*     */           
/* 102 */           maxRows = 0;
/*     */         } 
/*     */       }
/*     */     } 
/* 106 */     return maxRows;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static IQueryResultWrapper<? extends Object> executeProcedure(String argSqlStatement, List<?> argFinalizedParameters, List<String> argParamNames, Properties argProperties, String[] argResultFields, String argSourceDescription, IPersistenceStrategy argStrategy, QueryToken argQueryToken) throws SQLException {
/* 116 */     DBConnection conn = JDBCDataSourceMgr.getInstance().getQueryConnection(argStrategy.getDataSourceName(), argQueryToken);
/* 117 */     try (CallableStatement callstmt = conn.prepareCall(argSqlStatement)) {
/*     */       
/* 119 */       boolean registerReturnValue = Boolean.valueOf(argProperties.getProperty("HasReturnValue")).booleanValue();
/*     */       
/* 121 */       int sqlIndex = registerReturnValue ? 2 : 1;
/*     */       
/* 123 */       if (argFinalizedParameters.size() != argParamNames.size()) {
/* 124 */         throw new DtxException((new StringBuilder(1024)).append("Numer of ")
/* 125 */             .append("parameters and number of parameter names do not match! ").append("Parameter count [")
/* 126 */             .append(argFinalizedParameters.size()).append("] != parameter names count [")
/* 127 */             .append(argParamNames.size()).append("] Parameters: [").append(argFinalizedParameters)
/* 128 */             .append("] Parameter names: [").append(argParamNames).append("] SQL Statement: [")
/* 129 */             .append(argSqlStatement).append("]").toString());
/*     */       }
/*     */       
/* 132 */       for (; sqlIndex <= argFinalizedParameters.size(); sqlIndex++) {
/* 133 */         callstmt.setObject(sqlIndex, argFinalizedParameters.get(sqlIndex - 1));
/*     */       }
/*     */ 
/*     */       
/* 137 */       String outParamsValue = argProperties.getProperty("OutputParameters");
/* 138 */       String[] outputParams = null;
/*     */       
/* 140 */       if (outParamsValue != null) {
/* 141 */         outputParams = outParamsValue.replace('\n', ' ').trim().split(",\\s*");
/*     */       }
/*     */       
/* 144 */       String outTypesValue = argProperties.getProperty("OutputDataTypes");
/* 145 */       String[] outputTypes = null;
/* 146 */       if (outTypesValue != null) {
/* 147 */         outputTypes = outTypesValue.replace('\n', ' ').trim().split(",\\s*");
/*     */       }
/*     */       
/* 150 */       if (outputParams != null) {
/* 151 */         for (int i = 0; i < outputParams.length; i++) {
/* 152 */           String typeName = (outputTypes.length > i) ? outputTypes[i] : "Object";
/* 153 */           callstmt.registerOutParameter(outputParams[i], JDBCHelper.getJDBCTypeForTypeName(typeName));
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       if (registerReturnValue) {
/* 160 */         callstmt.registerOutParameter(1, 4);
/*     */       }
/*     */       
/* 163 */       callstmt.execute();
/*     */       
/* 165 */       List<Object[]> resultList = new ArrayList();
/*     */ 
/*     */       
/* 168 */       int fieldCount = (registerReturnValue ? 1 : 0) + ((outputParams != null) ? outputParams.length : 0);
/* 169 */       Object[] results = new Object[fieldCount];
/* 170 */       int resultIndex = 0;
/*     */ 
/*     */       
/* 173 */       if (registerReturnValue) {
/* 174 */         results[resultIndex] = Integer.valueOf(callstmt.getInt(1));
/* 175 */         resultIndex++;
/*     */       } 
/*     */       
/* 178 */       if (outputParams != null) {
/* 179 */         for (String outputParam : outputParams) {
/* 180 */           results[resultIndex] = callstmt.getObject(outputParam);
/* 181 */           resultIndex++;
/*     */         } 
/*     */       }
/*     */       
/* 185 */       resultList.add(results);
/* 186 */       Object[][] retVal = resultList.<Object[]>toArray(new Object[resultList.size()][fieldCount]);
/*     */ 
/*     */       
/* 189 */       return new QueryResultWrapper(retVal, false, 0L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static IQueryResultWrapper<? extends Object> executeStatement(String argSqlStatement, List<?> argFinalizedParameters, List<String> argParamNames, Properties argProperties, String[] argResultFields, String argSourceDescription, Class<?> argResultClass, IPersistenceStrategy argStrategy, QueryToken argQueryToken) throws SQLException {
/* 198 */     IQueryResultWrapper<? extends Object> wrapper = null;
/*     */ 
/*     */     
/* 201 */     DBConnection conn = JDBCDataSourceMgr.getInstance().getQueryConnection(argStrategy.getDataSourceName(), argQueryToken);
/* 202 */     try (PreparedStatement statement = conn.prepareStatement(argSqlStatement)) {
/* 203 */       List<? extends Object> parameters = (List)argFinalizedParameters;
/* 204 */       int sqlIndex = 1;
/*     */       
/* 206 */       String typeString = argProperties.getProperty("DataTypes");
/* 207 */       String maxRowsString = argProperties.getProperty("MaxRows");
/*     */       
/* 209 */       int maxRows = 0;
/*     */       
/* 211 */       if (!StringUtils.isEmpty(maxRowsString)) {
/*     */         try {
/* 213 */           maxRows = Integer.parseInt(maxRowsString);
/*     */         }
/* 215 */         catch (NumberFormatException ex) {
/* 216 */           logger_.warn("A bad value was detected for a 'MaxRows' property for a query.  Bad Value: " + maxRowsString, ex);
/*     */           
/* 218 */           maxRows = 0;
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 225 */       String[] datatypes = null;
/* 226 */       if (typeString != null) {
/* 227 */         datatypes = typeString.replace('\n', ' ').trim().split(",\\s*");
/*     */       }
/*     */       
/* 230 */       for (Object value : parameters) {
/* 231 */         if (value instanceof DtvDate) {
/* 232 */           statement.setTimestamp(sqlIndex, (Timestamp)value);
/*     */         } else {
/*     */           
/* 235 */           statement.setObject(sqlIndex, value);
/*     */         } 
/* 237 */         sqlIndex++;
/*     */       } 
/*     */       
/* 240 */       if (maxRows != 0) {
/* 241 */         statement.setMaxRows(maxRows);
/*     */       }
/*     */       
/* 244 */       logger_.debug("Starting execution of prepared statement...");
/* 245 */       boolean hasResults = statement.execute();
/* 246 */       logger_.debug("Finished execution of prepared statement.");
/*     */       
/* 248 */       List<Object[]> resultList = new ArrayList();
/* 249 */       int columnCount = 0;
/*     */       
/* 251 */       if (hasResults) {
/* 252 */         try (ResultSet results = statement.getResultSet()) {
/* 253 */           ResultSetMetaData data = results.getMetaData();
/* 254 */           columnCount = data.getColumnCount();
/*     */           
/* 256 */           if (argResultFields != null && argResultFields.length > 0 && columnCount != argResultFields.length)
/*     */           {
/*     */             
/* 259 */             logger_.warn((new StringBuilder(1024)).append("A query generated a ")
/* 260 */                 .append("result with a different number of columns than what is ")
/* 261 */                 .append("specified in QueryConfig. Column Count produced: [").append(columnCount)
/* 262 */                 .append("] Columns anticipated for this ").append("query: [").append(argResultFields.length)
/* 263 */                 .append("] Query properties: [").append(argProperties).append("] Sql string executed: [")
/* 264 */                 .append(argSqlStatement).append("]").toString());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 270 */           if (datatypes == null && argResultClass != null) {
/* 271 */             QueryResultHelper.DataMapping mapping = QueryResultHelper.getInstance().getMapping(argResultClass);
/* 272 */             datatypes = new String[columnCount];
/* 273 */             for (int i = 0; i < argResultFields.length; i++) {
/* 274 */               datatypes[i] = mapping.getSetterParameterTypeAsString(argResultFields[i]);
/*     */             }
/*     */           } 
/*     */           
/* 278 */           logger_.debug("Starting conversion of database result set into two-dimension array.");
/*     */           
/* 280 */           long index = 0L;
/* 281 */           while (results.next()) {
/* 282 */             index++;
/*     */             
/* 284 */             if (_debugLogging && index % 100L == 0L) {
/* 285 */               logger_.debug("Converted [" + index + "] rows of result set into array.");
/*     */             }
/*     */             
/* 288 */             Object[] row = new Object[columnCount];
/*     */             
/* 290 */             for (int i = 1; i <= columnCount; i++) {
/*     */               String type;
/* 292 */               if (datatypes == null) {
/* 293 */                 type = null;
/*     */               } else {
/*     */                 
/* 296 */                 type = datatypes[i - 1];
/*     */               } 
/* 298 */               row[i - 1] = getValueForType(results, i, type);
/*     */             } 
/* 300 */             resultList.add(row);
/*     */           } 
/*     */         } 
/* 303 */         logger_.debug("Finished conversion of database result set into two-dimension array.");
/*     */       } else {
/*     */         
/* 306 */         columnCount = 1;
/* 307 */         resultList.add(new Object[] { Integer.valueOf(statement.getUpdateCount()) });
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 313 */       if (resultList.size() > 0) {
/* 314 */         Object[][] retVal = new Object[resultList.size()][columnCount];
/* 315 */         retVal = resultList.<Object[]>toArray(retVal);
/*     */         
/* 317 */         wrapper = new QueryResultWrapper(retVal, (maxRows == 0) ? false : ((resultList.size() >= maxRows)), maxRows);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 322 */     return wrapper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object getValueForType(ResultSet resultSet, int argIndex, String argType) throws SQLException {
/* 328 */     if ("BigDecimal".equalsIgnoreCase(argType)) {
/* 329 */       return resultSet.getBigDecimal(argIndex);
/*     */     }
/* 331 */     if ("Byte".equalsIgnoreCase(argType)) {
/* 332 */       return Byte.valueOf(resultSet.getByte(argIndex));
/*     */     }
/* 334 */     if ("Bytes".equalsIgnoreCase(argType)) {
/* 335 */       byte[] temp = resultSet.getBytes(argIndex);
/* 336 */       if (temp == null) {
/* 337 */         return null;
/*     */       }
/*     */       
/* 340 */       return temp;
/*     */     } 
/*     */     
/* 343 */     if ("Date".equalsIgnoreCase(argType) || "Timestamp".equalsIgnoreCase(argType)) {
/* 344 */       Timestamp temp = resultSet.getTimestamp(argIndex);
/* 345 */       if (temp == null) {
/* 346 */         return null;
/*     */       }
/*     */       
/* 349 */       return new DtvDate(temp.getTime());
/*     */     } 
/*     */     
/* 352 */     if ("Integer".equalsIgnoreCase(argType) || "int".equalsIgnoreCase(argType)) {
/* 353 */       return Integer.valueOf(resultSet.getInt(argIndex));
/*     */     }
/* 355 */     if ("Long".equalsIgnoreCase(argType)) {
/* 356 */       return Long.valueOf(resultSet.getLong(argIndex));
/*     */     }
/* 358 */     if ("String".equalsIgnoreCase(argType)) {
/* 359 */       return resultSet.getString(argIndex);
/*     */     }
/* 361 */     if ("Boolean".equalsIgnoreCase(argType)) {
/* 362 */       return Boolean.valueOf(resultSet.getBoolean(argIndex));
/*     */     }
/*     */     
/* 365 */     if (argType == null || "Object".equalsIgnoreCase(argType)) {
/* 366 */       if (logger_.isDebugEnabled()) {
/* 367 */         logger_.debug("Reading field of argType [" + argType + "]");
/*     */       }
/*     */     } else {
/*     */       
/* 371 */       logger_.warn("Unknown result argType [" + argType + "]");
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
/*     */     
/* 383 */     int columnType = -1;
/* 384 */     Object oo = null;
/*     */     try {
/* 386 */       ResultSetMetaData metaData = resultSet.getMetaData();
/*     */       
/* 388 */       if (metaData != null) {
/* 389 */         columnType = metaData.getColumnType(argIndex);
/* 390 */         if (columnType == 91 || columnType == 93) {
/* 391 */           Timestamp temp = resultSet.getTimestamp(argIndex);
/* 392 */           if (temp != null) {
/* 393 */             oo = new DtvDate(temp.getTime());
/*     */           }
/*     */         } else {
/*     */           
/* 397 */           oo = resultSet.getObject(argIndex);
/*     */         } 
/*     */       } else {
/*     */         
/* 401 */         oo = resultSet.getObject(argIndex);
/*     */       }
/*     */     
/* 404 */     } catch (Exception ee) {
/* 405 */       if (logger_.isDebugEnabled()) {
/* 406 */         logger_.debug("Failed to determine column type from meta data.", ee);
/*     */       }
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
/*     */     
/* 419 */     if (oo instanceof Clob) {
/* 420 */       Clob clob = (Clob)oo;
/* 421 */       oo = clob.getSubString(1L, (int)clob.length());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 428 */     else if (oo instanceof Blob) {
/* 429 */       Blob blob = (Blob)oo;
/* 430 */       oo = blob.getBytes(1L, (int)blob.length());
/*     */     } 
/*     */     
/* 433 */     return oo;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\SqlQueryExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */