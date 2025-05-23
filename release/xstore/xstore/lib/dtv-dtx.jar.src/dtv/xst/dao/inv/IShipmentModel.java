package dtv.xst.dao.inv;

import dtv.data2.access.IDataModel;

public interface IShipmentModel extends IDataModel, IHasDocumentId {
  public static final String DESTINATION_TYPE_PARTY = "PARTY";
  
  public static final String DESTINATION_TYPE_RETAIL = "RETAIL_LOCATION";
  
  public static final String DESTINATION_TYPE_SERVICE_LOC = "SERVICE_LOCATION";
  
  void commitTemp();
  
  String getDestinationIdAsString();
  
  String getTempShipmentStatusCode();
  
  void setTempShipmentStatusCode(String paramString);
  
  void startTemp();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IShipmentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */