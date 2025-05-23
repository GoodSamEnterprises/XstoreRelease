/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.ItemModifierId;
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
/*     */ public class ItemModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 177238826L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private String _description;
/*     */   private String _imageUrl;
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
/*     */   public String getItemId() {
/* 109 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 113 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 114 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 119 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 123 */     if (changed(argDescription, this._description, "description")) {
/* 124 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getImageUrl() {
/* 129 */     return this._imageUrl;
/*     */   }
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 133 */     if (changed(argImageUrl, this._imageUrl, "imageUrl")) {
/* 134 */       this._imageUrl = argImageUrl;
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
/* 164 */     if (getItemId() != null) {
/* 165 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 167 */     if (getDescription() != null) {
/* 168 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 170 */     if (getImageUrl() != null) {
/* 171 */       buf.append("imageUrl").append("=").append(getImageUrl()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     ItemModifierId id = new ItemModifierId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setOrderId(getOrderId());
/* 181 */     id.setSequence(getSequence());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((ItemModifierId)argObjectId).getOrganizationId());
/* 187 */     setOrderId(((ItemModifierId)argObjectId).getOrderId());
/* 188 */     setSequence(((ItemModifierId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 196 */     StringBuilder buf = new StringBuilder(500);
/* 197 */     buf.append("<").append("dao").append(" name=\"ItemModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 198 */     getFieldsAsXml(buf);
/* 199 */     buf.append("</").append("dao").append(">");
/*     */     
/* 201 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 205 */     Map<String, String> values = super.getValues();
/* 206 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 207 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 208 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 209 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 210 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 211 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 212 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 213 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 214 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 215 */     if (this._imageUrl != null) values.put("ImageUrl", DaoUtils.getXmlSafeFieldValue(12, this._imageUrl)); 
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
/*     */         case "OrganizationId":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 231 */             setOrganizationId((Long)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 240 */             setOrderId((String)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 249 */             setSequence((Integer)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "ItemId":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setItemId((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 303 */             setDescription((String)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ImageUrl":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setImageUrl((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setImageUrl() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\ItemModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */