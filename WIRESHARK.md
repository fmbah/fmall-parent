# Wireshark
1. 软件使用调试
    1. 抓包原理
        * 本机环境---直接抓包本机网卡的进出流量----Npcap Loopback Adapter 监听本机流量
        * 集线器环境，看不懂IP MAC 向网络里所有的机器发送数据包，物理层
        * 交换机环境，链路层、网络层，端口镜像 将局域网内的端口copy到宿主机器的端口上，这样wireshark可以抓取当前网卡的端口数据
        * ARP欺骗
        * MAC泛洪

2. 初始化界面
    * 选择网卡
    * 停止抓包
    * 保存数据包
        * 显示大小、列修改、时间显示、参考时间
        * 名字解析：Capture->options->name resolution(statistics->resolved address)
    * 标记数据包 mark 配置数据包颜色 
    * 备注数据包
    * 数据包合并（file-merge）
    * 打印数据包
    * 导出数据包
3. 首选项设置：修改默认打开目录（edit->）、布局、列修改、字体、
4. 抓包选项设置：capture->options,[混淆模式](https://www.zhihu.com/question/28838507/answer/221311431)
    * 多文件（大小、时间、轮询）？
    * 过滤器？
        ```` 
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
        ````
                        
    * 显示过滤器？
        ````   
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
        ````

    * 定时器？

    * 数据流追踪：tcp stream 
     
2. 协议分析实战
    1. icmp包
    2. http请求
3. 网络故障分析
    统计分析：端点（Endpoints） 分析流量大小估计网络使用情况
              查看会话（Conversations），会话跟端点的区别在于会区别显示哪两个IP在通信，且各自都发送多大的数据等
              协议分层（Protocol Hierarchy Statistics），从该窗口中可看出是哪些协议的流量比较多
4. 编程实例分析
    1. tcp/ip 传输控制协议
        * 应用层：FTP、HTTP、TELNET、SMTP、DNS....
        * 传输层：TCP协议与UDP协议
        * 网络层：IP协议、ICMP协议、
        * 链路层：arp
    2. Socket 套接字： 基于TCP/IP协议开发的网络编程； 
              设计模式：门面模式
    ````
        
    ````


[官网](www.wireshark.org)
[书籍](www.wiresharkbook.com)
[wiki](wiki.wireshark.com)
[参考](https://www.toutiao.com/a6725575711781814795/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1566170867&app=news_article&utm_source=weixin&utm_medium=toutiao_android&req_id=201908190727470101520190682088304&group_id=6725575711781814795)
[门面模式](https://www.runoob.com/w3cnote/facade-pattern-3.html)