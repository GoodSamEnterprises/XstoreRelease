When using Epson devices on Windows, the following steps should be followed:
1) Run the Setup.exe file in the appropriate folder for the platform to install the latest TMUSB driver using and administrative account.
2) Run the PCS installer (PCS32.msi or PCS64.msi) in the appropriate folder for the platform to install the port communications service using an administrative account.
3) Extract the EpsUCCvt zip file (EpsUCCvt_32.zip or EpsUCCvt_64.zip) in the appropriate folder for the platform into the root of the c:\ drive using an administrative account to install Unicode files.

When using Epson devices on Linux, the following steps should be followed:
1) Extract the PCS tarball and run pcsinstall.sh as root.
2) Extract the EpsUCCvt tarball (EpsUCCvt_32.tar.gz or EpsUCCvt_64.tar.gz)in the appropriate folder for the platform into the root of the filesystem.


Independent of the platform that is being used, if a serial printer will need to be used, please review readme_serial.txt for additional details.