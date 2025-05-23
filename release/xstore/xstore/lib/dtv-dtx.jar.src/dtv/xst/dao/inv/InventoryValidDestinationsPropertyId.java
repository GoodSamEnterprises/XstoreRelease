/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryValidDestinationsPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 87833434L;
/*     */   private Long _retailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _destinationTypeEnum;
/*     */   private String _destinationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryValidDestinationsPropertyId() {}
/*     */   
/*     */   public InventoryValidDestinationsPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  34 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  38 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  42 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  46 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public String getDocumentSubtypeCode() {
/*  50 */     return this._documentSubtypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentSubtypeCode(String argDocumentSubtypeCode) {
/*  54 */     this._documentSubtypeCode = (argDocumentSubtypeCode != null && MANAGE_CASE) ? argDocumentSubtypeCode.toUpperCase() : argDocumentSubtypeCode;
/*     */   }
/*     */   
/*     */   public String getDestinationTypeEnum() {
/*  58 */     return this._destinationTypeEnum;
/*     */   }
/*     */   
/*     */   public void setDestinationTypeEnum(String argDestinationTypeEnum) {
/*  62 */     this._destinationTypeEnum = (argDestinationTypeEnum != null && MANAGE_CASE) ? argDestinationTypeEnum.toUpperCase() : argDestinationTypeEnum;
/*     */   }
/*     */   
/*     */   public String getDestinationId() {
/*  66 */     return this._destinationId;
/*     */   }
/*     */   
/*     */   public void setDestinationId(String argDestinationId) {
/*  70 */     this._destinationId = (argDestinationId != null && MANAGE_CASE) ? argDestinationId.toUpperCase() : argDestinationId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  74 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  78 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  82 */     String str = argObjectIdValue;
/*  83 */     if (StringUtils.isEmpty(str)) {
/*  84 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  87 */       String[] tokens = str.split("::");
/*  88 */       str = tokens[0];
/*     */       
/*  90 */       setOrganizationId(Long.valueOf(str));
/*  91 */       str = tokens[1];
/*     */       
/*  93 */       setRetailLocationId(Long.valueOf(str));
/*  94 */       str = tokens[2];
/*     */       
/*  96 */       if ("null".equals(str)) {
/*  97 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/* 100 */         setDocumentTypeCode(str);
/*     */       } 
/* 102 */       str = tokens[3];
/*     */       
/* 104 */       if ("null".equals(str)) {
/* 105 */         setDocumentSubtypeCode((String)null);
/*     */       } else {
/*     */         
/* 108 */         setDocumentSubtypeCode(str);
/*     */       } 
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       if ("null".equals(str)) {
/* 113 */         setDestinationTypeEnum((String)null);
/*     */       } else {
/*     */         
/* 116 */         setDestinationTypeEnum(str);
/*     */       } 
/* 118 */       str = tokens[5];
/*     */       
/* 120 */       if ("null".equals(str)) {
/* 121 */         setDestinationId((String)null);
/*     */       } else {
/*     */         
/* 124 */         setDestinationId(str);
/*     */       } 
/* 126 */       str = tokens[6];
/*     */       
/* 128 */       if ("null".equals(str)) {
/* 129 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 132 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 135 */     } catch (Exception ee) {
/* 136 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 142 */     if (this == ob) {
/* 143 */       return true;
/*     */     }
/* 145 */     if (!(ob instanceof InventoryValidDestinationsPropertyId)) {
/* 146 */       return false;
/*     */     }
/* 148 */     InventoryValidDestinationsPropertyId other = (InventoryValidDestinationsPropertyId)ob;
/* 149 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 152 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 155 */       .equals(other._retailLocationId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 158 */       .equals(other._documentTypeCode))) && ((this._documentSubtypeCode == null && other._documentSubtypeCode == null) || (this._documentSubtypeCode != null && this._documentSubtypeCode
/*     */ 
/*     */       
/* 161 */       .equals(other._documentSubtypeCode))) && ((this._destinationTypeEnum == null && other._destinationTypeEnum == null) || (this._destinationTypeEnum != null && this._destinationTypeEnum
/*     */ 
/*     */       
/* 164 */       .equals(other._destinationTypeEnum))) && ((this._destinationId == null && other._destinationId == null) || (this._destinationId != null && this._destinationId
/*     */ 
/*     */       
/* 167 */       .equals(other._destinationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 170 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 176 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 177 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 178 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 179 */       .hashCode()) + ((this._documentSubtypeCode == null) ? 0 : this._documentSubtypeCode
/* 180 */       .hashCode()) + ((this._destinationTypeEnum == null) ? 0 : this._destinationTypeEnum
/* 181 */       .hashCode()) + ((this._destinationId == null) ? 0 : this._destinationId
/* 182 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 183 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 188 */     return "InventoryValidDestinationsProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 193 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 195 */     return buff.append(
/* 196 */         String.valueOf(this._organizationId))
/* 197 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 198 */       .append("::").append(this._documentTypeCode)
/* 199 */       .append("::").append(this._documentSubtypeCode)
/* 200 */       .append("::").append(this._destinationTypeEnum)
/* 201 */       .append("::").append(this._destinationId)
/* 202 */       .append("::").append(this._propertyCode)
/* 203 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 207 */     if (this._retailLocationId == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (this._documentTypeCode == null) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (this._documentSubtypeCode == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._destinationTypeEnum == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._destinationId == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._propertyCode == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryValidDestinationsPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */