/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.sec.GroupId;
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
/*     */ public class GroupDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 69076575L;
/*     */   private String _groupId;
/*     */   private Long _organizationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private Integer _bitmapPosition;
/*     */   private String _description;
/*     */   private Integer _groupRank;
/*     */   private static final String SELECT_OBJECT = "SELECT t.group_id, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.bitmap_position, t.description, t.group_rank FROM sec_groups t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE group_id = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.group_id, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.bitmap_position, t.description, t.group_rank FROM sec_groups t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE group_id = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_groups(group_id, organization_id, create_date, create_user_id, update_date, update_user_id, config_element, bitmap_position, description, group_rank) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._groupId, this._organizationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._bitmapPosition, this._description, this._groupRank } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 91, 12, 91, 12, 12, 4, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_groups SET update_date = ?, update_user_id = ?, config_element = ?, bitmap_position = ?, description = ?, group_rank = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._bitmapPosition, this._description, this._groupRank } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_groups" }; private static final String WHERE_OBJECT = " WHERE group_id = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE group_id = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._groupId, this._organizationId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "sec_groups";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new GroupFiller(this);
/*     */   }
/*     */   
/*     */   private static class GroupFiller
/*     */     implements IFiller {
/*     */     private GroupDBA _parent;
/*     */     
/*     */     public GroupFiller(GroupDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       this._parent._groupId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 128 */       long primitiveResult = argResultSet.getLong(2);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 135 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 136 */       if (t3 != null) {
/* 137 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 145 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 146 */       if (t5 != null) {
/* 147 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._updateUserId = argResultSet.getString(6);
/* 154 */       this._parent._configElement = argResultSet.getString(7);
/*     */ 
/*     */       
/* 157 */       int i = argResultSet.getInt(8);
/* 158 */       if (i != 0 || argResultSet.getObject(8) != null) {
/* 159 */         this._parent._bitmapPosition = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 163 */       this._parent._description = argResultSet.getString(9);
/*     */ 
/*     */       
/* 166 */       i = argResultSet.getInt(10);
/* 167 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 168 */         this._parent._groupRank = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     GroupDAO dao = (GroupDAO)argDAO;
/* 178 */     dao.setGroupId(this._groupId);
/* 179 */     dao.setOrganizationId(this._organizationId);
/* 180 */     dao.setCreateDate(this._createDate);
/* 181 */     dao.setCreateUserId(this._createUserId);
/* 182 */     dao.setUpdateDate(this._updateDate);
/* 183 */     dao.setUpdateUserId(this._updateUserId);
/* 184 */     dao.setConfigElement(this._configElement);
/* 185 */     dao.setBitmapPosition(this._bitmapPosition);
/* 186 */     dao.setDescription(this._description);
/* 187 */     dao.setGroupRank(this._groupRank);
/* 188 */     argDAO.suppressStateChanges(false);
/* 189 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 193 */     return loadDAO((IDataAccessObject)new GroupDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 197 */     GroupDAO dao = (GroupDAO)argDAO;
/* 198 */     this._groupId = dao.getGroupId();
/* 199 */     this._organizationId = dao.getOrganizationId();
/* 200 */     this._createDate = dao.getCreateDate();
/* 201 */     this._createUserId = dao.getCreateUserId();
/* 202 */     this._updateDate = dao.getUpdateDate();
/* 203 */     this._updateUserId = dao.getUpdateUserId();
/* 204 */     this._configElement = dao.getConfigElement();
/* 205 */     this._bitmapPosition = dao.getBitmapPosition();
/* 206 */     this._description = dao.getDescription();
/* 207 */     this._groupRank = dao.getGroupRank();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 211 */     GroupId id = (GroupId)argId;
/* 212 */     argStatement.setString(1, id.getGroupId());
/* 213 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 214 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 218 */     GroupId id = new GroupId();
/* 219 */     id.setGroupId(this._groupId);
/* 220 */     id.setOrganizationId(this._organizationId);
/* 221 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 229 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 233 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\GroupDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */