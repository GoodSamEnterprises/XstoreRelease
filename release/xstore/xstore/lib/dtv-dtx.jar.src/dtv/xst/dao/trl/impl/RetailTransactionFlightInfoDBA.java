/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionFlightInfoId;
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
/*     */ public class RetailTransactionFlightInfoDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 978775385L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _flightNumber;
/*     */   private String _destinationAirport;
/*     */   private String _destinationCountry;
/*     */   private String _destinationZone;
/*     */   private String _destinationAirportName;
/*     */   private String _originAirport;
/*     */   private String _taxCalculationMode;
/*     */   private String _firstFlightNumber;
/*     */   private String _firstDestinationAirport;
/*     */   private String _firstOriginAirport;
/*     */   private String _firstFlightSeatNumber;
/*     */   private Date _firstFlightScheduledDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.flight_number, t.destination_airport, t.destination_country, t.destination_zone, t.destination_airport_name, t.origin_airport, t.tax_calculation_mode, t.first_flight_number, t.first_destination_airport, t.first_origin_airport, t.first_flight_seat_number, t.first_flight_scheduled_date FROM trl_rtrans_flight_info t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.flight_number, t.destination_airport, t.destination_country, t.destination_zone, t.destination_airport_name, t.origin_airport, t.tax_calculation_mode, t.first_flight_number, t.first_destination_airport, t.first_origin_airport, t.first_flight_seat_number, t.first_flight_scheduled_date FROM trl_rtrans_flight_info t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_rtrans_flight_info(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, flight_number, destination_airport, destination_country, destination_zone, destination_airport_name, origin_airport, tax_calculation_mode, first_flight_number, first_destination_airport, first_origin_airport, first_flight_seat_number, first_flight_scheduled_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._flightNumber, this._destinationAirport, this._destinationCountry, this._destinationZone, this._destinationAirportName, this._originAirport, this._taxCalculationMode, this._firstFlightNumber, this._firstDestinationAirport, this._firstOriginAirport, this._firstFlightSeatNumber, this._firstFlightScheduledDate } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_rtrans_flight_info SET update_date = ?, update_user_id = ?, flight_number = ?, destination_airport = ?, destination_country = ?, destination_zone = ?, destination_airport_name = ?, origin_airport = ?, tax_calculation_mode = ?, first_flight_number = ?, first_destination_airport = ?, first_origin_airport = ?, first_flight_seat_number = ?, first_flight_scheduled_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._flightNumber, this._destinationAirport, this._destinationCountry, this._destinationZone, this._destinationAirportName, this._originAirport, this._taxCalculationMode, this._firstFlightNumber, this._firstDestinationAirport, this._firstOriginAirport, this._firstFlightSeatNumber, this._firstFlightScheduledDate } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_rtrans_flight_info" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "trl_rtrans_flight_info";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new RetailTransactionFlightInfoFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailTransactionFlightInfoFiller
/*     */     implements IFiller {
/*     */     private RetailTransactionFlightInfoDBA _parent;
/*     */     
/*     */     public RetailTransactionFlightInfoFiller(RetailTransactionFlightInfoDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       long primitiveResult = argResultSet.getLong(1);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       primitiveResult = argResultSet.getLong(2);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 148 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 153 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 154 */       if (t3 != null) {
/* 155 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 163 */       long l1 = argResultSet.getLong(4);
/* 164 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 165 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       l1 = argResultSet.getLong(5);
/* 172 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 173 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 178 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 179 */       if (t6 != null) {
/* 180 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 188 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 189 */       if (t8 != null) {
/* 190 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._updateUserId = argResultSet.getString(9);
/* 197 */       this._parent._flightNumber = argResultSet.getString(10);
/* 198 */       this._parent._destinationAirport = argResultSet.getString(11);
/* 199 */       this._parent._destinationCountry = argResultSet.getString(12);
/* 200 */       this._parent._destinationZone = argResultSet.getString(13);
/* 201 */       this._parent._destinationAirportName = argResultSet.getString(14);
/* 202 */       this._parent._originAirport = argResultSet.getString(15);
/* 203 */       this._parent._taxCalculationMode = argResultSet.getString(16);
/* 204 */       this._parent._firstFlightNumber = argResultSet.getString(17);
/* 205 */       this._parent._firstDestinationAirport = argResultSet.getString(18);
/* 206 */       this._parent._firstOriginAirport = argResultSet.getString(19);
/* 207 */       this._parent._firstFlightSeatNumber = argResultSet.getString(20);
/*     */       
/* 209 */       Timestamp t21 = argResultSet.getTimestamp(21);
/* 210 */       if (t21 != null) {
/* 211 */         this._parent._firstFlightScheduledDate = (Date)new DtvDate(t21.getTime());
/*     */       } else {
/*     */         
/* 214 */         this._parent._firstFlightScheduledDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 221 */     argDAO.suppressStateChanges(true);
/* 222 */     RetailTransactionFlightInfoDAO dao = (RetailTransactionFlightInfoDAO)argDAO;
/* 223 */     dao.setOrganizationId(this._organizationId);
/* 224 */     dao.setRetailLocationId(this._retailLocationId);
/* 225 */     dao.setBusinessDate(this._businessDate);
/* 226 */     dao.setWorkstationId(this._workstationId);
/* 227 */     dao.setTransactionSequence(this._transactionSequence);
/* 228 */     dao.setCreateDate(this._createDate);
/* 229 */     dao.setCreateUserId(this._createUserId);
/* 230 */     dao.setUpdateDate(this._updateDate);
/* 231 */     dao.setUpdateUserId(this._updateUserId);
/* 232 */     dao.setFlightNumber(this._flightNumber);
/* 233 */     dao.setDestinationAirport(this._destinationAirport);
/* 234 */     dao.setDestinationCountry(this._destinationCountry);
/* 235 */     dao.setDestinationZone(this._destinationZone);
/* 236 */     dao.setDestinationAirportName(this._destinationAirportName);
/* 237 */     dao.setOriginAirport(this._originAirport);
/* 238 */     dao.setTaxCalculationMode(this._taxCalculationMode);
/* 239 */     dao.setFirstFlightNumber(this._firstFlightNumber);
/* 240 */     dao.setFirstDestinationAirport(this._firstDestinationAirport);
/* 241 */     dao.setFirstOriginAirport(this._firstOriginAirport);
/* 242 */     dao.setFirstFlightSeatNumber(this._firstFlightSeatNumber);
/* 243 */     dao.setFirstFlightScheduledDate(this._firstFlightScheduledDate);
/* 244 */     argDAO.suppressStateChanges(false);
/* 245 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 249 */     return loadDAO((IDataAccessObject)new RetailTransactionFlightInfoDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 253 */     RetailTransactionFlightInfoDAO dao = (RetailTransactionFlightInfoDAO)argDAO;
/* 254 */     this._organizationId = dao.getOrganizationId();
/* 255 */     this._retailLocationId = dao.getRetailLocationId();
/* 256 */     this._businessDate = dao.getBusinessDate();
/* 257 */     this._workstationId = dao.getWorkstationId();
/* 258 */     this._transactionSequence = dao.getTransactionSequence();
/* 259 */     this._createDate = dao.getCreateDate();
/* 260 */     this._createUserId = dao.getCreateUserId();
/* 261 */     this._updateDate = dao.getUpdateDate();
/* 262 */     this._updateUserId = dao.getUpdateUserId();
/* 263 */     this._flightNumber = dao.getFlightNumber();
/* 264 */     this._destinationAirport = dao.getDestinationAirport();
/* 265 */     this._destinationCountry = dao.getDestinationCountry();
/* 266 */     this._destinationZone = dao.getDestinationZone();
/* 267 */     this._destinationAirportName = dao.getDestinationAirportName();
/* 268 */     this._originAirport = dao.getOriginAirport();
/* 269 */     this._taxCalculationMode = dao.getTaxCalculationMode();
/* 270 */     this._firstFlightNumber = dao.getFirstFlightNumber();
/* 271 */     this._firstDestinationAirport = dao.getFirstDestinationAirport();
/* 272 */     this._firstOriginAirport = dao.getFirstOriginAirport();
/* 273 */     this._firstFlightSeatNumber = dao.getFirstFlightSeatNumber();
/* 274 */     this._firstFlightScheduledDate = dao.getFirstFlightScheduledDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 278 */     RetailTransactionFlightInfoId id = (RetailTransactionFlightInfoId)argId;
/* 279 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 280 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 281 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 282 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 283 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 284 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 288 */     RetailTransactionFlightInfoId id = new RetailTransactionFlightInfoId();
/* 289 */     id.setOrganizationId(this._organizationId);
/* 290 */     id.setRetailLocationId(this._retailLocationId);
/* 291 */     id.setBusinessDate(this._businessDate);
/* 292 */     id.setWorkstationId(this._workstationId);
/* 293 */     id.setTransactionSequence(this._transactionSequence);
/* 294 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 302 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 306 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionFlightInfoDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */