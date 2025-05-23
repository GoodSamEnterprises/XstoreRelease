/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryValidDestinationsId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 866266725L;
/*     */   private Long _retailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _destinationTypeEnum;
/*     */   private String _destinationId;
/*     */   
/*     */   public InventoryValidDestinationsId() {}
/*     */   
/*     */   public InventoryValidDestinationsId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  33 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  37 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  41 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  45 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public String getDocumentSubtypeCode() {
/*  49 */     return this._documentSubtypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentSubtypeCode(String argDocumentSubtypeCode) {
/*  53 */     this._documentSubtypeCode = (argDocumentSubtypeCode != null && MANAGE_CASE) ? argDocumentSubtypeCode.toUpperCase() : argDocumentSubtypeCode;
/*     */   }
/*     */   
/*     */   public String getDestinationTypeEnum() {
/*  57 */     return this._destinationTypeEnum;
/*     */   }
/*     */   
/*     */   public void setDestinationTypeEnum(String argDestinationTypeEnum) {
/*  61 */     this._destinationTypeEnum = (argDestinationTypeEnum != null && MANAGE_CASE) ? argDestinationTypeEnum.toUpperCase() : argDestinationTypeEnum;
/*     */   }
/*     */   
/*     */   public String getDestinationId() {
/*  65 */     return this._destinationId;
/*     */   }
/*     */   
/*     */   public void setDestinationId(String argDestinationId) {
/*  69 */     this._destinationId = (argDestinationId != null && MANAGE_CASE) ? argDestinationId.toUpperCase() : argDestinationId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  73 */     String str = argObjectIdValue;
/*  74 */     if (StringUtils.isEmpty(str)) {
/*  75 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  78 */       String[] tokens = str.split("::");
/*  79 */       str = tokens[0];
/*     */       
/*  81 */       setOrganizationId(Long.valueOf(str));
/*  82 */       str = tokens[1];
/*     */       
/*  84 */       setRetailLocationId(Long.valueOf(str));
/*  85 */       str = tokens[2];
/*     */       
/*  87 */       if ("null".equals(str)) {
/*  88 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  91 */         setDocumentTypeCode(str);
/*     */       } 
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       if ("null".equals(str)) {
/*  96 */         setDocumentSubtypeCode((String)null);
/*     */       } else {
/*     */         
/*  99 */         setDocumentSubtypeCode(str);
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setDestinationTypeEnum((String)null);
/*     */       } else {
/*     */         
/* 107 */         setDestinationTypeEnum(str);
/*     */       } 
/* 109 */       str = tokens[5];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setDestinationId((String)null);
/*     */       } else {
/*     */         
/* 115 */         setDestinationId(str);
/*     */       }
/*     */     
/* 118 */     } catch (Exception ee) {
/* 119 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 125 */     if (this == ob) {
/* 126 */       return true;
/*     */     }
/* 128 */     if (!(ob instanceof InventoryValidDestinationsId)) {
/* 129 */       return false;
/*     */     }
/* 131 */     InventoryValidDestinationsId other = (InventoryValidDestinationsId)ob;
/* 132 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 135 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 138 */       .equals(other._retailLocationId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 141 */       .equals(other._documentTypeCode))) && ((this._documentSubtypeCode == null && other._documentSubtypeCode == null) || (this._documentSubtypeCode != null && this._documentSubtypeCode
/*     */ 
/*     */       
/* 144 */       .equals(other._documentSubtypeCode))) && ((this._destinationTypeEnum == null && other._destinationTypeEnum == null) || (this._destinationTypeEnum != null && this._destinationTypeEnum
/*     */ 
/*     */       
/* 147 */       .equals(other._destinationTypeEnum))) && ((this._destinationId == null && other._destinationId == null) || (this._destinationId != null && this._destinationId
/*     */ 
/*     */       
/* 150 */       .equals(other._destinationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 157 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 158 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 159 */       .hashCode()) + ((this._documentSubtypeCode == null) ? 0 : this._documentSubtypeCode
/* 160 */       .hashCode()) + ((this._destinationTypeEnum == null) ? 0 : this._destinationTypeEnum
/* 161 */       .hashCode()) + ((this._destinationId == null) ? 0 : this._destinationId
/* 162 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 167 */     return "InventoryValidDestinations";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 174 */     return buff.append(
/* 175 */         String.valueOf(this._organizationId))
/* 176 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 177 */       .append("::").append(this._documentTypeCode)
/* 178 */       .append("::").append(this._documentSubtypeCode)
/* 179 */       .append("::").append(this._destinationTypeEnum)
/* 180 */       .append("::").append(this._destinationId)
/* 181 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 185 */     if (this._retailLocationId == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._documentTypeCode == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._documentSubtypeCode == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._destinationTypeEnum == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._destinationId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryValidDestinationsId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */