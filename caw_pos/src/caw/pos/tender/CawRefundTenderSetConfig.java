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
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 *===================================================================
 */

package caw.pos.tender;

import java.util.*;

import org.apache.log4j.Logger;

import dtv.util.StringUtils;
import dtv.util.config.AbstractParentConfig;
import dtv.util.config.IConfigObject;

/**
 *
 */
public class CawRefundTenderSetConfig extends AbstractParentConfig {

    /**
     * 
     */
    private static final long                        serialVersionUID       = 3016284035940763411L;

    private static final Logger                      _logger                = Logger
            .getLogger(CawRefundTenderSetConfig.class);

    private final Map<String, CawRefundTenderConfig> _refundTenderConfigMap = new HashMap<String, CawRefundTenderConfig>();

    private List<CawRefundTenderConfig>              _referencingConfigs    = new ArrayList<CawRefundTenderConfig>();

    /* (non-Javadoc)
     * @see dtv.util.config.IConfigObject#setConfigObject(java.lang.String, dtv.util.config.IConfigObject)
     */
    @Override
    public void setConfigObject(String argVar1, IConfigObject argVar2) {

        if ((argVar2 instanceof CawRefundTenderConfig)) {
            CawRefundTenderConfig config = (CawRefundTenderConfig) argVar2;

            if (!StringUtils.isEmpty(config.getRefundTenderId())) {
                CawRefundTenderConfig replaced = _refundTenderConfigMap
                        .put(config.getRefundTenderId().toUpperCase(), config);

                if (replaced != null) {
                    config.cascadeValues(replaced);
                }
            }

            if (!StringUtils.isEmpty(config.getReference())) {
                _referencingConfigs.add(config);
            }
        }
    }

    /**
     * 
     */
    public void initialize() {

        if (_referencingConfigs != null) {
            for (CawRefundTenderConfig referencingConfig : _referencingConfigs) {
                resolveReferences(referencingConfig);
            }

            _referencingConfigs = null;
        }
    }

    /**
     * @return 
     */
    public List<CawRefundTenderConfig> getAllConfigs() {

        return new ArrayList<CawRefundTenderConfig>(
                _refundTenderConfigMap.values());
    }

    /**
     * @return .
     */
    public CawRefundTenderConfig getConfig(String argRestName) {

        return _refundTenderConfigMap.get(argRestName.toUpperCase());
    }

    /**
     * @param argConfig
     */
    private void resolveReferences(CawRefundTenderConfig argConfig) {

        CawRefundTenderConfig currentConfig = argConfig;
        CawRefundTenderConfig tempConfig, source, target;

        Stack<CawRefundTenderConfig> referencedCfgs = new Stack<CawRefundTenderConfig>();

        do {
            referencedCfgs.push(currentConfig);
            tempConfig = currentConfig;
            currentConfig = getReferencedConfig(tempConfig);
            tempConfig.setReference(null);
        } while (currentConfig != null);

        boolean isEmpty = referencedCfgs.empty();

        while (!isEmpty) {
            source = referencedCfgs.pop();
            isEmpty = referencedCfgs.empty();

            if (!isEmpty) {
                target = referencedCfgs.peek();
                target.cascadeValues(source);
            }

            isEmpty = referencedCfgs.empty();
        }
    }

    /**
     * @param argConfig
     * @return
     */
    private CawRefundTenderConfig getReferencedConfig(
            CawRefundTenderConfig argConfig) {

        CawRefundTenderConfig referencedCfg = null;
        String reference = argConfig.getReference();

        if (!StringUtils.isEmpty(reference)) {
            referencedCfg = _refundTenderConfigMap.get(reference);
            if (referencedCfg == null) {
                _logger.error("No action sequence [" + reference
                        + "]!  Referring sequence ["
                        + argConfig.getRefundTenderId()
                        + "] is likely useless! @@ "
                        + argConfig.getSourceDescription());
            }
        }
        return referencedCfg;
    }
}
