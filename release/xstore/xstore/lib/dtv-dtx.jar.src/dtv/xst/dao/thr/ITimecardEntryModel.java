package dtv.xst.dao.thr;

import dtv.data2.access.IDataModel;
import dtv.i18n.IFormattable;
import java.util.Date;

public interface ITimecardEntryModel extends IDataModel {
  IFormattable getDeleteFormattable();
  
  String getDeleteText();
  
  String getEditedByTimecardMainIndicator();
  
  String getEmployeeId();
  
  boolean getPostedFlag();
  
  Date getTimecardDate();
  
  boolean getUpdateFlag();
  
  void setEmployeeId(String paramString);
  
  void setPostedFlag(boolean paramBoolean);
  
  void setTimecardDate(Date paramDate);
  
  void setUpdateFlag(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\ITimecardEntryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */