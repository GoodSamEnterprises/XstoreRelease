/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollCategoryId;
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
/*     */ public class PayrollCategoryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 75858211L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PayrollCategoryDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _payrollCategory;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*  33 */   private Boolean _includeInOverTime = Boolean.FALSE;
/*     */   private String _payCode;
/*  35 */   private Boolean _workingCategory = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPayrollCategory() {
/*  48 */     return this._payrollCategory;
/*     */   }
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/*  52 */     if (changed(argPayrollCategory, this._payrollCategory, "payrollCategory")) {
/*  53 */       this._payrollCategory = (argPayrollCategory != null && MANAGE_CASE) ? argPayrollCategory.toUpperCase() : argPayrollCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  58 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  62 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  63 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  69 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  73 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  74 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  79 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  83 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  84 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  90 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  94 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  95 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 100 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 104 */     if (changed(argDescription, this._description, "description")) {
/* 105 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 110 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 114 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 115 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getIncludeInOverTime() {
/* 120 */     return this._includeInOverTime;
/*     */   }
/*     */   
/*     */   public void setIncludeInOverTime(Boolean argIncludeInOverTime) {
/* 124 */     if (changed(argIncludeInOverTime, this._includeInOverTime, "includeInOverTime")) {
/* 125 */       this._includeInOverTime = argIncludeInOverTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPayCode() {
/* 130 */     return this._payCode;
/*     */   }
/*     */   
/*     */   public void setPayCode(String argPayCode) {
/* 134 */     if (changed(argPayCode, this._payCode, "payCode")) {
/* 135 */       this._payCode = argPayCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getWorkingCategory() {
/* 140 */     return this._workingCategory;
/*     */   }
/*     */   
/*     */   public void setWorkingCategory(Boolean argWorkingCategory) {
/* 144 */     if (changed(argWorkingCategory, this._workingCategory, "workingCategory")) {
/* 145 */       this._workingCategory = argWorkingCategory;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getOrganizationId() != null) {
/* 155 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 157 */     if (getPayrollCategory() != null) {
/* 158 */       buf.append("payrollCategory").append("=").append(getPayrollCategory()).append(" ");
/*     */     }
/* 160 */     if (getCreateDate() != null) {
/* 161 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 163 */     if (getCreateUserId() != null) {
/* 164 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 166 */     if (getUpdateDate() != null) {
/* 167 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 169 */     if (getUpdateUserId() != null) {
/* 170 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 172 */     if (getDescription() != null) {
/* 173 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 175 */     if (getSortOrder() != null) {
/* 176 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 178 */     if (getIncludeInOverTime() != null && getIncludeInOverTime().booleanValue()) {
/* 179 */       buf.append("includeInOverTime").append("=").append(getIncludeInOverTime()).append(" ");
/*     */     }
/* 181 */     if (getPayCode() != null) {
/* 182 */       buf.append("payCode").append("=").append(getPayCode()).append(" ");
/*     */     }
/* 184 */     if (getWorkingCategory() != null && getWorkingCategory().booleanValue()) {
/* 185 */       buf.append("workingCategory").append("=").append(getWorkingCategory()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     PayrollCategoryId id = new PayrollCategoryId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setPayrollCategory(getPayrollCategory());
/* 195 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 199 */     setOrganizationId(((PayrollCategoryId)argObjectId).getOrganizationId());
/* 200 */     setPayrollCategory(((PayrollCategoryId)argObjectId).getPayrollCategory());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 204 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 208 */     StringBuilder buf = new StringBuilder(550);
/* 209 */     buf.append("<").append("dao").append(" name=\"PayrollCategory\" cmd=\"" + getObjectStateString() + "\">");
/* 210 */     getFieldsAsXml(buf);
/* 211 */     buf.append("</").append("dao").append(">");
/*     */     
/* 213 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 217 */     Map<String, String> values = super.getValues();
/* 218 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 219 */     if (this._payrollCategory != null) values.put("PayrollCategory", DaoUtils.getXmlSafeFieldValue(12, this._payrollCategory)); 
/* 220 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 221 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 222 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 223 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 224 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 225 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 226 */     if (this._includeInOverTime != null) values.put("IncludeInOverTime", DaoUtils.getXmlSafeFieldValue(-7, this._includeInOverTime)); 
/* 227 */     if (this._payCode != null) values.put("PayCode", DaoUtils.getXmlSafeFieldValue(12, this._payCode)); 
/* 228 */     if (this._workingCategory != null) values.put("WorkingCategory", DaoUtils.getXmlSafeFieldValue(-7, this._workingCategory)); 
/* 229 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 234 */     super.setValues(argValues);
/* 235 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 237 */       String fieldName = field.getKey();
/* 238 */       String fieldValue = field.getValue();
/* 239 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 244 */             setOrganizationId((Long)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayrollCategory":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setPayrollCategory((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setPayrollCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 262 */             setCreateDate((Date)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setCreateUserId((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 280 */             setUpdateDate((Date)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 289 */             setUpdateUserId((String)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setDescription((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 307 */             setSortOrder((Integer)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IncludeInOverTime":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 316 */             setIncludeInOverTime((Boolean)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setIncludeInOverTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayCode":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setPayCode((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setPayCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkingCategory":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 334 */             setWorkingCategory((Boolean)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setWorkingCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollCategoryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */