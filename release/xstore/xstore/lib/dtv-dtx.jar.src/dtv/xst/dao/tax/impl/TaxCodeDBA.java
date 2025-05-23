/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxCodeId;
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
/*     */ public class TaxCodeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 130853912L;
/*     */   private Long _organizationId;
/*     */   private String _taxCodeId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_code_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description FROM tax_tax_code t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_code_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.organization_id, t.tax_code_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description FROM tax_tax_code t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE organization_id = ?  AND tax_code_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_code(organization_id, tax_code_id, create_date, create_user_id, update_date, update_user_id, description) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._organizationId, this._taxCodeId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_code SET update_date = ?, update_user_id = ?, description = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  69 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  73 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._description } };
/*  74 */     return updateParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  79 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_code" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_code_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE organization_id = ?  AND tax_code_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._organizationId, this._taxCodeId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "tax_tax_code";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new TaxCodeFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxCodeFiller
/*     */     implements IFiller {
/*     */     private TaxCodeDBA _parent;
/*     */     
/*     */     public TaxCodeFiller(TaxCodeDBA argParent) {
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
/* 130 */       this._parent._taxCodeId = argResultSet.getString(2);
/*     */       
/* 132 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 133 */       if (t3 != null) {
/* 134 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 137 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 140 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 142 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 143 */       if (t5 != null) {
/* 144 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._updateUserId = argResultSet.getString(6);
/* 151 */       this._parent._description = argResultSet.getString(7);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 156 */     argDAO.suppressStateChanges(true);
/* 157 */     TaxCodeDAO dao = (TaxCodeDAO)argDAO;
/* 158 */     dao.setOrganizationId(this._organizationId);
/* 159 */     dao.setTaxCodeId(this._taxCodeId);
/* 160 */     dao.setCreateDate(this._createDate);
/* 161 */     dao.setCreateUserId(this._createUserId);
/* 162 */     dao.setUpdateDate(this._updateDate);
/* 163 */     dao.setUpdateUserId(this._updateUserId);
/* 164 */     dao.setDescription(this._description);
/* 165 */     argDAO.suppressStateChanges(false);
/* 166 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 170 */     return loadDAO((IDataAccessObject)new TaxCodeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 174 */     TaxCodeDAO dao = (TaxCodeDAO)argDAO;
/* 175 */     this._organizationId = dao.getOrganizationId();
/* 176 */     this._taxCodeId = dao.getTaxCodeId();
/* 177 */     this._createDate = dao.getCreateDate();
/* 178 */     this._createUserId = dao.getCreateUserId();
/* 179 */     this._updateDate = dao.getUpdateDate();
/* 180 */     this._updateUserId = dao.getUpdateUserId();
/* 181 */     this._description = dao.getDescription();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 185 */     TaxCodeId id = (TaxCodeId)argId;
/* 186 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 187 */     argStatement.setString(2, id.getTaxCodeId());
/* 188 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     TaxCodeId id = new TaxCodeId();
/* 193 */     id.setOrganizationId(this._organizationId);
/* 194 */     id.setTaxCodeId(this._taxCodeId);
/* 195 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 203 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 207 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxCodeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */