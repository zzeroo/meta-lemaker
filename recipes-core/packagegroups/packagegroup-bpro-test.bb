DESCRIPTION = "BananaPro Test Packagegroup"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

inherit packagegroup

RDEPENDS_${PN} = "\
  wayland \
  gtk+3 \
  hello-world-gtk3-rs \
"

RRECOMMENDS_${PN} = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
"
