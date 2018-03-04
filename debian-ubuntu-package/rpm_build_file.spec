Name:    invotra-process-tracker
Version: 1
Release: 1%{?dist}
Summary: This is a Java service to track and report on running processes

License: Public Domain
Source0: howdy
BuildArch: noarch

%description
A simple program to greet the user, Texas style.

%install
mkdir -p %{buildroot}/%{_bindir}
install -p -m 755 %{SOURCE0} %{buildroot}/%{_bindir}

%files
 %{_bindir}/howdy

%changelog