
			Xadmin Purge

Documentation
-------------

Please refer to the document "CW_Purge_Xadmin_Installation_Guide" attachment this build.

Installation
------------

1. Upload all files for the tools into any folder in Xadmin application server.
2. Open the terminal and execute the command below to change permissions for caw_xoffice_purge_file* files.
Example:
-	chmod -R 775 /u01/caw_xoffice_purge_file/caw_xoffice_purge_file.jar
-	chmod -R 775 /u01/caw_xoffice_purge_file/caw_xoffice_purge_file.sh

3. Open file "config.properties" and change the configuration.
Note: Please declare 'Xadmin/XCenter' information in file 'config.properties' before executing this tool.
In the first time to execute this tool, you need to input the password with plain text format.
Example:
	- db.xcenter.username=!dtv
	- db.xcenter.password=!dtv
	- javax.net.ssl.trustStorePassword=!CAWallgoodthings
	- filepurger.deployment.webdav.username=!apacheUser
	- filepurger.deployment.webdav.password=!apache

4. Run the script: Open command line on server and run command below.
	-	$ cd /u01/caw_xoffice_purge_file
	-	$ sh caw_xoffice_purge_file.sh


  
