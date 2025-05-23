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
/*     */ 
/*     */ public class InventoryDocumentId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 284848759L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _retailLocationId;
/*     */   
/*     */   public InventoryDocumentId() {}
/*     */   
/*     */   public InventoryDocumentId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  31 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  35 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  39 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  43 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  47 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  51 */     this._retailLocationId = argRetailLocationId;
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
/*  64 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setDocumentId(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       if ("null".equals(str)) {
/*  72 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  75 */         setDocumentTypeCode(str);
/*     */       } 
/*  77 */       str = tokens[2];
/*     */       
/*  79 */       setOrganizationId(Long.valueOf(str));
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setRetailLocationId(Long.valueOf(str));
/*     */     }
/*  84 */     catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof InventoryDocumentId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     InventoryDocumentId other = (InventoryDocumentId)ob;
/*  98 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 101 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 104 */       .equals(other._documentTypeCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 107 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 110 */       .equals(other._retailLocationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._documentId == null) ? 0 : this._documentId
/* 117 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 118 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 119 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "InventoryDocument";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(this._documentId)
/*     */       
/* 134 */       .append("::").append(this._documentTypeCode)
/* 135 */       .append("::").append(String.valueOf(this._organizationId))
/* 136 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._documentId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._documentTypeCode == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._retailLocationId == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryDocumentId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */