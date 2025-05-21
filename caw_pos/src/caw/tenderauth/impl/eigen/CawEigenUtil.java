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
 * PAYMENT          070917    Payment-Item Display
 * BZ26858          101118    [PROD] Register suspends transaction involuntarily and charges customer multiple times
 * BZ28403          071218    [Internal] Tax amount is not rounding to 2 digits for the decimal on PINPAD.
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import static dtv.pos.common.ConfigurationMgr.getCurrency;

import java.math.BigDecimal;
import java.util.Currency;

import javax.inject.Inject;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.pos.common.CommonHelper;
import dtv.pos.common.TransactionHelper;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.tender.TenderHelper;
import dtv.util.Money;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trl.IAuthorizableLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * This base class is used for CawEigenMgr
 */
public class CawEigenUtil {

    @Inject
    private TransactionScope _transactionScope;

    @Inject
    private TenderHelper     _tenderHelper;

    @Inject
    private CommonHelper     _commonHelper;

    /** Constructs a <code>CawEigenUtil</code>.
     * 
     */
    @SuppressWarnings("deprecation")
    public CawEigenUtil() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    public Money getRoundedAmountDue() {

        IPosTransaction transaction = _transactionScope.getTransaction();
        if (transaction == null) {
            return new Money(BigDecimal.ZERO, null);
        }
        final Currency currency = getCurrency();
        Money balance = null;
        Money changeDue = TransactionHelper.getChangeDue(transaction);
        if (changeDue != null) {
            BigDecimal roundedChangeDue = _commonHelper.roundCurrency(changeDue);
            return new Money(roundedChangeDue, changeDue.getCurrency());
        } else if (transaction.getAmountDue() != null) {
            balance = new Money(_commonHelper.roundCurrency(_tenderHelper
                    .getRoundingAmountByTender(_tenderHelper.getLocalCurrency(), transaction.getAmountDue().abs())),
                    currency);
        }
        return balance;
    }

    public static String fnHeaderWelcome() {

        return FormattableFactory.getInstance().getSimpleFormattable("_cawSigcapWelcome")
                .toString(OutputContextType.VIEW);
    }

    // Begin BZ26858
    /**
     * Build echo data format
     * @param tenderLineItem
     * @return
     */
    public static String buildEchoData(long locationId, long workstationId, long transSeqId) {

        String echoData = CawEigenConstants.VALUE_EMPTY;
        try {
            echoData = String.format(CawEigenConstants.ECHO_DATA_FORMAT, locationId)
                    + String.format(CawEigenConstants.ECHO_DATA_FORMAT, workstationId)
                    + String.format(CawEigenConstants.ECHO_DATA_TRANSACTION_SEQUENCE_FORMAT, transSeqId);

        } catch (Exception ex) {
            echoData = CawEigenConstants.VALUE_EMPTY;
        }

        return echoData;
    }
    // End BZ26858

    /**
     * BZ26858 added
     * @param argItemPrice
     * @param argQty
     * @return
     */
    public static String formatItemPrice(BigDecimal argItemPrice, BigDecimal argQty) {

        /*Begin BZ-23604*/
        String formatedItemPrice = null;
        if (argItemPrice != null && argQty != null) {
            if (argQty.compareTo(BigDecimal.ZERO) == 0) {
                formatedItemPrice = argItemPrice.toString().replaceAll("\\.", CawEigenConstants.VALUE_EMPTY);
            } else {
                // Begin BZ27090
                BigDecimal newPrice = argItemPrice.divide(argQty, BigDecimal.ROUND_HALF_EVEN)
                        .setScale(2, BigDecimal.ROUND_HALF_EVEN);
                // End BZ27090
                formatedItemPrice = newPrice.toString().replaceAll("\\.", CawEigenConstants.VALUE_EMPTY);
            }
        }
        /*End BZ-23604*/
        return formatedItemPrice;
    }

    /**
     * BZ26858 added
     * @return
     */
    public static String fnFooterText(String sAmountDue, String sTaxAmount) {

        String strFooterPinpad = CawEigenConstants.AMT_DUE + sAmountDue + " | Tax: " + sTaxAmount; /* BZ28403 */
        return formatFooterPinpad(strFooterPinpad);
    }

    public static String fnEchoData(IAuthorizableLineItem tenderLineItem) {

        return buildEchoData(tenderLineItem.getRetailLocationId(), tenderLineItem.getWorkstationId(), tenderLineItem
                .getTransactionSequence());

    }

    public static String fnAmount(IAuthorizableLineItem tenderLineItem) {

        if (tenderLineItem != null && tenderLineItem.getAmount() != null) {
            return tenderLineItem.getAmount().toString().replace(CawEigenConstants.DOT, CawEigenConstants.VALUE_EMPTY);
        } else {
            return CawEigenConstants.VALUE_EMPTY;
        }
    }

    public static String fnItemUnitPrice(ISaleReturnLineItem newLineItem) {

        return formatItemPrice(newLineItem.getExtendedAmount(), newLineItem.getQuantity());
    }

    /* Begin BZ28403 */
    /**
     * The function is format footer pinpad to sent amt. due and tax amount to pinpad. 
     * @param strFooter
     */
    public static String formatFooterPinpad(String strFooter) {

        String strFooterPinpad = strFooter;
        int sizeFooter = strFooter.length();
        int addSpace = 0;

        /* If footer size <= 32 is add space for footer. */
        if (sizeFooter <= 32) {
            addSpace = 32 - sizeFooter;
            strFooterPinpad = addSpaceFooterPinpad(addSpace, strFooter);

        }
        /* If footer size > 32 and <=36  is replace " due" equals = "". */
        else if (32 < sizeFooter && sizeFooter <= 36) {
            String strReplaceDue = strFooter.replace(CawEigenConstants.FOOTER_DUE, "");
            int sizeReplaceDue = strReplaceDue.length();
            /* If string footer after replace <= 32 is add space */
            if (sizeReplaceDue <= 32) {
                addSpace = 32 - sizeReplaceDue;
                strFooterPinpad = addSpaceFooterPinpad(addSpace, strReplaceDue);
            }
        }
        /* If footer size > 36 is split from right to left with 32 character. */
        else {
            String splitRightFooter = strFooter.substring(sizeFooter - 32, sizeFooter);
            strFooterPinpad = splitRightFooter;
        }

        return strFooterPinpad;
    }
    /* End BZ28403 */

    /* Begin BZ28403 */
    /**
     * The function is add space for footer pinpad when length < 32
     * @param i
     * @param str
     */
    public static String addSpaceFooterPinpad(int i, String str) {

        String strResult = "";
        /* i == 0 when length of str = 32 */
        if (i == 0) {
            strResult = str;
        } else {
            StringBuilder str1 = new StringBuilder();
            for (int j = 0; j < i; j++) {
                str1.append(" ");
            }
            str1.append(str);
            strResult = str1.toString();
        }
        return strResult;
    }
    /* End BZ28403 */
}
