#source: load1.s
#as: --x32
#ld: -shared -melf32_x86_64
#objdump: -dw
#target: x86_64-*-nacl*

.*: +file format .*

Disassembly of section .text:

0+ <_start>:
[ 	]*[a-f0-9]+:	13 05 e2 01 01 10    	adc    0x100101e2\(%rip\),%eax        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	03 1d dc 01 01 10    	add    0x100101dc\(%rip\),%ebx        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	23 0d d6 01 01 10    	and    0x100101d6\(%rip\),%ecx        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	3b 15 d0 01 01 10    	cmp    0x100101d0\(%rip\),%edx        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	0b 35 ca 01 01 10    	or     0x100101ca\(%rip\),%esi        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	1b 3d c4 01 01 10    	sbb    0x100101c4\(%rip\),%edi        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	2b 2d be 01 01 10    	sub    0x100101be\(%rip\),%ebp        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	44 33 05 b7 01 01 10 	xor    0x100101b7\(%rip\),%r8d        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	44 85 3d b0 01 01 10 	test   %r15d,0x100101b0\(%rip\)        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 13 05 a9 01 01 10 	adc    0x100101a9\(%rip\),%rax        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 03 1d a2 01 01 10 	add    0x100101a2\(%rip\),%rbx        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 23 0d 9b 01 01 10 	and    0x1001019b\(%rip\),%rcx        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 3b 15 94 01 01 10 	cmp    0x10010194\(%rip\),%rdx        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 0b 3d 8d 01 01 10 	or     0x1001018d\(%rip\),%rdi        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 1b 35 86 01 01 10 	sbb    0x10010186\(%rip\),%rsi        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	48 2b 2d 7f 01 01 10 	sub    0x1001017f\(%rip\),%rbp        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	4c 33 05 78 01 01 10 	xor    0x10010178\(%rip\),%r8        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	4c 85 3d 71 01 01 10 	test   %r15,0x10010171\(%rip\)        # 100101e8 <_DYNAMIC\+0x70>
[ 	]*[a-f0-9]+:	13 05 73 01 01 10    	adc    0x10010173\(%rip\),%eax        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	03 1d 6d 01 01 10    	add    0x1001016d\(%rip\),%ebx        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	23 0d 67 01 01 10    	and    0x10010167\(%rip\),%ecx        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	3b 15 61 01 01 10    	cmp    0x10010161\(%rip\),%edx        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	0b 35 5b 01 01 10    	or     0x1001015b\(%rip\),%esi        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	1b 3d 55 01 01 10    	sbb    0x10010155\(%rip\),%edi        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	2b 2d 4f 01 01 10    	sub    0x1001014f\(%rip\),%ebp        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	44 33 05 48 01 01 10 	xor    0x10010148\(%rip\),%r8d        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	44 85 3d 41 01 01 10 	test   %r15d,0x10010141\(%rip\)        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 13 05 3a 01 01 10 	adc    0x1001013a\(%rip\),%rax        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 03 1d 33 01 01 10 	add    0x10010133\(%rip\),%rbx        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 23 0d 2c 01 01 10 	and    0x1001012c\(%rip\),%rcx        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 3b 15 25 01 01 10 	cmp    0x10010125\(%rip\),%rdx        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 0b 3d 1e 01 01 10 	or     0x1001011e\(%rip\),%rdi        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 1b 35 17 01 01 10 	sbb    0x10010117\(%rip\),%rsi        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	48 2b 2d 10 01 01 10 	sub    0x10010110\(%rip\),%rbp        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	4c 33 05 09 01 01 10 	xor    0x10010109\(%rip\),%r8        # 100101f0 <_DYNAMIC\+0x78>
[ 	]*[a-f0-9]+:	4c 85 3d 02 01 01 10 	test   %r15,0x10010102\(%rip\)        # 100101f0 <_DYNAMIC\+0x78>
#pass
