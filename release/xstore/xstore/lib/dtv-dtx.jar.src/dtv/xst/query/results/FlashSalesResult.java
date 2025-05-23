/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FlashSalesResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private String lineEnum_;
/*     */   private BigDecimal lineCount_;
/*     */   private BigDecimal lineAmount_;
/*     */   private BigDecimal foreignAmount_;
/*     */   private String deptId_;
/*     */   private Integer hour_;
/*     */   private Integer transCount_;
/*     */   private BigDecimal qty_;
/*     */   private BigDecimal netSales_;
/*     */   private Long wkstnId_;
/*     */   
/*     */   public String getDeptId() {
/*  39 */     return this.deptId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getForeignAmount() {
/*  48 */     return this.foreignAmount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getHour() {
/*  57 */     return this.hour_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLineAmount() {
/*  66 */     return this.lineAmount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLineCount() {
/*  75 */     return this.lineCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineEnum() {
/*  84 */     return this.lineEnum_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getNetSales() {
/*  93 */     return this.netSales_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQty() {
/* 102 */     return this.qty_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getTransCount() {
/* 111 */     return this.transCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getWkstnId() {
/* 120 */     return this.wkstnId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDeptId(String value) {
/* 129 */     this.deptId_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForeignAmount(BigDecimal value) {
/* 138 */     this.foreignAmount_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHour(Integer value) {
/* 147 */     this.hour_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineAmount(BigDecimal value) {
/* 156 */     this.lineAmount_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineCount(BigDecimal value) {
/* 165 */     this.lineCount_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineEnum(String value) {
/* 174 */     this.lineEnum_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNetSales(BigDecimal value) {
/* 183 */     this.netSales_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQty(BigDecimal value) {
/* 192 */     this.qty_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransCount(Integer value) {
/* 201 */     this.transCount_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWkstnId(Long value) {
/* 210 */     this.wkstnId_ = value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 216 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\FlashSalesResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */