/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.StringObjectPair;
/*     */ import dtv.util.KeyValuePair;
/*     */ import dtv.util.config.AbstractSetConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.Collection;
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
/*     */ public class ComponentPropertySetConfig
/*     */   extends AbstractSetConfig<ComponentPropertyConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "ComponentPropertySet";
/*     */   private String name_;
/*     */   private String ref_;
/*     */   private ComponentID componentId_;
/*     */   private ComponentPropertySet componentPropertySet_;
/*     */   
/*     */   public void cascadeValues(IConfigObject argSourceConfig) {
/*  33 */     super.cascadeValues(argSourceConfig);
/*     */     
/*  35 */     ComponentPropertySetConfig sourceConfig = (ComponentPropertySetConfig)argSourceConfig;
/*     */     
/*  37 */     if (getName() == null) {
/*  38 */       setName(sourceConfig.getName());
/*     */     }
/*  40 */     if (getComponentID() == null) {
/*  41 */       setComponentID(sourceConfig.getComponentID());
/*     */     }
/*  43 */     setPropertySet(sourceConfig.getPropertySet());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getChildTag() {
/*  49 */     return "ComponentProperty";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentID getComponentID() {
/*  57 */     return this.componentId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  65 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentPropertySet getPropertySet() {
/*  73 */     if (this.componentPropertySet_ == null) {
/*  74 */       this.componentPropertySet_ = new ComponentPropertySet();
/*  75 */       this.componentPropertySet_.setName(getName());
/*     */     } 
/*     */     
/*  78 */     Collection<ComponentPropertyConfig> children = getChildren();
/*     */     
/*  80 */     for (ComponentPropertyConfig config : children) {
/*  81 */       this.componentPropertySet_.put(new StringObjectPair((KeyValuePair)config.getPropertyValue()));
/*     */     }
/*     */     
/*  84 */     return this.componentPropertySet_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReference() {
/*  92 */     return this.ref_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComponentID(ComponentID argComponentID) {
/* 100 */     this.componentId_ = argComponentID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 106 */     if (argKey.equalsIgnoreCase("name")) {
/* 107 */       this.name_ = argValue.toString();
/*     */     }
/* 109 */     else if (argKey.equalsIgnoreCase("ref")) {
/* 110 */       this.ref_ = argValue.toString();
/*     */     }
/* 112 */     else if (argKey.equalsIgnoreCase("ComponentID")) {
/* 113 */       this.componentId_ = new ComponentID(argValue.toString());
/*     */     } else {
/*     */       
/* 116 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 125 */     this.name_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertySet(ComponentPropertySet argSet) {
/* 133 */     getPropertySet();
/* 134 */     this.componentPropertySet_.putAll(argSet.getAll());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReference(String argRef) {
/* 142 */     this.ref_ = argRef;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ComponentPropertySetConfig clone() throws CloneNotSupportedException {
/* 149 */     ComponentPropertySetConfig clone = new ComponentPropertySetConfig();
/*     */     
/* 151 */     clone.setComponentID(getComponentID());
/* 152 */     clone.setName(getName());
/* 153 */     clone.setReference(getReference());
/* 154 */     clone.setPropertySet(getPropertySet());
/*     */     
/* 156 */     return clone;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentPropertySetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */