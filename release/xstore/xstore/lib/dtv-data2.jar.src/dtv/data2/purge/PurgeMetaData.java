/*     */ package dtv.data2.purge;
/*     */ 
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ public class PurgeMetaData
/*     */ {
/*     */   public static PurgeMetaData makeFailure(Throwable argPurgeError) {
/*  23 */     PurgeMetaData purgeData = new PurgeMetaData();
/*  24 */     purgeData.setPurgeError(argPurgeError);
/*     */     
/*  26 */     return purgeData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PurgeMetaData makeSuccess(int argRecordsPurged, long argPurgeTime) {
/*  37 */     PurgeMetaData purgeData = new PurgeMetaData();
/*  38 */     purgeData.setRecordsPurged(argRecordsPurged);
/*  39 */     purgeData.setPurgeTime(argPurgeTime);
/*     */     
/*  41 */     return purgeData;
/*     */   }
/*     */   
/*  44 */   private int _recordsPurged = 0;
/*  45 */   private int _tablesPurged = 0;
/*  46 */   private int _tablesTargeted = 0;
/*     */   
/*  48 */   private long _purgeTime = 0L;
/*     */   
/*  50 */   private Throwable _purgeError = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(PurgeMetaData argPurgeData) {
/*  59 */     this._purgeTime += argPurgeData.getPurgeTime();
/*  60 */     this._recordsPurged += argPurgeData.getRecordsPurged();
/*  61 */     this._tablesPurged += argPurgeData.getTablesPurged();
/*  62 */     this._tablesTargeted += argPurgeData.getTablesTargeted();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getPurgeError() {
/*  70 */     return this._purgeError;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPurgeTime() {
/*  78 */     return this._purgeTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordsPurged() {
/*  86 */     return this._recordsPurged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTablesPurged() {
/*  94 */     return this._tablesPurged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTablesTargeted() {
/* 102 */     return this._tablesTargeted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPurgeError(Throwable argPurgeError) {
/* 110 */     this._purgeError = argPurgeError;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPurgeTime(long argPurgeTime) {
/* 118 */     this._purgeTime = argPurgeTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordsPurged(int argRecordsPurged) {
/* 126 */     this._recordsPurged = argRecordsPurged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTablesPurged(int argTablesPurged) {
/* 134 */     this._tablesPurged = argTablesPurged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTablesTargeted(int argTablesTargeted) {
/* 142 */     this._tablesTargeted = argTablesTargeted;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 148 */     return (new ToStringBuilder(this))
/* 149 */       .append("recordsPurged", getRecordsPurged())
/* 150 */       .append("tablesPurged", getTablesPurged())
/* 151 */       .append("tablesTargeted", getTablesTargeted())
/* 152 */       .append("purgeTime", getPurgeTime())
/* 153 */       .appendSuper(super.toString()).toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\PurgeMetaData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */