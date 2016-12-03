DESCRIPTION = "Packagegroup für den CO-NO2-Kalibrator"
LICENSE = "COPYING.GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

inherit packagegroup

RDEPENDS_${PN} = "\
"

RRECOMMENDS_${PN} = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
"
