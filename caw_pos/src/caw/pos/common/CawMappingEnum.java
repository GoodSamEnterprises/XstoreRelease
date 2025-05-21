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
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.common;

import java.util.stream.Stream;

/**
 *
 */
public enum CawMappingEnum {
    
    //UnitofMeasure ITM_ITEM_OPTIONS.UNIT_OF_MEASURE_CODE
    MEASURE_EA("EA",0),
    MEASURE_SME("SME",8192),
    MEASURE_FT2("FT2",4096),
    MEASURE_KG("KG",20487),
    MEASURE_LB("LB",1024),
    MEASURE_G("G",512),
    MEASURE_OZ("OZ",256),
    MEASURE_M("M",128),
    MEASURE_CM("CM",64),
    MEASURE_FT("FT",32),
    MEASURE_IN("IN",16),
    MEASURE_L("L",8),
    MEASURE_GAL("GAL",4),
    MEASURE_QT("QT",2),
    MEASURE_CS("CS",1);
    
    
    private final String key;

    private final int value;

    private CawMappingEnum(String argKey, int argValue) {
      this.key = argKey;
      this.value = argValue;
    }

    /**
     * @return the key
     */
    public String getKey() {
    
        return key;
    }

    /**
     * @return the value
     */
    public int getValue() {
    
        return value;
    }


    public static Stream<CawMappingEnum> stream() {
        return Stream.of(CawMappingEnum.values()); 
    }
}
