/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.common.ConfigurationMgr;
/*    */ import dtv.pos.iframework.form.IEnumLoader;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import dtv.xst.dao.com.CodeLocator;
/*    */ import dtv.xst.dao.com.ICodeValue;
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
/*    */ public class CodeEnumLoader
/*    */   implements IEnumLoader
/*    */ {
/* 27 */   private static final Logger logger_ = Logger.getLogger(CodeEnumLoader.class);
/*    */   
/*    */   private IValueWrapperFactory wrapperFactory_;
/*    */   
/*    */   private IFormValueEnumConfig config_;
/*    */   private String category_;
/*    */   private List<? extends ICodeValue> values_;
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
/* 53 */     if ("category".equalsIgnoreCase(name)) {
/* 54 */       this.category_ = argParam.getValue().toString();
/* 55 */       this
/*    */         
/* 57 */         .values_ = new ArrayList<>(CodeLocator.getCodeValues(ConfigurationMgr.getOrganizationId(), this.category_));
/*    */     } else {
/*    */       
/* 60 */       warnUnsupported(argParam);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void warnUnsupported(ParameterConfig argValue) {
/* 65 */     StringBuffer sb = new StringBuffer();
/* 66 */     sb.append("unsupported parameter ");
/* 67 */     sb.append((argValue == null) ? null : argValue.getName());
/* 68 */     sb.append("=").append((argValue == null) ? null : argValue.getValue());
/* 69 */     sb.append("@@").append(this.config_.getSourceDescription());
/* 70 */     sb.append("::").append(getClass().getName());
/* 71 */     Logger.getLogger(getClass()).warn(sb);
/*    */   }
/*    */   
/*    */   private void initialize() {
/* 75 */     if (this.values_ == null) {
/* 76 */       for (ParameterConfig param : this.config_.getLoaderParams().getParameters()) {
/* 77 */         processParam(param);
/*    */       }
/* 79 */       if (this.values_ == null) {
/* 80 */         logger_.warn("No config group configured @@ " + this.config_.getSourceDescription());
/* 81 */         this.values_ = new ArrayList<>();
/*    */       } 
/* 83 */       if (this.config_.isNullAllowed()) {
/* 84 */         this.values_.add(0, null);
/*    */       }
/* 86 */       this.wrapperFactory_ = CodeWrapperFactory.makeForCodeGroup(this.category_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */