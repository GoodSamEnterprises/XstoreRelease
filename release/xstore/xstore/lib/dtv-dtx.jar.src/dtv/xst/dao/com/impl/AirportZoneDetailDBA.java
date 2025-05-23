/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AirportZoneDetailId;
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
/*     */ public class AirportZoneDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1260580392L;
/*     */   private Long _organizationId;
/*     */   private String _zoneId;
/*     */   private String _destinationZoneId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _taxCalculationMode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.zone_id, t.destination_zone_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_calculation_mode FROM com_airport_zone_detail t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND zone_id = ?  AND destination_zone_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.zone_id, t.destination_zone_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_calculation_mode FROM com_airport_zone_detail t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND zone_id = ?  AND destination_zone_id = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_airport_zone_detail(organization_id, zone_id, destination_zone_id, create_date, create_user_id, update_date, update_user_id, tax_calculation_mode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._zoneId, this._destinationZoneId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._taxCalculationMode } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_airport_zone_detail SET update_date = ?, update_user_id = ?, tax_calculation_mode = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._taxCalculationMode } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_airport_zone_detail" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND zone_id = ?  AND destination_zone_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND zone_id = ?  AND destination_zone_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._zoneId, this._destinationZoneId };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "com_airport_zone_detail";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new AirportZoneDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class AirportZoneDetailFiller
/*     */     implements IFiller {
/*     */     private AirportZoneDetailDBA _parent;
/*     */     
/*     */     public AirportZoneDetailFiller(AirportZoneDetailDBA argParent) {
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
/* 131 */       this._parent._zoneId = argResultSet.getString(2);
/* 132 */       this._parent._destinationZoneId = argResultSet.getString(3);
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
/* 153 */       this._parent._taxCalculationMode = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 158 */     argDAO.suppressStateChanges(true);
/* 159 */     AirportZoneDetailDAO dao = (AirportZoneDetailDAO)argDAO;
/* 160 */     dao.setOrganizationId(this._organizationId);
/* 161 */     dao.setZoneId(this._zoneId);
/* 162 */     dao.setDestinationZoneId(this._destinationZoneId);
/* 163 */     dao.setCreateDate(this._createDate);
/* 164 */     dao.setCreateUserId(this._createUserId);
/* 165 */     dao.setUpdateDate(this._updateDate);
/* 166 */     dao.setUpdateUserId(this._updateUserId);
/* 167 */     dao.setTaxCalculationMode(this._taxCalculationMode);
/* 168 */     argDAO.suppressStateChanges(false);
/* 169 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 173 */     return loadDAO((IDataAccessObject)new AirportZoneDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 177 */     AirportZoneDetailDAO dao = (AirportZoneDetailDAO)argDAO;
/* 178 */     this._organizationId = dao.getOrganizationId();
/* 179 */     this._zoneId = dao.getZoneId();
/* 180 */     this._destinationZoneId = dao.getDestinationZoneId();
/* 181 */     this._createDate = dao.getCreateDate();
/* 182 */     this._createUserId = dao.getCreateUserId();
/* 183 */     this._updateDate = dao.getUpdateDate();
/* 184 */     this._updateUserId = dao.getUpdateUserId();
/* 185 */     this._taxCalculationMode = dao.getTaxCalculationMode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 189 */     AirportZoneDetailId id = (AirportZoneDetailId)argId;
/* 190 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 191 */     argStatement.setString(2, id.getZoneId());
/* 192 */     argStatement.setString(3, id.getDestinationZoneId());
/* 193 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 197 */     AirportZoneDetailId id = new AirportZoneDetailId();
/* 198 */     id.setOrganizationId(this._organizationId);
/* 199 */     id.setZoneId(this._zoneId);
/* 200 */     id.setDestinationZoneId(this._destinationZoneId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportZoneDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */