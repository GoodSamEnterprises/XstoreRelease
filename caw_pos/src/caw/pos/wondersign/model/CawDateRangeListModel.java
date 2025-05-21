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
 * BZ44528          130821    Electric World & Mobile POS Implementation(Phase 1)
 *===================================================================
 */

package caw.pos.wondersign.model;

import java.util.ArrayList;
import java.util.List;

import dtv.pos.framework.ui.model.DefaultListInputModel;
import dtv.ui.UIServices;

/**
 *
 */
public class CawDateRangeListModel extends DefaultListInputModel {

    private List<String> _dateRanges = new ArrayList<>();

    /**
     * @return the dateRanges
     */
    public List<String> getDateRanges() {

        return _dateRanges;
    }

    /**
     * @param argDateRanges the dateRanges to set
     */
    public void setDateRanges(final List<String> argDateRanges) {

        _dateRanges = argDateRanges;

        UIServices.invoke(new Runnable() {

            @Override
            public void run() {

                CawDateRangeListModel.this.getModel().setElements(argDateRanges);
                CawDateRangeListModel.this.getSelectionModel().selectFirst();
            }
        }, true);
    }

}
