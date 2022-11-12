package com.example.junittest.iloveyouboss;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
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
}