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
exit

# Build a Debiuan Ubuntu package
echo "Building a Debian/Ubuntu package"
cp java-src/out/artifacts/process_tracker_jar/process_tracker.jar debian-ubuntu-package/usr/local/bin
cp systemd-service/invotracker.service centos-fedora-package
pushd debian-ubuntu-package
dpkg-deb --build debian-process-tracker
popd
# Install on debian machine using sudo apt install ./name.deb