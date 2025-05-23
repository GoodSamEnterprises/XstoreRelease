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
/*     */ public class WarrantyJournalId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 2069047931L;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private Long _journalSequence;
/*     */   
/*     */   public WarrantyJournalId() {}
/*     */   
/*     */   public WarrantyJournalId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyNbr() {
/*  31 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  35 */     this._warrantyNbr = (argWarrantyNbr != null && MANAGE_CASE) ? argWarrantyNbr.toUpperCase() : argWarrantyNbr;
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/*  39 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  43 */     this._warrantyTypeCode = (argWarrantyTypeCode != null && MANAGE_CASE) ? argWarrantyTypeCode.toUpperCase() : argWarrantyTypeCode;
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/*  47 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/*  51 */     this._journalSequence = argJournalSequence;
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
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setWarrantyNbr((String)null);
/*     */       } else {
/*     */         
/*  70 */         setWarrantyNbr(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setWarrantyTypeCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setWarrantyTypeCode(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setJournalSequence(Long.valueOf(str));
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
/*  94 */     if (!(ob instanceof WarrantyJournalId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     WarrantyJournalId other = (WarrantyJournalId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._warrantyNbr == null && other._warrantyNbr == null) || (this._warrantyNbr != null && this._warrantyNbr
/*     */ 
/*     */       
/* 104 */       .equals(other._warrantyNbr))) && ((this._warrantyTypeCode == null && other._warrantyTypeCode == null) || (this._warrantyTypeCode != null && this._warrantyTypeCode
/*     */ 
/*     */       
/* 107 */       .equals(other._warrantyTypeCode))) && ((this._journalSequence == null && other._journalSequence == null) || (this._journalSequence != null && this._journalSequence
/*     */ 
/*     */       
/* 110 */       .equals(other._journalSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._warrantyNbr == null) ? 0 : this._warrantyNbr
/* 118 */       .hashCode()) + ((this._warrantyTypeCode == null) ? 0 : this._warrantyTypeCode
/* 119 */       .hashCode()) + ((this._journalSequence == null) ? 0 : this._journalSequence
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "WarrantyJournal";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._warrantyNbr)
/* 135 */       .append("::").append(this._warrantyTypeCode)
/* 136 */       .append("::").append(String.valueOf(this._journalSequence))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._warrantyNbr == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._warrantyTypeCode == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._journalSequence == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\WarrantyJournalId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */