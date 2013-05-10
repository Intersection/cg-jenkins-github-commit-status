package com.controlgroup.ci.jenkinsgithubcommitstatus;

import hudson.EnvVars;
import hudson.model.AbstractBuild;
import hudson.model.FreeStyleBuild;
import hudson.model.FreeStyleProject;
import hudson.model.Result;
import hudson.slaves.EnvironmentVariablesNodeProperty;
import org.apache.commons.io.FileUtils;
import org.jvnet.hudson.test.HudsonTestCase;

import java.io.IOException;
import java.util.Random;

/**
 * User: vikash
 * Date: 4/28/13
 * Time: 3:18 PM
 */
public class GithubStatusNotificationTest extends HudsonTestCase{

    private final String BUILD_OUTPUT_FORMAT = "POSTING Status of %s to /repos/%s/%s/statuses/%s";
    private final String TEST_SHA = "5645ab4q4345";
    private final String REPOSITORY_NAME = "testrepo";
    private final String REPOSITORY_OWNER = "controlgroup";
    private final String AUTH_TOKEN = "TEST";

    public void setEnvironmentVariables() throws IOException {
        EnvironmentVariablesNodeProperty prop = new EnvironmentVariablesNodeProperty();
        EnvVars envVars = prop.getEnvVars();
        envVars.put("GIT_COMMIT", TEST_SHA);
        super.hudson.getGlobalNodeProperties().add(prop);
    }

    public void testShouldLogPostOfSuccess() throws Exception {
        //set environment up
        setEnvironmentVariables();
        //create new FreeStyle project
        FreeStyleProject project = createFreeStyleProject();
        //add plugin to project
        project.getPublishersList().add(new GithubStatusNotification(REPOSITORY_NAME,REPOSITORY_OWNER,AUTH_TOKEN));
        //build
        FreeStyleBuild build = project.scheduleBuild2(0).get();
        //verify build
        String s = FileUtils.readFileToString(build.getLogFile());
        assertTrue(s.contains(String.format(BUILD_OUTPUT_FORMAT,"SUCCESS",REPOSITORY_OWNER,REPOSITORY_NAME,TEST_SHA)));

    }

//    TODO: Figure how to mock project and builds to test for FAILURE AND PENDING STATES
//    public void testShouldLogPostOfFailure() throws Exception {
//        //set environment up
//        setEnvironmentVariables();
//        // mock build:
//        FreeStyleBuild build = Mockito.mock(FreeStyleBuild.class);
//        FreeStyleProject project = Mockito.mock(FreeStyleProject.class);
//        //add plugin to project
//        project.getPublishersList().add(new GithubStatusNotification(REPOSITORY_NAME,REPOSITORY_OWNER));
//        Mockito.when(build.getProject()) .thenReturn(project);
//        Mockito.when(build.getResult()).thenReturn(Result.FAILURE);
//        //verify build
//        String s = FileUtils.readFileToString(build.getLogFile());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> " + s);
//        assertTrue(s.contains(String.format(BUILD_OUTPUT_FORMAT,"FAILURE",REPOSITORY_OWNER,REPOSITORY_NAME,TEST_SHA)));
//
//    }

}
