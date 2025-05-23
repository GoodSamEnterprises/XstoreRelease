/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxTaxGroupMappingId;
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
/*     */ public class TaxTaxGroupMappingDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -772656753L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxTaxGroupMappingDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _customerGroup;
/*     */   private String _taxGroupId;
/*     */   private Integer _rtlLocId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _priority;
/*     */   private String _newTaxGroupId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerGroup() {
/*  47 */     return this._customerGroup;
/*     */   }
/*     */   
/*     */   public void setCustomerGroup(String argCustomerGroup) {
/*  51 */     if (changed(argCustomerGroup, this._customerGroup, "customerGroup")) {
/*  52 */       this._customerGroup = (argCustomerGroup != null && MANAGE_CASE) ? argCustomerGroup.toUpperCase() : argCustomerGroup;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/*  57 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  61 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/*  62 */       this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRtlLocId() {
/*  67 */     return this._rtlLocId;
/*     */   }
/*     */   
/*     */   public void setRtlLocId(Integer argRtlLocId) {
/*  71 */     if (changed(argRtlLocId, this._rtlLocId, "rtlLocId")) {
/*  72 */       this._rtlLocId = argRtlLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getPriority() {
/* 119 */     return this._priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Integer argPriority) {
/* 123 */     if (changed(argPriority, this._priority, "priority")) {
/* 124 */       this._priority = argPriority;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNewTaxGroupId() {
/* 129 */     return this._newTaxGroupId;
/*     */   }
/*     */   
/*     */   public void setNewTaxGroupId(String argNewTaxGroupId) {
/* 133 */     if (changed(argNewTaxGroupId, this._newTaxGroupId, "newTaxGroupId")) {
/* 134 */       this._newTaxGroupId = argNewTaxGroupId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getOrganizationId() != null) {
/* 144 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 146 */     if (getCustomerGroup() != null) {
/* 147 */       buf.append("customerGroup").append("=").append(getCustomerGroup()).append(" ");
/*     */     }
/* 149 */     if (getTaxGroupId() != null) {
/* 150 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*     */     }
/* 152 */     if (getRtlLocId() != null) {
/* 153 */       buf.append("rtlLocId").append("=").append(getRtlLocId()).append(" ");
/*     */     }
/* 155 */     if (getCreateDate() != null) {
/* 156 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 158 */     if (getCreateUserId() != null) {
/* 159 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 161 */     if (getUpdateDate() != null) {
/* 162 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 164 */     if (getUpdateUserId() != null) {
/* 165 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 167 */     if (getPriority() != null) {
/* 168 */       buf.append("priority").append("=").append(getPriority()).append(" ");
/*     */     }
/* 170 */     if (getNewTaxGroupId() != null) {
/* 171 */       buf.append("newTaxGroupId").append("=").append(getNewTaxGroupId()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     TaxTaxGroupMappingId id = new TaxTaxGroupMappingId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setCustomerGroup(getCustomerGroup());
/* 181 */     id.setTaxGroupId(getTaxGroupId());
/* 182 */     id.setRtlLocId(getRtlLocId());
/* 183 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 187 */     setOrganizationId(((TaxTaxGroupMappingId)argObjectId).getOrganizationId());
/* 188 */     setCustomerGroup(((TaxTaxGroupMappingId)argObjectId).getCustomerGroup());
/* 189 */     setTaxGroupId(((TaxTaxGroupMappingId)argObjectId).getTaxGroupId());
/* 190 */     setRtlLocId(((TaxTaxGroupMappingId)argObjectId).getRtlLocId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 198 */     StringBuilder buf = new StringBuilder(500);
/* 199 */     buf.append("<").append("dao").append(" name=\"TaxTaxGroupMapping\" cmd=\"" + getObjectStateString() + "\">");
/* 200 */     getFieldsAsXml(buf);
/* 201 */     buf.append("</").append("dao").append(">");
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 207 */     Map<String, String> values = super.getValues();
/* 208 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 209 */     if (this._customerGroup != null) values.put("CustomerGroup", DaoUtils.getXmlSafeFieldValue(12, this._customerGroup)); 
/* 210 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/* 211 */     if (this._rtlLocId != null) values.put("RtlLocId", DaoUtils.getXmlSafeFieldValue(4, this._rtlLocId)); 
/* 212 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 213 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 214 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 215 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 216 */     if (this._priority != null) values.put("Priority", DaoUtils.getXmlSafeFieldValue(4, this._priority)); 
/* 217 */     if (this._newTaxGroupId != null) values.put("NewTaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._newTaxGroupId)); 
/* 218 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 223 */     super.setValues(argValues);
/* 224 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 226 */       String fieldName = field.getKey();
/* 227 */       String fieldValue = field.getValue();
/* 228 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 232 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 233 */             setOrganizationId((Long)value);
/* 234 */           } catch (Exception ee) {
/* 235 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerGroup":
/*     */           try {
/* 241 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 242 */             setCustomerGroup((String)value);
/* 243 */           } catch (Exception ee) {
/* 244 */             throw new DtxException("An exception occurred while calling setCustomerGroup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxGroupId":
/*     */           try {
/* 250 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 251 */             setTaxGroupId((String)value);
/* 252 */           } catch (Exception ee) {
/* 253 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RtlLocId":
/*     */           try {
/* 259 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 260 */             setRtlLocId((Integer)value);
/* 261 */           } catch (Exception ee) {
/* 262 */             throw new DtxException("An exception occurred while calling setRtlLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 268 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 269 */             setCreateDate((Date)value);
/* 270 */           } catch (Exception ee) {
/* 271 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 278 */             setCreateUserId((String)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 287 */             setUpdateDate((Date)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 296 */             setUpdateUserId((String)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Priority":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 305 */             setPriority((Integer)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setPriority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewTaxGroupId":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setNewTaxGroupId((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setNewTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxTaxGroupMappingDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */