import java.util.MissingResourceException;

/**
 * Created by Mihai on 07.09.2014.
 */

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author Mihai
 *         Class to handle model values from file
 */
public final class Model {
    private static final String BUNDLE_NAME_TEST = "AmazonTest.model";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME_TEST);

    /**
     */
    private Model() {

    }

    /**
     * @param key - key
     * @return - value
     */
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
