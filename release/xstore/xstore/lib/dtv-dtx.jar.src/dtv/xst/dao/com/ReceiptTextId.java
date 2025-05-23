/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ public class ReceiptTextId
/*     */   extends AbstractObjectId
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -593496219L;
/*     */   private String _textCode;
/*     */   private Integer _textSequence;
/*     */   private String _textSubcode;
/*     */   private String _configElement;
/*     */   
/*     */   public IObjectId getObjectId() {
/*  21 */     return (IObjectId)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ReceiptTextId() {}
/*     */ 
/*     */   
/*     */   public ReceiptTextId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextCode() {
/*  38 */     return this._textCode;
/*     */   }
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/*  42 */     this._textCode = (argTextCode != null && MANAGE_CASE) ? argTextCode.toUpperCase() : argTextCode;
/*     */   }
/*     */   
/*     */   public Integer getTextSequence() {
/*  46 */     return this._textSequence;
/*     */   }
/*     */   
/*     */   public void setTextSequence(Integer argTextSequence) {
/*  50 */     this._textSequence = argTextSequence;
/*     */   }
/*     */   
/*     */   public String getTextSubcode() {
/*  54 */     return this._textSubcode;
/*     */   }
/*     */   
/*     */   public void setTextSubcode(String argTextSubcode) {
/*  58 */     this._textSubcode = (argTextSubcode != null && MANAGE_CASE) ? argTextSubcode.toUpperCase() : argTextSubcode;
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  62 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  66 */     this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  70 */     String str = argObjectIdValue;
/*  71 */     if (StringUtils.isEmpty(str)) {
/*  72 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  75 */       String[] tokens = str.split("::");
/*  76 */       str = tokens[0];
/*     */       
/*  78 */       setOrganizationId(Long.valueOf(str));
/*  79 */       str = tokens[1];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setTextCode((String)null);
/*     */       } else {
/*     */         
/*  85 */         setTextCode(str);
/*     */       } 
/*  87 */       str = tokens[2];
/*     */       
/*  89 */       setTextSequence(Integer.valueOf(str));
/*  90 */       str = tokens[3];
/*     */       
/*  92 */       if ("null".equals(str)) {
/*  93 */         setTextSubcode((String)null);
/*     */       } else {
/*     */         
/*  96 */         setTextSubcode(str);
/*     */       } 
/*  98 */       str = tokens[4];
/*     */       
/* 100 */       if ("null".equals(str)) {
/* 101 */         setConfigElement((String)null);
/*     */       } else {
/*     */         
/* 104 */         setConfigElement(str);
/*     */       }
/*     */     
/* 107 */     } catch (Exception ee) {
/* 108 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 114 */     if (this == ob) {
/* 115 */       return true;
/*     */     }
/* 117 */     if (!(ob instanceof ReceiptTextId)) {
/* 118 */       return false;
/*     */     }
/* 120 */     ReceiptTextId other = (ReceiptTextId)ob;
/* 121 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 124 */       .equals(other._organizationId))) && ((this._textCode == null && other._textCode == null) || (this._textCode != null && this._textCode
/*     */ 
/*     */       
/* 127 */       .equals(other._textCode))) && ((this._textSequence == null && other._textSequence == null) || (this._textSequence != null && this._textSequence
/*     */ 
/*     */       
/* 130 */       .equals(other._textSequence))) && ((this._textSubcode == null && other._textSubcode == null) || (this._textSubcode != null && this._textSubcode
/*     */ 
/*     */       
/* 133 */       .equals(other._textSubcode))) && ((this._configElement == null && other._configElement == null) || (this._configElement != null && this._configElement
/*     */ 
/*     */       
/* 136 */       .equals(other._configElement))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 142 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 143 */       .hashCode()) + ((this._textCode == null) ? 0 : this._textCode
/* 144 */       .hashCode()) + ((this._textSequence == null) ? 0 : this._textSequence
/* 145 */       .hashCode()) + ((this._textSubcode == null) ? 0 : this._textSubcode
/* 146 */       .hashCode()) + ((this._configElement == null) ? 0 : this._configElement
/* 147 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 152 */     return "ReceiptText";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 157 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 159 */     return buff.append(
/* 160 */         String.valueOf(this._organizationId))
/* 161 */       .append("::").append(this._textCode)
/* 162 */       .append("::").append(String.valueOf(this._textSequence))
/* 163 */       .append("::").append(this._textSubcode)
/* 164 */       .append("::").append(this._configElement)
/* 165 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 169 */     if (this._textCode == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._textSequence == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (this._textSubcode == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._configElement == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ReceiptTextId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */