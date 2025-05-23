/*     */ package dtv.data2;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.CompositeObject;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
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
/*     */ public class SystemPropertyPersistenceDefaults
/*     */   implements IPersistenceDefaults
/*     */ {
/*  24 */   private static final Logger logger_ = Logger.getLogger(SystemPropertyPersistenceDefaults.class);
/*     */   
/*     */   private Long orgId_;
/*     */   
/*     */   private Integer retailLocationId_;
/*     */   
/*     */   private Long workstationId_;
/*     */   
/*     */   private String _currencyId;
/*     */   
/*     */   private static final String SYS_PROP_ORG_ID = "dtv.xst.orgid";
/*     */   
/*     */   private static final String SYS_PROP_RTL_LOC_ID = "dtv.xst.rtllocid";
/*     */   
/*     */   private static final String SYS_PROP_WKSTN_ID = "dtv.xst.wkstnid";
/*     */   
/*     */   private static final String SYS_PROP_CURRENCY_ID = "dtv.xst.currencyid";
/*     */   
/*     */   private static final String DEFAULT_ORG_ID = "-1";
/*     */   
/*     */   private static final String DEFAULT_RTL_LOC_ID = "-1";
/*     */   private static final String DEFAULT_WKSTN_ID = "-1";
/*     */   private static final String DEFAULT_CURRENCY_ID = "USD";
/*     */   
/*     */   public String getCurrencyId() {
/*  49 */     if (this._currencyId != null) {
/*  50 */       return this._currencyId;
/*     */     }
/*     */     
/*  53 */     String prop = System.getProperty("dtv.xst.currencyid", "USD");
/*     */     
/*     */     try {
/*  56 */       this._currencyId = prop;
/*     */     }
/*  58 */     catch (Exception ex) {
/*  59 */       logger_.warn("Bad value: " + prop + " for property " + "dtv.xst.currencyid", ex);
/*  60 */       this._currencyId = "USD";
/*     */     } 
/*     */     
/*  63 */     return this._currencyId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  69 */     if (this.orgId_ != null) {
/*  70 */       return this.orgId_;
/*     */     }
/*     */     
/*  73 */     String prop = System.getProperty("dtv.xst.orgid", "-1");
/*     */     
/*     */     try {
/*  76 */       this.orgId_ = Long.valueOf(prop);
/*     */     }
/*  78 */     catch (Exception ee) {
/*  79 */       throw new DtxException("Could not parse required system property: dtv.xst.orgid VALUE GIVEN: " + prop + " -- the dtx framework cannot determine org id without this property when configured to use SystemPropertyPersistenceDefaults", ee);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     return this.orgId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CompositeObject.TwoPiece<String, String>> getOrgHierarchyAncestry() {
/*  91 */     return Arrays.asList((CompositeObject.TwoPiece<String, String>[])new CompositeObject.TwoPiece[] { CompositeObject.make("*", "*") });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getRetailLocationId() {
/*  97 */     if (this.retailLocationId_ != null) {
/*  98 */       return this.retailLocationId_;
/*     */     }
/*     */     
/* 101 */     String prop = System.getProperty("dtv.xst.rtllocid", "-1");
/*     */     
/*     */     try {
/* 104 */       this.retailLocationId_ = Integer.valueOf(prop);
/*     */     }
/* 106 */     catch (Exception ee) {
/* 107 */       logger_.warn("Bad value: " + prop + " for propery " + "dtv.xst.rtllocid", ee);
/* 108 */       this.retailLocationId_ = Integer.valueOf("-1");
/*     */     } 
/*     */     
/* 111 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUserId() {
/* 117 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/* 123 */     if (this.workstationId_ != null) {
/* 124 */       return this.workstationId_;
/*     */     }
/*     */     
/* 127 */     String prop = System.getProperty("dtv.xst.wkstnid", "-1");
/*     */     
/*     */     try {
/* 130 */       this.workstationId_ = Long.valueOf(prop);
/*     */     }
/* 132 */     catch (Exception ee) {
/* 133 */       logger_.warn("Bad value: " + prop + " for propery " + "dtv.xst.wkstnid", ee);
/* 134 */       this.workstationId_ = Long.valueOf("-1");
/*     */     } 
/*     */     
/* 137 */     return this.workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraining() {
/* 143 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\SystemPropertyPersistenceDefaults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */