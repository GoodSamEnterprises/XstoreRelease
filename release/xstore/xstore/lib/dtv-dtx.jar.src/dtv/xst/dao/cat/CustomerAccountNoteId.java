/*     */ package dtv.xst.dao.cat;
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
/*     */ public class CustomerAccountNoteId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1544669409L;
/*     */   private Long _noteSequence;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   
/*     */   public CustomerAccountNoteId() {}
/*     */   
/*     */   public CustomerAccountNoteId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getNoteSequence() {
/*  31 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  35 */     this._noteSequence = argNoteSequence;
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  39 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  43 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  47 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  51 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
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
/*  63 */       setNoteSequence(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       setOrganizationId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setCustAccountId(str);
/*     */       } 
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setCustAccountCode(str);
/*     */       }
/*     */     
/*  84 */     } catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof CustomerAccountNoteId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     CustomerAccountNoteId other = (CustomerAccountNoteId)ob;
/*  98 */     return (((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/* 101 */       .equals(other._noteSequence))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 104 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 107 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 110 */       .equals(other._custAccountCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._noteSequence == null) ? 0 : this._noteSequence
/* 117 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 118 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 119 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "CustomerAccountNote";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._noteSequence))
/* 134 */       .append("::").append(String.valueOf(this._organizationId))
/* 135 */       .append("::").append(this._custAccountId)
/* 136 */       .append("::").append(this._custAccountCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._noteSequence == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._custAccountId == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._custAccountCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\CustomerAccountNoteId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */