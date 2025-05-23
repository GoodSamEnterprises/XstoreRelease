/*    */ package dtv.pos.iframework.visibilityrules;
/*    */ 
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IHasSourceDescription;
/*    */ import dtv.util.config.ISourceLocationAware;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IVisibilityRule
/*    */   extends IHasSourceDescription, ISourceLocationAware, Comparable<IVisibilityRule>
/*    */ {
/*    */   public static final String PARAM_INVERT = "inverted";
/*    */   
/*    */   IAccessLevel checkVisibility() throws Exception;
/*    */   
/*    */   int getGroup();
/*    */   
/*    */   boolean isGranter();
/*    */   
/*    */   @Deprecated
/*    */   default void setParameter(String argName, IConfigObject argValue) {
/* 90 */     throw new UnsupportedOperationException("setParameter(String, IConfigObject) is deprecated and is not supported for [" + 
/* 91 */         getClass().getName() + "]. Use setParameter(String, String) instead.");
/*    */   }
/*    */   
/*    */   void setParameter(String paramString1, String paramString2);
/*    */   
/*    */   void setSourceDescription(String paramString);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\visibilityrules\IVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */