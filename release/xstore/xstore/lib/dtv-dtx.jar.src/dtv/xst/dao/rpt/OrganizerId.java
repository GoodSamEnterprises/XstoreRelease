/*     */ package dtv.xst.dao.rpt;
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
/*     */ public class OrganizerId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -137637105L;
/*     */   private String _reportName;
/*     */   private String _reportGroup;
/*     */   private String _reportElement;
/*     */   
/*     */   public OrganizerId() {}
/*     */   
/*     */   public OrganizerId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReportName() {
/*  31 */     return this._reportName;
/*     */   }
/*     */   
/*     */   public void setReportName(String argReportName) {
/*  35 */     this._reportName = (argReportName != null && MANAGE_CASE) ? argReportName.toUpperCase() : argReportName;
/*     */   }
/*     */   
/*     */   public String getReportGroup() {
/*  39 */     return this._reportGroup;
/*     */   }
/*     */   
/*     */   public void setReportGroup(String argReportGroup) {
/*  43 */     this._reportGroup = (argReportGroup != null && MANAGE_CASE) ? argReportGroup.toUpperCase() : argReportGroup;
/*     */   }
/*     */   
/*     */   public String getReportElement() {
/*  47 */     return this._reportElement;
/*     */   }
/*     */   
/*     */   public void setReportElement(String argReportElement) {
/*  51 */     this._reportElement = (argReportElement != null && MANAGE_CASE) ? argReportElement.toUpperCase() : argReportElement;
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
/*  67 */         setReportName((String)null);
/*     */       } else {
/*     */         
/*  70 */         setReportName(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setReportGroup((String)null);
/*     */       } else {
/*     */         
/*  78 */         setReportGroup(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setReportElement((String)null);
/*     */       } else {
/*     */         
/*  86 */         setReportElement(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof OrganizerId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     OrganizerId other = (OrganizerId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._reportName == null && other._reportName == null) || (this._reportName != null && this._reportName
/*     */ 
/*     */       
/* 109 */       .equals(other._reportName))) && ((this._reportGroup == null && other._reportGroup == null) || (this._reportGroup != null && this._reportGroup
/*     */ 
/*     */       
/* 112 */       .equals(other._reportGroup))) && ((this._reportElement == null && other._reportElement == null) || (this._reportElement != null && this._reportElement
/*     */ 
/*     */       
/* 115 */       .equals(other._reportElement))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._reportName == null) ? 0 : this._reportName
/* 123 */       .hashCode()) + ((this._reportGroup == null) ? 0 : this._reportGroup
/* 124 */       .hashCode()) + ((this._reportElement == null) ? 0 : this._reportElement
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "Organizer";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._reportName)
/* 140 */       .append("::").append(this._reportGroup)
/* 141 */       .append("::").append(this._reportElement)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._reportName == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._reportGroup == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._reportElement == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\rpt\OrganizerId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */