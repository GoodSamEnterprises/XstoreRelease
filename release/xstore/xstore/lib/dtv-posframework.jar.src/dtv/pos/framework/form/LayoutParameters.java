/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.pos.framework.ui.config.InsetsRefConfig;
/*     */ import dtv.pos.iframework.form.design.model.ILayoutParameters;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.DoubleArrayConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.IntegerArrayConfig;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.ParameterListConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.io.IOException;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LayoutParameters
/*     */   implements ILayoutParameters
/*     */ {
/*     */   public static final String MAIN_TAG = "LayoutParameters";
/*  26 */   private static final Logger logger_ = Logger.getLogger(LayoutParameters.class);
/*     */   private Integer rowCount_;
/*     */   private Integer columnCount_;
/*     */   private double[] rowSizes_;
/*     */   private double[] columnSizes_;
/*     */   private IReflectionParameterCapable<?> gaps_;
/*  32 */   private Boolean verticalStretch_ = null;
/*     */   private boolean isDirty_ = false;
/*     */   private IReflectionParameterCapable<?> margins_;
/*     */   
/*     */   public LayoutParameters(ParameterListConfig config) {
/*  37 */     if (config != null) {
/*  38 */       ParameterConfig[] params = config.getParameters();
/*  39 */       for (ParameterConfig param : params) {
/*  40 */         String paramName = param.getName();
/*  41 */         Object[] paramValues = param.getParamValues();
/*     */         
/*  43 */         if ("setSize".equals(paramName)) {
/*  44 */           this.columnCount_ = (Integer)paramValues[0];
/*  45 */           this.rowCount_ = (Integer)paramValues[1];
/*     */         }
/*  47 */         else if ("setGaps".equals(paramName)) {
/*  48 */           this.gaps_ = (IReflectionParameterCapable)param.getValue();
/*     */         }
/*  50 */         else if ("setVerticalStretch".equals(paramName)) {
/*  51 */           this.verticalStretch_ = (Boolean)paramValues[0];
/*     */         }
/*  53 */         else if ("setColumn".equals(paramName)) {
/*  54 */           this.columnSizes_ = (double[])paramValues[0];
/*  55 */           this.columnCount_ = Integer.valueOf(this.columnSizes_.length);
/*     */         }
/*  57 */         else if ("setRow".equals(paramName)) {
/*  58 */           this.rowSizes_ = (double[])paramValues[0];
/*  59 */           this.rowCount_ = Integer.valueOf(this.rowSizes_.length);
/*     */         }
/*  61 */         else if ("setMargins".equals(paramName)) {
/*  62 */           this.margins_ = (IReflectionParameterCapable)param.getValue();
/*     */         } 
/*     */       } 
/*     */     } 
/*  66 */     if (this.columnCount_ == null) {
/*  67 */       this.columnCount_ = Integer.valueOf(0);
/*     */     }
/*  69 */     if (this.rowCount_ == null) {
/*  70 */       this.rowCount_ = Integer.valueOf(0);
/*     */     }
/*     */     
/*  73 */     if (this.rowSizes_ == null) {
/*  74 */       this.rowSizes_ = new double[this.rowCount_.intValue()];
/*  75 */       for (int i = 0; i < this.rowSizes_.length; i++) {
/*  76 */         this.rowSizes_[i] = -1.0D;
/*     */       }
/*     */     } 
/*     */     
/*  80 */     if (this.columnSizes_ == null) {
/*  81 */       this.columnSizes_ = new double[this.columnCount_.intValue()];
/*  82 */       for (int i = 0; i < this.columnSizes_.length; i++) {
/*  83 */         this.columnSizes_[i] = -1.0D;
/*     */       }
/*     */     } 
/*  86 */     this.isDirty_ = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteColumn(Integer delColumn) {
/*  91 */     this.columnSizes_ = ArrayUtils.remove(this.columnSizes_, delColumn.intValue());
/*  92 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteRow(Integer delRow) {
/*  97 */     this.rowSizes_ = ArrayUtils.remove(this.rowSizes_, delRow.intValue());
/*  98 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getColumnCount() {
/* 103 */     return this.columnCount_;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getColumnSizes() {
/* 108 */     return this.columnSizes_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IReflectionParameterCapable<?> getGaps() {
/* 113 */     return this.gaps_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int[] getGapSizes() {
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParameterListConfig getParameterListConfig() {
/* 125 */     ParameterListConfig list = new ParameterListConfig();
/* 126 */     list.setConfigObject("Parameter", (IConfigObject)new ParameterConfig(new StringConfig("setGaps"), (IConfigObject)this.gaps_));
/*     */     
/* 128 */     list.setConfigObject("Parameter", (IConfigObject)new ParameterConfig(new StringConfig("setVerticalStretch"), (IConfigObject)new BooleanConfig(
/* 129 */             getVerticalStretch())));
/* 130 */     list.setConfigObject("Parameter", (IConfigObject)new ParameterConfig(new StringConfig("setColumn"), (IConfigObject)new DoubleArrayConfig(this.columnSizes_)));
/*     */     
/* 132 */     list.setConfigObject("Parameter", (IConfigObject)new ParameterConfig(new StringConfig("setRow"), (IConfigObject)new DoubleArrayConfig(this.rowSizes_)));
/*     */     
/* 134 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getRowCount() {
/* 139 */     return this.rowCount_;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getRowSizes() {
/* 144 */     return this.rowSizes_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getVerticalStretch() {
/* 149 */     return (this.verticalStretch_ == null) ? Boolean.TRUE : this.verticalStretch_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertColumn(Integer newColumn) {
/* 154 */     this.columnSizes_ = ArrayUtils.insert(this.columnSizes_, -1.0D, newColumn.intValue());
/* 155 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertRow(Integer newRow) {
/* 160 */     this.rowSizes_ = ArrayUtils.insert(this.rowSizes_, -1.0D, newRow.intValue());
/* 161 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/* 166 */     return this.isDirty_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClean() {
/* 171 */     this.isDirty_ = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColumnCount(Integer newValue) {
/* 176 */     if (newValue != null && this.columnCount_ != null && 
/* 177 */       newValue.intValue() > this.columnCount_.intValue()) {
/* 178 */       double[] newColSizes = new double[newValue.intValue()];
/* 179 */       System.arraycopy(this.columnSizes_, 0, newColSizes, 0, this.columnSizes_.length);
/* 180 */       for (int i = this.columnSizes_.length; i < newColSizes.length; i++) {
/* 181 */         newColSizes[i] = -1.0D;
/*     */       }
/* 183 */       this.columnSizes_ = newColSizes;
/*     */     } 
/*     */ 
/*     */     
/* 187 */     this.columnCount_ = newValue;
/* 188 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColumnSizes(double[] newValue) {
/* 193 */     this.columnSizes_ = newValue;
/* 194 */     this.columnCount_ = Integer.valueOf(this.columnSizes_.length);
/* 195 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setGapSizes(int[] newValue) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGaps(String newValue) {
/* 209 */     boolean isSet = false;
/* 210 */     if (StringUtils.isEmpty(newValue)) {
/* 211 */       this.gaps_ = null;
/* 212 */       isSet = true;
/*     */     } 
/* 214 */     if (!isSet) {
/*     */       try {
/* 216 */         IntegerArrayConfig test = new IntegerArrayConfig(newValue);
/* 217 */         if ((test.getIntegerArray()).length == 4) {
/* 218 */           this.gaps_ = (IReflectionParameterCapable<?>)test;
/* 219 */           isSet = true;
/*     */         }
/*     */       
/* 222 */       } catch (Throwable ex) {
/* 223 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/* 226 */     if (!isSet) {
/* 227 */       this.gaps_ = (IReflectionParameterCapable<?>)new InsetsRefConfig(newValue);
/*     */     }
/* 229 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRowCount(Integer newValue) {
/* 234 */     if (newValue != null && this.rowCount_ != null && 
/* 235 */       newValue.intValue() > this.rowCount_.intValue()) {
/* 236 */       double[] newRowSizes = new double[newValue.intValue()];
/* 237 */       System.arraycopy(this.rowSizes_, 0, newRowSizes, 0, this.rowSizes_.length);
/* 238 */       for (int i = this.rowSizes_.length; i < newRowSizes.length; i++) {
/* 239 */         newRowSizes[i] = -1.0D;
/*     */       }
/* 241 */       this.rowSizes_ = newRowSizes;
/*     */     } 
/*     */     
/* 244 */     this.rowCount_ = newValue;
/* 245 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRowSizes(double[] newValue) {
/* 250 */     this.rowSizes_ = newValue;
/* 251 */     this.rowCount_ = Integer.valueOf(this.rowSizes_.length);
/* 252 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVerticalStretch(Boolean newValue) {
/* 257 */     this.verticalStretch_ = newValue;
/* 258 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 265 */     if (this.columnSizes_.length > 0 || this.rowSizes_.length > 0 || hasGaps()) {
/* 266 */       argWriter.writeHeader("LayoutParameters", "ParameterList");
/*     */       
/* 268 */       if (this.columnSizes_.length > 0) {
/* 269 */         argWriter.writeHeader("Parameter", "Parameter", "name=\"setColumn\"");
/* 270 */         argWriter.writeTableLayoutComments(this.columnSizes_);
/* 271 */         argWriter.writeValue("param_value", "DoubleArray", getConfigValue(this.columnSizes_));
/* 272 */         argWriter.writeFooter("Parameter");
/*     */       } 
/*     */       
/* 275 */       if (this.rowSizes_.length > 0) {
/* 276 */         argWriter.writeHeader("Parameter", "Parameter", "name=\"setRow\"");
/* 277 */         argWriter.writeTableLayoutComments(this.rowSizes_);
/* 278 */         argWriter.writeValue("param_value", "DoubleArray", getConfigValue(this.rowSizes_));
/* 279 */         argWriter.writeFooter("Parameter");
/*     */       } 
/*     */ 
/*     */       
/* 283 */       if (hasGaps()) {
/* 284 */         argWriter.writeHeader("Parameter", "Parameter", "name=\"setGaps\"");
/* 285 */         argWriter.writeValue("param_value", this.gaps_);
/* 286 */         argWriter.writeFooter("Parameter");
/*     */       } 
/*     */ 
/*     */       
/* 290 */       if (this.margins_ != null) {
/* 291 */         argWriter.writeHeader("Parameter", "Parameter", "name=\"setMargins\"");
/* 292 */         argWriter.writeValue("param_value", this.margins_);
/* 293 */         argWriter.writeFooter("Parameter");
/*     */       } 
/*     */       
/* 296 */       if (this.verticalStretch_ != null) {
/* 297 */         argWriter.writeHeader("Parameter", "Parameter", "name=\"setVerticalStretch\"");
/*     */         
/* 299 */         argWriter.writeValue("param_value", "Boolean", this.verticalStretch_);
/* 300 */         argWriter.writeFooter("Parameter");
/*     */       } 
/*     */       
/* 303 */       argWriter.writeFooter("LayoutParameters");
/*     */     } 
/* 305 */     this.isDirty_ = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean hasGaps() {
/* 312 */     if (this.gaps_ instanceof InsetsRefConfig && !StringUtils.isEmpty(this.gaps_.getConfigValue())) {
/* 313 */       return true;
/*     */     }
/* 315 */     if (this.gaps_ instanceof IntegerArrayConfig) {
/* 316 */       int[] gaps = ((IntegerArrayConfig)this.gaps_).getIntegerArray();
/* 317 */       if ((gaps.length == 4 && gaps[0] > 0) || gaps[1] > 0 || gaps[2] > 0 || gaps[3] > 0) {
/* 318 */         return true;
/*     */       }
/*     */     } 
/* 321 */     return false;
/*     */   }
/*     */   
/*     */   private String getConfigValue(double[] da) {
/* 325 */     StringBuffer sb = new StringBuffer();
/* 326 */     for (double element : da) {
/* 327 */       sb.append(element);
/* 328 */       sb.append(", ");
/*     */     } 
/* 330 */     if (sb.length() > 2)
/*     */     {
/* 332 */       sb.setLength(sb.length() - 2);
/*     */     }
/* 334 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\LayoutParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */