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
/*     */ public class InvoiceLineItemId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1194092372L;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private Integer _invoiceLineItemSequence;
/*     */   
/*     */   public InvoiceLineItemId() {}
/*     */   
/*     */   public InvoiceLineItemId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceLocationId() {
/*  31 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/*  35 */     this._serviceLocationId = (argServiceLocationId != null && MANAGE_CASE) ? argServiceLocationId.toUpperCase() : argServiceLocationId;
/*     */   }
/*     */   
/*     */   public String getInvoiceNumber() {
/*  39 */     return this._invoiceNumber;
/*     */   }
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/*  43 */     this._invoiceNumber = (argInvoiceNumber != null && MANAGE_CASE) ? argInvoiceNumber.toUpperCase() : argInvoiceNumber;
/*     */   }
/*     */   
/*     */   public Integer getInvoiceLineItemSequence() {
/*  47 */     return this._invoiceLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setInvoiceLineItemSequence(Integer argInvoiceLineItemSequence) {
/*  51 */     this._invoiceLineItemSequence = argInvoiceLineItemSequence;
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
/*  67 */         setServiceLocationId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setServiceLocationId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setInvoiceNumber((String)null);
/*     */       } else {
/*     */         
/*  78 */         setInvoiceNumber(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setInvoiceLineItemSequence(Integer.valueOf(str));
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
/*  94 */     if (!(ob instanceof InvoiceLineItemId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     InvoiceLineItemId other = (InvoiceLineItemId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._serviceLocationId == null && other._serviceLocationId == null) || (this._serviceLocationId != null && this._serviceLocationId
/*     */ 
/*     */       
/* 104 */       .equals(other._serviceLocationId))) && ((this._invoiceNumber == null && other._invoiceNumber == null) || (this._invoiceNumber != null && this._invoiceNumber
/*     */ 
/*     */       
/* 107 */       .equals(other._invoiceNumber))) && ((this._invoiceLineItemSequence == null && other._invoiceLineItemSequence == null) || (this._invoiceLineItemSequence != null && this._invoiceLineItemSequence
/*     */ 
/*     */       
/* 110 */       .equals(other._invoiceLineItemSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._serviceLocationId == null) ? 0 : this._serviceLocationId
/* 118 */       .hashCode()) + ((this._invoiceNumber == null) ? 0 : this._invoiceNumber
/* 119 */       .hashCode()) + ((this._invoiceLineItemSequence == null) ? 0 : this._invoiceLineItemSequence
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "InvoiceLineItem";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._serviceLocationId)
/* 135 */       .append("::").append(this._invoiceNumber)
/* 136 */       .append("::").append(String.valueOf(this._invoiceLineItemSequence))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._serviceLocationId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._invoiceNumber == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._invoiceLineItemSequence == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\InvoiceLineItemId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */