package com.Tunes_Developers.Utils;

import com.Tunes_Developers.Faker;
import com.Tunes_Developers.Models.FakerItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Geoffrey-Kimani on 10/14/2017.
 */
public class DecodeFakerItem {
    private ObservableList<FakerItem> fakerItems = FXCollections.observableArrayList();
    private String [] generatedContent;
    private ObservableList<ObservableList<String>> items = FXCollections.observableArrayList();
    Faker faker;

    public DecodeFakerItem(ObservableList<FakerItem> fakerItems) {
        this.fakerItems = fakerItems;
        this.generatedContent = new String[fakerItems.size()];

        if (!fakerItems.isEmpty()) {
            FakerItem item = fakerItems.get(0);
            faker = new Faker(item.getLanguage(), item.getCountry());
        }else{
            faker = new Faker();
        }
    }

    public ObservableList<ObservableList<String>> generateData(int numberOfItems) {
        ObservableList<String> row = FXCollections.observableArrayList();

        for(int i=0;i<numberOfItems;i++) {
            row = FXCollections.observableArrayList();

            for (FakerItem item : fakerItems) {
                if (item.isFaker()) {
                    row.add(getFakedItem(item));
                }else{
                    row.add(item.getData());
                }
            }

            items.add(row);
        }

        return items;
    }

    private String getFakedItem(FakerItem fakerItem) {
        switch (fakerItem.getFakerType()) {
            case 1:
                return faker.randomDigit();
            case 2:
                return faker.digitBetween(fakerItem.getParamInt1(),fakerItem.getParamInt2());
            case 3:
                return faker.randomLetter();
            case 4:
                return faker.numerify(fakerItem.getParam1());
            case 5:
                return faker.numerifyNoZeros(fakerItem.getParam1());
            case 6:
                return faker.numerifyAboveZero(fakerItem.getParam1());
            case 7:
                return faker.numerify(fakerItem.getParam1(),fakerItem.getParam2());
            case 8:
                return faker.numerifyNoZeros(fakerItem.getParam1(),fakerItem.getParam2());
            case 9:
                return faker.lexify(fakerItem.getParam1());
            case 10:
                return faker.bothify(fakerItem.getParam1());
            case 11:
                return faker.ascify(fakerItem.getParam1());
            case 12:
                return faker.word();
            case 13:
                return faker.sentence();
            case 14:
                return faker.sentence(fakerItem.getParamInt1());
            case 15:
                return faker.paragraph(fakerItem.getParamInt1(),fakerItem.getParamInt2());
            case 16:
                return faker.paragraph();
            case 17:
                return faker.paragraphs();
            case 18:
                return faker.paragraphs(fakerItem.getParamInt1(),fakerItem.getParamInt2(),fakerItem.getParamInt3());
            case 19:
                return faker.title();
            case 20:
                return faker.titleMale();
            case 21:
                return faker.titleFemale();
            case 22:
                return faker.oneName();
            case 23:
                return faker.name();
            case 24:
                return faker.nameMale();
            case 25:
                return faker.nameFemale();
            case 26:
                return faker.city();
            case 27:
                return faker.county();
            case 28:
                return faker.country();
            case 29:
                return faker.postCode();
            case 30:
                return faker.longitude();
            case 31:
                return faker.latitude();
            case 32:
                return faker.phoneNumber();
            case 33:
                return faker.text();
            case 34:
                return faker.text(fakerItem.getParamInt1(),fakerItem.getParamInt2());
            case 35:
                return faker.date();
            case 36:
                return faker.dateNow();
            case 37:
                return faker.dateTime();
            case 38:
                return faker.dateTimeNow();
            case 39:
                return faker.time();
            case 40:
                return faker.timeNow();
            case 41:
                return faker.dateOld();
            case 42:
                return faker.dateTimeOld();
            case 43:
                return faker.month();
            case 44:
                return faker.year();
            case 45:
                return faker.dateOfMonth();
            case 46:
                return faker.monthName();
            case 47:
                return faker.monthNameShort();
            case 48:
                return faker.dayOfWeek();
            case 49:
                return faker.dayOfWeekShort();
            case 50:
                return faker.dateTimeThisYear();
            case 51:
                return faker.email();
            case 52:
                return faker.safeEmail();
            case 53:
                return faker.freeEmail();
            case 54:
                return faker.emailResource();
            case 55:
                return faker.safeEmailResource();
            case 56:
                return faker.freeEmailResource();
            case 57:
                return faker.ipv4();
            case 58:
                return faker.localIpv4();
            case 59:
                return faker.ipv6();
            case 60:
                return faker.macAddress();
            case 61:
                return faker.url();
            case 62:
                return faker.domainName();
            case 63:
                return faker.slug();
            case 64:
                return faker.password();
            case 65:
                return faker.username();
            case 66:
                return faker.usernameResource();
            case 67:
                return faker.tid();
            case 68:
                return faker.creditCardType();
            case 69:
                return faker.creditCardNumber();
            case 70:
                return faker.creditCardNumberResource();
            case 71:
                return faker.creditCardExpirationDate();
            case 72:
                return faker.hexColor();
            case 73:
                return faker.rgbColor();
            case 74:
                return faker.rgbCssColor();
            case 75:
                return faker.colorName();
            case 76:
                return faker.safeColorName();
            case 77:
                return faker.ean13();
            case 78:
                return faker.ean8();
            case 79:
                return faker.isbn13();
            case 80:
                return faker.isbn10();
            case 81:
                return faker.bool();
            case 82:
                return faker.md5();
            case 83:
                return faker.sha1();
            case 84:
                return faker.sha256();
            case 85:
                return faker.locale();
            case 86:
                return faker.countryCode();
            case 87:
                return faker.countryCodeIsoAlpha3();
            case 88:
                return faker.languageCode();
            default:
                return faker.currencyCode();
        }
    }
}
