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
 * BZ24350          201117    Receipts need to print Tax code summary
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import oracle.retail.xstore.countrypack.common.docbuilding.TaxTotalIterator;

import dtv.data2.access.DataFactory;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.IPosDocument;
import dtv.xst.dao.tax.ITaxGroupRule;
import dtv.xst.dao.tax.ITaxLocation;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawTaxTotalIterator extends TaxTotalIterator {

    @Override
    protected void iterate(IPosDocument argDoc,
            IDocElementFactory argElementFactory, Object argO)
            throws IOException {

        TreeMap<String, Object> results = new TreeMap<String, Object>();
        if (argO instanceof IRetailTransaction) {
            IRetailTransaction tran = (IRetailTransaction) argO;
            for (ISaleReturnLineItem item : tran
                    .getLineItems(ISaleReturnLineItem.class)) {
                if (item.getVoid()
                        || item.getExtendedAmount().equals(BigDecimal.ZERO)) {
                    continue;
                }
                for (ISaleTaxModifier taxMod : item.getTaxModifiers()) {
                    if (taxMod.getVoid()) {
                        continue;
                    }
                    IRetailTransactionLineItem inProc = (IRetailTransactionLineItem) results
                            .get(taxMod.getTaxGroupId());
                    if (inProc == null) {
                        inProc = (IRetailTransactionLineItem) DataFactory
                                .createTransientObject(ITaxLineItem.class);
                        copyValues((ITaxLineItem) inProc, taxMod);
                        results.put(((ITaxLineItem) inProc)
                                .getTaxGroupId(), (Object) inProc);
                        continue;
                    }
                    ITaxLineItem currentInProc = (ITaxLineItem) inProc;
                    currentInProc.setTaxableAmount(currentInProc
                            .getTaxableAmount().add(taxMod.getTaxableAmount()));
                    currentInProc.setTaxAmount(currentInProc.getTaxAmount()
                            .add(taxMod.getTaxAmount()));
                }
            }
            ITaxLineItem taxLine = this.createTaxExemptLine(tran);
            if (taxLine != null) {
                results.put(taxLine.getTaxGroupId(), (Object) taxLine);
            }
            if (results.isEmpty() && (taxLine = this
                    .createTaxExemptLineItem(tran.getTotal())) != null) {
                results.put(taxLine.getTaxGroupId(), (Object) taxLine);
            }
        }
        if (!results.isEmpty()) {
            ArrayList finalResult = new ArrayList();
            finalResult.addAll(results.values());
            this.iterateList(argDoc, argElementFactory, finalResult);
        }
    }

    private void copyValues(ITaxLineItem argTarget,
            ISaleTaxModifier argOrigin) {

        argTarget.setAuthorityId(argOrigin.getAuthorityId());
        argTarget.setAuthorityName(argOrigin.getAuthorityName());
        argTarget.setAuthorityTypeCode(argOrigin.getAuthorityTypeCode());
        argTarget.setBeginDateTimestamp(argOrigin.getParentLine()
                .getBeginDateTimestamp());
        argTarget.setBusinessDate(argOrigin.getBusinessDate());
        argTarget.setCurrencyId(argOrigin.getParentLine().getCurrencyId());
        argTarget.setEndDateTimestamp(argOrigin.getParentLine()
                .getEndDateTimestamp());
        argTarget.setLineItemStatusCode(argOrigin.getParentLine()
                .getLineItemStatusCode());
        argTarget.setLineItemTypeCode(argOrigin.getParentLine()
                .getLineItemTypeCode());
        argTarget.setRawTaxAmount(argOrigin.getRawTaxAmount());
        argTarget.setRawTaxPercentage(argOrigin.getRawTaxPercentage());
        argTarget.setTaxPercentage(argOrigin.getTaxPercentage());
        argTarget.setSaleTaxGroupRule(argOrigin.getSaleTaxGroupRule());
        argTarget.setTaxableAmount(argOrigin.getTaxableAmount());
        argTarget.setTaxAmount(argOrigin.getTaxAmount());
        argTarget.setTaxGroupId(argOrigin.getTaxGroupId());
        argTarget.setTaxOverride(argOrigin.getTaxOverride());
        argTarget.setTaxOverrideAmount(argOrigin.getTaxOverrideAmount());
        argTarget
                .setTaxOverridePercentage(argOrigin.getTaxOverridePercentage());
        argTarget
                .setTaxOverrideReasonCode(argOrigin.getTaxOverrideReasonCode());
        argTarget.setTaxRuleSequence(argOrigin.getTaxRuleSequence());
    }

    private ITaxLineItem createTaxExemptLine(IRetailTransaction tran) {

        BigDecimal exentAmt = BigDecimal.ZERO;
        ITaxLineItem taxLine = null;
        List<IRetailTransactionLineItem> items = tran.getSaleLineItems();
        for (IRetailTransactionLineItem item : items) {
            if (!this.isLineItemTaxExempt((ISaleReturnLineItem) item)) {
                continue;
            }
            exentAmt = exentAmt
                    .add(((ISaleReturnLineItem) item).getExtendedAmount());
        }
        if (exentAmt.abs().compareTo(BigDecimal.ZERO) > 0) {
            taxLine = this.createTaxExemptLineItem(exentAmt);
        }
        return taxLine;
    }

    private ITaxLineItem createTaxExemptLineItem(BigDecimal argAmount) {

        ITaxLocation taxLocation = this._taxHelper
                .getTaxLocationByRetailLocation(this._stationState
                        .getRetailLocationId());
        ITaxGroupRule zeroRule = this.getZeroTaxRateRule(taxLocation);
        ITaxLineItem taxLine = null;
        if (zeroRule != null) {
            taxLine = this._taxHelper.createTaxLineItem(null, zeroRule);
            taxLine.setTaxableAmount(argAmount);
        }
        return taxLine;
    }

    private boolean isLineItemTaxExempt(ISaleReturnLineItem argItem) {

        List<ISaleTaxModifier> taxMods = argItem.getTaxModifiers();
        if (taxMods != null) {
            for (ISaleTaxModifier modifier : taxMods) {
                if (!this._taxHelper.isSaleTaxModifierTaxExempt(modifier)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
