package dtv.xst.dao.crm;

import java.util.List;

public interface IPartySegment {
  void addSegmentMessage(IPartySegmentMessage paramIPartySegmentMessage);
  
  String getDescription();
  
  String getName();
  
  String getSegmentId();
  
  String getSegmentMessage(String paramString);
  
  List<IPartySegmentMessage> getSegmentMessages();
  
  void setDescription(String paramString);
  
  void setName(String paramString);
  
  void setSegmentId(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IPartySegment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */