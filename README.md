This is a minimalistic page object mode made with
Selenium and Java

Unlike other POM design patterns this uses inline webdriver waits
so that webdriver waits don't need to be used in every
other places.

For example in a traditional Page Object model, you
will see,

```
 public void enterUsername(String username) {
   driver.findElement(txtUsername).sendKeys(username);
  }
```

In here same method is implemented as follows,

```
public void enterUsername(String username) {
  wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername)).sendKeys(username);
  }

```
