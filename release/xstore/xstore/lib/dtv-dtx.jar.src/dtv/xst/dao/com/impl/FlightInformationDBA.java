/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.FlightInformationId;
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
/*     */ public class FlightInformationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 766554748L;
/*     */   private Long _organizationId;
/*     */   private Date _scheduledDateTime;
/*     */   private String _flightNumber;
/*     */   private String _originAirport;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _destinationAirport;
/*     */   private String _via1Airport;
/*     */   private String _via2Airport;
/*     */   private String _via3Airport;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.scheduled_date_time, t.flight_number, t.origin_airport, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.destination_airport, t.via_1_airport, t.via_2_airport, t.via_3_airport FROM com_flight_info t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND scheduled_date_time = ?  AND flight_number = ?  AND origin_airport = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.scheduled_date_time, t.flight_number, t.origin_airport, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.destination_airport, t.via_1_airport, t.via_2_airport, t.via_3_airport FROM com_flight_info t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND scheduled_date_time = ?  AND flight_number = ?  AND origin_airport = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_flight_info(organization_id, scheduled_date_time, flight_number, origin_airport, create_date, create_user_id, update_date, update_user_id, destination_airport, via_1_airport, via_2_airport, via_3_airport) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._scheduledDateTime, this._flightNumber, this._originAirport, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._destinationAirport, this._via1Airport, this._via2Airport, this._via3Airport } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_flight_info SET update_date = ?, update_user_id = ?, destination_airport = ?, via_1_airport = ?, via_2_airport = ?, via_3_airport = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._destinationAirport, this._via1Airport, this._via2Airport, this._via3Airport } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_flight_info" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND scheduled_date_time = ?  AND flight_number = ?  AND origin_airport = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND scheduled_date_time = ?  AND flight_number = ?  AND origin_airport = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._scheduledDateTime, this._flightNumber, this._originAirport };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "com_flight_info";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new FlightInformationFiller(this);
/*     */   }
/*     */   
/*     */   private static class FlightInformationFiller
/*     */     implements IFiller {
/*     */     private FlightInformationDBA _parent;
/*     */     
/*     */     public FlightInformationFiller(FlightInformationDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 136 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 137 */       if (t2 != null) {
/* 138 */         this._parent._scheduledDateTime = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._scheduledDateTime = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._flightNumber = argResultSet.getString(3);
/* 145 */       this._parent._originAirport = argResultSet.getString(4);
/*     */       
/* 147 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 148 */       if (t5 != null) {
/* 149 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 157 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 158 */       if (t7 != null) {
/* 159 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._updateUserId = argResultSet.getString(8);
/* 166 */       this._parent._destinationAirport = argResultSet.getString(9);
/* 167 */       this._parent._via1Airport = argResultSet.getString(10);
/* 168 */       this._parent._via2Airport = argResultSet.getString(11);
/* 169 */       this._parent._via3Airport = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 174 */     argDAO.suppressStateChanges(true);
/* 175 */     FlightInformationDAO dao = (FlightInformationDAO)argDAO;
/* 176 */     dao.setOrganizationId(this._organizationId);
/* 177 */     dao.setScheduledDateTime(this._scheduledDateTime);
/* 178 */     dao.setFlightNumber(this._flightNumber);
/* 179 */     dao.setOriginAirport(this._originAirport);
/* 180 */     dao.setCreateDate(this._createDate);
/* 181 */     dao.setCreateUserId(this._createUserId);
/* 182 */     dao.setUpdateDate(this._updateDate);
/* 183 */     dao.setUpdateUserId(this._updateUserId);
/* 184 */     dao.setDestinationAirport(this._destinationAirport);
/* 185 */     dao.setVia1Airport(this._via1Airport);
/* 186 */     dao.setVia2Airport(this._via2Airport);
/* 187 */     dao.setVia3Airport(this._via3Airport);
/* 188 */     argDAO.suppressStateChanges(false);
/* 189 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 193 */     return loadDAO((IDataAccessObject)new FlightInformationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 197 */     FlightInformationDAO dao = (FlightInformationDAO)argDAO;
/* 198 */     this._organizationId = dao.getOrganizationId();
/* 199 */     this._scheduledDateTime = dao.getScheduledDateTime();
/* 200 */     this._flightNumber = dao.getFlightNumber();
/* 201 */     this._originAirport = dao.getOriginAirport();
/* 202 */     this._createDate = dao.getCreateDate();
/* 203 */     this._createUserId = dao.getCreateUserId();
/* 204 */     this._updateDate = dao.getUpdateDate();
/* 205 */     this._updateUserId = dao.getUpdateUserId();
/* 206 */     this._destinationAirport = dao.getDestinationAirport();
/* 207 */     this._via1Airport = dao.getVia1Airport();
/* 208 */     this._via2Airport = dao.getVia2Airport();
/* 209 */     this._via3Airport = dao.getVia3Airport();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 213 */     FlightInformationId id = (FlightInformationId)argId;
/* 214 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 215 */     argStatement.setTimestamp(2, new Timestamp(id.getScheduledDateTime().getTime()));
/* 216 */     argStatement.setString(3, id.getFlightNumber());
/* 217 */     argStatement.setString(4, id.getOriginAirport());
/* 218 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     FlightInformationId id = new FlightInformationId();
/* 223 */     id.setOrganizationId(this._organizationId);
/* 224 */     id.setScheduledDateTime(this._scheduledDateTime);
/* 225 */     id.setFlightNumber(this._flightNumber);
/* 226 */     id.setOriginAirport(this._originAirport);
/* 227 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 235 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 239 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\FlightInformationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */