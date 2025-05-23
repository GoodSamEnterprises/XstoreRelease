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
/*     */ public class InvoiceLineItemPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1391596873L;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private Integer _invoiceLineItemSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InvoiceLineItemPropertyId() {}
/*     */   
/*     */   public InvoiceLineItemPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceLocationId() {
/*  32 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/*  36 */     this._serviceLocationId = (argServiceLocationId != null && MANAGE_CASE) ? argServiceLocationId.toUpperCase() : argServiceLocationId;
/*     */   }
/*     */   
/*     */   public String getInvoiceNumber() {
/*  40 */     return this._invoiceNumber;
/*     */   }
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/*  44 */     this._invoiceNumber = (argInvoiceNumber != null && MANAGE_CASE) ? argInvoiceNumber.toUpperCase() : argInvoiceNumber;
/*     */   }
/*     */   
/*     */   public Integer getInvoiceLineItemSequence() {
/*  48 */     return this._invoiceLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setInvoiceLineItemSequence(Integer argInvoiceLineItemSequence) {
/*  52 */     this._invoiceLineItemSequence = argInvoiceLineItemSequence;
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
/*  76 */         setServiceLocationId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setServiceLocationId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setInvoiceNumber((String)null);
/*     */       } else {
/*     */         
/*  87 */         setInvoiceNumber(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setInvoiceLineItemSequence(Integer.valueOf(str));
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
/* 111 */     if (!(ob instanceof InvoiceLineItemPropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     InvoiceLineItemPropertyId other = (InvoiceLineItemPropertyId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._serviceLocationId == null && other._serviceLocationId == null) || (this._serviceLocationId != null && this._serviceLocationId
/*     */ 
/*     */       
/* 121 */       .equals(other._serviceLocationId))) && ((this._invoiceNumber == null && other._invoiceNumber == null) || (this._invoiceNumber != null && this._invoiceNumber
/*     */ 
/*     */       
/* 124 */       .equals(other._invoiceNumber))) && ((this._invoiceLineItemSequence == null && other._invoiceLineItemSequence == null) || (this._invoiceLineItemSequence != null && this._invoiceLineItemSequence
/*     */ 
/*     */       
/* 127 */       .equals(other._invoiceLineItemSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._serviceLocationId == null) ? 0 : this._serviceLocationId
/* 138 */       .hashCode()) + ((this._invoiceNumber == null) ? 0 : this._invoiceNumber
/* 139 */       .hashCode()) + ((this._invoiceLineItemSequence == null) ? 0 : this._invoiceLineItemSequence
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "InvoiceLineItemProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(this._serviceLocationId)
/* 156 */       .append("::").append(this._invoiceNumber)
/* 157 */       .append("::").append(String.valueOf(this._invoiceLineItemSequence))
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._serviceLocationId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._invoiceNumber == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._invoiceLineItemSequence == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\InvoiceLineItemPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */