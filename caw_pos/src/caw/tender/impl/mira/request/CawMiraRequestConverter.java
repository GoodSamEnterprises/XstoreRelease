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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23164              100917    [DEV] Implement EMV Payment Integration
 *== ================================================================
 */

package caw.tender.impl.mira.request;

import caw.tender.impl.mira.CawMiraFormatter;

import dtv.tenderauth.IAuthRequest;
import dtv.tenderauth.impl.AbstractRequestConverter;

public class CawMiraRequestConverter extends AbstractRequestConverter {

    private static CawMiraFormatter _formatter = new CawMiraFormatter();

    /** {@inheritDoc} */
    @Override
    protected Object convertRequestImpl(IAuthRequest argParamIAuthRequest) {

        return _formatter.formatConnectorMessage(argParamIAuthRequest);
    }
}
