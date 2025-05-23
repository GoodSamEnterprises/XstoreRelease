/*     */ package dtv.data2.dataloader.config;
/*     */ 
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FieldConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*  22 */   private static final Collection<String> _ignoredFields = Arrays.asList(new String[] { "dataType", "required", "size" });
/*     */   
/*     */   public static final String VARIABLE_CURRENT_DATE = "$currentDate";
/*     */   
/*     */   public static final String VARIABLE_CURRENT_DATE_TIMESTAMP = "$currentDateTimestamp";
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   private String fieldName_;
/*     */   
/*     */   private String fieldDataType_;
/*     */   private FieldValueSource fieldValueSource_;
/*     */   private String valueSpecifier_;
/*     */   private String default_;
/*     */   private int filePosition_;
/*     */   private int fileIntervalStart_;
/*     */   private int fileIntervalEnd_;
/*  39 */   private List<DataModifierConfig> valueTranslators_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDaoFieldName() {
/*  49 */     return this.fieldName_;
/*     */   }
/*     */   
/*     */   public String getFieldDataType() {
/*  53 */     return this.fieldDataType_;
/*     */   }
/*     */   
/*     */   public String getFieldDefault() {
/*  57 */     return this.default_;
/*     */   }
/*     */   
/*     */   public FieldValueSource getFieldValueSource() {
/*  61 */     return this.fieldValueSource_;
/*     */   }
/*     */   
/*     */   public int getFileIntervalEnd() {
/*  65 */     return this.fileIntervalEnd_;
/*     */   }
/*     */   
/*     */   public int getFileIntervalStart() {
/*  69 */     return this.fileIntervalStart_;
/*     */   }
/*     */   
/*     */   public int getFilePosition() {
/*  73 */     return this.filePosition_ - 2;
/*     */   }
/*     */   
/*     */   public String getValueSpecifier() {
/*  77 */     return this.valueSpecifier_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataModifierConfig> getValueTranslators() {
/*  84 */     return this.valueTranslators_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  90 */     if ("name".equalsIgnoreCase(argKey)) {
/*     */       
/*  92 */       this.fieldName_ = StringUtils.ensureFirstUpperCase(argValue.toString());
/*     */     }
/*  94 */     else if ("dataType".equalsIgnoreCase(argKey)) {
/*     */       
/*  96 */       this.fieldDataType_ = argValue.toString();
/*     */     
/*     */     }
/*  99 */     else if ("default".equalsIgnoreCase(argKey)) {
/*     */       
/* 101 */       this.default_ = argValue.toString();
/*     */     }
/* 103 */     else if ("ValueTranslator".equalsIgnoreCase(argKey)) {
/* 104 */       if (this.valueTranslators_ == null) {
/* 105 */         this.valueTranslators_ = new ArrayList<>(2);
/*     */       }
/* 107 */       this.valueTranslators_.add((DataModifierConfig)argValue);
/*     */     }
/* 109 */     else if ("filePosition".equalsIgnoreCase(argKey)) {
/* 110 */       if (this.fieldValueSource_ != null) {
/* 111 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field can only define one of the following: filePosition, sysProp, literal, variable Config source: " + 
/*     */             
/* 113 */             getSourceDescription());
/*     */       }
/*     */       
/* 116 */       this.fieldValueSource_ = FieldValueSource.FILE_POSITION;
/* 117 */       this.valueSpecifier_ = argValue.toString();
/*     */       
/*     */       try {
/* 120 */         this.filePosition_ = Integer.parseInt(this.valueSpecifier_);
/*     */       }
/* 122 */       catch (Exception ee) {
/* 123 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field defines a file position that is not an integer. Config source: " + 
/*     */             
/* 125 */             getSourceDescription(), ee);
/*     */       }
/*     */     
/* 128 */     } else if ("fileInterval".equals(argKey)) {
/* 129 */       if (this.fieldValueSource_ != null) {
/* 130 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field can only define one of the following: filePosition, sysProp, literal, variable,configParam Config source: " + 
/*     */             
/* 132 */             getSourceDescription());
/*     */       }
/*     */       
/* 135 */       this.fieldValueSource_ = FieldValueSource.FILE_INTERVAL;
/* 136 */       this.valueSpecifier_ = argValue.toString();
/*     */       
/*     */       try {
/* 139 */         String[] split = StringUtils.split(this.valueSpecifier_, '-');
/* 140 */         this.fileIntervalStart_ = Integer.parseInt(split[0]);
/* 141 */         if (split.length == 1) {
/* 142 */           this.fileIntervalEnd_ = this.fileIntervalStart_;
/*     */         } else {
/*     */           
/* 145 */           this.fileIntervalEnd_ = Integer.parseInt(split[1]);
/*     */         }
/*     */       
/* 148 */       } catch (Exception ee) {
/* 149 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field defines a file position that is not an integer. Config source: " + 
/*     */             
/* 151 */             getSourceDescription(), ee);
/*     */       }
/*     */     
/* 154 */     } else if ("sysProp".equals(argKey)) {
/* 155 */       if (this.fieldValueSource_ != null) {
/* 156 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field can only define one of the following: filePosition, sysProp, literal, variable,configParam Config source: " + 
/*     */             
/* 158 */             getSourceDescription());
/*     */       }
/*     */       
/* 161 */       this.fieldValueSource_ = FieldValueSource.SYSTEM_PROPERTY;
/* 162 */       this.valueSpecifier_ = argValue.toString();
/*     */     }
/* 164 */     else if ("configParam".equals(argKey)) {
/* 165 */       if (this.fieldValueSource_ != null) {
/* 166 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field can only define one of the following: filePosition, sysProp, literal, variable,configParam Config source: " + 
/*     */             
/* 168 */             getSourceDescription());
/*     */       }
/*     */       
/* 171 */       this.fieldValueSource_ = FieldValueSource.CONFIG_PARAMETER;
/* 172 */       this.valueSpecifier_ = argValue.toString();
/*     */     }
/* 174 */     else if ("literal".equals(argKey)) {
/* 175 */       if (this.fieldValueSource_ != null) {
/* 176 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field can only define one of the following: filePosition, sysProp, literal, variable,configParam Config source: " + 
/*     */             
/* 178 */             getSourceDescription());
/*     */       }
/*     */       
/* 181 */       this.fieldValueSource_ = FieldValueSource.LITERAL;
/* 182 */       this.valueSpecifier_ = argValue.toString();
/*     */     }
/* 184 */     else if ("variable".equals(argKey)) {
/* 185 */       if (this.fieldValueSource_ != null) {
/* 186 */         throw new DataLoaderException("DataLoaderConfig is misconfigured - a field can only define one of the following: filePosition, sysProp, literal, variable,configParam Config source: " + 
/*     */             
/* 188 */             getSourceDescription());
/*     */       }
/*     */       
/* 191 */       this.fieldValueSource_ = FieldValueSource.VARIABLE;
/* 192 */       this.valueSpecifier_ = argValue.toString();
/*     */     }
/* 194 */     else if (!_ignoredFields.contains(argKey)) {
/* 195 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public enum FieldValueSource {
/* 200 */     FILE_POSITION, FILE_INTERVAL, LITERAL, SYSTEM_PROPERTY, VARIABLE, CONFIG_PARAMETER;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\FieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */