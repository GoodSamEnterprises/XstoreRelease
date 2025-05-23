/*    */ package dtv.data2.access;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryKey<T>
/*    */   implements IQueryKey<T>
/*    */ {
/*    */   private final String name_;
/*    */   private final Class<T> resultClass_;
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
/*    */   public QueryKey(String argName, Class<T> argResultClass) {
/* 32 */     this.name_ = argName.trim();
/* 33 */     this.resultClass_ = nonNull(argResultClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 38 */     if (!(argOther instanceof IQueryKey)) {
/* 39 */       return false;
/*    */     }
/* 41 */     return this.name_.equals(((IQueryKey)argOther).getName());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<? extends IQueryResultInitializer<IQueryResult>> getInitializerClass() {
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 62 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<T> getResultClass() {
/* 71 */     return this.resultClass_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     return this.name_.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     return this.name_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\QueryKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */