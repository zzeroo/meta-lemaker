DESCRIPTION="Kalibrator für die RA-GAS CO-NO2 Kombisensoren mit Modbus Interface, basierend auf dem BananaPro Board"
LICENSE = "COPYING.GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"


include meta/recipes-graphics/images/core-image-weston.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
	"

IMAGE_INSTALL_append = " packagegroup-bpro-co-no2-calibrator"
