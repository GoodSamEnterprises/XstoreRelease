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
-- BZ37177                150720             [Task] Enable Order Function in Xstore
-- BZ37058                030820             [TASK] Enable Order Reject feature for all Xstore roles
-- BZ37023                170820             [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
-- BZ37951                170920             [Internal] Need Reject button on Order screens
-- BZ38006                210920             [TASK] Update base with CW Order Reject Reason Codes
-- BZ38021                210920             [Task] Pre-setup shipping methods with into Xstore DB by importing Shipper MNT file
-- BZ38549                141020             [Task] CW's request about updating configuration for DefaultLocateItemDistance and "Miles" field on LOCATE ITEM
-- BZ42889                110521             [Prod] Order cancellation with pricing turned on, tries to force a return with a refund. The refund should be happening in Oracle.
-- BZ44053                220621             [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
-- BZ45156                030821             [PROD] Update Miraserv auth request to include recurring payment indicator
-- BZ44528                130821             Electric World & Mobile POS Implementation(Phase 1)
-- BZ46006                300821             Phase 1 Electric World - Change shipping SKU for Electric World order.
-- BZ46387                300921             IDS Payment item restriction question
-- BZ42307                241121             [Requirement] Add ability to reject at the item level for BOPIS
-- ===================================================================

SPOOL cw_db_update.log;

-- BEGIN BZ37177
DELETE FROM COM_REASON_CODE WHERE ORGANIZATION_ID = $(OrgID) AND REASON_TYPCODE IN ('ORDER_CANCEL','ORDER_REJECT');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_CANCEL','OC1','The customer change their mind',1,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_CANCEL','OC2','Found a better item',2,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_CANCEL','OC3','Did not Like',3,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_CANCEL','OC4','Better price somewhere else',4,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');

-- BEGIN BZ38006
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_REJECT','OR1','Customer called to cancel',1,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_REJECT','OR2','Found item, but it''s defective',2,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_REJECT','OR3','Found item, but it''s on hold for another customer',3,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_REJECT','OR4','Partial pick',4,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO COM_REASON_CODE (ORGANIZATION_ID,REASON_TYPCODE,REASON_CODE,DESCRIPTION,SORT_ORDER,HIDDEN_FLAG,CONFIG_ELEMENT,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID) VALUES ($(OrgID),'ORDER_REJECT','OR5','Item not on hand',5,0,'*',SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
-- END BZ38006

-- END BZ37177

-- Begin BZ37058, BZ-37951 
DELETE FROM SEC_PRIVILEGE WHERE ORGANIZATION_ID = $(OrgID) and PRIVILEGE_TYPE in ('CAW_ORDERS_MANAGERMENT','ORDER_REJECT');
INSERT INTO SEC_PRIVILEGE (ORGANIZATION_ID, PRIVILEGE_TYPE, AUTHENTICATION_REQ, DESCRIPTION, OVERRIDABLE_FLAG, GROUP_MEMBERSHIP, SECOND_PROMPT_SETTINGS, SECOND_PROMPT_REQ_DIFF_EMP, SECOND_PROMPT_GROUP_MEMBERSHIP, CONFIG_ELEMENT) VALUES ($(OrgID), 'CAW_ORDERS_MANAGERMENT', 0, 'Who is allowed to Manage Orders?', 1, '/gc=', 'NO_PROMPT', '0', '/gc=', '*');
INSERT INTO SEC_PRIVILEGE (ORGANIZATION_ID, PRIVILEGE_TYPE, AUTHENTICATION_REQ, DESCRIPTION, OVERRIDABLE_FLAG, GROUP_MEMBERSHIP, SECOND_PROMPT_SETTINGS, SECOND_PROMPT_REQ_DIFF_EMP, SECOND_PROMPT_GROUP_MEMBERSHIP, CONFIG_ELEMENT) VALUES ($(OrgID), 'ORDER_REJECT', 0, 'Who is allowed to reject an order?', 0, '/gc=', 'NO_PROMPT', '0', '/gc=', '*');
-- End BZ37058, BZ-37951 

-- Begin BZ37023
-- BEGIN BZ38021
DELETE FROM inv_shipper_method WHERE organization_id = $(OrgID);

INSERT INTO inv_shipper_method (organization_id, shipper_method_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), '1' ,'STANDARD GROUND',  'UPS', null, null, 5, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO inv_shipper_method (organization_id, shipper_method_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), '2' ,'EXPEDITED GROUND', 'UPS', null, null,10, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO inv_shipper_method (organization_id, shipper_method_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), '4' ,'TWO-DAY AIR',      'UPS', null, null,15, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO inv_shipper_method (organization_id, shipper_method_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), '8' ,'NEXT-DAY AIR',     'UPS', null, null,20, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO inv_shipper_method (organization_id, shipper_method_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), '16' ,'INTERNATIONAL',   'UPS', null, null,25, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO inv_shipper_method (organization_id, shipper_method_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), '32' ,'LTL FREIGHT',     'UPS', null, null,30, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');

DELETE FROM com_shipping_fee_tier WHERE organization_id = $(OrgID) AND parent_rule_name = 'ORDER_SHIPPING_FEE';

INSERT INTO com_shipping_fee_tier (organization_id, rule_name, parent_rule_name, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'STANDARD_GROUND', 'ORDER_SHIPPING_FEE', 9,'FEE', 9.95,'1', NULL,NULL,NULL,'TRUE_RULE',NULL,NULL,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO com_shipping_fee_tier (organization_id, rule_name, parent_rule_name, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'EXPEDITED_GROUND','ORDER_SHIPPING_FEE',10,'FEE',19.95,'2', NULL,NULL,NULL,'TRUE_RULE',NULL,NULL,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO com_shipping_fee_tier (organization_id, rule_name, parent_rule_name, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'TWO_DAY_AIR',     'ORDER_SHIPPING_FEE',11,'FEE',19.99,'4', NULL,NULL,NULL,'TRUE_RULE',NULL,NULL,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO com_shipping_fee_tier (organization_id, rule_name, parent_rule_name, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'NEXT_DAY_AIR',    'ORDER_SHIPPING_FEE',12,'FEE',29.99,'8', NULL,NULL,NULL,'TRUE_RULE',NULL,NULL,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO com_shipping_fee_tier (organization_id, rule_name, parent_rule_name, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'INTERNATIONAL',   'ORDER_SHIPPING_FEE',13,'FEE',30.99,'16',NULL,NULL,NULL,'TRUE_RULE',NULL,NULL,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
INSERT INTO com_shipping_fee_tier (organization_id, rule_name, parent_rule_name, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LTL_FREIGHT',     'ORDER_SHIPPING_FEE',14,'FEE',31.99,'32',NULL,NULL,NULL,'TRUE_RULE',NULL,NULL,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA');
-- END BZ38021  
-- End BZ37023

-- Begin Bz-38549
DELETE FROM com_code_value
  WHERE organization_id = $(OrgID) AND
        category = 'LOCATE_ITEM_DISTANCES' AND
        code IN ('100', '200', '250', '500', '750', '1000', '1250', '5000', '5', '10', '25', '50');


INSERT INTO com_code_value (organization_id, category, code, description, sort_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LOCATE_ITEM_DISTANCES', '250', '250', 5, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO com_code_value (organization_id, category, code, description, sort_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LOCATE_ITEM_DISTANCES', '500', '500', 10, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO com_code_value (organization_id, category, code, description, sort_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LOCATE_ITEM_DISTANCES', '750', '750', 20, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO com_code_value (organization_id, category, code, description, sort_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LOCATE_ITEM_DISTANCES', '1000', '1000', 30, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO com_code_value (organization_id, category, code, description, sort_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LOCATE_ITEM_DISTANCES', '1250', '1250', 40, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO com_code_value (organization_id, category, code, description, sort_order, create_date, create_user_id, update_date, update_user_id) VALUES ($(OrgID), 'LOCATE_ITEM_DISTANCES', '5000', '5000', 50, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
-- End Bz-38549

-- BEGIN BZ42889
DELETE FROM TND_TNDR_OPTIONS WHERE ORGANIZATION_ID = $(OrgID) AND TNDR_ID = 'OMNI_REFUND';
INSERT INTO TND_TNDR_OPTIONS (ORGANIZATION_ID,TNDR_ID,CONFIG_ELEMENT,AUTH_MTHD_CODE,SERIAL_ID_NBR_REQ_FLAG,AUTH_REQ_FLAG,AUTH_EXPR_DATE_REQ_FLAG,PIN_REQ_FLAG,CUST_SIG_REQ_FLAG,ENDORSEMENT_REQ_FLAG,OPEN_CASH_DRAWER_REQ_FLAG,UNIT_COUNT_REQ_CODE,MAG_SWIPE_READER_REQ_FLAG,DFLT_TO_AMT_DUE_FLAG,MIN_DENOMINATION_AMT,REPORTING_GROUP,EFFECTIVE_DATE,EXPR_DATE,MIN_DAYS_FOR_RETURN,MAX_DAYS_FOR_RETURN,CUST_ID_REQ_CODE,CUST_ASSOCIATION_FLAG,POPULATE_SYSTEM_COUNT_FLAG,INCLUDE_IN_TYPE_COUNT_FLAG,SUGGESTED_DEPOSIT_THRESHOLD,SUGGEST_DEPOSIT_FLAG,CHANGE_TNDR_ID,CASH_CHANGE_LIMIT,OVER_TENDER_OVERRIDABLE_FLAG,NON_VOIDABLE_FLAG,DISALLOW_SPLIT_TNDR_FLAG,CLOSE_COUNT_DISC_THRESHOLD,CID_MSR_REQ_FLAG,CID_KEYED_REQ_FLAG,POSTAL_CODE_REQ_FLAG,POST_VOID_OPEN_DRAWER_FLAG,CHANGE_ALLOWED_WHEN_FOREIGN,FISCAL_TNDR_ID,ROUNDING_MODE,ASSIGN_CASH_DRAWER_REQ_FLAG,POST_VOID_ASSIGN_DRAWER_FLAG,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID,RECORD_STATE) VALUES ($(OrgID),'OMNI_REFUND','*','OMNI_REFUND',1,0,1,0,0,0,0,'TOTAL_NORMAL',0,1,null,'TENDER SUMMARY',null,null,0,30,null,0,0,1,1000,0,'LOCAL_CURRENCY',999999,0,0,0,null,0,0,0,0,0,null,null,0,0,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA',null);

DELETE FROM TND_TNDR WHERE ORGANIZATION_ID = $(OrgID) AND TNDR_ID = 'OMNI_REFUND';
INSERT INTO TND_TNDR (ORGANIZATION_ID,TNDR_ID,TNDR_TYPCODE,CURRENCY_ID,DESCRIPTION,DISPLAY_ORDER,FLASH_SALES_DISPLAY_ORDER,DISABLED_FLAG,CREATE_DATE,CREATE_USER_ID,UPDATE_DATE,UPDATE_USER_ID,RECORD_STATE) VALUES ($(OrgID),'OMNI_REFUND','MISCELLANEOUS','*','+OMNI_REFUND',null,370,0,SYSDATE,'BASEDATA',SYSDATE,'BASEDATA',null);

DELETE FROM COM_TRANSLATIONS WHERE ORGANIZATION_ID = $(OrgID) AND TRANSLATION_KEY='+OMNI_REFUND';
INSERT INTO COM_TRANSLATIONS (ORGANIZATION_ID, TRANSLATION_KEY, LOCALE, ORG_CODE, ORG_VALUE, TRANSLATION, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), '+OMNI_REFUND', 'DEFAULT', '*', '*', 'MNI Refund', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');

DELETE FROM TND_TNDR_AVAILABILITY WHERE ORGANIZATION_ID = $(OrgID) AND TNDR_ID = 'OMNI_REFUND';
INSERT INTO TND_TNDR_AVAILABILITY (ORGANIZATION_ID, TNDR_ID, AVAILABILITY_CODE, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), 'OMNI_REFUND', 'ORDER', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
-- END BZ42889
-- BEGIN BZ44053
DELETE FROM COM_CODE_VALUE WHERE ORGANIZATION_ID=$(OrgID) AND CATEGORY IN ('CAW_MEMBERSHIP_NAME');

INSERT INTO COM_CODE_VALUE (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), 'CAW_MEMBERSHIP_NAME', '1', 'GSAM', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO COM_CODE_VALUE (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), 'CAW_MEMBERSHIP_NAME', '4', 'GSRA', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO COM_CODE_VALUE (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), 'CAW_MEMBERSHIP_NAME', '16', 'DRA', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO COM_CODE_VALUE (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), 'CAW_MEMBERSHIP_NAME', '64', 'GSTA', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
INSERT INTO COM_CODE_VALUE (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID) VALUES ($(OrgID), 'CAW_MEMBERSHIP_NAME', '65536', 'LWHSL', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
-- END BZ44053

-- BEGIN BZ45156
INSERT INTO com_code_value (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID)
SELECT $(OrgID), 'CAW_RECURRING_PAYMENT_ENABLE', 'false', 'Enable recurring payment', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA'
FROM dual WHERE NOT EXISTS (SELECT 1 FROM com_code_value WHERE organization_id=$(OrgID) and category='CAW_RECURRING_PAYMENT_ENABLE');
-- END BZ45156

-- BEGIN BZ44528
INSERT INTO SEC_PRIVILEGE (organization_id, privilege_type, authentication_req, description, overridable_flag, group_membership, second_prompt_settings, second_prompt_req_diff_emp, second_prompt_group_membership, config_element) 
SELECT $(OrgID), 'CAW_KIOSK_ORDER', 0, 'Who is allowed to perform a kiosk order', 0, 'AAA=', 'NO_PROMPT', '0', 'AAA=', '*' 
FROM dual WHERE NOT EXISTS (SELECT 1 FROM SEC_PRIVILEGE WHERE ORGANIZATION_ID=$(OrgID) AND PRIVILEGE_TYPE='CAW_KIOSK_ORDER');

INSERT INTO com_code_value (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID)
SELECT $(OrgID), 'CAW_KIOSK_ORDER_ENABLE', 'false', 'enable kiosk order', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA'
FROM dual WHERE NOT EXISTS (SELECT 1 FROM com_code_value WHERE organization_id=$(OrgID) and category='CAW_KIOSK_ORDER_ENABLE');
-- END BZ44528

-- BEGIN BZ46006
DELETE FROM com_shipping_fee WHERE organization_id = $(OrgID) AND rule_name = 'ORDER_SHIPPING_FEE';
INSERT INTO com_shipping_fee (organization_id, rule_name, priority, ship_item_id, aggregation_type, rule_type, param1, param2, create_date, create_user_id, update_date, update_user_id) 
  VALUES ($(OrgID), 'ORDER_SHIPPING_FEE', 1, 'FREIGHT', 'TOTAL', 'ACCOUNT_TYPE_RULE', 'ORDER', NULL, SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA');
-- END BZ46006

-- BEGIN BZ46387
DELETE FROM DTV.ITM_ITEM_RESTRICT_MAPPING restrict_mapping WHERE restrict_mapping.ORGANIZATION_ID=$(OrgID) AND restrict_mapping.MERCH_HIERARCHY_LEVEL='ITEM' AND restrict_mapping.MERCH_HIERARCHY_ID='980921' AND restrict_mapping.RESTRICTION_CATEGORY='ALWAYS_RESTRICTED';
INSERT INTO ITM_ITEM_RESTRICT_MAPPING (ORGANIZATION_ID,MERCH_HIERARCHY_LEVEL,MERCH_HIERARCHY_ID,RESTRICTION_CATEGORY,ORG_CODE,ORG_VALUE) VALUES ($(OrgID),'ITEM','980921','ALWAYS_RESTRICTED','*','*');

INSERT INTO com_code_value (ORGANIZATION_ID, CATEGORY, CODE, DESCRIPTION, SORT_ORDER, HIDDEN_FLAG, CONFIG_ELEMENT, CREATE_DATE, CREATE_USER_ID, UPDATE_DATE, UPDATE_USER_ID)
SELECT $(OrgID), 'CAW_RV_PAYMENT_ENABLE', 'true', 'Enable rv payment', 1, 0, '*', SYSDATE, 'BASEDATA', SYSDATE, 'BASEDATA'
FROM dual WHERE NOT EXISTS (SELECT 1 FROM com_code_value WHERE organization_id=$(OrgID) and category='CAW_RV_PAYMENT_ENABLE');
-- END BZ46387

-- BEGIN BZ42307 - Disable Reject button
DELETE FROM SEC_PRIVILEGE WHERE ORGANIZATION_ID = $(OrgID) AND PRIVILEGE_TYPE = 'ORDER_REJECT';
INSERT INTO SEC_PRIVILEGE (ORGANIZATION_ID, PRIVILEGE_TYPE, AUTHENTICATION_REQ, DESCRIPTION, OVERRIDABLE_FLAG, GROUP_MEMBERSHIP, SECOND_PROMPT_SETTINGS, SECOND_PROMPT_REQ_DIFF_EMP, SECOND_PROMPT_GROUP_MEMBERSHIP, CONFIG_ELEMENT) VALUES ($(OrgID), 'ORDER_REJECT', 0, 'Who is allowed to reject an order?', 0, 'AAA=', 'NO_PROMPT', '0', 'AAA=', '*');
-- END BZ42307 - Disable Reject buttons

COMMIT;

