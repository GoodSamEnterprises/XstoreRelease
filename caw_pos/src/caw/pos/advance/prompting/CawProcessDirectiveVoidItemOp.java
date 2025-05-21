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
 * BZ23052          140917    Implement Advanced Prompting
 * B23735           051017    Duplicate property name: _catalystprompttitle in translations.properties
 * BZ23671          091017    [Prompting Engine] Void Line Item is not worked when trigger with catalyst 4
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawEBSConstant;
import twitter4j.*;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.IRetailTransactionLineItem;

/**
 *
 */
public class CawProcessDirectiveVoidItemOp extends AbstractPromptOp {

    @Inject
    private TransactionScope       transactionScope;

    private static final Logger    _logger                    = LogManager
            .getLogger(CawProcessDirectiveVoidItemOp.class);

    private static final PromptKey CAW_CATALYST_NOTIFY_PROMPT = PromptKey
            .valueOf("CAW_CATALYST_NOTIFY_PROMPT");

    private StringBuilder          lineItems                  = new StringBuilder();

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        try {
            if (CawCatalystHelper.getCatalystDirectiveResponse() != null
                    && CawCatalystHelper.getCatalystDirectiveResponse()
                            .length() > 0) {
                JSONObject directive = null;
                JSONArray directiveResponse = CawCatalystHelper
                        .getCatalystDirectiveResponse();
                for (int i = 0; i < directiveResponse.length(); i++) {
                    if (directiveResponse.getJSONObject(i) != null) {
                        directive = directiveResponse.getJSONObject(i);
                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && directive
                                        .getInt(CawEBSConstant.TYPE_ATTR) == 4) {
                            if (!directive
                                    .isNull(CawEBSConstant.PROPERTIES_ATTR)) {
                                if (directive
                                        .getJSONObject(CawEBSConstant.PROPERTIES_ATTR)
                                        .getString(CawEBSConstant.LINENUMBER_ATTR) != null) {
                                    lineItems.append(directive
                                            .getJSONObject(CawEBSConstant.PROPERTIES_ATTR)
                                            .getString(CawEBSConstant.LINENUMBER_ATTR));
                                    lineItems.append(",");
                                }
                            }
                        }
                    }
                }
            }

            if (lineItems != null && lineItems.length() > 0) {
                isRun = Boolean.TRUE;
                lineItems = new StringBuilder(
                        lineItems.subSequence(0, lineItems.length() - 1));
            }

        } catch (JSONException ex) {
            _logger.error("Can not get directive void item." + ex.getMessage());
        }

        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return CAW_CATALYST_NOTIFY_PROMPT;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent iXstEvent) {

        IOpResponse iOpResponse = HELPER.completeResponse();
        try {

            if (_transactionScope.getTransaction() != null
                    && CollectionUtils.isNotEmpty(_transactionScope
                            .getTransaction().getSaleLineItems())) {
                List<IRetailTransactionLineItem> lineItemls = transactionScope
                        .getTransaction().getSaleLineItems();
                if (CollectionUtils.isNotEmpty(lineItemls)
                        && lineItems != null) {

                    //Begin BZ23671
                    //Get items aren't void in Sale Line Items
                    //itemsNotVoid stored index of items that aren't void. We removed follow this.
                    List<Integer> itemsNotVoid = new ArrayList<Integer>();
                    for (int i = 0; i < lineItemls.size(); i++) {
                        if (!lineItemls.get(i).getVoid()) {
                            itemsNotVoid.add(i);
                        }
                    }
                    //End BZ23671

                    if (lineItems.length() <= itemsNotVoid.size()) {
                        String[] lsItemVoid = lineItems.toString().split(",");
                        if (lsItemVoid.length > 0) {

                            //Begin BZ23671
                            int indexTemp;
                            for (int i = 0; i < lsItemVoid.length; i++) {
                                indexTemp = Integer.valueOf(lsItemVoid[i]);
                                if (indexTemp <= itemsNotVoid.size()) {
                                    lineItemls
                                            .get(itemsNotVoid
                                                    .get(indexTemp - 1))
                                            .setVoid(Boolean.TRUE);
                                    _logger.info("Void Line Item: "
                                            + (itemsNotVoid
                                                    .get(indexTemp - 1)));
                                }
                            }
                            //End BZ23671
                        }
                    }
                }
            }

            if (iXstEvent instanceof IXstDataAction) {

                CawCatalystHelper.setCatalystDirectiveResponse(CawCatalystHelper
                        .removeElementOfJsonArray(CawCatalystHelper
                                .getCatalystDirectiveResponse(), 4));
                lineItems = new StringBuilder();//Clear list item has select before that.
            } else {
                iOpResponse = HELPER
                        .getPromptResponse(CAW_CATALYST_NOTIFY_PROMPT);
            }

        } catch (JSONException ex) {
            _logger.debug("Cann not void line item." + ex.getMessage());
        }
        return iOpResponse;

    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getSimpleFormattable(_ff
                .getTranslatable("_promptingEngineTitle"), FormatterType.SIMPLE);//B23735
        args[1] = _ff
                .getSimpleFormattable(_ff.getTranslatable("_voidLineNumber")
                        + lineItems.toString(), FormatterType.SIMPLE);
        return args;
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }

}
