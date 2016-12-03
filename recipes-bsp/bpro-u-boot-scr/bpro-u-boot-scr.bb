DESCRIPTION="U-boot mainline configured for Lemaker Banana Pro Board"
LICENSE = "COPYING.GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
PR = "r5"

COMPATIBLE_MACHINE = "bananapro"
DEPENDS = "u-boot-mkimage-native"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://bpro_boot.cmd"

#specify where to get the files
S = "${WORKDIR}"

do_compile() {
    mkimage -A arm -T script -C none -n "Boot script" -d "${WORKDIR}/bpro_boot.cmd" boot.scr
}

inherit deploy

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 boot.scr ${DEPLOYDIR}
    install -m 0644 ${WORKDIR}/bpro_boot.cmd ${DEPLOYDIR}/boot.cmd
}

addtask do_deploy after do_compile before do_build
