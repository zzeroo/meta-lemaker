

# # setenv fdtfile sun7i-a20-bananapro.dtb
# setenv bootargs 'earlyprintk console=ttyS0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait noinitrd'
# mmc dev 0
# fatload mmc 0:1 ${kernel_addr_r} uImage
# fatload mmc 0:1 ${fdt_addr_r} ${fdtfile}
# bootm ${kernel_addr_r} - ${fdt_addr_r}

# mkimage -C none -A arm -T script -d boot.cmd boot.scr
bootdelay=0
#setenv bootargs console=ttyS0,115200 root=/dev/mmcblk0p2 rootwait panic=10 vt.global_cursor_default=0 quiet splash
setenv bootargs console=ttyS0,115200 root=/dev/mmcblk0p2 rootwait panic=10 vt.global_cursor_default=0
# load mmc 0:1 0x41000000 u-boot-splashscreen.bmp
setenv splashimage 41000000
load mmc 0:1 0x43000000 ${fdtfile} || load mmc 0:1 0x43000000 boot/${fdtfile}
load mmc 0:1 0x42000000 uImage || load mmc 0:1 0x42000000 boot/uImage
bootm 0x42000000 - 0x43000000
