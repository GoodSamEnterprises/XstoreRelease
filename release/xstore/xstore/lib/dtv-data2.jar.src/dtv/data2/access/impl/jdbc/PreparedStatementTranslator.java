/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.util.DateUtils;
/*    */ import java.util.Collection;
/*    */ import java.util.Date;
/*    */ import java.util.Map;
/*    */ import java.util.StringTokenizer;
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
/*    */ 
/*    */ public class PreparedStatementTranslator
/*    */ {
/*    */   public static String getPrettySql(String sql, Collection<Object> logParams) {
/* 25 */     StringTokenizer st = new StringTokenizer(sql, "?");
/* 26 */     StringBuilder statement = new StringBuilder(256);
/*    */     
/* 28 */     int count = 0;
/* 29 */     while (st.hasMoreTokens()) {
/* 30 */       statement.append(st.nextToken());
/* 31 */       if (count < logParams.size()) {
/* 32 */         Object currentParameter = logParams.toArray()[count];
/* 33 */         if (currentParameter != null) {
/* 34 */           if (currentParameter instanceof Number) {
/* 35 */             statement.append(currentParameter);
/*    */           }
/* 37 */           else if (currentParameter instanceof Date) {
/*    */ 
/*    */ 
/*    */             
/* 41 */             statement.append("to_date('").append(DateUtils.formatIsoDateTime((Date)currentParameter))
/* 42 */               .append("', 'YYYY-MM-DD\"T\"HH24:MI:SS')");
/*    */           }
/* 44 */           else if (currentParameter instanceof String && ((String)currentParameter)
/* 45 */             .startsWith("[SQL NULL of type ")) {
/* 46 */             statement.append("null");
/*    */           } else {
/*    */             
/* 49 */             statement.append("'").append(currentParameter).append("'");
/*    */           }
/*    */         
/*    */         } else {
/*    */           
/* 54 */           statement.append("null");
/*    */         
/*    */         }
/*    */       
/*    */       }
/* 59 */       else if (st.hasMoreTokens()) {
/* 60 */         statement.append("? ").append("(missing variable # ").append(count).append(") ");
/*    */       } 
/*    */       
/* 63 */       count++;
/*    */     } 
/* 65 */     return statement.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getPrettySql(String sql, Map<Object, Object> logParams) {
/* 75 */     return getPrettySql(sql, logParams.values());
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\PreparedStatementTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */