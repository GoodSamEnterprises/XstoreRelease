/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.DataPropertyMap;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IDataPropertyParent;
/*     */ import dtv.data2.access.IHasDataProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractDataModelWithPropertyImpl<T extends IDataProperty>
/*     */   extends AbstractDataModelImpl
/*     */   implements IDataPropertyParent<T>, IHasDataProperty<T>
/*     */ {
/*     */   private static final long serialVersionUID = 6666677777L;
/*     */   private transient Map<String, T> _propertyMap;
/*     */   
/*     */   public boolean deleteProperty(String argPropertyName) {
/*  27 */     return (getPropertyMap().remove(argPropertyName) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBooleanProperty(String argPropertyName) {
/*  32 */     return getBooleanProperty(argPropertyName, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBooleanProperty(String argPropertyName, boolean argDefault) {
/*  37 */     T prop = getProperty(argPropertyName);
/*  38 */     return (prop == null) ? argDefault : prop.getBooleanValue(argDefault);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDateProperty(String argPropertyName) {
/*  43 */     return getDateProperty(argPropertyName, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDateProperty(String argPropertyName, Date argDefault) {
/*  48 */     T prop = getProperty(argPropertyName);
/*  49 */     return (prop == null) ? argDefault : prop.getDateValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalProperty(String argPropertyName) {
/*  54 */     return getDecimalProperty(argPropertyName, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalProperty(String argPropertyName, BigDecimal argDefault) {
/*  59 */     T prop = getProperty(argPropertyName);
/*  60 */     return (prop == null) ? argDefault : prop.getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract List<T> getProperties();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getProperty(String argPropertyName) {
/*  75 */     return getPropertyMap().get(argPropertyName);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringProperty(String argPropertyName) {
/*  80 */     return getStringProperty(argPropertyName, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringProperty(String argPropertyName, String argDefault) {
/*  85 */     T prop = getProperty(argPropertyName);
/*  86 */     return (prop == null) ? argDefault : prop.getStringValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType(String argPropertyName) {
/*  91 */     T prop = getProperty(argPropertyName);
/*  92 */     return (prop == null) ? null : prop.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBooleanProperty(String argPropertyName, boolean argValue) {
/*  97 */     T prop = getOrCreateProperty(argPropertyName);
/*  98 */     prop.setType("BOOLEAN");
/*  99 */     prop.setBooleanValue(argValue);
/* 100 */     setProperty(prop);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDateProperty(String argPropertyName, Date argValue) {
/* 105 */     if (argValue == null) {
/* 106 */       deleteProperty(argPropertyName);
/*     */     } else {
/*     */       
/* 109 */       T prop = getOrCreateProperty(argPropertyName);
/* 110 */       prop.setType("DATE");
/* 111 */       prop.setDateValue(argValue);
/* 112 */       setProperty(prop);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDecimalProperty(String argPropertyName, BigDecimal argValue) {
/* 118 */     if (argValue == null) {
/* 119 */       deleteProperty(argPropertyName);
/*     */     } else {
/*     */       
/* 122 */       T prop = getOrCreateProperty(argPropertyName);
/* 123 */       prop.setType("BIGDECIMAL");
/* 124 */       prop.setDecimalValue(argValue);
/* 125 */       setProperty(prop);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setProperties(List<T> paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringProperty(String argPropertyName, String argValue) {
/* 141 */     if (argValue == null) {
/* 142 */       deleteProperty(argPropertyName);
/*     */     } else {
/*     */       
/* 145 */       T prop = getOrCreateProperty(argPropertyName);
/* 146 */       prop.setType("STRING");
/* 147 */       prop.setStringValue(argValue);
/* 148 */       setProperty(prop);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected T getOrCreateProperty(String argPropertyName) {
/* 153 */     T prop = getProperty(argPropertyName);
/* 154 */     if (prop == null) {
/* 155 */       return newProperty(argPropertyName);
/*     */     }
/*     */     
/* 158 */     return prop;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Map<String, T> getPropertyMap() {
/* 163 */     if (this._propertyMap == null) {
/* 164 */       this._propertyMap = (Map<String, T>)new DataPropertyMap(this);
/*     */     }
/* 166 */     return this._propertyMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T newProperty(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setProperty(T argProperty) {
/* 184 */     getPropertyMap().put(argProperty.getPropertyCode(), argProperty);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractDataModelWithPropertyImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */