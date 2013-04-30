package com.controlgroup.ci.jenkinsgithubcommitstatus;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vikash
 * Date: 4/28/13
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationTest extends TestCase {

    private Notification notification;
    private final String TEST_REPO = "testrepo";
    private final String TEST_OWNER = "testowner";
    private final String COMMIT_SHA = "abcd";

    @Before
    public void setUp(){
        notification = new Notification();
        notification.setRepoName(TEST_REPO);
        notification.setRepoOwner(TEST_OWNER);
        notification.setCommitSha(COMMIT_SHA);
    }

    @Test
    public void testShouldHaveCorrectRepositoryName(){
        assertTrue(notification.getRepoName().equalsIgnoreCase(TEST_REPO));
    }

    @Test
    public void testShouldHaveCorrectRepositoryOwner(){
        assertTrue(notification.getRepoOwner().equalsIgnoreCase(TEST_OWNER));
    }

    @Test
    public void testShouldHaveCorrectCommitSha(){
        assertTrue(notification.getCommitSha().equalsIgnoreCase(COMMIT_SHA));
    }
}
