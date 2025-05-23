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
/*     */ public class PartyEmailId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1846281098L;
/*     */   private Long _partyId;
/*     */   private Integer _sequence;
/*     */   
/*     */   public PartyEmailId() {}
/*     */   
/*     */   public PartyEmailId(String argObjectIdValue) {
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
/*     */   public Integer getSequence() {
/*  38 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  42 */     this._sequence = argSequence;
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
/*  60 */       setSequence(Integer.valueOf(str));
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
/*  72 */     if (!(ob instanceof PartyEmailId)) {
/*  73 */       return false;
/*     */     }
/*  75 */     PartyEmailId other = (PartyEmailId)ob;
/*  76 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  79 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/*  82 */       .equals(other._partyId))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/*  85 */       .equals(other._sequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  92 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/*  93 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/*  94 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  99 */     return "PartyEmail";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 106 */     return buff.append(
/* 107 */         String.valueOf(this._organizationId))
/* 108 */       .append("::").append(String.valueOf(this._partyId))
/* 109 */       .append("::").append(String.valueOf(this._sequence))
/* 110 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 114 */     if (this._partyId == null) {
/* 115 */       return false;
/*     */     }
/* 117 */     if (this._sequence == null) {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\PartyEmailId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */