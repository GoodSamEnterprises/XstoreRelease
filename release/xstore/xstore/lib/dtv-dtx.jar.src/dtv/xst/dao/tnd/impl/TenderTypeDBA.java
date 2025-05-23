/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderTypeId;
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
/*     */ public class TenderTypeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1500428210L;
/*     */   private Long _organizationId;
/*     */   private String _tenderTypecode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private String _unitCountCode;
/*     */   private BigDecimal _closeCountDiscrepancyThreshold;
/*     */   private Boolean _hidden;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tndr_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order, t.unit_count_req_code, t.close_count_disc_threshold, t.hidden_flag FROM tnd_tndr_typcode t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tndr_typcode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.tndr_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order, t.unit_count_req_code, t.close_count_disc_threshold, t.hidden_flag FROM tnd_tndr_typcode t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND tndr_typcode = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr_typcode(organization_id, tndr_typcode, create_date, create_user_id, update_date, update_user_id, description, sort_order, unit_count_req_code, close_count_disc_threshold, hidden_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._tenderTypecode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._sortOrder, this._unitCountCode, this._closeCountDiscrepancyThreshold, this._hidden } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 4, 12, 3, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr_typcode SET update_date = ?, update_user_id = ?, description = ?, sort_order = ?, unit_count_req_code = ?, close_count_disc_threshold = ?, hidden_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._description, this._sortOrder, this._unitCountCode, this._closeCountDiscrepancyThreshold, this._hidden } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4, 12, 3, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr_typcode" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tndr_typcode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND tndr_typcode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._tenderTypecode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "tnd_tndr_typcode";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new TenderTypeFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderTypeFiller
/*     */     implements IFiller {
/*     */     private TenderTypeDBA _parent;
/*     */     
/*     */     public TenderTypeFiller(TenderTypeDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._tenderTypecode = argResultSet.getString(2);
/*     */       
/* 136 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 137 */       if (t3 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 146 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 147 */       if (t5 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(6);
/* 155 */       this._parent._description = argResultSet.getString(7);
/*     */ 
/*     */       
/* 158 */       int i = argResultSet.getInt(8);
/* 159 */       if (i != 0 || argResultSet.getObject(8) != null) {
/* 160 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 164 */       this._parent._unitCountCode = argResultSet.getString(9);
/* 165 */       this._parent._closeCountDiscrepancyThreshold = argResultSet.getBigDecimal(10);
/* 166 */       this._parent._hidden = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 171 */     argDAO.suppressStateChanges(true);
/* 172 */     TenderTypeDAO dao = (TenderTypeDAO)argDAO;
/* 173 */     dao.setOrganizationId(this._organizationId);
/* 174 */     dao.setTenderTypecode(this._tenderTypecode);
/* 175 */     dao.setCreateDate(this._createDate);
/* 176 */     dao.setCreateUserId(this._createUserId);
/* 177 */     dao.setUpdateDate(this._updateDate);
/* 178 */     dao.setUpdateUserId(this._updateUserId);
/* 179 */     dao.setDescription(this._description);
/* 180 */     dao.setSortOrder(this._sortOrder);
/* 181 */     dao.setUnitCountCode(this._unitCountCode);
/* 182 */     dao.setCloseCountDiscrepancyThreshold(this._closeCountDiscrepancyThreshold);
/* 183 */     dao.setHidden(this._hidden);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 189 */     return loadDAO((IDataAccessObject)new TenderTypeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 193 */     TenderTypeDAO dao = (TenderTypeDAO)argDAO;
/* 194 */     this._organizationId = dao.getOrganizationId();
/* 195 */     this._tenderTypecode = dao.getTenderTypecode();
/* 196 */     this._createDate = dao.getCreateDate();
/* 197 */     this._createUserId = dao.getCreateUserId();
/* 198 */     this._updateDate = dao.getUpdateDate();
/* 199 */     this._updateUserId = dao.getUpdateUserId();
/* 200 */     this._description = dao.getDescription();
/* 201 */     this._sortOrder = dao.getSortOrder();
/* 202 */     this._unitCountCode = dao.getUnitCountCode();
/* 203 */     this._closeCountDiscrepancyThreshold = dao.getCloseCountDiscrepancyThreshold();
/* 204 */     this._hidden = (dao.getHidden() != null) ? dao.getHidden() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     TenderTypeId id = (TenderTypeId)argId;
/* 209 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 210 */     argStatement.setString(2, id.getTenderTypecode());
/* 211 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 215 */     TenderTypeId id = new TenderTypeId();
/* 216 */     id.setOrganizationId(this._organizationId);
/* 217 */     id.setTenderTypecode(this._tenderTypecode);
/* 218 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 226 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 230 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderTypeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */