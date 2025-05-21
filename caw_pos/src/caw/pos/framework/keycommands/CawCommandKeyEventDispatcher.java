
package caw.pos.framework.keycommands;

import java.awt.KeyEventDispatcher;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import dtv.hardware.keyboard.*;
import dtv.pos.framework.keycommands.*;

public class CawCommandKeyEventDispatcher implements KeyEventDispatcher, IKeyStreamHandler {

    protected static final Logger            logger_                  = Logger.getLogger(CawCommandKeyEventDispatcher.class);

    protected final Map<String, IKeyCommand> commandMap_              = new HashMap<String, IKeyCommand>();

    private final IKeySentinalPair sentinals                          = new KeyCommandSentinalPair(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK);
    
    private static final int CTRL_ALT_SHIFT_DOWN_MASK                 = InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK;
    
    private static final int STREAM_TIMEOUT                           = 10000;

    @Inject
    private IPosKeyEventDispatcher           _mainDispatcher;

    private CawCommandKeyEventDispatcher(List<IKeyCommand> argCommands) {

        try {
            if (argCommands != null && argCommands.size() > 0) {
                Iterator<IKeyCommand> var2 = argCommands.iterator();
                while (var2.hasNext()) {
                    IKeyCommand command = var2.next();
                    this.registerKeyCommand(command);
                }
            }
        } catch (Exception ex) {
            logger_.error("Method CawCommandKeyEventDispatcher is caught exception:", ex);
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        try {
            if (e.getKeyCode() == KeyEvent.VK_F4) {
                int modifiers = e.getModifiersEx();
                if ((modifiers & CTRL_ALT_SHIFT_DOWN_MASK) == InputEvent.ALT_DOWN_MASK) {
                    e.consume();
                    return true;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                e.consume();
                return true;
            }
        } catch (Exception ex) {
            logger_.error("Method dispatchKeyEvent is caught exception:", ex);
        }

        return false;
    }

    @Override
    public IKeySentinalPair getSentinals() {

        return this.sentinals;
    }

    @Override
    public int getStreamTimeout() {

        return STREAM_TIMEOUT;
    }

    @Override
    public void handleKeys(KeyEvent[] argKeys) {

        StringBuffer sb = new StringBuffer();
        KeyEvent[] keyEventArr = argKeys;
        int keyEventLength = argKeys.length;
        for (int i = 0; i < keyEventLength; ++i) {
            KeyEvent argKey = keyEventArr[i];
            char c = argKey.getKeyChar();
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        String commandKey = sb.toString().trim().toLowerCase();
        IKeyCommand command = this.commandMap_.get(commandKey);

        if (command != null) {
            if (logger_.isDebugEnabled()) {
                logger_.debug("*************handling command '" + commandKey  + "'");
            }

            try {
                command.execute();
            } catch (Exception exception) {
                logger_.error("CAUGHT EXCEPTION", exception);
            }
        } else {
            logger_.warn("***********ignoring command '" + commandKey + "'");
        }
    }

    public void init() {

        this._mainDispatcher.addKeyEventDispatcher(this);
        this._mainDispatcher.addKeyStreamHandler(this);
    }

    private void registerKeyCommand(IKeyCommand command) {

        this.commandMap_.put(command.getCommand().toLowerCase(), command);
    }
}
