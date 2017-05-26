Test BSP meta layer for yocto (poky/ morty).
Aimed to support the Lemaker Banana Pro board.

# Dependencies

This layer depends on:

```
URI: git://git.openembedded.org/bitbake
branch: master

URI: git://git.openembedded.org/openembedded-core
layers: meta
branch: master
```

# Additional information

## Autoresize root filesystem on first boot

If you need an resize of the root filesystem add the following to your image definitions.

```
IMAGE_INSTALL += "resize-rootfs"
```
