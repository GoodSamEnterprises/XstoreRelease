/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.FiscalYearId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FiscalYearDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1727562555L;
/*  23 */   private static final Logger _logger = Logger.getLogger(FiscalYearDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Integer _fiscalYear;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _startDate;
/*     */   private DtvDate _endDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  35 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  39 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  40 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getFiscalYear() {
/*  45 */     return this._fiscalYear;
/*     */   }
/*     */   
/*     */   public void setFiscalYear(Integer argFiscalYear) {
/*  49 */     if (changed(argFiscalYear, this._fiscalYear, "fiscalYear")) {
/*  50 */       this._fiscalYear = argFiscalYear;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  55 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  59 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  60 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  66 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  70 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  71 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  76 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  80 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  81 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  87 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  91 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  92 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartDate() {
/*  97 */     return (Date)this._startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(Date argStartDate) {
/* 101 */     if (changed(argStartDate, this._startDate, "startDate")) {
/* 102 */       this._startDate = (argStartDate == null || argStartDate instanceof DtvDate) ? (DtvDate)argStartDate : new DtvDate(argStartDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 108 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 112 */     if (changed(argEndDate, this._endDate, "endDate")) {
/* 113 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder buf = new StringBuilder(512);
/* 122 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 123 */     if (getOrganizationId() != null) {
/* 124 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 126 */     if (getFiscalYear() != null) {
/* 127 */       buf.append("fiscalYear").append("=").append(getFiscalYear()).append(" ");
/*     */     }
/* 129 */     if (getCreateDate() != null) {
/* 130 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 132 */     if (getCreateUserId() != null) {
/* 133 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 135 */     if (getUpdateDate() != null) {
/* 136 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 138 */     if (getUpdateUserId() != null) {
/* 139 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 141 */     if (getStartDate() != null) {
/* 142 */       buf.append("startDate").append("=").append(getStartDate()).append(" ");
/*     */     }
/* 144 */     if (getEndDate() != null) {
/* 145 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/*     */     
/* 148 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 152 */     FiscalYearId id = new FiscalYearId();
/* 153 */     id.setOrganizationId(getOrganizationId());
/* 154 */     id.setFiscalYear(getFiscalYear());
/* 155 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 159 */     setOrganizationId(((FiscalYearId)argObjectId).getOrganizationId());
/* 160 */     setFiscalYear(((FiscalYearId)argObjectId).getFiscalYear());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 168 */     StringBuilder buf = new StringBuilder(400);
/* 169 */     buf.append("<").append("dao").append(" name=\"FiscalYear\" cmd=\"" + getObjectStateString() + "\">");
/* 170 */     getFieldsAsXml(buf);
/* 171 */     buf.append("</").append("dao").append(">");
/*     */     
/* 173 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 177 */     Map<String, String> values = super.getValues();
/* 178 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 179 */     if (this._fiscalYear != null) values.put("FiscalYear", DaoUtils.getXmlSafeFieldValue(4, this._fiscalYear)); 
/* 180 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 181 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 182 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 183 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 184 */     if (this._startDate != null) values.put("StartDate", DaoUtils.getXmlSafeFieldValue(91, this._startDate)); 
/* 185 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 186 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 191 */     super.setValues(argValues);
/* 192 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 194 */       String fieldName = field.getKey();
/* 195 */       String fieldValue = field.getValue();
/* 196 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 200 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 201 */             setOrganizationId((Long)value);
/* 202 */           } catch (Exception ee) {
/* 203 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FiscalYear":
/*     */           try {
/* 209 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 210 */             setFiscalYear((Integer)value);
/* 211 */           } catch (Exception ee) {
/* 212 */             throw new DtxException("An exception occurred while calling setFiscalYear() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 219 */             setCreateDate((Date)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 228 */             setCreateUserId((String)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 237 */             setUpdateDate((Date)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 246 */             setUpdateUserId((String)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartDate":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 255 */             setStartDate((Date)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setStartDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 264 */             setEndDate((Date)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\FiscalYearDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */