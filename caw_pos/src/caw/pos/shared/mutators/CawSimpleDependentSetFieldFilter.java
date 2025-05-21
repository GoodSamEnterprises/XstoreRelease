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
 * BZ29372          150218    [Requirement] PLCC Account Lookup - ID Verification Screen new request
 *===================================================================
 */

package caw.pos.shared.mutators;

import caw.pos.advance.prompting.CawInputSingleChoice;
import caw.tenderauth.impl.eigen.accountlookup.op.CawAccountCardType;

import dtv.pos.iframework.form.*;
import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
import dtv.pos.shared.mutators.SimpleDependentSetFieldFilter;

/**
 * The class use to enable the field "State of Issuanc" when the user select '“Driver’s License'.
 */
public class CawSimpleDependentSetFieldFilter extends SimpleDependentSetFieldFilter {

    @Override
    public void init(IEditModel argArgParentEditModel, IEditModelField<Object> argArgField) {

        super.init(argArgParentEditModel, argArgField);
    }

    @Override
    public Object setValue(IEditModel argParentEditModel, IEditModelField<Object> argField, Object argValue) {

        if (argValue instanceof CawInputSingleChoice) {
            CawInputSingleChoice selected = (CawInputSingleChoice) argValue;
            IMutableFieldDefinition<?> parentField = (IMutableFieldDefinition<?>) argParentEditModel
                    .getFieldDef(getDependentField());
            // If the associate selects “Driver’s License” in the “Select ID Type” field, the "State of Issuanc" field is enabled.
            if (CawAccountCardType.DRIVER_LICENSE.getType().equals(selected.getInputId())) {
                // parentField.setReadOnly(false);
                parentField.setCardinality(ICardinality.REQUIRED);
            } else {
                //parentField.setReadOnly(true);
                parentField.setCardinality(ICardinality.NOT_AVAILABLE);
            }
        }

        //return super.setValue(argParentEditModel, argField, argValue);
        return argValue;
    }

}
