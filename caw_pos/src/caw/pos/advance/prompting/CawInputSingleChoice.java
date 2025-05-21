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
 *===================================================================
 */

package caw.pos.advance.prompting;

import dtv.util.ICodeInterface;

/**
 *
 */
public class CawInputSingleChoice implements ICodeInterface {

    private String _inputId;

    private String _inputLable;

    /* (non-Javadoc)
     * @see dtv.util.ICode#getCode()
     */
    @Override
    public String getCode() {

        return this.getInputId();
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(ICodeInterface argO) {

        return this.getSortOrder() - argO.getSortOrder();
    }

    /* (non-Javadoc)
     * @see dtv.util.ICodeInterface#getDescription()
     */
    @Override
    public String getDescription() {

        return this.getInputLable();
    }

    /* (non-Javadoc)
     * @see dtv.util.ICodeInterface#getSortOrder()
     */
    @Override
    public int getSortOrder() {

        return 0;
    }

    public String getInputId() {

        return _inputId;
    }

    public void setInputId(String argInputId) {

        _inputId = argInputId;
    }

    public String getInputLable() {

        return _inputLable;
    }

    public void setInputLable(String argInputLable) {

        _inputLable = argInputLable;
    }

}
