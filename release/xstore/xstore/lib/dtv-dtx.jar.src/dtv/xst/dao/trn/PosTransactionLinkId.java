/*     */ package dtv.xst.dao.trn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PosTransactionLinkId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -878991580L;
/*     */   private DtvDate _businessDate;
/*     */   private DtvDate _linkBusinessDate;
/*     */   private Long _linkRetailLocationId;
/*     */   private Long _linkTransactionSequence;
/*     */   private Long _linkWorkstationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public PosTransactionLinkId() {}
/*     */   
/*     */   public PosTransactionLinkId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDate() {
/*  40 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  44 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLinkBusinessDate() {
/*  49 */     return (Date)this._linkBusinessDate;
/*     */   }
/*     */   
/*     */   public void setLinkBusinessDate(Date argLinkBusinessDate) {
/*  53 */     this._linkBusinessDate = (argLinkBusinessDate == null || argLinkBusinessDate instanceof DtvDate) ? (DtvDate)argLinkBusinessDate : new DtvDate(argLinkBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getLinkRetailLocationId() {
/*  58 */     return this._linkRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setLinkRetailLocationId(Long argLinkRetailLocationId) {
/*  62 */     this._linkRetailLocationId = argLinkRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getLinkTransactionSequence() {
/*  66 */     return this._linkTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setLinkTransactionSequence(Long argLinkTransactionSequence) {
/*  70 */     this._linkTransactionSequence = argLinkTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getLinkWorkstationId() {
/*  74 */     return this._linkWorkstationId;
/*     */   }
/*     */   
/*     */   public void setLinkWorkstationId(Long argLinkWorkstationId) {
/*  78 */     this._linkWorkstationId = argLinkWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  82 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  86 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  90 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  94 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  98 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 102 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/* 106 */     String str = argObjectIdValue;
/* 107 */     if (StringUtils.isEmpty(str)) {
/* 108 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 111 */       String[] tokens = str.split("::");
/* 112 */       str = tokens[0];
/*     */       
/* 114 */       if ("null".equals(str)) {
/* 115 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 118 */         setBusinessDate((Date)new DtvDate());
/* 119 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 121 */       str = tokens[1];
/*     */       
/* 123 */       if ("null".equals(str)) {
/* 124 */         setLinkBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 127 */         setLinkBusinessDate((Date)new DtvDate());
/* 128 */         this._linkBusinessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 130 */       str = tokens[2];
/*     */       
/* 132 */       setLinkRetailLocationId(Long.valueOf(str));
/* 133 */       str = tokens[3];
/*     */       
/* 135 */       setLinkTransactionSequence(Long.valueOf(str));
/* 136 */       str = tokens[4];
/*     */       
/* 138 */       setLinkWorkstationId(Long.valueOf(str));
/* 139 */       str = tokens[5];
/*     */       
/* 141 */       setOrganizationId(Long.valueOf(str));
/* 142 */       str = tokens[6];
/*     */       
/* 144 */       setRetailLocationId(Long.valueOf(str));
/* 145 */       str = tokens[7];
/*     */       
/* 147 */       setTransactionSequence(Long.valueOf(str));
/* 148 */       str = tokens[8];
/*     */       
/* 150 */       setWorkstationId(Long.valueOf(str));
/*     */     }
/* 152 */     catch (Exception ee) {
/* 153 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 159 */     if (this == ob) {
/* 160 */       return true;
/*     */     }
/* 162 */     if (!(ob instanceof PosTransactionLinkId)) {
/* 163 */       return false;
/*     */     }
/* 165 */     PosTransactionLinkId other = (PosTransactionLinkId)ob;
/* 166 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 169 */       .equals(other._businessDate))) && ((this._linkBusinessDate == null && other._linkBusinessDate == null) || (this._linkBusinessDate != null && this._linkBusinessDate
/*     */ 
/*     */       
/* 172 */       .equals(other._linkBusinessDate))) && ((this._linkRetailLocationId == null && other._linkRetailLocationId == null) || (this._linkRetailLocationId != null && this._linkRetailLocationId
/*     */ 
/*     */       
/* 175 */       .equals(other._linkRetailLocationId))) && ((this._linkTransactionSequence == null && other._linkTransactionSequence == null) || (this._linkTransactionSequence != null && this._linkTransactionSequence
/*     */ 
/*     */       
/* 178 */       .equals(other._linkTransactionSequence))) && ((this._linkWorkstationId == null && other._linkWorkstationId == null) || (this._linkWorkstationId != null && this._linkWorkstationId
/*     */ 
/*     */       
/* 181 */       .equals(other._linkWorkstationId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 184 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 187 */       .equals(other._retailLocationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 190 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 193 */       .equals(other._workstationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 199 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 200 */       .hashCode()) + ((this._linkBusinessDate == null) ? 0 : this._linkBusinessDate
/* 201 */       .hashCode()) + ((this._linkRetailLocationId == null) ? 0 : this._linkRetailLocationId
/* 202 */       .hashCode()) + ((this._linkTransactionSequence == null) ? 0 : this._linkTransactionSequence
/* 203 */       .hashCode()) + ((this._linkWorkstationId == null) ? 0 : this._linkWorkstationId
/* 204 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 205 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 206 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 207 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 208 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 213 */     return "PosTransactionLink";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 218 */     StringBuilder buff = new StringBuilder(108);
/*     */     
/* 220 */     return buff.append((this._businessDate == null) ? "null" : 
/* 221 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 222 */       .append("::").append((this._linkBusinessDate == null) ? "null" : String.valueOf(this._linkBusinessDate.getTimeSerializable()))
/* 223 */       .append("::").append(String.valueOf(this._linkRetailLocationId))
/* 224 */       .append("::").append(String.valueOf(this._linkTransactionSequence))
/* 225 */       .append("::").append(String.valueOf(this._linkWorkstationId))
/* 226 */       .append("::").append(String.valueOf(this._organizationId))
/* 227 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 228 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 229 */       .append("::").append(String.valueOf(this._workstationId))
/* 230 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 234 */     if (this._businessDate == null) {
/* 235 */       return false;
/*     */     }
/* 237 */     if (this._linkBusinessDate == null) {
/* 238 */       return false;
/*     */     }
/* 240 */     if (this._linkRetailLocationId == null) {
/* 241 */       return false;
/*     */     }
/* 243 */     if (this._linkTransactionSequence == null) {
/* 244 */       return false;
/*     */     }
/* 246 */     if (this._linkWorkstationId == null) {
/* 247 */       return false;
/*     */     }
/* 249 */     if (this._retailLocationId == null) {
/* 250 */       return false;
/*     */     }
/* 252 */     if (this._transactionSequence == null) {
/* 253 */       return false;
/*     */     }
/* 255 */     if (this._workstationId == null) {
/* 256 */       return false;
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\PosTransactionLinkId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */