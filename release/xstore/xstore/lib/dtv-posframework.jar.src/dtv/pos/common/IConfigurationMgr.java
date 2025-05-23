package dtv.pos.common;

public interface IConfigurationMgr {
  public static final String STORE_TAG = "Store";
  
  public static final String SYSTEM_CONFIG_TAG = "SystemConfig";
  
  public static final String REGISTER_CONFIG_TAG = "RegisterConfig";
  
  public static final String OPEN_CLOSE_CONFIG_TAG = "OpenClose";
  
  public static final String ROLLING_CLOSE_CONFIG_TAG = "RollingClose";
  
  public static final String TIME_CLOCK_TAG = "TimeClock";
  
  public static final String LOCATION_TAG = "Location";
  
  public static final String ITEM_SALE_TAG = "ItemSale";
  
  public static final String ITEM_MATRIX_TAG = "ItemMatrix";
  
  public static final String EMP_SALE_TAG = "EmployeeSale";
  
  public static final String CHECK_TENDER_TAG = "CheckTender";
  
  public static final String TRAINING_MODE_TAG = "TrainingMode";
  
  public static final String CURRENCY_ROUNDING_TAG = "CurrencyRounding";
  
  public static final String ROUNDING_MODE_TAG = "RoundingMode";
  
  public static final String ROUND_TO_TAG = "RoundTo";
  
  public static final String LOGIN_SECURITY_TAG = "LoginSecurity";
  
  public static final String PASSWORD_EXPIRATION_TAG = "PasswordExpiration";
  
  public static final String ACCOUNT_LOCKOUT_TAG = "AccountLockout";
  
  public static final String ENABLED_TAG = "Enabled";
  
  public static final String DAYS_TAG = "Days";
  
  public static final String TAX_TAG = "Tax";
  
  public static final String ITEM_RETURN_TAG = "ItemReturn";
  
  public static final String ITEM_MESSAGING_TAG = "ItemMessaging";
  
  public static final String PRE_SALE_TRANSACTION_TAG = "PreSalesTransaction";
  
  public static final String ATTACHED_ITEMS_TAG = "AttachedItems";
  
  public static final String COMMISSIONEDASSOCIATES_TAG = "CommissionedAssociates";
  
  public static final String SUSPEND_TRANS_TAG = "SuspendTransaction";
  
  public static final String VALIDATION_RE_PROMPT_TYPE = "ValidationRepromptType";
  
  public static final String RESTOCKING_FEE = "RestockingFee";
  
  public static final String PRICE_HISTORY_TAG = "PriceHistory";
  
  public static final String RETURN_VERIFICATION_TAG = "ReturnVerification";
  
  public static final String CREDIT_COMM_ASSC_METHOD_TAG = "CreditCommissionedAsscMethod";
  
  public static final String SEND_SALE_TAG = "SendSale";
  
  public static final String POS_LOCK = "PosLock";
  
  public static final String TILL_TAG = "TillAccountability";
  
  public static final String TILL_COUNT_OVER_THRESHOLD = "TillCountOverThreshold";
  
  public static final String DEALS_TAG = "Deals";
  
  public static final String PROMOTE_TAG = "Promote";
  
  public static final String TERMINAL_TAG = "Terminal";
  
  public static final String GIFT_RECEIPT_TAG = "GiftReceipt";
  
  public static final String POST_VOID_TAG = "PostVoid";
  
  public static final String PROMPT_FOR_REASON_TAG = "PromptForReason";
  
  public static final String PROMPT_FOR_COMMENT_TAG = "PromptForComment";
  
  public static final String REASON_TYPE_CODE_TAG = "ReasonTypeCode";
  
  public static final String LAYAWAY_TAG = "Layaway";
  
  public static final String SP_ORDER_TAG = "SpecialOrder";
  
  public static final String WORK_ORDER_TAG = "WorkOrder";
  
  public static final String RECEIVING_TAG = "Receiving";
  
  public static final String SHIPPING_TAG = "Shipping";
  
  public static final String BROWSER_TAG = "Browser";
  
  public static final String SALES_GOAL_TAG = "SalesGoal";
  
  public static final String SCHEDULING_TAG = "Scheduling";
  
  public static final String TIMEOFF_TAG = "TimeOff";
  
  public static final String TIMECARD_TAG = "Timecard";
  
  public static final String EXCEPTION_TAG = "Exception";
  
  public static final String PAYROLL_CALENDAR_TAG = "PayrollCalendar";
  
  public static final String PAYROLL_TAG = "Payroll";
  
  public static final String POST_PAYROLL_TAG = "PostPayroll";
  
  public static final String ALLOW_MIXED_IN_TRANS = "AllowSaleItemTypeInMixedTransaction";
  
  public static final String TENDER_TAG = "Tender";
  
  public static final String OPENING_TASKS_TAG = "OpeningTasks";
  
  public static final String CLOSING_TASKS_TAG = "ClosingTasks";
  
  public static final String ACCOUNT_RECEIVABLE_TAG = "AccountsReceivable";
  
  public static final String INVENTORY_ADJUSTMENT_TAG = "InventoryAdjustment";
  
  public static final String INVENTORY_COUNT_TAG = "InventoryCount";
  
  public static final String INVENTORY_TAG = "Inventory";
  
  public static final String DISCOUNTS_TAG = "Discounts";
  
  public static final String LINE_ITEM_DISCOUNT_TAG = "LineItemDiscount";
  
  public static final String GROUP_DISCOUNT_TAG = "GroupDiscount";
  
  public static final String TRANSACTION_DISCOUNT_TAG = "TransactionDiscount";
  
  public static final String YOU_SAVED_MESSAGE_TAG = "YouSavedMessage";
  
  public static final String SHELF_LABELS_ITEM_TAGS = "ShelfLabelsItemTags";
  
  public static final String DOCUMENT_TAG = "Document";
  
  public static final String NON_MERCH_ITEM_TYPES_TAG = "NonMerchItemTypes";
  
  public static final String TENDER_EXCHANGE_TAG = "TenderExchange";
  
  public static final String RETURN_ITEM_DISCOUNTS_TAG = "Discounts";
  
  public static final String CREDIT_DEBIT_TENDER_TAG = "CreditDebitTender";
  
  public static final String TAXWARE_TAG = "TaxWare";
  
  public static final String ERROR_SCREEN = "ErrorScreen";
  
  public static final String HELP_TAG = "Help";
  
  public static final String BINSMART_LOOKUP_TAG = "BINSmartLookup";
  
  public static final String SSL_CERTIFICATE_CHECK_TAG = "SSLCertificateCheck";
  
  public static final String RELATE_SECURITY_TAG = "RelateSecurity";
  
  public static final String ORDER_TAG = "Order";
  
  public static final String GIFT_REGISTRY_TAG = "GiftRegistry";
  
  public static final String RAIN_CHECK_TAG = "RainCheck";
  
  public static final String ASSOCIATE_TASKS_TAG = "AssociateTasks";
  
  public static final String TRANSACTION_MIXING_SETTINGS = "MixedTransactionSettings";
  
  public static final String FISCAL_CONFIG_TAG = "FiscalConfig";
  
  public static final String REFRESH_PROMOTIONS_TAG = "RefreshPromotions";
  
  public static final String XENVIRONMENT_TAG = "Xenvironment";
  
  public static final String USER_INTERFACE_TAG = "UserInterface";
  
  public static final String EXCHANGE_SERIAL_NUMBER_TAG = "ExchangeSerialNumber";
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\IConfigurationMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */