DESCRIPTION = "Qt Thermostat Demo"
HOMEPAGE = "https://gitorious.org/thermostat-demo"

LICENSE = "BSD & CC-BY-SA-2.0 & CC-BY-SA-3.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93a105adb99011afa5baee932b560714 \
                    file://IMAGE-LICENSE;md5=fce98146123de13a189c234a5e4cfa0d \
                    file://API-LICENSE;md5=5e32280d79a1eab76729c50d79ecfe72 \
                    file://remote/MIT-LICENSE.txt;md5=6a24093faaae5d5c198578c88e220071 \
"

require recipes-core/matrix/matrix-gui-paths.inc

PR = "r0"

BRANCH ?= "master"
SRCREV = "2f461242d469871538e6cd05e887457674347e8f"

SRC_URI = "git://gitorious.org/thermostat-demo/thermostat-demo.git;protocol=git"

S = "${WORKDIR}/git/"

inherit qt4e

# use the make targets already created in the Makefile.build files
do_install() {
	make -f Makefile.build DESTDIR=${D} install_common
}

PACKAGES += "matrix-gui-thermostat-demo"

RDEPENDS_matrix-gui-thermostat-demo += "matrix-gui-apps-images matrix-gui-submenus-qt4"

FILES_matrix-gui-thermostat-demo += "${MATRIX_APP_DIR}/*"
