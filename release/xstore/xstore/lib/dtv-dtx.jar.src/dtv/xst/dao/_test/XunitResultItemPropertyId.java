/*     */ package dtv.xst.dao._test;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XunitResultItemPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 419773889L;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private Long _resultItemSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public XunitResultItemPropertyId() {}
/*     */   
/*     */   public XunitResultItemPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHostname() {
/*  32 */     return this._hostname;
/*     */   }
/*     */   
/*     */   public void setHostname(String argHostname) {
/*  36 */     this._hostname = (argHostname != null && MANAGE_CASE) ? argHostname.toUpperCase() : argHostname;
/*     */   }
/*     */   
/*     */   public Long getResultTimestamp() {
/*  40 */     return this._resultTimestamp;
/*     */   }
/*     */   
/*     */   public void setResultTimestamp(Long argResultTimestamp) {
/*  44 */     this._resultTimestamp = argResultTimestamp;
/*     */   }
/*     */   
/*     */   public Long getResultItemSequence() {
/*  48 */     return this._resultItemSequence;
/*     */   }
/*     */   
/*     */   public void setResultItemSequence(Long argResultItemSequence) {
/*  52 */     this._resultItemSequence = argResultItemSequence;
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
/*  76 */         setHostname((String)null);
/*     */       } else {
/*     */         
/*  79 */         setHostname(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       setResultTimestamp(Long.valueOf(str));
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setResultItemSequence(Long.valueOf(str));
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  96 */     } catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof XunitResultItemPropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     XunitResultItemPropertyId other = (XunitResultItemPropertyId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._hostname == null && other._hostname == null) || (this._hostname != null && this._hostname
/*     */ 
/*     */       
/* 116 */       .equals(other._hostname))) && ((this._resultTimestamp == null && other._resultTimestamp == null) || (this._resultTimestamp != null && this._resultTimestamp
/*     */ 
/*     */       
/* 119 */       .equals(other._resultTimestamp))) && ((this._resultItemSequence == null && other._resultItemSequence == null) || (this._resultItemSequence != null && this._resultItemSequence
/*     */ 
/*     */       
/* 122 */       .equals(other._resultItemSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._hostname == null) ? 0 : this._hostname
/* 133 */       .hashCode()) + ((this._resultTimestamp == null) ? 0 : this._resultTimestamp
/* 134 */       .hashCode()) + ((this._resultItemSequence == null) ? 0 : this._resultItemSequence
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "XunitResultItemProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(this._hostname)
/* 151 */       .append("::").append(String.valueOf(this._resultTimestamp))
/* 152 */       .append("::").append(String.valueOf(this._resultItemSequence))
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._hostname == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._resultTimestamp == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._resultItemSequence == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\XunitResultItemPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */