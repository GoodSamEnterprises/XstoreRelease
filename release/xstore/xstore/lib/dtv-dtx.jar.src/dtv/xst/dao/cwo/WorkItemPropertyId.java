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
/*     */ public class WorkItemPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -666155047L;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Integer _workItemSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public WorkItemPropertyId() {}
/*     */   
/*     */   public WorkItemPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  32 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  36 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  40 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  44 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */   }
/*     */   
/*     */   public Integer getWorkItemSequence() {
/*  48 */     return this._workItemSequence;
/*     */   }
/*     */   
/*     */   public void setWorkItemSequence(Integer argWorkItemSequence) {
/*  52 */     this._workItemSequence = argWorkItemSequence;
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
/*  76 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setCustAccountId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  87 */         setCustAccountCode(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setWorkItemSequence(Integer.valueOf(str));
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
/* 111 */     if (!(ob instanceof WorkItemPropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     WorkItemPropertyId other = (WorkItemPropertyId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 121 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 124 */       .equals(other._custAccountCode))) && ((this._workItemSequence == null && other._workItemSequence == null) || (this._workItemSequence != null && this._workItemSequence
/*     */ 
/*     */       
/* 127 */       .equals(other._workItemSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 138 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 139 */       .hashCode()) + ((this._workItemSequence == null) ? 0 : this._workItemSequence
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "WorkItemProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(this._custAccountId)
/* 156 */       .append("::").append(this._custAccountCode)
/* 157 */       .append("::").append(String.valueOf(this._workItemSequence))
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._custAccountId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._custAccountCode == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._workItemSequence == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\WorkItemPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */