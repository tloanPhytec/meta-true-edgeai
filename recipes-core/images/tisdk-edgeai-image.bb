SUMMARY = "This image adapts TI's EdgeAI demos to the phyCORE-AM67x"

require recipes-images/images/phytec-headless-image.bb

COMPATIBLE_MACHINE = "phyboard-rigel-am67xx-1"

EDGEAI_STACK = " \
	ti-vision-apps-dev \
	ti-edgeai-firmware \
	ti-tidl-dev \
	edgeai-tiovx-kernels-dev \
	edgeai-tiovx-kernels-source \
	edgeai-apps-utils-source \
	edgeai-test-data \
	edgeai-tidl-models \
	edgeai-tiovx-apps-dev \
	edgeai-tiovx-apps-source \
	ti-tidl-osrt-dev \
	ti-tidl-osrt-staticdev \
	edgeai-init \
	edgeai-gui-app \
	edgeai-tiovx-modules-dev \
	edgeai-tiovx-modules-source \
	edgeai-gst-plugins \
	edgeai-gst-plugins-dev \
	edgeai-gst-apps-source \
	edgeai-dl-inferer-staticdev \
	edgeai-gst-plugins-source \
	edgeai-gst-apps-dev \
	edgeai-dl-inferer-source \
	ti-gpio-cpp-dev \
	ti-gpio-py \
	ti-gpio-cpp-source \
	ti-gpio-py-source \
	edgeai-studio-agent \
	packagegroup-edgeai-tisdk-addons \
	resize-rootfs \
	ntp \
	kms++ \
	qtbase-conf \
	qtquickcontrols-qmlplugins \
	qtquickcontrols2 \
	qtquickcontrols2-plugins \
	qtquickcontrols2-qmlplugins \
	qtgraphicaleffects-qmlplugins \
	qtquick3d \
	qtquick3d-plugins \
	qtquick3d-qmlplugins \
	qtscript \
	qtscript-plugins \
	qtscript-qmlplugins \
"
# omiiting for now:
# packagegroup-arago-gst-sdk-target \
#

IMAGE_FEATURES += "\
	splash \
	ssh-server-openssh \
	hwcodecs \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', '', d)} \
"

LICENSE = "MIT"

IMAGE_INSTALL += "\
	packagegroup-base \
	packagegroup-gstreamer \
	${EDGEAI_STACK} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland qtwayland-plugins weston weston-init', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland', '', d)} \
"

# Nice-to-haves for development
IMAGE_INSTALL:append = " packagegroup-core-buildessential cmake git meson ninja sudo pkgconfig python3-pip ffmpeg"

PACKAGECONFIG:append:pn-ffmpeg = " gpl x264 x265"
LICENSE_FLAGS_ACCEPTED += "commercial"
