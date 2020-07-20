package Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;
import java.util.List;

public class Element {
    private ByValue by; //comando do selenium
    private String map; //caminhos dos elementos
    private WebElement webElement = null;
    private HashMap<ByValue,By> byMap = new HashMap<ByValue, By>();

    public Element(ByValue by, String _map){
        this.by = by;
        map = _map;
        setByMap();
    }

    public void setByMap(){
        byMap.put(ByValue.ID,By.id(map));
        byMap.put(ByValue.CSS,By.cssSelector(map));
        byMap.put(ByValue.LINKTEXT,By.linkText(map));
        byMap.put(ByValue.NAME,By.name(map));
        byMap.put(ByValue.XPATH,By.xpath(map));
    }
    public void setWebElement(WebElement _element){
        webElement = _element;
    }

    public WebElement getWebElement(By by) {
        if (webElement == null){
           return Driver.getDriver().findElement(by);
        }
        return webElement.findElement(by);
    }

    public WebElement getElement(){
        return getWebElement(byMap.get(by));
    }

    public List<WebElement> getElements(){
        return Driver.getDriver().findElements(byMap.get(by));
    }
    public void sendKeys(CharSequence... value){
        getElement().sendKeys(value);
    }

    public String getText() {
        return getElement().getText();
    }

    public void click(){
        getElement().click();
    }

    public String getAttribute(String value){
       return getElement().getAttribute(value);
    }
    public void clear(){
        getElement().clear();
    }
    public boolean isEnable(){
        return getElement().isEnabled();
    }
    public boolean isDisable(){
        return getElement().isDisplayed();
    }
    public boolean isSelected(){
        return getElement().isSelected();
    }

    public void select(String value){
        Select select = new Select(getElement());
        select.selectByVisibleText(value);
    }


}
