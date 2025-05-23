/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.xst.daocommon.IHierarchyItem;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ public class HierarchyItem
/*     */   implements IHierarchyItem
/*     */ {
/*     */   private final String _levelCode;
/*     */   private final String _levelValue;
/*     */   private long _organizationId;
/*     */   
/*     */   public static IHierarchyItem makeNode(long argOrgId, String argLevelCode, String argLevelValue) {
/*  30 */     return new HierarchyItem(argOrgId, argLevelCode, argLevelValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IHierarchyItem makeNode(String argLevelCode, String argLevelValue) {
/*  41 */     return new HierarchyItem(argLevelCode, argLevelValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IHierarchyItem makeStoreNode(int argRetailLocId) {
/*  51 */     return new HierarchyItem("STORE", String.valueOf(argRetailLocId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IHierarchyItem makeStoreNode(long argOrgId, int argRetailLocId) {
/*  62 */     return new HierarchyItem(argOrgId, "STORE", String.valueOf(argRetailLocId));
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
/*     */   public HierarchyItem(long argOrgId, String argLevelCode, String argLevelValue) {
/*  78 */     this._organizationId = argOrgId;
/*  79 */     this._levelCode = argLevelCode;
/*  80 */     this._levelValue = argLevelValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HierarchyItem(String argLevelCode, String argLevelValue) {
/*  90 */     this(ConfigurationMgr.getOrganizationId(), argLevelCode, argLevelValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  96 */     if (argObj == null) {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (!(argObj instanceof IHierarchyItem)) {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     IHierarchyItem other = (IHierarchyItem)argObj;
/* 105 */     return (new EqualsBuilder()).append(getLevelCode(), other.getLevelCode())
/* 106 */       .append(getLevelValue(), other.getLevelValue())
/* 107 */       .append(getOrganizationId(), other.getOrganizationId()).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/* 113 */     return this._levelCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelValue() {
/* 119 */     return this._levelValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 124 */     return this._organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 130 */     return (new HashCodeBuilder()).append(getLevelCode()).append(getLevelValue()).toHashCode();
/*     */   }
/*     */   
/*     */   public void setOrganizationId(long argOrgId) {
/* 134 */     this._organizationId = argOrgId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 140 */     return (new ToStringBuilder(this)).append("levelCode", getLevelCode())
/* 141 */       .append("levelValue", getLevelValue()).toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\HierarchyItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */