package dtv.xst.dao.thr;

import dtv.xst.dao.hrs.IWorkCodes;
import dtv.xst.dao.trn.IPosTransaction;
import java.util.Date;

public interface ITimeclockTransactionModel extends IPosTransaction {
  Date getOldClockInDateTime();
  
  Date getOldClockOutDateTime();
  
  IWorkCodes getOldWorkCode();
  
  ITimecardJournal getTimecardJournal();
  
  TimecardJournalId getTimecardJournalIdObject();
  
  boolean getUpdateFlag();
  
  IWorkCodes getWorkCodes();
  
  void setOldClockInDateTime(Date paramDate);
  
  void setOldClockOutDateTime(Date paramDate);
  
  void setOldWorkCode(IWorkCodes paramIWorkCodes);
  
  void setTimecardJournal(ITimecardJournal paramITimecardJournal);
  
  void setUpdateFlag(boolean paramBoolean);
  
  void setWorkCodes(IWorkCodes paramIWorkCodes);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\ITimeclockTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */