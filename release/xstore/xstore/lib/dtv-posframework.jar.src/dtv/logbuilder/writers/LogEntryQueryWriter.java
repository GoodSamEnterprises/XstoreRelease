/*    */ package dtv.logbuilder.writers;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IQueryKey;
/*    */ import dtv.data2.access.ObjectNotFoundException;
/*    */ import dtv.data2.access.QueryKey;
/*    */ import dtv.logbuilder.ILogBuilder;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.TypeSafeMapKey;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LogEntryQueryWriter
/*    */   implements ILogEntryWriter
/*    */ {
/* 25 */   private static final TypeSafeMapKey<String> PROP_QUERY_KEY = new TypeSafeMapKey("QueryKey", String.class);
/*    */   
/*    */   private String queryKey_;
/*    */   
/* 29 */   private final StringBuilder buff_ = new StringBuilder(1024);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 35 */     String logContent = this.buff_.toString();
/* 36 */     this.buff_.setLength(0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     QueryKey queryKey = new QueryKey(this.queryKey_, Object.class);
/*    */     
/* 46 */     Map<String, Object> params = new HashMap<>(4);
/* 47 */     params.put("argLogEntry", logContent);
/*    */     try {
/* 49 */       DataFactory.getObjectByQuery((IQueryKey)queryKey, params);
/*    */     }
/* 51 */     catch (ObjectNotFoundException ee) {
/* 52 */       IOException ioEx = new IOException("Could not execute query.");
/* 53 */       ioEx.initCause((Throwable)ee);
/* 54 */       throw ioEx;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(Map<TypeSafeMapKey<?>, Object> argSettings) {
/* 61 */     this.queryKey_ = (String)PROP_QUERY_KEY.retrieve(argSettings);
/* 62 */     if (StringUtils.isEmpty(this.queryKey_)) {
/* 63 */       throw new RuntimeException("Misconfiguration - property " + PROP_QUERY_KEY + " is required. Check " + (String)ILogBuilder.CONFIG_SOURCE
/* 64 */           .retrieve(argSettings));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(String argString) {
/* 71 */     this.buff_.append(argString);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\writers\LogEntryQueryWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */