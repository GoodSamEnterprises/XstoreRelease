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
 * BZ46381          110821    IDS Payment - Should be able to scan a barcode of IDS Customer Number and IDS WO Number when doing a RV Service Payment Search in Xstore 
 *===================================================================
 */

package caw.hardware.types;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import dtv.pos.iframework.event.IXstEventType;

/**
 *
 */
public class CawInputType implements IXstEventType, Serializable{
    private static final long serialVersionUID = 1L;
    public static final CawInputType INPUT_RV_PAYMENT = new CawInputType("INPUT_RV_PAYMENT");
    private static Map<String, CawInputType> values_;
    private final String name_;
    public static CawInputType createForName(String argName) {
        if (argName == null) {
            return null;
        } else {
            CawInputType found = values_.get(argName.trim().toUpperCase());
            if (found == null) {
                synchronized (CawInputType.class) {
                    found = new CawInputType(argName);
                }
            }

            return found;
        }
    }

    public static CawInputType forName(String argName) {
        if (argName == null) {
            return null;
        } else {
            CawInputType found = values_.get(argName.trim().toUpperCase());
            if (found == null) {
            }
            return found;
        }
    }

    protected CawInputType(String argName) {
        this.name_ = argName.trim().toUpperCase();
        if (values_ == null) {
            values_ = new HashMap<String, CawInputType>();
        }

        values_.put(this.name_, this);
    }

    public String getName() {
        return this.name_;
    }

    @Override
    public String toString() {
        return this.name_;
    }

    Object readResolve() {
        Object o = forName(this.name_);
        if (o == null) {
            return this;
        } else {
            return o;
        }
    }
}
