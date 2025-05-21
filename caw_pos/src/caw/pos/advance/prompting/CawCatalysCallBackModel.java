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
 * BZ23052          210917    Implement Advanced Prompting
 *===================================================================
 */

package caw.pos.advance.prompting;

/**
 *
 */
public class CawCatalysCallBackModel {

    private String  id;

    private Integer type;

    private String  description;

    private String  label;

    private String  choices;

    private Boolean isCallbackRequired;

    private String  answer;

    public String getId() {

        return id;
    }

    public void setId(String argId) {

        id = argId;
    }

    public Integer getType() {

        return type;
    }

    public void setType(Integer argType) {

        type = argType;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String argDescription) {

        description = argDescription;
    }

    public String getLabel() {

        return label;
    }

    public void setLabel(String argLabel) {

        label = argLabel;
    }

    public String getChoices() {

        return choices;
    }

    public void setChoices(String argChoices) {

        choices = argChoices;
    }

    public Boolean getIsCallbackRequired() {

        return isCallbackRequired;
    }

    public void setIsCallbackRequired(Boolean argIsCallbackRequired) {

        isCallbackRequired = argIsCallbackRequired;
    }

    public String getAnswer() {

        return answer;
    }

    public void setAnswer(String argAnswer) {

        answer = argAnswer;
    }

}
