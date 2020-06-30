package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Generics {

	private static Workbook wb;

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 This method will return value from properties file.
	 * @param key
	 * @return
	 */

	public static String getValueFromConfigFile(String key) {
		String value = "";
		String path = System.getProperty("user.dir") + File.separator + "config.properties";
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 This method read data from the data.xlsx
	 * 
	 */
	public static String getValueFromExcel(int row) {
		String value = "";
		try {
			String path = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "data.xlsx";
			FileInputStream fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			Sheet sh = wb.getSheetAt(0);
			DataFormatter df = new DataFormatter();
			value = df.formatCellValue(sh.getRow(row).getCell(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;

	}
	
	
	

}
