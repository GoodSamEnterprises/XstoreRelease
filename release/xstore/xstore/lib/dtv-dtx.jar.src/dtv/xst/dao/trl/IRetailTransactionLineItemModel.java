package dtv.xst.dao.trl;

import dtv.xst.dao.trn.LineItemGenericStorageId;
import dtv.xst.dao.ttr.ITenderSignature;
import java.math.BigDecimal;
import java.util.Date;

public interface IRetailTransactionLineItemModel {
  public static final int EXCLUDE_FROM_POSLOG = -2147483648;
  
  LineItemGenericStorageId getLineItemGenericStorageId();
  
  BigDecimal getLocalizedAmount(BigDecimal paramBigDecimal);
  
  BigDecimal getRelativeAmount(BigDecimal paramBigDecimal);
  
  ITenderSignature getSignature();
  
  boolean getSignatureCaptureSkipped();
  
  Date getTransactionDate();
  
  void setSignature(ITenderSignature paramITenderSignature);
  
  void setSignatureCaptureSkipped(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransactionLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */