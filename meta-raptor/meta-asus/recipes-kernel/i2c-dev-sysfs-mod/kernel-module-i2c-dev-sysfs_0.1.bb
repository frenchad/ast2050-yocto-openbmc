# Copyright 2016-present Raptor Engineering. All Rights Reserved.
#
# This program file is free software; you can redistribute it and/or modify it
# under the terms of the GNU General Public License as published by the
# Free Software Foundation; version 2 of the License.
#
# This program is distributed in the hope that it will be useful, but WITHOUT
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
# FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
# for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program in a file named COPYING; if not, write to the
# Free Software Foundation, Inc.,
# 51 Franklin Street, Fifth Floor,
# Boston, MA 02110-1301 USA

SUMMARY = "ASUS i2c device library"
DESCRIPTION = "i2c device sysfs attribute library"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

PR = "r0"
PV = "0.1"

SRC_URI = "file://Makefile \
           file://i2c_dev_sysfs.c \
           file://i2c_dev_sysfs.h \
           file://COPYING \
          "

S = "${WORKDIR}"

do_install_append() {
     kerneldir=${STAGING_KERNEL_DIR}/include/linux
     install -d ${kerneldir}
     install -m 0644 i2c_dev_sysfs.h ${kerneldir}/
}

FILES_${PN}-dev = "${kerneldir}/i2c_dev_sysfs.h"
