/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMessageTypesPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -822325126L;
/*     */   private String _messageId;
/*     */   private String _lineItemType;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemMessageTypesPropertyId() {}
/*     */   
/*     */   public ItemMessageTypesPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageId() {
/*  31 */     return this._messageId;
/*     */   }
/*     */   
/*     */   public void setMessageId(String argMessageId) {
/*  35 */     this._messageId = (argMessageId != null && MANAGE_CASE) ? argMessageId.toUpperCase() : argMessageId;
/*     */   }
/*     */   
/*     */   public String getLineItemType() {
/*  39 */     return this._lineItemType;
/*     */   }
/*     */   
/*     */   public void setLineItemType(String argLineItemType) {
/*  43 */     this._lineItemType = (argLineItemType != null && MANAGE_CASE) ? argLineItemType.toUpperCase() : argLineItemType;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       if ("null".equals(str)) {
/*  64 */         setMessageId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setMessageId(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       setOrganizationId(Long.valueOf(str));
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setLineItemType((String)null);
/*     */       } else {
/*     */         
/*  78 */         setLineItemType(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof ItemMessageTypesPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ItemMessageTypesPropertyId other = (ItemMessageTypesPropertyId)ob;
/* 103 */     return (((this._messageId == null && other._messageId == null) || (this._messageId != null && this._messageId
/*     */ 
/*     */       
/* 106 */       .equals(other._messageId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 109 */       .equals(other._organizationId))) && ((this._lineItemType == null && other._lineItemType == null) || (this._lineItemType != null && this._lineItemType
/*     */ 
/*     */       
/* 112 */       .equals(other._lineItemType))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._messageId == null) ? 0 : this._messageId
/* 122 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 123 */       .hashCode()) + ((this._lineItemType == null) ? 0 : this._lineItemType
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ItemMessageTypesProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._messageId)
/*     */       
/* 139 */       .append("::").append(String.valueOf(this._organizationId))
/* 140 */       .append("::").append(this._lineItemType)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._messageId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._lineItemType == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemMessageTypesPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */