require recipes-kernel/linux/linux-mainline-common.inc

LINUX_VERSION ?= "5.13.x"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "linux-5.13.y"
SRCREV = "v5.13.19"
SRC_URI = " \
    https://kernel.googlesource.com/pub/scm/linux/kernel/git/stable/linux.git \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI:append:riscv64 = " \
    file://0001-riscv-sifive-fu740-cpu-1-2-3-4-set-compatible-to-sif.patch \
    file://0002-riscv-sifive-unmatched-update-regulators-values.patch \
    file://0003-riscv-sifive-unmatched-define-PWM-LEDs.patch \
    file://0004-riscv-sifive-unmatched-add-gpio-poweroff-node.patch \
    file://0005-SiFive-HiFive-Unleashed-Add-PWM-LEDs-D1-D2-D3-D4.patch \
    file://0006-riscv-sifive-unleashed-define-opp-table-cpufreq.patch \
    file://0007-riscv-enable-generic-PCI-resource-mapping.patch \
    file://29868ae1478fe18231672da94c4e862a03218a25.patch \
    file://riscv-sbi-srst-support.patch \
    "

# Use out-of-tree defconfig
SRC_URI:append = " file://defconfig"

unset KBUILD_DEFCONFIG
COMPATIBLE_MACHINE = "freedom-u540|unmatched|qemuriscv64|qemuriscv64_b|qemuriscv64_b_zfh|qemuriscv64_v"

KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
