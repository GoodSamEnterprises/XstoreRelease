/*     */ package dtv.data2.dataloader.valuetranslator;
/*     */ 
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.impl.jdbc.JDBCDataSourceMgr;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.data2.dataloader.ConfigParameters;
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*     */ import dtv.util.StringUtils;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SqlQueryTranslator
/*     */   extends AbstractValueTranslator
/*     */ {
/*  34 */   private static final Logger logger_ = Logger.getLogger(SqlQueryTranslator.class);
/*     */   
/*  36 */   private final String PARAM_SQL = "sql";
/*  37 */   private final String PARAM_SQL_FIELD = "sql.field.";
/*  38 */   private final String PARAM_NULL_VALUE = "nullValue";
/*     */   
/*  40 */   private final Map<String, String> parameters_ = new HashMap<>(4);
/*     */   
/*     */   private String sql_;
/*  43 */   private final List<String> fieldValues = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private String nullValue_;
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/*  53 */     if (this.parameters_.containsKey(argName)) {
/*  54 */       throw new DataLoaderException("Duplicate key detected for SqlQueryTranslator. Key=" + argName + " Value=" + argValue);
/*     */     }
/*     */     
/*  57 */     this.parameters_.put(argName, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/*  63 */     String translatedValue = this.nullValue_;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     parseParameters(argCurrentValue, argCurrentLine);
/*  69 */     Connection connection = null;
/*  70 */     PreparedStatement statement = null;
/*  71 */     ResultSet results = null;
/*     */     
/*     */     try {
/*  74 */       connection = getConnection();
/*     */ 
/*     */ 
/*     */       
/*  78 */       statement = connection.prepareStatement(this.sql_);
/*     */       
/*  80 */       int counter = 1;
/*  81 */       for (String argument : this.fieldValues)
/*     */       {
/*  83 */         statement.setObject(counter++, getValueForArgument(argCurrentValue, argument, argCurrentLine));
/*     */       }
/*     */       
/*  86 */       statement.execute();
/*     */       
/*  88 */       results = statement.getResultSet();
/*     */       
/*  90 */       if (results.next()) {
/*  91 */         Object queryResult = results.getObject(1);
/*  92 */         if (queryResult instanceof Clob) {
/*  93 */           translatedValue = JDBCHelper.clobToString((Clob)queryResult);
/*     */         
/*     */         }
/*  96 */         else if (queryResult != null) {
/*  97 */           translatedValue = queryResult.toString();
/*     */         } 
/*     */ 
/*     */         
/* 101 */         if (StringUtils.isEmpty(translatedValue)) {
/* 102 */           translatedValue = this.nullValue_;
/*     */         }
/*     */       } 
/*     */       
/* 106 */       if (results.next()) {
/* 107 */         logger_.warn("SQL for SqlQueryTranslator returned more than one row, 1 row & 1 column result is expected for this translator. sql " + this.sql_);
/*     */       
/*     */       }
/*     */     }
/* 111 */     catch (Exception ee) {
/*     */ 
/*     */ 
/*     */       
/* 115 */       String msg = null;
/* 116 */       if (FailoverException.isFailover(ee)) {
/* 117 */         msg = "An unexpected failure occurred while execeuting sql [" + this.sql_ + "]";
/*     */       } else {
/*     */         
/* 120 */         msg = "Failed to execute sql  [" + this.sql_ + "]";
/*     */       } 
/* 122 */       logger_.warn(msg, ee);
/*     */     }
/*     */     finally {
/*     */       
/* 126 */       if (results != null) {
/*     */         try {
/* 128 */           results.close();
/*     */         }
/* 130 */         catch (SQLException e) {
/* 131 */           logger_.warn("An exception occurred while closing a result set", e);
/*     */         } 
/*     */       }
/* 134 */       if (statement != null) {
/*     */         try {
/* 136 */           statement.close();
/*     */         }
/* 138 */         catch (SQLException e) {
/* 139 */           logger_.warn("An exception occurred while closing a statement.", e);
/*     */         } 
/*     */       }
/* 142 */       if (connection != null) {
/*     */         try {
/* 144 */           connection.close();
/*     */         }
/* 146 */         catch (SQLException e) {
/* 147 */           logger_.warn("An exception occurred while closing a connection.", e);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 152 */     return translatedValue;
/*     */   }
/*     */   
/*     */   private Connection getConnection() {
/* 156 */     String dataSourceName = this._configParameters.getDataSource();
/*     */     
/* 158 */     if (StringUtils.isEmpty(dataSourceName)) {
/* 159 */       throw new DataLoaderException("Could not get datasource name from dataloader config parameters");
/*     */     }
/*     */     
/* 162 */     return (Connection)JDBCDataSourceMgr.getInstance().getConnection(dataSourceName);
/*     */   }
/*     */   
/*     */   private void parseParameters(String argCurrentValue, FileLine argCurrentLine) {
/* 166 */     if (this.parameters_.isEmpty()) {
/* 167 */       throw new DataLoaderException("No paramters provided for SqlQueryTranslator.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.sql_ = this.parameters_.get("sql");
/*     */     
/* 175 */     if (StringUtils.isEmpty(this.sql_)) {
/* 176 */       throw new DataLoaderException("SqlQueryTranslator requires paramter \"sql\" to be set.  Parameters: " + this.parameters_);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     int fieldCounter = 1;
/* 184 */     String currentField = null;
/*     */     
/*     */     do {
/* 187 */       String key = (new StringBuilder(12)).append("sql.field.").append(fieldCounter++).toString();
/* 188 */       currentField = this.parameters_.get(key);
/* 189 */       if (currentField == null)
/* 190 */         continue;  this.fieldValues.add(currentField);
/*     */     
/*     */     }
/* 193 */     while (currentField != null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     this.nullValue_ = getValueForArgument(argCurrentValue, this.parameters_.get("nullValue"), argCurrentLine);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\SqlQueryTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */