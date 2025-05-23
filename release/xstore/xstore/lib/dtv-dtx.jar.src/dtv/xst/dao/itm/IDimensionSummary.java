package dtv.xst.dao.itm;

import dtv.util.ISortable;

public interface IDimensionSummary extends ISortable {
  String getDescription();
  
  String getDimension();
  
  String getDimensionSystem();
  
  String getDimensionValue();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IDimensionSummary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */