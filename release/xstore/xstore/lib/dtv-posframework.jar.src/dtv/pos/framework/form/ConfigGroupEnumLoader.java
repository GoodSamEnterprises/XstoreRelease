/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.common.ConfigurationMgr;
/*    */ import dtv.pos.iframework.form.IEnumLoader;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import dtv.xst.dao.com.CodeLocator;
/*    */ import dtv.xst.dao.com.IReasonCode;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class ConfigGroupEnumLoader
/*    */   implements IEnumLoader
/*    */ {
/* 27 */   private static final Logger logger_ = Logger.getLogger(ConfigGroupEnumLoader.class);
/*    */   
/*    */   private IValueWrapperFactory wrapperFactory_;
/*    */   
/*    */   private IFormValueEnumConfig config_;
/*    */   private String codeGroup_;
/*    */   private List<? extends IReasonCode> values_;
/*    */   
/*    */   public List<? extends Object> getValues() {
/* 36 */     initialize();
/* 37 */     return Collections.unmodifiableList(this.values_);
/*    */   }
/*    */ 
/*    */   
/*    */   public IValueWrapperFactory getWrapperFactory() {
/* 42 */     initialize();
/* 43 */     return this.wrapperFactory_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfig(IFormValueEnumConfig argConfig) {
/* 48 */     this.config_ = argConfig;
/*    */   }
/*    */   
/*    */   protected void processParam(ParameterConfig argParam) {
/* 52 */     String name = argParam.getName();
/* 53 */     if ("codegroup".equalsIgnoreCase(name)) {
/* 54 */       this.codeGroup_ = argParam.getValue().toString();
/* 55 */       this.values_ = CodeLocator.getReasonCodes(ConfigurationMgr.getOrganizationId(), this.codeGroup_);
/*    */     } else {
/*    */       
/* 58 */       warnUnsupported(argParam);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void warnUnsupported(ParameterConfig argValue) {
/* 63 */     StringBuffer sb = new StringBuffer();
/* 64 */     sb.append("unsupported parameter ");
/* 65 */     sb.append((argValue == null) ? null : argValue.getName());
/* 66 */     sb.append("=").append((argValue == null) ? null : argValue.getValue());
/* 67 */     sb.append("@@").append(this.config_.getSourceDescription());
/* 68 */     sb.append("::").append(getClass().getName());
/* 69 */     Logger.getLogger(getClass()).warn(sb);
/*    */   }
/*    */   
/*    */   private void initialize() {
/* 73 */     if (this.values_ == null) {
/* 74 */       for (ParameterConfig param : this.config_.getLoaderParams().getParameters()) {
/* 75 */         processParam(param);
/*    */       }
/* 77 */       if (this.values_ == null) {
/* 78 */         logger_.warn("No config group configured @@ " + this.config_.getSourceDescription());
/* 79 */         this.values_ = new ArrayList<>();
/*    */       } 
/* 81 */       if (this.config_.isNullAllowed()) {
/* 82 */         this.values_.add(0, null);
/*    */       }
/* 84 */       this.wrapperFactory_ = ReasonCodeValueWrapperFactory.makeForCodeGroup(this.codeGroup_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\ConfigGroupEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */