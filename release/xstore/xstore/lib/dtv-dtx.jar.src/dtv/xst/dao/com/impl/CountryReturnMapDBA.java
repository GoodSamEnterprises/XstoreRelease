/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.CountryReturnMapId;
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
/*     */ public class CountryReturnMapDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 926734134L;
/*     */   private Long _organizationId;
/*     */   private String _purchasedFrom;
/*     */   private String _returnTo;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _disallowCrossBorderFlag;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.purchased_from, t.return_to, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.disallow_cross_border_flag FROM com_country_return_map t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND purchased_from = ?  AND return_to = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.purchased_from, t.return_to, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.disallow_cross_border_flag FROM com_country_return_map t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND purchased_from = ?  AND return_to = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_country_return_map(organization_id, purchased_from, return_to, create_date, create_user_id, update_date, update_user_id, disallow_cross_border_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._purchasedFrom, this._returnTo, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._disallowCrossBorderFlag } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_country_return_map SET update_date = ?, update_user_id = ?, disallow_cross_border_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._disallowCrossBorderFlag } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_country_return_map" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND purchased_from = ?  AND return_to = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND purchased_from = ?  AND return_to = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._purchasedFrom, this._returnTo };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "com_country_return_map";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new CountryReturnMapFiller(this);
/*     */   }
/*     */   
/*     */   private static class CountryReturnMapFiller
/*     */     implements IFiller {
/*     */     private CountryReturnMapDBA _parent;
/*     */     
/*     */     public CountryReturnMapFiller(CountryReturnMapDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       long primitiveResult = argResultSet.getLong(1);
/* 126 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 127 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 131 */       this._parent._purchasedFrom = argResultSet.getString(2);
/* 132 */       this._parent._returnTo = argResultSet.getString(3);
/*     */       
/* 134 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 135 */       if (t4 != null) {
/* 136 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 139 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 142 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 144 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 145 */       if (t6 != null) {
/* 146 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._updateUserId = argResultSet.getString(7);
/* 153 */       this._parent._disallowCrossBorderFlag = Boolean.valueOf(argResultSet.getBoolean(8));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 158 */     argDAO.suppressStateChanges(true);
/* 159 */     CountryReturnMapDAO dao = (CountryReturnMapDAO)argDAO;
/* 160 */     dao.setOrganizationId(this._organizationId);
/* 161 */     dao.setPurchasedFrom(this._purchasedFrom);
/* 162 */     dao.setReturnTo(this._returnTo);
/* 163 */     dao.setCreateDate(this._createDate);
/* 164 */     dao.setCreateUserId(this._createUserId);
/* 165 */     dao.setUpdateDate(this._updateDate);
/* 166 */     dao.setUpdateUserId(this._updateUserId);
/* 167 */     dao.setDisallowCrossBorderFlag(this._disallowCrossBorderFlag);
/* 168 */     argDAO.suppressStateChanges(false);
/* 169 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 173 */     return loadDAO((IDataAccessObject)new CountryReturnMapDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 177 */     CountryReturnMapDAO dao = (CountryReturnMapDAO)argDAO;
/* 178 */     this._organizationId = dao.getOrganizationId();
/* 179 */     this._purchasedFrom = dao.getPurchasedFrom();
/* 180 */     this._returnTo = dao.getReturnTo();
/* 181 */     this._createDate = dao.getCreateDate();
/* 182 */     this._createUserId = dao.getCreateUserId();
/* 183 */     this._updateDate = dao.getUpdateDate();
/* 184 */     this._updateUserId = dao.getUpdateUserId();
/* 185 */     this._disallowCrossBorderFlag = (dao.getDisallowCrossBorderFlag() != null) ? dao.getDisallowCrossBorderFlag() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 189 */     CountryReturnMapId id = (CountryReturnMapId)argId;
/* 190 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 191 */     argStatement.setString(2, id.getPurchasedFrom());
/* 192 */     argStatement.setString(3, id.getReturnTo());
/* 193 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 197 */     CountryReturnMapId id = new CountryReturnMapId();
/* 198 */     id.setOrganizationId(this._organizationId);
/* 199 */     id.setPurchasedFrom(this._purchasedFrom);
/* 200 */     id.setReturnTo(this._returnTo);
/* 201 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 209 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 213 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CountryReturnMapDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */