/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringStyle;
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
/*     */ public class ListViewRequest
/*     */ {
/*     */   private final RequestType requestType_;
/*     */   private final Class<?> objectType_;
/*     */   private final List<?> objects_;
/*     */   
/*     */   public ListViewRequest(Class<?> argObjectType, RequestType argRequestType, Collection<?> argElements) {
/*  29 */     this.objectType_ = argObjectType;
/*  30 */     if (this.objectType_ == null) {
/*  31 */       throw new IllegalArgumentException("Object type cannot be null");
/*     */     }
/*     */     
/*  34 */     this.requestType_ = argRequestType;
/*  35 */     if (this.requestType_ == null) {
/*  36 */       throw new IllegalArgumentException("Request type cannot be null");
/*     */     }
/*     */     
/*  39 */     if (this.requestType_.isRequiresObjects()) {
/*     */       
/*  41 */       if (argElements == null) {
/*  42 */         throw new IllegalArgumentException("Elements cannot be null");
/*     */       }
/*  44 */       if (argElements.isEmpty()) {
/*  45 */         this.objects_ = Collections.emptyList();
/*     */       } else {
/*     */         
/*  48 */         this.objects_ = Collections.unmodifiableList(new ArrayList(argElements));
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  53 */       this.objects_ = Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*     */     boolean result;
/*  61 */     if (this == argOther) {
/*  62 */       result = true;
/*     */     }
/*  64 */     else if (argOther == null || getClass() != argOther.getClass()) {
/*  65 */       result = false;
/*     */     } else {
/*     */       
/*  68 */       EqualsBuilder eq = new EqualsBuilder();
/*  69 */       ListViewRequest other = (ListViewRequest)argOther;
/*  70 */       eq.append(getRequestType(), other.getRequestType());
/*  71 */       eq.append(getObjectType(), other.getObjectType());
/*  72 */       eq.append(getObjects(), other.getObjects());
/*  73 */       result = eq.isEquals();
/*     */     } 
/*  75 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<?> getObjects() {
/*  80 */     return this.objects_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getObjectType() {
/*  85 */     return this.objectType_;
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestType getRequestType() {
/*  90 */     return this.requestType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     HashCodeBuilder hash = new HashCodeBuilder(587, 3001);
/*  97 */     hash.append(getObjectType());
/*  98 */     hash.append(getRequestType());
/*  99 */     hash.append(getObjects());
/* 100 */     return hash.toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 106 */     ToStringBuilder str = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/* 107 */     str.append("RequestType", getRequestType());
/* 108 */     str.append("ObjectType", getObjectType());
/* 109 */     str.append("Objects", getObjects());
/* 110 */     return str.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum RequestType
/*     */   {
/* 117 */     ADD(true),
/*     */ 
/*     */     
/* 120 */     CLEAR(false),
/*     */ 
/*     */     
/* 123 */     REPLACE(true),
/*     */ 
/*     */     
/* 126 */     UPDATE(true);
/*     */     
/*     */     private final boolean requiresObjects_;
/*     */ 
/*     */     
/*     */     RequestType(boolean argRequiresObjects) {
/* 132 */       this.requiresObjects_ = argRequiresObjects;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isRequiresObjects() {
/* 137 */       return this.requiresObjects_;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\ListViewRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */