package win.elegentjs.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址帮助类，可用于查找域名对应IP地址
 */
public class INetAddressSample {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

        inetAddress = InetAddress.getByName("baidu.com");
        System.out.println(inetAddress);


        String cannonicalHostName = inetAddress.getCanonicalHostName();
        System.out.println("canonicalHostName : " + cannonicalHostName);

        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostAddress : " + hostAddress);

        String hostName = inetAddress.getHostName();
        System.out.println("hostName : " + hostName);

        inetAddress = InetAddress.getByAddress(new byte[] {123, 125, 114, 114});
        System.out.println(inetAddress.getHostName());

    }
}
