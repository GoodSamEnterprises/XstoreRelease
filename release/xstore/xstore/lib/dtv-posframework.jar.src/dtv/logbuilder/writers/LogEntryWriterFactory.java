/*    */ package dtv.logbuilder.writers;
/*    */ 
/*    */ import dtv.logbuilder.ILogBuilder;
/*    */ import dtv.util.TypeSafeMapKey;
/*    */ import java.io.IOException;
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
/*    */ public class LogEntryWriterFactory
/*    */ {
/*    */   public static ILogEntryWriter getWriter(Map<TypeSafeMapKey<?>, Object> argSettings) throws IOException {
/*    */     try {
/* 32 */       Class<?> clz = (Class)ILogBuilder.WRITER_IMPL.retrieve(argSettings);
/* 33 */       ILogEntryWriter writer = (ILogEntryWriter)clz.newInstance();
/* 34 */       writer.initialize(argSettings);
/* 35 */       return writer;
/*    */     }
/* 37 */     catch (Throwable ex) {
/* 38 */       throw new IOException(ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\writers\LogEntryWriterFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */