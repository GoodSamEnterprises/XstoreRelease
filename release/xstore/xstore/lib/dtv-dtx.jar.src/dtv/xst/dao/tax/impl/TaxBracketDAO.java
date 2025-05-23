/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxBracketId;
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
/*     */ public class TaxBracketDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1929214621L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxBracketDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _taxBracketId;
/*     */   private Integer _taxBracketSequence;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _taxBreakpoint;
/*     */   private BigDecimal _taxAmount;
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
/*     */   public String getTaxBracketId() {
/*  48 */     return this._taxBracketId;
/*     */   }
/*     */   
/*     */   public void setTaxBracketId(String argTaxBracketId) {
/*  52 */     if (changed(argTaxBracketId, this._taxBracketId, "taxBracketId")) {
/*  53 */       this._taxBracketId = (argTaxBracketId != null && MANAGE_CASE) ? argTaxBracketId.toUpperCase() : argTaxBracketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxBracketSequence() {
/*  58 */     return this._taxBracketSequence;
/*     */   }
/*     */   
/*     */   public void setTaxBracketSequence(Integer argTaxBracketSequence) {
/*  62 */     if (changed(argTaxBracketSequence, this._taxBracketSequence, "taxBracketSequence")) {
/*  63 */       this._taxBracketSequence = argTaxBracketSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  68 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  72 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  73 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  78 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  82 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  83 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxBreakpoint() {
/* 130 */     return this._taxBreakpoint;
/*     */   }
/*     */   
/*     */   public void setTaxBreakpoint(BigDecimal argTaxBreakpoint) {
/* 134 */     if (changed(argTaxBreakpoint, this._taxBreakpoint, "taxBreakpoint")) {
/* 135 */       this._taxBreakpoint = argTaxBreakpoint;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 140 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 144 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/* 145 */       this._taxAmount = argTaxAmount;
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
/* 157 */     if (getTaxBracketId() != null) {
/* 158 */       buf.append("taxBracketId").append("=").append(getTaxBracketId()).append(" ");
/*     */     }
/* 160 */     if (getTaxBracketSequence() != null) {
/* 161 */       buf.append("taxBracketSequence").append("=").append(getTaxBracketSequence()).append(" ");
/*     */     }
/* 163 */     if (getOrgCode() != null) {
/* 164 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 166 */     if (getOrgValue() != null) {
/* 167 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 169 */     if (getCreateDate() != null) {
/* 170 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 172 */     if (getCreateUserId() != null) {
/* 173 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 175 */     if (getUpdateDate() != null) {
/* 176 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 178 */     if (getUpdateUserId() != null) {
/* 179 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 181 */     if (getTaxBreakpoint() != null) {
/* 182 */       buf.append("taxBreakpoint").append("=").append(getTaxBreakpoint()).append(" ");
/*     */     }
/* 184 */     if (getTaxAmount() != null) {
/* 185 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     TaxBracketId id = new TaxBracketId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setTaxBracketId(getTaxBracketId());
/* 195 */     id.setTaxBracketSequence(getTaxBracketSequence());
/* 196 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 200 */     setOrganizationId(((TaxBracketId)argObjectId).getOrganizationId());
/* 201 */     setTaxBracketId(((TaxBracketId)argObjectId).getTaxBracketId());
/* 202 */     setTaxBracketSequence(((TaxBracketId)argObjectId).getTaxBracketSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 206 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 210 */     StringBuilder buf = new StringBuilder(550);
/* 211 */     buf.append("<").append("dao").append(" name=\"TaxBracket\" cmd=\"" + getObjectStateString() + "\">");
/* 212 */     getFieldsAsXml(buf);
/* 213 */     buf.append("</").append("dao").append(">");
/*     */     
/* 215 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 219 */     Map<String, String> values = super.getValues();
/* 220 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 221 */     if (this._taxBracketId != null) values.put("TaxBracketId", DaoUtils.getXmlSafeFieldValue(12, this._taxBracketId)); 
/* 222 */     if (this._taxBracketSequence != null) values.put("TaxBracketSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxBracketSequence)); 
/* 223 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 224 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 225 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 226 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 227 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 228 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 229 */     if (this._taxBreakpoint != null) values.put("TaxBreakpoint", DaoUtils.getXmlSafeFieldValue(3, this._taxBreakpoint)); 
/* 230 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 231 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 236 */     super.setValues(argValues);
/* 237 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 239 */       String fieldName = field.getKey();
/* 240 */       String fieldValue = field.getValue();
/* 241 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 246 */             setOrganizationId((Long)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxBracketId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setTaxBracketId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setTaxBracketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxBracketSequence":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 264 */             setTaxBracketSequence((Integer)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setTaxBracketSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 273 */             setOrgCode((String)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setOrgValue((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 291 */             setCreateDate((Date)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setCreateUserId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 309 */             setUpdateDate((Date)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setUpdateUserId((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxBreakpoint":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 327 */             setTaxBreakpoint((BigDecimal)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setTaxBreakpoint() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 336 */             setTaxAmount((BigDecimal)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxBracketDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */