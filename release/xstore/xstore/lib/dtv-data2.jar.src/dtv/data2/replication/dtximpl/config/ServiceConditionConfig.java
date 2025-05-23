/*    */ package dtv.data2.replication.dtximpl.config;
/*    */ 
/*    */ import dtv.data2.replication.ReplicationConfigException;
/*    */ import dtv.data2.replication.ReplicationException;
/*    */ import dtv.data2.replication.dtximpl.condition.AbstractReplicationCondition;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ServiceConditionConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String TAG_CONDITION_CLASS = "class";
/*    */   private static final String TAG_PARAMETER = "conditionParam";
/*    */   private Class<?> conditionClass_;
/*    */   private AbstractReplicationCondition condition_;
/* 32 */   private final List<ServiceConditionParameterConfig> paramaters_ = new ArrayList<>(2);
/*    */ 
/*    */   
/*    */   public AbstractReplicationCondition getCondition() {
/* 36 */     if (this.condition_ == null) {
/*    */       try {
/* 38 */         this.condition_ = (AbstractReplicationCondition)this.conditionClass_.newInstance();
/*    */       }
/* 40 */       catch (Exception ee) {
/* 41 */         throw new ReplicationException("Could not instantiate condition class as an AbstractReplicationCondition. Class name: " + this.conditionClass_
/* 42 */             .getName(), ee);
/*    */       } 
/* 44 */       for (ServiceConditionParameterConfig paramater : this.paramaters_) {
/* 45 */         this.condition_.setParam(paramater.getKey(), paramater.getValue());
/*    */       }
/*    */     } 
/*    */     
/* 49 */     return this.condition_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 55 */     if ("class".equals(argKey)) {
/*    */       try {
/* 57 */         this.conditionClass_ = Class.forName(argValue.toString());
/*    */       }
/* 59 */       catch (Exception ee) {
/* 60 */         throw new ReplicationConfigException("Could not create class for class name: " + argValue + " Check DtxReplicationConfig.xml");
/*    */       
/*    */       }
/*    */     
/*    */     }
/* 65 */     else if ("conditionParam".equals(argKey)) {
/* 66 */       this.paramaters_.add((ServiceConditionParameterConfig)argValue);
/*    */     } else {
/*    */       
/* 69 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\ServiceConditionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */