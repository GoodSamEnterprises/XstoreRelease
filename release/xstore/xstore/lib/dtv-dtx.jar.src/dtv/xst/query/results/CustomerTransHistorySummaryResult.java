/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerTransHistorySummaryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String CUST_LIFETIME_SUMMARY_PROP = "CUST_LIFETIME_SUMMARY_PROP";
/*  30 */   private int _totalItemsReturnedCount = -1;
/*  31 */   private int _totalItemsSoldCount = -1;
/*  32 */   private int _totalTransactionCount = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal _totalReturnsAmt;
/*     */ 
/*     */   
/*     */   private BigDecimal _totalSalesAmt;
/*     */ 
/*     */   
/*     */   private Map<String, BigDecimal>[] _chartData;
/*     */ 
/*     */   
/*     */   private Map<Date, BigDecimal>[] _chartDataTime;
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomerTransHistorySummaryResult() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomerTransHistorySummaryResult(int argTotalItemsReturnedCount, int argTotalItemsSoldCount, int argTotalTransactionCount, BigDecimal argTotalReturnsAmt, BigDecimal argTotalSalesAmt) {
/*  54 */     this._totalItemsReturnedCount = argTotalItemsReturnedCount;
/*  55 */     this._totalItemsSoldCount = argTotalItemsSoldCount;
/*  56 */     this._totalTransactionCount = argTotalTransactionCount;
/*  57 */     this._totalReturnsAmt = argTotalReturnsAmt;
/*  58 */     this._totalSalesAmt = argTotalSalesAmt;
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
/*     */   public CustomerTransHistorySummaryResult(String argTotalItemsReturnedCount, String argTotalItemsSoldCount, String argTotalTransactionCount, String argTotalReturnsAmt, String argTotalSalesAmt) {
/*  71 */     this(Integer.parseInt(argTotalItemsReturnedCount), Integer.parseInt(argTotalItemsSoldCount), 
/*  72 */         Integer.parseInt(argTotalTransactionCount), new BigDecimal(argTotalReturnsAmt), new BigDecimal(argTotalSalesAmt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, BigDecimal>[] getChartData() {
/*  82 */     return this._chartData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Date, BigDecimal>[] getChartDataTime() {
/*  91 */     return this._chartDataTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNetItemsSoldCount() {
/* 101 */     return this._totalItemsSoldCount - this._totalItemsReturnedCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getNetSalesAmt() {
/* 111 */     return ((BigDecimal)ObjectUtils.coalesce((Object[])new BigDecimal[] { this._totalSalesAmt, BigDecimal.ZERO })).add((BigDecimal)ObjectUtils.coalesce((Object[])new BigDecimal[] { this._totalReturnsAmt, BigDecimal.ZERO }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalItemsReturnedCount() {
/* 120 */     return this._totalItemsReturnedCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalItemsSoldCount() {
/* 129 */     return this._totalItemsSoldCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotalReturnsAmt() {
/* 138 */     return this._totalReturnsAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotalSalesAmt() {
/* 147 */     return this._totalSalesAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalTransactionCount() {
/* 156 */     return this._totalTransactionCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRequiredData() {
/* 166 */     boolean result = false;
/*     */     
/* 168 */     if (this._totalReturnsAmt != null && this._totalSalesAmt != null) {
/* 169 */       boolean empty = (BigDecimal.ZERO.compareTo(this._totalReturnsAmt) == 0 && BigDecimal.ZERO.compareTo(this._totalSalesAmt) == 0 && this._totalItemsReturnedCount == 0 && this._totalItemsSoldCount == 0);
/*     */ 
/*     */       
/* 172 */       boolean uninitialized = (this._totalItemsReturnedCount == -1 || this._totalItemsSoldCount == -1);
/*     */       
/* 174 */       result = (!empty && !uninitialized);
/*     */     } 
/*     */     
/* 177 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChartData(Map<String, BigDecimal>[] argChartData) {
/* 186 */     this._chartData = argChartData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChartDataTime(Map<Date, BigDecimal>[] argChartData) {
/* 195 */     this._chartDataTime = argChartData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalItemsReturnedCount(int argTotalItemsReturnedCount) {
/* 204 */     this._totalItemsReturnedCount = argTotalItemsReturnedCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalItemsSoldCount(int argTotalItemsSoldCount) {
/* 213 */     this._totalItemsSoldCount = argTotalItemsSoldCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalReturnsAmt(BigDecimal argTotalReturnsAmt) {
/* 222 */     this._totalReturnsAmt = argTotalReturnsAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalSalesAmt(BigDecimal argTotalSalesAmt) {
/* 231 */     this._totalSalesAmt = argTotalSalesAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalTransactionCount(int argTotalTransactionCount) {
/* 240 */     this._totalTransactionCount = argTotalTransactionCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 246 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CustomerTransHistorySummaryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */