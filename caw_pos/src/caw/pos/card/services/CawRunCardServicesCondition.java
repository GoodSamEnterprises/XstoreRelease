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
 * BZ25435          160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 *===================================================================
 */

package caw.pos.card.services;

import org.apache.commons.lang3.StringUtils;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.AbstractRunCondition;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;

/**
 * The class check configuraton is set to allow ability to point to the Prompting 
 * Engine (PE) services or CardSevices API (specific only Submit,Satus).
 * If CODE is CARD_SERVICES then run Card Services API.
 * If CODE is PROMPTING_ENGINE then run Prompting Engine API.
 * If CODE is set different than 2 value above then there are no calls PE/ Card Services
 * (Submit/Status) execution trigger at either Customer Identified or Transaction Total catalyst.
 * 
 */
public class CawRunCardServicesCondition extends AbstractRunCondition {

    private static final String PROMPTING_ENGINE            = "PROMPTING_ENGINE";

    private static final String CARD_SEVICES                = "CARD_SERVICES";

    private static final String PARAM_SEVICES_CODE          = "ServicesCode";

    private static final String CAT_DECOUPLE_PE_CARDSERVICE = "CAW_DECOUPLE_PE_CARDSERVICE";

    private String              sevicesCode                 = "";

    @Override
    public void setParameter(String argKey, String argValue) {

        if (PARAM_SEVICES_CODE.equalsIgnoreCase(argKey)
                && StringUtils.isNotEmpty(argValue)) {
            sevicesCode = argValue;
        } else {
            super.setParameter(argKey, argValue);
        }

    }

    @Override
    protected boolean shouldRunImpl() {

        if (PROMPTING_ENGINE.equalsIgnoreCase(sevicesCode)
                || CARD_SEVICES.equalsIgnoreCase(sevicesCode)) {
            ICodeValue iCodeValue = CodeLocator.getCodeValue(ConfigurationMgr
                    .getOrganizationId(), CAT_DECOUPLE_PE_CARDSERVICE, sevicesCode);

            if (iCodeValue != null) {
                return true;
            }
        }

        return false;
    }

}
