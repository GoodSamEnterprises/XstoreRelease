/*     */ package dtv.logbuilder;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.docbuilding.IDocBuilder;
/*     */ import dtv.logbuilder.config.LogConfigHelper;
/*     */ import dtv.logbuilder.routing.RoutingRequest;
/*     */ import dtv.logbuilder.routing.RoutingRequestList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.TypeSafeMapKey;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LogBuilder
/*     */   implements ILogBuilder
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(LogBuilder.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final LogConfigHelper configHelper_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void putIfMissing(Map<TypeSafeMapKey<?>, Object> argMap, TypeSafeMapKey<T> argKey, T argValue) {
/*  42 */     if (!argMap.containsKey(argKey)) {
/*  43 */       argMap.put(argKey, argValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void cleanFileName(StringBuffer sb) {
/*  54 */     StringUtils.replaceAll(sb, "::", "_");
/*     */ 
/*     */     
/*  57 */     for (int i = 0; i < sb.length(); i++) {
/*  58 */       switch (sb.charAt(i)) {
/*     */ 
/*     */         
/*     */         case '"':
/*     */         case '*':
/*     */         case '/':
/*     */         case '<':
/*     */         case '>':
/*     */         case '?':
/*     */         case '\\':
/*  68 */           sb.setCharAt(i, '_');
/*     */           break;
/*     */ 
/*     */         
/*     */         case ':':
/*  73 */           sb.setCharAt(i, '.');
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getDomain(IDataModel argObject) {
/*  86 */     if (argObject == null) {
/*  87 */       return null;
/*     */     }
/*  89 */     String className = argObject.getClass().getName();
/*  90 */     return getDomain(className);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getDomain(String argClassName) {
/* 100 */     if (argClassName == null) {
/* 101 */       return null;
/*     */     }
/* 103 */     int end = argClassName.lastIndexOf(".");
/* 104 */     if (end < 0) {
/* 105 */       return null;
/*     */     }
/* 107 */     int start = argClassName.lastIndexOf(".", end - 1);
/* 108 */     if (start < 0) {
/* 109 */       return null;
/*     */     }
/* 111 */     return argClassName.substring(start + 1, end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public static final String SYSTEM_PROPERTY = LogBuilder.class.getName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ILogBuilder INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ILogBuilder getInstance() {
/* 132 */     if (INSTANCE == null) {
/*     */       
/* 134 */       String className = System.getProperty(SYSTEM_PROPERTY);
/*     */       try {
/* 136 */         INSTANCE = (ILogBuilder)Class.forName(className).newInstance();
/*     */       }
/* 138 */       catch (Exception ex) {
/* 139 */         INSTANCE = new LogBuilder();
/*     */       } 
/*     */     } 
/* 142 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogBuilder() {
/* 149 */     this.configHelper_ = new LogConfigHelper();
/* 150 */     this.configHelper_.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTrainingMode() {
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveLogEntry(Object argSource) {
/* 173 */     return saveLogEntry(argSource, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveLogEntry(Object argSource, Map<TypeSafeMapKey<?>, Object> argSettings) {
/*     */     try {
/* 188 */       RoutingRequestList requests = this.configHelper_.getRoutingRequests(argSource);
/* 189 */       if (logger_.isDebugEnabled()) {
/* 190 */         logger_.debug("routing requests: " + requests);
/*     */       }
/* 192 */       for (int i = 0; i < requests.size(); i++) {
/* 193 */         Map<TypeSafeMapKey<?>, Object> settings; RoutingRequest req = (RoutingRequest)requests.get(i);
/*     */         
/* 195 */         IDocBuilder<?> layout = this.configHelper_.getLayout(req.getDocumentId());
/*     */ 
/*     */ 
/*     */         
/* 199 */         if (argSettings == null) {
/* 200 */           settings = new HashMap<>();
/*     */         } else {
/*     */           
/* 203 */           settings = new HashMap<>(argSettings);
/*     */         } 
/*     */         
/* 206 */         putIfMissing(settings, ENTRY_ID, makeEntryId(argSource));
/*     */ 
/*     */         
/* 209 */         ILogEntryDoc doc = new LogEntry(this.configHelper_.getLogFile(req.getFileId()), settings);
/*     */         
/* 211 */         layout.build(doc, argSource, LogDocElementFactory.getInstance());
/* 212 */         doc.close();
/*     */       } 
/*     */       
/* 215 */       return true;
/*     */     }
/* 217 */     catch (Exception ex) {
/* 218 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 219 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String makeEntryId(Object argSource) {
/* 230 */     if (argSource instanceof IDataModel) {
/* 231 */       return makeEntryIdFromObjectId((IDataModel)argSource);
/*     */     }
/* 233 */     if (argSource == null) {
/* 234 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 238 */     StringBuffer sb = new StringBuffer();
/* 239 */     sb.append(argSource.getClass().getName());
/* 240 */     sb.append("@");
/* 241 */     sb.append(Integer.toHexString(argSource.hashCode()));
/* 242 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String makeEntryIdFromObjectId(IDataModel argSource) {
/* 253 */     StringBuffer sb = new StringBuffer();
/* 254 */     sb.append(getDomain(argSource));
/* 255 */     sb.append("-");
/* 256 */     sb.append(argSource.getObjectId().toString());
/* 257 */     cleanFileName(sb);
/* 258 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LogBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */