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
-- BZ32046                230719             [New Requirement] Ability to change text Welcome screen on Pin Pad
--===================================================================

--*************************************************************************************************
--
-- Customer SQL updates specific to the Xadmin database go in this file.
--
--*************************************************************************************************

Declare v_exists NUMBER(1,0);
BEGIN

-- BEGIN BZ32046
SELECT DECODE(COUNT(*),0,0,1) INTO v_exists FROM CFG_CODE_CATEGORY WHERE organization_id = 1000  AND CATEGORY_GROUP = 'CAMPING_WORLD'  AND CATEGORY = 'PIN_PAD';
IF v_exists = 0 THEN 
  INSERT INTO cfg_code_category (ORGANIZATION_ID, CATEGORY_GROUP, CATEGORY, INTERNAL_FLAG, DESCRIPTION, COMMENTS, USES_IMAGE_URL, USES_RANK) VALUES (1000, 'CAMPING_WORLD', 'PIN_PAD', '0', 'Welcome message(Pin Pad)', 'This message will display when start pin pad', '0', '0');
END IF;
-- BEGIN BZ32046

END;
/

COMMIT;
--*************************************************************************************************
-- Keep this at the end of the file.
