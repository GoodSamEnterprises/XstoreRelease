/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.util.NumberUtils;
/*     */ import java.math.BigDecimal;
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
/*     */ public class DailyTimecardSummaryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private String workCode_;
/*  24 */   private BigDecimal duration_ = NumberUtils.ZERO;
/*  25 */   private BigDecimal hours_ = NumberUtils.ZERO;
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
/*     */   public BigDecimal getDuration() {
/*  40 */     return this.duration_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getHours() {
/*  49 */     return this.hours_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkCode() {
/*  58 */     return this.workCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDuration(BigDecimal argDuration) {
/*  67 */     this.duration_ = argDuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDuration(Long argDuration) {
/*  76 */     this.duration_ = new BigDecimal(argDuration.longValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHours(BigDecimal argHours) {
/*  85 */     this.hours_ = argHours;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCode(String argCode) {
/*  94 */     this.workCode_ = argCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 100 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\DailyTimecardSummaryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */