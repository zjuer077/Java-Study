package com.ljt.simatic;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;


    /***
     * SIMATIC S7-200 SMART CPU SR60
     * 西门子PLC通信案例
     *
     * @author 何智潮
     * 微信: QQ11527773
     * 邮箱: 11527773@qq.com
     *
     */
    public class SimaticClient {

        protected final byte[] header = { 0x03, 0x00, 0x00, 0x16, 0x11, (byte) 0xE0, 0x00, 0x00, 0x00, 0x01, 0x00, (byte) 0xC1, 0x02, 0x01, 0x00, (byte) 0xC2, 0x02, 0x01, 0x01, (byte) 0xC0, 0x01, 0x09 };
        protected final byte[] header2 = { 0x03, 0x00, 0x00, 0x19, 0x02, (byte) 0xF0, (byte) 0x80, 0x32, 0x01, 0x00, 0x00, (byte) 0xCC, (byte) 0xC1, 0x00, 0x08, 0x00, 0x00, (byte) 0xF0, 0x00, 0x00, 0x01, 0x00, 0x01, 0x03, (byte) 0xC0 };

        protected final byte[] READ = { 0x03, 0x00, 0x00, 0x1F, 0x02, (byte) 0xF0, (byte) 0x80, 0x32, 0x01, 0x00, 0x00, 0x00, 0x1C, 0x00, 0x0E, 0x00, 0x00, 0x04, 0x01, 0x12, 0x0A, 0x10, 0x02, 0x00, 0x03, 0x00, 0x01, (byte) 0x84, 0x00, 0x00,
                0x08 };
        protected final byte[] WRITE = { 0x03, 0x00, 0x00, 0x24, 0x02, (byte) 0xF0, (byte) 0x80, 0x32, 0x01, 0x00, 0x00, 0x00, 0x05, 0x00, 0x0E, 0x00, 0x05, 0x05, 0x01, 0x12, 0x0A, 0x10, 0x02, 0x00, 0x01, 0x00, 0x01, (byte) 0x84, 0x00, 0x00,
                0x50, 0x00, 0x04, 0x00, 0x08 };// length=35

        protected String host = "192.168.1.2";
        protected int port = 102;

        protected Socket socket;
        protected InputStream inputStream;
        protected OutputStream outputStream;

        public SimaticClient(String host, int port) {
            super();
            this.host = host;
            this.port = port;
        }

        protected void connect() {
            try {
                if (socket != null && socket.isConnected())
                    return;
                socket = new Socket(host, port);
                outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                send(header);
                send(header2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /***
         * 发送报文
         *
         * @param messages
         *            报文
         * @return 返回响应的结果
         */
        public byte[] send(byte[] messages) {
            connect();
            byte[] result = null;
            try {
                outputStream.write(messages);
                outputStream.flush();
                byte[] first = new byte[4];
                int size = 0;
                int count = -1;
                byte[] b = new byte[1];
                while (true) {
                    count++;
                    if (size > 4 && count >= size)
                        break;
                    if (inputStream.read(b) == -1)
                        break;
                    if (count < 4)
                        first[count] = b[0];
                    if (count == 3) {
                        size = ((0 | first[2]) << 8) | first[3];
                        result = new byte[size];
                        result[0] = first[0];
                        result[1] = first[1];
                        result[2] = first[2];
                        result[3] = first[3];
                    }
                    if (count > 3) {
                        if (result != null && result.length > count)
                            result[count] = b[0];
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        private byte[] readNative(int first, int count) {
            if (count > 102)
                System.out.println("SimaticClient.read(): count不能大于102  !!!!!");
            int value = 0;

            // 起始位置：
            byte[] posistion = new byte[3];
            value = first * 8;
            posistion[0] = (byte) ((value << 8) >> 24);
            value = first * 8;
            posistion[1] = (byte) ((value << 16) >> 24);
            value = first * 8;
            posistion[2] = (byte) ((value << 24) >> 24);
            READ[28] = posistion[0];
            READ[29] = posistion[1];
            READ[30] = posistion[2];

            // 读取数量：
            byte[] length = new byte[2];
            value = count;
            length[0] = (byte) ((value << 16) >> 24);
            value = count;
            length[1] = (byte) ((value << 24) >> 24);
            READ[23] = length[0];
            READ[24] = length[1];

            byte[] result = send(READ);
            return result;

        }

        /***
         * 读取VB区的数据
         *
         * @param first
         *            起始字节
         * @param count
         *            返回的字节数量
         * @return 返回目标数据
         */
        public byte[] read(int first, int count) {
            int origin = 25;
            byte[] nativeResult = readNative(first, count);
            int size = nativeResult.length - origin;
            byte[] result = new byte[size];
            for (int i = 0; i < size; i++) {
                result[i] = nativeResult[i + origin];
            }
            return result;
        }

        /***
         * 向VB区写入数据
         *
         * @param first
         *            起始字节
         * @param values
         *            要写入的数据
         * @return 返回PLC响应的信息
         */
        public byte[] write(int first, byte[] values) {
            if (values == null)
                return null;

            int origin = WRITE.length;// 报文基本长度
            int length = origin + values.length;
            byte[] messages = new byte[length];
            for (int i = 0; i < length; i++) {
                if (i < origin)
                    messages[i] = WRITE[i];
                else
                    messages[i] = values[i - origin];
            }

            int value = 0;// 临时操作值

            // 【2】【3】报文长度：
            value = length;
            messages[2] = (byte) ((value << 16) >> 24);
            value = length;
            messages[3] = (byte) ((value << 24) >> 24);

            // 【15】【16】写入长度：
            value = values.length + 4;
            messages[15] = (byte) ((value << 16) >> 24);
            value = values.length + 4;
            messages[16] = (byte) ((value << 24) >> 24);

            // 【23】【24】写入的数据个数：
            value = values.length;
            messages[23] = (byte) ((value << 16) >> 24);
            value = values.length;
            messages[24] = (byte) ((value << 24) >> 24);

            // 【28】【29】【30】偏移量（起始位置）：
            value = first * 8;
            messages[28] = (byte) ((value << 8) >> 24);
            value = first * 8;
            messages[29] = (byte) ((value << 16) >> 24);
            value = first * 8;
            messages[30] = (byte) ((value << 24) >> 24);

            // 位个数：
            value = 8 * values.length;
            messages[33] = (byte) ((value << 16) >> 24);
            value = 8 * values.length;
            messages[34] = (byte) ((value << 24) >> 24);

            byte[] result = send(messages);
            return result;

        }

        /***
         * 打印数据
         *
         * @param title
         *            标题
         * @param messages
         *            要打印的数据
         */
        public static void print(String title, byte[] messages) {
            if (messages == null) {
                System.out.println("\n SimaticClient.class: 无结果可打印 ");
                return;
            }
            System.out.println("\n" + title);
            // System.out.println("\n 编号：");
            for (int i = 0; i < messages.length; i++) {
                System.out.print("    " + i);
            }
            System.out.println();
            // System.out.println("\n 10 进制：");
            for (byte m : messages) {
                System.out.print("    " + (m & 0xFF));
            }
            System.out.println();
            // System.out.println("\n 16 进制：");
            for (byte m : messages) {
                System.out.print("    " + Integer.toHexString(m & 0xFF).toUpperCase());
            }
            System.out.println("\n");
        }

    }