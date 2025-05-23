/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.IQueryResultWrapper;
/*    */ import java.io.Serializable;
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
/*    */ public class QueryResultWrapper<T>
/*    */   implements IQueryResultWrapper<T>, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private T data_;
/*    */   private boolean isLimitReached_;
/*    */   private long limit_;
/*    */   
/*    */   public QueryResultWrapper(T argData) {
/* 27 */     this(argData, false, 0L);
/*    */   }
/*    */   
/*    */   public QueryResultWrapper(T argData, boolean argLimitReached, long argLimit) {
/* 31 */     this.data_ = argData;
/* 32 */     this.isLimitReached_ = argLimitReached;
/* 33 */     this.limit_ = argLimit;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T getData() {
/* 43 */     return this.data_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getQueryLimit() {
/* 53 */     return this.limit_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isQueryLimitReached() {
/* 63 */     return this.isLimitReached_;
/*    */   }
/*    */   
/*    */   public void setData(T argData) {
/* 67 */     this.data_ = argData;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     return "QueryResultWrapper with data: " + this.data_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryResultWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */