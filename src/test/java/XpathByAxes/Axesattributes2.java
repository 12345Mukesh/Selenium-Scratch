package XpathByAxes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * SDET Pavan
 */

public class Axesattributes2 {

	public static void main(String[] args)
	{
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://money.rediff.com/gainers/bse/daily/group");
		  
		  //1.sef node - select the current nod
	String text=  driver.findElement(By.xpath("//a[contains(text(),'Universal Cables')]/self::a")).getText();
		System.out.println(text);//Universal Cables
		
		//2. Parent node(printing text) - select the parent of the current node(always one)
		String parenttext=driver.findElement(By.xpath("//a[contains(text(),'Universal Cables')]/parent::td")).getText();
		System.out.println(parenttext);//Universal Cables
		
		/*
		 * we always take from ancestor for descendant, following , preceding, siblings because
		 * inside the ancestor there are no that much attributes to check so using same
		 * ancestor tag
		 */
		
		//3. child node(size) - select all the childrens of current node(one or many)
	 List<WebElement> child= driver.findElements(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr/child::td"));
		System.out.println("No.of child Elements for tr:"+child.size());  
		//No.of child Elements for tr:5
		
		//4. Ancestor - select all ancestors(parent,grand parent etc/..)
	String ancestor = driver.findElement(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr")).getText();
		System.out.println(ancestor);
		//Universal Cables B 226.65 255.00 + 12.51
		
		//5.descendant - select all descendants(child, grand child) of current node
		List<WebElement> descendant=driver.findElements(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr/descendant::*"));
		System.out.println("No.of Descendant Elements for tr:"+descendant.size());
		//No.of Descendant Elements for tr:7
		
		// 6. Following -select all the elements after the self element
	List<WebElement>  followingnodes=	driver.findElements(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr/following::tr"));
		System.out.println("No.of.Following Nodes:"+followingnodes.size());
		//No.of.Following Nodes:1867
		
	
		//7. Following-sibling - select all siblings after current node
		
		List<WebElement>follsibl=driver.findElements(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr/following-sibling::tr"));
		System.out.println("No.of.Following siblings:"+follsibl);
        //No.of.Following siblings:1865
		
	   
		//8. Preceding - select all the elements before the self element
		     List<WebElement>precedingnode=driver.findElements(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr/preceding::tr"));
	   
	     System.out.println("No.of preceding node:"+ precedingnode.size());
	     //No.of preceding node:13
	
	    //9. preceding-sibling -
	     List<WebElement>precsib=driver.findElements(By.xpath("//a[contains(text(),'Universal Cables')]/ancestor::tr/preceding-sibling::tr"));
	     
	     System.out.println("No.of Preceding-sibling:"+precsib.size());
	    //No.of Preceding-sibling:12
	
	
	 
	     driver.close();
	
	
	
	
	
	
	
	
	
	}

}
