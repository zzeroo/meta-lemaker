FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "file://custom-weston.service \
		file://weston.ini"
PV = "r3"

FILES_${PN} += "/home/root/.config/weston.ini"

RDEPENDS_${PN} = "weston"

do_install() {
	install -Dm0644 ${WORKDIR}/custom-weston.service ${D}${systemd_system_unitdir}/weston.service
	install -Dm0644 ${WORKDIR}/weston.ini ${D}/home/root/.config/weston.ini
}

SYSTEMD_SERVICE_${PN} = "weston.service"
