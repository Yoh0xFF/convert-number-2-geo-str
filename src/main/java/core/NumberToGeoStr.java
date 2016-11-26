package core;

import org.apache.commons.lang.StringUtils;

public class NumberToGeoStr {

    private static final String[] TOKEN_1_20_ARR = {
        "ერთი", "ორი", "სამი", "ოთხი", "ხუთი",
        "ექვსი", "შვიდი", "რვა", "ცხრა", "ათი",
        "თერთმეტი", "თორმეტი", "ცამეტი", "თოთხმეტი", "თხუთმეტი",
        "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი", "ოცი"
    };

    private static final String[] TOKEN_20_100_ARR = {
        "ოცდა", "ორმოცდა", "სამოცდა", "ოთხმოცდა"
    };

    private static final String[] TOKEN_100_900_ARR = {
        "", "ას", "ორას", "სამას", "ოთხას", "ხუთას",
        "ექვსას", "შვიდას", "რვაას", "ცხრაას"
    };

    private static final String TOKEN_0 = "ნული";
    private static final String TOKEN_1000 = "ათას";
    private static final String TOKEN_1000000 = "მილიონ";
    private static final String TOKEN_1000000000 = "მილიარდ";
    
    private static final String TOKEN_LARI = "ლარი";
    private static final String TOKEN_TETRI = "თეთრი";
    
    private static final String TOKEN_AND = "და";
    private static final String TOKEN_SUFFIX = "ი";

    public static String convert(long amount) {
        long lari = amount / 100, tetri = amount % 100;
        
        StringBuilder rsltBldr = new StringBuilder();
        
        if (tetri > 0) {
            String tmp = StringUtils.trim(convertNumberToGeoStr(lari));
            rsltBldr
                    .append(StringUtils.isBlank(tmp) ? TOKEN_0 : tmp)
                    .append(' ')
                    .append(TOKEN_LARI);
            
            tmp = StringUtils.trim(convertNumberToGeoStr(tetri));
            rsltBldr
                    .append(' ')
                    .append(TOKEN_AND)
                    .append(' ')
                    .append(StringUtils.isBlank(tmp) ? TOKEN_0 : tmp)
                    .append(' ')
                    .append(TOKEN_TETRI);
        } else {
            String tmp = StringUtils.trim(convertNumberToGeoStr(lari));
            rsltBldr
                    .append(StringUtils.isBlank(tmp) ? TOKEN_0 : tmp)
                    .append(' ')
                    .append(TOKEN_LARI);
        }
        
        return rsltBldr.toString();
    }

    private static String convertNumberToGeoStr(long number) {
        if (String.valueOf(number).length() > 12) {
            throw new IllegalArgumentException("Number is too big");
        }

        StringBuilder rsltBldr = new StringBuilder();

        for (int i = 3; i >= 1; --i) {
            int divisor = 1;
            for (int k = 0; k < i; ++k) {
                divisor *= 1000;
            }
            
            long remainder = number % divisor, division = number / divisor;
            if (division != 0) {
                String part = convertNumber1000ToGeoStr((int) division);

                if (!StringUtils.isBlank(part)) {
                    part += " ";
                }
                
                if (StringUtils.trim(part).equals(TOKEN_1_20_ARR[0])) {
                    part = "";
                }
                
                switch (divisor) {
                    case 1000:
                        rsltBldr.append(part).append(TOKEN_1000);
                        break;
                    case 1000000:
                        rsltBldr.append(part).append(TOKEN_1000000);
                        break;
                    case 1000000000:
                        rsltBldr.append(part).append(TOKEN_1000000000);
                        break;
                }
                
                if (remainder == 0) {
                    rsltBldr.append(TOKEN_SUFFIX);
                    return rsltBldr.toString();
                } else {
                    rsltBldr.append(' ');
                }
            }
            number = remainder;
        }
        
        rsltBldr.append(convertNumber1000ToGeoStr((int) number));

        return rsltBldr.toString();
    }

    private static String convertNumber1000ToGeoStr(int number) {
        if (number == 0) {
            return "";
        }

        if (String.valueOf(number).length() > 3) {
            throw new IllegalArgumentException("Number is too big");
        }

        StringBuilder rsltBldr = new StringBuilder();
        
        int remainder = number % 100, division = number / 100;
        rsltBldr.append(TOKEN_100_900_ARR[division]);
        number = remainder;
        
        if (number == 0) {
            rsltBldr.append(TOKEN_SUFFIX);
            return rsltBldr.toString();
        } else {
            rsltBldr.append(' ');
        }

        if (number <= 20) {
            rsltBldr.append(TOKEN_1_20_ARR[number - 1]);
            return rsltBldr.toString();
        }
        
        remainder = number % 10; division = number / 10;
        switch (division) {
            case 2:
            case 3:
                rsltBldr.append(TOKEN_20_100_ARR[0]);
                break;
            case 4:
            case 5:
                rsltBldr.append(TOKEN_20_100_ARR[1]);
                break;
            case 6:
            case 7:
                rsltBldr.append(TOKEN_20_100_ARR[2]);
                break;
            case 8:
            case 9:
                rsltBldr.append(TOKEN_20_100_ARR[3]);
                break;
        }

        if (remainder == 0) {
            if (division % 2 == 0) {
                rsltBldr.delete(rsltBldr.length() - 2, rsltBldr.length());
                rsltBldr.append(TOKEN_SUFFIX);
            } else {
                rsltBldr.append(TOKEN_1_20_ARR[9]);
            }
        } else if (division % 2 == 0) {
            rsltBldr.append(TOKEN_1_20_ARR[remainder - 1]);
        } else {
            rsltBldr.append(TOKEN_1_20_ARR[remainder + 10 - 1]);
        }

        return rsltBldr.toString();
    }
}
