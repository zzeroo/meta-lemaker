# Base this image on bpro-hwup-image
include bpro-hwup-image.bb

# IMAGE_FEATURES += "ssh-server-dropbear splash"
IMAGE_FEATURES += ""

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
"
