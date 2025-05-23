/*     */ package dtv.xst.dao.trl;
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
/*     */ 
/*     */ public class LineItemAssociationTypeCodeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 326133537L;
/*     */   private String _lineItemAssociationTypeCode;
/*     */   
/*     */   public LineItemAssociationTypeCodeId() {}
/*     */   
/*     */   public LineItemAssociationTypeCodeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineItemAssociationTypeCode() {
/*  29 */     return this._lineItemAssociationTypeCode;
/*     */   }
/*     */   
/*     */   public void setLineItemAssociationTypeCode(String argLineItemAssociationTypeCode) {
/*  33 */     this._lineItemAssociationTypeCode = (argLineItemAssociationTypeCode != null && MANAGE_CASE) ? argLineItemAssociationTypeCode.toUpperCase() : argLineItemAssociationTypeCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  37 */     String str = argObjectIdValue;
/*  38 */     if (StringUtils.isEmpty(str)) {
/*  39 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  42 */       String[] tokens = str.split("::");
/*  43 */       str = tokens[0];
/*     */       
/*  45 */       if ("null".equals(str)) {
/*  46 */         setLineItemAssociationTypeCode((String)null);
/*     */       } else {
/*     */         
/*  49 */         setLineItemAssociationTypeCode(str);
/*     */       } 
/*  51 */       str = tokens[1];
/*     */       
/*  53 */       setOrganizationId(Long.valueOf(str));
/*     */     }
/*  55 */     catch (Exception ee) {
/*  56 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  62 */     if (this == ob) {
/*  63 */       return true;
/*     */     }
/*  65 */     if (!(ob instanceof LineItemAssociationTypeCodeId)) {
/*  66 */       return false;
/*     */     }
/*  68 */     LineItemAssociationTypeCodeId other = (LineItemAssociationTypeCodeId)ob;
/*  69 */     return (((this._lineItemAssociationTypeCode == null && other._lineItemAssociationTypeCode == null) || (this._lineItemAssociationTypeCode != null && this._lineItemAssociationTypeCode
/*     */ 
/*     */       
/*  72 */       .equals(other._lineItemAssociationTypeCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  75 */       .equals(other._organizationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  81 */     return ((this._lineItemAssociationTypeCode == null) ? 0 : this._lineItemAssociationTypeCode
/*  82 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/*  83 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  88 */     return "LineItemAssociationTypeCode";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  95 */     return buff.append(this._lineItemAssociationTypeCode)
/*     */       
/*  97 */       .append("::").append(String.valueOf(this._organizationId))
/*  98 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 102 */     if (this._lineItemAssociationTypeCode == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\LineItemAssociationTypeCodeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */