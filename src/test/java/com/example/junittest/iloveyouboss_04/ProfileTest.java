package com.example.junittest.iloveyouboss_04;

import com.example.junittest.iloveyouboss_06.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
    // 각 테스트들은 순서대로 실행되지 않는다.
    // 매 메서드마다 새로운 인스턴스 실행함.
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before // 먼저 실행된다.
    public void create() {
        // 중복코드들
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswerFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        boolean matches = profile.matches(criteria);

        Assert.assertFalse(matches);
    }

    @Test
    public void matchAnswerTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        boolean matches = profile.matches(criteria);

        Assert.assertTrue(matches);
    }
}
