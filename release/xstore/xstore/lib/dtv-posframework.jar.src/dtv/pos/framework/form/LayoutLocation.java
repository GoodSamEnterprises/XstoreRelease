/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.pos.iframework.form.ILayoutLocation;
/*     */ import dtv.pos.iframework.ui.TableLayoutHorizontalAlignment;
/*     */ import dtv.pos.iframework.ui.TableLayoutVerticalAlignment;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LayoutLocation
/*     */   implements ILayoutLocation
/*     */ {
/*     */   private String stringLocation_;
/*     */   private Integer row_;
/*     */   private Integer column_;
/*     */   private Integer rowSpan_;
/*     */   private Integer columnSpan_;
/*     */   private TableLayoutHorizontalAlignment horizontalAlign_;
/*     */   private TableLayoutVerticalAlignment verticalAlign_;
/*  28 */   private static final Integer ZERO = Integer.valueOf(0);
/*  29 */   private static final Integer ONE = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isDirty_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LayoutLocation(String argText) {
/*  40 */     if (argText == null || argText.indexOf(',') < 0) {
/*  41 */       this.stringLocation_ = argText;
/*     */       return;
/*     */     } 
/*  44 */     if (argText.startsWith("_")) {
/*  45 */       String uiProp = UIResourceManager.getInstance().getString(argText);
/*  46 */       this.stringLocation_ = (uiProp != null) ? uiProp : argText;
/*     */       return;
/*     */     } 
/*  49 */     String[] fields = (argText == null) ? new String[0] : argText.split(",");
/*     */     
/*  51 */     this.column_ = (fields.length > 0) ? Integer.valueOf(fields[0].trim()) : ZERO;
/*  52 */     this.row_ = (fields.length > 1) ? Integer.valueOf(fields[1].trim()) : ZERO;
/*     */     
/*  54 */     this.columnSpan_ = (fields.length > 2) ? Integer.valueOf(fields[2].trim()) : ONE;
/*  55 */     this.rowSpan_ = (fields.length > 3) ? Integer.valueOf(fields[3].trim()) : ONE;
/*     */     
/*  57 */     this
/*  58 */       .horizontalAlign_ = (fields.length > 4) ? TableLayoutHorizontalAlignment.forName(fields[4]) : TableLayoutHorizontalAlignment.FULL;
/*     */     
/*  60 */     this
/*  61 */       .verticalAlign_ = (fields.length > 5) ? TableLayoutVerticalAlignment.forName(fields[5]) : TableLayoutVerticalAlignment.FULL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ILayoutLocation other) {
/*  67 */     if (this.stringLocation_ != null || this.row_ == null) {
/*  68 */       return 0;
/*     */     }
/*  70 */     int comparison = this.row_.compareTo(other.getRow());
/*  71 */     if (comparison == 0)
/*     */     {
/*  73 */       return this.column_.compareTo(other.getColumn());
/*     */     }
/*     */ 
/*     */     
/*  77 */     return comparison;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getColumn() {
/*  83 */     return this.column_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getColumnSpan() {
/*  88 */     return this.columnSpan_;
/*     */   }
/*     */   
/*     */   public TableLayoutHorizontalAlignment getHorizontalAlignment() {
/*  92 */     return this.horizontalAlign_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getRow() {
/*  97 */     return this.row_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getRowSpan() {
/* 102 */     return this.rowSpan_;
/*     */   }
/*     */   
/*     */   public TableLayoutVerticalAlignment getVerticalAlignment() {
/* 106 */     return this.verticalAlign_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/* 111 */     return this.isDirty_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClean() {
/* 116 */     this.isDirty_ = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColumn(Integer newValue) {
/* 121 */     this.column_ = newValue;
/* 122 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColumnSpan(Integer newValue) {
/* 127 */     this.columnSpan_ = newValue;
/* 128 */     this.isDirty_ = true;
/*     */   }
/*     */   
/*     */   public void setHorizontalAlignment(TableLayoutHorizontalAlignment newValue) {
/* 132 */     this.horizontalAlign_ = newValue;
/* 133 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRow(Integer newValue) {
/* 138 */     this.row_ = newValue;
/* 139 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRowSpan(Integer newValue) {
/* 144 */     this.rowSpan_ = newValue;
/* 145 */     this.isDirty_ = true;
/*     */   }
/*     */   
/*     */   public void setVerticalAlignment(TableLayoutVerticalAlignment newValue) {
/* 149 */     this.verticalAlign_ = newValue;
/* 150 */     this.isDirty_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     if (this.stringLocation_ != null) {
/* 156 */       return this.stringLocation_;
/*     */     }
/* 158 */     return this.column_ + ", " + this.row_ + ", " + this.columnSpan_ + ", " + this.rowSpan_ + ", " + this.horizontalAlign_
/* 159 */       .toString().charAt(0) + ", " + this.verticalAlign_.toString().charAt(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 166 */     if (this.horizontalAlign_ != null && this.verticalAlign_ != null) {
/* 167 */       argWriter.writeValue("LayoutLocation", "String", toString());
/*     */     }
/* 169 */     this.isDirty_ = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\LayoutLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */