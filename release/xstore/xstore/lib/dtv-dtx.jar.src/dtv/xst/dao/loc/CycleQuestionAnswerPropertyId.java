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
/*     */ public class CycleQuestionAnswerPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -258671201L;
/*     */   private String _answerId;
/*     */   private DtvDate _answerTimestamp;
/*     */   private String _questionId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CycleQuestionAnswerPropertyId() {}
/*     */   
/*     */   public CycleQuestionAnswerPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnswerId() {
/*  34 */     return this._answerId;
/*     */   }
/*     */   
/*     */   public void setAnswerId(String argAnswerId) {
/*  38 */     this._answerId = (argAnswerId != null && MANAGE_CASE) ? argAnswerId.toUpperCase() : argAnswerId;
/*     */   }
/*     */   
/*     */   public Date getAnswerTimestamp() {
/*  42 */     return (Date)this._answerTimestamp;
/*     */   }
/*     */   
/*     */   public void setAnswerTimestamp(Date argAnswerTimestamp) {
/*  46 */     this._answerTimestamp = (argAnswerTimestamp == null || argAnswerTimestamp instanceof DtvDate) ? (DtvDate)argAnswerTimestamp : new DtvDate(argAnswerTimestamp);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQuestionId() {
/*  51 */     return this._questionId;
/*     */   }
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/*  55 */     this._questionId = (argQuestionId != null && MANAGE_CASE) ? argQuestionId.toUpperCase() : argQuestionId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  59 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  63 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  67 */     String str = argObjectIdValue;
/*  68 */     if (StringUtils.isEmpty(str)) {
/*  69 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  72 */       String[] tokens = str.split("::");
/*  73 */       str = tokens[0];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setAnswerId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setAnswerId(str);
/*     */       } 
/*  81 */       str = tokens[1];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setAnswerTimestamp((Date)null);
/*     */       } else {
/*     */         
/*  87 */         setAnswerTimestamp((Date)new DtvDate());
/*  88 */         this._answerTimestamp.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  90 */       str = tokens[2];
/*     */       
/*  92 */       setOrganizationId(Long.valueOf(str));
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       if ("null".equals(str)) {
/*  96 */         setQuestionId((String)null);
/*     */       } else {
/*     */         
/*  99 */         setQuestionId(str);
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 107 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 110 */     } catch (Exception ee) {
/* 111 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 117 */     if (this == ob) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (!(ob instanceof CycleQuestionAnswerPropertyId)) {
/* 121 */       return false;
/*     */     }
/* 123 */     CycleQuestionAnswerPropertyId other = (CycleQuestionAnswerPropertyId)ob;
/* 124 */     return (((this._answerId == null && other._answerId == null) || (this._answerId != null && this._answerId
/*     */ 
/*     */       
/* 127 */       .equals(other._answerId))) && ((this._answerTimestamp == null && other._answerTimestamp == null) || (this._answerTimestamp != null && this._answerTimestamp
/*     */ 
/*     */       
/* 130 */       .equals(other._answerTimestamp))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 133 */       .equals(other._organizationId))) && ((this._questionId == null && other._questionId == null) || (this._questionId != null && this._questionId
/*     */ 
/*     */       
/* 136 */       .equals(other._questionId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 139 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return ((this._answerId == null) ? 0 : this._answerId
/* 146 */       .hashCode()) + ((this._answerTimestamp == null) ? 0 : this._answerTimestamp
/* 147 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 148 */       .hashCode()) + ((this._questionId == null) ? 0 : this._questionId
/* 149 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 150 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 155 */     return "CycleQuestionAnswerProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 162 */     return buff.append(this._answerId)
/*     */       
/* 164 */       .append("::").append((this._answerTimestamp == null) ? "null" : String.valueOf(this._answerTimestamp.getTimeSerializable()))
/* 165 */       .append("::").append(String.valueOf(this._organizationId))
/* 166 */       .append("::").append(this._questionId)
/* 167 */       .append("::").append(this._propertyCode)
/* 168 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 172 */     if (this._answerId == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (this._answerTimestamp == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._questionId == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._propertyCode == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\CycleQuestionAnswerPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */