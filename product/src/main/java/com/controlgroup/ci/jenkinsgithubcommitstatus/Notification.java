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
