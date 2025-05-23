/*     */ package dtv.xst.dao.prc;
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
/*     */ public class DealCustomerGroupsPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1159585037L;
/*     */   private String _dealId;
/*     */   private String _customerGroupId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DealCustomerGroupsPropertyId() {}
/*     */   
/*     */   public DealCustomerGroupsPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  31 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  35 */     this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */   }
/*     */   
/*     */   public String getCustomerGroupId() {
/*  39 */     return this._customerGroupId;
/*     */   }
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/*  43 */     this._customerGroupId = (argCustomerGroupId != null && MANAGE_CASE) ? argCustomerGroupId.toUpperCase() : argCustomerGroupId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  63 */       if ("null".equals(str)) {
/*  64 */         setDealId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setDealId(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       setOrganizationId(Long.valueOf(str));
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setCustomerGroupId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setCustomerGroupId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof DealCustomerGroupsPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     DealCustomerGroupsPropertyId other = (DealCustomerGroupsPropertyId)ob;
/* 103 */     return (((this._dealId == null && other._dealId == null) || (this._dealId != null && this._dealId
/*     */ 
/*     */       
/* 106 */       .equals(other._dealId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 109 */       .equals(other._organizationId))) && ((this._customerGroupId == null && other._customerGroupId == null) || (this._customerGroupId != null && this._customerGroupId
/*     */ 
/*     */       
/* 112 */       .equals(other._customerGroupId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._dealId == null) ? 0 : this._dealId
/* 122 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 123 */       .hashCode()) + ((this._customerGroupId == null) ? 0 : this._customerGroupId
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "DealCustomerGroupsProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._dealId)
/*     */       
/* 139 */       .append("::").append(String.valueOf(this._organizationId))
/* 140 */       .append("::").append(this._customerGroupId)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._dealId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._customerGroupId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\DealCustomerGroupsPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */