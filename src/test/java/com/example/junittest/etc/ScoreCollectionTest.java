package com.example.junittest.etc;

import static org.hamcrest.CoreMatchers.*;

import com.example.junittest.iloveyouboss_04.ScoreCollection;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ScoreCollectionTest  {

    @Test
    public void answer() {
        // 준비
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // 실행
        int actualResult = collection.arithemeticMean();

        // 단언
        Assert.assertThat(actualResult, equalTo(6));
    }

    @Test
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void test2() {
        Assert.assertTrue(false);
    }
}