SRCREV = "dd31be21bf8117df054f9ad072784bfc4df9e76f"
SRC_URI = "git://git.denx.de/u-boot.git"


FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " \
  file://0001-Bananapro_defconfig.patch \
"

RDEPENDS_${PN}_append_bpro = " bpro-u-boot-scr"
