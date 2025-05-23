package dtv.docbuilding;

import dtv.docbuilding.conditions.IDocBuilderCondition;
import dtv.util.config.IReflectionParameterCapable;
import java.util.Comparator;
import java.util.List;

public interface IDocBuilderIterator extends IDocBuilderIteratorMember {
  void addCondition(IDocBuilderCondition paramIDocBuilderCondition);
  
  void addMember(IDocBuilderIteratorMember paramIDocBuilderIteratorMember);
  
  void setConditions(List<IDocBuilderCondition> paramList);
  
  void setItemComparator(Comparator<? super Object> paramComparator);
  
  void setMembers(List<IDocBuilderIteratorMember> paramList);
  
  void setMethodName(String paramString);
  
  void setMethodParams(List<IReflectionParameterCapable<?>> paramList);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocBuilderIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */