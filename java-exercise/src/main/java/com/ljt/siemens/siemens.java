package com.ljt.siemens;

import com.ljt.simatic.SimaticClient;

public class siemens {
        public static void main(String[] args) {
            try {

                SimaticClient client = new SimaticClient("192.168.1.201", 102);

                int count = 16;
                byte[] values = createValues(1, count);

                // client.send(messages); // 发送自定义报文

                client.write(0, values); // 从VB0 开始写入 values
                byte[] result =client.read(0, count);   // 从VB0 开始读取 count个数据

                //打印：第一行为下标，第二行以10进制显示结果，第三行以16进制显示结果
                SimaticClient.print("返回读取VB区的数据【25】起：", result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //生成简单的测试数据：
        public static byte[] createValues(int min, int count) {
            byte[] values = new byte[count];
            for (int i = 0; i < count; i++) {
                values[i] = (byte) (i + min);// 注意：大于127时，数据溢出错误
            }
            return values;
        }

    }