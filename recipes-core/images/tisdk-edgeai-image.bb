require recipes-images/images/phytec-qt6demo-image.bb

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
"
# omiiting for now:
# packagegroup-arago-gst-sdk-target \
#

IMAGE_INSTALL:append = " ${EDGEAI_STACK}"
IMAGE_INSTALL:remove += " qtphy"


   

