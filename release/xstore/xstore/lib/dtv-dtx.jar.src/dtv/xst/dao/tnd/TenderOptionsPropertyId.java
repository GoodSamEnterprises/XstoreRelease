/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderOptionsPropertyId
/*     */   extends AbstractObjectId
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -1538401025L;
/*     */   private String _tenderId;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   
/*     */   public IObjectId getObjectId() {
/*  21 */     return (IObjectId)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TenderOptionsPropertyId() {}
/*     */ 
/*     */   
/*     */   public TenderOptionsPropertyId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/*  37 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  41 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  45 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  49 */     this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  53 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  57 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  61 */     String str = argObjectIdValue;
/*  62 */     if (StringUtils.isEmpty(str)) {
/*  63 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  66 */       String[] tokens = str.split("::");
/*  67 */       str = tokens[0];
/*     */       
/*  69 */       setOrganizationId(Long.valueOf(str));
/*  70 */       str = tokens[1];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/*  76 */         setTenderId(str);
/*     */       } 
/*  78 */       str = tokens[2];
/*     */       
/*  80 */       if ("null".equals(str)) {
/*  81 */         setConfigElement((String)null);
/*     */       } else {
/*     */         
/*  84 */         setConfigElement(str);
/*     */       } 
/*  86 */       str = tokens[3];
/*     */       
/*  88 */       if ("null".equals(str)) {
/*  89 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  92 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  95 */     } catch (Exception ee) {
/*  96 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 102 */     if (this == ob) {
/* 103 */       return true;
/*     */     }
/* 105 */     if (!(ob instanceof TenderOptionsPropertyId)) {
/* 106 */       return false;
/*     */     }
/* 108 */     TenderOptionsPropertyId other = (TenderOptionsPropertyId)ob;
/* 109 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 112 */       .equals(other._organizationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/* 115 */       .equals(other._tenderId))) && ((this._configElement == null && other._configElement == null) || (this._configElement != null && this._configElement
/*     */ 
/*     */       
/* 118 */       .equals(other._configElement))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 121 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 127 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 128 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 129 */       .hashCode()) + ((this._configElement == null) ? 0 : this._configElement
/* 130 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 131 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 136 */     return "TenderOptionsProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 143 */     return buff.append(
/* 144 */         String.valueOf(this._organizationId))
/* 145 */       .append("::").append(this._tenderId)
/* 146 */       .append("::").append(this._configElement)
/* 147 */       .append("::").append(this._propertyCode)
/* 148 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 152 */     if (this._tenderId == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     if (this._configElement == null) {
/* 156 */       return false;
/*     */     }
/* 158 */     if (this._propertyCode == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderOptionsPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */