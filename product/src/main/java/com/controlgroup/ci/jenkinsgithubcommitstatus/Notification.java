package com.controlgroup.ci.jenkinsgithubcommitstatus;

/**
 * User: vikash
 * Date: 4/28/13
 * Time: 5:57 PM
 */
public class Notification {
    private String repoName;
    private String repoOwner;
    private String commitSha;
    private String authToken;
    private String buildResult;
    private String buildDescription;
    private String targetURI;

    public String getBuildResult() {
        return buildResult;
    }

    public void setBuildResult(String buildResult) {
        this.buildResult = buildResult;
    }

    public String getBuildDescription() {
        return buildDescription;
    }

    public void setBuildDescription(String buildDescription) {
        this.buildDescription = buildDescription;
    }

    public String getTargetURI() {
        return targetURI;
    }

    public void setTargetURI(String targetURI) {
        this.targetURI = targetURI;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Notification() {
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoOwner() {
        return repoOwner;
    }

    public void setRepoOwner(String repoOwner) {
        this.repoOwner = repoOwner;
    }

    public String getCommitSha() {
        return commitSha;
    }

    public void setCommitSha(String commitSha) {
        this.commitSha = commitSha;
    }
}
