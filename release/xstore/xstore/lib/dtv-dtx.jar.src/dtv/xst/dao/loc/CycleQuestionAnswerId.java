/*     */ package dtv.xst.dao.loc;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CycleQuestionAnswerId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1404041814L;
/*     */   private String _answerId;
/*     */   private DtvDate _answerTimestamp;
/*     */   private String _questionId;
/*     */   
/*     */   public CycleQuestionAnswerId() {}
/*     */   
/*     */   public CycleQuestionAnswerId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnswerId() {
/*  33 */     return this._answerId;
/*     */   }
/*     */   
/*     */   public void setAnswerId(String argAnswerId) {
/*  37 */     this._answerId = (argAnswerId != null && MANAGE_CASE) ? argAnswerId.toUpperCase() : argAnswerId;
/*     */   }
/*     */   
/*     */   public Date getAnswerTimestamp() {
/*  41 */     return (Date)this._answerTimestamp;
/*     */   }
/*     */   
/*     */   public void setAnswerTimestamp(Date argAnswerTimestamp) {
/*  45 */     this._answerTimestamp = (argAnswerTimestamp == null || argAnswerTimestamp instanceof DtvDate) ? (DtvDate)argAnswerTimestamp : new DtvDate(argAnswerTimestamp);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQuestionId() {
/*  50 */     return this._questionId;
/*     */   }
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/*  54 */     this._questionId = (argQuestionId != null && MANAGE_CASE) ? argQuestionId.toUpperCase() : argQuestionId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  58 */     String str = argObjectIdValue;
/*  59 */     if (StringUtils.isEmpty(str)) {
/*  60 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  63 */       String[] tokens = str.split("::");
/*  64 */       str = tokens[0];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setAnswerId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setAnswerId(str);
/*     */       } 
/*  72 */       str = tokens[1];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setAnswerTimestamp((Date)null);
/*     */       } else {
/*     */         
/*  78 */         setAnswerTimestamp((Date)new DtvDate());
/*  79 */         this._answerTimestamp.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       setOrganizationId(Long.valueOf(str));
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setQuestionId((String)null);
/*     */       } else {
/*     */         
/*  90 */         setQuestionId(str);
/*     */       }
/*     */     
/*  93 */     } catch (Exception ee) {
/*  94 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 100 */     if (this == ob) {
/* 101 */       return true;
/*     */     }
/* 103 */     if (!(ob instanceof CycleQuestionAnswerId)) {
/* 104 */       return false;
/*     */     }
/* 106 */     CycleQuestionAnswerId other = (CycleQuestionAnswerId)ob;
/* 107 */     return (((this._answerId == null && other._answerId == null) || (this._answerId != null && this._answerId
/*     */ 
/*     */       
/* 110 */       .equals(other._answerId))) && ((this._answerTimestamp == null && other._answerTimestamp == null) || (this._answerTimestamp != null && this._answerTimestamp
/*     */ 
/*     */       
/* 113 */       .equals(other._answerTimestamp))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 116 */       .equals(other._organizationId))) && ((this._questionId == null && other._questionId == null) || (this._questionId != null && this._questionId
/*     */ 
/*     */       
/* 119 */       .equals(other._questionId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return ((this._answerId == null) ? 0 : this._answerId
/* 126 */       .hashCode()) + ((this._answerTimestamp == null) ? 0 : this._answerTimestamp
/* 127 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 128 */       .hashCode()) + ((this._questionId == null) ? 0 : this._questionId
/* 129 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 134 */     return "CycleQuestionAnswer";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 141 */     return buff.append(this._answerId)
/*     */       
/* 143 */       .append("::").append((this._answerTimestamp == null) ? "null" : String.valueOf(this._answerTimestamp.getTimeSerializable()))
/* 144 */       .append("::").append(String.valueOf(this._organizationId))
/* 145 */       .append("::").append(this._questionId)
/* 146 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 150 */     if (this._answerId == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (this._answerTimestamp == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._questionId == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\CycleQuestionAnswerId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */