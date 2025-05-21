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
 * BZ24594          221217    [Advanced Prompting] Transactions without a customer should prompt with "will save".
 * BZ24940          261217    Amount displaying on "WillSavePrompt" should be displayed 2 decimal places.
 * BZ24957          291217    'Confirmation to Join Good Sam Club' screen displays unexpectedly when pressing Cancel on 'Insert Check/MCR Read error' screen
 * BZ33231          241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 *===================================================================
 */

package caw.pos.advance.prompting;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.i18n.*;
import dtv.pos.common.*;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.PriceProvider;
import dtv.util.Money;
import dtv.xst.dao.itm.IItemPrices;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWillSavedAmountPromptOp extends AbstractPromptOp {

    private static final String JOIN        = "JOIN";

    private static final String CANCEL_JOIN = "CANCEL_JOIN";

    private static final String CLUB        = "CLUB";

    @Inject
    private CommonHelper        _commonHelper;

    @Override
    public boolean isOperationApplicable() {
        clearScopedValue(CawValueKeys.CATALYST_IS_CALL_BACK_DATA); //BZ32131
        /* START BZ 24957 */
        Boolean alreadyDisplayed = getScopedValue(CawValueKeys.DISPL_JOIN_CLUB_PROMPT);
        if (alreadyDisplayed != null && alreadyDisplayed) {
            return false;
        }
        /* END BZ 24957 */

        IRetailTransaction trans = _transactionScope
                .getTransaction(RETAIL_SALE);
        /* BEGIN BZ33231 */
        if (CawCatalystHelper.isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PROMPTING_ENGINE)) {
            if (!CawCatalystHelper.isCardPromptingEngineTurnedOn(CawConstants.CAW_TURN_ON_PE_TOTAL)
                    && trans.getCustomerParty() == null && getWillSavedAmt().compareTo(BigDecimal.ZERO) > 0) {
                setScopedValue(CawValueKeys.DISPL_JOIN_CLUB_PROMPT, Boolean.TRUE);
                return true;
            }
        } else {
            if (trans.getCustomerParty() == null && getWillSavedAmt().compareTo(BigDecimal.ZERO) > 0) {
                setScopedValue(CawValueKeys.DISPL_JOIN_CLUB_PROMPT, Boolean.TRUE);
                return true;
            }
            return false;
        }
        /* END BZ33231 */
        return false;

    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("WILL_SAVED_CONFIRM_PROMPT");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        final IXstActionKey key = ((IXstAction) argEvent).getActionKey();

        if (key.toString().equalsIgnoreCase(JOIN)) {
            return HELPER.getStartChainResponse(OpChainKey
                    .valueOf("CUST_ASSOCIATION"));
        }

        else if (key.toString().equalsIgnoreCase(CANCEL_JOIN)) {
            return HELPER.getCompleteStackChainResponse(OpChainKey
                    .valueOf("CHECK_SALE_COMPLETE"));
        }

        return HELPER.completeResponse();
    }

    @Override
    public IOpResponse getPromptResponse(IXstEvent argArgEvent,
            PromptKey argArgPromptKey, IFormattable[] argArgPromptArgs) {

        /*Begin BZ24940*/
        IFormatter formatter = FormatterFactory.getInstance()
                .getMoneyFormatter();
        Money money = new Money(getWillSavedAmt(),
                _commonHelper.getLocalCurrency());
        IFormattable value = FormattableFactory.getInstance()
                .getSimpleFormattable(formatter
                        .format(money, OutputContextType.VIEW));
        /*End BZ24940*/
        return HELPER
                .getPromptResponse(getDefaultPromptKey(), new IFormattable[] { value });
    }

    private BigDecimal getWillSavedAmt() {

        IRetailTransaction trans = _transactionScope
                .getTransaction(RETAIL_SALE);
        BigDecimal couldSavedAmt = BigDecimal.ZERO;
        Collection<IItemPrices> iItemPrices = null;
        List<ISaleReturnLineItem> lineItems = trans
                .getLineItems(ISaleReturnLineItem.class);
        List<String> argPriceTypes = new ArrayList<String>();

        if (lineItems != null) {
            for (ISaleReturnLineItem saleLineItem : lineItems) {
                if (saleLineItem.getReturn() || saleLineItem.getVoid()) {
                    continue;
                }

                argPriceTypes.add(CLUB);

                iItemPrices = PriceProvider.getAllBestPricesByType(saleLineItem
                        .getItemId(), saleLineItem
                                .getBusinessDate(), null, saleLineItem
                                        .getQuantity(), argPriceTypes);
                for (IItemPrices price : iItemPrices) {
                    couldSavedAmt = couldSavedAmt.add(saleLineItem
                            .getRegularBasePrice().subtract(price.getPrice())
                            .multiply(saleLineItem.getQuantity()));
                }
            }
        }

        return couldSavedAmt;
    }

}
