package dtv.xst.dao.itm;

import dtv.data2.access.IDataModel;
import java.util.List;

public interface IItemModel extends IDataModel {
  void buildPromptPropertiesMap();
  
  void buildPropertiesMap();
  
  String getDescription();
  
  IItemDimensionType getItemDimensionType(int paramInt);
  
  String getItemDimensionValue(int paramInt);
  
  List<IItemDimensionValue> getItemDimensionValues(String paramString);
  
  IItemImage getItemImage(String paramString);
  
  String getMerchLevel1Id();
  
  String getMerchLevel2Id();
  
  String getMerchLevel3Id();
  
  String getMerchLevel4Id();
  
  String getMessageKey();
  
  IItemOptions getOptions();
  
  List<?> getPromptPropertiesByCode(String paramString);
  
  List<IItemDealProperty> getPropertiesByCode(String paramString);
  
  List<IItemDealProperty> getPropertiesByCode(String[] paramArrayOfString);
  
  void setDescription(String paramString);
  
  void setMessageKey(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */