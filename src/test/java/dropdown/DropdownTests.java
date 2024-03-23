package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropdown();
        String option = "Option 2";
        dropdownPage.selectFromDropdown(option);
        var selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption.size(),1,"There are more than 1 selected option");
        Assert.assertTrue(selectedOption.contains(option)," The expected not selected");
    }
}
