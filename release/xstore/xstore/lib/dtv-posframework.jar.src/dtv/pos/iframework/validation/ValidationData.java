/*     */ package dtv.pos.iframework.validation;
/*     */ 
/*     */ import dtv.util.Money;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValidationData
/*     */   implements IValidationData
/*     */ {
/*     */   private final ValidationDataType type_;
/*     */   private final Object[] data_;
/*     */   private final Object[] suppliedData_;
/*     */   
/*     */   public ValidationData(BigDecimal data) {
/*  30 */     this(ValidationDataType.BIG_DECIMAL, data);
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
/*     */   public ValidationData(BigDecimal data, Object[] suppliedData) {
/*  42 */     this(ValidationDataType.BIG_DECIMAL, data, suppliedData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationData(double data) {
/*  52 */     this(ValidationDataType.DOUBLE, Double.valueOf(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationData(int data) {
/*  62 */     this(ValidationDataType.INT, Integer.valueOf(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationData(Money data) {
/*  72 */     this(ValidationDataType.MONEY, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationData(Object[] data) {
/*  82 */     this(ValidationDataType.OBJECT_ARRAY, data, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationData(String data) {
/*  92 */     this(ValidationDataType.STRING, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationData(ValidationDataType type, Object data) {
/* 103 */     this(type, new Object[] { data }, new Object[] { data });
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
/*     */   public ValidationData(ValidationDataType type, Object data, Object[] suppliedData) {
/* 116 */     this(type, new Object[] { data }, suppliedData);
/*     */   }
/*     */   
/*     */   private ValidationData(ValidationDataType type, Object[] data, Object[] suppliedData) {
/* 120 */     this.type_ = type;
/* 121 */     this.data_ = data;
/* 122 */     this.suppliedData_ = suppliedData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal() {
/* 133 */     if (this.type_ != ValidationDataType.BIG_DECIMAL) {
/* 134 */       throw new UnsupportedOperationException("Invalid access of validation data as big decimal.  Type is " + this.type_);
/*     */     }
/*     */     
/* 137 */     return (BigDecimal)this.data_[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDouble() {
/* 148 */     if (this.type_ != ValidationDataType.DOUBLE) {
/* 149 */       throw new UnsupportedOperationException("Invalid access of validation data as double.  Type is " + this.type_);
/*     */     }
/*     */     
/* 152 */     return ((Double)this.data_[0]).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt() {
/* 163 */     if (this.type_ != ValidationDataType.INT) {
/* 164 */       throw new UnsupportedOperationException("Invalid access of validation data as int.  Type is " + this.type_);
/*     */     }
/* 166 */     return ((Integer)this.data_[0]).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Money getMoney() {
/* 177 */     if (this.type_ != ValidationDataType.MONEY) {
/* 178 */       throw new UnsupportedOperationException("Invalid access of validation data as money.  Type is " + this.type_);
/*     */     }
/* 180 */     return (Money)this.data_[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 191 */     if (this.type_ != ValidationDataType.OBJECT) {
/* 192 */       throw new UnsupportedOperationException("Invalid access of validation data as object.  Type is " + this.type_);
/*     */     }
/*     */     
/* 195 */     return this.data_[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getObjectArray() {
/* 206 */     if (this.type_ != ValidationDataType.OBJECT_ARRAY) {
/* 207 */       throw new UnsupportedOperationException("Invalid access of validation data as object array.  Type is " + this.type_);
/*     */     }
/*     */     
/* 210 */     return this.data_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 221 */     if (this.type_ != ValidationDataType.STRING) {
/* 222 */       throw new UnsupportedOperationException("Invalid access of validation data as string.  Type is " + this.type_);
/*     */     }
/*     */     
/* 225 */     return (String)this.data_[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getSuppliedData() {
/* 235 */     return this.suppliedData_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValidationDataType getType() {
/* 241 */     return this.type_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\ValidationData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */