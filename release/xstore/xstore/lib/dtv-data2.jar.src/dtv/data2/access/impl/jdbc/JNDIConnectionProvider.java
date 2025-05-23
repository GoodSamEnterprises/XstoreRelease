/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.naming.NamingException;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class JNDIConnectionProvider
/*    */   implements JDBCConnectionProvider
/*    */ {
/*    */   static final String JNDI_URL_PREFIX = "jndi:";
/*    */   private final String _datasourceName;
/*    */   private final DataSource _jndiDatasource;
/*    */   
/*    */   protected JNDIConnectionProvider(JDBCConnectionTemplate argTemplate) throws NamingException {
/* 28 */     String jndiUrl = argTemplate.getUrl().replaceFirst("jndi:", "");
/* 29 */     Context initContext = new InitialContext();
/*    */     try {
/* 31 */       this._jndiDatasource = (DataSource)initContext.lookup(jndiUrl);
/*    */     } finally {
/*    */       
/* 34 */       initContext.close();
/*    */     } 
/* 36 */     this._datasourceName = argTemplate.getDataSourceName();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Connection getConnection() throws SQLException {
/* 43 */     return this._jndiDatasource.getConnection();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 49 */     return this._datasourceName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPoolSize() {
/* 55 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JNDIConnectionProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */