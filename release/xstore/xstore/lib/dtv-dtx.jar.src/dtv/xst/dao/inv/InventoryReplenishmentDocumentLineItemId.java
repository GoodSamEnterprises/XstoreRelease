/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryReplenishmentDocumentLineItemId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1339662122L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _retailLocationId;
/*     */   
/*     */   public InventoryReplenishmentDocumentLineItemId() {}
/*     */   
/*     */   public InventoryReplenishmentDocumentLineItemId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  32 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  36 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  40 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  44 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  48 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  52 */     this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  56 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  60 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  76 */         setDocumentId(str);
/*     */       } 
/*  78 */       str = tokens[1];
/*     */       
/*  80 */       if ("null".equals(str)) {
/*  81 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  84 */         setDocumentTypeCode(str);
/*     */       } 
/*  86 */       str = tokens[2];
/*     */       
/*  88 */       setInventoryDocumentLineNumber(Integer.valueOf(str));
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setOrganizationId(Long.valueOf(str));
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       setRetailLocationId(Long.valueOf(str));
/*     */     }
/*  96 */     catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof InventoryReplenishmentDocumentLineItemId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     InventoryReplenishmentDocumentLineItemId other = (InventoryReplenishmentDocumentLineItemId)ob;
/* 110 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 113 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 116 */       .equals(other._documentTypeCode))) && ((this._inventoryDocumentLineNumber == null && other._inventoryDocumentLineNumber == null) || (this._inventoryDocumentLineNumber != null && this._inventoryDocumentLineNumber
/*     */ 
/*     */       
/* 119 */       .equals(other._inventoryDocumentLineNumber))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 122 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 125 */       .equals(other._retailLocationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._documentId == null) ? 0 : this._documentId
/* 132 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 133 */       .hashCode()) + ((this._inventoryDocumentLineNumber == null) ? 0 : this._inventoryDocumentLineNumber
/* 134 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 135 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "InventoryReplenishmentDocumentLineItem";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(this._documentId)
/*     */       
/* 150 */       .append("::").append(this._documentTypeCode)
/* 151 */       .append("::").append(String.valueOf(this._inventoryDocumentLineNumber))
/* 152 */       .append("::").append(String.valueOf(this._organizationId))
/* 153 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._documentId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._documentTypeCode == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._inventoryDocumentLineNumber == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._retailLocationId == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryReplenishmentDocumentLineItemId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */