setenv fdtfile sun7i-a20-bananapro.dtb
setenv bootargs 'earlyprintk console=ttyS0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait noinitrd'
mmc dev 0
fatload mmc 0:1 ${kernel_addr_r} uImage
fatload mmc 0:1 ${fdt_addr_r} ${fdtfile}
bootm ${kernel_addr_r} - ${fdt_addr_r}
