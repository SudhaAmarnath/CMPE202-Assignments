
package starbucks;

import java.io.Console;
import java.util.Arrays;

/**
 * Main Entry Point.
 */
final class Main {

	/**
	 * Prevent Construction.
	 */
	private Main() {
		// Utility Class
		return;
	}

	/**
	 * Main App Entry Point.
	 * 
	 * @param args No args expected.
	 */
	public static void main(final String[] args) {
		System.err.println("Args: " + Arrays.toString(args));
		IApp app = new AppAuthProxy();
		Console c = System.console();
		String msg = "";
		for (;;) {
			String cmd = getCommandOutput(app, c, msg);

			/* process commands */
			msg = cmd;

			msg = cmdTouchAndSelect(app, msg, cmd);

			msg = cmdStartsWithPrevOrNext(app, msg, cmd);

			msg = cmdEqualsPortraitOrLandscape(app, msg, cmd);

			msg = cmdStartsWithLoginOrEndApp(app, msg, cmd);

		}
	}

	/**
	 * get command output, format strings
	 * 
	 * @param app [description]
	 * @param c   [description]
	 * @param msg [description]
	 * @return cmd [description]
	 */
	private static String getCommandOutput(IApp app, Console c, String msg) {
		System.out.print("\033[H\033[2J"); // clear the screen
		System.out.flush();
		System.out.println(app.screenContents());
		System.out.println(msg);
		System.out.print("=> ");
		String ch = c.readLine(); // get user command
		String cmd = ch.toLowerCase(); // convert to lower case
		cmd = cmd.replaceAll("\\s", ""); // remove all whitespaces
		return cmd;
	}

	/**
	 * check if cmd has touch and select keys
	 * 
	 * @param app [description]
	 * @param msg [description]
	 * @param cmd [description]
	 * @return msg [description]
	 */
	private static String cmdTouchAndSelect(IApp app, String msg, String cmd) {
		if (cmd.startsWith("touch")) {
			String parms = cmd.replaceFirst("touch", "");
			parms = parms.substring(1);
			parms = parms.substring(0, parms.length() - 1);
			String[] values = parms.split(",");
			System.err.println("Value: " + Arrays.toString(values));
			String x = values[0];
			String y = values[1];
			msg = "touch: x=" + x + " y=" + y;
			app.touch(Integer.parseInt(x), Integer.parseInt(y));
		} else if (cmd.matches("[a-e]{1}")) {
			String selection = cmd.toUpperCase();
			msg = "selected: " + selection;
			app.execute(selection);
		}
		return msg;
	}

	/**
	 * check if cmd has prev or next screen keys
	 * 
	 * @param app [description]
	 * @param msg [description]
	 * @param cmd [description]
	 * @return msg [description]
	 */
	private static String cmdStartsWithPrevOrNext(IApp app, String msg, String cmd) {
		if (cmd.startsWith("prev")) {
			msg = "cmd: previous";
			app.prev();
		} else if (cmd.startsWith("next")) {
			msg = "cmd: next";
			app.next();
		}
		return msg;
	}

	/**
	 * check if cmd has portraint or landscape options
	 * 
	 * @param app [description]
	 * @param msg [description]
	 * @param cmd [description]
	 * @return msg [description]
	 */
	private static String cmdEqualsPortraitOrLandscape(IApp app, String msg, String cmd) {
		if (cmd.equalsIgnoreCase("portrait")) {
			app.portrait();
		} else if (cmd.equalsIgnoreCase("landscape")) {
			app.landscape();
		}
		return msg;
	}

	/**
	 * check if cmd has login or end application
	 * 
	 * @param app [description]
	 * @param msg [description]
	 * @param cmd [description]
	 * @return msg [description]
	 */
	private static String cmdStartsWithLoginOrEndApp(IApp app, String msg, String cmd) {
		if (cmd.startsWith("login")) {
			app.touch(1, 5); // 1
			app.touch(2, 5); // 2
			app.touch(3, 5); // 3
			app.touch(1, 6); // 4
		} else {
			msg = "";
		}
		return msg;
	}

}
