
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


do_install_append() {
  install -Dm0644 ${WORKDIR}/wpa_supplicant.conf-sane ${D}/etc/wpa_supplicant/wpa_supplicant-wlan0.conf
  install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
  ln -s ${systemd_unitdir}/system/wpa_supplicant@.service \
          ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
}


FILES_${PN} += "/lib/systemd/system/ /etc/wpa_supplicant/wpa_supplicant-wlan0.conf"
