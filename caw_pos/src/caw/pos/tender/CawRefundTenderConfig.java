/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 *===================================================================
 */

package caw.pos.tender;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import dtv.util.config.*;

/**
 *
 */
public class CawRefundTenderConfig
        extends AbstractParentConfig implements ICascadableConfig {

    /**
     * 
     */
    private static final long   serialVersionUID               = 196134463134374029L;

    private static final Logger _logger                        = Logger
            .getLogger(CawRefundTenderConfig.class);

    private static final String REFUND_TENDER_ID               = "RefundTenderId";

    private static final String CHECK_ORIG_TRANS               = "CheckOriginalTransaction";

    private static final String NO_REQUIRED_ORIG_TRANS         = "NoRequiredOriginalTransaction";

    private static final String ORIG_TENDER_ID                 = "OriginalTenderId";

    private static final String MIN_AMT_WITHOUT_ORIG_TRANS     = "MinAmountWithoutOriginalTrans";

    private static final String MIN_AMT_WITH_ORIG_TRANS        = "MinAmountWithOriginalTrans";

    private static final String REFERENCE_TAG                  = "Ref";

    private static final String REGEX_SIGN                     = ",";

    private String              _refundTenderId                = null;

    private boolean             _checkOriginalTransaction      = false;

    private List<String>        _noRequiredOrigTrans           = null;

    private List<String>        _originalTenderId              = null;

    private BigDecimal          _minAmountWithoutOriginalTrans = null;

    private BigDecimal          _minAmountWithOriginalTrans    = null;

    private String              _reference                     = null;

    /* (non-Javadoc)
     * @see dtv.util.config.IConfigObject#setConfigObject(java.lang.String, dtv.util.config.IConfigObject)
     */
    @Override
    public void setConfigObject(String argVar1, IConfigObject argVar2) {

        if (REFUND_TENDER_ID.equalsIgnoreCase(argVar1)) {
            _refundTenderId = argVar2.toString();
        } else if (CHECK_ORIG_TRANS.equalsIgnoreCase(argVar1)) {
            _checkOriginalTransaction = ConfigUtils.asBool(argVar2.toString());
        } else if (NO_REQUIRED_ORIG_TRANS.equalsIgnoreCase(argVar1)) {
            String[] returnTypes = argVar2.toString().split(REGEX_SIGN);
            _noRequiredOrigTrans = Arrays.asList(returnTypes);
        } else if (ORIG_TENDER_ID.equalsIgnoreCase(argVar1)) {
            String[] tenderIds = argVar2.toString().split(REGEX_SIGN);
            _originalTenderId = Arrays.asList(tenderIds);
        } else if (MIN_AMT_WITHOUT_ORIG_TRANS.equalsIgnoreCase(argVar1)) {
            _minAmountWithoutOriginalTrans = ConfigUtils.toBigDecimal(argVar2);
        } else if (MIN_AMT_WITH_ORIG_TRANS.equalsIgnoreCase(argVar1)) {
            _minAmountWithOriginalTrans = ConfigUtils.toBigDecimal(argVar2);
        } else if (REFERENCE_TAG.equalsIgnoreCase(argVar1)) {
            _reference = argVar2.toString();
        }
        setClean();
    }

    /* (non-Javadoc)
     * @see dtv.util.config.ICascadableConfig#cascadeValues(dtv.util.config.IConfigObject)
     */
    @Override
    public void cascadeValues(IConfigObject argVar1) {

        if (!(argVar1 instanceof CawRefundTenderConfig)) {
            _logger.error("Attempted to cascade from invalid configuration object::"
                    + getSourceDescription(argVar1) + "-->"
                    + getSourceDescription());
            return;
        }

    }

    /**
     * @return the refundTenderId
     */
    public String getRefundTenderId() {

        return _refundTenderId;
    }

    /**
     * @param argRefundTenderId the refundTenderId to set
     */
    public void setRefundTenderId(String argRefundTenderId) {

        _refundTenderId = argRefundTenderId;
        setDirty();
    }

    /**
     * @return the originalTenderId
     */
    public List<String> getOriginalTenderId() {

        return _originalTenderId;
    }

    /**
     * @param argOriginalTenderId the originalTenderId to set
     */
    public void setOriginalTenderId(List<String> argOriginalTenderId) {

        _originalTenderId = argOriginalTenderId;
        setDirty();
    }

    /**
     * @return the minAmountWithoutOriginalTrans
     */
    public BigDecimal getMinAmountWithoutOriginalTrans() {

        return _minAmountWithoutOriginalTrans;
    }

    /**
     * @param argMinAmountWithoutOriginalTrans the minAmountWithoutOriginalTrans to set
     */
    public void setMinAmountWithoutOriginalTrans(
            BigDecimal argMinAmountWithoutOriginalTrans) {

        _minAmountWithoutOriginalTrans = argMinAmountWithoutOriginalTrans;
        setDirty();
    }

    /**
     * @return the minAmountWithOriginalTrans
     */
    public BigDecimal getMinAmountWithOriginalTrans() {

        return _minAmountWithOriginalTrans;
    }

    /**
     * @param argMinAmountWithOriginalTrans the minAmountWithOriginalTrans to set
     */
    public void setMinAmountWithOriginalTrans(
            BigDecimal argMinAmountWithOriginalTrans) {

        _minAmountWithOriginalTrans = argMinAmountWithOriginalTrans;
        setDirty();
    }

    /**
     * @return the reference
     */
    public String getReference() {

        return _reference;
    }

    /**
     * @param argReference the reference to set
     */
    public void setReference(String argReference) {

        _reference = argReference;
        setDirty();
    }

    /**
     * @return the checkOriginalTransaction
     */
    public boolean getCheckOriginalTransaction() {

        return _checkOriginalTransaction;
    }

    /**
     * @param argCheckOriginalTransaction the checkOriginalTransaction to set
     */
    public void setCheckOriginalTransaction(
            boolean argCheckOriginalTransaction) {

        _checkOriginalTransaction = argCheckOriginalTransaction;
    }

    /**
     * @return the noRequiredOrigTrans
     */
    public List<String> getNoRequiredOrigTrans() {

        return _noRequiredOrigTrans;
    }

    /**
     * @param argNoRequiredOrigTrans the noRequiredOrigTrans to set
     */
    public void setNoRequiredOrigTrans(List<String> argNoRequiredOrigTrans) {

        _noRequiredOrigTrans = argNoRequiredOrigTrans;
    }

}
