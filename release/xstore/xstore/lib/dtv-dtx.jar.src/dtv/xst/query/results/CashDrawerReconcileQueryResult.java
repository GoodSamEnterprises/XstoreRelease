/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.i18n.FormatterFactory;
/*     */ import dtv.i18n.IFormatter;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.tsn.SessionId;
/*     */ import java.util.Date;
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
/*     */ public class CashDrawerReconcileQueryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private long _organizationId;
/*     */   private long _sessionId;
/*     */   private String _cashDrawerId;
/*     */   private String _cashDrawerDescription;
/*     */   private Date _beginDatetimestamp;
/*     */   private Date _endDatetimestamp;
/*     */   
/*     */   public Date getBeginDatetimestamp() {
/*  36 */     return this._beginDatetimestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCashDrawerDescription() {
/*  45 */     return this._cashDrawerDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCashDrawerId() {
/*  54 */     return this._cashDrawerId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDatetimestamp() {
/*  63 */     return this._endDatetimestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  72 */     return this._organizationId;
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
/*     */   
/*     */   public String getSessionData() {
/*  86 */     StringBuilder sessionData = new StringBuilder(40);
/*     */     
/*  88 */     String id = String.valueOf(getSessionId());
/*     */     
/*  90 */     if (id.length() >= 4) {
/*  91 */       sessionData.append(StringUtils.right(id, 4));
/*     */     } else {
/*     */       
/*  94 */       sessionData.append(id);
/*     */     } 
/*     */ 
/*     */     
/*  98 */     IFormatter dateTimeShortFormatter = FormatterFactory.getInstance().getDateTimeShortFormatter();
/*  99 */     sessionData.append(" ");
/* 100 */     Date beginDateTime = getBeginDatetimestamp();
/* 101 */     sessionData.append(dateTimeShortFormatter.format(beginDateTime, OutputContextType.VIEW));
/* 102 */     sessionData.append("-");
/* 103 */     Date endDateTime = getEndDatetimestamp();
/*     */     
/* 105 */     if (endDateTime != null) {
/* 106 */       if (DateUtils.dateDiff(CalendarField.DAY, beginDateTime, endDateTime) == 0L) {
/*     */ 
/*     */ 
/*     */         
/* 110 */         String[] formattedEndDate = dateTimeShortFormatter.format(endDateTime, OutputContextType.VIEW).split("\\s");
/* 111 */         int length = formattedEndDate.length;
/* 112 */         sessionData.append(formattedEndDate[length - 2]);
/* 113 */         sessionData.append(" ").append(formattedEndDate[length - 1]);
/*     */       } else {
/*     */         
/* 116 */         sessionData.append(dateTimeShortFormatter.format(endDateTime, OutputContextType.VIEW));
/*     */       } 
/*     */     }
/* 119 */     return sessionData.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSessionId() {
/* 129 */     return this._sessionId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/* 138 */     this._beginDatetimestamp = argBeginDatetimestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCashDrawerDescription(String argCashDrawerDescription) {
/* 147 */     this._cashDrawerDescription = argCashDrawerDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/* 156 */     this._cashDrawerId = argCashDrawerId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/* 165 */     this._endDatetimestamp = argEndDatetimestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 174 */     this._organizationId = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSessionId(long argSessionId) {
/* 183 */     this._sessionId = argSessionId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 189 */     SessionId id = new SessionId();
/* 190 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 191 */     id.setSessionId(Long.valueOf(getSessionId()));
/* 192 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CashDrawerReconcileQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */