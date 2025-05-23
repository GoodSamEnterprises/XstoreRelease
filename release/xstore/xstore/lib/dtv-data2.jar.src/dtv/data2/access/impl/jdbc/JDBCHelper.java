/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import dtv.data2.SQLExceptionScrubber;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Clob;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JDBCHelper
/*     */ {
/*     */   private static final String QUOTE = "'";
/*  26 */   private static final Logger logger_ = Logger.getLogger(JDBCHelper.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static JDBCHelper instance_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static final String[] WANRINGS_TO_IGNORE = new String[] { "truncate nanosecond values", "No row was found for FETCH, UPDATE or DELETE; or the result of a query is an empty table." };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  49 */     String className = System.getProperty(JDBCHelper.class.getName(), "dtv.data2.access.impl.jdbc.JDBCHelper");
/*     */     
/*     */     try {
/*  52 */       instance_ = (JDBCHelper)Class.forName(className).newInstance();
/*     */     }
/*  54 */     catch (Exception ex) {
/*  55 */       throw new DtxException("Unable to load JDBCHelper implementation: [" + className + "] controlled by system property: " + JDBCHelper.class
/*  56 */           .getName(), ex);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void assignParameters(PreparedStatement argStatement, List<Object> argParams, List<Integer> argParamTypes) throws SQLException {
/*  73 */     if (argParams != null) {
/*     */ 
/*     */ 
/*     */       
/*  77 */       if (argParamTypes == null) {
/*  78 */         throw new DtxException("Invalid call made to assignParameters - argParamTypes must be supplied when argParams is non null, -- argParamTypes is null. argParams value: " + argParams);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  83 */       if (argParams.size() != argParamTypes.size()) {
/*  84 */         throw new DtxException("Invalid call made to assignParameters - the length of argParams (length=" + argParams
/*  85 */             .size() + ") must equal the length of of argParamTypes (length=" + argParamTypes
/*  86 */             .size() + ") argParams value: " + argParams + " argParamTypes value: " + argParamTypes);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  94 */       int counter = 0;
/*  95 */       for (Object param : argParams) {
/*  96 */         int type = ((Integer)argParamTypes.get(counter)).intValue();
/*  97 */         if (param == null) {
/*     */           try {
/*  99 */             argStatement.setNull(counter + 1, ((Integer)argParamTypes.get(counter)).intValue());
/*     */           }
/* 101 */           catch (SQLException ee) {
/* 102 */             if (type == 2005) {
/* 103 */               argStatement.setNull(counter + 1, -1);
/*     */             } else {
/*     */               
/* 106 */               throw ee;
/*     */             }
/*     */           
/*     */           }
/*     */         
/* 111 */         } else if (12 == type) {
/* 112 */           argStatement.setString(counter + 1, param.toString());
/*     */         }
/* 114 */         else if (4 == type) {
/* 115 */           argStatement.setInt(counter + 1, ((Integer)param).intValue());
/*     */         }
/* 117 */         else if (-5 == type) {
/* 118 */           argStatement.setLong(counter + 1, ((Long)param).longValue());
/*     */         }
/* 120 */         else if (-7 == type || 16 == type) {
/* 121 */           argStatement.setBoolean(counter + 1, ((Boolean)param).booleanValue());
/*     */         }
/* 123 */         else if (3 == type) {
/* 124 */           argStatement.setBigDecimal(counter + 1, (BigDecimal)param);
/*     */         }
/* 126 */         else if (param instanceof Timestamp) {
/* 127 */           argStatement.setTimestamp(counter + 1, (Timestamp)param);
/*     */         } else {
/*     */           
/* 130 */           argStatement.setObject(counter + 1, param);
/*     */         } 
/*     */         
/* 133 */         counter++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String clobToString(Clob argClob) throws SQLException {
/* 141 */     if (argClob == null) {
/* 142 */       return null;
/*     */     }
/* 144 */     int WARNING_THESHOLD_100_MB = 100000000;
/*     */     
/* 146 */     long size = argClob.length();
/*     */     
/* 148 */     if (size > 2147483647L) {
/* 149 */       throw new DtxException("A HUGE Clob of length [" + size + "] was detected. clobToString() is not designed to handle such a large object and would certainly run the JVM out of memory if it were to try... First 50 bytes of the value: [" + argClob
/*     */ 
/*     */           
/* 152 */           .getSubString(1L, 50) + "]");
/*     */     }
/*     */     
/* 155 */     if (size > 100000000L) {
/* 156 */       logger_.warn("Very large clob object detected of length: [" + size + "] Processing this object may run the JVM out of memory.");
/*     */     }
/*     */     
/* 159 */     return argClob.getSubString(1L, (int)size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String clobToString(ResultSet argResultSet, int argPosition) throws SQLException {
/* 165 */     String stringResult = argResultSet.getString(argPosition);
/* 166 */     if (stringResult != null) {
/* 167 */       return stringResult;
/*     */     }
/* 169 */     Object objectValue = argResultSet.getObject(argPosition);
/*     */     
/* 171 */     if (objectValue == null) {
/* 172 */       return null;
/*     */     }
/* 174 */     if (objectValue instanceof Clob) {
/* 175 */       return clobToString((Clob)objectValue);
/*     */     }
/* 177 */     if (objectValue instanceof String) {
/* 178 */       return objectValue.toString();
/*     */     }
/*     */     
/* 181 */     throw new DtxException("Unknown object type returned for CLOB field: [" + 
/* 182 */         ObjectUtils.getClassNameFromObject(objectValue) + "] value: [" + objectValue + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JDBCHelper getInstance() {
/* 191 */     return instance_;
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
/*     */   public static int getJDBCTypeForObject(Object theObject) {
/* 203 */     if (theObject == null) {
/* 204 */       return 0;
/*     */     }
/* 206 */     if (theObject instanceof Short || theObject instanceof Integer) {
/* 207 */       return 4;
/*     */     }
/* 209 */     if (theObject instanceof Double || theObject instanceof Float || theObject instanceof BigDecimal) {
/* 210 */       return 3;
/*     */     }
/* 212 */     if (theObject instanceof Long) {
/* 213 */       return -5;
/*     */     }
/* 215 */     if (theObject instanceof java.util.Date) {
/* 216 */       return 93;
/*     */     }
/* 218 */     if (theObject instanceof Boolean) {
/* 219 */       return -7;
/*     */     }
/* 221 */     if (theObject instanceof Byte) {
/* 222 */       return -2;
/*     */     }
/*     */     
/* 225 */     return 12;
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
/*     */   public static int getJDBCTypeForTypeName(String argTypeName) {
/* 238 */     if (argTypeName == null) {
/* 239 */       return 0;
/*     */     }
/* 241 */     if (argTypeName.equals("String")) {
/* 242 */       return 12;
/*     */     }
/* 244 */     if (argTypeName.equals("Short") || argTypeName.equals("Integer")) {
/* 245 */       return 4;
/*     */     }
/* 247 */     if (argTypeName.equals("Double") || argTypeName.equals("Float") || argTypeName.equals("BigDecimal")) {
/* 248 */       return 3;
/*     */     }
/* 250 */     if (argTypeName.equals("Long")) {
/* 251 */       return -5;
/*     */     }
/* 253 */     if (argTypeName.equals("Date")) {
/* 254 */       return 93;
/*     */     }
/* 256 */     if (argTypeName.equals("Boolean")) {
/* 257 */       return -7;
/*     */     }
/* 259 */     if (argTypeName.equals("Byte")) {
/* 260 */       return -2;
/*     */     }
/*     */     
/* 263 */     return 12;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<Integer> getJDBCTypesForList(List<Object> argParams) {
/* 268 */     if (argParams == null) {
/* 269 */       return null;
/*     */     }
/* 271 */     List<Integer> types = new ArrayList<>(argParams.size());
/*     */     
/* 273 */     for (Object oo : argParams) {
/* 274 */       types.add(Integer.valueOf(getJDBCTypeForObject(oo)));
/*     */     }
/* 276 */     return types;
/*     */   }
/*     */   
/*     */   public static boolean handleWarnings(String argSql, SQLWarning argWarning) {
/* 280 */     SQLWarning warning = argWarning;
/* 281 */     boolean hasWarnings = false;
/*     */     
/* 283 */     while (warning != null) {
/* 284 */       hasWarnings = true;
/*     */ 
/*     */       
/* 287 */       String msg = warning.getMessage();
/* 288 */       boolean ignore = false;
/*     */       
/* 290 */       for (String element : WANRINGS_TO_IGNORE) {
/* 291 */         if (msg.indexOf(element) != -1) {
/* 292 */           ignore = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 297 */       if (!ignore) {
/* 298 */         logger_.warn("A jdbc warning was generated while executing sql: " + argSql, warning);
/*     */       }
/* 300 */       warning = warning.getNextWarning();
/*     */     } 
/* 302 */     return hasWarnings;
/*     */   }
/*     */   
/*     */   public static void logSqlException(String argMessage, SQLException argException) {
/* 306 */     logger_.error("SQL EXCEPTION", SQLExceptionScrubber.scrub(argException));
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
/*     */   
/*     */   public static String toParameterString(String argValue) {
/* 320 */     if (argValue == null) {
/* 321 */       return argValue;
/*     */     }
/* 323 */     StringBuilder buff = new StringBuilder(argValue.length() + 2);
/* 324 */     buff.append("'").append(argValue.replace("'", "''")).append("'");
/*     */     
/* 326 */     return buff.toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */