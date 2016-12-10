DESCRIPTION = "Default WPA Supplicant configuration special for RA-GAS Devices"
HOMEPAGE = "https://zzeroo.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
PR = "r3"

SRC_URI = "file://wpa_supplicant.conf \
        file://interfaces"

do_install_append() {
  install -Dm0644 ${WORKDIR}/wpa_supplicant.conf ${D}/etc/wpa_supplicant.conf
  install -Dm0644 ${WORKDIR}/interfaces ${D}/etc/network/interfaces
}

FILES_${PN} += "/etc/wpa_supplicant.conf"
FILES_${PN} += "/etc/network/interfaces"
