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
 * BZ24324          021117    Membership validation prompt should be distinguish when joining in GS club and GS RS (Roadside assistance)
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ39699          191120    [Task] Porting these fixes of xstore 6.0 patch 10.0/11.0 into Xstore 7.0 patch 1.0
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.register.ItemLocator;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.impl.NonPhysicalItemModel;

/**
 *
 */
public class CawMembershipActivityHelper {

    private static final Logger _logger              = LogManager
            .getLogger(CawMembershipActivityHelper.class);

    private static final String GOOD_SAM_ITEM_CONFIG = "/version1/GoodSamClubConfig.xml";

    private InputStream         xmlContent           = null;

    public CawMembershipActivityHelper() {
        
        super();
    }

    /**
     * The function gets content from an XML file.
     * @return
     */
    public InputStream loadXMLContent() {

        try {
            xmlContent = this.getClass()
                    .getResourceAsStream(GOOD_SAM_ITEM_CONFIG);
        } catch (Exception ex) {
            _logger.error("Cannot load data from XML file." + ex.getMessage());
        }

        return xmlContent;
    }

    /**
     * The function process parse XML content to Object
     * @return
     */
    public CawMembershipModel parseXmlToObject() {

        CawMembershipModel membershipModel = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(CawMembershipModel.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            membershipModel = (CawMembershipModel) unmarshaller
                    .unmarshal(loadXMLContent());

        } catch (JAXBException ex) {
            _logger.error("Cannot parse XML content to Object."
                    + ex.getMessage());
        }
        return membershipModel;
    }

    /**
     * The function get None physical group of by a item id.
     * @param itemId
     * @return
     */
    public String getNonPhysicalItemSubtypeByItemId(String itemId) {

        if (itemId != null && !itemId.isEmpty()) {
            IItem items = ItemLocator.getLocator().lookupItem(itemId);
            if (items != null) {
                return items.getMerchLevel4Id();
            }
        }
        return null;
    }

    /**
     * The function gets the group of the item in the XML file.
     * @param groupItem
     * @return
     */
    public CawMembershipActivityModel getGroupItemByGroupName(
            String groupItem) {

        CawMembershipActivityModel activityModel = null;
        if (groupItem != null) {
            CawMembershipModel cawMembershipModel = this.parseXmlToObject();
            if (cawMembershipModel != null
                    && cawMembershipModel.getActivities() != null
                    && cawMembershipModel.getActivities().size() > 0) {
                List<CawMembershipActivityModel> activityModels = cawMembershipModel
                        .getActivities();
                for (CawMembershipActivityModel activity : activityModels) {
                    if (groupItem.equals(activity.getName())) {
                        activityModel = activity;
                        break;
                    }
                }
            }
        }

        return activityModel;

    }

    /**
     * The function gets the group of the item in the XML file by Item Id.
     * @param itemId
     * @return
     */
    public CawMembershipActivityModel getMembershipActivity(String itemId) {

        CawMembershipActivityModel activityModel = null;
        if (itemId != null) {
            try {
                IItem iItem = ItemLocator.getLocator().lookupItem(itemId);
                if (iItem != null) {
                    String groupName = getNonPhysicalItemSubtypeByItemId(itemId);
                    if (groupName != null) {
                        activityModel = getGroupItemByGroupName(groupName);
                    }
                }
            } catch (Exception ex) {
                _logger.error("Can not found the Item Id." + itemId);
            }
        }

        return activityModel;
    }
    
    // Start BZ-39699
    /**
     * @param isRun
     * @param item
     * @return
     */
    public Boolean isExistMembershipItem(IItem item) {
        Boolean isMembershipItem = Boolean.FALSE;

        CawMembershipActivityModel activityModel;
        // Begin BZ24424
        if (item != null && item instanceof NonPhysicalItemModel
                && item.getMerchLevel4Id() != null) {
            String itemSubtype = item.getMerchLevel4Id();
            activityModel = getGroupItemByGroupName(itemSubtype);

            if (activityModel != null) {
                isMembershipItem = Boolean.TRUE;
            }
        }
        // End BZ24424
        return isMembershipItem;
    } // End BZ-39699
}
