/*     */ package dtv.data2.access.impl.jdbc;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.URL;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.NClob;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Ref;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.RowId;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLType;
/*     */ import java.sql.SQLXML;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Calendar;
/*     */ 
/*     */ public class WrapperPreparedStatement<E extends PreparedStatement> extends WrapperStatement<E> implements PreparedStatement {
/*     */   WrapperPreparedStatement(E argStatement, String argSql, String argDatasourceName) {
/*  25 */     super(argStatement, argSql, argDatasourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBatch() throws SQLException {
/*  32 */     ((PreparedStatement)this._statement).addBatch();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearParameters() throws SQLException {
/*  39 */     clearParameters();
/*  40 */     ((PreparedStatement)this._statement).clearParameters();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute() throws SQLException {
/*  47 */     startExecute(new String[0]);
/*     */     try {
/*  49 */       return ((PreparedStatement)this._statement).execute();
/*     */     } finally {
/*     */       
/*  52 */       log("execute");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long executeLargeUpdate() throws SQLException {
/*  60 */     startExecute(new String[0]);
/*     */     try {
/*  62 */       return ((PreparedStatement)this._statement).executeLargeUpdate();
/*     */     } finally {
/*     */       
/*  65 */       log("execute");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet executeQuery() throws SQLException {
/*  73 */     startExecute(new String[0]);
/*     */     try {
/*  75 */       return ((PreparedStatement)this._statement).executeQuery();
/*     */     } finally {
/*     */       
/*  78 */       log("execute");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate() throws SQLException {
/*  86 */     startExecute(new String[0]);
/*     */     try {
/*  88 */       return ((PreparedStatement)this._statement).executeUpdate();
/*     */     } finally {
/*     */       
/*  91 */       log("execute");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSetMetaData getMetaData() throws SQLException {
/*  99 */     return ((PreparedStatement)this._statement).getMetaData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParameterMetaData getParameterMetaData() throws SQLException {
/* 106 */     return ((PreparedStatement)this._statement).getParameterMetaData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArray(int argParameterIndex, Array argX) throws SQLException {
/* 113 */     addParameter(argX);
/* 114 */     ((PreparedStatement)this._statement).setArray(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(int argParameterIndex, InputStream argX) throws SQLException {
/* 121 */     addParameter(argX);
/* 122 */     ((PreparedStatement)this._statement).setAsciiStream(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(int argParameterIndex, InputStream argX, int argLength) throws SQLException {
/* 129 */     addParameter(argX);
/* 130 */     ((PreparedStatement)this._statement).setAsciiStream(argParameterIndex, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(int argParameterIndex, InputStream argX, long argLength) throws SQLException {
/* 137 */     addParameter(argX);
/* 138 */     ((PreparedStatement)this._statement).setAsciiStream(argParameterIndex, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBigDecimal(int argParameterIndex, BigDecimal argX) throws SQLException {
/* 145 */     addParameter(argX);
/* 146 */     ((PreparedStatement)this._statement).setBigDecimal(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(int argParameterIndex, InputStream argX) throws SQLException {
/* 153 */     addParameter(argX);
/* 154 */     ((PreparedStatement)this._statement).setBinaryStream(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(int argParameterIndex, InputStream argX, int argLength) throws SQLException {
/* 161 */     addParameter(argX);
/* 162 */     ((PreparedStatement)this._statement).setBinaryStream(argParameterIndex, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(int argParameterIndex, InputStream argX, long argLength) throws SQLException {
/* 169 */     addParameter(argX);
/* 170 */     ((PreparedStatement)this._statement).setBinaryStream(argParameterIndex, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(int argParameterIndex, Blob argX) throws SQLException {
/* 177 */     addParameter(argX);
/* 178 */     ((PreparedStatement)this._statement).setBlob(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(int argParameterIndex, InputStream argInputStream) throws SQLException {
/* 185 */     addParameter(argInputStream);
/* 186 */     ((PreparedStatement)this._statement).setBlob(argParameterIndex, argInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(int argParameterIndex, InputStream argInputStream, long argLength) throws SQLException {
/* 193 */     addParameter(argInputStream);
/* 194 */     ((PreparedStatement)this._statement).setBlob(argParameterIndex, argInputStream, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoolean(int argParameterIndex, boolean argX) throws SQLException {
/* 201 */     addParameter(argX);
/* 202 */     ((PreparedStatement)this._statement).setBoolean(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByte(int argParameterIndex, byte argX) throws SQLException {
/* 209 */     addParameter(argX);
/* 210 */     ((PreparedStatement)this._statement).setByte(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBytes(int argParameterIndex, byte[] argX) throws SQLException {
/* 217 */     addParameter(argX);
/* 218 */     ((PreparedStatement)this._statement).setBytes(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(int argParameterIndex, Reader argReader) throws SQLException {
/* 225 */     addParameter(argReader);
/* 226 */     ((PreparedStatement)this._statement).setCharacterStream(argParameterIndex, argReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(int argParameterIndex, Reader argReader, int argLength) throws SQLException {
/* 233 */     addParameter(argReader);
/* 234 */     ((PreparedStatement)this._statement).setCharacterStream(argParameterIndex, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(int argParameterIndex, Reader argReader, long argLength) throws SQLException {
/* 241 */     addParameter(argReader);
/* 242 */     ((PreparedStatement)this._statement).setCharacterStream(argParameterIndex, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(int argParameterIndex, Clob argX) throws SQLException {
/* 249 */     addParameter(argX);
/* 250 */     ((PreparedStatement)this._statement).setClob(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(int argParameterIndex, Reader argReader) throws SQLException {
/* 257 */     addParameter(argReader);
/* 258 */     ((PreparedStatement)this._statement).setClob(argParameterIndex, argReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(int argParameterIndex, Reader argReader, long argLength) throws SQLException {
/* 265 */     addParameter(argReader);
/* 266 */     ((PreparedStatement)this._statement).setClob(argParameterIndex, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(int argParameterIndex, Date argX) throws SQLException {
/* 273 */     addParameter(argX);
/* 274 */     ((PreparedStatement)this._statement).setDate(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(int argParameterIndex, Date argX, Calendar argCal) throws SQLException {
/* 281 */     addParameter(argX);
/* 282 */     ((PreparedStatement)this._statement).setDate(argParameterIndex, argX, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDouble(int argParameterIndex, double argX) throws SQLException {
/* 289 */     addParameter(argX);
/* 290 */     ((PreparedStatement)this._statement).setDouble(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFloat(int argParameterIndex, float argX) throws SQLException {
/* 297 */     addParameter(argX);
/* 298 */     ((PreparedStatement)this._statement).setFloat(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInt(int argParameterIndex, int argX) throws SQLException {
/* 305 */     addParameter(argX);
/* 306 */     ((PreparedStatement)this._statement).setInt(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLong(int argParameterIndex, long argX) throws SQLException {
/* 313 */     addParameter(argX);
/* 314 */     ((PreparedStatement)this._statement).setLong(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNCharacterStream(int argParameterIndex, Reader argValue) throws SQLException {
/* 321 */     addParameter(argValue);
/* 322 */     ((PreparedStatement)this._statement).setNCharacterStream(argParameterIndex, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNCharacterStream(int argParameterIndex, Reader argValue, long argLength) throws SQLException {
/* 329 */     addParameter(argValue);
/* 330 */     ((PreparedStatement)this._statement).setNCharacterStream(argParameterIndex, argValue, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNClob(int argParameterIndex, NClob argValue) throws SQLException {
/* 337 */     addParameter(argValue);
/* 338 */     ((PreparedStatement)this._statement).setNClob(argParameterIndex, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNClob(int argParameterIndex, Reader argReader) throws SQLException {
/* 345 */     addParameter(argReader);
/* 346 */     ((PreparedStatement)this._statement).setNClob(argParameterIndex, argReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNClob(int argParameterIndex, Reader argReader, long argLength) throws SQLException {
/* 353 */     addParameter(argReader);
/* 354 */     ((PreparedStatement)this._statement).setNClob(argParameterIndex, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNString(int argParameterIndex, String argValue) throws SQLException {
/* 361 */     addParameter(argValue);
/* 362 */     ((PreparedStatement)this._statement).setNString(argParameterIndex, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNull(int argParameterIndex, int argSqlType) throws SQLException {
/* 369 */     addParameter((Object)null);
/* 370 */     ((PreparedStatement)this._statement).setNull(argParameterIndex, argSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNull(int argParameterIndex, int argSqlType, String argTypeName) throws SQLException {
/* 377 */     addParameter((Object)null);
/* 378 */     ((PreparedStatement)this._statement).setNull(argParameterIndex, argSqlType, argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int argParameterIndex, Object argX) throws SQLException {
/* 385 */     addParameter(argX);
/* 386 */     ((PreparedStatement)this._statement).setObject(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int argParameterIndex, Object argX, int argTargetSqlType) throws SQLException {
/* 393 */     addParameter(argX);
/* 394 */     ((PreparedStatement)this._statement).setObject(argParameterIndex, argX, argTargetSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int argParameterIndex, Object argX, int argTargetSqlType, int argScaleOrLength) throws SQLException {
/* 401 */     addParameter(argX);
/* 402 */     ((PreparedStatement)this._statement).setObject(argParameterIndex, argX, argTargetSqlType, argScaleOrLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int argParameterIndex, Object argX, SQLType argTargetSqlType) throws SQLException {
/* 409 */     addParameter(argX);
/* 410 */     ((PreparedStatement)this._statement).setObject(argParameterIndex, argX, argTargetSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int argParameterIndex, Object argX, SQLType argTargetSqlType, int argScaleOrLength) throws SQLException {
/* 417 */     addParameter(argX);
/* 418 */     ((PreparedStatement)this._statement).setObject(argParameterIndex, argX, argTargetSqlType, argScaleOrLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRef(int argParameterIndex, Ref argX) throws SQLException {
/* 425 */     addParameter(argX);
/* 426 */     ((PreparedStatement)this._statement).setRef(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowId(int argParameterIndex, RowId argX) throws SQLException {
/* 433 */     addParameter(argX);
/* 434 */     ((PreparedStatement)this._statement).setRowId(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShort(int argParameterIndex, short argX) throws SQLException {
/* 441 */     addParameter(argX);
/* 442 */     ((PreparedStatement)this._statement).setShort(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSQLXML(int argParameterIndex, SQLXML argXmlObject) throws SQLException {
/* 449 */     addParameter(argXmlObject);
/* 450 */     ((PreparedStatement)this._statement).setSQLXML(argParameterIndex, argXmlObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(int argParameterIndex, String argX) throws SQLException {
/* 457 */     addParameter(argX);
/* 458 */     ((PreparedStatement)this._statement).setString(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTime(int argParameterIndex, Time argX) throws SQLException {
/* 465 */     addParameter(argX);
/* 466 */     ((PreparedStatement)this._statement).setTime(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTime(int argParameterIndex, Time argX, Calendar argCal) throws SQLException {
/* 473 */     addParameter(argX);
/* 474 */     ((PreparedStatement)this._statement).setTime(argParameterIndex, argX, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(int argParameterIndex, Timestamp argX) throws SQLException {
/* 481 */     addParameter(argX);
/* 482 */     ((PreparedStatement)this._statement).setTimestamp(argParameterIndex, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(int argParameterIndex, Timestamp argX, Calendar argCal) throws SQLException {
/* 489 */     addParameter(argX);
/* 490 */     ((PreparedStatement)this._statement).setTimestamp(argParameterIndex, argX, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setUnicodeStream(int argParameterIndex, InputStream argX, int argLength) throws SQLException {
/* 501 */     addParameter(argX);
/* 502 */     ((PreparedStatement)this._statement).setUnicodeStream(argParameterIndex, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setURL(int argParameterIndex, URL argX) throws SQLException {
/* 509 */     addParameter(argX);
/* 510 */     ((PreparedStatement)this._statement).setURL(argParameterIndex, argX);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\WrapperPreparedStatement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */