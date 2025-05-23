package dtv.logbuilder.writers;

import dtv.util.TypeSafeMapKey;
import java.util.Map;

public class NullFileWriter implements ILogEntryWriter {
  public void close() {}
  
  public void initialize(Map<TypeSafeMapKey<?>, Object> argSettings) {}
  
  public void write(String argString) {}
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\writers\NullFileWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */