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
/*     */ public class OrganizerPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -588016124L;
/*     */   private String _reportName;
/*     */   private String _reportGroup;
/*     */   private String _reportElement;
/*     */   private String _propertyCode;
/*     */   
/*     */   public OrganizerPropertyId() {}
/*     */   
/*     */   public OrganizerPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReportName() {
/*  32 */     return this._reportName;
/*     */   }
/*     */   
/*     */   public void setReportName(String argReportName) {
/*  36 */     this._reportName = (argReportName != null && MANAGE_CASE) ? argReportName.toUpperCase() : argReportName;
/*     */   }
/*     */   
/*     */   public String getReportGroup() {
/*  40 */     return this._reportGroup;
/*     */   }
/*     */   
/*     */   public void setReportGroup(String argReportGroup) {
/*  44 */     this._reportGroup = (argReportGroup != null && MANAGE_CASE) ? argReportGroup.toUpperCase() : argReportGroup;
/*     */   }
/*     */   
/*     */   public String getReportElement() {
/*  48 */     return this._reportElement;
/*     */   }
/*     */   
/*     */   public void setReportElement(String argReportElement) {
/*  52 */     this._reportElement = (argReportElement != null && MANAGE_CASE) ? argReportElement.toUpperCase() : argReportElement;
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
/*  76 */         setReportName((String)null);
/*     */       } else {
/*     */         
/*  79 */         setReportName(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setReportGroup((String)null);
/*     */       } else {
/*     */         
/*  87 */         setReportGroup(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setReportElement((String)null);
/*     */       } else {
/*     */         
/*  95 */         setReportElement(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof OrganizerPropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     OrganizerPropertyId other = (OrganizerPropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._reportName == null && other._reportName == null) || (this._reportName != null && this._reportName
/*     */ 
/*     */       
/* 126 */       .equals(other._reportName))) && ((this._reportGroup == null && other._reportGroup == null) || (this._reportGroup != null && this._reportGroup
/*     */ 
/*     */       
/* 129 */       .equals(other._reportGroup))) && ((this._reportElement == null && other._reportElement == null) || (this._reportElement != null && this._reportElement
/*     */ 
/*     */       
/* 132 */       .equals(other._reportElement))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._reportName == null) ? 0 : this._reportName
/* 143 */       .hashCode()) + ((this._reportGroup == null) ? 0 : this._reportGroup
/* 144 */       .hashCode()) + ((this._reportElement == null) ? 0 : this._reportElement
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "OrganizerProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._reportName)
/* 161 */       .append("::").append(this._reportGroup)
/* 162 */       .append("::").append(this._reportElement)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._reportName == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._reportGroup == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._reportElement == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\rpt\OrganizerPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */