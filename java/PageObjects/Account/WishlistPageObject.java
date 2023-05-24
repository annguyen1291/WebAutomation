package PageObjects.Account;

import PageObjects.BasePageObject;

public class WishlistPageObject extends BasePageObject {
    protected static String shareWishListXPath = "//button[.='Share Wishlist']";

    public static void clickOnShareWishList() {
        click(shareWishListXPath);
    }

    public static void enterEmailAndShareWishlist(String email) {
        String emailXPath = "//textarea[@id='email_address']";
        type(emailXPath, email);
        click(shareWishListXPath);
    }

    public static void verifySharingWishlist() {
        String successMessageXPath = "//li[@class='success-msg' and .='Your Wishlist has been shared.']";
        waitVisible(successMessageXPath);
    }
}
