# EXTRA_OECONF_append = " --disable-logind"

PACKAGECONFIG += "networkd resolved"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://00-wireless-dhcp.network"

FILES_${PN} += "{sysconfdir}/systemd/network/*"

do_install_append() {
  install -d ${D}${sysconfdir}/systemd/network/
  install -m 0644 ${WORKDIR}/*.network ${D}${sysconfdir}/systemd/network/
}
