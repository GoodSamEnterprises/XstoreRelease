package dtv.xst.dao.trn;

import dtv.data2.access.IDataModel;
import java.math.BigDecimal;

public interface IRainCheckModel extends IDataModel {
  String getItemDescription();
  
  BigDecimal getQuantityLimit();
  
  void setItemDescription(String paramString);
  
  void setQuantityLimit(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IRainCheckModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */