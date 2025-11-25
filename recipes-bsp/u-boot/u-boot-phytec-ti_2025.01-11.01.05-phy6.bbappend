COMPATIBLE_MACHINE .= "|phyboard-rigel"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " file://0001-edgeai-demo-enable-co-processor-firmware-in-bootloader.patch \
           "
