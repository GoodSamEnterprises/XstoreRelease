/*     */ package dtv.xst.dao.crm;
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
/*     */ 
/*     */ public class CustomerNoteId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1064491280L;
/*     */   private Long _partyId;
/*     */   private Long _noteSequence;
/*     */   
/*     */   public CustomerNoteId() {}
/*     */   
/*     */   public CustomerNoteId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/*  30 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  34 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Long getNoteSequence() {
/*  38 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  42 */     this._noteSequence = argNoteSequence;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       setPartyId(Long.valueOf(str));
/*  58 */       str = tokens[2];
/*     */       
/*  60 */       setNoteSequence(Long.valueOf(str));
/*     */     }
/*  62 */     catch (Exception ee) {
/*  63 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  69 */     if (this == ob) {
/*  70 */       return true;
/*     */     }
/*  72 */     if (!(ob instanceof CustomerNoteId)) {
/*  73 */       return false;
/*     */     }
/*  75 */     CustomerNoteId other = (CustomerNoteId)ob;
/*  76 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  79 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/*  82 */       .equals(other._partyId))) && ((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/*  85 */       .equals(other._noteSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  92 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/*  93 */       .hashCode()) + ((this._noteSequence == null) ? 0 : this._noteSequence
/*  94 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  99 */     return "CustomerNote";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 106 */     return buff.append(
/* 107 */         String.valueOf(this._organizationId))
/* 108 */       .append("::").append(String.valueOf(this._partyId))
/* 109 */       .append("::").append(String.valueOf(this._noteSequence))
/* 110 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 114 */     if (this._partyId == null) {
/* 115 */       return false;
/*     */     }
/* 117 */     if (this._noteSequence == null) {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\CustomerNoteId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */