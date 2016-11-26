DESCRIPTION="U-boot mainline configured for banana pro"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=master \
  file://boot.cmd"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://boot.cmd"
SRC_URI += "file://0001-u-boot-bananapro.patch"

PV = "v2016.11"
SRCREV = "136179bec19f4bc84227cba138214ea392a723ea"

PE = "2"

S = "${WORKDIR}/git"

SPL_BINARY="u-boot-sunxi-with-spl.bin"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
