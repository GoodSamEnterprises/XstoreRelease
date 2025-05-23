package dtv.xst.dao.trn;

import dtv.data2.access.IDataModel;
import java.util.Date;

public interface IGenericStorage extends IDataModel {
  Date getBusinessDate();
  
  String getDataStorage();
  
  long getRetailLocationId();
  
  long getTransactionSequence();
  
  long getWorkstationId();
  
  void setDataStorage(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IGenericStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */