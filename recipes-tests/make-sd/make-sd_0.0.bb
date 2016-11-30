DESCRIPTION = "Create SDCard partitions and copy files"
LICENSE = "MIT"

inherit sdcard_image-bpro

make-sd_do_configure() {
  bbnote "MAKE_SD CONFIGURE"
}

make-sd_do_make() {
  bbnote "MAKE_SD MAKE"
}

make-sd_do_install() {
  bbnote "MAKE_SD INSTALL"
}
