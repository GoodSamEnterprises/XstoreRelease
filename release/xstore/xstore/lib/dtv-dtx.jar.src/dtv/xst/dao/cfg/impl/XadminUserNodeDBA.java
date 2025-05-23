/*     */ package dtv.xst.dao.cfg.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cfg.XadminUserNodeId;
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
/*     */ public class XadminUserNodeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1176774532L;
/*     */   private String _userName;
/*     */   private String _orgScope;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _organizationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.user_name, t.org_scope, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.organization_id FROM cfg_user_node t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE user_name = ?  AND org_scope = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.user_name, t.org_scope, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.organization_id FROM cfg_user_node t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE user_name = ?  AND org_scope = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cfg_user_node(user_name, org_scope, create_date, create_user_id, update_date, update_user_id, organization_id) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._userName, this._orgScope, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._organizationId } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 91, 12, 91, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cfg_user_node SET update_date = ?, update_user_id = ?, organization_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  69 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  73 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._organizationId } };
/*  74 */     return updateParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  79 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cfg_user_node" }; private static final String WHERE_OBJECT = " WHERE user_name = ?  AND org_scope = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE user_name = ?  AND org_scope = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._userName, this._orgScope };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "cfg_user_node";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new XadminUserNodeFiller(this);
/*     */   }
/*     */   
/*     */   private static class XadminUserNodeFiller
/*     */     implements IFiller {
/*     */     private XadminUserNodeDBA _parent;
/*     */     
/*     */     public XadminUserNodeFiller(XadminUserNodeDBA argParent) {
/* 119 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 122 */       this._parent._userName = argResultSet.getString(1);
/* 123 */       this._parent._orgScope = argResultSet.getString(2);
/*     */       
/* 125 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 126 */       if (t3 != null) {
/* 127 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 130 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 133 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 135 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 136 */       if (t5 != null) {
/* 137 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */ 
/*     */       
/* 146 */       long primitiveResult = argResultSet.getLong(7);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 148 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 156 */     argDAO.suppressStateChanges(true);
/* 157 */     XadminUserNodeDAO dao = (XadminUserNodeDAO)argDAO;
/* 158 */     dao.setUserName(this._userName);
/* 159 */     dao.setOrgScope(this._orgScope);
/* 160 */     dao.setCreateDate(this._createDate);
/* 161 */     dao.setCreateUserId(this._createUserId);
/* 162 */     dao.setUpdateDate(this._updateDate);
/* 163 */     dao.setUpdateUserId(this._updateUserId);
/* 164 */     dao.setOrganizationId(this._organizationId);
/* 165 */     argDAO.suppressStateChanges(false);
/* 166 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 170 */     return loadDAO((IDataAccessObject)new XadminUserNodeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 174 */     XadminUserNodeDAO dao = (XadminUserNodeDAO)argDAO;
/* 175 */     this._userName = dao.getUserName();
/* 176 */     this._orgScope = dao.getOrgScope();
/* 177 */     this._createDate = dao.getCreateDate();
/* 178 */     this._createUserId = dao.getCreateUserId();
/* 179 */     this._updateDate = dao.getUpdateDate();
/* 180 */     this._updateUserId = dao.getUpdateUserId();
/* 181 */     this._organizationId = dao.getOrganizationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 185 */     XadminUserNodeId id = (XadminUserNodeId)argId;
/* 186 */     argStatement.setString(1, id.getUserName());
/* 187 */     argStatement.setString(2, id.getOrgScope());
/* 188 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     XadminUserNodeId id = new XadminUserNodeId();
/* 193 */     id.setUserName(this._userName);
/* 194 */     id.setOrgScope(this._orgScope);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\impl\XadminUserNodeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */