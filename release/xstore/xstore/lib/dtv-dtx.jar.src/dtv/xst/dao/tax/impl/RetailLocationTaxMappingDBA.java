/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.RetailLocationTaxMappingId;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RetailLocationTaxMappingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 866442939L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _taxLocationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_loc_id FROM tax_rtl_loc_tax_mapping t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_loc_id FROM tax_rtl_loc_tax_mapping t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_rtl_loc_tax_mapping(organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, tax_loc_id) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._taxLocationId } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_rtl_loc_tax_mapping SET update_date = ?, update_user_id = ?, tax_loc_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  69 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  73 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._taxLocationId } };
/*  74 */     return updateParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  79 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_rtl_loc_tax_mapping" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._organizationId, this._retailLocationId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "tax_rtl_loc_tax_mapping";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new RetailLocationTaxMappingFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailLocationTaxMappingFiller
/*     */     implements IFiller {
/*     */     private RetailLocationTaxMappingDBA _parent;
/*     */     
/*     */     public RetailLocationTaxMappingFiller(RetailLocationTaxMappingDBA argParent) {
/* 119 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       long primitiveResult = argResultSet.getLong(1);
/* 125 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 126 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       primitiveResult = argResultSet.getLong(2);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 134 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 139 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 140 */       if (t3 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 149 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 150 */       if (t5 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(6);
/* 158 */       this._parent._taxLocationId = argResultSet.getString(7);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 163 */     argDAO.suppressStateChanges(true);
/* 164 */     RetailLocationTaxMappingDAO dao = (RetailLocationTaxMappingDAO)argDAO;
/* 165 */     dao.setOrganizationId(this._organizationId);
/* 166 */     dao.setRetailLocationId(this._retailLocationId);
/* 167 */     dao.setCreateDate(this._createDate);
/* 168 */     dao.setCreateUserId(this._createUserId);
/* 169 */     dao.setUpdateDate(this._updateDate);
/* 170 */     dao.setUpdateUserId(this._updateUserId);
/* 171 */     dao.setTaxLocationId(this._taxLocationId);
/* 172 */     argDAO.suppressStateChanges(false);
/* 173 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 177 */     return loadDAO((IDataAccessObject)new RetailLocationTaxMappingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 181 */     RetailLocationTaxMappingDAO dao = (RetailLocationTaxMappingDAO)argDAO;
/* 182 */     this._organizationId = dao.getOrganizationId();
/* 183 */     this._retailLocationId = dao.getRetailLocationId();
/* 184 */     this._createDate = dao.getCreateDate();
/* 185 */     this._createUserId = dao.getCreateUserId();
/* 186 */     this._updateDate = dao.getUpdateDate();
/* 187 */     this._updateUserId = dao.getUpdateUserId();
/* 188 */     this._taxLocationId = dao.getTaxLocationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 192 */     RetailLocationTaxMappingId id = (RetailLocationTaxMappingId)argId;
/* 193 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 194 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 195 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 199 */     RetailLocationTaxMappingId id = new RetailLocationTaxMappingId();
/* 200 */     id.setOrganizationId(this._organizationId);
/* 201 */     id.setRetailLocationId(this._retailLocationId);
/* 202 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 214 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\RetailLocationTaxMappingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */