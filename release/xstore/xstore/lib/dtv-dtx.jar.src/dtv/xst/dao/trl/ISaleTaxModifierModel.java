package dtv.xst.dao.trl;

import dtv.xst.dao.tax.TaxExemptionId;
import java.math.BigDecimal;

public interface ISaleTaxModifierModel extends ISaleReturnLineItemChild {
  TaxExemptionId getTaxExemptionIdObject();
  
  BigDecimal getTranTaxableAmt();
  
  void setTranTaxableAmt(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ISaleTaxModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */