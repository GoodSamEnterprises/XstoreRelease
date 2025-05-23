/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.DataPropertyUtils;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ public abstract class AbstractDataModelPropertiesImpl
/*     */   extends AbstractDataModelImpl
/*     */   implements IDataProperty
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public boolean getBooleanValue(boolean argDefault) {
/*  32 */     BigDecimal value = getDecimalValue();
/*  33 */     return (value == null) ? argDefault : (!NumberUtils.isZero(value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getPropertyValue() {
/*  39 */     Object propertyValue = null;
/*  40 */     String valueType = getType();
/*     */     
/*  42 */     if (valueType == null) {
/*     */       
/*  44 */       propertyValue = ObjectUtils.coalesce((Object[])new Serializable[] { getStringValue(), getDecimalValue(), getDateValue() });
/*     */     }
/*  46 */     else if ("BOOLEAN".equalsIgnoreCase(valueType)) {
/*  47 */       propertyValue = Boolean.valueOf(getBooleanValue(false));
/*     */     }
/*  49 */     else if ("DATE".equalsIgnoreCase(valueType)) {
/*  50 */       propertyValue = getDateValue();
/*     */     }
/*  52 */     else if ("BIGDECIMAL".equalsIgnoreCase(valueType)) {
/*  53 */       propertyValue = getDecimalValue();
/*     */     }
/*  55 */     else if ("STRING".equalsIgnoreCase(valueType)) {
/*  56 */       propertyValue = getStringValue();
/*     */     } else {
/*     */       
/*  59 */       _logger.warn("Unknown property type [" + valueType + "] assigned to model [" + this + "]!");
/*     */     } 
/*  61 */     return propertyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBooleanValue(boolean argValue) {
/*  67 */     setDecimalValue(argValue ? BigDecimal.ONE : BigDecimal.ZERO);
/*  68 */     setType("BOOLEAN");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyValue(Object argValue) {
/*  74 */     String valueType = getPropertyValueType(argValue);
/*     */     
/*  76 */     if ("BOOLEAN".equalsIgnoreCase(valueType)) {
/*  77 */       setBooleanValue(((Boolean)argValue).booleanValue());
/*     */     }
/*  79 */     else if ("DATE".equalsIgnoreCase(valueType)) {
/*  80 */       setDateValue((Date)argValue);
/*     */     }
/*  82 */     else if ("BIGDECIMAL".equalsIgnoreCase(valueType)) {
/*  83 */       setDecimalValue((BigDecimal)argValue);
/*     */     }
/*  85 */     else if ("STRING".equalsIgnoreCase(valueType)) {
/*  86 */       setStringValue((String)argValue);
/*     */     }
/*  88 */     else if (argValue != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  93 */       _logger.warn("Unknown property type [" + valueType + "] assigned to model [" + this + "].  Converting [" + argValue + "] to a string and assigning it as such,  though the calling client should be performing this conversion explicitly.");
/*     */ 
/*     */ 
/*     */       
/*  97 */       setStringValue(argValue.toString());
/*  98 */       valueType = "STRING";
/*     */     } 
/* 100 */     setType(valueType);
/*     */   }
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
/*     */   private String getPropertyValueType(Object argValue) {
/* 113 */     String valueType = null;
/*     */     
/* 115 */     if (argValue == null) {
/*     */ 
/*     */       
/* 118 */       valueType = getType();
/*     */       
/* 120 */       if (StringUtils.isEmpty(valueType)) {
/*     */         
/* 122 */         Object existingValue = getPropertyValue();
/* 123 */         valueType = DataPropertyUtils.getPropertyValueType(existingValue);
/*     */       } 
/*     */     } else {
/*     */       
/* 127 */       valueType = DataPropertyUtils.getPropertyValueType(argValue);
/*     */     } 
/* 129 */     return valueType;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractDataModelPropertiesImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */