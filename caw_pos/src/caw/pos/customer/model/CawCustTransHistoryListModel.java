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
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 *===================================================================
 */

package caw.pos.customer.model;

import java.util.*;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerHelper;

import dtv.pos.customer.CustomerMaintenanceModel;
import dtv.pos.customer.model.CustTransHistoryListModel;
import dtv.pos.customer.model.HistoryGroup.Item;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.IBusyState;
import dtv.ui.swing.lists.grouping.Group;
import dtv.ui.swing.lists.grouping.IGroupItem;
import dtv.util.DateUtils;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 *
 */
public class CawCustTransHistoryListModel extends CustTransHistoryListModel {

    private List<CustomerTransHistoryResult> _lifeTimeResultList;

    private final IParty                     party_;

    @Inject
    protected TransactionScope               _transactionScope;

    @Inject
    private IBusyState                       _busyState;

    public CawCustTransHistoryListModel(CustomerMaintenanceModel argParentModel,
            IParty argParty, boolean argIsNew) {

        super(argParentModel, argParty, argIsNew);
        this.party_ = argParty;
        this.populateLifeTimeHistoryResults();
    }

    /**
     * this function to set history list of current customer: 
     * 1. Look up history purchase scope.
     * 2. if not exist, look up API 
     */
    @Override
    protected void populateLifeTimeHistoryResults() {

        this._lifeTimeResultList = new ArrayList<CustomerTransHistoryResult>();
        String accountNumber = _transactionScope
                .getValue(CawValueKeys.ACCOUNT_API) != null
                        ? _transactionScope.getValue(CawValueKeys.ACCOUNT_API)
                        : null;
        if (this.party_ != null) {
            accountNumber = accountNumber != null ? accountNumber
                    : this.party_.getCustomerId();
            _busyState.start(CawConstants.BUSY_STATE_MSG);
            Map<String, Date> result = CawCustomerHelper.getInstance()
                    .searchCustomerPurchaseFromEBS(accountNumber, null);
            if (result != null && result.size() > 0) {
                this._lifeTimeResultList = CawCustomerHelper.getInstance()
                        .searchCustomerPurchaseDetailFromEBS(result, accountNumber);
            }
            _busyState.end();
        }

    }

    @Override
    public List<CustomerTransHistoryResult> getRollingResultList() {

        return this._lifeTimeResultList;
    }

    /**
     * override this method to find the selected item in the _lifeTimeResultList list.
     * if the item is found, set it in ITEM_SELECTED transactionScope
     */
    @Override
    public void setSelectedItem(IGroupItem argItem) {

        super.setSelectedItem(argItem);
        CustomerTransHistoryResult itemSelected = new CustomerTransHistoryResult();
        _transactionScope.clearValue(CawValueKeys.ITEM_SELECTED);
        if (super.getSelectedItem() != null) {
            Item item = (Item) super.getSelectedItem();
            for (Iterator<Group<?, ?>> group = super.getGroups()
                    .iterator(); group.hasNext();) {
                CawHistoryGroup historyGroup = (CawHistoryGroup) group.next();
                if (historyGroup.getItems().contains(item)) {
                    itemSelected = this._lifeTimeResultList.stream()
                            .filter(itemHistory -> {
                                boolean isSameDay = DateUtils
                                        .isSameDay(itemHistory
                                                .getTransactionDate(), historyGroup
                                                        .getHeader().getDate());
                                return (itemHistory.getTransSeq()
                                        .equals(historyGroup.getHeader()
                                                .getTransSeq()))
                                        && (itemHistory.getItemId()
                                                .equals(item.getItemId())
                                                && isSameDay);
                            }).findFirst().orElse(null);
                }
            }
            _transactionScope
                    .setValue(CawValueKeys.ITEM_SELECTED, itemSelected);
        }
    }

    /**
     * override this method to custom price total of group 
     */
    @Override
    protected ArrayList<Group<?, ?>> createGroups() {

        List<CustomerTransHistoryResult> data = null;
        data = super.getResultList();
        if (data == null) {
            return new ArrayList();
        } else {
            Map<PosTransactionId, CawHistoryGroup> groups = new LinkedHashMap<PosTransactionId, CawHistoryGroup>();
            Iterator<CustomerTransHistoryResult> var3 = data.iterator();

            while (var3.hasNext()) {
                CustomerTransHistoryResult datum = var3.next();
                PosTransactionId mapId = new PosTransactionId();
                mapId.setOrganizationId(1000L);
                mapId.setWorkstationId(1L);
                mapId.setBusinessDate(datum.getTransactionDate());
                mapId.setRetailLocationId(Long
                        .valueOf(datum.getRetailLocationId()));
                mapId.setTransactionSequence(datum.getTransSeq());
                CawHistoryGroup g;
                if (groups.get(mapId) == null) {
                    g = new CawHistoryGroup(datum,
                            this.getGroupHeaderRenderer());
                    groups.put(mapId, g);
                }

                g = groups.get(mapId);

                g.addHistoryItem(datum, this.getGroupItemRenderer());
            }

            this.setSelectedItem((IGroupItem) null);
            return new ArrayList(groups.values());
        }
    }

}
