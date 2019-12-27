package shopping.Utils;

public class StringUtil {
    /**
     *  判断字符串是否为空
     * @param stu
     * @return
     */
    public static boolean isNotNull(String stu){
        return stu != null && !"".equals(stu);
    }

    /**
     *  将字符串转成Integer
     * @param stuNo
     * @param defValue
     * @return
     */
    public static Integer String2int(String stuNo,Integer defValue){
        if(isNotNull(stuNo)){
            try {
                return Integer.parseInt(stuNo);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return defValue;
    }

    /**
     * 将字符串转成Double
     * @param stuNo
     * @param defValue
     * @return
     */
    public static Double String2Db(String stuNo,Integer defValue){
        if(isNotNull(stuNo)){
            try {
                return Double.parseDouble(stuNo);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return (double)defValue;
    }


    /**
     *      用于字符串数组转换成字符串，不带中括号
     * @param arr
     * @return
     */
    public  static String printStr(String[] arr){
        if (arr != null) {
            StringBuffer sf = new StringBuffer();
            for(int i = 0;i < arr.length;i++) {
                sf.append(arr[i]);
                if(i!=arr.length-1){
                    sf.append(",");
                }
            }
            return sf.toString();
        }
        return null;
    }


    /**
     *     将字符串转换成int数组
     * @param arr   获取的字符串
     * @return
     */
    public static int[] getInt(String arr) {
        if (isNotNull(arr)) {
            String[] arrStr = arr.split(",");
            int[] arr1 = new int[arrStr.length];
            for (int i = 0; i < arrStr.length; i++) {
                arr1[i] = Integer.parseInt(arrStr[i]);
            }
            return arr1;
        }
        return null;

    }
}
