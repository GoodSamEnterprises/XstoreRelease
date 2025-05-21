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
 * BZ44528          130821    Electric World & Mobile POS Implementation(Phase 1)
 *===================================================================
 */

package caw.pos.wondersign.model;

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

import caw.pos.advance.prompting.CawInputSingleChoice;
import caw.pos.common.CawConstants;
import caw.pos.common.CawUtilFunction;
import caw.pos.wondersign.util.CawWonderSignHelper;

import dtv.pos.framework.form.*;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.form.*;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.util.ICodeInterface;

/**
 *
 */
public class CawWonderSignSearchFormModel extends BasicEditModel {

    public static final String         EMPTY_STRING                 = "";

    private final IValueWrapperFactory _codeInterfaceWrapperFactory = ValueWrapperFactory
            .makeWrapperFactory(CodeEnumValueWrapper.class);

    public static final String         DATE_RANGE                   = "dateRange";

    public static final String         FROM_DATE                    = "fromDate";

    public static final String         TO_DATE                      = "toDate";
    
    public static final String         FIRST_NAME                   = "firstName";

    public static final String         LAST_NAME                    = "lastName";

    public static final String         PHONE_NUMBER                 = "phoneNumber";

    private Date                     _fromDate;

    private Date                     _toDate;

    private ICodeInterface             _dateRange;
    
    private String                     _firstName;

    private String                     _lastName;

    private String                     _phoneNumber;

    /**
     * 
     */
    public CawWonderSignSearchFormModel() {

        super(FF.getTranslatable("_cawCartSearchTitle"), FF.getTranslatable("_cawCartSearchMsg"));

        addField(FROM_DATE, Date.class);
        addField(TO_DATE, Date.class);
        addField(FIRST_NAME, String.class);
        addField(LAST_NAME, String.class);
        addField(PHONE_NUMBER, String.class);

        addField(EditModelField.makeFieldDef(this, DATE_RANGE
                , ICodeInterface.class, ATTR_NEW, null, ICardinality.OPTIONAL
                , getListDateRange(), null, _codeInterfaceWrapperFactory, null));

        setFromDate(new Date());
        setToDate(new Date());

        initializeFieldState();
    }

    
    /**
     * @return the fromDate
     */
    public Date getFromDate() {
    
        return _fromDate;
    }

    
    /**
     * @param argFromDate the fromDate to set
     */
    public void setFromDate(Date argFromDate) {
    
        _fromDate = argFromDate;
    }

    
    /**
     * @return the toDate
     */
    public Date getToDate() {
    
        return _toDate;
    }

    
    /**
     * @param argToDate the toDate to set
     */
    public void setToDate(Date argToDate) {
    
        _toDate = argToDate;
    }

    public List<CawInputSingleChoice> getListDateRange() {

        List<CawInputSingleChoice> dateRanges = new ArrayList<CawInputSingleChoice>();

        CawInputSingleChoice element = new CawInputSingleChoice();
        String dateRangeIndicator = new String(CawWonderSignHelper.SPECIFIC_DATE);

        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.TODAY_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.CURRENT_WEEK_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.CURRENT_MONTH_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.CURRENT_QUARTER_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.CURRENT_YEAR_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.YESTERDAY_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.PREVIOUS_WEEK_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.PREVIOUS_MONTH_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.PREVIOUS_QUARTER_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        element = new CawInputSingleChoice();
        dateRangeIndicator = new String(CawWonderSignHelper.PREVIOUS_YEAR_PRE);
        element.setInputId(dateRangeIndicator);
        element.setInputLable(dateRangeIndicator + CawConstants.SPACE_SIGN  + CawWonderSignHelper.getStringDateRange(dateRangeIndicator));
        dateRanges.add(element);

        return dateRanges;
    }

    /**
     * @return the dateRange
     */
    public ICodeInterface getDateRange() {

        return _dateRange;
    }

