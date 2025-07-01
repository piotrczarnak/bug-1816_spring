/*
 * Copyright (c) Microsoft Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example;

import com.microsoft.playwright.*;

public class App {
  public static void main(String[] args) {
    for (int i = 0; i < 100_000; i++) {
      runOnce();
      System.out.println("Iteration: " + i);
    }
  }

  private static void runOnce() {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.webkit().launch();
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://playwright.dev");
      page.close();
      context.close();
      browser.close();      
    }
  }
}
