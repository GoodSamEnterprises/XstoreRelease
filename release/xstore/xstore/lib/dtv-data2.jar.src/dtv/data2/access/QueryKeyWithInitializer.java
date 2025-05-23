/*    */ package dtv.data2.access;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryKeyWithInitializer<T extends IQueryResult>
/*    */   implements IQueryKey<T>
/*    */ {
/*    */   private final String name_;
/*    */   private final Class<T> resultClass_;
/*    */   private final Class<? extends IQueryResultInitializer<T>> initializerClass_;
/*    */   
/*    */   private static <T> Class<T> nonNull(Class<T> c) {
/* 18 */     return (c == null) ? (Class)Object.class : c;
/*    */   }
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
/*    */   public QueryKeyWithInitializer(String argName, Class<T> argResultClass, Class<? extends IQueryResultInitializer<T>> argInitializerClass) {
/* 34 */     this.name_ = argName.trim();
/* 35 */     this.resultClass_ = nonNull(argResultClass);
/* 36 */     this.initializerClass_ = argInitializerClass;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 41 */     if (!(argOther instanceof IQueryKey)) {
/* 42 */       return false;
/*    */     }
/* 44 */     return this.name_.equals(((IQueryKey)argOther).getName());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<? extends IQueryResultInitializer<T>> getInitializerClass() {
/* 55 */     return this.initializerClass_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 65 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<T> getResultClass() {
/* 74 */     return this.resultClass_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 79 */     return this.name_.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 89 */     return this.name_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\QueryKeyWithInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */