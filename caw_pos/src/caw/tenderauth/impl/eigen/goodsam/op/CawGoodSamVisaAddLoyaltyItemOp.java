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
 * BZ55978          290323    Loyalty Issue: Java Null Pointer
 * BZ57844          040823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58779          070923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 * BZ58783          110923    [Internal] Xstore adds the new GS Membership SKU instead of renewal Membership SKU for customers who currently have an active GS Membership.
 * BZ58779          110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import java.text.ParseException;
import java.util.*;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import caw.pos.common.*;
import caw.pos.customer.membership.CawCustomerMembershipView;
import caw.pos.customer.membership.CawMembershipHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawGoodSamVisaAddLoyaltyItemOp extends Operation {

    private static final Logger _logger                      = Logger.getLogger(CawGoodSamVisaAddLoyaltyItemOp.class);

    private final String        CAW_GS_MEMBERSHIP_GRACE_PERIOD           = "CAW_GS_MEMBERSHIP_GRACE_PERIOD";

    private final String        CAW_NEW_GS_MEMBERSHIP_SKU     = "CAW_NEW_GS_MEMBERSHIP_SKU";

    private final String        CAW_RENEWAL_GS_MEMBERSHIP_SKU = "CAW_RENEWAL_GS_MEMBERSHIP_SKU";

    private CawCustomerGSHelper _gsHelper                    = CawCustomerGSHelper.getInstance();
    
    private final String        CAW_PROCESSING_STATUS         = "Processing";

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {
        IPosTransaction trans = _transactionScope.getTransaction();
        if (trans != null && _gsHelper.isEnableLoyalty()) {
            return true;
        } 
        return false;
    }
    
    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        IPosTransaction trans = _transactionScope.getTransaction();

        if (trans != null && _gsHelper.isEnableLoyalty()) {
            IItem item = getGSMembershipItem();
            if (item != null) {
                // BEGIN BZ58779
                setScopedValue(ValueKeys.CURRENT_ITEM, item);
                
                ISaleReturnLineItem newLineItem = ItemLocator.getLocator().getSaleLineItem(item, SaleItemType.SALE, "");
                setScopedValue(ValueKeys.CURRENT_SALE_LINE, newLineItem);
                // END BZ58779
            }
        } 

        return this.HELPER.completeResponse();
    }

    private IItem getGSMembershipItem() {

        IItem item = null;
        ICodeValue codeValue;
        if (isRenewalExpiredLoyalty()) {
            codeValue = CodeLocator.getCodeValue(ConfigurationMgr
                    .getOrganizationId(), CAW_RENEWAL_GS_MEMBERSHIP_SKU, CAW_RENEWAL_GS_MEMBERSHIP_SKU);
        } else {
            codeValue = CodeLocator.getCodeValue(ConfigurationMgr
                    .getOrganizationId(), CAW_NEW_GS_MEMBERSHIP_SKU, CAW_NEW_GS_MEMBERSHIP_SKU);
            _transactionScope.setValue(CawValueKeys.CAW_IS_NEWAL_GS_MEMBERSHIP_SKU, Boolean.TRUE);//BZ58779
        }
        if (codeValue != null) {
            item = ItemLocator.getLocator().lookupItem(codeValue.getDescription());
        }
        return item;
    }

    private boolean isRenewalExpiredLoyalty() {

        int monthExpiryLoyalty = getMonthExpiryLoyalty();

        List<CawCustomerMembershipView> customerMemershipViews = CawMembershipHelper.getInstance().getMemberships();

        if (customerMemershipViews == null || customerMemershipViews.isEmpty()) {
            return false;
        }

        List<String> listGSAMMemberType = CodeLocator
                .getCodes(ConfigurationMgr.getOrganizationId(), CawEBSConstant.CAW_LOYALTY_GSAM_MEMBER_TYPE);
        CawCustomerMembershipView customerMemershipView = null;

        if (!listGSAMMemberType.isEmpty()) {
            // BEGIN BZ58783, BZ58779
            customerMemershipView = customerMemershipViews.stream()
                    .filter(cus -> listGSAMMemberType.contains(cus.getType()) && !CAW_PROCESSING_STATUS.equalsIgnoreCase(cus.getStatus()))
                    .sorted(Comparator.comparing(CawCustomerMembershipView::getDaysExpired)).findFirst().orElse(null);
            // END BZ58783, BZ58779
            if (customerMemershipView != null && customerMemershipView.getExpDate() != null) {

                try {
                    Date expDate = DateUtils.parseDate(customerMemershipView.getExpDate(), CawConstants.MM_DD_YYYY);
                    expDate = DateUtils.addMonths(expDate, monthExpiryLoyalty);
                    Date currentDate = new Date();
                    if (expDate.after(currentDate)) {
                        return true;
                    }
                } catch (ParseException ex) {
                    _logger.error("[Can not parse date]: " + ex.getMessage());
                }
            }
        }

        return false;
    }

    private int getMonthExpiryLoyalty() {

        ICodeValue month = CodeLocator
                .getCodeValue(ConfigurationMgr.getOrganizationId(), CAW_GS_MEMBERSHIP_GRACE_PERIOD, CAW_GS_MEMBERSHIP_GRACE_PERIOD);
        return Integer.parseInt(month.getDescription());
    }

}
