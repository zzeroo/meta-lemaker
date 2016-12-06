# Base this image on bpro-basic-image
include bpro-basic-image.bb

IMAGE_INSTALL_append = " packagegroup-bpro-test"
IMAGE_INSTALL += "weston weston-init"
