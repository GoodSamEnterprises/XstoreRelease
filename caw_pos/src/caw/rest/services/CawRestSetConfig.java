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
 * Req/Bug ID#          ddMMyy    Description
 * INT-92               260817    Customer Integration
 * BZ24094              261017    [Technical issue] - Method Invocation in Loop Condition
 *== ================================================================
 */

package caw.rest.services;

import java.util.*;

import org.apache.log4j.Logger;

import dtv.util.StringUtils;
import dtv.util.config.AbstractParentConfig;
import dtv.util.config.IConfigObject;

/**
 *
 */
public class CawRestSetConfig extends AbstractParentConfig {

    private static final long                serialVersionUID    = 1L;

    private static final Logger              _logger             = Logger
            .getLogger(CawRestSetConfig.class);

    private final Map<String, CawRestConfig> _restConfigMap      = new HashMap<String, CawRestConfig>();

    private List<CawRestConfig>              _referencingConfigs = new ArrayList<CawRestConfig>();

    /**
     * @return Detail for the all REST request.
     */
    public List<CawRestConfig> getAllRestConfigs() {

        return new ArrayList<CawRestConfig>(_restConfigMap.values());
    }

    /**
     * @return Detail for the the rest request.
     */
    public CawRestConfig getRestConfig(String argRestName) {

        return _restConfigMap.get(argRestName.toUpperCase());
    }

    /**
     * Assign all information to the rest configuration from the rest it
     * reference
     */
    public void initialize() {

        if (_referencingConfigs != null) {
            for (CawRestConfig referencingConfig : _referencingConfigs) {
                resolveReferences(referencingConfig);
            }

            _referencingConfigs = null;
        }
    }

    /**
     * Create and add the Rest configuration to the map.
     */
    @Override
    public void setConfigObject(String argKey, IConfigObject argValue) {

        if ((argValue instanceof CawRestConfig)) {
            CawRestConfig seqConfig = (CawRestConfig) argValue;

            if (!StringUtils.isEmpty(seqConfig.getRestName())) {
                CawRestConfig replaced = _restConfigMap
                        .put(seqConfig.getRestName().toUpperCase(), seqConfig);

                if (replaced != null) {
                    seqConfig.cascadeValues(replaced);
                }
            }

            if (!StringUtils.isEmpty(seqConfig.getReference())) {
                _referencingConfigs.add(seqConfig);
            }
        }
    }

    /**
     * @param argConfig
     * @return
     */
    private CawRestConfig getReferencedConfig(CawRestConfig argConfig) {

        CawRestConfig referencedCfg = null;
        String reference = argConfig.getReference();

        if (!StringUtils.isEmpty(reference)) {
            referencedCfg = _restConfigMap.get(reference);
            if (referencedCfg == null) {
                _logger.error("No action sequence [" + reference
                        + "]!  Referring sequence [" + argConfig.getRestName()
                        + "] is likely useless! @@ "
                        + argConfig.getSourceDescription());
            }
        }
        return referencedCfg;
    }

    /**
     * @param argConfig
     */
    private void resolveReferences(CawRestConfig argConfig) {

        CawRestConfig currentConfig = argConfig;
        CawRestConfig tempConfig, source, target;

        Stack<CawRestConfig> referencedCfgs = new Stack<CawRestConfig>();

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
}
