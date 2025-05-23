/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.pos.iframework.type.IDtvDate;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RelativeDtvDate
/*     */   implements IDtvDate, Comparable
/*     */ {
/*  29 */   private static final Logger logger_ = Logger.getLogger(RelativeDtvDate.class);
/*     */   
/*  31 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */ 
/*     */   
/*  34 */   public static final IDtvDate TODAY = new RelativeDtvDate("TODAY", "_relativeDateDescrToday", 0, 0);
/*  35 */   public static final IDtvDate YESTERDAY = new RelativeDtvDate("YESTERDAY", "_relativeDateDescrYesterday", -1, 1);
/*     */   
/*     */   private static final long serialVersionUID = 7022751476447345441L;
/*     */   private static Map<RelativeDtvDate, RelativeDtvDate> instances_;
/*     */   private static Map<String, RelativeDtvDate> instancesByName_;
/*     */   private static RelativeDtvDate[] sortedInstances_;
/*     */   private final String name_;
/*     */   private String descriptionKey_;
/*     */   private int offsetAmount_;
/*     */   private final int sortOrder_;
/*     */   @Inject
/*     */   private TransDateProvider _transDateProvider;
/*     */   
/*     */   public static final RelativeDtvDate forName(String argName) {
/*  49 */     RelativeDtvDate found = instancesByName_.get(argName.toUpperCase());
/*  50 */     if (found == null) {
/*  51 */       logger_.warn("there is no instance of " + RelativeDtvDate.class.getName() + " named " + argName);
/*     */     }
/*  53 */     return found;
/*     */   }
/*     */   
/*     */   public static RelativeDtvDate[] getInstances() {
/*  57 */     if (sortedInstances_ == null) {
/*  58 */       RelativeDtvDate[] instances = (RelativeDtvDate[])instances_.values().toArray((Object[])new RelativeDtvDate[instances_.size()]);
/*  59 */       Arrays.sort((Object[])instances);
/*  60 */       sortedInstances_ = instances;
/*     */     } 
/*  62 */     return sortedInstances_;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RelativeDtvDate(String argName, String argDescriptionKey, int argOffsetAmount, int argSortOrder) {
/*  79 */     processInjections();
/*  80 */     this.name_ = argName;
/*  81 */     this.descriptionKey_ = argDescriptionKey;
/*     */     
/*  83 */     this.offsetAmount_ = argOffsetAmount;
/*  84 */     this.sortOrder_ = argSortOrder;
/*  85 */     if (instances_ == null) {
/*  86 */       instances_ = new HashMap<>();
/*  87 */       instancesByName_ = new HashMap<>();
/*     */     } 
/*  89 */     instances_.put(this, this);
/*  90 */     instancesByName_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Object argOther) {
/*  95 */     int anotherVal = ((RelativeDtvDate)argOther).sortOrder_;
/*  96 */     return (this.sortOrder_ < anotherVal) ? -1 : ((this.sortOrder_ == anotherVal) ? 0 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/* 101 */     if (argOther == this) {
/* 102 */       return true;
/*     */     }
/* 104 */     if (!(argOther instanceof RelativeDtvDate)) {
/* 105 */       return false;
/*     */     }
/* 107 */     RelativeDtvDate other = (RelativeDtvDate)argOther;
/*     */     
/* 109 */     return (other.offsetAmount_ == this.offsetAmount_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate() {
/* 115 */     return getDate(this._transDateProvider.getDate());
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDate(Date argReferencePoint) {
/* 120 */     return DateUtils.dateAdd(CalendarField.DAY, this.offsetAmount_, argReferencePoint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getDescription() {
/* 127 */     IFormattable[] fa = { FF.getTranslatable(this.descriptionKey_), FF.getSimpleFormattable(getDate(), FormatterType.DATE_MEDIUM) };
/* 128 */     return FF.getTranslatable("_dateRelativeDescr", fa);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 132 */     return this.name_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 137 */     int result = 17;
/*     */     
/* 139 */     result = 37 * result + this.offsetAmount_;
/* 140 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRelative() {
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toExternalForm() {
/* 150 */     return getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     return getDescription().toString(OutputContextType.VIEW);
/*     */   }
/*     */   
/*     */   private void processInjections() {
/*     */     try {
/* 160 */       InjectionHammer.forceAtInjectProcessing(this);
/*     */     }
/* 162 */     catch (Exception ex) {
/* 163 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException {
/* 171 */     this.descriptionKey_ = in.readUTF();
/*     */     
/* 173 */     in.readInt();
/* 174 */     this.offsetAmount_ = in.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   private Object readResolve() {
/* 179 */     Object preexisting = instances_.get(this);
/* 180 */     if (preexisting == null) {
/* 181 */       return this;
/*     */     }
/*     */     
/* 184 */     return preexisting;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 191 */     out.writeUTF(this.descriptionKey_);
/*     */     
/* 193 */     out.writeInt(0);
/* 194 */     out.writeInt(this.offsetAmount_);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\RelativeDtvDate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */