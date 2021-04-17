package thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 群聊服务器
 */

public class GroupChatServer {
    private static final int PORT = 8080;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }

    public GroupChatServer() {
        init();
        System.out.println("群聊服务器已启动！");
    }

    /**
     * 初始化
     */
    private void init() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            // 绑定端口号
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            // 设置非阻塞
            serverSocketChannel.configureBlocking(false);
            // select上注册接受连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听
     */
    private void listen() {
        while (true) {
            try {
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        // 连接进来了
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            // selector上注册读事件
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("客户端" + socketChannel.getRemoteAddress() + "上线了！");
                        }
                        // 读事件进来了
                        if (key.isReadable()) {
                            read(key);
                        }
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读消息
     */
    private void read(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int count = socketChannel.read(buffer);
            if (count > 0) {
                String msg = new String(buffer.array());
                System.out.println("客户端" + socketChannel.getRemoteAddress() + "发出数据：" + msg);
                forward(socketChannel, msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转发消息
     */
    private void forward(SocketChannel socketChannel,  String msg) {
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            if (!(channel instanceof SocketChannel)) {
                continue;
            }
            SocketChannel sc = (SocketChannel) channel;
            if (sc == socketChannel) {
                continue;
            }
            try {
                msg = "客户端" + socketChannel.getRemoteAddress() + "说： " + msg;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                sc.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}