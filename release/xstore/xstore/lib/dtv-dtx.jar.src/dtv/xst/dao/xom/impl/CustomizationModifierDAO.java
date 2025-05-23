/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.CustomizationModifierId;
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
/*     */ public class CustomizationModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1871520854L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomizationModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Integer _modSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _customizationCode;
/*     */   private String _customizationMessage;
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
/*     */   public String getOrderId() {
/*  47 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  51 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  52 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  57 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  61 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  62 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getModSequence() {
/*  67 */     return this._modSequence;
/*     */   }
/*     */   
/*     */   public void setModSequence(Integer argModSequence) {
/*  71 */     if (changed(argModSequence, this._modSequence, "modSequence")) {
/*  72 */       this._modSequence = argModSequence;
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
/*     */   public String getCustomizationCode() {
/* 119 */     return this._customizationCode;
/*     */   }
/*     */   
/*     */   public void setCustomizationCode(String argCustomizationCode) {
/* 123 */     if (changed(argCustomizationCode, this._customizationCode, "customizationCode")) {
/* 124 */       this._customizationCode = argCustomizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomizationMessage() {
/* 129 */     return this._customizationMessage;
/*     */   }
/*     */   
/*     */   public void setCustomizationMessage(String argCustomizationMessage) {
/* 133 */     if (changed(argCustomizationMessage, this._customizationMessage, "customizationMessage")) {
/* 134 */       this._customizationMessage = argCustomizationMessage;
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
/* 146 */     if (getOrderId() != null) {
/* 147 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 149 */     if (getSequence() != null) {
/* 150 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 152 */     if (getModSequence() != null) {
/* 153 */       buf.append("modSequence").append("=").append(getModSequence()).append(" ");
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
/* 167 */     if (getCustomizationCode() != null) {
/* 168 */       buf.append("customizationCode").append("=").append(getCustomizationCode()).append(" ");
/*     */     }
/* 170 */     if (getCustomizationMessage() != null) {
/* 171 */       buf.append("customizationMessage").append("=").append(getCustomizationMessage()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     CustomizationModifierId id = new CustomizationModifierId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setOrderId(getOrderId());
/* 181 */     id.setSequence(getSequence());
/* 182 */     id.setModSequence(getModSequence());
/* 183 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 187 */     setOrganizationId(((CustomizationModifierId)argObjectId).getOrganizationId());
/* 188 */     setOrderId(((CustomizationModifierId)argObjectId).getOrderId());
/* 189 */     setSequence(((CustomizationModifierId)argObjectId).getSequence());
/* 190 */     setModSequence(((CustomizationModifierId)argObjectId).getModSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 198 */     StringBuilder buf = new StringBuilder(500);
/* 199 */     buf.append("<").append("dao").append(" name=\"CustomizationModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 200 */     getFieldsAsXml(buf);
/* 201 */     buf.append("</").append("dao").append(">");
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 207 */     Map<String, String> values = super.getValues();
/* 208 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 209 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 210 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 211 */     if (this._modSequence != null) values.put("ModSequence", DaoUtils.getXmlSafeFieldValue(4, this._modSequence)); 
/* 212 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 213 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 214 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 215 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 216 */     if (this._customizationCode != null) values.put("CustomizationCode", DaoUtils.getXmlSafeFieldValue(12, this._customizationCode)); 
/* 217 */     if (this._customizationMessage != null) values.put("CustomizationMessage", DaoUtils.getXmlSafeFieldValue(12, this._customizationMessage)); 
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
/*     */         case "OrderId":
/*     */           try {
/* 241 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 242 */             setOrderId((String)value);
/* 243 */           } catch (Exception ee) {
/* 244 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 250 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 251 */             setSequence((Integer)value);
/* 252 */           } catch (Exception ee) {
/* 253 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ModSequence":
/*     */           try {
/* 259 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 260 */             setModSequence((Integer)value);
/* 261 */           } catch (Exception ee) {
/* 262 */             throw new DtxException("An exception occurred while calling setModSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "CustomizationCode":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 305 */             setCustomizationCode((String)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setCustomizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomizationMessage":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setCustomizationMessage((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setCustomizationMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\CustomizationModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */