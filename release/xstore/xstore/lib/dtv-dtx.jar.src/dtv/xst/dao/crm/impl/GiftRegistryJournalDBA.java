/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.GiftRegistryJournalId;
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
/*     */ public class GiftRegistryJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -909944630L;
/*     */   private Long _organizationId;
/*     */   private Long _journalSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _registryId;
/*     */   private String _actionCode;
/*     */   private String _registryStatus;
/*     */   private Long _transRetailLocationId;
/*     */   private Long _transWorkstationId;
/*     */   private Date _transBusinessDate;
/*     */   private Long _transSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.registry_id, t.action_code, t.registry_status, t.trans_rtl_loc_id, t.trans_wkstn_id, t.trans_business_date, t.trans_trans_seq FROM crm_gift_registry_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.registry_id, t.action_code, t.registry_status, t.trans_rtl_loc_id, t.trans_wkstn_id, t.trans_business_date, t.trans_trans_seq FROM crm_gift_registry_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_gift_registry_journal(organization_id, journal_seq, create_date, create_user_id, update_date, update_user_id, registry_id, action_code, registry_status, trans_rtl_loc_id, trans_wkstn_id, trans_business_date, trans_trans_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._journalSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._registryId, this._actionCode, this._registryStatus, this._transRetailLocationId, this._transWorkstationId, this._transBusinessDate, this._transSequence } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, 12, 91, 12, -5, 12, 12, -5, -5, 91, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_gift_registry_journal SET update_date = ?, update_user_id = ?, registry_id = ?, action_code = ?, registry_status = ?, trans_rtl_loc_id = ?, trans_wkstn_id = ?, trans_business_date = ?, trans_trans_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._registryId, this._actionCode, this._registryStatus, this._transRetailLocationId, this._transWorkstationId, this._transBusinessDate, this._transSequence } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, 12, 12, -5, -5, 91, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_gift_registry_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._journalSequence };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "crm_gift_registry_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new GiftRegistryJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class GiftRegistryJournalFiller
/*     */     implements IFiller {
/*     */     private GiftRegistryJournalDBA _parent;
/*     */     
/*     */     public GiftRegistryJournalFiller(GiftRegistryJournalDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       primitiveResult = argResultSet.getLong(2);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._journalSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 145 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 146 */       if (t3 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 155 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 156 */       if (t5 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */ 
/*     */       
/* 166 */       long l1 = argResultSet.getLong(7);
/* 167 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 168 */         this._parent._registryId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 172 */       this._parent._actionCode = argResultSet.getString(8);
/* 173 */       this._parent._registryStatus = argResultSet.getString(9);
/*     */ 
/*     */       
/* 176 */       l1 = argResultSet.getLong(10);
/* 177 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 178 */         this._parent._transRetailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       l1 = argResultSet.getLong(11);
/* 185 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 186 */         this._parent._transWorkstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 191 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 192 */       if (t12 != null) {
/* 193 */         this._parent._transBusinessDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._transBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 201 */       long l2 = argResultSet.getLong(13);
/* 202 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 203 */         this._parent._transSequence = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 211 */     argDAO.suppressStateChanges(true);
/* 212 */     GiftRegistryJournalDAO dao = (GiftRegistryJournalDAO)argDAO;
/* 213 */     dao.setOrganizationId(this._organizationId);
/* 214 */     dao.setJournalSequence(this._journalSequence);
/* 215 */     dao.setCreateDate(this._createDate);
/* 216 */     dao.setCreateUserId(this._createUserId);
/* 217 */     dao.setUpdateDate(this._updateDate);
/* 218 */     dao.setUpdateUserId(this._updateUserId);
/* 219 */     dao.setRegistryId(this._registryId);
/* 220 */     dao.setActionCode(this._actionCode);
/* 221 */     dao.setRegistryStatus(this._registryStatus);
/* 222 */     dao.setTransRetailLocationId(this._transRetailLocationId);
/* 223 */     dao.setTransWorkstationId(this._transWorkstationId);
/* 224 */     dao.setTransBusinessDate(this._transBusinessDate);
/* 225 */     dao.setTransSequence(this._transSequence);
/* 226 */     argDAO.suppressStateChanges(false);
/* 227 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 231 */     return loadDAO((IDataAccessObject)new GiftRegistryJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 235 */     GiftRegistryJournalDAO dao = (GiftRegistryJournalDAO)argDAO;
/* 236 */     this._organizationId = dao.getOrganizationId();
/* 237 */     this._journalSequence = dao.getJournalSequence();
/* 238 */     this._createDate = dao.getCreateDate();
/* 239 */     this._createUserId = dao.getCreateUserId();
/* 240 */     this._updateDate = dao.getUpdateDate();
/* 241 */     this._updateUserId = dao.getUpdateUserId();
/* 242 */     this._registryId = dao.getRegistryId();
/* 243 */     this._actionCode = dao.getActionCode();
/* 244 */     this._registryStatus = dao.getRegistryStatus();
/* 245 */     this._transRetailLocationId = dao.getTransRetailLocationId();
/* 246 */     this._transWorkstationId = dao.getTransWorkstationId();
/* 247 */     this._transBusinessDate = dao.getTransBusinessDate();
/* 248 */     this._transSequence = dao.getTransSequence();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 252 */     GiftRegistryJournalId id = (GiftRegistryJournalId)argId;
/* 253 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 254 */     argStatement.setLong(2, id.getJournalSequence().longValue());
/* 255 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 259 */     GiftRegistryJournalId id = new GiftRegistryJournalId();
/* 260 */     id.setOrganizationId(this._organizationId);
/* 261 */     id.setJournalSequence(this._journalSequence);
/* 262 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 270 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 274 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\GiftRegistryJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */