/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.FiscalYearId;
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
/*     */ public class FiscalYearDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1727562555L;
/*     */   private Long _organizationId;
/*     */   private Integer _fiscalYear;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _startDate;
/*     */   private Date _endDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.fiscal_year, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.start_date, t.end_date FROM inv_stock_fiscal_year t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND fiscal_year = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.fiscal_year, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.start_date, t.end_date FROM inv_stock_fiscal_year t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND fiscal_year = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_stock_fiscal_year(organization_id, fiscal_year, create_date, create_user_id, update_date, update_user_id, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._fiscalYear, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._startDate, this._endDate } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 4, 91, 12, 91, 12, 91, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_stock_fiscal_year SET update_date = ?, update_user_id = ?, start_date = ?, end_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._startDate, this._endDate } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_stock_fiscal_year" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND fiscal_year = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND fiscal_year = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._fiscalYear };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "inv_stock_fiscal_year";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new FiscalYearFiller(this);
/*     */   }
/*     */   
/*     */   private static class FiscalYearFiller
/*     */     implements IFiller {
/*     */     private FiscalYearDBA _parent;
/*     */     
/*     */     public FiscalYearFiller(FiscalYearDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       long l = argResultSet.getLong(1);
/* 126 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 127 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       int primitiveResult = argResultSet.getInt(2);
/* 134 */       if (primitiveResult != 0 || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._fiscalYear = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 140 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 141 */       if (t3 != null) {
/* 142 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 148 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 150 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 151 */       if (t5 != null) {
/* 152 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */       
/* 160 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 161 */       if (t7 != null) {
/* 162 */         this._parent._startDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._startDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 169 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 170 */       if (t8 != null) {
/* 171 */         this._parent._endDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._endDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 181 */     argDAO.suppressStateChanges(true);
/* 182 */     FiscalYearDAO dao = (FiscalYearDAO)argDAO;
/* 183 */     dao.setOrganizationId(this._organizationId);
/* 184 */     dao.setFiscalYear(this._fiscalYear);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setStartDate(this._startDate);
/* 190 */     dao.setEndDate(this._endDate);
/* 191 */     argDAO.suppressStateChanges(false);
/* 192 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 196 */     return loadDAO((IDataAccessObject)new FiscalYearDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 200 */     FiscalYearDAO dao = (FiscalYearDAO)argDAO;
/* 201 */     this._organizationId = dao.getOrganizationId();
/* 202 */     this._fiscalYear = dao.getFiscalYear();
/* 203 */     this._createDate = dao.getCreateDate();
/* 204 */     this._createUserId = dao.getCreateUserId();
/* 205 */     this._updateDate = dao.getUpdateDate();
/* 206 */     this._updateUserId = dao.getUpdateUserId();
/* 207 */     this._startDate = dao.getStartDate();
/* 208 */     this._endDate = dao.getEndDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     FiscalYearId id = (FiscalYearId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setInt(2, id.getFiscalYear().intValue());
/* 215 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 219 */     FiscalYearId id = new FiscalYearId();
/* 220 */     id.setOrganizationId(this._organizationId);
/* 221 */     id.setFiscalYear(this._fiscalYear);
/* 222 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\FiscalYearDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */