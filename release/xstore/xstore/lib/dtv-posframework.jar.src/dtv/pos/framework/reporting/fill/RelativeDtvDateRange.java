/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.pos.iframework.type.IDtvDateRange;
/*     */ import dtv.pos.storecalendar.IStoreCalendar;
/*     */ import dtv.pos.storecalendar.StoreCalendarException;
/*     */ import dtv.util.DateRange;
/*     */ import dtv.util.config.ConfigException;
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
/*     */ public class RelativeDtvDateRange
/*     */   implements IDtvDateRange, Comparable<RelativeDtvDateRange>
/*     */ {
/*  29 */   private static final Logger logger_ = Logger.getLogger(RelativeDtvDateRange.class);
/*     */ 
/*     */   
/*  32 */   public static final IDtvDateRange TODAY = new RelativeDtvDateRange("TODAY", "_relativeDateRangeDescrToday", 204, 0, 1);
/*     */ 
/*     */   
/*  35 */   public static final IDtvDateRange THIS_WEEK = new RelativeDtvDateRange("THIS_WEEK", "_relativeDateRangeDescrCurrentWeek", 203, 0, 2);
/*     */   
/*  37 */   public static final IDtvDateRange THIS_MONTH = new RelativeDtvDateRange("THIS_MONTH", "_relativeDateRangeDescrCurrentMonth", 202, 0, 3);
/*     */   
/*  39 */   public static final IDtvDateRange THIS_QUARTER = new RelativeDtvDateRange("THIS_QUARTER", "_relativeDateRangeDescrCurrentQuarter", 201, 0, 4);
/*     */   
/*  41 */   public static final IDtvDateRange THIS_YEAR = new RelativeDtvDateRange("THIS_YEAR", "_relativeDateRangeDescrCurrentYear", 200, 0, 5);
/*     */   
/*  43 */   public static final IDtvDateRange YESTERDAY = new RelativeDtvDateRange("YESTERDAY", "_relativeDateRangeDescrYesterday", 204, -1, 6);
/*     */   
/*  45 */   public static final IDtvDateRange LAST_WEEK = new RelativeDtvDateRange("LAST_WEEK", "_relativeDateRangeDescrPrevWeek", 203, -1, 7);
/*     */   
/*  47 */   public static final IDtvDateRange LAST_MONTH = new RelativeDtvDateRange("LAST_MONTH", "_relativeDateRangeDescrPrevMonth", 202, -1, 8);
/*     */   
/*  49 */   public static final IDtvDateRange LAST_QUARTER = new RelativeDtvDateRange("LAST_QUARTER", "_relativeDateRangeDescrPrevQuarter", 201, -1, 9);
/*     */   
/*  51 */   public static final IDtvDateRange LAST_YEAR = new RelativeDtvDateRange("LAST_YEAR", "_relativeDateRangeDescrPrevYear", 200, -1, 10);
/*     */   private static final long serialVersionUID = 5730649790620120436L;
/*     */   private static Map<RelativeDtvDateRange, RelativeDtvDateRange> instances_;
/*     */   private static Map<String, RelativeDtvDateRange> instancesByName_;
/*     */   private static RelativeDtvDateRange[] sortedInstances_;
/*     */   @Inject
/*     */   private FormattableFactory _formattableFactory;
/*     */   @Inject
/*     */   private IStoreCalendar _storeCalendar;
/*     */   @Inject
/*     */   private TransDateProvider _transDateProvider;
/*     */   private final String name_;
/*     */   private String descriptionKey_;
/*     */   private int offsetType_;
/*     */   private int offsetAmount_;
/*     */   private final int sortOrder_;
/*     */   
/*     */   public static final RelativeDtvDateRange forName(String argName) {
/*  69 */     RelativeDtvDateRange found = instancesByName_.get(argName.toUpperCase());
/*  70 */     if (found == null) {
/*  71 */       logger_.warn("there is no instance of " + RelativeDtvDateRange.class.getName() + " named " + argName);
/*     */     }
/*  73 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RelativeDtvDateRange[] getInstances() {
/*  82 */     if (sortedInstances_ == null) {
/*     */       
/*  84 */       RelativeDtvDateRange[] instances = (RelativeDtvDateRange[])instances_.values().toArray((Object[])new RelativeDtvDateRange[instances_.size()]);
/*  85 */       Arrays.sort((Object[])instances);
/*  86 */       sortedInstances_ = instances;
/*     */     } 
/*  88 */     return sortedInstances_;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RelativeDtvDateRange(String argName, String argDescriptionKey, int argOffsetType, int argOffsetAmount, int argSortOrder) {
/* 111 */     this.name_ = argName;
/* 112 */     this.sortOrder_ = argSortOrder;
/* 113 */     this.descriptionKey_ = argDescriptionKey;
/* 114 */     setOffsetType(argOffsetType);
/* 115 */     this.offsetAmount_ = argOffsetAmount;
/* 116 */     processInjections();
/* 117 */     if (instances_ == null) {
/* 118 */       instances_ = new HashMap<>();
/* 119 */       instancesByName_ = new HashMap<>();
/*     */     } 
/* 121 */     instances_.put(this, this);
/* 122 */     instancesByName_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(RelativeDtvDateRange argOther) {
/* 133 */     int anotherVal = argOther.sortOrder_;
/* 134 */     return (this.sortOrder_ < anotherVal) ? -1 : ((this.sortOrder_ == anotherVal) ? 0 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/* 145 */     if (argOther == this) {
/* 146 */       return true;
/*     */     }
/* 148 */     if (!(argOther instanceof RelativeDtvDateRange)) {
/* 149 */       return false;
/*     */     }
/* 151 */     RelativeDtvDateRange other = (RelativeDtvDateRange)argOther;
/*     */     
/* 153 */     return (other.offsetType_ == this.offsetType_ && other.offsetAmount_ == this.offsetAmount_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange() {
/* 159 */     return getDateRange(this._transDateProvider.getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(boolean argEndOfDay) {
/* 165 */     return getDateRange(this._transDateProvider.getDate(), argEndOfDay);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(Date argReferencePoint) {
/* 171 */     return getDateRange(argReferencePoint, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(Date argReferencePoint, boolean argEndOfDay) {
/* 177 */     switch (this.offsetType_) {
/*     */       
/*     */       case 200:
/*     */       case 201:
/*     */       case 202:
/*     */       case 203:
/*     */       case 204:
/*     */         
/*     */         try {
/* 186 */           DateRange dateRange = this._storeCalendar.getDateRange(this.offsetType_, argReferencePoint, this.offsetAmount_, argReferencePoint);
/* 187 */           if (argEndOfDay) {
/* 188 */             return dateRange.toEndOfDay();
/*     */           }
/* 190 */           return dateRange;
/*     */         }
/* 192 */         catch (StoreCalendarException ex) {
/* 193 */           throw new ConfigException(ex);
/*     */         } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 199 */     throw new IllegalStateException("unknown offset type " + this.offsetType_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getDescription() {
/* 206 */     DateRange r = getDateRange();
/*     */     
/* 208 */     IFormattable start = this._formattableFactory.getSimpleFormattable(r.getStartDate(), FormatterType.DATE_MEDIUM);
/*     */     
/* 210 */     IFormattable end = this._formattableFactory.getSimpleFormattable(r.getEndDate(), FormatterType.DATE_MEDIUM);
/*     */     
/* 212 */     IFormattable[] fa = { this._formattableFactory.getTranslatable(this.descriptionKey_), start, end };
/* 213 */     return this._formattableFactory.getTranslatable("_dateRelativeRangeDescr", fa);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 219 */     return getEndDate(this._transDateProvider.getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate(boolean argEndOfDay) {
/* 225 */     return getEndDate(this._transDateProvider.getDate(), argEndOfDay);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate(Date argReferencePoint) {
/* 231 */     return getEndDate(argReferencePoint, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate(Date argReferencePoint, boolean argEndOfDay) {
/* 237 */     return getDateRange(argReferencePoint, argEndOfDay).getEndDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 246 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartDate() {
/* 252 */     return getStartDate(this._transDateProvider.getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartDate(Date argReferencePoint) {
/* 258 */     return getDateRange(argReferencePoint).getStartDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 268 */     int result = 17;
/* 269 */     result = 37 * result + this.offsetType_;
/* 270 */     result = 37 * result + this.offsetAmount_;
/* 271 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRelative() {
/* 281 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toExternalForm() {
/* 287 */     return getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 297 */     return getDescription().toString(OutputContextType.VIEW);
/*     */   }
/*     */   
/*     */   private void processInjections() {
/*     */     try {
/* 302 */       InjectionHammer.forceAtInjectProcessing(this);
/*     */     }
/* 304 */     catch (Exception ex) {
/* 305 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException {
/* 314 */     this.descriptionKey_ = in.readUTF();
/*     */     
/* 316 */     setOffsetType(in.readInt());
/* 317 */     this.offsetAmount_ = in.readInt();
/* 318 */     processInjections();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object readResolve() {
/* 324 */     Object preexisting = instances_.get(this);
/* 325 */     if (preexisting == null) {
/* 326 */       return this;
/*     */     }
/*     */     
/* 329 */     return preexisting;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setOffsetType(int argOffsetType) {
/* 334 */     switch (argOffsetType) {
/*     */       case 200:
/*     */       case 201:
/*     */       case 202:
/*     */       case 203:
/*     */       case 204:
/* 340 */         this.offsetType_ = argOffsetType;
/*     */         return;
/*     */     } 
/* 343 */     throw new IllegalArgumentException("unknown offset type " + argOffsetType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 352 */     out.writeUTF(this.descriptionKey_);
/*     */     
/* 354 */     out.writeInt(this.offsetType_);
/* 355 */     out.writeInt(this.offsetAmount_);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\RelativeDtvDateRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */