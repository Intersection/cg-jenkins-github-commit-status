package com.controlgroup.ci.jenkinsgithubcommitstatus;

import hudson.Launcher;
import hudson.model.BuildListener;


/**
 * Created with IntelliJ IDEA.
 * User: vikash
 * Date: 4/28/13
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IGithubStatusAPI {
    public void doPost(BuildListener listener,Launcher launcher, Notification post);
}
