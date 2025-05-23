
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_code_value where category = 'OrganizationId' and code = '$(OrgID)';
IF v_exists = 0 THEN 

INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
VALUES (HIBERNATE_SEQUENCE.nextval, 'OrganizationId', 'DEFAULT', '$(OrgID)', 'DEFAULT', 'Organization $(OrgID)', 0, null, null, null);
end if;
end;
/


COMMIT;


-- SEQUENCES
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'EMPLOYEE_MESSAGE' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'EMPLOYEE_MESSAGE', NULL, NULL, 0, NULL, 1, 9, '0', 1, 999999, 1, 0, 0, 1, 6);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'ASSOCIATE_TASK' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'ASSOCIATE_TASK', NULL, NULL, 0, NULL, 1, 9, '0', 1, 999999, 1, 0, 0, 1, 6);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'PARTY' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'PARTY', NULL, NULL, 0, NULL, 1, 9, '0', 1, 999999, 1, 0, 0, 1, 6);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'DEPLOYMENT_ID' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'DEPLOYMENT_ID', NULL, NULL, 0, NULL, 1, 9, '0', 1, 99999999, 1, 0, 0, 0, 0);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'PLAN_ID' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'PLAN_ID', NULL, NULL, 0, NULL, 1, 9, '0', 1, 999999, 1, 0, 0, 0, 0);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'TAX_BRACKET_SEQ' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'TAX_BRACKET_SEQ', NULL, NULL, 0, NULL, 1, 9, '0', 1000, 99999999, 1, 0, 0, 0, 0);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'LANDSCAPE' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'LANDSCAPE', NULL, NULL, 0, NULL, 1, 9, '0', 1, 999999, 1, 0, 0, 0, 0);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_sequence_part where sequence_id = 'PERSONALITY' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_sequence_part (organization_id, sequence_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length)
values ($(OrgID), 'PERSONALITY', NULL, NULL, 0, NULL, 1, 9, '0', 1, 999999, 1, 0, 0, 0, 0);
end if;
end;
/


COMMIT;


-- org hierarchy levels
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_org_hierarchy_level where org_code = '*' and organization_id = $(OrgID);
IF v_exists = 0 THEN 

INSERT INTO cfg_org_hierarchy_level(organization_id, org_code, parent_org_code, description, system_flag)
values ($(OrgID), '*', NULL, '*', 1);
end if;
end;
/


COMMIT;


-- authorization tender type categories
DELETE FROM cfg_tender_type_category where organization_id=$(OrgID) and tender_category = 'AUTHORIZATION' and tender_type in ('ACCOUNT_RECEIVABLE', 'HOUSE_ACCOUNT', 'CHECK', 'CREDIT_CARD', 'VOUCHER');
COMMIT;

INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'AUTHORIZATION', 'CHECK');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'AUTHORIZATION', 'CREDIT_CARD');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'AUTHORIZATION', 'VOUCHER');
COMMIT;


-- count tender type categories
DELETE FROM cfg_tender_type_category where organization_id=$(OrgID) and tender_category = 'COUNT' and tender_type in ('ACCOUNT_CREDIT', 'CHECK', 'COUPON', 'CREDIT_CARD', 'CURRENCY', 'TRAVELERS_CHECK', 'VOUCHER', 'MISCELLANEOUS_VOUCHER', 'MISCELLANEOUS');
COMMIT;

INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'ACCOUNT_CREDIT');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'CHECK');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'COUPON');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'CREDIT_CARD');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'CURRENCY');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'TRAVELERS_CHECK');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'VOUCHER');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'MISCELLANEOUS_VOUCHER');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'COUNT', 'MISCELLANEOUS');
COMMIT;


-- denomination tender type categories
DELETE FROM cfg_tender_type_category where organization_id=$(OrgID) and tender_category = 'DENOMINATION' and tender_type in ('COUPON', 'CURRENCY', 'TRAVELERS_CHECK', 'VOUCHER', 'MISCELLANEOUS_VOUCHER', 'MISCELLANEOUS');
COMMIT;
 
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'DENOMINATION', 'CURRENCY');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'DENOMINATION', 'TRAVELERS_CHECK');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'DENOMINATION', 'MISCELLANEOUS_VOUCHER');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'DENOMINATION', 'MISCELLANEOUS');
COMMIT;


-- add new tender type categories
DELETE FROM cfg_tender_type_category where organization_id=$(OrgID) and tender_category = 'ADD_NEW_TENDER' and tender_type in ('CURRENCY', 'CREDIT_CARD', 'MISCELLANEOUS');
COMMIT;
  
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'ADD_NEW_TENDER', 'CURRENCY');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'ADD_NEW_TENDER', 'CREDIT_CARD');
INSERT INTO cfg_tender_type_category(organization_id, tender_category, tender_type) values ($(OrgID), 'ADD_NEW_TENDER', 'MISCELLANEOUS');
COMMIT;


-- CUSTOMER
DELETE FROM cfg_code_category WHERE organization_id = $(OrgID) and category_group = 'CUSTOMER' and category IN ('ADDRESS_TYPE', 'CUST_ACCOUNT_STATE', 'CUSTOMER_CONTACT_PREF', 'CUSTOMER_GROUPS', 'GENDER', 'GIFT_REGISTRY_ADDRESS_TYPE', 'GIFT_REGISTRY_EVENT_TYPE', 'MARITAL_STATUS', 'ORGANIZATION_TYPE', 'PARTY_PROPERTY_DISPLAY');
COMMIT;

INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'ADDRESS_TYPE', 0, 'Address Type', 'The categorization of customer address types (Example: work, home, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'CUST_ACCOUNT_STATE', 0, 'Customer Account Status', 'The status of the customer''s account (Example: open, closed, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'CUSTOMER_CONTACT_PREF', 0, 'Customer Contact Preference Type', 'The customer''s preferred method of contact (Example: work, email, home).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'CUSTOMER_GROUPS', 0, 'Customer Groups', 'The grouping of customers based on similar attributes (Example: VIP, employee, etc.).', 1, 1);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'GENDER', 0, 'Gender', 'The customer''s gender.', 1, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'GIFT_REGISTRY_ADDRESS_TYPE', 0, 'Gift Registry Address Type', 'The addresses associated with a gift registry (Example: before event shipping address, venue, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'GIFT_REGISTRY_EVENT_TYPE', 0, 'Gift Registry Event Type', 'The type of event associated with a gift registry (Example: wedding, baby shower, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'MARITAL_STATUS', 0, 'Marital Status', 'The marital status of a customer.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'ORGANIZATION_TYPE', 0, 'Organization Type', 'The classification of an organization based on its business (Example: distributor, manufacturer, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'CUSTOMER', 'PARTY_PROPERTY_DISPLAY', 0, 'Party Property Display', 'The properties that have been chosen to display when assigned to a customer.', 0, 0);
COMMIT;


-- EMPLOYEE
DELETE FROM cfg_code_category WHERE organization_id = $(OrgID) and category_group = 'EMPLOYEE' and category IN ('EMPLOYEE_CHALLENGE', 'EMPLOYEE_GROUP', 'EMPLOYEE_ROLE', 'EMPLOYEE_STATUS', 'EMPLOYEE_TASK_TYPE', 'EMPLOYEE_TYPE', 'PAY_STATUS', 'RESTRICTED_TASK_TYPE', 'EMPLOYEE_TASK_VISIBILITY');
COMMIT;

INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_CHALLENGE', 0, 'Employee Challenge Questions', 'Employee challenge questions are used to identify an employee for the purpose of resetting the employee''s password.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_GROUP', 0, 'Employee Group', 'Employee Groups are used to target employee tasks for specific groups of individuals.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_ROLE', 0, 'Employee Role', 'The employee''s role within the organization. This is found in the ''Role'' dropdown in employee maintenance.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_STATUS', 0, 'Employee Status', 'The employment status of an employee (Example: inactive, active, terminated).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_TASK_TYPE', 0, 'Employee Task Type', 'The type of tasks that may be assigned to employees (Example: housekeeping, general, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_TASK_VISIBILITY', 0, 'Employee Task Visibility', 'The visibility type of tasks that determines the assigned to options (Example: Store, Employee Groups, Employee.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'RESTRICTED_TASK_TYPE', 0, 'Restricted Task Type', 'The type of tasks that are restricted from being created or edited', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'EMPLOYEE_TYPE', 0, 'Employee Type', 'The type of employees that may exist within the organization. This is found in the ''Type'' dropdown in employee maintenance.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EMPLOYEE', 'PAY_STATUS', 0, 'Pay Status', 'The pay status of an employee (Example: hourly, salaried, etc.).', 0, 0);
COMMIT;


-- INVENTORY
DELETE FROM cfg_code_category WHERE organization_id = $(OrgID) and category_group = 'INVENTORY' and category IN ('INVENTORY_ACTION_CODES', 'INV_BUCKET', 'INV_BUCKET_SYSTEM', 'INV_BUCKET_TRACKING_METHOD', 'INVENTORY_LOCATOR_DISTANCES', 'ITEM_GROUP', 'ITEM_MATRIX_COLOR_CLASS', 'ITEM_MATRIX_COLOR_DEPT', 'ITEM_MATRIX_COLOR_ITEM', 'ITEM_MATRIX_COLOR_SUBDEPT', 'ITEM_MATRIX_COLOR_SUBCLASS', 'ITEM_PROP_GROUP');
COMMIT;

INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'INVENTORY_ACTION_CODES', 0, 'Inventory Action Codes', 'Inventory Action Codes describe actions that were taken against inventory (Example: cycle count, sale, etc.) and are used by the inventory movement report.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'INV_BUCKET', 0, 'Inventory Bucket Type', 'Inventory buckets used for inventory maintenance and management.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'INV_BUCKET_SYSTEM', 0, 'Inventory System Bucket Type', 'Inventory system buckets used for inventory maintenance and management', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'INV_BUCKET_TRACKING_METHOD', 0, 'Inventory Bucket Tracking Method', 'Tracking inventory buckets is used in inventory location maintenance for location-based inventory.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_GROUP', 0, 'Item Group', 'Item groups are used to group similar items together.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_MATRIX_COLOR_CLASS', 0, 'Item Matrix Color, Class', 'The Item Matrix color used for Classes.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_MATRIX_COLOR_DEPT', 0, 'Item Matrix Color, Department', 'The Item Matrix color used for Departments.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_MATRIX_COLOR_ITEM', 0, 'Item Matrix Color, Item', 'The Item Matrix color used for Items.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_MATRIX_COLOR_SUBDEPT', 0, 'Item Matrix Color, SubDepartment', 'The Item Matrix color used for SubDepartments.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_MATRIX_COLOR_SUBCLASS', 0, 'Item Matrix Color, Subclass', 'The Item Matrix color used for SubClass.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'INVENTORY', 'ITEM_PROP_GROUP', 1, 'Item Property, Group', '', 0, 0);
COMMIT;


-- EXTENDED_TRANSACTION
DELETE FROM cfg_code_category WHERE organization_id = $(OrgID) and category_group = 'EXTENDED_TRANSACTION' and category IN ('INSURANCE_PLAN', 'MODULE_NAME', 'PRIVATE_CREDIT_ACCOUNT_TYPE', 'PRIVATE_CREDIT_PRIMARY_ID_TYPE', 'PRIVATE_CREDIT_SECOND_ID_TYPE', 'WORK_ORDER_PRIORITIES', 'LOCATE_ITEM_DISTANCES');
COMMIT;

INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'INSURANCE_PLAN', 0, 'Insurance Plan', 'Insurance plans that may be used in conjunction with a private credit plan.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'MODULE_NAME', 0, 'Module Name', 'Modules identify functional areas of Xstore and are used by the "Open Support Ticket" option when a help desk error is displayed.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'PRIVATE_CREDIT_ACCOUNT_TYPE', 0, 'Private Credit Account Type', 'Private credit account type accessed by the customer (Example: deferred billing, extended payment, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'PRIVATE_CREDIT_PRIMARY_ID_TYPE', 0, 'Private Credit Primary ID Type', 'The primary ID type accepted by the organization when a customer sets up a private credit account.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'PRIVATE_CREDIT_SECOND_ID_TYPE', 0, 'Private Credit Second ID Type', 'The second ID type accepted by the organization when two IDs are required for a customer to set up a private credit account.', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'WORK_ORDER_PRIORITIES', 0, 'Work Order Priorities', 'The priority of a work order (Example: expedite, standard, etc.).', 0, 0);
INSERT INTO cfg_code_category (organization_id, category_group, category, internal_flag, description, comments, uses_image_url, uses_rank)
values ($(OrgID), 'EXTENDED_TRANSACTION', 'LOCATE_ITEM_DISTANCES', 0, 'Locate Item Distances', 'The possible selections for distance from a store that is used when locating an item.', 0, 0);
COMMIT;


-- REASON_CODE_TYPES
DELETE FROM cfg_reason_code_type WHERE organization_id = $(OrgID);
COMMIT;

INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'CHANGE_FLOAT', '_reasonCodeType_CHANGE_FLOAT');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'DISCOUNT', '_reasonCodeType_DISCOUNT');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'INVENTORY_ADJUSTMENT', '_reasonCodeType_INVENTORY_ADJUSTMENT');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'ITEM_TRANSFER', '_reasonCodeType_ITEM_TRANSFER');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'NO_SALE', '_reasonCodeType_NO_SALE');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'ORDER_CANCEL', '_reasonCodeType_ORDER_CANCEL');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'ORDER_REJECT', '_reasonCodeType_ORDER_REJECT');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'PAID_IN', '_reasonCodeType_PAID_IN');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'PAID_OUT', '_reasonCodeType_PAID_OUT');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'PAYMENT_REVERSAL', '_reasonCodeType_PAYMENT_REVERSAL');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'POST_VOID', '_reasonCodeType_POST_VOID');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'PRICE_CHANGE', '_reasonCodeType_PRICE_CHANGE');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'REPLENISHMENT_HEADER', '_reasonCodeType_REPLENISHMENT_HEADER');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'REPLENISHMENT_ITEM', '_reasonCodeType_REPLENISHMENT_ITEM');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'RETURN', '_reasonCodeType_RETURN');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'TAX_CHANGE', '_reasonCodeType_TAX_CHANGE');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'TAX_EXEMPT', '_reasonCodeType_TAX_EXEMPT');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'TILL_COUNT_DISCREPANCY', '_reasonCodeType_TILL_COUNT_DISCREPANCY');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'TIME_OFF_REAS_CODE', '_reasonCodeType_TIME_OFF_REAS_CODE');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'TRANSACTION_CANCEL', '_reasonCodeType_TRANSACTION_CANCEL');
INSERT INTO cfg_reason_code_type (organization_id, reason_code_type, description) VALUES ($(OrgID), 'VOID_LINE_ITEM', '_reasonCodeType_VOID_LINE_ITEM');
COMMIT;


-- **************************************************** --
-- * Always keep Default User Creation at end of file * --
-- **************************************************** --
-- DEFAULT USER
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_user where USER_NAME='$(OrgID)-1';
IF v_exists = 0 THEN 

  INSERT INTO cfg_user (user_name, first_name, last_name, organization_id, locale, role_id) VALUES ('$(OrgID)-1', 'Organization $(OrgID)', 'User', $(OrgID), 'en_US', 'ADMINISTRATOR');
  INSERT INTO cfg_user_node (organization_id, user_name, org_scope) VALUES ($(OrgID), '$(OrgID)-1', '*:*');
  INSERT INTO cfg_user_password (password_id, organization_id, user_name, password, effective_date) VALUES (HIBERNATE_SEQUENCE.nextval, $(OrgID), '$(OrgID)-1', 'tZxnvxlqR1gZHkL3ZnDOug==', SYSDATE);
end if;
end;
/


COMMIT;

