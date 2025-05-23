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
/*     */ 
/*     */ public class CustomerAccountPlanId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1544725528L;
/*     */   private String _custAccountCode;
/*     */   private String _planId;
/*     */   
/*     */   public CustomerAccountPlanId() {}
/*     */   
/*     */   public CustomerAccountPlanId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/*  30 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  34 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */   }
/*     */   
/*     */   public String getPlanId() {
/*  38 */     return this._planId;
/*     */   }
/*     */   
/*     */   public void setPlanId(String argPlanId) {
/*  42 */     this._planId = (argPlanId != null && MANAGE_CASE) ? argPlanId.toUpperCase() : argPlanId;
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
/*  58 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  61 */         setCustAccountCode(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setPlanId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setPlanId(str);
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
/*  82 */     if (!(ob instanceof CustomerAccountPlanId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     CustomerAccountPlanId other = (CustomerAccountPlanId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/*  92 */       .equals(other._custAccountCode))) && ((this._planId == null && other._planId == null) || (this._planId != null && this._planId
/*     */ 
/*     */       
/*  95 */       .equals(other._planId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 103 */       .hashCode()) + ((this._planId == null) ? 0 : this._planId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "CustomerAccountPlan";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._custAccountCode)
/* 119 */       .append("::").append(this._planId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._custAccountCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._planId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\CustomerAccountPlanId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */