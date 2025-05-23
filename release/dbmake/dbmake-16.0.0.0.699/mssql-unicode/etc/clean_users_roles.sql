--------------------------------------------------------------------------------
-- This script will drop all of the users and roles created for XStore.  
--
-- Product:         XStore
-- Version:         16.0.0
-- DB platform:     Microsoft SQL Server 2008/2012
-- $Name$
--------------------------------------------------------------------------------

USE [master]
GO

DROP LOGIN [handheld]
DROP LOGIN [pos]
DROP LOGIN [xbruser]
DROP LOGIN [xtoolusers]
DROP LOGIN [dtv]
DROP LOGIN [dbauser]
GO

