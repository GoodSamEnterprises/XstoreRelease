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
 * BZ28915          020119    [Internal] Missing Cashier and Transaction number on Balance Inquiry receipt.
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import javax.inject.Inject;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.iframework.security.StationState;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.hrs.impl.EmployeeModel;

public class CawGCEmployeeIdDocBuilderField extends AbstractDocBuilderField {

    @Inject
    private StationState _stationState;

    public CawGCEmployeeIdDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argParamObject, IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        String employeeId = "";
        if (_stationState != null && _stationState.getSystemUser() != null) {
            employeeId = ((EmployeeModel) _stationState.getSystemUser()).getEmployeeId();
        }
        return employeeId;
    }
}
