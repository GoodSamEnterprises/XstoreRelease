/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.BalanceModifierId;
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
/*     */ public class BalanceModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 436662707L;
/*  23 */   private static final Logger _logger = Logger.getLogger(BalanceModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Integer _modSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _typeCode;
/*     */   private BigDecimal _amount;
/*  35 */   private Boolean _void = Boolean.FALSE;
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
/*     */   public String getOrderId() {
/*  48 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  52 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  53 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  58 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  62 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  63 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getModSequence() {
/*  68 */     return this._modSequence;
/*     */   }
/*     */   
/*     */   public void setModSequence(Integer argModSequence) {
/*  72 */     if (changed(argModSequence, this._modSequence, "modSequence")) {
/*  73 */       this._modSequence = argModSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  78 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  82 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  83 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  89 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  93 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  94 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  99 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 103 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 104 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 110 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 114 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 115 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 120 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 124 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 125 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 130 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 134 */     if (changed(argAmount, this._amount, "amount")) {
/* 135 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 140 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 144 */     if (changed(argVoid, this._void, "void")) {
/* 145 */       this._void = argVoid;
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
/* 157 */     if (getOrderId() != null) {
/* 158 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 160 */     if (getSequence() != null) {
/* 161 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 163 */     if (getModSequence() != null) {
/* 164 */       buf.append("modSequence").append("=").append(getModSequence()).append(" ");
/*     */     }
/* 166 */     if (getCreateDate() != null) {
/* 167 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 169 */     if (getCreateUserId() != null) {
/* 170 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 172 */     if (getUpdateDate() != null) {
/* 173 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 175 */     if (getUpdateUserId() != null) {
/* 176 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 178 */     if (getTypeCode() != null) {
/* 179 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 181 */     if (getAmount() != null) {
/* 182 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 184 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 185 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     BalanceModifierId id = new BalanceModifierId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setOrderId(getOrderId());
/* 195 */     id.setSequence(getSequence());
/* 196 */     id.setModSequence(getModSequence());
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 201 */     setOrganizationId(((BalanceModifierId)argObjectId).getOrganizationId());
/* 202 */     setOrderId(((BalanceModifierId)argObjectId).getOrderId());
/* 203 */     setSequence(((BalanceModifierId)argObjectId).getSequence());
/* 204 */     setModSequence(((BalanceModifierId)argObjectId).getModSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 208 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 212 */     StringBuilder buf = new StringBuilder(550);
/* 213 */     buf.append("<").append("dao").append(" name=\"BalanceModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 214 */     getFieldsAsXml(buf);
/* 215 */     buf.append("</").append("dao").append(">");
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 221 */     Map<String, String> values = super.getValues();
/* 222 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 223 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 224 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 225 */     if (this._modSequence != null) values.put("ModSequence", DaoUtils.getXmlSafeFieldValue(4, this._modSequence)); 
/* 226 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 227 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 228 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 229 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 230 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 231 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 232 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 233 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 238 */     super.setValues(argValues);
/* 239 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 241 */       String fieldName = field.getKey();
/* 242 */       String fieldValue = field.getValue();
/* 243 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 248 */             setOrganizationId((Long)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setOrderId((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 266 */             setSequence((Integer)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ModSequence":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 275 */             setModSequence((Integer)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setModSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setCreateDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setCreateUserId((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 302 */             setUpdateDate((Date)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setUpdateUserId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setTypeCode((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 329 */             setAmount((BigDecimal)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 338 */             setVoid((Boolean)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\BalanceModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */