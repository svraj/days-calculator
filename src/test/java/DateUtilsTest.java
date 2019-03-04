import com.sajan.calculator.dto.CustomDate;
import org.junit.Assert;
import org.junit.Test;

import static com.sajan.calculator.utils.DateUtils.calculateDays;
import static com.sajan.calculator.utils.DateUtils.getNextDate;

public class DateUtilsTest {

    @Test
    public void test_next_date1(){
        CustomDate customDate = new CustomDate(3,2,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(4,2,2018),nextDate);
    }

    @Test
    public void test_next_date2(){
        CustomDate customDate = new CustomDate(27,2,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(28,2,2018),nextDate);
    }

    @Test
    public void test_next_date3(){
        CustomDate customDate = new CustomDate(28,2,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(01,03,2018),nextDate);
    }

    @Test
    public void test_next_date4(){
        CustomDate customDate = new CustomDate(28,2,2000);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(29,2,2000),nextDate);
    }

    @Test
    public void test_next_date5(){
        CustomDate customDate = new CustomDate(30,12,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(31,12,2018),nextDate);
    }

    @Test
    public void test_next_date6(){
        CustomDate customDate = new CustomDate(31,12,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(1,1,2019),nextDate);
    }

    @Test
    public void test_next_date7(){
        CustomDate customDate = new CustomDate(15,3,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(16,3,2018),nextDate);
    }

    @Test
    public void test_next_date8(){
        CustomDate customDate = new CustomDate(30,4,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(1,5,2018),nextDate);
    }

    @Test
    public void test_next_date9(){
        CustomDate customDate = new CustomDate(30,7,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(31,7,2018),nextDate);
    }

    @Test
    public void test_next_date10(){
        CustomDate customDate = new CustomDate(31,7,2018);
        CustomDate nextDate = getNextDate(customDate);
        System.out.println(nextDate);
        Assert.assertEquals(new CustomDate(1,8,2018),nextDate);
    }

    @Test
    public void test_calculate_days1(){
        CustomDate start = new CustomDate(3,2,2018);
        CustomDate end =  new CustomDate(3,2,2018);
        Assert.assertEquals(0, calculateDays(start,end));
    }

    @Test
    public void test_calculate_days2(){
        CustomDate start = new CustomDate(2,6,1983);
        CustomDate end =  new CustomDate(22,6,1983);
        Assert.assertEquals(19, calculateDays(start,end));
    }

    @Test
    public void test_calculate_days3(){
        CustomDate start = new CustomDate(4,7,1984);
        CustomDate end =  new CustomDate(25,12,1984);
        Assert.assertEquals(173, calculateDays(start,end));
    }

   /* @Test
    public void test_calculate_days4(){
        //End should be after start
        CustomDate start = new CustomDate(3,1,1989);
        CustomDate end =  new CustomDate(3,8,1983);
        Assert.assertEquals(1979,DateUtils.calculateDays(start,end));
    }*/

    @Test
    public void test_calculate_days5(){
        CustomDate start =  new CustomDate(3,8,1983);
        CustomDate end = new CustomDate(3,1,1989);
        Assert.assertEquals(1979, calculateDays(start,end));
    }

    @Test
    public void test_calculate_days6(){
        CustomDate start =  new CustomDate(7,11,1972);
        CustomDate end = new CustomDate(8,11,1972);
        Assert.assertEquals(0, calculateDays(start,end));
    }

    @Test
    public void test_calculate_days7(){
        CustomDate start =  new CustomDate(1,1,2000);
        CustomDate end = new CustomDate(3,1,2000);
        Assert.assertEquals(1, calculateDays(start,end));
    }

    @Test
    public void test_calculate_days8(){
        CustomDate start =  new CustomDate(1,1,1901);
        CustomDate end = new CustomDate(31,12,2999);
        Assert.assertEquals(401407, calculateDays(start,end));
    }
}