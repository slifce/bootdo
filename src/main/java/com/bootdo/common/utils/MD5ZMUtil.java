package com.bootdo.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
* Title: MD5Util
* Description: 
* @author wanchangfu
* @date 2017年12月1日
*/
public class MD5ZMUtil {
	
	public static final String signKey = "zm123InsureWine";

    public static final String DEFAULT_KEY = "KEYFORBUGS";
	
	public static void main(String[] args) {
//        System.out.println(MD5Util.md5To32("12345678"));
		Map<String, String> params = new HashMap<>();
		params.put("paySerial", "A6313034059714560");
		params.put("payTypeInt", "1");
		params.put("total_fee", "0.70");
		String Key = MD5ZMUtil.DEFAULT_KEY;
		String verification = MD5ZMUtil.getSignForPay(params, Key);
		System.out.println(verification);
    }
 
    /**
     *
     * @param plainText
     *            明文
     * @return 32位密文
     */
    public static String md5To32(String plainText) {
    	 String re_md5 = new String();
         try {
             MessageDigest md = MessageDigest.getInstance("MD5");
             md.update(plainText.getBytes());
             byte b[] = md.digest();
  
             int i;
  
             StringBuffer buf = new StringBuffer("");
             for (int offset = 0; offset < b.length; offset++) {
                 i = b[offset];
                 if (i < 0)
                     i += 256;
                 if (i < 16)
                     buf.append("0");
                 buf.append(Integer.toHexString(i));
             }
  
             re_md5 = buf.toString();
  
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }
         return re_md5;
    }
    
    //MD5forSMS
    public final static String MD5(String data) {  
        //用于加密的字符  
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = data.getBytes("UTF-8");  
               
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
               
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
               
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
               
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }  
               
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    } 

    
    /**
     * 获取短信验证签名
     * @param content 短信内容
     * @param Key1 
     * @param Key2
     * @return 验证签名
     */
    public static String getCode(String content, String Key1, String Key2) {
		String toReturn = MD5ZMUtil.MD5(MD5ZMUtil.MD5(content + Key1) + Key2);
		return toReturn;
	}
    
    /**
     * 支付、财务流接口签名加密
     * @param params 参数map
     * @param Key 签名密钥
     * @return
     */
    public static String getSignForPay(Map<String, String> params, String Key){
    	String pa = JSON.toJSONString(params, SerializerFeature.MapSortField);
    	return MD5ZMUtil.MD5(pa + Key);
    }
    
    public static String GetMd5_Tpy(String dataSource) {
    	String md51 = MD5("zhongmin_tpy").toLowerCase();
    	return MD5(md51+dataSource).toLowerCase();
    }

    
}
