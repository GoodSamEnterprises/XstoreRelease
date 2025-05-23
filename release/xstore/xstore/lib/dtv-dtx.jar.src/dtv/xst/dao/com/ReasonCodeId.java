/*     */ package dtv.xst.dao.com;
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
/*     */ public class ReasonCodeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1579364751L;
/*     */   private String _reasonTypeCode;
/*     */   private String _reasonCode;
/*     */   
/*     */   public ReasonCodeId() {}
/*     */   
/*     */   public ReasonCodeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonTypeCode() {
/*  30 */     return this._reasonTypeCode;
/*     */   }
/*     */   
/*     */   public void setReasonTypeCode(String argReasonTypeCode) {
/*  34 */     this._reasonTypeCode = (argReasonTypeCode != null && MANAGE_CASE) ? argReasonTypeCode.toUpperCase() : argReasonTypeCode;
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/*  38 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/*  42 */     this._reasonCode = (argReasonCode != null && MANAGE_CASE) ? argReasonCode.toUpperCase() : argReasonCode;
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
/*  57 */       if ("null".equals(str)) {
/*  58 */         setReasonTypeCode((String)null);
/*     */       } else {
/*     */         
/*  61 */         setReasonTypeCode(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setReasonCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setReasonCode(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof ReasonCodeId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     ReasonCodeId other = (ReasonCodeId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._reasonTypeCode == null && other._reasonTypeCode == null) || (this._reasonTypeCode != null && this._reasonTypeCode
/*     */ 
/*     */       
/*  92 */       .equals(other._reasonTypeCode))) && ((this._reasonCode == null && other._reasonCode == null) || (this._reasonCode != null && this._reasonCode
/*     */ 
/*     */       
/*  95 */       .equals(other._reasonCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._reasonTypeCode == null) ? 0 : this._reasonTypeCode
/* 103 */       .hashCode()) + ((this._reasonCode == null) ? 0 : this._reasonCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "ReasonCode";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._reasonTypeCode)
/* 119 */       .append("::").append(this._reasonCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._reasonTypeCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._reasonCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ReasonCodeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */