/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.SequenceId;
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
/*     */ public class SequenceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1414192097L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private String _sequenceId;
/*     */   private String _sequenceMode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _sequenceNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.sequence_id, t.sequence_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sequence_nbr FROM com_sequence t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND sequence_id = ?  AND sequence_mode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.sequence_id, t.sequence_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sequence_nbr FROM com_sequence t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND sequence_id = ?  AND sequence_mode = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_sequence(organization_id, rtl_loc_id, wkstn_id, sequence_id, sequence_mode, create_date, create_user_id, update_date, update_user_id, sequence_nbr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._sequenceId, this._sequenceMode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._sequenceNumber } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 12, 12, 91, 12, 91, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_sequence SET update_date = ?, update_user_id = ?, sequence_nbr = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._sequenceNumber } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_sequence" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND sequence_id = ?  AND sequence_mode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND sequence_id = ?  AND sequence_mode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._sequenceId, this._sequenceMode };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "com_sequence";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new SequenceFiller(this);
/*     */   }
/*     */   
/*     */   private static class SequenceFiller
/*     */     implements IFiller {
/*     */     private SequenceDBA _parent;
/*     */     
/*     */     public SequenceFiller(SequenceDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       primitiveResult = argResultSet.getLong(3);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 145 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 149 */       this._parent._sequenceId = argResultSet.getString(4);
/* 150 */       this._parent._sequenceMode = argResultSet.getString(5);
/*     */       
/* 152 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 153 */       if (t6 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 162 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 163 */       if (t8 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 173 */       long l1 = argResultSet.getLong(10);
/* 174 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 175 */         this._parent._sequenceNumber = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     SequenceDAO dao = (SequenceDAO)argDAO;
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setRetailLocationId(this._retailLocationId);
/* 187 */     dao.setWorkstationId(this._workstationId);
/* 188 */     dao.setSequenceId(this._sequenceId);
/* 189 */     dao.setSequenceMode(this._sequenceMode);
/* 190 */     dao.setCreateDate(this._createDate);
/* 191 */     dao.setCreateUserId(this._createUserId);
/* 192 */     dao.setUpdateDate(this._updateDate);
/* 193 */     dao.setUpdateUserId(this._updateUserId);
/* 194 */     dao.setSequenceNumber(this._sequenceNumber);
/* 195 */     argDAO.suppressStateChanges(false);
/* 196 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 200 */     return loadDAO((IDataAccessObject)new SequenceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 204 */     SequenceDAO dao = (SequenceDAO)argDAO;
/* 205 */     this._organizationId = dao.getOrganizationId();
/* 206 */     this._retailLocationId = dao.getRetailLocationId();
/* 207 */     this._workstationId = dao.getWorkstationId();
/* 208 */     this._sequenceId = dao.getSequenceId();
/* 209 */     this._sequenceMode = dao.getSequenceMode();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/* 214 */     this._sequenceNumber = dao.getSequenceNumber();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 218 */     SequenceId id = (SequenceId)argId;
/* 219 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 220 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 221 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 222 */     argStatement.setString(4, id.getSequenceId());
/* 223 */     argStatement.setString(5, id.getSequenceMode());
/* 224 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 228 */     SequenceId id = new SequenceId();
/* 229 */     id.setOrganizationId(this._organizationId);
/* 230 */     id.setRetailLocationId(this._retailLocationId);
/* 231 */     id.setWorkstationId(this._workstationId);
/* 232 */     id.setSequenceId(this._sequenceId);
/* 233 */     id.setSequenceMode(this._sequenceMode);
/* 234 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequenceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */