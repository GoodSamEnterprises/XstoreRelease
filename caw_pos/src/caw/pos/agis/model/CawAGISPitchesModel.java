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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 * BZ62146          060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.agis.model;

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;

import java.util.*;
import java.util.stream.*;

import org.apache.commons.collections.CollectionUtils;

import caw.pos.common.CawConstants;

import dtv.pos.framework.form.*;
import dtv.pos.iframework.form.*;
import dtv.util.ICodeInterface;

/**
 *
 */
public class CawAGISPitchesModel extends BasicEditModel{
    
    public static final String PITCH_GROUP_NAME_1 = "pitchGroupName1";
    public static final String PITCH_GROUP_NAME_2 = "pitchGroupName2";
    public static final String PITCH_GROUP_NAME_3 = "pitchGroupName3";
    public static final String PITCH_GROUP_NAME_4 = "pitchGroupName4";
    public static final String PITCH_GROUP_NAME_5 = "pitchGroupName5";
    public static final String PITCH_GROUP_NAME_6 = "pitchGroupName6";
    public static final String PITCH_GROUP_NAME_7 = "pitchGroupName7";
    public static final String PITCH_GROUP_NAME_8 = "pitchGroupName8";
    public static final String PITCH_GROUP_NAME_9 = "pitchGroupName9";
    public static final String PITCH_GROUP_NAME_10 = "pitchGroupName10";
    
    public static final String COMBO_BOX_GROUP_1 = "comboBoxGroup1";
    public static final String COMBO_BOX_GROUP_2 = "comboBoxGroup2";
    public static final String COMBO_BOX_GROUP_3 = "comboBoxGroup3";
    public static final String COMBO_BOX_GROUP_4 = "comboBoxGroup4";
    public static final String COMBO_BOX_GROUP_5 = "comboBoxGroup5";
    public static final String COMBO_BOX_GROUP_6 = "comboBoxGroup6";
    public static final String COMBO_BOX_GROUP_7 = "comboBoxGroup7";
    public static final String COMBO_BOX_GROUP_8 = "comboBoxGroup8";
    public static final String COMBO_BOX_GROUP_9 = "comboBoxGroup9";
    public static final String COMBO_BOX_GROUP_10 = "comboBoxGroup10";

    private String pitchGroupName1;
    private String pitchGroupName2;
    private String pitchGroupName3;
    private String pitchGroupName4;
    private String pitchGroupName5;
    private String pitchGroupName6;
    private String pitchGroupName7;
    private String pitchGroupName8;
    private String pitchGroupName9;
    private String pitchGroupName10;
    
    private ICodeInterface comboBoxGroup1;
    private ICodeInterface comboBoxGroup2;
    private ICodeInterface comboBoxGroup3;
    private ICodeInterface comboBoxGroup4;
    private ICodeInterface comboBoxGroup5;
    private ICodeInterface comboBoxGroup6;
    private ICodeInterface comboBoxGroup7;
    private ICodeInterface comboBoxGroup8;
    private ICodeInterface comboBoxGroup9;
    private ICodeInterface comboBoxGroup10;
    
    
    private List<CawAGISPitchesItemModel> pitchItemsGroup1;
    private List<CawAGISPitchesItemModel> pitchItemsGroup2;
    private List<CawAGISPitchesItemModel> pitchItemsGroup3;
    private List<CawAGISPitchesItemModel> pitchItemsGroup4;
    private List<CawAGISPitchesItemModel> pitchItemsGroup5;
    private List<CawAGISPitchesItemModel> pitchItemsGroup6;
    private List<CawAGISPitchesItemModel> pitchItemsGroup7;
    private List<CawAGISPitchesItemModel> pitchItemsGroup8;
    private List<CawAGISPitchesItemModel> pitchItemsGroup9;
    private List<CawAGISPitchesItemModel> pitchItemsGroup10;
    
    
    private final IValueWrapperFactory codeInterfaceWrapperFactory = ValueWrapperFactory
            .makeWrapperFactory(CodeEnumValueWrapper.class);

    public CawAGISPitchesModel(List<CawAGISPitchesItemModel>[] groups) {
        super(FF.getTranslatable(CawConstants.CAW_AGIS_PITCHES_TITLE), 
              FF.getTranslatable(CawConstants.CAW_AGIS_PITCHES_MSG));

        for (int i = 0; i < groups.length; i++) {
            String pitchGroupName = "pitchGroupName" + (i + 1);
            addField(pitchGroupName, String.class);
        }

        for (int i = 0; i < groups.length; i++) {
            if (CollectionUtils.isNotEmpty(groups[i])) {
                String comboBoxGroup = "comboBoxGroup" + (i + 1);
                addField(EditModelField.makeFieldDef(
                    this, comboBoxGroup, ICodeInterface.class, ATTR_NEW, null, 
                    ICardinality.OPTIONAL, groups[i], null, codeInterfaceWrapperFactory, null
                ));
                setPitchItemsGroup(i, groups[i]);
            }
        }
        
        initializeFieldState();
    }
    private void setPitchItemsGroup(int index, List<CawAGISPitchesItemModel> group) {
        switch (index) {
            case 0: setPitchItemsGroup1(group); break;
            case 1: setPitchItemsGroup2(group); break;
            case 2: setPitchItemsGroup3(group); break;
            case 3: setPitchItemsGroup4(group); break;
            case 4: setPitchItemsGroup5(group); break;
            case 5: setPitchItemsGroup6(group); break;
            case 6: setPitchItemsGroup7(group); break;
            case 7: setPitchItemsGroup8(group); break;
            case 8: setPitchItemsGroup9(group); break;
            case 9: setPitchItemsGroup10(group); break;
            default: throw new IllegalArgumentException("Unsupported group index: " + index);
        }
    }


    protected void addSimpleFields() {
        addField(PITCH_GROUP_NAME_1, String.class);
        addField(COMBO_BOX_GROUP_1, String.class);
        addField(PITCH_GROUP_NAME_2, String.class);
        addField(COMBO_BOX_GROUP_2, String.class);
    }

    public String getPitchGroupName1() {

        return pitchGroupName1;
    }

    public void setPitchGroupName1(String argPitchGroupName1) {

        this.pitchGroupName1 = argPitchGroupName1;
    }

    public String getPitchGroupName2() {

        return pitchGroupName2;
    }

    public void setPitchGroupName2(String argPitchGroupName2) {

        this.pitchGroupName2 = argPitchGroupName2;
    }

    public ICodeInterface getComboBoxGroup1() {

        return comboBoxGroup1;
    }

    public void setComboBoxGroup1(ICodeInterface argComboBoxGroup1) {

        this.comboBoxGroup1 = argComboBoxGroup1;
    }

    public ICodeInterface getComboBoxGroup2() {

        return comboBoxGroup2;
    }

    public void setComboBoxGroup2(ICodeInterface argComboBoxGroup2) {

        this.comboBoxGroup2 = argComboBoxGroup2;
    }

    public List<CawAGISPitchesItemModel> getPitchItemsGroup1() {

        return pitchItemsGroup1;
    }

    public void setPitchItemsGroup1(List<CawAGISPitchesItemModel> group1) {

        this.pitchItemsGroup1 = group1;
    }

    public List<CawAGISPitchesItemModel> getPitchItemsGroup2() {

        return pitchItemsGroup2;
    }

    public void setPitchItemsGroup2(List<CawAGISPitchesItemModel> group2) {

        this.pitchItemsGroup2 = group2;
    }
    
    
    /**
     * @return the pitchGroupName3
     */
    public String getPitchGroupName3() {
    
        return pitchGroupName3;
    }

    
    /**
     * @param argPitchGroupName3 the pitchGroupName3 to set
     */
    public void setPitchGroupName3(String argPitchGroupName3) {
    
        pitchGroupName3 = argPitchGroupName3;
    }

    
    /**
     * @return the pitchGroupName4
     */
    public String getPitchGroupName4() {
    
        return pitchGroupName4;
    }

    
    /**
     * @param argPitchGroupName4 the pitchGroupName4 to set
     */
    public void setPitchGroupName4(String argPitchGroupName4) {
    
        pitchGroupName4 = argPitchGroupName4;
    }

    
    /**
     * @return the pitchGroupName5
     */
    public String getPitchGroupName5() {
    
        return pitchGroupName5;
    }

    
    /**
     * @param argPitchGroupName5 the pitchGroupName5 to set
     */
    public void setPitchGroupName5(String argPitchGroupName5) {
    
        pitchGroupName5 = argPitchGroupName5;
    }

    
    /**
     * @return the pitchGroupName6
     */
    public String getPitchGroupName6() {
    
        return pitchGroupName6;
    }

    
    /**
     * @param argPitchGroupName6 the pitchGroupName6 to set
     */
    public void setPitchGroupName6(String argPitchGroupName6) {
    
        pitchGroupName6 = argPitchGroupName6;
    }

    
    /**
     * @return the pitchGroupName7
     */
    public String getPitchGroupName7() {
    
        return pitchGroupName7;
    }

    
    /**
     * @param argPitchGroupName7 the pitchGroupName7 to set
     */
    public void setPitchGroupName7(String argPitchGroupName7) {
    
        pitchGroupName7 = argPitchGroupName7;
    }

    
    /**
     * @return the pitchGroupName8
     */
    public String getPitchGroupName8() {
    
        return pitchGroupName8;
    }

    
    /**
     * @param argPitchGroupName8 the pitchGroupName8 to set
     */
    public void setPitchGroupName8(String argPitchGroupName8) {
    
        pitchGroupName8 = argPitchGroupName8;
    }

    
    /**
     * @return the pitchGroupName9
     */
    public String getPitchGroupName9() {
    
        return pitchGroupName9;
    }

    
    /**
     * @param argPitchGroupName9 the pitchGroupName9 to set
     */
    public void setPitchGroupName9(String argPitchGroupName9) {
    
        pitchGroupName9 = argPitchGroupName9;
    }

    
    /**
     * @return the pitchGroupName10
     */
    public String getPitchGroupName10() {
    
        return pitchGroupName10;
    }

    
    /**
     * @param argPitchGroupName10 the pitchGroupName10 to set
     */
    public void setPitchGroupName10(String argPitchGroupName10) {
    
        pitchGroupName10 = argPitchGroupName10;
    }

    
    /**
     * @return the comboBoxGroup3
     */
    public ICodeInterface getComboBoxGroup3() {
    
        return comboBoxGroup3;
    }

    
    /**
     * @param argComboBoxGroup3 the comboBoxGroup3 to set
     */
    public void setComboBoxGroup3(ICodeInterface argComboBoxGroup3) {
    
        comboBoxGroup3 = argComboBoxGroup3;
    }

    
    /**
     * @return the comboBoxGroup4
     */
    public ICodeInterface getComboBoxGroup4() {
    
        return comboBoxGroup4;
    }

    
    /**
     * @param argComboBoxGroup4 the comboBoxGroup4 to set
     */
    public void setComboBoxGroup4(ICodeInterface argComboBoxGroup4) {
    
        comboBoxGroup4 = argComboBoxGroup4;
    }

    
    /**
     * @return the comboBoxGroup5
     */
    public ICodeInterface getComboBoxGroup5() {
    
        return comboBoxGroup5;
    }

    
    /**
     * @param argComboBoxGroup5 the comboBoxGroup5 to set
     */
    public void setComboBoxGroup5(ICodeInterface argComboBoxGroup5) {
    
        comboBoxGroup5 = argComboBoxGroup5;
    }

    
    /**
     * @return the comboBoxGroup6
     */
    public ICodeInterface getComboBoxGroup6() {
    
        return comboBoxGroup6;
    }

    
    /**
     * @param argComboBoxGroup6 the comboBoxGroup6 to set
     */
    public void setComboBoxGroup6(ICodeInterface argComboBoxGroup6) {
    
        comboBoxGroup6 = argComboBoxGroup6;
    }

    
    /**
     * @return the comboBoxGroup7
     */
    public ICodeInterface getComboBoxGroup7() {
    
        return comboBoxGroup7;
    }

    
    /**
     * @param argComboBoxGroup7 the comboBoxGroup7 to set
     */
    public void setComboBoxGroup7(ICodeInterface argComboBoxGroup7) {
    
        comboBoxGroup7 = argComboBoxGroup7;
    }

    
    /**
     * @return the comboBoxGroup8
     */
    public ICodeInterface getComboBoxGroup8() {
    
        return comboBoxGroup8;
    }

    
    /**
     * @param argComboBoxGroup8 the comboBoxGroup8 to set
     */
    public void setComboBoxGroup8(ICodeInterface argComboBoxGroup8) {
    
        comboBoxGroup8 = argComboBoxGroup8;
    }

    
    /**
     * @return the comboBoxGroup9
     */
    public ICodeInterface getComboBoxGroup9() {
    
        return comboBoxGroup9;
    }

    
    /**
     * @param argComboBoxGroup9 the comboBoxGroup9 to set
     */
    public void setComboBoxGroup9(ICodeInterface argComboBoxGroup9) {
    
        comboBoxGroup9 = argComboBoxGroup9;
    }

    
    /**
     * @return the comboBoxGroup10
     */
    public ICodeInterface getComboBoxGroup10() {
    
        return comboBoxGroup10;
    }

    
    /**
     * @param argComboBoxGroup10 the comboBoxGroup10 to set
     */
    public void setComboBoxGroup10(ICodeInterface argComboBoxGroup10) {
    
        comboBoxGroup10 = argComboBoxGroup10;
    }

    
    /**
     * @return the pitchItemsGroup3
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup3() {
    
        return pitchItemsGroup3;
    }

    
    /**
     * @param argPitchItemsGroup3 the pitchItemsGroup3 to set
     */
    public void setPitchItemsGroup3(
            List<CawAGISPitchesItemModel> argPitchItemsGroup3) {
    
        pitchItemsGroup3 = argPitchItemsGroup3;
    }

    
    /**
     * @return the pitchItemsGroup4
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup4() {
    
        return pitchItemsGroup4;
    }

    
    /**
     * @param argPitchItemsGroup4 the pitchItemsGroup4 to set
     */
    public void setPitchItemsGroup4(
            List<CawAGISPitchesItemModel> argPitchItemsGroup4) {
    
        pitchItemsGroup4 = argPitchItemsGroup4;
    }

    
    /**
     * @return the pitchItemsGroup5
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup5() {
    
        return pitchItemsGroup5;
    }

    
    /**
     * @param argPitchItemsGroup5 the pitchItemsGroup5 to set
     */
    public void setPitchItemsGroup5(
            List<CawAGISPitchesItemModel> argPitchItemsGroup5) {
    
        pitchItemsGroup5 = argPitchItemsGroup5;
    }

    
    /**
     * @return the pitchItemsGroup6
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup6() {
    
        return pitchItemsGroup6;
    }

    
    /**
     * @param argPitchItemsGroup6 the pitchItemsGroup6 to set
     */
    public void setPitchItemsGroup6(
            List<CawAGISPitchesItemModel> argPitchItemsGroup6) {
    
        pitchItemsGroup6 = argPitchItemsGroup6;
    }

    
    /**
     * @return the pitchItemsGroup7
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup7() {
    
        return pitchItemsGroup7;
    }

    
    /**
     * @param argPitchItemsGroup7 the pitchItemsGroup7 to set
     */
    public void setPitchItemsGroup7(
            List<CawAGISPitchesItemModel> argPitchItemsGroup7) {
    
        pitchItemsGroup7 = argPitchItemsGroup7;
    }

    
    /**
     * @return the pitchItemsGroup8
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup8() {
    
        return pitchItemsGroup8;
    }

    
    /**
     * @param argPitchItemsGroup8 the pitchItemsGroup8 to set
     */
    public void setPitchItemsGroup8(
            List<CawAGISPitchesItemModel> argPitchItemsGroup8) {
    
        pitchItemsGroup8 = argPitchItemsGroup8;
    }

    
    /**
     * @return the pitchItemsGroup9
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup9() {
    
        return pitchItemsGroup9;
    }

    
    /**
     * @param argPitchItemsGroup9 the pitchItemsGroup9 to set
     */
    public void setPitchItemsGroup9(
            List<CawAGISPitchesItemModel> argPitchItemsGroup9) {
    
        pitchItemsGroup9 = argPitchItemsGroup9;
    }

    
    /**
     * @return the pitchItemsGroup10
     */
    public List<CawAGISPitchesItemModel> getPitchItemsGroup10() {
    
        return pitchItemsGroup10;
    }

    
    /**
     * @param argPitchItemsGroup10 the pitchItemsGroup10 to set
     */
    public void setPitchItemsGroup10(
            List<CawAGISPitchesItemModel> argPitchItemsGroup10) {
    
        pitchItemsGroup10 = argPitchItemsGroup10;
    }

    public List<String> getAllItemIds() {
        return Stream.concat(
                Optional.ofNullable(pitchItemsGroup1).orElse(Collections.emptyList()).stream(),
                Optional.ofNullable(pitchItemsGroup2).orElse(Collections.emptyList()).stream()
            )
            .map(CawAGISPitchesItemModel::getItemCode)
            .collect(Collectors.toList());
    }
    
}
