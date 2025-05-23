package dtv.pos.iframework.form;

public interface ICountryEditModel extends IEditModel {
  void changeCountry(String paramString, boolean paramBoolean);
  
  String getCountry();
  
  boolean getCountryChangedExternally();
  
  void initializeCountryFields();
  
  void setCountryChangedExternally(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\ICountryEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */