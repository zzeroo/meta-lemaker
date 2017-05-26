#!/bin/sh

# check root
[ $(whoami) = "root" ] || { echo "E: You must be root" && exit 1; }

# check tools
SGDISK=$(which sgdisk) || { echo "E: You must have sgdisk" && exit 1; }
PARTED=$(which parted) || { echo "E: You must have parted" && exit 1; }
PARTPROBE=$(which partprobe) || { echo "E: You must have partprobe" && exit 1; }
RESIZE2FS=$(which resize2fs) || { echo "E: You must have resize2fs" && exit 1; }

# find root device
ROOT_DEVICE=$(findmnt --noheadings --output=SOURCE / | cut -d'[' -f1)
# prune root device (for example UUID)
ROOT_DEVICE=$(realpath ${ROOT_DEVICE})
# get the partition number and type
PART_ENTRY_NUMBER=$(udevadm info --query=property --name=${ROOT_DEVICE} | grep '^ID_PART_ENTRY_NUMBER=' | cut -d'=' -f2)
PART_TABLE_TYPE=$(udevadm info --query=property --name=${ROOT_DEVICE} | grep '^ID_PART_TABLE_TYPE=' | cut -d'=' -f2)
# find the block device
DEVICE=$(udevadm info --query=path --name=${ROOT_DEVICE} | awk -F'/' '{print $(NF-1)}')
DEVICE="/dev/${DEVICE}"

if [ "$PART_TABLE_TYPE" = "gpt" ]; then
	${SGDISK} -e ${DEVICE}
	${PARTPROBE}
fi

${PARTED} ${DEVICE} resizepart ${PART_ENTRY_NUMBER} 100%
${PARTPROBE}
${RESIZE2FS} "${ROOT_DEVICE}"

touch /etc/resize-rootfs.ok
