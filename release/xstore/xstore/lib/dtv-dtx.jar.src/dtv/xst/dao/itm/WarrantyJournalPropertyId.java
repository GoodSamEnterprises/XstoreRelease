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
/*     */ public class WarrantyJournalPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1206730384L;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private Long _journalSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public WarrantyJournalPropertyId() {}
/*     */   
/*     */   public WarrantyJournalPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyNbr() {
/*  32 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  36 */     this._warrantyNbr = (argWarrantyNbr != null && MANAGE_CASE) ? argWarrantyNbr.toUpperCase() : argWarrantyNbr;
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/*  40 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  44 */     this._warrantyTypeCode = (argWarrantyTypeCode != null && MANAGE_CASE) ? argWarrantyTypeCode.toUpperCase() : argWarrantyTypeCode;
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/*  48 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/*  52 */     this._journalSequence = argJournalSequence;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setWarrantyNbr((String)null);
/*     */       } else {
/*     */         
/*  79 */         setWarrantyNbr(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setWarrantyTypeCode((String)null);
/*     */       } else {
/*     */         
/*  87 */         setWarrantyTypeCode(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setJournalSequence(Long.valueOf(str));
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  98 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 101 */     } catch (Exception ee) {
/* 102 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 108 */     if (this == ob) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(ob instanceof WarrantyJournalPropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     WarrantyJournalPropertyId other = (WarrantyJournalPropertyId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._warrantyNbr == null && other._warrantyNbr == null) || (this._warrantyNbr != null && this._warrantyNbr
/*     */ 
/*     */       
/* 121 */       .equals(other._warrantyNbr))) && ((this._warrantyTypeCode == null && other._warrantyTypeCode == null) || (this._warrantyTypeCode != null && this._warrantyTypeCode
/*     */ 
/*     */       
/* 124 */       .equals(other._warrantyTypeCode))) && ((this._journalSequence == null && other._journalSequence == null) || (this._journalSequence != null && this._journalSequence
/*     */ 
/*     */       
/* 127 */       .equals(other._journalSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._warrantyNbr == null) ? 0 : this._warrantyNbr
/* 138 */       .hashCode()) + ((this._warrantyTypeCode == null) ? 0 : this._warrantyTypeCode
/* 139 */       .hashCode()) + ((this._journalSequence == null) ? 0 : this._journalSequence
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "WarrantyJournalProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(this._warrantyNbr)
/* 156 */       .append("::").append(this._warrantyTypeCode)
/* 157 */       .append("::").append(String.valueOf(this._journalSequence))
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._warrantyNbr == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._warrantyTypeCode == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._journalSequence == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\WarrantyJournalPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */