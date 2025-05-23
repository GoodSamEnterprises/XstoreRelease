
-- Base Configuration Features
DELETE FROM cfg_base_feature;
COMMIT;

INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('cust/loyalty', 'Loyalty', null, 10);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('cust/loyalty/award', 'Loyalty Awards', 'cust/loyalty', 10);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('relate', 'Customer Engagement', null, 20);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('cust/registry', 'Gift Registry', 'relate', 10);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('order:locate', 'Order Broker (Cloud)', null, 30);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('crosschannelreturn', 'Order Management Cross-channel Return', null, 40);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('authprocessor/tenderretail', 'Tender Retail Authorizations', null, 90);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('opera', 'Opera Guest Services', null, 100);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('sim', 'Store Inventory Management (SIM)', null, 110);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('avs', 'Address Verification', null, 120);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('qas', 'Experian Address Verification', 'avs', 120);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('rxm', 'Retail Extension Module (RXM)', null, 130);
INSERT INTO cfg_base_feature (feature_id, description, depends_on_feature_id, sort_order) VALUES ('xcommerce', 'Xcommerce', null, 140);
COMMIT;


-- CFG_PRIVILEGE
DELETE FROM cfg_privilege WHERE category IN ('Menu', 'Support', 'AdminSecurity', 'Administration', 'Configurator', 'DataManager', 'DeploymentManager', 'Reports', 'Home Page');
COMMIT;

DELETE FROM cfg_role_privilege WHERE privilege_id = 'CFG_DELETE_STORE_CONFIGS';
COMMIT;


INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'BASIC_ACCESS', 'Home Page', 'Home Page');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Support', 'SPT_VIEW_SUPPORT_DASHBOARD', 'Alert Console', 'Alert Console');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Support', 'SPT_SUPPORT_SETTINGS', 'Alert Settings', 'Alert Settings');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Support', 'SPT_POSLOG_BUILDER', 'POSLog Publisher', 'PosLog Publisher');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Support', 'SPT_VERSIONINFO_DASHBOARD', 'Deployed Xstore Versions', 'Deployed Xstore Versions');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'SPT_EJOURNAL', 'Electronic Journal', 'Electronic Journal');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Support', 'SPT_REPL_VIEWER', 'Replication Status', 'Replication Status');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Administration', 'ADMN_ADD_EDIT_USERS', 'Users and Security Access', 'Users and Security Access');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Administration', 'ADMN_USER_ROLES', 'User Roles', 'User Roles');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Administration', 'ADMN_AVAILABLE_LOCALES', 'Available Locales', 'Available Locales');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Administration', 'XADMIN_SETTINGS', 'Xadmin Settings', 'Xadmin Settings');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Administration', 'ADMN_ACCOUNT_RESET', 'Lock/Reset Account', 'Lock/Reset Account');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Administration', 'XADMIN_USERS', 'Xadmin Users', 'Xadmin Users');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_CODE', 'Code Value', 'Code Value');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_SYSCONFIG', 'System Config', 'System Config');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_DISCOUNTS', 'Discounts', 'Discounts');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_MENUS', 'Menus', 'Menus');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_MENU_CONFIG', 'Menu Configuration', 'Menu Configuration');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_TAB_CONFIG', 'Tab Configuration', 'Tab Configuration');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_REASON_CODE', 'Reason Codes', 'Reason Codes');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_RECEIPT_CONFIG', 'Receipts', 'Receipts');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_PROFILE_CONFIGURATION', 'Configurator', 'Configurator');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_PROFILE_GROUPS', 'Profile Maintenance', 'Profile Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_PROFILE_MANAGEMENT', 'Profile Management', 'Profile Management');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_PERSONALITY_MAINTENANCE', 'Personality Maintenance', 'Personality Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_LANDSCAPE_MAINTENANCE', 'Landscape Maintenance', 'Landscape Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_STORE_PERSONALITIES', 'Store Personality Maintenance', 'Store Personality Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_GLOBAL_CONFIGURATION', 'Global Configurations', 'Global Configurations');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_CONFIGURATION_OVERRIDES', 'Configuration Overrides', 'Configuration Overrides');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_SCHEDULE_DEPLOYMENT', 'Schedule Deployment', 'Schedule Deployment');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_STORE_SPECIFIC_OVERRIDES', 'Store Specific Overrides', 'Store Specific Overrides');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_COPY_STORE_CONFIGS', 'Copy Store Configurations', 'Copy Store Configurations');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_DELETE_PROFILE_CHANGES', 'Delete Profile Element Configurations', 'Delete Profile Element Configurations');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_SECURITY_GROUP', 'Security Groups', 'Security Group');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_SECURITY_PERMISSION', 'Security', 'Security');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_SECURITY_PRIVILEGE', 'Security Privileges', 'Security Privilege');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_TENDER', 'Tender Maintenance', 'Tender Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_TENDER_OPTIONS', 'Tender Options Maintenance', 'Tender Options Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_TENDER_USER_SETTINGS', 'Tender Security Settings', 'Tender Security Settings');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_TENDER_OPTION', 'Tenders', 'Tenders');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Configurator', 'CFG_CUSTDISPLAYS', 'Customer Displays', 'Customer Displays');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_CURRENCY_EXCHANGE', 'Currency Exchange', 'Currency Exchange');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_EMPLOYEE', 'Employee', 'Employee');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_EMPLOYEE_MESSAGE', 'Store Messages', 'Store Messages');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_EMPLOYEE_TASK', 'Employee Tasks', 'Employee Tasks');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ITEM', 'Items', 'Items');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ITEM_PRICING', 'Item Pricing', 'Item Pricing');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ORGANIZATION_HIERARCHY', 'Organization Hierarchy', 'Organization Hierarchy');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ORG_HIERARCHY_LEVELS', 'Organization Hierarchy Levels', 'Organization Hierarchy Levels');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ORG_HIERARCHY_MAINTENANCE', 'Organization Hierarchy Maintenance', 'Organization Hierarchy Maintenance');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_STORE_COLLECTIONS', 'Store Collections', 'Store Collections');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_STORES', 'Stores', 'Stores');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAX_AUTHORITY', 'Tax Authority', 'Tax Authority');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAX_GROUP', 'Tax Group', 'Tax Group');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAX_LOCATION', 'Tax Location', 'Tax Location');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_VENDOR', 'Vendor', 'Vendor');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_EDIT_SESSION', 'Data Manager', 'Data Manager');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_COMMUNICATIONS', 'Store Communications', 'Store Communications');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_MERCH_ITEMS', 'Merchandise Items', 'Merchandise Items');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_NON_MERCH_ITEMS', 'Non Merchandise Items', 'Non Merchandise Items');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ITEM_MATRIX', 'Item Matrix Manager', 'Item Matrix Manager');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_MERCH_HIERARCHY', 'Merchandise Hierarchy', 'Merchandise Hierarchy');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAXES', 'Taxes', 'Taxes');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAX_ELEMENTS', 'Tax Elements', 'Tax Elements');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAX_RATES', 'Tax Rates', 'Tax Rates');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_TAX_BRACKET', 'Tax Brackets', 'Tax Brackets');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_ATTACHED_ITEMS', 'Attached Items', 'Attached Items');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DataManager', 'CFG_MASS_TRANSFER', 'Data Publisher', 'Data Publisher');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'SPT_FILE_UPLOAD', 'File Upload', 'File Upload');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'UPLOAD_FILE_TO_DEPLOY', 'Upload File to Deploy', 'Upload File to Deploy');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'SPT_DEPLOYMENT_VIEWER', 'View Deployments', 'View Deployments');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'FILE_DEPLOY', 'File Deploy', 'File Deploy');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'CANCEL_DEPLOYMENT', 'Cancel Deployment', 'Cancel Deployment');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'VIEW_ONLY_DEPLOYMENT_PLAN', 'View Deployment Plans', 'View Deployment Plans');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'EDIT_DEPLOYMENT_PLAN', 'Create/Edit Deployment Plans', 'Create/Edit Deployment Plans');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'UNAPPROVE_DEPLOYMENT_WAVE', 'Unapprove Deployment Wave', 'Unapprove Deployment Wave');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'APPROVE_DEPLOYMENT_WAVE', 'Approve Deployment Wave', 'Approve Deployment Wave');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'SCHEDULE_DEPLOYMENT_PLAN', 'Schedule Planned Deployment', 'Schedule Planned Deployment');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'SCHEDULE_SINGLE_TARGET', 'Schedule Single Deployment', 'Schedule Single Deployment');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('DeploymentManager', 'PURGE_DEPLOYMENT_FILES', 'Purge Deployment Files', 'Purge Deployment Files');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_GENERAL_ACCESS', 'View Reports', 'View Reports');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_BEST_SELLERS', 'Best Sellers Report', 'Best Sellers Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_CCA_ACTIVITY_SUMMARY', 'Customer Account Activity Summary Report', 'Customer Account Activity Summary Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_CREDIT_CARD', 'Credit Card Report', 'Credit Card Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_CUSTOMER_LIST', 'Customer List Report', 'Customer List Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_DAILY_SALES_CASH', 'Daily Sales and Cash Report', 'Daily Sales and Cash Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_DAILY_SALES', 'Daily Sales Report', 'Daily Sales Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_DAILY_SALES_TOTAL', 'Daily Sales Total Report', 'Daily Sales Total Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_EMPLOYEE_PERFORMANCE', 'Employee Performance Report', 'Employee Performance Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_FLASH_SALES', 'Flash Sales Report', 'Flash Sales Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_GIFT_CERTIFICATE', 'Gift Certificate Report', 'Gift Certificate Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_ITEM_LIST', 'Item List Report', 'Item List Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_EMP_TASKS', 'Employee Tasks Report', 'Employee Tasks Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_JOURNAL', 'Journal Report', 'Journal Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_LAYAWAY_ACCT_ACTIVITY', 'Layaway Account Activity Report', 'Layaway Account Activity Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_LAYAWAY_AGING', 'Layaway Aging Report', 'Layaway Aging Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_LINE_VOID', 'Line Void Report', 'Line Void Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_NO_SALE', 'No Sale Report', 'No Sale Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_POST_VOID', 'Post Void Report', 'Post Void Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_PRICE_CHANGE', 'Price Change Report', 'Price Change Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_PRICE_OVERRIDE', 'Price Override Report', 'Price Override Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_RECEIVING_EXCEPTION', 'Receiving Exception Report', 'Receiving Exception Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_RETURNED_MERCHANDISE', 'Returned Merchandise Report', 'Returned Merchandise Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_INVENTORY_STOCK_COST', 'Inventory Stock Cost Report', 'Inventory Stock Cost Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_RECEIVING_REPORT', 'Receiving Report', 'Receiving Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SALES_DEPT_EMPLOYEE', 'Sales By Department and Employee Report', 'Sales By Department and Employee Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SALES_DEPARTMENT', 'Sales By Department Report', 'Sales By Department Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SALES_HOUR_ANALYSIS', 'Sales By Hour Analysis Report', 'Sales By Hour Analysis Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SALES_HOUR', 'Sales By Hour Report', 'Sales By Hour Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SHIPPING_EXCEPTION', 'Shipping Exception Report', 'Shipping Exception Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SPECIAL_ORDERS', 'Special Orders Report', 'Special Orders Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_STORE_LOCATIONS', 'Store Locations Report', 'Store Locations Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_SUSPENDED_TRANS', 'Suspended Transaction Summary Report', 'Suspended Transaction Summary Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_TAX_EXEMPTION', 'Tax Exemption Report', 'Tax Exemption Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_TRANS_CANCEL', 'Transaction Cancel Detail Report', 'Transaction Cancel Detail Report');
--INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_WORST_SELLERS_ITEM', 'Worst Sellers By Item Report', 'Worst Sellers By Item Report');
--INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_WORST_SELLERS_STYLE', 'Worst Sellers By Style Report', 'Worst Sellers By Style Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_STOCK_VALUATION', 'Stock Valuation Reports', 'Stock Valuation Reports');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_STOCK_ROLLUP', 'Roll-up Stock Valuation Report', 'Roll-up Stock Valuation Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Reports', 'RPT_AIRSIDE_CSV', 'Airport Authority Report', 'Airport Authority Report');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'HOME_PAGE_CONFIG', 'Home Page Config Management Panel', 'Home Page Config Management Panel');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'HOME_PAGE_DATA', 'Home Page Data Management Panel', 'Home Page Data Management Panel');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'HOME_PAGE_DEPLOY', 'Home Page Deployment Panel', 'Home Page Deployment Panel');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'HOME_PAGE_SUPPORT', 'Home Page Support Panel', 'Home Page Support Panel');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'HOME_PAGE_REPORTS', 'Home Page Reports Panel', 'Home Page Reports Panel');
INSERT INTO cfg_privilege (category, privilege_id, privilege_desc, short_desc) VALUES ('Home Page', 'HOME_PAGE_SYSTEM', 'Home Page System Panel', 'Home Page System Panel');
COMMIT;


-- **************************************************** --
-- * Manual referential-integrity cleanup: keep the   * --
-- * cfg_role_privilege table consistent with the     * --
-- * actual list of privileges from cfg_privilege.    * --
-- * Always do this AFTER cfg_privileges are          * --
-- * (re)created!                                     * --
-- **************************************************** --
DELETE FROM cfg_role_privilege WHERE privilege_id NOT IN (SELECT privilege_id FROM cfg_privilege);
COMMIT;



-- CFG_MENU_CONFIG
DELETE FROM cfg_menu_config WHERE category = 'REDIRECT_MENU_ACTION';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REDIRECT_MENU_ACTION', 'CHANGE_PASSWORD', NULL, NULL, NULL, 'REDIRECT_ACTION', 10, '/changePassword.xhtml', NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REDIRECT_MENU_ACTION', 'INDEX', NULL, NULL, NULL, 'REDIRECT_ACTION', 10, '/index.xhtml', NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;



-- TOP LEVEL MENUS
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and (parent_menu_name IS NULL OR parent_menu_name = 'ROOT');
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'ELECTRONIC_JOURNAL', 'ROOT', 'ELECTRONIC_JOURNAL', '_menuJournal', 'LINK', 10, NULL, NULL, 1, 'join', NULL, NULL, NULL, '/xadmin/images/newlaf/menu-electronic-journal.png', 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'REPORTS_MENU', 'ROOT', null, '_reports', 'LINK', 20, NULL, NULL, 1, NULL, NULL, NULL, NULL, '/xadmin/images/newlaf/menu-reports.png', 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'CONFIGURATOR_MENU', 'ROOT', 'CONFIGURATOR', '_enterConfigurator', 'LINK', 30, NULL, NULL, 1, NULL, NULL, NULL, NULL, '/xadmin/images/newlaf/menu-config.png', 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'DATA_MANAGER_MENU', 'ROOT', 'DATA', '_enterDataManager', 'LINK', 40, NULL, NULL, 1, NULL, NULL, NULL, NULL, '/xadmin/images/newlaf/menu-data.png', 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'DEPLOY_MANAGER_MENU', 'ROOT', 'DEPLOY', '_enterDeployManager', 'LINK', 50, NULL, NULL, 1, NULL, NULL, NULL, NULL, '/xadmin/images/newlaf/menu-deployment.png', 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'SUPPORT_MENU', 'ROOT', 'SUPPORT', '_xstoreInformationSupport', 'LINK', 60, NULL, NULL, 1, 'join', NULL, NULL, NULL, '/xadmin/images/newlaf/menu-support.png', 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'XCENTER_ADMIN_MENU', 'ROOT', 'ADMIN', '_systemToolPanelTitle', 'LINK', 70, NULL, NULL, 1, 'join', NULL, NULL, NULL, '/xadmin/images/newlaf/menu-settings.png', 0);
COMMIT;



-- ELECTRONIC JOURNAL MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'ELECTRONIC_JOURNAL';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'EJ_SEARCH', 'ELECTRONIC_JOURNAL', 'ELECTRONIC_JOURNAL', '_menuEj', 'REDIRECT_ACTION', 20, '/eJournal/eJournal.xhtml', NULL, 1, 'join', 'SPT_EJOURNAL', NULL, NULL, NULL, 0);
COMMIT;



-- CONFIGURATION MANAGER MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'CONFIGURATOR_MENU';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'CONFIGURATOR2', 'CONFIGURATOR_MENU', NULL, '_configurator', 'REDIRECT_ACTION', 10, '/configurator/configurator.xhtml', NULL, 1, NULL, 'CFG_PROFILE_CONFIGURATION', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'PROFILE_MANAGEMENT', 'CONFIGURATOR_MENU', NULL, '_profileManagement', 'LINK', 30, '/configurator/profileManagement.xhtml', NULL, 1, NULL, 'CFG_PROFILE_MANAGEMENT', NULL, NULL, NULL, 0);
COMMIT;



-- CONFIGURATOR FEATURES
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'CODE';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'CODE', 'CONFIGURATOR2_FEATURE', 'ALL,PERSONALITY', '_codeConfig', 'LINK', 10, null, NULL, 1, NULL, 'CFG_CODE', NULL, NULL, '/xadmin/images/configurator/code.png', 0, '_codeConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name = 'DISCOUNT';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'DISCOUNT', 'CONFIGURATOR2_FEATURE', 'ALL,PERSONALITY', '_discountConfig', 'LINK', 20, null, NULL, 1, NULL, 'CFG_DISCOUNTS', NULL, NULL, '/xadmin/images/configurator/discount.png', 0, '_discountConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name in ('MENU_CONFIG','MENU');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, create_date, create_user_id, update_date, update_user_id, description)
  VALUES ('MAIN_MENU', 'MENU', 'CONFIGURATOR2_FEATURE', 'ALL,ALL', '_menuConfig', 'LINK', 30, NULL, NULL, 1, NULL, 'CFG_MENUS', NULL, NULL, '/xadmin/images/configurator/menu1.png', 0, NULL, NULL, NULL, NULL, '_menuConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name in ('REASONCODE_CONFIG','REASONCODE');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, create_date, create_user_id, update_date, update_user_id, description)
  VALUES ('MAIN_MENU', 'REASONCODE', 'CONFIGURATOR2_FEATURE', 'ALL,PERSONALITY', '_reasonCodeConfig', 'LINK', 40, '/configurator/reasoncode/reasonCodeConfig.xhtml', NULL, 1, NULL, 'CFG_REASON_CODE', NULL, NULL, '/xadmin/images/configurator/reasoncode.png', 0, NULL, NULL, NULL, NULL, '_reasonCodeDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name in ('RECEIPT_CONFIG','RECEIPT');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, create_date, create_user_id, update_date, update_user_id, description)
  VALUES ('MAIN_MENU', 'RECEIPT', 'CONFIGURATOR2_FEATURE', 'ALL,PERSONALITY', '_receiptConfig', 'LINK', 50, null, NULL, 1, NULL, 'CFG_RECEIPT_CONFIG', NULL, NULL, '/xadmin/images/configurator/receipt-64.png', 0, NULL, NULL, NULL, NULL, '_receiptConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'SECURITY';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'SECURITY', 'CONFIGURATOR2_FEATURE', 'MASTER,PERSONALITY', '_securityConfig', 'LINK', 60, NULL, NULL, 1, NULL, 'CFG_SECURITY_PERMISSION', NULL, NULL, '/xadmin/images/configurator/security.png', 0, '_securityConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name = 'SYSCONFIG';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'SYSCONFIG', 'CONFIGURATOR2_FEATURE', 'ALL,ALL', '_systemConfig', 'LINK', 70, NULL, NULL, 1, NULL, 'CFG_SYSCONFIG', NULL, NULL, '/xadmin/images/configurator/systemconfig.png', 0, '_systemConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name in ('TENDER_CONFIG', 'TENDER');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'TENDER', 'CONFIGURATOR2_FEATURE', 'ALL,PERSONALITY', '_tenderConfig', 'LINK', 80, NULL, NULL, 1, NULL, 'CFG_TENDER_OPTION', NULL, NULL, '/xadmin/images/configurator/tender.png', 0, '_tenderConfigDesc');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' AND menu_name = 'CUSTDISPLAY';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'CUSTDISPLAY', 'CONFIGURATOR2_FEATURE', 'ALL,PERSONALITY', '_custDisplayConfig', 'LINK', 90, null, NULL, 1, NULL, 'CFG_CUSTDISPLAYS', NULL, NULL, '/xadmin/images/configurator/custdisplay.png', 0, '_custDisplayConfigDesc');
COMMIT;



-- DATA MANAGER MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'DATA_MANAGER_MENU';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'DATA_MANAGER', 'DATA_MANAGER_MENU', NULL, '_dataManager', 'REDIRECT_ACTION', 5, '/datamanager.xhtml', NULL, 1, NULL, 'CFG_EDIT_SESSION', NULL, NULL, NULL, 0);

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'ORG_HIERARCHY';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'ORG_HIERARCHY', 'DATA_MANAGER_MENU', NULL, '_orgHierarchy', 'REDIRECT_ACTION', 10, '/orgHierarchy.xhtml', NULL, 1, NULL, 'CFG_ORGANIZATION_HIERARCHY', NULL, NULL, NULL, 0);

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'YEAREND_PROCESS';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'YEAREND_PROCESS', 'DATA_MANAGER_MENU', NULL, '_yearEndRollUpMenuTitle', 'REDIRECT_ACTION', 20, NULL, '/reports/yearEndRollUp.xhtml', 1, NULL, 'RPT_STOCK_ROLLUP', NULL, NULL, NULL, 0);
COMMIT;


-- "New" DATA MANAGER FEATURES
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'COMMUNICATIONS';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'COMMUNICATIONS', 'DATA_MANAGER2_FEATURE', 'COMMUNICATIONS', '_communicationsConfigFeatureTitle', 'LINK', 10, NULL, NULL, 1, NULL, 'CFG_COMMUNICATIONS', '/xadmin/images/datamanager/CommIcon_64x64.png', 0, '_communicationsMaintDesc');

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'CURRENCY_EXCHANGE';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'CURRENCY_EXCHANGE', 'DATA_MANAGER2_FEATURE', 'CURRENCY_EXCHANGE', '_currencyExchangeConfigFeatureTitle', 'LINK', 20, NULL, NULL, 1, NULL, 'CFG_CURRENCY_EXCHANGE', '/xadmin/images/datamanager/CurrencyExchange6464.png', 0, '_currencyExchangeMaintDesc');

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'EMPLOYEE';
COMMIT;

INSERT INTO cfg_menu_config(category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description, create_date, create_user_id, update_date, update_user_id)
  VALUES ('MAIN_MENU', 'EMPLOYEE', 'DATA_MANAGER2_FEATURE', 'EMPLOYEE', '_employeeConfig', 'LINK', 30, NULL, NULL, 1, NULL, 'CFG_EMPLOYEE', NULL, NULL, '/xadmin/images/datamanager/employees6464.png', 0, '_employeeMaintDesc', NULL, NULL, NULL, NULL);

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'ITEM';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'ITEM', 'DATA_MANAGER2_FEATURE', 'ITEM', '_itemConfigFeatureTitle', 'LINK', 40, NULL, NULL, 1, NULL, 'CFG_ITEM', '/xadmin/images/datamanager/items6464.png', 0, '_itemMaintDesc');

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'STORES';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'STORES', 'DATA_MANAGER2_FEATURE', 'STORES', '_retailLocationConfig', 'LINK', 50, NULL, NULL, 1, NULL, 'CFG_STORES', '/xadmin/images/datamanager/Stores6464.png', 0, '_storesMaintDesc');

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'TAXES';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'TAXES', 'DATA_MANAGER2_FEATURE', 'TAXES', '_taxesConfigFeatureTitle', 'LINK', 60, NULL, NULL, 1, NULL, 'CFG_TAXES', '/xadmin/images/datamanager/Taxes6464.png', 0, '_taxesMaintDesc');

DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'VENDOR';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'VENDOR', 'DATA_MANAGER2_FEATURE', 'VENDOR', '_vendorConfigFeatureTitle', 'LINK', 70, NULL, NULL, 1, NULL, 'CFG_VENDOR', '/xadmin/images/datamanager/VendorIcon6464.png', 0, '_vendorMaintDesc');


-- "Old" DATA MANAGER FEATURES
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'DATA_MANAGER_FEATURE';
COMMIT;



-- DATA MANAGER SECURITY SUB MENUS
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'SECURITY_CONFIG';
COMMIT;



-- DATA MANAGER TAX SUB MENUS
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'TAX_CONFIG';
COMMIT;



-- DATA MANAGER TENDER SUB MENUS
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'TENDER_CONFIG';
COMMIT;



-- DEPLOYMENT MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'DEPLOY_MANAGER_MENU';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'FILE_UPLOAD', 'DEPLOY_MANAGER_MENU', NULL, '_fileupload', 'LINK', 10, '/deployment/fileupload.xhtml', NULL, 1, NULL, 'SPT_FILE_UPLOAD', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'DEPLOYMENT_VIEWER', 'DEPLOY_MANAGER_MENU', NULL, '_deploymentViewerMenu', 'LINK', 20, '/deployment/deploymentViewer.xhtml', NULL, 1, NULL, 'SPT_DEPLOYMENT_VIEWER', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'VIEW_ONLY_DEPLOYMENT_PLAN', 'DEPLOY_MANAGER_MENU', NULL, '_deploymentPlanMenu', 'LINK', 30, '/deployment/deploymentPlan.xhtml', NULL, 1, NULL, 'VIEW_ONLY_DEPLOYMENT_PLAN', NULL, NULL, NULL, 0);


-- SUPPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'SUPPORT_MENU';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'SUPPORT_DASHBOARD', 'SUPPORT_MENU', NULL, '_supportDashboard', 'LINK', 10, '/support/dashboard.xhtml', NULL, 1, NULL, 'SPT_VIEW_SUPPORT_DASHBOARD', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'SUPPORT_DASHBOARD_SETTINGS', 'SUPPORT_MENU', NULL, '_supportDashboardSettings', 'LINK', 20, '/support/settings.xhtml', NULL, 1, NULL, 'SPT_SUPPORT_SETTINGS', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'VERSION_INFO', 'SUPPORT_MENU', NULL, '_versioninfo', 'LINK', 30, '/support/versioninfo.xhtml', NULL, 1, NULL, 'SPT_VERSIONINFO_DASHBOARD', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'POSLOG_BUILDER', 'SUPPORT_MENU', NULL, '_posLogPublisherMenu', 'LINK', 40, '/support/poslog/posLogPublisher.xhtml', NULL, 1, NULL, 'SPT_POSLOG_BUILDER', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'REPL_VIEWER', 'SUPPORT_MENU', NULL, '_replViewerMenu', 'LINK', 50, '/support/replication/replicationViewer.xhtml', NULL, 1, NULL, 'SPT_REPL_VIEWER', NULL, NULL, NULL, 0);


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'PROFILE_CONFIG';
COMMIT;


-- SYSTEM UTILS MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'XCENTER_ADMIN_MENU';
COMMIT;


-- The option for the new administration landing page
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'ADMINISTRATION';
COMMIT;


-- The individual administration menu options
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'XADMIN_SETTINGS';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'XADMIN_SETTINGS', 'XCENTER_ADMIN_MENU', NULL, '_adminConfigFeatureShortTitle', 'LINK', 10, null, NULL, 1, NULL, 'XADMIN_SETTINGS', NULL, NULL, NULL, 0, null);
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'XADMIN_USERS';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'XADMIN_USERS', 'XCENTER_ADMIN_MENU', NULL, '_adminUserFeatureShortTitle', 'LINK', 20, null, NULL, 1, NULL, 'XADMIN_USERS', NULL, NULL, NULL, 0, null);
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'AVAILABLE_LOCALE';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'AVAILABLE_LOCALE', 'XCENTER_ADMIN_MENU', NULL, '_availableLocaleFeatureTitle', 'LINK', 30, NULL, NULL, 1, NULL, 'ADMN_AVAILABLE_LOCALES', NULL, NULL, NULL, 0, null);
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'USER_GUIDE';
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'VERSION';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'VERSION', 'XCENTER_ADMIN_MENU', NULL, '_versionFeatureTitle', 'LINK', 50, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0, null);
COMMIT;



-- REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and parent_menu_name = 'REPORTS_MENU';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('MAIN_MENU', 'REPORT_VIEWER', 'REPORTS_MENU', null, '_startReports', 'ACTION', 20, NULL, NULL, 1, NULL, 'RPT_GENERAL_ACCESS', NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('MAIN_MENU', 'REPORT_VIEWER|FLASH_SALES_REPORT', 'REPORTS_MENU', null, '_rptFlashSalesReportTitle', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''FLASH_SALES_REPORT'')}', 1, NULL, 'RPT_FLASH_SALES', NULL, NULL, NULL, 0, '_rptDescFlashSales');
COMMIT;


-- Report groups that are accessed from within the report viewer
-- Old place of storing in-feature report options
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and config_type = 'REPORTS';
COMMIT;

-- New place of storing in-feature report options
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name = 'ROOT';
-- Delete this menu first since it moved from its original location (Misc Reports) to here
DELETE FROM cfg_menu_config WHERE category = 'MAIN_MENU' and menu_name = 'STOCK_VALUATION_GROUP';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'FLASH_SALES_GROUP', 'ROOT', 'REPORTS', '_menutextFlashSalesReports', 10, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'SALES_GROUP', 'ROOT', 'REPORTS', '_menuTextSalesReport', 20, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'TRANSACTION_AUDIT_GROUP', 'ROOT', 'REPORTS', '_menuTextTransAuditReport', 30, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'INVENTORY_GROUP', 'ROOT', 'REPORTS', '_menuTextInventoryException', 40, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'SCHEDULE_GROUP', 'ROOT', 'REPORTS', '_menutextEmpSchedRep', 50, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'LAYAWAY_GROUP', 'ROOT', 'REPORTS', '_menutextLayawayReports', 60, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'MISC_GROUP', 'ROOT', 'REPORTS', '_menutextMiscReports', 70, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'STOCK_VALUATION_GROUP', 'ROOT', 'REPORTS', '_rptStockValReport', 80, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator)
  VALUES ('REPORT_VIEWER_MENU', 'AIRSIDE_GROUP', 'ROOT', 'REPORTS', '_rptAirsideReports', 90, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;



-- FLASH SALES REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name = 'FLASH_SALES_GROUP';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'FLASH_SALES_REPORT', 'FLASH_SALES_GROUP', 'REPORTS', '_rptFlashSalesReportMenu', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''FLASH_SALES_REPORT'')}', 1, NULL, 'RPT_FLASH_SALES', NULL, NULL, NULL, 0, '_rptDescFlashSales');
COMMIT;



-- SALES REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('SALES_GROUP', 'SALES_REPORTS');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'DAILY_SALES_CASH_REPORT', 'SALES_GROUP', 'REPORTS', '_rptDailySalesCashReportTitleMenu', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''DAILY_SALES_CASH_REPORT'')}', 1, NULL, 'RPT_DAILY_SALES_CASH', NULL, NULL, NULL, 0, '_rptDescDailySalesCash');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'SALES_BY_HOUR_REPORT', 'SALES_GROUP', 'REPORTS', '_rptSalesByHourReportSalesByHour', 'ACTION', 20, NULL, '@{reportLoadAction.execute(''SALES_BY_HOUR_REPORT'')}', 1, NULL, 'RPT_SALES_HOUR', NULL, NULL, NULL, 0, '_rptDescSalesHour');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'SALES_BY_HOUR_ANALYSIS_REPORT', 'SALES_GROUP', 'REPORTS', '_rptSaleByHourAnalysisTitleMenu', 'ACTION', 30, NULL, '@{reportLoadAction.execute(''SALES_BY_HOUR_ANALYSIS_REPORT'')}', 1, NULL, 'RPT_SALES_HOUR_ANALYSIS', NULL, NULL, NULL, 0, '_rptDescSalesHourAnalysis');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'SALES_BY_MERCHLVL1_REPORT', 'SALES_GROUP', 'REPORTS', '_rptSaleByMerchLevel1TitleMenu', 'ACTION', 40, NULL, '@{reportLoadAction.execute(''SALES_BY_MERCHLVL1_REPORT'')}', 1, NULL, 'RPT_SALES_DEPARTMENT', NULL, NULL, NULL, 0, '_rptDescSalesDept');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'RETURN_MERCHANDISE_REPORT', 'SALES_GROUP', 'REPORTS', '_rptReturnMerchandiseReportMenu', 'ACTION', 60, NULL, '@{reportLoadAction.execute(''RETURN_MERCHANDISE_REPORT'')}', 1, NULL, 'RPT_RETURNED_MERCHANDISE', NULL, NULL, NULL, 0, '_rptDescReturnMerchLog');
--INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
--  VALUES ('REPORT_VIEWER_MENU', 'SALES_BY_EMPLOYEE', 'SALES_GROUP', 'REPORTS', '_rptSalesByEmployeeReportTitleMenu', 'ACTION', 70, NULL, '@{reportLoadAction.execute(''SALES_BY_EMPLOYEE'')}', 1, NULL, 'RPT_DAILY_SALES', NULL, NULL, NULL, 0, '_rptDescSalesEmployee');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'BEST_SELLERS_REPORT', 'SALES_GROUP', 'REPORTS', '_rptBestSellersMenu', 'ACTION', 80, NULL, '@{reportLoadAction.execute(''BEST_SELLERS_BY_STYLE_REPORT'')}', 1, NULL, 'RPT_BEST_SELLERS', NULL, NULL, NULL, 0, '_rptDescBestSellers');
--INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
--  VALUES ('REPORT_VIEWER_MENU', 'WORST_SELLERS_BY_STYLE_REPORT', 'SALES_GROUP', 'REPORTS', '_rptWorstSellersByStyleTitle', 'ACTION', 100, NULL, '@{reportLoadAction.execute(''WORST_SELLERS_BY_STYLE_REPORT'')}', 1, NULL, 'RPT_WORST_SELLERS_STYLE', NULL, NULL, NULL, 0, '_rptDescWorstSellersStyle');
--INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
--  VALUES ('REPORT_VIEWER_MENU', 'WORST_SELLERS_BY_ITEM_REPORT', 'SALES_GROUP', 'REPORTS', '_rptWorstSellersByItemTitle', 'ACTION', 110, NULL, '@{reportLoadAction.execute(''WORST_SELLERS_BY_ITEM_REPORT'')}', 1, NULL, 'RPT_WORST_SELLERS_ITEM', NULL, NULL, NULL, 0, '_rptDescWorstSellersItem');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'CREDIT_CARD_REPORT', 'SALES_GROUP', 'REPORTS', '_rptCreditCardTitleMenu', 'ACTION', 120, NULL, '@{reportLoadAction.execute(''CREDIT_CARD_REPORT'')}', 1, NULL, 'RPT_CREDIT_CARD', NULL, NULL, NULL, 0, '_rptDescCreditCard');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'DAILY_SALES_REPORT', 'SALES_GROUP', 'REPORTS', '_rptDailySalesReportTitleMenu', 'ACTION', 130, NULL, '@{reportLoadAction.execute(''DAILY_SALES_REPORT'')}', 1, NULL, 'RPT_DAILY_SALES_TOTAL', NULL, NULL, NULL, 0, '_rptDescDailySalesTotal');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name = 'TRANSACTION_AUDIT_GROUP';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'NO_SALE_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptNoSaleTitleMenu', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''NO_SALE_REPORT'')}', 1, NULL, 'RPT_NO_SALE', NULL, NULL, NULL, 0, '_rptDescNoSale');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'PRICE_OVERRIDE_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptPriceOverrideTitleMenu', 'ACTION', 20, NULL, '@{reportLoadAction.execute(''PRICE_OVERRIDE_REPORT'')}', 1, NULL, 'RPT_PRICE_OVERRIDE', NULL, NULL, NULL, 0, '_rptDescPriceOverride');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'LINE_VOID_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptLineVoidTitleMenu', 'ACTION', 30, NULL, '@{reportLoadAction.execute(''LINE_VOID_REPORT'')}', 1, NULL, 'RPT_LINE_VOID', NULL, NULL, NULL, 0, '_rptDescLineVoid');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'POST_VOID_TRANSACTION_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptPostVoidTransactionMenu', 'ACTION', 40, NULL, '@{reportLoadAction.execute(''POST_VOID_REPORT'')}', 1, NULL, 'RPT_POST_VOID', NULL, NULL, NULL, 0, '_rptDescPostVoid');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'SUSPENDED_TRANSACTION_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptSuspendedTransactionReportTitleMenu', 'ACTION', 50, NULL, '@{reportLoadAction.execute(''SUSPENDED_TRANSACTION_REPORT'')}', 1, NULL, 'RPT_SUSPENDED_TRANS', NULL, NULL, NULL, 0, '_rptDescSuspendedTransSummary');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'CANCELLED_TRANSACTION_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptCancelledTransactionTitleMenu', 'ACTION', 60, NULL, '@{reportLoadAction.execute(''CANCELLED_TRANSACTION_REPORT'')}', 1, NULL, 'RPT_TRANS_CANCEL', NULL, NULL, NULL, 0, '_rptDescTransactionVoidSummary');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'GIFT_CERTIFICATE_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptGiftCertificateTitleMenu', 'ACTION', 70, NULL, '@{reportLoadAction.execute(''GIFT_CERTIFICATE_REPORT'')}', 1, NULL, 'RPT_GIFT_CERTIFICATE', NULL, NULL, NULL, 0, '_rptDescGiftCertificate');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'TAX_EXEMPTION_REPORT', 'TRANSACTION_AUDIT_GROUP', 'REPORTS', '_rptTaxExemptionReportTitleMenu', 'ACTION', 80, NULL, '@{reportLoadAction.execute(''TAX_EXEMPTION_REPORT'')}', 1, NULL, 'RPT_TAX_EXEMPTION', NULL, NULL, NULL, 0, '_rptDescTaxExemption');
COMMIT;



-- INVENTORY REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('INVENTORY_GROUP', 'INVENTORY_EXCEPTION');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'INVENTORY_SHIPPING_EXCEPTION_REPORT', 'INVENTORY_GROUP', 'REPORTS', '_rptInventoryExceptionShipTitle', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''INVENTORY_SHIPPING_EXCEPTION_REPORT'')}', 1, NULL, 'RPT_SHIPPING_EXCEPTION', NULL, NULL, NULL, 0, '_rptDescInventoryShip');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'INVENTORY_RECEIVING_EXCEPTION_REPORT', 'INVENTORY_GROUP', 'REPORTS', '_rptInventoryExceptionRecTitle', 'ACTION', 20, NULL, '@{reportLoadAction.execute(''INVENTORY_RECEIVING_EXCEPTION_REPORT'')}', 1, NULL, 'RPT_RECEIVING_EXCEPTION', NULL, NULL, NULL, 0, '_rptDescInventoryRecv');
--INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
--  VALUES ('REPORT_VIEWER_MENU', 'RESTOCK_REPORT', 'INVENTORY_GROUP', 'REPORTS', '_rpReStockReportTitleMenu', 'ACTION', 30, NULL, '@{reportLoadAction.execute("RESTOCK_REPORT")}', 0, NULL, NULL, NULL, NULL, NULL, 0, '_rptDescRestock');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'INVENTORY_STOCK_COST_REPORT', 'INVENTORY_GROUP', 'REPORTS', '_rptInventoryStockCostTitleMenu', 'ACTION', 40, NULL, '@{reportLoadAction.execute(''INVENTORY_STOCK_COST_REPORT'')}', 1, NULL, 'RPT_INVENTORY_STOCK_COST', NULL, NULL, NULL, 0, '_rptDescInventoryStockCost');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'RECEIVING_REPORT', 'INVENTORY_GROUP', 'REPORTS', '_rptReceivingReportTitle', 'ACTION', 50, NULL, '@{reportLoadAction.execute(''RECEIVING_REPORT'')}', 1, NULL, 'RPT_RECEIVING_REPORT', NULL, NULL, NULL, 0, '_rptDescReceiving');
COMMIT;



-- EMPLOYEE REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('SCHEDULE_GROUP', 'SCHEDULE_REPORTS');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
VALUES ('REPORT_VIEWER_MENU', 'EMPLOYEE_PERFORMANCE_REPORT', 'SCHEDULE_GROUP', 'REPORTS', '_menutextRepEmpPerf', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''EMPLOYEE_PERFORMANCE_REPORT'')}', 1, NULL, 'RPT_EMPLOYEE_PERFORMANCE', NULL, NULL, NULL, 0, '_rptDescEmployeePerformance');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'SCHEDULE_DETAIL_REPORT', 'SCHEDULE_GROUP', 'REPORTS', '_menutextRepSchedDet', 'ACTION', 20, NULL, '@{reportLoadAction.execute("SCHEDULE_DETAIL_REPORT")}', 0, NULL, NULL, NULL, NULL, NULL, 0, '_rptDescEmpScheduleDetail');
COMMIT;



-- LAYAWAY REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('LAYAWAY_GROUP', 'LAYAWAY_REPORTS');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'LAYAWAY_AGING_REPORT', 'LAYAWAY_GROUP', 'REPORTS', '_rptLayawayAgingMenu', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''LAYAWAY_AGING_REPORT'')}', 1, NULL, 'RPT_LAYAWAY_AGING', NULL, NULL, NULL, 0, '_rptLayawayAgingTitle');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)  
  VALUES ('REPORT_VIEWER_MENU', 'LAYAWAY_ACCOUNT_ACTIVITY_REPORT', 'LAYAWAY_GROUP', 'REPORTS', '_rptLayawayAccountActivityMenu', 'ACTION', 30, NULL, '@{reportLoadAction.execute(''LAYAWAY_ACCOUNT_ACTIVITY_REPORT'')}', 1, NULL, 'RPT_LAYAWAY_ACCT_ACTIVITY', NULL, NULL, NULL, 0, '_rptLayawayAccountActivityTitle');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'CONFIGURABLE_CUST_ACCT_ACTIVITY_SUMMARY_REPORT', 'LAYAWAY_GROUP', 'REPORTS', '_menutextConfigurableCustAccountActivtySummaryReport', 'ACTION', 10, NULL, '@{reportLoadAction.execute("CONFIGURABLE_CUST_ACCT_ACTIVITY_SUMMARY_REPORT")}', 1, NULL, 'RPT_CCA_ACTIVITY_SUMMARY', NULL, NULL, NULL, 0, '_rptDescCcaActivitySummary');
COMMIT;



-- MISC REPORT MENU
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('MISC_GROUP', 'MISC_REPORTS');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'JOURNAL_ROLL_REPORT', 'MISC_GROUP', 'REPORTS', '_rptJournalRollReport', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''JOURNAL_ROLL_REPORT'')}', 1, NULL, 'RPT_JOURNAL', NULL, NULL, NULL, 0, '_rptDescJournalRoll');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'STORE_LOCATIONS_REPORT', 'MISC_GROUP', 'REPORTS', '_rptStoreLocationsReport', 'ACTION', 20, NULL, '@{reportLoadAction.execute(''STORE_LOCATIONS_REPORT'')}', 1, NULL, 'RPT_STORE_LOCATIONS', NULL, NULL, NULL, 0, '_rptDescStoreLocations');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'CUSTOMER_LIST_REPORT', 'MISC_GROUP', 'REPORTS', '_menutextCustList', 'ACTION', 30, NULL, '@{reportLoadAction.execute(''CUSTOMER_LIST_REPORT'')}', 1, NULL, 'RPT_CUSTOMER_LIST', NULL, NULL, NULL, 0, '_rptDescCustomerList');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'SPECIAL_ORDERS_REPORT', 'MISC_GROUP', 'REPORTS', '_menutextSpecialOrdersReports', 'ACTION', 40, NULL, '@{reportLoadAction.execute(''SPECIAL_ORDERS_REPORTS'')}', 1, NULL, 'RPT_SPECIAL_ORDERS', NULL, NULL, NULL, 0, '_rptDescSpecialOrders');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'PRICE_CHANGE_REPORT', 'MISC_GROUP', 'REPORTS', '_menutextPriceChangeReport', 'ACTION', 50, NULL, '@{reportLoadAction.execute(''PRICE_CHANGE_REPORT'')}', 1, NULL, 'RPT_PRICE_CHANGE', NULL, NULL, NULL, 0, '_rptDescPriceChange');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
 VALUES ('REPORT_VIEWER_MENU', 'ITEM_LIST_REPORT', 'MISC_GROUP', 'REPORTS', '_rptItemListTitle', 'ACTION', 70, NULL, '@{reportLoadAction.execute(''ITEM_LIST_REPORT'')}', 1, NULL, 'RPT_ITEM_LIST', NULL, NULL, NULL, 0, '_rptDescItemList');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'EMPLOYEE_TASKS_REPORT', 'MISC_GROUP', 'REPORTS', '_rptEmployeeTasksReport', 'ACTION', 80, NULL, '@{reportLoadAction.execute(''EMPLOYEE_TASKS_REPORT'')}', 1, NULL, 'RPT_EMP_TASKS', NULL, NULL, NULL, 0, '_rptDescEmployeeTasks');
COMMIT;


-- STOCK VALUATION REPORTS
-- WAC Reports
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('WAC_REPORTS_GROUP', 'WAC_REPORTS');
COMMIT;

-- PWAC Reports
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('PWAC_REPORTS_GROUP', 'PWAC_REPORTS');
COMMIT;

-- FIFO Reports
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('FIFO_REPORTS_GROUP', 'FIFO_REPORTS');
COMMIT;


DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name IN ('STOCK_VALUATION_GROUP', 'STOCK_VALUATION_REPORT');
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'WAC_STOCK_VALUATION_REPORT', 'STOCK_VALUATION_GROUP', 'REPORTS', '_rptWacStockValReportTitleMenu', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''WAC_STOCK_VALUATION_REPORT'')}', 1, NULL, 'RPT_STOCK_VALUATION', NULL, NULL, NULL, 0, '_rptDescWacStockValuation');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'WAC_DETAIL_STOCK_VALUATION_REPORT', 'STOCK_VALUATION_GROUP', 'REPORTS', '_rptWacDetailReportTitleMenu', 'ACTION', 20, NULL, '@{reportLoadAction.execute(''WAC_DETAIL_STOCK_VALUATION_REPORT'')}', 1, NULL, 'RPT_STOCK_VALUATION', NULL, NULL, NULL, 0, '_rptDescWacStockValuationDetail');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'PWAC_STOCK_VALUATION_REPORT', 'STOCK_VALUATION_GROUP', 'REPORTS', '_rptPwacStockValReportTitleMenu', 'ACTION', 30, NULL, '@{reportLoadAction.execute(''PWAC_STOCK_VALUATION_REPORT'')}', 1, NULL, 'RPT_STOCK_VALUATION', NULL, NULL, NULL, 0, '_rptDescPwacStockValuation');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'PWAC_DETAIL_STOCK_VALUATION_REPORT', 'STOCK_VALUATION_GROUP', 'REPORTS', '_rptPwacDetailReportTitleMenu', 'ACTION', 40, NULL, '@{reportLoadAction.execute(''PWAC_DETAIL_STOCK_VALUATION_REPORT'')}', 1, NULL, 'RPT_STOCK_VALUATION', NULL, NULL, NULL, 0, '_rptDescPwacStockValuationDetail');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'FIFO_STOCK_VALUATION_REPORT', 'STOCK_VALUATION_GROUP', 'REPORTS', '_rptFifoStockValReportTitleMenu', 'ACTION', 50, NULL, '@{reportLoadAction.execute(''FIFO_STOCK_VALUATION_REPORT'')}', 0, NULL, 'RPT_STOCK_VALUATION', NULL, NULL, NULL, 0, '_rptDescFifoSummary');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'FIFO_DETAIL_STOCK_VALUATION_REPORT', 'STOCK_VALUATION_GROUP', 'REPORTS', '_rptFifoDetailReportTitleMenu', 'ACTION', 60, NULL, '@{reportLoadAction.execute(''FIFO_DETAIL_STOCK_VALUATION_REPORT'')}', 0, NULL, 'RPT_STOCK_VALUATION', NULL, NULL, NULL, 0, '_rptDescFifoDetail');
COMMIT;


-- Airside Reports
DELETE FROM cfg_menu_config WHERE category = 'REPORT_VIEWER_MENU' and parent_menu_name = 'AIRSIDE_GROUP';
COMMIT;

INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, config_type, title, menu_type, sort_order, view_id, action_expression, active_flag, propagation, security_privilege, custom_datasource_class, custom_datasource_method, menu_small_icon, menu_separator, description)
  VALUES ('REPORT_VIEWER_MENU', 'AIRSIDE_CSV_REPORT', 'AIRSIDE_GROUP', 'REPORTS', '_rptAirsideCsvReportTitle', 'ACTION', 10, NULL, '@{reportLoadAction.execute(''AIRSIDE_CSV_REPORT'')}', 1, NULL, 'RPT_AIRSIDE_CSV', NULL, NULL, NULL, 0, '_rptDescAirsideCsv');
COMMIT;


-- **********************************************************************************************************
-- Home Page Menu options
-- **********************************************************************************************************
-- Home page menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'ROOT';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'CONFIG_OPTIONS', 'ROOT', '_homePageOptionTitleConfig', 10, 1, 'HOME_PAGE_CONFIG', '/xadmin/images/newlaf/icon-config-db.png');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'DATA_OPTIONS', 'ROOT', '_enterDataManager', 20, 1, 'HOME_PAGE_DATA', '/xadmin/images/newlaf/icon-data-db.png');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'DEPLOY_OPTIONS', 'ROOT', '_homePageOptionTitleDeploy', 30, 1, 'HOME_PAGE_DEPLOY', '/xadmin/images/newlaf/icon-deploy-db.png');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'SUPPORT_OPTIONS', 'ROOT', '_xstoreInformationSupport', 40, 1, 'HOME_PAGE_SUPPORT', '/xadmin/images/newlaf/icon-support-db.png');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'REPORT_OPTIONS', 'ROOT', '_reports', 50, 1, 'HOME_PAGE_REPORTS', '/xadmin/images/newlaf/icon-reports-db.png');
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'SYSTEM_OPTIONS', 'ROOT', '_homePageOptionTitleSystem', 60, 1, 'HOME_PAGE_SYSTEM', '/xadmin/images/newlaf/icon-system-db.png');
COMMIT;


-- Config options home menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'CONFIG_OPTIONS';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'CONFIGURATOR2', 'CONFIG_OPTIONS', '_configurator', 10, 1,'CFG_PROFILE_CONFIGURATION', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'PROFILE_MANAGEMENT', 'CONFIG_OPTIONS', '_profileManagement', 20, 1, 'CFG_PROFILE_MANAGEMENT', null);
COMMIT;


-- Data options home menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'DATA_OPTIONS';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'DATA_MANAGER', 'DATA_OPTIONS', '_dataManager', 10, 1, 'CFG_EDIT_SESSION', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'ORG_HIERARCHY', 'DATA_OPTIONS', '_orgHierarchy', 20, 1, 'CFG_ORGANIZATION_HIERARCHY', null);
COMMIT;


-- Deployment options home menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'DEPLOY_OPTIONS';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'FILE_UPLOAD', 'DEPLOY_OPTIONS', '_fileupload', 10, 1, 'SPT_FILE_UPLOAD', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'DEPLOYMENT_VIEWER', 'DEPLOY_OPTIONS', '_deploymentViewerMenu', 20, 1, 'SPT_DEPLOYMENT_VIEWER', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'VIEW_ONLY_DEPLOYMENT_PLAN', 'DEPLOY_OPTIONS', '_deploymentPlanMenu', 30, 1, 'VIEW_ONLY_DEPLOYMENT_PLAN', null);
COMMIT;


-- Support options home menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'SUPPORT_OPTIONS';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'SUPPORT_DASHBOARD', 'SUPPORT_OPTIONS', '_supportDashboard', 10, 1, 'SPT_VIEW_SUPPORT_DASHBOARD', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'VERSION_INFO', 'SUPPORT_OPTIONS', '_versioninfo', 20, 1, 'SPT_VERSIONINFO_DASHBOARD', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'POSLOG_BUILDER', 'SUPPORT_OPTIONS', '_posLogPublisherMenu', 30, 1, 'SPT_POSLOG_BUILDER', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'REPL_VIEWER', 'SUPPORT_OPTIONS', '_replViewerMenu', 40, 1, 'SPT_REPL_VIEWER', null);
COMMIT;


-- Report options home menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'REPORT_OPTIONS';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'EJ_SEARCH', 'REPORT_OPTIONS', '_menuEj', 10, 1, 'SPT_EJOURNAL', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'REPORT_VIEWER|FLASH_SALES', 'REPORT_OPTIONS', '_rptFlashSalesReportTitle', 20, 1, 'RPT_FLASH_SALES', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'REPORT_VIEWER|DAILY_SALES_CASH_REPORT', 'REPORT_OPTIONS', '_rptDailySalesCashReportTitle', 30, 1, 'RPT_DAILY_SALES_CASH', null);
COMMIT;


-- System options home menu
DELETE FROM cfg_menu_config WHERE category = 'HOME_PAGE_MENU' and parent_menu_name = 'SYSTEM_OPTIONS';
COMMIT;


INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'XADMIN_SETTINGS', 'SYSTEM_OPTIONS', '_adminConfigFeatureShortTitle', 10, 1, 'XADMIN_SETTINGS', null);
INSERT INTO cfg_menu_config (category, menu_name, parent_menu_name, title, sort_order, active_flag, security_privilege, menu_small_icon)
  VALUES ('HOME_PAGE_MENU', 'XADMIN_USERS', 'SYSTEM_OPTIONS', '_adminUserFeatureShortTitle', 20, 1, 'XADMIN_USERS', null);
COMMIT;

-- **********************************************************************************************************
-- (End) Home Page Menu options
-- **********************************************************************************************************



-- CFG_CODE_VALUE
DELETE FROM cfg_code_value WHERE category = 'VISIBILITY_RULE';
COMMIT;


DELETE FROM cfg_code_value WHERE category = 'SYSTEM_CONFIG';
COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_code_value WHERE category = 'AVAILABLE_LOCALE' AND sub_category = 'DEFAULT';
IF v_exists = 0 THEN 

INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'AVAILABLE_LOCALE', 'DEFAULT', 'en_US', 'DEFAULT', 'US English', 10, NULL, NULL, NULL);
end if;
end;
/


COMMIT;


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_code_value WHERE category = 'CONFIG_PATH' AND sub_category = 'DEFAULT';
IF v_exists = 0 THEN 

INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'CONFIG_PATH', 'DEFAULT', '/version1', 'DEFAULT', 'cust', 10, NULL, NULL, NULL);
end if;
end;
/


COMMIT;


DELETE FROM cfg_code_value WHERE category = 'CONFIG_PATH_GROUP' AND sub_category = 'DEFAULT';
COMMIT;



-- Configuration settings
DELETE FROM cfg_code_value WHERE category = 'ConfiguratorConfig' AND sub_category = 'DEFAULT';
COMMIT;

-- Config settings now live in the cfg_system_setting table

-- Deployment configurations
DELETE FROM cfg_code_value WHERE category = 'ConfiguratorConfig' AND sub_category = 'DEPLOYMENT';
COMMIT;

-- Deployment Config settings now live in the cfg_system_setting table

-- SECURITY SETTINGS
-- Password validation rules
DELETE FROM cfg_code_value WHERE category = 'ConfiguratorConfig' AND sub_category = 'Password';
COMMIT;

-- Config settings now live in the cfg_system_setting table

-- Xadmin Configuration - User accounts
DELETE FROM cfg_code_value WHERE category = 'ConfiguratorConfig' AND sub_category = 'ACCOUNT';
COMMIT;

-- Config settings now live in the cfg_system_setting table

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'CODE_CATEGORY';
COMMIT;

-- Code categories are defined in the cfg_code_category table


DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'AUTH_METHOD_CODE';
COMMIT;

INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_AMERICAN_EXPRESS', 'DEFAULT', '_AJB_AMERICAN_EXPRESS', 10, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_CHECK', 'DEFAULT', '_AJB_CHECK', 20, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_DEBIT', 'DEFAULT', '_AJB_DEBIT', 30, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_DINERS_CLUB', 'DEFAULT', '_AJB_DINERS_CLUB', 40, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_DISCOVER', 'DEFAULT', '_AJB_DISCOVER', 50, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_GIFT_CARD', 'DEFAULT', '_AJB_GIFT_CARD', 60, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_JCB', 'DEFAULT', '_AJB_JCB', 70, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_MASTERCARD', 'DEFAULT', '_AJB_MASTERCARD', 80, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_PRIVATE_CREDIT', 'DEFAULT', '_AJB_PRIVATE_CREDIT', 100, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'AJB_VISA', 'DEFAULT', '_AJB_VISA', 110, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'MANUAL', 'DEFAULT', '_MANUAL', 120, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'OPERA_ROOM_CHARGE', 'DEFAULT', '_OPERA_ROOM_CHARGE', 130, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'TENDER_RETAIL_CREDIT', 'DEFAULT', '_TENDER_RETAIL_CREDIT', 140, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'TENDER_RETAIL_DEBIT', 'DEFAULT', '_TENDER_RETAIL_DEBIT', 150, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_AMEX_AMEX', 'DEFAULT', '_XPAY_AMEX_AMEX', 160, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_CHECK_CERTEGY', 'DEFAULT', '_XPAY_CHECK_CERTEGY', 170, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_GIFT_CARD_PAYMENTECH', 'DEFAULT', '_XPAY_GIFT_CARD_PAYMENTECH', 180, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_GIFT_CARD_RELATE', 'DEFAULT', '_XPAY_GIFT_CARD_RELATE', 190, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_POINTS_CARD', 'DEFAULT', '_XPAY_POINTS_CARD', 200, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_AMEX_FDMS', 'DEFAULT', '_XPAY_AMEX_FDMS', 210, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DEBIT_FDMS', 'DEFAULT', '_XPAY_DEBIT_FDMS', 220, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DINERS_CLUB_FDMS', 'DEFAULT', '_XPAY_DINERS_CLUB_FDMS', 230, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DISCOVER_FDMS', 'DEFAULT', '_XPAY_DISCOVER_FDMS', 240, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_JCB_FDMS', 'DEFAULT', '_XPAY_JCB_FDMS', 250, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_MASTERCARD_FDMS', 'DEFAULT', '_XPAY_MASTERCARD_FDMS', 260, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_PRIVATE_LABEL_FDMS', 'DEFAULT', '_XPAY_PRIVATE_LABEL_FDMS', 270, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_VISA_FDMS', 'DEFAULT', '_XPAY_VISA_FDMS', 280, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_AMEX_MERCHANTLINK', 'DEFAULT', '_XPAY_AMEX_MERCHANTLINK', 290, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DEBIT_MERCHANTLINK', 'DEFAULT', '_XPAY_DEBIT_MERCHANTLINK', 300, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DINERS_CLUB_MERCHANTLINK', 'DEFAULT', '_XPAY_DINERS_CLUB_MERCHANTLINK', 310, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DISCOVER_MERCHANTLINK', 'DEFAULT', '_XPAY_DISCOVER_MERCHANTLINK', 320, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_JCB_MERCHANTLINK', 'DEFAULT', '_XPAY_JCB_MERCHANTLINK', 330, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_MASTERCARD_MERCHANTLINK', 'DEFAULT', '_XPAY_MASTERCARD_MERCHANTLINK', 340, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_PRIVATELABEL_MERCHANTLINK', 'DEFAULT', '_XPAY_PRIVATELABEL_MERCHANTLINK', 350, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_VISA_MERCHANTLINK', 'DEFAULT', '_XPAY_VISA_MERCHANTLINK', 360, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_AMEX_MWHSE', 'DEFAULT', '_XPAY_AMEX_MWHSE', 370, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DEBIT_MWHSE', 'DEFAULT', '_XPAY_DEBIT_MWHSE', 380, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DINERS_CLUB_MWHSE', 'DEFAULT', '_XPAY_DINERS_CLUB_MWHSE', 390, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DISCOVER_MWHSE', 'DEFAULT', '_XPAY_DISCOVER_MWHSE', 400, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_JCB_MWHSE', 'DEFAULT', '_XPAY_JCB_MWHSE', 410, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_MASTERCARD_MWHSE', 'DEFAULT', '_XPAY_MASTERCARD_MWHSE', 420, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_VISA_MWHSE', 'DEFAULT', '_XPAY_VISA_MWHSE', 430, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_AMEX_PAYMENTECH', 'DEFAULT', '_XPAY_AMEX_PAYMENTECH', 440, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DEBIT_PAYMENTECH', 'DEFAULT', '_XPAY_DEBIT_PAYMENTECH', 450, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DINERS_CLUB_PAYMENTECH', 'DEFAULT', '_XPAY_DINERS_CLUB_PAYMENTECH', 460, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_DISCOVER_PAYMENTECH', 'DEFAULT', '_XPAY_DISCOVER_PAYMENTECH', 470, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_JCB_PAYMENTECH', 'DEFAULT', '_XPAY_JCB_PAYMENTECH', 480, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_MASTERCARD_PAYMENTECH', 'DEFAULT', '_XPAY_MASTERCARD_PAYMENTECH', 490, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_PRIVATE_LABEL_PAYMENTECH', 'DEFAULT', '_XPAY_PRIVATE_LABEL_PAYMENTECH', 500, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_VISA_PAYMENTECH', 'DEFAULT', '_XPAY_VISA_PAYMENTECH', 510, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'XPAY_GIFT_CARD_FDMS', 'DEFAULT', '_XPAY_GIFT_CARD_FDMS', 570, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'DATA', 'AUTH_METHOD_CODE', 'GIFT_CARD_RELATE', 'DEFAULT', '_GIFT_CARD_RELATE', 580, NULL, NULL, NULL);
  
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Discount---applicationMethod';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Discount---calculationMethod';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Discount---eligibilityType';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Discount---taxibilityCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Employee---employeeStatusCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Employee---employeeTypeCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Item---itemLevelCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Item---itemTypeCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'PRICE_TYPES';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'REASON_CODE_TYPE';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'RECEIPT_TEXT';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Security---noAccessSettingsCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Security---secondPromptSettingsCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tax---roundingRequireCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tax---taxApplicationTypes';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tax---taxBreakPointTypes';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tender---authMethodCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tender---currencyId';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tender---custIdReqCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tender---reportingGroup';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Tender---unitCountCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'TenderAvailability---availabilityCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'TenderUserSettings---entryMethodCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'TenderUserSettings---usageCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Vendor---vendorStatusCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'DATA' AND config_name = 'Vendor---vendorTypeCode';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'MenuConfig' AND config_name = 'KEY_STROKES';
COMMIT;

INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F2', 'DEFAULT', 'F2', 10, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F3', 'DEFAULT', 'F3', 20, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F4', 'DEFAULT', 'F4', 30, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F5', 'DEFAULT', 'F5', 40, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F6', 'DEFAULT', 'F6', 50, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F7', 'DEFAULT', 'F7', 60, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F8', 'DEFAULT', 'F8', 70, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F9', 'DEFAULT', 'F9', 80, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F10', 'DEFAULT', 'F10', 90, NULL, NULL, NULL);
INSERT INTO cfg_code_value (code_id, category, config_name, code, sub_category, description, sort_order, data1, data2, data3)
  VALUES (HIBERNATE_SEQUENCE.nextval, 'MenuConfig', 'KEY_STROKES', 'F11', 'DEFAULT', 'F11', 100, NULL, NULL, NULL);
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'ORG_HIERARCHY_LEVEL';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'RcptConfig';
COMMIT;

DELETE FROM cfg_code_value WHERE category = 'ConfiguratorConfig' and config_name in ('StagingHostName','StagingHostPort','StagingHostBaseURL', 'StagingHostUsername', 'StagingHostPassword');
COMMIT;



-- ************************************************************ --
-- * Change some enum status codes for some deployment tables * --
-- ************************************************************ --
UPDATE dpl_deployment_target SET files_downloaded_status='UNREPORTED' where files_downloaded_status='PENDING';
UPDATE dpl_deployment_target SET files_applied_status='UNREPORTED' where files_applied_status='PENDING';
UPDATE dpl_deployment_file_status SET downloaded_status='UNREPORTED' where downloaded_status='PENDING';
UPDATE dpl_deployment_file_status SET applied_status='UNREPORTED' where applied_status='PENDING';
COMMIT;


-- ************************************************************ --
-- * Default the deployment name to N/A if its NULL * --
-- ************************************************************ --
UPDATE dpl_deployment SET deployment_name='N/A' where deployment_name is null;
COMMIT;


-- ************************************************************ --
-- * set this field to COMPLETE for 5.5.0 customers               --
-- * In the document guide, customer should complete the existing --
-- * deployments  before doing the upgrade                        --
-- ************************************************************   --
 UPDATE dpl_deployment SET deploy_status = 'NOT_APPLICABLE' where deploy_status is null;
 COMMIT;


 -- ************************************************************   --
-- * set this field to NOT_APPLICABLE for 5.5.0 customers          --
-- ************************************************************   --
 UPDATE dpl_deployment SET deployment_type = 'NOT_APPLICABLE' where deployment_type is null;
 COMMIT;


-- ************************************************************ --
-- * Default the plan_id to -1 if its NULL * --
-- * this means all previous deployment are considered single * --
-- * wave deployment since plan is introduced only for 6.0    * --
-- ************************************************************ --
 UPDATE dpl_deployment SET plan_id = -1 where plan_id is null;
 COMMIT;


 -- ************************************************************ --
-- * Default the plan_name to Single Wave if its NULL * --
-- * this means all previous deployments(5.5) are considered   * --
-- * single wave deployment since plan is introduced only for 6.0--
-- ************************************************************  --
 UPDATE dpl_deployment SET plan_name = 'Single Wave' where plan_name is null;
 COMMIT;


-- ************************************************************ --
-- * Default the purge_status to UNREPORTED if its NULL         --
-- * this means all previous deployment fiels (5.5) by default  --
-- * are not purged                                             --
-- ************************************************************ --
 UPDATE dpl_deployment SET purge_status = 'UNREPORTED' where purge_status is null;
 COMMIT;


-- ************************************************************ --
-- * Default the purge_status to UNREPORTED if its NULL         --
-- * this means all previous deployment files (5.5) by default  --
-- * are not purged                                             --
-- ************************************************************ --
 UPDATE dpl_deployment_file SET purge_status = 'UNREPORTED' where purge_status is null;
 COMMIT;

 -- ************************************************************ --
-- * Default the is_all_remaining_store to 0 if its NULL         --
-- * We will not face this issue when upgrading from 5.5 to 6.o  --
-- * for any client since "dpl_deployment_plan_wave" is already  --
-- * new table but we need this update for QA lab "xstxcenter"   --
-- ************************************************************ --
 UPDATE dpl_deployment_plan_wave SET is_all_remaining_store = 0 where is_all_remaining_store is null;
 COMMIT;



-- Remove the org node from the configurator object id.
UPDATE cfg_desc_translation_map SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_msg_translation_map SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_receipt_text_change SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_reason_code_change SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_dsc_valid_item_type_change SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_dsc_group_mapping_change SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_discount_change SET change_id=REPLACE(change_id,'::null::null','') where change_id like '%::null::null';
UPDATE cfg_profile_element_changes SET change_subtype=REPLACE(change_subtype,'::null::null','') where change_subtype like '%::null::null';
COMMIT;



-- New settings data
-- Configuration settings
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'AutoFileTransferDirectory';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('AutoFileTransferDirectory', 'file:/filetransfer/auto/org${organizationId}/', 'com.micros_retail.configurator.filetransfer.autoSchedulerIntervalChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'AutoFileTransferSchedulerInterval';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('AutoFileTransferSchedulerInterval', '15', 'com.micros_retail.configurator.filetransfer.autoSchedulerIntervalChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'FileUploadDirectory';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('FileUploadDirectory', 'file:/fileuploads/org${organizationId}/', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DeviceConsideredMissingInXMinutes';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DeviceConsideredMissingInXMinutes', '61', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'IgnoreMissingDeviceAfterXHours';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('IgnoreMissingDeviceAfterXHours', '72', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'ScanForMissingDevicesEveryXMinutes';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('ScanForMissingDevicesEveryXMinutes', '15', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'BusinessDateStartTime';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('BusinessDateStartTime', '5', 'com.micros_retail.xcenter.support.observer.businessDateStartTimeChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PosLogPublisherRemoteFileDirectory';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PosLogPublisherRemoteFileDirectory', 'file:/poslog/org${organizationId}/', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableStoreSpecificOverrides';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableStoreSpecificOverrides', 'false', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableDeleteStoreConfigurations';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableDeleteStoreConfigurations', 'false', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DeploymentConfigTimeout';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DeploymentConfigTimeout', '5', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DeploymentConfigRetries';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DeploymentConfigRetries', '10', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DeploymentConfigRetryInterval';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DeploymentConfigRetryInterval', '10', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableDataManagerAutoDeployment';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableDataManagerAutoDeployment', 'false', 'com.micros_retail.xadmin.datamanager.server.dataManagerDeploymentChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DataManagerAutoDeploymentStartTime';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DataManagerAutoDeploymentStartTime', '21:00', 'com.micros_retail.xadmin.datamanager.server.dataManagerDeploymentChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'MaxDeploymentResult';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('MaxDeploymentResult', '100', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'MaxPOSLogResult';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('MaxPOSLogResult', '100', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DaysBeforeLaunchDate';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DaysBeforeLaunchDate', '3', 'com.micros_retail.xadmin.daysBeforeLaunchDateChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DeploymentAutoEmailInterval';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DeploymentAutoEmailInterval', '60', 'com.micros_retail.xadmin.deploymentAutoEmailIntervalChanged');
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'NewUserPasswordCreation';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('NewUserPasswordCreation', 'MANUAL', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableLDAP';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableLDAP', 'false', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'LDAP_URL';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('LDAP_URL', '', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'LDAP_DefaultDomain';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('LDAP_DefaultDomain', '', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'POSLogPublishSearchMaxResult';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('POSLogPublishSearchMaxResult', '1000', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DeleteFifoDataAfterRptGen';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DeleteFifoDataAfterRptGen', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'UseTillAccountabilityDefault';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('UseTillAccountabilityDefault', 'false', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DefaultDepositBankName';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DefaultDepositBankName', 'Deposit Bank', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DefaultDepositBankAcctNbr';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DefaultDepositBankAcctNbr', '1234567890', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PrimaryServerNumber';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value)
  VALUES ('PrimaryServerNumber', '1');
end if;
end;
/


COMMIT;


-- User/Password settings
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordHistoryLength';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordHistoryLength', '12', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordMaximumConsecutiveChars';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordMaximumConsecutiveChars', '2', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordMinimumCapitalLetters';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordMinimumCapitalLetters', '1', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordMinimumDigits';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordMinimumDigits', '1', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordMinimumLength';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordMinimumLength', '8', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordMinimumSpecialChars';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordMinimumSpecialChars', '1', null);
end if;
end;
/


--sort_order of all password related entries may need to be adjusted
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'PasswordExpirationDays';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('PasswordExpirationDays', '90', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'LockUserAccountAfterRetries';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('LockUserAccountAfterRetries', '3', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'UserIdMinimumLength';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('UserIdMinimumLength', '6', null);
end if;
end;
/


COMMIT;


-- Report settings
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_PDF';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_PDF', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_HTML';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_HTML', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_CSV';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_CSV', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_XLS';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_XLS', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_XLSX';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_XLSX', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_PPTX';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_PPTX', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_RTF';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_RTF', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'EnableReportOutputFormat_DOCX';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('EnableReportOutputFormat_DOCX', 'true', null);
end if;
end;
/


Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DefaultReportOutputFormat';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DefaultReportOutputFormat', 'PDF', null);
end if;
end;
/


COMMIT;


-- Country Code Setting for the organization
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_system_setting where config_id = 'DefaultCountryCode';
IF v_exists = 0 THEN 

INSERT INTO cfg_system_setting (config_id, config_value, modified_event)
  VALUES ('DefaultCountryCode', 'US', null);
end if;
end;
/


COMMIT;


-- Tab propery configuration
DELETE FROM cfg_tab_property;
COMMIT;


INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('MESSAGE_AREA', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('ASSOCIATE_TASKS', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('SALES_GOAL', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('EMPLOYEE_MESSAGES', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('NUMERIC_KEYPAD', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('TRANSACTION_COUPONS', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('ACTIVITY_STREAM', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('ORDER_WORKLIST', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('WEATHER_FORECAST', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('EMPLOYEE_SCHEDULE', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('QUICK_LAUNCH', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('QUICK_ITEMS', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('URL_NAVIGATOR', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('TWITTER', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('URL_NAVIGATOR', 'tab', 'TextBox', 'complexValue', '_tabUrlLabel', NULL, NULL, NULL, NULL);
INSERT INTO cfg_tab_property(tab_id, property_id, display_component, value_type, label, create_date, create_user_id, update_date, update_user_id)
  VALUES('ASSOCIATED_ITEMS', 'tabTitle', 'TextBox', 'value', '_tabTitleLabel', NULL, NULL, NULL, NULL);
COMMIT;



-- **************************************************** --
-- * Always keep Default User Creation at end of file * --
-- **************************************************** --
-- DEFAULT USER
Declare v_exists NUMBER(1,0);
begin
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM cfg_user where USER_NAME='1';
IF v_exists = 0 THEN 

  INSERT INTO cfg_user (user_name, first_name, last_name, locale, role_id) VALUES ('1', 'Default', 'User', 'en_US', 'ADMINISTRATOR');
  INSERT INTO cfg_user_node (user_name, org_scope) VALUES ('1', '*:*');
  INSERT INTO cfg_user_password (password_id, user_name, password, effective_date) VALUES (HIBERNATE_SEQUENCE.nextval, '1', 'tZxnvxlqR1gZHkL3ZnDOug==', SYSDATE);
end if;
end;
/


COMMIT;


-- Always rebuild the Administrator role so that any new privileges that were added automatically get assigned.
  DELETE FROM cfg_role WHERE role_id = 'ADMINISTRATOR';
COMMIT;

  INSERT INTO cfg_role (role_id, role_desc, system_role_flag, xadmin_rank, xstore_rank) VALUES ('ADMINISTRATOR', 'Administrator', 1, 150, 150);

  DELETE FROM cfg_role_privilege WHERE role_id = 'ADMINISTRATOR';
COMMIT;

  INSERT INTO cfg_role_privilege (role_id, privilege_id)
  SELECT 'ADMINISTRATOR', privilege_id FROM cfg_privilege;
COMMIT;


-- Always rebuild the Receipt viewer for XBRi role so that any new privileges that were added automatically gets assigned.
  DELETE FROM cfg_role WHERE role_id = 'ReceiptViewer';
COMMIT;

  INSERT INTO cfg_role (role_id, role_desc, system_role_flag, xadmin_rank, xstore_rank) VALUES ('ReceiptViewer', 'Receipt Viewer/Electronic Journal Access', 0, 100, 100);

  DELETE FROM cfg_role_privilege WHERE role_id = 'ReceiptViewer';
COMMIT;

  INSERT INTO cfg_role_privilege (role_id, privilege_id) VALUES ('ReceiptViewer', 'SPT_EJOURNAL');
  INSERT INTO cfg_role_privilege (role_id, privilege_id) VALUES ('ReceiptViewer', 'BASIC_ACCESS');
COMMIT;


-- ************************************************************ --
-- * Default the config_version to 0 if it is NULL.             --
-- * This means that all previous translation changes are not   --
-- * managed therefore cannot be monitored by the config        --
-- * versioning feature of Xadmin.                              --
-- ************************************************************ --
 UPDATE cfg_desc_translation_map SET s_config_version = 0 where s_config_version is null;
 UPDATE cfg_msg_translation_map SET s_config_version = 0 where s_config_version is null;
 UPDATE cfg_desc_translation_map SET t_config_version = 0 where t_config_version is null;
 UPDATE cfg_msg_translation_map SET t_config_version = 0 where t_config_version is null;
 UPDATE dpl_deployment SET config_version = 0 where config_version is null;
 UPDATE cfg_profile_element_changes SET inactive_flag = 0 where inactive_flag is null;
 UPDATE cfg_resource SET config_version = 0 where config_version is null;
 COMMIT;
