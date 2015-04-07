package dst.ass1.jpa.interceptor;

import org.hibernate.EmptyInterceptor;

public class SQLInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 3894614218727237142L;
    private static boolean verbose = false;
    private static int counter = 0;

	public String onPrepareStatement(String sql) {
		
		if(sql.toLowerCase().contains("from moderator") || sql.toLowerCase().contains("from virtualschool")){
            counter ++;
        }
		
		return sql;
	}

	public static void resetCounter() {
		counter = 0;
	}

	
	public static int getSelectCount() {
		return counter;
	}

	public static void setVerbose(boolean verbose) {
		verbose = verbose;
	}

}
