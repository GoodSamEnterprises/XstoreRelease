/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import com.micros.xstore.config.form.field.FieldTypeEnumeration;
/*     */ import com.micros.xstore.config.form.field.FormParameterType;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Predicate;
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
/*     */ public class ResolvedFieldConfig
/*     */ {
/*     */   private FieldTypeEnumeration _fieldType;
/*     */   private Font _font;
/*     */   private FormatterType _formatter;
/*     */   private String _name;
/*     */   private String _resource;
/*     */   private IFormattable _text;
/*     */   private IDataFieldConfig _dataField;
/*  35 */   private boolean _required = Boolean.FALSE.booleanValue();
/*     */ 
/*     */   
/*     */   private String _type;
/*     */ 
/*     */   
/*     */   private List<FormParameterType> _parameters;
/*     */ 
/*     */   
/*     */   private Color _foregroundColor;
/*     */ 
/*     */   
/*     */   private int _horizontalAlignment;
/*     */   
/*     */   private int _verticalAlignment;
/*     */ 
/*     */   
/*     */   public IDataFieldConfig getDataField() {
/*  53 */     return this._dataField;
/*     */   }
/*     */   
/*     */   public FieldTypeEnumeration getFieldType() {
/*  57 */     return this._fieldType;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/*  61 */     return this._font;
/*     */   }
/*     */   
/*     */   public Color getForegroundColor() {
/*  65 */     return this._foregroundColor;
/*     */   }
/*     */   
/*     */   public FormatterType getFormatter() {
/*  69 */     return this._formatter;
/*     */   }
/*     */   
/*     */   public int getHorizontalAlignment() {
/*  73 */     return this._horizontalAlignment;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  77 */     return this._name;
/*     */   }
/*     */   
/*     */   public String getParameter(String argParamType) {
/*  81 */     if (this._parameters == null || this._parameters.isEmpty()) {
/*  82 */       return null;
/*     */     }
/*     */     
/*  85 */     Predicate<FormParameterType> paramTypeCheckPredicate = p -> p.getName().equalsIgnoreCase(argParamType);
/*  86 */     Optional<FormParameterType> result = this._parameters.stream().filter(paramTypeCheckPredicate).findFirst();
/*     */     
/*  88 */     return result.isPresent() ? ((FormParameterType)result.get()).getValue() : null;
/*     */   }
/*     */   
/*     */   public List<FormParameterType> getParameters() {
/*  92 */     return this._parameters;
/*     */   }
/*     */   
/*     */   public String getResource() {
/*  96 */     return this._resource;
/*     */   }
/*     */   
/*     */   public IFormattable getText() {
/* 100 */     return this._text;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 104 */     return this._type;
/*     */   }
/*     */   
/*     */   public int getVerticalAlignment() {
/* 108 */     return this._verticalAlignment;
/*     */   }
/*     */   
/*     */   public boolean isRequired() {
/* 112 */     return this._required;
/*     */   }
/*     */   
/*     */   public void setDataField(IDataFieldConfig argDataField) {
/* 116 */     this._dataField = argDataField;
/*     */   }
/*     */   
/*     */   public void setFieldType(FieldTypeEnumeration argFieldType) {
/* 120 */     this._fieldType = argFieldType;
/*     */   }
/*     */   
/*     */   public void setFont(Font argFont) {
/* 124 */     this._font = argFont;
/*     */   }
/*     */   
/*     */   public void setForegroundColor(Color argForegroundColor) {
/* 128 */     this._foregroundColor = argForegroundColor;
/*     */   }
/*     */   
/*     */   public void setFormatter(FormatterType argFormatter) {
/* 132 */     this._formatter = argFormatter;
/*     */   }
/*     */   
/*     */   public void setHorizontalAlignment(int argHorizontalAlignment) {
/* 136 */     this._horizontalAlignment = argHorizontalAlignment;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 140 */     this._name = argName;
/*     */   }
/*     */   
/*     */   public void setParameters(List<FormParameterType> argParameters) {
/* 144 */     this._parameters = argParameters;
/*     */   }
/*     */   
/*     */   public void setRequired(boolean argRequired) {
/* 148 */     this._required = argRequired;
/*     */   }
/*     */   
/*     */   public void setResource(String argResource) {
/* 152 */     this._resource = argResource;
/*     */   }
/*     */   
/*     */   public void setText(IFormattable argText) {
/* 156 */     this._text = argText;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 160 */     this._type = argType;
/*     */   }
/*     */   
/*     */   public void setVerticalAlignment(int argVerticalAlignment) {
/* 164 */     this._verticalAlignment = argVerticalAlignment;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ResolvedFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */