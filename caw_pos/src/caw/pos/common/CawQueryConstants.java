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
 * Req/Bug ID#          ddMMyy    Description
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ29625              080419    [New Requirement] - Auto-Renewal Item Specific Receipts
 * BZ31717              240719    [Prod] Cancelled transactions are successfully proceed in Order Service.
 * BZ38598              301020    [PROD] Membership Activation Issues
 *===================================================================
 */

package caw.pos.common;

import caw.pos.customer.*;

import dtv.data2.access.IQueryKey;
import dtv.data2.access.QueryKey;
import dtv.xst.dao.itm.IItemMessage;

/**
 * Define common constants of query parameters used for all functions
 */
public class CawQueryConstants {

    //DEFINE PARAMETER CONSTANTS-------------------
    public static final String                                       ARG_CUST_CARD_NUMBER            = "argCustCardNumber";

    public static final String                                       ARG_PARTY_ID                    = "argPartyId";

    public static final String                                       ARG_ACCOUNT_NUMBER              = "argAccountNumber";

    public static final String                                       ARG_ORGANIZATION_ID             = "argOrganizationId";

    public static final String                                       ARG_CARD_NUMBER                 = "argCardNumber";

    public static final String                                       ARG_ACTIVE_FLAG                 = "argActiveFlag";

    public static final String                                       ARG_VOID_FLAG                   = "argVoidFlag";
    
    /* BEGIN BZ31717 */
    public static final String                                       ARG_CUST_ACCT_ID                = "argCustAcctId";
    /* END BZ31717 */
    
    /* BEGIN BZ38598 */
    public static final String                                       ARG_PROPERTY_CODE                = "argPropertyCode";
    
    public static final String                                       PARTY_PROPERTY_REMOVE            = "PARTY_PROPERTY_REMOVE";
    /* END BZ38598 */

    //DEFINE QUERY CONSTANTS-----------------------
    public static final IQueryKey<CawCustomerLoyaltyQueryResult>     CRM_CUSTOMER_LOYALTY_EBS_LOOKUP = new QueryKey<CawCustomerLoyaltyQueryResult>(
            "CRM_CUSTOMER_LOYALTY_EBS_LOOKUP",
            CawCustomerLoyaltyQueryResult.class);

    public static final IQueryKey<CawCustomerLoyaltyQueryResult>     CRM_CUSTOMER_LOYALTY_LOOKUP     = new QueryKey<CawCustomerLoyaltyQueryResult>(
            "CRM_CUSTOMER_LOYALTY_LOOKUP", CawCustomerLoyaltyQueryResult.class);

    // Begin BZ23958
    public static final IQueryKey<CawCustomerCardQueryResult>        CRM_CUSTOMER_CARD_LOOKUP        = new QueryKey<CawCustomerCardQueryResult>(
            "CRM_CUSTOMER_CARD_LOOKUP", CawCustomerCardQueryResult.class);
    // End BZ23958

    public static final IQueryKey<CawCustomerEBSQueryResult>         CRM_CUSTOMER_EBS_LOOKUP         = new QueryKey<CawCustomerEBSQueryResult>(
            "CRM_CUSTOMER_EBS_LOOKUP", CawCustomerEBSQueryResult.class);

    /* Start BZ 25318 */
    public static final IQueryKey<CawCustomerPartyIdXrefQueryResult> CUSTOMER_PARTY_ID_XREF_LOOKUP   = new QueryKey<CawCustomerPartyIdXrefQueryResult>(
            "CUSTOMER_PARTY_ID_XREF_LOOKUP",
            CawCustomerPartyIdXrefQueryResult.class);
    /* End BZ 25318 */

    /* BEGIN BZ29625 */
    public static final IQueryKey<IItemMessage>                      CAW_ITEM_MESSAGES               = new QueryKey<IItemMessage>(
            "CAW_ITEM_MESSAGES", IItemMessage.class);
    /* END BZ29625 */
}
