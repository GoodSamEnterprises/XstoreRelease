/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ public class ButtonGridPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 970597293L;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _gridId;
/*     */   private Integer _rowId;
/*     */   private Integer _columnId;
/*     */   private String _componentId;
/*     */   private Integer _sortOrder;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ButtonGridPropertyId() {}
/*     */   
/*     */   public ButtonGridPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
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
/*     */   public String getLevelCode() {
/*  36 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  40 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  44 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  48 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */   }
/*     */   
/*     */   public String getGridId() {
/*  52 */     return this._gridId;
/*     */   }
/*     */   
/*     */   public void setGridId(String argGridId) {
/*  56 */     this._gridId = (argGridId != null && MANAGE_CASE) ? argGridId.toUpperCase() : argGridId;
/*     */   }
/*     */   
/*     */   public Integer getRowId() {
/*  60 */     return this._rowId;
/*     */   }
/*     */   
/*     */   public void setRowId(Integer argRowId) {
/*  64 */     this._rowId = argRowId;
/*     */   }
/*     */   
/*     */   public Integer getColumnId() {
/*  68 */     return this._columnId;
/*     */   }
/*     */   
/*     */   public void setColumnId(Integer argColumnId) {
/*  72 */     this._columnId = argColumnId;
/*     */   }
/*     */   
/*     */   public String getComponentId() {
/*  76 */     return this._componentId;
/*     */   }
/*     */   
/*     */   public void setComponentId(String argComponentId) {
/*  80 */     this._componentId = (argComponentId != null && MANAGE_CASE) ? argComponentId.toUpperCase() : argComponentId;
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/*  84 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/*  88 */     this._sortOrder = argSortOrder;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  92 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  96 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/* 100 */     String str = argObjectIdValue;
/* 101 */     if (StringUtils.isEmpty(str)) {
/* 102 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 105 */       String[] tokens = str.split("::");
/* 106 */       str = tokens[0];
/*     */       
/* 108 */       setOrganizationId(Long.valueOf(str));
/* 109 */       str = tokens[1];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/* 115 */         setLevelCode(str);
/*     */       } 
/* 117 */       str = tokens[2];
/*     */       
/* 119 */       if ("null".equals(str)) {
/* 120 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 123 */         setLevelValue(str);
/*     */       } 
/* 125 */       str = tokens[3];
/*     */       
/* 127 */       if ("null".equals(str)) {
/* 128 */         setGridId((String)null);
/*     */       } else {
/*     */         
/* 131 */         setGridId(str);
/*     */       } 
/* 133 */       str = tokens[4];
/*     */       
/* 135 */       setRowId(Integer.valueOf(str));
/* 136 */       str = tokens[5];
/*     */       
/* 138 */       setColumnId(Integer.valueOf(str));
/* 139 */       str = tokens[6];
/*     */       
/* 141 */       if ("null".equals(str)) {
/* 142 */         setComponentId((String)null);
/*     */       } else {
/*     */         
/* 145 */         setComponentId(str);
/*     */       } 
/* 147 */       str = tokens[7];
/*     */       
/* 149 */       setSortOrder(Integer.valueOf(str));
/* 150 */       str = tokens[8];
/*     */       
/* 152 */       if ("null".equals(str)) {
/* 153 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 156 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 159 */     } catch (Exception ee) {
/* 160 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 166 */     if (this == ob) {
/* 167 */       return true;
/*     */     }
/* 169 */     if (!(ob instanceof ButtonGridPropertyId)) {
/* 170 */       return false;
/*     */     }
/* 172 */     ButtonGridPropertyId other = (ButtonGridPropertyId)ob;
/* 173 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 176 */       .equals(other._organizationId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 179 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 182 */       .equals(other._levelValue))) && ((this._gridId == null && other._gridId == null) || (this._gridId != null && this._gridId
/*     */ 
/*     */       
/* 185 */       .equals(other._gridId))) && ((this._rowId == null && other._rowId == null) || (this._rowId != null && this._rowId
/*     */ 
/*     */       
/* 188 */       .equals(other._rowId))) && ((this._columnId == null && other._columnId == null) || (this._columnId != null && this._columnId
/*     */ 
/*     */       
/* 191 */       .equals(other._columnId))) && ((this._componentId == null && other._componentId == null) || (this._componentId != null && this._componentId
/*     */ 
/*     */       
/* 194 */       .equals(other._componentId))) && ((this._sortOrder == null && other._sortOrder == null) || (this._sortOrder != null && this._sortOrder
/*     */ 
/*     */       
/* 197 */       .equals(other._sortOrder))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 200 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 206 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 207 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 208 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 209 */       .hashCode()) + ((this._gridId == null) ? 0 : this._gridId
/* 210 */       .hashCode()) + ((this._rowId == null) ? 0 : this._rowId
/* 211 */       .hashCode()) + ((this._columnId == null) ? 0 : this._columnId
/* 212 */       .hashCode()) + ((this._componentId == null) ? 0 : this._componentId
/* 213 */       .hashCode()) + ((this._sortOrder == null) ? 0 : this._sortOrder
/* 214 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 215 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 220 */     return "ButtonGridProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 225 */     StringBuilder buff = new StringBuilder(108);
/*     */     
/* 227 */     return buff.append(
/* 228 */         String.valueOf(this._organizationId))
/* 229 */       .append("::").append(this._levelCode)
/* 230 */       .append("::").append(this._levelValue)
/* 231 */       .append("::").append(this._gridId)
/* 232 */       .append("::").append(String.valueOf(this._rowId))
/* 233 */       .append("::").append(String.valueOf(this._columnId))
/* 234 */       .append("::").append(this._componentId)
/* 235 */       .append("::").append(String.valueOf(this._sortOrder))
/* 236 */       .append("::").append(this._propertyCode)
/* 237 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 241 */     if (this._levelCode == null) {
/* 242 */       return false;
/*     */     }
/* 244 */     if (this._levelValue == null) {
/* 245 */       return false;
/*     */     }
/* 247 */     if (this._gridId == null) {
/* 248 */       return false;
/*     */     }
/* 250 */     if (this._rowId == null) {
/* 251 */       return false;
/*     */     }
/* 253 */     if (this._columnId == null) {
/* 254 */       return false;
/*     */     }
/* 256 */     if (this._componentId == null) {
/* 257 */       return false;
/*     */     }
/* 259 */     if (this._sortOrder == null) {
/* 260 */       return false;
/*     */     }
/* 262 */     if (this._propertyCode == null) {
/* 263 */       return false;
/*     */     }
/* 265 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ButtonGridPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */