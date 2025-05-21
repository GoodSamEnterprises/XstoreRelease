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
 * BZ23147          070917    Implement Serialized coupon
 *===================================================================
 */

package caw.pos.promotion.coupon;

import static dtv.util.NumberUtils.isLessThanOrEqual;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConfigurationMgr;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.tender.TenderConstants;
import dtv.pos.tender.TenderHelper;
import dtv.pos.tender.change.PromptSelectChangeTenderOp;
import dtv.util.NumberUtils;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * Config to allow or disallow issue another card when using coupon tender
 */
public class CawPromptSelectChangeTenderOp extends PromptSelectChangeTenderOp {

    private static final Logger _logger = LogManager
            .getLogger(CawPromptSelectChangeTenderOp.class);

    @Inject
    private TenderHelper        _tenderHelper;

    @Override
    protected List<ITender> getChangeTenderIdChoices(IRetailTransaction trans,
            BigDecimal changeAmount) {

        Set<ITender> changeTenders = new HashSet<ITender>();
        Set<ITender> fallbackChangeTenders = new HashSet<ITender>();
        ITender localCurrencyTender = _tenderHelper.getLocalCurrency();

        List<ITenderLineItem> incomingTenderLineItems = trans
                .getLineItems(ITenderLineItem.class);
        for (ITenderLineItem tndrLineItem : incomingTenderLineItems) {
            final ITender incomingTender = tndrLineItem.getTender();

            // Make sure its a non-voided tender
            if (tndrLineItem.getVoid() || !tndrLineItem.getTenderStatusCode()
                    .equalsIgnoreCase(TenderStatus.TENDER.getName())) {
                continue;
            }

            BigDecimal cashChangeLimit = incomingTender.getOptions()
                    .getCashChangeLimit();
            String changeTenderId = incomingTender.getOptions()
                    .getChangeTenderId();

            // CAW: Use config to allow or not allow issue another card with coupon tender.
            if (incomingTender.getOptions().getTenderId()
                    .equalsIgnoreCase("COUPON")
                    && !CawConfigurationMgr
                            .allowCouponTenderIssueAnotherCard()) {
                changeTenderId = null;
            }

            /* If either (1) No cash change limit has been configured or (2) the cash change limit is acceptable for
             * the incomingTender used and the change due is less than or equal to the incoming tender amount. The
             * maximum cash change that can be issued against a given tender is the lesser of its pre- configured
             * cash change limit and that tender's applied amount. If, for example, credit cards have a $100 maximum
             * cash change allowance but I only tender $20 against a credit card, I should only be able to receive
             * $20 in cash change, not the pre-configured maximum of $100. */
            if ((cashChangeLimit == null
                    || isLessThanOrEqual(changeAmount, cashChangeLimit))
                    && !(isLessThanOrEqual(changeAmount, tndrLineItem
                            .getAmount())
                            && !TenderConstants.LOCAL_CURRENCY
                                    .equalsIgnoreCase(changeTenderId))) {

                /* Add local cash currency to the list of available choices, as long as it will not be rounded off to
                 * 0. */
                if (!changeTenders.contains(localCurrencyTender)
                        && !NumberUtils.equivalent(_tenderHelper
                                .getRoundingAmountByTender(localCurrencyTender, changeAmount), BigDecimal.ZERO)) {
                    changeTenders.add(localCurrencyTender);
                }

                /* Add foreign currency tender to the list of available choices if it is allowed to be given as
                 * change. */
                if (_tenderHelper.isForeignCurrency(incomingTender)
                        && incomingTender.getOptions()
                                .getChangeAllowedWhenForeign()) {

                    /* Add the foreign cash currency when it is used, as long as it will not be rounded off to 0. */
                    BigDecimal exchangeRate = _tenderHelper
                            .getExchangeRate(incomingTender
                                    .getCurrencyId(), _stationState
                                            .getRetailLocationId());
                    BigDecimal foreignAmount = changeAmount
                            .multiply(exchangeRate);
                    foreignAmount = foreignAmount.setScale(Currency
                            .getInstance(incomingTender.getCurrencyId())
                            .getDefaultFractionDigits(), RoundingMode.HALF_UP);

                    if (!NumberUtils.equivalent(_tenderHelper
                            .getRoundingAmountByTender(incomingTender, foreignAmount), BigDecimal.ZERO)) {
                        changeTenders.add(incomingTender);
                    }
                }
            } else {
                /* The cash change limit or tender amount has been exceeded. This means that local cash is not an
                 * acceptable method to deliver change. Get the configured fallback change_tender_id to use, and add
                 * it to the list of fallback tender choices. If the fallback change tender id is null, then there are
                 * no other tenders to consider */
                if (changeTenderId != null && !TenderConstants.LOCAL_CURRENCY
                        .equalsIgnoreCase(changeTenderId)) {
                    fallbackChangeTenders
                            .addAll(getVoucherActivityTenderIds(changeTenderId));
                }
            }
        }

        /* Add all the fallback change tender ids to the list if it is empty at this point */
        if (changeTenders.isEmpty()) {
            _logger.debug("no change tenders, adding the fallback tenders: "
                    + fallbackChangeTenders);
            changeTenders.addAll(fallbackChangeTenders);
        }

        /* There's still nothing to give as change, so get the system configured default */
        if (changeTenders.isEmpty()) {
            // CAW: Use config to allow or not allow issue another card with coupon tender.
            String lastTenderId = incomingTenderLineItems
                    .get(incomingTenderLineItems.size() - 1).getTenderId();
            if (!lastTenderId.equalsIgnoreCase("COUPON") || CawConfigurationMgr
                    .allowCouponTenderIssueAnotherCard()) {
                _logger.debug("still no change tenders, using the system configured default");
                changeTenders.add(_tenderHelper.getTender(ConfigurationMgr
                        .getDefaultChangeTenderIdIfNoneFound(), this));
            }
        }

        _logger.debug("changeTender choices to present to the user:"
                + changeTenders);

        /* Sort choices on the display order column */
        List<ITender> sortedChoices = new ArrayList<ITender>();
        sortedChoices.addAll(changeTenders);
        Collections.sort(sortedChoices, new Comparator<ITender>() {

            @Override
            public int compare(ITender tender1, ITender tender2) {

                return (tender1.getDisplayOrder() - tender2.getDisplayOrder());
            }
        });

        return sortedChoices;
    }
}
