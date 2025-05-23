/*     */ package dtv.pos.framework.form.design.model;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public abstract class AbstractDetailEditModel
/*     */   implements PropertyEditTableModel
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(AbstractDetailEditModel.class);
/*     */   
/*  28 */   private static final String[] COLUMN_NAMES = new String[] { "property", "value" };
/*     */   
/*     */   private final String[] rowLabels_;
/*     */   
/*     */   private final Class[] rowClasses_;
/*  33 */   private final List<TableModelListener> listeners_ = new ArrayList<>();
/*     */   
/*     */   public AbstractDetailEditModel(int argRowCount, String[] argRowLabels, Class[] argRowClasses) {
/*  36 */     if (argRowLabels.length != argRowCount) {
/*  37 */       throw new IllegalArgumentException("label count [" + argRowLabels.length + "] disagrees with row count [" + argRowCount + "]");
/*     */     }
/*     */     
/*  40 */     if (argRowClasses.length != argRowCount) {
/*  41 */       throw new IllegalArgumentException("class count [" + argRowClasses.length + "] disagrees with row count [" + argRowCount + "]");
/*     */     }
/*     */     
/*  44 */     this.rowLabels_ = argRowLabels;
/*  45 */     this.rowClasses_ = argRowClasses;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addTableModelListener(TableModelListener l) {
/*  50 */     this.listeners_.add(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class getCellClass(int rowIndex, int columnIndex) {
/*  55 */     Class<?> c = null;
/*  56 */     if (columnIndex == 0) {
/*  57 */       c = getColumnClass(0);
/*     */     } else {
/*     */       
/*  60 */       c = this.rowClasses_[rowIndex];
/*     */     } 
/*  62 */     if (c == null) {
/*  63 */       logger_.error("null class for row:" + rowIndex + ", col:" + columnIndex + " in " + getClass());
/*     */     }
/*  65 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int columnIndex) {
/*  70 */     return String.class;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/*  75 */     return COLUMN_NAMES.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int columnIndex) {
/*  80 */     return COLUMN_NAMES[columnIndex];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/*  85 */     return this.rowLabels_.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/*  90 */     if (columnIndex == 0) {
/*  91 */       return this.rowLabels_[rowIndex];
/*     */     }
/*     */     
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 100 */     if (columnIndex == 1) {
/* 101 */       return true;
/*     */     }
/*     */     
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTableModelListener(TableModelListener l) {
/* 110 */     this.listeners_.remove(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/* 115 */     logger_.warn("NOT YET IMPLEMENTED IN " + getClass().getName());
/*     */   }
/*     */   
/*     */   protected String makeString(double[] doubleValues) {
/* 119 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 121 */     for (double doubleValue : doubleValues) {
/* 122 */       if (doubleValue == -1.0D) {
/* 123 */         sb.append("FILL");
/*     */       }
/* 125 */       else if (doubleValue == -2.0D) {
/* 126 */         sb.append("PREFERRED");
/*     */       }
/* 128 */       else if (doubleValue == -3.0D) {
/* 129 */         sb.append("MINIMUM");
/*     */       } else {
/*     */         
/* 132 */         sb.append(doubleValue);
/*     */       } 
/* 134 */       sb.append(", ");
/*     */     } 
/*     */     
/* 137 */     if (sb.length() > 1) {
/* 138 */       sb.setLength(sb.length() - 2);
/*     */     }
/* 140 */     return sb.toString();
/*     */   }
/*     */   
/*     */   protected String makeString(int[] intValues) {
/* 144 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 146 */     for (int intValue : intValues) {
/* 147 */       sb.append(intValue);
/* 148 */       sb.append(", ");
/*     */     } 
/*     */     
/* 151 */     sb.setLength(sb.length() - 2);
/* 152 */     return sb.toString();
/*     */   }
/*     */   
/*     */   protected double[] parseToDoubleArray(String argText) {
/* 156 */     String[] fields = argText.toUpperCase().split(",");
/* 157 */     double[] doubles = new double[fields.length];
/* 158 */     int doubleCount = 0;
/*     */     
/* 160 */     for (String field : fields) {
/* 161 */       String f = field.trim();
/* 162 */       if (!StringUtils.isEmpty(f))
/*     */       {
/*     */         
/* 165 */         if (f.startsWith("F")) {
/* 166 */           doubles[doubleCount++] = -1.0D;
/*     */         }
/* 168 */         else if (f.startsWith("P")) {
/* 169 */           doubles[doubleCount++] = -2.0D;
/*     */         }
/* 171 */         else if (f.startsWith("M")) {
/* 172 */           doubles[doubleCount++] = -3.0D;
/*     */         } else {
/*     */           
/*     */           try {
/* 176 */             double d = Double.parseDouble(f);
/* 177 */             doubles[doubleCount++] = d;
/*     */           }
/* 179 */           catch (NumberFormatException ex) {
/* 180 */             logger_.error("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 187 */     double[] rtn = new double[doubleCount];
/* 188 */     System.arraycopy(doubles, 0, rtn, 0, doubleCount);
/* 189 */     return rtn;
/*     */   }
/*     */   
/*     */   protected int[] parseToIntArray(String argText) {
/* 193 */     String[] fields = argText.toUpperCase().split(",");
/* 194 */     int[] integers = new int[fields.length];
/* 195 */     int intCount = 0;
/*     */     
/* 197 */     for (String field : fields) {
/* 198 */       String f = field.trim();
/*     */       try {
/* 200 */         int value = Integer.parseInt(f);
/* 201 */         integers[intCount++] = value;
/*     */       }
/* 203 */       catch (NumberFormatException ex) {
/* 204 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 210 */     int[] rtn = new int[intCount];
/* 211 */     System.arraycopy(integers, 0, rtn, 0, intCount);
/* 212 */     return rtn;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\AbstractDetailEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */