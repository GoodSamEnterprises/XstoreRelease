/*      */ package dtv.pos.common;
/*      */ 
/*      */ import dtv.i18n.IFormattable;
/*      */ import dtv.pos.framework.action.type.XstKeyStroke;
/*      */ import dtv.util.CurrencyUtils;
/*      */ import dtv.util.NumberUtils;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.util.config.IUrlConfig;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*      */ import java.lang.reflect.Method;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.RoundingMode;
/*      */ import java.net.URL;
/*      */ import java.time.LocalTime;
/*      */ import java.util.Arrays;
/*      */ import java.util.Comparator;
/*      */ import java.util.Currency;
/*      */ import java.util.List;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ConfigurationMgr
/*      */   implements IConfigurationMgr
/*      */ {
/*   37 */   private static final Logger logger_ = Logger.getLogger(ConfigurationMgr.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   46 */   private static final SystemConfigHelper helper_ = new SystemConfigHelper(); static final String CHARITY_TAG = "Charity"; static {
/*   47 */     helper_.initialize();
/*      */   }
/*      */   private static Currency currency_;
/*      */   public static boolean addSetupFeeToLayaway() {
/*   51 */     return getHelper()
/*   52 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AddSetupFeeToLayawayAccount" });
/*      */   }
/*      */   
/*      */   public static boolean allowBatchSavePrompt() {
/*   56 */     return getHelper()
/*   57 */       .getBoolean(new String[] { "Store", "SystemConfig", "ShelfLabelsItemTags", "SaveBatchPrompt" });
/*      */   }
/*      */   
/*      */   public static boolean allowHouseAccountManagerOverride() {
/*   61 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "PromptManagerOverride" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean allowLayawayEscrowDayOfPayment() {
/*   70 */     return getHelper()
/*   71 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowEscrowDayOfPayment" });
/*      */   }
/*      */   
/*      */   public static boolean allowLayawayInMixedTransaction() {
/*   75 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowLayawayInMixedTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean allowMultipleIncomingTendersForExchange() {
/*   80 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TenderExchange", "AllowMultipleIncomingTenders" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean allowMultipleOutgoingTendersForExchange() {
/*   85 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TenderExchange", "AllowMultipleOutgoingTenders" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean allowNewLayawayWithDelinquentExisting() {
/*   90 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowNewLayawayWithDelinquentExisting" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean allowNonMerchTickets() {
/*   95 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ShelfLabelsItemTags", "AllowNonMerchTickets" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean allowPartialLayawayPickups() {
/*  100 */     return getHelper()
/*  101 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowPartialPickups" });
/*      */   }
/*      */   
/*      */   public static boolean allowPartialSpecOrderPickups() {
/*  105 */     return getHelper()
/*  106 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "AllowPartialPickups" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean allowRemoteWorkstationClose() {
/*  115 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "AllowRemoteWSClose" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean allowSpecOrderEscrowDayOfPayment() {
/*  120 */     return getHelper()
/*  121 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "AllowEscrowDayOfPayment" });
/*      */   }
/*      */   
/*      */   public static boolean autoAdjustLayawayItemPriceAtPickup() {
/*  125 */     return getHelper()
/*  126 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AutoAdjustItemPriceAtPickup" });
/*      */   }
/*      */   
/*      */   public static boolean autoAdjustSpecOrderItemPriceAtPickup() {
/*  130 */     return getHelper()
/*  131 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "AutoAdjustItemPriceAtPickup" });
/*      */   }
/*      */   
/*      */   public static String autoClockOutOnRtlLocClose() {
/*  135 */     return getHelper().getString(new String[] { "Store", "RegisterConfig", "OpenClose", "AutoClockOutOnRtlLocClose" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean autoGenerateCustomerId() {
/*  140 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AutoGenerateCustomerId" });
/*      */   }
/*      */   
/*      */   public static boolean autoGenerateEmployeeId() {
/*  144 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AutoGenerateEmployeeId" });
/*      */   }
/*      */   
/*      */   public static boolean autoGenerateLayawayId() {
/*  148 */     return getHelper()
/*  149 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AutoGenerateLayawayId" });
/*      */   }
/*      */   
/*      */   public static boolean autoGenerateSpecOrderId() {
/*  153 */     return getHelper()
/*  154 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "AutoGenerateSpecOrderId" });
/*      */   }
/*      */   
/*      */   public static boolean autoGenerateSpecOrderReceivingDoc() {
/*  158 */     return getHelper()
/*  159 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "AutoGenerateReceivingDoc" });
/*      */   }
/*      */   
/*      */   public static boolean autoGenerateWorkOrderId() {
/*  163 */     return getHelper()
/*  164 */       .getBoolean(new String[] { "Store", "SystemConfig", "WorkOrder", "AutoGenerateWorkOrderId" });
/*      */   }
/*      */   
/*      */   public static boolean autoTriggerRegistryGiftReceipts() {
/*  168 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "GiftRegistry", "AutoTriggerGiftReceipts" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean bookAsSaleOnLayawaySetup() {
/*  173 */     return getHelper()
/*  174 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "BookAsSaleOnSetup" });
/*      */   }
/*      */   
/*      */   public static boolean bookAsSaleOnSpecialOrderSetup() {
/*  178 */     return getHelper()
/*  179 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "BookAsSaleOnSetup" });
/*      */   }
/*      */   
/*      */   public static boolean captureUserMsg() {
/*  183 */     return getHelper()
/*  184 */       .getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "CaptureUserMsg" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean checkingForNewCachedPromotions() {
/*  193 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "RefreshPromotions", "CheckingForNewCachedPromotions" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean countTillsInClose() {
/*  198 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "CountTillsInClose" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean createRtlLocCloseTransaction() {
/*  203 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "CreateRtlLocCloseTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean createRtlLocOpenTransaction() {
/*  208 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "CreateRtlLocOpenTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean createWSCloseTransaction() {
/*  213 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "CreateWSCloseTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean createWSOpenTransaction() {
/*  218 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "CreateWSOpenTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int customerActivityStreamItemLimit() {
/*  223 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "CustomerActivityStreamMaxItems" });
/*      */   }
/*      */   
/*      */   public static int customerHistoryAgeLimitDays() {
/*  227 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "CustomerHistoryAgeLimitDays" });
/*      */   }
/*      */   
/*      */   public static boolean displayUserCapturedMsg() {
/*  231 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "DisplayUserCapturedMsg" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean displayVoidedLineItems() {
/*  241 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "DisplayVoidedLineItems" });
/*      */   }
/*      */   
/*      */   public static boolean forceCloseWSOnRtlLocClose() {
/*  245 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "ForceCloseWSOnRtlLocClose" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getAbstractValidationRepromptType() {
/*  250 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "ValidationRepromptType", "AbstractValidationRepromptType" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getActiveSequenceFilePath() {
/*  255 */     return getHelper()
/*  256 */       .getString(new String[] { "Store", "SystemConfig", "SequenceFilePaths", "ActiveFilePath" });
/*      */   }
/*      */   
/*      */   public static int getActivityStreamAnniversaryDateReminderDays() {
/*  260 */     return getHelper()
/*  261 */       .getInt(new String[] { "Store", "SystemConfig", "ActivityStream", "AnniversaryDateReminderDays" });
/*      */   }
/*      */   
/*      */   public static int getActivityStreamBirthDateReminderDays() {
/*  265 */     return getHelper()
/*  266 */       .getInt(new String[] { "Store", "SystemConfig", "ActivityStream", "BirthDateReminderDays" });
/*      */   }
/*      */   
/*      */   public static int getActivityStreamLoyaltyExpirationReminderDays() {
/*  270 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ActivityStream", "LoyaltyExpirationReminderDays" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static Boolean getAirsideAllowSalesToArrivals() {
/*  275 */     return Boolean.valueOf(getHelper()
/*  276 */         .getBoolean(new String[] { "Store", "SystemConfig", "Airside", "AllowSalesToArrivals" }));
/*      */   }
/*      */   
/*      */   public static Boolean getAirsideAllowSalesToStaff() {
/*  280 */     return Boolean.valueOf(getHelper()
/*  281 */         .getBoolean(new String[] { "Store", "SystemConfig", "Airside", "AllowSalesToStaff" }));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Boolean getAirsideAskMoreFlightsWhenNoTaxExemption() {
/*  287 */     return Boolean.valueOf(getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Airside", "AskMoreFlightsWhenNoTaxExemption" }));
/*      */   }
/*      */ 
/*      */   
/*      */   public static Boolean getAirsideConnectingFlightInformationInDB() {
/*  292 */     return Boolean.valueOf(getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Airside", "ConnectingFlightInformationInDB" }));
/*      */   }
/*      */ 
/*      */   
/*      */   public static Boolean getAirsideDisallowedToSuspendTransaction() {
/*  297 */     return Boolean.valueOf(getHelper()
/*  298 */         .getBoolean(new String[] { "Store", "SystemConfig", "Airside", "DisallowedToSuspendTransaction" }));
/*      */   }
/*      */   
/*      */   public static Boolean getAirsideDisallowMultipleBoardingPasses() {
/*  302 */     return Boolean.valueOf(getHelper()
/*  303 */         .getBoolean(new String[] { "Store", "SystemConfig", "Airside", "DisallowMultipleBoardingPasses" }));
/*      */   }
/*      */   
/*      */   public static Boolean getAirsideEnabled() {
/*  307 */     return Boolean.valueOf(getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Airside", "Enabled" }));
/*      */   }
/*      */   
/*      */   public static int getAirsideFirstFlightDateMax() {
/*  311 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Airside", "FirstFlightDateMax" });
/*      */   }
/*      */   
/*      */   public static int getAirsideFirstFlightDateMaxWarn() {
/*  315 */     return getHelper()
/*  316 */       .getInt(new String[] { "Store", "SystemConfig", "Airside", "FirstFlightDateMaxWarn" });
/*      */   }
/*      */   
/*      */   public static int getAirsideFirstFlightDateMin() {
/*  320 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Airside", "FirstFlightDateMin" });
/*      */   }
/*      */   
/*      */   public static int getAirsideFirstFlightDateMinWarn() {
/*  324 */     return getHelper()
/*  325 */       .getInt(new String[] { "Store", "SystemConfig", "Airside", "FirstFlightDateMinWarn" });
/*      */   }
/*      */   
/*      */   public static Boolean getAirsideFlightInformationFromDBRequired() {
/*  329 */     return Boolean.valueOf(getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Airside", "FlightInformationFromDBRequired" }));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getAirsideFollowingFlightDateMax() {
/*  334 */     return getHelper()
/*  335 */       .getInt(new String[] { "Store", "SystemConfig", "Airside", "FollowingFlightDateMax" });
/*      */   }
/*      */   
/*      */   public static int getAirsideFollowingFlightDateMaxWarn() {
/*  339 */     return getHelper()
/*  340 */       .getInt(new String[] { "Store", "SystemConfig", "Airside", "FollowingFlightDateMaxWarn" });
/*      */   }
/*      */   
/*      */   public static int getAirsideFollowingFlightDateMin() {
/*  344 */     return getHelper()
/*  345 */       .getInt(new String[] { "Store", "SystemConfig", "Airside", "FollowingFlightDateMin" });
/*      */   }
/*      */   
/*      */   public static int getAirsideFollowingFlightDateMinWarn() {
/*  349 */     return getHelper()
/*  350 */       .getInt(new String[] { "Store", "SystemConfig", "Airside", "FollowingFlightDateMinWarn" });
/*      */   }
/*      */   
/*      */   public static Boolean getAirsideShowFlightInformationRecap() {
/*  354 */     return Boolean.valueOf(getHelper()
/*  355 */         .getBoolean(new String[] { "Store", "SystemConfig", "Airside", "ShowFlightInformationRecap" }));
/*      */   }
/*      */   
/*      */   public static String getAirsideTaxExemptionReasonCode() {
/*  359 */     return getHelper()
/*  360 */       .getString(new String[] { "Store", "SystemConfig", "Airside", "TaxExemptionReasonCode" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowAddItemAfterSetup() {
/*  364 */     return getHelper()
/*  365 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowAddItemAfterSetup" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowAutoPostWithError() {
/*  369 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "PostPayroll", "AllowAutoPostWithError" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowCashierAsCommissionedAssociate() {
/*  376 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "AllowCashierAsCommissionedAssociate" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowDiscountsOnBlindReturn() {
/*  387 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "Discounts", "AllowDiscountsOnBlindReturn" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowDiscountsOnUnverifiedReturn() {
/*  398 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "Discounts", "AllowDiscountsOnUnverifiedReturn" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowDiscountsOnVerifiedReturn() {
/*  409 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "Discounts", "AllowDiscountsOnVerifiedReturn" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowDonationFooterMessageOnReceipts() {
/*  414 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Charity", "AllowDonationFooterMessageOnReceipts" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowDonationLineItemOnReceipts() {
/*  419 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Charity", "AllowDonationLineItemOnReceipts" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowEmpSelfSale() {
/*  429 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "EmployeeSale", "AllowSelfSale" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowExemptAllTaxLines() {
/*  433 */     return getHelper()
/*  434 */       .getBoolean(new String[] { "Store", "SystemConfig", "Tax", "AllowExemptAllTaxLines" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowFuturePayrollEntry() {
/*  438 */     return getHelper()
/*  439 */       .getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "AllowFuturePayrollEntry" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowFutureTimecardEntry() {
/*  443 */     return getHelper()
/*  444 */       .getBoolean(new String[] { "Store", "SystemConfig", "Timecard", "AllowFutureTimecardEntry" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowItemNotOnFile() {
/*  453 */     return getHelper()
/*  454 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "AllowItemNotOnFile" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowItemNotOnFileBlindReturn() {
/*  458 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "AllowItemNotOnFileBlindReturn" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowLayawayItemNotOnFile() {
/*  468 */     return getHelper()
/*  469 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowItemNotOnFileLayaway" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowLayawayOverpayment() {
/*  473 */     return getHelper()
/*  474 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "AllowOverpayment" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeLAYAWAY() {
/*  478 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "LAYAWAY" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeORDER() {
/*  483 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "ORDER" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeRETURN() {
/*  488 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "RETURN" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeSALE() {
/*  493 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "SALE" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeSENDSALE() {
/*  498 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "SENDSALE" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeSPECIALORDER() {
/*  503 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "SPECIALORDER" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMixedInTransWithSaleItemTypeWORKORDER() {
/*  508 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowSaleItemTypeInMixedTransaction", "WORKORDER" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowMultipleItemsPerWorkOrder() {
/*  513 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "WorkOrder", "AllowMultipleItemsPerWorkOrder" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowNegativeTotalInExchangeTransaction() {
/*  518 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "AllowNegativeTotalInExchangeTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowPostPayrollPerEmployee() {
/*  523 */     return getHelper()
/*  524 */       .getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "AllowPostPayrollPerEmployee" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowPromptNotificationWhenDonationItemVoided() {
/*  528 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Charity", "AllowPromptNotificationWhenDonationItemVoided" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowReceiveDocInTotal() {
/*  533 */     return getHelper()
/*  534 */       .getBoolean(new String[] { "Store", "SystemConfig", "Receiving", "AllowReceiveDocInTotal" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowRepostingPayroll() {
/*  538 */     return getHelper()
/*  539 */       .getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "AllowRepostingPayroll" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowReturnDonationItems() {
/*  543 */     return getHelper()
/*  544 */       .getBoolean(new String[] { "Store", "SystemConfig", "Charity", "AllowReturnDonationItems" });
/*      */   }
/*      */   
/*      */   public static boolean getAllowSameDayStoreReopen() {
/*  548 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "AllowSameDayStoreReopen" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowSpecOrderItemNotOnFile() {
/*  558 */     return getHelper()
/*  559 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "AllowItemNotOnFileSpecOrder" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAllowSuspendTransWithVerifiedReturn() {
/*  570 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SuspendTransaction", "AllowSuspendTransWithVerifiedReturn" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowUnscheduledBusinessDateOpen() {
/*  575 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "AllowUnscheduledBusinessDateOpen" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAllowUserChangeBusinessDate() {
/*  580 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "AllowUserChangeBusinessDate" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAlwaysPromptForItemPriceUponBlindReturn() {
/*  592 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "AlwaysPromptForItemPriceUponBlindReturn" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getAlwaysPromptForItemPriceUponUnverifiedReturn() {
/*  604 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "AlwaysPromptForItemPriceUponUnverifiedReturn" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getAssocAdvanceAuthNumber() {
/*  609 */     return getHelper()
/*  610 */       .getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "AssocAdvanceAuthNumber" });
/*      */   }
/*      */   
/*      */   public static boolean getAssocAdvanceRepaymentAmount() {
/*  614 */     return getHelper()
/*  615 */       .getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "AssocAdvanceRepaymentAmount" });
/*      */   }
/*      */   
/*      */   public static boolean getAutogenerateShippingDocumentId() {
/*  619 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Shipping", "AutogenerateShippingDocumentId" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getAutoLogoutWaitInSeconds() {
/*  624 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "AutoLogout", "WaitSeconds" });
/*      */   }
/*      */   
/*      */   public static int getBasicCalendarPayrollWeekendingDay() {
/*  628 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Payroll", "BasicCalendarPayrollWeekendingDay" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getBINSmartLookupAuthMethodCode() {
/*  633 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "CreditDebitTender", "BINSmartLookup", "AuthMethodCode" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getBINSmartLookupPreferredDefaultOnError() {
/*  638 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "CreditDebitTender", "BINSmartLookup", "PreferredDefaultOnError" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getBlindCouponTenderId() {
/*  643 */     return getHelper()
/*  644 */       .getString(new String[] { "Store", "SystemConfig", "Tender", "BlindCouponTenderId" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getBlindReturnAmountThreshold() {
/*  648 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "ItemReturn", "BlindReturns", "AmountThreshold" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static Boolean getBrowserDebug() {
/*  653 */     return Boolean.valueOf(getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "Browser", "Debug"
/*  654 */           }, Boolean.valueOf(false).booleanValue()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final boolean getCachePriceOfItemsAddedToTheTransaction() {
/*  663 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Transaction", "CachePriceOfItemsAddedToTheTransaction" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static BigDecimal getCashPaymentRequiringIrsReport() {
/*  668 */     return getHelper()
/*  669 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "CashPaymentRequiringIrsReport" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getCashTotalDisplay() {
/*  678 */     return getHelper()
/*  679 */       .getBoolean(new String[] { "Store", "SystemConfig", "CurrencyRounding", "CashTotalDisplay" });
/*      */   }
/*      */   
/*      */   public static boolean getChangeIndividualTaxLines() {
/*  683 */     return getHelper()
/*  684 */       .getBoolean(new String[] { "Store", "SystemConfig", "Tax", "ChangeIndividualTaxLines" });
/*      */   }
/*      */   
/*      */   public static boolean getChargeSetupFeeOnEdit() {
/*  688 */     return getHelper()
/*  689 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "ChargeSetupFeeOnEdit" });
/*      */   }
/*      */   
/*      */   public static IFormattable getCharitableCompanyName() {
/*  693 */     return getHelper()
/*  694 */       .getFormattable(new String[] { "Store", "SystemConfig", "Charity", "CharitableCompanyName" });
/*      */   }
/*      */   
/*      */   public static boolean getClearViewOnBlankMessage() {
/*  698 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "ClearViewOnBlankMessage" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getClockInRequiredForAuthorization() {
/*  703 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TimeClock", "ClockInRequiredForAuthorizationFlag" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getCommAssocRcptIncludeFirstName() {
/*  708 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "RcptIncludeFirstName" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getCommAssocRcptIncludeLastName() {
/*  713 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "RcptIncludeLastName" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getCommAssocRcptNewLineBetween() {
/*  718 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "RcptNewLineBetween" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getCompositeMessageImagePosition() {
/*  728 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "ItemMessaging", "CompositeMessageImagePosition" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getCompoundTaxIncludeOtherCompTaxAmt() {
/*  734 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Tax", "CompoundTaxIncludeOtherCompTaxAmt" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getConfirmQuantityThreshold() {
/*  743 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "Replenishment", "ConfirmQuantityThreshold" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getCountSummaryViewTypeCashPickup() {
/*  748 */     return getHelper()
/*  749 */       .getString(new String[] { "Store", "SystemConfig", "TillAccountability", "CountSummaryViewTypeCashPickup" });
/*      */   }
/*      */   
/*      */   public static String getCountSummaryViewTypeMidDay() {
/*  753 */     return getHelper()
/*  754 */       .getString(new String[] { "Store", "SystemConfig", "TillAccountability", "CountSummaryViewTypeMidDay" });
/*      */   }
/*      */   
/*      */   public static String getCountSummaryViewTypeReconcile() {
/*  758 */     return getHelper()
/*  759 */       .getString(new String[] { "Store", "SystemConfig", "TillAccountability", "CountSummaryViewTypeReconcile" });
/*      */   }
/*      */   
/*      */   public static String getCountSummaryViewTypeStartCount() {
/*  763 */     return getHelper()
/*  764 */       .getString(new String[] { "Store", "SystemConfig", "TillAccountability", "CountSummaryViewTypeStartCount" });
/*      */   }
/*      */   
/*      */   public static String getCountSummaryViewTypeTillCount() {
/*  768 */     return getHelper()
/*  769 */       .getString(new String[] { "Store", "SystemConfig", "TillAccountability", "CountSummaryViewTypeTillCount" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getCreditBlindReturnSaleCommissionMethod() {
/*  778 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "ItemReturn", "CreditCommissionedAsscMethod", "CreditBlindReturnSaleCommissionMethod" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getCreditUnverifiedReturnSaleCommissionMethod() {
/*  788 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "ItemReturn", "CreditCommissionedAsscMethod", "CreditUnverifiedReturnSaleCommissionMethod" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getCreditVerifiedReturnSaleCommissionMethod() {
/*  798 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "ItemReturn", "CreditCommissionedAsscMethod", "CreditVerifiedReturnSaleCommissionMethod" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getCriteriaRequiredForEmployeeSearch() {
/*  803 */     return getHelper()
/*  804 */       .getBoolean(new String[] { "Store", "SystemConfig", "CriteriaRequiredForEmployeeSearch" }, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Currency getCurrency() {
/*  813 */     if (currency_ == null) {
/*  814 */       currency_ = CurrencyUtils.getCurrency(getLocalCurrencyId());
/*      */     }
/*  816 */     return currency_;
/*      */   }
/*      */   
/*      */   public static BigDecimal getDefaultAccountCreditLimit() {
/*  820 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "AccountsReceivable", "DefaultAccountCreditLimit" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getDefaultActiveEmployeeListSortType() {
/*  825 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Timecard", "DefaultActiveEmployeeListSortType" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getDefaultCashierIsFirstCommissionedAssociate() {
/*  831 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "DefaultCashierAsFirstCommissionedAssociate" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getDefaultChangeTenderIdIfNoneFound() {
/*  836 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Tender", "DefaultChangeTenderIdIfNoneFound" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getDefaultCommissionMethod() {
/*  841 */     return getHelper().getString(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "DefaultCommissionMethod" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getDefaultCustIdentificationType() {
/*  851 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "DefaultIDType" });
/*      */   }
/*      */   
/*      */   public static String getDefaultEmployeeGroup() {
/*  855 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "DefaultEmployeeGroup" });
/*      */   }
/*      */   
/*      */   public static String getDefaultInventoryLocationId() {
/*  859 */     return getHelper()
/*  860 */       .getString(new String[] { "Store", "RegisterConfig", "Location", "DefaultInventoryLocationId" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getDefaultItemMaxSaleUnitCount() {
/*  869 */     return getHelper()
/*  870 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "DefaultItemMaxSaleUnitCount" });
/*      */   }
/*      */   
/*      */   public static String getDefaultItemMessageIcon() {
/*  874 */     return getHelper()
/*  875 */       .getString(new String[] { "Store", "SystemConfig", "ItemMessaging", "DefaultMessageIcon" });
/*      */   }
/*      */   
/*      */   public static String getDefaultItemMessageTitle() {
/*  879 */     return getHelper()
/*  880 */       .getString(new String[] { "Store", "SystemConfig", "ItemMessaging", "DefaultMessageTitle" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getDefaultMessageUrlKey() {
/*  890 */     return getHelper()
/*  891 */       .getString(new String[] { "Store", "SystemConfig", "ItemMessaging", "DefaultMessageURL" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getDefaultRoundUpValue() {
/*  895 */     return getHelper()
/*  896 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Charity", "DefaultRoundUpValue" });
/*      */   }
/*      */   
/*      */   public static String getDefaultStoreOrignatorCode() {
/*  900 */     return getHelper()
/*  901 */       .getString(new String[] { "Store", "SystemConfig", "SendSale", "DefaultStoreOrignatorCode" });
/*      */   }
/*      */   
/*      */   public static int getDefaultWorkOrderLeadDays() {
/*  905 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "WorkOrder", "DefaultLeadDays" });
/*      */   }
/*      */   
/*      */   public static String getDelinquencyFeeType() {
/*  909 */     return getHelper()
/*  910 */       .getString(new String[] { "Store", "SystemConfig", "Layaway", "DelinquencyFeeType" });
/*      */   }
/*      */   
/*      */   public static int getDelinquentDaysAfterDue() {
/*  914 */     return getHelper()
/*  915 */       .getInt(new String[] { "Store", "SystemConfig", "Layaway", "DelinquentDaysAfterDue" });
/*      */   }
/*      */   
/*      */   public static String getDepositFeeType() {
/*  919 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Layaway", "DepositFeeType" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static RoundingMode getDiscountRoundingMode() {
/*  924 */     String name = getHelper().getString(new String[] { "Store", "SystemConfig", "Discounts", "RoundingMode" });
/*  925 */     RoundingMode mode = NumberUtils.getRoundingModeForName(name);
/*  926 */     if (mode == null)
/*      */     {
/*  928 */       mode = RoundingMode.HALF_DOWN;
/*      */     }
/*  930 */     return mode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getDisplayCommissionedAssociatesPerReturnItem() {
/*  942 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "DisplayPerItemOnReturn" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getDisplayCommissionedAssociatesPerSaleItem() {
/*  955 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "DisplayPerItemOnSale" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getDisplayDeletedTimecardEntry() {
/*  960 */     return getHelper()
/*  961 */       .getBoolean(new String[] { "Store", "SystemConfig", "Timecard", "DisplayDeletedTimecardEntry" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getDisplayEndOfDayCompleteDialog() {
/*  971 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "DisplayEndRetailPeriodCompleteDialog" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getDisplayLayawayItemOnTransactionList() {
/*  976 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "DisplayLayawayItemOnTransactionList" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getDisplayMsgTillCountStatus() {
/*  986 */     return getHelper()
/*  987 */       .getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "DisplayMsgTillCountStatus" });
/*      */   }
/*      */   
/*      */   public static boolean getDisplayNegativeDeals() {
/*  991 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Deals", "DisplayNegative" });
/*      */   }
/*      */   
/*      */   public static int getDisplayNumberOfPreviousPayrollWeeks() {
/*  995 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Payroll", "PayrollCalendar", "DisplayNumberOfPreviousWeekinReport" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getDisplayPayrollNotYetPostMsgAtLoginIfPassPostDay() {
/* 1000 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "PostPayroll", "DisplayPayrollNotYetPostMsgAtLoginIfPassPostDay" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getDisplayProportionDealAmt() {
/* 1005 */     return getHelper()
/* 1006 */       .getBoolean(new String[] { "Store", "SystemConfig", "Deals", "DisplayProportionDealAmt" });
/*      */   }
/*      */   
/*      */   public static boolean getDisplayProportionDealAmtOnReturn() {
/* 1010 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Deals", "DisplayProportionDealAmtOnReturn" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getDisplaySendSaleItemCount() {
/* 1015 */     return getHelper()
/* 1016 */       .getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "DisplaySoldItemCount" });
/*      */   }
/*      */   
/*      */   public static boolean getDisplaySpecialOrderItemCount() {
/* 1020 */     return getHelper()
/* 1021 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "DisplaySoldItemCount" });
/*      */   }
/*      */   
/*      */   public static String getDonationDefaultNonMerchItemId() {
/* 1025 */     return getHelper()
/* 1026 */       .getString(new String[] { "Store", "SystemConfig", "Charity", "DonationDefaultNonMerchItemId" });
/*      */   }
/*      */   
/*      */   public static Boolean getEnableEftLinkGiftCardSupport() {
/* 1030 */     return Boolean.valueOf(getHelper()
/* 1031 */         .getBoolean(new String[] { "Store", "SystemConfig", "EFTLink", "EnableEftLinkGiftCardSupport" }));
/*      */   }
/*      */   
/*      */   public static boolean getEnableTaxCodeDisplayAndPrint() {
/* 1035 */     return getHelper()
/* 1036 */       .getBoolean(new String[] { "Store", "SystemConfig", "Tax", "EnableTaxCodeDisplayAndPrint" });
/*      */   }
/*      */   
/*      */   public static boolean getEnableVatTaxSummaryPrint() {
/* 1040 */     return getHelper()
/* 1041 */       .getBoolean(new String[] { "Store", "SystemConfig", "Tax", "EnableVatTaxSummaryPrint" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getEndClosingStatuses() {
/* 1046 */     String endCloseStatuses = getHelper().getString(new String[] { "Store", "SystemConfig", "ClosingTasks", "EndingStatuses" });
/*      */     
/* 1048 */     if (StringUtils.isEmpty(endCloseStatuses)) {
/* 1049 */       return new String[0];
/*      */     }
/* 1051 */     return endCloseStatuses.split(",");
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getEndClosingTask() {
/* 1056 */     String endCloseTask = getHelper().getString(new String[] { "Store", "SystemConfig", "ClosingTasks", "EndingTask" });
/*      */     
/* 1058 */     return StringUtils.isEmpty(endCloseTask) ? "CLOSING" : endCloseTask;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getEndOpeningStatuses() {
/* 1063 */     String endOpenStatuses = getHelper().getString(new String[] { "Store", "SystemConfig", "OpeningTasks", "EndingStatuses" });
/*      */     
/* 1065 */     if (StringUtils.isEmpty(endOpenStatuses)) {
/* 1066 */       return new String[0];
/*      */     }
/* 1068 */     return endOpenStatuses.split(",");
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getEndOpeningTask() {
/* 1073 */     String endOpenTask = getHelper().getString(new String[] { "Store", "SystemConfig", "OpeningTasks", "EndingTask" });
/*      */     
/* 1075 */     return StringUtils.isEmpty(endOpenTask) ? "OPEN" : endOpenTask;
/*      */   }
/*      */   
/*      */   public static boolean getEnforcePostPayrollDateTime() {
/* 1079 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "PostPayroll", "EnforcePostPayrollDateTime" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getEnvPasswordFileCreationRepeatInterval() {
/* 1090 */     return getHelper()
/* 1091 */       .getInt(new String[] { "Store", "SystemConfig", "EnvPasswordFile", "FileCreationRepeatInterval" });
/*      */   }
/*      */   
/*      */   public static boolean getExportHashedAccountNumber() {
/* 1095 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "CreditDebitTender", "ExportHashedAccountNumber" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getForceStorePickup() {
/* 1100 */     return getHelper()
/* 1101 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "ForceStorePickup" });
/*      */   }
/*      */   
/*      */   public static int getFutureSchedulingWeeks() {
/* 1105 */     return getHelper()
/* 1106 */       .getInt(new String[] { "Store", "SystemConfig", "Scheduling", "FutureSchedulingWeeks" });
/*      */   }
/*      */   
/*      */   public static int getFutureTimeOffWeeks() {
/* 1110 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Scheduling", "TimeOff", "FutureTimeOffWeeks" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getGiftReceiptMaxPrints() {
/* 1115 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "GiftReceipt", "MaxPrintsBeforeManagerOverride" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getGroupDiscountConfirmItemVoid() {
/* 1120 */     return getHelper()
/* 1121 */       .getBoolean(new String[] { "Store", "SystemConfig", "GroupDiscount", "ConfirmItemVoid" });
/*      */   }
/*      */   
/*      */   public static int getGroupDiscountMinItemsRequired() {
/* 1125 */     return getHelper()
/* 1126 */       .getInt(new String[] { "Store", "SystemConfig", "GroupDiscount", "MinItemsRequired" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static SystemConfigHelper getHelper() {
/* 1135 */     return helper_;
/*      */   }
/*      */   
/*      */   public static URL getHelpFilePathUrl() {
/* 1139 */     return ((IUrlConfig)getHelper()
/* 1140 */       .getObject(new String[] { "Store", "SystemConfig", "Help", "HelpFilePath" })).getUrl();
/*      */   }
/*      */   
/*      */   public static XstKeyStroke getHelpKey() {
/* 1144 */     XstKeyStroke helpKey = null;
/*      */     
/* 1146 */     String helpKeyName = getHelper().getString(new String[] { "Store", "SystemConfig", "Help", "HelpKey" });
/*      */     
/* 1148 */     if (!StringUtils.isEmpty(helpKeyName)) {
/* 1149 */       helpKey = XstKeyStroke.forName(helpKeyName);
/*      */     }
/* 1151 */     return helpKey;
/*      */   }
/*      */   
/*      */   public static String getHelpMenu() {
/* 1155 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Help", "HelpMenu" });
/*      */   }
/*      */   
/*      */   public static String getHomeOfficeManualAuthPhoneNumber() {
/* 1159 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "AccountsReceivable", "HomeOfficeManualAuthPhoneNumber" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getHouseAccountEmployeeId() {
/* 1164 */     return getHelper()
/* 1165 */       .getString(new String[] { "Store", "SystemConfig", "ItemReturn", "HouseAccountEmployeeId" });
/*      */   }
/*      */   
/*      */   public static boolean getIncludeEmployeeInDefaultGroup() {
/* 1169 */     return getHelper()
/* 1170 */       .getBoolean(new String[] { "Store", "SystemConfig", "IncludeEmployeeInDefaultGroup" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getInstructionalMsgIcon() {
/* 1175 */     return getHelper()
/* 1176 */       .getString(new String[] { "Store", "SystemConfig", "ItemMessaging", "InstructionalMsgIcon" });
/*      */   }
/*      */   
/*      */   public static boolean getInventoryEnableCountSheetMode() {
/* 1180 */     return getHelper()
/* 1181 */       .getBoolean(new String[] { "Store", "SystemConfig", "InventoryCount", "EnableCountSheetMode" });
/*      */   }
/*      */   
/*      */   public static boolean getInventoryPromptForQuantityOnItemKey() {
/* 1185 */     return getHelper()
/* 1186 */       .getBoolean(new String[] { "Store", "SystemConfig", "Inventory", "PromptForQuantityOnItemKey" });
/*      */   }
/*      */   
/*      */   public static boolean getInventoryPromptForQuantityOnItemScan() {
/* 1190 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Inventory", "PromptForQuantityOnItemScan" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getIrsIdentificationNumber() {
/* 1195 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "IrsIdentificationNumber" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupLoadGrid() {
/* 1199 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "LoadGrid" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupLoadPriceHistory() {
/* 1203 */     return getHelper()
/* 1204 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "LoadPriceHistory" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupLoadSalesHistory() {
/* 1208 */     return getHelper()
/* 1209 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "LoadSalesHistory" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupLoadSimilar() {
/* 1213 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "LoadSimilar" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupLoadSubstitute() {
/* 1217 */     return getHelper()
/* 1218 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "LoadSubstitute" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupLoadUpcs() {
/* 1222 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "LoadUpcs" });
/*      */   }
/*      */   
/*      */   public static String getItemLookupLocatorDistanceUnit() {
/* 1226 */     return getHelper()
/* 1227 */       .getString(new String[] { "Store", "SystemConfig", "ItemLookup", "LocatorDistanceUnit" });
/*      */   }
/*      */   
/*      */   public static int getItemLookupPriceHistoryDays() {
/* 1231 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemLookup", "PriceHistoryDays" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getItemLookupSalesHistoryWeeks() {
/* 1239 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemLookup", "SalesHistoryWeeks" });
/*      */   }
/*      */   
/*      */   public static boolean getItemLookupShowAdvancedSearchForm() {
/* 1243 */     return getHelper()
/* 1244 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemLookup", "ShowAdvancedSearchForm" });
/*      */   }
/*      */   
/*      */   public static int getItemMatrixHeight() {
/* 1248 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemMatrix", "Height" });
/*      */   }
/*      */   
/*      */   public static boolean getItemMatrixIsCacheEnabled() {
/* 1252 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemMatrix", "CacheEnabled" });
/*      */   }
/*      */   
/*      */   public static int getItemMatrixWidth() {
/* 1256 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemMatrix", "Width" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getItemMessageDisplayMessage() {
/* 1265 */     return getHelper()
/* 1266 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "DisplayMessage" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getItemMessageDisplayMessageAsNotify() {
/* 1275 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "DisplayMessageAsNotify" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getItemMessageDisplayOnReturnItem() {
/* 1280 */     return getHelper()
/* 1281 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "DisplayOnReturnItem" });
/*      */   }
/*      */   
/*      */   public static boolean getItemMessageDisplayOnSaleItem() {
/* 1285 */     return getHelper()
/* 1286 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "DisplayOnSaleItem" });
/*      */   }
/*      */   
/*      */   public static boolean getItemMessageDisplayOnSendItem() {
/* 1290 */     return getHelper()
/* 1291 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "DisplayOnSendItem" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static URL getItemMessageFileUrl() {
/* 1296 */     IUrlConfig config = (IUrlConfig)getHelper().getObject(new String[] { "Store", "SystemConfig", "ItemMessaging", "MessageFilePath" });
/*      */     
/* 1298 */     return (config != null) ? config.getUrl() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getItemMessageStyleMessageSupersede() {
/* 1307 */     return getHelper()
/* 1308 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemMessaging", "StyleMessageSupersede" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getItemNotOnFileDefaultId() {
/* 1317 */     return getHelper()
/* 1318 */       .getString(new String[] { "Store", "SystemConfig", "ItemSale", "ItemNotOnFileDefaultId" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getLapseTimeBeforeUnlockingUser() {
/* 1325 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "LoginSecurity", "LapseTimeBeforeUnlockingUser" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getLayawayAccountType() {
/* 1330 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Layaway", "AccountType" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayDelinquencyFeeAmount() {
/* 1334 */     return getHelper()
/* 1335 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "DelinquencyFeeAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayDelinquencyFeePercentage() {
/* 1339 */     return getHelper()
/* 1340 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "DelinquencyFeePercentage" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayDepositFixedAmount() {
/* 1344 */     return getHelper()
/* 1345 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "DepositFixedAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayDepositPercentage() {
/* 1349 */     return getHelper()
/* 1350 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "DepositPercentage" });
/*      */   }
/*      */   
/*      */   public static int getLayawayMinDaysBeforeEscrowAllowed() {
/* 1354 */     return getHelper()
/* 1355 */       .getInt(new String[] { "Store", "SystemConfig", "Layaway", "MinDaysBeforeEscrowAllowed" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayMinTotalItemPrice() {
/* 1359 */     return getHelper()
/* 1360 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "MinTotalItemPrice" });
/*      */   }
/*      */   
/*      */   public static int getLayawayPaymentPeriodDaysLength() {
/* 1364 */     return getHelper()
/* 1365 */       .getInt(new String[] { "Store", "SystemConfig", "Layaway", "PaymentPeriodDaysLength" });
/*      */   }
/*      */   
/*      */   public static int getLayawayPaymentPeriods() {
/* 1369 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Layaway", "PaymentPeriods" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayRestockingFeeFixedAmount() {
/* 1373 */     return getHelper()
/* 1374 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "RestockingFeeFixedAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawayRestockingFeePercentage() {
/* 1378 */     return getHelper()
/* 1379 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "RestockingFeePercentage" });
/*      */   }
/*      */   
/*      */   public static String getLayawayRestockingFeeType() {
/* 1383 */     return getHelper()
/* 1384 */       .getString(new String[] { "Store", "SystemConfig", "Layaway", "RestockingFeeType" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawaySetupFeeAmount() {
/* 1388 */     return getHelper()
/* 1389 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "SetupFeeAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLayawaySetupFeePercentage() {
/* 1393 */     return getHelper()
/* 1394 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "SetupFeePercentage" });
/*      */   }
/*      */   
/*      */   public static boolean getLineDiscountUseConfiguredScale() {
/* 1398 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "LineItemDiscount", "LineDiscountUseConfiguredScale" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getLineItemDiscountPrecision() {
/* 1404 */     return getHelper()
/* 1405 */       .getInt(new String[] { "Store", "SystemConfig", "LineItemDiscount", "LineDiscountPrecision" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getLineItemDiscountThresholdAmount() {
/* 1409 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "LineItemDiscount", "DiscountThreshold", "Amount" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getLineItemDiscountThresholdEnabled() {
/* 1414 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "LineItemDiscount", "DiscountThreshold", "Enabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getLineItemDiscountThresholdPercent() {
/* 1419 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "LineItemDiscount", "DiscountThreshold", "Percent" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getLocalCurrencyId() {
/* 1424 */     if (System.getProperty("LOCAL_CURRENCY_ID_PROPERTY") == null) {
/* 1425 */       System.setProperty("LOCAL_CURRENCY_ID_PROPERTY", 
/* 1426 */           getHelper().getString(new String[] { "Store", "SystemConfig", "LocalCurrencyId" }));
/*      */     }
/* 1428 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "LocalCurrencyId" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static RoundingMode getLocalCurrencyRoundingMode() {
/* 1433 */     String roundModeName = getHelper().getString(new String[] { "Store", "SystemConfig", "CurrencyRounding", "RoundingMode" });
/*      */     
/* 1435 */     RoundingMode roundMode = NumberUtils.getRoundingModeForName(roundModeName);
/*      */     
/* 1437 */     return (roundMode == null) ? RoundingMode.HALF_UP : roundMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getLocalCurrencyScale() {
/* 1446 */     return getCurrency().getDefaultFractionDigits();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getLoginFailLimit() {
/* 1455 */     if (!isAccountLockoutEnabled()) {
/* 1456 */       return -1;
/*      */     }
/*      */     
/* 1459 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "LoginSecurity", "AccountLockout", "Retries" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getManualEnteredCreditCardImprint() {
/* 1464 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Tender", "ManualEnteredCreditCardImprint" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static BigDecimal getMaxAssociateAdvanceAmount() {
/* 1469 */     return getHelper()
/* 1470 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Payroll", "MaxAssociateAdvanceAmount" });
/*      */   }
/*      */   
/*      */   public static int getMaxCommissionedAssociatesAllowed() {
/* 1474 */     int maxCommAssocAllowed = getHelper().getInt(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "MaxCommissionedAssociatesAllowed" });
/*      */     
/* 1476 */     if (maxCommAssocAllowed < 1) {
/* 1477 */       maxCommAssocAllowed = 99;
/*      */     }
/* 1479 */     return maxCommAssocAllowed;
/*      */   }
/*      */   
/*      */   public static BigDecimal getMaxDailyTotalPayrollHours() {
/* 1483 */     return getHelper()
/* 1484 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "Payroll", "MaxDailyTotalPayrollHours" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMaxDaysAfterPurchase() {
/* 1493 */     return getHelper()
/* 1494 */       .getInt(new String[] { "Store", "SystemConfig", "ItemReturn", "MaxDaysAfterPurchase" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMaxEmployeeIdLength() {
/* 1503 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "MaximumEmployeeIdLength" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getMaximumAllowedTotal() {
/* 1507 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "MixedTransactionSettings", "MaximumAllowedTotal" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMaximumItemIdLength() {
/* 1518 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemSale", "MaxItemIdLength" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getMaximumItemPrice() {
/* 1527 */     return getHelper()
/* 1528 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "ItemSale", "MaxItemPrice" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMaximumItemSerialLength() {
/* 1537 */     return getHelper()
/* 1538 */       .getInt(new String[] { "Store", "SystemConfig", "ItemSale", "MaxItemSerialLength" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getMaximumKeyedCostThreshold() {
/* 1547 */     return getHelper()
/* 1548 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "MaximumKeyedCostThreshold" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getMaximumKeyedQuantityThreshold() {
/* 1557 */     return getHelper()
/* 1558 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "MaximumKeyedQuantityThreshold" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getMaximumReturnItemPrice() {
/* 1567 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "ItemReturn", "MaximumReturnItemPrice" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getMaxNumberLayawayItems() {
/* 1572 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Layaway", "MaxLayawayItems" });
/*      */   }
/*      */   
/*      */   public static int getMaxNumberSpecOrderItems() {
/* 1576 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "SpecialOrder", "MaxItems" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getMaxTotalTransactionRefundThreshold() {
/* 1585 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "ItemReturn", "MaxTotalTransactionRefundThreshold" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMeasurementUnitOfLength() {
/* 1594 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "MeasurementUnits", "Length" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMeasurementUnitOfTemperature() {
/* 1602 */     return getHelper()
/* 1603 */       .getString(new String[] { "Store", "SystemConfig", "MeasurementUnits", "Temperature" });
/*      */   }
/*      */   
/*      */   public static int getMenuButtonCount() {
/* 1607 */     return getHelper().getInt(new String[] { "Store", "RegisterConfig", "Terminal", "MenuButtonCount" });
/*      */   }
/*      */   
/*      */   public static String getMerchHierLevel1Code() {
/* 1611 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "MerchHierarchy", "Level1Code" });
/*      */   }
/*      */   
/*      */   public static String getMerchHierLevel2Code() {
/* 1615 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "MerchHierarchy", "Level2Code" });
/*      */   }
/*      */   
/*      */   public static String getMerchHierLevel3Code() {
/* 1619 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "MerchHierarchy", "Level3Code" });
/*      */   }
/*      */   
/*      */   public static String getMerchHierLevel4Code() {
/* 1623 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "MerchHierarchy", "Level4Code" });
/*      */   }
/*      */   
/*      */   public static int getMessageClearTime() {
/* 1627 */     return getHelper().getInt(new String[] { "Store", "Xenvironment", "MessageClearTime" });
/*      */   }
/*      */   
/*      */   public static int getMinCommissionedAssociatesAllowed() {
/* 1631 */     int i = getHelper().getInt(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "MinCommissionedAssociatesAllowed" });
/*      */ 
/*      */     
/* 1634 */     return Math.max(i, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMinEmployeeIdLength() {
/* 1643 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "MinimumEmployeeIdLength" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getMinimumCashInTill() {
/* 1647 */     return getHelper()
/* 1648 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "TillAccountability", "MinimumCashInTill" });
/*      */   }
/*      */   
/*      */   public static long getMinimumCheckNumber() {
/* 1652 */     return getHelper()
/* 1653 */       .getLong(new String[] { "Store", "SystemConfig", "CheckTender", "MinimumCheckNumber" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMinimumItemIdLength() {
/* 1663 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemSale", "MinItemIdLength" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMinimumItemSerialLength() {
/* 1672 */     return getHelper()
/* 1673 */       .getInt(new String[] { "Store", "SystemConfig", "ItemSale", "MinItemSerialLength" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getMinimumLayawayPaymentAmount() {
/* 1677 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "MinimumPaymentDollarAmount" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static BigDecimal getMinimumLayawayPaymentPctOfRecommended() {
/* 1682 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "Layaway", "MinimumPaymentPctOfRecommended" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal getMinimumReturnItemPrice() {
/* 1692 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "ItemReturn", "MinimumReturnItemPrice" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static BigDecimal getMinimumRoundUpDonationThreshold() {
/* 1697 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "Charity", "MinimumRoundUpDonationThreshold" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getMultipleQuantityPrintsMultipleGiftReceipts() {
/* 1702 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "GiftReceipt", "MultipleQuantityPrintsMultipleGiftReceipts" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getNonMerchIncludeItemCounts() {
/* 1707 */     String nonMerchIncludeItemCounts = getHelper().getString(new String[] { "Store", "SystemConfig", "NonMerchItemTypes", "IncludeItemCounts" });
/*      */ 
/*      */     
/* 1710 */     if (StringUtils.isEmpty(nonMerchIncludeItemCounts)) {
/* 1711 */       return new String[0];
/*      */     }
/* 1713 */     return nonMerchIncludeItemCounts.split(",");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> getNonTaxableSellingGroups() {
/* 1723 */     String tmp = getHelper().getString(new String[] { "Store", "SystemConfig", "FiscalConfig", "NonTaxableSellingGroups" });
/*      */     
/* 1725 */     if (!StringUtils.isEmpty(tmp)) {
/* 1726 */       return getHelper().getStringList(new String[] { "Store", "SystemConfig", "FiscalConfig", "NonTaxableSellingGroups" });
/*      */     }
/*      */ 
/*      */     
/* 1730 */     return Arrays.asList(new String[] { "DEFAULT_NON_FISCAL_GROUP" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getNotifyForItemNotOnFile() {
/* 1742 */     return getHelper()
/* 1743 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "NotifyForItemNotOnFile" });
/*      */   }
/*      */   
/*      */   public static int getNumberCpltGoalsToDisplay() {
/* 1747 */     return getHelper()
/* 1748 */       .getInt(new String[] { "Store", "SystemConfig", "SalesGoal", "NumberCpltGoalsToDisplay" });
/*      */   }
/*      */   
/*      */   public static int getNumberFutureGoalsToDisplay() {
/* 1752 */     return getHelper()
/* 1753 */       .getInt(new String[] { "Store", "SystemConfig", "SalesGoal", "NumberFutureGoalsToDisplay" });
/*      */   }
/*      */   
/*      */   public static int getNumberOfMerchHierLevels() {
/* 1757 */     return getHelper()
/* 1758 */       .getInt(new String[] { "Store", "SystemConfig", "MerchHierarchy", "NumberOfLevels" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getNumDaysToSearchPaymentsMade() {
/* 1762 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "AccountsReceivable", "NumDaysToSearchPaymentsMade" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getOnHandInventoryBucketId() {
/* 1767 */     return getHelper()
/* 1768 */       .getString(new String[] { "Store", "RegisterConfig", "Location", "OnHandInventoryBucketId" });
/*      */   }
/*      */   
/*      */   public static boolean getOnlyWriteHourlyPayStatusEmpInPayrollLog() {
/* 1772 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "PostPayroll", "OnlyWriteHourlyPayStatusEmpInPayrollLog" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getOnScreenKeyboardKeyClickDuration() {
/* 1781 */     return getHelper()
/* 1782 */       .getInt(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "KeyClickDuration" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getOnScreenKeyboardKeyClickFreqency() {
/* 1790 */     return getHelper()
/* 1791 */       .getInt(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "KeyClickFrequency" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getOnScreenKeyboardKeyClickVolume() {
/* 1799 */     return getHelper()
/* 1800 */       .getInt(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "KeyClickVolume" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getOnScreenKeyboardLayout() {
/* 1808 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "Layout" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getOrganizationId() {
/* 1818 */     return Long.parseLong(System.getProperty("dtv.location.organizationId"));
/*      */   }
/*      */   
/*      */   public static String getOvertimeRuleType() {
/* 1822 */     return getHelper()
/* 1823 */       .getString(new String[] { "Store", "RegisterConfig", "Location", "OvertimeRuleType" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPasswordExpirationDays() {
/* 1832 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "LoginSecurity", "PasswordExpiration", "Days" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPasswordHistoryLength() {
/* 1838 */     return getHelper()
/* 1839 */       .getInt(new String[] { "Store", "SystemConfig", "LoginSecurity", "PasswordHistoryLength" });
/*      */   }
/*      */   
/*      */   public static int getPastTimeOffWeeks() {
/* 1843 */     return getHelper()
/* 1844 */       .getInt(new String[] { "Store", "SystemConfig", "Scheduling", "TimeOff", "PastTimeOffWeeks" });
/*      */   }
/*      */   
/*      */   public static int getPayrollCalendarDisplayNumberOfPreviousWeek() {
/* 1848 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Payroll", "PayrollCalendar", "DisplayNumberOfPreviousWeek" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getPayrollHoursRoundingMinutes() {
/* 1853 */     return getHelper()
/* 1854 */       .getString(new String[] { "Store", "SystemConfig", "Payroll", "PayrollHoursRoundingMinutes" });
/*      */   }
/*      */   
/*      */   public static int getPayrollPostDay() {
/* 1858 */     return getHelper()
/* 1859 */       .getInt(new String[] { "Store", "SystemConfig", "Payroll", "PostPayroll", "PayrollPostDay" });
/*      */   }
/*      */   
/*      */   public static String getPayrollPostTime() {
/* 1863 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Payroll", "PostPayroll", "PayrollPostTime" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static BigDecimal getPickupFloatRoundingFactor() {
/* 1868 */     return getHelper().getBigDecimal(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "PickUpFloatRoundFactor" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getPostVoidPromptForReason() {
/* 1878 */     return getHelper()
/* 1879 */       .getBoolean(new String[] { "Store", "SystemConfig", "PostVoid", "PromptForReason" });
/*      */   }
/*      */   
/*      */   public static boolean getPreferCurrentSystemDayOpen() {
/* 1883 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "PreferCurrentSystemDayOpen" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPreSaleAssignCommissionedAssociates() {
/* 1888 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "PreSalesTransaction", "PromptAssignCommissionedAssociates" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPriceHistoryLookupPreviousNumberOfDays() {
/* 1898 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "ItemReturn", "PriceHistory", "PriceHistoryLookupPreviousNumberOfDays" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getPrimaryTerminalId() {
/* 1903 */     return getHelper()
/* 1904 */       .getInt(new String[] { "Store", "RegisterConfig", "Terminal", "PrimaryTerminalId" });
/*      */   }
/*      */   
/*      */   public static boolean getPrintStoreCopyWithSigCaptured() {
/* 1908 */     return getHelper()
/* 1909 */       .getBoolean(new String[] { "Store", "SystemConfig", "PrintStoreCopyWithSigCaptured" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getPrintSuspendTransReceipt() {
/* 1920 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SuspendTransaction", "PrintSuspendTransReceipt" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getPromptBirthdayForCheckTender() {
/* 1930 */     return getHelper()
/* 1931 */       .getBoolean(new String[] { "Store", "SystemConfig", "CheckTender", "PromptForBirthday" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getPromptForBirthDate() {
/* 1940 */     return getHelper()
/* 1941 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "PromptForBirthDate" });
/*      */   }
/*      */   
/*      */   public static boolean getPromptForCommissionedAssociates() {
/* 1945 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "PromptForCommissionedAssociates" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getPromptForCommissionedAssociatesPerItem() {
/* 1959 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "PromptPerItem" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptForCommissionedAssociatesWithList() {
/* 1964 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "CommissionedAssociates", "PromptWithList" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptForCustomerUponReturn() {
/* 1969 */     return getHelper()
/* 1970 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "PromptForCustomer" });
/*      */   }
/*      */   
/*      */   public static boolean getPromptForExpectedDate() {
/* 1974 */     return getHelper()
/* 1975 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "PromptForExpectedDate" });
/*      */   }
/*      */   
/*      */   public static boolean getPromptForGiftReceiptGrouping() {
/* 1979 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "GiftReceipt", "PromptForGiftReceiptGrouping" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptForMultipleGiftReceipts() {
/* 1984 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "GiftReceipt", "PromptForMultipleGiftReceipts" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptForPaymentPeriodDaysLength() {
/* 1989 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "PromptForPaymentPeriodDaysLength" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptForPaymentPeriods() {
/* 1994 */     return getHelper()
/* 1995 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "PromptForPaymentPeriods" });
/*      */   }
/*      */   
/*      */   public static boolean getPromptForPaymentScheduleChange() {
/* 1999 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "PromptForPaymentScheduleChange" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptForTranCancelReasonCode() {
/* 2004 */     return getHelper()
/* 2005 */       .getBoolean(new String[] { "Store", "SystemConfig", "Transaction", "PromptForCancelReasonCode" });
/*      */   }
/*      */   
/*      */   public static boolean getPromptGiftRcptForVerifiedReturnBarcodeScan() {
/* 2009 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "PromptGiftRcptForVerifiedReturnBarcodeScan" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptInvoicesAtPayment() {
/* 2014 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "PromptInvoicesAtPayment" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptOriginalTransactionListUponEntry() {
/* 2019 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "PromptOriginalTransactionListUponEntry" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptShippingFeeAdded() {
/* 2024 */     return getHelper()
/* 2025 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "PromptShippingFeeAdded" });
/*      */   }
/*      */   
/*      */   public static boolean getPromptStatementDateAtPayment() {
/* 2029 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "PromptStatementDateAtPayment" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptTndrAmtForOriginalCreditCardTender() {
/* 2034 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "PromptTndrAmtForOriginalCreditCardTender" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getPromptUserForSaleCompletion() {
/* 2046 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "PromptUserForSaleCompletion" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptUserInfo() {
/* 2051 */     return getHelper()
/* 2052 */       .getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "PromptUserInfo" });
/*      */   }
/*      */   
/*      */   public static String getPromptUserInfoMethod() {
/* 2056 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "AccountsReceivable", "PromptUserInfoMethod" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getPromptUserOnChangeItem() {
/* 2061 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "PromptUserOnChangeItem" });
/*      */   }
/*      */   
/*      */   public static boolean getProRatedDiscountReturnsDisabled() {
/* 2065 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "ProRatedDiscountReturnsDisabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getProRatedTaxOnReturnsDisabled() {
/* 2070 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "ProRatedTaxOnReturnsDisabled" }, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getQuickItemsTabHeight() {
/* 2075 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "QuickItems", "TabHeight" });
/*      */   }
/*      */   
/*      */   public static int getQuickItemsTabWidth() {
/* 2079 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "QuickItems", "TabWidth" });
/*      */   }
/*      */   
/*      */   public static int getRainCheckExpirationDays() {
/* 2083 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "RainCheck", "ExpirationDays" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getRainCheckQuantityLimit() {
/* 2087 */     return getHelper()
/* 2088 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "RainCheck", "QuantityLimit" });
/*      */   }
/*      */   
/*      */   public static String getReceivingDocumentIdRule() {
/* 2092 */     return getHelper()
/* 2093 */       .getString(new String[] { "Store", "SystemConfig", "Receiving", "ReceivingDocumentIdRule" });
/*      */   }
/*      */   
/*      */   public static boolean getRecountCloseCountDiscrepancyOverThreshold() {
/* 2097 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "RecountCloseCountDiscrepancyOverThreshold" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getRefundProrationTimeUnit() {
/* 2102 */     return getHelper()
/* 2103 */       .getString(new String[] { "Store", "SystemConfig", "ItemReturn", "ProrationTimeUnit" });
/*      */   }
/*      */   
/*      */   public static boolean getRefundSetupFeeOnCancel() {
/* 2107 */     return getHelper()
/* 2108 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "RefundSetupFeeOnCancel" });
/*      */   }
/*      */   
/*      */   public static String getRegisterInstructionalMsgTitle() {
/* 2112 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "ItemMessaging", "RegisterInstructionalMsgTitle" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getRegisterRestrictSaleType() {
/* 2117 */     return getHelper().getString(new String[] { "Store", "RegisterConfig", "RestrictSaleType" });
/*      */   }
/*      */   
/*      */   public static boolean getRegularHoursFromTimeCard() {
/* 2121 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "IsRegularPayrollHoursFromTimeCard" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getRelateBlackBookCustSegmentId() {
/* 2126 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "BlackBookSegmentId" });
/*      */   }
/*      */   
/*      */   public static String getRelateDefaultUserId() {
/* 2130 */     return getHelper()
/* 2131 */       .getString(new String[] { "Store", "SystemConfig", "RelateSecurity", "DefaultUserId" });
/*      */   }
/*      */   
/*      */   public static String getRelateSecurityType() {
/* 2135 */     return getHelper()
/* 2136 */       .getString(new String[] { "Store", "SystemConfig", "RelateSecurity", "SecurityType" });
/*      */   }
/*      */   
/*      */   public static boolean getRequireARAcctOwnerAsscWithTrans() {
/* 2140 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "RequireARAcctOwnerAsscWithTrans" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getRequireDepostForWorkOrder() {
/* 2145 */     return getHelper()
/* 2146 */       .getBoolean(new String[] { "Store", "SystemConfig", "WorkOrder", "RequireDeposit" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getRequiredReversalPaymentReasonCode() {
/* 2156 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "RequiredReversalPaymentReasonCode" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getRequireItemVoidReasonCode() {
/* 2166 */     return getHelper()
/* 2167 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "RequireItemVoidReasonCode" });
/*      */   }
/*      */   
/*      */   public static boolean getRequirePartyObjectForAllUsers() {
/* 2171 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "RequirePartyObjectForAllUsers" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getReturnVerificationRequired() {
/* 2181 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "ReturnVerification", "ReturnVerificationRequired" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getReviewPayrollRequired() {
/* 2186 */     return getHelper()
/* 2187 */       .getBoolean(new String[] { "Store", "SystemConfig", "Payroll", "ReviewPayrollRequired" });
/*      */   }
/*      */   
/*      */   public static RollingCloseType getRollingCloseType() {
/* 2191 */     String rollingCloseType = getHelper().getString(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "RollingCloseType" }, "DISABLED");
/*      */ 
/*      */     
/* 2194 */     RollingCloseType type = RollingCloseType.DISABLED;
/*      */     try {
/* 2196 */       type = RollingCloseType.valueOf(rollingCloseType);
/*      */     }
/* 2198 */     catch (Throwable ex) {
/*      */       
/* 2200 */       logger_.warn("Unable to parse rolling close type [" + rollingCloseType + "]", ex);
/*      */     } 
/*      */     
/* 2203 */     return type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getSaleEndingChain() {
/* 2212 */     return getHelper().getString(new String[] { "Store", "RegisterConfig", "SaleEndingChain" });
/*      */   }
/*      */   
/*      */   public static String getSendCloseBatchAuthMethodCode() {
/* 2216 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "CreditDebitTender", "CloseBatch", "AuthMethodCode" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getSendSaleTaxType() {
/* 2221 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "SendSale", "SendTaxType" });
/*      */   }
/*      */   
/*      */   public static int getSeriesIdLength() {
/* 2225 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Document", "SeriesIdLength" });
/*      */   }
/*      */   
/*      */   public static int getSeriesIdStartingIndexInDocId() {
/* 2229 */     return getHelper()
/* 2230 */       .getInt(new String[] { "Store", "SystemConfig", "Document", "SeriesIdStartingIndexInDocId" });
/*      */   }
/*      */   
/*      */   public static String getSetupFeeType() {
/* 2234 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Layaway", "SetupFeeType" });
/*      */   }
/*      */   
/*      */   public static boolean getShowOutstandingInvoicesForPayment() {
/* 2238 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AccountsReceivable", "ShowOutstandingInvoicesForPayment" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getSkipSearchFormIfCustomer() {
/* 2243 */     return getHelper()
/* 2244 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "SkipSearchFormIfCustomer" });
/*      */   }
/*      */   
/*      */   public static String getSpecOrderDepositFeeType() {
/* 2248 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "SpecialOrder", "DepositFeeType" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderDepositFixedAmount() {
/* 2252 */     return getHelper()
/* 2253 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "DepositFixedAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderDepositPercentage() {
/* 2257 */     return getHelper()
/* 2258 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "DepositPercentage" });
/*      */   }
/*      */   
/*      */   public static String getSpecOrderItemNotOnFileDefaultId() {
/* 2262 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "SpecialOrder", "SpecOrderItemNotOnFileDefaultId" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getSpecOrderMinDaysBeforeEscrowAllowed() {
/* 2267 */     return getHelper()
/* 2268 */       .getInt(new String[] { "Store", "SystemConfig", "SpecialOrder", "MinDaysBeforeEscrowAllowed" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderMinTotalItemPrice() {
/* 2272 */     return getHelper()
/* 2273 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "MinTotalItemPrice" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderRestockingFeeFixedAmount() {
/* 2277 */     return getHelper()
/* 2278 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "RestockingFeeFixedAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderRestockingFeePercentage() {
/* 2282 */     return getHelper()
/* 2283 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "RestockingFeePercentage" });
/*      */   }
/*      */   
/*      */   public static String getSpecOrderRestockingFeeType() {
/* 2287 */     return getHelper()
/* 2288 */       .getString(new String[] { "Store", "SystemConfig", "SpecialOrder", "RestockingFeeType" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderServiceFeeAmount() {
/* 2292 */     return getHelper()
/* 2293 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "ServiceFeeAmount" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getSpecOrderServiceFeePercentage() {
/* 2297 */     return getHelper()
/* 2298 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "SpecialOrder", "ServiceFeePercentage" });
/*      */   }
/*      */   
/*      */   public static String getSpecOrderServiceFeeType() {
/* 2302 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "SpecialOrder", "ServiceFeeType" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getStartClosingStatuses() {
/* 2307 */     String startCloseStatuses = getHelper().getString(new String[] { "Store", "SystemConfig", "ClosingTasks", "StartingStatuses" });
/*      */     
/* 2309 */     if (StringUtils.isEmpty(startCloseStatuses)) {
/* 2310 */       return new String[0];
/*      */     }
/* 2312 */     return startCloseStatuses.split(",");
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getStartClosingTask() {
/* 2317 */     String startCloseTask = getHelper().getString(new String[] { "Store", "SystemConfig", "ClosingTasks", "StartingTask" });
/*      */     
/* 2319 */     return StringUtils.isEmpty(startCloseTask) ? "CLOSING" : startCloseTask;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getStartOpeningStatuses() {
/* 2324 */     String startOpenStatuses = getHelper().getString(new String[] { "Store", "SystemConfig", "OpeningTasks", "StartingStatuses" });
/*      */     
/* 2326 */     if (StringUtils.isEmpty(startOpenStatuses)) {
/* 2327 */       return new String[0];
/*      */     }
/* 2329 */     return startOpenStatuses.split(",");
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getStartOpeningTask() {
/* 2334 */     String startOpenTask = getHelper().getString(new String[] { "Store", "SystemConfig", "OpeningTasks", "StartingTask" });
/*      */     
/* 2336 */     return StringUtils.isEmpty(startOpenTask) ? "OPEN" : startOpenTask;
/*      */   }
/*      */   
/*      */   public static String getStartTillCountMethod() {
/* 2340 */     return getHelper()
/* 2341 */       .getString(new String[] { "Store", "SystemConfig", "TillAccountability", "StartTillCountMethod" });
/*      */   }
/*      */   
/*      */   public static String getStartupApplication() {
/* 2345 */     String data = getHelper().getString(new String[] { "Store", "RegisterConfig", "OpenClose", "StartupApplication" });
/*      */     
/* 2347 */     if (data == null) {
/* 2348 */       logger_.warn("no setting for StartupApplication");
/*      */     }
/* 2350 */     return data;
/*      */   }
/*      */   
/*      */   public static String getStoreBankEndCountAtStoreCloseMethod() {
/* 2354 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "TillAccountability", "StoreBankEndCountAtStoreCloseMethod" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getStoreCloseGracePeriod() {
/* 2365 */     return getHelper().getInt(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "StoreCloseGracePeriod" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getStoreCloseWarningFrequency() {
/* 2374 */     return getHelper().getInt(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "StoreCloseWarningFrequency" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getStoreCloseWarningSpan() {
/* 2383 */     return getHelper().getInt(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "StoreCloseWarningSpan" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LocalTime getStoreOpenTime() {
/* 2392 */     return getHelper().getTime(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "StoreOpenTime" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static BigDecimal getSuggestedAfterCashPickUpAmtUponOverMax() {
/* 2397 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "TillAccountability", "SuggestedAfterCashPickUpAmtUponOverMax" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getSuspendedTransactionsLookback() {
/* 2406 */     return getHelper().getInt(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "SuspendedTransactionsLookback" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object getSystemProperty(String argKey) {
/* 2418 */     Object o = getHelper().getObject(argKey.split("\\."));
/* 2419 */     if (o == null) {
/* 2420 */       logger_.warn("System property '" + argKey + "' not found.", new Throwable("STACK TRACE"));
/*      */     }
/* 2422 */     return o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object getSystemPropertyFromMethod(String methodName) {
/*      */     try {
/* 2434 */       Method getter = ConfigurationMgr.class.getMethod(methodName, (Class[])null);
/* 2435 */       return getter.invoke(null, (Object[])null);
/*      */     }
/* 2437 */     catch (Exception ex) {
/* 2438 */       logger_.warn("Unable to retrieve getter method for attribute " + methodName, ex);
/* 2439 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static String getTabletScreenRatio() {
/* 2444 */     return getHelper()
/* 2445 */       .getString(new String[] { "Store", "SystemConfig", "UserInterface", "TabletScreenRatio" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getTaxDisableChangeTaxAmount() {
/* 2453 */     return getHelper()
/* 2454 */       .getBoolean(new String[] { "Store", "SystemConfig", "Tax", "DisableChangeTaxAmount" });
/*      */   }
/*      */   
/*      */   public static int getTaxGroupLines() {
/* 2458 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Tax", "TaxGroupLines" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getTaxIgnoreTaxGroups() {
/* 2467 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Tax", "IgnoreTaxGroups" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getTaxSelectTaxPercentFromList() {
/* 2475 */     return getHelper()
/* 2476 */       .getBoolean(new String[] { "Store", "SystemConfig", "Tax", "SelectTaxPercentFromList" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getTaxShippingFeeLikeAssociatedLineItem() {
/* 2486 */     return getHelper()
/* 2487 */       .getBoolean(new String[] { "Store", "SystemConfig", "TaxShippingFeeLikeAssociatedLineItem" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getTempFilePath() {
/* 2496 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "TempFilePath" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getTenderAmtOverAvailCreditLimitThreshold() {
/* 2500 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "AccountsReceivable", "ARTenderAmtOverAvailCreditLimitThreshold" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTillPickupMethod() {
/* 2505 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "TillAccountability", "TillPickupMethod" });
/*      */   }
/*      */   
/*      */   public static String getTimecardEntryRoundingMinutes() {
/* 2509 */     return getHelper()
/* 2510 */       .getString(new String[] { "Store", "SystemConfig", "Timecard", "TimecardEntryRoundingMinutes" });
/*      */   }
/*      */   
/*      */   public static int getTimecardHourGreaterThanHours() {
/* 2514 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Timecard", "Exception", "TimecardHourGreaterThanHours" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getTimecardHourLessThanHours() {
/* 2520 */     return getHelper().getInt(new String[] { "Store", "SystemConfig", "Timecard", "Exception", "TimecardHourLessThanHours" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getTimecardPrintAcceptanceForm() {
/* 2525 */     return getHelper()
/* 2526 */       .getBoolean(new String[] { "Store", "SystemConfig", "Timecard", "PrintAcceptanceForm" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getTimeIntervalForCheckingForNewCachedPromotions() {
/* 2534 */     return getHelper().getInt(new String[] { "Store", "RegisterConfig", "RefreshPromotions", "TimeIntervalForCheckingForNewCachedPromotions" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<Comparator<IRetailTransactionLineItem>> getTLogLineItemComparatorImpl() {
/* 2540 */     return getHelper()
/* 2541 */       .getConfiguredClass(new String[] { "Store", "SystemConfig", "Tlog", "LineItemComparator" });
/*      */   }
/*      */   
/*      */   public static String getTrainingSequenceFilePath() {
/* 2545 */     return getHelper()
/* 2546 */       .getString(new String[] { "Store", "SystemConfig", "SequenceFilePaths", "TrainingFilePath" });
/*      */   }
/*      */   
/*      */   public static boolean getTransactionDiscountConfirmItemVoid() {
/* 2550 */     return true;
/*      */   }
/*      */   
/*      */   public static String getTwitterAuthAccessToken() {
/* 2554 */     return getHelper()
/* 2555 */       .getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "AccessToken" });
/*      */   }
/*      */   
/*      */   public static String getTwitterAuthAccessTokenSecret() {
/* 2559 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "AccessTokenSecret" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTwitterAuthConsumerKey() {
/* 2564 */     return getHelper()
/* 2565 */       .getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "ConsumerKey" });
/*      */   }
/*      */   
/*      */   public static String getTwitterAuthConsumerSecret() {
/* 2569 */     return getHelper()
/* 2570 */       .getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "ConsumerSecret" });
/*      */   }
/*      */   
/*      */   public static String getTwitterFollowAccount() {
/* 2574 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "FollowAccount" });
/*      */   }
/*      */   
/*      */   public static String getTwitterMode() {
/* 2578 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Mode" });
/*      */   }
/*      */   
/*      */   public static String getTwitterOauthAccessTokenURL() {
/* 2582 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "OauthAccessTokenURL" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTwitterOauthAthorizationURL() {
/* 2587 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "OauthAthorizationURL" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTwitterOauthAuthenticationURL() {
/* 2592 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "OauthAuthenticationURL" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTwitterOauthRequestTokenURL() {
/* 2597 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "OauthRequestTokenURL" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTwitterRestBaseURL() {
/* 2602 */     return getHelper()
/* 2603 */       .getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "RestBaseURL" });
/*      */   }
/*      */   
/*      */   public static String getTwitterSiteStreamBaseURL() {
/* 2607 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "SiteStreamBaseURL" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getTwitterStremBaseURL() {
/* 2612 */     return getHelper()
/* 2613 */       .getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "StreamBaseURL" });
/*      */   }
/*      */   
/*      */   public static String getTwitterUserStreamBaseURL() {
/* 2617 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "Twitter", "Credentials", "UserStreamBaseURL" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getUIOrientation() {
/* 2622 */     return getHelper()
/* 2623 */       .getString(new String[] { "Store", "SystemConfig", "UserInterface", "UIOrientation" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getUnlockUserRepeatInterval() {
/* 2630 */     return getHelper()
/* 2631 */       .getInt(new String[] { "Store", "SystemConfig", "LoginSecurity", "UnlockUserRepeatInterval" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getUnverifiedReturnsPromptSendSale() {
/* 2641 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "UnverifiedReturnsPromptSendSale" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getUpdateGracePeriod() {
/* 2647 */     return getHelper().getInt(new String[] { "Store", "Xenvironment", "UpdateGracePeriod" });
/*      */   }
/*      */   
/*      */   public static int getUpdateRequiredPeriod() {
/* 2651 */     return getHelper().getInt(new String[] { "Store", "Xenvironment", "UpdateRequiredPeriod" });
/*      */   }
/*      */   
/*      */   public static boolean getUseCategoryServiceLocations() {
/* 2655 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "WorkOrder", "UseCategoryServiceLocations" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getUseItemTableAsPrimary() {
/* 2666 */     return getHelper()
/* 2667 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "UseItemTableAsPrimary" });
/*      */   }
/*      */   
/*      */   public static boolean getValidateAnyEmployeeNotClockOutYet() {
/* 2671 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "ValidateAnyEmployeeNotClockOutYet" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getValidateCashTenderGoNegative() {
/* 2676 */     return getHelper()
/* 2677 */       .getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "ValidateCashTenderGoNegative" });
/*      */   }
/*      */   
/*      */   public static boolean getValidateControlNumber() {
/* 2681 */     return getHelper()
/* 2682 */       .getBoolean(new String[] { "Store", "SystemConfig", "Receiving", "ValidateControlNumber" });
/*      */   }
/*      */   
/*      */   public static boolean getValidateReturnSerialNumberAgainstOriginalTrans() {
/* 2686 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "ValidateReturnSerialNumberAgainstOriginalTrans" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getVoucherNumberMask() {
/* 2696 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "VoucherNumberMask" });
/*      */   }
/*      */   
/*      */   public static int getWeatherUpdateIfDataIsOlderThanMinutes() {
/* 2700 */     return getHelper()
/* 2701 */       .getInt(new String[] { "Store", "SystemConfig", "Weather", "UpdateIfDataIsOlderThanMinutes" });
/*      */   }
/*      */   
/*      */   public static BigDecimal getWorkOrderDepositPercentage() {
/* 2705 */     return getHelper()
/* 2706 */       .getBigDecimal(new String[] { "Store", "SystemConfig", "WorkOrder", "DepositPercentage" });
/*      */   }
/*      */   
/*      */   public static boolean haltApplicationOnRtlLocClose() {
/* 2710 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "HaltApplicationOnRtlLocClose" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean hasSystemProperty(String argKey) {
/* 2721 */     Object o = getHelper().getObject(argKey.split("\\."));
/* 2722 */     if (o == null) {
/* 2723 */       return false;
/*      */     }
/*      */     
/* 2726 */     return (!(o instanceof dtv.util.config.StringConfig) || o.toString().length() != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean hideGiftRegistryPurchasedQuantity() {
/* 2731 */     return getHelper()
/* 2732 */       .getBoolean(new String[] { "Store", "SystemConfig", "GiftRegistry", "HidePurchasedQuantity" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String idType() {
/* 2741 */     return getHelper().getString(new String[] { "Store", "SystemConfig", "LoginSecurity", "IdType" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAccountLockoutEnabled() {
/* 2750 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "LoginSecurity", "AccountLockout", "Enabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isAuthenticationRequiredOnAppChange() {
/* 2755 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "AlwaysAuthenticateOnAppChange" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isAutoGenerateShippingFee() {
/* 2760 */     return getHelper()
/* 2761 */       .getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "AutoGenerateShippingFee" });
/*      */   }
/*      */   
/*      */   public static boolean isAutoLogoutEnabled() {
/* 2765 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AutoLogout", "Enabled" });
/*      */   }
/*      */   
/*      */   public static boolean isBatchShipMode() {
/* 2769 */     return getHelper()
/* 2770 */       .getBoolean(new String[] { "Store", "SystemConfig", "WorkOrder", "BatchShipMode" });
/*      */   }
/*      */   
/*      */   public static boolean isBINSmartLookupEnabled() {
/* 2774 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "CreditDebitTender", "BINSmartLookup", "Enabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBlindReturnAmountThresholdEnabled() {
/* 2779 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "BlindReturns", "AmountThresholdEnabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBlindReturnLowestPriceEnabled() {
/* 2784 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "BlindReturns", "LowestPriceReturnEnabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBlindWSOpenOnRtlLocOpen() {
/* 2789 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "BlindWSOpenOnRtlLocOpen" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isClockInNotRequiredOnCreateEmployee() {
/* 2794 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TimeClock", "ClockInNotRequiredOnCreateEmpFlag" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isCrossBorderReturnsAllowed() {
/* 2799 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "CrossBorderReturnsEnabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isCrossChannelReturnsEnabled() {
/* 2804 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "CrossChannelReturnsEnabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isCrossStateReturnsAllowed() {
/* 2809 */     return getHelper()
/* 2810 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "CrossStateReturnsEnabled" });
/*      */   }
/*      */   
/*      */   public static boolean isCrossStoreReturnsAllowed() {
/* 2814 */     return getHelper()
/* 2815 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "CrossStoreReturnsEnabled" });
/*      */   }
/*      */   
/*      */   public static Boolean isCustomerAccountCreditAsTender() {
/* 2819 */     return Boolean.valueOf(getHelper()
/* 2820 */         .getBoolean(new String[] { "Store", "SystemConfig", "CustomerAccountCreditAsTender" }));
/*      */   }
/*      */   
/*      */   public static boolean isCustomerDefaultDestination() {
/* 2824 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "CustomerIsDefaultDestination" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isDatabaseTranslationEnabled() {
/* 2829 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "DatabaseTranslationsEnabled" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isDecimalKeyboardAutomaticallyCalled() {
/* 2837 */     return getHelper()
/* 2838 */       .getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "AutomaticCallDecimal" });
/*      */   }
/*      */   
/*      */   public static boolean isDonationEnabled() {
/* 2842 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Charity", "EnableDonation" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static final Boolean isDualScreenEnabled() {
/* 2847 */     return Boolean.valueOf(getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "DualDisplay", "EnableDualDisplay" }));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isEnhancedSendSale() {
/* 2852 */     return getHelper()
/* 2853 */       .getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "EnhancedSendSale" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEqualSecurityRankAccessible() {
/* 2865 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "AllowEqualSecurityRankAccess" }, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isExchangeCustomerRequired() {
/* 2870 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ExchangeSerialNumber", "CustomerRecordRequired" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final boolean isFeesLineDisplayed() {
/* 2883 */     return getHelper()
/* 2884 */       .getBoolean(new String[] { "Store", "SystemConfig", "Transaction", "DisplayFeesLine" });
/*      */   }
/*      */   
/*      */   public static boolean isGenerateWeightedSendSaleShippingFee() {
/* 2888 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "GenerateWeightedShippingFee" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isInitialCountSummarySkipped() {
/* 2893 */     return getHelper()
/* 2894 */       .getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "InitialCountSummarySkipped" });
/*      */   }
/*      */   
/*      */   public static boolean isLayawayApplyDealAtSetup() {
/* 2898 */     return getHelper()
/* 2899 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "ApplyDealAtSetup" });
/*      */   }
/*      */   
/*      */   public static boolean isMinimalSpecOrderMode() {
/* 2903 */     return getHelper()
/* 2904 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "MinimalOrderMode" });
/*      */   }
/*      */   
/*      */   public static boolean isOneSequenceForAllCustAccounts() {
/* 2908 */     return getHelper()
/* 2909 */       .getBoolean(new String[] { "Store", "SystemConfig", "OneSequenceForAllCustAccounts" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardAutomaticallyCalled() {
/* 2917 */     return getHelper()
/* 2918 */       .getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "AutomaticCall" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardEnabled() {
/* 2926 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "Enabled" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardKeyClickEnabled() {
/* 2934 */     return getHelper()
/* 2935 */       .getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "KeyClickEnabled" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardSliding() {
/* 2943 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "Sliding" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardSlidingBump() {
/* 2951 */     return getHelper()
/* 2952 */       .getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "SlidingEndBump" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardSwipeToClose() {
/* 2960 */     return getHelper()
/* 2961 */       .getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "SwipeDownToClose" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOnScreenKeyboardSwipeToSwitchLayout() {
/* 2969 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "OnScreenKeyboard", "SwipeSideToSwitchLayout" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPasswordExpirationEnabled() {
/* 2979 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "LoginSecurity", "PasswordExpiration", "Enabled" });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPinpadRequiredForDebit() {
/* 2985 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "CreditDebitTender", "PinpadRequiredForDebit" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isProcessPosLog() {
/* 2990 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TrainingMode", "TrainingModeProcessPosLog" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isQuickTransferNoTillCount() {
/* 2995 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "QuickTransferNoTillCount" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isRainCheckFeatureEnabled() {
/* 3000 */     return getHelper()
/* 3001 */       .getBoolean(new String[] { "Store", "SystemConfig", "RainCheck", "FeatureEnabled" });
/*      */   }
/*      */   
/*      */   public static boolean isRainCheckRedeemAnyStore() {
/* 3005 */     return getHelper()
/* 3006 */       .getBoolean(new String[] { "Store", "SystemConfig", "RainCheck", "RedeemAnyStore" });
/*      */   }
/*      */   
/*      */   public static boolean isRestrictEmployeeAccess() {
/* 3010 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TrainingMode", "TrainingModeRestrictEmployeeAccess" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isRestrictEnterExitPrinting() {
/* 3015 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TrainingMode", "TrainingModeRestrictEnterExitPrinting" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isRestrictReceiptPrinting() {
/* 3020 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TrainingMode", "TrainingModeRestrictReceiptPrinting" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isReturnCustomerRecordRequired() {
/* 3025 */     return getHelper()
/* 3026 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "CustomerRecordRequired" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isReturnCustomerRecordRequiredOnNegativeBalance() {
/* 3037 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "CustomerRecordRequiredWhenNegativeBalance" }, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isRollingCloseAutoOpenEnabled() {
/* 3042 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "RollingClose", "AutoOpenAfterClose" }, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isRollingCloseEnabled() {
/* 3047 */     return getRollingCloseType().enabled();
/*      */   }
/*      */   
/*      */   public static boolean isSendCloseBatchEnabled() {
/* 3051 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "CreditDebitTender", "CloseBatch", "Enabled" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSendSaleCreateShippingDocument() {
/* 3056 */     return getHelper()
/* 3057 */       .getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "CreateShippingDocument" });
/*      */   }
/*      */   
/*      */   public static boolean isSendSaleUseThisStoreAsFailOverTaxRate() {
/* 3061 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "UseThisStoreAsFailOverTaxRate" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSpecOrderApplyDealAtSetup() {
/* 3066 */     return getHelper()
/* 3067 */       .getBoolean(new String[] { "Store", "SystemConfig", "SpecialOrder", "ApplyDealAtSetup" });
/*      */   }
/*      */   
/*      */   public static boolean isStoreBankEndCountAtStoreCloseRequired() {
/* 3071 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "StoreBankEndCountAtStoreCloseRequired" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isStoreBankOpenPromptedOnStoreOpen() {
/* 3076 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "PromptToOpenStoreBankOnStoreOpen" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isTextAllCapsOnButtons() {
/* 3081 */     return getHelper()
/* 3082 */       .getBoolean(new String[] { "Store", "SystemConfig", "UserInterface", "AllCapsButtons" });
/*      */   }
/*      */   
/*      */   public static boolean isTextAllCapsOnListHeaders() {
/* 3086 */     return getHelper()
/* 3087 */       .getBoolean(new String[] { "Store", "SystemConfig", "UserInterface", "AllCapsListHeaders" });
/*      */   }
/*      */   
/*      */   public static boolean isTextAllCapsOnTabHeaders() {
/* 3091 */     return getHelper()
/* 3092 */       .getBoolean(new String[] { "Store", "SystemConfig", "UserInterface", "AllCapsTabHeaders" });
/*      */   }
/*      */   
/*      */   public static boolean isTrainingModeEnabled() {
/* 3096 */     return getHelper()
/* 3097 */       .getBoolean(new String[] { "Store", "SystemConfig", "TrainingMode", "TrainingModeEnabled" });
/*      */   }
/*      */   
/*      */   public static boolean isTrainingModeRtlLocCloseFromPrimaryWSOnly() {
/* 3101 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TrainingMode", "TrainingModeRtlLocCloseFromPrimaryWSOnly" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isUIFlipped() {
/* 3110 */     String orientation = getUIOrientation().toLowerCase();
/* 3111 */     switch (orientation) {
/*      */       case "left":
/* 3113 */         return false;
/*      */     } 
/* 3115 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean listOpenWS() {
/* 3120 */     return getHelper()
/* 3121 */       .getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "ListOpenWS" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean lookupReturnItemPriceHistory() {
/* 3130 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "PriceHistory", "LookupPriceHistory" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean lookupVerifiedReturnItemPriceHistory() {
/* 3139 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "PriceHistory", "LookupVerifiedPriceHistory" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static int maxTicketsPerLine() {
/* 3144 */     return getHelper()
/* 3145 */       .getInt(new String[] { "Store", "SystemConfig", "ShelfLabelsItemTags", "MaxQuantityPerLine" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal minYouSavedThresholdAmount() {
/* 3154 */     return getHelper().getBigDecimal(new String[] { "Store", "SystemConfig", "YouSavedMessage", "MinYouSavedMessageThresholdAmount" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean printCanceledTransactions() {
/* 3159 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "PrintCanceledTransactions" });
/*      */   }
/*      */   
/*      */   public static boolean printLayawayMerchandiseTicket() {
/* 3163 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "PrintLayawayMerchandiseTicket" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean printLayawayMerchandiseTicketPerItem() {
/* 3168 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "PrintLayawayMerchandiseTicketPerItem" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean printLayawayOnlyReceipt() {
/* 3173 */     return getHelper()
/* 3174 */       .getBoolean(new String[] { "Store", "SystemConfig", "Layaway", "PrintLayawayOnlyReceipt" });
/*      */   }
/*      */   
/*      */   public static boolean printPickupTotalOnTillCountReceipt() {
/* 3178 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "TillAccountability", "PrintPickupTotalOnTillCountReceipt" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean printSendSaleMerchandiseTicketPerItem() {
/* 3183 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "SendSale", "PrintSendSaleMerchandiseTicketPerItem" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean processLastChancePosLog() {
/* 3188 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "ProcessLastChancePosLog" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean processPayroll() {
/* 3193 */     return getHelper()
/* 3194 */       .getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "ProcessPayroll" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean promptApplyRestockingFeeMessage() {
/* 3204 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ItemReturn", "RestockingFee", "PromptApplyRestockingFeeMessage" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean promptBusinessDay() {
/* 3209 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "PromptBusinessDay" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean promptForCustomerOnLogin() {
/* 3221 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "PromptForCustomerOnLogin" });
/*      */   }
/*      */   
/*      */   public static boolean promptToInitiateClose() {
/* 3225 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "PromptToInitiateClose" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean promptWishToCloseQuestion() {
/* 3230 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "PromptWishToCloseQuestion" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean promptWishToOpenQuestion() {
/* 3235 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "PromptWishToOpenQuestion" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean receivingAllowForcedSku() {
/* 3245 */     return getHelper()
/* 3246 */       .getBoolean(new String[] { "Store", "SystemConfig", "Receiving", "AllowForcedSku" });
/*      */   }
/*      */   
/*      */   public static boolean receivingCartonListOnDocument() {
/* 3250 */     return getHelper()
/* 3251 */       .getBoolean(new String[] { "Store", "SystemConfig", "Receiving", "CartonListOnDocument" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int receivingDocumentAttentionDays() {
/* 3260 */     return getHelper()
/* 3261 */       .getInt(new String[] { "Store", "SystemConfig", "Receiving", "DocumentAttentionDays" });
/*      */   }
/*      */   
/*      */   public static boolean receivingIsBlind() {
/* 3265 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Receiving", "Blind" });
/*      */   }
/*      */   
/*      */   public static boolean requireWSClosed() {
/* 3269 */     return getHelper()
/* 3270 */       .getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "RequireWSClosed" });
/*      */   }
/*      */   
/*      */   public static boolean returnToCustomerSearchAfterSave() {
/* 3274 */     return getHelper()
/* 3275 */       .getBoolean(new String[] { "Store", "SystemConfig", "ReturnToCustomerSearchAfterSave" });
/*      */   }
/*      */   
/*      */   public static boolean rtlLocCycleFromPrimaryWSOnly() {
/* 3279 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "RtlLocCycleFromPrimaryWSOnly" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean runWSOpenOnRtlLocOpen() {
/* 3284 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "RunWSOpenOnRtlLocOpen" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean shippingAllowForcedSku() {
/* 3294 */     return getHelper()
/* 3295 */       .getBoolean(new String[] { "Store", "SystemConfig", "Shipping", "AllowForcedSku" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int shippingDocumentAttentionDays() {
/* 3304 */     return getHelper()
/* 3305 */       .getInt(new String[] { "Store", "SystemConfig", "Shipping", "DocumentAttentionDays" });
/*      */   }
/*      */   
/*      */   public static boolean showCustomerListIfOne() {
/* 3309 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ShowCustomerListIfOne" });
/*      */   }
/*      */   
/*      */   public static boolean showEmployeeListIfOne() {
/* 3313 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ShowEmployeeListIfOne" });
/*      */   }
/*      */   
/*      */   public static boolean showItemImagesXstoreMobile() {
/* 3317 */     return getHelper()
/* 3318 */       .getBoolean(new String[] { "Store", "SystemConfig", "ItemSale", "ShowItemImages" }, true);
/*      */   }
/*      */   
/*      */   public static boolean showListsIfOne() {
/* 3322 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "ShowListsIfOne" });
/*      */   }
/*      */   
/*      */   public static boolean showMicrButtonOnTransactionSearchForm() {
/* 3326 */     return getHelper()
/* 3327 */       .getBoolean(new String[] { "Store", "SystemConfig", "ShowMicrButtonOnTransactionSearchForm" });
/*      */   }
/*      */   
/*      */   public static boolean showPromptCancelOrderReasonCode() {
/* 3331 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Order", "PromptShowOrderCancelReasonCode" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean showPromptPickedOrderItemWarning() {
/* 3336 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Order", "PromptShowPickedOrderItemWarning" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean showPromptRejectOrderReasonCode() {
/* 3341 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "Order", "PromptShowOrderRejectReasonCode" });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean showYouSavedMessage() {
/* 3351 */     return getHelper().getBoolean(new String[] { "Store", "SystemConfig", "YouSavedMessage", "ShowYouSavedMessage" });
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean useSystemDate() {
/* 3356 */     return getHelper().getBoolean(new String[] { "Store", "RegisterConfig", "OpenClose", "UseSystemDate" }, false);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\ConfigurationMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */