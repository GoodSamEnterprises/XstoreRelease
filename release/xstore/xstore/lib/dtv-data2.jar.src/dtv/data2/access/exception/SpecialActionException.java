/*     */ package dtv.data2.access.exception;
/*     */ 
/*     */ import dtv.data2.SQLExceptionScrubber;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import java.sql.SQLException;
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
/*     */ public abstract class SpecialActionException
/*     */   extends RuntimeException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String associatedDataSource_;
/*     */   
/*     */   public static String getFullExceptionString(Throwable argThrowable) {
/*  33 */     StringBuilder buff = new StringBuilder(128);
/*  34 */     Throwable cause = argThrowable;
/*     */     
/*  36 */     while (cause != null) {
/*  37 */       if (cause instanceof SQLException) {
/*  38 */         cause = SQLExceptionScrubber.scrub((SQLException)cause);
/*     */       }
/*     */       
/*  41 */       buff.append(cause.toString());
/*     */       
/*  43 */       if (cause instanceof SQLException) {
/*  44 */         SQLException nextException = ((SQLException)cause).getNextException();
/*  45 */         while (nextException != null) {
/*  46 */           buff.append(" Next SQL Exception --> ");
/*  47 */           buff.append(nextException.toString());
/*  48 */           nextException = nextException.getNextException();
/*     */         } 
/*     */       } 
/*     */       
/*  52 */       cause = cause.getCause();
/*  53 */       if (cause != null) {
/*  54 */         buff.append(" Caused by --> ");
/*     */       }
/*     */     } 
/*  57 */     return buff.toString().trim();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SpecialActionException() {
/*  63 */     this.associatedDataSource_ = null;
/*     */   }
/*     */   
/*     */   protected SpecialActionException(String argMessage, String argDataSource) {
/*  67 */     super(argMessage);
/*     */ 
/*     */     
/*  70 */     DataSourceFactory.getInstance().getDataSourceDescriptor(argDataSource);
/*  71 */     this.associatedDataSource_ = argDataSource;
/*     */   }
/*     */   
/*     */   protected SpecialActionException(String argMessage, Throwable argCause, String argDataSource) {
/*  75 */     super(argMessage, argCause);
/*     */ 
/*     */     
/*  78 */     DataSourceFactory.getDataSourceDescriptor(argDataSource, argCause);
/*  79 */     this.associatedDataSource_ = argDataSource;
/*     */   }
/*     */   
/*     */   protected SpecialActionException(Throwable argCause, String argDataSource) {
/*  83 */     super(argCause);
/*     */ 
/*     */     
/*  86 */     DataSourceFactory.getDataSourceDescriptor(argDataSource, argCause);
/*  87 */     this.associatedDataSource_ = argDataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceName() {
/*  96 */     return this.associatedDataSource_;
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
/*     */   public boolean isApplicable(Throwable argException) {
/* 108 */     if (argException == null) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (argException.getClass().getName().equals(getClass().getName())) {
/* 113 */       return true;
/*     */     }
/*     */     
/* 116 */     ExceptionApplicableRule[] rules = getApplicableRules();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     String fullExceptionMessage = getFullExceptionString(argException);
/*     */     
/* 124 */     for (ExceptionApplicableRule rule : rules) {
/* 125 */       if (!rule.isExceptionClassPertinent() || 
/* 126 */         rule.getExceptionClass().getName().equals(argException.getClass().getName()))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 131 */         if (rule.getMessage() == null || fullExceptionMessage
/* 132 */           .toLowerCase().indexOf(rule.getMessage()) != -1)
/*     */         {
/*     */ 
/*     */           
/* 136 */           return rule.getMatchFoundResult(); }  } 
/*     */     } 
/* 138 */     return false;
/*     */   }
/*     */   
/*     */   abstract ExceptionApplicableRule[] getApplicableRules();
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\SpecialActionException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */