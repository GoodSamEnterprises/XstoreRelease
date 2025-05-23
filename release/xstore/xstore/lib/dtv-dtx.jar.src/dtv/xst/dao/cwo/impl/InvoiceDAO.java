/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.InvoiceId;
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
/*     */ public class InvoiceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -670115059L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InvoiceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _invoiceDate;
/*     */   private BigDecimal _amountDue;
/*     */   private String _notes;
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
/*     */   public String getServiceLocationId() {
/*  47 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/*  51 */     if (changed(argServiceLocationId, this._serviceLocationId, "serviceLocationId")) {
/*  52 */       this._serviceLocationId = (argServiceLocationId != null && MANAGE_CASE) ? argServiceLocationId.toUpperCase() : argServiceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvoiceNumber() {
/*  57 */     return this._invoiceNumber;
/*     */   }
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/*  61 */     if (changed(argInvoiceNumber, this._invoiceNumber, "invoiceNumber")) {
/*  62 */       this._invoiceNumber = (argInvoiceNumber != null && MANAGE_CASE) ? argInvoiceNumber.toUpperCase() : argInvoiceNumber;
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
/*     */   public Date getInvoiceDate() {
/* 109 */     return (Date)this._invoiceDate;
/*     */   }
/*     */   
/*     */   public void setInvoiceDate(Date argInvoiceDate) {
/* 113 */     if (changed(argInvoiceDate, this._invoiceDate, "invoiceDate")) {
/* 114 */       this._invoiceDate = (argInvoiceDate == null || argInvoiceDate instanceof DtvDate) ? (DtvDate)argInvoiceDate : new DtvDate(argInvoiceDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getAmountDue() {
/* 120 */     return this._amountDue;
/*     */   }
/*     */   
/*     */   public void setAmountDue(BigDecimal argAmountDue) {
/* 124 */     if (changed(argAmountDue, this._amountDue, "amountDue")) {
/* 125 */       this._amountDue = argAmountDue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 130 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 134 */     if (changed(argNotes, this._notes, "notes")) {
/* 135 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder buf = new StringBuilder(512);
/* 143 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 144 */     if (getOrganizationId() != null) {
/* 145 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 147 */     if (getServiceLocationId() != null) {
/* 148 */       buf.append("serviceLocationId").append("=").append(getServiceLocationId()).append(" ");
/*     */     }
/* 150 */     if (getInvoiceNumber() != null) {
/* 151 */       buf.append("invoiceNumber").append("=").append(getInvoiceNumber()).append(" ");
/*     */     }
/* 153 */     if (getCreateDate() != null) {
/* 154 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 156 */     if (getCreateUserId() != null) {
/* 157 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 159 */     if (getUpdateDate() != null) {
/* 160 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 162 */     if (getUpdateUserId() != null) {
/* 163 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 165 */     if (getInvoiceDate() != null) {
/* 166 */       buf.append("invoiceDate").append("=").append(getInvoiceDate()).append(" ");
/*     */     }
/* 168 */     if (getAmountDue() != null) {
/* 169 */       buf.append("amountDue").append("=").append(getAmountDue()).append(" ");
/*     */     }
/* 171 */     if (getNotes() != null) {
/* 172 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/*     */     
/* 175 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 179 */     InvoiceId id = new InvoiceId();
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     id.setServiceLocationId(getServiceLocationId());
/* 182 */     id.setInvoiceNumber(getInvoiceNumber());
/* 183 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 187 */     setOrganizationId(((InvoiceId)argObjectId).getOrganizationId());
/* 188 */     setServiceLocationId(((InvoiceId)argObjectId).getServiceLocationId());
/* 189 */     setInvoiceNumber(((InvoiceId)argObjectId).getInvoiceNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 193 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 197 */     StringBuilder buf = new StringBuilder(500);
/* 198 */     buf.append("<").append("dao").append(" name=\"Invoice\" cmd=\"" + getObjectStateString() + "\">");
/* 199 */     getFieldsAsXml(buf);
/* 200 */     buf.append("</").append("dao").append(">");
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 206 */     Map<String, String> values = super.getValues();
/* 207 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 208 */     if (this._serviceLocationId != null) values.put("ServiceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._serviceLocationId)); 
/* 209 */     if (this._invoiceNumber != null) values.put("InvoiceNumber", DaoUtils.getXmlSafeFieldValue(12, this._invoiceNumber)); 
/* 210 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 211 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 212 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 213 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 214 */     if (this._invoiceDate != null) values.put("InvoiceDate", DaoUtils.getXmlSafeFieldValue(91, this._invoiceDate)); 
/* 215 */     if (this._amountDue != null) values.put("AmountDue", DaoUtils.getXmlSafeFieldValue(3, this._amountDue)); 
/* 216 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 217 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 222 */     super.setValues(argValues);
/* 223 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 225 */       String fieldName = field.getKey();
/* 226 */       String fieldValue = field.getValue();
/* 227 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 231 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 232 */             setOrganizationId((Long)value);
/* 233 */           } catch (Exception ee) {
/* 234 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ServiceLocationId":
/*     */           try {
/* 240 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 241 */             setServiceLocationId((String)value);
/* 242 */           } catch (Exception ee) {
/* 243 */             throw new DtxException("An exception occurred while calling setServiceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceNumber":
/*     */           try {
/* 249 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 250 */             setInvoiceNumber((String)value);
/* 251 */           } catch (Exception ee) {
/* 252 */             throw new DtxException("An exception occurred while calling setInvoiceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 259 */             setCreateDate((Date)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setCreateUserId((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 277 */             setUpdateDate((Date)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setUpdateUserId((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceDate":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 295 */             setInvoiceDate((Date)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setInvoiceDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AmountDue":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 304 */             setAmountDue((BigDecimal)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setAmountDue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setNotes((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */