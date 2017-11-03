package client;

import java.util.Scanner;

import com.socgen.ApparelHelper;

/**
 * @author Kaushal Soni
 * This is the main class to run the apparel system
 */
public class Application {

	public static void main(String[] args) throws Exception {
//		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		Scanner scanner = new Scanner(System.in);
		ApparelHelper apparaelHelper = new ApparelHelper(scanner, System.out);
		apparaelHelper.execute();
	}
}
