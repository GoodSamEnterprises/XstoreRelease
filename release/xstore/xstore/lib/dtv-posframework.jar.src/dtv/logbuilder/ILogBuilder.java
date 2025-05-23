/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.util.TypeSafeMapKey;
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
/*    */ public interface ILogBuilder
/*    */ {
/* 21 */   public static final TypeSafeMapKey<String> ENTRY_ID = new TypeSafeMapKey("ENTRY_ID", String.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   public static final TypeSafeMapKey<Class> WRITER_IMPL = new TypeSafeMapKey("WRITER_IMPL", Class.class);
/*    */ 
/*    */ 
/*    */   
/* 31 */   public static final TypeSafeMapKey<String> CONFIG_SOURCE = new TypeSafeMapKey("CONFIG_SOURCE", String.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   public static final TypeSafeMapKey<String> ENCODING = new TypeSafeMapKey("ENCODING", String.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   public static final TypeSafeMapKey<String> HEADER = new TypeSafeMapKey("HEADER", String.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 47 */   public static final TypeSafeMapKey<String> FOOTER = new TypeSafeMapKey("FOOTER", String.class);
/*    */   
/*    */   boolean isTrainingMode();
/*    */   
/*    */   boolean saveLogEntry(Object paramObject);
/*    */   
/*    */   boolean saveLogEntry(Object paramObject, Map<TypeSafeMapKey<?>, Object> paramMap);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\ILogBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */