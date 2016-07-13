package com.alone.common.util;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-8 下午11:28
 */
public class Utils {
    private static long __previous_time__ = 0L;
    private static int __machine_key__ = 0;
    private static int __sequence_no__ = 0;

    public static <T> T java2Thrift(T thrift, Object java) {
        for (Field field : java.getClass().getDeclaredFields()) {
            try {
                Object value = ReflectionUtils.getFieldValue(java, field.getName());
                if (value != null) {
                    Method invoke = ReflectionUtils.getSetMethod(thrift.getClass(), field.getName());
                    if (invoke != null) {
                        invoke.invoke(thrift, value);
                    }
                }
            } catch (Exception ignored) {}
        }
        return thrift;
    }

    public static int[] ipv4ToIntArray(String c) {
        if (StringUtils.isEmpty(c))
            return null;
        Matcher match = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$").matcher(c);
        if (match.matches()) {
            int ip1 = Integer.parseInt(match.group(1));
            int ip2 = Integer.parseInt(match.group(2));
            int ip3 = Integer.parseInt(match.group(3));
            int ip4 = Integer.parseInt(match.group(4));
            if (ip1 < 0 || ip1 > 255 || ip2 < 0 || ip2 > 255 || ip3 < 0
                    || ip3 > 255 || ip4 < 0 || ip4 > 255)
                return null;
            else
                return new int[] { ip1, ip2, ip3, ip4 };
        } else {
            return null;
        }
    }

    public static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized static long generateUUID() {
        if (__machine_key__ == 0L) {
            // 获取本机IP地址
            int[] args = ipv4ToIntArray(getFristIPv4());
            if (args == null)
                args = new int[] { (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255) };
            __machine_key__ = args[0] + args[1] + args[2] + args[3];
            if (__machine_key__ > 999)
                __machine_key__ -= 1000;
            __machine_key__ = (__machine_key__ * 1000)
                    + ((int) (Math.random() * 9) * 100)
                    + ((int) (Math.random() * 9) * 10);
        }

        long now = System.currentTimeMillis();
        if (now == __previous_time__) {
            __sequence_no__++;
        } else {
            __previous_time__ = now;
            __sequence_no__ = 0;
        }
        return __previous_time__ * 1000 + __machine_key__ + __sequence_no__;
    }

    /*
	 * 获取序列网卡上第一个IP地址, 外网地址优先返回
	 *
	 *
	 */
    public static String getFristIPv4() {
        String localip 	= null;	// 本地IP，如果没有配置外网IP则返回它
        String netip 	= null;	// 外网IP
        try{
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;// 是否找到外网IP
            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    } else if (localip == null
                            && ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        localip = ip.getHostAddress();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
}
