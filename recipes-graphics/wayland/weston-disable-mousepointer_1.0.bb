DESCRIPTION = "Disables the mousepointer under weston"
HOMEPAGE = "https://zzeroo.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS = "weston"
PR = "r1"


SRC_URI = "file://disable_mousepointer.rules"

do_install() {
	install -Dm0644 ${WORKDIR}/disable_mousepointer.rules ${D}/etc/udev/rules.d/disable_mousepointer.rules
}

FILES_${PN} += "/etc/udev/rules.d/disable_mousepointer.rules"

PACKAGES = "${PN}"
