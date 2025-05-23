/*     */ package dtv.xst.dao.trn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class PosTransactionLinkPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1196197145L;
/*     */   private DtvDate _businessDate;
/*     */   private DtvDate _linkBusinessDate;
/*     */   private Long _linkRetailLocationId;
/*     */   private Long _linkTransactionSequence;
/*     */   private Long _linkWorkstationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PosTransactionLinkPropertyId() {}
/*     */   
/*     */   public PosTransactionLinkPropertyId(String argObjectIdValue) {
/*  27 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  41 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  45 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLinkBusinessDate() {
/*  50 */     return (Date)this._linkBusinessDate;
/*     */   }
/*     */   
/*     */   public void setLinkBusinessDate(Date argLinkBusinessDate) {
/*  54 */     this._linkBusinessDate = (argLinkBusinessDate == null || argLinkBusinessDate instanceof DtvDate) ? (DtvDate)argLinkBusinessDate : new DtvDate(argLinkBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getLinkRetailLocationId() {
/*  59 */     return this._linkRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setLinkRetailLocationId(Long argLinkRetailLocationId) {
/*  63 */     this._linkRetailLocationId = argLinkRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getLinkTransactionSequence() {
/*  67 */     return this._linkTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setLinkTransactionSequence(Long argLinkTransactionSequence) {
/*  71 */     this._linkTransactionSequence = argLinkTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getLinkWorkstationId() {
/*  75 */     return this._linkWorkstationId;
/*     */   }
/*     */   
/*     */   public void setLinkWorkstationId(Long argLinkWorkstationId) {
/*  79 */     this._linkWorkstationId = argLinkWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  83 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  87 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  91 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  95 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  99 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 103 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 107 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 111 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/* 115 */     String str = argObjectIdValue;
/* 116 */     if (StringUtils.isEmpty(str)) {
/* 117 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 120 */       String[] tokens = str.split("::");
/* 121 */       str = tokens[0];
/*     */       
/* 123 */       if ("null".equals(str)) {
/* 124 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 127 */         setBusinessDate((Date)new DtvDate());
/* 128 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 130 */       str = tokens[1];
/*     */       
/* 132 */       if ("null".equals(str)) {
/* 133 */         setLinkBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 136 */         setLinkBusinessDate((Date)new DtvDate());
/* 137 */         this._linkBusinessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 139 */       str = tokens[2];
/*     */       
/* 141 */       setLinkRetailLocationId(Long.valueOf(str));
/* 142 */       str = tokens[3];
/*     */       
/* 144 */       setLinkTransactionSequence(Long.valueOf(str));
/* 145 */       str = tokens[4];
/*     */       
/* 147 */       setLinkWorkstationId(Long.valueOf(str));
/* 148 */       str = tokens[5];
/*     */       
/* 150 */       setOrganizationId(Long.valueOf(str));
/* 151 */       str = tokens[6];
/*     */       
/* 153 */       setRetailLocationId(Long.valueOf(str));
/* 154 */       str = tokens[7];
/*     */       
/* 156 */       setTransactionSequence(Long.valueOf(str));
/* 157 */       str = tokens[8];
/*     */       
/* 159 */       setWorkstationId(Long.valueOf(str));
/* 160 */       str = tokens[9];
/*     */       
/* 162 */       if ("null".equals(str)) {
/* 163 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 166 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 169 */     } catch (Exception ee) {
/* 170 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 176 */     if (this == ob) {
/* 177 */       return true;
/*     */     }
/* 179 */     if (!(ob instanceof PosTransactionLinkPropertyId)) {
/* 180 */       return false;
/*     */     }
/* 182 */     PosTransactionLinkPropertyId other = (PosTransactionLinkPropertyId)ob;
/* 183 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 186 */       .equals(other._businessDate))) && ((this._linkBusinessDate == null && other._linkBusinessDate == null) || (this._linkBusinessDate != null && this._linkBusinessDate
/*     */ 
/*     */       
/* 189 */       .equals(other._linkBusinessDate))) && ((this._linkRetailLocationId == null && other._linkRetailLocationId == null) || (this._linkRetailLocationId != null && this._linkRetailLocationId
/*     */ 
/*     */       
/* 192 */       .equals(other._linkRetailLocationId))) && ((this._linkTransactionSequence == null && other._linkTransactionSequence == null) || (this._linkTransactionSequence != null && this._linkTransactionSequence
/*     */ 
/*     */       
/* 195 */       .equals(other._linkTransactionSequence))) && ((this._linkWorkstationId == null && other._linkWorkstationId == null) || (this._linkWorkstationId != null && this._linkWorkstationId
/*     */ 
/*     */       
/* 198 */       .equals(other._linkWorkstationId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 201 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 204 */       .equals(other._retailLocationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 207 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 210 */       .equals(other._workstationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 213 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 219 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 220 */       .hashCode()) + ((this._linkBusinessDate == null) ? 0 : this._linkBusinessDate
/* 221 */       .hashCode()) + ((this._linkRetailLocationId == null) ? 0 : this._linkRetailLocationId
/* 222 */       .hashCode()) + ((this._linkTransactionSequence == null) ? 0 : this._linkTransactionSequence
/* 223 */       .hashCode()) + ((this._linkWorkstationId == null) ? 0 : this._linkWorkstationId
/* 224 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 225 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 226 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 227 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 228 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 229 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 234 */     return "PosTransactionLinkProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 239 */     StringBuilder buff = new StringBuilder(120);
/*     */     
/* 241 */     return buff.append((this._businessDate == null) ? "null" : 
/* 242 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 243 */       .append("::").append((this._linkBusinessDate == null) ? "null" : String.valueOf(this._linkBusinessDate.getTimeSerializable()))
/* 244 */       .append("::").append(String.valueOf(this._linkRetailLocationId))
/* 245 */       .append("::").append(String.valueOf(this._linkTransactionSequence))
/* 246 */       .append("::").append(String.valueOf(this._linkWorkstationId))
/* 247 */       .append("::").append(String.valueOf(this._organizationId))
/* 248 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 249 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 250 */       .append("::").append(String.valueOf(this._workstationId))
/* 251 */       .append("::").append(this._propertyCode)
/* 252 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 256 */     if (this._businessDate == null) {
/* 257 */       return false;
/*     */     }
/* 259 */     if (this._linkBusinessDate == null) {
/* 260 */       return false;
/*     */     }
/* 262 */     if (this._linkRetailLocationId == null) {
/* 263 */       return false;
/*     */     }
/* 265 */     if (this._linkTransactionSequence == null) {
/* 266 */       return false;
/*     */     }
/* 268 */     if (this._linkWorkstationId == null) {
/* 269 */       return false;
/*     */     }
/* 271 */     if (this._retailLocationId == null) {
/* 272 */       return false;
/*     */     }
/* 274 */     if (this._transactionSequence == null) {
/* 275 */       return false;
/*     */     }
/* 277 */     if (this._workstationId == null) {
/* 278 */       return false;
/*     */     }
/* 280 */     if (this._propertyCode == null) {
/* 281 */       return false;
/*     */     }
/* 283 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\PosTransactionLinkPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */