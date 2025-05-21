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
 * PAYMENT          070917    Payment-Item Display
 * BZ24019          161017    [Technical issue] - Empty method
 * BZ24018          171017    [Technical issue] - Empty if statement
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ26270          290618    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28401          211118    [Internal] Item displayed twice on PINPAD screen when adding a discount to the item
 * BZ28375          231118    [2.9.4] The number of items displayed incorrect on PIN PAD when changing qty number then void line item
 * BZ28407          281118    [Internal] PINPAD doesn't show full items when item has quantity >1
 * BZ28562          071218    PINPAD doesn't reload items once complete transaction by partial Credit card
 * BZ28564          101218    Item on Xstore displays inconsistency on PIN PAD when doing void line tender New Good Sam Visa
 * BZ28561          131218    [PINPAD] Items is overwriting on Gander Outdoor idle screen
 * BZ29383          190219    [Internal] GS Account Inquiry form on the PinPad does not go away after selecting Back/Esc.
 * BZ48120          180122    Pinpad shows Thank You message on top of line items after assigning customer during a sale transaction
 *===================================================================
 */

package caw.tenderauth.impl.eigen.model;

import static dtv.data2.access.ModelEventor.PRIVILEGED_EVENT_DESCRIPTOR_NAME;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import caw.pos.common.CawUtilFunction;
import caw.pos.transaction.model.CawCurrentTransactionAmtModel;
import caw.pos.transaction.model.CawCurrentTransactionModel;
import caw.tenderauth.impl.eigen.*;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.event.*;
import dtv.event.constraint.NameConstraint;
import dtv.pos.framework.form.*;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.framework.ui.model.IndirectField;
import dtv.pos.iframework.form.*;
import dtv.pos.iframework.security.SecuredObjectID;
import dtv.pos.register.DefaultLineItemFilter;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.daocommon.ILineItemFilter;
import dtv.xst.daocommon.IRetailTransactionManager;

/**
 *
 */
public class CawTransactionListEditModel extends BasicListEditModel {

    public static final String                                    CAW_TRANSACTION_FIELD_KEY         = "transaction";

    public static final String                                    CAW_TRANSACTION_ID_FIELD_KEY      = "transactionSequence";

    public static final EventDescriptor                           SALE_LINE_ITEM_DESCRIPTOR_NAME    = new EventDescriptor(
            "dtv.xst.dao.trl.impl.SaleReturnLineItemModel");

    public static final EventDescriptor                           VOUCHER_LINE_ITEM_DESCRIPTOR_NAME = new EventDescriptor(
            "dtv.xst.dao.trl.impl.VoucherSaleLineItemModel");

    private static final IEditModelFieldMetadata<IPosTransaction> tranFieldDescr_                   = new EditModelFieldMetadata<IPosTransaction>(
            CAW_TRANSACTION_FIELD_KEY, IPosTransaction.class, 0, ICardinality.OPTIONAL, null, null, null, null,
            (SecuredObjectID) null);

    @Inject
    private EventManager                                          _eventManager;

    private final List<String>                                    transactionFieldKeys_             = new ArrayList<String>();

    private final ILineItemFilter                                 lineItemFilter_                   = new DefaultLineItemFilter();

    private EventDescriptor                                       privilegedDescriptor;

    // higher visibility to aid access from inner class
    protected IPosTransaction                                     emTransaction_;

    // higher visibility to aid access from inner class
    int                                                           currentSelection_;

    // higher visibility to aid access from inner class
    int                                                           currentItemCount_;

    private ValueKey<?>                                           _transactionValueKey;

    @Inject
    private TransactionScope                                      _transactionScope;

    @Inject
    private CawEigenMgr                                           _cawEigenMgr;

    private ConcurrentLinkedQueue<Event>                          eventList                         = new ConcurrentLinkedQueue<Event>();

    private ConcurrentLinkedQueue<Event>                          eventListForPrivileged            = new ConcurrentLinkedQueue<Event>();

    private static final Logger                                   logger_                           = Logger
            .getLogger(CawTransactionListEditModel.class);

    public static CawCurrentTransactionAmtModel                   _cawCurrentTransAmtModel          = new CawCurrentTransactionAmtModel();

    // Begin BZ27344
    private Queue<CawPinpadItemModel>                             _itemNeedUpdateQueue              = new LinkedList<CawPinpadItemModel>();

    @Inject
    private CawEigenHelper                                        _cawEigenHelper;
    // End BZ27344
    /*BEGIN BZ48120*/
    private long                                                  beforeTime;

    private static final long                                     CAW_PINPAD_ITEMS_DISPLAY_TIMEOUT  = 120000;

    /*END BZ48120*/
    public CawTransactionListEditModel() {

        this(TransactionScope.CURRENT_TRANSACTION, null);
    }

    public CawTransactionListEditModel(ValueKey<? extends IPosTransaction> argValueKey) {

        this(argValueKey, null);
    }

    /**
     * Returns the transaction whose data is currently being modeled.
     * @return the transaction whose data is currently being modeled
     */
    public IPosTransaction getTransaction() {

        return emTransaction_;
    }

    public void init() {

        /* Register for interest in events indicating that a new transaction of a specific type has been assigned
         * to the station model. */
        _eventManager.registerEventHandler(newTransactionListener_, _transactionScope.getEventSource(), //
                        new NameConstraint(_transactionValueKey));
    }

    public CawTransactionListEditModel(ValueKey<? extends IPosTransaction> argValueKey, BasicEditModel argDelegate) {

        super(argDelegate);

        _transactionValueKey = argValueKey;
        addField(CAW_TRANSACTION_FIELD_KEY, IPosTransaction.class);
        addTransactionField(CAW_TRANSACTION_ID_FIELD_KEY, Long.class);
        initializeFieldState();
    }

    /**
     * Does nothing, but needs to be here because it will be invoked reflectively.
     * @param newValue New transaction to ignore.
     */
    public void setTransaction(IPosTransaction newValue) {

        logger_.info("Does nothing, but needs to be here because it will be invoked reflectively.");
    }

    /**
     * Adds to this model an i
     * @param argFieldKey
     * @param argFieldDataType
     */
    protected <T> void addTransactionField(String argFieldKey, Class<T> argFieldDataType) {

        IEditModelField<T> fieldDef = IndirectField.makeFieldDef(this, tranFieldDescr_, argFieldKey, argFieldDataType);

        transactionFieldKeys_.add(argFieldKey);
        addField(fieldDef);
    }

    @Override
    protected ILineItemFilter getLineItemFilter() {

        return lineItemFilter_;
    }

    protected IEventAware getTransactionEventListener() {

        return transactionListener_;
    }

    private synchronized void processSuspendTransaction(IRetailTransaction argEmTransaction) {

        IPosTransaction tranx = _transactionScope.getTransaction();
        String sAmountDue = CawUtilFunction.vString(tranx.getAmountDue());
        String sTaxAmount = CawUtilFunction.vString(tranx.getTaxAmount());

        List<IRetailTransactionLineItem> saleLineItems = argEmTransaction.getSaleLineItems();
        ISaleReturnLineItem saleLineItm;
        for (IRetailTransactionLineItem saleLineItem : saleLineItems) {
            if (saleLineItem instanceof ISaleReturnLineItem) {

                saleLineItm = (ISaleReturnLineItem) saleLineItem;
                addPinpadCurrentModel(saleLineItm, sAmountDue, sTaxAmount);

            }
        }

    }

    /**
     * process events after transaction updated.
     */
    protected synchronized void processEventListForPrivileged() {

        //clear events when finishing.
        eventListForPrivileged.clear();
    }

    /**
     * process events after transaction updated.
     */
    protected synchronized void processEventList() {

        Event argEvent;
        Object eventName;
        // Begin BZ27344
        boolean flagCreateOrUpdate = false;
        _itemNeedUpdateQueue.clear();
        // End BZ27344

        int size = eventList.size();
        while (size > 0) {
            /*BEGIN BZ48120*/
            long currentTime = System.currentTimeMillis();
            if(beforeTime > 0 && currentTime - beforeTime >= CAW_PINPAD_ITEMS_DISPLAY_TIMEOUT) {
                _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                eventList.clear();
                beforeTime = currentTime;
                break;
            }
            beforeTime = currentTime;
            /*END BZ48120*/
            
            argEvent = eventList.poll();
            size = eventList.size();
            eventName = argEvent.getName();

            if (eventName == IRetailTransactionManager.TRANSACTION_UPDATED) {
                handleUpdateTransaction(argEvent);
                flagCreateOrUpdate = true; //BZ27344
            } else if (eventName == IPosTransaction.ADD_RETAILTRANSACTIONLINEITEMS
                    || eventName == ISaleReturnLineItem.ADD_RETAILPRICEMODIFIERS) {
                handleAddLineItem(argEvent);
                flagCreateOrUpdate = true; //BZ27344
            } else if (eventName == IPosTransaction.REMOVE_RETAILTRANSACTIONLINEITEMS) {
                handleRemoveLineItem(argEvent);
            } else if (eventName == IRetailTransactionLineItem.SET_VOID || eventName == IRetailPriceModifier.SET_VOID) {
                handleSetVoidLineItem(argEvent);
            }
        }
        //clear events when finishing.
        eventList.clear();
        size = eventList.size();

        // Begin BZ27344
        if (_cawEigenMgr.allowDisplayLineItemPP() && flagCreateOrUpdate) {
            allowDisplayLineItem();
        }
        // End BZ27344
    }

    protected void allowDisplayLineItem() {
  
        /* Begin BZ28561, BZ29383 */
        /* Check flag when enter input of Pinpad to remove all items and reload all items of transaction to Pinpad */
        if (CawPinpadItemModelHelper.isRefreshPinPadScreen()) {
            _cawEigenHelper.refreshPinpadScreen(_transactionScope);
            CawPinpadItemModelHelper.handleRefreshPinPadScreen(false); /* End BZ28561, BZ29383 */
        } else {
            int _cawCurrentTransTotal = 0;
            if (_cawCurrentTransAmtModel != null
                    && _cawCurrentTransAmtModel.size() > 0) {
                _cawCurrentTransTotal = _cawCurrentTransAmtModel.size() + 1;

                int _itemNeedUpdateCount = 0;
                if (_itemNeedUpdateQueue != null
                        && _itemNeedUpdateQueue.size() > 0) {
                    if (_itemNeedUpdateQueue.size() == 1) {
                        _itemNeedUpdateCount = 1;
                    } else {
                        _itemNeedUpdateCount = 1
                                + (_itemNeedUpdateQueue.size() * 2);
                    }
                }

                /**
                 * The code handle case: the transaction have applied discount/deal which changes price all item.
                 */
                if ((_cawCurrentTransTotal < _itemNeedUpdateCount)
                        || _itemNeedUpdateCount > CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD) {//BZ28562: Add condition || CawVoucherValue.isIS_USE_CREDIT_GIFT_FLAG()
                    //Clear all element in queue
                    CawPinpadItemModelHelper.getInstance()
                            .clearAllElementToListNeedToSendMiraServ();

                    IPosTransaction tranx = _transactionScope.getTransaction();
                    String sAmountDue = CawUtilFunction
                            .vString(tranx.getAmountDue());
                    String sTaxAmount = CawUtilFunction
                            .vString(tranx.getTaxAmount());

                    // Add the first element to clear Pinpad screen
                    _cawEigenHelper.addElementClearToQueue();

                    /**
                     * The Pinpad has only displayed 13 item on the screen. 
                     * Therefore, the code will be got 13 last items.
                     * Example formula: The transaction has 20 items need to refresh price on Pinpad screen. 
                     * We only display 13 last items on the Pinpad. 
                     * Number item update: 7 = 20 (total item in transaction) - 13(number of item display on Pinpad).
                     * That means: We need to list item need to update in the transaction from index= 7 to index 20.
                     */

                    /* Begin BZ28407 */
                    ArrayList<CawCurrentTransactionModel> listItem = new ArrayList<CawCurrentTransactionModel>();
                    listItem = _cawEigenHelper
                            .processGroupItem(_cawCurrentTransAmtModel);
                    int j = 0;
                    int totalElement = listItem.size();
                    if (totalElement > CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD) {
                        j = totalElement
                                - CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD;
                    }

                    CawCurrentTransactionModel currentModel = null;
                    CawPinpadItemModel cawPinpadItemModelTemp = null;

                    /* Add 13 last items to queue */
                    for (int i = j; i < totalElement; i++) {
                        currentModel = listItem.get(i);
                        cawPinpadItemModelTemp = new CawPinpadItemModel();
                        _cawEigenHelper
                                .addCawPinpadItemModelToQueue(sAmountDue, sTaxAmount, currentModel, cawPinpadItemModelTemp);
                    }
                    listItem.clear();
                    /* End BZ28407 */
                    /**
                     * The code handle case: Transaction has applied deal/discount for some items(Number of item changes < total items in transaction).
                     */
                } else {
                    if (_itemNeedUpdateQueue != null
                            && _itemNeedUpdateQueue.size() > 0) {
                        // Only a item need to add new or update price
                        if (_itemNeedUpdateQueue.size() == 1) {
                            addOneItemNeedChangePriceToQueue();
                        } else {
                            /**
                             * Many items need to update price.
                             */
                            updateItemPrice();
                        }
                    }
                }
            } else {
                /* Begin BZ28564 */
                /* Clear PinPad and add items from RetailTransactionLineItems when select tender New Good Sam ViSa */
                _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                /* End BZ28564 */
            }
        }
    }

    protected void updateItemPrice() {
        int elementIndex = 0;
        CawPinpadItemModel elementPinpadItemModel = null;
        if (_itemNeedUpdateQueue.size() > CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD) {
            //Clear all element in queue
            CawPinpadItemModelHelper.getInstance().clearAllElementToListNeedToSendMiraServ();
        }

        for (CawPinpadItemModel cawPinpadItemModel : _itemNeedUpdateQueue) {
            if (elementIndex < CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD) {
                if (!_itemNeedUpdateQueue.isEmpty()) {
                    if (cawPinpadItemModel
                            .getPinpadItemModelCommand() == CawPinpadItemModelCommand.ADD_PINPAD_CURRENT_MODEL) {
                        CawPinpadItemModelHelper.getInstance().addElementToListNeedToSendMiraServ(cawPinpadItemModel);
                        /**
                         * For the updated price of the item in Pinpad, the code needs to send two requests to MiraSev.
                         * 1. Request remove the current item on Pinpad.
                         * 2. Request add the item with the new price.
                         */
                    } else if (cawPinpadItemModel
                            .getPinpadItemModelCommand() == CawPinpadItemModelCommand.UPDATE_PINPAD_CURRENT_MODEL) {
                        try {
                            // Copy the current object and change command to REMOVE_PINPAD_CURRENT_MODEL
                            elementPinpadItemModel = (CawPinpadItemModel) cawPinpadItemModel.clone();
                            changeCawPinpadModelCommand(elementPinpadItemModel, CawPinpadItemModelCommand.REMOVE_PINPAD_CURRENT_MODEL);
                            // Copy the current object and change command to ADD_PINPAD_CURRENT_MODEL
                            elementPinpadItemModel = (CawPinpadItemModel) cawPinpadItemModel.clone();
                            changeCawPinpadModelCommand(elementPinpadItemModel, CawPinpadItemModelCommand.ADD_PINPAD_CURRENT_MODEL);

                        } catch (CloneNotSupportedException ex) {
                            logger_.debug("Can not clone object cawPinpadItemModel." + ex.getMessage());
                        }
                    }
                }

                ++elementIndex;

            } else {
                break;
            }
        }
    }

    protected void processEventForPrivileged(Event argEvent) {

        Object payload = argEvent.getPayload();
        if (payload instanceof EventList) {
            EventList events = (EventList) payload;
            List<IEventFinder> elements = events.getElements();
            for (IEventFinder finder : elements) {
                processEventForPrivileged(finder.getBaseEvent());
            }
        } else {
            Object eventName = argEvent.getName();

            if (eventName == ISaleReturnLineItem.ADD_RETAILPRICEMODIFIERS) {
                eventListForPrivileged.offer(argEvent);
            } else if (eventName == IRetailPriceModifier.SET_VOID) {
                eventListForPrivileged.offer(argEvent);
            } else if (eventName == IRetailPriceModifier.SET_EXTENDEDAMOUNT) {
                eventListForPrivileged.offer(argEvent);
            }
        }
    }

    protected void processEventForTransaction(Event argEvent) {

        Object payload = argEvent.getPayload();
        if (payload instanceof EventList) {
            EventList events = (EventList) payload;
            List<IEventFinder> elements = events.getElements();
            for (IEventFinder finder : elements) {
                processEventForTransaction(finder.getBaseEvent());
            }
        } else {
            Object eventName = argEvent.getName();

            if (eventName == IRetailTransactionManager.TRANSACTION_UPDATED) {
                eventList.offer(argEvent);
                processEventList();
                processEventListForPrivileged();
            } else if (eventName == IPosTransaction.ADD_RETAILTRANSACTIONLINEITEMS) {
                eventList.offer(argEvent);
            } else if (eventName == IPosTransaction.REMOVE_RETAILTRANSACTIONLINEITEMS) {
                eventList.offer(argEvent);
            }
        }
    }

    protected void processEventForLineItem(Event argEvent) {

        Object payload = argEvent.getPayload();
        if (payload instanceof EventList) {
            EventList events = (EventList) payload;
            List<IEventFinder> elements = events.getElements();
            for (IEventFinder finder : elements) {
                processEventForLineItem(finder.getBaseEvent());
            }
        } else {
            Object eventName = argEvent.getName();
            if (eventName == IRetailTransactionLineItem.SET_VOID) {
                eventListForPrivileged.offer(argEvent);
            } else if (eventName == ISaleReturnLineItem.SET_EXTENDEDAMOUNT) {
                eventListForPrivileged.offer(argEvent);
            } else if (eventName == ISaleReturnLineItem.SET_QUANTITY) {
                eventListForPrivileged.offer(argEvent);
            }
        }
    }

    protected void processEventForVoucher(Event argEvent) {

        Object payload = argEvent.getPayload();
        if (payload instanceof EventList) {
            EventList events = (EventList) payload;
            List<IEventFinder> elements = events.getElements();
            for (IEventFinder finder : elements) {
                processEventForLineItem(finder.getBaseEvent());
            }
        } else {
            Object eventName = argEvent.getName();

            if (eventName == IRetailTransactionLineItem.SET_VOID) {
                handleSetVoidLineItem(argEvent);
            }
        }
    }

    /**
     * Cleaned up with BZ27344 
     * @param argArgEvent
     */
    private void handleUpdateTransaction(Event argEvent) {

        if (CawTransactionListEditModel._cawCurrentTransAmtModel.isEmpty()) {
            return;
        }

        IPosTransaction tranx = _transactionScope.getTransaction();
        String sAmountDue = CawUtilFunction.vString(tranx.getAmountDue());
        String sTaxAmount = CawUtilFunction.vString(tranx.getTaxAmount());

        IRetailTransaction transaction = (IRetailTransaction) argEvent.getSource();
        if (transaction != null) {

            List<IRetailTransactionLineItem> retailTrans = null;
            retailTrans = transaction.getRetailTransactionLineItems();
            if (retailTrans != null && retailTrans.size() > 0) {
                SaleReturnLineItemModel updElement = null;
                CawCurrentTransactionModel currentElement = null;
                int currentSize = _cawCurrentTransAmtModel.size();
                int currentIndex = -1;
                for (IRetailTransactionLineItem retailTran : retailTrans) {
                    if (retailTran instanceof SaleReturnLineItemModel) {
                        updElement = (SaleReturnLineItemModel) retailTran;
                        currentIndex++;
                        if (currentIndex < currentSize) {
                            currentElement = _cawCurrentTransAmtModel.get(currentIndex);
                            if (currentElement.hasChanged(updElement)) {
                                updatePinpadCurrentModel(updElement, sAmountDue, sTaxAmount, currentElement);
                            }
                        }
                    }
                }
            }
        }

        if (_cawCurrentTransAmtModel.hasChanged(sAmountDue, sTaxAmount)) {
            _cawEigenMgr.updateTransAmt(sAmountDue, sTaxAmount);
            _cawCurrentTransAmtModel.setTotalAmt(sAmountDue, sTaxAmount);
        }
    }

    protected void handleAddLineItem(Event argEvent) {

        Object payload = argEvent.getPayload();

        if (payload instanceof IRetailTransactionLineItem) {

            IPosTransaction tranx = _transactionScope.getTransaction();
            String sAmountDue = CawUtilFunction.vString(tranx.getAmountDue());
            String sTaxAmount = CawUtilFunction.vString(tranx.getTaxAmount());
            if (payload instanceof ISaleReturnLineItem) {
                ISaleReturnLineItem saleLineItm = (ISaleReturnLineItem) payload;
                addCurrentModelToPinpad(saleLineItm, sAmountDue, sTaxAmount);

            } else if (payload instanceof IRetailPriceModifier) {

                IRetailPriceModifier priceModifier = (IRetailPriceModifier) payload;
                if (!(priceModifier.getAmount().compareTo(BigDecimal.ZERO) == 0
                        && priceModifier.getDiscountReasonCode() == null)) {

                    ISaleReturnLineItem parentLine = priceModifier.getParentLine();
                    if (parentLine != null && parentLine.getParentTransaction() != null) {

                        IPosTransaction parentTransaction = parentLine.getParentTransaction();
                        List<IRetailTransactionLineItem> tranLineItems = null;
                        tranLineItems = parentTransaction.getRetailTransactionLineItems();
                        ISaleReturnLineItem saleLineItm;
                        for (IRetailTransactionLineItem lineItem : tranLineItems) {
                            if (lineItem instanceof ISaleReturnLineItem) {

                                saleLineItm = (ISaleReturnLineItem) lineItem;
                                addCurrentModelToPinpad(saleLineItm, sAmountDue, sTaxAmount);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void handleRemoveLineItem(Event argEvent) {

        Object payload = argEvent.getPayload();
        if (payload instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem saleLineItm = (ISaleReturnLineItem) payload;
            removePinpadCurrentModel(saleLineItm);
        }
    }

    protected void handleSetVoidLineItem(Event argEvent) {

        Object source = argEvent.getSource();
        if (source instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem saleLineItm = (ISaleReturnLineItem) source;
            removePinpadCurrentModel(saleLineItm);
        }
    }

    /* An event handler that rebuilds the display of the currently modeled transaction. */
    private final EventHandler transactionListener_     = new EventHandler() {

                                                            /** {@inheritDoc} */
                                                            @Override
                                                            protected void handle(Event argEvent) {

                                                                processEventForTransaction(argEvent);
                                                            }
                                                        };

    /* An event handler that rebuilds the display of the currently modeled transaction. */
    private final EventHandler privilegedEventListener_ = new EventHandler() {

                                                            /** {@inheritDoc} */
                                                            @Override
                                                            protected void handle(Event argEvent) {

                                                                processEventForPrivileged(argEvent);
                                                            }
                                                        };

    private final EventHandler lineItemListener_        = new EventHandler() {

                                                            /** {@inheritDoc} */
                                                            @Override
                                                            protected void handle(Event argEvent) {

                                                                processEventForLineItem(argEvent);
                                                            }
                                                        };

    private final EventHandler voucherListener_         = new EventHandler() {

                                                            /** {@inheritDoc} */
                                                            @Override
                                                            protected void handle(Event argEvent) {

                                                                processEventForVoucher(argEvent);
                                                            }
                                                        };

    /* An event handler that registers for interest in changes to new transactions assigned to a station model.
     * Because the transaction also trampolines changes to its contained elements, the registration will also
     * implicitly apply to those elements. */
    private final EventHandler newTransactionListener_  = new EventHandler() {

                                                            /** {@inheritDoc} */
                                                            @Override
                                                            protected void handle(Event argEvent) {

                                                                // Before processing the new transaction, make sure we de-register for events posted by the old one.
                                                                if (emTransaction_ != null
                                                                        && emTransaction_ instanceof IRetailTransaction) {
                                                                    _eventManager
                                                                            .deregisterEventHandler(transactionListener_, emTransaction_);

                                                                    _eventManager
                                                                            .deregisterEventHandler(privilegedEventListener_, privilegedDescriptor);
                                                                    _eventManager
                                                                            .deregisterEventHandler(lineItemListener_, SALE_LINE_ITEM_DESCRIPTOR_NAME);
                                                                    _eventManager
                                                                            .deregisterEventHandler(voucherListener_, VOUCHER_LINE_ITEM_DESCRIPTOR_NAME);
                                                                }

                                                                emTransaction_ = (IPosTransaction) argEvent
                                                                        .getBaseEvent().getPayload();

                                                                // Register for events posted by the new transaction or its contained elements and initialize the display accordingly.
                                                                if (emTransaction_ != null
                                                                        && emTransaction_ instanceof IRetailTransaction) {

                                                                    processSuspendTransaction((IRetailTransaction) emTransaction_);
                                                                    privilegedDescriptor = new EventDescriptor(
                                                                            PRIVILEGED_EVENT_DESCRIPTOR_NAME);

                                                                    //create event handlers
                                                                    _eventManager
                                                                            .registerEventHandler(transactionListener_, emTransaction_);
                                                                    _eventManager
                                                                            .registerEventHandler(privilegedEventListener_, privilegedDescriptor);
                                                                    _eventManager
                                                                            .registerEventHandler(lineItemListener_, SALE_LINE_ITEM_DESCRIPTOR_NAME);
                                                                    _eventManager
                                                                            .registerEventHandler(voucherListener_, VOUCHER_LINE_ITEM_DESCRIPTOR_NAME);
                                                                }
                                                            }
                                                        };

    //Begin BZ27344 
    /**
     * BZ27344 added
     * Update for _cawCurrentTransModel and _cawCurrentTransAmtModel
     * @param item
     */
    private void updatePinpadCurrentModel(ISaleReturnLineItem saleLineItem, String sAmountDue, String sTaxAmount,
            CawCurrentTransactionModel currentElement) {

        String currentQuantity = currentElement.getQty();
        String unitPriceOld = currentElement.getUnitPrice();
        currentElement.update(saleLineItem);
        CawPinpadItemModel cawPinpadItemModel = _cawEigenHelper
                .createPinpadItemModel(currentElement, sAmountDue, sTaxAmount, CawPinpadItemModelCommand.UPDATE_PINPAD_CURRENT_MODEL);
        cawPinpadItemModel.setCurrentQty(currentQuantity);
        cawPinpadItemModel.setUnitPriceOld(unitPriceOld);
        _itemNeedUpdateQueue.add(cawPinpadItemModel);

        _cawCurrentTransAmtModel.setTotalAmt(sAmountDue, sTaxAmount);

    }

    /**
     * 
     * @param saleLineItem
     * @param sAmountDue
     * @param sTaxAmount
     */
    private void addPinpadCurrentModel(ISaleReturnLineItem saleLineItem, String sAmountDue, String sTaxAmount) {

        addPinpadCurrentModel(saleLineItem, sAmountDue, sTaxAmount, true);
    }

    /**
     * 
     * @param saleLineItem
     * @param sAmountDue
     * @param sTaxAmount
     * @param isIncludeFooterLine
     */
    private void addPinpadCurrentModel(ISaleReturnLineItem saleLineItem, String sAmountDue, String sTaxAmount,
            boolean isIncludeFooterLine) {

        if (isIncludeFooterLine) {
            _cawEigenMgr.addItem(saleLineItem.getQuantity().toString(), saleLineItem
                    .getUnitPrice().toString(), saleLineItem.getItemDescription(), sAmountDue, sTaxAmount);
        } else {
            _cawEigenMgr.addItem(saleLineItem, _transactionScope, false);
        }

        _cawCurrentTransAmtModel.add(saleLineItem, sAmountDue, sTaxAmount);

    }

    /**
     * The function add sale line item to queue 
     * @param saleLineItem
     * @param sAmountDue
     * @param sTaxAmount
     */
    private void addCurrentModelToPinpad(ISaleReturnLineItem saleLineItem, String sAmountDue, String sTaxAmount) {

        addCurrentModelToPinpad(saleLineItem, sAmountDue, sTaxAmount, true);
    }

    /**
     * 
     * @param saleLineItem
     * @param sAmountDue
     * @param sTaxAmount
     * @param isIncludeFooterLine
     */
    private void addCurrentModelToPinpad(ISaleReturnLineItem saleLineItem, String sAmountDue, String sTaxAmount,
            boolean isIncludeFooterLine) {

        saleLineItem.getItemDescription();

        CawCurrentTransactionModel model = CawCurrentTransactionModel.getNewInstance(saleLineItem);
        if (isIncludeFooterLine) {
            if (StringUtils.isNotEmpty(saleLineItem.getItemDescription())) {
                model.setDescription(saleLineItem.getItemDescription());
            } else {
                model.setDescription(String.valueOf(saleLineItem.getItem()));
            }
        }

        _cawCurrentTransAmtModel.add(model, sAmountDue, sTaxAmount);

        CawPinpadItemModel cawPinpadScreenModel = _cawEigenHelper
                .createPinpadItemModel(model, sAmountDue, sTaxAmount, CawPinpadItemModelCommand.ADD_PINPAD_CURRENT_MODEL);

        _itemNeedUpdateQueue.add(cawPinpadScreenModel);

    }

    /**
     * 
     * @param saleLineItem
     * @param sAmountDue
     * @param sTaxAmount
     */
    private void removePinpadCurrentModel(ISaleReturnLineItem saleLineItem, String sAmountDue, String sTaxAmount) {

        _cawEigenMgr.removeItem(saleLineItem.getQuantity().toString(), saleLineItem
                .getUnitPrice().toString(), saleLineItem.getItemDescription(), _transactionScope);

        _cawCurrentTransAmtModel.setTotalAmt(sAmountDue, sTaxAmount);
    }

    private void removePinpadCurrentModel(ISaleReturnLineItem saleLineItem) {

        IPosTransaction tranx = _transactionScope.getTransaction();
        String sAmountDue = CawUtilFunction.vString(tranx.getAmountDue());
        String sTaxAmount = CawUtilFunction.vString(tranx.getTaxAmount());
        removePinpadCurrentModel(saleLineItem, sAmountDue, sTaxAmount);
    }


    private void changeCawPinpadModelCommand(CawPinpadItemModel pinpadItemModel, CawPinpadItemModelCommand command) {

        pinpadItemModel.setPinpadItemModelCommand(command);
        CawPinpadItemModelHelper.getInstance().addElementToListNeedToSendMiraServ(pinpadItemModel);
    }

    private void addOneItemNeedChangePriceToQueue() {

        CawPinpadItemModel cawPinpadItemModel = _itemNeedUpdateQueue.poll();
        if (cawPinpadItemModel.getPinpadItemModelCommand() == CawPinpadItemModelCommand.ADD_PINPAD_CURRENT_MODEL) {
            CawPinpadItemModelHelper.getInstance().addElementToListNeedToSendMiraServ(cawPinpadItemModel);

        } else if (cawPinpadItemModel
                .getPinpadItemModelCommand() == CawPinpadItemModelCommand.UPDATE_PINPAD_CURRENT_MODEL) {
            try {
                Boolean isVoid = Boolean.valueOf(cawPinpadItemModel.getIsVoid());
                if (isVoid) {
                    CawPinpadItemModel pinpadItemModel = (CawPinpadItemModel) cawPinpadItemModel.clone();
                    changeCawPinpadModelCommand(pinpadItemModel, CawPinpadItemModelCommand.REMOVE_PINPAD_CURRENT_MODEL);
                } else {
                    CawPinpadItemModel pinpadItemModel = (CawPinpadItemModel) cawPinpadItemModel.clone();
                    changeCawPinpadModelCommand(pinpadItemModel, CawPinpadItemModelCommand.REMOVE_PINPAD_CURRENT_MODEL);

                    pinpadItemModel = (CawPinpadItemModel) cawPinpadItemModel.clone();
                    changeCawPinpadModelCommand(pinpadItemModel, CawPinpadItemModelCommand.ADD_PINPAD_CURRENT_MODEL);
                }
            } catch (CloneNotSupportedException ex) {
                logger_.debug("The method addOneItemNeedChangePriceToQueue can not clone object CawPinpadItemModel."
                        + ex.getMessage());
            }
        }
    }

    //End BZ27344
}
