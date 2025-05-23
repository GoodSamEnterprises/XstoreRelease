/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ public class ReceiptTextPropertyId
/*     */   extends AbstractObjectId
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 476120154L;
/*     */   private String _textCode;
/*     */   private Integer _textSequence;
/*     */   private String _textSubcode;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   
/*     */   public IObjectId getObjectId() {
/*  21 */     return (IObjectId)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ReceiptTextPropertyId() {}
/*     */ 
/*     */   
/*     */   public ReceiptTextPropertyId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextCode() {
/*  39 */     return this._textCode;
/*     */   }
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/*  43 */     this._textCode = (argTextCode != null && MANAGE_CASE) ? argTextCode.toUpperCase() : argTextCode;
/*     */   }
/*     */   
/*     */   public Integer getTextSequence() {
/*  47 */     return this._textSequence;
/*     */   }
/*     */   
/*     */   public void setTextSequence(Integer argTextSequence) {
/*  51 */     this._textSequence = argTextSequence;
/*     */   }
/*     */   
/*     */   public String getTextSubcode() {
/*  55 */     return this._textSubcode;
/*     */   }
/*     */   
/*     */   public void setTextSubcode(String argTextSubcode) {
/*  59 */     this._textSubcode = (argTextSubcode != null && MANAGE_CASE) ? argTextSubcode.toUpperCase() : argTextSubcode;
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  63 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  67 */     this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  71 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  75 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  79 */     String str = argObjectIdValue;
/*  80 */     if (StringUtils.isEmpty(str)) {
/*  81 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  84 */       String[] tokens = str.split("::");
/*  85 */       str = tokens[0];
/*     */       
/*  87 */       setOrganizationId(Long.valueOf(str));
/*  88 */       str = tokens[1];
/*     */       
/*  90 */       if ("null".equals(str)) {
/*  91 */         setTextCode((String)null);
/*     */       } else {
/*     */         
/*  94 */         setTextCode(str);
/*     */       } 
/*  96 */       str = tokens[2];
/*     */       
/*  98 */       setTextSequence(Integer.valueOf(str));
/*  99 */       str = tokens[3];
/*     */       
/* 101 */       if ("null".equals(str)) {
/* 102 */         setTextSubcode((String)null);
/*     */       } else {
/*     */         
/* 105 */         setTextSubcode(str);
/*     */       } 
/* 107 */       str = tokens[4];
/*     */       
/* 109 */       if ("null".equals(str)) {
/* 110 */         setConfigElement((String)null);
/*     */       } else {
/*     */         
/* 113 */         setConfigElement(str);
/*     */       } 
/* 115 */       str = tokens[5];
/*     */       
/* 117 */       if ("null".equals(str)) {
/* 118 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 121 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 124 */     } catch (Exception ee) {
/* 125 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 131 */     if (this == ob) {
/* 132 */       return true;
/*     */     }
/* 134 */     if (!(ob instanceof ReceiptTextPropertyId)) {
/* 135 */       return false;
/*     */     }
/* 137 */     ReceiptTextPropertyId other = (ReceiptTextPropertyId)ob;
/* 138 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 141 */       .equals(other._organizationId))) && ((this._textCode == null && other._textCode == null) || (this._textCode != null && this._textCode
/*     */ 
/*     */       
/* 144 */       .equals(other._textCode))) && ((this._textSequence == null && other._textSequence == null) || (this._textSequence != null && this._textSequence
/*     */ 
/*     */       
/* 147 */       .equals(other._textSequence))) && ((this._textSubcode == null && other._textSubcode == null) || (this._textSubcode != null && this._textSubcode
/*     */ 
/*     */       
/* 150 */       .equals(other._textSubcode))) && ((this._configElement == null && other._configElement == null) || (this._configElement != null && this._configElement
/*     */ 
/*     */       
/* 153 */       .equals(other._configElement))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 156 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 162 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 163 */       .hashCode()) + ((this._textCode == null) ? 0 : this._textCode
/* 164 */       .hashCode()) + ((this._textSequence == null) ? 0 : this._textSequence
/* 165 */       .hashCode()) + ((this._textSubcode == null) ? 0 : this._textSubcode
/* 166 */       .hashCode()) + ((this._configElement == null) ? 0 : this._configElement
/* 167 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 168 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 173 */     return "ReceiptTextProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 178 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 180 */     return buff.append(
/* 181 */         String.valueOf(this._organizationId))
/* 182 */       .append("::").append(this._textCode)
/* 183 */       .append("::").append(String.valueOf(this._textSequence))
/* 184 */       .append("::").append(this._textSubcode)
/* 185 */       .append("::").append(this._configElement)
/* 186 */       .append("::").append(this._propertyCode)
/* 187 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 191 */     if (this._textCode == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._textSequence == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._textSubcode == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._configElement == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._propertyCode == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ReceiptTextPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */