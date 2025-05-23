/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AirportId;
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
/*     */ public class AirportDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 672986283L;
/*     */   private Long _organizationId;
/*     */   private String _airportCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _zoneId;
/*     */   private String _airportName;
/*     */   private String _countryCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.airport_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.zone_id, t.airport_name, t.country_code FROM com_airport t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND airport_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.airport_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.zone_id, t.airport_name, t.country_code FROM com_airport t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND airport_code = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_airport(organization_id, airport_code, create_date, create_user_id, update_date, update_user_id, zone_id, airport_name, country_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._airportCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._zoneId, this._airportName, this._countryCode } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_airport SET update_date = ?, update_user_id = ?, zone_id = ?, airport_name = ?, country_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._zoneId, this._airportName, this._countryCode } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_airport" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND airport_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND airport_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._airportCode };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "com_airport";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new AirportFiller(this);
/*     */   }
/*     */   
/*     */   private static class AirportFiller
/*     */     implements IFiller {
/*     */     private AirportDBA _parent;
/*     */     
/*     */     public AirportFiller(AirportDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 132 */       this._parent._airportCode = argResultSet.getString(2);
/*     */       
/* 134 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 135 */       if (t3 != null) {
/* 136 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 139 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 142 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._updateUserId = argResultSet.getString(6);
/* 153 */       this._parent._zoneId = argResultSet.getString(7);
/* 154 */       this._parent._airportName = argResultSet.getString(8);
/* 155 */       this._parent._countryCode = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 160 */     argDAO.suppressStateChanges(true);
/* 161 */     AirportDAO dao = (AirportDAO)argDAO;
/* 162 */     dao.setOrganizationId(this._organizationId);
/* 163 */     dao.setAirportCode(this._airportCode);
/* 164 */     dao.setCreateDate(this._createDate);
/* 165 */     dao.setCreateUserId(this._createUserId);
/* 166 */     dao.setUpdateDate(this._updateDate);
/* 167 */     dao.setUpdateUserId(this._updateUserId);
/* 168 */     dao.setZoneId(this._zoneId);
/* 169 */     dao.setAirportName(this._airportName);
/* 170 */     dao.setCountryCode(this._countryCode);
/* 171 */     argDAO.suppressStateChanges(false);
/* 172 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 176 */     return loadDAO((IDataAccessObject)new AirportDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 180 */     AirportDAO dao = (AirportDAO)argDAO;
/* 181 */     this._organizationId = dao.getOrganizationId();
/* 182 */     this._airportCode = dao.getAirportCode();
/* 183 */     this._createDate = dao.getCreateDate();
/* 184 */     this._createUserId = dao.getCreateUserId();
/* 185 */     this._updateDate = dao.getUpdateDate();
/* 186 */     this._updateUserId = dao.getUpdateUserId();
/* 187 */     this._zoneId = dao.getZoneId();
/* 188 */     this._airportName = dao.getAirportName();
/* 189 */     this._countryCode = dao.getCountryCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 193 */     AirportId id = (AirportId)argId;
/* 194 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 195 */     argStatement.setString(2, id.getAirportCode());
/* 196 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 200 */     AirportId id = new AirportId();
/* 201 */     id.setOrganizationId(this._organizationId);
/* 202 */     id.setAirportCode(this._airportCode);
/* 203 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 211 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 215 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */