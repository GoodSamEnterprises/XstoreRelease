/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ36993          280720    New Requirement-Property Lines for Age Verification From POS
 *===================================================================
 */

package caw.pos.register;

import java.math.BigDecimal;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import dtv.i18n.IFormattable;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.register.MinimumAgeValidationOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CawMinimumAgeValidationOp extends MinimumAgeValidationOp{
    
    private static final Logger logger_ = LogManager.getLogger(CawMinimumAgeValidationOp.class);
    
    //Begin BZ36993
    protected Integer getPurchaserAge(Date custBirthDate) {
        
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(custBirthDate.getTime());
        
        int dd = birthDay.get(Calendar.DATE);
        int mm = birthDay.get(Calendar.MONTH) + 1;
        int yyyy = birthDay.get(Calendar.YEAR);
                
        LocalDate currDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(yyyy, mm, dd); 
        
        return Period.between(birthDate, currDate).getYears();
    }
    //End BZ36993
    
    @Override
    protected IOpResponse handleBirthDate(IXstEvent argEvent, Date custBirthDate) {
        ISaleReturnLineItem saleLine = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        IItem item = this.getScopedValue(ValueKeys.CURRENT_ITEM);
        saleLine.setStringProperty("ENTRY_METHOD", this.getBirthDateEntryMethod(argEvent));
        Date validMinDate = this.getMinValidBirthDate(item.getOptions().getMinAgeRequired());
        if (custBirthDate != null) {
            if (validMinDate.before(custBirthDate)) {
                this.setOpState(this.MIN_AGE_NOT_MET_PROMPT);
                return this.HELPER.getPromptResponse(PromptKey.valueOf("ITEM_MIN_AGE_NOT_MET"),
                        this.getPromptArgs(argEvent));
            } else {
                IPosTransaction trans = this.createTransactionIfNotExists();
                trans.setCustBirthDate(custBirthDate);
                //Begin BZ36993
                saleLine.setDecimalProperty("AGE", BigDecimal.valueOf(getPurchaserAge(custBirthDate)));
                saleLine.setDecimalProperty("MINIMUM_AGE_REQUIRED", BigDecimal.valueOf(item.getOptions().getMinAgeRequired()));
                //End BZ36993
                saleLine.setBooleanProperty("MIN_AGE_MET", true);
                return this.HELPER.completeResponse();
            }
        } else {
            this.setOpState((IOpState) null);
            return this.HELPER.getPromptResponse(PromptKey.valueOf("INVALID_DATE"), new IFormattable[0]);
        }
    }
    
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {
        ISaleReturnLineItem line = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        IItem item = this.getScopedValue(ValueKeys.CURRENT_ITEM);
        line.setStringProperty("ENTRY_METHOD", this.getBirthDateEntryMethod(argAction));
        if (XstDataActionKey.YES.equals(argAction.getActionKey())) {
            IPosTransaction trans = this.createTransactionIfNotExists();
            trans.setCustBirthDate(this.getMinValidBirthDate(item.getOptions().getMinAgeRequired()));
            //Begin BZ36993
            line.setDecimalProperty("AGE", BigDecimal.valueOf(item.getOptions().getMinAgeRequired()));
            line.setDecimalProperty("MINIMUM_AGE_REQUIRED", BigDecimal.valueOf(item.getOptions().getMinAgeRequired()));
            //End BZ36993
            line.setBooleanProperty("MIN_AGE_MET", true);
            return this.HELPER.completeResponse();
        } else {
            return !XstDataActionKey.NO.equals(argAction.getActionKey())
                    && !XstDataActionKey.ACCEPT.equals(argAction.getActionKey())
                            ? super.handleDataAction(argAction)
                            : this.HELPER.silentErrorResponse();
        }
    }
      
    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {
        IPosTransaction tran = this._transactionScope.getTransaction();
        if (tran != null && tran.getCustBirthDate() != null) {
            Date custBirthDate = tran.getCustBirthDate();
            if (ConfigurationMgr.getPromptForBirthDate()) {
                return this.handleBirthDate(argEvent, custBirthDate);
            }

            IItem item = this.getScopedValue(ValueKeys.CURRENT_ITEM);
            Date validMinDate = this.getMinValidBirthDate(item.getOptions().getMinAgeRequired());
            if (!validMinDate.before(custBirthDate)) {
                ISaleReturnLineItem saleLine = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
                saleLine.setStringProperty("ENTRY_METHOD", this.getBirthDateEntryMethod(argEvent));
                //Begin BZ36993
                saleLine.setDecimalProperty("AGE", BigDecimal.valueOf(getPurchaserAge(custBirthDate)));
                saleLine.setDecimalProperty("MINIMUM_AGE_REQUIRED", BigDecimal.valueOf(item.getOptions().getMinAgeRequired()));
                //End BZ36993
                saleLine.setBooleanProperty("MIN_AGE_MET", true);
                return this.HELPER.completeResponse();
            }
        }

        if (ConfigurationMgr.getPromptForBirthDate()) {
            this.setOpState(this.POST_BIRTH_DATE);
        } else {
            this.setOpState(this.POST_PROMPT);
        }

        if (logger_.isDebugEnabled()) {
            logger_.debug("Returning prompt response for the key " + this.getDefaultPromptKey());
        }

        if (logger_.isInfoEnabled()) {
            logger_.info("Exit method - handleOpExec(argCmd, argEvent)");
        }

        return this.HELPER.getPromptResponse(this.getDefaultPromptKey(), this.getPromptArgs(argEvent));
    }

}
