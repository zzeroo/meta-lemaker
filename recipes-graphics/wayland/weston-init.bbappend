FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "file://custom-weston.service \
		file://weston.ini \
	file://wallpaper-desktop-ra-gas.png \
		"
PV = "r3"


RDEPENDS_${PN} = "weston"

do_install() {
	install -Dm0644 ${WORKDIR}/custom-weston.service ${D}${systemd_system_unitdir}/weston.service
	install -Dm0644 ${WORKDIR}/weston.ini ${D}/home/root/.config/weston.ini

	install -Dm0644 ${WORKDIR}/wallpaper-desktop-ra-gas.png ${D}/usr/share/backgrounds/ra-gas/wallpaper-desktop-ra-gas.png
}

FILES_${PN} += "/home/root/.config/weston.ini"
FILES_${PN} += "/usr/share/backgrounds/ra-gas/wallpaper-desktop-ra-gas.png"

SYSTEMD_SERVICE_${PN} = "weston.service"
