/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderDenominationId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderDenominationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1700067577L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderDenominationDAO.class);
/*     */   
/*     */   private String _denominationId;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private BigDecimal _value;
/*     */   
/*     */   public String getDenominationId() {
/*  37 */     return this._denominationId;
/*     */   }
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/*  41 */     if (changed(argDenominationId, this._denominationId, "denominationId")) {
/*  42 */       this._denominationId = (argDenominationId != null && MANAGE_CASE) ? argDenominationId.toUpperCase() : argDenominationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  47 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  51 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  52 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  57 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  61 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  62 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 109 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 113 */     if (changed(argDescription, this._description, "description")) {
/* 114 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 119 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 123 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 124 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getValue() {
/* 129 */     return this._value;
/*     */   }
/*     */   
/*     */   public void setValue(BigDecimal argValue) {
/* 133 */     if (changed(argValue, this._value, "value")) {
/* 134 */       this._value = argValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getDenominationId() != null) {
/* 144 */       buf.append("denominationId").append("=").append(getDenominationId()).append(" ");
/*     */     }
/* 146 */     if (getOrganizationId() != null) {
/* 147 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 149 */     if (getTenderId() != null) {
/* 150 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 152 */     if (getCreateDate() != null) {
/* 153 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 155 */     if (getCreateUserId() != null) {
/* 156 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 158 */     if (getUpdateDate() != null) {
/* 159 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 161 */     if (getUpdateUserId() != null) {
/* 162 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 164 */     if (getDescription() != null) {
/* 165 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 167 */     if (getSortOrder() != null) {
/* 168 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 170 */     if (getValue() != null) {
/* 171 */       buf.append("value").append("=").append(getValue()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     TenderDenominationId id = new TenderDenominationId();
/* 179 */     id.setDenominationId(getDenominationId());
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     id.setTenderId(getTenderId());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setDenominationId(((TenderDenominationId)argObjectId).getDenominationId());
/* 187 */     setOrganizationId(((TenderDenominationId)argObjectId).getOrganizationId());
/* 188 */     setTenderId(((TenderDenominationId)argObjectId).getTenderId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 196 */     StringBuilder buf = new StringBuilder(500);
/* 197 */     buf.append("<").append("dao").append(" name=\"TenderDenomination\" cmd=\"" + getObjectStateString() + "\">");
/* 198 */     getFieldsAsXml(buf);
/* 199 */     buf.append("</").append("dao").append(">");
/*     */     
/* 201 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 205 */     Map<String, String> values = super.getValues();
/* 206 */     if (this._denominationId != null) values.put("DenominationId", DaoUtils.getXmlSafeFieldValue(12, this._denominationId)); 
/* 207 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 208 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 209 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 210 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 211 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 212 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 213 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 214 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 215 */     if (this._value != null) values.put("Value", DaoUtils.getXmlSafeFieldValue(3, this._value)); 
/* 216 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 221 */     super.setValues(argValues);
/* 222 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 224 */       String fieldName = field.getKey();
/* 225 */       String fieldValue = field.getValue();
/* 226 */       switch (fieldName) {
/*     */         
/*     */         case "DenominationId":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 231 */             setDenominationId((String)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setDenominationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 240 */             setOrganizationId((Long)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 249 */             setTenderId((String)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 258 */             setCreateDate((Date)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setCreateUserId((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 276 */             setUpdateDate((Date)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setUpdateUserId((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setDescription((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 303 */             setSortOrder((Integer)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Value":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 312 */             setValue((BigDecimal)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderDenominationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */