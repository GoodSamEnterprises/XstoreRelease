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
 * BZ38355          121020    [Internal] Pickup Order - The receipts are printed incorrectly when executing Pickup partial Order
 * BZ46879          102720    Xstore Patch 16 Receipt Issues
 *===================================================================
 */

package caw.pos.order;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.xst.query.result.CawOrderModQueryResult;
import caw.xst.query.result.CawOrderlineTaxGroupIdResult;

import dtv.data2.access.*;
import dtv.data2.access.pm.PersistenceManagerType;
import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.scope.TransactionScope;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.ItemId;
import dtv.xst.dao.xom.IOrderLine;

public class CawOrderLineTaxField extends AbstractDocBuilderField {
    private static final Logger _logger             = LogManager.getLogger(CawOrderLineTaxField.class);
    
    protected static final IQueryKey<CawOrderModQueryResult> QUERY_ORDER_MOD = new QueryKey<CawOrderModQueryResult>(
            "QUERY_ORDER_MOD", CawOrderModQueryResult.class);
    
    protected static final IQueryKey<CawOrderlineTaxGroupIdResult> QUERY_ORDERLINE_TAX_ID = new QueryKey<CawOrderlineTaxGroupIdResult>(
            "QUERY_ORDERLINE_TAX_ID", CawOrderlineTaxGroupIdResult.class);
    
    @Inject
    protected TransactionScope _transactionScope;
    
    private CawOrderModQueryResult getOrderModQueryResult(IOrderLine orderline) {
        CawOrderModQueryResult result = null;
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("argOrganizationId", orderline.getOrganizationId());
        params.put("argOrderId", orderline.getOrderId());
        List<CawOrderModQueryResult> orderModResults = DataFactory
                .getObjectByQueryNoThrow(QUERY_ORDER_MOD, params, PersistenceManagerType
                        .forName("XCENTER_STANDARD"));
        /*BEGIN BZ46879*/
        if (orderModResults != null && orderModResults.size() > 0) {
            for (CawOrderModQueryResult orderResult : orderModResults) {
                if(orderResult.getTransLineItmSeq() == orderline.getSequence() 
                        && orderResult.getItemType().equals("ITEM")) {
                    result = orderResult;
                    break;
                }
                else if(orderResult.getDetailSeq() == orderline.getSequence() 
                        && orderResult.getItemType().equals("ITEM")) {
                    result = orderResult;
                    break;
                }
            }
        }
        /*END BZ46879*/
        return result;        
    }
    
    private CawOrderlineTaxGroupIdResult getOrderLineTaxGroupIdResult(CawOrderModQueryResult orderMod) {
        CawOrderlineTaxGroupIdResult result = null;
        
        if(orderMod != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("argOrgId", orderMod.getOrgId());
            params.put("argRtlId", orderMod.getRtlId());
            params.put("argBDate", orderMod.getBDate());
            params.put("argWstId", orderMod.getWstId());
            params.put("argTransSeq", orderMod.getTransSeq());
            params.put("argTransLineItmSeq", orderMod.getTransLineItmSeq());
            List<CawOrderlineTaxGroupIdResult> listOrderlineTax = DataFactory
                    .getObjectByQueryNoThrow(QUERY_ORDERLINE_TAX_ID, params, PersistenceManagerType
                            .forName("XCENTER_STANDARD"));
            
            if(listOrderlineTax != null && listOrderlineTax.size() >0) {
                result = listOrderlineTax.get(0);
            }
        }
        
        return result;
    }
    
    public CawOrderLineTaxField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argArg0, IDocElementFactory argArg1, Locale argArg2) {
        String result = "";

        IOrderLine orderline = (IOrderLine) argArg0;

        if (orderline.getShadowedSaleItem() != null) {
            result = orderline.getShadowedSaleItem().getTaxGroupId();
        } else {
            CawOrderModQueryResult orderMod = getOrderModQueryResult(orderline);
            CawOrderlineTaxGroupIdResult taxResult = getOrderLineTaxGroupIdResult(orderMod);
            if (taxResult != null) {
                result = taxResult.getTaxGroupId();
            } else {
                /* BEGIN BZ46879*/
                try {
                    if ("CANCELLED".equalsIgnoreCase(orderline.getStatusCode())
                            || "FULFILLED".equalsIgnoreCase(orderline.getStatusCode())) {
                        String itemID = orderline.getItemId();
                        if (itemID != null) {
                            ItemId id = new ItemId();
                            id.setItemId(itemID);
                            id.setOrganizationId(ConfigurationMgr.getOrganizationId());
                            IItem iItem = DataFactory.getObjectByIdNoThrow(id);
                            if (iItem != null && iItem.getItemOptions() != null) {
                                if (iItem.getItemOptions().get(0) != null) {
                                    result = iItem.getItemOptions().get(0).getTaxGroupId();
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    _logger.error("Cannot get taxGroupId." + ex.getMessage());
                }
                /* END BZ46879*/
            }
        }

        return result;
    }
}