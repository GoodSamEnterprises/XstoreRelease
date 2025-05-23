/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxBracketId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class TaxBracketDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1929214621L;
/*     */   private Long _organizationId;
/*     */   private String _taxBracketId;
/*     */   private Integer _taxBracketSequence;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _taxBreakpoint;
/*     */   private BigDecimal _taxAmount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_bracket_id, t.tax_bracket_seq_nbr, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_breakpoint, t.tax_amount FROM tax_tax_bracket t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_bracket_id = ?  AND tax_bracket_seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.tax_bracket_id, t.tax_bracket_seq_nbr, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_breakpoint, t.tax_amount FROM tax_tax_bracket t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND tax_bracket_id = ?  AND tax_bracket_seq_nbr = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_bracket(organization_id, tax_bracket_id, tax_bracket_seq_nbr, org_code, org_value, create_date, create_user_id, update_date, update_user_id, tax_breakpoint, tax_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._taxBracketId, this._taxBracketSequence, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._taxBreakpoint, this._taxAmount } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 12, 12, 91, 12, 91, 12, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_bracket SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, tax_breakpoint = ?, tax_amount = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._taxBreakpoint, this._taxAmount } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_bracket" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_bracket_id = ?  AND tax_bracket_seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND tax_bracket_id = ?  AND tax_bracket_seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._taxBracketId, this._taxBracketSequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "tax_tax_bracket";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new TaxBracketFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxBracketFiller
/*     */     implements IFiller {
/*     */     private TaxBracketDBA _parent;
/*     */     
/*     */     public TaxBracketFiller(TaxBracketDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long l = argResultSet.getLong(1);
/* 129 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._taxBracketId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 137 */       int primitiveResult = argResultSet.getInt(3);
/* 138 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 139 */         this._parent._taxBracketSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._orgCode = argResultSet.getString(4);
/* 144 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 156 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 157 */       if (t8 != null) {
/* 158 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._updateUserId = argResultSet.getString(9);
/* 165 */       this._parent._taxBreakpoint = argResultSet.getBigDecimal(10);
/* 166 */       this._parent._taxAmount = argResultSet.getBigDecimal(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 171 */     argDAO.suppressStateChanges(true);
/* 172 */     TaxBracketDAO dao = (TaxBracketDAO)argDAO;
/* 173 */     dao.setOrganizationId(this._organizationId);
/* 174 */     dao.setTaxBracketId(this._taxBracketId);
/* 175 */     dao.setTaxBracketSequence(this._taxBracketSequence);
/* 176 */     dao.setOrgCode(this._orgCode);
/* 177 */     dao.setOrgValue(this._orgValue);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setTaxBreakpoint(this._taxBreakpoint);
/* 183 */     dao.setTaxAmount(this._taxAmount);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 189 */     return loadDAO((IDataAccessObject)new TaxBracketDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 193 */     TaxBracketDAO dao = (TaxBracketDAO)argDAO;
/* 194 */     this._organizationId = dao.getOrganizationId();
/* 195 */     this._taxBracketId = dao.getTaxBracketId();
/* 196 */     this._taxBracketSequence = dao.getTaxBracketSequence();
/* 197 */     this._orgCode = dao.getOrgCode();
/* 198 */     this._orgValue = dao.getOrgValue();
/* 199 */     this._createDate = dao.getCreateDate();
/* 200 */     this._createUserId = dao.getCreateUserId();
/* 201 */     this._updateDate = dao.getUpdateDate();
/* 202 */     this._updateUserId = dao.getUpdateUserId();
/* 203 */     this._taxBreakpoint = dao.getTaxBreakpoint();
/* 204 */     this._taxAmount = dao.getTaxAmount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     TaxBracketId id = (TaxBracketId)argId;
/* 209 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 210 */     argStatement.setString(2, id.getTaxBracketId());
/* 211 */     argStatement.setInt(3, id.getTaxBracketSequence().intValue());
/* 212 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 216 */     TaxBracketId id = new TaxBracketId();
/* 217 */     id.setOrganizationId(this._organizationId);
/* 218 */     id.setTaxBracketId(this._taxBracketId);
/* 219 */     id.setTaxBracketSequence(this._taxBracketSequence);
/* 220 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 228 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 232 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxBracketDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */