package com.controlgroup.ci.jenkinsgithubcommitstatus;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Notifier;
import hudson.tasks.Publisher;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Company: Control Group
 * User: vikash
 * Date: 4/26/13
 * Time: 3:18 PM
 *
 * This class notifies github of build status utilizing the github status api: http://developer.github.com/v3/repos/statuses/
 */
public class GithubStatusNotification extends Notifier {

    private String repositoryName, repositoryOwner;

    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.BUILD;
    }

    @DataBoundConstructor
    public GithubStatusNotification(String repoName, String repoOwner){
        repositoryName = repoName;
        repositoryOwner = repoOwner;
    }


    /*
     *
     * Descriptor class needed by Jenkins to help identify and manage plugin
     */
    @Extension
    public static class Descriptor extends BuildStepDescriptor<Publisher>{

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Github Repository Status Notification";  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
