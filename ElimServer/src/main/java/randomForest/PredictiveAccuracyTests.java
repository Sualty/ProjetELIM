package randomForest;

import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickml.data.AttributesMap;
import quickml.data.instances.ClassifierInstance;

import java.io.*;
import java.nio.Buffer;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class PredictiveAccuracyTests {
    private static final Logger logger = LoggerFactory.getLogger(PredictiveAccuracyTests.class);

    public static List<ClassifierInstance> loadDataSet() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("dataset.data");//TODO
        final BufferedReader br = new BufferedReader(new InputStreamReader(is));
        final List<ClassifierInstance> instances = Lists.newLinkedList();

        String[] headings = new String[]{
                AttributeEnum.POCKET_TIME.getTxt(),
                AttributeEnum.CALLING_TIME.getTxt(),
                AttributeEnum.NOT_IN_USE_TIME.getTxt(),
                AttributeEnum.IN_USE_TIME.getTxt()};

        String line = br.readLine();
        while (line != null) {
            String[] splitLine = line.split(",");

            AttributesMap attributes = AttributesMap.newHashMap();
            for (int x = 0; x < splitLine.length - 1; x++) {
                attributes.put(headings[x], Double.valueOf((String)splitLine[x]));
            }
            instances.add(new ClassifierInstance(attributes, splitLine[splitLine.length - 1]));
            line = br.readLine();
        }

        return instances;
    }


    /*public static  List<ClassifierInstance> loadIrisDataset() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("iris.data");
        final BufferedReader br = new BufferedReader(new InputStreamReader(is));
        final List<ClassifierInstance> instances = Lists.newLinkedList();

        String[] headings = new String[]{"sepal-length", "sepal-width", "petal-length", "petal-width"};

        String line = br.readLine();
        while (line != null) {
            String[] splitLine = line.split(",");

            AttributesMap attributes = AttributesMap.newHashMap();
            for (int x = 0; x < splitLine.length - 1; x++) {
                attributes.put(headings[x], Double.valueOf((String)splitLine[x]));
            }
            instances.add(new ClassifierInstance(attributes, splitLine[splitLine.length - 1]));
            line = br.readLine();
        }

        return instances;
    }*/
}