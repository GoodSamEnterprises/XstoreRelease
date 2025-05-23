/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.util.crypto.SecretKeyCipherStoreException;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import javax.naming.NamingException;
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
/*    */ 
/*    */ 
/*    */ public interface JDBCConnectionProvider
/*    */ {
/*    */   static JDBCConnectionProvider make(JDBCConnectionTemplate template) throws SecretKeyCipherStoreException, NamingException, SQLException {
/* 23 */     if (template.getUrl().startsWith("jndi:")) {
/* 24 */       return new JNDIConnectionProvider(template);
/*    */     }
/* 26 */     return new UcpConnectionProvider(template);
/*    */   }
/*    */ 
/*    */   
/*    */   default void close() {}
/*    */   
/*    */   Connection getConnection() throws SQLException;
/*    */   
/*    */   String getName();
/*    */   
/*    */   int getPoolSize();
/*    */   
/*    */   default CharSequence getStats() {
/* 39 */     return (new StringBuilder(100)).append("Info not Available in this Implementation (")
/* 40 */       .append(getClass().getName()).append(")");
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCConnectionProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */