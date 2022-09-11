package HW_03_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

abstract public class BaseFiler<E> {
	protected String filePath;
	public final static String DELIMITER = "; ";

	public BaseFiler(String filePath) {
		this.filePath = filePath;
	}
 
	public void store(List<E> entityList) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for (E entity : entityList) {
			String line = format(entity);
			bw.write(line);
			bw.write("\r\n");
		}
		bw.close();
	}
	public List<E> load() throws Exception {
		List<E> entityList = null;
		try {
			StringBuilder builder = new StringBuilder();
			entityList = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = null;
			E entity = null;
			while ((line = br.readLine()) != null) {
				builder.append(line);
				entity = parse(line);
				entityList.add(entity);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return entityList;

	}
	abstract protected String format(E entity);
	abstract protected E parse(String line);
}
