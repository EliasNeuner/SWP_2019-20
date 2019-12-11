import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private static final String SEPERATOR = " | ";

	public enum LogLevel {
		DEBUG("debug", 1), ERROR("error", 4), INFO("info", 2), WARN("warning", 3);

		private String bez;
		private int lvl;

		private LogLevel(String bez, int lvl) {
			this.bez = bez;
			this.lvl = lvl;
		}

		public String getBez() {
			return this.bez;
		}

		private int getLvl() {
			return this.lvl;
		}
	}

	private static Logger instance;

	private PrintWriter writer;
	private static SimpleDateFormat dateformat;
	private File logFile;
	private LogLevel level = LogLevel.DEBUG;

	static {
		dateformat = new SimpleDateFormat("HH:mm:ss");
	}

	private Logger() {
		if (logFile != null) {
			init();
		}
	}

	private void init() {
		if (writer != null) {
			writer.close();
		}
		try {
			writer = new PrintWriter(new FileWriter(logFile, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setLogFile(String path) {
		setLogFile(new File(path));
	}

	public void setLogFile(File file) {
		this.logFile = file;
		init();
	}

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void log(LogLevel loglevel, String message) {
		if (loglevel.getLvl() >= level.getLvl()) {
			StringBuilder sb = new StringBuilder();
			sb.append(loglevel.getBez());
			sb.append(SEPERATOR);
			sb.append(dateformat.format(new Date()));
			sb.append(SEPERATOR);
			sb.append(message);
			writer.println(sb.toString());
			writer.flush();
		}
	}

	public void setLogLevel(LogLevel level) {
		this.level = level;
	}
	
	public void warn(String message) {
		this.log(LogLevel.WARN, message);
	}

	public void info(String message) {
		this.log(LogLevel.INFO, message);
	}

	public void error(String message) {
		this.log(LogLevel.ERROR, message);
	}

	public void debug(String message) {
		this.log(LogLevel.DEBUG, message);
	}

}
