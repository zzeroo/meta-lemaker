FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-Bananapro_defconfig-patched.patch"
RDEPENDS_${PN}_append_bpro = " bpro-u-boot-scr"
