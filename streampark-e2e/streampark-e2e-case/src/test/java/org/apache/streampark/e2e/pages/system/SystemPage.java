/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.streampark.e2e.pages.system;

import org.apache.streampark.e2e.pages.common.NavBarPage;
import org.apache.streampark.e2e.pages.common.NavBarPage.NavBarItem;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public final class SystemPage extends NavBarPage implements NavBarItem {
    @FindBy(xpath = "//span[contains(@class, 'streampark-simple-menu-sub-title') and contains(text(), 'User Management')]//..")
    private WebElement menuUserManagement;

    @FindBy(xpath = "//span[contains(@class, 'streampark-simple-menu-sub-title') and contains(text(), 'Token Management')]//..")
    private WebElement menuTokenManagement;

    @FindBy(xpath = "//span[contains(@class, 'streampark-simple-menu-sub-title') and contains(text(), 'Role Management')]//..")
    private WebElement menuRoleManagement;

    @FindBy(xpath = "//span[contains(@class, 'streampark-simple-menu-sub-title') and contains(text(), 'Team Management')]//..")
    private WebElement menuTeamManagement;

    @FindBy(xpath = "//span[contains(@class, 'streampark-simple-menu-sub-title') and contains(text(), 'Member Management')]//..")
    private WebElement menuMemberManagement;

    public SystemPage(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends SystemPage.Tab> T goToTab(Class<T> tab) {
        if (tab == UserManagementPage.class) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(menuUserManagement));
            menuUserManagement.click();
            return tab.cast(new UserManagementPage(driver));
        }

        if (tab == TeamManagementPage.class) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(menuTeamManagement));
            menuTeamManagement.click();
            return tab.cast(new TeamManagementPage(driver));
        }

        throw new UnsupportedOperationException("Unknown tab: " + tab.getName());
    }

    public interface Tab {
    }
}
