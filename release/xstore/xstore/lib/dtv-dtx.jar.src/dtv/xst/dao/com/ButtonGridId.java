/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ public class ButtonGridId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1943332424L;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _gridId;
/*     */   private Integer _rowId;
/*     */   private Integer _columnId;
/*     */   private String _componentId;
/*     */   private Integer _sortOrder;
/*     */   
/*     */   public ButtonGridId() {}
/*     */   
/*     */   public ButtonGridId(String argObjectIdValue) {
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
/*     */   public String getLevelCode() {
/*  35 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  39 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  43 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  47 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */   }
/*     */   
/*     */   public String getGridId() {
/*  51 */     return this._gridId;
/*     */   }
/*     */   
/*     */   public void setGridId(String argGridId) {
/*  55 */     this._gridId = (argGridId != null && MANAGE_CASE) ? argGridId.toUpperCase() : argGridId;
/*     */   }
/*     */   
/*     */   public Integer getRowId() {
/*  59 */     return this._rowId;
/*     */   }
/*     */   
/*     */   public void setRowId(Integer argRowId) {
/*  63 */     this._rowId = argRowId;
/*     */   }
/*     */   
/*     */   public Integer getColumnId() {
/*  67 */     return this._columnId;
/*     */   }
/*     */   
/*     */   public void setColumnId(Integer argColumnId) {
/*  71 */     this._columnId = argColumnId;
/*     */   }
/*     */   
/*     */   public String getComponentId() {
/*  75 */     return this._componentId;
/*     */   }
/*     */   
/*     */   public void setComponentId(String argComponentId) {
/*  79 */     this._componentId = (argComponentId != null && MANAGE_CASE) ? argComponentId.toUpperCase() : argComponentId;
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/*  83 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/*  87 */     this._sortOrder = argSortOrder;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  91 */     String str = argObjectIdValue;
/*  92 */     if (StringUtils.isEmpty(str)) {
/*  93 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  96 */       String[] tokens = str.split("::");
/*  97 */       str = tokens[0];
/*     */       
/*  99 */       setOrganizationId(Long.valueOf(str));
/* 100 */       str = tokens[1];
/*     */       
/* 102 */       if ("null".equals(str)) {
/* 103 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/* 106 */         setLevelCode(str);
/*     */       } 
/* 108 */       str = tokens[2];
/*     */       
/* 110 */       if ("null".equals(str)) {
/* 111 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 114 */         setLevelValue(str);
/*     */       } 
/* 116 */       str = tokens[3];
/*     */       
/* 118 */       if ("null".equals(str)) {
/* 119 */         setGridId((String)null);
/*     */       } else {
/*     */         
/* 122 */         setGridId(str);
/*     */       } 
/* 124 */       str = tokens[4];
/*     */       
/* 126 */       setRowId(Integer.valueOf(str));
/* 127 */       str = tokens[5];
/*     */       
/* 129 */       setColumnId(Integer.valueOf(str));
/* 130 */       str = tokens[6];
/*     */       
/* 132 */       if ("null".equals(str)) {
/* 133 */         setComponentId((String)null);
/*     */       } else {
/*     */         
/* 136 */         setComponentId(str);
/*     */       } 
/* 138 */       str = tokens[7];
/*     */       
/* 140 */       setSortOrder(Integer.valueOf(str));
/*     */     }
/* 142 */     catch (Exception ee) {
/* 143 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 149 */     if (this == ob) {
/* 150 */       return true;
/*     */     }
/* 152 */     if (!(ob instanceof ButtonGridId)) {
/* 153 */       return false;
/*     */     }
/* 155 */     ButtonGridId other = (ButtonGridId)ob;
/* 156 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 159 */       .equals(other._organizationId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 162 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 165 */       .equals(other._levelValue))) && ((this._gridId == null && other._gridId == null) || (this._gridId != null && this._gridId
/*     */ 
/*     */       
/* 168 */       .equals(other._gridId))) && ((this._rowId == null && other._rowId == null) || (this._rowId != null && this._rowId
/*     */ 
/*     */       
/* 171 */       .equals(other._rowId))) && ((this._columnId == null && other._columnId == null) || (this._columnId != null && this._columnId
/*     */ 
/*     */       
/* 174 */       .equals(other._columnId))) && ((this._componentId == null && other._componentId == null) || (this._componentId != null && this._componentId
/*     */ 
/*     */       
/* 177 */       .equals(other._componentId))) && ((this._sortOrder == null && other._sortOrder == null) || (this._sortOrder != null && this._sortOrder
/*     */ 
/*     */       
/* 180 */       .equals(other._sortOrder))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 186 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 187 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 188 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 189 */       .hashCode()) + ((this._gridId == null) ? 0 : this._gridId
/* 190 */       .hashCode()) + ((this._rowId == null) ? 0 : this._rowId
/* 191 */       .hashCode()) + ((this._columnId == null) ? 0 : this._columnId
/* 192 */       .hashCode()) + ((this._componentId == null) ? 0 : this._componentId
/* 193 */       .hashCode()) + ((this._sortOrder == null) ? 0 : this._sortOrder
/* 194 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 199 */     return "ButtonGrid";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 204 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 206 */     return buff.append(
/* 207 */         String.valueOf(this._organizationId))
/* 208 */       .append("::").append(this._levelCode)
/* 209 */       .append("::").append(this._levelValue)
/* 210 */       .append("::").append(this._gridId)
/* 211 */       .append("::").append(String.valueOf(this._rowId))
/* 212 */       .append("::").append(String.valueOf(this._columnId))
/* 213 */       .append("::").append(this._componentId)
/* 214 */       .append("::").append(String.valueOf(this._sortOrder))
/* 215 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 219 */     if (this._levelCode == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._levelValue == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this._gridId == null) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (this._rowId == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (this._columnId == null) {
/* 232 */       return false;
/*     */     }
/* 234 */     if (this._componentId == null) {
/* 235 */       return false;
/*     */     }
/* 237 */     if (this._sortOrder == null) {
/* 238 */       return false;
/*     */     }
/* 240 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ButtonGridId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */