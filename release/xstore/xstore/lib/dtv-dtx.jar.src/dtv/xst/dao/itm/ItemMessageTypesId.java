/*     */ package dtv.xst.dao.itm;
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
/*     */ public class ItemMessageTypesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1893294981L;
/*     */   private String _messageId;
/*     */   private String _lineItemType;
/*     */   
/*     */   public ItemMessageTypesId() {}
/*     */   
/*     */   public ItemMessageTypesId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageId() {
/*  30 */     return this._messageId;
/*     */   }
/*     */   
/*     */   public void setMessageId(String argMessageId) {
/*  34 */     this._messageId = (argMessageId != null && MANAGE_CASE) ? argMessageId.toUpperCase() : argMessageId;
/*     */   }
/*     */   
/*     */   public String getLineItemType() {
/*  38 */     return this._lineItemType;
/*     */   }
/*     */   
/*     */   public void setLineItemType(String argLineItemType) {
/*  42 */     this._lineItemType = (argLineItemType != null && MANAGE_CASE) ? argLineItemType.toUpperCase() : argLineItemType;
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
/*  54 */       if ("null".equals(str)) {
/*  55 */         setMessageId((String)null);
/*     */       } else {
/*     */         
/*  58 */         setMessageId(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setLineItemType((String)null);
/*     */       } else {
/*     */         
/*  69 */         setLineItemType(str);
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
/*  82 */     if (!(ob instanceof ItemMessageTypesId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     ItemMessageTypesId other = (ItemMessageTypesId)ob;
/*  86 */     return (((this._messageId == null && other._messageId == null) || (this._messageId != null && this._messageId
/*     */ 
/*     */       
/*  89 */       .equals(other._messageId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._lineItemType == null && other._lineItemType == null) || (this._lineItemType != null && this._lineItemType
/*     */ 
/*     */       
/*  95 */       .equals(other._lineItemType))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._messageId == null) ? 0 : this._messageId
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._lineItemType == null) ? 0 : this._lineItemType
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "ItemMessageTypes";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._messageId)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._lineItemType)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._messageId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._lineItemType == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemMessageTypesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */