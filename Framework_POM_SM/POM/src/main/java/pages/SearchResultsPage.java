package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getSearchHeader()
	{
		return getElement("SearchHeader").getText();
	}

}
 