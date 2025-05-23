/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderDenominationId;
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
/*     */ 
/*     */ public class TenderDenominationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1700067577L;
/*     */   private String _denominationId;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private BigDecimal _value;
/*     */   private static final String SELECT_OBJECT = "SELECT t.denomination_id, t.organization_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order, t.value FROM tnd_tndr_denomination t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE denomination_id = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.denomination_id, t.organization_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order, t.value FROM tnd_tndr_denomination t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE denomination_id = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr_denomination(denomination_id, organization_id, tndr_id, create_date, create_user_id, update_date, update_user_id, description, sort_order, value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._denominationId, this._organizationId, this._tenderId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._sortOrder, this._value } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12, 12, 4, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr_denomination SET update_date = ?, update_user_id = ?, description = ?, sort_order = ?, value = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._description, this._sortOrder, this._value } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr_denomination" }; private static final String WHERE_OBJECT = " WHERE denomination_id = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE denomination_id = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._denominationId, this._organizationId, this._tenderId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "tnd_tndr_denomination";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new TenderDenominationFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderDenominationFiller
/*     */     implements IFiller {
/*     */     private TenderDenominationDBA _parent;
/*     */     
/*     */     public TenderDenominationFiller(TenderDenominationDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       this._parent._denominationId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 128 */       long primitiveResult = argResultSet.getLong(2);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._tenderId = argResultSet.getString(3);
/*     */       
/* 136 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 137 */       if (t4 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(7);
/* 155 */       this._parent._description = argResultSet.getString(8);
/*     */ 
/*     */       
/* 158 */       int i = argResultSet.getInt(9);
/* 159 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 160 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 164 */       this._parent._value = argResultSet.getBigDecimal(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 169 */     argDAO.suppressStateChanges(true);
/* 170 */     TenderDenominationDAO dao = (TenderDenominationDAO)argDAO;
/* 171 */     dao.setDenominationId(this._denominationId);
/* 172 */     dao.setOrganizationId(this._organizationId);
/* 173 */     dao.setTenderId(this._tenderId);
/* 174 */     dao.setCreateDate(this._createDate);
/* 175 */     dao.setCreateUserId(this._createUserId);
/* 176 */     dao.setUpdateDate(this._updateDate);
/* 177 */     dao.setUpdateUserId(this._updateUserId);
/* 178 */     dao.setDescription(this._description);
/* 179 */     dao.setSortOrder(this._sortOrder);
/* 180 */     dao.setValue(this._value);
/* 181 */     argDAO.suppressStateChanges(false);
/* 182 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 186 */     return loadDAO((IDataAccessObject)new TenderDenominationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 190 */     TenderDenominationDAO dao = (TenderDenominationDAO)argDAO;
/* 191 */     this._denominationId = dao.getDenominationId();
/* 192 */     this._organizationId = dao.getOrganizationId();
/* 193 */     this._tenderId = dao.getTenderId();
/* 194 */     this._createDate = dao.getCreateDate();
/* 195 */     this._createUserId = dao.getCreateUserId();
/* 196 */     this._updateDate = dao.getUpdateDate();
/* 197 */     this._updateUserId = dao.getUpdateUserId();
/* 198 */     this._description = dao.getDescription();
/* 199 */     this._sortOrder = dao.getSortOrder();
/* 200 */     this._value = dao.getValue();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     TenderDenominationId id = (TenderDenominationId)argId;
/* 205 */     argStatement.setString(1, id.getDenominationId());
/* 206 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 207 */     argStatement.setString(3, id.getTenderId());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     TenderDenominationId id = new TenderDenominationId();
/* 213 */     id.setDenominationId(this._denominationId);
/* 214 */     id.setOrganizationId(this._organizationId);
/* 215 */     id.setTenderId(this._tenderId);
/* 216 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 224 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 228 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderDenominationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */