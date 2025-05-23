/*    */ package dtv.data2.access.impl.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class RelationshipConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   static final String MAIN_TAG = "Relationship";
/*    */   private static final String IDENTIFIER_TAG = "Identifier";
/*    */   private static final String CHILD_DAO_TAG = "ChildDAO";
/*    */   private static final String TYPE_TAG = "Type";
/*    */   private String identifier_;
/*    */   private String type_;
/*    */   private ClassConfig<?> daoClass_;
/*    */   
/*    */   public Class<?> getChildDAOClass() {
/* 34 */     return this.daoClass_.getValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getIdentifier() {
/* 43 */     return this.identifier_;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 47 */     return this.type_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 52 */     if (argValue instanceof ClassConfig && argKey.equalsIgnoreCase("ChildDAO")) {
/* 53 */       this.daoClass_ = (ClassConfig)argValue;
/*    */     }
/* 55 */     else if (argValue instanceof dtv.util.config.StringConfig && argKey.equalsIgnoreCase("Identifier")) {
/* 56 */       this.identifier_ = argValue.toString();
/*    */     }
/* 58 */     else if (argValue instanceof dtv.util.config.StringConfig && argKey.equalsIgnoreCase("Type")) {
/* 59 */       this.type_ = argValue.toString();
/*    */     } else {
/*    */       
/* 62 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\config\RelationshipConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */