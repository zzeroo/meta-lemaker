# mkimage -C none -A arm -T script -d boot.cmd boot.scr
bootdelay=0
setenv bootargs console=ttyS0,115200 root=/dev/mmcblk0p2 rootwait panic=10 vt.global_cursor_default=0 quiet splash
# load mmc 0:1 0x41000000 u-boot-splashscreen.bmp
setenv splashimage 41000000
load mmc 0:1 0x43000000 ${fdtfile} || load mmc 0:1 0x43000000 boot/${fdtfile}
load mmc 0:1 0x42000000 uImage || load mmc 0:1 0x42000000 boot/uImage
bootm 0x42000000 - 0x43000000
