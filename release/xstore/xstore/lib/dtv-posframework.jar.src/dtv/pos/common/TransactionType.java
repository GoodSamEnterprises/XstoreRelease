/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.pos.iframework.ITransactionType;
/*     */ import dtv.pos.iframework.type.AbstractCodeEnum;
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransaction;
/*     */ import dtv.xst.dao.inv.IInventoryTransaction;
/*     */ import dtv.xst.dao.inv.IMovementPendingTransaction;
/*     */ import dtv.xst.dao.thr.ITimeclockTransaction;
/*     */ import dtv.xst.dao.trl.IEscrowTransaction;
/*     */ import dtv.xst.dao.trl.IRetailTransaction;
/*     */ import dtv.xst.dao.trn.IGiftRegistryTransaction;
/*     */ import dtv.xst.dao.trn.INoSaleTransaction;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import dtv.xst.dao.trn.IPostVoidTransaction;
/*     */ import dtv.xst.dao.trn.IRainCheckTransaction;
/*     */ import dtv.xst.dao.tsn.IExchangeRateTransaction;
/*     */ import dtv.xst.dao.tsn.ISessionControlTransaction;
/*     */ import dtv.xst.dao.tsn.ITenderControlTransaction;
/*     */ import dtv.xst.dao.tsn.ITillControlTransaction;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class TransactionType<T extends IPosTransaction>
/*     */   extends AbstractCodeEnum<TransactionType<T>>
/*     */   implements ITransactionType<T>
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(TransactionType.class);
/*     */ 
/*     */   
/*  33 */   private static final Map<String, TransactionType<? extends IPosTransaction>> values_ = new HashMap<>();
/*     */   
/*     */   private static TransactionType<IPosTransaction>[] sortedInstances_;
/*  36 */   private static final Object SORT_LOCK = new Object();
/*     */ 
/*     */   
/*  39 */   public static final TransactionType<ITimeclockTransaction> TIMECLOCK = new TransactionType("TIMECLOCK", (Class)ITimeclockTransaction.class);
/*     */   
/*  41 */   public static final TransactionType<INoSaleTransaction> NO_SALE = new TransactionType("NO_SALE", (Class)INoSaleTransaction.class);
/*     */   
/*  43 */   public static final TransactionType<IRetailTransaction> RETAIL_SALE = new TransactionType("RETAIL_SALE", (Class)IRetailTransaction.class);
/*     */   
/*  45 */   public static final TransactionType<ISessionControlTransaction> SESSION_CONTROL = new TransactionType("SESSION_CONTROL", (Class)ISessionControlTransaction.class);
/*     */   
/*  47 */   public static final TransactionType<ITenderControlTransaction> TENDER_CONTROL = new TransactionType("TENDER_CONTROL", (Class)ITenderControlTransaction.class);
/*     */   
/*  49 */   public static final TransactionType<ITenderControlTransaction> TENDER_EXCHANGE = new TransactionType("TENDER_EXCHANGE", (Class)ITenderControlTransaction.class);
/*     */   
/*  51 */   public static final TransactionType<IPosTransaction> SYSTEM_OPEN = new TransactionType("SYSTEM_OPEN", (Class)IPosTransaction.class);
/*     */   
/*  53 */   public static final TransactionType<IPosTransaction> SYSTEM_CLOSE = new TransactionType("SYSTEM_CLOSE", (Class)IPosTransaction.class);
/*     */   
/*  55 */   public static final TransactionType<IPosTransaction> CASHDRAWER_OPEN = new TransactionType("CASHDRAWER_OPEN", (Class)IPosTransaction.class);
/*     */   
/*  57 */   public static final TransactionType<IPosTransaction> CASHDRAWER_CLOSE = new TransactionType("CASHDRAWER_CLOSE", (Class)IPosTransaction.class);
/*     */   
/*  59 */   public static final TransactionType<IPosTransaction> WORKSTATION_OPEN = new TransactionType("WORKSTATION_OPEN", (Class)IPosTransaction.class);
/*     */   
/*  61 */   public static final TransactionType<IPosTransaction> WORKSTATION_CLOSE = new TransactionType("WORKSTATION_CLOSE", (Class)IPosTransaction.class);
/*     */   
/*  63 */   public static final TransactionType<IPosTransaction> WORKSTATION_START_REMOTE_CLOSE = new TransactionType("WORKSTATION_START_REM_CLOSE", (Class)IPosTransaction.class);
/*     */   
/*  65 */   public static final TransactionType<IPosTransaction> WORKSTATION_COMPLETE_REMOTE_CLOSE = new TransactionType("WORKSTATION_COMPLETE_REM_CLOSE", (Class)IPosTransaction.class);
/*     */   
/*  67 */   public static final TransactionType<IInventoryTransaction> INVENTORY_CONTROL = new TransactionType("INVENTORY_CONTROL", (Class)IInventoryTransaction.class);
/*     */   
/*  69 */   public static final TransactionType<IPostVoidTransaction> POST_VOID = new TransactionType("POST_VOID", (Class)IPostVoidTransaction.class);
/*     */   
/*  71 */   public static final TransactionType<IPosTransaction> TRAINING_MODE_ENTRY = new TransactionType("TRAINING_MODE_ENTRY", (Class)IPosTransaction.class);
/*     */   
/*  73 */   public static final TransactionType<IPosTransaction> TRAINING_MODE_EXIT = new TransactionType("TRAINING_MODE_EXIT", (Class)IPosTransaction.class);
/*     */   
/*  75 */   public static final TransactionType<IExchangeRateTransaction> EXCHANGE_RATE = new TransactionType("EXCHANGE_RATE", (Class)IExchangeRateTransaction.class);
/*     */   
/*  77 */   public static final TransactionType<IPosTransaction> BALANCE_INQUIRY = new TransactionType("BALANCE_INQUIRY", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/*  80 */   public static final TransactionType<IRetailTransaction> CREDIT_APPLICATION = new TransactionType("CREDIT_APPLICATION", (Class)IRetailTransaction.class);
/*     */   
/*  82 */   public static final TransactionType<IPosTransaction> ACCOUNT_LOOKUP = new TransactionType("ACCOUNT_LOOKUP", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/*  85 */   public static final TransactionType<ITillControlTransaction> TILL_CONTROL = new TransactionType("TILL_CONTROL", (Class)ITillControlTransaction.class);
/*     */   
/*  87 */   public static final TransactionType<IInventorySummaryCountTransaction> INVENTORY_SUMMARY_COUNT = new TransactionType("INVENTORY_SUMMARY_COUNT", (Class)IInventorySummaryCountTransaction.class);
/*     */ 
/*     */   
/*  90 */   public static final TransactionType<IMovementPendingTransaction> MOVEMENT_PENDING = new TransactionType("MOVEMENT_PENDING", (Class)IMovementPendingTransaction.class);
/*     */ 
/*     */   
/*  93 */   public static final TransactionType<IEscrowTransaction> ESCROW = new TransactionType("ESCROW", (Class)IEscrowTransaction.class);
/*     */ 
/*     */   
/*  96 */   public static final TransactionType<IPosTransaction> BATCH_CLOSE = new TransactionType("BATCH_CLOSE", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/*  99 */   public static final TransactionType<IGiftRegistryTransaction> GIFT_REGISTRY = new TransactionType("GIFT_REGISTRY", (Class)IGiftRegistryTransaction.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public static final TransactionType<IPosTransaction> ORDER = new TransactionType("ORDER", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/* 110 */   public static final TransactionType<IRainCheckTransaction> RAIN_CHECK = new TransactionType("RAIN_CHECK", (Class)IRainCheckTransaction.class);
/*     */ 
/*     */   
/* 113 */   public static final TransactionType<IPosTransaction> WORKSTATION_BEGIN_DAY = new TransactionType("WORKSTATION_BEGIN_DAY", (Class)IPosTransaction.class);
/*     */   
/* 115 */   public static final TransactionType<IPosTransaction> WORKSTATION_END_DAY = new TransactionType("WORKSTATION_END_DAY", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/* 118 */   public static final TransactionType<IPosTransaction> DEFERRED_INVOICE = new TransactionType("DEFERRED_INVOICE", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/* 121 */   public static final TransactionType<IRetailTransaction> RETAIL_ENGAGEMENT = new TransactionType("RETAIL_ENGAGEMENT", (Class)IRetailTransaction.class);
/*     */ 
/*     */   
/* 124 */   public static final TransactionType<IPosTransaction> WORKSTATION_X_REPORT = new TransactionType("WORKSTATION_X_REPORT", (Class)IPosTransaction.class);
/*     */ 
/*     */   
/* 127 */   public static final TransactionType<IRetailTransaction> SERIAL_EXCHANGE = new TransactionType("SERIAL_EXCHANGE", (Class)IRetailTransaction.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Class<T> transactionInterface_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TransactionType<? extends IPosTransaction> forName(String argName) {
/* 139 */     if (argName == null) {
/* 140 */       return null;
/*     */     }
/* 142 */     TransactionType<? extends IPosTransaction> found = values_.get(argName.trim().toUpperCase());
/* 143 */     if (found == null) {
/* 144 */       logger_.warn("There is no instance of [" + TransactionType.class
/* 145 */           .getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/* 148 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TransactionType<IPosTransaction>[] getInstances() {
/* 158 */     synchronized (SORT_LOCK) {
/* 159 */       if (sortedInstances_ == null) {
/* 160 */         sortedInstances_ = (TransactionType<IPosTransaction>[])values_.values().toArray((Object[])new TransactionType[0]);
/* 161 */         Arrays.sort((Object[])sortedInstances_);
/*     */       } 
/*     */     } 
/* 164 */     return sortedInstances_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected TransactionType(String argName, Class<T> argTransactionInterface) {
/* 177 */     super(TransactionType.class, argName);
/* 178 */     this.transactionInterface_ = argTransactionInterface;
/* 179 */     values_.put(getCode(), this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<T> getInterfaceClass() {
/* 189 */     return this.transactionInterface_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(IPosTransaction argTransaction) {
/* 200 */     return (argTransaction != null && matches(argTransaction.getTransactionTypeCode()));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\TransactionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */