-- 
-- CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
-- 
-- Use AND distribution of this code is subject to applicable 
-- licenses AND the permission of the code owner.  This notice 
-- does not indicate the actual or intended publication of 
-- this source code.
-- 
-- Portions developed for Camping World by BTM Global Consulting
-- LLC AND are the property of Camping World.
-- 
-- ===== BTM Modification ===========================================
-- Scope/Bug ID#          ddMMyy             Description
-- BZ45156                191121             [PROD] Update Miraserv auth request to include recurring payment indicator
-- ===================================================================
INSERT INTO com_code_value (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID)
SELECT $(OrgID), 'CAW_RECURRING_PAYMENT_ENABLE', 'false', 'Enable recurring payment', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA'
FROM dual WHERE NOT EXISTS (SELECT 1 FROM com_code_value WHERE organization_id=$(OrgID) and category='CAW_RECURRING_PAYMENT_ENABLE');
COMMIT;