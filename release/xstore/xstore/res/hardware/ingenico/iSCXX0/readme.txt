This folder contains files and information that can be used to inject Ingenico iSCXX0 devices for use with Xstore.

If using a USB device, configure the device for USB->Serial communications and install the USB driver using the provided Install.bat file in the USB directory.
If using a Serial device, configure the device for Serial communications.

Once the device has been properly configured, run the appropriate download_<type>.bat file in the subdirectory that is appropriate for your device and configuration to load forms and configurations that will be used by Xstore.
If the device is attached to a serial port other than COM1, it will be necessary to adjust the "set COM=" line in the download batch file to target the appropriate port. 