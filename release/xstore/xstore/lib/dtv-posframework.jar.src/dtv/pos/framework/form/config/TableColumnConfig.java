/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.IFormatter;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.iframework.form.config.ITableColumnConfig;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import java.io.IOException;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableColumnConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISavableConfig, ITableColumnConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private static final Logger logger_ = Logger.getLogger(TableColumnConfig.class);
/*     */   
/*     */   public static final String MAIN_DTYPE = "TableColumn";
/*     */   
/*     */   private static final String MAIN_TAG = "column";
/*     */   
/*     */   private static final String RESOURCE_TAG = "Resource";
/*     */   
/*     */   private static final String HEADER_TAG = "Header";
/*     */   private static final String VIEW_FORMATTER_TAG = "ViewFormatter";
/*     */   private static final String VIEW_FORMAT_TYPE_TAG = "ViewFormatType";
/*     */   private static final String EDIT_FORMAT_TYPE_TAG = "EditFormatType";
/*     */   private static final String WIDTH_TAG = "Width";
/*     */   private static final String READ_ONLY_TAG = "ReadOnly";
/*     */   private static final String MODEL_COL_IDX_TAG = "ModelColumnIndex";
/*     */   private String resource;
/*     */   private IFormattableConfig header;
/*     */   private ClassConfig viewFormatterClassConfig;
/*     */   private IFormatter viewFormatter;
/*     */   private FormatterType viewFormatType;
/*     */   private TextFieldInputType editFormatType;
/*     */   private Integer width;
/*     */   private Boolean readOnly;
/*     */   private Integer modelColumnIndex;
/*     */   
/*     */   public TextFieldInputType getEditFormatType() {
/*  54 */     return this.editFormatType;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getHeader() {
/*  59 */     return (this.header == null) ? IFormattable.EMPTY : this.header.getFormattable();
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getModelColumnIndex() {
/*  64 */     return this.modelColumnIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getReadOnly() {
/*  69 */     return (this.readOnly == null) ? false : this.readOnly.booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getResource() {
/*  74 */     return this.resource;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormatter getViewFormatter() {
/*  79 */     if (this.viewFormatter == null && this.viewFormatterClassConfig != null) {
/*     */       try {
/*  81 */         this.viewFormatter = this.viewFormatterClassConfig.getValue().newInstance();
/*     */       }
/*  83 */       catch (Exception ex) {
/*  84 */         logger_.error("CAUGHT EXCEPTION", ex);
/*  85 */         return null;
/*     */       } 
/*     */     }
/*  88 */     return this.viewFormatter;
/*     */   }
/*     */ 
/*     */   
/*     */   public FormatterType getViewFormatType() {
/*  93 */     return this.viewFormatType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getWidth() {
/*  98 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 103 */     if (argValue instanceof dtv.util.config.StringConfig && "Resource".equalsIgnoreCase(argKey)) {
/* 104 */       this.resource = argValue.toString();
/*     */     }
/* 106 */     else if (argValue instanceof IFormattableConfig && "Header".equalsIgnoreCase(argKey)) {
/* 107 */       this.header = (IFormattableConfig)argValue;
/*     */     }
/* 109 */     else if (argValue instanceof ClassConfig && "ViewFormatter".equalsIgnoreCase(argKey)) {
/* 110 */       this.viewFormatterClassConfig = (ClassConfig)argValue;
/*     */     }
/* 112 */     else if (argValue instanceof dtv.util.config.StringConfig && "ViewFormatType".equalsIgnoreCase(argKey)) {
/* 113 */       this.viewFormatType = FormatterType.forName(argValue.toString());
/*     */     }
/* 115 */     else if (argValue instanceof dtv.util.config.StringConfig && "EditFormatType".equalsIgnoreCase(argKey)) {
/* 116 */       this.editFormatType = TextFieldInputType.forName(argValue.toString());
/*     */     }
/* 118 */     else if (argValue instanceof IntegerConfig && "Width".equalsIgnoreCase(argKey)) {
/* 119 */       this.width = ((IntegerConfig)argValue).getInteger();
/*     */     }
/* 121 */     else if (argValue instanceof BooleanConfig && "ReadOnly".equalsIgnoreCase(argKey)) {
/* 122 */       this.readOnly = ((BooleanConfig)argValue).getBoolean();
/*     */     }
/* 124 */     else if (argValue instanceof IntegerConfig && "ModelColumnIndex".equalsIgnoreCase(argKey)) {
/* 125 */       this.modelColumnIndex = ((IntegerConfig)argValue).getInteger();
/*     */     } else {
/*     */       
/* 128 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 136 */     argWriter.writeHeader("column", "TableColumn");
/*     */     
/* 138 */     argWriter.writeValue("Resource", "String", this.resource);
/* 139 */     argWriter.writeValue("Header", (IReflectionParameterCapable)this.header);
/* 140 */     argWriter.writeValue("ViewFormatter", (IReflectionParameterCapable)this.viewFormatterClassConfig);
/* 141 */     argWriter.writeValue("ViewFormatType", "String", this.viewFormatType);
/* 142 */     argWriter.writeValue("EditFormatType", "String", this.editFormatType);
/* 143 */     argWriter.writeValue("Width", "Integer", this.width);
/* 144 */     argWriter.writeValue("ReadOnly", "Boolean", this.readOnly);
/* 145 */     argWriter.writeValue("ModelColumnIndex", "Integer", this.modelColumnIndex);
/*     */     
/* 147 */     argWriter.writeFooter("column");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\TableColumnConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */