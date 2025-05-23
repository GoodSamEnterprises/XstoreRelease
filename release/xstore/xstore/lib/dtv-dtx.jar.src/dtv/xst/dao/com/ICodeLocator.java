package dtv.xst.dao.com;

import dtv.data2.access.IObjectId;
import dtv.util.ICodeInterface;
import java.util.List;

public interface ICodeLocator {
  ICodeInterface getCode(IObjectId paramIObjectId);
  
  List<? extends ICodeInterface> getCodes(Class<? extends IObjectId> paramClass);
  
  ICodeValue getCodeValue(long paramLong, String paramString1, String paramString2);
  
  List<? extends ICodeValue> getCodeValues(long paramLong, String paramString);
  
  IReasonCode getReasonCode(long paramLong, String paramString1, String paramString2);
  
  List<? extends IReasonCode> getReasonCodes(long paramLong, String paramString1, String paramString2);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ICodeLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */