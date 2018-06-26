package win.elegentjs.util;

import java.io.*;
import java.net.URL;
import java.util.Random;

public class FileUtil {


    public static void generatorIntToFile(int length, String filePath) throws IOException {
        Random random = new Random();
        URL url = FileUtil.class.getClassLoader().getResource(filePath);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url.getPath())));

        for (int index = 0; index < length; index ++) {
            bufferedWriter.write(random.nextInt(100_000)  + ",");
        }

        bufferedWriter.close();
    }

    public static int[] classpathFileToArray(String fileName) {
        InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder content = new StringBuilder();
        String line;

        try {
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            String[] stringArray = content.toString().split(",");
            int[] array = new int[stringArray.length];

            for (int index = 0; index < stringArray.length; index ++) {
                int tmp;
                try {
                    tmp = Integer.parseInt(stringArray[index].trim());
                } catch (Exception e) {
                    // ignore..
                    continue;
                }

                array[index] = tmp;
            }

            return array;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws IOException {
        generatorIntToFile(1_000, "oneThousandArray.txt");
        generatorIntToFile(10_000, "tenThousandArray.txt");
        generatorIntToFile(100_000, "oneHundredThousandArray.txt");
        generatorIntToFile(1_000_000, "oneMillionArray.txt");
    }
}
