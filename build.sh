#! /bin/bash

# Build a Centos Fedora Package
# https://docs.fedoraproject.org/quick-docs/en-US/creating-rpm-packages.html#con_rpm_spec_file_overview
echo "Building Fedora 27 package"
cp java-src/out/artifacts/process_tracker_jar/process_tracker.jar centos-fedora-package
cp systemd-service/invotracker.service centos-fedora-package
pushd centos-fedora-package
fedpkg --release f27 local
popd
# Further work required on how to create upgrade package
# https://www.ibm.com/developerworks/library/l-rpm2/

# Build a Debiuan Ubuntu package
echo "Building a Debian/Ubuntu package"
cp java-src/out/artifacts/process_tracker_jar/process_tracker.jar debian-ubuntu-package/usr/local/bin
chmod +x debian-ubuntu-package/usr/local/bin/process_tracker.jar
cp systemd-service/invotracker.service debian-ubuntu-package/etc/systemd/system
pushd debian-ubuntu-package
# We need the two stops to build from 'current directory' to 'current directory'
dpkg-deb --build . .
popd
# Install on debian machine using sudo apt install ./name.deb