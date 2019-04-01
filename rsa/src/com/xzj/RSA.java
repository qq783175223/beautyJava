package com.xzj;
/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月1日 下午2:01:05
*/
public class RSA {
    /**
     * 
     * 算法：
     *   (1)选择两个不同的大素数p和q；
     *   (2)计算乘积n=pq和Φ(n)=(p-1)(q-1)；
     *   (3)选择大于1小于Φ(n)的随机整数e，使得gcd(e,Φ(n))=1；注：gcd即最大公约数。
     *   (4)计算d使得d*e=1mod Φ(n)；注：即d*e mod Φ(n) =1。
     *   (5)对每一个密钥k=(n,p,q,d,e)，定义加密变换为Ek(x)=xe mod n，解密变换为Dk(x)=yd mod n，这里x,y∈Zn；
     *   (6)p,q销毁，以{e,n}为公开密钥，{d,n}为私有密钥。
	 *
     * 实例：
     *   1. 假设p = 3、q = 11（p，q都是素数即可。），则N = pq = 33；
     *   2. r =Φ(n)= (p-1)(q-1) = (3-1)(11-1) = 20；
     *   3. 根据gcd(e,Φ(n))=1，即gcd(e,20)=1，令e=3，则，d = 7。（两个数交换一下也可以。）
	 *
     * 到这里，公钥和密钥已经确定。公钥为(N, e) = (33, 3)，密钥为(N, d) = (33, 7)。
     * 
     * @param key 公钥或密钥
     * @param message 数据
     * @return
     */
    public static long rsa(int baseNum, int key, long message){
        if(baseNum < 1 || key < 1){
            return 0L;
        }
        //加密或者解密之后的数据
        long rsaMessage = 0L;
           
        //加密核心算法
        rsaMessage = Math.round(Math.pow(message, key)) % baseNum;
        return rsaMessage;
    }
 
    public static void main(String[] args){
        //基数
        int baseNum = 3 * 11;
        //公钥
        int keyE = 3;
        //密钥
        int keyD = 7;
        //未加密的数据
        long msg = 5L;
        //加密后的数据
        long encodeMsg = rsa(baseNum, keyE, msg);
        //解密后的数据
        long decodeMsg = rsa(baseNum, keyD, encodeMsg);
           
        System.out.println("加密前：" + msg);
        System.out.println("加密后：" + encodeMsg);
        System.out.println("解密后：" + decodeMsg);
    }
} 
