package sy.test;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by jiaranran on 2016/6/25.
 */
public class CommonsLangTest {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,4,5};
        ArrayUtils.reverse(intArray);
        System.out.println(intArray[0]);

    }
}
