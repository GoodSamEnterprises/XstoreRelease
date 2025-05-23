package dtv.data2x;

import dtv.data2x.model.IDataModelFactory;
import dtv.data2x.req.IPersistRequest;
import dtv.data2x.req.IPersistResponse;
import dtv.data2x.req.IQueryRequest;
import dtv.data2x.req.IRetrieveRequest;
import dtv.data2x.req.IUpdateRequest;
import dtv.data2x.req.IUpdateResponse;
import dtv.service.IService;
import dtv.service.ServiceException;

public interface IDataServices extends IDataModelFactory, IService {
  <R extends dtv.data2.access.IQueryResult, QOA extends dtv.data2x.req.IQueryResponse<R>> QOA browse(IQueryRequest<R> paramIQueryRequest) throws ServiceException;
  
  IPersistResponse persist(IPersistRequest<?> paramIPersistRequest) throws ServiceException;
  
  <ROA extends dtv.data2x.req.IRetrieveResponse<?>> ROA retrieve(IRetrieveRequest<?> paramIRetrieveRequest) throws ServiceException;
  
  <R extends dtv.data2.access.IQueryResult, QOA extends dtv.data2x.req.IQueryResponse<R>> QOA search(IQueryRequest<R> paramIQueryRequest) throws ServiceException;
  
  IUpdateResponse update(IUpdateRequest paramIUpdateRequest) throws ServiceException;
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\IDataServices.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */