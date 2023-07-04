import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AptekaTest {
    @BeforeEach
    public void setUp() {
        Configuration.baseUrl = "https://aptekaeconom.com/";
        Cookie region = new Cookie("current_region", "119202");
        open("/");
        Selenide.webdriver().driver().getWebDriver().manage().addCookie(region);
        refresh();
        $(".region_wrapper .confirm_region").shouldNotBe(Condition.visible);
    }

    @Test
    @DisplayName("Test 1")
    public void firstTest() {
        SelenideElement category = $$(".dropdown .dropdown-toggle").get(0);
        ElementsCollection subcategories = $$(".table-menu .dropdown:nth-child(2) ul li");

        category.hover();
        assertThat(subcategories.size()).isEqualTo(12);

    }

    @Test
    @DisplayName("���� 2")
    public void secondTest() {
        SelenideElement category = $$(".dropdown .dropdown-toggle").get(0);
        ElementsCollection subcategories = $$(".table-menu .dropdown:nth-child(2) ul li");

        step("�������� ���������� ������������", () -> {
            category.hover();
            assertThat(subcategories.size()).isEqualTo(12);
        });
    }

    @Test
    @DisplayName("���� 3")
    public void thirdTest() {
        ElementsCollection subcategories = $$(".table-menu .dropdown:nth-child(3) ul li");
        SelenideElement subcategory = subcategories.get(2);
        String subcategoryName = subcategory.$("span").getAttribute("innerText");

        step("�������� �������� ������������", () -> {
            assertThat(subcategoryName).isEqualTo("���� ��� ����");
        });
    }

}
