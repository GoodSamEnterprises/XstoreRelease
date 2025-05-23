/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringStyle;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SecondDisplayMode
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -914087198160304287L;
/*  29 */   private static final Logger _logger = Logger.getLogger(SecondDisplayMode.class);
/*  30 */   private static final Map<String, SecondDisplayMode> _instances = new HashMap<>(8);
/*     */   
/*  32 */   private static final Map<String, Component> _sharedComponents = new HashMap<>();
/*     */ 
/*     */   
/*  35 */   public static final SecondDisplayMode TRAINING = new SecondDisplayMode("TRAINING", "CUST_TRAINING_VIEW", false, true, true);
/*     */ 
/*     */ 
/*     */   
/*  39 */   public static final SecondDisplayMode REGISTER = new SecondDisplayMode("REGISTER", "CUST_TRANS_VIEW", true, false, true);
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static final SecondDisplayMode REGISTER_DISABLED = new SecondDisplayMode("REGISTER_DISABLED", "CUST_TRANS_VIEW", true, false, false);
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static final SecondDisplayMode OTHER = new SecondDisplayMode("OTHER", "CUST_OTHER_VIEW", false, false, true); private final boolean register_;
/*     */   private final boolean training_;
/*     */   private final boolean enabled_;
/*     */   
/*     */   public static Set<String> getComponentNames() {
/*  52 */     Set<String> names = new HashSet<>(8);
/*  53 */     for (SecondDisplayMode mode : values()) {
/*  54 */       names.add(mode.getComponentName());
/*     */     }
/*  56 */     return names;
/*     */   }
/*     */   private final String componentName_; private final String id_; private transient String toString_; private transient Integer hashCode_;
/*     */   public static Component getSharedComponent(String argComponentName) {
/*  60 */     return _sharedComponents.get(argComponentName);
/*     */   }
/*     */   
/*     */   public static void registerSharedComponent(Component argComponent) {
/*  64 */     _sharedComponents.put(argComponent.getName(), argComponent);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SecondDisplayMode valueOf(String argId) {
/*  69 */     String id = normalize(argId);
/*  70 */     SecondDisplayMode value = _instances.get(id);
/*  71 */     if (value == null) {
/*  72 */       _logger.warn("Unknown instance [" + id + "]", new Throwable("STACK TRACE"));
/*     */     }
/*  74 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Collection<SecondDisplayMode> values() {
/*  79 */     return Collections.unmodifiableCollection(_instances.values());
/*     */   }
/*     */ 
/*     */   
/*     */   protected static String normalize(String argValue) {
/*  84 */     return StringUtils.nonNull(argValue).trim().toUpperCase();
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
/*     */   public SecondDisplayMode(String argId, String argComponentName, boolean argRegister, boolean argTraining, boolean argEnabled) {
/* 106 */     this.id_ = normalize(argId);
/* 107 */     this.register_ = argRegister;
/* 108 */     this.training_ = argTraining;
/* 109 */     this.enabled_ = argEnabled;
/* 110 */     this.componentName_ = argComponentName;
/* 111 */     _instances.put(this.id_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doTransition() {
/* 116 */     Component component = getSharedComponent(getComponentName());
/* 117 */     if (component != null) {
/* 118 */       UIServices.showComponentAndParents(component, true);
/* 119 */       if (component instanceof Container) {
/* 120 */         UIServices.setChildrenEnabled((Container)component, isEnabled());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*     */     boolean result;
/* 129 */     if (this == argOther) {
/* 130 */       result = true;
/*     */     }
/* 132 */     else if (!(argOther instanceof SecondDisplayMode)) {
/* 133 */       result = false;
/*     */     } else {
/*     */       
/* 136 */       result = this.id_.equals(((SecondDisplayMode)argOther).id_);
/*     */     } 
/* 138 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getComponentName() {
/* 143 */     return this.componentName_;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getId() {
/* 148 */     return this.id_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 154 */     if (this.hashCode_ == null) {
/* 155 */       HashCodeBuilder hash = new HashCodeBuilder(1073676287, 3539);
/* 156 */       hash.append(this.id_);
/* 157 */       this.hashCode_ = Integer.valueOf(hash.toHashCode());
/*     */     } 
/* 159 */     return this.hashCode_.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 164 */     return this.enabled_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRegister() {
/* 169 */     return this.register_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTraining() {
/* 174 */     return this.training_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matches(String argValue) {
/* 179 */     return this.id_.equals(normalize(argValue));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     if (this.toString_ == null) {
/* 186 */       ToStringBuilder str = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/* 187 */       str.append(this.id_);
/* 188 */       this.toString_ = str.toString();
/*     */     } 
/* 190 */     return this.toString_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Object readResolve() {
/* 195 */     SecondDisplayMode result = _instances.get(this.id_);
/* 196 */     if (result == null) {
/* 197 */       _instances.put(this.id_, result = this);
/*     */     }
/* 199 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\SecondDisplayMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */