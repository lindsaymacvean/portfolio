# Readme

A Fedora 27 installation package (possibly Centos 6) is located in centos-fedora-package/noarch/
Run `sudo dnf install centos-fedora-package/noarch/invotra-process-tracker-1-1.fc27.noarch.rpm`

A Debian Ubuntu 14+ package is located in debian-ubuntu-package
Run `sudo dpkg -i debian-ubuntu-package/invotra-process-tracker_1.0_all.deb`
And to check dependendencies are clean `sudo apt-get install -f .`


The Java App is located in java-src
The systemd service file is located in systemd-service this is packaged into the installations
So once its installed try
`sudo service invotracker start`

## Build 
First create the Java jar artifact. I used IntelliJ to do this
Second run `sudo ./build.sh` to create the installation packages

## Uninstall
`sudo dnf remove invotra-process-tracker`
`sudo apt-get remove invotra-process-tracker`