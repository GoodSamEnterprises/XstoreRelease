/*     */ package dtv.xst.dao.cwo;
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
/*     */ public class WorkItemId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 99166692L;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Integer _workItemSequence;
/*     */   
/*     */   public WorkItemId() {}
/*     */   
/*     */   public WorkItemId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  31 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  35 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  39 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  43 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */   }
/*     */   
/*     */   public Integer getWorkItemSequence() {
/*  47 */     return this._workItemSequence;
/*     */   }
/*     */   
/*     */   public void setWorkItemSequence(Integer argWorkItemSequence) {
/*  51 */     this._workItemSequence = argWorkItemSequence;
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
/*  67 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCustAccountId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setCustAccountCode(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setWorkItemSequence(Integer.valueOf(str));
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
/*  94 */     if (!(ob instanceof WorkItemId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     WorkItemId other = (WorkItemId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 104 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 107 */       .equals(other._custAccountCode))) && ((this._workItemSequence == null && other._workItemSequence == null) || (this._workItemSequence != null && this._workItemSequence
/*     */ 
/*     */       
/* 110 */       .equals(other._workItemSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 118 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 119 */       .hashCode()) + ((this._workItemSequence == null) ? 0 : this._workItemSequence
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "WorkItem";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._custAccountId)
/* 135 */       .append("::").append(this._custAccountCode)
/* 136 */       .append("::").append(String.valueOf(this._workItemSequence))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._custAccountId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._custAccountCode == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._workItemSequence == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\WorkItemId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */