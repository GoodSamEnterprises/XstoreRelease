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
 * BZ24417          201117    No action is displayed when pressing 'Back' on Dashboard screen in BO
 *===================================================================
 */

package caw.hardware.service;

import com.micros.xstore.config.IConfigMgr;
import com.micros.xstore.config.action.ActionSet;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.action.XstActionFactory;
import dtv.pos.framework.action.type.XstChainActionType;
import dtv.pos.framework.action.type.XstKeyStroke;
import dtv.pos.iframework.action.IXstAction;

/**
 *
 */
public class CawXstActionFactory extends XstActionFactory {

    /**
     * 
     */
    public CawXstActionFactory(IConfigMgr<ActionSet> argConfigMgr) {

        super(argConfigMgr);
    }

    @Override
    public IXstAction getHelpAction() {

        IXstAction helpAction = null;
        XstKeyStroke helpKey = dtv.pos.common.ConfigurationMgr.getHelpKey();

        if (helpKey != null) {
            helpAction = getChainAction(OpChainKey.valueOf("HELP"), XstChainActionType.STACK);
            helpAction.setActionNameKey("_help");
            helpAction.setKeyStroke(helpKey.getKeyStroke());
            helpAction.setVisible(false);//BZ24224
            helpAction.setEnabled(false);//BZ24224
        }
        return helpAction;
    }

}