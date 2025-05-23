/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*     */ import dtv.pos.iframework.op.req.IPromptReqHandler;
/*     */ import dtv.pos.iframework.ui.config.IPromptReqHandlerFactory;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ public class PromptReqHandlerFactory
/*     */   implements IPromptReqHandlerFactory
/*     */ {
/*  24 */   private static final String IMPL_KEY = IPromptReqHandlerFactory.class.getName();
/*     */   
/*  26 */   private static final Logger logger_ = Logger.getLogger(PromptReqHandlerFactory.class);
/*  27 */   private static IPromptReqHandlerFactory _instance = null;
/*     */ 
/*     */   
/*     */   private final Collection<IMatcher> _requestMatchers;
/*     */ 
/*     */   
/*     */   public static IPromptReqHandlerFactory getInstance() {
/*  34 */     if (_instance == null) {
/*  35 */       String className = System.getProperty(IMPL_KEY);
/*     */       try {
/*  37 */         _instance = (IPromptReqHandlerFactory)Class.forName(className).newInstance();
/*     */       }
/*  39 */       catch (Exception ex) {
/*  40 */         _instance = new PromptReqHandlerFactory();
/*     */       } 
/*     */     } 
/*  43 */     return _instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PromptReqHandlerFactory() {
/*  53 */     this._requestMatchers = new ArrayList<>();
/*  54 */     addMatchers(this._requestMatchers);
/*     */ 
/*     */     
/*  57 */     IMatcher defaultMatcher = getDefaultMatcher();
/*  58 */     if (defaultMatcher != null) {
/*  59 */       this._requestMatchers.add(defaultMatcher);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPromptReqHandler getPromptReqHandler(String argPromptType) {
/*  66 */     IPromptReqHandler requestHandler = null;
/*     */     
/*  68 */     for (IMatcher matcher : this._requestMatchers) {
/*  69 */       if (matcher.isMatch(argPromptType)) {
/*  70 */         requestHandler = matcher.getRequestHandler();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  75 */     return requestHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addMatchers(Collection<IMatcher> argMatchers) {
/*  85 */     argMatchers.add(new StringMatcher((Class)NotifyPromptReqHandler.class, new String[] { "NOTIFY%" }));
/*  86 */     argMatchers.add(new StringMatcher((Class)TextPromptReqHandler.class, new String[] { "TEXT" }));
/*  87 */     argMatchers.add(new StringMatcher((Class)ListPromptReqHandler.class, new String[] { "LIST" }));
/*  88 */     argMatchers.add(new StringMatcher((Class)ViewportPromptReqHandler.class, new String[] { "VIEWPORT" }));
/*  89 */     argMatchers.add(new StringMatcher((Class)LongTextPromptReqHandler.class, new String[] { "LONG_TEXT", "LongText" }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IMatcher getDefaultMatcher() {
/* 100 */     return AlwaysMatcher.getInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class AlwaysMatcher
/*     */     implements IMatcher
/*     */   {
/* 112 */     private static final AlwaysMatcher _instance = new AlwaysMatcher();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static PromptReqHandlerFactory.IMatcher getInstance() {
/* 119 */       return _instance;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IPromptReqHandler getRequestHandler() {
/* 130 */       return new NotifyPromptReqHandler();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isMatch(String arg0) {
/* 136 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static interface IMatcher
/*     */   {
/*     */     IPromptReqHandler getRequestHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isMatch(String param1String);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class StringMatcher
/*     */     implements IMatcher
/*     */   {
/* 158 */     private static final Collection<? extends String> _noMatches = Collections.emptyList();
/*     */     
/*     */     private final Collection<? extends String> _matchingTypes;
/*     */     
/*     */     private final Class<? extends IPromptReqHandler> _class;
/*     */     
/*     */     protected StringMatcher(Class<? extends IPromptReqHandler> argClass, String... argMatchingTypes) {
/* 165 */       this._class = argClass;
/* 166 */       this
/*     */         
/* 168 */         ._matchingTypes = (argMatchingTypes == null || argMatchingTypes.length == 0) ? _noMatches : Arrays.<String>asList(argMatchingTypes);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public IPromptReqHandler getRequestHandler() {
/*     */       try {
/* 175 */         return this._class.newInstance();
/*     */       }
/* 177 */       catch (InstantiationException|IllegalAccessException ex) {
/* 178 */         PromptReqHandlerFactory.logger_.warn("Could not load prompt request handler for type(s) " + this._matchingTypes + ".  Returning a NotifyPromptRequestHandler.", ex);
/*     */         
/* 180 */         return new NotifyPromptReqHandler();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isMatch(String argPromptType) {
/* 187 */       boolean match = false;
/*     */       
/* 189 */       if (!StringUtils.isEmpty(argPromptType)) {
/*     */ 
/*     */         
/* 192 */         String promptType = argPromptType.trim();
/*     */         
/* 194 */         for (String candidate : this._matchingTypes) {
/* 195 */           if (candidate.endsWith("%")) {
/*     */ 
/*     */             
/* 198 */             int endIdx = candidate.indexOf("%");
/*     */             
/* 200 */             if (promptType.length() >= endIdx && promptType
/* 201 */               .substring(0, endIdx).equalsIgnoreCase(candidate.substring(0, endIdx))) {
/* 202 */               match = true;
/*     */               break;
/*     */             } 
/*     */             continue;
/*     */           } 
/* 207 */           if (promptType.equalsIgnoreCase(candidate)) {
/* 208 */             match = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 214 */       return match;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\PromptReqHandlerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */