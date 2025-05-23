/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.URL;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Date;
/*     */ import java.sql.NClob;
/*     */ import java.sql.Ref;
/*     */ import java.sql.RowId;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLType;
/*     */ import java.sql.SQLXML;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class WrapperCallableStatement<E extends CallableStatement>
/*     */   extends WrapperPreparedStatement<E> implements CallableStatement {
/*     */   WrapperCallableStatement(E argStatement, String argSql, String argDatasourceName) {
/*  26 */     super(argStatement, argSql, argDatasourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array getArray(int argParameterIndex) throws SQLException {
/*  33 */     return ((CallableStatement)this._statement).getArray(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array getArray(String argParameterName) throws SQLException {
/*  40 */     return ((CallableStatement)this._statement).getArray(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(int argParameterIndex) throws SQLException {
/*  47 */     return ((CallableStatement)this._statement).getBigDecimal(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public BigDecimal getBigDecimal(int argParameterIndex, int argScale) throws SQLException {
/*  59 */     return ((CallableStatement)this._statement).getBigDecimal(argParameterIndex, argScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(String argParameterName) throws SQLException {
/*  66 */     return ((CallableStatement)this._statement).getBigDecimal(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Blob getBlob(int argParameterIndex) throws SQLException {
/*  73 */     return ((CallableStatement)this._statement).getBlob(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Blob getBlob(String argParameterName) throws SQLException {
/*  80 */     return ((CallableStatement)this._statement).getBlob(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBoolean(int argParameterIndex) throws SQLException {
/*  87 */     return ((CallableStatement)this._statement).getBoolean(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String argParameterName) throws SQLException {
/*  94 */     return ((CallableStatement)this._statement).getBoolean(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getByte(int argParameterIndex) throws SQLException {
/* 101 */     return ((CallableStatement)this._statement).getByte(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getByte(String argParameterName) throws SQLException {
/* 108 */     return ((CallableStatement)this._statement).getByte(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes(int argParameterIndex) throws SQLException {
/* 115 */     return ((CallableStatement)this._statement).getBytes(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes(String argParameterName) throws SQLException {
/* 122 */     return ((CallableStatement)this._statement).getBytes(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getCharacterStream(int argParameterIndex) throws SQLException {
/* 129 */     return ((CallableStatement)this._statement).getCharacterStream(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getCharacterStream(String argParameterName) throws SQLException {
/* 136 */     return ((CallableStatement)this._statement).getCharacterStream(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Clob getClob(int argParameterIndex) throws SQLException {
/* 143 */     return ((CallableStatement)this._statement).getClob(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Clob getClob(String argParameterName) throws SQLException {
/* 150 */     return ((CallableStatement)this._statement).getClob(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate(int argParameterIndex) throws SQLException {
/* 157 */     return ((CallableStatement)this._statement).getDate(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate(int argParameterIndex, Calendar argCal) throws SQLException {
/* 164 */     return ((CallableStatement)this._statement).getDate(argParameterIndex, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate(String argParameterName) throws SQLException {
/* 171 */     return ((CallableStatement)this._statement).getDate(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate(String argParameterName, Calendar argCal) throws SQLException {
/* 178 */     return ((CallableStatement)this._statement).getDate(argParameterName, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDouble(int argParameterIndex) throws SQLException {
/* 185 */     return ((CallableStatement)this._statement).getDouble(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDouble(String argParameterName) throws SQLException {
/* 192 */     return ((CallableStatement)this._statement).getDouble(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFloat(int argParameterIndex) throws SQLException {
/* 199 */     return ((CallableStatement)this._statement).getFloat(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFloat(String argParameterName) throws SQLException {
/* 206 */     return ((CallableStatement)this._statement).getFloat(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt(int argParameterIndex) throws SQLException {
/* 213 */     return ((CallableStatement)this._statement).getInt(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt(String argParameterName) throws SQLException {
/* 220 */     return ((CallableStatement)this._statement).getInt(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLong(int argParameterIndex) throws SQLException {
/* 227 */     return ((CallableStatement)this._statement).getLong(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLong(String argParameterName) throws SQLException {
/* 234 */     return ((CallableStatement)this._statement).getLong(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getNCharacterStream(int argParameterIndex) throws SQLException {
/* 241 */     return ((CallableStatement)this._statement).getNCharacterStream(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getNCharacterStream(String argParameterName) throws SQLException {
/* 248 */     return ((CallableStatement)this._statement).getNCharacterStream(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NClob getNClob(int argParameterIndex) throws SQLException {
/* 255 */     return ((CallableStatement)this._statement).getNClob(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NClob getNClob(String argParameterName) throws SQLException {
/* 262 */     return ((CallableStatement)this._statement).getNClob(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNString(int argParameterIndex) throws SQLException {
/* 269 */     return ((CallableStatement)this._statement).getNString(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNString(String argParameterName) throws SQLException {
/* 276 */     return ((CallableStatement)this._statement).getNString(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(int argParameterIndex) throws SQLException {
/* 283 */     return ((CallableStatement)this._statement).getObject(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T getObject(int argParameterIndex, Class<T> argType) throws SQLException {
/* 290 */     return ((CallableStatement)this._statement).getObject(argParameterIndex, argType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(int argParameterIndex, Map<String, Class<?>> argMap) throws SQLException {
/* 297 */     return ((CallableStatement)this._statement).getObject(argParameterIndex, argMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(String argParameterName) throws SQLException {
/* 304 */     return ((CallableStatement)this._statement).getObject(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T getObject(String argParameterName, Class<T> argType) throws SQLException {
/* 311 */     return ((CallableStatement)this._statement).getObject(argParameterName, argType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(String argParameterName, Map<String, Class<?>> argMap) throws SQLException {
/* 318 */     return ((CallableStatement)this._statement).getObject(argParameterName, argMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ref getRef(int argParameterIndex) throws SQLException {
/* 325 */     return ((CallableStatement)this._statement).getRef(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ref getRef(String argParameterName) throws SQLException {
/* 332 */     return ((CallableStatement)this._statement).getRef(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RowId getRowId(int argParameterIndex) throws SQLException {
/* 339 */     return ((CallableStatement)this._statement).getRowId(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RowId getRowId(String argParameterName) throws SQLException {
/* 346 */     return ((CallableStatement)this._statement).getRowId(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getShort(int argParameterIndex) throws SQLException {
/* 353 */     return ((CallableStatement)this._statement).getShort(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getShort(String argParameterName) throws SQLException {
/* 360 */     return ((CallableStatement)this._statement).getShort(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLXML getSQLXML(int argParameterIndex) throws SQLException {
/* 367 */     return ((CallableStatement)this._statement).getSQLXML(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLXML getSQLXML(String argParameterName) throws SQLException {
/* 374 */     return ((CallableStatement)this._statement).getSQLXML(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(int argParameterIndex) throws SQLException {
/* 381 */     return ((CallableStatement)this._statement).getString(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String argParameterName) throws SQLException {
/* 388 */     return ((CallableStatement)this._statement).getString(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Time getTime(int argParameterIndex) throws SQLException {
/* 395 */     return ((CallableStatement)this._statement).getTime(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Time getTime(int argParameterIndex, Calendar argCal) throws SQLException {
/* 402 */     return ((CallableStatement)this._statement).getTime(argParameterIndex, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Time getTime(String argParameterName) throws SQLException {
/* 409 */     return ((CallableStatement)this._statement).getTime(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Time getTime(String argParameterName, Calendar argCal) throws SQLException {
/* 416 */     return ((CallableStatement)this._statement).getTime(argParameterName, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp(int argParameterIndex) throws SQLException {
/* 423 */     return ((CallableStatement)this._statement).getTimestamp(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp(int argParameterIndex, Calendar argCal) throws SQLException {
/* 430 */     return ((CallableStatement)this._statement).getTimestamp(argParameterIndex, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp(String argParameterName) throws SQLException {
/* 437 */     return ((CallableStatement)this._statement).getTimestamp(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp(String argParameterName, Calendar argCal) throws SQLException {
/* 444 */     return ((CallableStatement)this._statement).getTimestamp(argParameterName, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URL getURL(int argParameterIndex) throws SQLException {
/* 451 */     return ((CallableStatement)this._statement).getURL(argParameterIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URL getURL(String argParameterName) throws SQLException {
/* 458 */     return ((CallableStatement)this._statement).getURL(argParameterName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int argParameterIndex, int argSqlType) throws SQLException {
/* 465 */     ((CallableStatement)this._statement).registerOutParameter(argParameterIndex, argSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int argParameterIndex, int argSqlType, int argScale) throws SQLException {
/* 472 */     ((CallableStatement)this._statement).registerOutParameter(argParameterIndex, argSqlType, argScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int argParameterIndex, int argSqlType, String argTypeName) throws SQLException {
/* 479 */     ((CallableStatement)this._statement).registerOutParameter(argParameterIndex, argSqlType, argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int argParameterIndex, SQLType argSqlType) throws SQLException {
/* 486 */     ((CallableStatement)this._statement).registerOutParameter(argParameterIndex, argSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int argParameterIndex, SQLType argSqlType, int argScale) throws SQLException {
/* 493 */     ((CallableStatement)this._statement).registerOutParameter(argParameterIndex, argSqlType, argScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int argParameterIndex, SQLType argSqlType, String argTypeName) throws SQLException {
/* 500 */     ((CallableStatement)this._statement).registerOutParameter(argParameterIndex, argSqlType, argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(String argParameterName, int argSqlType) throws SQLException {
/* 507 */     ((CallableStatement)this._statement).registerOutParameter(argParameterName, argSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(String argParameterName, int argSqlType, int argScale) throws SQLException {
/* 514 */     ((CallableStatement)this._statement).registerOutParameter(argParameterName, argSqlType, argScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(String argParameterName, int argSqlType, String argTypeName) throws SQLException {
/* 521 */     ((CallableStatement)this._statement).registerOutParameter(argParameterName, argSqlType, argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(String argParameterName, SQLType argSqlType) throws SQLException {
/* 528 */     ((CallableStatement)this._statement).registerOutParameter(argParameterName, argSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(String argParameterName, SQLType argSqlType, int argScale) throws SQLException {
/* 535 */     ((CallableStatement)this._statement).registerOutParameter(argParameterName, argSqlType, argScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(String argParameterName, SQLType argSqlType, String argTypeName) throws SQLException {
/* 542 */     ((CallableStatement)this._statement).registerOutParameter(argParameterName, argSqlType, argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(String argParameterName, InputStream argX) throws SQLException {
/* 549 */     addParameter(argX);
/* 550 */     ((CallableStatement)this._statement).setAsciiStream(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(String argParameterName, InputStream argX, int argLength) throws SQLException {
/* 557 */     addParameter(argX);
/* 558 */     ((CallableStatement)this._statement).setAsciiStream(argParameterName, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(String argParameterName, InputStream argX, long argLength) throws SQLException {
/* 565 */     addParameter(argX);
/* 566 */     ((CallableStatement)this._statement).setAsciiStream(argParameterName, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBigDecimal(String argParameterName, BigDecimal argX) throws SQLException {
/* 573 */     addParameter(argX);
/* 574 */     ((CallableStatement)this._statement).setBigDecimal(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(String argParameterName, InputStream argX) throws SQLException {
/* 581 */     addParameter(argX);
/* 582 */     ((CallableStatement)this._statement).setBinaryStream(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(String argParameterName, InputStream argX, int argLength) throws SQLException {
/* 589 */     addParameter(argX);
/* 590 */     ((CallableStatement)this._statement).setBinaryStream(argParameterName, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(String argParameterName, InputStream argX, long argLength) throws SQLException {
/* 597 */     addParameter(argX);
/* 598 */     ((CallableStatement)this._statement).setBinaryStream(argParameterName, argX, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(String argParameterName, Blob argX) throws SQLException {
/* 605 */     addParameter(argX);
/* 606 */     ((CallableStatement)this._statement).setBlob(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(String argParameterName, InputStream argInputStream) throws SQLException {
/* 613 */     addParameter(argInputStream);
/* 614 */     ((CallableStatement)this._statement).setBlob(argParameterName, argInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(String argParameterName, InputStream argInputStream, long argLength) throws SQLException {
/* 621 */     addParameter(argInputStream);
/* 622 */     ((CallableStatement)this._statement).setBlob(argParameterName, argInputStream, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoolean(String argParameterName, boolean argX) throws SQLException {
/* 629 */     addParameter(argX);
/* 630 */     ((CallableStatement)this._statement).setBoolean(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByte(String argParameterName, byte argX) throws SQLException {
/* 637 */     addParameter(argX);
/* 638 */     ((CallableStatement)this._statement).setByte(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBytes(String argParameterName, byte[] argX) throws SQLException {
/* 645 */     addParameter(argX);
/* 646 */     ((CallableStatement)this._statement).setBytes(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(String argParameterName, Reader argReader) throws SQLException {
/* 653 */     addParameter(argReader);
/* 654 */     ((CallableStatement)this._statement).setCharacterStream(argParameterName, argReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(String argParameterName, Reader argReader, int argLength) throws SQLException {
/* 661 */     addParameter(argReader);
/* 662 */     ((CallableStatement)this._statement).setCharacterStream(argParameterName, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(String argParameterName, Reader argReader, long argLength) throws SQLException {
/* 669 */     addParameter(argReader);
/* 670 */     ((CallableStatement)this._statement).setCharacterStream(argParameterName, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(String argParameterName, Clob argX) throws SQLException {
/* 677 */     addParameter(argX);
/* 678 */     ((CallableStatement)this._statement).setClob(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(String argParameterName, Reader argReader) throws SQLException {
/* 685 */     addParameter(argReader);
/* 686 */     ((CallableStatement)this._statement).setClob(argParameterName, argReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(String argParameterName, Reader argReader, long argLength) throws SQLException {
/* 693 */     addParameter(argReader);
/* 694 */     ((CallableStatement)this._statement).setClob(argParameterName, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(String argParameterName, Date argX) throws SQLException {
/* 701 */     addParameter(argX);
/* 702 */     ((CallableStatement)this._statement).setDate(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(String argParameterName, Date argX, Calendar argCal) throws SQLException {
/* 709 */     addParameter(argX);
/* 710 */     ((CallableStatement)this._statement).setDate(argParameterName, argX, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDouble(String argParameterName, double argX) throws SQLException {
/* 717 */     addParameter(argX);
/* 718 */     ((CallableStatement)this._statement).setDouble(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFloat(String argParameterName, float argX) throws SQLException {
/* 725 */     addParameter(argX);
/* 726 */     ((CallableStatement)this._statement).setFloat(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInt(String argParameterName, int argX) throws SQLException {
/* 733 */     addParameter(argX);
/* 734 */     ((CallableStatement)this._statement).setInt(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLong(String argParameterName, long argX) throws SQLException {
/* 741 */     addParameter(argX);
/* 742 */     ((CallableStatement)this._statement).setLong(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNCharacterStream(String argParameterName, Reader argValue) throws SQLException {
/* 749 */     addParameter(argValue);
/* 750 */     ((CallableStatement)this._statement).setNCharacterStream(argParameterName, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNCharacterStream(String argParameterName, Reader argValue, long argLength) throws SQLException {
/* 757 */     addParameter(argValue);
/* 758 */     ((CallableStatement)this._statement).setNCharacterStream(argParameterName, argValue, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNClob(String argParameterName, NClob argValue) throws SQLException {
/* 765 */     addParameter(argValue);
/* 766 */     ((CallableStatement)this._statement).setNClob(argParameterName, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNClob(String argParameterName, Reader argReader) throws SQLException {
/* 773 */     addParameter(argReader);
/* 774 */     ((CallableStatement)this._statement).setNClob(argParameterName, argReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNClob(String argParameterName, Reader argReader, long argLength) throws SQLException {
/* 781 */     addParameter(argReader);
/* 782 */     ((CallableStatement)this._statement).setNClob(argParameterName, argReader, argLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNString(String argParameterName, String argValue) throws SQLException {
/* 789 */     addParameter(argValue);
/* 790 */     ((CallableStatement)this._statement).setNString(argParameterName, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNull(String argParameterName, int argSqlType) throws SQLException {
/* 797 */     addParameter((Object)null);
/* 798 */     ((CallableStatement)this._statement).setNull(argParameterName, argSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNull(String argParameterName, int argSqlType, String argTypeName) throws SQLException {
/* 805 */     addParameter((Object)null);
/* 806 */     ((CallableStatement)this._statement).setNull(argParameterName, argSqlType, argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(String argParameterName, Object argX) throws SQLException {
/* 813 */     addParameter(argX);
/* 814 */     ((CallableStatement)this._statement).setObject(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(String argParameterName, Object argX, int argTargetSqlType) throws SQLException {
/* 821 */     addParameter(argX);
/* 822 */     ((CallableStatement)this._statement).setObject(argParameterName, argX, argTargetSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(String argParameterName, Object argX, int argTargetSqlType, int argScale) throws SQLException {
/* 829 */     addParameter(argX);
/* 830 */     ((CallableStatement)this._statement).setObject(argParameterName, argX, argTargetSqlType, argScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(String argParameterName, Object argX, SQLType argTargetSqlType) throws SQLException {
/* 837 */     addParameter(argX);
/* 838 */     ((CallableStatement)this._statement).setObject(argParameterName, argX, argTargetSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(String argParameterName, Object argX, SQLType argTargetSqlType, int argScaleOrLength) throws SQLException {
/* 845 */     addParameter(argX);
/* 846 */     ((CallableStatement)this._statement).setObject(argParameterName, argX, argTargetSqlType, argScaleOrLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowId(String argParameterName, RowId argX) throws SQLException {
/* 853 */     addParameter(argX);
/* 854 */     ((CallableStatement)this._statement).setRowId(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShort(String argParameterName, short argX) throws SQLException {
/* 861 */     addParameter(argX);
/* 862 */     ((CallableStatement)this._statement).setShort(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSQLXML(String argParameterName, SQLXML argXmlObject) throws SQLException {
/* 869 */     addParameter(argXmlObject);
/* 870 */     ((CallableStatement)this._statement).setSQLXML(argParameterName, argXmlObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(String argParameterName, String argX) throws SQLException {
/* 877 */     addParameter(argX);
/* 878 */     ((CallableStatement)this._statement).setString(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTime(String argParameterName, Time argX) throws SQLException {
/* 885 */     addParameter(argX);
/* 886 */     ((CallableStatement)this._statement).setTime(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTime(String argParameterName, Time argX, Calendar argCal) throws SQLException {
/* 893 */     addParameter(argX);
/* 894 */     ((CallableStatement)this._statement).setTime(argParameterName, argX, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(String argParameterName, Timestamp argX) throws SQLException {
/* 901 */     addParameter(argX);
/* 902 */     ((CallableStatement)this._statement).setTimestamp(argParameterName, argX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(String argParameterName, Timestamp argX, Calendar argCal) throws SQLException {
/* 909 */     addParameter(argX);
/* 910 */     ((CallableStatement)this._statement).setTimestamp(argParameterName, argX, argCal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setURL(String argParameterName, URL argVal) throws SQLException {
/* 917 */     addParameter(argVal);
/* 918 */     ((CallableStatement)this._statement).setURL(argParameterName, argVal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean wasNull() throws SQLException {
/* 925 */     return ((CallableStatement)this._statement).wasNull();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\WrapperCallableStatement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */