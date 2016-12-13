DESCRIPTION = "Default Network configuration for RA-GAS Devices"
HOMEPAGE = "https://zzeroo.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
PR = "r1"

SRC_URI = "file://interfaces"

do_install_append() {
  install -Dm0644 ${WORKDIR}/interfaces ${D}/etc/network/interfaces
}

FILES_${PN} += "/etc/network/interfaces"
