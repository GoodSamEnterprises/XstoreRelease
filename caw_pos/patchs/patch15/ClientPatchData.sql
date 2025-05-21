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
alter session set current_schema=$(DbSchema);
-- BEGIN PATCH 14
-- BEGIN BZ44528
--INSERT INTO SEC_PRIVILEGE (organization_id, privilege_type, authentication_req, description, overridable_flag, group_membership, second_prompt_settings, second_prompt_req_diff_emp, second_prompt_group_membership, config_element) 
--SELECT $(OrgID), 'CAW_KIOSK_ORDER', 0, 'Who is allowed to perform a kiosk order', 0, 'AAA=', 'NO_PROMPT', '0', 'AAA=', '*' 
--FROM dual WHERE NOT EXISTS (SELECT 1 FROM SEC_PRIVILEGE WHERE ORGANIZATION_ID=$(OrgID) AND PRIVILEGE_TYPE='CAW_KIOSK_ORDER');

--INSERT INTO com_code_value (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID)
--SELECT $(OrgID), 'CAW_KIOSK_ORDER_ENABLE', 'false', 'Enable kiosk order', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA'
--FROM dual WHERE NOT EXISTS (SELECT 1 FROM com_code_value WHERE organization_id=$(OrgID) and category='CAW_KIOSK_ORDER_ENABLE');
-- END BZ44528

-- BEGIN BZ46006
--DELETE FROM com_shipping_fee WHERE organization_id = $(OrgID) AND rule_name = 'ORDER_SHIPPING_FEE';
--INSERT INTO com_shipping_fee (organization_id, rule_name, priority, ship_item_id, aggregation_type, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) 
--  VALUES ($(OrgID), 'ORDER_SHIPPING_FEE', 1, 'FREIGHT', 'TOTAL', 'ACCOUNT_TYPE_RULE', 'ORDER', NULL, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
-- END BZ46006
-- END PATCH 14

-- BEGIN PATCH 15: BZ46387
DELETE FROM ITM_ITEM_RESTRICT_MAPPING restrict_mapping WHERE restrict_mapping.ORGANIZATION_ID=$(OrgID) AND restrict_mapping.MERCH_HIERARCHY_LEVEL='ITEM' AND restrict_mapping.MERCH_HIERARCHY_ID='980921' AND restrict_mapping.RESTRICTION_CATEGORY='ALWAYS_RESTRICTED';
INSERT INTO ITM_ITEM_RESTRICT_MAPPING (ORGANIZATION_ID,MERCH_HIERARCHY_LEVEL,MERCH_HIERARCHY_ID,RESTRICTION_CATEGORY,ORG_CODE,ORG_VALUE) VALUES ($(OrgID),'ITEM','980921','ALWAYS_RESTRICTED','*','*');

INSERT INTO com_code_value (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID)
SELECT $(OrgID), 'CAW_RV_PAYMENT_ENABLE', 'true', 'Enable rv payment', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA'
FROM dual WHERE NOT EXISTS (SELECT 1 FROM com_code_value WHERE organization_id=$(OrgID) and category='CAW_RV_PAYMENT_ENABLE');
-- END PATCH 15: BZ46387
COMMIT;