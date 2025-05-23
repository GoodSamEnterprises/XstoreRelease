/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.util.DtvDate;
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
/*    */ public abstract class DaoDateFactory
/*    */ {
/* 18 */   public static final String SYSTEM_PROPERTY = DaoDateFactory.class.getName();
/*    */   
/*    */   private static DaoDateFactory INSTANCE;
/*    */ 
/*    */   
/*    */   static {
/* 24 */     String className = System.getProperty(SYSTEM_PROPERTY);
/*    */     
/*    */     try {
/* 27 */       instance = (DaoDateFactory)Class.forName(className).newInstance();
/*    */     }
/* 29 */     catch (Throwable ex) {
/* 30 */       instance = new GmtDateFactory();
/*    */     } 
/* 32 */     INSTANCE = instance;
/*    */   }
/*    */   
/*    */   static {
/*    */     DaoDateFactory instance;
/*    */   }
/*    */   
/*    */   public abstract DtvDate newDate();
/*    */   
/*    */   public static DaoDateFactory getInstance() {
/* 42 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\DaoDateFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */