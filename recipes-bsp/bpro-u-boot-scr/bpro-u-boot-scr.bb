DESCRIPTION="U-boot mainline configured for Lemaker Banana Pro Board"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
PR = "r11"

COMPATIBLE_MACHINE = "bananapro"
DEPENDS = "u-boot-mkimage-native"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = " \
  file://bpro_boot.cmd \
  file://splashscreen.bmp \
"

#specify where to get the files
S = "${WORKDIR}"

do_compile() {
    mkimage -A arm -T script -C none -n "Boot script" -d "${S}/bpro_boot.cmd" ${S}/boot.scr
}

inherit deploy

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${S}/boot.scr ${DEPLOYDIR}
    install -m 0644 ${S}/bpro_boot.cmd ${DEPLOYDIR}/boot.cmd
    install -m 0644 ${S}/splashscreen.bmp ${DEPLOYDIR}/splashscreen.bmp
}

addtask do_deploy after do_compile before do_build
