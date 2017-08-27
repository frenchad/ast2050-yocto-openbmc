#!/usr/bin/env python
#
# Copyright 2017 Raptor Engineering, LLC
# Copyright 2014-present Facebook. All Rights Reserved.
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
#

import subprocess

# Handler for sensors resource endpoint
def get_slotid():
    p = subprocess.Popen('source /usr/local/bin/openbmc-utils.sh;'
                         'asus_slot_id $(asus_board_type)',
                         shell=True, stdout=subprocess.PIPE)
    out, err = p.communicate()
    try:
        slot = int(out.strip('\n'))
    except:
        slot = 0
    return { 'slotid' : slot }
