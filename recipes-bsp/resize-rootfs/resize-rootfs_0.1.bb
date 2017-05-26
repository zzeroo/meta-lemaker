SUMMARY = "Resize the root filesystem"
HOMEPAGE = "https://github.com/zzeroo/meta-lemaker"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r8"

SRC_URI = " \
  file://resize-rootfs.sh \
  file://resize-rootfs.service \
"

S = "${WORKDIR}"

inherit systemd allarch

do_install () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/resize-rootfs.service ${D}${systemd_unitdir}/system

    install -d ${D}${sbindir}
    install -m 0755 ${S}/resize-rootfs.sh ${D}${sbindir}
}

SYSTEMD_SERVICE_${PN} = "resize-rootfs.service"
RDEPENDS_${PN} += "e2fsprogs-resize2fs gptfdisk parted util-linux udev"
