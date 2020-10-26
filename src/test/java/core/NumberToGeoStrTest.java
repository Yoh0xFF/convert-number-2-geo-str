package core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class NumberToGeoStrTest {
    
    @Test
    public void check0() {
        assertThat(NumberToGeoStr.convert(0), is(equalTo("ნული ლარი")));
    }
    
    @Test
    public void check1() {
        assertThat(NumberToGeoStr.convert(1), is(equalTo("ნული ლარი და ერთი თეთრი")));
    }
    
    @Test
    public void check2() {
        assertThat(NumberToGeoStr.convert(2), is(equalTo("ნული ლარი და ორი თეთრი")));
    }
    
    @Test
    public void check3() {
        assertThat(NumberToGeoStr.convert(3), is(equalTo("ნული ლარი და სამი თეთრი")));
    }
    
    @Test
    public void check4() {
        assertThat(NumberToGeoStr.convert(4), is(equalTo("ნული ლარი და ოთხი თეთრი")));
    }
    
    @Test
    public void check5() {
        assertThat(NumberToGeoStr.convert(5), is(equalTo("ნული ლარი და ხუთი თეთრი")));
    }
    
    @Test
    public void check6() {
        assertThat(NumberToGeoStr.convert(6), is(equalTo("ნული ლარი და ექვსი თეთრი")));
    }
    
    @Test
    public void check7() {
        assertThat(NumberToGeoStr.convert(7), is(equalTo("ნული ლარი და შვიდი თეთრი")));
    }
    
    @Test
    public void check8() {
        assertThat(NumberToGeoStr.convert(8), is(equalTo("ნული ლარი და რვა თეთრი")));
    }
    
    @Test
    public void check9() {
        assertThat(NumberToGeoStr.convert(9), is(equalTo("ნული ლარი და ცხრა თეთრი")));
    }
    
    @Test
    public void check10() {
        assertThat(NumberToGeoStr.convert(10), is(equalTo("ნული ლარი და ათი თეთრი")));
    }
    
    @Test
    public void check20() {
        assertThat(NumberToGeoStr.convert(20), is(equalTo("ნული ლარი და ოცი თეთრი")));
    }
    
    @Test
    public void check30() {
        assertThat(NumberToGeoStr.convert(30), is(equalTo("ნული ლარი და ოცდაათი თეთრი")));
    }
    
    @Test
    public void check40() {
        assertThat(NumberToGeoStr.convert(40), is(equalTo("ნული ლარი და ორმოცი თეთრი")));
    }
    
    @Test
    public void check50() {
        assertThat(NumberToGeoStr.convert(50), is(equalTo("ნული ლარი და ორმოცდაათი თეთრი")));
    }
    
    @Test
    public void check60() {
        assertThat(NumberToGeoStr.convert(60), is(equalTo("ნული ლარი და სამოცი თეთრი")));
    }
    
    @Test
    public void check70() {
        assertThat(NumberToGeoStr.convert(70), is(equalTo("ნული ლარი და სამოცდაათი თეთრი")));
    }
    
    @Test
    public void check80() {
        assertThat(NumberToGeoStr.convert(80), is(equalTo("ნული ლარი და ოთხმოცი თეთრი")));
    }
    
    @Test
    public void check90() {
        assertThat(NumberToGeoStr.convert(90), is(equalTo("ნული ლარი და ოთხმოცდაათი თეთრი")));
    }
    
    @Test
    public void check100() {
        assertThat(NumberToGeoStr.convert(100), is(equalTo("ერთი ლარი")));
    }
    
    @Test
    public void check101() {
        assertThat(NumberToGeoStr.convert(101), is(equalTo("ერთი ლარი და ერთი თეთრი")));
    }
    
    @Test
    public void check100000000000() {
        assertThat(NumberToGeoStr.convert(100000000000L), is(equalTo("მილიარდი ლარი")));
    }
    
    @Test
    public void check999999999999() {
        assertThat(NumberToGeoStr.convert(999999999999L), is(equalTo("ცხრა მილიარდ ცხრაას ოთხმოცდაცხრამეტი მილიონ ცხრაას ოთხმოცდაცხრამეტი ათას ცხრაას ოთხმოცდაცხრამეტი ლარი და ოთხმოცდაცხრამეტი თეთრი")));
    }
}
