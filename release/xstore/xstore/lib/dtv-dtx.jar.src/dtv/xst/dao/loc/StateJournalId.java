/*     */ package dtv.xst.dao.loc;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StateJournalId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1081884282L;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private String _statusTypcode;
/*     */   private String _stateJournalId;
/*     */   
/*     */   public StateJournalId() {}
/*     */   
/*     */   public StateJournalId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  32 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  36 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  40 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  44 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public String getStatusTypcode() {
/*  48 */     return this._statusTypcode;
/*     */   }
/*     */   
/*     */   public void setStatusTypcode(String argStatusTypcode) {
/*  52 */     this._statusTypcode = (argStatusTypcode != null && MANAGE_CASE) ? argStatusTypcode.toUpperCase() : argStatusTypcode;
/*     */   }
/*     */   
/*     */   public String getStateJournalId() {
/*  56 */     return this._stateJournalId;
/*     */   }
/*     */   
/*     */   public void setStateJournalId(String argStateJournalId) {
/*  60 */     this._stateJournalId = (argStateJournalId != null && MANAGE_CASE) ? argStateJournalId.toUpperCase() : argStateJournalId;
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
/*  75 */       setRetailLocationId(Long.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       setWorkstationId(Long.valueOf(str));
/*  79 */       str = tokens[3];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setStatusTypcode((String)null);
/*     */       } else {
/*     */         
/*  85 */         setStatusTypcode(str);
/*     */       } 
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setStateJournalId((String)null);
/*     */       } else {
/*     */         
/*  93 */         setStateJournalId(str);
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
/* 106 */     if (!(ob instanceof StateJournalId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     StateJournalId other = (StateJournalId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 116 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 119 */       .equals(other._workstationId))) && ((this._statusTypcode == null && other._statusTypcode == null) || (this._statusTypcode != null && this._statusTypcode
/*     */ 
/*     */       
/* 122 */       .equals(other._statusTypcode))) && ((this._stateJournalId == null && other._stateJournalId == null) || (this._stateJournalId != null && this._stateJournalId
/*     */ 
/*     */       
/* 125 */       .equals(other._stateJournalId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 133 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 134 */       .hashCode()) + ((this._statusTypcode == null) ? 0 : this._statusTypcode
/* 135 */       .hashCode()) + ((this._stateJournalId == null) ? 0 : this._stateJournalId
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "StateJournal";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 151 */       .append("::").append(String.valueOf(this._workstationId))
/* 152 */       .append("::").append(this._statusTypcode)
/* 153 */       .append("::").append(this._stateJournalId)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._retailLocationId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._workstationId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._statusTypcode == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._stateJournalId == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\StateJournalId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */