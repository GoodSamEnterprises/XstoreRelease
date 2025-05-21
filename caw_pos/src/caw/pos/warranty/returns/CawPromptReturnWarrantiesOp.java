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
 * BZ33305          181019    [New Requirement] Need changing about formatting, color, displaying on Current Warranty Plans Screen
 *===================================================================
 */
package caw.pos.warranty.returns;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.warranty.returns.PromptReturnWarrantiesOp;

public class CawPromptReturnWarrantiesOp extends PromptReturnWarrantiesOp {

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
        IFormattable[] args = new IFormattable[1];

        args[0] = _ff.getTranslatable("+WARRANTY_TITLE");

        return args;
    }
}