    /**
     * @param argDateRange the dateRange to set
     */
    @SuppressWarnings("unchecked")
    public void setDateRange(ICodeInterface argDateRange) {

        Date now = new Date();

        if (argDateRange != null && !argDateRange.getDescription()
                .startsWith(CawWonderSignHelper.SPECIFIC_DATE)) {

            String dateRangeIndicator = argDateRange.getDescription();

            IEditModelField<Date> fromDateField = (getFieldDef(FROM_DATE));
            IEditModelField<Date> toDateField = (getFieldDef(TO_DATE));

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.TODAY_PRE)) {
                fromDateField.setValue(now);
                toDateField.setValue(now);
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.CURRENT_WEEK_PRE)) {
                fromDateField.setValue(CawUtilFunction.getWeekStart(now));
                toDateField.setValue(CawUtilFunction.getWeekEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.CURRENT_MONTH_PRE)) {
                fromDateField.setValue(CawUtilFunction.getMonthStart(now));
                toDateField.setValue(CawUtilFunction.getMonthEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.CURRENT_QUARTER_PRE)) {
                fromDateField.setValue(CawUtilFunction.getQuarterStart(now));
                toDateField.setValue(CawUtilFunction.getQuarterEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.CURRENT_YEAR_PRE)) {
                fromDateField.setValue(CawUtilFunction.getYearStart(now));
                toDateField.setValue(CawUtilFunction.getYearEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.YESTERDAY_PRE)) {
                fromDateField.setValue(CawUtilFunction.getYesterday(now));
                toDateField.setValue(CawUtilFunction.getYesterday(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.PREVIOUS_WEEK_PRE)) {
                
                fromDateField.setValue(CawUtilFunction.getPreviousWeekStart(now));
                toDateField.setValue(CawUtilFunction.getPreviousWeekEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.PREVIOUS_MONTH_PRE)) {
                fromDateField.setValue(CawUtilFunction.getPreviousMonthStart(now));
                toDateField.setValue(CawUtilFunction.getPreviousMonthEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.PREVIOUS_QUARTER_PRE)) {
                fromDateField.setValue(CawUtilFunction.getPreviousQuarterStart(now));
                toDateField.setValue(CawUtilFunction.getPreviousQuarterEnd(now));
            }

            if (dateRangeIndicator.startsWith(CawWonderSignHelper.PREVIOUS_YEAR_PRE)) {
                fromDateField.setValue(CawUtilFunction.getPreviousYearStart(now));
                toDateField.setValue(CawUtilFunction.getPreviousYearEnd(now));

            }

            ((IEditModelField<?>) getFieldDef(TO_DATE)).setCardinality(ICardinality.NOT_AVAILABLE);
            ((IEditModelField<?>) getFieldDef(FROM_DATE)).setCardinality(ICardinality.NOT_AVAILABLE);

        } else {

            ((IEditModelField<?>) getFieldDef(TO_DATE)).setCardinality(ICardinality.OPTIONAL);
            ((IEditModelField<?>) getFieldDef(FROM_DATE)).setCardinality(ICardinality.OPTIONAL);

        }

        this.commitChanges();

        _dateRange = argDateRange;

    }

    /**
     * @return the firstName
     */
    public String getFirstName() {

        return _firstName;
    }

    /**
     * @param argFirstName the firstName to set
     */
    public void setFirstName(String argFirstName) {

        _firstName = argFirstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {

        return _lastName;
    }

    /**
     * @param argLastName the lastName to set
     */
    public void setLastName(String argLastName) {

        _lastName = argLastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {

        return _phoneNumber;
    }

    /**
     * @param argPhoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String argPhoneNumber) {

        _phoneNumber = argPhoneNumber;
    }
    
    @Override
    public String toString() {

        return "CawWonderSignSearchFormModel [_fromDate=" + _fromDate + ", _toDate="
                + _toDate + ", _dateRange=" + _dateRange + ", _firstName="
                + _firstName + ", _lastName=" + _lastName + ", _phoneNumber="
                + _phoneNumber + "]";
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public IValidationResultList validate() {
        
        ValidationResultList result = new ValidationResultList();
        
        IEditModelField<String> firstNameField = (getFieldDef(FIRST_NAME));
        IEditModelField<String> lastNameField = (getFieldDef(LAST_NAME));
        IEditModelField<String> phoneNumberField = (getFieldDef(PHONE_NUMBER));
        
        if (StringUtils.isEmpty(firstNameField.getValue())
            || StringUtils.isEmpty(lastNameField.getValue())
            || StringUtils.isEmpty(phoneNumberField.getValue())) {
            result.add(SimpleValidationResult.getFailed("_cawWonderSignCartSearchErrorInputMsg"));
        }
        
        return result;
    }

}
