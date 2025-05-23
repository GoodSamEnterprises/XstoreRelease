package dtv.xst.dao.ttr;

import dtv.util.Money;
import dtv.xst.dao.tnd.ITender;

public interface ITenderLineItemModel {
  Money getForeignMoney();
  
  Object getInputEvent();
  
  ITender getTender();
  
  void setInputEvent(Object paramObject);
  
  void setSecuredInputEvent(Object paramObject);
  
  void setTender(ITender paramITender);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ITenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */