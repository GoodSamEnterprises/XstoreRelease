@echo off

time /t
copy xdld.bin \\.\com12
copy /y xst_fa221w_super_101116.tgz update.tgz
ddl -p12 -b115200 -iupdate.tgz
time /t

del update.tgz

echo deleting c:\xstore\tmp\device.ste in case the device was already on this version
del c:\xstore\tmp\device.ste
echo Waiting for device reboot(Sleeping for 10 minutes)...
choice /D y /T 600 >nul
time /t
