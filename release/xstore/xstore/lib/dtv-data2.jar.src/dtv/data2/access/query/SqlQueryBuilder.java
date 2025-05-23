/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.PersistenceConstants;
/*     */ import dtv.data2.access.impl.jdbc.JDBCCall;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SqlQueryBuilder
/*     */ {
/*     */   public static final String DIRECT_REPLACEMENT_VAR_PREFIX = "$";
/*  29 */   private static final Logger logger_ = Logger.getLogger(SqlQueryBuilder.class);
/*     */ 
/*     */   
/*     */   private static final String DISABLE_CASE_HANDLING = "DisableCaseHandling";
/*     */   
/*     */   private static final String COMMA = ",\\s*";
/*     */   
/*     */   private static final String DB_WILDCARD = "%";
/*     */   
/*     */   private static final String SPACE = " ";
/*     */   
/*     */   private static final String DB_VARPREFIX = "@";
/*     */   
/*     */   private static final String DB_ESCVAR = "@@";
/*     */ 
/*     */   
/*     */   public static final String buildBaseQuery(Properties argProperties, Map<String, Object> argParams, int argQueryCount) {
/*  46 */     StringBuilder baseQuery = new StringBuilder(6144);
/*     */ 
/*     */     
/*  49 */     for (int i = 1; i <= argQueryCount; i++) {
/*     */       
/*  51 */       String identifier = "SQL" + i;
/*  52 */       String queryElement = argProperties.getProperty(identifier);
/*     */       
/*  54 */       if (isRequired(identifier, argProperties) || 
/*  55 */         isParametersPresent(argProperties.getProperty("Parameters" + i), argParams)) {
/*  56 */         if (!StringUtils.isEmpty(queryElement)) {
/*  57 */           baseQuery.append(queryElement).append(" ");
/*     */         }
/*     */         
/*  60 */         String optionalWhereClause = buildOptionalWhere(argProperties, argParams, i);
/*     */         
/*  62 */         if (!StringUtils.isEmpty(optionalWhereClause)) {
/*  63 */           if (baseQuery.length() > 0 && 
/*  64 */             "".equals(argProperties.getProperty("QueryType", ""))) {
/*  65 */             baseQuery.append(" AND ");
/*     */           }
/*     */ 
/*     */           
/*  69 */           baseQuery.append(optionalWhereClause);
/*     */         } 
/*     */       } else {
/*     */         
/*  73 */         logger_.debug("Missing required parameters for [" + identifier + "], ignoring.");
/*     */       } 
/*     */     } 
/*  76 */     return baseQuery.toString();
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
/*     */   public static final String buildOptionalWhere(Properties argProperties, Map<String, Object> argParams, int argQueryCount) {
/*  90 */     StringBuilder where = new StringBuilder();
/*  91 */     StringBuilder sbTemp = new StringBuilder();
/*  92 */     Set<String> keys = argParams.keySet();
/*     */     
/*  94 */     if (keys != null && !keys.isEmpty()) {
/*     */ 
/*     */       
/*  97 */       for (String key : keys) {
/*  98 */         sbTemp.setLength(0);
/*  99 */         String identifier = "SQL.";
/*     */         
/* 101 */         if (argQueryCount > 0) {
/* 102 */           identifier = "SQL" + argQueryCount + ".";
/*     */         }
/*     */         
/* 105 */         sbTemp.append(identifier).append(key);
/* 106 */         String tempWhere = argProperties.getProperty(sbTemp.toString());
/*     */         
/* 108 */         if (tempWhere == null || tempWhere.length() < 1) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 113 */         if ("Procedure".equals(argProperties.getProperty("QueryType", ""))) {
/* 114 */           where.append(" " + tempWhere + " ");
/*     */           continue;
/*     */         } 
/* 117 */         where.append(" (").append(tempWhere).append(") AND");
/*     */       } 
/*     */ 
/*     */       
/* 121 */       if (where.length() > 1 && 
/* 122 */         "".equals(argProperties.getProperty("QueryType", ""))) {
/* 123 */         where.delete(where.length() - 3, where.length());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 128 */     return where.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String cleanSqlString(String argSql) {
/* 150 */     if (argSql == null) {
/* 151 */       return argSql;
/*     */     }
/*     */     
/* 154 */     String cleanedSql = StringUtils.removeLineFeeds(argSql, " ");
/* 155 */     cleanedSql = StringUtils.replaceAll(new StringBuilder(cleanedSql), "\t", " ").toString();
/* 156 */     return cleanedSql;
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
/*     */   
/*     */   public static final JDBCCall getJDBCCall(IPersistenceStrategy argStrategy, String argBaseSqlString, Properties argProperties, Map<String, Object> argParams) {
/* 173 */     StringBuilder sql = new StringBuilder(1024);
/* 174 */     List<String> paramNames = getParameterNames(argProperties, argParams);
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (!StringUtils.isEmpty(argBaseSqlString)) {
/* 179 */       sql.append(argBaseSqlString);
/*     */     }
/*     */ 
/*     */     
/* 183 */     String optionalWhereClause = buildOptionalWhere(argProperties, argParams, 0);
/*     */     
/* 185 */     if (!StringUtils.isEmpty(optionalWhereClause)) {
/* 186 */       if (sql.length() > 0) {
/* 187 */         sql.append(" AND ");
/*     */       }
/* 189 */       sql.append(optionalWhereClause);
/*     */     } 
/*     */ 
/*     */     
/* 193 */     String suffixString = argProperties.getProperty("Suffix");
/*     */     
/* 195 */     if (!StringUtils.isEmpty(suffixString)) {
/* 196 */       sql.append(' ').append(suffixString);
/*     */     }
/*     */ 
/*     */     
/* 200 */     if (argProperties.getProperty("Constant.Suffix") != null) {
/* 201 */       String constantSuffix = argProperties.getProperty("Constant.Suffix");
/* 202 */       String parameterSuffix = argProperties.getProperty("Parameters.Suffix");
/*     */       
/* 204 */       if (parameterSuffix.contains(",")) {
/* 205 */         String[] ps = parameterSuffix.toString().split(",\\s*");
/*     */         
/* 207 */         if (argParams.get(ps[0]) != null) {
/* 208 */           for (String element : ps) {
/* 209 */             constantSuffix = constantSuffix.replaceFirst("\\?", argParams.get(element.trim()).toString());
/* 210 */             argParams.remove(element);
/*     */           } 
/*     */         }
/*     */         
/* 214 */         if (!StringUtils.isEmpty(constantSuffix)) {
/* 215 */           sql.append(constantSuffix);
/*     */         
/*     */         }
/*     */       }
/* 219 */       else if (argParams.get(parameterSuffix) != null) {
/* 220 */         constantSuffix = constantSuffix.replaceFirst("\\?", argParams.get(parameterSuffix).toString());
/* 221 */         argParams.remove(parameterSuffix);
/*     */         
/* 223 */         if (!StringUtils.isEmpty(constantSuffix)) {
/* 224 */           sql.append(constantSuffix);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 230 */     sql.append(getCustomHaving(argProperties, argParams));
/* 231 */     sql.append(getCustomSort(argProperties, argParams));
/* 232 */     List<Object> finalizedParams = getParametersFinalized(paramNames, argProperties, argParams);
/*     */     
/* 234 */     replaceVariables(sql, (Map)argParams);
/*     */     
/* 236 */     buildInStatement(sql, finalizedParams, paramNames, argProperties);
/* 237 */     JDBCCall call = new JDBCCall();
/* 238 */     call.setSqlString(sql.toString());
/* 239 */     call.setParams(finalizedParams);
/* 240 */     call.setTypes(JDBCHelper.getJDBCTypesForList(finalizedParams));
/* 241 */     call.setParamNames(paramNames);
/* 242 */     return call;
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
/*     */   public static final JDBCCall getJDBCCall(String argBaseSqlString, Properties argProperties, Map<String, Object> argParams) {
/* 257 */     return getJDBCCall(null, argBaseSqlString, argProperties, argParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String toSqlInClauseArgs(List<String> argValues) {
/* 268 */     StringBuilder inClauseArgs = new StringBuilder();
/*     */     
/* 270 */     for (int i = 0, n = argValues.size(); i < n; i++) {
/* 271 */       inClauseArgs.append("'").append(argValues.get(i)).append("'");
/*     */       
/* 273 */       if (i < n - 1) {
/* 274 */         inClauseArgs.append(",");
/*     */       }
/*     */     } 
/* 277 */     return inClauseArgs.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getCustomHaving(Properties argProperties, Map<String, Object> argParameters) {
/* 288 */     StringBuilder str = new StringBuilder(96);
/* 289 */     int appended = 0;
/*     */     
/* 291 */     for (int i = 1;; i++) {
/* 292 */       String base = "Having" + i;
/* 293 */       String sql = argProperties.getProperty(base);
/* 294 */       String field = argProperties.getProperty(base + ".Field");
/* 295 */       String parameters = argProperties.getProperty(base + ".Parameters");
/*     */       
/* 297 */       if (field == null || sql == null || parameters == null) {
/*     */         break;
/*     */       }
/*     */       
/* 301 */       if (isParametersPresent(parameters, argParameters)) {
/* 302 */         if (appended == 0) {
/* 303 */           str.append(" HAVING ");
/*     */         }
/* 305 */         else if (appended > 0) {
/* 306 */           str.append(" AND ");
/*     */         } 
/*     */         
/* 309 */         str.append(field);
/* 310 */         str.append(" ").append(sql);
/* 311 */         appended++;
/*     */       } 
/*     */     } 
/*     */     
/* 315 */     return str.toString();
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
/*     */   protected static String getCustomSort(Properties argProperties, Map<String, Object> argParams) {
/* 329 */     StringBuilder str = new StringBuilder(96);
/* 330 */     int appended = 0;
/*     */     
/* 332 */     for (int i = 1;; i++) {
/* 333 */       String base = "Sort" + i;
/* 334 */       String field = argProperties.getProperty(base);
/*     */       
/* 336 */       if (field == null) {
/*     */         break;
/*     */       }
/*     */       
/* 340 */       String requiredString = argProperties.getProperty(base + "." + "RequiredSort");
/* 341 */       boolean isRequired = (requiredString != null) ? Boolean.valueOf(requiredString).booleanValue() : true;
/*     */       
/* 343 */       if (isRequired || argParams.containsKey(field)) {
/* 344 */         if (appended == 0) {
/* 345 */           str.append(" ORDER BY ");
/*     */         }
/* 347 */         else if (appended > 0) {
/* 348 */           str.append(", ");
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 353 */         if (argParams.containsKey(field)) {
/* 354 */           str.append(argParams.get(field));
/*     */         } else {
/*     */           
/* 357 */           str.append(field);
/*     */         } 
/*     */         
/* 360 */         String order = argProperties.getProperty(base + "." + "Order");
/*     */         
/* 362 */         if (order != null) {
/* 363 */           if (argParams.containsKey(order)) {
/* 364 */             str.append(" ").append(argParams.get(order));
/*     */           } else {
/*     */             
/* 367 */             str.append(" ").append(order);
/*     */           } 
/*     */         }
/*     */         
/* 371 */         appended++;
/*     */       } 
/*     */     } 
/*     */     
/* 375 */     return str.toString();
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
/*     */   private static void buildInStatement(StringBuilder sqlToModify, List<Object> argFinalizedParams, List<String> argParamNames, Properties argProperties) {
/* 389 */     if (argParamNames == null || argParamNames.isEmpty()) {
/*     */       return;
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
/*     */     
/* 403 */     StringTokenizer sqlTokens = new StringTokenizer(sqlToModify.toString(), "?");
/* 404 */     StringBuilder newSql = new StringBuilder(sqlToModify.length());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 414 */     if (argParamNames.size() < sqlTokens.countTokens() - 1 || argParamNames
/* 415 */       .size() > sqlTokens.countTokens()) {
/* 416 */       StringBuilder str = new StringBuilder(512);
/* 417 */       str.append("The number of parameters does not match the number of ");
/* 418 */       str.append("tokens! Number of parameters: [").append(argParamNames.size());
/* 419 */       str.append("], number of tokens: [").append(sqlTokens.countTokens());
/* 420 */       str.append("]. Parameter list: ").append(argParamNames);
/* 421 */       logger_.warn(str.toString());
/*     */     } 
/*     */     
/* 424 */     int paramNameIndex = 0;
/* 425 */     ListIterator<Object> paramIterator = argFinalizedParams.listIterator();
/* 426 */     while (paramIterator.hasNext()) {
/* 427 */       String paramName = argParamNames.get(paramNameIndex++);
/* 428 */       paramName = paramName.replaceFirst("@@", "");
/* 429 */       paramName = paramName.replaceAll("%", "");
/* 430 */       Object tValue = paramIterator.next();
/* 431 */       newSql = newSql.append(sqlTokens.nextToken());
/*     */ 
/*     */       
/* 434 */       if (paramName.startsWith("@") && !paramName.startsWith("@@")) {
/* 435 */         newSql.append('(');
/* 436 */         Collection<?> inParameters = (Collection)tValue;
/* 437 */         paramIterator.remove();
/*     */         
/* 439 */         Iterator<?> innerParameterIterator = inParameters.iterator();
/* 440 */         while (innerParameterIterator.hasNext()) {
/* 441 */           Object innerParam = innerParameterIterator.next();
/* 442 */           paramIterator.add(innerParam);
/* 443 */           newSql.append('?');
/*     */           
/* 445 */           if (innerParameterIterator.hasNext()) {
/* 446 */             newSql.append(", ");
/*     */           }
/*     */         } 
/*     */         
/* 450 */         newSql.append(')');
/*     */         continue;
/*     */       } 
/* 453 */       newSql.append('?');
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 458 */     if (sqlTokens.hasMoreTokens()) {
/* 459 */       newSql.append(sqlTokens.nextToken());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 466 */     while (sqlTokens.hasMoreTokens()) {
/* 467 */       newSql.append('?').append(sqlTokens.nextToken());
/*     */     }
/*     */     
/* 470 */     sqlToModify.setLength(0);
/* 471 */     sqlToModify.append(newSql);
/*     */   }
/*     */   
/*     */   private static Object filterType(Object argValue) {
/* 475 */     if (argValue instanceof Object[]) {
/* 476 */       return ((Object[])argValue)[0];
/*     */     }
/* 478 */     if (argValue instanceof Date && !(argValue instanceof DtvDate)) {
/* 479 */       return new DtvDate(((Date)argValue).getTime());
/*     */     }
/*     */     
/* 482 */     return argValue;
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
/*     */   private static final List<String> getParameterNames(Properties argProperties, Map<String, Object> argParams) {
/* 497 */     StringBuilder parameterNameList = new StringBuilder(128);
/* 498 */     StringBuilder parameterKey = new StringBuilder(32);
/* 499 */     int queryCount = Integer.parseInt(argProperties.getProperty("QueryCount", "0"));
/* 500 */     Set<String> keys = argParams.keySet();
/*     */ 
/*     */     
/* 503 */     if (queryCount == 0) {
/*     */       
/* 505 */       String requiredParameterList = argProperties.getProperty("Parameters");
/*     */       
/* 507 */       if (!StringUtils.isEmpty(requiredParameterList)) {
/* 508 */         parameterNameList.append(requiredParameterList);
/* 509 */         parameterNameList.append(", ");
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 514 */       if (keys != null && !keys.isEmpty())
/*     */       {
/*     */         
/* 517 */         for (String key : keys) {
/* 518 */           parameterKey.setLength(0);
/* 519 */           parameterKey.append("Parameters").append(".").append(key);
/* 520 */           String tempParams = argProperties.getProperty(parameterKey.toString());
/*     */           
/* 522 */           if (tempParams != null && tempParams.length() > 0) {
/* 523 */             parameterNameList.append(tempParams).append(", ");
/*     */           }
/*     */         }
/*     */       
/*     */       }
/*     */     } else {
/*     */       
/* 530 */       for (int j = 1; j <= queryCount; j++) {
/*     */         
/* 532 */         parameterKey.setLength(0);
/* 533 */         parameterKey.append("Parameters").append(j);
/*     */         
/* 535 */         String requiredParameterList = argProperties.getProperty(parameterKey.toString(), "");
/*     */ 
/*     */ 
/*     */         
/* 539 */         if (isRequired("SQL" + j, argProperties) || 
/* 540 */           isParametersPresent(argProperties.getProperty(parameterKey.toString()), argParams)) {
/*     */ 
/*     */ 
/*     */           
/* 544 */           if (!"".equals(requiredParameterList)) {
/* 545 */             parameterNameList.append(requiredParameterList);
/* 546 */             parameterNameList.append(", ");
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 551 */           if (keys != null && !keys.isEmpty()) {
/* 552 */             for (String key : keys) {
/* 553 */               parameterKey.setLength(0);
/* 554 */               parameterKey.append("Parameters").append(j).append(".").append(key);
/* 555 */               String tempParams = argProperties.getProperty(parameterKey.toString(), "");
/*     */               
/* 557 */               if (!"".equals(tempParams)) {
/* 558 */                 parameterNameList.append(tempParams).append(", ");
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 566 */     for (int i = 1;; i++) {
/* 567 */       String base = "Having" + i;
/* 568 */       String sql = argProperties.getProperty(base);
/* 569 */       String field = argProperties.getProperty(base + ".Field");
/* 570 */       String tempParams = argProperties.getProperty(base + ".Parameters");
/*     */       
/* 572 */       if (field == null || sql == null || tempParams == null) {
/*     */         break;
/*     */       }
/* 575 */       if (isParametersPresent(tempParams, argParams)) {
/* 576 */         parameterNameList.append(tempParams).append(", ");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 581 */     if (parameterNameList.length() > 1) {
/* 582 */       parameterNameList.delete(parameterNameList.length() - 2, parameterNameList.length());
/*     */     }
/*     */ 
/*     */     
/* 586 */     if (!StringUtils.isEmpty(parameterNameList.toString())) {
/* 587 */       String[] parameterNames = parameterNameList.toString().split(",\\s*");
/* 588 */       List<String> finalNames = new ArrayList<>();
/*     */       
/* 590 */       for (int ii = 0; ii < parameterNames.length; ii++) {
/*     */ 
/*     */         
/* 593 */         if (!parameterNames[ii].trim().startsWith("$")) {
/* 594 */           finalNames.add(parameterNames[ii].trim());
/*     */         }
/*     */       } 
/*     */       
/* 598 */       return finalNames;
/*     */     } 
/*     */     
/* 601 */     return null;
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
/*     */   private static final List<Object> getParametersFinalized(List<String> argParameterNames, Properties argProperties, Map<String, Object> argParams) {
/* 617 */     List<Object> parameterValues = new ArrayList();
/*     */ 
/*     */     
/* 620 */     if (argParameterNames == null || argParameterNames.size() == 0) {
/* 621 */       return new ArrayList(0);
/*     */     }
/*     */ 
/*     */     
/* 625 */     String caseMgmtDisabled = argProperties.getProperty("DisableCaseHandling");
/* 626 */     boolean disableCaseHandling = (caseMgmtDisabled == null) ? false : Boolean.parseBoolean(caseMgmtDisabled);
/*     */     
/* 628 */     for (String paramName : argParameterNames) {
/*     */ 
/*     */       
/* 631 */       boolean prefixVar = paramName.startsWith("@@");
/* 632 */       paramName = paramName.replaceFirst("@@", "");
/*     */       
/* 634 */       boolean prefixWildcard = paramName.startsWith("%");
/* 635 */       boolean postfixWildcard = paramName.endsWith("%");
/* 636 */       paramName = paramName.replaceAll("%", "");
/* 637 */       Object value = null;
/*     */ 
/*     */       
/* 640 */       if (argParams.containsKey(paramName)) {
/* 641 */         value = argParams.get(paramName);
/*     */       } else {
/*     */         
/* 644 */         throw new DtxException("Null value was detected for required query parameter: [" + paramName + "]. Query key: [" + argProperties
/* 645 */             .get("Name") + "]");
/*     */       } 
/*     */ 
/*     */       
/* 649 */       if (value instanceof String) {
/* 650 */         if (prefixVar) {
/* 651 */           value = "@@" + value;
/*     */         }
/*     */         
/* 654 */         if (prefixWildcard) {
/* 655 */           value = "%" + value;
/*     */         }
/*     */         
/* 658 */         if (postfixWildcard) {
/* 659 */           value = value + "%";
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 664 */       value = filterType(value);
/* 665 */       value = massageValue(value, disableCaseHandling);
/* 666 */       parameterValues.add(value);
/*     */     } 
/*     */     
/* 669 */     return parameterValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isParametersPresent(String argParameterList, Map<String, Object> argParameters) {
/* 680 */     if (!StringUtils.isEmpty(argParameterList)) {
/* 681 */       for (String parameter : argParameterList.split(",\\s*")) {
/* 682 */         if (!argParameters.containsKey(parameter.trim())) {
/* 683 */           return false;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 688 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isRequired(String argIdentifier, Properties argProperties) {
/* 692 */     boolean result = true;
/* 693 */     String key = argIdentifier + "." + "Required";
/* 694 */     if (argProperties.getProperty(key) != null) {
/* 695 */       result = Boolean.valueOf(argProperties.getProperty(key)).booleanValue();
/*     */     }
/*     */     
/* 698 */     return result;
/*     */   }
/*     */   
/*     */   private static Object massageValue(Object argValue, boolean argDisableCaseHandling) {
/* 702 */     if (PersistenceConstants.MANAGE_CASE && !argDisableCaseHandling) {
/* 703 */       if (argValue instanceof Collection) {
/* 704 */         Collection<?> inParameters = (Collection)argValue;
/* 705 */         if (inParameters.stream().filter(e -> e instanceof String).count() > 0L) {
/* 706 */           return inParameters.stream().map(e -> (e instanceof String) ? ((String)e).toUpperCase() : e)
/* 707 */             .collect(Collectors.toList());
/*     */         }
/*     */       }
/* 710 */       else if (argValue instanceof String) {
/* 711 */         String inParameter = (String)argValue;
/* 712 */         return inParameter.toUpperCase();
/*     */       } 
/*     */     }
/* 715 */     return argValue;
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
/*     */   private static final StringBuilder replaceVariables(StringBuilder argTarget, Map<? extends Object, ? extends Object> argVariableLookupMap) {
/* 731 */     int foundStart = argTarget.indexOf("{$");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 736 */     while (foundStart != -1) {
/* 737 */       int foundEnd = argTarget.indexOf("}", foundStart + 1);
/* 738 */       String variableName = argTarget.substring(foundStart + 1, foundEnd);
/* 739 */       String variableValue = StringUtils.nonNull(argVariableLookupMap.get(variableName));
/* 740 */       argTarget.replace(foundStart, foundEnd + 1, variableValue);
/*     */ 
/*     */       
/* 743 */       foundStart = argTarget.indexOf("{$", foundStart + 1);
/*     */     } 
/*     */     
/* 746 */     return argTarget;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\SqlQueryBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */