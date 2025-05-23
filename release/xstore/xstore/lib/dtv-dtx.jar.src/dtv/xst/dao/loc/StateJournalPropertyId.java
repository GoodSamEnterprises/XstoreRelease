/*     */ package dtv.xst.dao.loc;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StateJournalPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -2001920645L;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private String _statusTypcode;
/*     */   private String _stateJournalId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public StateJournalPropertyId() {}
/*     */   
/*     */   public StateJournalPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  33 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  37 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  41 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  45 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public String getStatusTypcode() {
/*  49 */     return this._statusTypcode;
/*     */   }
/*     */   
/*     */   public void setStatusTypcode(String argStatusTypcode) {
/*  53 */     this._statusTypcode = (argStatusTypcode != null && MANAGE_CASE) ? argStatusTypcode.toUpperCase() : argStatusTypcode;
/*     */   }
/*     */   
/*     */   public String getStateJournalId() {
/*  57 */     return this._stateJournalId;
/*     */   }
/*     */   
/*     */   public void setStateJournalId(String argStateJournalId) {
/*  61 */     this._stateJournalId = (argStateJournalId != null && MANAGE_CASE) ? argStateJournalId.toUpperCase() : argStateJournalId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  65 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  69 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  73 */     String str = argObjectIdValue;
/*  74 */     if (StringUtils.isEmpty(str)) {
/*  75 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  78 */       String[] tokens = str.split("::");
/*  79 */       str = tokens[0];
/*     */       
/*  81 */       setOrganizationId(Long.valueOf(str));
/*  82 */       str = tokens[1];
/*     */       
/*  84 */       setRetailLocationId(Long.valueOf(str));
/*  85 */       str = tokens[2];
/*     */       
/*  87 */       setWorkstationId(Long.valueOf(str));
/*  88 */       str = tokens[3];
/*     */       
/*  90 */       if ("null".equals(str)) {
/*  91 */         setStatusTypcode((String)null);
/*     */       } else {
/*     */         
/*  94 */         setStatusTypcode(str);
/*     */       } 
/*  96 */       str = tokens[4];
/*     */       
/*  98 */       if ("null".equals(str)) {
/*  99 */         setStateJournalId((String)null);
/*     */       } else {
/*     */         
/* 102 */         setStateJournalId(str);
/*     */       } 
/* 104 */       str = tokens[5];
/*     */       
/* 106 */       if ("null".equals(str)) {
/* 107 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 110 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 113 */     } catch (Exception ee) {
/* 114 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 120 */     if (this == ob) {
/* 121 */       return true;
/*     */     }
/* 123 */     if (!(ob instanceof StateJournalPropertyId)) {
/* 124 */       return false;
/*     */     }
/* 126 */     StateJournalPropertyId other = (StateJournalPropertyId)ob;
/* 127 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 130 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 133 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 136 */       .equals(other._workstationId))) && ((this._statusTypcode == null && other._statusTypcode == null) || (this._statusTypcode != null && this._statusTypcode
/*     */ 
/*     */       
/* 139 */       .equals(other._statusTypcode))) && ((this._stateJournalId == null && other._stateJournalId == null) || (this._stateJournalId != null && this._stateJournalId
/*     */ 
/*     */       
/* 142 */       .equals(other._stateJournalId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 145 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 151 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 152 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 153 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 154 */       .hashCode()) + ((this._statusTypcode == null) ? 0 : this._statusTypcode
/* 155 */       .hashCode()) + ((this._stateJournalId == null) ? 0 : this._stateJournalId
/* 156 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 157 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 162 */     return "StateJournalProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 169 */     return buff.append(
/* 170 */         String.valueOf(this._organizationId))
/* 171 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 172 */       .append("::").append(String.valueOf(this._workstationId))
/* 173 */       .append("::").append(this._statusTypcode)
/* 174 */       .append("::").append(this._stateJournalId)
/* 175 */       .append("::").append(this._propertyCode)
/* 176 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 180 */     if (this._retailLocationId == null) {
/* 181 */       return false;
/*     */     }
/* 183 */     if (this._workstationId == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     if (this._statusTypcode == null) {
/* 187 */       return false;
/*     */     }
/* 189 */     if (this._stateJournalId == null) {
/* 190 */       return false;
/*     */     }
/* 192 */     if (this._propertyCode == null) {
/* 193 */       return false;
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\StateJournalPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */