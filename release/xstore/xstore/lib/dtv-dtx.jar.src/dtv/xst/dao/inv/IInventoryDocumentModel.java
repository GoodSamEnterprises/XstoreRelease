package dtv.xst.dao.inv;

import java.util.Date;

public interface IInventoryDocumentModel extends IHasDocumentId {
  public static final String RECORD_CREATION_TYPE_STORE = "STORE";
  
  public static final String LINE_ITEMS_FIELD = "InventoryDocumentLineItems";
  
  public static final String CARTONS_FIELD = "Cartons";
  
  public static final String SHIPMENTS_FIELD = "Shipments";
  
  public static final String NOTES_FIELD = "Notes";
  
  public static final String CARTON_ADDED = "CARTON_ADDED";
  
  void commitTemp();
  
  Date getExpectedDeliveryDate();
  
  String getNotesContent();
  
  String getTempStatusCode();
  
  void setExpectedDeliveryDate(Date paramDate);
  
  void setTempStatusCode(String paramString);
  
  void startTemp();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryDocumentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */