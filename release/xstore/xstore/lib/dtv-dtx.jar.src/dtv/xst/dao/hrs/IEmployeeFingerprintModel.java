package dtv.xst.dao.hrs;

import dtv.data2.access.IDataModel;
import java.io.IOException;

public interface IEmployeeFingerprintModel extends IDataModel {
  Object getBiometricData() throws ClassNotFoundException, IOException;
  
  boolean isDeleted();
  
  void markForDeletion();
  
  void setBiometricData(Object paramObject) throws IOException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeFingerprintModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */