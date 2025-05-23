/*     */ package dtv.data2x.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2x.IDataServices;
/*     */ import dtv.data2x.impl.req.PersistResponse;
/*     */ import dtv.data2x.impl.req.QueryResponse;
/*     */ import dtv.data2x.impl.req.RetrieveResponse;
/*     */ import dtv.data2x.impl.req.UpdateResponse;
/*     */ import dtv.data2x.req.IPersistRequest;
/*     */ import dtv.data2x.req.IPersistResponse;
/*     */ import dtv.data2x.req.IQueryRequest;
/*     */ import dtv.data2x.req.IRetrieveRequest;
/*     */ import dtv.data2x.req.IUpdateRequest;
/*     */ import dtv.data2x.req.IUpdateResponse;
/*     */ import dtv.service.ServiceException;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class DataServicesImpl
/*     */   implements IDataServices
/*     */ {
/*     */   private static <T extends IDataModel> T setModelState(T argModel, boolean argDeep, int argState) {
/*  31 */     if (argDeep) {
/*     */       
/*  33 */       for (IPersistable persistable : DaoUtils.getPersistables(argModel)) {
/*  34 */         if (persistable instanceof IDataAccessObject) {
/*  35 */           ((IDataAccessObject)persistable).setObjectState(argState);
/*     */         }
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  41 */       ((IDataModelImpl)argModel).getDAO().setObjectState(argState);
/*     */     } 
/*  43 */     return argModel;
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
/*     */   public <R extends dtv.data2.access.IQueryResult, QOA extends dtv.data2x.req.IQueryResponse<R>> QOA browse(IQueryRequest<R> argRequest) {
/*     */     try {
/*  58 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(argRequest.getQueryKey(), argRequest.getQueryParams());
/*     */       
/*  60 */       return (QOA)new QueryResponse((List)iQueryResultList);
/*     */     }
/*  62 */     catch (ServiceException ex) {
/*  63 */       throw ex;
/*     */     }
/*  65 */     catch (Exception ex) {
/*  66 */       throw new ServiceException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IDataModel> T create(Class<T> argModelType) {
/*  73 */     IDataModel iDataModel = DataFactory.createObject(argModelType);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     ((IDataModelImpl)iDataModel).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
/*     */     
/*  81 */     return (T)iDataModel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IDataModel> T createClean(Class<T> argModelType) {
/*  87 */     T model = create(argModelType);
/*  88 */     return makeClean(model, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IDataModel> T createTransient(Class<T> argModelType) {
/*  94 */     return (T)DataFactory.createTransientObject(argModelType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IDataModel> T makeClean(T argModel, boolean argDeep) {
/* 100 */     return setModelState(argModel, argDeep, DaoState.CLEAN.intVal());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends IDataModel> T makeDirty(T argModel, boolean argDeep) {
/* 106 */     return setModelState(argModel, argDeep, DaoState.INSERT_OR_UPDATE.intVal());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <M extends IDataModel> M makeTransient(M argModel) {
/* 112 */     DataFactory.makeTransient(argModel);
/* 113 */     return argModel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistResponse persist(IPersistRequest<? extends IPersistable> argRequest) {
/*     */     try {
/* 120 */       DataFactory.makePersistent(argRequest.getModelsToPersist());
/* 121 */       return (IPersistResponse)new PersistResponse();
/*     */     }
/* 123 */     catch (ServiceException ex) {
/* 124 */       throw ex;
/*     */     }
/* 126 */     catch (Exception ex) {
/* 127 */       throw new ServiceException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <ROA extends dtv.data2x.req.IRetrieveResponse<?>> ROA retrieve(IRetrieveRequest<? extends IObjectId> argRequest) {
/* 135 */     IDataModel result = DataFactory.getObjectById(argRequest.getModelId());
/* 136 */     return (ROA)new RetrieveResponse(result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <R extends dtv.data2.access.IQueryResult, QOA extends dtv.data2x.req.IQueryResponse<R>> QOA search(IQueryRequest<R> argRequest) {
/*     */     try {
/* 145 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(argRequest.getQueryKey(), argRequest.getQueryParams());
/*     */       
/* 147 */       return (QOA)new QueryResponse((List)iQueryResultList);
/*     */     }
/* 149 */     catch (ServiceException ex) {
/* 150 */       throw ex;
/*     */     }
/* 152 */     catch (Exception ex) {
/* 153 */       throw new ServiceException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IUpdateResponse update(IUpdateRequest argRequest) {
/*     */     try {
/* 161 */       int updateCount = DataFactory.executeQuery(argRequest.getQueryKey(), argRequest.getQueryParams());
/* 162 */       return (IUpdateResponse)new UpdateResponse(updateCount);
/*     */     }
/* 164 */     catch (ServiceException ex) {
/* 165 */       throw ex;
/*     */     }
/* 167 */     catch (Exception ex) {
/* 168 */       throw new ServiceException(ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\DataServicesImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */