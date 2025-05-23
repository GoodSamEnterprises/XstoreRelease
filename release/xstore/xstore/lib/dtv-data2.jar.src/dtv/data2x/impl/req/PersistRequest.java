/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2x.req.IPersistRequest;
/*    */ import dtv.servicex.impl.req.ServiceRequest;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*    */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PersistRequest<M extends IPersistable>
/*    */   extends ServiceRequest
/*    */   implements IPersistRequest<M>
/*    */ {
/*    */   private final Collection<M> _objectsToPersist;
/*    */   
/*    */   public PersistRequest(Collection<? extends M> argModelsToPersist) {
/* 34 */     Collection<M> _noObjectsToPersist = Collections.emptyList();
/* 35 */     this._objectsToPersist = (argModelsToPersist == null) ? _noObjectsToPersist : new ArrayList<>(argModelsToPersist);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 42 */     if (argObj == this) {
/* 43 */       return true;
/*    */     }
/* 45 */     if (!(argObj instanceof PersistRequest)) {
/* 46 */       return false;
/*    */     }
/* 48 */     PersistRequest<?> other = (PersistRequest)argObj;
/* 49 */     return (new EqualsBuilder()).append(this._objectsToPersist, other._objectsToPersist)
/* 50 */       .appendSuper(super.equals(argObj)).isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<? extends M> getModelsToPersist() {
/* 56 */     return this._objectsToPersist;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 62 */     return (new HashCodeBuilder(17, 37)).append(this._objectsToPersist).appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     return (new ToStringBuilder(this)).append("modelsToPersist", this._objectsToPersist)
/* 69 */       .appendSuper(super.toString()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\PersistRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */