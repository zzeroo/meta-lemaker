DESCRIPTION = "Broadcom Firmware, stolen"
HOMEPAGE = "https://zzeroo.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
PR = "r1"

SRC_URI = "file://brcmfmac43362-sdio.txt"

do_install() {
	install -Dm0644 ${WORKDIR}/brcmfmac43362-sdio.txt ${D}/lib/firmware/brcm/brcmfmac43362-sdio.txt
}

FILES_${PN} += "/lib/firmware/brcm/brcmfmac43362-sdio.txt"

PACKAGES = "${PN}"
