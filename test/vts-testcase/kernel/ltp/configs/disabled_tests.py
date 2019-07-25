# Tests disabled
# Based on external/ltp commit 5f01077afe994f4107b147222f3956716d4a8fde
DISABLED_TESTS = [
    # b/32386191 getrusage04 result is flaky
    'syscalls.getrusage04',
    # b/31154962
    'cpuhotplug.cpuhotplug02',
    # The following test cases are uncategorized
    'syscalls.chown01_16',
    'syscalls.chown02_16',
    'syscalls.chown03_16',
    'syscalls.chown05_16',
    'syscalls.fchown04',
    'syscalls.fchown01_16',
    'syscalls.fchown02_16',
    'syscalls.fchown03_16',
    'syscalls.fchown04_16',
    'syscalls.fchown05_16',
    'syscalls.getegid01_16',
    'syscalls.getegid02_16',
    'syscalls.geteuid01_16',
    'syscalls.geteuid02_16',
    'syscalls.getgid01_16',
    'syscalls.getgid03_16',
    'syscalls.getgroups01_16',
    'syscalls.gethostbyname_r01',
    'syscalls.getuid01_16',
    'syscalls.getuid03_16',
    'syscalls.ioctl03',
    'syscalls.inotify03',
    'syscalls.lchown03',
    'syscalls.lchown01_16',
    'syscalls.lchown02_16',
    'syscalls.lchown03_16',
    'syscalls.mmap16',
    'syscalls.mprotect01',
    'syscalls.nftw01',
    'syscalls.nftw6401',
    'syscalls.nice04',
    'syscalls.open08',
    'syscalls.open11',
    'syscalls.pathconf01',
    'syscalls.preadv02',
    'syscalls.pwritev02',
    'syscalls.rt_sigprocmask01',
    'syscalls.setfsgid01_16',
    'syscalls.setfsgid02_16',
    'syscalls.setfsgid03_16',
    'syscalls.setfsuid01_16',
    'syscalls.setfsuid02_16',
    'syscalls.setfsuid03_16',
    'syscalls.setfsuid04_16',
    'syscalls.setgid01_16',
    'syscalls.setgid02_16',
    'syscalls.setgid03_16',
    'syscalls.setgroups01_16',
    'syscalls.setgroups02_16',
    'syscalls.setgroups03_16',
    'syscalls.setgroups04_16',
    'syscalls.setregid02',
    'syscalls.setregid03',
    'syscalls.setregid04',
    'syscalls.setregid01_16',
    'syscalls.setregid02_16',
    'syscalls.setregid03_16',
    'syscalls.setregid04_16',
    'syscalls.setresgid01_16',
    'syscalls.setresgid02_16',
    'syscalls.setresgid03_16',
    'syscalls.setresgid04_16',
    'syscalls.setresuid01_16',
    'syscalls.setresuid02_16',
    'syscalls.setresuid03_16',
    'syscalls.setresuid04_16',
    'syscalls.setresuid05_16',
    'syscalls.setreuid01_16',
    'syscalls.setreuid02_16',
    'syscalls.setreuid03_16',
    'syscalls.setreuid04_16',
    'syscalls.setreuid05_16',
    'syscalls.setreuid06_16',
    'syscalls.setreuid07_16',
    'syscalls.setuid01_16',
    'syscalls.setuid02_16',
    'syscalls.setuid03_16',
    'syscalls.setuid04_16',
    'syscalls.splice02',
    'syscalls.sysconf01',
    'syscalls.utimensat01',
    'fs.gf01',
    'fs.gf02',
    'fs.gf03',
    'fs.gf04',
    'fs.gf05',
    'fs.gf06',
    'fs.gf07',
    'fs.gf08',
    'fs.gf09',
    'fs.gf10',
    'fs.gf11',
    'fs.gf14',
    'fs.gf15',
    'fs.gf16',
    'fs.gf17',
    'fs.gf18',
    'fs.gf19',
    'fs.gf20',
    'fs.gf21',
    'fs.gf22',
    'fs.gf23',
    'fs.gf24',
    'fs.gf25',
    'fs.gf26',
    'fs.gf27',
    'fs.gf28',
    'fs.gf29',
    'fs.gf30',
    'fs.rwtest01',
    'fs.rwtest02',
    'fs.rwtest03',
    'fs.rwtest04',
    'fs.rwtest05',
    'fs.iogen01',
    'fs.isofs',
    'fsx.fsx-linux',
    'mm.mtest06',
    'mm.shm_test01',
    'mm.mallocstress01',
    'mm.vma03',
    'mm.min_free_kbytes',
    'pipes.pipeio_1',
    'pipes.pipeio_3',
    'pipes.pipeio_4',
    'pipes.pipeio_5',
    'pipes.pipeio_6',
    'pipes.pipeio_8',
    'sched.trace_sched01',
    'math.float_bessel',
    'math.float_exp_log',
    'math.float_iperb',
    'math.float_power',
    'math.float_trigo',
    'fs_bind.BindMounts',
    'filecaps.Filecaps',
    'cap_bounds.Cap_bounds',
    'fcntl-locktests_android.FCNTL_LOCKTESTS',
    'numa.move_pages03',
    'numa.move_pages11',
    'hugetlb.hugemmap05_1',
    'hugetlb.hugemmap05_2',
    'hugetlb.hugemmap05_3',
    'hyperthreading.smt_smp_enabled',
    'hyperthreading.smt_smp_affinity',
    'kernel_misc.zram03',
    'fs_ext4.ext4-uninit-groups',
    'fs_ext4.ext4-persist-prealloc',
    'cpuhotplug.cpuhotplug03',
    'cpuhotplug.cpuhotplug06',
    'dio.dio10',
    # dio29 and dio30 take too long to finish
    'dio.dio29',
    'dio.dio30',
    'fsx.fsx-linux',
    'dio.dio04',
    'numa.Numa-testcases',
    'syscalls.connect01',
    'syscalls.prot_hsymlinks',
    'fs.ftest01',
    'fs.ftest03',
    'fs.ftest04',
    'fs.ftest05',
    'fs.ftest07',
    'fs.ftest08',
    'fs.inode02',
    'ipc.signal_test_01',
    'mm.mmapstress10',
    'syscalls.fcntl14',
    'syscalls.fcntl14',
    'syscalls.fcntl14_64',
    'syscalls.fcntl17',
    'syscalls.fcntl17_64',
    'syscalls.kill12',
    'syscalls.sigpending02',
    'syscalls.sigrelse01',
    'syscalls.vfork02',
    # The following tests are not stable on 64bit version
    'input.input01_64bit',
    'input.input02_64bit',
    'input.input04_64bit',
    'input.input05_64bit',
    'input.input06_64bit',
    'input.input06_32bit',
    # The following tests are failing on 64bit version
    'mm.overcommit_memory01_64bit',
    'mm.overcommit_memory02_64bit',
    'mm.overcommit_memory03_64bit',
    'mm.overcommit_memory04_64bit',
    'mm.overcommit_memory05_64bit',
    'mm.overcommit_memory06_64bit',
    # tests that are currently killing some lab devices 64bit on (pixel and bullhead)
    # b/31181781
    'mm.oom01_64bit',
    'mm.oom02_64bit',
    'mm.oom03_64bit',
    'mm.oom04_64bit',
    'mm.oom05_64bit',
    'mm.swapping01_64bit',
    'mm.thp01_64bit',
    'mm.thp02_64bit',
    'mm.thp03_64bit',
    'mm.vma01_64bit',
    # b/65636203
    'mm.thp01_32bit',
    # kmsg01 would pass but it occasionally causes socket timeout and misalignment
    # of request and response
    # b/32343072
    'kernel_misc.kmsg01',
    # alarm02 tests for a boundary condition which is impractical to implement
    # correctly on 32-bit Linux.  bionic deliberately breaks with POSIX by reporting
    # that it failed to set up the alarm.  (Other libc implementations fail to
    # set up the alarm too, but then return 0 anyway.)
    'syscalls.alarm02',
    # readdir02 calls opendir() -> closedir() -> readdir() and checks if readdir()
    # returns EBADF.  POSIX doesn't require this, and bionic is likely to instead
    # deadlock trying to acquire a destroyed mutex.
    'syscalls.readdir02',
    # Android sets RLIMIT_NICE to 40, so setpriority02 succeeds unexpectedly
    'syscalls.setpriority02',
    # fork13 takes ~45 minutes to run
    'syscalls.fork13',
    # open13 tests that fchmod() fails on fds opened with O_PATH.  bionic
    # deliberately masks the EBADF returned by the kernel.
    #
    # https://android-review.googlesource.com/#/c/127908/
    'syscalls.open13',
    # Bug#30675453
    'syscalls.perf_event_open02',
    # Bug#30688551
    'syscalls.lstat03_64',
    'syscalls.lstat03',
    # Bug#30688056
    'cpuhotplug.cpuhotplug04',
    # Bug#30699880
    'mm.mtest01w',
    'mm.mtest01',
    # Bug#30688574
    'syscalls.accept4_01',
    # Bug #32100169
    'dma_thread_diotest.dma_thread_diotest1',
    'dma_thread_diotest.dma_thread_diotest2',
    'dma_thread_diotest.dma_thread_diotest3',
    'dma_thread_diotest.dma_thread_diotest4',
    'dma_thread_diotest.dma_thread_diotest5',
    'dma_thread_diotest.dma_thread_diotest6',
    'dma_thread_diotest.dma_thread_diotest7',
    # b/33008689 (closed) requires mkfs.ext4 and loop device support.
    'fs.quota_remount_test01',
    # https://b/65053723#comment19 (Flaky due to timeout dependency)
    'syscalls.pselect01',
    # https://b/65053723#comment20 (seems to test for "xfs" specific bug)
    'syscalls.getxattr04',
    # Following tests added in LTP20170516 release are disabled because
    # they currently fail with VTS
    'syscalls.access04',
    'syscalls.ioctl04',
    'syscalls.ioctl06',
    'syscalls.kcmp03',
    # TODO(b/67981135): Following tests added in LTP20170929 release are
    # disabled because they currently fail with VTS
    'mm.max_map_count_64bit',
    'mm.max_map_count_32bit',
    # TODO(b/69117476): Following test needs to be checked to see it
    # it correctly skips running
    'tracing.ftrace_regression01',
    # b/71780005: causes /data to get filled repeatedly
    'fs.fs_racer_32bit',
    'fs.fs_racer_64bit',
    # b/71414136: fails in VTS
    'commands.file01',
    # b/71415362: fails in VTS
    'fs.proc01',
    # b/71416672: fails in VTS
    'mm.ksm01_1',
    'mm.ksm01',
    'mm.ksm03_1',
    'mm.ksm03',
    # b/71416706: fails in VTS
    'syscalls.cve-2017-5669',
    # b/71416738: fails in VTS
    'syscalls.fcntl35_64',
    'syscalls.fcntl35',
    # b/71416760: fails in VTS
    'syscalls.fcntl36_64',
    'syscalls.fcntl36',
    # b/71416822: fails in VTS
    'tracing.dynamic_debug01',
    # (TODO): b/73784987
    'syscalls.mount03',
]