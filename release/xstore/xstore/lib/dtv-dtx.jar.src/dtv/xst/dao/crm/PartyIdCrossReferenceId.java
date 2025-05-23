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
/*     */ public class PartyIdCrossReferenceId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1914929100L;
/*     */   private Long _partyId;
/*     */   private String _alternateIdOwner;
/*     */   
/*     */   public PartyIdCrossReferenceId() {}
/*     */   
/*     */   public PartyIdCrossReferenceId(String argObjectIdValue) {
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
/*     */   public String getAlternateIdOwner() {
/*  38 */     return this._alternateIdOwner;
/*     */   }
/*     */   
/*     */   public void setAlternateIdOwner(String argAlternateIdOwner) {
/*  42 */     this._alternateIdOwner = (argAlternateIdOwner != null && MANAGE_CASE) ? argAlternateIdOwner.toUpperCase() : argAlternateIdOwner;
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
/*  60 */       if ("null".equals(str)) {
/*  61 */         setAlternateIdOwner((String)null);
/*     */       } else {
/*     */         
/*  64 */         setAlternateIdOwner(str);
/*     */       }
/*     */     
/*  67 */     } catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof PartyIdCrossReferenceId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     PartyIdCrossReferenceId other = (PartyIdCrossReferenceId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/*  87 */       .equals(other._partyId))) && ((this._alternateIdOwner == null && other._alternateIdOwner == null) || (this._alternateIdOwner != null && this._alternateIdOwner
/*     */ 
/*     */       
/*  90 */       .equals(other._alternateIdOwner))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/*  98 */       .hashCode()) + ((this._alternateIdOwner == null) ? 0 : this._alternateIdOwner
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "PartyIdCrossReference";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(String.valueOf(this._partyId))
/* 114 */       .append("::").append(this._alternateIdOwner)
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._partyId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._alternateIdOwner == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\PartyIdCrossReferenceId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */