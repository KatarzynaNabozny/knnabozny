package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User basia = new Millenials("Basia Dzik");
        User wlad = new YGeneration("Wlad Palownik");
        User bolko = new ZGeneration("Bolek Chrobry");
        //When
        String basiaShuldPublish = basia.sharePost();
        System.out.println("Basia: " + basiaShuldPublish);
        String wladShuldPublish = wlad.sharePost();
        System.out.println("Wlad: " + wladShuldPublish);
        String bolkoShuldPublish = bolko.sharePost();
        System.out.println("Bolko: " + bolkoShuldPublish);
        //Then
        Assertions.assertEquals("Facebook",basiaShuldPublish);
        Assertions.assertEquals("Snapchat",wladShuldPublish);
        Assertions.assertEquals("Twitter",bolkoShuldPublish);
    }
    @Test
    void testIndividualSharingStrategy() {
        //given
        User basia = new Millenials( "Basia Dzik");
        //when
        String basiaShouldPublish = basia.sharePost();
        System.out.println("Basia:" + basiaShouldPublish);
        basia.setSocialPublisherStrategy(new SnapchatPublisher());
        basiaShouldPublish = basia.sharePost();
        System.out.println("Basia now: " + basiaShouldPublish);
        //then
        Assertions.assertEquals("Snapchat",basiaShouldPublish);
    }
}
