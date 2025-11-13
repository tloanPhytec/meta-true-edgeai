# meta-true-edgeai

* based on: BSP-Yocto-Ampliphy-AM67x-PD25.1.0
* author: True Loan (tloan@phytec.com)
* machine: phyboard-rigel-am67xx-1
* yocto: scarthgap

# Meta Layer Summary

* Ports TI's Edge AI demos for the J722S platform to the phyCORE-AM67x

To add this layer to your existing BSP-Yocto-Ampliphy-AM67x-PD25.1.0:

* Navigate to your BSP's sources directory:
  ```sh
  cd $BUILDDIR/../sources
  ```
* Clone this repo and checkout the scarthgap branch:
  ```sh
  git clone https://github.com/tloanPhytec/meta-true-edgeai.git -b scarthgap
  cd meta-true-edgeai
  git submodule update --init
  ```
* Enable the layer and its layer dependency in your build:
  ```sh
  cd $BUILDDIR
  bitbake-layers add-layer ../sources/meta-true-edgeai
  bitbake-layers add-layer ../sources/meta-true-edgeai/meta-qt5
  ```
* Build the image:
  ```sh
  MACHINE=phyboard-rigel-am67xx-1 bitbake tisdk-edgeai-image
  ```
