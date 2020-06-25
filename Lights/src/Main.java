import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);

		Colours[] colours = Colours.values();
		ArrayList<String> setOfLights = new ArrayList<String>();

		System.out.println("Would you like to choose the number of lights?");
		System.out.println("Type: 1(yes) or 2(no)");
		int option = sc.nextInt();

		if (option == 1) {
			System.out.println(("Number of lights: "));
			int setNumber = sc.nextInt();
			sc.close();

			for (int i = 0, x = 0; i < setNumber; i++, x++) {
				if (x > 0 && colours[x - 1].equals(colours[colours.length - 1])) {
					x = 0;
				}
				setOfLights.add(colours[x].toString());
			}
		}

		else {
			for (int i = 0, x = 0; i < 20; i++, x++) {
				if (x > 0 && colours[x - 1].equals(colours[colours.length - 1])) {
					x = 0;
				}
				setOfLights.add(colours[x].toString());
			}
		}

		int size = setOfLights.size();

		SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
		LightState light = new LightState();

		while (true) {
			for (int i = 0; i < size; i++) {
				int index = i + 1;

				Date d = new Date();
				String time = sdf.format(d);
				light.setState("On");
				System.out.print(time + ": " + index + " " + setOfLights.get(i) + " Light " + light.getState()+ " ");

				TimeUnit.SECONDS.sleep(1);

				Date d1 = new Date();
				String time1 = sdf.format(d1);
				light.setState("Off");
				System.out.print(time1 + ": " + index + " " + setOfLights.get(i) + " Light " + light.getState()+ " ");
			}
		}
	}
}
