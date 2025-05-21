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
 * BZ33518          130220    [PROD] - Wholesale account set up is requiring First Name and Last Name to be included
 * BZ37057          290720    [INTERNAL] Cannot create new Order for Crew/ WHSL customer
 *===================================================================
 */

package caw.pos.shared.mutators;

import java.util.*;
import java.util.Map.Entry;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.form.IEditModelSetFieldFilter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.form.*;
import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
import dtv.util.StringUtils;

/**
 *
 */
public class CawCheckCreateCustFields implements IEditModelSetFieldFilter<Object> {

    private Map<String, String> dependentFields = new HashMap<String, String>();
    @Inject
    protected TransactionScope  _transactionScope;//BZ33518
    
    @Override
    public void init(IEditModel argVar1, IEditModelField<Object> argVar2) {
        setValue(argVar1, argVar2, argVar1.getValue(argVar2.getFieldKey()));
    }

    /**
     * 
     * @param argDependencyProps
     */
    public void setDependencyProps(Properties argDependencyProps) {

        Set<Entry<Object, Object>> fields = argDependencyProps.entrySet();
        fields.stream().forEach(field -> {
            dependentFields.put((String) field.getKey(), (String) field.getValue());
        });
    }

    @Override
    public Object setValue(IEditModel argVar1, IEditModelField<Object> argVar2, Object argVar3) {
        dependentFields.entrySet().forEach(dependentField -> {
            IMutableFieldDefinition<?> parentField = (IMutableFieldDefinition<?>) argVar1
                    .getFieldDef(dependentField.getKey());
            if (StringUtils.isEmpty(StringUtils.nonNull(argVar3))) {
                emptyBehavior(parentField, dependentField.getValue());
            } else {
                notEmptyBehavior(parentField, dependentField.getValue());
            }
        });
        return argVar3;
    }

    /**
     * CompanyName field not empty: disable fields with (EnableRequired, Enable), enable fields with (Disable)
     * @param argParentField
     * @param argValue
     */
    private void notEmptyBehavior(IMutableFieldDefinition<?> argParentField, String argValue) {
        if (!argParentField.isReadOnly()) {
            /*BEGIN BZ37057 - Change boolean to Boolean */
            Boolean isScreenNewCustomer = _transactionScope.getValue(CawValueKeys.IS_ADD_NEW_CUST_ASSOC);
            /*END BZ37057*/
            if ("EnableRequired".equalsIgnoreCase(argValue)) {
                /*BEGIN BZ35298*/
                if (Boolean.TRUE.equals(isScreenNewCustomer)) {
                    argParentField.removeValue();
                }
                /*END BZ35298*/
                argParentField.setCardinality(ICardinality.NOT_AVAILABLE);
            } else if ("Enable".equalsIgnoreCase(argValue)) {
                /*BEGIN BZ35298*/
                if (Boolean.TRUE.equals(isScreenNewCustomer)) {
                    argParentField.removeValue();
                }
                /*END BZ35298*/
                argParentField.setCardinality(ICardinality.NOT_AVAILABLE);
            } else if ("Disable".equalsIgnoreCase(argValue)) {
                argParentField.unremoveValue();
                argParentField.setCardinality(ICardinality.REQUIRED);
            }
        }
    }

    /**
     * CompanyName field empty: enable fields with (EnableRequired, Enable), disable fields with (Disable)
     * @param parentField
     * @param value
     */
    protected void emptyBehavior(IMutableFieldDefinition<?> parentField, String value) {

        if ("EnableRequired".equalsIgnoreCase(value)) {
            parentField.unremoveValue();
            parentField.setCardinality(ICardinality.REQUIRED);
        } else if ("Enable".equalsIgnoreCase(value)) {
            parentField.unremoveValue();
            parentField.setCardinality(ICardinality.OPTIONAL);
        } else if ("Disable".equalsIgnoreCase(value)) {
            parentField.removeValue();
            parentField.setCardinality(ICardinality.NOT_AVAILABLE);
        }
    }

}
