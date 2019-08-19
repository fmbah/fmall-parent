# Wireshark
1. 软件使用调试
1.抓包原理（本机环境---直接抓包本机网卡的进出流量
集线器环境，看不懂IP MAC 向网络里所有的机器发送数据包，物理层
交换机环境，链路层、网络层，端口镜像 将局域网内的端口copy到宿主机器的端口上，这样wireshark可以抓取当前网卡的端口数据
ARP欺骗
MAC泛洪）

初始化界面、选择网卡、停止抓包、保存数据包
显示大小、列修改、时间显示、参考时间
名字解析：Capture->options->name resolution(statistics->resolved address)
   
标记数据包 mark 配置数据包颜色 备注数据包， 数据包合并（file-merge），打印数据包，导出数据包
首选项设置：修改默认打开目录（edit->）、布局、列修改、字体、
抓包选项设置：capture->options,混淆模式？多文件（大小、时间、轮询）？
过滤器？（
抓包过滤器？BPF语法
    类型： host/net/port
    方向：src/dst
    协议:ether/ip/tcp/udp/http/ftp
    逻辑运算符：&& 与、 ||或、!非
    src host 192.168.1.1 && dst port 80 抓取源地址 与 目的端口的数据包
    host 192.168.1.1 && host 192.168.1.2
    !broadcast 不要广播包
    
    过滤mac地址：ether host macAddress
                ether src host macAddress
                ether dst host macAddress
    过滤IP地址： host ip
                host src ip
                host dst ip
    过滤端口：   port 80
    协议过滤：   arp
               icmp
      
    
显示过滤器？
    比较操作符： == 等于  !=不等于   > 大于 <小于  >= <=
    逻辑操作符： and or  xor有且仅有一个条件满足 not没有条件满足
    ip地址：ip.addr ip.src  ip.dst
    端口过滤：tcp.port tcp.srcport tcp.dstport tcp.flag.syn tcp.flag.ack
    协议过滤： arp ip icmp udp tcp bootp dns
    
    过滤IP： ip.addr == 192.168.6.106
            ip.src == 192.168.6.106 
            ip.dst == 192.168.6.106
            ip.src == 192.168.6.106 and ip.dst == 192.168.6.106 
    过滤端口：tcp.port == 80
            tcp.srcport == 80
            tcp.dstport == 80
            tcp.flag.syn == 1 
    协议过滤： arp
                tcp
                udp
                not http
                not arp
    ip.src == 192.168.6.106 and tcp.port == 80
    ip.addr == 192.168.6.106 and udp.port == 4000 
    ）
定时器？

数据流追踪：tcp stream 
专家信息说明
     
2. 协议分析实战
3. 网络故障分析 


【www.wireshark.org】
【www.wiresharkbook.com】
【wiki.wireshark.com】