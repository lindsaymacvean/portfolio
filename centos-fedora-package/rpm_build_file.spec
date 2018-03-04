Name:    invotra-process-tracker
Version: 1
Release: 1%{?dist}
Summary: This is a Java service to track and report on running processes

License: Public Domain
Source0: process_tracker.jar
Source1: invotracker.service
BuildArch: noarch

%description
A Java based process tracker

%install
mkdir -p %{buildroot}/%{_bindir}
install -p -m 755 %{SOURCE0} %{buildroot}/%{_bindir}
install -p -m 644 %{SOURCE1} /etc/systemd/system
systemctl daemon-reload
%files
 %{_bindir}/process_tracker.jar

%changelog