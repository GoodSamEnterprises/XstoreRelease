/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.DefaultQueryResult;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractRelatedItemTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  23 */   private static final Logger _logger = Logger.getLogger(AbstractRelatedItemTransformer.class);
/*     */   
/*  25 */   private static final IQueryKey<DefaultQueryResult> SELECT_RELATED_ITEM_HEAD = (IQueryKey<DefaultQueryResult>)new QueryKey("SELECT_RELATED_ITEM_HEAD", DefaultQueryResult.class);
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
/*     */   protected enum RelationshipType
/*     */   {
/*  39 */     CRSL(true, false), UPSL(true, false), SUBS(false, true);
/*     */ 
/*     */     
/*     */     private boolean _attachedItems = false;
/*     */ 
/*     */     
/*     */     private boolean _substituteItems = false;
/*     */ 
/*     */ 
/*     */     
/*     */     RelationshipType(boolean argAttachedItems, boolean argSubstituteItems) {
/*  50 */       this._attachedItems = argAttachedItems;
/*  51 */       this._substituteItems = argSubstituteItems;
/*     */     }
/*     */     
/*     */     public boolean isAttachedItems() {
/*  55 */       return this._attachedItems;
/*     */     }
/*     */     
/*     */     public boolean isSubstituteItems() {
/*  59 */       return this._substituteItems;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   private String _promptToAddMessageKey = null;
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
/*     */   public String getPromptToAddMessageKey() {
/*  83 */     return this._promptToAddMessageKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptToAddMessageKey(String argPromptToAddMessageKey) {
/*  91 */     this._promptToAddMessageKey = argPromptToAddMessageKey;
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
/*     */   protected RelatedItemHead lookupRelatedItemHead(String argRelationshipId, String argLocation, MOMFileLine argLine) {
/* 106 */     Map<String, Object> params = new HashMap<>(3);
/* 107 */     params.put("argRelationshipId", argRelationshipId);
/* 108 */     params.put("argLocation", argLocation);
/* 109 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*     */ 
/*     */ 
/*     */     
/* 113 */     IQueryResultList<DefaultQueryResult> results = DataFactory.getObjectByQueryNoThrow(SELECT_RELATED_ITEM_HEAD, params);
/*     */ 
/*     */     
/* 116 */     RelatedItemHead relatedItemHead = null;
/*     */     
/* 118 */     if (results.size() > 0) {
/*     */       
/* 120 */       DefaultQueryResult result = (DefaultQueryResult)results.get(0);
/*     */       
/* 122 */       relatedItemHead = new RelatedItemHead();
/* 123 */       relatedItemHead.setRelationshipId(argRelationshipId);
/* 124 */       relatedItemHead.setItem((String)result.get("item"));
/* 125 */       relatedItemHead.setRelationshipType((String)result.get("relationshipType"));
/* 126 */       relatedItemHead.setMandatoryInd((String)result.get("mandatoryInd"));
/*     */     } else {
/*     */       
/* 129 */       _logger.warn("Missing head record: " + argLine.getFileLine());
/*     */     } 
/*     */     
/* 132 */     return relatedItemHead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class RelatedItemDetail
/*     */   {
/*     */     private String _relationshipId;
/*     */ 
/*     */ 
/*     */     
/*     */     private String _relatedItem;
/*     */ 
/*     */     
/*     */     private String _priority;
/*     */ 
/*     */     
/*     */     private String _startDate;
/*     */ 
/*     */     
/*     */     private String _endDate;
/*     */ 
/*     */ 
/*     */     
/*     */     public RelatedItemDetail(String argRelationshipId, String argRelatedItem, String argPriority, String argStartDate, String argEndDate) {
/* 158 */       this._relationshipId = argRelationshipId;
/* 159 */       this._relatedItem = argRelatedItem;
/* 160 */       this._priority = argPriority;
/* 161 */       this._startDate = argStartDate;
/* 162 */       this._endDate = argEndDate;
/*     */     }
/*     */     
/*     */     public Date getEndDate() {
/* 166 */       return AbstractRelatedItemTransformer.this.parseRMSDate(this._endDate);
/*     */     }
/*     */     
/*     */     public Integer getPriority() {
/* 170 */       if (this._priority == null) {
/* 171 */         return null;
/*     */       }
/* 173 */       return Integer.valueOf(Integer.parseInt(this._priority));
/*     */     }
/*     */     
/*     */     public String getRelatedItem() {
/* 177 */       return this._relatedItem;
/*     */     }
/*     */     
/*     */     public String getRelationshipId() {
/* 181 */       return this._relationshipId;
/*     */     }
/*     */     
/*     */     public Date getStartDate() {
/* 185 */       return AbstractRelatedItemTransformer.this.parseRMSDate(this._startDate);
/*     */     }
/*     */     
/*     */     public void setEndDate(String argEndDate) {
/* 189 */       this._endDate = argEndDate;
/*     */     }
/*     */     
/*     */     public void setPriority(String argPriority) {
/* 193 */       this._priority = argPriority;
/*     */     }
/*     */     
/*     */     public void setRelatedItem(String argRelatedItem) {
/* 197 */       this._relatedItem = argRelatedItem;
/*     */     }
/*     */     
/*     */     public void setRelationshipId(String argRelationshipId) {
/* 201 */       this._relationshipId = argRelationshipId;
/*     */     }
/*     */     
/*     */     public void setStartDate(String argStartDate) {
/* 205 */       this._startDate = argStartDate;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class RelatedItemHead
/*     */   {
/*     */     private String _relationshipId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String _item;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String _location;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private AbstractRelatedItemTransformer.RelationshipType _relationshipType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String _mandatoryInd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getItem() {
/* 245 */       return this._item;
/*     */     }
/*     */     
/*     */     public String getLocation() {
/* 249 */       return this._location;
/*     */     }
/*     */     
/*     */     public String getMandatoryInd() {
/* 253 */       return this._mandatoryInd;
/*     */     }
/*     */     
/*     */     public String getRelationshipId() {
/* 257 */       return this._relationshipId;
/*     */     }
/*     */     
/*     */     public AbstractRelatedItemTransformer.RelationshipType getRelationshipType() {
/* 261 */       return this._relationshipType;
/*     */     }
/*     */     
/*     */     public Boolean isMandatory() {
/* 265 */       return Boolean.valueOf("Y".equals(getMandatoryInd()));
/*     */     }
/*     */     
/*     */     public void setItem(String argItem) {
/* 269 */       this._item = argItem;
/*     */     }
/*     */     
/*     */     public void setLocation(String argLocation) {
/* 273 */       this._location = argLocation;
/*     */     }
/*     */     
/*     */     public void setMandatoryInd(String argMandatoryInd) {
/* 277 */       this._mandatoryInd = argMandatoryInd;
/*     */     }
/*     */     
/*     */     public void setRelationshipId(String argRelationshipId) {
/* 281 */       this._relationshipId = argRelationshipId;
/*     */     }
/*     */     
/*     */     public void setRelationshipType(String argRelationshipType) {
/* 285 */       this._relationshipType = AbstractRelatedItemTransformer.RelationshipType.valueOf(argRelationshipType);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 291 */       return "RelatedItemHead [_relationshipId=" + this._relationshipId + ", _item=" + this._item + ", _location=" + this._location + ", _relationshipType=" + this._relationshipType + ", _mandatoryInd=" + this._mandatoryInd + "]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\AbstractRelatedItemTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */