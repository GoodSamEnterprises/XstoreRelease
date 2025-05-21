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
 * BZ23052          120917    Implement Advanced Prompting
 * B23735           051017    Duplicate property name: _catalystprompttitle in translations.properties
 * BZ31753          030719    [INTERNAL] ESB responded Response is:400 After parsing a value an unexpected character was encountered
 *===================================================================
 */

package caw.pos.advance.prompting;

import static dtv.pos.iframework.form.ICardinality.OPTIONAL;
import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import dtv.i18n.FormatterType;
import dtv.pos.framework.form.*;
import dtv.pos.framework.form.config.FieldDependencyConfig;
import dtv.pos.iframework.form.*;
import dtv.pos.iframework.security.SecuredObjectID;
import dtv.util.ICodeInterface;

/**
 *
 */
public class CawInputFormModel extends BasicEditModel {

    private static final String        INPUT_VALUE                   = "inputValue";

    private static final String        INPUT_LABLE_PROMPT            = "inputLabelPrompt"; /*BZ31753*/
    
    private static final String        INPUT_LABLE                   = "inputLable";

    private static final String        FIELD_STATUS                  = "multipleList";

    private static final String        SINGLE_LIST                   = "singleList";

    public static final String         TASKS_FIELD                   = "tasksModel";

    private List<CawInputSingleChoice> multipleList                  = new ArrayList<CawInputSingleChoice>();

    private ICodeInterface             _singleList;

    private String                     _inputValue;

    private String                     _inputLable;
    
    private String                     _inputLabelPrompt; /*BZ31753*/

    private String                     answer;

    private Integer                    type;

    private Boolean                    isCallback;

    private String                     id;

    private String                     description;

    /** The Constant CUST_ACCOUNT_LIST_MODEL_FIELD. */
    public static final String         CUST_ACCOUNT_LIST_MODEL_FIELD = "custAccountListModel";

    private final IValueWrapperFactory _codeInterfaceWrapperFactory  = ValueWrapperFactory
            .makeWrapperFactory(CodeEnumValueWrapper.class);

    @SuppressWarnings("unchecked")
    CawInputFormModel(String promptMsg,
            List<CawInputSingleChoice> lsInputSingleSelect,
            List<String> multiSelect) {

        super(FF.getTranslatable("_promptingEngineTitle"), FF
                .getSimpleFormattable(promptMsg, FormatterType.SIMPLE));//B23735

        addField(INPUT_VALUE, String.class);
        addField(INPUT_LABLE, String.class);
        addField(INPUT_LABLE_PROMPT, String.class); /*BZ31753*/

        if (CollectionUtils.isNotEmpty(multiSelect)) {
            addField(EditModelField
                    .makeFieldDefUnsafe(this, FIELD_STATUS, List.class, ATTR_NEW, (FieldDependencyConfig) null, OPTIONAL, multiSelect, (IListFieldElementDescr) null, null, (SecuredObjectID) null));
        }

        if (CollectionUtils.isNotEmpty(lsInputSingleSelect)) {
            addField(EditModelField
                    .makeFieldDef(this, SINGLE_LIST, ICodeInterface.class, ATTR_NEW, null, ICardinality.OPTIONAL, lsInputSingleSelect, null, _codeInterfaceWrapperFactory, null));
        }

        initializeFieldState();
    }

    public String getInputValue() {

        return _inputValue;
    }

    public void setInputValue(String argInputValue) {

        _inputValue = argInputValue;
    }

    public String getInputLable() {

        return _inputLable;
    }

    public void setInputLable(String argInputLable) {

        _inputLable = argInputLable;
    }

    public ICodeInterface getSingleList() {

        return _singleList;
    }

    public void setSingleList(ICodeInterface argSingleList) {

        _singleList = argSingleList;
    }

    public List<CawInputSingleChoice> getMultipleList() {

        return multipleList;
    }

    public void setMultipleList(List<CawInputSingleChoice> argMultipleList) {

        multipleList = argMultipleList;
    }

    public String getAnswer() {

        return answer;
    }

    public void setAnswer(String argAnswer) {

        answer = argAnswer;
    }

    public Integer getType() {

        return type;
    }

    public void setType(Integer argType) {

        type = argType;
    }

    public Boolean getIsCallback() {

        return isCallback;
    }

    public void setIsCallback(Boolean argIsCallback) {

        isCallback = argIsCallback;
    }

    public String getId() {

        return id;
    }

    public void setId(String argId) {

        id = argId;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String argDescription) {

        description = argDescription;
    }

    /* Begin BZ31753 */
    /**
     * @return the inputLableNew
     */
    public String getInputLabelPrompt() {
        return _inputLabelPrompt;
    }

    /**
     * @param argInputLableNew the inputLableNew to set
     */
    public void setInputLabelPrompt(String argInputLabelPrompt) {
        _inputLabelPrompt = argInputLabelPrompt;
    }
    /* End BZ31753 */
}
