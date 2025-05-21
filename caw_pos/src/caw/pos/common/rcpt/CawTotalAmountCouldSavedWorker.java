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
 * BZ24657          011217    "You could have saved..." receipts changes
 * BZ40798          240221    Modification to member savings calculation
 * BZ48145          130121    IDS Service Payment and member savings total
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyRoundingMode;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyScale;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;

import caw.pos.register.rvpayment.CawRvPaymentHelper;

import dtv.pos.pricing.PriceProvider;
import dtv.xst.dao.itm.IItemPrices;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Calculates the total amount saved on a transaction.
 *
 */
public class CawTotalAmountCouldSavedWorker implements Callable<BigDecimal> {

    private static final String      CLUB = "CLUB";

    private final IRetailTransaction _transaction;

    private BigDecimal               _youCouldSavedAmount;

    /**
     * Instantiates a new total amount saved worker.
     *
     * @param argTransaction the transaction
     */
    public CawTotalAmountCouldSavedWorker(IRetailTransaction argTransaction) {

        _transaction = argTransaction;
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal call() {

        if (_youCouldSavedAmount == null) {
            BigDecimal couldSavedAmt = BigDecimal.ZERO;
            Collection<IItemPrices> iItemPrices = null;
            List<ISaleReturnLineItem> lineItems = _transaction
                    .getLineItems(ISaleReturnLineItem.class);
            List<String> argPriceTypes = new ArrayList<String>();

            if (lineItems != null) {
                for (ISaleReturnLineItem saleLineItem : lineItems) {
                    if (saleLineItem.getReturn() 
                            || saleLineItem.getVoid() 
                            || CawRvPaymentHelper.isRvPaymentSaleLineItem(saleLineItem)) {/*BZ48145*/
                        continue;
                    }

                    argPriceTypes.add(CLUB);

                    iItemPrices = PriceProvider
                            .getAllBestPricesByType(saleLineItem
                                    .getItemId(), saleLineItem
                                            .getBusinessDate(), null, saleLineItem
                                                    .getQuantity(), argPriceTypes);
                    for (IItemPrices price : iItemPrices) {
                        couldSavedAmt = couldSavedAmt
                                .add(saleLineItem.getRegularBasePrice()
                                        .subtract(price.getPrice())
                                        .multiply(saleLineItem.getQuantity()));
                    }
                }
            }
            couldSavedAmt = couldSavedAmt.setScale(getLocalCurrencyScale(), getLocalCurrencyRoundingMode()); //BZ40798 - Format amount scale = 2 and rounding
            _youCouldSavedAmount = couldSavedAmt;
        }
        return _youCouldSavedAmount;
    }
}
