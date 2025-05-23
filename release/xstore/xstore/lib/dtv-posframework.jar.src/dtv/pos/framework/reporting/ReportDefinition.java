/*     */ package dtv.pos.framework.reporting;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.springframework.beans.factory.BeanNameAware;
/*     */ import org.springframework.core.io.Resource;
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
/*     */ public class ReportDefinition
/*     */   implements IReportDefinition, BeanNameAware
/*     */ {
/*     */   private String _name;
/*     */   private String _title;
/*     */   private List<String> _titleParameters;
/*     */   private String _parameterPromptMessage;
/*  31 */   private String _printer = "defaultPrinterType";
/*  32 */   private String _printerRequestType = "defaultPrintRequestType";
/*     */   
/*     */   private Resource _dataTemplate;
/*     */   
/*     */   private Resource _layoutTemplate;
/*     */   
/*     */   private LabelUsage _labelUsage;
/*     */   
/*     */   private int _labelColumnCount;
/*     */   private int _labelRowCount;
/*     */   private Map<String, Object> _properties;
/*  43 */   private Boolean _promptPageRange = Boolean.FALSE;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private FormattableFactory _ff;
/*     */ 
/*     */   
/*     */   public Resource getDataTemplate() {
/*  51 */     return this._dataTemplate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLabelColumnCount() {
/*  57 */     return this._labelColumnCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLabelRowCount() {
/*  63 */     return this._labelRowCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LabelUsage getLabelUsage() {
/*  69 */     return this._labelUsage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Resource getLayoutTemplate() {
/*  75 */     return this._layoutTemplate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  81 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getParameterPromptMessage() {
/*  87 */     return this._ff.getTranslatable(this._parameterPromptMessage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrinter() {
/*  93 */     return this._printer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrinterRequestType() {
/*  99 */     return this._printerRequestType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getPromptPageRange() {
/* 105 */     return this._promptPageRange;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> getProperties() {
/* 111 */     return this._properties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTitle() {
/* 118 */     if (getTitleParameters() != null) {
/* 119 */       List<IFormattable> parameters = new ArrayList<>();
/* 120 */       getTitleParameters().forEach(parameter -> parameters.add(this._ff.getTranslatable(parameter)));
/* 121 */       return this._ff.getTranslatable(this._title, parameters.<IFormattable>toArray(new IFormattable[parameters.size()]));
/*     */     } 
/*     */     
/* 124 */     return this._ff.getTranslatable(this._title);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getTitleParameters() {
/* 132 */     return this._titleParameters;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeanName(String argName) {
/* 138 */     this._name = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataTemplate(Resource argDataTemplate) {
/* 144 */     this._dataTemplate = argDataTemplate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelColumnCount(int argColumnCount) {
/* 150 */     this._labelColumnCount = argColumnCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelRowCount(int argRowCount) {
/* 156 */     this._labelRowCount = argRowCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelUsage(String argLabelUsage) {
/* 162 */     this._labelUsage = LabelUsage.forName(argLabelUsage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLayoutTemplate(Resource argLayoutTemplate) {
/* 168 */     this._layoutTemplate = argLayoutTemplate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameterPromptMessage(String argParameterPromptMessage) {
/* 174 */     this._parameterPromptMessage = argParameterPromptMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrinter(String argPrinter) {
/* 180 */     this._printer = argPrinter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrinterRequestType(String argPrinterRequestType) {
/* 186 */     this._printerRequestType = argPrinterRequestType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptPageRange(Boolean argPromptPageRange) {
/* 192 */     this._promptPageRange = argPromptPageRange;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Map<String, Object> argProperties) {
/* 198 */     this._properties = argProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(String argTitle) {
/* 204 */     this._title = argTitle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitleParameters(List<String> argTitleParameters) {
/* 210 */     this._titleParameters = argTitleParameters;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */