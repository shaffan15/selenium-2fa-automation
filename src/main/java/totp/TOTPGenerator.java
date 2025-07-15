
import com.warrenstrange.googleauth.GoogleAuthenticator;

public class TOTPGenerator {

	public static String getTotp(String secretKey) {
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		return String.valueOf(gAuth.getTotpPassword(secretKey));
	}
}
