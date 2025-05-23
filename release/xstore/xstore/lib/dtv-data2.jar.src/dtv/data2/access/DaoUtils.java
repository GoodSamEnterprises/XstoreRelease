/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.PersistenceException;
/*     */ import dtv.data2.access.exception.SpecialActionException;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.IDataModelRelationshipImpl;
/*     */ import dtv.data2.access.impl.IExtensibleDataAccessObjectImpl;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.EncodingHelper;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.XmlUtils;
/*     */ import dtv.util.crypto.EncString;
/*     */ import java.lang.reflect.Method;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DaoUtils
/*     */ {
/*     */   public static final String QUERY_DEBUGGER = "DtxQueryDebugger";
/*     */   private static final String RESTRICTED_CLASS = "dtv.pos.storecalendar.AbsoluteDtvDateRange";
/*  38 */   private static final Logger failedPersistenceLogger_ = Logger.getLogger("FAILED_PERSISTENCE_LOG");
/*     */ 
/*     */   
/*  41 */   private static ThreadLocal<SimpleDateFormat> DATE_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>()
/*     */     {
/*     */       protected synchronized SimpleDateFormat initialValue()
/*     */       {
/*  45 */         return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */       }
/*     */     };
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
/*     */   public static boolean anyInState(Object argObject, DaoState argState) {
/*  59 */     boolean anyFound = false;
/*     */     
/*  61 */     for (IPersistable persistable : getPersistables(argObject)) {
/*  62 */       if (persistable instanceof IDataAccessObject && 
/*  63 */         argState.matches((IDataAccessObject)persistable)) {
/*  64 */         anyFound = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  69 */     return anyFound;
/*     */   }
/*     */   
/*     */   public static IDataAccessObject cloneDao(IDataAccessObject argDaoToClone) {
/*  73 */     if (argDaoToClone == null) {
/*  74 */       throw new DtxException("cloneDao cannot accept a null argDaoToClone. Please pass a valid, non-null dao.");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  79 */       IDataAccessObject daoClone = (IDataAccessObject)argDaoToClone.clone();
/*  80 */       daoClone.setOriginDataSource(argDaoToClone.getOriginDataSource());
/*  81 */       return daoClone;
/*     */     }
/*  83 */     catch (CloneNotSupportedException ee) {
/*  84 */       throw new DtxException("Unexpected problem cloning dao [" + argDaoToClone.getClass().getName() + "] id: " + argDaoToClone
/*  85 */           .getObjectId(), ee);
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
/*     */   public static boolean contains(Collection<?> argObjs, IDataModel argDataModel) {
/*  98 */     boolean contains = false;
/*     */     
/* 100 */     if (argDataModel != null && argObjs != null) {
/* 101 */       for (Object obj : argObjs) {
/* 102 */         if (obj instanceof IDataModel && equivalent((IDataModel)obj, argDataModel)) {
/* 103 */           contains = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 108 */     return contains;
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
/*     */   public static final boolean equivalent(IDataModel argObject1, IDataModel argObject2) {
/* 121 */     if (argObject1 == argObject2) {
/* 122 */       return true;
/*     */     }
/*     */     
/* 125 */     if (argObject1 == null || argObject2 == null) {
/* 126 */       return false;
/*     */     }
/* 128 */     return argObject1.getObjectId().equals(argObject2.getObjectId());
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
/*     */   public static Collection<? extends PersistableLink> getAllPersistables(Object argObject) {
/* 142 */     return getPersistableLinks(argObject, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <D extends IDataAccessObject> D getDao(IDataModel argModel, Class<D> argDaoType) {
/* 153 */     return (argModel instanceof IDataModelImpl) ? (D)((IDataModelImpl)argModel).getDAO() : null;
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
/*     */   public static Object getFieldValueForXmlString(int argDataType, String argFieldValue) {
/* 166 */     if (argFieldValue == null || argFieldValue.equals("nul")) {
/* 167 */       return null;
/*     */     }
/* 169 */     Object result = null;
/*     */     
/* 171 */     switch (argDataType)
/*     */     { case -7:
/*     */       case 16:
/* 174 */         if (argFieldValue.equals("1")) {
/* 175 */           result = Boolean.valueOf(true);
/*     */         }
/* 177 */         else if (argFieldValue.equals("0")) {
/* 178 */           result = Boolean.valueOf(false);
/*     */         } else {
/*     */           
/* 181 */           result = Boolean.valueOf(argFieldValue);
/*     */         } 
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
/* 255 */         return result;case -6: case 4: case 5: try { result = Integer.valueOf(argFieldValue); } catch (NumberFormatException ex) { result = Long.valueOf(argFieldValue); }  return result;case -5: result = Long.valueOf(argFieldValue); return result;case 3: case 6: case 7: case 8: result = new BigDecimal(argFieldValue); return result;case 91: case 92: case 93: try { result = new DtvDate(); ((DtvDate)result).setTimeFromSerialization(Long.valueOf(argFieldValue).longValue()); } catch (NumberFormatException ee) { Date parsedDate = DateUtils.parseIso(argFieldValue); if (parsedDate == null) try { parsedDate = ((SimpleDateFormat)DATE_TIME_FORMAT.get()).parse(argFieldValue); } catch (Exception ee2) { parsedDate = DateUtils.parseDate(argFieldValue); }   if (parsedDate != null) { result = new DtvDate(parsedDate.getTime()); } else { throw new DtxException("Could not parse date string: " + argFieldValue); }  }  return result;case -4: result = EncodingHelper.decodeObject(argFieldValue, false); return result; }  result = argFieldValue; return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PersistablesPackage getPersistablePackageForXml(String argXml) {
/* 264 */     XmlPersistablesParser persistables = new XmlPersistablesParser(argXml);
/* 265 */     return persistables.getPersistablePackage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<IPersistable> getPersistables(Object argObject) {
/* 275 */     Object obj = (argObject instanceof Object[]) ? Arrays.<Object>asList((Object[])argObject) : argObject;
/*     */     
/* 277 */     LinkedHashMap<PersistableKey, IPersistable> map = new LinkedHashMap<>();
/* 278 */     getPersistablesImpl(obj, map);
/*     */ 
/*     */     
/* 281 */     List<IPersistable> list = new ArrayList<>(map.values());
/*     */     
/* 283 */     for (IPersistable persistable : list) {
/* 284 */       setDaoClassName(persistable);
/*     */     }
/* 286 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<IPersistable> getPersistablesForXml(String argXml) {
/* 295 */     return getPersistablePackageForXml(argXml).getPersistables();
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
/*     */   public static Collection<? extends PersistableLink> getRootPersistables(Object argObject) {
/* 307 */     return getPersistableLinks(argObject, false);
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
/*     */   public static IDataAccessObject getSampleDao(Object argObject) throws PersistenceException {
/* 323 */     if (argObject == null) {
/* 324 */       throw new PersistenceException("Cannot start transaction for null object!");
/*     */     }
/*     */     
/* 327 */     if (argObject instanceof IDataModelImpl) {
/* 328 */       return ((IDataModelImpl)argObject).getDAO();
/*     */     }
/* 330 */     if (argObject instanceof IDataAccessObject) {
/* 331 */       return (IDataAccessObject)argObject;
/*     */     }
/* 333 */     if (argObject instanceof Collection) {
/* 334 */       Collection<?> col = (Collection)argObject;
/* 335 */       if (col.isEmpty()) {
/* 336 */         throw new PersistenceException("Cannot retrieve models from an empty collection!");
/*     */       }
/*     */       
/* 339 */       Iterator<?> it = col.iterator();
/* 340 */       Object firstObject = null;
/* 341 */       while (it.hasNext()) {
/* 342 */         firstObject = it.next();
/* 343 */         if (!(firstObject instanceof IDataAccessObject))
/*     */         {
/* 345 */           firstObject = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 352 */       if (firstObject == null) {
/* 353 */         return null;
/*     */       }
/*     */       
/* 356 */       if (firstObject instanceof Collection) {
/* 357 */         throw new PersistenceException("Cannot start a transaction for a collection within a collection: cannot determine model class.");
/*     */       }
/*     */ 
/*     */       
/* 361 */       return getSampleDao(firstObject);
/*     */     } 
/*     */ 
/*     */     
/* 365 */     throw new PersistenceException("Cannot start a transaction for type: " + argObject
/* 366 */         .getClass().getName());
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
/*     */   public static String getXmlSafeFieldValue(int argDataType, Object argFieldValue) {
/* 379 */     String result = null;
/*     */     
/* 381 */     if (argFieldValue == null) {
/* 382 */       return "nul";
/*     */     }
/* 384 */     if (argFieldValue instanceof DtvDate) {
/* 385 */       return String.valueOf(((DtvDate)argFieldValue).getTimeSerializable());
/*     */     }
/* 387 */     if (argFieldValue instanceof Boolean) {
/* 388 */       return ((Boolean)argFieldValue).booleanValue() ? "1" : "0";
/*     */     }
/* 390 */     if (argFieldValue instanceof BigDecimal) {
/* 391 */       BigDecimal dec = ((BigDecimal)argFieldValue).stripTrailingZeros();
/* 392 */       return dec.toPlainString();
/*     */     } 
/* 394 */     if (argFieldValue instanceof Number) {
/* 395 */       return argFieldValue.toString();
/*     */     }
/*     */     
/* 398 */     if (argDataType == -4) {
/* 399 */       result = EncodingHelper.encodeObject(argFieldValue, false);
/*     */     } else {
/*     */       
/* 402 */       result = argFieldValue.toString();
/*     */     } 
/*     */     
/* 405 */     return XmlUtils.toXmlSafe(new StringBuilder(result)).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isClean(IPersistable argPersistable) {
/* 415 */     boolean clean = false;
/* 416 */     if (argPersistable instanceof IDataAccessObject) {
/* 417 */       clean = DaoState.isClean((IDataAccessObject)argPersistable);
/*     */     }
/* 419 */     else if (argPersistable instanceof IDataModelImpl) {
/* 420 */       clean = DaoState.isClean(((IDataModelImpl)argPersistable).getDAO());
/*     */     } 
/* 422 */     return clean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSetter(Method argMethod) {
/* 433 */     return (argMethod.getName().startsWith("set") && !argMethod.getName().equals("setValues"));
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
/*     */   public static boolean isTreeDirty(Object argObject) {
/* 446 */     boolean dirty = false;
/*     */     
/* 448 */     for (PersistableLink modelData : getAllPersistables(argObject)) {
/* 449 */       if (!isClean(modelData.getPersistable())) {
/* 450 */         dirty = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 454 */     return dirty;
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
/*     */   public static IObjectId loadIDFromValueMap(IObjectId argId, Map<String, String> argValues) {
/* 468 */     Method[] idMethods = argId.getClass().getMethods();
/*     */     
/* 470 */     for (Method method : idMethods) {
/* 471 */       if (isSetter(method)) {
/* 472 */         String value = argValues.get(getKeyFromSetter(method));
/*     */         try {
/* 474 */           if (value != null) {
/* 475 */             Object valueCorrectType = getValueWithCorrectType(value, method);
/* 476 */             method.invoke(argId, new Object[] { valueCorrectType });
/*     */           }
/*     */         
/* 479 */         } catch (Exception e) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 484 */     return argId;
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
/*     */   public static synchronized void logFailedPersistence(Throwable argEx, Object argObject) {
/* 497 */     failedPersistenceLogger_
/* 498 */       .error("Persistence Failed: " + SpecialActionException.getFullExceptionString(argEx));
/*     */     
/* 500 */     StringBuilder buff = new StringBuilder(1024);
/* 501 */     for (IPersistable persistable : getPersistables(argObject)) {
/*     */       
/* 503 */       if (isClean(persistable)) {
/*     */         continue;
/*     */       }
/* 506 */       buff.append(persistable.toXmlString());
/*     */     } 
/*     */     
/* 509 */     buff.insert(0, "<FailedPersistence>");
/* 510 */     buff.append("</FailedPersistence>");
/*     */     
/* 512 */     failedPersistenceLogger_.error(buff.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void massageQueryParams(Map<String, Object> argParams, Long argOrgId) {
/* 521 */     if (argParams == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 526 */     DtvDate.ensureProperDates(argParams);
/*     */     
/* 528 */     for (Map.Entry<String, Object> entry : argParams.entrySet()) {
/* 529 */       Object oo = entry.getValue();
/*     */ 
/*     */ 
/*     */       
/* 533 */       if (oo instanceof EncString) {
/* 534 */         entry.setValue(EncString.getSensitiveData(oo));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 539 */       if (oo != null && "dtv.pos.storecalendar.AbsoluteDtvDateRange".equals(oo.getClass().getName())) {
/* 540 */         throw new DtxException("Illegal query parameter detected.  Class [dtv.pos.storecalendar.AbsoluteDtvDateRange] is not allowed as a query parameter. Object: [" + oo + "] Parameters: " + argParams);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 548 */     if (!argParams.containsKey("argOrganizationId")) {
/* 549 */       argParams.put("argOrganizationId", argOrgId);
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
/*     */   public static void setDataSourceOnAll(IDataModel argModel, String argDataSource) {
/* 562 */     for (IPersistable persistable : getPersistables(argModel)) {
/* 563 */       if (persistable instanceof IDataAccessObject) {
/* 564 */         ((IDataAccessObject)persistable).setOriginDataSource(argDataSource);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void getPersistablesImpl(Object argObject, LinkedHashMap<PersistableKey, IPersistable> argPersistablesMap) {
/* 575 */     if (argObject instanceof IDataAccessObject) {
/* 576 */       IDataAccessObject dao = (IDataAccessObject)argObject;
/* 577 */       PersistableKey key = new PersistableKey(dao);
/*     */ 
/*     */ 
/*     */       
/* 581 */       argPersistablesMap.remove(key);
/*     */       
/* 583 */       argPersistablesMap.put(key, dao);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 589 */     if (argObject instanceof HistoricalList) {
/*     */ 
/*     */ 
/*     */       
/* 593 */       List<?> removedElements = ((HistoricalList)argObject).getDeletedItems();
/* 594 */       if (removedElements != null) {
/* 595 */         for (int ii = 0; ii < removedElements.size(); ii++) {
/* 596 */           IDataModelImpl deleteMe = (IDataModelImpl)removedElements.get(ii);
/* 597 */           deleteMe.getDAO().setObjectState(DaoState.DELETED.intVal());
/* 598 */           getPersistablesImpl(deleteMe, argPersistablesMap);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 604 */       Iterator<?> it = ((HistoricalList)argObject).iterator();
/*     */       
/* 606 */       while (it.hasNext()) {
/* 607 */         getPersistablesImpl(it.next(), argPersistablesMap);
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 614 */     if (argObject instanceof Collection) {
/* 615 */       Collection<?> currentCollection = (Collection)argObject;
/* 616 */       Iterator<?> it = currentCollection.iterator();
/*     */       
/* 618 */       while (it.hasNext()) {
/* 619 */         getPersistablesImpl(it.next(), argPersistablesMap);
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 626 */     if (argObject instanceof IDataModelImpl) {
/* 627 */       IDataModelImpl model = (IDataModelImpl)argObject;
/* 628 */       IDataAccessObject dao = model.getDAO();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 634 */       if (argPersistablesMap.containsKey(new PersistableKey(model))) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 640 */       argPersistablesMap.put(new PersistableKey(model), dao);
/*     */ 
/*     */       
/* 643 */       IDataModelRelationship[] rels = DataModelFactory.getModelRelationships(model.getDAO());
/*     */       
/* 645 */       if (rels != null)
/*     */       {
/* 647 */         for (IDataModelRelationship rel : rels) {
/* 648 */           IDataModelRelationshipImpl relationship = (IDataModelRelationshipImpl)rel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 654 */           if (relationship instanceof dtv.data2.access.impl.ManyToManyRelationship);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 662 */           Object relatedObject = model.getValue(relationship.getIdentifier());
/*     */           
/* 664 */           if (relatedObject != null) {
/* 665 */             if (relatedObject instanceof HistoricalList) {
/* 666 */               HistoricalList<?> historicalList = (HistoricalList)relatedObject;
/* 667 */               if (!historicalList.isEmpty() || historicalList.getDeletedItems() != null) {
/* 668 */                 getPersistablesImpl(relatedObject, argPersistablesMap);
/*     */ 
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 674 */             else if (relatedObject instanceof Collection) {
/* 675 */               if (!((Collection)relatedObject).isEmpty()) {
/* 676 */                 getPersistablesImpl(relatedObject, argPersistablesMap);
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */             else {
/*     */               
/* 683 */               getPersistablesImpl(relatedObject, argPersistablesMap);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 691 */       Set<?> deletedBag = model.getAndClearDeletedObjects();
/*     */       
/* 693 */       if (deletedBag != null && !deletedBag.isEmpty()) {
/* 694 */         getPersistablesImpl(deletedBag, argPersistablesMap);
/*     */ 
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 700 */     else if (argObject instanceof dtv.data2.access.query.QueryRequest) {
/* 701 */       argPersistablesMap.put(new PersistableKey(argObject), argObject);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 706 */     else if (argObject instanceof dtv.data2.access.query.SqlQueryRequest) {
/* 707 */       argPersistablesMap.put(new PersistableKey(argObject), argObject);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 713 */       if (argObject instanceof IRunQueryKey) {
/* 714 */         throw new DtxException("Sorry! action queries are depracted. Key " + ((IRunQueryKey)argObject)
/* 715 */             .getQueryKey().getName());
/*     */       }
/*     */       
/* 718 */       throw new DtxException("Unknown type passed to getPersistables(): " + argObject.getClass().getName());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void setDaoClassName(IPersistable argDao) {
/* 726 */     if (argDao instanceof IExtensibleDataAccessObjectImpl) {
/* 727 */       IExtensibleDataAccessObjectImpl daoExstensible = (IExtensibleDataAccessObjectImpl)argDao;
/*     */       
/* 729 */       if (StringUtils.isEmpty(daoExstensible.getImplementingClass())) {
/* 730 */         String className = daoExstensible.getClass().getName();
/* 731 */         if (!className.endsWith("DAO")) {
/* 732 */           throw new DtxException("Cannot determine proper value for class name field based on class named: " + className + ". We expect this to end in 'DAO', like ItemDAO");
/*     */         }
/*     */         
/* 735 */         daoExstensible.setClassName(className.substring(0, className.length() - 3));
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
/*     */   private static String getKeyFromSetter(Method m) {
/* 747 */     return m.getName().substring(3);
/*     */   }
/*     */   
/*     */   private static Collection<? extends PersistableLink> getPersistableLinks(Object argRoot, boolean argDeep) {
/* 751 */     Collection<PersistableLink> modelRelationships = new ArrayList<>();
/* 752 */     getPersistableLinks(argRoot, null, null, modelRelationships, argDeep);
/*     */     
/* 754 */     return modelRelationships;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void getPersistableLinks(Object argObject, IDataModelImpl argParent, String argRelationship, Collection<PersistableLink> argLinks, boolean argDeep) {
/* 762 */     if (argObject instanceof IDataModelImpl) {
/* 763 */       IDataModelImpl model = (IDataModelImpl)argObject;
/*     */       
/* 765 */       PersistableLink link = new PersistableLink((IPersistable)model, (IPersistable)argParent, argRelationship);
/* 766 */       if (!argLinks.contains(link)) {
/* 767 */         argLinks.add(link);
/*     */         
/* 769 */         if (argDeep) {
/* 770 */           IDataModelRelationship[] rels = DataModelFactory.getModelRelationships(model.getDAO());
/* 771 */           if (rels != null) {
/* 772 */             for (IDataModelRelationship relationship : rels) {
/* 773 */               String relationshipName = relationship.getIdentifier();
/* 774 */               Object relatedObjects = model.getValue(relationshipName);
/*     */               
/* 776 */               getPersistableLinks(relatedObjects, model, relationshipName, argLinks, argDeep);
/*     */             }
/*     */           
/*     */           }
/*     */         } 
/*     */       } 
/* 782 */     } else if (argObject instanceof IPersistable) {
/*     */ 
/*     */ 
/*     */       
/* 786 */       PersistableLink link = new PersistableLink((IPersistable)argObject);
/* 787 */       if (!argLinks.contains(link)) {
/* 788 */         argLinks.add(link);
/*     */       }
/*     */     }
/* 791 */     else if (argObject instanceof HistoricalList) {
/* 792 */       HistoricalList<?> objects = (HistoricalList)argObject;
/* 793 */       if (!objects.isEmpty() || objects.getDeletedItems() != null) {
/* 794 */         for (Object entry : objects) {
/* 795 */           getPersistableLinks(entry, argParent, argRelationship, argLinks, argDeep);
/*     */         }
/*     */       }
/*     */     }
/* 799 */     else if (argObject instanceof Collection) {
/* 800 */       for (Object entry : argObject) {
/* 801 */         getPersistableLinks(entry, argParent, argRelationship, argLinks, argDeep);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object getValueWithCorrectType(String value, Method method) throws Exception {
/* 819 */     Class<?>[] paramTypes = method.getParameterTypes();
/* 820 */     if (paramTypes.length == 0 || paramTypes.length > 1) {
/* 821 */       throw new Exception("Method: " + method.getName() + " does not appear to be a setter");
/*     */     }
/* 823 */     Class<?> paramType = paramTypes[0];
/* 824 */     int jdbcType = JDBCHelper.getJDBCTypeForTypeName(paramType.getSimpleName());
/*     */     
/* 826 */     return getFieldValueForXmlString(jdbcType, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PersistableLink
/*     */   {
/*     */     private final IPersistable _persistable;
/*     */ 
/*     */ 
/*     */     
/*     */     private final IPersistable _parent;
/*     */ 
/*     */ 
/*     */     
/*     */     private final String _relationship;
/*     */ 
/*     */ 
/*     */     
/*     */     PersistableLink(IPersistable argPersistable) {
/* 847 */       this(argPersistable, null, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     PersistableLink(IPersistable argPersistable, IPersistable argParent, String argRelationship) {
/* 853 */       this._persistable = argPersistable;
/* 854 */       this._parent = argParent;
/* 855 */       this._relationship = argRelationship;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object argObj) {
/* 861 */       if (argObj == this) {
/* 862 */         return true;
/*     */       }
/* 864 */       if (!(argObj instanceof PersistableLink)) {
/* 865 */         return false;
/*     */       }
/* 867 */       PersistableLink other = (PersistableLink)argObj;
/* 868 */       return (new EqualsBuilder()).append(this._persistable, other._persistable).append(this._parent, other._parent)
/* 869 */         .append(this._relationship, other._relationship).isEquals();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IPersistable getParent() {
/* 878 */       return this._parent;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IPersistable getPersistable() {
/* 886 */       return this._persistable;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getRelationship() {
/* 896 */       return this._relationship;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 902 */       return (new HashCodeBuilder(17, 37)).append(this._persistable).append(this._parent).append(this._relationship)
/* 903 */         .toHashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 909 */       return this._parent + " -> " + this._persistable + " [" + this._relationship + "]";
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
/*     */   private static class PersistableKey
/*     */   {
/* 922 */     private IObjectId id_ = null;
/* 923 */     private int objectState_ = DaoState.UNDEFINED.intVal();
/* 924 */     private String queryIdentifier_ = null;
/*     */     
/*     */     public PersistableKey(Object argObject) {
/* 927 */       if (argObject == null) {
/* 928 */         throw new DtxException("null is not an acceptable param for PersistableKey constructor.");
/*     */       }
/*     */       
/* 931 */       if (argObject instanceof IDataModelImpl) {
/* 932 */         this.id_ = ((IDataModelImpl)argObject).getObjectId();
/* 933 */         this.objectState_ = ((IDataModelImpl)argObject).getDAO().getObjectState();
/*     */       }
/* 935 */       else if (argObject instanceof IDataAccessObject) {
/* 936 */         this.id_ = ((IDataAccessObject)argObject).getObjectId();
/* 937 */         this.objectState_ = ((IDataAccessObject)argObject).getObjectState();
/*     */       }
/* 939 */       else if (argObject instanceof IPersistable) {
/* 940 */         this.queryIdentifier_ = argObject.toString();
/*     */       } else {
/*     */         
/* 943 */         throw new DtxException("Unknown object passed to constuctor of PersistableKey: [" + argObject + "]");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object argObject) {
/* 950 */       if (argObject instanceof PersistableKey) {
/* 951 */         PersistableKey other = (PersistableKey)argObject;
/*     */         
/* 953 */         if (((this.id_ == null && other.id_ == null) || (this.id_ != null && this.id_.equals(other.id_))) && 
/* 954 */           this.objectState_ == other.objectState_ && ((
/* 955 */           this.queryIdentifier_ == null && other.queryIdentifier_ == null) || (this.queryIdentifier_ != null && this.queryIdentifier_
/* 956 */           .equals(other.queryIdentifier_)))) {
/* 957 */           return true;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 962 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 968 */       int hash = ((this.id_ == null) ? 0 : this.id_.hashCode()) + this.objectState_ + ((this.queryIdentifier_ == null) ? 0 : this.queryIdentifier_.hashCode());
/*     */       
/* 970 */       return hash;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 975 */       return getClass().getSimpleName() + "[object id: " + this.id_ + " Object state: " + this.objectState_ + " Query Id: " + this.queryIdentifier_ + "]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DaoUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */