/*     */ package dtv.data2.access.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IGenericQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Stack;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public abstract class AbstractBaseDataModelImpl implements IDataModelImpl, IGenericQueryResult {
/*  28 */   protected static final Logger _logger = Logger.getLogger(AbstractBaseDataModelImpl.class);
/*     */   
/*     */   private static final long serialVersionUID = 418385730493988677L;
/*     */   
/*     */   protected transient Eventor _events;
/*     */   
/*     */   protected transient EventHandler _eventCascade;
/*     */   
/*     */   protected IDataAccessObject _daoImpl;
/*     */   
/*     */   protected transient IDataAccessObject _daoSavepoint;
/*     */   
/*     */   private final Map<Object, Object> _genericProperties;
/*     */ 
/*     */   
/*     */   protected static IDataAccessObject getOrthogonalDAO(AbstractBaseDataModelImpl model) {
/*  44 */     return model._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   private Set<IDataModel> _deletedObjectBag = null;
/*     */   
/*     */   private boolean _rolledBack = false;
/*     */   
/*     */   protected transient IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   protected transient EventManager _eventManager;
/*     */   
/*     */   private transient boolean _postEventsForChanges = false;
/*     */ 
/*     */   
/*     */   protected AbstractBaseDataModelImpl() {
/*  66 */     initDAO();
/*  67 */     this._genericProperties = new HashMap<>();
/*  68 */     initializePostEventForChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/*  74 */     this._rolledBack = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object argKey) {
/*  80 */     return this._genericProperties.containsKey(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void externalizeToXml(StringBuilder argBuffer) {
/*  90 */     Stack<String> callStack = new Stack<>();
/*  91 */     callStack.push(getClass().getName());
/*  92 */     externalizeToXml(argBuffer, (Class)getClass(), callStack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get(Object argKey) {
/*  98 */     return this._genericProperties.get(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<IDataModel> getAndClearDeletedObjects() {
/* 104 */     Set<IDataModel> returnVal = this._deletedObjectBag;
/* 105 */     this._deletedObjectBag = null;
/* 106 */     return returnVal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject getDAO() {
/* 112 */     return this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSource() {
/* 118 */     return this._daoImpl.getOriginDataSource();
/*     */   }
/*     */   
/*     */   public IObjectId getModelId() {
/* 122 */     return getObjectId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getObjectId() {
/* 128 */     return this._daoImpl.getObjectId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getObjectIdAsString() {
/* 134 */     return (getObjectId() == null) ? null : getObjectId().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getThis() {
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) throws IllegalArgumentException {
/* 148 */     if (StringUtils.isEmpty(argFieldId)) {
/* 149 */       throw new IllegalArgumentException("getValue cannot accept NULL or empty argFieldId! Model: " + 
/* 150 */           getClass().getName());
/*     */     }
/*     */     
/* 153 */     throw new IllegalArgumentException("Model: " + 
/* 154 */         getClass().getName() + " cannot handle field: " + argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValueSafe(String argFieldId) {
/*     */     try {
/* 162 */       return getValue(argFieldId);
/*     */     }
/* 164 */     catch (Exception ex) {
/* 165 */       _logger.debug("CAUGHT EXCEPTION", ex);
/*     */       
/*     */       try {
/* 168 */         return getClass().getMethod("get" + argFieldId, new Class[0]).invoke(this, new Object[0]);
/*     */       }
/* 170 */       catch (Exception exception) {
/* 171 */         _logger.debug("CAUGHT EXCEPTION", exception);
/*     */         
/* 173 */         return null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlreadyRolledBack() {
/* 184 */     return this._rolledBack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNew() {
/* 190 */     return DaoState.isNew(this._daoImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Object> iterator() {
/* 196 */     return this._genericProperties.keySet().iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Object argKey, Object argValue) {
/* 202 */     this._genericProperties.put(argKey, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 208 */     if (this._daoSavepoint == null) {
/* 209 */       throw new DtxException("Cannot perform rollbackChanges - daoSavepoint_ is NULL.  Call startTransaction() first");
/*     */     }
/*     */     
/* 212 */     this._daoImpl = this._daoSavepoint;
/* 213 */     this._daoSavepoint = null;
/* 214 */     this._rolledBack = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDAO(IDataAccessObject argDAO) {
/* 220 */     this._daoImpl = argDAO;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSource(String argDataSource) {
/* 226 */     this._daoImpl.setOriginDataSource(argDataSource);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 232 */     this._persistenceDefaults = argPD;
/* 233 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 234 */     this._eventManager = argEM;
/* 235 */     this._events = (Eventor)new ModelEventor(this, argEM);
/* 236 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectId(IObjectId argId) {
/* 242 */     this._daoImpl.setObjectId(argId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 248 */     if (StringUtils.isEmpty(argFieldId)) {
/* 249 */       throw new IllegalArgumentException("setValue cannot accept NULL or empty argFieldId! Model: " + 
/* 250 */           getClass().getName());
/*     */     }
/*     */     
/* 253 */     throw new IllegalArgumentException("Model: " + 
/* 254 */         getClass().getName() + " cannot handle field: " + argFieldId + " value: " + argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/*     */     try {
/* 262 */       this._daoSavepoint = (IDataAccessObject)this._daoImpl.clone();
/*     */     }
/* 264 */     catch (CloneNotSupportedException ee) {
/* 265 */       throw new DtxException("An unexpected error occurred while cloning " + this._daoImpl, ee);
/*     */     } 
/*     */     
/* 268 */     if (this._daoSavepoint == null) {
/* 269 */       throw new DtxException("An unexpected error occurred while cloning " + this._daoImpl + " result object is null");
/*     */     }
/*     */     
/* 272 */     this._rolledBack = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 278 */     throw new DtxException("toXmlString is not implemented for IDataModel.  This should be implemented, though, and it should replace the externalizeToXml methods.  Also, this should not implement IPersistable in the future.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addDeletedObject(IDataModel argObjectToDelete) {
/* 284 */     if (argObjectToDelete == null) {
/* 285 */       throw new DtxException("invalid call made to addDeletedObject() -- argObjectToDelete was null.");
/*     */     }
/* 287 */     IDataAccessObject dao = ((IDataModelImpl)argObjectToDelete).getDAO();
/*     */     
/* 289 */     if (DaoState.isNew(dao)) {
/*     */       return;
/*     */     }
/*     */     
/* 293 */     if (this._deletedObjectBag == null) {
/* 294 */       this._deletedObjectBag = new HashSet<>(4);
/*     */     }
/*     */     
/* 297 */     if (!this._deletedObjectBag.contains(argObjectToDelete)) {
/* 298 */       dao.setObjectState(DaoState.DELETED.intVal());
/* 299 */       this._deletedObjectBag.add(argObjectToDelete);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> List<T> changeToList(Object unchecked, Class<T> cls) {
/* 306 */     return Collections.checkedList((List<T>)unchecked, cls);
/*     */   }
/*     */   
/*     */   protected IPersistenceDefaults getPersistenceDefaults() {
/* 310 */     return this._persistenceDefaults;
/*     */   }
/*     */   
/*     */   protected abstract void initDAO();
/*     */   
/*     */   protected boolean postEventsForChanges() {
/* 316 */     return this._postEventsForChanges;
/*     */   }
/*     */   
/*     */   protected void removeDeletedObject(IDataModelImpl argObjectToRemove) {
/* 320 */     if (argObjectToRemove == null) {
/* 321 */       throw new DtxException("invalid call made to removeDeletedObject() -- argObjectToRemove was null.");
/*     */     }
/*     */     
/* 324 */     if (this._deletedObjectBag != null) {
/* 325 */       this._deletedObjectBag.remove(argObjectToRemove);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void externalizeToXml(StringBuilder argBuffer, Class<? extends AbstractBaseDataModelImpl> argClass, Stack<String> argCallStack) {
/* 332 */     if (argClass == AbstractBaseDataModelImpl.class) {
/*     */       return;
/*     */     }
/* 335 */     String className = argClass.getName();
/*     */     
/* 337 */     argBuffer.append("<");
/* 338 */     argBuffer.append(className);
/* 339 */     argBuffer.append(">");
/*     */     
/* 341 */     Field[] fields = argClass.getDeclaredFields();
/*     */     
/* 343 */     if (fields != null) {
/* 344 */       Object value = null;
/*     */       
/* 346 */       for (Field element : fields) {
/* 347 */         element.setAccessible(true);
/*     */         
/* 349 */         argBuffer.append("<");
/*     */         
/* 351 */         argBuffer.append(element.getName());
/* 352 */         argBuffer.append(">");
/*     */         
/*     */         try {
/* 355 */           value = element.get(this);
/*     */         }
/* 357 */         catch (IllegalArgumentException e) {
/* 358 */           _logger.warn("Illegal Argument", e);
/* 359 */           value = "IllegalArgumentException";
/*     */         }
/* 361 */         catch (IllegalAccessException e) {
/* 362 */           _logger.warn("Field " + element.getName() + " is not accessible.", e);
/* 363 */           value = "IllegalAccessException";
/*     */         } 
/*     */         
/* 366 */         if (value == null) {
/* 367 */           value = "null";
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 372 */         if (value instanceof AbstractBaseDataModelImpl && 
/* 373 */           !argCallStack.contains(value.getClass().getName())) {
/* 374 */           ((AbstractBaseDataModelImpl)value).externalizeToXml(argBuffer, argCallStack);
/*     */         }
/* 376 */         else if (value instanceof AbstractDAOImpl) {
/* 377 */           argBuffer.append(((AbstractDAOImpl)value).toXmlString());
/*     */         }
/* 379 */         else if (value instanceof Collection) {
/* 380 */           int counter = 0;
/*     */ 
/*     */           
/* 383 */           for (Iterator<?> it = ((Collection)value).iterator(); it.hasNext(); ) {
/* 384 */             argBuffer.append("<");
/* 385 */             argBuffer.append("CollectionValue");
/* 386 */             argBuffer.append(counter);
/* 387 */             argBuffer.append(">");
/*     */             
/* 389 */             Object target = it.next();
/* 390 */             if (target == null) {
/* 391 */               target = "null";
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 396 */             if (target instanceof AbstractBaseDataModelImpl && 
/* 397 */               !argCallStack.contains(target.getClass().getName())) {
/* 398 */               ((AbstractBaseDataModelImpl)target).externalizeToXml(argBuffer, argCallStack);
/*     */             }
/* 400 */             if (value instanceof AbstractDAOImpl) {
/* 401 */               argBuffer.append(((AbstractDAOImpl)value).toXmlString());
/*     */             } else {
/*     */               
/* 404 */               argBuffer.append("![CDATA[");
/* 405 */               argBuffer.append(target.toString());
/* 406 */               argBuffer.append("]]");
/*     */             } 
/*     */             
/* 409 */             argBuffer.append("</");
/* 410 */             argBuffer.append("CollectionValue");
/* 411 */             argBuffer.append(counter);
/* 412 */             argBuffer.append(">");
/*     */             
/* 414 */             counter++;
/*     */           } 
/*     */         } else {
/*     */           
/* 418 */           argBuffer.append("![CDATA[");
/* 419 */           argBuffer.append(value.toString());
/* 420 */           argBuffer.append("]]");
/*     */         } 
/*     */         
/* 423 */         argBuffer.append("</");
/* 424 */         argBuffer.append(element.getName());
/* 425 */         argBuffer.append(">");
/*     */       } 
/*     */     } 
/*     */     
/* 429 */     argBuffer.append("</");
/* 430 */     argBuffer.append(className);
/* 431 */     argBuffer.append(">");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void externalizeToXml(StringBuilder argBuffer, Stack<String> argCallStack) {
/* 438 */     argCallStack.push(getClass().getName());
/* 439 */     externalizeToXml(argBuffer, (Class)getClass(), argCallStack);
/* 440 */     argCallStack.pop();
/*     */   }
/*     */   
/*     */   private void initializePostEventForChanges() {
/* 444 */     this._postEventsForChanges = Boolean.getBoolean("dtv.data2.access.DataModel.enableEventPostingForChanges");
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 449 */     argStream.defaultReadObject();
/* 450 */     initializePostEventForChanges();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractBaseDataModelImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */